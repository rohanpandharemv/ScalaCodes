package LearningScalaBookCodes

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.params.HttpConnectionParams
import net.liftweb.json._

/**
 * Created by rohanp on 4/6/17.
 */
class FutureSequenceAPIcalls {
  val api_key = "87086d48b9c617b7ad3b96a3251c83de"
  def getResultJson(city: String,
                    continent : Option[String]): String = {

    val api_Url = continent match {
      case Some(conti) => s"http://api.openweathermap.org/data/2.5/weather?q=$city,$conti&appid=$api_key"
      case None => s"http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$api_key"
    }
    //makeHttpGetRequest(api_Url)
    //getResultWithTimeout(api_Url)
    getRestContentHttpsClient(api_Url)
  }

  /**
   * Simple function to make API call
   * Several problems with it like timeouts not available
   * Cant even specify the Request Type
   * @param URL Source Url to make connection to
   * @throws java.io.IOException
   * @return Contents from the Source Url
   */
  @throws(classOf[java.io.IOException])
  def makeHttpGetRequest(URL : String) : String = {
    io.Source.fromURL(URL).mkString.trim
  }

  /**
   * HttpRequest method including
   * connectionTimeOut, ReadTimeOut, RequestMethod
   * @param url Source Url to make connection to
   * @param connectTimeOut default is 5000 ms
   * @param readTimeouts  default is 5000 ms
   * @param requestMethod default is "GET"
   * @throws java.io.IOException
   * @throws java.net.SocketTimeoutException
   * @return Contents from the Source Url
   */
  @throws(classOf[java.io.IOException])
  @throws(classOf[java.net.SocketTimeoutException])
  def getResultWithTimeout(url : String,
                            connectTimeOut : Int = 5000,
                            readTimeouts: Int = 5000,
                            requestMethod : String = "GET"): String = {
    import java.net.HttpURLConnection
    val Conn = (new java.net.URL(url)).openConnection.asInstanceOf[HttpURLConnection]
    Conn.setConnectTimeout(connectTimeOut)
    Conn.setReadTimeout(readTimeouts)
    Conn.setRequestMethod(requestMethod)
    val inputStream = Conn.getInputStream
    val jsonContent = io.Source.fromInputStream(inputStream).mkString.trim
    if(inputStream!=null) inputStream.close()
    jsonContent
  }

  /**
   * Method to get REST response by building HttpClient
   * @param url Url from Json Response to be collected
   * @param connectionTimeOut timeout
   * @param socketTimeOut timeout
   * @return json String response
   */
  def getRestContentHttpsClient(url : String,
                                 connectionTimeOut : Int = 5000,
                                 socketTimeOut : Int = 5000): String = {

    val httpClient = buildHttpClient(connectionTimeOut, socketTimeOut)
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    var content = ""
    Option(entity) match {
      case Some(con) =>
        val inputStream = con.getContent
        content = io.Source.fromInputStream(inputStream).getLines.mkString
        inputStream.close()
    }
    httpClient.getConnectionManager.shutdown
    content
  }

  /**
   * Method to build Build Http Client & set
   * Connection Timeout, SocketTimeout
   * @param connectionTimeout
   * @param socketTimeOut
   * @return Instance of HttpClient
   */
  def buildHttpClient(connectionTimeout : Int, socketTimeOut : Int) : DefaultHttpClient = {
    val httpClient = new DefaultHttpClient()
    val httpParams = httpClient.getParams
    HttpConnectionParams.setConnectionTimeout(httpParams,connectionTimeout)
    HttpConnectionParams.setConnectionTimeout(httpParams,socketTimeOut)
    httpClient.setParams(httpParams)
    httpClient
  }

  /**
   * Convert Json String to JValue Object
   * @param str Input Json String got from API
   * @return JValue object converted from
   */
  def stringToJsonObj(str : String) : JValue = {
    implicit val formats = DefaultFormats
    parse(str)
  }



}

object FutureSequenceAPIcalls {
  def main(args: Array[String]) {

    val obj = new FutureSequenceAPIcalls
    //println(obj.getResultJson("pune",Option("ind")))
    //println(obj.getResultJson("pune",None))
    //println(obj.getResultJson("Mumbai",None))
    //println(prettyRender(obj.stringToJsonObj(obj.getResultJson("Mumbai",None))))
     val main = (obj.stringToJsonObj(obj.getResultJson("Mumbai",None)) \\ "main").children
     main.map(i => println(i \\ "temp"))
  }
}