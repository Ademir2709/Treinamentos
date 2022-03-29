<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="LinkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Empresas</title>
</head>
<body>

	<form action="${LinkServletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nomeEmpresa"> </br></br>

		Data Abertura: <input type="text" name="dataAbertura"> </br></br>

		<input type="submit" value="Cadastrar"/>
		
	</form>
</body>
</html>