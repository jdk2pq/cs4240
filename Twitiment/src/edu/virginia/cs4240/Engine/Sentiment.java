/**
 * Stores the sentiment of the Tweet.
 */
package edu.virginia.cs4240.Engine;

public class Sentiment {
	private int score;
	private String reason;

	/**
	 * Constructor used for emoticons. The positivity or negativity of the Sentiment is set,
	 * as well as a reason for which our service believes it is positive or negative.
	 * @param boolean positiveOrNegative - true for positive, false for negative
	 * @param String reason - the reason for which we think the tweet is positive or negative
	 */
	
	public Sentiment() {
		this.score = 0;
	}

	public void increase(int amt) {
		this.score +=amt;
	}

	public void decrease(int amt){
		this.score -=amt;
	}


	public int getScore() {
		return score;
	}

	public String getReason() {
		if(score>0)
			this.reason= "Positive Tweet";
		else if(score<0)
			this.reason = "Negative Tweet";
		else
			this.reason = "Neutral Tweet";
		
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
