package com.ms.bussiness.msbussiness.utils;

import com.ms.bussiness.msbussiness.constants.Constants;
import com.ms.bussiness.msbussiness.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

    public static <T> GenericResponse<T> validateFeignResponse(ResponseEntity<GenericResponse<T>> feignResponse, Integer httpMethod){
        String status = "";
        String message = null;

            if (feignResponse.getStatusCode() == HttpStatus.OK) {
                status = Constants.STATUS_SUCCESS;
                if (httpMethod == Constants.HTTP_METHOD_GET) {
                    if (feignResponse.getBody().getData() instanceof List<?>) {
                        List<T> body = (List<T>) feignResponse.getBody().getData();
                        if (body.isEmpty())
                            message = Constants.NOT_FOUND_DATA_MESSAGE;
                    } else {
                        T body = (T) feignResponse.getBody().getData();
                        if (body == null)
                            message = Constants.NOT_FOUND_DATA_MESSAGE;
                    }
                }
                else {
                    message = Constants.REQUEST_SUCCESS;
                }
            }
            else {
                status = Constants.STATUS_WARNING;
                message = Constants.REQUEST_ERROR;
            }

        return generateResponse(feignResponse.getBody().getData(), status, message);
    }

}
