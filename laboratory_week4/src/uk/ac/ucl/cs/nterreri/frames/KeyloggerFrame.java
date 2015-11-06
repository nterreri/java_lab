package uk.ac.ucl.cs.nterreri.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Frame to demonstrate keylogging.
 * This frame logs text typed in a JTextArea on the left, and on
 * a file named "keylog" inside the executable's root folder.
 * 
 * @author nterreri
 *
 */
class KeyloggerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8187551851812798311L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextArea txtrTypeHere;
	private FileWriter os;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					KeyloggerFrame frame = new KeyloggerFrame();
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
	public KeyloggerFrame() {
		//Initialize frame:
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Initialize file keylogger:
		try {
			//keylogger appends typed chars to keylog file:
			os = new FileWriter("keylog", true);
			os.append('\n');
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error accessing file");
		}
		
		//Initialize pane:
		JSplitPane splitPane = new JSplitPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		splitPane.setDividerLocation(200);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
		);
		
		//Initialize label:
		lblNewLabel = new JLabel("");
		splitPane.setLeftComponent(lblNewLabel);
		
		//Initialize textarea (with keytyped listener:)
		txtrTypeHere = new JTextArea();
		txtrTypeHere.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				update_label(e.getKeyChar());
				log_to_file(e.getKeyChar());
				
			}
		});
		txtrTypeHere.setToolTipText(" - type here -");
		splitPane.setRightComponent(txtrTypeHere);
		contentPane.setLayout(gl_contentPane);
	}

	
	void update_label(char typed) {
		lblNewLabel.setText(lblNewLabel.getText() + typed);
	}
	
	void log_to_file(char key) {
		try {
			os.append(key);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not write to file");
		}
		
	}
}
