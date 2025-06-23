package org.example.config;

public final class ApplicationEnvironments {

    public static final String DB_URL = System.getenv("DB_URL");
    public static final String DB_USER = System.getenv("DB_USER");
    public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");


    static {
        if (DB_URL == null || DB_USER == null || DB_PASSWORD == null) {
            throw new ExceptionInInitializerError("Please set the environment variable");
        }
    }

    private ApplicationEnvironments() {
    }
}
