package app.Kap16.animationen;

import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineAnimation extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Text text = new Text("Timeline Animation");
		KeyValue keyValue1 = new KeyValue(text.opacityProperty(), 0.4);
		KeyValue keyValue2 = new KeyValue(text.scaleXProperty(), 2.4);
		KeyValue keyValue3 = new KeyValue(text.strokeProperty(), Color.GREEN);
		KeyValue keyValue4 = new KeyValue(text.scaleYProperty(), 2.4);
		Duration duration1 = Duration.millis(1000);
		KeyFrame keyFrame1 = new KeyFrame(duration1, keyValue1, keyValue2);
		Duration duration2 = Duration.millis(5000);
		KeyFrame keyFrame2 = new KeyFrame(duration2, keyValue3, keyValue4);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().addAll(keyFrame1, keyFrame2);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.play();
		BorderPane root = new BorderPane();
		root.setCenter(text);
		Scene scene = new Scene(root, 150, 150);
		stage.setScene(scene);
		stage.show();
	}

}
