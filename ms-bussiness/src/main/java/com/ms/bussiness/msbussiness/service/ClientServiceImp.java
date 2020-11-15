package com.ms.bussiness.msbussiness.service;

import com.ms.bussiness.msbussiness.client.MSPersistenceFeign;
import com.ms.bussiness.msbussiness.constants.Constants;
import com.ms.bussiness.msbussiness.dto.ClientDTO;
import com.ms.bussiness.msbussiness.request.ClientRequest;
import com.ms.bussiness.msbussiness.response.GenericResponse;
import com.ms.bussiness.msbussiness.utils.GenericResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp {

    private MSPersistenceFeign msPersistenceFeign;

    @Autowired
    public ClientServiceImp(MSPersistenceFeign msPersistenceFeign) {
        this.msPersistenceFeign = msPersistenceFeign;
    }

    /**
     * Function to get client from ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<List<ClientDTO>> getAllClients(){
        ResponseEntity<GenericResponse<List<ClientDTO>>> feignResponse = msPersistenceFeign.getAllClients();
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_GET);
    }

    /**
     * Function to get client by id from ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<ClientDTO> getClientById(Integer clientId){
        ResponseEntity<GenericResponse<ClientDTO>> feignResponse = msPersistenceFeign.getClientById(clientId);
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_GET);
    }

    /**
     * Function to save new client on ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> saveClient(ClientRequest clientRequest){
        ResponseEntity<GenericResponse<Object>> feignResponse = msPersistenceFeign.saveClient(clientRequest);
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_POST);
    }

    /**
     * Function to update client by id on ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> updateClient(Integer clientId, ClientRequest clientRequest){
        GenericResponse<Object> genericResponse;

        if (clientId != clientRequest.getId())
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_BAD_REQUEST);
        else {
            ResponseEntity<GenericResponse<Object>> feignResponse = msPersistenceFeign.saveClient(clientRequest);
            genericResponse = GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_PUT);
        }

        return genericResponse;
    }

    /**
     * Function to delete client by id on ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> deleteClientById(Integer clientId){
        ResponseEntity<GenericResponse<Object>> feignResponse = msPersistenceFeign.deleteClientById(clientId);
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_DELETE);
    }

}
