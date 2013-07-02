function openSubCategory(){
			document.getElementById("subCategoryArts").style.display="none";
			document.getElementById("subCategoryCollege").style.display="none";
			document.getElementById("subCategoryNight").style.display="none";
			document.getElementById("subCategoryFood").style.display="none";
			document.getElementById("subCategoryTravel").style.display="none";
			document.getElementById("subCategoryShop").style.display="none";

			var index = document.getElementById("subCategory").selectedIndex;
			if(index===1){
				document.getElementById("subCategoryArts").style.display="block";
			}
			if(index===2){
				document.getElementById("subCategoryCollege").style.display="block";
			}
			if(index===3){
			document.getElementById("subCategoryFood").style.display="block";
			}
			if(index===4){
				document.getElementById("subCategoryNight").style.display="block";
			}
			if(index===5){
			document.getElementById("subCategoryShop").style.display="block";
			}
			if(index===6){
			document.getElementById("subCategoryTravel").style.display="block";
			}
		
		}
		

	

	function selectSubCategory(subcategory){
	
	if(subcategory==="Arts"){
		var index = document.getElementById("subCategoryArts").selectedIndex;
		var value = document.getElementById("subCategoryArts").options;
		document.getElementById("category").value = value[index].text;
	}
		if(subcategory==="College"){
		var index = document.getElementById("subCategoryCollege").selectedIndex;
		var value = document.getElementById("subCategoryCollege").options;
		document.getElementById("category").value = value[index].text;
	}
	
	if(subcategory==="Night"){
		var index = document.getElementById("subCategoryNight").selectedIndex;
		var value = document.getElementById("subCategoryNight").options;
		document.getElementById("category").value = value[index].text;
	}
	
	if(subcategory==="Food"){
		var index = document.getElementById("subCategoryFood").selectedIndex;
		var value = document.getElementById("subCategoryFood").options;
		document.getElementById("category").value = value[index].text;
	}
	if(subcategory==="Travel"){
		var index = document.getElementById("subCategoryTravel").selectedIndex;
		var value =  document.getElementById("subCategoryTravel").options;
		document.getElementById("category").value = value[index].text;
	}
	if(subcategory==="Shop"){
		var index = document.getElementById("subCategoryShop").selectedIndex;
		var value = document.getElementById("subCategoryShop").options;
		document.getElementById("category").value = value[index].text;
	}
	
	}

	
	
