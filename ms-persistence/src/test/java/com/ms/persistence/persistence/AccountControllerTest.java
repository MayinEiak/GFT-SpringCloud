package com.ms.persistence.persistence;

import com.ms.persistence.persistence.entity.AccountEntity;
import com.ms.persistence.persistence.entity.ProductTypeEntity;
import com.ms.persistence.persistence.request.AccountRequest;
import com.ms.persistence.persistence.service.AccountServiceImp;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.with;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountServiceImp accountServiceImp;

    @Before
    public void setup(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void testGetAllAccounts() {
        when()
                .get("/accounts")
                .then()
                .log()
                .ifValidationFails()
                .body("data[0].id", equalTo(1))
                .body("data[0].accountNumber", equalTo(123456))
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAccountById() {
        when()
                .get("/accounts/{clientId}", 1)
                .then()
                .log()
                .ifValidationFails()
                .body("data.id", equalTo(1))
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testSaveAccount() {
        AccountRequest accountRequest = new AccountRequest(20, (long) 9999, 200.0, 1, 1);

        with()
                .body(accountRequest)
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .when()
                .post("/accounts")
                .then()
                .log()
                .ifValidationFails()
                .body("data", equalTo(null))
                .body("status", equalTo("success"))
                .statusCode(HttpStatus.OK.value());
    }


}
