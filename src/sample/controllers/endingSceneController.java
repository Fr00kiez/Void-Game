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
import sample.models.Context;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class endingSceneController implements Initializable {
    @FXML
    private Button selesaiButton;

    @FXML
    private Label endingNarasi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String name = Context.getInstance().getPlayer().getName();
        endingNarasi.setText("Kamu berhasil mengalahkan Wizard itu\n" +
                "sebagai bukti kemenangan kamu\n" +
                "membawa tongkat milik Wizard itu.\n" +
                "Dan beberapa barang berharga lainnya.\n" +
                "\n" +
                "Selamat atas kemenanganmu " + name + " !");
        selesaiButton.setText("Kembali ke Menu");
    }
    @FXML
    public void selesaiButtonOnAction(ActionEvent event) throws IOException {
        Parent endScene = FXMLLoader.load(getClass().getResource("/sample/views/mainScene.fxml"));
        Scene endSceneScene = new Scene(endScene);
        Stage endSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        endSceneStage.hide();
        endSceneStage.setScene(endSceneScene);
        endSceneStage.show();
    }


}
