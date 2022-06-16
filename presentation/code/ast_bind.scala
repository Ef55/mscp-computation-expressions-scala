def bind[T, S](
  value: Tree[T], 
  follow: Variable[T] => Tree[S]
): Tree[S] =
  val variable = freshVariable
  sequence(
    assign(variable, value),
    follow(variable)
  )