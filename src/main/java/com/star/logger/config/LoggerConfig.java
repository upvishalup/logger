package com.star.logger.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.star.logger.contants.Config;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public final class LoggerConfig {

    JsonParser parser = new JsonParser();

    private JsonArray sinkTypes;

    private JsonObject elasticSearch;

    private JsonObject s3;

    public LoggerConfig() throws IOException {
        File file = new File(Config.CONFIG_FILE);
        String config = FileUtils.readFileToString(file);
        JsonObject object = parser.parse(config).getAsJsonObject();
        this.sinkTypes = object.get("sink_type").getAsJsonArray();
    }

    public JsonArray getSinkTypes(){
        return sinkTypes;
    }

    public JsonObject getElasticSearch() {
        return elasticSearch;
    }

    public JsonObject getS3() {
        return s3;
    }
}
