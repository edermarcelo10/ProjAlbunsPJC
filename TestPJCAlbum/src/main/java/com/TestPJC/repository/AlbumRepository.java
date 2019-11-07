package com.TestPJC.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.TestPJC.models.Album;
import com.TestPJC.models.ResultadoModel;

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
	public List<Album> SelecionaListaAlbuns(String Id_Album, String Id_Artista, String Nome_Artista, String orderType, String orderColumn)
	{ 
		String Query =  " SELECT A.ID_ALBUM, A.DESCRICAO_ALBUM, A.ID_ARTISTA, AT.NOME_ARTISTA " +
						"   FROM CAD_ALBUM A " +
					    "  LEFT OUTER JOIN CAD_ARTISTA AT ON ( " +
						"    AT.ID_ARTISTA = A.ID_ARTISTA  " +
					    "  ) ";
		Boolean Where = false;
		
		if ((Id_Album != "") && (Id_Album != null)&& (Id_Album != "0"))
		{ Query = Query + " WHERE A.ID_ALBUM = " + Id_Album; Where = true; }
		
		if ((Id_Artista != "") && (Id_Artista != null)&& (Id_Artista != "0"))
		{
			if (Where)
			{ Query = Query + " AND A.ID_ARTISTA = " + Id_Artista; }
			else
			{ Query = Query + " WHERE A.ID_ARTISTA = " + Id_Artista; }
		}
		
		if ((Nome_Artista != "") && (Nome_Artista != null))
		{
			if (Where)
			{ Query = Query + " AND UPPER(AT.NOME_ARTISTA) LIKE '%" + Nome_Artista.toUpperCase() + "%'"; }
			else
			{ Query = Query + " WHERE UPPER(AT.NOME_ARTISTA) LIKE '%" + Nome_Artista.toUpperCase() + "%'"; }
		}
		
		if ((orderColumn != null) && (orderColumn != ""))
		{ Query = Query + "ORDER BY " + orderColumn.toUpperCase(); }
		else
		{ Query = Query + "ORDER BY NOME_ARTISTA "; }
		
		if ((orderType != null) && (orderType != ""))
		{ Query = Query  + " " + orderType.toUpperCase(); }
		else
		{ Query = Query + " ASC "; }
		
		return jdbcTemplate.query(Query, new BeanPropertyRowMapper(Album.class));
	}
	
	
	
	
	/**
	 * ESSE METODO RETORNA UM ALBUM CADASTRADO PELO ID DO ALBUM E PELO ID DO ARTISTA
	 * @param ID
	 * @return
	 */
	public Album SelecionaAlbum(int ID_ALBUM, int ID_ARTISTA)
	{
		String Query = "SELECT * FROM CAD_ALBUM ";
		Boolean Where = false;
		
		if (ID_ALBUM > 0)
		{ Query = Query + " WHERE ID_ALBUM = " + Integer.toString(ID_ALBUM); Where = true; }
		
		if (ID_ARTISTA > 0)
		{
			if (Where)
			{ Query = Query + " AND ID_ARTISTA = " + Integer.toString(ID_ARTISTA); }
			else
			{ Query = Query + " WHERE ID_ARTISTA = " + Integer.toString(ID_ARTISTA); }
		}
		return jdbcTemplate.queryForObject(Query, new BeanPropertyRowMapper<Album>(Album.class));
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
