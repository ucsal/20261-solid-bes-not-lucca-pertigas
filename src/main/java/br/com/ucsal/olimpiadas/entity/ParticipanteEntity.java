package br.com.ucsal.olimpiadas.entity;

public class ParticipanteEntity {
	private long id;
	private String nome;
	private String email;
	
	public ParticipanteEntity(long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isBlank() || nome == null) {
			throw new IllegalArgumentException("Nome invalido");
		}
		this.nome = nome.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.isBlank() || email == null) {
			this.email = null;
			return;
		}
		
		if (email.contains("@")) {
			throw new IllegalArgumentException("Email invalido");
		}
		
		this.email = email.trim();
	}
}
