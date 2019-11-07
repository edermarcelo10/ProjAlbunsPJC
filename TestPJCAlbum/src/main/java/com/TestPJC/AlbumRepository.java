package com.TestPJC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * CLASSE RESPONSAVEL POR PERSISTIR AS INFORMACOES DO ALBUM NA BASE DE DADOS
 * @author Eder Marcelo B. Nascimento
 *
 */

@Repository
public class AlbumRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * ESSE METODO CADASTRA UM NOVO ALBUM	
	 * @param Artista
	 * @return
	 */
	public ResultadoModel InsereAlbum(String Nome, int Id_Artista){
 
		try 
		{
			jdbcTemplate.update(QuerysRepository.INSERIR_ALBUM, Nome, Id_Artista);
		} 
		catch (Exception e) 
		{
 			return new ResultadoModel(0, "Falha ao tentar realizar o cadastro do album! detalhe:" + e.getMessage());	
		}
 
		return new ResultadoModel (1, "Album cadastrado com sucesso!");
	}
	
	
	
	
	/**
	 * ESSE METODO RETORNAR TODOS OS ALBUNS CADASTRADOS
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Album> SelecionaListaAlbuns()
	{ 
		return jdbcTemplate.query(QuerysRepository.CONSULTAR_ALBUNS, new BeanPropertyRowMapper(Album.class));
	}
	
	
	
	
	/**
	 * ESSE METODO RETORNA UM ALBUM CADASTRADO PELO ID DO ALBUM E PELO ID DO ARTISTA
	 * @param ID
	 * @return
	 */
	public Album SelecionaAlbum(int ID_ALBUM, int ID_ARTISTA)
	{
		String Query = "SELECT * FROM CAD_ALBUNS";
		Boolean Where = false;
		
		if (ID_ALBUM > 0)
		{ Query = Query + " WHERE ID_ALBUM = " + Integer.toString(ID_ALBUM); Where = true; }
		
		if (ID_ARTISTA > 0)
		{
			if (Where)
			{ Query = Query + "AND ID_ARTISTA = " + Integer.toString(ID_ARTISTA); }
			else
			{ Query = Query + "WHERE ID_ARTISTA = " + Integer.toString(ID_ARTISTA); }
		}
		return jdbcTemplate.queryForObject(Query, new BeanPropertyRowMapper<Album>(Album.class),ID_ALBUM);
	}
	
	
	
	/**
	 * ATUALIZA AS INFORMACOES DO ALBUM
	 * @return
	 */
	public ResultadoModel AtualizaAlbum(Integer ID, String Nome, Integer ID_ARTISTA){
 
		try 
		{ 
			jdbcTemplate.update(QuerysRepository.ATUALIZAR_ALBUM, Nome, ID_ARTISTA, ID); 
		} 
		catch (Exception e) 
		{
			return new ResultadoModel(0, "Falha ao tentar atualizar o cadastro do album! detalhe:" + e.getMessage());	
		}
 
		return new ResultadoModel(1, "Cadastro do album atualizado com sucesso!");
	}
	
	
	
	
	/**
	 * EXCLUI UM ALBUM PELO CODIGO
	 * @param ID
	 * @return
	 */
	public ResultadoModel ExcluirAlbum(int ID){
 
		try 
		{
			jdbcTemplate.update(QuerysRepository.EXCLUIR_ALBUM, ID); 
		} 
		catch (Exception e) 
		{
			return new ResultadoModel(0,"Erro ao tentar excluir o cadastro do album! detalhe:" + e.getMessage());	
		}
 
		return new ResultadoModel(1,"Cadastro do album excluido com sucesso!");
	}
}
