package com.systemdesign.logger;

public abstract class LogParser {

    LogParser nextLogParser;

    LogParser(LogParser nextLogParser) {
        this.nextLogParser = nextLogParser;
    }

     public void log(LogType type, String message) {

        if (this.nextLogParser != null) {
            this.nextLogParser.log(type, message);
        } else {
            System.out.println("Invalid type passed");
        }
     }
}
