package br.com.ucsal.olimpiadas.command;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.service.ParticipanteService;

public class ParticipanteCommand implements Command{
	private final Scanner in;
	private final ParticipanteService participanteService;
	
	public ParticipanteCommand(Scanner in, ParticipanteService participanteService) {
		this.in = in;
		this.participanteService = participanteService;
	}
	
	@Override
	public void executar() {
		System.out.println("Digite seu nome: ");
		String nome = in.nextLine();
		
		System.out.println("Digite seu email (Opcional)");
		String email = in.nextLine();
		
		try {
	        var p = participanteService.cadastrar(nome, email);
	        System.out.println("Participante cadastrado com sucesso ID - " + p.getId());
	    } catch (IllegalArgumentException e) {
	        System.out.println(e.getMessage());
	    }
		
	}
	
}
