<%-- 
    Document   : areaRestrita
    Created on : 12/11/2017, 14:29:00
    Author     : Notebook
--%>

<%@page import="DAO.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso Restrito - Autenticação</title>
        <link rel="stylesheet" type="text/css" href="mega.css" />
    </head>
    <body>
        <jsp:include page="areaCompra.jsp"/>
        <div id="conteudo">
            
            <p></p>
            <table>
                <% ArrayList <Produto> resultado = (ArrayList<Produto>) request.getAttribute("produtos");
                    if(resultado!=null && !resultado.isEmpty()){
                        for (int i = 0; i < resultado.size(); i++) {
                        Produto aux = (Produto)resultado.get(i);
                %>
                <thead>
                    <th>Id</th>
                    <th>Id_Categoria</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Valor</th>
                    <th>Ações</th>
                </thead>
                 <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getId_categoria()%></td> 
                    <td><%=aux.getNome()%></td>
                    <td><%=aux.getDescricao()%></td>
                    <td><%=aux.getValor()%></td>
                    <td><a href="CompraCarrinho?id=<%=aux.getId()%>">Comprar</a></td>
                </tr>
                <%
                        }
                    }else{%>
                 <tr>
                    <td>Não houve resultados para a pesquisa!</td>
                </tr>       
                   <% }
                    %>
            </table>
        </div>
    </body>
</html>
