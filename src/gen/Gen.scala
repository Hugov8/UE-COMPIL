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
  var indexClosure: Int = 0
  var bodies: String = ""
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
    case Let(_, t: ATerm, in: ATerm) => Code.Seq(emit(t) ::PushEnv :: Extend :: PopEnv :: emit(in) :: Nil)
    case VAR(_, i) => Search(i)

    case Fun(_, body: ATerm) =>
      val currentIndex = indexClosure
      indexClosure+=1
      val bodyCode = format(emit(body))
      bodies += "(func $closure"+currentIndex+" (result i32)\n"+ bodyCode + "\nreturn\n)\n"

      MkClos(currentIndex)

    case App(fun, arg) => Code.Seq(emit(arg) :: emit(fun) ::Code.Ins("call $apply")::PopEnv :: Nil)
    case _ => ???
  }

  private def Search(idx: Int): Code = Code.Seq(Code.Ins(s"i32.const $idx"):: Code.Ins("global.get $ENV") :: Code.Ins("call $search") ::Nil)
  private val PushEnv: Code = Code.Ins("global.get $ENV")
  private val PopEnv: Code = Code.Seq(Code.Ins("global.set $ACC")::Code.Ins("global.get $ACC") :: Code.Ins("global.set $ENV")::Code.Ins("global.get $ACC") ::Nil)
  private val Extend: Code = Code.Ins("call $cons")

  private def MkClos(idx: Int) = Code.Seq(Code.Ins(s"i32.const $idx")::PushEnv ::Code.Ins("call $pair") ::Nil)

  private def initEnv: String =
    val src = fromFile("src/gen/initEnv.wat")
    val res = src.mkString
    src.close
    res

  private def closureNames: String =
    (0 until indexClosure).foldLeft("")((acc, i) => {
      acc+"\n    "+"$closure"+i+ s";;index $i"
    })

  def gen(term: ATerm): String =
    val main = format(emit(term, 3))

    "(module\n" + initEnv +
    "\n;;Begin compiled code\n" +
      s"(table funcref\n  (elem\n$closureNames\n))\n" + bodies +
      "\n  (func (export \"main\") (result i32)\n" +
    s"$main\n" +
    "   return)\n  )\n"
}
