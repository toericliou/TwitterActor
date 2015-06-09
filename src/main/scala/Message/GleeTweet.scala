package Message

import java.util.Date

import TwitterHandler.ResultHandler

/**
 * Created by eerilio on 5/25/15.
 */
case class SentGleeTweet (override val time:Date,override val id:Long, override val text:String, override val destAddress:String) extends Tweet
case class TwitterGleeTweet (override val time:Date,override val id:Long, override val text:String, override val destAddress:String) extends Tweet
case class GetGleeTweet (val hashTag:String, val count :Int, val resultHandler:ResultHandler) extends APITweet

