package uk.ac.ucl.cs.nterreri.mole;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * New JDialog extension made from scratch.
 * (Author did not know how to use JOptionPane at the time)
 * 
 * The window created is modal with the MainWindow frame as its parent, so
 * this is inaccessible until the dialog is closed.
 * 
 * @author nterreri
 *
 */
public class NewHighScore extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2669590919924911157L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtLetters;

	private String name = null;


	/**
	 * Create the dialog.
	 */
	public NewHighScore(JFrame parent) {
		
		super(parent, true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewHighScore = new JLabel("New high score:");
			lblNewHighScore.setBounds(5, 105, 114, 15);
			contentPanel.add(lblNewHighScore);
		}
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(137, 100, 114, 26);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			txtLetters = new JTextField();
			txtLetters.setToolTipText("- 3 letters -");
			txtLetters.setBounds(137, 175, 114, 19);
			
			//This actionlistener looks for the first three letters entered
			//in the textbox where the name of the player who scored the new
			//high score should go.
			//After this happens, the window is disposed of.
			txtLetters.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GameScore.name = txtLetters.getText().substring(0, 3).toUpperCase();
					dispose();
					}
				
			});
			contentPanel.add(txtLetters);
			txtLetters.setColumns(10);
		}
		{
			JLabel lblEnterName = new JLabel("Enter name:");
			lblEnterName.setBounds(5, 177, 114, 15);
			contentPanel.add(lblEnterName);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				//equivalent action listeners are registered to both the
				//"OK" button and pressing enter on the textfield
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GameScore.name = txtLetters.getText().substring(0, 3).toUpperCase();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				//Pressing cancel the score is not saved
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
							
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Getter for private field name.
	 */
	public String getName(){
		return name;
	}

}
