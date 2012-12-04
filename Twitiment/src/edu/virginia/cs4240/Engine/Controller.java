/**
 * The Controller class is apart of a MVC design and is responsible for interacting with the model and view.
 * 
 * @author Josh
 */



package edu.virginia.cs4240.Engine;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.virginia.cs4240.GUI.MainJFrame;
import edu.virginia.cs4240.GUI.ResultsJFrame;

public class Controller {

	private TwitterModel model;
	private MainJFrame view;

	/**
	 * The Constructor for Controller. It takes in a model and view so as to interact with the two compomenents.
	 * This constructor also adds action listeners so that it can tell when the user submits a query.
	 * 
	 * @param m the model
	 * @param v the view
	 */
	public Controller(TwitterModel m, MainJFrame v){
		model = m;
		view = v;
		
		view.addKeyListener(new KeyListener());
		view.addButtonListener(new ButtonListener());
	}
	
	/**
	 * The Search method utilizes the model to search a query from the view when the user submits a search.
	 * It then creates the results frame by passing it all of the tweets and sets it to visible.
	 * 
	 */
	private void Search(){
		model.query(view.getQuery());
		ResultsJFrame results = new ResultsJFrame(model.getGlobalScore(), model.getSentiment());
		results.setVisible(true);
	}
	
	/**
	 * Inner class KeyListener
	 * 
	 * Listens for key pressed on the view and then calls Search.
	 * @author Josh
	 *
	 */
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
		
	}
	
	/**
	 * Inner class Button Listener
	 * 
	 * Listens for mouse button pressed on the view and then calls Search.
	 * @author Josh
	 *
	 */

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
		
	}
	
	
}
