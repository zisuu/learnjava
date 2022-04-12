package de.philipackermann.java.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TabPaneLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("TabPane-Layout");
        TabPane root = new TabPane();
        Tab tab = new Tab("Register 1");
        tab.setContent(new Text("Inhalt Tab 1"));
        tab.setClosable(false);
        Tab tab2 = new Tab("Register 2");
        tab2.setContent(new Text("Inhalt Tab 2"));
        root.getTabs().addAll(tab, tab2);
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
	}

}
