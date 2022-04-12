package de.philipackermann.java.javafx.komponenten;

import de.philipackermann.java.javafx.urlaub002.Urlaubsantrag;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableViewKomponente extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public class Nutzer {
		private String vorname;
		private String nachname;
		
		
		public Nutzer(String vorname, String nachname) {
			super();
			this.vorname = vorname;
			this.nachname = nachname;
		}
		public String getVorname() {
			return vorname;
		}
		public void setVorname(String vorname) {
			this.vorname = vorname;
		}
		public String getNachname() {
			return nachname;
		}
		public void setNachname(String nachname) {
			this.nachname = nachname;
		}
		
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("TableView-Komponente");
        TableView<Nutzer> table = new TableView();
        TableColumn columnVorname = new TableColumn("Vorname");
        TableColumn columnNachname = new TableColumn("Nachname");
        columnVorname.setCellValueFactory(new PropertyValueFactory<Nutzer, String>("vorname"));
        columnNachname.setCellValueFactory(new PropertyValueFactory<Nutzer, String>("nachname"));
        table.getColumns().addAll(columnVorname, columnNachname);
        table.getItems().addAll(new Nutzer("Kai", "Günster"));
        table.getItems().addAll(new Nutzer("Philip", "Ackermann"));
        Scene scene = new Scene(table, 200, 200);
        stage.setScene(scene);
        stage.show();
	}
}
