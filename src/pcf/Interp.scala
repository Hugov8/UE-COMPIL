package pcf

import java.io.{FileInputStream, InputStream}
import ast.Term
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}
import parser.{ASTVisitor, Error, ErrorListener, PCFParser, ReportingPCFLexer, SyntaxError}
import interp.Value
import interp.Interp.{interp, valueToInt}
import typer.Type
import typer.Typer.typer
import parser.{transform, toPCF}

import scala.collection.immutable.Map


object Interp:
  def main(args: Array[String]): Unit =
    val is = if (args.length == 0) System.in else new FileInputStream(args(0))
    val verbose = args.length == 0 || args.length > 1 && args(1) == "-v"
    println(s"==> ${interpret(is, verbose)}")

  def interpret(is: InputStream, verbose: Boolean): (Value, Type) =
    val input = new ANTLRInputStream(is)
    // val lexer = new CalcLexer(input)
    val lexer = new ReportingPCFLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new PCFParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(new ErrorListener())
    val tree = parser.term()
    if (verbose) println(s"ANTLR Parse Tree: ${tree.toStringTree(parser)}")
    if ! Error.flag then
      val visitor = new ASTVisitor
      val term = transform(visitor.visit(tree)).asInstanceOf[Term]
      println(toPCF(term))
      if (verbose) println(s"AST: $term")
      val a = typer(term, Map())
      if (verbose) println(s"Type: $a")
      val result = interp(term, Map())
      (result, a)
    else throw new SyntaxError(Error.msg)



