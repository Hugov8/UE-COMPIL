package typer

import scala.collection.mutable.Map
import ast.Term
import typer.InterpException.*
import Term.*

import scala.collection.mutable

object Typer {
  type Env = mutable.Map[String, Type]
  def typer(term: Term, env: Env): Type = term match
    case Lit(_) => INT

    case Let(x, t, in) =>
      val typeT = typer(t, env)
      typer(in, env + (x->typeT))

    case VAR(x) =>
      if env.contains(x) then env(x) else throw UnificationFailed(s"Var ${x} not defined in this scope")

    case IfZ(t1, t2, t3) =>
      val type1 = typer(t1, env)
      val type2 = typer(t2, env)
      val type3 = typer(t3, env)
      if type1 ===INT && type2 === type3 then type2 else throw UnificationFailed("T1 should be INT, T2 and T3 have to be the same type\n" +
        s"T1 is $type1, T2 is $type2 and T3 is $type3")

    case BOp(_, t1, t2) =>
      val type1 = typer(t1, env)
      val type2 = typer(t2, env)
      if type1===INT && type2 === INT then INT else throw UnificationFailed("T1 and T2 should be INT\n"
      +s"T1 is $type1 and T2 is $type2")

    case Fun(arg, body) =>
      val argType = TVar(arg)
      argType --> typer(body, env+(arg->argType))

    case App(fun, arg) =>
      val typeArg = typer(arg, env)
      val typeF = typer(fun, env)
      if !(typeF=== -->(TVar(), TVar())) then throw UnificationFailed(s"The caller is of type $typeF")
      val res = TVar()
      if typeF === typeArg-->res then res else throw UnificationFailed(s"The argument of the function have the wrong type ${typeF.deref.asInstanceOf[-->].a} expected, not $typeArg")

    case Fix(arg, body) =>
      val argType = TVar(arg)
      val res = typer(body, env + (arg->argType))
      if res===argType then res else throw UnificationFailed("Variable and return value should be the same type\n"
      + s"variable is $argType, return value is $res")

    case _ => throw ShouldNotHappenException()
}
//Exemple polymorphisme
// (let f (fun x x) (ifz (f 0) (f (fun x x)) (f (fun x x))))
// f devient un INT->INT après f0 et f fun est du mauvais type