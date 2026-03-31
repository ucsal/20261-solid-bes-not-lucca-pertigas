package br.com.ucsal.olimpiadas.entity;

public class RespostaEntity {
	
	 private long questaoId;
	    private char alternativaMarcada;
	    private boolean correta;

	    public long getQuestaoId() {
	        return questaoId;
	    }

	    public void setQuestaoId(long questaoId) {
	        this.questaoId = questaoId;
	    }

	    public char getAlternativaMarcada() {
	        return alternativaMarcada;
	    }

	    public void setAlternativaMarcada(char alternativaMarcada) {
	        this.alternativaMarcada = normalizar(alternativaMarcada);
	    }

	    public boolean isCorreta() {
	        return correta;
	    }

	    public void setCorreta(boolean correta) {
	        this.correta = correta;
	    }
	    
	    private char normalizar(char c) {
	        char up = Character.toUpperCase(c);

	        if (up < 'A' || up > 'E') {
	            return 'X'; // resposta inválida
	        }

	        return up;
	    }
}
