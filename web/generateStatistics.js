var statistics;
var listStatisticsNation=[];

function generateStatistics(data){
	
	var nation = worldmap["names"][data["acr"]];
	
	var aggiunto = false;
	for(var cont=0;cont<listStatisticsNation.length;cont++){
		var nameNation = listStatisticsNation[cont]["name"];
		console.log("nameNation:"+nameNation + "    nation:"+nation)
		if(nameNation === nation){
			listStatisticsNation[cont]["value"] += 1;
			console.log("IF name:   "+listStatisticsNation[cont]["name"] + "     value:"+listStatisticsNation[cont]["value"]);
			aggiunto=true;

		}
	}
		
	if(!aggiunto){
			statistics = {
				"name": nation,
				"value":1
	
			}
			listStatisticsNation.push(statistics)
			console.log("Else name:   "+statistics["name"] + "     value:"+statistics["value"]);	
	}
	
	
	
	
		if(listStatisticsNation.length === 0){
			statistics = {
				"name": nation,
				"value":1
	
			}
			listStatisticsNation.push(statistics);
			console.log("first--> name:   "+listStatisticsNation[0]["name"] + "     value:"+listStatisticsNation[0]["value"]);
	
		}
	


}


