package uk.ac.ucl.cs.nterreri.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

/**
 * MouseMotionAdapter extension implementing mouseDragged(MouseEvent).
 * Used in MouseListening.
 * 
 * @author nterreri
 *
 */
public class MouseListener extends MouseMotionAdapter{
	
	@Override
	/**
	 * The implemented method calls a static method of MouseListening
	 * to change the position of a JComponent.
	 */
	public void mouseDragged(MouseEvent e){
		MouseListening.update_coords((JComponent) e.getSource(), e.getX(), e.getY());
	}
}
