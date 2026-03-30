package br.com.ucsal.olimpiadas.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.entity.ProvaEntity;
import br.com.ucsal.olimpiadas.entity.QuestaoEntity;
import br.com.ucsal.olimpiadas.entity.TentativaEntity;

import br.com.ucsal.olimpiadas.service.ProvaService;
import br.com.ucsal.olimpiadas.service.QuestaoService;
import br.com.ucsal.olimpiadas.service.AplicarProvaService;

public class AplicarProvaCommand implements Command{
	private final Scanner in;
	private final ProvaService provaService;
	private final QuestaoService questaoService;
	private final AplicarProvaService aplicarProvaService;
	
	public AplicarProvaCommand(Scanner in, ProvaService provaService, QuestaoService questaoService,
			AplicarProvaService aplicarProvaService) {
		this.in = in;
		this.provaService = provaService;
		this.questaoService = questaoService;
		this.aplicarProvaService = aplicarProvaService;
	}
	
	public void executar() {
		if (provaService.possuiProvas()) {
			System.out.println("nenhuma prova cadastrada");
			return;
		}
		
		List<ProvaEntity> provas = provaService.listar();
		
		System.out.println("Provas disponiveis: ");
		for(ProvaEntity p : provas) {
			System.out.println(p.getId() + " - " + p.getTitulo());
		}
		
		Long provaId;
		try {
			System.out.println("Digite o ID da prova: ");
			provaId = Long.parseLong(in.nextLine());
		} catch (Exception e) {
			System.out.println("ID invalido");
			return;
		}
		
		List<QuestaoEntity> questoes = questaoService.buscarPorProva(provaId);

        if (questoes.isEmpty()) {
            System.out.println("Essa prova não possui questões");
            return;
        }
		
		List<Character> respostas = new ArrayList<>();
		
		System.out.println("Inicio da prova: ");
		
		for(QuestaoEntity q : questoes) {
			System.out.println("\nQuestao - " + q.getId());
			System.out.println(q.getEnunciado());
			
			for (String alt : q.getAlternativas()) {
				System.out.println(alt);
			}
			
			System.out.println("Resposta -> ");
			
			try {
                char resposta = QuestaoEntity.normalizar(in.nextLine().charAt(0));
                respostas.add(resposta);
            } catch (Exception e) {
                System.out.println("Resposta inválida, marcada como errada");
                respostas.add('X');
            }
			
			TentativaEntity tentativa = aplicarProvaService.aplicar(1L, provaId, respostas);
			
			System.out.println("Resultado: ");
	        System.out.println("Nota: " + tentativa.calcularNota() + "/" + questoes.size());
		}
		
	}
	
}
