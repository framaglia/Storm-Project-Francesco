package geoLocation;

import java.util.HashMap;
import java.util.Map;

public class AcronimNationUtility {

	private final Map<String,String> ACRONYM;
	
	public Map<String, String> getACRONYM() {
		return ACRONYM;
	}

	public AcronimNationUtility(){
		
		this.ACRONYM = new HashMap<String,String>();
		mapFiller(ACRONYM);
		
	}
	
	public void mapFiller(Map<String,String> mapToFill){
		ACRONYM.put("Vanuatu","VU");
		ACRONYM.put("Latvia","LV");
		ACRONYM.put("Lithuania","LT");
		ACRONYM.put("Luxembourg","LU");
		ACRONYM.put("Viet Nam","VN");
		ACRONYM.put("Ecuador","EC");
		ACRONYM.put("Libyan Arab Jamahiriya","LY");
		ACRONYM.put("Lesotho","LS");
		ACRONYM.put("Liberia","LR");
		ACRONYM.put("Algeria","DZ");
		ACRONYM.put("Bolivarian Republic of Venezuela","VE");
		ACRONYM.put("Madagascar","MG");
		ACRONYM.put("Dominican Republic","DO");
		ACRONYM.put("The Former Yugoslav Republic of Macedonia","MK");
		ACRONYM.put("Mali","ML");
		ACRONYM.put("Germany","DE");
		ACRONYM.put("Uzbekistan","UZ");
		ACRONYM.put("Uruguay","UY");
		ACRONYM.put("Republic of Moldova","MD");
		ACRONYM.put("Denmark","DK");
		ACRONYM.put("Morocco","MA");
		ACRONYM.put("Djibouti","DJ");
		ACRONYM.put("United States","US");
		ACRONYM.put("Mexico","MX");
		ACRONYM.put("Malawi","MW");
		ACRONYM.put("Mozambique","MZ");
		ACRONYM.put("Malaysia","MY");
		ACRONYM.put("Mongolia","MN");
		ACRONYM.put("Myanmar","MM");
		ACRONYM.put("Mauritania","MR");
		ACRONYM.put("Ukraine","UA");
		ACRONYM.put("Nigeria","NG");
		ACRONYM.put("Nicaragua","NI");
		ACRONYM.put("Ethiopia","ET");
		ACRONYM.put("Spain","ES");
		ACRONYM.put("The Netherlands","NL");
		ACRONYM.put("Eritrea","ER");
		ACRONYM.put("Western Sahara","EH");
		ACRONYM.put("Egypt","EG");
		ACRONYM.put("United Republic of Tanzania","TZ");
		ACRONYM.put("Namibia","NA");
		ACRONYM.put("Estonia","EE");
		ACRONYM.put("New Caledonia","NC");
		ACRONYM.put("Province of China Taiwan","TW");
		ACRONYM.put("Niger","NE");
		ACRONYM.put("Georgia","GE");
		ACRONYM.put("New Zealand","NZ");
		ACRONYM.put("French Guiana","GF");
		ACRONYM.put("Gabon","GA");
		ACRONYM.put("United Kingdom","GB");
		ACRONYM.put("Nepal","NP");
		ACRONYM.put("Norway","NO");
		ACRONYM.put("Oman","OM");
		ACRONYM.put("France","FR");
		ACRONYM.put("Falkland Islands","FK");
		ACRONYM.put("Fiji","FJ");
		ACRONYM.put("Finland","FI");
		ACRONYM.put("Guyana","GY");
		ACRONYM.put("Guinea-Bissau","GW");
		ACRONYM.put("Poland","PL");
		ACRONYM.put("Guatemala","GT");
		ACRONYM.put("Philippines","PH");
		ACRONYM.put("Greece","GR");
		ACRONYM.put("Equatorial Guinea","GQ");
		ACRONYM.put("Pakistan","PK");
		ACRONYM.put("Guinea","GN");
		ACRONYM.put("Peru","PE");
		ACRONYM.put("Gambia","GM");
		ACRONYM.put("Greenland","GL");
		ACRONYM.put("Papua New Guinea","PG");
		ACRONYM.put("Panama","PA");
		ACRONYM.put("Ghana","GH");
		ACRONYM.put("South Africa","ZA");
		ACRONYM.put("Honduras","HN");
		ACRONYM.put("Croatia","HR");
		ACRONYM.put("Romania","RO");
		ACRONYM.put("Haiti","HT");
		ACRONYM.put("Hungary","HU");
		ACRONYM.put("Zambia","ZM");
		ACRONYM.put("Zimbabwe","ZW");
		ACRONYM.put("Indonesia","ID");
		ACRONYM.put("Ireland","IE");
		ACRONYM.put("Austria","AT");
		ACRONYM.put("Argentina","AR");
		ACRONYM.put("Israel","IL");
		ACRONYM.put("Qatar","QA");
		ACRONYM.put("India","IN");
		ACRONYM.put("Australia","AU");
		ACRONYM.put("Iraq","IQ");
		ACRONYM.put("Islamic Republic of Iran","IR");
		ACRONYM.put("Yemen","YE");
		ACRONYM.put("Azerbaijan","AZ");
		ACRONYM.put("Iceland","IS");
		ACRONYM.put("Italy","IT");
		ACRONYM.put("Bosnia and Herzegovina","BA");
		ACRONYM.put("Puerto Rico","PR");
		ACRONYM.put("United Arab Emirates","AE");
		ACRONYM.put("Occupied Palestinian Territory","PS");
		ACRONYM.put("Afghanistan","AF");
		ACRONYM.put("Albania","AL");
		ACRONYM.put("Angola","AO");
		ACRONYM.put("Paraguay","PY");
		ACRONYM.put("Armenia","AM");
		ACRONYM.put("Togo","TG");
		ACRONYM.put("Botswana","BW");
		ACRONYM.put("Japan","JP");
		ACRONYM.put("Belarus","BY");
		ACRONYM.put("Chad","TD");
		ACRONYM.put("Jordan","JO");
		ACRONYM.put("Tajikistan","TJ");
		ACRONYM.put("Brazil","BR");
		ACRONYM.put("Jamaica","JM");
		ACRONYM.put("Thailand","TH");
		ACRONYM.put("Bhutan","BT");
		ACRONYM.put("Tunisia","TN");
		ACRONYM.put("Turkmenistan","TM");
		ACRONYM.put("Timor-Leste","TL");
		ACRONYM.put("Canada","CA");
		ACRONYM.put("Turkey","TR");
		ACRONYM.put("Belize","BZ");
		ACRONYM.put("Burkina Faso","BF");
		ACRONYM.put("El Salvador","SV");
		ACRONYM.put("Bulgaria","BG");
		ACRONYM.put("Burundi","BI");
		ACRONYM.put("Syrian Arab Republic","SY");
		ACRONYM.put("Swaziland","SZ");
		ACRONYM.put("Bangladesh","BD");
		ACRONYM.put("Belgium","BE");
		ACRONYM.put("Brunei Darussalam","BN");
		ACRONYM.put("Plurinational State of Bolivia","BO");
		ACRONYM.put("Cambodia","KH");
		ACRONYM.put("Kyrgyzstan","KG");
		ACRONYM.put("Benin","BJ");
		ACRONYM.put("Kenya","KE");
		ACRONYM.put("Sudan","SD");
		ACRONYM.put("Czech Republic","CZ");
		ACRONYM.put("Cyprus","CY");
		ACRONYM.put("North Korea","KP");
		ACRONYM.put("Sweden","SE");
		ACRONYM.put("South Korea","KR");
		ACRONYM.put("Cuba","CU");
		ACRONYM.put("Svalbard and Jan Mayen","SJ");
		ACRONYM.put("Sierra Leone","SL");
		ACRONYM.put("Kuwait","KW");
		ACRONYM.put("Slovakia","SK");
		ACRONYM.put("Senegal","SN");
		ACRONYM.put("Kazakhstan","KZ");
		ACRONYM.put("Somalia","SO");
		ACRONYM.put("Suriname","SR");
		ACRONYM.put("Ivory Coast","CI");
		ACRONYM.put("Lao People's Democratic Republic","LA");
		ACRONYM.put("Serbia","RS");
		ACRONYM.put("Congo","CG");
		ACRONYM.put("Russia","RU");
		ACRONYM.put("Switzerland","CH");
		ACRONYM.put("Lebanon","LB");
		ACRONYM.put("Rwanda","RW");
		ACRONYM.put("The Democratic Republic of the Congo","CD");
		ACRONYM.put("Costa Rica","CR");
		ACRONYM.put("Colombia","CO");
		ACRONYM.put("Sri Lanka","LK");
		ACRONYM.put("Cameroon","CM");
		ACRONYM.put("China","CN");
		ACRONYM.put("Saudi Arabia","SA");
		ACRONYM.put("Solomon Islands","SB");
		ACRONYM.put("Chile","CL");


				
	}
}


