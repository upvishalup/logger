package com.star.logger.writer;

import com.star.logger.contants.Level;
import com.star.logger.contants.SinkType;

public class WriterFactory {

    private static WriterFactory instace;

    Writer es;
    Writer s3;
    Writer stout;
    private WriterFactory(){
        es = new ElasticSearchWriter();
        s3 = new S3Writer();
        stout = new STDOUTWriter();
    }

    public static WriterFactory getInstance(){
        return new WriterFactory();
    }

    public void pushLog(SinkType sinkType, Level level, String message){
        switch (sinkType){
            case S3:
                es.write(message);
                break;
            case STDOUT:
                s3.write(message);
                break;
            case ELASTIC_SEARCH:
                stout.write(message);
                break;
                default:
                    throw new IllegalArgumentException("Invalid Argument");
        }
    }

}
