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

public class BeispielHBox extends Application{

    public static void main(String[] args) {
        launch(args);
   }


   @Override
   public void start(Stage stage) throws Exception {
       stage.setTitle("Beispielanwendung");
       HBox root = new HBox();
       root.setPadding(new Insets(5, 20, 5, 20));
       root.setSpacing(20);
       Button buttonNew = new Button("Neu ...");
       Button buttonOpen = new Button("Öffnen ...");
       Button buttonClose = new Button("Schliessen");
       Button buttonExit = new Button("Verlassen");
       root.getChildren().add(buttonNew);
       root.getChildren().add(buttonOpen);
       root.getChildren().addAll(buttonClose, buttonExit);
       Scene scene = new Scene(root, 700, 400);
       stage.setScene(scene);
       stage.show();
       }

}
