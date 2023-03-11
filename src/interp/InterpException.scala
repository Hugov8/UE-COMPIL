package interp

object InterpException {
 class VariableNotDefined(message: String) extends Exception(message)
 class DivisionByZero extends Exception("Division by 0")
 //class NotYetImplemented extends Exception("Not yet implemented")
 class IntValueExpected extends Exception("Int Value expected")
 class FunctionExpected extends Exception("Function expected")
 class ShouldNotHappenException extends Exception("Should not happen")
}
