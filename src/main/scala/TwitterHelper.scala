import java.util.List
import java.util.concurrent.{ExecutorService, Executors}

import twitter4j.{QueryResult, Status}

import scala.collection.JavaConversions._

/**
 * Created by eerilio on 5/25/15.
 */
object TwitterHelper {

  val pool: ExecutorService = Executors.newFixedThreadPool(4)
  val dwts = "#dwts"
  val glee = "#glee"
  val idol = "#idol"
  val xfactor = "#xfactor"
  //val myHandler = new MyHandler

  def start() = {
    //val system = ActorSystem("ClusterSystem")
    //val clustorActor = system.actorOf(Props[ClusterListener], name = "clusterListener")
    val myHandler = new MyHandler(/*clustorActor*/)
    pool.submit(new ServerReq(dwts, 1, 20 * 1000, myHandler))
    pool.submit(new ServerReq(glee, 1, 20 * 1000, myHandler))
    pool.submit(new ServerReq(idol, 1, 20 * 1000, myHandler))
    pool.submit(new ServerReq(xfactor, 1, 20 * 1000, myHandler))
  }
}

class MyHandler(/*cluster:ActorRef*/) extends ResultHandler {

  override def handle(queryResult: QueryResult): Unit = {
    val list: List[Status] = queryResult.getTweets
    if (list != null) {
      for (x <- list) handleStatus(x)
    }
  }

  def handleStatus(status: Status): Unit = {
    println("=====a=======")
    println(status.getCreatedAt)
    println(status.getId)
    println(status.getText)
    println("=====b=======")
    if(status.getText.toLowerCase.contains("#dwts")){
      //cluster ! new TwitterDwtsTweet(status.getCreatedAt, status.getId,status.getText, "akka.tcp://ClusterSystem@127.0.0.1:2551")
    }
  }



}
