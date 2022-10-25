package com.example.vulcanizare.controller;


import com.example.vulcanizare.domain.Vehicul;
import com.example.vulcanizare.services.VehiculService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("mysql")
public class VehiculControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    VehiculService vehiculService;

    @MockBean
    Model model;



    @Disabled
    @Test
    public void showByIdMvc() throws Exception {

        mockMvc.perform(get("/vehicul/info/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("info"));
    }



    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void showByIdMockMvc() throws Exception {
        Long id = 1l;
        Vehicul vehiculTest = new Vehicul();
        vehiculTest.setId(id);
        vehiculTest.setNr_matriculare("test");

        when(vehiculService.findById(id)).thenReturn(vehiculTest);

        mockMvc.perform(get("/vehicul/info/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("info"))
                .andExpect(model().attribute("vehicul", vehiculTest))
                //.andExpect(content().contentType(MediaType.TEXT_HTML));
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }



    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void deleteByIdMockMvc() throws Exception {

        mockMvc.perform(get("/vehicul/delete/{id}", "1"))
                .andExpect(status().isForbidden());
    }
}
