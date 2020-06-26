package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException{

        //Mainkan backsound
        final Task task = new Task() {

            @Override
            protected Object call() throws Exception {
                int s = INDEFINITE;
                AudioClip audio = new AudioClip(getClass().getResource("backsound/poker face medieval.wav").toExternalForm());
                audio.setVolume(0.5f);
                audio.setCycleCount(s);
                audio.play();
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        //Memulai scene
        Parent root = FXMLLoader.load(getClass().getResource("views/mainScene.fxml"));
        primaryStage.setTitle("VOID");
        Scene scene = new Scene (root, 626, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
