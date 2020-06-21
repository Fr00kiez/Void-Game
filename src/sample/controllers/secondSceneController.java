package sample.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import sample.models.Context;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class secondSceneController implements Initializable {
    @FXML
    private Button okbutton;

    @FXML
    private TextField namefield;

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    public void okbuttonOnAction(ActionEvent event) throws IOException {
        if (namefield.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Harap masukkan nama kamu!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Apakah nama kamu adalah " + namefield.getText() + " ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Context.getInstance().getPlayer().setName(namefield.getText());

                Parent secondScene = FXMLLoader.load(getClass().getResource("/sample/views/characterView.fxml"));

                Scene secondSceneScene = new Scene(secondScene);
                Stage secondSceneStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                secondSceneStage.hide();
                secondSceneStage.setScene(secondSceneScene);
                secondSceneStage.show();
            }
        }
    }
}
