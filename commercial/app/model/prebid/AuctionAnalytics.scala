package model.prebid

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, _}

// todo include slot ID
case class AuctionAnalytics(pageViewId: String, auctionId: String, bids: Seq[BidAnalytics])

object AuctionAnalytics {

  implicit val reads: Reads[AuctionAnalytics] = (
    (__ \ "pv").read[String] and
      (__ \ "au").read[String] and
      (__ \ "bids").read[Seq[BidAnalytics]]
  )(AuctionAnalytics.apply _)
}
