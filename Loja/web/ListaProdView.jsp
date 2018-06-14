<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
       <jsp:include page="areaRestrita.jsp"/>
       <div id="conteudo">
            <h1>Lista de Produtos</h1>
            <a href="ProdListarCat">Incluir Produto</a>
            <p></p>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Id_Categoria</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Valor</th>
                    <th>Ações</th>
                </thead>
                <% ArrayList <Produto> resultado = (ArrayList<Produto>) request.getAttribute("produtos");
                    for (int i = 0; i < resultado.size(); i++) {
                    Produto aux = (Produto)resultado.get(i);
                %>
                 <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getId_categoria()%></td> 
                    <td><%=aux.getNome()%></td>
                    <td><%=aux.getDescricao()%></td>
                    <td><%=aux.getValor()%></td>
                    <td><a href="ProdVisualizar?id=<%=aux.getId()%>">Visualizar</a> | <a href="ProdEditar?id=<%=aux.getId()%>">Editar</a> | <a href="ProdExcluir?id=<%=aux.getId()%>">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </table>
       </div>
    </body>
</html>
