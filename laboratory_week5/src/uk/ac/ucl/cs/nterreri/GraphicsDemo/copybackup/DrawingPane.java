package uk.ac.ucl.cs.nterreri.GraphicsDemo.copybackup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingPane extends JPanel implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//nothing for the moment

	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//diameter is 10% of smallest between height and width
		Dimension paneSize = getSize();
		int diameter = (Math.min(paneSize.width, paneSize.height))/10;
		
		//Antialiasing on:
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLUE);
		//g2.drawOval(0, getHeight()/2, diameter, diameter);//optional:drawing border
		g2.fillOval(0, getHeight()/2, diameter, diameter);
	}

}
