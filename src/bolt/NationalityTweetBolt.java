package bolt;



import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import fi.foyt.foursquare.api.FoursquareApiException;
import fourSquare.FourSquareUtility;
import geoLocation.AcronimNationUtility;
import geoLocation.GeoCoord;

import socket.Socket;
import twitter4j.Status;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class NationalityTweetBolt extends BaseRichBolt{

	private static final long serialVersionUID = 2L;
	private static final Map<String,String> ACRONYM = new HashMap<String, String>(new AcronimNationUtility().getACRONYM());
	private static final Socket socket = new Socket();
	private OutputCollector collector;
	

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;


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
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FourSquareUtility fourSquareUtility = new FourSquareUtility();
			String nation = fourSquareUtility.getTweetNationality(ll);
			
			String acronym = ACRONYM.get(nation);
			System.out.println("finded tweet in: "+ nation + " ACR: "+acronym);
			try {
				json.put("acr", acronym);
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
		} catch (FoursquareApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		socket.getSocket().emit("coords", json);
		
		

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("nationalityTweet"));		
	}


	
}