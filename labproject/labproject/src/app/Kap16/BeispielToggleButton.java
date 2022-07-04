package app.Kap16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BeispielToggleButton extends Application {
    public static void main(String[] args) {
        launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beispielanwendung");
            HBox Hroot = new HBox();
            Hroot.setPadding(new Insets(5, 20, 5, 20));
            Hroot.setSpacing(20);
            ToggleGroup group2 = new ToggleGroup();
            ToggleButton toggleButtonOne = new ToggleButton("Option1");
            toggleButtonOne.setToggleGroup(group2);
            toggleButtonOne.setSelected(true);
            ToggleButton toggleButtonTwo = new ToggleButton("Option2");
            toggleButtonTwo.setToggleGroup(group2);
            ToggleButton toggleButtonThree = new ToggleButton("Option3");
            toggleButtonThree.setToggleGroup(group2);
            Hroot.getChildren().add(toggleButtonOne);
            Hroot.getChildren().add(toggleButtonTwo);
            Hroot.getChildren().add(toggleButtonThree);
            Scene scene = new Scene(Hroot, 300, 250);
            stage.setScene(scene);
            stage.show();
        }
}