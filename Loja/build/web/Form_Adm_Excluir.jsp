<%@page import="DAO.Administrador"%>
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
        <h1>Lista de Administradores</h1>
        <h1>Excluir Administrador</h1>
        <% Administrador administrador = (Administrador) request.getAttribute("administrador"); 
        %>
        <form action="AdmExcluir" method="Post">
            
            <input type="hidden" name="id" value="<%=administrador.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=administrador.getNome() %>" readonly="" id="texto" >
            <br>
            <% if(request.getAttribute("erro_senha") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_senha"));%></h3>        
            <% }%>
            Idade:<br>
            <input type="text" name="senha" value="<%=administrador.getSenha()%>" readonly="" id="texto" >
            <br><br>
            <input type="submit" value="Confirmar Exclusão" id="botão">
            <a href="AdmServ">Retorna</a>
        </form> 
        </div>
    </body>
</html>
