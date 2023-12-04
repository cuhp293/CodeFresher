package hust.soict.hedspi.aims.media;

public class Track implements Playable {

	private String title;
	private int length;
	private int nbTrack = 1;
	
	// Create constructor
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
		nbTrack++;
	}
	
	@Override
	public String toString() {
		return (nbTrack + 1) + ".Track - " + this.getTitle() 
				+ " - " + this.getLength();
	}

	// Create getter
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	@Override
    public String play() {
        return "Playing track: " + this.getTitle() + "\nTrack length: " + this.getLength();
    }
	
	@Override
	public boolean equals(Object o) {
		Track tmp = (Track)o;
		if(this.getTitle() == tmp.getTitle() && this.getLength() == tmp.getLength())
			return true;
		else return false;
	}

}
