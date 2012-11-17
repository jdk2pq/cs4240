package edu.cs4240.Engine;
import java.awt.List;
import java.util.ArrayList;

import twitter4j.*;

public class Search {
	private String searchTerm;
	private Query query;
	private QueryResult results;
	private java.util.List<Status> statuses;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public Search(String searchTerm) {
		this.searchTerm = searchTerm;
		this.query = new Query(searchTerm);
	}
	
	/**
	 * Performs search on given search term.
	 */
	public void performSearch() {
		query.setCount(100);
		Twitter twitter = new TwitterFactory().getInstance();
		try {
			this.results = twitter.search(query);
		} catch (TwitterException e) {
			System.out.println("Could not perform search");
		}
	}
	
	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	/**
	 * Transforms results from List<Status> to an ArrayList of Tweets.
	 */
	public void transformResults() {
		this.setStatuses(results.getTweets());
		for (Status status : this.statuses) {
			Tweet tweet = new Tweet(status);
			tweets.add(tweet);
		}
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
}
