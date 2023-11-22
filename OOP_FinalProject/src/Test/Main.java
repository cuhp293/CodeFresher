package Test;

import java.util.ArrayList;
import java.util.List;

import Final.Tweet;
import Final.Blog;
import Final.Collection;

public class Main {
	public static void main(String[] args) {
		List<Collection> collections = new ArrayList<>();
	    collections.add(new Collection(100, 600));
	    collections.add(new Collection(500, 1200));
	    collections.add(new Collection(20, 700));
        
//      Tweet.sortByLike(tweets);
//      Tweet.sortByShare(tweets);
//      Tweet.sortByComment(tweets);
//      Blog.sortByView(blogs);
	    Collection.sortByPrice(collections);
//	    Collection.sortByTransaction(collections);
	}
}