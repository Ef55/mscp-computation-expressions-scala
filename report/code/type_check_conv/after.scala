sequence(
  initialize(variable("x"), Number(0)),
  ifThenElse(
    ===(variable("x"), Number(1)),
    assign(variable("x"), Number(1)),
    assign(variable("x"), Number(-1))
  )
)
