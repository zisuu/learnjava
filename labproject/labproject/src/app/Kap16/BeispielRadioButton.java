package app.Kap16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BeispielRadioButton extends Application {
    public static void main(String[] args) {
        launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beispielanwendung");
            HBox Hroot = new HBox();
            Hroot.setPadding(new Insets(5, 20, 5, 20));
            Hroot.setSpacing(20);
            ToggleGroup group = new ToggleGroup();
            RadioButton radioButton1 = new RadioButton("Gelb");
            radioButton1.setToggleGroup(group);
            radioButton1.setSelected(true);
            RadioButton radioButton2 = new RadioButton("Blau");
            radioButton2.setToggleGroup(group);
            RadioButton radioButton3 = new RadioButton("Grün");
            radioButton3.setToggleGroup(group);
            Hroot.getChildren().add(radioButton1);
            Hroot.getChildren().add(radioButton2);
            Hroot.getChildren().add(radioButton3);
            Scene scene = new Scene(Hroot, 300, 250);
            stage.setScene(scene);
            stage.show();
        }
}