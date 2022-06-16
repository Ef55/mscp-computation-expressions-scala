trait ASTBuilder[Tree[_]] {
  def sequence[S, T](l: Tree[S], r: Tree[T]): Tree[T]
  // Other methods for other constructs
  ...
}

object myBuilder[MyTree] extends ASTBuilder {...}