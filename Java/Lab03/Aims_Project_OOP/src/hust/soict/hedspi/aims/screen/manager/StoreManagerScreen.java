package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	
	private static Store store;
	Container cp = getContentPane();
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreMenu = new JMenuItem("View store");
		viewStoreMenu.addActionListener(e -> {
			addNewCenter(this.createCenter());
		});
		menu.add(viewStoreMenu);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem smAddBook = new JMenuItem("Add Book");
		smAddBook.addActionListener(e -> {
			AddBookToStoreScreen bookScreen = new AddBookToStoreScreen();
			addNewCenter(bookScreen.createCenter());
		});
		smUpdateStore.add(smAddBook);
		
		JMenuItem smAddCD = new JMenuItem("Add CD");
		smAddCD.addActionListener(e -> {
			AddCompactDiscToStoreScreen cdScreen = new AddCompactDiscToStoreScreen();
			addNewCenter(cdScreen.createCenter());
		});
		smUpdateStore.add(smAddCD);
		
		JMenuItem smAddDVD = new JMenuItem("Add DVD");
		smAddDVD.addActionListener(e -> {
			AddDigitalVideoDiscToStoreScreen dvdScreen = new AddDigitalVideoDiscToStoreScreen();
			addNewCenter(dvdScreen.createCenter());
		});
        smUpdateStore.add(smAddDVD);        

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

		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}

	public void addNewCenter(JPanel panel) {
		LayoutManager layout = cp.getLayout();
		Component centerComponent = ((BorderLayout) layout).getLayoutComponent(cp, BorderLayout.CENTER);
		cp.remove(centerComponent);
		cp.add(panel, BorderLayout.CENTER);
		cp.revalidate();
		cp.repaint();
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
				MediaStore cell = new MediaStore(mediaInStore.get(i));
				center.add(cell);
		}
		
		return center;
	}
	
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
	
	public StoreManagerScreen(Store store) {		
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon", "Animation", 21.23f);
        store.addMedia(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Ponyo", "Animation", 24.55f);
        store.addMedia(dvd5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Conan", "Animation", 18.29f);
        store.addMedia(dvd6);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Howl's Moving Castle", "Animation", 15.29f);
        store.addMedia(dvd7);
        CompactDisc cd = new CompactDisc("Folklore", "Taylor Swift", 300.64f);
        store.addMedia(cd);
        Track track1 = new Track("The 1", 143);
        cd.addTrack(track1);
        Track track2 = new Track("Betty", 354);
        cd.addTrack(track2);
        Track track3 = new Track("Seven", 437);
        cd.addTrack(track3);
        Book book = new Book("Harry Potter", "Fantasy", 18.35f);
        store.addMedia(book);
        
		new StoreManagerScreen(store);
	}
	
}
