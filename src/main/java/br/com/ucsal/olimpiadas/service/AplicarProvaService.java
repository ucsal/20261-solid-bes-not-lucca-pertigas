package br.com.ucsal.olimpiadas.service;

import java.util.List;

import br.com.ucsal.olimpiadas.entity.QuestaoEntity;
import br.com.ucsal.olimpiadas.entity.TentativaEntity;

public class AplicarProvaService {
	private final QuestaoService questaoService;

	public AplicarProvaService(QuestaoService questaoService) {
		this.questaoService = questaoService;
	}
	
	public TentativaEntity aplicar (long participanteId, long provaId, List<Character> respostas) {
		
		List<QuestaoEntity> questoes = questaoService.buscarPorProva(provaId);
		
		if (questoes.isEmpty()) {
			throw new IllegalArgumentException("Sua prova não tem questões cadastradas");
		}
		
		if (respostas == null || respostas.size() != questoes.size()) {
			throw new IllegalArgumentException("Quantidade de respostas diferente com a quantidade de questoes");
		}
		
		TentativaEntity tentativa = new TentativaEntity();
		tentativa.setParticipanteId(participanteId);
		tentativa.setProvaId(provaId);
		
		for (int i = 0; i < questoes.size(); i++) {
			QuestaoEntity questao = questoes.get(i);
			char resposta = respostas.get(i);
			
			tentativa.responder(questao, resposta);
		}
		
		return tentativa;
	}
	
}
