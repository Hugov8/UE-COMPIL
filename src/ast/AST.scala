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


enum Op :
  case PLUS, MINUS, TIMES, DIVIDE

object Op :
  def parse(s: String): Op = s match
    case "+" => PLUS
    case "-" => MINUS
    case "*" => TIMES
    case "/" => DIVIDE
    case _ => ??? // should never happen


  
