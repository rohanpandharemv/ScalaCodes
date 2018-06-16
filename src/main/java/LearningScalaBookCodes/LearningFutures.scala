package LearningScalaBookCodes

import concurrent.ExecutionContext.Implicits.global
import concurrent.Future
import scala.util.{Success,Failure}

/**
 * Created by rohanp on 4/4/17.
 */
class LearningFutures {
  def nextFuture( x : Int) = {
    val f = Future {
      sleep(util.Random.nextInt(3000))
      42
    }
    println("------------Before OnComplete------------")
    /*f.onComplete{
      case Success(value) => println(s"Got the callback, meaning $value")
      case Failure(ex) => ex.printStackTrace()
    }*/

    f.onSuccess{
      case x => println(x)
    }

    println("A..........")
    sleep(500)
    println("B..........")
    sleep(500)
    println("C..........")
    sleep(500)
    println("D..........")
    sleep(500)
  }
  def sleep(t : Int): Unit = {
    Thread.sleep(t)
  }
}

object LearningFutures{
  def main(args : Array[String]) = {
    val obj = new LearningFutures
    obj.nextFuture(400)
  }
}