package com.belano;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parses poem content from path into poem lines
 */
public class PoemParser {

    final static Logger logger = LoggerFactory.getLogger(PoemParser.class);

    final PoemReader reader;

    public PoemParser(PoemReader reader) {
        this.reader = reader;
    }

    public List<PoemLine> parsePoem(String poemPath) {
        List<PoemLine> lines = new ArrayList<>();
        String poemContent = reader.readContent(poemPath);
        String[] poemLines = poemContent.split(System.getProperty("line.separator"));
        Arrays.stream(poemLines)
                .forEach(poemLine -> {
                    logger.info("this is line: {}", poemLine);
                    lines.add(new PoemLine(poemLine));
                });
        return lines;
    }
}
