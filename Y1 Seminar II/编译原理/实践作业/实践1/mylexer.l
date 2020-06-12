%{
/****************************************************************************
mylexer.l
ParserWizard generated Lex file.

Date: 2020年6月2日
****************************************************************************/

#include "myparser.h"
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

headfile  #include(" "*)[<"](([a-z]|[A-Z]|\.)+)[>"]
numbers ([0-9]+[\.|0-9]*[e|E]?[0-9]+)|0[x|X][0-9|A-F|a-f]+[\.|0-9|a-f|A-F]*
string \"(.)*\"
reserved auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|union|unsigned|void|volatile|while
delimiter  ,|;|\(|\)|\{|\}|\[|\]|\'|\"|\<|\>
identifier [_|a-zA-Z]+[_|a-zA-Z]*[0-9]*
backspace \r\n
operator \>\>=|\<\<=|\+\+|--|==|\>=|\<=|!=|&&|\|\||\<\<|\>\>|\+=|-=|\*=|\/=|\%=|&=|\|=|\^=|\+|-|\*|\/|\%|\>|\<|!|&~|\^|=
%%
/////////////////////////////////////////////////////////////////////////////
// rules section
{headfile} {printf("%s是第%d行的头文件",yytext,yylineno);}
{numbers} {printf("%s是第%d行的数字",yytext,yylineno);}
{string} {printf("%s是第%d行的字符",yytext,yylineno);}
{reserved} {printf("%s是第%d行的保留字",yytext,yylineno);}
{delimiter} {printf("%s是第%d行的分隔符",yytext,yylineno);}
{identifier} {printf("%s是第%d行的标识符",yytext,yylineno);}
{backspace} {printf("%s是第%d行的换行符",yytext,yylineno);}
{operator} {printf("%s是第%d行的操作符",yytext,yyineno);}
%%

/////////////////////////////////////////////////////////////////////////////
// programs section
int main()
{
//create a lexer, and call the lex function.
//it will read from stdin and parser the tokens.
 YYLEXERNAME lexer;
 if(lexer.yycreate()){
	 lexer.yylex();
 }
}
