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

public class characterViewController implements Initializable {
    @FXML
    private Label namelabel;

    @FXML
    private Button lanjutbutton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        namelabel.setText(Context.getInstance().getPlayer().getName());
    }

    @FXML
    public void lanjutbuttonOnAction(ActionEvent event) throws IOException {
        Parent characterView = FXMLLoader.load(getClass().getResource("story.fxml"));
        Scene characterViewScene = new Scene(characterView);
        Stage characterViewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        characterViewStage.hide();
        characterViewStage.setScene(characterViewScene);
        characterViewStage.show();
    }
}
