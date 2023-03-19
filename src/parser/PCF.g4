grammar PCF;

// règles syntaxiques

term : LIT                                   # Lit
     | '(' term')'                           # Par
     | term term                             # App
     | term OP1 term                         # BOp
     | term OP2 term                         # BOp
     | VAR                                   # Var
     | 'ifz' term 'then' term 'else' term    # IfZ
     | 'let' VAR '=' term ('and' VAR '=' term)* 'in' term # LetPlus
     | 'let' VAR '=' term 'in' term          # Let
     | 'fun' VAR '->' term                   # Fun
     | 'fix' VAR term                        # Fix
     | 'fixfun' VAR VAR '->' term            # FixFun
     ;


// règles lexicales
OP1  :  '*' | '/' ;
OP2  : '+' | '-' ;
OP   : OP1 | OP2 ;
LIT : '0' | [1-9][0-9]* ;

LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
VAR : [a-zA-Z_]+ [a-zA-Z0-9_]* ;
