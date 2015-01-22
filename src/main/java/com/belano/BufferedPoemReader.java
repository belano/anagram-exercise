package com.belano;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Base class for buffered poem readers
 */
public abstract class BufferedPoemReader implements PoemReader {

	final static Logger logger = LoggerFactory.getLogger(BufferedPoemReader.class);

	@Override
	public String readContent(String poemPath) {
		BufferedReader reader = getReader(poemPath);
		StringBuilder contents = new StringBuilder();
		String inputLine;
		try {
			while ((inputLine = reader.readLine()) != null) {
				if (!"".equals(inputLine)) {	// skip empty lines
					contents.append(inputLine);
					contents.append(System.getProperty("line.separator"));
				}
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Unexpected exception reading file");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error("Could not close reader", e);
				}
			}
		}
		String poem = contents.toString();
		return poem;
	}

	abstract BufferedReader getReader(String poemPath);

}
