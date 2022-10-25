package com.example.vulcanizare.repositories;

import com.example.vulcanizare.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Order(1)
    public void addClient() {
        Client client = new Client();
        client.setNume("Vasu");
        client.setPrenume("Ionut");
        clientRepository.save(client);
    }
}
