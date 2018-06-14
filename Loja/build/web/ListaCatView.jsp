<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
       <jsp:include page="areaRestrita.jsp"/>
       <div id="conteudo">
            <h1>Lista de Categorias</h1>
            <a href="Form_Cat.jsp">Incluir Categoria</a>
            <p></p>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Descrição</th>
                    <th>Ações</th>
                </thead>
                <% ArrayList <Categoria> resultado = (ArrayList<Categoria>) request.getAttribute("categorias");
                    for (int i = 0; i < resultado.size(); i++) {
                    Categoria aux = (Categoria)resultado.get(i);
                %>
                 <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getDescricao()%></td> 
                    <td><a href="CatVisualizar?id=<%=aux.getId()%>">Visualizar</a> | <a href="CatEditar?id=<%=aux.getId()%>">Editar</a> | <a href="CatExcluir?id=<%=aux.getId()%>">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </table>
       </div>
    </body>
</html>
