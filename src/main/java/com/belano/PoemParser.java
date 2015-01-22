package com.belano;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses poem content from string into poem lines
 */
public class PoemParser {

	final static Logger logger = LoggerFactory.getLogger(PoemParser.class);

	public List<PoemLine> parsePoem(String poemContent) {
		List<PoemLine> lines = new ArrayList<PoemLine>();
		String[] poemLines = poemContent.split(System.getProperty("line.separator"));
		for (int i = 0; i < poemLines.length; i++) {
			logger.info("this is line: {}", poemLines[i]);
			lines.add(new PoemLine(poemLines[i]));
		}
		return lines;
	}
}
