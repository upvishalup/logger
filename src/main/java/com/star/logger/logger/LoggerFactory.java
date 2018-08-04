package com.star.logger.logger;

public class LoggerFactory {

    public static Logger getLogger(Class aClass){
        Logger logger = new Logger(aClass);
        return logger;
    }

}
