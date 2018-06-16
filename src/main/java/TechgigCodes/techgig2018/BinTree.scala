package TechgigCodes.techgig2018

/**
 * Created by rohanp on 4/20/18.
 */

/**
 * Input:
 * 5
 * -1 0 0 1 1 2
 */

object BinTree extends  App {
  @annotation.tailrec
  def power( x : Int, n : Int, y : Int = 1) : Int = {
    n < 1 match {
      case true =>
        y
      case false =>
        power(x , n - 1 , y * x)
    }
  }

  println(power(2,1))
  /*def main(args : Array[String]) : Unit = {
    //for(i <- args) println(i)
    /*args.map(
      i =>
        println(i)
    )*/
    args(0) = "0"
    println(args.filter(_.toInt > 0).size)
  }*/
}

