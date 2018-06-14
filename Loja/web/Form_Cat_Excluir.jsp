<%@page import="DAO.Categoria"%>
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
        <h1>Lista de Categorias</h1>
        <h1>Excluir Categoria</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("categoria"); 
        %>
        <form action="CatExcluir" method="Post">
            
            <input type="hidden" name="id" value="<%=categoria.getId()%>" >
            
            <% if(request.getAttribute("erro_descricao") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=categoria.getDescricao() %>" readonly="" id="texto" >
            <br><br>
            <input type="submit" value="Confirmar Exclusão" id="botão">
            <a href="CatListar">Retorna</a>
        </form> 
        </div>
    </body>
</html>
