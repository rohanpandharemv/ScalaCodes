package TechSwat

/**
 * Created by rohanp on 8/17/17.
 */
object TechSwatCode2 {
  def main(args : Array[String]) : Unit = {
    println(getMaximumTravelTime(args))
  }
  def getMaximumTravelTime( args : Array[String]) : Int = {
    val timeList = args(0).split(",").map(_.toInt).sorted
    println(timeList.toList)
    timeList.size match {
      case 1 =>  timeList(0)
      case 2 =>  timeList.last
      case 3 =>  timeList.reduce( _ + _ )
      case 4 =>  timeList(0) + (timeList(1) * 3) + timeList(3)
      case 5 =>  (timeList(0) * 2) + (timeList(1) * 3) + timeList(2) + timeList(4)
    }
  }
}
