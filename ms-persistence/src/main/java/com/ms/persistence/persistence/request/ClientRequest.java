package com.ms.persistence.persistence.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@Getter
@Setter
@ToString
public class ClientRequest {

    private Integer id;
    private String name;
    private String lastNames;
    private Date birthDate;
    private Integer genderId;

}
