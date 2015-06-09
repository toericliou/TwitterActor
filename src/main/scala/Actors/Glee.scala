package Actors

import Message.SentGleeTweet
import akka.actor.{Actor, ActorLogging}

/**
 * Created by eerilio on 5/25/15.
 */
class Glee extends Actor with ActorLogging {
  var message = ""

  def receive = {
    case SentGleeTweet(date, id, text, address) => log.info("{} - {}", id, text)
    case _ => //DoNth
  }
}
