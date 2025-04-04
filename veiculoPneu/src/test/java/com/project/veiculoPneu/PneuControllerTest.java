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
public class PneuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCriarPneu() throws Exception {
        String pneuJson = "{\"numeroDeFogo\":789, \"marca\":\"Goodyear\", \"pressaoAtual\":35, \"status\":\"Inativo\"}";

        mockMvc.perform(post("/api/pneus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pneuJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroDeFogo").value(789));
    }

    @Test
    public void testListarPneus() throws Exception {
        mockMvc.perform(get("/api/pneus"))
                .andExpect(status().isOk());
    }
}
