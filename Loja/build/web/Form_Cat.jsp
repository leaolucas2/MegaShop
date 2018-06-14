<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="areaRestrita.jsp"/>
        <div id="conteudo">
            <h1>Incluir Categoria</h1>
            <form action="CatIncluir" method="POST">
              <% if((request.getAttribute("erro_descricao") != null)|| (request.getAttribute("erro_descricao") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" id="texto">
            <br><br>
            <input type="submit" value="Submit" id="botão">
        </form> 
        </div>
    </body>
</html>
