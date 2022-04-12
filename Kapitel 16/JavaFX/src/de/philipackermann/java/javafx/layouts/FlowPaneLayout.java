package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FlowPaneLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("FlowPane-Layout");
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.HORIZONTAL);
        root.setAlignment(Pos.TOP_LEFT);
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().addAll(button3, button4, button5);
        Scene scene = new Scene(root, 290, 140);
        stage.setScene(scene);
        stage.show();
	}

}
