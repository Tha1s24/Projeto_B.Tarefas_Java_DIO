package br.com.board.repository;

import br.com.board.model.Tarefa;
import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa tarefa);
    List<Tarefa> listar();
    void atualizar(Tarefa tarefa);
    void deletar(Long id);
    Tarefa buscarPorId(Long id);
}
