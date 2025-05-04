package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItemToStoreScreen extends JFrame {
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

		JTextField titleField = new JTextField("Input title : ");
//		titleField.setMaximumSize(new Dimension(500, 30));
//		titleField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
//				BorderFactory.createEmptyBorder(0, 20, 0, 0)));
//		titleField.setMargin(new Insets(10, 10, 10, 10));

		JTextField authorField = new JTextField("Input author : ");
//		authorField.setMaximumSize(new Dimension(500, 30));
//		authorField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
//				BorderFactory.createEmptyBorder(0, 20, 0, 0)));

		JTextField costField = new JTextField("Input cost : ");
//		costField.setMaximumSize(new Dimension(500, 30));
//		costField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
//				BorderFactory.createEmptyBorder(0, 20, 0, 0)));

		center.add(titleField);
		center.add(authorField);
		center.add(costField);

		return center;
	}
	
	protected JTextField createTextField(String text) {
		JTextField textField = new JTextField(text);
		textField.setMaximumSize(new Dimension(500, 30));
		textField.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.DARK_GRAY),
				BorderFactory.createEmptyBorder(0, 20, 0, 0)));
		textField.setMargin(new Insets(10, 10, 10, 10));
		return textField;
	}
	
//	protected static Store store;
//	
//	JPanel createNorth() {
//		JPanel north = new JPanel();
//		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
//		north.add(createMenuBar());
//		north.add(createHeader());
//		return north;
//	}
//	
//	JMenuBar createMenuBar() {
//		JMenu menu = new JMenu("Options");
//		
//		JMenuItem viewStoreMenu = new JMenuItem("View store");
//		menu.add(viewStoreMenu);
//		
//		JMenu smUpdateStore = new JMenu("Update Store");
//		JMenuItem smAddBook = new JMenuItem("Add Book");
//		smUpdateStore.add(smAddBook);
//		JMenuItem smAddCD = new JMenuItem("Add CD");
//		smUpdateStore.add(smAddCD);
//		JMenuItem smAddDVD = new JMenuItem("Add DVD");
//        smUpdateStore.add(smAddDVD);        
//
//        smAddBook.addActionListener(new ButtonListener());
//        smAddCD.addActionListener(new ButtonListener());
//        smAddDVD.addActionListener(new ButtonListener());
//        
//        viewStoreMenu.addActionListener(new ActionListener() {
//        	@Override
//        	public void actionPerformed(ActionEvent e) {
//        		new StoreManagerScreen(store);
//        	}
//        });
//
//		menu.add(smUpdateStore);
//		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
//		menuBar.add(menu);
//		
//		return menuBar;
//	}
//	
//	JPanel createHeader() {
//		JPanel header = new JPanel();
//		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
//		
//		JLabel title = new JLabel("Add item to store:");
//		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 25));
//		title.setForeground(Color.CYAN);
//		
//		header.add(Box.createRigidArea(new Dimension(10, 10)));
//		header.add(title);
//		header.add(Box.createHorizontalGlue());
//		header.add(Box.createRigidArea(new Dimension(10, 10)));
//		
//		return header;
//	}
//	
////	JPanel createCenter() {
////		JPanel center = new JPanel();
////		return center;
////	}
//	
//	private class ButtonListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String cmd = e.getActionCommand();
//			if (cmd.equals("Add Book")) {
//				new AddBookToStoreScreen(store);
//			} else if (cmd.equals("Add CD")) {
//				new AddCompactDiscToStoreScreen(store);
//			} else if (cmd.equals("Add DVD")) {
//				new AddDigitalVideoDiscToStoreScreen(store);
//			}
//		}
//	}
//	
//	public AddItemToStoreScreen(Store store) {
//		super();
//		this.store = store;
//		
//		Container cp = getContentPane();
//		cp.setLayout(new BorderLayout());
//		cp.add(createNorth(), BorderLayout.NORTH);
////		cp.add(createCenter(), BorderLayout.CENTER);
//		
//		this.setSize(1024, 768);
//		this.setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//	public static void main(String[] args) {
//		new AddItemToStoreScreen(store);
//	}

}
