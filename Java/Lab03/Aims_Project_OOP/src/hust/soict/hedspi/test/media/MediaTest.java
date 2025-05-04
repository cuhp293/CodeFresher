package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class MediaTest {
    
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Create some media
        CompactDisc cd = new CompactDisc("Folklore", "Taylor Swift", 300.64f);
        mediae.add(cd);
        
        Book book = new Book("Harry Potter", "Fantasy", 18.35f);
        mediae.add(book);
        
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation",
        		"Roger Allers", 87, 19.95f);
        mediae.add(dvd);
        
        Track track1 = new Track("The 1", 143);
        cd.addTrack(track1);
        Track track2 = new Track("Betty", 354);
        cd.addTrack(track2);
        Track track3 = new Track("Seven", 437);
        cd.addTrack(track3);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
    
}