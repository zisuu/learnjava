package de.philipackermann.java.javafx.uebung002;

import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TodoApplication extends Application {

  private ObservableList<Todo> todos = FXCollections.observableArrayList();

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
    final TableView<Todo> table = new TableView();
    TableColumn columnDescription = new TableColumn("Aufgabe");
    columnDescription.setMinWidth(300);
    columnDescription.setCellValueFactory(new PropertyValueFactory<Todo, String>("description"));
    TableColumn columnUntil = new TableColumn("Erledigen bis");
    columnUntil.setMinWidth(300);
    columnUntil.setCellValueFactory(new PropertyValueFactory<Todo, String>("until"));
    table.getColumns().addAll(columnDescription, columnUntil);
    table.setItems(this.getTodos());

    // Registrieren der Listener
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    button.addEventHandler(ActionEvent.ACTION,
      new EventHandler<ActionEvent>() {
    @Override
      public void handle(ActionEvent actionEvent) {
        Todo todo = new Todo();
        todo.setDescription(textFieldDescription.getText());
        todo.setUntil(datePickerUntil.getValue().format(formatter));
        table.getItems().add(todo);
      }
    }
  );

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

  public ObservableList<Todo> getTodos() {
    return this.todos;
  }
}
