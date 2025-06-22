CREATE DATABASE IF NOT EXISTS board_tarefas;
USE board_tarefas;

CREATE TABLE IF NOT EXISTS tarefas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(10) DEFAULT 'TODO',
    data_criacao DATE NOT NULL
);
