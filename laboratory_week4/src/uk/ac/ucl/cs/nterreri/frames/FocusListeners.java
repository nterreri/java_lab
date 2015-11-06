package uk.ac.ucl.cs.nterreri.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import javax.swing.ImageIcon;

/**
 * 
 * @author nterreri
 *
 */
class FocusListeners extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3418873522747022178L;
	private JPanel contentPane;
	//accessible to a FocusListener instance:
	static JLabel lblTarget;
	private JButton btnAButton;
	private JComboBox<String> comboBox;
	private JRadioButton rdbtnARadioButton;
	private FocusListener focusListener;
	private JLabel lblALabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FocusListeners frame = new FocusListeners();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FocusListeners() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Instantiating the focuslistener object:
		focusListener = new FocusListener();
		//This is then registered to each component:
		
		//Labels do not trigger the FocusEvent because there is no
		//focusing over labels, so registering the listener to them
		//does not change anything
		lblTarget = new JLabel("");
		lblTarget.addFocusListener(focusListener);
		lblTarget.setName("This label");
		contentPane.add(lblTarget, BorderLayout.CENTER);

		
		btnAButton = new JButton("a button");
		btnAButton.addFocusListener(focusListener);
		btnAButton.setName("a button");
		contentPane.add(btnAButton, BorderLayout.WEST);
		
		comboBox = new JComboBox<String>();
		comboBox.addFocusListener(focusListener);
		comboBox.setName("a combobox");
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		rdbtnARadioButton = new JRadioButton("a radio button");
		rdbtnARadioButton.addFocusListener(focusListener);
		rdbtnARadioButton.setName("a radio button");
		contentPane.add(rdbtnARadioButton, BorderLayout.SOUTH);
		
		lblALabel = new JLabel();
		lblALabel.setIcon(new ImageIcon("/home/nterreri/Downloads/generic_scaled.jpg"));
		lblALabel.setText("a label");
		lblALabel.addFocusListener(focusListener);
		contentPane.add(lblALabel, BorderLayout.EAST);
	}

}
