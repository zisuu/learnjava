package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridPaneLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("GridPane-Layout");
        GridPane root = new GridPane();
//        root.setGridLinesVisible(true);
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setHgap(15);
        root.setVgap(15);
        Label labelUserName = new Label("Vorname: ");
        TextField textFieldUserName = new TextField();
        Label labelPassword= new Label("Passwort: ");
        PasswordField passwordField = new PasswordField();
        Button buttonLogin = new Button("Login");
        Button buttonCancel = new Button("Abbrechen");
        root.add(labelUserName, 0, 0);
        root.add(textFieldUserName, 1, 0, 2, 1);
        root.add(labelPassword, 0, 1);
        root.add(passwordField, 1, 1, 2, 1);
        root.add(buttonLogin, 1, 2);
        root.add(buttonCancel, 2, 2);
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.show();
	}

}
