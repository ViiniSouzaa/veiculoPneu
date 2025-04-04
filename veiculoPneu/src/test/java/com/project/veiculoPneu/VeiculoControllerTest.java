package com.project.veiculoPneu;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCriarVeiculo() throws Exception {
        String veiculoJson = "{\"placa\":\"DEF5678\", \"marca\":\"Fiat\", \"kilometragem\":1500, \"status\":\"Ativo\"}";

        mockMvc.perform(post("/api/veiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(veiculoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa").value("DEF5678"));
    }
    
    

    @Test
    public void testListarVeiculos() throws Exception {
        mockMvc.perform(get("/api/veiculos"))
                .andExpect(status().isOk());
    }
}