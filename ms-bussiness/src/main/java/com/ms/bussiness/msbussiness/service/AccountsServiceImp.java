package com.ms.bussiness.msbussiness.service;

import com.ms.bussiness.msbussiness.client.MSPersistenceFeign;
import com.ms.bussiness.msbussiness.constants.Constants;
import com.ms.bussiness.msbussiness.dto.AccountDTO;
import com.ms.bussiness.msbussiness.request.AccountRequest;
import com.ms.bussiness.msbussiness.response.GenericResponse;
import com.ms.bussiness.msbussiness.utils.GenericResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsServiceImp {

    private MSPersistenceFeign msPersistenceFeign;

    @Autowired
    public AccountsServiceImp(MSPersistenceFeign msPersistenceFeign) {
        this.msPersistenceFeign = msPersistenceFeign;
    }

    /**
     * Function to get all accounta from ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<List<AccountDTO>> getAllAccounts(){
        ResponseEntity<GenericResponse<List<AccountDTO>>> feignResponse = msPersistenceFeign.getAllAccounts();
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_GET);
    }

    /**
     * Function to get account by id from ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<AccountDTO> getAccountById(Integer accountId){
        ResponseEntity<GenericResponse<AccountDTO>> feignResponse = msPersistenceFeign.getAccountById(accountId);
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_GET);
    }

    /**
     * Function to save new account to ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> saveAccount(AccountRequest accountRequest){
        ResponseEntity<GenericResponse<Object>> feignResponse = msPersistenceFeign.saveAccount(accountRequest);
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_POST);
    }

    /**
     * Function to update account by id on ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> updateAccount(Integer accountId, AccountRequest accountRequest){
        GenericResponse<Object> genericResponse;

        if (accountId != accountRequest.getId())
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_BAD_REQUEST);
        else {
            ResponseEntity<GenericResponse<Object>> feignResponse = msPersistenceFeign.saveAccount(accountRequest);
            genericResponse = GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_PUT);
        }

        return genericResponse;
    }

    /**
     * Function to delete account by id on ms-persisitence using feign
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> deleteAccountById(Integer accountId){
        ResponseEntity<GenericResponse<Object>> feignResponse = msPersistenceFeign.deleteAccountById(accountId);
        return GenericResponseUtils.validateFeignResponse(feignResponse, Constants.HTTP_METHOD_DELETE);
    }
}
