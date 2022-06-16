enum Orientation:
  case N,S,W,E

sealed trait AST[+T]
class Variable[+T](id: String) extends AST[T]
// Basic constructs
case class Assign[T](vr: Variable[T], vl: AST[T]) extends AST[Unit]
case class Sequence[+T](l: AST[?], r: AST[T]) extends AST[T]
// Arithmetic
case class Number(i: Int) extends AST[Int]
case class Add(l: AST[Int], r: AST[Int]) extends AST[Int]
// Logic & control flow
case class ===[T](l: AST[T], r: AST[T]) extends AST[Boolean] // Test two values for equality
case class !==[T](l: AST[T], r: AST[T]) extends AST[Boolean] 
case class Ite[+T](cnd: AST[Boolean],thenn: AST[T],elze: AST[T]) extends AST[T]//If-then-else
case class While[T](cnd: AST[Boolean], body: AST[?]) extends AST[Unit]// While-loop
// IO
case object robOrientation extends AST[Orientation] // Get current orientation
case object robX extends AST[Int]
case object robY extends AST[Int]
case object robInput extends AST[Boolean] // Read 1 bit from (rob's) stdin
case class robOutput(out: AST[Boolean]) extends AST[Unit] // Write 1 bit to (rob's) stdout
// Navigation
case object robRotateLeft extends AST[Orientation] // Rotate and return new orientation
case object robRotateRight extends AST[Orientation]
case object robAdvance extends AST[Unit] // Advance to tile in front