package com.ms.persistence.persistence.constants;

public class Constants {

    public static final String STATUS_SUCCESS = "success";
    public static final String NOT_FOUND_DATA_MESSAGE = "No existen resultados para la solicitud generada";
    public static final String DELETE_SUCCESS = "El registro se elimimó correctamente";
    public static final String DELETE_FAILED = "El registro no puedo ser eliminado ya que no existe en la base de datos";
    public static final String INSERT_FAILED = "Ocurrio un error y no se ha podido dar de alta el registro en la base de datos";
    public static final String INSERT_SUCCESS = "El registro se dio de alta exitosamente";
    public static  final String UPDATE_BAD_REQUEST = "El id enviado en la url no corresponde al id enviado en el objeto del request";
    public static  final String UPDATE_SUCCESS = "Los datos fueron actualziados exitosamente";
    public static  final String UPDATE_FAILED = "Hubo un error al intentar actualizar la información";

}
