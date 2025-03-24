package com.kiribyte.io;

import com.kiribyte.io.services.IAppRunner;
import com.kiribyte.io.services.ILogger;
import com.kiribyte.io.services.impl.ConsoleLoggerImpl;

import java.nio.file.Path;


public class Main {
    final static String str = "Romeo: text for Romeo\n"
            + "Text for Romeo\n" + "Text for Romeo\n"
            + "Gulieta: text fo Gulieta\n"
            + "text fo Gulieta\n" + "text fo Gulieta\n"
            + "text fo Gulieta\n" + "Romeo: text for Romeo\n"
            + "Text for Romeo\n" + "Text for Romeo";

    public static final String USER_HOME = System.getProperty("user.home");
    public static final Path HOME_PATH = Path.of(USER_HOME);
    public static final Path ORIGIN_FILE = HOME_PATH.resolve("text.txt");
    public static final Path COPY_FILE = HOME_PATH.resolve("copy.txt");
    public static final Path ROMEO_FILE = HOME_PATH.resolve("romeo.txt");
    public static final Path JULIET_FILE = HOME_PATH.resolve("juliet.txt");

    private static final ILogger logger = new ConsoleLoggerImpl();

    public static void main(String[] args) {

        IAppRunner app = null;
        try {
            app = selectAppRunner(args);
        } catch (IllegalArgumentException e) {
            logger.log(e.getMessage());
            return;
        }

        Context context = new Context(app);
        context.execute();

    }

    public static IAppRunner selectAppRunner(String[] args) throws IllegalStateException {
        if (args.length == 0) {
            return new HomeTaskApp(logger);
        }

        return switch (args[0]) {
            case "-h" -> new HomeTaskApp(logger);
            case "-e" -> new ExperimentalApp(logger);
            default -> throw new IllegalArgumentException("Unknown argument: " + args[0]);
        };


    }

}