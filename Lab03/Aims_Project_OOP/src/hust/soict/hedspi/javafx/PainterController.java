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
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if(drawingPen.isSelected()) {
			Circle newCircle = new Circle(event.getX(),
					event.getY(), 4, Color.BLACK);
			drawingAreaPane.getChildren().add(newCircle);			
		}
		else {
			Circle newCircle = new Circle(event.getX(),
					event.getY(), 4, Color.WHITE);
			drawingAreaPane.getChildren().add(newCircle);	
		}
    }
    
    @FXML
    void selectedButton(ActionEvent event) {
        ToggleGroup toggleGroup = new ToggleGroup();	
        drawingPen.setToggleGroup(toggleGroup);
        eraserPen.setToggleGroup(toggleGroup);
        
        drawingPen.setSelected(true);

        if (eraserPen.isSelected()) {
        	drawingPen.setSelected(false);
        } else {
        	eraserPen.setSelected(false);
        }
    }
    
}
