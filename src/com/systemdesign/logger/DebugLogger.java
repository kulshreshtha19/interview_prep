package com.systemdesign.logger;

public class DebugLogger extends LogParser{

    DebugLogger(LogParser nextLogParser) {
        super(nextLogParser);
    }

    @Override
    public void log(LogType type, String message) {
        if (type.equals(LogType.DEBUG))
            System.out.println(type.name() + " " + message);
        else
            super.log(type, message);
    }
}
