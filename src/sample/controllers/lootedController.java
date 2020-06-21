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

public class lootedController implements Initializable {
    @FXML
    private Button ohButton;
    @FXML
    private Label narasiCerita;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        narasiCerita.setText("Kamu menemukan secarik kertas di tas gendong milik Goblin yang\n" +
                "yang menyerangmu tadi.\n" +
                "\n" +
                "'Dari pohon Beringin belok ke kanan'\n" +
                "\n" +
                "Kamu pun mencari sebuah pohon Beringin.");
        ohButton.setText("Aku ingat ada Beringin di dekat sungai.");
    }

    @FXML
    public void ohButtonOnAction(ActionEvent event) throws IOException {
        Parent looted = FXMLLoader.load(getClass().getResource("/sample/views/story3.fxml"));
        Scene lootedScene = new Scene(looted);
        Stage lootedStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        lootedStage.hide();
        lootedStage.setScene(lootedScene);
        lootedStage.show();
    }

}
