function focusNumeric(campoObj) 
{
	if (campoObj != null) 
	{
		if (campoObj.value == "0,00") 
		{
			campoObj.value = "";
			campoObj.select();
		} 
	}
}

function formatarNumeric(campo) 
{  
    
    var strValor = new String(campo.value);	  
    strValor = strValor.replace('.','').replace(',','.');
	            
    var valor = new Number(strValor);
    if (isNaN(valor)) 
    {
      alert('Valor inválido!');
      valor = 0;
    }

    valor = valor.toFixed(2);
	  
    var strValorFinal = new String(valor);	  
    strValorFinal = strValorFinal.replace('.',',');
      
    campo.value = strValorFinal;
    
  } 
