-- 	Inserção de dados de populacao

-- 	Inserção de veículos no banco de dados. 
/* 	Cada veículo tem um ID único e as informações associadas (placa, 
	marca, quilometragem, status e tipo).
*/

INSERT INTO veiculos (placa, marca, quilometragem, status, tipo) VALUES
('ABC1234', 'Toyota', 50000, 'Ativo', 'Carro'),
('XYZ9876', 'Ford', 30000, 'Ativo', 'Carro'),
('LMN4567', 'Harley', 20000, 'Ativo', 'Moto'),
('JKL8520', 'Mercedes', 100000, 'Ativo', 'Truck'),
('OPQ3210', 'Fiat', 45000, 'Ativo', 'Carro'),
('RST6543', 'Honda', 25000, 'Em manutenção', 'Moto'),
('UVW7890', 'Volkswagen', 80000, 'Ativo', 'Carro'),
('DEF5678', 'BMW', 150000, 'Ativo', 'Truck'),
('GHI4321', 'Suzuki', 20000, 'Inativo', 'Moto');


-- 	Inserção de pneus
-- 	Cada pneu tem um número de fogo (ID único) e uma marca associada
-- 	A pressão é definida aleatoriamente para simular uma situação mais realista
INSERT INTO pneus (numero_de_fogo, marca, pressao_atual, status) VALUES
(1000, 'Michelin', 32, 'Ativo'),
(1001, 'Pirelli', 30, 'Ativo'),
(1002, 'Bridgestone', 35, 'Ativo'),
(1003, 'Goodyear', 33, 'Ativo'),
(1004, 'Dunlop', 32, 'Ativo'),
(1005, 'Michelin', 30, 'Ativo'),
(1006, 'Pirelli', 31, 'Ativo'),
(1007, 'Bridgestone', 34, 'Ativo'),
(1008, 'Goodyear', 32, 'Ativo'),
(1009, 'Dunlop', 33, 'Ativo'),
(1010, 'Michelin', 32, 'Ativo'),
(1011, 'Pirelli', 30, 'Ativo'),
(1012, 'Bridgestone', 35, 'Ativo'),
(1013, 'Goodyear', 33, 'Ativo'),
(1014, 'Dunlop', 32, 'Ativo'),
(1015, 'Michelin', 30, 'Ativo'),
(1016, 'Pirelli', 31, 'Ativo'),
(1017, 'Bridgestone', 34, 'Ativo'),
(1018, 'Goodyear', 32, 'Ativo'),
(1019, 'Dunlop', 33, 'Ativo'),
(1020, 'Michelin', 32, 'Ativo'),
(1021, 'Pirelli', 30, 'Ativo'),
(1022, 'Bridgestone', 35, 'Ativo'),
(1023, 'Goodyear', 33, 'Ativo'),
(1024, 'Dunlop', 32, 'Ativo'),
(1025, 'Michelin', 30, 'Ativo'),
(1026, 'Pirelli', 31, 'Ativo'),
(1027, 'Bridgestone', 34, 'Ativo'),
(1028, 'Goodyear', 32, 'Ativo'),
(1029, 'Dunlop', 33, 'Ativo'),
(1030, 'Michelin', 32, 'Ativo'),
(1031, 'Pirelli', 30, 'Ativo'),
(1032, 'Bridgestone', 35, 'Ativo'),
(1033, 'Goodyear', 33, 'Ativo'),
(1034, 'Dunlop', 32, 'Ativo'),
(1035, 'Michelin', 30, 'Ativo'),
(1036, 'Pirelli', 31, 'Ativo'),
(1037, 'Bridgestone', 34, 'Ativo'),
(1038, 'Goodyear', 32, 'Inativo'),
(1039, 'Dunlop', 33, 'Inativo'),
(1040, 'Michelin', 32, 'Inativo'),
(1041, 'Pirelli', 30, 'Inativo'),
(1042, 'Bridgestone', 35, 'Inativo');

-- Veículo XYZ9876 (Carro) 
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('XYZ9876', 1004, 'A'),
('XYZ9876', 1005, 'B'),
('XYZ9876', 1006, 'C'),
('XYZ9876', 1007, 'D');

-- Veículo LMN4567 (Moto)
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('LMN4567', 1008, 'A'),
('LMN4567', 1009, 'B');

-- Veículo JKL8520 (Truck)
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('JKL8520', 1010, 'A'),
('JKL8520', 1011, 'B'),
('JKL8520', 1012, 'C'),
('JKL8520', 1013, 'D'),
('JKL8520', 1014, 'E'),
('JKL8520', 1015, 'F');

-- Veículo OPQ3210 (Carro) 
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('OPQ3210', 1016, 'A'),
('OPQ3210', 1017, 'B'),
('OPQ3210', 1018, 'C'),
('OPQ3210', 1019, 'D');

-- Veículo RST6543 (Moto)
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('RST6543', 1020, 'A'),
('RST6543', 1021, 'B');

-- Veículo UVW7890 (Carro)
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('UVW7890', 1022, 'A'),
('UVW7890', 1023, 'B'),
('UVW7890', 1024, 'C'),
('UVW7890', 1025, 'D');

-- Veículo DEF5678 (Truck) 
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('DEF5678', 1026, 'A'),
('DEF5678', 1027, 'B'),
('DEF5678', 1028, 'C'),
('DEF5678', 1029, 'D'),
('DEF5678', 1030, 'E'),
('DEF5678', 1031, 'F');

-- Veículo GHI4321 (Moto)
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('GHI4321', 1032, 'A'),
('GHI4321', 1033, 'B');

-- Veículo ABC1234 (Carro)
INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES
('ABC1234', 1034, 'A'),
('ABC1234', 1035, 'B'),
('ABC1234', 1036, 'C'),
('ABC1234', 1037, 'D');