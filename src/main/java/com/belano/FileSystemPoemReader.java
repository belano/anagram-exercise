package com.belano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Reads poem content from file system
 */
public class FileSystemPoemReader extends BufferedPoemReader {

	BufferedReader getReader(String poemPath) {
		try {
			final FileReader fileReader = new FileReader(poemPath);
			return new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			String message = String.format("Input file %s does not exist or cannot be opened for reading.", poemPath);
			throw new IllegalArgumentException(message, e);
		}
	}
}
