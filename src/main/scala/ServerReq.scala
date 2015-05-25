import twitter4j.TwitterFactory
import twitter4j._
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by eerilio on 5/25/15.
 */
object ServerReq{
  def main(args : Array[String]):Unit= {

    // (1) config work to create a twitter object
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("uxHMOFhz4LQNzDU1OPl6ICFry")
      .setOAuthConsumerSecret("p99mPF0nsXW9Gw8BtPWY9CcOuMO9yKG16IenPuBlP0MdcBgMzw")
      .setOAuthAccessToken("3297829109-CylqTlwceyNEMm72IwcmyBBgAXdvEEwzkvCUxtq")
      .setOAuthAccessTokenSecret("jpyc5JQHRB47mFDZdxRk13EkZx5clZNBJa7a0LhMLX8XF")
    val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()
    //val factory = new AsyncTwitterFactory(cb.build())
    //val asynchtwitter = factory.getInstance()

    // (2) use the twitter object to get your friend's timeline
    val statuses = twitter.getUserTimeline()
    System.out.println("Showing friends timeline.")
    val it = statuses.iterator()
    while (it.hasNext()) {
      val status = it.next()
      println(status.getUser().getName() + ":" +
        status.getText());
    }

    def getDwtsTweets(count:Int): Unit ={

    }

    val dwts = new Query("#dwts")
    val glee = new Query("#glee")
    val idol = new Query("#idol")
    val xfactor = new Query("#xfactor")

    val query = new Query("#weather")
    query.count(1)
    val queryResult1 = twitter.search(query)
    val queryResult2 = twitter.search(query)
    println(queryResult1)
  }
}
