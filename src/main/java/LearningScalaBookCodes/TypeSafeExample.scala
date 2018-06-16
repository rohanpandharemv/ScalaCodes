package LearningScalaBookCodes

/**
 * Created by rohanp on 6/11/18.
 */
object TypeSafeExample extends App {
  for( i <- 1 to 100) i match {
    case n if(n % 15 == 0) => println("typesafe")
    case n if(n % 5 == 0 ) => println("safe")
    case n if(n % 3 == 0 ) => println("type")
    case _ => println(i)
  }
}
