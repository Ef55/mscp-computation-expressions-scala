def bind[T, S](
  m: Tree[T], 
  f: Variable[T] => Tree[S]
): Tree[S] = 
  // User provided variable generator
  val v = freshVariable[T]  
  sequence(
    // Initialize v with value (of tree) m
    initialize(v, m), 
    // Allow f to refer to v
    f(v)              
  )