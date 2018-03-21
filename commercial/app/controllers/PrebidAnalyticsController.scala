package commercial.controllers

import common.Logging
import model.prebid.AuctionAnalytics
import play.api.libs.json.JsValue
import play.api.mvc._

class PrebidAnalyticsController(val controllerComponents: ControllerComponents) extends BaseController with Logging {

  def insert(): Action[JsValue] = Action(parse.json(maxLength = 100)) { request =>
    request.body.asOpt[AuctionAnalytics] map { analytics =>
      log.info(analytics.toString)
    } getOrElse {
      log.error(s"Invalid analytics: ${request.body}")
    }
    NoContent
  }
}
