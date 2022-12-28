<%@ idioma da página="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<cabeça>
<meta charset="UTF-8">
<title>Edição de Registro</title>
</head>
<corpo>
	<% // Importador como Bibliotecas necessárias //%>
	<%@page import="com.CrudJspJava.modelo.Usuario , com.CrudJspJava.Dao.UsuarioDao" %>
	
	<% // Informar a pagina que vou passar o parametro Id para Manipular um Usuario especifico // %>
	<% String id = request.getParameter("id");
		
		// Cria uma instância de Usuario, e com isso chama o Metodo de "Pegar Registro Espacifico" da Classe UsuarioDao. //
		Usuario usu = UsuarioDao.PegarEspecifico(Integer.parseInt(id));
	%>
	
	
	<h1>Edição do Usuário</h1>
	
	<form action="Edit.jsp" method="post">
		<input type="hidden" name="id" value="<%=usu.getId()%>" />
		<tabela>
			<tr>
				<td>Nome: </td>
				<td> <input type="text" name="nome" value="<%=usu.getNome() %>"/></td>
			</tr>
			<tr>
				<td>Senha: </td>
				<td> <input type="password" name="senha" value="<%=usu.getSenha() %>"/></td>
			</tr>
			<tr>
				<td>E-mail: </td>
				<td> <input type="email" name="email" value="<%=usu.getEmail()%>"/></td>
			</tr>
			<tr>
				<td>Sexo: </td>
				<td> <input type="radio" name="sexo" value="Masculino"/> Masculino
					<input type="radio" name="sexo" value="Feminino"/> Feminino
				</td>
			</tr>
			<tr>
				<td>País: </td>
					<td>
						<selecionar nome="pais" >
							<option>Brasil</option>
							<option>Inglaterra</option>
							<option>França</option>
							<option>Senegal</option>
							<option>Polônia</option>
							<option>Portugal</option>
						</selecionar>
					</td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Atualizar"> <input type="button" value="Sair" onclick='history.go(-1)'/></td>
			</tr>
			
		</table>
	</form>
	
</body>
</html>