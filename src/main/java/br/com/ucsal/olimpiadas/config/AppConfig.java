package br.com.ucsal.olimpiadas.config;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.command.*;
import br.com.ucsal.olimpiadas.service.*;
import br.com.ucsal.olimpiadas.Menu;

public class AppConfig {
	public static Menu criarMenu (Scanner in) {
		
		ParticipanteService participanteService = new ParticipanteService();
		ProvaService provaService = new ProvaService();
		QuestaoService questaoService = new QuestaoService();
		TentativaService tentativaService = new TentativaService();
		AplicarProvaService aplicarProvaService = new AplicarProvaService(questaoService, tentativaService);
		
		Menu menu = new Menu(in);
		
		menu.registrar("1", new ParticipanteCommand(in, participanteService));
		menu.registrar("2", new ProvaCommand(in, provaService));
		menu.registrar("3", new QuestaoCommand(in, questaoService, provaService));
		menu.registrar("4", new AplicarProvaCommand(in, provaService, questaoService, aplicarProvaService));
		menu.registrar("5", new TentativaCommand(tentativaService));
		menu.registrar("0", new SairCommand());
		
		return menu;
	}
}
