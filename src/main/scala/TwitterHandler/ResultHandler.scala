package TwitterHandler

import java.util.List

import twitter4j.{Status, QueryResult}

/**
 * Created by eerilio on 6/1/15.
 */
trait ResultHandler {
  def handle(queryResult: QueryResult, oldList:List[Status]) : List[Status]
}
