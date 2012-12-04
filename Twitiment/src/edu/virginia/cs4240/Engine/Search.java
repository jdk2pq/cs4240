/**
 * This class serves as an Facade class to Twitter4J's Library.
 * This class provides mainly search functions from said Library.
 * 
 * @author Jake
 */
package edu.virginia.cs4240.Engine;
import java.util.ArrayList;
import twitter4j.*;

public class Search {
	private String searchTerm;
	private Query query;
	private QueryResult results;
	private java.util.List<Status> statuses;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
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
	 * @exception TwitterException search could not be preformed.
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
	 * adapts Twitter4J's Status class to our own Tweet adapter class.
	 */
	private void transformResults() {
		this.setStatuses(results.getTweets());
		for (Status status : this.statuses) {
			Tweet tweet = new Tweet(status);
			tweets.add(tweet);
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
