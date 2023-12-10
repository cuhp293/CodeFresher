package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon", "Animation", 21.23f);
        anOrder.addDigitalVideoDisc(dvd4);

        // Remove DVD
        anOrder.removeDigitalVideoDisc(dvd4);

        // Display the cart items
        anOrder.displayCartItems();

        // Print total cost of the items in the cart
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Ponyo", "Animation", 24.55f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Conan", "Animation", 18.29f);
        DigitalVideoDisc[] List = {dvd5, dvd6,};
        anOrder.addDigitalVideoDisc(List);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Shinosuke", "Animation", 20.55f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Howl's Moving Castle", "Animation", 15.29f);
        anOrder.addDigitalVideoDisc(dvd7, dvd8);
    }
}
