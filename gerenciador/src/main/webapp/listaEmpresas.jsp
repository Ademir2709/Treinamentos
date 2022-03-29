<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.database.Empresa"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listando Empresas</title>
</head>
<body>
	<b>Lista de Empresas Cadastradas</b><br/><br/>

	<ul>

		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nomeEmpresa} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/mostraEmpresa?id=${empresa.id}"> editar</a>
				<a href="/gerenciador/removeEmpresa?id=${empresa.id}"> remove</a>
			</li>
		</c:forEach>
	</ul>
		<br>
		<input type="submit" value="< voltar">
</body>
</html>