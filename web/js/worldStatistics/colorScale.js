function hex2Int(esadecimale){
   var lunghezzaEsadecimale = esadecimale.length;
   var esadecimaleParsato = esadecimale.substring(1,lunghezzaEsadecimale);
   
   var esadecimaleRR = esadecimaleParsato.substring(0,2);
   var esadecimaleGG = esadecimaleParsato.substring(2,4);
   var esadecimaleBB = esadecimaleParsato.substring(4,6);
   
   
      
    var esadecimaleIntGG =  parseInt(esadecimaleGG, 16) - 4;
    var esadecimaleIntBB =  parseInt(esadecimaleBB, 16) - 4;
	
	var esadGG = esadecimaleIntGG.toString(16);
	var esadBB = esadecimaleIntBB.toString(16);
   
   return "#"+esadecimaleRR+esadGG+esadBB;
  
   
}




