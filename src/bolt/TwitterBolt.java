package bolt;

import java.util.Map;

import twitter4j.Status;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class TwitterBolt extends BaseRichBolt{

	private static final long serialVersionUID = 1L;
	private OutputCollector collector;
	
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
		
		
	}

	@Override
	public void execute(Tuple input) {
		final Status status = (Status) input.getValue(0);
		final double longitude = status.getGeoLocation().getLongitude();
		final double latitude = status.getGeoLocation().getLatitude();
		System.out.println(latitude + "," + longitude);
		collector.emit(input, new Values(latitude));
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("latitude"));		
	}

}
