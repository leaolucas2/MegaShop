<%@page import="DAO.Categoria"%>
<%@page import="DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="areaRestrita.jsp"/>
        <div id="conteudo">
            <h1>Lista de Produtos</h1>
            <h2>Alterar Dados dos Produtos</h2>
            <% Produto produto = (Produto) request.getAttribute("produto"); %>
            <form action="ProdEditar" method="POST">
                <input type="hidden" name="id" value="<%=produto.getId()%>" >
                <input type="hidden" name="id_categoria" value="<%=produto.getId_categoria()%>" >
                <% if(request.getAttribute("erro_nome") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
                <% }%>
                Nome:<br>
                <input type="text" name="nome" value="<%=produto.getNome() %>" id="texto" >
                <br> 
                <% if(request.getAttribute("erro_descricao") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
                <% }%>
                Descrição:<br>
                <input type="text" name="descricao" value="<%=produto.getDescricao() %>" id="texto" >
                <br>
                <% if(request.getAttribute("erro_valor") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_valor"));%></h3>        
                <% }%>
                Valor:<br>
                <input type="text" name="valor" value="<%=produto.getValor() %>" id="texto" >
                <br><br>
                <input type="submit" value="Alterar" id="botão">
                <a href="ProdListar">Retorna</a>
            </form> 
        </div>
    </body>
</html>
