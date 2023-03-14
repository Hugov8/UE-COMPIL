package gen

import ast.ATerm._
import ast.ATerm
import ast.Op._

enum Code {
  case Ins(s: String, space: Int=0)
  case Seq(seq: List[Code])
  case Test(code1: Code, code2: Code, space: Int=0)
}
object Gen {
  private def format(code: Code): String =

    code match {
    case Code.Ins(s, space) => " "*space + s
    case Code.Seq(seq) => seq.foldLeft("")((acc, c) => acc + format(c)+"\n")
    case Code.Test(c1, c2, space) => def n : String = "\n"+" "*space
      " "* space +
        s"(if (result i32)$n" +
        s"(then\n${format(c2)}$n)$n" +
        s"(else\n${format(c1)}$n)$n)"
  }
  private def emit(term: ATerm, space: Int = 1): Code = term match {
    case Lit(x) => Code.Ins(s"i32.const $x", space)
    case BOp(op, t1, t2) => Code.Seq(emit(t1, space) :: emit(t2, space) :: Code.Ins(op match
      case PLUS => "i32.add"
      case MINUS => "i32.sub"
      case TIMES => "i32.mul"
      case DIVIDE => "i32.div_u"
    , space) :: Nil
    )
    case IfZ(t1, t2, t3) => Code.Seq(emit(t1, space) :: Code.Test(emit(t2, space+1), emit(t3, space+1), space) :: Nil)
    case App(f, arg) => Code.Seq(Code.Ins("(call (")::emit(f)::Code.Ins(") (",1):: emit(arg)::Code.Ins("))")::Nil)
    case _ => ???
  }

  def gen(term: ATerm): String = "(module\n" +
    "  (func (export \"main\") (result i32)\n" +
    s"${format(emit(term,3))}\n" +
    "   return)\n  )\n"
}
