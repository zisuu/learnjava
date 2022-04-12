package de.philipackermann.java.javafx.transformationen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Translation extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Text text = new Text("Verschobener Text");
		text.getTransforms().add(new Translate(20, 40));
		BorderPane root = new BorderPane();
		root.setCenter(text);
		Scene scene = new Scene(root, 300, 150);
		stage.setScene(scene);
		stage.show();
	}

}
