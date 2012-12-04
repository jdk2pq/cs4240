package edu.virginia.cs4240.GUI;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import edu.virginia.cs4240.Engine.TwitterModel;


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
public class MainJFrame extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField queryJTextField;
	private JButton searchJButton;
	@SuppressWarnings("unused")
	private TwitterModel model;


	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public MainJFrame(TwitterModel m) {
		super();
		model = m;
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setTitle("Search Tweets");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				searchJButton = new JButton();
				AnchorLayout SearchJButtonLayout = new AnchorLayout();
				searchJButton.setLayout(SearchJButtonLayout);
				getContentPane().add(searchJButton, new AnchorConstraint(570, 986, 674, 701, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				searchJButton.setText("Search");
				searchJButton.setPreferredSize(new java.awt.Dimension(114, 29));
				
			}
			{
				queryJTextField = new JTextField();
				getContentPane().add(queryJTextField, new AnchorConstraint(422, 1001, 526, 6, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_ABS));
				queryJTextField.setPreferredSize(new java.awt.Dimension(394, 29));
			
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    System.out.println("Could not start the GUI for the MainJFrame!");
		}
	}
	
	
	public void reset(){
		queryJTextField.setText("");
	}
	
	public String getQuery(){
		return queryJTextField.getText();
	}
	
	public void addKeyListener(ActionListener k){
		queryJTextField.addActionListener(k);
	}
	
	public void addButtonListener(ActionListener b){
		searchJButton.addActionListener(b);
	}

	


}
