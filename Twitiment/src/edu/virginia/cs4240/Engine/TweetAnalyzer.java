/**
 * TweetAnalyzer performs the analysis of sentiment on a given tweet.
 */
package edu.virginia.cs4240.Engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.virginia.cs4240.Engine.Sentiment;

public class TweetAnalyzer {
	private ArrayList<String> sadEmoticons = new ArrayList<String>();
	private ArrayList<String> happyEmoticons = new ArrayList<String>();
	
	/**
	 *  TweetAnalyzer constructor. Populates the lists of emoticons upon instantiation.
	 *  Then calls performAnalysis and checks to see if the tweet contains any sad
	 *  or happy emoticons. Updates the tweet's sentiment accordingly.
	 *  @param Tweet tweet - The tweet to analyze
	 */
	public TweetAnalyzer (Tweet tweet) {
		this.populateEmoticons();
		this.performAnalysis(tweet);
	}

	/**
	 *  Populates the lists of emoticons that will be used in the tweet analysis.
	 */
	private void populateEmoticons() {
		Scanner scanSad, scanHappy;
		try {
			scanSad = new Scanner(new File("sad.txt"));
			scanHappy = new Scanner(new File("happy.txt"));
			while (scanSad.hasNextLine()) {
				this.getSadEmoticons().add(scanSad.nextLine());
			}
			while (scanHappy.hasNextLine()) {
				this.getHappyEmoticons().add(scanHappy.nextLine());
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Performs the actual analysis of the tweets, checking to see if the tweets contain
	 * any of the emoticons in the sad and happy Lists.
	 * @param Tweet tweet - the tweet to perform analysis on
	 */
	private void performAnalysis(Tweet tweet) {
		for (String emoticon : sadEmoticons) {
			if (tweet.getStatus().contains(emoticon)) {
				tweet.setSentiment(new Sentiment(0, emoticon));
			}
		}
		
		for (String emoticon : happyEmoticons) {
			if (tweet.getSentiment() == null && tweet.getStatus().contains(emoticon)) {
				tweet.setSentiment(new Sentiment(1, emoticon));
			}
		}
		
		if (tweet.getSentiment() == null) {
			tweet.setSentiment(new Sentiment());
		}
		
		
	}
	
	public ArrayList<String> getSadEmoticons() {
		return sadEmoticons;
	}

	public ArrayList<String> getHappyEmoticons() {
		return happyEmoticons;
	}
}
