package com.ms.bussiness.msbussiness.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClientDTO {

    private Integer id;
    private String name;
    private String lastNames;
    private Date birthDate;
    private Set<AccountDTO> accounts;
    private GenderDTO gender;

}
