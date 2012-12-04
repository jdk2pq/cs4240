/**
 * Stores the sentiment of the Tweet.
 * 
 * @author Jake, Josh
 */
package edu.virginia.cs4240.Engine;

public class Sentiment {
	private int score;
	private String reason;

	/**
	 * Constructor used for Sentiment. The default score is 0, indicating neutral.
	 */
	
	public Sentiment() {
		this.score = 0;
	}

	/**
	 * Increases the sentiment by the amt.
	 * @param amt The amount to increase the sentiment.
	 */
	public void increase(int amt) {
		this.score +=amt;
	}

	/**
	 * Decreases the sentiment by the amt.
	 * @param amt The amount to decrease the sentiment.
	 */
	public void decrease(int amt){
		this.score -=amt;
	}

	/**
	 * Gets the sentiment score of the tweet.
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Gets the reason of a sentiment, if the score is greater than 0 its positive, less than is negative, 0 is neutral.
	 * @return reason
	 */
	public String getReason() {
		if(score>0)
			this.reason= "Positive Tweet";
		else if(score<0)
			this.reason = "Negative Tweet";
		else
			this.reason = "Neutral Tweet";
		
		return reason;
	}

	/**
	 * Sets the reason for the sentiment.
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
