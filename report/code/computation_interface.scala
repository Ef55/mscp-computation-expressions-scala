trait ComputationBuilder[Computation[_]] {
  type Bound[T]

  // Bind a value `val x = ! m; f(x)`
  def bind[T, S](m: Computation[T], f: Bound[T] => Computation[S]): Computation[S]
  // Combine two computations `l; r`
  def combine[T, S](l: Computation[T], r: Computation[S]): Computation[S]
  // Create a computation
  def unit[T](t: => T): Computation[T]
  // Init the computation
  def init[T](c: () => Computation[T]): Computation[T]
  // Reassign a value `b =! v`
  def assign[T](b: Bound[T], v: Computation[T]): Computation[Unit]
}