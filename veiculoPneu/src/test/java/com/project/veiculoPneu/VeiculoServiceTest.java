package com.project.veiculoPneu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.veiculoPneu.controller.VeiculoController;
import com.project.veiculoPneu.model.Veiculo;
import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.model.dto.VeiculoDTO;
import com.project.veiculoPneu.model.dto.VeiculoPneuDTO;
import com.project.veiculoPneu.service.PneuService;
import com.project.veiculoPneu.service.VeiculoService;

@SpringBootTest
public class VeiculoServiceTest {

    @Mock
    private VeiculoService veiculoService;
    
    @Mock
    private PneuService pneuService;
    
    @InjectMocks
    private VeiculoController veiculoController;
    
    private VeiculoPneuDTO veiculoDto;
    
    private VeiculoDTO veiculo;
    
    
    @BeforeEach
    void setUp() {

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
    void insereVeiculo() {
    	when(veiculoService.salvarVeiculo(this.veiculo)).thenReturn(Veiculo.from(veiculo));

        Veiculo veiculoSalvo = veiculoService.salvarVeiculo(this.veiculo);

        assertNotNull(veiculoSalvo);
        
        assertEquals(this.veiculo.getPlaca(), veiculoSalvo.getPlaca());
        assertEquals(this.veiculo.getMarca(), veiculoSalvo.getMarca());
        assertEquals(this.veiculo.getQuilometragem(), veiculoSalvo.getQuilometragem());
        
        verify(veiculoService, times(1)).salvarVeiculo(this.veiculo);
    }
    
    @Test
    public void testListarTodosVeiculos() {
    	List<VeiculoDTO> veiculos = new ArrayList<>();
        veiculos.add(veiculo);
        
        when(veiculoService.listarTodosVeiculos()).thenReturn(veiculos);
        
        assertFalse(veiculos.isEmpty());  
        assertTrue(veiculos.size() > 0);  
    }
    
    @Test
    void obterVeiculoComPneusPorId() {
        
        when(veiculoService.obterVeiculoComPneus(1L)).thenReturn(veiculoDto);
       
        var response = veiculoController.obterVeiculo(1L);

        assertNotNull(response);
        assertEquals("ABC-1234", response.getVeiculo().getPlaca());
        assertTrue(response.getPneus().size() > 0);

        verify(veiculoService, times(1)).obterVeiculoComPneus(1L);
    }
    
    @Test
    void obterVeiculoComPneusPorPlaca() {
        
        when(veiculoService.obterVeiculoComPneus("ABC1234")).thenReturn(veiculoDto);
       
        var response = veiculoController.obterVeiculobyPlaca("ABC1234");

        assertNotNull(response);
        assertEquals("ABC-1234", response.getVeiculo().getPlaca());
        assertTrue(response.getPneus().size() > 0);

        verify(veiculoService, times(1)).obterVeiculoComPneus("ABC1234");
    }
}