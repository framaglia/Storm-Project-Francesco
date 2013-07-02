var statisticsCategory;
var listCategory=[];

function generateCategoryStatistics(data){
	
	var category =  data["category"];
	var aggiunto = false;
	for(var cont=0;cont<listCategory.length;cont++){
		var nameCategory = listCategory[cont]["category"];
		if(nameCategory === category){
			listCategory[cont]["value"] += 1;
			aggiunto=true;

		}
	}
		
	if(!aggiunto){
			statisticsCategory = {
				"category": category,
				"value":1
	
			}
			listCategory.push(statisticsCategory)
	}
	
	
	
	
		if(listCategory.length === 0){
			statisticsCategory = {
				"category": category,
				"value":1
	
			}
			listCategory.push(statisticsCategory);	
		}
	


}


