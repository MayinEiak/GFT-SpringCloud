package com.ms.persistence.persistence;

import com.ms.persistence.persistence.entity.ClientEntity;
import com.ms.persistence.persistence.repository.ClientRepository;
import com.ms.persistence.persistence.service.ClientServiceImp;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientServiceImp clientServiceImp;

    @Test
    public void getAllClientsTest(){
        log.info("*****************************************");
        assertThat(clientServiceImp.getClients().getData()).isNotEmpty();
    }

    @Test
    public void p (){
        System.out.println("Start");
        int[] t = {-1, 0, 1, 2, -1, -4};
        Set<int[]> list = new HashSet<>();
        for( int i = 0; i<t.length; i++ ) {
            for( int j = i+1; j <t.length; j++ ) {
                if( j != t.length ) {
                    for (int z = j + 1; z < t.length; z++) {
                        int suma = t[i] + t[j] + t[z];
                        if (suma == 0) {
                            int[] s = {t[i], t[j], t[z]};
                            list.add(s);
                        }
                    }
                }
            }
        }
        System.out.println(list.toString());
    }
}
