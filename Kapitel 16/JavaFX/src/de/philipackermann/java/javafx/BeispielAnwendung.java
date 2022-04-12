package de.philipackermann.java.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BeispielAnwendung extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Beispiel-Anwendung");
        Button button = new Button();
        button.setText("Klick mich");
        BorderPane root = new BorderPane();
        root.setCenter(button);
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
	}

}
