package br.com.ucsal.olimpiadas.command;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.service.ProvaService;

public class ProvaCommand implements Command{
	private final Scanner in;
	private final ProvaService provaService;
	
	public ProvaCommand(Scanner in, ProvaService provaService) {
		this.in = in;
		this.provaService = provaService;
	}
	
	@Override
	public void executar() {
		System.out.print("Título da prova: ");
		String titulo = in.nextLine();
		
		var p = provaService.cadastrarProva(titulo);
		
		System.out.println("Prova criada com sucesso ID - " + p.getId());
	}
	
}
