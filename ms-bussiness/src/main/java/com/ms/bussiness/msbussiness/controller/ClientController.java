package com.ms.bussiness.msbussiness.controller;

import com.ms.bussiness.msbussiness.request.ClientRequest;
import com.ms.bussiness.msbussiness.service.ClientServiceImp;
import com.ms.bussiness.msbussiness.response.GenericResponse;
import com.ms.bussiness.msbussiness.dto.ClientDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientServiceImp clientServiceImp;

    @Autowired
    public ClientController(ClientServiceImp clientServiceImp) {
        this.clientServiceImp = clientServiceImp;
    }

    /**
     * Controller to get all clients
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para obtener todos los clientes de la base de datos")
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<ClientDTO>>> getClients(){
        return new ResponseEntity<>(clientServiceImp.getAllClients(),  HttpStatus.OK);
    }

    /**
     * Controller to get client by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para obtener un cliente específico a partir de su id")
    @GetMapping(path = "/{clientId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<ClientDTO>> getClientById(@ApiParam("Id del cliente del que se desea obtener su información") @PathVariable(name = "clientId") Integer clientId) {
        return new ResponseEntity<>(clientServiceImp.getClientById(clientId), HttpStatus.OK);
    }

    /**
     * Controller to save new client
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controler para guardar un cliente nuevo")
    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> saveClient(@RequestBody ClientRequest clientRequest){
        return new ResponseEntity<>(clientServiceImp.saveClient(clientRequest),  HttpStatus.OK);
    }

    /**
     * Controller to update client
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para actualizar la información de un usuario por id")
    @PutMapping(path = "/{clientId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> updateClient( @ApiParam("Id del cliente del que se desea obtener su información") @PathVariable(name = "clientId") Integer clientId,
                                                                @RequestBody ClientRequest clientRequest){
        return new ResponseEntity<>(clientServiceImp.updateClient(clientId, clientRequest),  HttpStatus.OK);
    }

    /**
     * Controller to delete client by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para eliminar un usuario por id")
    @DeleteMapping(path = "/{clientId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> deleteClient(@ApiParam("Id del cliente que se desea eliminar")  @PathVariable(name = "clientId") Integer clientId){
        return new ResponseEntity<>(clientServiceImp.deleteClientById(clientId),  HttpStatus.OK);
    }

}
