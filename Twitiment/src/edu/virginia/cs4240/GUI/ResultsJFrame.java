package edu.virginia.cs4240.GUI;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import edu.virginia.cs4240.Engine.Tweet;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ResultsJFrame extends javax.swing.JFrame {
	private JTextPane ResultsJTextPane;
	private JScrollPane scrollPane;
	private ArrayList<Tweet> tweets;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public ResultsJFrame(ArrayList<Tweet> t) {
		super();
		tweets = t;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				ResultsJTextPane = new JTextPane();
				String allResults = "";
				for(Tweet t : tweets){
					allResults += t.getUserName() + " said " + t.getStatus() + ". \n";
					allResults += "We think this is " + t.getPositiveOrNegative() + " because " + t.getReason() + ". \n\n";
				}
				ResultsJTextPane.setText(allResults);
				scrollPane = new JScrollPane(ResultsJTextPane);
				
				getContentPane().add(scrollPane, BorderLayout.CENTER);
			}
			pack();
			setSize(800, 800);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
