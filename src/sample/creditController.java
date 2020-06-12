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

public class creditController implements Initializable {
    @FXML
    private Button kembalibutton;

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    public void kembalibuttonOnAction(ActionEvent event) throws IOException {
        Parent credit = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        Scene creditScene = new Scene(credit);
        Stage creditSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        creditSceneStage.hide();
        creditSceneStage.setScene(creditScene);
        creditSceneStage.show();
    }
}
