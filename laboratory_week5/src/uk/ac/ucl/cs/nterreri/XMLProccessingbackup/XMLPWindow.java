package uk.ac.ucl.cs.nterreri.XMLProccessingbackup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class XMLPWindow {

	private JFrame frame;
	//MenuBar and options:
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnNewMenu;
	private JMenuItem mntmVerify;
	//JSplitPane with two text areas:
	private JSplitPane splitPane;
	private JTextArea textArea_l;
	private JTextArea textArea_r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XMLPWindow window = new XMLPWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public XMLPWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 432);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		mnNewMenu = new JMenu("Validate");
		menuBar.add(mnNewMenu);
		
		mntmVerify = new JMenuItem("Verify");
		mnNewMenu.add(mntmVerify);
		frame.getContentPane().setLayout(null);
		
		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setBounds(0, 0, 730, 382);
		frame.getContentPane().add(splitPane);
		
		textArea_l = new JTextArea();
		splitPane.setLeftComponent(textArea_l);
		
		textArea_r = new JTextArea();
		textArea_r.setEnabled(false);
		textArea_r.setEditable(false);
		splitPane.setRightComponent(textArea_r);
		
	
		splitPane.setDividerLocation(1.0);
	}
}
