package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 10000;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	// Add Media
	public void addMedia(Media media) {
		if (itemsInStore.size() < MAX_NUMBERS_IN_STORE) {
			itemsInStore.add(media);
			System.out.println("The media has been added.");
			return;
		} else {
			System.out.println("The store is almost full.");
		}
	}
		
	// Remove Media
	public void removeMedia (Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media has been removed.");
		} else {
			System.out.println("The media is not in the store.");
		}
	}
	
	// Print the list of items of the store
    public void printStore() {
        if (itemsInStore.size() == 0) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("\n\n********************MEDIA IN STORE**********************");
            for (Media media : itemsInStore) {
                System.out.println(media.toString());
            }
            System.out.println("********************************************************");
        }
    }

    // Search media by title and display the result
    public Media searchByTitle(String title) {
		for (Media media : itemsInStore) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}
    
}
