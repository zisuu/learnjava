package de.philipackermann.java.javafx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventBeispiel extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        final Text text = new Text();
        root.setTop(text);
        TextField textField = new TextField();
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				text.setText(text.getText() + keyEvent.getText());
			}
		});
        root.setCenter(textField);
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.show();
	}
}
