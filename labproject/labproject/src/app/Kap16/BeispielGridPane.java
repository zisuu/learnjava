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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BeispielGridPane extends Application{

    public static void main(String[] args) {
        launch(args);
   }


   @Override
   public void start(Stage stage) throws Exception {
       stage.setTitle("Beispielanwendung");
       GridPane root = new GridPane();
       root.setPadding(new Insets(15, 15, 15, 15));
       root.setHgap(15);
       root.setVgap(15);
       Label labelUserName = new Label("Vorname: ");
       TextField textFieldUserName = new TextField();
       Label labelPassword= new Label("Passwort: ");
       PasswordField passwordField = new PasswordField();
       Button buttonLogin = new Button("Login");
       Button buttonCancel = new Button("Abbrechen");
       root.add(labelUserName, 0, 0);
       root.add(textFieldUserName, 1, 0, 2, 1);
       root.add(labelPassword, 0, 1);
       root.add(passwordField, 1, 1, 2, 1);
       root.add(buttonLogin, 1, 2);
       root.add(buttonCancel, 2, 2);
       Scene scene = new Scene(root, 700, 400);
       stage.setScene(scene);
       stage.show();
       }

}
