package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SchaltflaechenKomponenten extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Text-Komponenten");
        VBox root = new VBox();
        root.setSpacing(5);
        root.setPadding(new Insets(5, 20, 5, 20));
        Button button = new Button("Öffnen");
        ToggleGroup group = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("Gelb");
        radioButton1.setToggleGroup(group);
        radioButton1.setSelected(true);
        RadioButton radioButton2 = new RadioButton("Blau");
        radioButton2.setToggleGroup(group);
        RadioButton radioButton3 = new RadioButton("Grün");
        radioButton3.setToggleGroup(group);
        
        ToggleButton toogleButton = new ToggleButton("Licht Wohnzimmer ");
        toogleButton.setSelected(false);
        ToggleButton toogleButton2 = new ToggleButton("Licht Flur");
        toogleButton2.setSelected(true);
        
        ToggleGroup group2 = new ToggleGroup();
        ToggleButton toogleButtonLarge = new ToggleButton("L");
        toogleButtonLarge.setToggleGroup(group2);
        toogleButtonLarge.setSelected(true);
        ToggleButton toogleButtonMedium = new ToggleButton("M");
        toogleButtonMedium.setToggleGroup(group2);
        ToggleButton toogleButtonSmall = new ToggleButton("S");
        toogleButtonSmall.setToggleGroup(group2);
        
        CheckBox checkBox1 = new CheckBox("Salami");
        checkBox1.setSelected(false);
        CheckBox checkBox2 = new CheckBox("Käse");
        checkBox2.setSelected(true);
        CheckBox checkBox3 = new CheckBox("Pepperoni");
        checkBox3.setSelected(true);
        checkBox3.setIndeterminate(true);
        
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        ObservableList<String> farben = FXCollections.observableArrayList("Rot", "Blau", "Grün");
        choiceBox.setItems(farben);
        farben.add("Orange");
        
        root.getChildren().addAll(radioButton1, radioButton2, radioButton3, toogleButton, toogleButton2, toogleButtonLarge, toogleButtonMedium, toogleButtonSmall, checkBox1, checkBox2, checkBox3, choiceBox);
        Scene scene = new Scene(root, 240, 400);
        stage.setScene(scene);
        stage.show();
	}

}
