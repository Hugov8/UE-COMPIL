package interp

import ast.Term
import scala.collection.mutable.Map
import Term._
import ast.Op._
import InterpException._

import scala.language.implicitConversions

object Interp :
  type Env = Map[String, Value | IceCube]
  implicit def unionToValue(x: Value | IceCube): Value = x match
    case i: Value => i
    case _ => throw IntValueExpected()
  implicit def intToValue(x: Int): Value = Value.IntValue(x)
  implicit def valueToInt(x: Value): Int = x match
    case Value.IntValue(i) => i
    case Value.Closure(_, _, _) => throw IntValueExpected()
  

  def interp(t: Term, env: Env): Value = t match
    case Lit(value) => value

    case Let(x, t: Term, in: Term) =>
      val v1 = interp(t, env)
      interp(in, env + (x->v1))

    case VAR(x) => if(env.contains(x)) {
      env(x) match
        case v :Value => v
        case i :IceCube => interp(i.term, env)
    } else throw VariableNotDefined(s"\"$x\" is not defined in this scope")

    case IfZ(t1, t2, t3) =>
      val v1 = interp(t1, env)
      v1 match
        case Value.IntValue(0) => interp(t2, env)
        case _ => interp(t3, env)

    case BOp(op, t1, t2) =>
      val v1 = valueToInt(interp(t1, env))
      val v2 = valueToInt(interp(t2, env))
      op match
        case PLUS => v1 + v2
        case MINUS => v1 - v2
        case TIMES => v1 * v2
        case DIVIDE => if(v2 != 0) v1 / v2 else throw DivisionByZero()

    case Fun(arg, body) =>
      Value.Closure(arg, body, env)
    
    case App(f, arg) =>
      val fun = interp(f, env)
      val argValue = interp(arg, env)
      fun match
        case Value.Closure(argClosure, body, envClosure) => interp(body, envClosure + (argClosure->argValue))
        case _ => throw FunctionExpected()

    case Fix(arg, body) =>
      interp(body, env + (arg->IceCube(body)))

    case LetPlus(_,_) => throw ShouldNotHappenException()
    case FixFun(_,_,_) => throw ShouldNotHappenException()
    // case _ => throw NotYetImplemented()

