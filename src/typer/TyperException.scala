package typer

object InterpException {
  class UnificationFailed(message: String) extends Exception(message)
  class ShouldNotHappenException() extends Exception("Should not happen")
}
