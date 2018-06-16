package scripts

import scala.concurrent.duration.DurationInt
import scala.concurrent.{ Await, Future }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Random}

/**
 * Created by rohanp on 12/14/17.
 * unblocking Future code
 */
object ScalaFutureExample extends App {
  println("starting calculation")

  val f = Future {
    Thread.sleep(Random.nextInt(500))
    1+2
  }

  f.onComplete {
    case Success(value) => println(s"Got the value $value")
    case Failure(ex) => ex.getMessage
  }

  println("A......."); Thread.sleep(100L)
  println("B......."); Thread.sleep(100L)
  println("C......."); Thread.sleep(100L)
  println("D......."); Thread.sleep(100L)
  println("E......."); Thread.sleep(100L)

  Thread.sleep(5000L)
}


//Blocking Future code
/**
 * object ScalaFutureExample extends App {
  println("starting calculation")

  val f = Future {
    Thread.sleep(1000L)
    1+2
  }

  val result = Await.result(f,1 second)
  println(result)
  Thread.sleep(5000L)
}
 */
