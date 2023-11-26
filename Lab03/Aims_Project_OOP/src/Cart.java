public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }  
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (int i = 0 ; i < dvdList.length ; i++){
            this.addDigitalVideoDisc(dvdList[i]);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                i--;
                qtyOrdered--; // reduce the number of elements in the array
                System.out.println("The disc has been removed.");
            }
        }
    }

    public void displayCartItems() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-3d %-20s %8f\n", i + 1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }
        System.out.println("Total Cost \t" + totalCost());
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++)
            total += itemsOrdered[i].getCost();
        return total;
    }
}
