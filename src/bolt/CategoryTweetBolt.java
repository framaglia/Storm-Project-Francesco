package bolt;

import java.util.Map;

import fi.foyt.foursquare.api.FoursquareApiException;
import fourSquare.FourSquareUtility;

import twitter4j.Status;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class CategoryTweetBolt extends BaseRichBolt{

	private static final long serialVersionUID = 1L;
	private OutputCollector collector;
	private String category;
	

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;


	}

	@Override
	public void execute(Tuple input) {
		final Status status = (Status) input.getValue(0);
		if(isValidCategory(status))
			collector.emit(input, new Values(status));

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("categoryTweet"));		
	}

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	public boolean isValidCategory(Status status){
		String ll = Double.toString(status.getGeoLocation().getLatitude()) + "," + Double.toString(status.getGeoLocation().getLongitude());
		try {
			FourSquareUtility fourSquareUtility = new FourSquareUtility();
			return fourSquareUtility.isValidCategoryVenue(ll, category);
		} 
			catch (FoursquareApiException e) {
				return false;
			}
		

	}
	
}