package app.Kap16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BeispielCheckBox extends Application {
    public static void main(String[] args) {
        launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beispielanwendung");
            HBox Hroot = new HBox();
            Hroot.setPadding(new Insets(5, 20, 5, 20));
            Hroot.setSpacing(20);
            CheckBox checkBox1 = new CheckBox("Option1");
            checkBox1.setSelected(false);
            CheckBox checkBox2 = new CheckBox("Option2");
            checkBox2.setSelected(true);
            CheckBox checkBox3 = new CheckBox("Option3");
            checkBox3.setSelected(true);
            checkBox3.setIndeterminate(true);
            Hroot.getChildren().add(checkBox1);
            Hroot.getChildren().add(checkBox2);
            Hroot.getChildren().add(checkBox3);
            Scene scene = new Scene(Hroot, 300, 250);
            stage.setScene(scene);
            stage.show();
        }
}