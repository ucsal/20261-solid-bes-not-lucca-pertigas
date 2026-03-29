package br.com.ucsal.olimpiadas.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.entity.ProvaEntity;

public class ProvaService {
	private final List<ProvaEntity> provas = new ArrayList<>();
	private long proximoId = 1;

	public ProvaEntity cadastrarProva(String titulo) {
		
		ProvaEntity p = new ProvaEntity(proximoId, titulo);
		
		p.setId(proximoId);
		
		provas.add(p);
		
		return p;
	}
	
	public List<ProvaEntity> listar() {
		return provas;
	}
	
}
