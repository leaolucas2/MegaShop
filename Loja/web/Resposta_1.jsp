<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <jsp:include page="areaCompra.jsp"/>
        <div id="conteudo">
            <h1><% out.println(request.getAttribute("mensagem"));    %></h1>
            <p></p>
            <div><a href="<% out.println(request.getAttribute("retorna"));%>">Retornar Para a Lista</a></div>
        </div>
    </body>
</html>
