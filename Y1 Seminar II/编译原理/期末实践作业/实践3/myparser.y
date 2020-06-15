%{
/****************************************************************************
myparser.y
ParserWizard generated YACC file.

Date: 2020Äê6ÔÂ4ÈÕ
****************************************************************************/

#include "mylexer.h"
#include<string>
%}

/////////////////////////////////////////////////////////////////////////////
// declarations section

// parser name
%name myparser

// class definition
{
	// place any extra class members here
}

// constructor
{
	// place any extra initialisation code here
}

// destructor
{
	// place any extra cleanup code here
}

// attribute type
%include {
#ifndef YYSTYPE
#define YYSTYPE int
#endif
}



%token NUMBER ID
%token PLUS MINUS DIVIDE MULTI
%token LP RP EOL COMMENT
%token EQUAL

%left PLUS MINUS
%left MULTI DIVIDE
%right UMINUS
// place any declarations here

%%

/////////////////////////////////////////////////////////////////////////////
// rules section

// place your YACC rules here (there must be at least one)

lines	:	ID EQUAL expr EOL	{ printf("\nID=%d\n", $3); }
		|	lines EOL
		|   lines COMMENT
		|
		;

expr	:	expr PLUS expr	{ $$ = $1 + $3; printf("PLUS EXPRESSION:%d\n",$$);}
		|	expr MINUS expr	{ $$ = $1 - $3; printf("MINUS EXPRESSION:%d\n",$$);}
		|	expr MULTI expr	{ $$ = $1 * $3; printf("MULTI EXPRESSION:%d\n",$$);}
		|	expr DIVIDE expr	{ $$ = $1 / $3;printf("DIVIDE EXPRESSION:%d\n",$$);}
		|	LP expr RP	{ $$ = $2; }
		|	'-' expr %prec UMINUS	{ $$ = -$2; }
		|	NUMBER {$$=$1;} //$$=$1 can be ignored
		|   ID 
		; 

%%

/////////////////////////////////////////////////////////////////////////////
// programs section

int main(void)
{
	int n = 1;
	mylexer lexer;
	myparser parser;
	if (parser.yycreate(&lexer)) {
		if (lexer.yycreate(&parser)) {
			n = parser.yyparse();
		}
	}
	return n;
}

