<%@page import="DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="areaRestrita.jsp"/>
        <div id="conteudo">
            <h1>Lista de Administradores</h1>
            <h1>Alterar Dados do Contato</h1>
            <% Administrador administrador = (Administrador) request.getAttribute("administrador"); %>
            <form action="AdmEditar" method="POST">
                <input type="hidden" name="id" value="<%=administrador.getId()%>" >
                <% if(request.getAttribute("erro_nome") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
                <% }%>
                Nome:<br>
                <input type="text" name="nome" value="<%=administrador.getNome() %>" id="texto" >
                <br>
                <% if(request.getAttribute("erro_idade") != null){ %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idade"));%></h3>        
                <% }%>
                Idade:<br>
                <input type="text" name="senha" value="<%=administrador.getSenha()%>" id="texto" >
            <br><br>
            <input type="submit" value="Alterar" id="botão">
            <a href="AdmServ">Retorna</a>
        </form> 
        </div>
    </body>
</html>
