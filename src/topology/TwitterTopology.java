package topology;

import spout.TwitterSpout;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;
import bolt.TwitterBolt;

public class TwitterTopology {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		
		final TopologyBuilder builder = new TopologyBuilder();
		

		builder.setSpout("sample", new TwitterSpout());
		builder.setBolt("latitude", new TwitterBolt()).shuffleGrouping("sample");
		final Config conf = new Config();

		final LocalCluster cluster = new LocalCluster();

		cluster.submitTopology("test", conf, builder.createTopology());
		
		Utils.sleep(5 * 60 * 1000);
		cluster.shutdown();

	}

}
