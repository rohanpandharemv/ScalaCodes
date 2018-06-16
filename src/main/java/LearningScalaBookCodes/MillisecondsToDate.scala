package LearningScalaBookCodes

/**
 * Created by rohanp on 4/22/18.
 */
class MillisecondsToDate {
  private def m2date(m : Long) : String = {
    m > 0 match {
      case true =>
        val str = new java.util.Date(m)
        str.toString
      case false =>
        0.toString
    }
  }
}

object MillisecondsToDate extends App {
  val obj = new MillisecondsToDate
  println(obj.m2date(143452342341l))
}