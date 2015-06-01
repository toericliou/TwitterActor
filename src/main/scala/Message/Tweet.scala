package Message

import java.util.Date


/**
 * Created by eerilio on 5/25/15.
 */
trait Tweet{
  def time:Date
  def id:Long
  def text:String
  def destAddress:String
}
