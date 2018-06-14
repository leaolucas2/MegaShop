<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="script.js"></script>
    </head>
    <body>
        <jsp:include page="areaCompra.jsp"/>
        <div id="conteudo">
            <h1>Cadastro</h1>
            <form action="UserIncluir" method="POST">
            <% if((request.getAttribute("erro_nome") != null)|| (request.getAttribute("erro_nome") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" id="texto" >
            <br>
            <% if((request.getAttribute("erro_cpf") != null)|| (request.getAttribute("erro_cpf") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
            <% }%>
            CPF:<br>
            <input type="text" name="cpf" id="texto" >
            <br>
            <% if((request.getAttribute("erro_rg") != null)|| (request.getAttribute("erro_rg") == "")) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_rg"));%></h3>        
            <% }%>
            RG:<br>
            <input type="text" name="rg" id="texto"><br>
            Endereço:<br>
                <input type="text" name="endereco" placeholder="Rua XXX, N.15" id="texto" >
                <br>
                Bairro:<br>
                <input type="text" name="bairro" placeholder="EX:CENTRO" id="texto" >
                <br>
                Cidade:<br>
                <input type="text" name="cidade" placeholder="EX: RIO DAS OSTRAS" id="texto" >
                <br>
                CEP:<br>
                <input type="text" name="cep" placeholder="XXXXX-XXX" id="texto" >
                <br>
                UF:<br>
                <input type="text" name="uf" placeholder="UF" id="texto" >
                <br>
                Referência:<br>
                <input type="text" name="referencia" placeholder="REFERENCIA" id="texto" >
                <br>
                Telefone:<br>
                <input type="text" name="telefone" placeholder="XXX XXXX XXXXX" id="texto" >
                <br>
                Celular:<br>
                <input type="text" name="celular" placeholder="XXX XXXXX XXXX" id="texto" >
                <br>
                Cartão de Crédito:(Apenas os numeros)<br>
                <input type="text" name="num_cartao" placeholder="XXXX XXXX XXXX XXXX" id="texto" >
                <br>
                Bandeira:<br>
                <input type="text" name="bandeira" placeholder="Rua xxx" id="texto" >
            <br><br>
            <input type="submit" value="Concluir Cadastro" id="botão">
        </form>
        </div>
    </body>
</html>
