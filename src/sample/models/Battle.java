package sample.models;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.Random;

public class Battle {
    public interface OnTalkCallback {
        void call(String input);
    }
    public interface OnTurnCallback {
        void call();
    }

    private enum BattleTurn {
        WAITING_FOR_PLAYER,
        PLAYER_ACTION,
        WAITING_FOR_ENEMY,
        ENEMY_ACTION
    }

    private final Player player;
    private final Entity enemy;

    private final OnTalkCallback onPlayerTalk;
    private final OnTalkCallback onEnemyTalk;

    private final OnTurnCallback onPlayerTurn;
    private final OnTurnCallback onPlayerAttack;
    private final OnTurnCallback onBattleEnd;

    private BattleTurn turn = BattleTurn.WAITING_FOR_PLAYER;

    public Battle(
            Player player,
            Entity enemy,
            OnTalkCallback onPlayerTalk,
            OnTalkCallback onEnemyTalk,
            OnTurnCallback onPlayerAttack,
            OnTurnCallback onPlayerTurn,
            OnTurnCallback onBattleEnd
    ) {
        this.player = player;
        this.enemy = enemy;
        this.onPlayerTalk = onPlayerTalk;
        this.onEnemyTalk = onEnemyTalk;
        this.onPlayerAttack = onPlayerAttack;
        this.onPlayerTurn = onPlayerTurn;
        this.onBattleEnd = onBattleEnd;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getEnemy() {
        return enemy;
    }

    public void playerAttackAction() {
        turn = BattleTurn.PLAYER_ACTION;

        onPlayerAttack.call();

        String[] playerAttacks = player.attack(enemy);

        onPlayerTalk.call(playerAttacks[0]);
        onEnemyTalk.call(playerAttacks[1]);

        battleSequence();
    }

    public void playerGuardAction() {
        String playerGuards = player.setGuarding(true);

        onPlayerTalk.call(playerGuards);

        battleSequence();
    }

    public void battleSequence() {
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            if (enemy.getHealth() > 0 && turn == BattleTurn.PLAYER_ACTION) {
                onPlayerTalk.call("");
                onEnemyTalk.call("Giliran " + enemy.getName() + ".");

                turn = BattleTurn.WAITING_FOR_ENEMY;

                pause.playFromStart();
            } else if (enemy.getHealth() > 0 && turn == BattleTurn.WAITING_FOR_ENEMY) {
                turn = BattleTurn.ENEMY_ACTION;

                if (new Random().nextInt(100) > 50) {
                    onEnemyTalk.call(enemy.setGuarding(true));
                } else {
                    String[] goblinAttacks = enemy.attack(player);

                    onEnemyTalk.call(goblinAttacks[0]);
                    onPlayerTalk.call(goblinAttacks[1]);
                }

                turn = BattleTurn.WAITING_FOR_PLAYER;

                pause.playFromStart();
            } else if (turn == BattleTurn.WAITING_FOR_PLAYER) {
                onEnemyTalk.call("");
                onPlayerTalk.call("Giliran kamu.");

                onPlayerTurn.call();
            } else {
                onBattleEnd.call();
            }
        });

        pause.play();
    }
}
