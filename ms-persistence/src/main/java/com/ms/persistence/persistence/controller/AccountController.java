package com.ms.persistence.persistence.controller;

import com.ms.persistence.persistence.entity.AccountEntity;
import com.ms.persistence.persistence.request.AccountRequest;
import com.ms.persistence.persistence.response.GenericResponse;
import com.ms.persistence.persistence.service.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private AccountServiceImp accountServiceImp;

    @Autowired
    public AccountController(AccountServiceImp accountServiceImp){
        this.accountServiceImp = accountServiceImp;
    }

    /**
     * Controller get all accounts
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<AccountEntity>>> getAllAccounts() {
        return new ResponseEntity(accountServiceImp.getAccounts(), HttpStatus.OK);
    }

    /**
     * Controller get account by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<AccountEntity>> getAccountById(@PathVariable(name = "accountId") Integer accountId) {
        return new ResponseEntity(accountServiceImp.getAccountById(accountId), HttpStatus.OK);
    }

    /**
     * Controller to save new account
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> saveAccount(@RequestBody AccountRequest accountRequest) {
        return new ResponseEntity(accountServiceImp.saveAccount(accountRequest), HttpStatus.OK);
    }

    /**
     * Controller to update account by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @PutMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> updateAccountById(@PathVariable(name = "accountId") Integer accountId, @RequestBody AccountRequest accountRequest){
        return new ResponseEntity(accountServiceImp.updateAccount(accountId, accountRequest), HttpStatus.OK);
    }

    /**
     * Controller to delete account by id
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    @DeleteMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Object>> deleteAccountById(@PathVariable(name = "accountId") Integer accountId) {
        return new ResponseEntity(accountServiceImp.deleteAccountById(accountId), HttpStatus.OK);
    }
}
