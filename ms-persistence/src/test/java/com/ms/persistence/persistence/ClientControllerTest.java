package com.ms.persistence.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ms.persistence.persistence.request.ClientRequest;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;


@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllClients() throws Exception {
        String response = mockMvc.perform(get("/clients"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

        log.info("response: {}", response);
    }

    @Test
    public void testGetClientById() throws Exception {
        int clientId = 1;
        String response = mockMvc.perform(get("/clients"+"/{clientId}", clientId))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.id").value(clientId))
                .andReturn().getResponse().getContentAsString();

        log.info("response: {}", response);

    }

    @Test
    public void testAddClient() throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = format.parse("1995-02-18");
        java.sql.Date sql = new java.sql.Date(date.getDate());
        ClientRequest clientRequest = new ClientRequest(11, "Test name", "Apellido Test", sql, 2);

        String response = mockMvc.perform(post("/clients")
                .content(objectMapper.writeValueAsString(clientRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

        log.info("response: {}", response);


    }

    @Test
    public void testUpdateClientById() throws Exception {
        int clientId = 1;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = format.parse("1995-02-18");
        java.sql.Date sql = new java.sql.Date(date.getDate());
        ClientRequest clientRequest = new ClientRequest(1, "Juan Mario", "García De los Pinos", sql, 2);

        String response = mockMvc.perform(put("/clients/{clientId}", clientId)
                .content(objectMapper.writeValueAsString(clientRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

        log.info("response: {}", response);
    }

    @Test
    public void testDeleteById() throws Exception {
        int clientId = 2;

        String response = mockMvc.perform(delete("/clients/{clientId}", clientId))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

        log.info("response: {}", response);
    }

    /* MockBean para imprimir la respiesa en con formato json en consola */
/*    @TestConfiguration
    static class TestConfigurationApp {
        @Bean
        ObjectMapper objectMapperPrettyPrinting() {
            return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        }
    }*/

}
