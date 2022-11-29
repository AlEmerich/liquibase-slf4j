package com.mattbertolini.liquibase.logging.slf4j;

import liquibase.ui.ConsoleUIService;
import liquibase.logging.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jConsoleUIService extends ConsoleUIService {


    public Logger getLog(Class clazz) {
        return new Slf4jLogger(LoggerFactory.getLogger(clazz), null);
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public void setAllowPrompt(boolean allowPrompt) {
        //empty
    }

    @Override
    public boolean getAllowPrompt() {
        return false;
    }

    @Override
    public void sendMessage(String message) {
        getLog(this.getClass()).info(message);
    }

    @Override
    public void sendErrorMessage(String message) {
        getLog(this.getClass()).severe(message);
    }

    @Override
    public void sendErrorMessage(String message, Throwable exception) {
        getLog(this.getClass()).severe(message, exception);
    }
}
