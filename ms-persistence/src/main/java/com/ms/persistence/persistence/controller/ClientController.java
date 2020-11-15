package com.ms.persistence.persistence.controller;

import com.ms.persistence.persistence.entity.ClientEntity;
import com.ms.persistence.persistence.request.ClientRequest;
import com.ms.persistence.persistence.response.GenericResponse;
import com.ms.persistence.persistence.service.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    ClientServiceImp clientServiceImp;

    @Autowired
    public ClientController(ClientServiceImp clientServiceImp) {
        this.clientServiceImp = clientServiceImp;
    }

    /**
     * Controller get all clients
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<ClientEntity>>> getAllClients() {
        return new ResponseEntity(clientServiceImp.getClients(), HttpStatus.OK);
    }

    /**
     * Controller get client by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @GetMapping(path = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<ClientEntity>> getClientById(@PathVariable(name = "clientId") Integer clientId) {
        return new ResponseEntity(clientServiceImp.getClientById(clientId), HttpStatus.OK);
    }

    /**
     * Controller to save new client
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> saveClient(@RequestBody ClientRequest clientRequest) {
        return new ResponseEntity(clientServiceImp.saveClient(clientRequest), HttpStatus.OK);
    }

    /**
     * Controller to update client by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @PutMapping(path = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> updateClientById(@PathVariable(name = "clientId") Integer clientId, @RequestBody ClientRequest clientRequest){
        return new ResponseEntity(clientServiceImp.updateClient(clientId, clientRequest), HttpStatus.OK);
    }

    /**
     * Controller to delete client by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @DeleteMapping(path = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> deleteClientById(@PathVariable(name = "clientId") Integer clientId) {
        return new ResponseEntity(clientServiceImp.deleteClientById(clientId), HttpStatus.OK);
    }

}
