package app.Kap16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BeispielButton extends Application {
    public static void main(String[] args) {
        launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beispielanwendung");
            BorderPane root = new BorderPane();
            Button button = new Button("Klick mich");
            root.setCenter(button);
            Scene scene = new Scene(root, 300, 250);
            stage.setScene(scene);
            stage.show();
        }
}