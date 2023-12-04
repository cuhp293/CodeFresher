package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddTrackToStoreScreen extends AddItemToStoreScreen {
	
	JPanel createCenter() {
		JPanel panel = super.createCenter();
		
		JTextField lengthField = new JTextField("Input track length: ");
//		lengthField.setMaximumSize(new Dimension(500, 30));
//		lengthField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
//				BorderFactory.createEmptyBorder(0, 20, 0, 0)));
//		lengthField.setMargin(new Insets(10, 10, 10, 10));

		panel.add(lengthField);

		JButton btnAdd = new JButton("Add Track to the store");
		panel.add(btnAdd);

		return panel;
	}
	
//	private static CompactDisc CD;
//
//	public AddTrackToStoreScreen(CompactDisc CD) {
//		super();
//		this.CD = CD;
//		
//		this.setTitle("Add Track");
//		this.setSize(600, 300);
//		this.setVisible(true);
//	}
//	
//	public static void main(String[] args) {
//		new AddTrackToStoreScreen(CD);
//	}

}
