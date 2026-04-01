package br.com.ucsal.olimpiadas.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.entity.QuestaoEntity;

public class QuestaoService {

		private final List<QuestaoEntity> questoes = new ArrayList<>();
		private long proximoId = 1;
		
		public QuestaoEntity cadastrarQuestao (long provaId, String enunciado, String[] alternativas, char alternativaCorreta) {
			QuestaoEntity q = new QuestaoEntity(proximoId, provaId, enunciado, alternativas, alternativaCorreta);
			
			q.setId(proximoId++);
			
			questoes.add(q);
			
			proximoId++;
			
			return q;
		}
		
		public List<QuestaoEntity> buscarPorProva(Long provaId) {
	        return questoes.stream()
	                .filter(q -> q.getProvaId() == provaId)
	                .toList();
	    }
}
