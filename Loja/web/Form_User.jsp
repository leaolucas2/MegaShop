<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="script.js"></script>
    </head>
    <body>
        <jsp:include page="areaRestrita.jsp"/>
        <div id="conteudo">
            <h1>Incluir Usuário</h1>
            <form action="UserIncluir" method="POST">
            <% if((request.getAttribute("erro_nome") != null)|| (request.getAttribute("erro_nome") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" id="texto" >
            <br>
            <% if((request.getAttribute("erro_cpf") != null)|| (request.getAttribute("erro_cpf") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
            <% }%>
            CPF:<br>
            <input type="text" name="cpf" id="texto" >
            <br>
            <% if((request.getAttribute("erro_rg") != null)|| (request.getAttribute("erro_rg") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_rg"));%></h3>        
            <% }%>
            RG:<br>
            <input type="text" name="rg" id="texto">
            <br><br>
            <input type="submit" value="Submit" id="botão">
        </form>
        </div>
    </body>
</html>
