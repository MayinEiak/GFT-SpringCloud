package com.ms.persistence.persistence.request;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    private Integer id;
    private Long accountNumber;
    private Double balance;
    private Integer clientId;
    private Integer productTypeId;

}
