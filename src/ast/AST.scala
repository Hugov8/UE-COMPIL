package ast

trait AST

import ast.Op.{DIVIDE, MINUS, PLUS, TIMES}

enum Term extends AST :
  case Lit(n: Int)
  case BOp(op: Op, t1: Term, t2: Term)
  case IfZ(t1: Term, t2: Term, t3: Term)
  case VAR(x: String)
  case LetPlus(letters: List[(String, Term)], expression: Term)
  case Let(x: String, t: Term, in: Term)
  case Fun(arg: String, body: Term)
  case Fix(arg: String, body: Term)
  case App(f: Term, arg: Term)
  case FixFun(f: String, arg: String, body: Term)

  type Env = List[String]

  private def findInEnv(elem: String, e: Env): Int = e match {
    case q :: _ if q==elem => 0
    case _ :: q => 1 + findInEnv(elem, q)
    case Nil => 0
  }
  def annotate(e: Env): ATerm = this match {
    case Lit(n) => ATerm.Lit(n)
    case BOp(op, t1, t2) => ATerm.BOp(op, t1.annotate(e), t2.annotate(e))
    case IfZ(t1, t2, t3) => ATerm.IfZ(t1.annotate(e), t2.annotate(e), t3.annotate(e))
    case Let(x, t, in) =>
      val v1 = t.annotate(e)
      ATerm.Let(x, v1, in.annotate(x :: e))
    case VAR(x) =>
      //Si deux variable ont le même nom dans des environnements imbriquées ?
      val indice = findInEnv(x, e)
      if indice == e.size then throw Exception("Var does not exist") else ATerm.VAR(x, indice)
    case Fun(arg, body) => ATerm.Fun(arg, body.annotate(arg :: e))
    case App(fun, arg) => ATerm.App(fun.annotate(e), arg.annotate(e))
    case Fix(arg, body) => ATerm.Fix(arg, body.annotate(arg :: e))
    case _ => throw Exception("Should not happen") // LetPlus et FixFun déjà transformé
  }


enum Op :
  case PLUS, MINUS, TIMES, DIVIDE

object Op :
  def parse(s: String): Op = s match
    case "+" => PLUS
    case "-" => MINUS
    case "*" => TIMES
    case "/" => DIVIDE
    case _ => throw Exception("Should not happen") // should never happen


  
