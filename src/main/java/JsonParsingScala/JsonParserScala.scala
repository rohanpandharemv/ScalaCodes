package JsonParsingScala

import net.liftweb.json._

/**
 * Created by rohanp on 6/1/17.
 */
/*class JsonParserScala {





}*/

object  JsonParserScala{
  implicit val format = DefaultFormats



  def main(args : Array[String]) : Unit = {

    /*for(i <- 1 to 5) {
      println()
      for(j <- 1 to i) {
        print("*")
        if(j == 5){
          for(k <- j to 1){
            println()
            for(l <- 1 to k)
              print("*")
          }
        }
      }
    }*/


    /*for( i <- 5 to 1) {
      println(i + " ")
      /*for(j <- 1 to i){
        print("*")
      }*/
    }*/



  }

  object TipStatus extends Enumeration { val todo, done = Value }
  case class reviewJason(metaTag : ResponseMeta, responseTag : Response)
  case class ResponseMeta(code : Int, requestId : String, errorType : Option[String], errorDetail : Option[String],
                          message : Option[String], errorMessage : Option[String])
  {
    lazy val isError : Boolean = (200 > code) || (300 <= code) || errorType.isDefined || errorDetail.isDefined || errorMessage.isDefined

    lazy val errorText : String = {
      isError match {
        case false =>
          ""
        case true =>
          val sb = new StringBuilder()
          sb.append(s"code ($code)")
          if (errorType.isDefined) sb.append(s" error type (${errorType.get})")
          if (errorDetail.isDefined) sb.append(s" error detail (${errorDetail.get})")
          if (errorMessage.isDefined) sb.append(s" error message (${errorMessage.get})")
          sb.toString()
      }
    }
  }
  case class Response(tipsTag : Tips)
  case class Tips(count : Int, items : List[Items])
  case class Items( id: String, text: String, createdAt: Long, status: Option[ TipStatus.Value ],
                    canonicalUrl: Option[ String ], canonicalPath: Option [ String ], user: Option[ User ], venue: Option[ Counter ],
                    todo: Option[ Counter ], likes: Option[ Counter ] )
  case class Counter( count: Int )
  /*(id : String,
                   createdAt : Long,
                   test : String,
                   entities : Entities,
                   Type : String,
                   canonicalUrl : String,
                   canonicalPath : String,
                   likes : Likes,
                   logView : Boolean,
                   saves : Likes,
                   agreeCount : Int,
                   disagreeCount : Int,
                   justification : Justification,
                   user : User,
                   authorInteractionType : String
  )*/
  case class Entities(indices : List[Int],id : String, Type : String,text : String)
  case class Likes(count : Int, groups : List[Groups])
  case class Groups()
  case class Justification(message : String, justificationType : String)
  case class User(id : String, firstName : String, lastName : String,
                   gender : String, canonicalUrl : String, canonicalPath : String,
                  photo : Photo)
  case class Photo(prefix : String, suffix : String)

  val jsonString =
    """
      |{
      |    "meta": {
      |        "code": 200,
      |        "requestId": "592fd1cd4c1f6749d862638e"
      |    },
      |    "response": {
      |        "tips": {
      |            "count": 109,
      |            "items": [
      |                {
      |                    "id": "58d5457723188e13ab40cad3",
      |                    "createdAt": 1490371959,
      |                    "text": "Spend the extra $ and book yourselves a corner suite! It's HUGE!",
      |                    "entities": [
      |                        {
      |                            "indices": [
      |                                22,
      |                                26
      |                            ],
      |                            "id": "52e132bd498ec24bad56745d",
      |                            "type": "tip_taste_match",
      |                            "text": "books"
      |                        }
      |                    ],
      |                    "type": "user",
      |                    "canonicalUrl": "https://foursquare.com/item/58d5457723188e13ab40cad3",
      |                    "canonicalPath": "/item/58d5457723188e13ab40cad3",
      |                    "likes": {
      |                        "count": 0,
      |                        "groups": [ ]
      |                    },
      |                    "logView": true,
      |                    "saves": {
      |                        "count": 0,
      |                        "groups": [ ]
      |                    },
      |                    "agreeCount": 0,
      |                    "disagreeCount": 0,
      |                    "justification": {
      |                        "message": "Been here 10+ times",
      |                        "justificationType": "visits"
      |                    },
      |                    "user": {
      |                        "id": "3859639",
      |                        "firstName": "Albert",
      |                        "lastName": "Revah",
      |                        "gender": "male",
      |                        "canonicalUrl": "https://foursquare.com/user/3859639",
      |                        "canonicalPath": "/user/3859639",
      |                        "photo": {
      |                            "prefix": "https://igx.4sqi.net/img/user/",
      |                            "suffix": "/3859639-DMQQMEDANWURKLQF.jpg"
      |                        }
      |                    },
      |                    "authorInteractionType": "liked"
      |                }
      |             ]
      |          }
      |     }
      |}
    """.stripMargin
}
