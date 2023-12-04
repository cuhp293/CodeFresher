package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	
	// Create constructor method
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category, float cost) {
		setTitle(title);
		setCategory(category);
		setCost(cost);
		setId(nbMedia);
		nbMedia++;
	}

	// Add author
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("The author is already in the list.");
			return;
		} else {
			authors.add(authorName);
			System.out.println("The author has been added.");
		}
	}
	
	// Remove author
	public void removeAuthor (String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("The author has been removed.");
		} else {
			System.out.println("The author is not in the list.");
		}
	}
	
	@Override
	public String toString() {
		return (getId() + 1) + ". Book - " + this.getTitle() + " - " + this.getCategory()
				+ ": " + this.getCost() + "$\n";
	}

	// Create accessor and mutator
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

}
