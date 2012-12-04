/**
 * Twittermodel is the model aspect of the model view controller. It serves as the interface between the mvc and 
 * the twitter4j library. 
 * 
 * @author Josh
 */
package edu.virginia.cs4240.Engine;

import java.util.ArrayList;

public class TwitterModel {

	Search search; 
	int globalScore = 0;

	/**
	 * Constructor TwitterModel initializes a list of emoticons that is used to check if a tweet contains any.
	 */
	public TwitterModel() {
		reset();
	}

	/**
	 * Unused method.
	 */
	public void reset() {

	}

	/**
	 * Query will search the twittersphere given user input. It then selects the appropriate strategy
	 * to determine the sentiment score of a tweet.
	 * 
	 * @param q A search query
	 */
	public void query(String q) {
		this.search = new Search(q);
		for (Tweet tweet : search.getTweets()) {
			globalScore += tweet.performAnalysis();
		}
	}


	/**
	 * Gets the tweets from a search.
	 * @return tweets
	 */
	public ArrayList<Tweet> getTweets() {
		return this.search.getTweets();
	}

	/**
	 * Gets the global sentiment score of a search.
	 * @return globalScore
	 */
	public int getGlobalScore() {
		return globalScore;
	}	
	
	/**
	 * Resets the globalScore to 0 for a new search.
	 */
	public void resetGlobalScore() {
		this.globalScore = 0;
	}	

	/**
	 * Gets the sentiment reason of a search.
	 * @return sentiment
	 */
	public String getSentiment(){
		int s = getGlobalScore();
		if(s>0)
			return "Positive";
		else if(s<0)
			return "Negative";
		else
			return "Neutral";
	}
}

