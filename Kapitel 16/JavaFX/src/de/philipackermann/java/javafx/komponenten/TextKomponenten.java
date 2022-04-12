package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TextKomponenten extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Text-Komponenten");
        VBox root = new VBox();
        root.setPadding(new Insets(5, 20, 5, 20));
        Text text = new Text("Kleiner Text");
        Text text2 = new Text("Großer Text");
        text2.setFont(Font.font("Cambria", 30));
        Text text3 = new Text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        text3.setWrappingWidth(200);
        text3.setTextAlignment(TextAlignment.JUSTIFY);
        root.getChildren().add(text);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        Scene scene = new Scene(root, 240, 400);
        stage.setScene(scene);
        stage.show();
	}

}
