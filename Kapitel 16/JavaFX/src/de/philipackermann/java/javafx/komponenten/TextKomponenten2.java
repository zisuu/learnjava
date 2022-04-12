package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextKomponenten2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Text-Komponenten");
        VBox root = new VBox();
        Text text = new Text("Ein einfacher Text");
        Label label = new Label("Beschriftung");
        Image image = new Image(getClass().getResourceAsStream("label.png"));
        Label labelMitBild = new Label("Beschriftung mit Bild",new ImageView(image));
        Label labelMitAngepasstemText = new Label("Beschriftung mit großem Text");
        labelMitAngepasstemText.setFont(Font.font("Cambria", 30));
        Label labelRotiert = new Label("Beschriftung rotiert");
        labelRotiert.setRotate(180);
        root.getChildren().addAll(text);
        root.getChildren().addAll(label);
        root.getChildren().add(labelMitBild);
        root.getChildren().add(labelMitAngepasstemText);
        root.getChildren().add(labelRotiert);
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
	}

}
