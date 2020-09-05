package com.belano;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Reads poem content from a classpath resource
 */
public class ClasspathFilePoemReader extends BufferedPoemReader {

    BufferedReader getReader(String poemPath) {
        try {
            return Files.newBufferedReader(Paths.get(this.getClass()
                    .getResource("/" + poemPath)
                    .toURI()));
        } catch (IOException | URISyntaxException e) {
            String message = String.format("Input file %s does not exist or cannot be opened for reading.", poemPath);
            throw new IllegalArgumentException(message, e);
        }
    }
}
