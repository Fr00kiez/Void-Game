package sample.controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.util.Duration;
import sample.models.Context;
import sample.models.Entities;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class attackGoblinController implements Initializable {
    @FXML
    private Button attackButton;

    @FXML
    private Button guardButton;

    @FXML
    private Button lanjutAdegan;

    @FXML
    private Label goblinTalks; //kalau bisa rata kiri

    @FXML
    private Label playerTalks; //kalau bisa rata kanan

    private void goblinTalk(String message) {
        goblinTalks.setText(goblin.getName() + " - Health: " + goblin.getHealth() + (goblin.getGuarding() ? " - Guarding (-" + (goblin.getGuardPercentage() * 100) + "% damage)" : "") + "\n" + message);
    }

    private void playerTalk(String message) {
        var player = Context.getInstance().getPlayer();
        playerTalks.setText(player.getName() + " - Health: " + player.getHealth() + (player.getGuarding() ? " - Guarding (- " + (player.getGuardPercentage() * 100) + "% damage)" : "") + "\n" + message);
    }

    private enum CONDITIONS {
        WAITING_FOR_PLAYER,
        PLAYER_ACTION,
        WAITING_FOR_GOBLIN,
        GOBLIN_ACTION,
    };

    private CONDITIONS condition = CONDITIONS.WAITING_FOR_PLAYER;

    private final Entities goblin = new Entities(60, 5, (float) 0.2, "Goblin");

    private void goblinAction() {
        var player = Context.getInstance().getPlayer();

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            if (goblin.getHealth() > 0 && condition == CONDITIONS.WAITING_FOR_GOBLIN) {
                playerTalk("");
                goblinTalk("Giliran Goblin.");

                condition = CONDITIONS.GOBLIN_ACTION;

                pause.playFromStart();
            } else if (goblin.getHealth() > 0 && condition == CONDITIONS.GOBLIN_ACTION) {
                if (new Random().nextInt(100) > 50) {
                    goblinTalk(goblin.setGuarding(true));
                } else {
                    String[] goblinAttacks = goblin.attack(player);

                    goblinTalk(goblinAttacks[0]);
                    playerTalk(goblinAttacks[1]);
                }

                condition = CONDITIONS.WAITING_FOR_PLAYER;

                pause.playFromStart();
            } else if (condition == CONDITIONS.WAITING_FOR_PLAYER) {
                goblinTalk("");
                playerTalk("Giliran kamu.");

                attackButton.setDisable(false);
                guardButton.setDisable(false);
            } else {
                playerTalk("Sangat efektif!");
                goblinTalk("Argh!");

                lanjutAdegan.setDisable(false);
            }
        });

        pause.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerTalk("Err... Hai....");
        goblinTalk("Hei! Penyusup!");

        lanjutAdegan.setDisable(true);
    }

    @FXML
    public void attackButtonOnAction(ActionEvent event) throws IOException {
        attackButton.setDisable(true);
        guardButton.setDisable(true);

        var player = Context.getInstance().getPlayer();
        String[] playerAttacks = player.attack(goblin);

        playerTalk(playerAttacks[0]);
        goblinTalk(playerAttacks[1]);

        condition = CONDITIONS.WAITING_FOR_GOBLIN;

        goblinAction();
    }

    @FXML
    public void guardButtonOnAction(ActionEvent event) throws IOException{
        attackButton.setDisable(true);
        guardButton.setDisable(true);

        var player = Context.getInstance().getPlayer();
        String playerGuard = player.setGuarding(true);

        playerTalk(playerGuard);

        condition = CONDITIONS.WAITING_FOR_GOBLIN;

        goblinAction();
    }

    @FXML
    public void lanjutButtonOnAction(ActionEvent event) throws IOException{
        Parent characterView = null;
        try {
            characterView = FXMLLoader.load(getClass().getResource("/sample/views/looted.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene characterViewScene = new Scene(characterView);
        Stage characterViewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        characterViewStage.hide();
        characterViewStage.setScene(characterViewScene);
        characterViewStage.show();
    }

}
