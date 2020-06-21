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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void attackButtonOnAction(ActionEvent event) throws IOException{
        //memberikan damage ke musuh dan menampilkan damage lewat label goblinTalks
    }

    @FXML
    public void guardButtonOnAction(ActionEvent event) throws IOException{
        //bertahan dan menampilkan "Tidak ada serangan" pada goblinTalks dan damage yang didapat pada label playerTalks
    }

    @FXML
    public void lanjutButtonOnAction(ActionEvent event) throws IOException{
        //gak bisa lanjut kalau goblin belum mati, muncul warning. kalau sudah pindah scene
    }

}
