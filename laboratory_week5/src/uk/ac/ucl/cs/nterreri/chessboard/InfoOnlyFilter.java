package uk.ac.ucl.cs.nterreri.chessboard;

import java.util.logging.*;

public class InfoOnlyFilter implements Filter{
	public boolean isLoggable(LogRecord record) {
		if(record.getLevel() == Level.INFO)
			return true;
		else 
			return false;
	}

}
