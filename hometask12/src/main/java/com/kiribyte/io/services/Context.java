package com.kiribyte.io.services;

public class Context {

    private IAppRunner appRunner;

    public Context(IAppRunner appRunner) {
        this.appRunner = appRunner;
    }

    public void setAppRunner(IAppRunner appRunner) {
        this.appRunner = appRunner;
    }

    public void execute() {
        appRunner.run();
    }
}
