package edu.virginia.cs4240.Engine;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.virginia.cs4240.GUI.MainJFrame;
import edu.virginia.cs4240.GUI.ResultsJFrame;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class Controller {

	/**
	 * Controller for analyzing tweets. 
	 */
	private TwitterModel model;
	private MainJFrame view;
	
	public Controller(TwitterModel m, MainJFrame v){
		model = m;
		view = v;
		
		view.addKeyListener(new KeyListener());
		view.addButtonListener(new ButtonListener());
	}
	
	private void Search(){
		model.query(view.getQuery());
		ResultsJFrame results = new ResultsJFrame(model.getTweets());
		results.setVisible(true);
	}
	
	//Inner class Key Listener
	class KeyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(!view.getQuery().isEmpty()){
				try{
					Search();
				}
				catch(Exception ex){
					System.out.println("Error: "+ex);
				}
			}
		}
		
	}//end Inner Class
	
	
	//Inner class Button Listener
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(!view.getQuery().isEmpty()){
				try{
					Search();
				}
				catch(Exception ex){
					System.out.println("Error: "+ex);
				}
			}
		}
		
	}//end Inner Class
	
	
}
