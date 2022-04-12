package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListViewKomponente extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ListView-Komponente");
        ListView<String> listView = new ListView<String>();
        ObservableList<String> farben = FXCollections.observableArrayList ("Rot", "Blau", "Grün", "Orange");
        listView.setItems(farben);
        Scene scene = new Scene(listView, 700, 700);
        stage.setScene(scene);
        stage.show();
	}
}
