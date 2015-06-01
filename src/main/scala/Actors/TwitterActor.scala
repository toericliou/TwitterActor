package Actors

import Message.GetDwtsTweet
import akka.actor.{Actor, ActorLogging}
import twitter4j.{Query, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by eerilio on 5/27/15.
 */
class TwitterActor extends Actor with ActorLogging {

  val cb = new ConfigurationBuilder()
  cb.setDebugEnabled(true)
    .setOAuthConsumerKey("uxHMOFhz4LQNzDU1OPl6ICFry")
    .setOAuthConsumerSecret("p99mPF0nsXW9Gw8BtPWY9CcOuMO9yKG16IenPuBlP0MdcBgMzw")
    .setOAuthAccessToken("3297829109-CylqTlwceyNEMm72IwcmyBBgAXdvEEwzkvCUxtq")
    .setOAuthAccessTokenSecret("jpyc5JQHRB47mFDZdxRk13EkZx5clZNBJa7a0LhMLX8XF")
  val tf = new TwitterFactory(cb.build())
  val twitter = tf.getInstance()


  def receive = {
    case GetDwtsTweet(hashTag,count)=>
      val query = new Query(hashTag)
      query.count(count)
      val queryResult = twitter.search(query)
  }
}
