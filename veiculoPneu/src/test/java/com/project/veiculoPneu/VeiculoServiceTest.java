package com.project.veiculoPneu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.veiculoPneu.model.Veiculo;
import com.project.veiculoPneu.model.repository.VeiculoRepository;
import com.project.veiculoPneu.service.VeiculoService;

@SpringBootTest
public class VeiculoServiceTest {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Test
    public void testSalvarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC1234");
        veiculo.setMarca("Ford");
        veiculo.setQuilometragem(1000);
        veiculo.setStatus("Ativo");

        Veiculo veiculoSalvo = veiculoService.salvarVeiculo(veiculo);

        assertNotNull(veiculoSalvo.getId());  // Verifica se o ID foi gerado
        assertEquals("ABC1234", veiculoSalvo.getPlaca());  // Verifica a placa
    }

    @Test
    public void testListarTodosVeiculos() {
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setPlaca("XYZ1234");
        veiculo1.setMarca("Chevrolet");
        veiculo1.setQuilometragem(5000);
        veiculo1.setStatus("Ativo");

        veiculoRepository.save(veiculo1);

        List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();

        assertFalse(veiculos.isEmpty());  // Verifica que a lista não está vazia
        assertTrue(veiculos.size() > 0);  // Verifica que a lista tem ao menos um item
    }
}