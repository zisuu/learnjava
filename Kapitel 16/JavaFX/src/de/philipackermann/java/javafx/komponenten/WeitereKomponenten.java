package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class WeitereKomponenten extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(final Stage stage) throws Exception {
		stage.setTitle("Text-Komponenten");
        VBox root = new VBox();
        root.setSpacing(20);
        root.setPadding(new Insets(20, 20, 20, 20));
        /*
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        root.getChildren().add(slider);
        
        ProgressBar progressBar = new ProgressBar(0.6);
        root.getChildren().add(progressBar);
        
        ProgressIndicator progressIndicator = new ProgressIndicator(0.6);
        root.getChildren().add(progressIndicator);
        
        Hyperlink hyperlink = new Hyperlink("http://www.philipackermann.de");
        root.getChildren().add(hyperlink);
        
        Separator separator = new Separator();
        root.getChildren().add(separator);
        */
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().add(new Button("Öffnen"));
        toolBar.getItems().add(new Button("Schließen"));
        toolBar.getItems().add(new Button("Speichern"));
        root.getChildren().add(toolBar);
        
        ScrollPane scrollPane = new ScrollPane();
        VBox vBox = new VBox();
        TextArea textArea = new TextArea();
        vBox.getChildren().add(textArea);
        scrollPane.setContent(vBox);
        root.getChildren().add(scrollPane);

        ScrollBar scrollBar = new ScrollBar();
        root.getChildren().add(scrollBar);
        
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().add(new TextField());
        splitPane.getItems().add(new TextField());
        root.getChildren().add(splitPane);
        
//        TitledPane titledPane = new TitledPane();
//        titledPane.setText("Bereich mit Titel");
//        titledPane.setContent(new TextArea());
//        root.getChildren().add(titledPane);
        
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(new Tab("Tab 1"));
        tabPane.getTabs().add(new Tab("Tab 2"));
        tabPane.getTabs().add(new Tab("Tab 3"));
        tabPane.getTabs().add(new Tab("Tab 4"));
        root.getChildren().add(tabPane);
        
//        Accordion accordion = new Accordion();
//        accordion.getPanes().add(new TitledPane("Bereich 1", new TextArea()));
//        accordion.getPanes().add(new TitledPane("Bereich 2", new TextArea()));
//        accordion.getPanes().add(new TitledPane("Bereich 3", new TextArea()));
//        accordion.getPanes().add(new TitledPane("Bereich 4", new TextArea()));
//        root.getChildren().add(accordion);
        
        /*
        Button button1 = new Button();
        button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Datei öffnen");
				fileChooser.showOpenDialog(stage);
			}
		});
        root.getChildren().add(button1);
        
		DatePicker datePicker = new DatePicker();
        root.getChildren().add(datePicker);
        ColorPicker colorPicker = new ColorPicker();
        root.getChildren().add(colorPicker);
        */
//        HTMLEditor htmlEditor = new HTMLEditor();
//        root.getChildren().add(htmlEditor);
        
        Scene scene = new Scene(root, 240, 400);
        stage.setScene(scene);
        stage.show();
	}

}
