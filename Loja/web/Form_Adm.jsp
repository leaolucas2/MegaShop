<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="areaRestrita.jsp"/>
        <div id="conteudo">
            <h1>Incluir Contato</h1>
            <form action="AdmIncluir" method="POST">
              <% if((request.getAttribute("erro_nome") != null)|| (request.getAttribute("erro_nome") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" id="texto">
            <br>
            <% if((request.getAttribute("erro_senha") != null)|| (request.getAttribute("erro_senha") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_senha"));%></h3>        
            <% }%>
            Senha:<br>
            <input type="password" name="senha" id="texto" >
            <br><br>
            <input type="submit" value="Submit" id="botão">
        </form> 
        </div>
    </body>
</html>
