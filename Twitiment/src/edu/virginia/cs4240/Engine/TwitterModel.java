package edu.virginia.cs4240.Engine;

import java.util.ArrayList;

import edu.virginia.cs4240.Engine.Search;
import edu.virginia.cs4240.Engine.Tweet;
import edu.virginia.cs4240.Engine.TweetAnalyzer;

public class TwitterModel {

	Search search; //is this a "flacade"?
	TweetAnalyzer analyzer;
	
	public TwitterModel() {
		reset();
	}
	
	public void reset() {
		
	}
	
	public void query(String q) {
		this.search = new Search(q);
		for (int i = 0; i < search.getTweets().size(); i++) {
			this.analyzer = new TweetAnalyzer(search.getSingleTweet(i));
		}
	}
	
	public ArrayList<Tweet> getTweets() {
		return this.search.getTweets();
	}
	
}





//Search search = new Search("Obama"); //example
//	search.performSearch();
//search.transformResults();
//for (Tweet tweet : search.getTweets()) {
  //  System.out.println("@" + tweet.getUserName() + " said " + tweet.getStatus());
//}