package org.validoc.scalaMacroBlog

import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros

object QuasiQuotes {

  val universe: scala.reflect.runtime.universe.type = scala.reflect.runtime.universe
  import universe._

  def helloWithQuasiquotesImpl(c: Context): c.Expr[Unit] = {
    import c.universe._
    val value = q"""println("Hello")"""
    c.Expr(value)
  }

  def hello = macro helloWithQuasiquotesImpl

  def main(args: Array[String]): Unit = {
    val tree = q"i am { a quasiquote }"
    println(tree)
  }
}