package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.Tip;
import com.example.vulcanizare.domain.Vehicul;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.Arrays;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CascadeTypeTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    @Order(1)
    public void saveClient() {
        Client client = new Client();
        client.setNume("Zidaru");
        client.setPrenume("Catalin");
        Vehicul vehicul = new Vehicul();
        vehicul.setNr_matriculare("B 10 ZEU");
        vehicul.setTip(Tip.masina);
        client.setVehicule(Arrays.asList(vehicul));

        entityManager.persist(client);
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    @Order(2)
    public void updateClient(){
        Vehicul vehicul = entityManager.find(Vehicul.class, 1L);
        Client client = vehicul.getProprietar();
        client.setPrenume("Catalin-Costin");
        client.getVehicule().forEach(vehi -> {vehicul.setTip(Tip.bicicleta);});
        entityManager.merge(client);
        entityManager.flush(); }
}
