package app.Kap16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BeispielMenu extends Application {
    public static void main(String[] args) {
        launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beispielanwendung");
            HBox Hroot = new HBox();
            Hroot.setPadding(new Insets(5, 20, 5, 20));
            Hroot.setSpacing(20);
            MenuBar menuBar = new MenuBar();
            Menu menu = new Menu("Datei");
            MenuItem menuItem = new MenuItem("Neu");
            CheckMenuItem checkMenuItem = new CheckMenuItem("Auswahl");
            menu.getItems().add(menuItem);
            menu.getItems().add(checkMenuItem);
            menuBar.getMenus().add(menu);
            Scene scene = new Scene(menuBar, 300, 250);
            stage.setScene(scene);
            stage.show();
        }
}