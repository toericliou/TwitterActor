package Message

import java.util.Date

/**
 * Created by eerilio on 5/25/15.
 */
case class SentDwtsTweet (override val time:Date, override val id:Long, override val text:String, override val destAddress:String) extends Tweet
case class TwitterDwtsTweet (override val time:Date,override val id:Long, override val text:String, override val destAddress:String) extends Tweet
case class GetDwtsTweet (hashTag:String, count :Int)


