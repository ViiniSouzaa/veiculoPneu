package com.project.veiculoPneu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.veiculoPneu.controller.PneuController;
import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.service.PneuService;

@SpringBootTest
public class PneuServiceTest {

	@InjectMocks
    private PneuController pneuController;  // O Controller que estamos testando

    @Mock
    private PneuService pneuService;  // O Serviço que o Controller utiliza para obter os dados

    private PneuDTO pneu;

    @BeforeEach
    void setUp() {
        // Setup do pneu que será utilizado nos testes
        pneu = new PneuDTO();
        pneu.setId(1L);
        pneu.setNumeroDeFogo(1000L);
        pneu.setMarca("Michelin");
        pneu.setPressaoAtual(32);
        pneu.setStatus("ATIVO");
    }

    // Teste para o método listarPneus()
    @Test
    void listarPneus() {
        // Simula o retorno do serviço
        when(pneuService.listarTodosPneus()).thenReturn(Arrays.asList(pneu));

        // Chama o método do controller
        var response = pneuController.listarPneus();

        // Verifica se o retorno está correto
        assertFalse(response.isEmpty());
        assertEquals(1, response.size());
        assertEquals("Michelin", response.get(0).getMarca());

        // Verifica que o serviço foi chamado uma vez
        verify(pneuService, times(1)).listarTodosPneus();
    }

    // Teste para o método obterPneu(Long id)
    @Test
    void obterPneuPorId() {
        // Simula o comportamento do serviço
        when(pneuService.obterPneu(1L)).thenReturn(pneu);

        // Chama o método do controller
        var response = pneuController.obterPneu(1L);

        // Verifica se o retorno está correto
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("ATIVO", StringUtils.upperCase(response.getStatus()));

        // Verifica que o serviço foi chamado uma vez
        verify(pneuService, times(1)).obterPneu(1L);
    }

    // Teste para o método obterPneuByNumeroDeFogo(Long numeroDeFogo)
    @Test
    void obterPneuPorNumeroDeFogo() {
        // Simula o comportamento do serviço
        when(pneuService.findByNumeroDeFogo(1000L)).thenReturn(pneu);

        // Chama o método do controller
        var response = pneuController.obterPneuByNumeroDeFogo(1000L);

        // Verifica se o retorno está correto
        assertNotNull(response);
        assertEquals(1000L, response.getNumeroDeFogo());
        assertEquals("ATIVO", StringUtils.upperCase(response.getStatus()));

        // Verifica que o serviço foi chamado uma vez
        verify(pneuService, times(1)).findByNumeroDeFogo(1000L);
    }

    // Teste para o método obterPneu por ID, mas o pneu não encontrado
    @Test
    void obterPneuPorIdNaoEncontrado() {
        // Simula que o serviço não encontrou o pneu com o ID
        when(pneuService.obterPneu(999L)).thenThrow(new RuntimeException("Pneu não encontrado"));

        // Verifica se a exceção é lançada
        RuntimeException exception = assertThrows(RuntimeException.class, () -> pneuController.obterPneu(999L));
        assertEquals("Pneu não encontrado", exception.getMessage());

        // Verifica que o serviço foi chamado uma vez
        verify(pneuService, times(1)).obterPneu(999L);
    }
    
    @Test
    void obterPneuPorNumeroDeFogoNaoEncontrado() {
        // Simula que o serviço não encontrou o pneu com o numeroDeFogo
        when(pneuService.findByNumeroDeFogo(99999L)).thenThrow(new RuntimeException("Pneu com o número de fogo 99999 não encontrado"));

        // Verifica se a exceção é lançada
        RuntimeException exception = assertThrows(RuntimeException.class, () -> pneuController.obterPneuByNumeroDeFogo(99999L));
        assertEquals("Pneu com o número de fogo 99999 não encontrado", exception.getMessage());

        // Verifica que o serviço foi chamado uma vez
        verify(pneuService, times(1)).findByNumeroDeFogo(99999L);
    }
}
