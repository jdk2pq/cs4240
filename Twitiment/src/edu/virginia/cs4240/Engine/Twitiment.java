package edu.virginia.cs4240.Engine;

import edu.virginia.cs4240.GUI.MainJFrame;

public class Twitiment {

	public static void main(String[] args) {
	
		TwitterModel model = new TwitterModel();
		MainJFrame view = new MainJFrame(model);
		Controller controller = new Controller(model, view);
		
		view.setVisible(true);
		
	}

}
