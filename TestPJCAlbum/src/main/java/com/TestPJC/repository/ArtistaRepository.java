package com.TestPJC.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.TestPJC.models.Artista;
import com.TestPJC.models.ResultadoModel;

//import com.models.Artista;
//import com.models.ResultadoModel;

/**
 * CLASSE RESPONS�?VEL POR PERSISTIR AS INFORMAÇÕES DO ARTISTA NA BASE DE DADOS
 * @author Eder Marcelo B. Nascimento
 *
 */

@Repository
public class ArtistaRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * ESSE MÉTODO CADASTRA UM NOVO ARTISTA	
	 * @param Artista
	 * @return
	 */
	public ResultadoModel InsereArtista(String Nome){
 
		try 
		{
			jdbcTemplate.update(QuerysRepository.INSERIR_ARTISTA, Nome);
		} 
		catch (Exception e) 
		{
 			return new ResultadoModel(0, "Falha ao tentar realizar o cadastro do artista! detalhe:" + e.getMessage());	
		}
 
		return new ResultadoModel (1, "Artista cadastrado com sucesso!");
	}
	
	
	
	
	/**
	 * ESSE MÉTODO RETORNAR TODOS OS ARTISTAS CADASTRADOS
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Artista> SelecionaListaArtistas()
	{ 
		return jdbcTemplate.query(QuerysRepository.CONSULTAR_ARTISTAS, new BeanPropertyRowMapper(Artista.class));
	}
	
	
	
	
	/**
	 * ESSE MÉTODO RETORNA UM ARTISTA CADASTRADO PELO ID
	 * @param ID
	 * @return
	 */
	public Artista SelecionaArtista(int ID)
	{
		return jdbcTemplate.queryForObject(QuerysRepository.SELECIONAR_ARTISTA, new BeanPropertyRowMapper<Artista>(Artista.class),ID);
	}
	
	
	
	/**
	 * ATUALIZA AS INFORMAÇÕES DO ARTISTA
	 * @param Artista
	 * @return
	 */
	public ResultadoModel AtualizaArtista(Integer ID, String Nome){
 
		try 
		{ 
			jdbcTemplate.update(QuerysRepository.ATUALIZAR_ARTISTA, Nome, ID); 
		} 
		catch (Exception e) 
		{
			return new ResultadoModel(0, "Falha ao tentar atualizar o cadastro do artista! detalhe:" + e.getMessage());	
		}
 
		return new ResultadoModel(1, "Cadastro do artista atualizado com sucesso!");
	}
	
	
	
	
	/**
	 * EXCLUI UM ARTISTA PELO CODIGO
	 * @param ID
	 * @return
	 */
	public ResultadoModel ExcluirArtista(int ID){
 
		try 
		{
			jdbcTemplate.update(QuerysRepository.EXCLUIR_ARTISTA, ID); 
		} 
		catch (Exception e) 
		{
			return new ResultadoModel(0,"Erro ao tentar excluir o cadastro do artista! detalhe:" + e.getMessage());	
		}
 
		return new ResultadoModel(1,"Cadastro do artista excluido com sucesso!");
	}
}
