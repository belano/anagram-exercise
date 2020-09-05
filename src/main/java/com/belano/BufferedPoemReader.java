package com.belano;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Base class for buffered poem readers
 */
public abstract class BufferedPoemReader implements PoemReader {

    final static Logger logger = LoggerFactory.getLogger(BufferedPoemReader.class);

    @Override
    public String readContent(String poemPath) {
        String contents = null;
        try (BufferedReader reader = getReader(poemPath)) {
            // skip empty lines
            contents = reader.lines()
                    .filter(inputLine -> inputLine.trim()
                            .length() > 0)
                    .collect(Collectors.joining(System.getProperty("line.separator")));
        } catch (IOException e) {
            logger.error("Could not close reader", e);
        }
        return contents;
    }

    abstract BufferedReader getReader(String poemPath);

}
