package spout;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import twitter4j.FilterQuery;
import twitter4j.GeoLocation;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.URLEntity;
import twitter4j.User;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class TwitterSpout extends BaseRichSpout {

	private static final long serialVersionUID = 3L;
	LinkedBlockingQueue<Status> queue = null;
	SpoutOutputCollector collectorSpout;

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {

		collectorSpout = collector;
		queue = new LinkedBlockingQueue<Status>(1000);
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        StatusListener listener = new StatusListener() {
           
        	@Override
            public void onStatus(Status status) {
        		boolean isValid = isValid(status);
        		
        		if(isValid) queue.offer(status);
        			//System.out.println(status);
        	
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }


			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub

			}

			public boolean isValid(Status status){

				boolean valid = false;
				User user = status.getUser();

				if (user.isGeoEnabled()) {
					
					URLEntity[] urls;
					try {
						urls = status.getURLEntities();
						if (urls[0] != null) {
							String displayURL = urls[0].getDisplayURL();
							String subURL = displayURL.substring(0, 3);
							if (subURL.equals("4sq")) {
								GeoLocation geo = status.getGeoLocation();
								if (geo != null) 
									valid = true;

							}
						}
					} catch (Exception e) {
						
					}
					
				}

				return valid;
			}
        };
        
        twitterStream.addListener(listener);
        twitterStream.sample();
        FilterQuery filtro=new FilterQuery();
        String[] arrayQuery={"4sq"}; 
        filtro.track(arrayQuery);
        twitterStream.filter(filtro);
	}

	@Override
	public void nextTuple() {
		Status status = queue.poll();
        if(status == null) {
            Utils.sleep(50);
        } else {
            collectorSpout.emit(new Values(status));
        }

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("tweetLL"));

	}

}