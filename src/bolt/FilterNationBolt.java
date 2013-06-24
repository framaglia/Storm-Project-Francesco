package bolt;

import java.util.Map;

import fi.foyt.foursquare.api.FoursquareApiException;
import fourSquare.FoursQuareUtility;

import twitter4j.Status;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class FilterNationBolt extends BaseRichBolt{

	private static final long serialVersionUID = 1L;
	private OutputCollector collector;
	private String nation;
	

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;


	}

	@Override
	public void execute(Tuple input) {
		final Status status = (Status) input.getValue(0);
		try {
			if(isValidNation(status))
				collector.emit(input, new Values(status));
		} catch (FoursquareApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("categoryTweet"));		
	}

	
	
	
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public boolean isValidNation(Status status) throws FoursquareApiException{
		String ll = Double.toString(status.getGeoLocation().getLatitude()) + "," + Double.toString(status.getGeoLocation().getLongitude());
		FoursQuareUtility fourSquareUtility = new FoursQuareUtility();
		return fourSquareUtility.isValidNationVenue(ll, nation);
		

	}
	
}