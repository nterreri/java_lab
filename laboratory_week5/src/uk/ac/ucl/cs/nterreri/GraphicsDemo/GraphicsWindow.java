package uk.ac.ucl.cs.nterreri.GraphicsDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

class GraphicsWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3136489356466726967L;
	private DrawingPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicsWindow frame = new GraphicsWindow();
					frame.setVisible(true);

					frame.contentPane.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraphicsWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			
			//overridden windowClosing to stop the timer instance:
			@Override
			public void windowClosing(WindowEvent e) {
				contentPane.timer.stop();
				dispose();
			}
			
		});
		setBounds(100, 100, 900, 600);
		contentPane = new DrawingPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
	}

}
