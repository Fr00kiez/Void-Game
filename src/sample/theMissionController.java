package sample;

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

public class theMissionController implements Initializable {
    @FXML
    private Button lanjutkanButton;

    @FXML
    private Label narasiSatuLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String name = Context.getInstance().getPlayer().getName();
        narasiSatuLabel.setText("Selamat pagi, kamu yang bernama " + name + " ?\n" +
                "Sayembara yang kamu ikuti sudah dimulai.\n" +
                "Tugas kamu adalah memburu seorang Wizard.");
    }

    public void narasiKedua(){
        narasiSatuLabel.setText("Wizard itu tinggal di kawasan hutan sebelah Timur,\n" +
                "Wizard itu tentunya tidak ingin diganggu jadi\n" +
                "berhati-hatilah dengan Goblin yang berjaga disana.\n");
    }


    @FXML
    public void lanjutkanButtonOnAction( ) throws IOException {
        narasiKedua();
        lanjutkanButton.setOnAction(event -> {
            Parent characterView = null;
            try {
                characterView = FXMLLoader.load(getClass().getResource("attackGoblin.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene characterViewScene = new Scene(characterView);
            Stage characterViewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            characterViewStage.hide();
            characterViewStage.setScene(characterViewScene);
            characterViewStage.show();
        });
    }
}
