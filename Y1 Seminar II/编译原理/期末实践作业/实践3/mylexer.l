%{
/****************************************************************************
mylexer.l
ParserWizard generated Lex file.

Date: 2020Äê6ÔÂ4ÈÕ
****************************************************************************/

#include "myparser.h"
#include<iostream>
using namespace std;
%}

/////////////////////////////////////////////////////////////////////////////
// declarations section

// lexical analyser name
%name mylexer

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

// place any declarations here
delim [ \t]
ws    {delim}+
letter [a-zA-Z]
digit [0-9]
id    {letter}({letter}|{digit})*
/* can support 12.34 */
number {digit}+(\.{digit}+)?
%%

/////////////////////////////////////////////////////////////////////////////
// rules section

%{
	// extract yylval for use later on in actions
	YYSTYPE YYFAR& yylval = *(YYSTYPE YYFAR*)yyparserptr->yylvalptr;
%}

// place your Lex rules here
{ws} {/*do nothing*/}

"+" {return PLUS;}
"-" {return MINUS;}
"*" {return MULTI;}
"(" {return LP;}
")" {return RP;}
"=" {return EQUAL;}
"\n" {return EOL;}
"/" {return DIVIDE;}
{id} {return ID;}
{number}    { yylval = atof(yytext);return NUMBER;}
%%

/////////////////////////////////////////////////////////////////////////////
// programs section

