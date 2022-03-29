<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<c:url value="/alteraEmpresa" var="LinkServletAlteraEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Empresas</title>
</head>
<body>

	<form action="${LinkServletAlteraEmpresa}" method="post">
		
		Nome: <input type="text" name="nomeEmpresa" value= "${empresa.nomeEmpresa}"></br></br>
		
		Data Abertura: <input type="text" name="dataAbertura" value= "<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"></br></br>
		
		<input type="hidden" name="id" value="${empresa.id}">
		
		<input type="submit" value="Alterar"/>
		
	</form>
</body>
</html>