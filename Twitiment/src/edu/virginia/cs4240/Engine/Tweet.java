package edu.virginia.cs4240.Engine;
import twitter4j.Status;

public class Tweet {
	private String userName;
	private String status;
	private Boolean posOrNeg;
	private Sentiment sentiment;
	
	public Tweet(Status status) {
		this.userName = status.getUser().getName();
		this.status = status.getText();
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

	public boolean isPosOrNeg() {
		return posOrNeg;
	}

	public void setPosOrNeg(boolean posOrNeg) {
		this.posOrNeg = posOrNeg;
	}
}
