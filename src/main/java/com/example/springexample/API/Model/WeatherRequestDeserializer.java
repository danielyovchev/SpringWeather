package com.example.springexample.API.Model;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.tomcat.util.json.JSONParser;

import java.beans.Customizer;
import java.io.IOException;

public class WeatherRequestDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonToken currentToken = jsonParser.getCurrentToken();

        if (currentToken.equals(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();

            if ("Yes".equalsIgnoreCase(text)) {
                return Boolean.TRUE;
            } else if ("No".equalsIgnoreCase(text)) {
                return Boolean.FALSE;
            }

        } else if (currentToken.equals(JsonToken.VALUE_NULL)) {
            return Boolean.FALSE;
        }

        return Boolean.FALSE;
    }
    }

