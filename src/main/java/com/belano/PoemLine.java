package com.belano;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Abstraction of a poem line
 */
public class PoemLine {

	final static Logger logger = LoggerFactory.getLogger(PoemLine.class);

	/** line content */
	private String text;

	public PoemLine(String poemLineText) {
		this.text = poemLineText;
	}

	/**
	 * Determines if this line is an anagram of another line
	 *
	 * @param anotherLine line to compare with
	 * @return <code>true</code> if anagram is detected, <code>false</code> otherwise
	 */
	public boolean isAnagramOf(PoemLine anotherLine) {
		String str1 = this.text;
		String str2 = anotherLine.text;

		logger.debug("strlength1: {}", str1.length());
		logger.debug("strlength2: {}", str2.length());

		// remove spaces, only consider alphabetic characters
		String s1 = str1.replaceAll("\\s+", "").toLowerCase().replaceAll("[^a-z]", "");
		String s2 = str2.replaceAll("\\s+", "").toLowerCase().replaceAll("[^a-z]", "");

		// string as buckets
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		// sort buckets alphabetically
		Arrays.sort(c1);
		Arrays.sort(c2);

		logger.debug("arrlength1: {}", c1.length);
		logger.debug("arrlength2: {}", c2.length);

		// compare bucket elements
		int pos = 0;
		boolean matches = true;
		while (pos < c1.length && matches) {
			logger.debug("c1[pos]: {} - c2[pos]:{}", c1[pos], c2[pos]);
			if (c1[pos] == c2[pos]) {
				pos++;
			} else {
				matches = false;
			}
		}

		logger.info("{} is anagram of {}?: {}", this, anotherLine, matches);
		return matches;
	}

	@Override public String toString() {
		return "'" + this.text + "'";
	}
}
