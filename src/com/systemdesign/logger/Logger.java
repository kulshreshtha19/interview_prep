package com.systemdesign.logger;

public class Logger {

    public static void main(String[] args) {
        LogParser logParser = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
        logParser.log(LogType.DEBUG, "Debug Message");
        logParser.log(LogType.INFO, "INFO Message");
        logParser.log(LogType.ERROR, "ERROR Message");
    }
}
