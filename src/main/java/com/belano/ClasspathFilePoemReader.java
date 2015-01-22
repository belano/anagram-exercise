package com.belano;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads poem content from a classpath resource
 */
public class ClasspathFilePoemReader extends BufferedPoemReader {

	BufferedReader getReader(String poemPath) {
		try {
			final InputStream inputStream = this.getClass().getResourceAsStream("/" + poemPath);
			final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			return new BufferedReader(inputStreamReader);
		} catch (Exception e) {
			String message = String.format("Input file %s does not exist or cannot be opened for reading.", poemPath);
			throw new IllegalArgumentException(message, e);
		}
	}
}
