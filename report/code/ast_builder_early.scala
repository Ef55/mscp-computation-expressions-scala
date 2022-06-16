trait AstBuilder[
  Tree[_], 
  Variable[_] <: Tree[_]
] {
  def initialize(variable: Variable[T], value: Tree[T]): Tree[Unit]
  def assign(variable: Variable[T], value: Tree[T]): Tree[Unit]
  def sequence[S](first: Tree[S], second: Tree[T]): Tree[T]
  def ifThenElse[T](cond: Tree[Boolean], thenn: Tree[T], elze: Tree[T]): Tree[T]
}