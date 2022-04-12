package de.philipackermann.java.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KontaktListe extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Kontakt-Liste");
		BorderPane root = new BorderPane();
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Datei");
		MenuItem menuItem = new MenuItem("Schließen");
		menu.getItems().add(menuItem);
		menuBar.getMenus().add(menu);
		Text textUnten = new Text("unten");
		Text textMitte = new Text("Mitte");
		Text textLinks = new Text("links");
		Text textRechts = new Text("rechts");
		root.setTop(menuBar);
		root.setBottom(textUnten);
		root.setLeft(textLinks);
		root.setRight(textRechts);
		root.setCenter(textMitte);
		BorderPane.setAlignment(menuBar, Pos.CENTER);
		BorderPane.setAlignment(textUnten, Pos.CENTER);
		BorderPane.setAlignment(textLinks, Pos.CENTER);
		BorderPane.setAlignment(textRechts, Pos.CENTER);
		BorderPane.setAlignment(textMitte, Pos.CENTER);
		Scene scene = new Scene(root, 700, 400);
		stage.setScene(scene);
		stage.show();
	}
}