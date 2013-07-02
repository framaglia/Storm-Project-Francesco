
var graphCategoryValues = [];
var categoryRate;

function drawCategoryRate(worldValues){

	var totaleComplessivo = calculateCategoryTotal(worldValues);
	for(var cont=0;cont<worldValues.length;cont++){
		categoryRate = {
			"category":worldValues[cont]["category"],
			"rate":calculeteRateCategory(worldValues[cont]["value"],totaleComplessivo)
		
		};
		
		graphCategoryValues.push(categoryRate);
	
	}
	
	var table = document.createElement("table");
	table.setAttribute("id","categoryStatistics")
	var tbody = document.createElement("tbody");
	
	for(var cont = 0;cont<graphCategoryValues.length;cont++){
		var tr = document.createElement("tr");
		var th = document.createElement("th");
		var nameCategory = document.createTextNode(graphCategoryValues[cont]["category"]);
		th.setAttribute("scope","row");
		th.appendChild(nameCategory);
		
		var td = document.createElement("td");
		var rateNation = document.createTextNode(graphCategoryValues[cont]["rate"]+"%");
		td.appendChild(rateNation);
		
		tr.appendChild(th);
		tr.appendChild(td);
		tbody.appendChild(tr);
		
	}
	table.appendChild(tbody);
	var divChart = document.getElementById("pie1");
	divChart.appendChild(table);
	var pie1 = document.getElementById("pie1");
    var values = [],
        labels = [];
    $("#categoryStatistics tr").each(function () {
        values.push(parseInt($("td", this).text(), 10));
        labels.push($("th", this).text());
    });
    $("#categoryStatistics").hide();
    Raphael(pie1, 700, 600).pieChart(250, 220, 125, values, labels, "#fff");

}


function calculeteRateCategory(totaleNazione,totaleComplessivo){

return (100*totaleNazione)/totaleComplessivo;

}


function calculateCategoryTotal(array){
	var total=0;
	for(var cont=0;cont<array.length;cont++){
		total += array[cont]["value"]; 
	}
	
	return total;
	

}



