package br.com.ucsal.olimpiadas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.command.Command;

public class Menu {
	private final Scanner in;
	private final Map<String, Command> opcoes = new HashMap<>();
	
	public Menu(Scanner in) {
			this.in = in;
	}
	
	public void registrar(String tecla, Command command) {
		opcoes.put(tecla, command);
	}
	
	public void iniciar() {
		while(true) {
			exibirMenu();
			
			String opcao = in.nextLine();
			
			Command command = opcoes.get(opcao);
			
			if (command != null) {
				command.executar();
				
				if (opcao.equals("0")) {
					return;
				}
			} else {
				opcaoInvalida();
			}
		}
	}
	
	private void exibirMenu() {
		
		System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V2) ===");
        System.out.println("1) Cadastrar participante");
        System.out.println("2) Cadastrar prova");
        System.out.println("3) Cadastrar questão (A–E)");
        System.out.println("4) Aplicar prova");
        System.out.println("5) Listar tentativas (resumo)");
        System.out.println("0) Sair");
        System.out.print("> ");
        
	}
	
	private void opcaoInvalida() {
        System.out.println("Opção inválida, tente novamente!");
    }
}
