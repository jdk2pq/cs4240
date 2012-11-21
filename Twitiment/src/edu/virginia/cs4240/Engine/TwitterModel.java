package edu.virginia.cs4240.Engine;

import java.util.ArrayList;

public class TwitterModel {

	Search search; //is this a "flacade"?
	
	public TwitterModel(){
		reset();
	}
	
	public void reset(){
		
	}
	
	public void query(String q){ //put some of this logic into Controller
		search = new Search(q);
		search.performSearch();
		search.transformResults();
	}
	
	public ArrayList<Tweet> getTweets(){
		return search.getTweets();
	}
	
}





//Search search = new Search("Obama"); //example
//	search.performSearch();
//search.transformResults();
//for (Tweet tweet : search.getTweets()) {
  //  System.out.println("@" + tweet.getUserName() + " said " + tweet.getStatus());
//}