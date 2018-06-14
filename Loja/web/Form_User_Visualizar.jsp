<%@page import="DAO.Usuario"%>
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
        <h1>Lista de Usuários</h1>
        <h2>Dados do Usuário</h2>
        <% Usuario usuario = (Usuario) request.getAttribute("usuario"); 
        %>
        <form action="UserListar" method="GET">
            
            <input type="hidden" name="id" value="<%=usuario.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=usuario.getNome() %>" readonly="" id="texto" >
            <br>
            <% if(request.getAttribute("erro_cpf") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
            <% }%>
            CPF:<br>
            <input type="text" name="descricao" value="<%=usuario.getCpf()%>" readonly="" id="texto">
            <br>
            <% if(request.getAttribute("erro_rg") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_rg"));%></h3>        
            <% }%>
            RG:<br>
            <input type="text" name="valor" value="<%=usuario.getRg()%>" readonly="" id="texto">
            <br><br>
            <a href="UserListar">Retorna</a>
        </form> 
        </div>
    </body>
</html>
