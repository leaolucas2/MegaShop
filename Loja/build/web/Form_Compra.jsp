<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="areaRestrita.jsp"/>
        <div id="conteudo">
            <h1>Incluir Compra</h1>
            <form action="CompraIncluir" method="POST">
              <% if((request.getAttribute("erro_id_usuario") != null)|| (request.getAttribute("erro_id_usuario") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_id_usuario"));%></h3>        
            <% }%>
            Id Usuário:<br>
            <input type="text" name="id_usuario" id="texto">
            <br>
            <% if((request.getAttribute("erro_id_produto") != null)|| (request.getAttribute("erro_id_produto") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_id_produto"));%></h3>        
            <% }%>
            Id Produto:<br>
            <input type="text" name="id_produto" id="texto" >
            <br><br>
            <input type="submit" value="Submit" id="botão">
        </form> 
        </div>
    </body>
</html>
