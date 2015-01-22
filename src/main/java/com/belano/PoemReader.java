package com.belano;

/**
 * Interface for classes reading a poem from a text file
 */
public interface PoemReader {

	/**
	 * Reads poem content as string
	 * @param path file path
	 * @return poem content as string
	 */
	String readContent(String path);

}
