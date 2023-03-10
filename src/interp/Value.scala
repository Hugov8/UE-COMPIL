package interp

import ast.Term
import Interp.Env

case class IceCube(term: Term)
enum Value {
    case IntValue(i: Int)
    case Closure(x: String, t: Term, e: Env)
}