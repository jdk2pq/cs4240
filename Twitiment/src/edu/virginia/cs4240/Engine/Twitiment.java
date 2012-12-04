/**
 * Main Client class for Twitiment, creates the model view controller interface and starts off the application.
 * 
 * @author Josh
 */
package edu.virginia.cs4240.Engine;

import edu.virginia.cs4240.GUI.MainJFrame;

public class Twitiment {

	public static void main(String[] args) {
		TwitterModel model = new TwitterModel();
		MainJFrame view = new MainJFrame(model);
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
		view.setVisible(true);
	}

}
