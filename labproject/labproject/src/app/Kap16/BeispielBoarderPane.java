package app.Kap16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.text.Text;

public class BeispielBoarderPane extends Application {
    public static void main(String[] args) {
        launch(args);
   }


   @Override
   public void start(Stage stage) throws Exception {
       stage.setTitle("Beispielanwendung");
       BorderPane root = new BorderPane();
       MenuBar menuBar = new MenuBar();
       Menu menu = new Menu("Datei");
       MenuItem menuItem = new MenuItem("Schliessen");
       menu.getItems().add(menuItem);
       menuBar.getMenus().add(menu);
       Text textUnten = new Text("unten");
       Text textMitte = new Text("Mitte");
       Text textLinks = new Text("links");
       Text textRechts = new Text("rechts");
       root.setTop(menuBar);
       root.setBottom(textUnten);
       root.setLeft(textLinks);
       root.setRight(textRechts);
       root.setCenter(textMitte);
       BorderPane.setAlignment(menuBar, Pos.CENTER);
       BorderPane.setAlignment(textUnten, Pos.CENTER);
       BorderPane.setAlignment(textLinks, Pos.CENTER);
       BorderPane.setAlignment(textRechts, Pos.CENTER);
       BorderPane.setAlignment(textMitte, Pos.CENTER);
       Scene scene = new Scene(root, 700, 400);
       stage.setScene(scene);
       stage.show();
       }

}
