package com.TestPJC.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id_Artista;
	
	@NotBlank
	private String Nome_Artista;
	
	public long getId_Artista() {
		return Id_Artista;
	}

	public void setId_Artista(long id_Artista) {
		Id_Artista = id_Artista;
	}

	public String getNome_Artista() {
		return Nome_Artista;
	}

	public void setNome_Artista(String nome_Artista) {
		Nome_Artista = nome_Artista;
	}
}
