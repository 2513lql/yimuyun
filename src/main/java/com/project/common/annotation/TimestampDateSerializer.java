package com.project.common.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by katiemi on 2017/3/30.
 */
public class TimestampDateSerializer extends JsonSerializer<Date> {


    @Override
    //覆盖serialize解析数据的方法


    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        long timestamp = value.getTime()/1000;
        jgen.writeString(timestamp+"");

    }
}
