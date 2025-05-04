package hust.soict.hedspi.test.screen.customer.store;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
	private static Cart cart;
	private static Store store;

	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		CartController cartController = new CartController(store, cart);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();

		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) throws LimitExceededException {
		cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);				
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Ponyo", "Animation", 24.55f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Conan", "Animation", 18.29f);
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(dvd4);
		cart.addMedia(dvd5);
		
		launch(args);
	}

}
