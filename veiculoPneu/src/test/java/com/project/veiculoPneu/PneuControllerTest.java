package com.project.veiculoPneu;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.project.veiculoPneu.controller.PneuController;
import com.project.veiculoPneu.model.Pneu;
import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.service.PneuService;

@SpringBootTest
@AutoConfigureMockMvc
public class PneuControllerTest {

	@Mock
    private PneuService pneuService;

    @InjectMocks
    private PneuController pneuController;

    private MockMvc mockMvc;

    private PneuDTO pneu;
    
    @Autowired
    Gson gson;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pneuController).build();

        pneu = new PneuDTO();
        pneu.setNumeroDeFogo(12345L);
        pneu.setMarca("Dunlop");
        pneu.setPressaoAtual(32);
        pneu.setStatus("Ativo");
    }

    @Test
    public void testListarPneus() throws Exception {
        when(pneuService.listarTodosPneus()).thenReturn(List.of(pneu));

        mockMvc.perform(get("/api/pneus"))
                .andExpect(status().isOk());

        verify(pneuService, times(1)).listarTodosPneus();
    }

    @Test
    public void testObterPneuPorId() throws Exception {
       when(pneuService.obterPneu(1L)).thenReturn(pneu);

        mockMvc.perform(get("/api/pneus/1"))
                .andExpect(status().isOk());

        verify(pneuService, times(1)).obterPneu(1L);
    }

    @Test
    public void testObterPneuPorNumeroDeFogo() throws Exception {
        when(pneuService.findByNumeroDeFogo(12345L)).thenReturn(pneu);

        mockMvc.perform(get("/api/pneus/numeroDeFogo/12345"))
                .andExpect(status().isOk());

        verify(pneuService, times(1)).findByNumeroDeFogo(12345L);
    }

    @Test
    public void testCriarPneu() throws Exception {
        when(pneuService.salvarPneu(pneu)).thenReturn(Pneu.from(pneu));

        mockMvc.perform(post("/api/pneus")
                .contentType("application/json")
                .content(gson.toJson(pneu)))
                .andExpect(status().isOk());

        verify(pneuService, times(1)).salvarPneu(pneu);
    }
}
