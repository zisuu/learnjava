package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StackPaneLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("StackPane-Layout");
        StackPane root = new StackPane();
        Rectangle rectangle = new Rectangle(70, 70);
        Rectangle rectangle2 = new Rectangle(50, 50);
        rectangle2.setFill(Color.YELLOW);
        Circle circle = new Circle(20);
        Circle circle2 = new Circle(15);
        circle2.setFill(Color.YELLOW);
        root.getChildren().addAll(rectangle, rectangle2, circle, circle2);
        Scene scene = new Scene(root, 80, 80);
        stage.setScene(scene);
        stage.show();
	}

}
