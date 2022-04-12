package de.philipackermann.java.javafx.komponenten;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TreeViewKomponente extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("TreeView-Komponente");
        TreeItem<String> rootItem = new TreeItem<String>("Wurzel");
        rootItem.setExpanded(true);
        for(int i=1; i<5; i++) {
        	TreeItem<String> item = new TreeItem<String>("Knoten " + i);
        	item.setExpanded(true);
            rootItem.getChildren().add(item);       
        	for(int j=1; j<5; j++) {
        		TreeItem<String> leaf = new TreeItem<String>("Blatt " + j);
        		item.getChildren().add(leaf);
        	}
        }        
        TreeView<String> tree = new TreeView<String>(rootItem); 
        Scene scene = new Scene(tree, 200, 270);
        stage.setScene(scene);
        stage.show();
	}
}
