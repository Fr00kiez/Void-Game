package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainSceneController implements Initializable{

    @FXML
    private Button playbutt;
    @FXML
    private Button creditbutt;
    @FXML
    private Button exitbutt;

    @FXML
    public void setPlaybuttlaybuttOnAction(ActionEvent event) throws IOException {
        Parent mainScene = FXMLLoader.load(getClass().getResource("secondScene.fxml"));
        Scene mainSceneScene = new Scene(mainScene);
        Stage mainSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainSceneStage.hide();
        mainSceneStage.setScene(mainSceneScene);
        mainSceneStage.show();
    }

    @FXML
    public void setCreditbuttOnAction(ActionEvent event) throws IOException {
        Parent mainScene = FXMLLoader.load(getClass().getResource("credit.fxml"));
        Scene mainSceneScene = new Scene(mainScene);
        Stage mainSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainSceneStage.hide();
        mainSceneStage.setScene(mainSceneScene);
        mainSceneStage.show();
    }

    @FXML
    public void setExitbuttOnAction(MouseEvent event) {
        Stage primarystage = (Stage) exitbutt.getScene().getWindow();
        primarystage.close();
    }
}
