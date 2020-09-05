package com.belano;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Reads poem content from file system
 */
public class FileSystemPoemReader extends BufferedPoemReader {

    BufferedReader getReader(String poemPath) {
        try {
            return Files.newBufferedReader(Paths.get(poemPath));
        } catch (IOException e) {
            String message = String.format("Input file %s does not exist or cannot be opened for reading.", poemPath);
            throw new IllegalArgumentException(message, e);
        }
    }
}
