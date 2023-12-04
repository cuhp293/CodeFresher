package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	
	JPanel createCenter() {
		JPanel panel = super.createCenter();
		JButton btnAdd = new JButton("Add Book to the store");
		panel.add(btnAdd);
		return panel;
	}

}
