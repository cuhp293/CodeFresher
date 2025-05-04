package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store();
				
		// Create new DVD objects and add them to the store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
				
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Ponyo", "Animation", 24.55f);
		store.addMedia(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Conan", "Animation", 18.29f);
        store.addMedia(dvd5);
        
        // Remove DVD from the store
        store.removeMedia(dvd2);
	}
}
