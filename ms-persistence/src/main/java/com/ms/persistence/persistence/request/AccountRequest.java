package com.ms.persistence.persistence.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AccountRequest {

    private Integer id;
    private Long accountNumber;
    private Double balance;
    private Integer clientId;
    private Integer productTypeId;

}
