package ar.edu.unlp.oo1.ejercicio1.impl;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.*;

public class FilterHandler extends Handler{
	private Handler handler;
	private List<String> words;
	
	public FilterHandler(Handler handler, List<String> words) {
		this.handler = handler;
		this.words = words;
	}

	@Override
	public void publish(LogRecord record) {
		String msg = record.getMessage();
		
		for (String word: words)
			msg = msg.replaceAll(word, "***");
		
        handler.publish(new LogRecord(record.getLevel(), msg));
	}

	@Override
	public void flush() {
		handler.flush();
	}

	@Override
	public void close() throws SecurityException {
		handler.flush();
	}
}
