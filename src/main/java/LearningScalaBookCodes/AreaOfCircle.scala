package LearningScalaBookCodes

/**
 * Created by rohanp on 6/11/18.
 */
object AreaOfCircle extends App {
  def areaOfo(radius : Double) = {
    math.pow(radius , 2) * math.Pi
  }
  println(areaOfo(8))

  def circleAreaString(radius : String) = {
    radius.isEmpty match {
      case true => 0.0
      case _ => math.pow(radius.toDouble,2) * math.Pi
    }
  }
  println(circleAreaString("5"))
  println(circleAreaString(""))
}
