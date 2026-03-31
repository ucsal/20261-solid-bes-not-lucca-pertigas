package br.com.ucsal.olimpiadas.service;

import java.util.List;
import java.util.ArrayList;

import br.com.ucsal.olimpiadas.entity.TentativaEntity;

public class TentativaService {
	private final List<TentativaEntity> tentativas = new ArrayList<>();
	private long proximoId = 1;
	
	public void salvar(TentativaEntity tentativa) {
		tentativa.setId(proximoId++);
		tentativas.add(tentativa);
	}
	
	public List<TentativaEntity> listar() {
		return tentativas;
	}
	
	public boolean vazio() {
		return tentativas.isEmpty();
	}
}
