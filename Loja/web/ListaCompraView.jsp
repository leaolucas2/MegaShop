

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Compra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
       <jsp:include page="areaRestrita.jsp"/>
       <div id="conteudo">
            <h1>Lista de Compras</h1>
            <a href="Form_Compra.jsp">Incluir Compra</a>
            <p></p>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Id_usuario</th>
                    <th>Id_produto</th>
                    <th>Ações</th>
                </thead>
                <% ArrayList <Compra> resultado = (ArrayList<Compra>) request.getAttribute("compras");
                    for (int i = 0; i < resultado.size(); i++) {
                    Compra aux = (Compra)resultado.get(i);
                %>
                 <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getId_usuario()%></td> 
                    <td><%=aux.getId_produto()%></td>
                    <td><a href="CompraVisualizar?id=<%=aux.getId()%>">Visualizar</a> | <a href="CompraEditar?id=<%=aux.getId()%>">Editar</a> | <a href="CompraExcluir?id=<%=aux.getId()%>">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </table>
       </div>
    </body>
</html>
