package com.ms.persistence.persistence.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.persistence.persistence.constants.Constants;
import com.ms.persistence.persistence.entity.AccountEntity;
import com.ms.persistence.persistence.entity.ClientEntity;
import com.ms.persistence.persistence.entity.ProductTypeEntity;
import com.ms.persistence.persistence.repository.AccountRepository;
import com.ms.persistence.persistence.request.AccountRequest;
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
public class AccountServiceImp extends CustomJpaService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Function to get all accounts from account table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<List<AccountEntity>> getAccounts(){
        GenericResponse<List<AccountEntity>> genericResponse;
        List<AccountEntity> accountsList = accountRepository.findAll();

        if (!accountsList.isEmpty())
            genericResponse = GenericResponseUtils.generateResponse(accountsList, Constants.STATUS_SUCCESS, null);
        else
            genericResponse = GenericResponseUtils.generateResponse(accountsList, Constants.STATUS_SUCCESS, Constants.NOT_FOUND_DATA_MESSAGE);

        return genericResponse;
    }

    /**
     * Function to get account by id from account table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<AccountEntity> getAccountById(Integer accountId){
        GenericResponse<AccountEntity> genericResponse;
        Optional<AccountEntity> account = accountRepository.findById(accountId);

        if (account.isPresent())
            genericResponse = GenericResponseUtils.generateResponse(account.get(), Constants.STATUS_SUCCESS, null);
        else
            genericResponse = GenericResponseUtils.generateResponse((AccountEntity) null, Constants.STATUS_SUCCESS, Constants.NOT_FOUND_DATA_MESSAGE);

        return genericResponse;
    }

    /**
     * Function to insert new account to account table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> saveAccount(AccountRequest accountRequest){
        GenericResponse<Object> genericResponse;
        AccountEntity accountEntity = this.getCompleteEntity(accountRequest);

        if (accountEntity.getId() != null && accountEntity.getId() != 0)
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.INSERT_SUCCESS);
        else
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.INSERT_FAILED);

        return genericResponse;
    }

    private AccountEntity getCompleteEntity(AccountRequest accountRequest) {
        return accountRepository.save(handlerAccount.apply(new AccountEntity(), accountRequest));
    }

    /**
     * Function to update account by account id to account table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> updateAccount(Integer accountId, AccountRequest accountRequest){
        GenericResponse<Object> genericResponse;
        if (accountId != accountRequest.getId()){
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_BAD_REQUEST);
        }
        else {
            AccountEntity accountEntity = this.getCompleteEntity(accountRequest);

            if (accountEntity.getId() != null && accountEntity.getId() != 0)
                genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_SUCCESS);
            else
                genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.UPDATE_FAILED);
        }

        return genericResponse;
    }

    /**
     * Function to delete account from account table
     * @date: 13/Nov/2020
     * @modify:
     * 				$Log: $
     */
    public GenericResponse<Object> deleteAccountById(Integer accountId){
        return super.deleteDataById(accountRepository, accountId);
    }

    @FunctionalInterface
    interface HandlerAccount {
        AccountEntity apply(AccountEntity accountEntity, AccountRequest accountRequest);
    }

    HandlerAccount handlerAccount = (entity, request) -> {
        entity = HandlerRequest.convertRequestToEntity(request, entity.getClass());
        entity.setProductType(new ProductTypeEntity(request.getProductTypeId()));
        entity.setClient(new ClientEntity(request.getClientId()));
        return entity;
    };


}
