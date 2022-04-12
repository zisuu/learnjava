package de.philipackermann.java.javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Einbinden einer FXML-Komponente in Java");
        BorderPane root = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
	}
}