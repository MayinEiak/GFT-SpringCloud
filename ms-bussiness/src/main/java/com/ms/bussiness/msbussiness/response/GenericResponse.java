package com.ms.bussiness.msbussiness.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GenericResponse<T> {

    private String status;
    String message;
    private T data;

}
