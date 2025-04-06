package com.kiribyte.io.services;

import java.io.IOException;

public interface IFileOperation {
    void writeToFile(String fileName, String content) throws IOException;

    void writeToFile(String fileName, String[] lines) throws IOException;

    String readFromFileAsString(String fileName) throws IOException;

    String[] readFromFileAsLines(String fileName) throws IOException;
}
