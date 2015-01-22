package com.belano;

import java.util.Collections;
import java.util.List;

/**
 * Abstraction of a poem as a list of poem lines
 */
public class Poem {

	/** poem lines */
	private List<PoemLine> poemLines;

	/**
	 * Constructor
	 *
	 * @param path poem file path
	 * @param reader poem file reader
	 * @param parser poem content parser
	 */
	public Poem(String path, PoemReader reader, PoemParser parser) {
		String poemContent = reader.readContent(path);
		poemLines = parser.parsePoem(poemContent);
	}

	/**
	 * Constructor
	 *
	 * @param poemContent poem string content
	 * @param parser poem content parser
	 */
	public Poem(String poemContent, PoemParser parser) {
		poemLines = parser.parsePoem(poemContent);
	}

	public List<PoemLine> poemLines() {
		return Collections.unmodifiableList(poemLines);
	}

	/**
	 * Detects if the poem is anagrammatic
	 *
	 * @return <code>true</code> if anagrammatic, <code>false</code> otherwise
	 */
	public boolean isAnagrammatic() {
		boolean stillOk = true;
		int pos = 0;
		while (pos < poemLines.size() && stillOk) {
			int j = pos + 1;
			while (j < poemLines.size()) {
				if(poemLines.get(pos).isAnagramOf(poemLines.get(j))) {
					j++;
				} else {
					stillOk = false;
					break;
				}
			}
			pos++;
		}
		return stillOk;
	}

}
