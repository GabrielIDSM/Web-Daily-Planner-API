function exibeNome(){
	var elNome = document.getElementById("txtNome");
	var strNome = elNome.value;
	var elDisplay = document.getElementById("display");
	elDisplay.innerText = strNome;
}

function novoContato(){
	var elContatos = document.getElementById("contatos");
	var inputContato = document.createElement("input");
	var labelContato = document.createElement("label");
	inputContato.setAttribute("name","txtContato")
	var br = document.createElement("br");
	var div = document.createElement("div");
	var inputExcluir = document.createElement("input");
	inputExcluir.setAttribute("type","button");
	inputExcluir.setAttribute("value","-");
	inputExcluir.onclick = function(){
		elContatos.removeChild(div);
	};
	labelContato.innerText = "Contato: ";
	div.appendChild(labelContato);
	div.appendChild(inputContato);
	div.appendChild(inputExcluir);
	div.appendChild(br);
	elContatos.appendChild(div);
}

function exibeContatos(){
	var arrContatos = document.frmContatos.txtContato;
	var display = document.getElementById("display");
	var aux = "";
	for(var i=0; i < arrContatos.length; i++){
		aux += arrContatos[i].value + "<br>";
	}
	display.innerHTML = aux;
}