package br.com.board.repository;

import br.com.board.model.Tarefa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaRepositoryImpl implements TarefaRepository {

    private final Connection conn;

    public TarefaRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void salvar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (titulo, descricao, status, data_criacao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setDate(4, Date.valueOf(tarefa.getDataCriacao()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar tarefa", e);
        }
    }

    @Override
    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tarefa tarefa = new Tarefa(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getDate("data_criacao").toLocalDate()
                );
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar tarefas", e);
        }
        return tarefas;
    }

    @Override
    public void atualizar(Tarefa tarefa) {
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setLong(4, tarefa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar tarefa", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar tarefa", e);
        }
    }

    @Override
    public Tarefa buscarPorId(Long id) {
        String sql = "SELECT * FROM tarefas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tarefa(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getDate("data_criacao").toLocalDate()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tarefa por ID", e);
        }
        return null;
    }
}
