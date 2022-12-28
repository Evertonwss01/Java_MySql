<%@ idioma da página="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@page import="com.CrudJspJava.Dao.UsuarioDao"%>
<jsp:useBean id="usu" class="com.CrudJspJava.modelo.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="usu"/>


<%
UsuarioDao.AgagarUsuario(usu);

response.sendRedirect("viewUsuario.jsp");
%>