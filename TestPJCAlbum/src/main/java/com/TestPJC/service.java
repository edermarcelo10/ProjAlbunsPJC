package com.TestPJC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class service {
	
	/* Metodos CRUD da tabela CAD_ARTISTA
	 * Autor: Eder Marcelo
	 * */
	@Autowired
	private ArtistaRepository ArtistaRepository = new ArtistaRepository();

	@RequestMapping(value="/InsereArtista/{Nome}")
	public ResultadoModel InsereArtista (@PathVariable("Nome") String Nome){
 
		return this.ArtistaRepository.InsereArtista(Nome);
	}
	
	@RequestMapping(value="/AtualizaArtista/{ID}/{Nome}")
	public @ResponseBody ResultadoModel AtualizaArtista(@PathVariable("Nome") String Nome, @PathVariable("ID") Integer ID){
 
		return this.ArtistaRepository.AtualizaArtista(ID, Nome);
	}
	
	@RequestMapping(value="/ExcluirArtista/{ID}")
	public @ResponseBody ResultadoModel ExcluirArtista(@PathVariable("ID") Integer ID){
 
		return this.ArtistaRepository.ExcluirArtista(ID);
	}
		
	@RequestMapping(value="/SelecionaListaArtistas")
	public List<Artista> SelecionaListaArtistas()
	{
		return this.ArtistaRepository.SelecionaListaArtistas(); 
	}
	
	@RequestMapping(value="/SelecionaArtista/{ID}")
	public @ResponseBody Artista SelecionaArtista(@PathVariable("ID") Integer ID){
 
		return this.ArtistaRepository.SelecionaArtista(ID);
	}
	
	/* Metodos CRUD da tabela CAD_ALBUM
	 * Autor: Eder Marcelo
	 * */
	@Autowired
	private AlbumRepository AlbumRepository = new AlbumRepository();

	@RequestMapping(value="/InsereAlbum/{Descricao}/{Id_Artista}")
	public ResultadoModel InsereAlbum (@PathVariable("Descricao") String Descricao, @PathVariable("Id_Artista") int Id_Artista){
 
		return this.AlbumRepository.InsereAlbum(Descricao, Id_Artista);
	}
	
	@RequestMapping(value="/AtualizaAlbum/{ID}/{Descricao}/Id_Artista}")
	public @ResponseBody ResultadoModel AtualizaAlbum(@PathVariable("ID") Integer ID, @PathVariable("Descricao") String Descricao, @PathVariable("Id_Artista") Integer Id_Artista){
 
		return this.AlbumRepository.AtualizaAlbum(ID, Descricao, Id_Artista);
	}
	
	@RequestMapping(value="/ExcluirAlbum/{ID}")
	public @ResponseBody ResultadoModel ExcluirAlbum(@PathVariable("ID") Integer ID){
 
		return this.AlbumRepository.ExcluirAlbum(ID);
	}
		
	@RequestMapping(value="/SelecionaListaAlbuns")
	public List<Album> SelecionaListaAlbuns()
	{
		return this.AlbumRepository.SelecionaListaAlbuns(); 
	}
	
	@RequestMapping(value="/SelecionaAlbum/{ID}/{Id_Artista}")
	public @ResponseBody Album SelecionaAlbum(@PathVariable("ID") Integer ID, @PathVariable("Id_Artista") Integer Id_Artista){
 
		return this.AlbumRepository.SelecionaAlbum(ID, Id_Artista);
	}
}
