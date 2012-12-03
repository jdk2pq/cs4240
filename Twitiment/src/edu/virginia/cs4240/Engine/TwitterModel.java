package edu.virginia.cs4240.Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.virginia.cs4240.Engine.Search;
import edu.virginia.cs4240.Engine.Tweet;

public class TwitterModel {

	Search search; //is this a "facade"?
	AnalysisStrategy emoticonAnalyzer = new EmoticonStrategy();
	AnalysisStrategy nonEmoticonAnalyzer = new NonEmoticonStrategy();
	int globalScore =0;
	private ArrayList<String> emotes;
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
	
	public void reset() {
		
	}
	
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
				System.out.println(globalScore);
		}
		
	
	
	public ArrayList<Tweet> getTweets() {
		return this.search.getTweets();
	}

	public int getGlobalScore() {
		return globalScore;
	}	
}

