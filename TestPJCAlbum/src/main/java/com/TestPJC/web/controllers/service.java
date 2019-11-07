package com.TestPJC.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TestPJC.models.Album;
import com.TestPJC.models.Artista;
import com.TestPJC.models.ResultadoModel;
import com.TestPJC.repository.AlbumRepository;
import com.TestPJC.repository.ArtistaRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class service {
	
	/* Metodos CRUD da tabela CAD_ARTISTA
	 * Autor: Eder Marcelo
	 * */
	@Autowired
	private ArtistaRepository ArtistaRepository = new ArtistaRepository();

	@RequestMapping(value="/InsereArtista")
	public ResultadoModel InsereArtista (@RequestParam(value="Nome") String Nome){
 
		return this.ArtistaRepository.InsereArtista(Nome);
	}
	
	@RequestMapping(value="/AtualizaArtista")
	public @ResponseBody ResultadoModel AtualizaArtista(@RequestParam(value="Nome") String Nome, @RequestParam(value="ID") Integer ID){
 
		return this.ArtistaRepository.AtualizaArtista(ID, Nome);
	}
	
	@RequestMapping(value="/ExcluirArtista")
	public @ResponseBody ResultadoModel ExcluirArtista(@RequestParam(value="ID") Integer ID){
 
		return this.ArtistaRepository.ExcluirArtista(ID);
	}
		
	
	
	
	
	
	/* Metodos CRUD da tabela CAD_ALBUM
	 * Autor: Eder Marcelo
	 * */
	@Autowired
	private AlbumRepository AlbumRepository = new AlbumRepository();

	@RequestMapping(value="/InsereAlbum")
	public ResultadoModel InsereAlbum (@RequestParam(value="Descricao") String Descricao, @RequestParam(value="Id_Artista") int Id_Artista){
 
		return this.AlbumRepository.InsereAlbum(Descricao, Id_Artista);
	}
	
	@RequestMapping(value="/AtualizaAlbum")
	public @ResponseBody ResultadoModel AtualizaAlbum(@RequestParam(value="ID") Integer ID, @RequestParam(value="Descricao") String Descricao, @RequestParam(value="Id_Artista") Integer Id_Artista){
 
		return this.AlbumRepository.AtualizaAlbum(ID, Descricao, Id_Artista);
	}
	
	@RequestMapping(value="/ExcluirAlbum")
	public @ResponseBody ResultadoModel ExcluirAlbum(@RequestParam(value="ID") Integer ID){
 
		return this.AlbumRepository.ExcluirAlbum(ID);
	}
		
	@RequestMapping(value="/SelecionaListaAlbuns")
	public List<Album> SelecionaListaAlbuns(@RequestParam(value="Id_Album", required=false) String Id_Album, 
			                                @RequestParam(value="Id_Artista", required=false) String Id_Artista, 
			                                @RequestParam(value="Nome_Artista", required=false) String Nome_Artista,
			                                @RequestParam(value="orderType", required=false) String orderType,
			                                @RequestParam(value="orderColumnName", required=false) String orderColumnName)
	{
		return this.AlbumRepository.SelecionaListaAlbuns(Id_Album, Id_Artista, Nome_Artista, orderType, orderColumnName); 
	}
}
