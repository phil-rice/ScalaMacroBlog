package org.validoc.scalaMacroBlog

import language.experimental.macros

import reflect.macros.blackbox.Context

object HelloWorldOldMacro {
  def hello(): Unit = macro helloImpl

  def helloImpl(c: Context)(): c.Expr[Unit] = {
    import c.universe._
    reify { println("Hello World!") }
  }
}