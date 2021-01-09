package com.eltropy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BaseControllerTest {



    /**
     * Function to convert java object into json string.
     */
    protected Function<Object, String> toJson = o -> {
        Gson gson = new Gson();
        return gson.toJson(o);
    };

    /**
     * Function to convert java object into json string.
     */
    protected BiFunction<String, Class, Object> fromJson = (json, clazz) -> {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    };
}
