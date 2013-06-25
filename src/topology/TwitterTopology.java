package topology;

import socket.Socket;
import spout.TwitterSpout;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;
import bolt.CategoryTweetBolt;
import bolt.NationalityTweetBolt;
import bolt.NoCategoryTweetBolt;

public class TwitterTopology {
	
	
	public static void main (String[] args){
		
		TwitterTopology twitterTopology = new TwitterTopology();
		final Socket socket = new Socket(twitterTopology);
		
	}

	public static void executeStorm(String category) throws Exception {

		final TopologyBuilder builder = new TopologyBuilder();
    
		CategoryTweetBolt categoryBolt = new CategoryTweetBolt();
		NationalityTweetBolt nationBolt = new NationalityTweetBolt();
		categoryBolt.setCategory(category);
		NoCategoryTweetBolt noCategoryTweetBolt = new NoCategoryTweetBolt();
		
		
		builder.setSpout("tweetLL", new TwitterSpout(),10);
		builder.setBolt("noCategoryTweetBolt", noCategoryTweetBolt,5).shuffleGrouping("tweetLL");
		builder.setBolt("categoryTweet",categoryBolt,5).shuffleGrouping("tweetLL");
		builder.setBolt("nationalityTweet",nationBolt,5).shuffleGrouping("categoryTweet");
	
		final Config conf = new Config();
		final LocalCluster cluster = new LocalCluster();

		cluster.submitTopology("test", conf, builder.createTopology());

		
		Utils.sleep(5 * 60 * 1000);
		cluster.shutdown();

	}



}