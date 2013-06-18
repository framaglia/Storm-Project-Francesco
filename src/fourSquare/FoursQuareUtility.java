package fourSquare;

import twitter4j.Status;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.entities.Category;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

public class FoursQuareUtility{	
	
	
	public String getTweetNationality(String ll) throws FoursquareApiException{
		FoursquareApi foursquareApi = new FoursquareApi("xx", "xx", "http://xx.it");

		String nationality = "";
		fi.foyt.foursquare.api.Result<VenuesSearchResult> result = foursquareApi.venuesSearch(ll, null, null, null, null, null, null, null, null, null, null);
		if (result.getMeta().getCode() == 200) {
			nationality = result.getResult().getVenues()[0].getLocation().getCountry().toString();
		}
		
		return nationality;
	}
	
	
	
	
	
	public boolean isValidVenue(String ll,String category) throws FoursquareApiException {

		boolean isValidVenue = false;

		FoursquareApi foursquareApi = new FoursquareApi("xx", "xx", "http://xx.it");
		fi.foyt.foursquare.api.Result<VenuesSearchResult> result = foursquareApi.venuesSearch(ll, null, null, null, null, null, null, null, null, null, null);
		if (result.getMeta().getCode() == 200) {
			for (CompactVenue venue : result.getResult().getVenues()) {
				for (Category cat : venue.getCategories()){
					if(cat.getName().equals(category)) isValidVenue=true;

				}

			}
		} 
			else {
				System.out.println("Error occured: ");
				System.out.println("  code: " + result.getMeta().getCode());
				System.out.println("  type: " + result.getMeta().getErrorType());
				System.out.println("  detail: " + result.getMeta().getErrorDetail()); 
			}
		
		return isValidVenue;
	}


	


}
