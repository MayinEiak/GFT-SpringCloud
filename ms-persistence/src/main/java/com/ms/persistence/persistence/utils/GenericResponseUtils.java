package com.ms.persistence.persistence.utils;

import com.ms.persistence.persistence.response.GenericResponse;

import java.util.List;

public class GenericResponseUtils {

    public static <T> GenericResponse<T> generateResponse(T objectResponse, String status, String message) {
        GenericResponse<T> response = new GenericResponse<>();
        response.setStatus(status);
        response.setData(objectResponse);
        response.setMessage(message);
        return response;
    }

    public static <T> GenericResponse<List<T>> generateResponse(List<T> objectResponse, String status, String message) {
        GenericResponse<List<T>> response = new GenericResponse<>();
        response.setStatus(status);
        response.setData(objectResponse);
        response.setMessage(message);
        return response;
    }

}
