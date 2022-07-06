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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BeispielVBox extends Application{

    public static void main(String[] args) {
        launch(args);
   }


   @Override
   public void start(Stage stage) throws Exception {
       stage.setTitle("Beispielanwendung");
       VBox root = new VBox();
       root.setPadding(new Insets(20, 5, 20, 5));
       root.setSpacing(20);
       Button button1 = new Button("Button 1");
       Button button2 = new Button("Button 2");
       Button button3 = new Button("Button 3");
       Button button4 = new Button("Button 4");
       Button button5 = new Button("Button 5");
       root.getChildren().add(button1);
       root.getChildren().add(button2);
       root.getChildren().addAll(button3, button4, button5);
       Scene scene = new Scene(root, 700, 400);
       stage.setScene(scene);
       stage.show();
       }

}
