package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class story3Controller implements Initializable {
    @FXML
    private Button ohButton;
    @FXML
    private Label narasiCerita;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        narasiCerita.setText("Kamu berusaha mengingat dimana kamu\n" +
                "pernah melihat pohon Beringin\n" +
                "Kamu menyusuri pinggiran sungai sampai\n" +
                "akhirnya kamu melihat sebuah pohon\n" +
                "yang besar dan teduh.\n");
        ohButton.setText("Ok, sekarang belok ke kanan");
    }

    public void stageWizard(){
        narasiCerita.setText("Oops, sepertinya kamu tidak menemukan Wizard itu.\n" +
                "Tapi...\n" +
                "Wizard itu yang menemukan kamu!\n" +
                "\n" +
                "KAMU DISERANG!\n");
        ohButton.setText("Ah, sangat mengejutkan.");
    }

    @FXML
    public void ohButtonOnAction( ) throws IOException {
        stageWizard();
        ohButton.setOnAction(event -> {
            Parent mission = null;
            try {
                mission = FXMLLoader.load(getClass().getResource("/sample/views/attackWizard.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene missionScene = new Scene(mission);
            Stage missionStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            missionStage.hide();
            missionStage.setScene(missionScene);
            missionStage.show();
        });
    }

}
