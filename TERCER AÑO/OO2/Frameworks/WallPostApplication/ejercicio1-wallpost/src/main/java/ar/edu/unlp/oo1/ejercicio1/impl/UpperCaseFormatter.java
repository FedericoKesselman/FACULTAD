package ar.edu.unlp.oo1.ejercicio1.impl;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class UpperCaseFormatter extends SimpleFormatter{
		
	@Override
	public String format(LogRecord record) {
		return super.format(record).toUpperCase();
	}

}

