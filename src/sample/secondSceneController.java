package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class secondSceneController implements Initializable {
    @FXML
    private Button okbutton;

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    public void okbuttonOnAction(ActionEvent event) throws IOException {
        Parent secondScene = FXMLLoader.load(getClass().getResource("theMission.fxml"));
        Scene secondSceneScene = new Scene(secondScene);
        Stage secondSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        secondSceneStage.hide();
        secondSceneStage.setScene(secondSceneScene);
        secondSceneStage.show();
    }
}
