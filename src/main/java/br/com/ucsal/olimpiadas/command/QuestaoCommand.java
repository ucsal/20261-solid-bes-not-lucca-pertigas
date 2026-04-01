package br.com.ucsal.olimpiadas.command;

import java.util.Scanner;
import java.util.List;

import br.com.ucsal.olimpiadas.entity.ProvaEntity;

import br.com.ucsal.olimpiadas.service.QuestaoService;
import br.com.ucsal.olimpiadas.service.ProvaService;

public class QuestaoCommand implements Command{
	private final Scanner in;
	private final QuestaoService questaoService;
	private final ProvaService provaService;
	
	public QuestaoCommand(Scanner in, QuestaoService questaoService, ProvaService provaService) {
		this.in = in;
		this.questaoService = questaoService;
		this.provaService = provaService;
	}
	
	public void executar() {
		
		List<ProvaEntity> provas = provaService.listar();
		
		if (!provaService.possuiProvas()) {
			System.out.println("Nenhuma prova cadastrada");
			return;
		}
		
		System.out.println("Provas disponiveis: ");
		for (ProvaEntity p : provas) {
			System.out.println(p.getId() + " - " + p.getTitulo());
		}
		
		System.out.println("Digite o ID da prova que voce quer: ");
		Long provaId;
		
		try {
			provaId = Long.parseLong(in.nextLine());
		} catch (Exception e) {
			System.out.println("ID invalido");
			return;
		}
		
		System.out.println("Digite o enunciado: ");
		String enunciado = in.nextLine();
		
		String[] alternativas = new String[5];
		
		for (int i = 0; i < 5; i++) {
			char letra = (char) ('A' + i);
			System.out.println("Alternativa " + letra + ": ");
			alternativas[i] = letra + ") " + in.nextLine();
		}
		char correta;
		
		while (true) {
			try {
				System.out.println("Qual a alternativa correta (A - E): ");
				String entrada = in.nextLine().toUpperCase();
				
				if(entrada.length() != 1 || entrada.charAt(0) < 'A' || entrada.charAt(0) > 'E') {
					throw new IllegalArgumentException("Alternativa invalida");
				}
				
				correta = entrada.charAt(0);
				break;
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Alternativa correta escolhida: " + correta);
		
		var questao = questaoService.cadastrarQuestao(provaId, enunciado, alternativas, correta);
		
		System.out.println("Questao cadastrada com sucesso ID - " + questao.getId());
	}
	
}
