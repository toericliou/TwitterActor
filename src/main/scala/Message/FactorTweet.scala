package Message

import java.util.Date

import TwitterHandler.ResultHandler

/**
 * Created by eerilio on 6/1/15.
 */
case class SentFactorTweet (override val time:Date,override val id:Long, override val text:String, override val destAddress:String) extends Tweet
case class TwitterFactorTweet (override val time:Date,override val id:Long, override val text:String, override val destAddress:String) extends Tweet
case class GetFactorTweet (val hashTag:String, val count :Int, val resultHandler:ResultHandler) extends APITweet
