package com.kiribyte.io;

import com.kiribyte.io.services.IAppRunner;
import com.kiribyte.io.services.ILogger;

import java.io.*;

import static com.kiribyte.io.Main.*;

public class HomeTaskApp implements IAppRunner {

    private final ILogger logger;

    public HomeTaskApp(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void run() {

        File f = ORIGIN_FILE.toFile();
        if (!f.exists() || !f.isFile()) return;

        File julietFile = prepareFile(JULIET_FILE.toString());
        File romeoFile = prepareFile(ROMEO_FILE.toString());


        try (BufferedReader br = new BufferedReader(new FileReader(f));
             BufferedWriter romeoWriter = new BufferedWriter(new FileWriter(romeoFile));
             BufferedWriter julietWriter = new BufferedWriter(new FileWriter(julietFile))) {

            String line;
            boolean isRomeo = false;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Romeo:")) {
                    isRomeo = true;
                } else if (line.startsWith("Gulieta:")) {
                    isRomeo = false;
                }

                if (isRomeo) {
                    romeoWriter.write(line);
                    romeoWriter.newLine();
                } else {
                    julietWriter.write(line);
                    julietWriter.newLine();
                }

            }

        } catch (IOException e) {
            logger.log("Error while processing file: " + e.getMessage());
            throw new RuntimeException(e);
        }


    }

    private File prepareFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.exists()) {
                if (!file.delete()) {
                    throw new IOException("Failed to delete file: " + filePath);
                }
            }
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file: " + filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while preparing file: " + filePath, e);
        }
        return file;
    }
}
