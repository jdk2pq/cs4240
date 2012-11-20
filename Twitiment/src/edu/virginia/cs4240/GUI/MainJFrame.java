package edu.virginia.cs4240.GUI;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;



import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
	private JTextField QueryJTextField;
	private JButton SearchJButton;


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
		
	public MainJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setTitle("Search Tweets");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				SearchJButton = new JButton();
				AnchorLayout SearchJButtonLayout = new AnchorLayout();
				SearchJButton.setLayout(SearchJButtonLayout);
				getContentPane().add(SearchJButton, new AnchorConstraint(570, 986, 674, 701, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				SearchJButton.setText("Search");
				SearchJButton.setPreferredSize(new java.awt.Dimension(114, 29));
				SearchJButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						SearchJButtonMouseClicked(evt);
					}
				});
			}
			{
				QueryJTextField = new JTextField();
				getContentPane().add(QueryJTextField, new AnchorConstraint(422, 1001, 526, 6, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_ABS));
				QueryJTextField.setPreferredSize(new java.awt.Dimension(394, 29));
				QueryJTextField.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						QueryJTextFieldKeyPressed(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void SearchJButtonMouseClicked(MouseEvent evt) {
		if(!(QueryJTextField.getText().isEmpty()))
			notifyController();
	}
	
	private void QueryJTextFieldKeyPressed(KeyEvent evt) {
		if((evt.getKeyCode()==10) && (!(QueryJTextField.getText().isEmpty())))
			notifyController();
	}
	
	private void notifyController(){
		
	
	}

}
