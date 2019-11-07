

**********************************************
*** Preparando a base de dados PostgreSQL. ***
**********************************************

Realize o download do PostgreSQL, e instale o mesmo utilizando a porta padrão 5432 e senha 123456.
Obs.: 
	1. Caso ja possua o postgresql instalado na máquina com outra senha não tem problema, permaneça com a senha atual porem altere o arquivo "application.properties". 
	   Altere a linha 7, "spring.datasource.password=123456" colocando a sua senha do banco de dados no lugar da palavra "123456".
	2. Caso a porta de acesso ao banco de dados nao seja a padrao 5432, altere a linha "spring.datasource.url=jdbc:postgresql://localhost:5432/bdpjc_eder" colocando
           a porta correta onde esta o valor "5432".

Apos instalado o banco de dados, execute a criacao da base rodando o script contido no arquivo "script_create.sql" contigo no diretorio do projeto "TestPJCAlbum\scripts_bd\script_create.sql".



*****************************************
**********  CONFIGURANDO API  ***********
*****************************************
Instalar o Eclipse versao 2019-09 R (4.13.0)
Baixe o eclipse do site: https://spring.io/tools3/eclipse


Instalar o Spring Tools
1. Apos instalado o Eclipse, abra a IDE e acesse o menu "Help" e na sequencia selecione a opcao "Eclipse Marketplace".
   Na aba "Search" no campo "Find", digite "Spring Tools 4" e clique em GO. Sera exibido o pacote "Spring Tools 4 - for Spring Boot...". Clique no botao "Install" para instalacao deste pacote.


Após a instalacao do pacote "Spring Tools 4", com o eclipse aberto, abra o projeto "TestPJCAlbum".


Para executar a API, selecione a classe "Application.java" e selecione as opcoes "Run As / Java Application".
Apos isso o servico será iniciado.


Apos a inicialização da API, para realizar a chamada dos metodos, siga os exemplo abaixo:
	Endereco default: http://localhost:8090


        -------------------------------------------------------------
        -----                     INSERTS                         ---
        -------------------------------------------------------------
	++++ Para inserir um novo artista +++++
	Exemplo: http://localhost:8090/service/InsereArtista?Nome=Eder

	++++ Para inserir um novo album +++++	
	Exemplo: http://localhost:8090/service/InsereAlbum?Descricao=ALBUM&Id_Artista=1


        -------------------------------------------------------------
        -----                     UPDATES                         ---
        -------------------------------------------------------------
	++++ Para alterar um artista +++++
	Exemplo: http://localhost:8090/service/AtualizaArtista?Nome=PEDRO&ID=1
	
	++++ Para alterar um album +++++
	Exemplo: http://localhost:8090/service/AtualizaAlbum?ID=1&Descricao=LAMBADA&Id_Artista=1


        -------------------------------------------------------------
        -----                     DELETES                         ---
        -------------------------------------------------------------
	++++ Para excluir um artista +++++
	Exemplo: http://localhost:8090/service/ExcluirArtista?ID=1
	
	++++ Para excluir um album +++++
	Exemplo: http://localhost:8090/service/ExcluirAlbum?ID=1


        -------------------------------------------------------------
        -----                     SELECTS                         ---
        -------------------------------------------------------------
	++++ Para listar todos os albuns e artistas +++++
	Exemplo: http://localhost:8090/service/SelecionaListaAlbuns

	++++ Para listar os albuns de um determinado artistas buscando pelo NOME do artista, utiliza função LIKE buscando por parte do nome também +++++
	Exemplo: http://localhost:8090/service/SelecionaListaAlbuns?Nome_Artista=eder

	++++ Para listar os albuns de um determinado artistas buscando pelo codigo ID album +++++
	Exemplo: http://localhost:8090/service/SelecionaListaAlbuns?Id_Album=1

	++++ Para listar os albuns de um determinado artistas buscando pelo codigo ID do artista +++++
	Exemplo: http://localhost:8090/service/SelecionaListaAlbuns?Id_Artista=1

	++++ Para listar os albuns de um determinado artistas buscando pelo codigo NOME do artista ordenando por nome do ALbum de forma decrescente +++++
	Exemplo: http://localhost:8090//service/SelecionaListaAlbuns?Nome_Artista=eder&orderType=DESC&orderColumnName=descricao_Album
        

