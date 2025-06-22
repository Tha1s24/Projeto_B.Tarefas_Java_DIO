package br.com.board;

import br.com.board.controller.TarefaController;
import br.com.board.repository.TarefaRepositoryImpl;
import br.com.board.service.TarefaService;
import br.com.board.util.Conexao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConnection()) {
            var repo = new TarefaRepositoryImpl(conn);
            var service = new TarefaService(repo);
            var controller = new TarefaController(service);
            controller.iniciar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
