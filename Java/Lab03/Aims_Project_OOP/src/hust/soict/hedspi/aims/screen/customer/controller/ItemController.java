package hust.soict.hedspi.aims.screen.customer.controller;

import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

	private Media media;
	
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
    	if (media instanceof DigitalVideoDisc) {
    		createDialog(((DigitalVideoDisc) media).play());
    	} else if (media instanceof CompactDisc) {
    		createDialog(((CompactDisc) media).play());
    	}
    }
    
    private void createDialog(String play) {
    	JDialog dialog = new JDialog();
    	JLabel label = new JLabel(play);
    	dialog.setLocationRelativeTo(null);
    	dialog.add(label);
    	dialog.setSize(400, 200);
    	dialog.setVisible(true);
	}

	public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }

}
