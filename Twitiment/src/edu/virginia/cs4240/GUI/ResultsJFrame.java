package edu.virginia.cs4240.GUI;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;


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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane ResultsJTextPane;
	private JScrollPane scrollPane;
	private int score;
	private String reason;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public ResultsJFrame(int s, String r) {
		super();
		score = s;
		reason = r;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				ResultsJTextPane = new JTextPane();
				String result = "This search term has a score of "+ score+" indicating a "+reason+" feel on twitter.";
				ResultsJTextPane.setText(result);
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
