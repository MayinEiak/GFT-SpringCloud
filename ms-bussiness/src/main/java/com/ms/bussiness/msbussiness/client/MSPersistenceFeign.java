package com.ms.bussiness.msbussiness.client;

import com.ms.bussiness.msbussiness.dto.AccountDTO;
import com.ms.bussiness.msbussiness.request.AccountRequest;
import com.ms.bussiness.msbussiness.request.ClientRequest;
import com.ms.bussiness.msbussiness.response.GenericResponse;
import com.ms.bussiness.msbussiness.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-persistence")
public interface MSPersistenceFeign {

    /*** CLIENTS ***/
    @GetMapping(path = "/clients", produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<List<ClientDTO>>> getAllClients();

    @GetMapping(path = "/clients/{clientId}", produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<ClientDTO>> getClientById(@PathVariable(name = "clientId") Integer clientId);

    @PostMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<Object>> saveClient(@RequestBody ClientRequest clientRequest);

    @PutMapping(path = "/clients/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<Object>> updateClientById(@PathVariable(name = "clientId") Integer clientId, @RequestBody ClientRequest clientRequest);

    @DeleteMapping(path = "/clients/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<Object>> deleteClientById(@PathVariable(name = "clientId") Integer clientId);


    /*** ACCOUNTS ***/
    @GetMapping(path = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<List<AccountDTO>>> getAllAccounts();

    @GetMapping(path = "/accounts/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<AccountDTO>> getAccountById(@PathVariable(name = "accountId") Integer accountId);

    @PostMapping(path = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<Object>> saveAccount(@RequestBody AccountRequest accountRequest);

    @PutMapping(path = "/accounts/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<Object>> updateAccountById(@PathVariable(name = "accountId") Integer accountId, @RequestBody AccountRequest accountRequest);

    @DeleteMapping(path = "/accounts/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GenericResponse<Object>> deleteAccountById(@PathVariable(name = "accountId") Integer accountId);


}
