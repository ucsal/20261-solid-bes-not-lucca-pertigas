package br.com.ucsal.olimpiadas.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.entity.ParticipanteEntity;

public class ParticipanteService {
	private final List<ParticipanteEntity> participantes = new ArrayList<>();
	private long proximoId = 1;
	
	public ParticipanteEntity cadastrar (String nome, String email) {
		
		ParticipanteEntity p = new ParticipanteEntity(proximoId, nome, email);
		p.setId(proximoId);
		
		participantes.add(p);
		 
		return p;
	}
}
