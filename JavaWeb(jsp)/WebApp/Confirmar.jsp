<%@page import="com.CrudJspJava.Dao.UsuarioDao"%>

<jsp:useBean id="usu" class="com.CrudJspJava.modelo.Usuario"></jsp:useBean>

<jsp:setProperty property="*" name="usu"/>

<%
int chamada = UsuarioDao.CriarUsuario(usu);

if(chamada > 0){
	response.sendRedirect("addusuario-success.jsp");
}else{
	response.sendRedirect("addusuario-error.jsp");
}
%>