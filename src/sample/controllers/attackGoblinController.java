package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import sample.models.Battle;
import sample.models.Context;
import sample.models.Goblin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class attackGoblinController extends BattleController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setBattle(new Battle(
                Context.getInstance().getPlayer(),
                new Goblin(),
                this::playerTalks,
                this::enemyTalks,
                this::onPlayerAttack,
                this::onPlayerTurn,
                () -> {
                    playerTalks("Sangat efektif!");
                    enemyTalks("Argh!");

                    continueButton.setDisable(false);
                }));

        playerTalks("Err... Hai....");
        enemyTalks("Hei! Penyusup!");

        continueButton.setDisable(true);
    }

    @FXML
    public void attackButtonOnAction(ActionEvent event) throws IOException {
        getBattle().playerAttackAction();
    }

    @FXML
    public void guardButtonOnAction(ActionEvent event) throws IOException {
        getBattle().playerGuardAction();
    }

    @FXML
    public void continueButtonOnAction(ActionEvent event) throws IOException {
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
