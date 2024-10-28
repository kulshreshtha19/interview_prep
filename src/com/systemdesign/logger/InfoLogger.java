package com.systemdesign.logger;

public class InfoLogger extends LogParser {

    InfoLogger(LogParser nextLogParser) {
        super(nextLogParser);
    }

    @Override
    public void log(LogType type, String message) {
        if (type.equals(LogType.INFO))
            System.out.println(type.name() + " " + message);
        else
            super.log(type, message);

    }
}
