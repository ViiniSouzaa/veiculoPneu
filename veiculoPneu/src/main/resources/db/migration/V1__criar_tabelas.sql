-- Criação das tabelas

-- Tabela de Veículos
CREATE TABLE veiculos (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(7) UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,
    quilometragem INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    tipo VARCHAR(20) NOT NULL  
);

-- Tabela de Pneus
CREATE TABLE pneus (
    id SERIAL PRIMARY KEY,
    numero_de_fogo INT UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,
    pressao_atual INT NOT NULL,
    status VARCHAR(20) DEFAULT 'INATIVO'
);

-- Tabela de Relacionamento Veículo - Pneus
CREATE TABLE veiculo_pneus (
    placa_veiculo VARCHAR(7) NOT NULL,  
    numero_fogo INT NOT NULL,  
    posicao VARCHAR(1) NOT NULL,  -- Ex: A, B, C, D
    PRIMARY KEY (placa_veiculo, numero_fogo),  -- Chave primária composta
    FOREIGN KEY (placa_veiculo) REFERENCES veiculos(placa),
    FOREIGN KEY (numero_fogo) REFERENCES pneus(numero_de_fogo),
    CONSTRAINT uq_pneu_veiculo UNIQUE (numero_fogo)  -- Garantir que um pneu não se repita 
);