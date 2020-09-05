package com.belano;

import java.util.Collections;
import java.util.List;

/**
 * Abstraction of a poem as a list of poem lines
 */
public class Poem {

    /**
     * poem lines
     */
    private final List<PoemLine> poemLines;

    /**
     * Constructor
     *
     * @param filePath poem file path
     * @param parser   poem content parser
     */
    public Poem(String filePath, PoemParser parser) {
        poemLines = parser.parsePoem(filePath);
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
                if (poemLines.get(pos)
                        .isAnagramOf(poemLines.get(j))) {
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
