import twitter4j.*;

//new comment
public class Test {

	/**
	 * @param args
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
	    int pos = 0, neg = 0;
		Twitter twitter = new TwitterFactory().getInstance();
	    Query query = new Query("Petraeus");
	    query.setCount(100);
	    QueryResult result = twitter.search(query);
		    for (Status tweet : result.getTweets()) {
		        System.out.println(tweet.getUser().getName() + ":" + tweet.getText());
		        if (tweet.getText().contains("stupid") || tweet.getText().contains("liar") || (tweet.getText().contains("fraud"))) {
		        	neg++;
		        } else {
		        	pos++;
		        }
		    }
		    result.nextQuery();
		System.out.println("total pos: " + pos + " total neg: " + neg);
	}

}
