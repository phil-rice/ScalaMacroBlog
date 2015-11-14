package org.validoc.scalaMacroBlog

object FunctionWrapperUser {
  def main(args: Array[String]): Unit = {
    val double = FunctionWrapper[Int,Int]((i: Int) => i * 2)
    println(s"double to String is $double")
    println(double(4))
    val partial =FunctionWrapper[Any, Any]({ case x: Int => x * 2; case x: Float => x * 2.2 })
    println(s"partial to String is\n$partial")
    println((x: Int)=>2*x)
  }
}