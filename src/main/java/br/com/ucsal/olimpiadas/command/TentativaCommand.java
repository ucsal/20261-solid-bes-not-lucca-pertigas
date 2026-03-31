package br.com.ucsal.olimpiadas.command;

import br.com.ucsal.olimpiadas.entity.TentativaEntity;
import br.com.ucsal.olimpiadas.service.TentativaService;

public class TentativaCommand implements Command{
	private final TentativaService tentativaService;

	public TentativaCommand(TentativaService tentativaService) {
		this.tentativaService = tentativaService;
	}
	
	@Override
	public void executar() {
		if (tentativaService.vazio()) {
			System.out.println("Nenhuma tentativa encontrada");
			return;
		}
		
		System.out.println("Tentativas");
		
		for(TentativaEntity t : tentativaService.listar()) {
			int nota = t.calcularNota();
			
			System.out.printf("#%d | participante=%d | prova=%d | nota=%d/%d%n", t.getId(), t.getParticipanteId(), t.getProvaId(), nota, t.getRespostas().size());
		}
	}
	

}
