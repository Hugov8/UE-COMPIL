package parser

import ast.*
import ast.Term.{BOp, Fix, IfZ, Let, LetPlus, App, Fun}

def transform(ast: AST): AST = ast match
  case Fix(arg, body) => Fix(arg, transform(body).asInstanceOf[Term])
  case BOp(op, t1, t2) =>
    val tr1 = transform(t1).asInstanceOf[Term]
    val tr2 = transform(t2).asInstanceOf[Term]
    BOp(op, tr1, tr2)
  case IfZ(t1, t2, t3) =>
    val tr1 = transform(t1).asInstanceOf[Term]
    val tr2 = transform(t2).asInstanceOf[Term]
    val tr3 = transform(t3).asInstanceOf[Term]
    IfZ(tr1, tr2, tr3)
  case Let(x, t, in) =>
    val tr = transform(t).asInstanceOf[Term]
    val intr = transform(in).asInstanceOf[Term]
    Let(x, tr, intr)
  case LetPlus(letters, expression) =>
    val expr = transform(expression).asInstanceOf[Term]
    letters.foldRight(expr) {
      (term, acc) =>
        Let(term._1, transform(term._2).asInstanceOf[Term], acc).asInstanceOf[Term]
    }
  case Fun(arg, body) => Fun(arg, transform(body).asInstanceOf[Term])
  case App(f, arg) => App(transform(f).asInstanceOf[Term], transform(arg).asInstanceOf[Term])
  case _ => ast
