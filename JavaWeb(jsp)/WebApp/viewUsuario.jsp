<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Cadastros</title>
</head>
	<body>
		<%// Importar os Pacotes Modelo "Usuario" e o Dao de "UsuariosDao" %>
		<%@page import="com.CrudJspJava.Dao.UsuarioDao, com.CrudJspJava.modelo.Usuario, java.util.*" %>
	
		<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
	
		<h1>Lista de Usuarios Cadastrados</h1>

		<% List<Usuario> lista = UsuarioDao.PegarLista();	// Cria uma lista e Chama o Metodo de Listagem la na UsuarioDao //
			request.setAttribute("lista", lista);		// Faz uma requisição para trazer a Lista //
		%>

		<table border="2">
			<tr><th>ID </th> <th>NOME: </th> <th>Senha: </th> <th>Email: </th> <th>Sexo: </th> <th>Pais: </th>  <th>Alterar</th> <th>Apagar</th></tr>
		
			<c:forEach items="${lista }" var="usuario">
			<tr>
				<td>${	usuario.getId()}</td>
				<td>${	usuario.getNome()}</td>
				<td>${	usuario.getSenha()}</td>
				<td>${	usuario.getEmail()}</td>
				<td>${	usuario.getSexo()}</td>
				<td>${	usuario.getPais()}</td>
				
				<td><a  href="Editar.jsp?id=${usuario.getId() }">  Editar </a></td>
				<td><a  href="Apagar.jsp?id=${usuario.getId() }">  Excluir </a></td>
			</tr>
			</c:forEach>
		</table>
		<a href="addUsuario.jsp">Cria um novo Usuario</a>
	</body>
</html>