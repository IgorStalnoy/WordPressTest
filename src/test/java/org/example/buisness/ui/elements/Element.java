package org.example.buisness.ui.elements;

import org.apache.log4j.Logger;

public abstract class Element {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public Logger getLogger() {
        return logger;
    }
}
