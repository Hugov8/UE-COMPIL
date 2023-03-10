grammar PCF;

// règles syntaxiques

term : LIT                                   # Lit
     | '(' OP term term ')'                  # BOp
     | VAR                                   # Var
     | '(' 'ifz' term term term ')'          # IfZ
     | '(' 'let' VAR term term ')'           # Let
     | '(''fun' VAR term ')'                 # Fun
     | '(' term term ')'                     # App
     | '(' 'fix' VAR term ')'                # Fix
     //| '(' 'fun' ('('  VAR (',' VAR)*   ')')? term ')'        # LET_FUN
     ;


// règles lexicales
OP  : '+' | '-' | '*' | '/' ;
LIT : '0' | [1-9][0-9]* ;

LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
VAR : [a-zA-Z_]+ [a-zA-Z0-9_]* ;
