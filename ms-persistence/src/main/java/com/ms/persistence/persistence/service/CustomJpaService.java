package com.ms.persistence.persistence.service;

import com.ms.persistence.persistence.constants.Constants;
import com.ms.persistence.persistence.response.GenericResponse;
import com.ms.persistence.persistence.utils.GenericResponseUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomJpaService {

    public GenericResponse<Object> deleteDataById(JpaRepository jpaRepository, Integer id){
        return handlerDeleteData.apply(jpaRepository, id);
    }

    @FunctionalInterface
    interface HandlerDeleteData {
        GenericResponse<Object> apply(JpaRepository repository, Integer account);
    }

    HandlerDeleteData handlerDeleteData = (repository, account) -> {
        GenericResponse<Object> genericResponse;
        if (repository.existsById(account)){
            repository.deleteById(account);
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.DELETE_SUCCESS);
        }
        else
            genericResponse = GenericResponseUtils.generateResponse((Object) null, Constants.STATUS_SUCCESS, Constants.DELETE_FAILED);
        return genericResponse;
    };
}
