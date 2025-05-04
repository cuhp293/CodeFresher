package hust.soict.hedspi.aims.media;

public class Disc extends Media {

	private String director;
	private int length;
	
	// Create constructor
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	
	public Disc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
		setId(nbMedia);
		nbMedia++;
	}
	
	// Create getter, setter
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}
	

}
