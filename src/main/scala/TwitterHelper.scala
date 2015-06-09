import java.util.List

import Actors.TwitterActor
import Message.{GetDwtsTweet, GetFactorTweet, GetGleeTweet, GetIdolTweet}
import TwitterHandler.ResultHandler
import akka.actor.{ActorSystem, Props}
import twitter4j.{QueryResult, Status}

import scala.collection.JavaConversions._
import scala.concurrent.duration._


/**
 * Created by eerilio on 5/25/15.
 */
object TwitterHelper {

  val DWTS_HASHTAG = "#dwts"
  val GLEE_HASHTAG = "#glee"
  val IDOL_HASHTAG = "#idol"
  val XFACTOR_HASHTAG = "#xfactor"
  //val myHandler = new MyHandler

  def start() = {
    import system.dispatcher
    val system = ActorSystem("ClusterSystem")
    //val clustorActor = system.actorOf(Props[ClusterListener], name = "clusterListener")
    val myHandler = new MyHandler()
    val twitterActor = system.actorOf(Props[TwitterActor], name = "twitterActor")

    system.scheduler.schedule(0 seconds, 10 seconds, twitterActor, GetDwtsTweet(DWTS_HASHTAG,1,myHandler))
    system.scheduler.schedule(0 seconds, 10 seconds, twitterActor, GetGleeTweet(GLEE_HASHTAG,1,myHandler))
    system.scheduler.schedule(0 seconds, 10 seconds, twitterActor, GetIdolTweet(IDOL_HASHTAG,1,myHandler))
    system.scheduler.schedule(0 seconds, 10 seconds, twitterActor, GetFactorTweet(XFACTOR_HASHTAG,1,myHandler))
  }
}

class MyHandler() extends ResultHandler {

  override def handle(queryResult: QueryResult, oldList:List[Status]): List[Status] = {
    val list: List[Status] = queryResult.getTweets
    if (list != null && !list.equals(oldList)) {
      for (x <- list) handleStatus(x)
      list
    }
    else{
      println("==========NO NEW TWEETS==========")
      oldList
    }
  }

  def handleStatus(status: Status): Unit = {
    println("==============TWEET START==============")
    println(status.getCreatedAt)
    println(status.getId)
    println(status.getText)
    println("==============TWEET FINISH=============")
    println("")
    if(status.getText.toLowerCase.contains("#dwts")){
      //cluster ! new TwitterDwtsTweet(status.getCreatedAt, status.getId,status.getText, "akka.tcp://ClusterSystem@127.0.0.1:2551")
    }
  }



}
