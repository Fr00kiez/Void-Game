package sample.controllers;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class story2Controller implements Initializable {
    @FXML
    private Button ohButton;
    @FXML
    private Label narasiCerita;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        narasiCerita.setText("Tidak lama setelah Prajurit itu datang, kamu segera bersiap\n" +
                "dan pergi ke hutan tempat Wizard itu berada.");
        ohButton.setText("Duna luar aku datang!");
    }

    public void StageGoblin(){
        narasiCerita.setText("Kamu berjalan melewati sungai dan masuk kedalam hutan.\n" +
                "Kamu berhenti melangkah dan mulai mengamati lingkungan\n" +
                "sekitar, lalu kamu melihat sebuah bayangan mendekatimu.\n" +
                "\n" +
                "KAMU DISERANG!\n");
        ohButton.setText("Bersiap untuk menyerang");
    }

    @FXML
    public void ohButtonOnAction( ) throws IOException {
        StageGoblin();
        ohButton.setOnAction(event -> {
            Parent mission = null;
            try {
                mission = FXMLLoader.load(getClass().getResource("/sample/views/attackGoblin.fxml"));
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
