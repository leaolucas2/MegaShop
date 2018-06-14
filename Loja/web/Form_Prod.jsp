<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Categoria"%>
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
            <h1>Incluir Produto</h1>
            <form  action="ProdIncluir" method="POST">
              <% if((request.getAttribute("erro_id_categoria") != null)|| (request.getAttribute("erro_id_categoria") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_id_categoria"));%></h3>        
            <% }%>
            Categoria:<br>
            <select  name="id_categoria" id="texto">
                <% ArrayList<Categoria> resultado = (ArrayList<Categoria>)request.getAttribute("categorias");
                    for (int i = 0; i < resultado.size(); i++) {
                    Categoria aux = (Categoria)resultado.get(i);
                %>
                <option value="<%=aux.getId()%>"> <%=aux.getDescricao()%> </option>
                <% } %>
            </select>
            <br>
            <% if((request.getAttribute("erro_nome") != null)|| (request.getAttribute("erro_nome") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" id="texto" >
            <br>
            <% if((request.getAttribute("erro_descricao") != null)|| (request.getAttribute("erro_descricao") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" id="texto" >
            <br>
            <% if((request.getAttribute("erro_valor") != null)|| (request.getAttribute("erro_valor") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_valor"));%></h3>        
            <% }%>
            Valor:<br>
            <input type="text" name="valor" id="valor" placeholder="0.00" >
            <br><br>
            <input type="submit" value="Submit" id="botão">
        </form>
        </div>
    </body>
</html>
