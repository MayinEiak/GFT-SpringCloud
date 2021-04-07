package com.ms.persistence.persistence;

import com.ms.persistence.persistence.repository.ClientRepository;
import com.ms.persistence.persistence.service.ClientServiceImp;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientMockTest {

    @MockBean
    ClientRepository clientRepository;

    @Autowired
    ClientServiceImp clientServiceImp;

    @Test
    public void getAllClientsTest(){
        log.info("*****************************************");
        when(clientRepository.findAll()).thenReturn(new ArrayList<>()); //Cuando se manda llamar el método findAll siempre regresará un nuevo array list
        assertThat(clientServiceImp.getClients().getData()).isEmpty();
        verify(clientRepository, times(1)).findAll(); //Verifica el número de llamadas del método
    }

}
