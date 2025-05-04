package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Media {
	// section 8: add attributes
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    // section 10: create constructor method
    public DigitalVideoDisc() {
	}

    public DigitalVideoDisc(String title) {
		super();
        this.id = Count();
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
        this.id = Count();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
        this.id = Count();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
        this.id = Count();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}

    private int Count() {
        nbDigitalVideoDiscs++;
        return nbDigitalVideoDiscs;
    }
    
    public String toString() {
    	return this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector()
    	 + " - " + this.getLength() + " - " + this.getCost() + "$\n";
    }
    public boolean isMatch(String title) {
    	if (this.title.equals(title))
    		return true;
    	else
    		return false;
    }
    
    public int getId() {
        return id;
    }
    
    // section 9: create accessors and mutators
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }

	// set to change in TestPassingParameter.java
	public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setCost (float cost){
        this.cost = cost;
    }
    public void setLength (int length){
        this.length = length;
    }
    
}
