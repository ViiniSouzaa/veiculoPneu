package com.project.veiculoPneu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.veiculoPneu.model.Pneu;
import com.project.veiculoPneu.model.repository.PneuRepository;
import com.project.veiculoPneu.service.PneuService;

@SpringBootTest
public class PneuServiceTest {

    @Autowired
    private PneuService pneuService;

    @Autowired
    private PneuRepository pneuRepository;

    @Test
    public void testSalvarPneu() {
        Pneu pneu = new Pneu();
        pneu.setNumeroDeFogo(123);
        pneu.setMarca("Michelin");
        pneu.setPressaoAtual(32);
        pneu.setStatus("Ativo");

        Pneu pneuSalvo = pneuService.salvarPneu(pneu);

        assertNotNull(pneuSalvo.getId());  // Verifica se o ID foi gerado
        assertEquals(Integer.valueOf(123), pneuSalvo.getNumeroDeFogo());  // Verifica o número de fogo
    }

    @Test
    public void testListarTodosPneus() {
        Pneu pneu1 = new Pneu();
        pneu1.setNumeroDeFogo(456);
        pneu1.setMarca("Pirelli");
        pneu1.setPressaoAtual(30);
        pneu1.setStatus("Ativo");

        pneuRepository.save(pneu1);

        List<Pneu> pneus = pneuService.listarTodosPneus();

        assertFalse(pneus.isEmpty());  // Verifica que a lista não está vazia
        assertTrue(pneus.size() > 0);  // Verifica que a lista tem ao menos um item
    }
}
