package annotate

import ast.Term
import ast.Term._
import annotate.ATerm

object Annotate {
  type Env = List[String]
  private def findInEnv(elem: String, e: Env): Int = e match {
    case elem::q => 0
    case _::q => 1 + findInEnv(elem, q)
  }
  def annotate(t: Term, e: Env): ATerm = t match {
    case Lit(n) => ATerm.Lit(n)
    case BOp(op, t1, t2) => ATerm.BOp(op, annotate(t1, e), annotate(t2, e))
    case IfZ(t1, t2, t3) => ATerm.IfZ(annotate(t1, e), annotate(t2, e), annotate(t3, e))
    case Let(x, t, in) =>
      val v1 = annotate(t, e)
      ATerm.Let(x, v1, annotate(in, x::e))
    case VAR(x) =>
      val indice = findInEnv(x, e)
      if indice == e.size then throw Exception("Var does not exist") else ATerm.VAR(x, indice)
    case Fun(arg, body) => ATerm.Fun(arg, annotate(body, arg::e))
    case App(fun, arg) => ATerm.App(annotate(fun, e), annotate(arg, e))
    case Fix(arg, body) => ATerm.Fix(arg, annotate(body, arg::e))
    case _ => throw Exception("Should not happen")
  }
}
