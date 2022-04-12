package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AnchorPaneLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AnchorPane-Layout");
        AnchorPane root = new AnchorPane();
        ListView<String> listView = new ListView<String>();
        ObservableList<String> farben = FXCollections.observableArrayList("Rot", "Grün", "Blau", "Gelb", "Orange");
        listView.setItems(farben);
        AnchorPane.setTopAnchor(listView, 10.0);
        AnchorPane.setLeftAnchor(listView, 10.0);
        AnchorPane.setRightAnchor(listView, 90.0);
        AnchorPane.setBottomAnchor(listView, 10.0);
        Button buttonNew = new Button("Neu");
        AnchorPane.setTopAnchor(buttonNew, 10.0);
        AnchorPane.setRightAnchor(buttonNew, 10.0);
        Button buttonDelete = new Button("Löschen");
        AnchorPane.setTopAnchor(buttonDelete, 40.0);
        AnchorPane.setRightAnchor(buttonDelete, 10.0);
        root.getChildren().addAll(listView, buttonNew, buttonDelete);
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.show();
	}

}
