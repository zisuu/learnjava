package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("BorderPane-Layout");
        BorderPane root = new BorderPane();
        Label labelOben = new Label("oben");
        Label labelUnten = new Label("unten");
        Label labelLinks = new Label("links");
        Label labelRechts = new Label("rechts");
        Label labelMitte = new Label("Mitte");
        root.setTop(labelOben);
        root.setBottom(labelUnten);
        root.setLeft(labelLinks);
        root.setRight(labelRechts);
        root.setCenter(labelMitte);
        BorderPane.setAlignment(labelOben, Pos.CENTER);
        BorderPane.setAlignment(labelUnten, Pos.CENTER);
        BorderPane.setAlignment(labelLinks, Pos.CENTER);
        BorderPane.setAlignment(labelRechts, Pos.CENTER);
        BorderPane.setAlignment(labelMitte, Pos.CENTER);
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
	}

}
