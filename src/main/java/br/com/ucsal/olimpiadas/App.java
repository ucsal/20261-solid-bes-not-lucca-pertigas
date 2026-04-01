package br.com.ucsal.olimpiadas;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.config.AppConfig;

public class App {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Menu menu = AppConfig.criarMenu(in);
		menu.iniciar();
	}
	
}