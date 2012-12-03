/**
 * Interface for the analysis strategy to use in analyzing tweets for sentiment.
 */

package edu.virginia.cs4240.Engine;

import java.util.ArrayList;

public interface AnalysisStrategy {	
	/**
	 * Performs the actual analysis of the tweets for sentiment.
	 * @param Tweet tweet - the tweet to perform analysis on
	 */
	public int performAnalysis(Tweet tweet);
	
	/**
	 *  Populates the lists that will be used in the tweet analysis.
	 */
	public void populateLists();
	
	/**
	 * Returns the negative list
	 * @return ArrayList<String> negative
	 */
	public ArrayList<String> getNegative();
	
	/**
	 * Returns the positive list
	 * @return ArrayList<String> positive
	 */
	public ArrayList<String> getPositive();

}


