-- Criação das tabelas

-- Tabela de Veículos
CREATE TABLE veiculos (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(7) UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,
    quilometragem INT NOT NULL,
    status VARCHAR(20) NOT NULL
);

-- Tabela de Pneus
CREATE TABLE pneus (
    id SERIAL PRIMARY KEY,
    numero_de_fogo INT NOT NULL,
    marca VARCHAR(50) NOT NULL,
    pressao_atual INT NOT NULL,
    status VARCHAR(20) DEFAULT 'INATIVO'
);

-- Tabela de Relacionamento Veículo - Pneus
CREATE TABLE veiculo_pneus (
    id SERIAL PRIMARY KEY,
    veiculo_id INT NOT NULL,
    pneu_id INT NOT NULL,
    posicao VARCHAR(1) NOT NULL,  -- Ex: A, B, C, D
    FOREIGN KEY (veiculo_id) REFERENCES veiculos(id),
    FOREIGN KEY (pneu_id) REFERENCES pneus(id)
);

-- Inserção de dados de exemplo

INSERT INTO veiculos (placa, marca, quilometragem, status) VALUES
('ABC1234', 'Toyota', 50000, 'Ativo'),
('XYZ9876', 'Ford', 30000, 'Ativo');

INSERT INTO pneus (numero_de_fogo, marca, pressao_atual, status) VALUES
(188, 'Michelin', 32, 'Inativo'),
(189, 'Pirelli', 30, 'Inativo');

INSERT INTO veiculo_pneus (veiculo_id, pneu_id, posicao) VALUES
(1, 1, 'A'),
(1, 2, 'B');