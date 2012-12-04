/**
 * This class serves as an Facade class to Twitter4J's Library.
 * This class provides mainly search functions from said Library.
 * 
 * @author Jake
 */
package edu.virginia.cs4240.Engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import twitter4j.*;

public class Search {
	private String searchTerm;
	private Query query;
	private QueryResult results;
	private java.util.List<Status> statuses;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<String> emotes;
	private AnalysisStrategy emoticonAnalyzer = new EmoticonStrategy();
	private AnalysisStrategy nonEmoticonAnalyzer = new NonEmoticonStrategy();
	
	/**
	 * Constructor to perform a new search. Takes a String searchTerm and creates a
	 * Query instance of that searchTerm.
	 * @param searchTerm  The searchTerm to use when querying Twitter
	 */
	public Search(String searchTerm) {
		this.setSearchTerm(searchTerm);
		this.setQuery(new Query(searchTerm));
		this.performSearch();
	}
	
	/**
	 * Performs search on given search term. First, sets the result count to 100,
	 * then, tries to perform the search by querying the twitter instance. If a search
	 * cannot be performed, a TwitterException is thrown and caught.
	 * 
	 * @exception TwitterException search could not be performed.
	 */
	private void performSearch() {
		this.getQuery().setCount(100);
		Twitter twitter = new TwitterFactory().getInstance();
		try {
			this.setResults(twitter.search(query));
			this.transformResults();
		} catch (TwitterException e) {
			System.out.println("Could not perform search. Are you connected to the Web?");
		}
	}
	
	/**
	 * Transforms results from List<Status> to an ArrayList of Tweets. Basically, this
	 * adapts Twitter4J's Status class to our own Tweet class.
	 */
	private void transformResults() {
		Tweet tweet;
		this.setStatuses(results.getTweets());
		for (Status status : this.statuses) {
			if (this.tweetContainsEmoticons(status)) {
				tweet = new Tweet(status, emoticonAnalyzer);
			}
			else {
				tweet = new Tweet(status, nonEmoticonAnalyzer);
			}
			tweets.add(tweet);
		}
	}
	
	/**
	 * Checks to see if the specified tweet contains an emoticon.
	 * @param status
	 * @return true if there is an emoticon, false otherwise
	 */
	private boolean tweetContainsEmoticons(Status status) {
		this.populateList();
		String[] tweetWords = status.getText().split(" ");
		for (String word : tweetWords) {
			if (this.emotes.contains(word)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Populates the list of emoticons.
	 */
	private void populateList() {
		Scanner scanner;
		this.emotes = new ArrayList<String>();
		try {
			scanner = new Scanner(new File("negEmotes.txt"));
			while (scanner.hasNextLine()) {
				this.emotes.add(scanner.nextLine());
			}
			scanner = new Scanner(new File("posEmotes.txt"));
			while (scanner.hasNextLine()) {
				this.emotes.add(scanner.nextLine());
			}	
		} catch (FileNotFoundException e) {
			System.out.println("I couldn't find the file!");
		}		
	}

	/**
	 * Gets the Tweets
	 * @return tweets
	 */
	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	/**
	 * Sets the tweets
	 * @param tweets
	 */
	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	/**
	 * Gets the statuses
	 * @return statuses
	 */
	public java.util.List<Status> getStatuses() {
		return statuses;
	}

	/**
	 * sets the statuses
	 * @param statuses
	 */
	public void setStatuses(java.util.List<Status> statuses) {
		this.statuses = statuses;
	}

	/**
	 * gets the Search term
	 * @return searchTerm
	 */
	public String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * sets the Search Term
	 * @param searchTerm
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	/**
	 * Gets the query
	 * @return query
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * Sets the query
	 * @param query
	 */
	public void setQuery(Query query) {
		this.query = query;
	}

	/**
	 * Gets the results
	 * @return results
	 */
	public QueryResult getResults() {
		return results;
	}

	/**
	 * Sets the results
	 * @param results
	 */
	public void setResults(QueryResult results) {
		this.results = results;
	}

	/**
	 * Gets a single tweet at specified index i.
	 * @param i the specified index
	 * @return tweet
	 */
	public Tweet getSingleTweet(int i) {
		return this.getTweets().get(i);
	}
}
