var macroCategory = {
	"Arts & Entertainment":"arts",		
	"College & University":"college",
	"Food":"food",
	"Professional & Other Places":"professional",
	"Nightlife Spot":"night",
	"Parks & Outdoors":"parks",
	"Shops & Services":"shop",
	"Travel & Transport":"travel",
	"Residence":"residence"
}



function chooseColorCategory(category){
	
	var category = macroCategory[category];
	return colorCategory(category);
	

}


function colorCategory(category){
	
	var color;
	
	if(category === "arts" ){
		color = "#1560BD";
	}
	
	if(category === "college" ){
		color = "#E30B5C";
	}
	if(category === "food" ){
		color = "#FFD700";
	}
	if(category === "professional" ){
		color = "#00FF7F";
	}
	if(category === "night" ){
		color = "#FFC0CB";
	}
	if(category === "parks" ){
		color = "#C04000";
	}
	if(category === "shop" ){
		color = "#0096F5";
	}
	if(category === "travel" ){
		color = "#8F00FF";
	}
	if(category === "residence" ){
		color = "#FF9C00";
	}

return color;

}