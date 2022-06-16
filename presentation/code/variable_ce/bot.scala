val variable = Variable("x")
Sequence(
  Assign(variable, 0)
  (x => x + 2)(variable)
)