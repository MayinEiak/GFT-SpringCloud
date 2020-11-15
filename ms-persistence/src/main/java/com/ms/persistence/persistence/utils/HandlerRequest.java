package com.ms.persistence.persistence.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HandlerRequest {

    public static <T, E> T convertRequestToEntity(E request, Class<T> typeEntity){
        T entity;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        entity = objectMapper.convertValue(request, typeEntity);
        return entity;
    }

}
