package parser
import ast.*
import ast.Op._
import ast.Term.{Lit, BOp, IfZ, VAR, Let, Fun, Fix, App}

def toPCF(ast: AST, tab: Int =0, prio: Boolean = false): String = "\t"*tab + (ast match
  case Lit(n) => n.toString
  case BOp(op, t1, t2) =>
    val opString = op match
      case PLUS => "+"
      case MINUS => "-"
      case TIMES => "*"
      case DIVIDE => "/"
    val res = toPCF(t1.asInstanceOf[AST], prio=op==TIMES || op==DIVIDE) + opString + toPCF(t2.asInstanceOf[AST], prio=op==TIMES || op==DIVIDE)
    if prio && (op==PLUS || op==MINUS) then s"(${res})" else res
  case IfZ(t1, t2, t3) =>
    val t1S = toPCF(t1)
    val t2S = toPCF(t2, tab +1)
    val t3S = toPCF(t3, tab+1)
    "if ("+t1S+"==0)\n"+"\t"*tab+"then (\n"+t2S+")\n"+"\t"*tab+"else (\n+"+t3S+"\n"+"\t"*tab+")"
  case VAR(x) => x
  case Let(x, t, in) => x+"="+toPCF(t) + " in {\n"+toPCF(in, tab+1)+"\n"+"\t"*tab+"}"
  case Fun(arg, body) => arg+"-> {\n"+toPCF(body, tab+1)+"\n"+"\t"*tab+"}"
  case App(f, arg) => toPCF(f)+"("+toPCF(arg, tab +1)+")"
  case Fix(arg, body) => s"fix ${arg} in {\n"+toPCF(body, tab+1)+"\n"+"\t"*tab+"}"
  )