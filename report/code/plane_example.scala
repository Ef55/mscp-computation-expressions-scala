val thrust = Variable("thrust")
val roll = Variable("roll")
thrust := 1 andThen
While(roll < 360) {
  roll := roll + 10 andThen 
  waitFor(1)
}