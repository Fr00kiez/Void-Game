package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Label label1 = new Label("VOID");
        Button button1 = new Button("Play");
        button1.setOnAction(e -> window.setScene(scene2));

        //layout sama child
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 375, 480);

        //button2
        Button button2 = new Button("Continue");
        button2.setOnAction(e -> window.setScene(scene1));

        //layout2
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button2);
        scene2 = new Scene(layout2, 375, 480);

        window.setScene(scene1);
        window.setTitle("VOID");
        window.show();

        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("VOID");
        Scene scene = new Scene (root, 457, 375, Color.BLACK);

        String judul = "VOID";
        Text judul1 = new Text(judul);
        judul1.setTextAlignment(TextAlignment.CENTER);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
