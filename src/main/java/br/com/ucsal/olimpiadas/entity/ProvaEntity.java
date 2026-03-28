package br.com.ucsal.olimpiadas.entity;

public class ProvaEntity {

	private long id;
	private String titulo;
	
	public ProvaEntity(long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == null || titulo.isBlank()) {
			throw new IllegalArgumentException("Necessidade de um titulo");
		}
		this.titulo = titulo;
	}

}
