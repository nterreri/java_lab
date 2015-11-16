package uk.ac.ucl.cs.nterreri.GraphicsLearning;
//original:
//package com.zetcode;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Unlike the oracle examples, the component responsible for drawing is a
 * JPanel instead of a JApplet.
 * <p>
 * The JPanel also implements ActionListener. In its default constructor, it
 * register the calling instance as the listener for its Timer field.
 * <p>
 * Its override (implementation) of actionPerformed makes a call to repaint();
 * <p>
 * The method repaint() is inherited from Component (not JComponent) by the 
 * JPanel class. Generally, it adds a region to the "dirty" region lists: those
 * that will be painted over after pending events have been dispatched.
 * <p>
 * Since this particular call is made without arguments, the whole component
 * (here a JPanel) is scheduled for paint-over.
 * <p>
 * This (eventually) produces a call to paintComponent(). This other method is
 * inherited from JComponent (not Component) by JPanel. The override calls
 * super.paintComponent() (as recommended by javadoc). Then calls 
 * a newly defined JPanel extension method: doDrawing(Graphics g).
 * <p>
 * This method does the specific sort of drawing the author is interested in.
 * Altering this method allows for display of the desired result.
 * 
 * @author com.zetcode
 *
 */
@SuppressWarnings("serial")
class Surface extends JPanel implements ActionListener {

    private final int DELAY = 150;
    private Timer timer;

    public Surface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public Timer getTimer() {
        
        return timer;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.blue);

        int w = getWidth();
        int h = getHeight();

        Random r = new Random();

        for (int i = 0; i < 2000; i++) {

            int x = Math.abs(r.nextInt()) % w;
            int y = Math.abs(r.nextInt()) % h;
            g2d.drawLine(x, y, x, y);
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

@SuppressWarnings("serial")
public class PointsEx extends JFrame {

    public PointsEx() {

        initUI();
    }

    private void initUI() {

        final Surface surface = new Surface();
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                PointsEx ex = new PointsEx();
                ex.setVisible(true);
            }
        });
    }
}