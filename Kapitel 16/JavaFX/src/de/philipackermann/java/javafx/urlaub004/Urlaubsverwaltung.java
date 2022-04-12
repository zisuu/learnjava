package de.philipackermann.java.javafx.urlaub004;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Urlaubsverwaltung extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        // Initialisierung des Menüs
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Datei");
        MenuItem menuItem = new MenuItem("Neu");
        menu.getItems().add(menuItem);
        menuBar.getMenus().add(menu);
        root.setTop(menuBar);
        // Initialisierung der Tabs
        TabPane tabPane = new TabPane();
        Tab tab = new Tab("Urlaubsantrag anlegen");
        Tab tab2 = new Tab("Urlaubsanträge");
        tab2.setClosable(false);
        tabPane.getTabs().addAll(tab, tab2);
        root.setCenter(tabPane);
        // Initialisierung des Inhalts von Tab 1
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        TextField textFieldFirstName = new TextField();
        Label labelFirstName = new Label("Vorname: ");
        TextField textFieldLastName = new TextField();
        Label labelLastName = new Label("Nachname: ");
        DatePicker datePickerFrom = new DatePicker();
        Label labelFrom = new Label("Von: ");
        DatePicker datePickerTo = new DatePicker();
        Label labelTo = new Label("Bis: ");
        Button button = new Button("Beantragen");
        gridPane.add(labelFirstName, 0, 0);
        gridPane.add(textFieldFirstName, 1, 0);
        gridPane.add(labelLastName, 0, 1);
        gridPane.add(textFieldLastName, 1, 1);
        gridPane.add(labelFrom, 0, 2);
        gridPane.add(datePickerFrom, 1, 2);
        gridPane.add(labelTo, 0, 3);
        gridPane.add(datePickerTo, 1, 3);
        gridPane.add(button, 1, 4);
        tab.setContent(gridPane);
        tab.setClosable(false);
        // Initialisierung des Inhalts von Tab 2
        TableView table = new TableView();
        TableColumn columnFirstName = new TableColumn("Vorname");
        TableColumn columnLastName = new TableColumn("Nachname");
        TableColumn columFrom = new TableColumn("Von");
        TableColumn columTo = new TableColumn("Bis");
        table.getColumns().addAll(columnFirstName, columnLastName, columFrom, columTo);
        tab2.setContent(table);
        // Initialisierung der Scene
        Scene scene = new Scene(root, 320, 320);
        scene.getStylesheets().add("de/philipackermann/java/javafx/urlaub004/styles.css");
        stage.setScene(scene);
        stage.show();
	}
}
