package Message

import java.util.Date

/**
 * Created by eerilio on 5/25/15.
 */
case class GleeTweet (override val time:Date,override val id:Long, override val text:String, override val destAddress:String) extends Tweet

