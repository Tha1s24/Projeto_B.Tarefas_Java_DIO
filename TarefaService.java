package br.com.board.service;

import br.com.board.model.Tarefa;
import br.com.board.repository.TarefaRepository;

import java.time.LocalDate;
import java.util.List;

public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public void criarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setStatus("TODO");
        tarefa.setDataCriacao(LocalDate.now());
        repository.salvar(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listar();
    }

    public void atualizarTarefa(Long id, String novoTitulo, String novaDescricao, String novoStatus) {
        Tarefa tarefa = repository.buscarPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setStatus(novoStatus);
            repository.atualizar(tarefa);
        }
    }

    public void deletarTarefa(Long id) {
        repository.deletar(id);
    }
}
