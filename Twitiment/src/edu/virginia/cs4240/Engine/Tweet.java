/**
 * Tweet class. Adapts the Twitter4J Status class to something more relevant (only needing
 * a userName and actual text of the status) and easier to use.
 */
package edu.virginia.cs4240.Engine;
import twitter4j.Status;

public class Tweet {
	private String userName;
	private String status;
	private Sentiment sentiment = null;
	
	/**
	 * The constructor for a Tweet. Takes a Twitter4J Status and sets the Tweet's userName
	 * and status fields. Slims down and adapts the Status class, as this is the only information we would
	 * like to work with at the moment, in addition to the Tweet's sentiment.
	 * @param Status status - a Twitter4J Status class to use in constructing the Tweet
	 */
	public Tweet(Status status) {
		this.setUserName(status.getUser().getName());
		this.setStatus(status.getText());
	}

	public String getReason() {
		return this.sentiment.getReason();
	}

	public Sentiment getSentiment() {
		return sentiment;
	}

	public void setSentiment(Sentiment sentiment2) {
		this.sentiment = sentiment2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPositiveOrNegative() {
		if (this.getSentiment().getPositiveOrNegative() == 1) {
			return "positive";
		} else if (this.getSentiment().getPositiveOrNegative() == 0) {
			return "negative";
		} else {
			return "not sure";
		}
	}
}
