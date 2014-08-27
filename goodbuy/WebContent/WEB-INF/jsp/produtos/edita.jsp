<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/produtos/${produto.id}"/>">
  <fieldset>
    <legend>Editar Produto</legend>
    <input type="hidden" name="produto.id" 
      value="${produto.id }" /> 
    
    <label for="nome">Nome:</label>
    <input id="nome" type="text" name="produto.nome" 
      value="${produto.nome }"/>
    
    <label for="descricao">Descri��o:</label>
    <textarea id="descricao" name="produto.descricao">
      ${produto.descricao }
    </textarea>
    
    <label for="preco">Pre�o:</label>
    <input id="preco" type="text" name="produto.preco" 
      value="${produto.preco }"/>
    
    <button type="submit" name="_method" value="PUT">Enviar</button>
  </fieldset>
</form>

<form action="<c:url value="/produtos/${produto.id}/imagem"/>" method="post" enctype="multipar/form-data">
	<fieldset>
		<legend>Upload de Imagem</legend>
		<input type="file" name="imagem"/>
		<button type="button">Enviar</button>
	</fieldset>
</form>
</body>
</html>