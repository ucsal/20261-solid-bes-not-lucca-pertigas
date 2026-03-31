package br.com.ucsal.olimpiadas.entity;

import java.util.ArrayList;
import java.util.List;

public class TentativaEntity {
	private long id;
	private long participanteId;
	private long provaId;

	private final List<RespostaEntity> respostas = new ArrayList<>();
	
	public void responder(QuestaoEntity q, char marcada) {
		RespostaEntity r = new RespostaEntity();
		r.setQuestaoId(q.getId());
		r.setAlternativaMarcada(marcada);
		r.setCorreta(q.isRespostaCorreta(marcada));
		
		respostas.add(r);
	}
	
	public int calcularNota() {
		int acertos = 0;
		
		for (RespostaEntity r : respostas) {
			if (r.isCorreta()) {
				acertos++;
			}
		}
		return acertos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(long participanteId) {
		this.participanteId = participanteId;
	}

	public long getProvaId() {
		return provaId;
	}

	public void setProvaId(long provaId) {
		this.provaId = provaId;
	}

	public List<RespostaEntity> getRespostas() {
		return respostas;
	}
}
