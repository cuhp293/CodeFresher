package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	
	private Cart cart;
	private Store store;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    void btnPlaceOrderAction(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
		createDialog(media.getTitle() + " - " + media.getCost() + " has been ordered!");
		cart.removeMedia(media);
		costLabel.setText(" " + cart.totalCost() + "  $");
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media instanceof DigitalVideoDisc) {
			createDialog(((DigitalVideoDisc) media).play());
		} else if (media instanceof CompactDisc) {
			createDialog(((CompactDisc) media).play());
		}
    }

	public void createDialog(String playText) {
		JDialog dialog = new JDialog();
		JLabel label = new JLabel(playText, SwingConstants.CENTER);
		dialog.setLocationRelativeTo(null);
		dialog.add(label);
		dialog.setSize(400, 200);
		dialog.setVisible(true);
	}

    @FXML
    void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		costLabel.setText(" " + cart.totalCost() + "  $");
	}

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			fxmlLoader.setController(new ViewStoreController(store, cart));
			Parent root = fxmlLoader.load();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Store");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    public void initialize() throws LimitExceededException {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	costLabel.setText(" " + cart.totalCost() + "  $");
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});
    }
    
	private void updateButtonBar(Media media) {
		if (media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			if (media instanceof Playable) {
				btnPlay.setVisible(true);
			} else
				btnPlay.setVisible(false);
		}
	}
    
    public CartController(Store store, Cart cart) {
    	this.cart = cart;
    	this.store = store;
    }

}
