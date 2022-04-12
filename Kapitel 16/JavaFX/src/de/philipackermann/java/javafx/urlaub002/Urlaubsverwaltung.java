package de.philipackermann.java.javafx.urlaub002;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
        Tab tabNeuerUrlaubsantrag = new Tab("Urlaubsantrag anlegen");
        tabNeuerUrlaubsantrag.setClosable(false);
        Tab tabUrlaubsantraege = new Tab("Urlaubsanträge");
        tabUrlaubsantraege.setClosable(false);
        tabPane.getTabs().addAll(tabNeuerUrlaubsantrag, tabUrlaubsantraege);
        root.setCenter(tabPane);
        // Initialisierung des Inhalts von Tab 1
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        final TextField textFieldVorname = new TextField();
        Label labelVorname = new Label("Vorname: ");
        final TextField textFieldNachname = new TextField();
        Label labelNachname = new Label("Nachname: ");
        Label labelUrlaubsBeginn = new Label("Von: ");
        final DatePicker datePickerUrlaubsBeginn = new DatePicker();
        Label labelUrlaubEnde = new Label("Bis: ");
        final DatePicker datePickerUrlaubsEnde = new DatePicker();
        Button buttonBeantragen = new Button("Beantragen");
        gridPane.add(labelVorname, 0, 0);
        gridPane.add(textFieldVorname, 1, 0);
        gridPane.add(labelNachname, 0, 1);
        gridPane.add(textFieldNachname, 1, 1);
        gridPane.add(labelUrlaubsBeginn, 0, 2);
        gridPane.add(datePickerUrlaubsBeginn, 1, 2);
        gridPane.add(labelUrlaubEnde, 0, 3);
        gridPane.add(datePickerUrlaubsEnde, 1, 3);
        gridPane.add(buttonBeantragen, 1, 4);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.NEVER);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints2);
        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setTopAnchor(gridPane, 10.0);
        AnchorPane.setLeftAnchor(gridPane, 10.0);
        AnchorPane.setRightAnchor(gridPane, 10.0);
        anchorPane.getChildren().add(gridPane);
        tabNeuerUrlaubsantrag.setContent(anchorPane);
        // Initialisierung des Inhalts von Tab 2
        final TableView<Urlaubsantrag> tableView = new TableView();
        TableColumn columnVorname = new TableColumn("Vorname");
        TableColumn columnNachname = new TableColumn("Nachname");
        TableColumn columUrlaubsBeginn = new TableColumn("Von");
        TableColumn columUrlaubsEnde = new TableColumn("Bis");
        columnVorname.setCellValueFactory(new PropertyValueFactory<Urlaubsantrag, String>("vorname"));
        columnNachname.setCellValueFactory(new PropertyValueFactory<Urlaubsantrag, String>("nachname"));
        columUrlaubsBeginn.setCellValueFactory(new PropertyValueFactory<Urlaubsantrag, String>("datumUrlaubsBeginn"));
        columUrlaubsEnde.setCellValueFactory(new PropertyValueFactory<Urlaubsantrag, String>("datumUrlaubsEnde"));
        tableView.getColumns().addAll(columnVorname, columnNachname, columUrlaubsBeginn, columUrlaubsEnde);
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.getChildren().add(tableView);
        AnchorPane.setTopAnchor(tableView, 10.0);
        AnchorPane.setBottomAnchor(tableView, 10.0);
        AnchorPane.setLeftAnchor(tableView, 10.0);
        AnchorPane.setRightAnchor(tableView, 10.0);
        tabUrlaubsantraege.setContent(anchorPane2);
        // Registrieren der Listener
        buttonBeantragen.setOnAction(new EventHandler<ActionEvent>() {
    	  @Override
    	  public void handle(ActionEvent actionEvent) {
    	    Urlaubsantrag urlaubsantrag = new Urlaubsantrag();
    	    urlaubsantrag.setVorname(textFieldVorname.getText());
    	    urlaubsantrag.setNachname(textFieldNachname.getText());
    	    urlaubsantrag.setDatumUrlaubsBeginn(datePickerUrlaubsBeginn.getValue());
    	    urlaubsantrag.setDatumUrlaubsEnde(datePickerUrlaubsEnde.getValue());
    	    tableView.getItems().add(urlaubsantrag);
    	  }
    	});
        // Initialisierung der Scene
        Scene scene = new Scene(root, 390, 320);
        stage.setScene(scene);
        stage.show();
	}
}
