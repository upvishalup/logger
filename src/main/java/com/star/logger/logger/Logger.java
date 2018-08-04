package com.star.logger.logger;

import com.star.logger.config.LoggerConfig;
import com.star.logger.contants.Constants;
import com.star.logger.contants.Level;
import com.star.logger.contants.SinkType;
import com.star.logger.writer.WriterFactory;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

public class Logger {

    private Class aClass;

    public Logger(Class aClass) {
        this.aClass = aClass;
    }

    public void log(Level level, String msg){
        logWrite(level, msg);
    }

    public void log(Level level, String... msgs){
        logWrite(level, msgs);
    }

    private String logWrite(Level level, String... msgs){
        Date date = new Date();
        String log = date + Constants.SPACE+ level.name() + Constants.SPACE + StringUtils.join(msgs , Constants.NEW_LINE);
        return log;
    }

    private void pushLog(Level level, String log){
        try {
            LoggerConfig config = new LoggerConfig();
            for(int i = 0; i < config.getSinkTypes().size(); i++){
                WriterFactory factory = WriterFactory.getInstance();
                factory.pushLog(SinkType.valueOf(config.getSinkTypes().get(i).getAsString()), level, log);
            }
        }catch (Throwable t){
            t.printStackTrace();
        }
    }
}
