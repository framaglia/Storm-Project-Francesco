package bolt;



import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import fi.foyt.foursquare.api.FoursquareApiException;
import fourSquare.CategoryRetrievalUtility;
import fourSquare.FourSquareUtility;
import geoLocation.GeoCoord;

import socket.Socket;
import twitter4j.Status;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class NoCategoryTweetBolt extends BaseRichBolt{

	private static final long serialVersionUID = 2L;
	private static final Socket socket = new Socket();
	private OutputCollector collector;


	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector=collector;
		}

	@Override
	public void execute(Tuple input) {

		JSONObject json = new JSONObject();
		final Status status = (Status) input.getValue(0);
		String ll = Double.toString(status.getGeoLocation().getLatitude()) + "," + Double.toString(status.getGeoLocation().getLongitude());
		GeoCoord geo = new GeoCoord(status.getGeoLocation().getLatitude(), status.getGeoLocation().getLongitude());
		String geoString = geo.toDMSstring();


		try {
			json.put("ll", geoString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		FourSquareUtility fourSquareUtility = new FourSquareUtility();
		CategoryRetrievalUtility categoryRetrieval = new CategoryRetrievalUtility();


		String subCategory;
		String category;
		try {
			subCategory = fourSquareUtility.getBestCategory(ll);
			if (!subCategory.equals("NOT FOUND")){
				category = categoryRetrieval.getCategory(subCategory);
				
				try {
					json.put("category", category);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				socket.getSocket().emit("category", json);
			}

			} catch (FoursquareApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}






	}


	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("nationalityTweet"));		
	}



}