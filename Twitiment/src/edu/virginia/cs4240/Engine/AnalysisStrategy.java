/**
 * Interface for the analysis strategy to use in analyzing tweets for sentiment.
 * This is a part of a strategy design implementation.
 * 
 * @author Jake
 */

package edu.virginia.cs4240.Engine;

import java.util.ArrayList;

public interface AnalysisStrategy {	
	
	/**
	 * Performs the actual analysis of the tweets for sentiment.
	 * @param tweet  The tweet to perform analysis on
	 * @return score of sentiment
	 */
	public int performAnalysis(Tweet tweet);
	
	/**
	 *  Populates the lists that will be used in the tweet analysis.
	 */
	public void populateLists();
	
	/**
	 * Returns the negative list
	 * @return arraylist of negative entities
	 */
	public ArrayList<String> getNegative();
	
	/**
	 * Returns the positive list
	 * @return arraylist of positive entities
	 */
	public ArrayList<String> getPositive();

}


