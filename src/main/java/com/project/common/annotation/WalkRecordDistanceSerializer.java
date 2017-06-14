package com.project.common.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Created by katiemi on 2017/3/30.
 */
public class WalkRecordDistanceSerializer extends JsonSerializer<Integer> {

    @Override
    //覆盖serialize解析数据的方法


    public void serialize(Integer value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        double distance = value/1000.0;
        jgen.writeString(distance+"");
    }
}
