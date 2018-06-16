package LearningScalaBookCodes

/**
 * Created by rohanp on 4/21/18.
 */
class TailrecExample5_50 {
  @annotation.tailrec
  final def print5_50(start : Int) : Int = {
    start > 50 match {
      case true => 0
      case false =>
        println( start )
        print5_50( start + 5 )
    }
  }
}

object TailrecExample5_50 extends  App {
  val obj = new TailrecExample5_50
  obj.print5_50(5)
}