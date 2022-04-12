package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("VBox-Layout");
        VBox root = new VBox();
        root.setPadding(new Insets(20, 5, 20, 5));
        root.setSpacing(20);
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().addAll(button3, button4, button5);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}

}
