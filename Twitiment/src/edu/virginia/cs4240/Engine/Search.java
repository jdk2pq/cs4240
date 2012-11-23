/**
 * This class serves as an Adapter class to Twitter4J's implementation of searching for tweets.
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
	 * @param String searchTerm - the searchTerm to use when querying Twitter
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
	
	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	public java.util.List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(java.util.List<Status> statuses) {
		this.statuses = statuses;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public QueryResult getResults() {
		return results;
	}

	public void setResults(QueryResult results) {
		this.results = results;
	}

	public Tweet getSingleTweet(int i) {
		return this.getTweets().get(i);
	}
}
