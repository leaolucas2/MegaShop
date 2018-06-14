function validarInteiro(){ 
  var valor = parseInt(document.getElementById('valor').value);
	if (isNaN(valor) ) {
	    alert("entre com um numero");
            window.location("Form_Prod.jsp");
	}
        
}