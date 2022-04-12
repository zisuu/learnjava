package de.philipackermann.java.javafx.transformationen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Rotation extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Text text = new Text("Rotierter Text");
		text.getTransforms().add(new Rotate(-50, 0, 0));
		BorderPane root = new BorderPane();
		root.setCenter(text);
		Scene scene = new Scene(root, 150, 150);
		stage.setScene(scene);
		stage.show();
	}

}
