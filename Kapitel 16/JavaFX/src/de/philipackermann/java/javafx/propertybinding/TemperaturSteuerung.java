package de.philipackermann.java.javafx.propertybinding;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TemperaturSteuerung extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		final Raum wohnzimmer = new Raum();
        Button buttonPlus = new Button("+1");
        Button buttonMinus = new Button("-1");
        final Label label = new Label(new Double(wohnzimmer.getTemperatur()).toString()); 
        label.setAlignment(Pos.CENTER); 
        wohnzimmer.temperaturProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> wert, Object alterWert, Object neuerWert) {
                label.setText(new Double(wohnzimmer.getTemperatur()).toString()); 
			}
		});
        buttonPlus.setOnAction(new EventHandler<ActionEvent>() { 
            @Override 
            public void handle(ActionEvent event) { 
                wohnzimmer.setTemperatur(wohnzimmer.getTemperatur() + 1); 
            } 
        });
        buttonMinus.setOnAction(new EventHandler<ActionEvent>() { 
            @Override 
            public void handle(ActionEvent event) { 
                wohnzimmer.setTemperatur(wohnzimmer.getTemperatur() - 1); 
            } 
        });
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER); 
        grid.add(buttonMinus, 0, 0);
        grid.add(label, 1, 0);
        grid.add(buttonPlus, 2, 0); 
        Scene scene = new Scene(grid, 150, 100); 
        stage.setScene(scene); 
        stage.show();
	}
}
