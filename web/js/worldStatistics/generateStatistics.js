var statistics;
var listStatisticsNation=[];

function generateStatistics(data){
	
	var nation = worldmap["names"][data["acr"]];
	
	var aggiunto = false;
	for(var cont=0;cont<listStatisticsNation.length;cont++){
		var nameNation = listStatisticsNation[cont]["name"];
		if(nameNation === nation){
			listStatisticsNation[cont]["value"] += 1;
			aggiunto=true;

		}
	}
		
	if(!aggiunto){
			statistics = {
				"name": nation,
				"value":1
	
			}
			listStatisticsNation.push(statistics)
	}
	
	
	
	
		if(listStatisticsNation.length === 0){
			statistics = {
				"name": nation,
				"value":1
	
			}
			listStatisticsNation.push(statistics);
	
		}
	


}


