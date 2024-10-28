package com.systemdesign.logger;

public class ErrorLogger extends LogParser{

    ErrorLogger(LogParser nextLogParser) {
        super(nextLogParser);
    }

    @Override
    public void log(LogType type, String message) {
        if (type.equals(LogType.ERROR))
            System.out.println(type.name() + " " + message);
        else
            super.log(type, message);
    }
}
