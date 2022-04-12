package de.philipackermann.java.javafx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        final Text text = new Text();
        root.setTop(text);
        Button button = new Button("Bitte klicken");
        button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				text.setText("Geklickt");
			}
		});
        root.setCenter(button);
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.show();
	}
}
