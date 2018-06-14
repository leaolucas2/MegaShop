<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
       <jsp:include page="areaRestrita.jsp"/>
       <div id="conteudo">
            <h1>Lista de Usuários</h1>
            <a href="Form_User.jsp">Incluir Usuario</a>
            <p></p>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>RG</th>
                    <th>Endereço</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>UF</th>
                    <th>Referência</th>
                    <th>Telefone</th>
                    <th>Celular</th>
                    <th>Cartão de Crédito</th>
                    <th>Bandeira</th>
                    <th>Opções</th>
                </thead>
                <% ArrayList <Usuario> resultado = (ArrayList<Usuario>) request.getAttribute("usuarios");
                    for (int i = 0; i < resultado.size(); i++) {
                    Usuario aux = (Usuario)resultado.get(i);
                %>
                 <tr>
                    <td><%=aux.getId()%></td> 
                    <td><%=aux.getNome()%></td>
                    <td><%=aux.getCpf()%></td>
                    <td><%=aux.getRg()%></td>
                    <td><%=aux.getEndereco()%></td> 
                    <td><%=aux.getBairro()%></td>
                    <td><%=aux.getCidade()%></td>
                    <td><%=aux.getUf()%></td>
                    <td><%=aux.getReferencia()%></td>
                    <td><%=aux.getTelefone()%></td> 
                    <td><%=aux.getCelular()%></td>
                    <td><%=aux.getNum_cartao()%></td>
                    <td><%=aux.getBandeira()%></td>
                    <td><a href="UserVisualizar?id=<%=aux.getId()%>">Visualizar</a> | <a href="UserEditar?id=<%=aux.getId()%>">Editar</a> | <a href="UserExcluir?id=<%=aux.getId()%>">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </table>
       </div>
    </body>
</html>
