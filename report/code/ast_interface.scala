trait AstBuilder[Tree[_]] 
extends ComputationBuilder[Tree] {

  // User must define
  type Variable[T] <: Tree[T]
  def freshVariable[T]: Variable[T]
  def initialize[T](va: Variable[T], init: Tree[T]): Tree[Unit]
  def constant[T](t: T): Tree[T]
  def combine[T, S](l: Tree[T], r: Tree[S]): Tree[S]
  def assign[T](b: Variable[T], v: Tree[T]): Tree[Unit]

  // Computation expression implementation
  type Bound[T] = Variable[T]
  def bind[T, S](m: Tree[T], f: Variable[T] => Tree[S]): Tree[S] =
    val v = freshVariable[T]
    combine(initialize(v, m), f(v))
  def unit[T](t: => T): Tree[T] =
    constant[T](t)
  def init[T](c: () => Tree[T]): Tree[T] =
    c()
}