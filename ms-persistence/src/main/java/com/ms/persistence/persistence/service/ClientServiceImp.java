package com.ms.persistence.persistence.service;

import com.ms.persistence.persistence.constants.Constants;
import com.ms.persistence.persistence.entity.ClientEntity;
import com.ms.persistence.persistence.entity.GenderEntity;
import com.ms.persistence.persistence.repository.ClientRepository;
import com.ms.persistence.persistence.request.ClientRequest;
import com.ms.persistence.persistence.response.GenericResponse;
import com.ms.persistence.persistence.utils.GenericResponseUtils;
import com.ms.persistence.persistence.utils.HandlerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImp extends CustomJpaService{

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    /**
     * Function to get all clients from client table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<List<ClientEntity>> getClients(){
        GenericResponse<List<ClientEntity>> genericResponse;
        List<ClientEntity> clientsList = clientRepository.findAll();

        if (!clientsList.isEmpty())
            genericResponse = GenericResponseUtils.generateResponse(clientsList, Constants.STATUS_SUCCESS, null);
        else
            genericResponse = GenericResponseUtils.generateResponse(clientsList, Constants.STATUS_SUCCESS, Constants.NOT_FOUND_DATA_MESSAGE);

        return genericResponse;
    }

    /**
     * Function to get client by id from client table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<ClientEntity> getClientById(Integer clientId){
        GenericResponse<ClientEntity> genericResponse;
        Optional<ClientEntity> client = clientRepository.findById(clientId);

        if (client.isPresent())
            genericResponse = GenericResponseUtils.generateResponse(client.get(), Constants.STATUS_SUCCESS, null);
        else
            genericResponse = GenericResponseUtils.generateResponse((ClientEntity) null, Constants.STATUS_SUCCESS, Constants.NOT_FOUND_DATA_MESSAGE);

        return genericResponse;
    }

    /**
     * Function to insert new client to client table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> saveClient(ClientRequest clientRequest){
        GenericResponse<Object> genericResponse;

        ClientEntity clientEntity = clientRepository.save(handlerClient.apply(new ClientEntity(), clientRequest));

        if (clientEntity.getId() != null && clientEntity.getId() != 0)
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.INSERT_SUCCESS);
        else
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.INSERT_FAILED);

        return genericResponse;
    }

    /**
     * Function to update client by client id to client table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> updateClient(Integer clientId, ClientRequest clientRequest){
        GenericResponse<Object> genericResponse;
        if (clientId != clientRequest.getId()){
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_BAD_REQUEST);
        }
        else {
            ClientEntity clientEntity = clientRepository.save(handlerClient.apply(new ClientEntity(), clientRequest));

            if (clientEntity.getId() != null && clientEntity.getId() != 0)
                genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_SUCCESS);
            else
                genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_FAILED);
        }

        return genericResponse;
    }

    /**
     * Function to delete client from client table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> deleteClientById(Integer clientId){
        return super.deleteDataById(clientRepository, clientId);
    }

    @FunctionalInterface
    interface HandlerClient {
        ClientEntity apply(ClientEntity clientEntity, ClientRequest clientRequest);
    }

    HandlerClient handlerClient = (entity, request) -> {
        entity = HandlerRequest.convertRequestToEntity(request, entity.getClass());
        entity.setGender(new GenderEntity(request.getGenderId()));
        return entity;
    };

}

