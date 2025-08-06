package com.kiribyte.threads;

public class Context {

    private IAppRunner appRunner;

    public Context(IAppRunner runner) {
        this.appRunner = appRunner;
    }

    public void setAppRunner(IAppRunner runner) {
        this.appRunner = runner;
    }

    public void execute() {
        appRunner.run();
    }

}
