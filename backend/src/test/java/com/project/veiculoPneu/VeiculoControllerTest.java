package com.project.veiculoPneu;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import com.project.veiculoPneu.controller.VeiculoController;
import com.project.veiculoPneu.model.Veiculo;
import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.model.dto.VeiculoDTO;
import com.project.veiculoPneu.model.dto.VeiculoPneuDTO;
import com.project.veiculoPneu.service.PneuService;
import com.project.veiculoPneu.service.VeiculoService;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoControllerTest {

	@Mock
    private VeiculoService veiculoService;
    
    @Mock
    private PneuService pneuService;
    
    @InjectMocks
    private VeiculoController veiculoController;
    
    private MockMvc mockMvc;
    
    private VeiculoPneuDTO veiculoDto;
    
    private VeiculoDTO veiculo;
    
    @Autowired
    Gson gson;
    
    @BeforeEach
    void setUp() {
    	mockMvc = MockMvcBuilders.standaloneSetup(veiculoController).build();

    	this.veiculo = new VeiculoDTO();
        veiculo.setId(1L);
        veiculo.setPlaca("ABC-1234");
        veiculo.setMarca("Toyota");
        veiculo.setQuilometragem(50000);
        veiculo.setStatus("ATIVO");
        veiculo.setTipo("Carro");
        
        veiculoDto = new VeiculoPneuDTO();
        
        this.veiculoDto.setVeiculo(veiculo);
        
        List<PneuDTO> pneus = new ArrayList<PneuDTO>();
        pneus.add(new PneuDTO(35L,1034L,"Dunlop",32,"Ativo","A"));
        pneus.add(new PneuDTO(36L,1035L,"Michelin",30,"Ativo","B"));
        pneus.add(new PneuDTO(37L,1036L,"Pirelli",31,"Ativo","C"));
        pneus.add(new PneuDTO(38L,1034L,"Bridgestone",34,"Ativo","D"));
        
        this.veiculoDto.setPneus(pneus);
    }
    
    @Test
    public void testCriarVeiculo() throws Exception {

    	when(veiculoService.salvarVeiculo(veiculo)).thenReturn(Veiculo.from(veiculo));


    	mockMvc.perform(post("/api/veiculos")
                .contentType("application/json")
                .content(gson.toJson(veiculo)))
                .andExpect(status().isOk());

        verify(veiculoService, times(1)).salvarVeiculo(veiculo);
    }
    
    @Test
    public void testObterVeiculoPorId() throws Exception {
        // Simula o comportamento do serviço
        when(veiculoService.obterVeiculoComPneus(1L)).thenReturn(veiculoDto);

        // Realiza o GET e verifica se a resposta tem status OK e os dados esperados
        mockMvc.perform(get("/api/veiculos/1"))
                .andExpect(status().isOk());

        // Verifica que o serviço foi chamado uma vez com o id 1L
        verify(veiculoService, times(1)).obterVeiculoComPneus(1L);
    }

    @Test
    public void testObterVeiculoPorPlaca() throws Exception {

    	when(veiculoService.obterVeiculoComPneus("ABC1234")).thenReturn(veiculoDto);

        mockMvc.perform(get("/api/veiculos/placa/ABC1234"))
                .andExpect(status().isOk());

        verify(veiculoService, times(1)).obterVeiculoComPneus("ABC1234");
    }

    @Test
    public void testListarPneus() throws Exception {
    	
    	when(veiculoService.listarTodosVeiculos()).thenReturn(List.of(veiculo));

        mockMvc.perform(get("/api/veiculos"))
                .andExpect(status().isOk());
        
        verify(veiculoService, times(1)).listarTodosVeiculos();
    }
}