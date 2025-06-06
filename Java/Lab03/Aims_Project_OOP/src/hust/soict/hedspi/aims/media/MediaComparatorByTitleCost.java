package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	
	@Override
	public int compare(Media o1, Media o2) {
		// By title
        int titleCompare = o1.getTitle().compareTo(o2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        
        // By cost
        return Float.compare(o2.getCost(), o1.getCost());
	}
	
}
