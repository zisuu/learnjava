package app.Kap16;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BeispielAnwendung extends Application {
    public static void main(String[] args) {
        launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beispielanwendung");
            Button button = new Button();
            button.setText("Klick mich");
            BorderPane root = new BorderPane();
            root.setCenter(button);
            Scene scene = new Scene(root, 300, 250);
            stage.setScene(scene);
            stage.show();
        }
}