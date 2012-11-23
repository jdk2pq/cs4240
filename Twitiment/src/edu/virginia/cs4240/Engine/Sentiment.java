/**
 * Stores the sentiment of the Tweet.
 */
package edu.virginia.cs4240.Engine;

public class Sentiment {
	private int positiveOrNegative;
	private String reason;

	/**
	 * Constructor used for emoticons. The positivity or negativity of the Sentiment is set,
	 * as well as a reason for which our service believes it is positive or negative.
	 * @param boolean positiveOrNegative - true for positive, false for negative
	 * @param String reason - the reason for which we think the tweet is positive or negative
	 */
	public Sentiment(int positiveOrNegative, String reason) {
		this.setPositiveOrNegative(positiveOrNegative);
		this.setReason("the tweet contained the emoticon \"" + reason);
	}

	public void setPositiveOrNegative(int positiveOrNegative) {
		this.positiveOrNegative = positiveOrNegative;
	}

	public Sentiment() {
		this.setPositiveOrNegative(-1);
		this.setReason ("the tweet did not contain an emoticon.");
	}

	public int getPositiveOrNegative() {
		return positiveOrNegative;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
