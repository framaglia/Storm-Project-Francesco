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

public class NationalityTweetBolt extends BaseRichBolt{

	private static final long serialVersionUID = 2L;
	private OutputCollector collector;
	
	

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;


	}

	@Override
	public void execute(Tuple input) {
		final Status status = (Status) input.getValue(0);
		String ll = Double.toString(status.getGeoLocation().getLatitude()) + "," + Double.toString(status.getGeoLocation().getLongitude());
		try {
			FoursQuareUtility fourSquareUtility = new FoursQuareUtility();
			String nation = fourSquareUtility.getTweetNationality(ll);
			System.out.println(nation);
			collector.emit(input, new Values(nation));
			
			
			
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
