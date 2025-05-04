package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton drawingPen;
    
    @FXML
    private RadioButton eraserPen;
    
    @FXML
    private ToggleGroup tools;
    
    @FXML
    void selected(ActionEvent event) {
		ToggleGroup select = new ToggleGroup();	
		drawingPen.setToggleGroup(select);
		eraserPen.setToggleGroup(select);
		if(drawingPen.isSelected()) {
			eraserPen.setSelected(false);
		}
		else {
			drawingPen.setSelected(false);
		}
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if(drawingPen.isSelected()) {
			Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
			drawingAreaPane.getChildren().add(newCircle);			
		}
		else {
			Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
			drawingAreaPane.getChildren().add(newCircle);	
		}
    }
}
