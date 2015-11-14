package org.validoc.scalaMacroBlog

import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros
import scala.language.implicitConversions

object PartialFunctionWrapper {
  implicit def apply[P, R](fn: PartialFunction[P, R]): FunctionWrapper[P, R] = macro partial_apply_impl[P, R]

  def partial_apply_impl[P: c.WeakTypeTag, R: c.WeakTypeTag](c: Context)(fn: c.Expr[PartialFunction[P, R]]): c.Expr[FunctionWrapper[P, R]] = {
    import c.universe._
    c.Expr(q" new FunctionWrapper($fn, ${show(fn.tree)})")
  }

}
object FunctionWrapper {

  implicit def apply[P, R](fn: P => R): FunctionWrapper[P, R] = macro apply_impl[P, R]

  def apply_impl[P: c.WeakTypeTag, R: c.WeakTypeTag](c: Context)(fn: c.Expr[P => R]): c.Expr[FunctionWrapper[P, R]] = {
    import c.universe._
    c.Expr(q" new FunctionWrapper($fn, ${show(fn.tree)})")
  }

}

class FunctionWrapper[P, R](val fn: P => R, description: String) extends Function1[P, R] {
  def apply(p: P) = fn(p)
  override def toString = description
}

