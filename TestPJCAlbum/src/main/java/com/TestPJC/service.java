package com.TestPJC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class service {
	/*INJEÇÃO DE DEPÊNDENCIA*/
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
}
