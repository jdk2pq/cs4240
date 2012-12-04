/**
 * Implementation of AnalysisStrategy Interface to analyze tweets by looking through a list of good and bad words
 * This is a part of a Strategy Design Implementation.
 * 
 * @author Jake
 */
package edu.virginia.cs4240.Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NonEmoticonStrategy implements AnalysisStrategy {
	
	private String posFile = "Positive.txt";
	private String negFile = "Negative.txt";
	private ArrayList<String> negative = new ArrayList<String>();
	private ArrayList<String> positive = new ArrayList<String>();
	
	public NonEmoticonStrategy() {
		populateLists();
	}

	@Override
	public int performAnalysis(Tweet tweet) {
		String[] words = tweet.getStatus().split(" ");
		Sentiment sentiment = new Sentiment();
		tweet.setSentiment(sentiment);
		for (int i = 0; i < words.length; i++) {
			if(negative.contains(words[i].toLowerCase())){
				sentiment.decrease(1);
			}
			if(positive.contains(words[i].toLowerCase())){
				sentiment.increase(1);
			}
		}
		
		return sentiment.getScore();
	}

	@Override
	public void populateLists() {
		Scanner scanNeg, scanPos;
		try {
			scanNeg = new Scanner(new File(negFile));
			scanPos = new Scanner(new File(posFile));
			while (scanNeg.hasNextLine()) {
				this.getNegative().add(scanNeg.nextLine().toLowerCase());
			}
			while (scanPos.hasNextLine()) {
				this.getPositive().add(scanPos.nextLine().toLowerCase());
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public ArrayList<String> getNegative() {
		return this.negative;
	}

	@Override
	public ArrayList<String> getPositive() {
		return this.positive;
	}
	


}
