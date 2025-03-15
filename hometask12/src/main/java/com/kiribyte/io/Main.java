package com.kiribyte.io;

import com.kiribyte.io.services.IFileOperation;
import com.kiribyte.io.services.impl.IOFileOperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        final String str = "EDC México 2022";
        String userHome = System.getProperty("user.home");
        Path homePath = Path.of(userHome);
        var originFile = homePath.resolve("text.txt");

        if (Files.exists(originFile)) {
            System.out.println("Origin file exists");
        } else {
            System.out.println("Origin file does not exist");
            System.out.println("Creating origin file.....");
            try {
                Files.createFile(originFile);
                Files.write(originFile, str.getBytes());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        IFileOperation fileOperation = new IOFileOperation();
        String[] lines;
        try {
            lines = fileOperation.readFromFileAsLines(originFile.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            lines = new String[0];
        }

        if (!(lines.length > 0)) {
            return;
        }

        var romeoFile = homePath.resolve("romeo.txt");
        var julietFile = homePath.resolve("juliet.txt");

        var romeoSb = new StringBuilder();
        var julietSb = new StringBuilder();

        var isRomeoSpeaking = false;
        var isJulietSpeaking = false;

        for (String line : lines) {
            if (line.startsWith("Romeo:")) {
                isRomeoSpeaking = true;
                isJulietSpeaking = false;
                romeoSb.append(line).append("\n");
            } else if (line.startsWith("Juliet:")) {
                isJulietSpeaking = true;
                isRomeoSpeaking = false;
                julietSb.append(line).append("\n");
            } else if (isRomeoSpeaking) {
                romeoSb.append(line).append("\n");
            } else if (isJulietSpeaking) {
                julietSb.append(line).append("\n");
            }
        }

        if (!Files.exists(romeoFile)) {
            try {
                Files.createFile(romeoFile);
                fileOperation.writeToFile(romeoFile.toString(), romeoSb.toString());
            } catch (IOException e) {
                System.out.println("Cannot create romeo file or writing to file");
            }
        }
        if (!Files.exists(julietFile)) {
            try {
                Files.createFile(julietFile);
                fileOperation.writeToFile(julietFile.toString(), julietSb.toString());
            } catch (IOException e) {
                System.out.println("Cannot create juliet file or writing to file");
            }
        }


    }
}