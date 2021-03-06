package uk.ac.ucl.cs.nterreri.XMLProccessing;

import java.util.logging.*;

import uk.ac.ucl.cs.nterreri.chessboard.FormatterRawMessage;

public class RawMessageConsoleHandler extends ConsoleHandler {
	@Override
	public void publish(LogRecord record)
	{
		setFormatter(new FormatterRawMessage());


		try {
			String message = getFormatter().format(record);
			if (record.getLevel().intValue() >= Level.WARNING.intValue())
			{
				System.err.write(message.getBytes());                       
			}
			else
			{
				System.out.write(message.getBytes());
			}
		} catch (Exception exception) {
			reportError(null, exception, ErrorManager.FORMAT_FAILURE);
		}

	}

	@Override
	public void close() throws SecurityException {}
	@Override
	public void flush(){}

}
