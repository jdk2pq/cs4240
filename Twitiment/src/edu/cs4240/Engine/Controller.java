package edu.cs4240.Engine;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class Controller {

	/**
	 * Controller for analyzing tweets. 
	 */
	public static void main(String[] args) {
		Search search = new Search("Obama"); //example
		search.performSearch();
		search.transformResults();
	    for (Tweet tweet : search.getTweets()) {
	        System.out.println("@" + tweet.getUserName() + " said " + tweet.getStatus());
	    }
	}

}
