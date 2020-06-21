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

public class attackWizardController implements Initializable {
    @FXML
    private Button attackButton;

    @FXML
    private Button guardButton;

    @FXML
    private Button lanjutAdegan;

    @FXML
    private Label wizardTalks; //kalau bisa rata kiri

    @FXML
    private Label playerTalks; //kalau bisa rata kanan

    private void wizardTalk(String message) {
        wizardTalks.setText(wizard.getName() + " - Health: " + wizard.getHealth() + (wizard.getGuarding() ? " - Guarding (-" + (wizard.getGuardPercentage() * 100) + "% damage)" : "") + "\n" + message);
    }

    private void playerTalk(String message) {
        var player = Context.getInstance().getPlayer();
        playerTalks.setText(player.getName() + " - Health: " + player.getHealth() + (player.getGuarding() ? " - Guarding (- " + (player.getGuardPercentage() * 100) + "% damage)" : "") + "\n" + message);
    }

    private enum CONDITIONS {
        WAITING_FOR_PLAYER,
        PLAYER_ACTION,
        WAITING_FOR_WIZARD,
        WIZARD_ACTION,
    };

    private CONDITIONS condition = CONDITIONS.WAITING_FOR_PLAYER;

    private final Entities wizard = new Entities(80, 15, (float) 0.3, "Wizard");

    private void wizardAction() {
        var player = Context.getInstance().getPlayer();

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            if (wizard.getHealth() > 0 && condition == CONDITIONS.WAITING_FOR_WIZARD) {
                playerTalk("");
                wizardTalk("Giliran Wizard.");

                condition = CONDITIONS.WIZARD_ACTION;

                pause.playFromStart();
            } else if (wizard.getHealth() > 0 && condition == CONDITIONS.WIZARD_ACTION) {
                if (new Random().nextInt(100) > 80) {
                    wizardTalk(wizard.setGuarding(true));
                } else {
                    String[] wizardAttacks = wizard.attack(player);

                    wizardTalk(wizardAttacks[0]);
                    playerTalk(wizardAttacks[1]);
                }

                condition = CONDITIONS.WAITING_FOR_PLAYER;

                pause.playFromStart();
            } else if (condition == CONDITIONS.WAITING_FOR_PLAYER) {
                wizardTalk("");
                playerTalk("Giliran kamu.");

                attackButton.setDisable(false);
                guardButton.setDisable(false);
            } else {
                playerTalk("Karirmu berakhir disini!");
                wizardTalk("Waktumu akan datang!");

                lanjutAdegan.setDisable(false);
            }
        });

        pause.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerTalk("Akhirnya, wizard yang kucari-cari.");
        wizardTalk("Beraninya kau memasuki wilayahku!");

        lanjutAdegan.setDisable(true);
    }

    @FXML
    public void attackButtonOnAction(ActionEvent event) throws IOException {
        attackButton.setDisable(true);
        guardButton.setDisable(true);

        var player = Context.getInstance().getPlayer();
        String[] playerAttacks = player.attack(wizard);

        playerTalk(playerAttacks[0]);
        wizardTalk(playerAttacks[1]);

        condition = CONDITIONS.WAITING_FOR_WIZARD;

        wizardAction();
    }

    @FXML
    public void guardButtonOnAction(ActionEvent event) throws IOException{
        attackButton.setDisable(true);
        guardButton.setDisable(true);

        var player = Context.getInstance().getPlayer();
        String playerGuard = player.setGuarding(true);

        playerTalk(playerGuard);

        condition = CONDITIONS.WAITING_FOR_WIZARD;

        wizardAction();
    }

    @FXML
    public void lanjutButtonOnAction(ActionEvent event) throws IOException{
        Parent characterView = null;
        try {
            characterView = FXMLLoader.load(getClass().getResource("/sample/views/endingScene.fxml"));
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
