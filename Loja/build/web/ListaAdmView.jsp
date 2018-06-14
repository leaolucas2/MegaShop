

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
       <jsp:include page="areaRestrita.jsp"/>
       <div id="conteudo">
            <h1>Lista de Administradores</h1>
            <a href="Form_Adm.jsp">Incluir Contato</a>
            <p></p>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Senha</th>
                    <th>Ações</th>
                </thead>
                <% ArrayList <Administrador> resultado = (ArrayList<Administrador>) request.getAttribute("administradores");
                    for (int i = 0; i < resultado.size(); i++) {
                    Administrador aux = (Administrador)resultado.get(i);
                %>
                 <tr>
                    <td><%=aux.getId()%></td>
                    <td><%=aux.getNome()%></td> 
                    <td><%=aux.getSenha()%></td>
                    <td><a href="AdmVisualizar?id=<%=aux.getId()%>">Visualizar</a> | <a href="AdmEditar?id=<%=aux.getId()%>">Editar</a> | <a href="AdmExcluir?id=<%=aux.getId()%>">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </table>
       </div>
    </body>
</html>
