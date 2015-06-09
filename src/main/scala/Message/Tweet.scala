package Message

import java.util.Date

import TwitterHandler.ResultHandler


/**
 * Created by eerilio on 5/25/15.
 */
trait Tweet{
  def time:Date
  def id:Long
  def text:String
  def destAddress:String
}

abstract class APITweet{
  def hashTag:String
  def count :Int
  def resultHandler:ResultHandler
}