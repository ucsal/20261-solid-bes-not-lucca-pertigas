package br.com.ucsal.olimpiadas.command;

public class SairCommand implements Command{
	
	@Override
	public void executar() {
		System.out.println("Tchau !");
		return;
	}
}
