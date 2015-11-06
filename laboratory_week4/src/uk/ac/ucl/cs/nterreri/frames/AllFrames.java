package uk.ac.ucl.cs.nterreri.frames;

import uk.ac.ucl.cs.nterreri.mouse.*;
import java.awt.EventQueue;

/**
 * Entry point, generates all frames.
 * @author nterreri
 *
 */
class AllFrames {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					ComboBox comboFrame = new ComboBox();
					comboFrame.setVisible(true);
					FocusListeners focusFrame = new FocusListeners();
					focusFrame.setVisible(true);
					KeyloggerFrame loggerFrame = new KeyloggerFrame();
					loggerFrame.setVisible(true);
					MouseListening mouseFrame = new MouseListening();
					mouseFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
