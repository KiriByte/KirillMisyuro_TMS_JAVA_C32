package com.kiribyte.io;

import com.kiribyte.io.services.IAppRunner;

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
