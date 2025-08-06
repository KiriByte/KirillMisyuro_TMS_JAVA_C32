package com.kiribyte.io;

import com.kiribyte.io.services.IAppRunner;
import com.kiribyte.io.services.IFileOperation;
import com.kiribyte.io.services.ILogger;
import com.kiribyte.io.services.impl.IOFileOperationImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static com.kiribyte.io.Main.*;

public class ExperimentalApp implements IAppRunner {


    private final ILogger logger;

    public ExperimentalApp(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void run() {
        //region Create file if it doesn't exist
        if (Files.exists(ORIGIN_FILE)) {
            logger.log("Origin file exists");
        } else {
            logger.log("Origin file does not exist");
            try {
                logger.log("Creating origin file.....");
                Files.createFile(ORIGIN_FILE);
                Files.write(ORIGIN_FILE, str.getBytes());
                logger.log("Origin file created");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        //endregion

        //region Create copy file. Replace Gulieta to Juliet and repeated 10 times

        try {
            var content = new String(Files.readAllBytes(ORIGIN_FILE));
            var updatedContent = content.replaceAll("Gulieta", "Juliet");

            if (Files.exists(COPY_FILE)) {
                Files.delete(COPY_FILE);
            }
            Files.createFile(COPY_FILE);
            //StandadOpenOption.APPEND -> add content to end file
            for (var i = 0; i < 10; i++) {
                Files.write(COPY_FILE, updatedContent.getBytes(), StandardOpenOption.APPEND);
                Files.write(COPY_FILE, "\n".getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            logger.log(e.getMessage());
        }
        //endregion

        //region File Operation IO
        IFileOperation fileOperation = new IOFileOperationImpl();
        String[] lines;
        try {
            lines = fileOperation.readFromFileAsLines(COPY_FILE.toString());
        } catch (IOException e) {
            logger.log("Error reading file: " + e.getMessage());
            lines = new String[0];
        }

        if (lines.length == 0) {
            logger.log("No lines found in file");
            return;
        }

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
            } else {
                logger.log("Unknown line: " + line);
            }
        }

        if (!Files.exists(ROMEO_FILE)) {
            try {
                Files.createFile(ROMEO_FILE);
                fileOperation.writeToFile(ROMEO_FILE.toString(), romeoSb.toString());
            } catch (IOException e) {
                logger.log("Cannot create romeo file or writing to file");
            }
        }
        if (!Files.exists(JULIET_FILE)) {
            try {
                Files.createFile(JULIET_FILE);
                fileOperation.writeToFile(JULIET_FILE.toString(), julietSb.toString());
            } catch (IOException e) {
                logger.log("Cannot create juliet file or writing to file");
            }
        }
        //endregion
    }
}
