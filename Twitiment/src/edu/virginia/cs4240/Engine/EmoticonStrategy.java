/**
 * Implementation of AnalysisStrategy Interface to analyze tweets for Emoticons
 * This is a part of a strategy design implementation.
 * 
 * @author Jake
 */
package edu.virginia.cs4240.Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmoticonStrategy implements AnalysisStrategy {

	private String posFile = "posEmotes.txt";
	private String negFile = "negEmotes.txt";
	private ArrayList<String> negative = new ArrayList<String>();
	private ArrayList<String> positive = new ArrayList<String>();
	
	
	public EmoticonStrategy() {
		populateLists();
	}

	@Override
	public int performAnalysis(Tweet tweet) {
		String[] words = tweet.getStatus().split(" ");
		Sentiment sentiment = new Sentiment();
		tweet.setSentiment(sentiment);
		
		for (int i = 0; i < words.length; i++) {
			if(negative.contains(words[i])){
				sentiment.decrease(1);
			}
			if(positive.contains(words[i])){
				sentiment.increase(1);
			}
		}	
		return sentiment.getScore();
	}

	public void populateLists() {
		Scanner scanNeg, scanPos;
		try {
			scanNeg = new Scanner(new File(negFile));
			scanPos = new Scanner(new File(posFile));
			while (scanNeg.hasNextLine()) {
				this.getNegative().add(scanNeg.nextLine());
			}
			while (scanPos.hasNextLine()) {
				this.getPositive().add(scanPos.nextLine());
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getNegative() {
		return this.negative;
	}

	public ArrayList<String> getPositive() {
		return this.positive;
	}
	

}
