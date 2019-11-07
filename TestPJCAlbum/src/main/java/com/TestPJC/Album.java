package com.TestPJC;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id_Album;
	
	@NotBlank
	private String Descricao_Album;
	
	@NotBlank
	private long Id_Artista;

	public long getId_Album() {
		return Id_Album;
	}

	public void setId_Album(long id_Album) {
		Id_Album = id_Album;
	}

	public String getDescricao_Album() {
		return Descricao_Album;
	}

	public void setDescricao_Album(String descricao_Album) {
		Descricao_Album = descricao_Album;
	}

	public long getId_Artista() {
		return Id_Artista;
	}

	public void setId_Artista(long id_Artista) {
		Id_Artista = id_Artista;
	}
}
