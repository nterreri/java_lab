package uk.ac.ucl.cs.nterreri.chessboard;

import java.util.logging.*;

public class FormatterRawMessage extends Formatter {
	
	public String format(LogRecord record) {
		return record.getMessage();
	}
}
