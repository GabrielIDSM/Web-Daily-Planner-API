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
			var br = document.createElement("br")
			//Button excluir
			var inputExcluir = document.createElement("input");
			inputExcluir.setAttribute("type","button");
			inputExcluir.setAttribute("value","-");
			inputExcluir.onclick = function(){
				elContatos.removeChild(labelContato);
				elContatos.removeChild(inputContato);
				elContatos.removeChild(inputExcluir);
				elContatos.removeChild(br);
			};

			labelContato.innerText = "Contato: ";
			elContatos.appendChild(labelContato);
			elContatos.appendChild(inputContato);
			elContatos.appendChild(inputExcluir);
			elContatos.appendChild(br);
		}