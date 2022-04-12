package de.philipackermann.java.javafx.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.*;

public class Controller {
	@FXML
	private MenuBar menuBar;
	
	@FXML
    private void handleOpen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.showOpenDialog(menuBar.getScene().getWindow());
    }
}
