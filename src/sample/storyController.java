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

public class storyController implements Initializable {
    @FXML
    private Button ohButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    public void ohButtonOnAction(ActionEvent event) throws IOException {
        Parent storyController = FXMLLoader.load(getClass().getResource("theMission.fxml"));
        Scene storyControllerScene = new Scene(storyController);
        Stage storyControllerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        storyControllerStage.hide();
        storyControllerStage.setScene(storyControllerScene);
        storyControllerStage.show();
    }
}
