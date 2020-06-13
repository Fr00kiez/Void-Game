package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
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
        narasiSatuLabel.setText("Selamat pagi, kamu yang bernama " + name + " ?");
    }

    @FXML
    public void lanjutkanbuttonOnAction(ActionEvent event) throws IOException {
        Parent characterView = FXMLLoader.load(getClass().getResource("attackGoblin.fxml"));
        Scene characterViewScene = new Scene(characterView);
        Stage characterViewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        characterViewStage.hide();
        characterViewStage.setScene(characterViewScene);
        characterViewStage.show();
    }
}
