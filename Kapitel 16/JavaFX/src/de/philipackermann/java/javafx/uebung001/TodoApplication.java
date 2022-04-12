package de.philipackermann.java.javafx.uebung001;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoApplication extends Application {
	
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    // Initialisierung des Formulars zum Anlegen von Aufgaben
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 15, 15, 15));
    hbox.setSpacing(15);
    final TextField textFieldDescription = new TextField();
    Label labelDescription = new Label("Aufgabe: ");
    final DatePicker datePickerUntil = new DatePicker();
    Label labelUntil = new Label("Erledigen bis: ");
    Button button = new Button("Hinzufügen");
    hbox.getChildren().addAll(
    labelDescription, 
    textFieldDescription, 
    labelUntil, 
    datePickerUntil, 
    button);
        
    // Initialisierung der Tabelle zum Aufliste der Aufgaben
    final TableView table = new TableView();
    TableColumn columnDescription = new TableColumn("Aufgabe");
    columnDescription.setMinWidth(300);
    TableColumn columnUntil = new TableColumn("Erledigen bis");
    columnUntil.setMinWidth(300);
    table.getColumns().addAll(columnDescription, columnUntil);
        
    VBox vbox = new VBox();
    vbox.getChildren().addAll(
      hbox, 
      table
    );
        
    // Initialisierung der Scene
    Scene scene = new Scene(vbox, 900, 500);
    stage.setScene(scene);
    stage.show();
  }
}
