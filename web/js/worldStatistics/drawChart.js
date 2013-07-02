
var graphValues = [];
var nationRate;

function drawChart(worldValues){

	var totaleComplessivo = calculateTotal(worldValues);
	for(var cont=0;cont<worldValues.length;cont++){
		nationRate = {
			"name":worldValues[cont]["name"],
			"rate":calculeteRate(worldValues[cont]["value"],totaleComplessivo)
		
		};
		
		graphValues.push(nationRate);
	
	}
	
	var table = document.createElement("table");
	table.setAttribute("id","worldStatistics")
	var tbody = document.createElement("tbody");
	
	for(var cont = 0;cont<graphValues.length;cont++){
		var tr = document.createElement("tr");
		var th = document.createElement("th");
		var nameNation = document.createTextNode(graphValues[cont]["name"]);
		th.setAttribute("scope","row");
		th.appendChild(nameNation);
		
		var td = document.createElement("td");
		var rateNation = document.createTextNode(graphValues[cont]["rate"]+"%");
		td.appendChild(rateNation);
		
		tr.appendChild(th);
		tr.appendChild(td);
		tbody.appendChild(tr);
		
	}
	table.appendChild(tbody);
	var divChart = document.getElementById("pie");
	divChart.appendChild(table);
	
    var values = [],
        labels = [];
    $("#worldStatistics tr").each(function () {
        values.push(parseInt($("td", this).text(), 10));
        labels.push($("th", this).text());
    });
    $("#worldStatistics").hide();
	
    Raphael(pie, 700, 600).pieChart(250, 220, 125, values, labels, "#fff");

}


function calculeteRate(totaleNazione,totaleComplessivo){

return (100*totaleNazione)/totaleComplessivo;

}


function calculateTotal(array){
	var total=0;
	for(var cont=0;cont<array.length;cont++){
		total += array[cont]["value"]; 
	}
	
	return total;
	

}



