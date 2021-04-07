package com.ms.persistence.persistence.request;

import lombok.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClientRequest {

    private Integer id;
    private String name;
    private String lastNames;
    private Date birthDate;
    private Integer genderId;

    public ClientRequest(Integer id, String name, String lastNames, Date birthDate, Integer genderId) throws ParseException {
        this.id = id;
        this.name = name;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
        this.genderId = genderId;
    }
}
