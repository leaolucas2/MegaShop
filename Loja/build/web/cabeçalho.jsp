<%-- 
    Document   : index
    Created on : 12/11/2017, 14:24:31
    Author     : Notebook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MegaShop.com - o seu site de compras!</title>
        <link rel="stylesheet" type="text/css" href="mega.css" />

    </head>
    <body>
        <div id="titulo">
            <img src="MegaShop2.png" id="logo">
            <p id="link01">
                <a id="link03" href="javascript:;" >ACESSO RESTRITO</a>
            </p>
            <form >
                <input type="text" id="pesquisa" placeholder="Pesquisar"/>
            </form> 
        </div>
        <div id="myModal" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
                <span class="close">&times;</span>
                <p>Entre com o nome e senha para logar como Administrador: </p>
                <form action="areaRestrita.jsp" method="POST" >
                Nome:<br />
                <input type="text" name="nome" id="texto" ><br /><br />
                Senha:<br />
                <input type="password" name="senha" id="texto" ><br /><br />
                <input type="submit" value="Logar" id="botão">
                </form>
            </div>
        </div>
        <script>
// Get the modal
            var modal = document.getElementById('myModal');

// Get the button that opens the modal
            var btn = document.getElementById("link03");

// Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
            btn.onclick = function () {
                modal.style.display = "block";
            };

// When the user clicks on <span> (x), close the modal
            span.onclick = function () {
                modal.style.display = "none";
            };

// When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target === modal) {
                    modal.style.display = "none";
                };
            };
        </script>

    </body>
</html>
<!--    Object logado = session.getAttribute("logado");
                   if(logado!=null){
                       String aux = (String) logado;
                       if(aux.equals("logado")){%>
                       %= session.getAttribute("adm")%>  &nbsp; <a id="link03" href="index.jsp" >SAIR</a>    
                % }else{%>
                <a id="link03" href="javascript:;" >ACESSO RESTRITO</a>
                % } %> -->