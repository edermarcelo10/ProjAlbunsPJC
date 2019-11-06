package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.Artista;
import com.models.ResultadoModel;
import com.repository.ArtistaRepository;
//import com.repository.QuerysRepository;

/**
 * CLASSE RESPONSÁVEL POR DISPONIBILIZAR OS MÉTODOS VIA HTTP COMO SERVIÇO REST
 * @author Eder Marcelo B. Nascimento
 *
 */

@RestController
@RequestMapping("/service")
public class Service {
	/*INJEÇÃO DE DEPÊNDENCIA*/
	@Autowired
	private ArtistaRepository ArtistaRepository;
 
 
	
	
	
	
	/**
	 * ESSE MÉTODO CADASTRA UM NOVO ARTISTA COMO MOSTRA O EXEMPLO ABAIXO.
	 * 
	 * EXEMPLO:
	 * 
	 * 	URL: http://localhost:8080/service/Artista
	 * 
	 *  REQUEST JSON:
	 *  			{
	 *  				"Id_Artista":1,
	 *  				"Nome_Artista":"Eder"
	 *  			}
	 *  
	 *  
	 *  RESPONSE JSON:
	 *  			{
	 *  				"ID": 1,
	 *  				"MSG": "Registro cadastrado com sucesso!"
	 *  			}
	 *  
	 *  
	 * 
	 * */
	@RequestMapping(value="/Artista", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResultadoModel InserirArtista(@RequestBody Artista Artista)
	{
		return this.ArtistaRepository.InsereArtista(Artista);
	}
 
	
	
	
	
	
	
 
	/**
	 * ATUALIZA UM ARTISTA COMO MOSTRA O EXEMPLO ABAIXO.
	 * 
	 * EXEMPLO: 
	 * 	 
	 * 	 URL: http://localhost:8080/service/Artista
	 * 	 
	 *   REQUEST JSON:   
	 *				{
	 *					"Id_Artista": 1,
	 *					"Nome_Artista": "Eder"
	 *				}
	 *      
	 *      
	 *   RESPONSE JSON:
	 *				{
	 *					"ID": 1,
	 *					"MSG": "Registro atualizado com sucesso!"
	 *				}
	 *         
	 *         
	 *         
	 *         
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/Artista", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResultadoModel AtualizaArtista(@RequestBody Artista Artista)
	{
		return this.ArtistaRepository.AtualizaArtista(Artista);
	}
 
	
	
	
	
	
	
	
 
	/**
	 * CONSULTA TODOS OS ARTISTAS CADASTRADOS COMO MOSTRA O EXEMPLO ABAIXO
	 * 
	 * EXEMPLO:
	 * 	 URL:http://localhost:8080/service/Artista
	 * 
	 *   RESPONSE JSON:
	 *				[
	 *					{
//	 *					  "Id_Artista": 1,
	 *					  "Nome_Artista": "Eder"
	 *					  },
	 *					  {
	 *					  "Id_Artista": 2,
	 *					  "Nome_Artista": "Eder 2"
	 *					  }
	 *				]   	
	 *   
	 *   
	 * 
	 * @return
	 */
	@RequestMapping(value="/Artista",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Artista> SelecionaListaArtistas()
	{
		return this.ArtistaRepository.SelecionaListaArtistas(); 
	}
 
	
	
	
	
	
	
	
	/**
	 * SELECIONA UM ARTISTA PELO CÓDIGO COMO MOSTRA O EXEMPLO ABAIXO
	 * 
	 * EXEMPLO:
	 *   
	 *   URL REQUEST:http://localhost:8080/service/Artista/1
	 *   
	 *   
	 *   RESPONSE JSON:
	 *   		{
	 *   			"Id_Artista": 1,
	 *   			"Nome_Artista": "Eder"
	 *   		}
	 *   		
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/Artista/{Id_Artista}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Artista SelecionaArtista(@PathVariable("Id_Artista") Integer Id_Artista)
	{ 
		return this.ArtistaRepository.SelecionaArtista(Id_Artista);
	}
 
	
	
	
	
	
	
	/**
	 * EXCLUI UM ARTISTA PELO CÓDIGO COMO MOSTRA O EXEMPLO ABAIXO;
	 * 
	 * EXEMPLO:
	 * 	
	 * 	URL REQUEST:http://localhost:8080/service/Artista/1
	 * 
	 * 	RESPONSE JSON:
	 * 				{
	 * 					"ID": 1,
	 * 					"MSG": "Registro excluido com sucesso!"
	 * 				}
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/Artista/{Id_Artista}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResultadoModel ExcluiArtista(@PathVariable("Id_Artista") Integer Id_Artista)
	{ 
		return this.ArtistaRepository.ExcluirArtista(Id_Artista);
	}
}
