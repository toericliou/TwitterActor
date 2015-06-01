package Actors

import Message.{TwitterDwtsTweet, SentDwtsTweet, Tweet}
import akka.actor.{Props, Actor, ActorLogging}
import akka.cluster.ClusterEvent._
import akka.cluster.{Cluster, Member}

/**
 * Created by eerilio on 5/25/15.
 */
class ClusterListener extends Actor with ActorLogging {

  val cluster = Cluster(context.system)
  val clusterPath = "/user/clusterListener"

  val DwtsActor = context.system.actorOf(Props[Dwts])

  var nodes = Set.empty[Member]

  override def preStart(): Unit ={
    cluster.subscribe(self, initialStateMode = InitialStateAsEvents, classOf[MemberEvent], classOf[UnreachableMember])
  }

  override def postStop(): Unit ={
    cluster.unsubscribe(self)
  }
  def receive = {
    case MemberUp(member) =>
      nodes += member
      log.info("Member is Up: {}", member.address)
    case UnreachableMember(member) =>
      log.info("Member detected as unreachable: {}", member)
    case MemberRemoved(member, previousStatus) =>
      nodes -= member
      log.info("Member is Removed: {} after {}",
        member.address, previousStatus)
    case TwitterDwtsTweet(time,id, text, address) =>
      sendMessage(new SentDwtsTweet(time,id,text,address))
    case SentDwtsTweet(time, id, text, address) =>
      log.info("Message Recieved")
      DwtsActor ! SentDwtsTweet(time,id,text,address)
    case _: MemberEvent =>
  }

  def sendMessage(tweet:Tweet): Unit ={
    for(member<-nodes){
      if(member.address.toString.equals(tweet.destAddress)) {
        log.info(member.address.toString)
        context.actorSelection(member.address+clusterPath) ! tweet
        log.info("Message Sent")
      }
    }
  }
}
