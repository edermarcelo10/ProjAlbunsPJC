package com.TestPJC.repository;

public class QuerysRepository {
	
	/*INSERIR UM NOVO ARTISTA*/
	public static final String INSERIR_ARTISTA = "INSERT INTO CAD_ARTISTA(NOME_ARTISTA) VALUES(?)";
 
	/*CONSULTAR TODOS ARTISTAS*/
	public static final String CONSULTAR_ARTISTAS = "SELECT ID_ARTISTA, NOME_ARTISTA FROM CAD_ARTISTA";
 
	/*SELECIONAR UM ARTISTA PELO CODIGO*/
	public static final String SELECIONAR_ARTISTA = "SELECT ID_ARTISTA, NOME_ARTISTA FROM CAD_ARTISTA WHERE ID_ARTISTA = ?";
 
	/*EXCLUIR UM ARTISTA PELO CODIGO*/
	public static final String EXCLUIR_ARTISTA =" DELETE FROM CAD_ARTISTA WHERE ID_ARTISTA = ?";
 
	/*ATUALIZAR INFORMACOES DO ARTISTA PELO CODIGO*/
	public static final String ATUALIZAR_ARTISTA = "UPDATE CAD_ARTISTA SET NOME_ARTISTA = ? WHERE ID_ARTISTA= ? ";
	
	/*INSERIR UM NOVO ALBUM*/
	public static final String INSERIR_ALBUM = "INSERT INTO CAD_ALBUM(DESCRICAO_ALBUM, ID_ARTISTA) VALUES(?, ?)";
 
	/*EXCLUIR UM ALBUM PELO CODIGO*/
	public static final String EXCLUIR_ALBUM =" DELETE FROM CAD_ALBUM WHERE ID_ALBUM = ?";
 
	/*ATUALIZAR INFORMACOES DO ALBUM PELO CODIGO*/
	public static final String ATUALIZAR_ALBUM = "UPDATE CAD_ALBUM SET DESCRICAO_ALBUM = ?, ID_ARTISTA = ? WHERE ID_ALBUM = ? ";
}
