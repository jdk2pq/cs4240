/**
 * Twittermodel is the model aspect of the model view controller. It serves as the interface between the mvc and 
 * the twitter4j library. 
 * 
 * @author Josh
 */

package edu.virginia.cs4240.Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.virginia.cs4240.Engine.Search;
import edu.virginia.cs4240.Engine.Tweet;

public class TwitterModel {

	Search search; 
	AnalysisStrategy emoticonAnalyzer = new EmoticonStrategy();
	AnalysisStrategy nonEmoticonAnalyzer = new NonEmoticonStrategy();
	int globalScore =0;
	private ArrayList<String> emotes;
	
	/**
	 * Constructor TwitterModel initializes a list of emoticons that is used to check if a tweet contains any.
	 */
	public TwitterModel() {
		reset();
		
		Scanner scanner;
		emotes = new ArrayList<String>();
		try {
			scanner = new Scanner(new File("negEmotes.txt"));
			while (scanner.hasNextLine()) {
				emotes.add(scanner.nextLine());
			}
			scanner = new Scanner(new File("posEmotes.txt"));
			while (scanner.hasNextLine()) {
				emotes.add(scanner.nextLine());
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

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
		boolean containEmote = false;
		for (int i = 0; i < search.getTweets().size(); i++) {
			containEmote = false;
			String[] tweetWords = search.getSingleTweet(i).getStatus().split(" ");
			for (String word : tweetWords) {
				if(emotes.contains(word))
					containEmote = true;
			}
				if(containEmote){
					globalScore +=  emoticonAnalyzer.performAnalysis(search.getSingleTweet(i));
				}
				else{
					globalScore +=  nonEmoticonAnalyzer.performAnalysis(search.getSingleTweet(i));
				}
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

