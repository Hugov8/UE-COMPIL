package gen

import ast.ATerm.*
import ast.ATerm
import ast.Op.*

import scala.io.Source.fromFile

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
    case Let(_, t: ATerm, in: ATerm) => Code.Seq(emit(t) ::PushEnv :: Extend :: PopEnv :: emit(in) :: Nil)
    case VAR(_, i) => Search(i)
    case _ => ???
  }

  private def Search(idx: Int): Code = Code.Seq(Code.Ins(s"i32.const $idx"):: Code.Ins("global.get $ENV") :: Code.Ins("call $search") ::Nil)
  private val PushEnv: Code = Code.Ins("global.get $ENV")
  private val PopEnv: Code = Code.Ins("global.set $ENV")
  private val Extend: Code = Code.Ins("call $cons")
  private def initEnv: String =
    val src = fromFile("src/gen/initEnv.wat")
    val res = src.mkString
    src.close
    res
  def gen(term: ATerm): String = "(module\n" + initEnv +
    "\n;;Begin compiled code\n  (func (export \"main\") (result i32)\n" +
    s"${format(emit(term,3))}\n" +
    "   return)\n  )\n"
}
