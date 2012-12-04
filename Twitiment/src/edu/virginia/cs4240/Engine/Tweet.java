/**
 * Tweet class. Adapts the Twitter4J Status class to something more relevant (only needing
 * a userName and actual text of the status) and easier to use.
 * @author Jake
 */
package edu.virginia.cs4240.Engine;
import twitter4j.Status;

public class Tweet {
	private String userName;
	private String status;
	private Sentiment sentiment = new Sentiment();
	
	/**
	 * The constructor for a Tweet. Takes a Twitter4J Status and sets the Tweet's userName
	 * and status fields. Slims down and adapts the Status class, as this is the only information we would
	 * like to work with at the moment, in addition to the Tweet's sentiment.
	 * @param status - a Twitter4J Status class to use in constructing the Tweet
	 */
	public Tweet(Status status) {
		this.setUserName(status.getUser().getName());
		this.setStatus(status.getText());
	}
	
	/**
	 * Returns the reason of the sentiment of a tweet.
	 * 
	 * @return sentiment description
	 */
	public String getReason() {
		return this.sentiment.getReason();
	}

	/**
	 * Returns the sentiment of a tweet.
	 * 
	 * @return sentiment
	 */
	public Sentiment getSentiment() {
		return sentiment;
	}

	/**
	 * Sets sentiment of a tweet.
	 * 
	 * @param sentiment2
	 */
	public void setSentiment(Sentiment sentiment2) {
		this.sentiment = sentiment2;
	}

	/**
	 * Get the user name associated with a tweet.
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Set the user name associated with a tweet.
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get the status of a tweet.
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of a tweet.
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get Sentiment score of a tweet.
	 * 
	 * @return score
	 */
	public int getScore() {
		return this.getSentiment().getScore();
	}
}
