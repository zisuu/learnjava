package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FelderKomponenten extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Felder-Komponenten");
        GridPane root = new GridPane();
        root.setPadding(new Insets(5, 20, 5, 20));
        root.setHgap(5);
        root.setVgap(5);
        TextField textField = new TextField();
        textField.setPromptText("Bitte Text eingeben");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Bitte Passwort eingeben");
        root.add(textField, 0, 0);
        root.add(passwordField, 0, 1);
        root.add(new TextField(), 0, 2);
        Scene scene = new Scene(root, 150, 150);
        stage.setScene(scene);
        stage.show();
	}

}
