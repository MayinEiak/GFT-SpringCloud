package com.ms.bussiness.msbussiness.controller;

import com.ms.bussiness.msbussiness.dto.AccountDTO;
import com.ms.bussiness.msbussiness.request.AccountRequest;
import com.ms.bussiness.msbussiness.response.GenericResponse;
import com.ms.bussiness.msbussiness.service.AccountsServiceImp;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private AccountsServiceImp accountsServiceImp;

    @Autowired
    public AccountController(AccountsServiceImp accountsServiceImp) {
        this.accountsServiceImp = accountsServiceImp;
    }

    /**
     * Controller to get all accounts
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para obtener todos las cuentas de la base de datos")
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<AccountDTO>>> getAccounts(){
        return new ResponseEntity<>(accountsServiceImp.getAllAccounts(),  HttpStatus.OK);
    }

    /**
     * Controller to get account by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para obtener una cuenta específica a partir de su id")
    @GetMapping(path = "/{accountId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<AccountDTO>> getAccountById(@ApiParam("Id de la cuenta de la que se desea obtener su información") @PathVariable(name = "accountId") Integer accountId) {
        return new ResponseEntity<>(accountsServiceImp.getAccountById(accountId), HttpStatus.OK);
    }

    /**
     * Controller to save new account
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controler para guardar una nueva cuenta")
    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> saveAccount(@RequestBody AccountRequest accountRequest){
        return new ResponseEntity<>(accountsServiceImp.saveAccount(accountRequest),  HttpStatus.OK);
    }

    /**
     * Controller to update account
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para actualizar la información de una cuenta por id")
    @PutMapping(path = "/{accountId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> updateAccount( @ApiParam("Id de la cuenta de la que se desea obtener su información") @PathVariable(name = "accountId") Integer accountId,
                                                                 @RequestBody AccountRequest accountRequest){
        return new ResponseEntity<>(accountsServiceImp.updateAccount(accountId, accountRequest),  HttpStatus.OK);
    }

    /**
     * Controller to delete account by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @ApiOperation(value = "Controller para eliminar una cuenta por id")
    @DeleteMapping(path = "/{accountId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> deleteAccount(@ApiParam("Id de la cuenta que se desea eliminar")  @PathVariable(name = "accountId") Integer accountId){
        return new ResponseEntity<>(accountsServiceImp.deleteAccountById(accountId),  HttpStatus.OK);
    }
}
