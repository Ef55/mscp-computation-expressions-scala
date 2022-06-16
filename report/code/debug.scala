val debug: Boolean = ???

val orientation = ! (???)
If (orientation !== Orientation.N) { // (1)
  if debug then // (2)
    robPrint(orientation === Orientation.S)
  else
    robNop
  // Remaing of the code
  ???
}