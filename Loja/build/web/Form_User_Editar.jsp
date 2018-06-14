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
            <h2>Alterar Dados do Usuário</h2>
            <% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
            <form action="UserEditar" method="POST">
                <input type="hidden" name="id" value="<%=usuario.getId()%>" >
                <% if((request.getAttribute("erro_nome") != null)|| (request.getAttribute("erro_nome") == "")) {  %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
                <% }%>
                Nome:<br>
                <input type="text" name="nome" value="<%=usuario.getNome() %>" id="texto" >
                <br>
                <% if((request.getAttribute("erro_cpf") != null)|| (request.getAttribute("erro_cpf") == "")) { %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
                <% }%>
                CPF:<br>
                <input type="text" name="senha" value="<%=usuario.getCpf()%>" id="texto" >
                <br>
                <% if((request.getAttribute("erro_rg") != null)|| (request.getAttribute("erro_rg") == "")) {  %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_rg"));%></h3>        
                <% }%>
                RG:<br>
                <input type="text" name="senha" value="<%=usuario.getRg()%>" id="texto" >
                <br>
                <% if((request.getAttribute("erro_dados") != null)|| (request.getAttribute("erro_dados") == "")) {  %> 
                <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_dados"));%></h3>        
                <% }%>
                Endereço:<br>
                <input type="text" name="endereco" value="<%=usuario.getEndereco()%>" id="texto" >
                <br>
                Bairro:<br>
                <input type="text" name="bairro" value="<%=usuario.getBairro()%>" id="texto" >
                <br>
                Cidade:<br>
                <input type="text" name="cidade" value="<%=usuario.getCidade()%>" id="texto" >
                <br>
                CEP:<br>
                <input type="text" name="cep" value="<%=usuario.getCep()%>" id="texto" >
                <br>
                UF:<br>
                <input type="text" name="uf" value="<%=usuario.getUf()%>" id="texto" >
                <br>
                Referência:<br>
                <input type="text" name="referencia" value="<%=usuario.getReferencia()%>" id="texto" >
                <br>
                Telefone:<br>
                <input type="text" name="telefone" value="<%=usuario.getTelefone()%>" id="texto" >
                <br>
                Celular:<br>
                <input type="text" name="celular" value="<%=usuario.getCelular()%>" id="texto" >
                <br>
                Cartão de Crédito:<br>
                <input type="text" name="num_cartao" value="<%=usuario.getNum_cartao()%>" id="texto" >
                <br>
                Bandeira:<br>
                <input type="text" name="bandeira" value="<%=usuario.getBandeira()%>" id="texto" >
            <br><br>
            <input type="submit" value="Alterar" id="botão">
            <a href="UserListar">Retorna</a>
        </form> 
        </div>
    </body>
</html>
