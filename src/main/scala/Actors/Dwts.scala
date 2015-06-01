package Actors

import Message.{SentDwtsTweet}
import akka.actor.{Actor, ActorLogging}

/**
 * Created by eerilio on 5/25/15.
 */
class Dwts extends Actor with ActorLogging {

  var message = ""

  def receive = {
    case SentDwtsTweet(time, id, text, address) => log.info("*************"+time+"- "+id+": "+text+"*********************")
    case _ => //DoNth
  }
}
