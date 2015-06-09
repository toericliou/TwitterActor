import TwitterHandler.ResultHandler
import twitter4j.conf.ConfigurationBuilder
import twitter4j.{Query, TwitterFactory}

/**
 * Created by eerilio on 5/25/15.
 */
class ServerReq (hashTag:String, count:Int, interval: Long , resultHandler: ResultHandler) extends Runnable {
  val cb = new ConfigurationBuilder()
  cb.setDebugEnabled(true)
    .setOAuthConsumerKey("uxHMOFhz4LQNzDU1OPl6ICFry")
    .setOAuthConsumerSecret("p99mPF0nsXW9Gw8BtPWY9CcOuMO9yKG16IenPuBlP0MdcBgMzw")
    .setOAuthAccessToken("3297829109-CylqTlwceyNEMm72IwcmyBBgAXdvEEwzkvCUxtq")
    .setOAuthAccessTokenSecret("jpyc5JQHRB47mFDZdxRk13EkZx5clZNBJa7a0LhMLX8XF")
  val tf = new TwitterFactory(cb.build())
  val twitter = tf.getInstance()
  val query = new Query(hashTag)


  def run(){
    try {
      while (true) {
        query.count(count)
        val queryResult = twitter.search(query)
        //resultHandler.handle(queryResult)
        Thread sleep interval
      }
    } catch {
      case e: Exception => {
        println(e)
      }
    } finally {

    }
  }
}


