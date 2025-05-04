package hust.soict.hedspi.aims;

import java.util.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	
    private static Store store = new Store();
    private static Cart cart = new Cart();
    
    public static void mediaInStore() {
    	CompactDisc cd = new CompactDisc("Folklore", "Taylor Swift", 300.64f);
        store.addMedia(cd);
        
        Book book = new Book("Harry Potter", "Fantasy", 18.35f);
        store.addMedia(book);
        
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
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Shinosuke", "Animation", 20.55f);
        store.addMedia(dvd7);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Howl's Moving Castle", "Animation", 15.29f);
        store.addMedia(dvd8);
        
        Track track1 = new Track("The 1", 143);
        cd.addTrack(track1);
        Track track2 = new Track("Betty", 354);
        cd.addTrack(track2);
        Track track3 = new Track("Seven", 437);
        cd.addTrack(track3);
    }
	
	public static void showMenu() {
		System.out.println("\n\nAIMS: ");
		System.out.println("-------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-------------------------------");
		System.out.print("Please choose a number: 0-1-2-3: ");
	}
	
	public static void storeMenu() throws PlayerException {
		System.out.println("\n\nOptions: ");
		System.out.println("---------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("---------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4: ");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		scanner.nextLine();
		
		switch (option) {
		case 1:
			// See a media's details
			System.out.print("Enter the title of the media: ");
			String titleDetails = scanner.nextLine();
			Media mediaDetails = store.searchByTitle(titleDetails);
			if (mediaDetails != null) {
				System.out.println(mediaDetails.toString());
				mediaDetailsMenu(scanner, mediaDetails);
			} else {
				System.out.println("Media not found!");
			}
			break;
		case 2:
			// Add a media to cart
			store.printStore();
			System.out.print("Enter the title of the media: ");
			String titleAdd = scanner.nextLine();
			Media mediaAdd = store.searchByTitle(titleAdd);
			if (mediaAdd != null) {
				cart.addMedia(mediaAdd);
				cart.countDVDs();
			} else {
				System.out.println("Media not found!");
			}
			break;
		case 3:
			// Play a media
			System.out.print("Enter the title of the media: ");
			String titlePlay = scanner.nextLine();
			Media mediaPlay = store.searchByTitle(titlePlay);
			PlayMedia(mediaPlay);
			break;
		case 4:
			// See current cart
			cartMenu();
			break;
		case 0:
			break;
		default :
			System.out.println("Invalid option. Please choose a number: 0-1-2-3-4: ");
		}
	}
	
	public static void mediaDetailsMenu(Scanner scanner, Media mediaDetails) throws PlayerException {
		System.out.println("\n\nOptions: ");
		System.out.println("------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.print("Please choose a number: 0-1-2: ");
		
		int option = scanner.nextInt();
		scanner.nextLine();
		
		switch (option) {
		case 1:
			// Add to cart
			cart.addMedia(mediaDetails);
			break;
		case 2:
			// Play
			PlayMedia(mediaDetails);
			break;
		case 0:
			break;
		default :
			System.out.println("Invalid option. Please choose a number: 0-1-2-3-4: ");
		}
	}
	
	public static void updateStore() {
		System.out.println("\n\nOptions: ");
		System.out.println("------------------------------");
		System.out.println("1. Add a media to the store");
		System.out.println("2. Remove a media from the store");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.print("Please choose a number: 0-1-2: ");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		scanner.nextLine();
		
		switch (option) {
		case 1:
			// Add a media
			System.out.print("Enter category (1) Book, (2) CD, (3) DVD: ");
			int category = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Enter media title: ");
            String mediaTitle = scanner.nextLine();
            System.out.print("Enter media category: ");
            String mediaCategory = scanner.nextLine();
            System.out.print("Enter media cost: ");
            Float mediaCost = scanner.nextFloat();
            scanner.nextLine();
			
			if (category == 1) {
				// Book
                Book newBook = new Book(mediaTitle, mediaCategory, mediaCost);
                store.addMedia(newBook);
			} else if (category == 2) {
				// CD
	            System.out.print("Enter media artist: ");
	            String cdArtist = scanner.nextLine();
	            
	            CompactDisc newCD = new CompactDisc(mediaTitle, mediaCategory, cdArtist, mediaCost);
	            // Track
	            System.out.print("Enter track number: ");
	            int track = scanner.nextInt();
	            scanner.nextLine();
	            for (int i = 0; i < track; i++) {
	            	System.out.println("Track " + (i+1) + ": ");
	            	System.out.print("Enter track title: ");
	            	String trackTitle = scanner.nextLine();
		            System.out.print("Enter track length: ");
		            int trackLength = scanner.nextInt();
		            scanner.nextLine();
		            
		            Track newTrack = new Track (trackTitle, trackLength);
		            newCD.addTrack(newTrack);
	            }
	            store.addMedia(newCD);
			} else if (category == 3) {
				// DVD
				System.out.print("Enter media director: ");
	            String dvdDirector = scanner.nextLine();
	            System.out.print("Enter media length: ");
	            Float dvdLength = scanner.nextFloat();
	            scanner.nextLine();
	            
				DigitalVideoDisc newDVD = new DigitalVideoDisc(mediaTitle, mediaCategory,
									dvdDirector, dvdLength);
				store.addMedia(newDVD);
			} else
				System.out.println("Invalid option. Please choose a number: 1-2-3: ");
			break;
		case 2:
			// Remove a media
			System.out.print("Enter the title of the media: ");
			String titleRemove = scanner.nextLine();
			Media mediaRemove = store.searchByTitle(titleRemove);
			if (mediaRemove != null)
				store.removeMedia(mediaRemove);
			else
				System.out.println("Media not found!");
			break;
		case 0:
			break;
		default :
			System.out.println("Invalid option. Please choose a number: 0-1-2-3-4: ");
		}
	}
	
	public static void cartMenu() throws PlayerException {
		cart.printCart();
		System.out.println("\n\nOptions: ");
		System.out.println("-----------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("-----------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4-5: ");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		scanner.nextLine();
		
		switch (option) {
		case 1:
			// Filter media in cart
			System.out.print("Filter media by id (1), by title (2): ");
			int filter = scanner.nextInt();
			if (filter == 1) {
				int id = scanner.nextInt();
				System.out.println(cart.searchByID(id));
			} else if (filter == 2) {
				String title = scanner.nextLine();
				System.out.println(cart.searchByTitle(title));
			} else
				System.out.print("Please choose a number: 1-2: ");
			break;
		case 2:
			// Sort media in cart
			System.out.print("Filter media by title (1), by cost (2): ");
			int sort = scanner.nextInt();
			scanner.nextLine();
			if (sort == 1) {
				cart.sortByTitle();
			} else if (sort == 2) {
				cart.sortByCost();
			} else
				System.out.print("Please choose a number: 1-2: ");
			break;
		case 3:
			// Remove media from cart
			System.out.print("Enter the title of the media: ");
			String titleRemove = scanner.nextLine();
			Media mediaRemove = cart.searchByTitleRemove(titleRemove);
			if (mediaRemove != null)
				cart.removeMedia(mediaRemove);
			else
				System.out.println("Media not found!");
			break;
		case 4:
			// Play a media
			System.out.print("Enter the title of the media: ");
			String titlePlay = scanner.nextLine();
			Media mediaPlay = cart.searchByTitle(titlePlay);
			PlayMedia(mediaPlay);
			break;
		case 5:
			// Place order
			cart.placeOrder();
			break;
		case 0:
			break;
		default :
			System.out.println("Invalid option. Please choose a number: 0-1-2-3-4-5: ");
		}
	}
	
	public static void PlayMedia(Media media) throws PlayerException {
		if (media != null) {
			if (media instanceof DigitalVideoDisc) {
				System.out.println(((DigitalVideoDisc) media).play());
			} else if (media instanceof CompactDisc) {
				System.out.println(((CompactDisc) media).play());
			} else {
				System.out.println("Can't play this media!");
			}
		} else {
			System.out.println("Media not found!");
		}
	}
	
	public static void main(String[] args) throws PlayerException {
		
		Scanner scanner = new Scanner(System.in);
		
		mediaInStore();
		
        while (true) {
        	showMenu();
        	int option = scanner.nextInt();
        	switch (option) {
        		case 1:
        			storeMenu();
        			break;
        		case 2:
        			updateStore();
        			break;
        		case 3:
        			cartMenu();
        			break;
        		case 0:
        			System.exit(0);
    			default :
        			System.out.print("Invalid option. Please choose a number: 0-1-2-3");
        	}
        }
    }
}
