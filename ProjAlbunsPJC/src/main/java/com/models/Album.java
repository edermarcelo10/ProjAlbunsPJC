package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id_Album;
	
	@NotNull
	private String Nome_Album;
	
	@NotNull
	private long Id_Artista;

	public long getId_Album() {
		return Id_Album;
	}

	public void setId_Album(long id_Album) {
		Id_Album = id_Album;
	}

	public String getNome_Album() {
		return Nome_Album;
	}

	public void setNome_Album(String nome_Album) {
		Nome_Album = nome_Album;
	}

	public long getId_Artista() {
		return Id_Artista;
	}

	public void setId_Artista(long id_Artista) {
		Id_Artista = id_Artista;
	}
	
}
