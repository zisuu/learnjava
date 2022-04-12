package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("HBox-Layout");
        HBox root = new HBox();
        root.setPadding(new Insets(5, 20, 5, 20));
        root.setSpacing(20);
        Button buttonNew = new Button("Neu ...");
        Button buttonOpen = new Button("Öffnen ...");
        Button buttonClose = new Button("Schließen");
        Button buttonExit = new Button("Verlassen");
        root.getChildren().add(buttonNew);
        root.getChildren().add(buttonOpen);
        root.getChildren().addAll(buttonClose, buttonExit);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}

}
