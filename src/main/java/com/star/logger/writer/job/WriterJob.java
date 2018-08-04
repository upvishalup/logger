package com.star.logger.writer.job;

import com.star.logger.writer.Writer;

public class WriterJob implements Runnable {

    private Writer writer;

    private String message;

    public WriterJob(Writer writer, String message){
        this.writer = writer;
        this.message = message;
    }

    @Override
    public void run() {
        writer.write(message);
    }
}
