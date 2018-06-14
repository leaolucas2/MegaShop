<%-- 
    Document   : Carrinho
    Created on : 19/12/2017, 16:14:16
    Author     : Notebook
--%>

<%@page import="DAO.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
    </head>
    <body>
        <jsp:include page="areaCompra.jsp" />
        <div id="conteudo">
        <%
            Carrinho carrinho;       
            Object cart = session.getAttribute("carrinho");
            if (cart != null) {
                carrinho = (Carrinho) cart;
        %>
        <table>
            <thead>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th></th>
        </thead>
        <%
            ArrayList<Produto> l_produto = carrinho.getCarrinhoItens();

            double total = 0;
            for (int i = 0; i < l_produto.size(); i++) {
                Produto aux = (Produto) l_produto.get(i);
        %>
        <tr>
            <td><%=aux.getNome()%></td>
            <td><%=aux.getDescricao()%></td>
            <td>R$ <%=aux.getValor()%></td>
            <td><button onclick= "window.location.href = 'CompraCarrinho?id=<%=aux.getId()%>&acao=remover'" id="botão">Remover</button></td>
        </tr>
        <%
                total = total + aux.getValor();
            }

        %>
    </table>
    Total = R$<%= total%>
    <br><br>
    <button onclick= "window.location.href = 'Form_User_1.jsp'" id="botão" >Finalizar</button>
    <%
    } else {
    %> <h1>Seu carrinho está vazio!</h1><%
        }
    %>
        </div>
</body>
</html>