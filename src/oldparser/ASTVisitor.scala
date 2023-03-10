package oldparser

import ast.Term.*
import ast.{AST, Op, Term}
import parser.PCFParser

import java.util
import scala.jdk.CollectionConverters.*

class ASTVisitor[AST] extends PCFBaseVisitor[AST] :

  override def visitFun(ctx: oldparser.PCFParser.FunContext): AST =
    val arg = ctx.VAR.getText
    val t = visit(ctx.term).asInstanceOf[Term]
    Term.Fun(arg, t).asInstanceOf[AST]

  override def visitFix(ctx: oldparser.PCFParser.FixContext): AST =
    val arg = ctx.VAR.getText
    val t = visit(ctx.term).asInstanceOf[Term]
    Term.Fix(arg, t).asInstanceOf[AST]

  override def visitApp(ctx: oldparser.PCFParser.AppContext): AST =
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    
    Term.App(term1, term2).asInstanceOf[AST]

  override def visitLit(ctx: oldparser.PCFParser.LitContext): AST =
    Lit(ctx.getText.toInt).asInstanceOf[AST]

  override def visitLet(ctx: oldparser.PCFParser.LetContext): AST =
    val variable = ctx.VAR.getText
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    Term.Let(variable, term1, term2).asInstanceOf[AST]

  override def visitVar(ctx: oldparser.PCFParser.VarContext): AST =
    VAR(ctx.getText).asInstanceOf[AST]

  override def visitIfZ(ctx: oldparser.PCFParser.IfZContext): AST =
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2, term3) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    Term.IfZ(term1, term2, term3).asInstanceOf[AST]

  override def visitBOp(ctx: oldparser.PCFParser.BOpContext): AST =
    val op = Op.parse(ctx.OP.getText)
    // ctx.term is a Java list, it is translated in a Scala list
    // (initially, to an instance of Buffer, using a collection
    // converter, as Java lists are mutable)
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    BOp(op, term1, term2).asInstanceOf[AST]


