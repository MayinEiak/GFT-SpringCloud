package com.ms.bussiness.msbussiness.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountDTO {

    private Integer id;
    private Long accountNumber;
    private Double balance;
    private ClientDTO client;
    private ProductTypeDTO productType;

}
