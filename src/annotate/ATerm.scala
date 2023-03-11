package annotate

import ast.Op
enum ATerm {
  case Lit(n: Int)
  case BOp(op: Op, t1: ATerm, t2: ATerm)
  case IfZ(t1: ATerm, t2: ATerm, t3: ATerm)
  case VAR(x: String, index: Int)
  case LetPlus(letters: List[(String, ATerm)], expression: ATerm)
  case Let(x: String, t: ATerm, in: ATerm)
  case Fun(arg: String, body: ATerm)
  case Fix(arg: String, body: ATerm)
  case App(f: ATerm, arg: ATerm)
}