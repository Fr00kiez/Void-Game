package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button exitbutt;

    public void setexitbuttOnAction(ActionEvent event)
    {
        Stage primarystage = (Stage) exitbutt.getScene().getWindow();
        primarystage.close();
    }
}
