package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.models.Battle;
import sample.models.Entity;
import sample.models.EntityType;

public class BattleController {
    @FXML
    private Label enemyTalks;

    @FXML
    private Label playerTalks;

    @FXML
    protected Button attackButton;

    @FXML
    protected Button guardButton;

    @FXML
    protected Button continueButton;

    private Battle battle;
    public Battle getBattle() {
        return battle;
    }
    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    private void entityTalk(EntityType type, String message) {
        Entity entity = type == EntityType.PLAYER ? battle.getPlayer() : battle.getEnemy();
        Label label = type == EntityType.PLAYER ? playerTalks : enemyTalks;

        int health = entity.getHealth();
        int guardPercentage = (int) (entity.getGuardPercentage() * 100);
        String name = entity.getName();
        String guardingText = entity.getGuarding()
                ? " - Guarding (-" + guardPercentage + "% damage)"
                : "";

        label.setText(name + " - Health: " + health + guardingText + "\n" + message);
    }

    public void playerTalks(String message) {
        entityTalk(EntityType.PLAYER, message);
    }

    public void enemyTalks(String message) {
        entityTalk(EntityType.ENEMY, message);
    }

    public void onPlayerAttack() {
        attackButton.setDisable(true);
        guardButton.setDisable(true);
    }

    public void onPlayerTurn() {
        attackButton.setDisable(false);
        guardButton.setDisable(false);
    }

    public void onPlayerWin() {
        continueButton.setDisable(false);
    }
}
