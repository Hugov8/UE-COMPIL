package parser
import scala.jdk.CollectionConverters.*
import ast.{AST, Op, Term}
import Term.{App, BOp, Fix, Fun, IfZ, Let, LetPlus, Lit, VAR}
import parser.PCFParser

import java.util

class ASTVisitor[AST] extends PCFBaseVisitor[AST] :

  override def visitFun(ctx: PCFParser.FunContext): AST =
    val arg = ctx.VAR.getText
    val t = visit(ctx.term).asInstanceOf[Term]
    Term.Fun(arg, t).asInstanceOf[AST]

  override def visitFix(ctx: PCFParser.FixContext): AST =
    val arg = ctx.VAR.getText
    val t = visit(ctx.term).asInstanceOf[Term]
    Term.Fix(arg, t).asInstanceOf[AST]

  override def visitApp(ctx: PCFParser.AppContext): AST =
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    
    Term.App(term1, term2).asInstanceOf[AST]

  override def visitLit(ctx: PCFParser.LitContext): AST =
    Lit(ctx.getText.toInt).asInstanceOf[AST]

  override def visitLetPlus(ctx: PCFParser.LetPlusContext): AST =
    //Get all variable
    val vars = for (variable <- ctx.VAR.asScala.toList) yield
      variable.getText

    //Get all terms including the last one
    // len(terms)=len(vars)+1
    val terms = for (term <- ctx.term.asScala.toList) yield
      visit(term).asInstanceOf[Term]

    //Associate var to the expresison
    val letters = for(i <- vars.indices) yield
      (vars(i), terms(i))
    // Final expression
    val expression = terms.last
    LetPlus(letters.toList, expression).asInstanceOf[AST]

  override def visitLet(ctx: PCFParser.LetContext): AST =
    val variable = ctx.VAR.getText
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    Term.Let(variable, term1, term2).asInstanceOf[AST]

  override def visitVar(ctx: PCFParser.VarContext): AST =
    VAR(ctx.getText).asInstanceOf[AST]

  override def visitIfZ(ctx: PCFParser.IfZContext): AST =
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2, term3) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    Term.IfZ(term1, term2, term3).asInstanceOf[AST]

  override def visitPar(ctx: PCFParser.ParContext): AST =
    visit(ctx.term)

  override def visitBOp(ctx: PCFParser.BOpContext): AST =
    //Get the correct operator according to the rule used for priority
    val opText = if ctx.OP1==null then ctx.OP2.getText else ctx.OP1.getText
    val op = Op.parse(opText)
    // ctx.term is a Java list, it is translated in a Scala list
    // (initially, to an instance of Buffer, using a collection
    // converter, as Java lists are mutable)
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    BOp(op, term1, term2).asInstanceOf[AST]


