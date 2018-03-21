package model.prebid

import java.time.Duration

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class BidAnalytics(bidderName: String, timeToRespond: Duration)

object BidAnalytics {

  implicit val reads: Reads[BidAnalytics] = (
    (__ \ "n").read[String] and
      (__ \ "ttr").read[Long].map(Duration.ofMillis)
  )(BidAnalytics.apply _)
}
