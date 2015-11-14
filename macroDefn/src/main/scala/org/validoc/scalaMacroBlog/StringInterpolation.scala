package org.validoc.scalaMacroBlog

object StringInterpolation {

  def main(args: Array[String]): Unit = {
    val a = 1
    val b =2 
    print("The value of a is " + a + ", while the value of b is " + b)
    print(s"The value of a is $a  while the value of b is $b")
  }
}