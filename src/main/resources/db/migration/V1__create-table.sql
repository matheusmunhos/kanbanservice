-- Criação da tabela "gestores"
CREATE TABLE gestores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL
);

-- Criação da tabela "funcionarios"
CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    gestor_id INT,
    FOREIGN KEY (gestor_id) REFERENCES gestores(id)
);

-- Criação da tabela "tarefas"
CREATE TABLE tarefas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(255) NOT NULL,
    funcionario_id INT,
    FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);
