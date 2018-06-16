package TechgigCodes

/**
 * Created by rohanp on 3/30/17.
 * In bhopal jail terrorist decides to run from jail, he can jump to x height
 * but slides down to y height every time he takes jump as walls are slippery.
 * There are several wall in jail he needs to jump from.
 * Input : x - height terrorist can jump to
 *         y - height he can slides down to
 *         (1,2,3) - Heights of the wall in array[Int]
 *  OutPut : Jump Attemps made by terrorist to clear all the walls
 *
 */
class JailBreakInBhopal {
  def getJumpCount(x : Int, y : Int , arr : Array[Int]) : Int = {
      var jumpCount : Int = 0
      arr.size match {
        case 0 => jumpCount
        case _ =>
          arr.map( wallSize => jumpOverTheWall(wallSize, x, y))
          jumpCount
      }

    def jumpOverTheWall(wallSize : Int, jump : Int, slide : Int ): Unit =
     wallSize match {
       case ws if(ws < 1) => jumpCount = jumpCount + 0
       case ws if(ws <= jump) => jumpCount = jumpCount + 1
       case ws if(ws > jump) =>
         jumpCount = jumpCount + 1
         jumpOverTheWall((ws - (jump - slide)), jump, slide)
     }
    jumpCount
  }
}

object JailBreakInBhopal{
  def main(args: Array[String]) {
    val obj = new JailBreakInBhopal
    val array1 : Array[Int] = Array[Int](10)
    val array2 : Array[Int] = Array[Int](9,10)
    val array3 : Array[Int] = Array[Int](132,345,123,234,345,567,999,456)
    println(util.Try(obj.getJumpCount(250,50,array3)))
  }
}