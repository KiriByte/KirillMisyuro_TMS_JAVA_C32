package com.kiribyte.io.services.impl;

import com.kiribyte.io.services.IFileOperation;

import java.io.*;

public class IOFileOperationImpl implements IFileOperation {
    @Override
    public void writeToFile(String fileName, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(content);
        }
    }

    @Override
    public void writeToFile(String fileName, String[] lines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        }
    }

    @Override
    public String readFromFileAsString(String fileName) throws IOException {
        var sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String[] readFromFileAsLines(String fileName) throws IOException {
        boolean isFirstIteration = true;
        int linesCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                linesCount++;
            }
        }
        String[] lines = new String[linesCount];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for (int i = 0; i < linesCount; i++) {
                lines[i] = br.readLine();
            }
        }
        return lines;
    }
}
