package ast

import ast.Op
enum ATerm {
  case Lit(n: Int) //--> ok
  case BOp(op: Op, t1: ATerm, t2: ATerm) //-->ok
  case IfZ(t1: ATerm, t2: ATerm, t3: ATerm) //--> voir la forme du result ?
  case VAR(x: String, index: Int) // ok
  // case LetPlus(letters: List[(String, ATerm)], expression: ATerm) //Should never happen
  case Let(x: String, t: ATerm, in: ATerm) // ok

  case Fun(arg: String, body: ATerm) // ok
  case Fix(arg: String, body: ATerm)
  case App(f: ATerm, arg: ATerm) //--> ok
}