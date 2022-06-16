val x: Variable[Boolean] = robInput
val b: Boolean = x // Should not be allowed

def f(u: Tree[Unit]) = ???
f(()) // Should not be allowed