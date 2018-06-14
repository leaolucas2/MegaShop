<%@page import="DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style>
        input:-moz-read-only { /* For Firefox */
            background-color: #DCDCDC;
        }

        input:read-only {
            background-color: #DCDCDC;
        }
        </style>
    </head>
    <body>
        <jsp:include page="areaRestrita.jsp"/>
        <div id="conteudo">
        <h1>Lista de Produtos</h1>
        <h1>Excluir Produto</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <form action="ProdExcluir" method="Post">
            
            <input type="hidden" name="id" value="<%=produto.getId()%>" >
            <input type="hidden" name="id_categoria" value="<%=produto.getId_categoria()%>" >
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome() %>" readonly="" id="texto" >
            <br>
            <% if(request.getAttribute("erro_descricao") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=produto.getDescricao()%>" readonly="" id="texto" >
            <br>
            <% if(request.getAttribute("erro_valor") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_valor"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="valor" value="<%=produto.getValor()%>" readonly="" id="texto" >
            <br><br>
            <input type="submit" value="Confirmar Exclusão" id="botão">
            <a href="AdmServ">Retorna</a>
        </form> 
        </div>
    </body>
</html>
