package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menus extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Datei");
        MenuItem menuItemNew = new MenuItem("Neu");
        menuItemNew.setMnemonicParsing(true);
        menuItemNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN));
        MenuItem menuItemOpen = new MenuItem("Öffnen");
        menuItemOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN));
        menu.getItems().addAll(menuItemNew, menuItemOpen);
        menuBar.getMenus().add(menu);
        root.setTop(menuBar);
        Scene scene = new Scene(root, 390, 320);
        stage.setScene(scene);
        stage.show();
	}
}
