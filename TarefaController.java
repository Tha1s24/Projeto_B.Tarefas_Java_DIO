package br.com.board.controller;

import br.com.board.model.Tarefa;
import br.com.board.service.TarefaService;

import java.util.Scanner;

public class TarefaController {

    private final TarefaService service;
    private final Scanner sc = new Scanner(System.in);

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n===== BOARD DE TAREFAS =====");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Deletar Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> criar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> deletar();
            }
        } while (opcao != 0);
    }

    private void criar() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        service.criarTarefa(titulo, descricao);
    }

    private void listar() {
        System.out.println("\n--- TAREFAS ---");
        for (Tarefa t : service.listarTarefas()) {
            System.out.printf("[%d] %s - %s (%s)%n",
                    t.getId(), t.getTitulo(), t.getDescricao(), t.getStatus());
        }
    }

    private void atualizar() {
        System.out.print("ID da tarefa: ");
        Long id = Long.parseLong(sc.nextLine());
        System.out.print("Novo título: ");
        String titulo = sc.nextLine();
        System.out.print("Nova descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Novo status (TODO, DOING, DONE): ");
        String status = sc.nextLine();
        service.atualizarTarefa(id, titulo, descricao, status);
    }

    private void deletar() {
        System.out.print("ID da tarefa a deletar: ");
        Long id = Long.parseLong(sc.nextLine());
        service.deletarTarefa(id);
    }
}
