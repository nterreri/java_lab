package uk.ac.ucl.cs.nterreri.frames;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Extending the FocusAdapter abstract class to obtain an instantiable
 * FocusListener object that can be register to various elements on a JFrame.
 * 
 * Used in FocusListener.java for the FocusListener JFrame child.
 */
class FocusListener extends FocusAdapter {

	public FocusListener() { /* does this even need a constructor? */	}
	
	@Override
	public void focusGained(FocusEvent e) {
		FocusListeners.lblTarget.setText(e.getComponent().getName());
	}
}
