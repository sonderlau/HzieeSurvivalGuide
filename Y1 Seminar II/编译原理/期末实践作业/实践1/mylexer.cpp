/****************************************************************************
*                     U N R E G I S T E R E D   C O P Y
* 
* You are on day 5 of your 30 day trial period.
* 
* This file was produced by an UNREGISTERED COPY of Parser Generator. It is
* for evaluation purposes only. If you continue to use Parser Generator 30
* days after installation then you are required to purchase a license. For
* more information see the online help or go to the Bumble-Bee Software
* homepage at:
* 
* http://www.bumblebeesoftware.com
* 
* This notice must remain present in the file. It cannot be removed.
****************************************************************************/

/****************************************************************************
* mylexer.cpp
* C++ source file generated from mylexer.l.
* 
* Date: 06/02/20
* Time: 20:44:28
* 
* ALex Version: 2.07
****************************************************************************/

#include <yyclex.h>

// namespaces
#ifdef YYSTDCPPLIB
using namespace std;
#endif
#ifdef YYNAMESPACE
using namespace yl;
#endif

#line 1 ".\\mylexer.l"

/****************************************************************************
mylexer.l
ParserWizard generated Lex file.

Date: 2020年6月2日
****************************************************************************/

#include "mylexer.h"

#line 49 "mylexer.cpp"
// repeated because of possible precompiled header
#include <yyclex.h>

// namespaces
#ifdef YYSTDCPPLIB
using namespace std;
#endif
#ifdef YYNAMESPACE
using namespace yl;
#endif

#include ".\mylexer.h"

/////////////////////////////////////////////////////////////////////////////
// constructor

YYLEXERNAME::YYLEXERNAME()
{
	yytables();
#line 24 ".\\mylexer.l"

	// place any extra initialisation code here

#line 73 "mylexer.cpp"
}

/////////////////////////////////////////////////////////////////////////////
// destructor

YYLEXERNAME::~YYLEXERNAME()
{
#line 29 ".\\mylexer.l"

	// place any extra cleanup code here

#line 85 "mylexer.cpp"
}

#ifndef YYTEXT_SIZE
#define YYTEXT_SIZE 100
#endif
#ifndef YYUNPUT_SIZE
#define YYUNPUT_SIZE YYTEXT_SIZE
#endif
#ifndef YYTEXT_MAX
#define YYTEXT_MAX 0
#endif
#ifndef YYUNPUT_MAX
#define YYUNPUT_MAX YYTEXT_MAX
#endif

/****************************************************************************
* N O T E
* 
* If the compiler generates a YYLEXERNAME error then you have not declared
* the name of the lexical analyser. The easiest way to do this is to use a
* name declaration. This is placed in the declarations section of your Lex
* source file and is introduced with the %name keyword. For instance, the
* following name declaration declares the lexer mylexer:
* 
* %name mylexer
* 
* For more information see help.
****************************************************************************/

// backwards compatability with lex
#ifdef input
int YYLEXERNAME::yyinput()
{
	return input();
}
#else
#define input yyinput
#endif

#ifdef output
void YYLEXERNAME::yyoutput(int ch)
{
	output(ch);
}
#else
#define output yyoutput
#endif

#ifdef unput
void YYLEXERNAME::yyunput(int ch)
{
	unput(ch);
}
#else
#define unput yyunput
#endif

#ifndef YYNBORLANDWARN
#ifdef __BORLANDC__
#pragma warn -rch		// <warning: unreachable code> off
#endif
#endif

int YYLEXERNAME::yyaction(int action)
{
	yyreturnflg = yytrue;
	switch (action) {
	case 1:
		{
#line 46 ".\\mylexer.l"
printf("%s是第%d行的头文件",yytext, yylineno);
#line 157 "mylexer.cpp"
		}
		break;
	case 2:
		{
#line 47 ".\\mylexer.l"
printf("%s是第%d行的数字",yytext, yylineno);
#line 164 "mylexer.cpp"
		}
		break;
	case 3:
		{
#line 48 ".\\mylexer.l"
printf("%s是第%d行的字符",yytext, yylineno);
#line 171 "mylexer.cpp"
		}
		break;
	case 4:
		{
#line 49 ".\\mylexer.l"
printf("%s是第%d行的保留字",yytext,yylineno);
#line 178 "mylexer.cpp"
		}
		break;
	case 5:
		{
#line 50 ".\\mylexer.l"
printf("%s是第%d行的分隔符",yytext, yylineno);
#line 185 "mylexer.cpp"
		}
		break;
	case 6:
		{
#line 51 ".\\mylexer.l"
printf("%s是第%d行的标识符",yytext, yylineno);
#line 192 "mylexer.cpp"
		}
		break;
	case 7:
		{
#line 52 ".\\mylexer.l"
printf("%s是第%d行的换行符",yytext, yylineno);
#line 199 "mylexer.cpp"
		}
		break;
	case 8:
		{
#line 53 ".\\mylexer.l"
printf("%s是第%d行的操作符",yytext, yylineno);
#line 206 "mylexer.cpp"
		}
		break;
	default:
		yyassert(0);
		break;
	}
	yyreturnflg = yyfalse;
	return 0;
}

#ifndef YYNBORLANDWARN
#ifdef __BORLANDC__
#pragma warn .rch		// <warning: unreachable code> to the old state
#endif
#endif

void YYLEXERNAME::yytables()
{
	yystext_size = YYTEXT_SIZE;
	yysunput_size = YYUNPUT_SIZE;
	yytext_max = YYTEXT_MAX;
	yyunput_max = YYUNPUT_MAX;

	static const yymatch_t YYNEARFAR YYBASED_CODE match[] = {
		0
	};
	yymatch = match;

	yytransitionmax = 355;
	static const yytransition_t YYNEARFAR YYBASED_CODE transition[] = {
		{ 0, 0 },
		{ 3, 1 },
		{ 54, 72 },
		{ 95, 72 },
		{ 33, 7 },
		{ 67, 67 },
		{ 0, 121 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 67, 67 },
		{ 63, 29 },
		{ 120, 120 },
		{ 39, 11 },
		{ 121, 120 },
		{ 4, 1 },
		{ 5, 1 },
		{ 6, 1 },
		{ 64, 30 },
		{ 4, 1 },
		{ 7, 1 },
		{ 8, 1 },
		{ 8, 1 },
		{ 8, 1 },
		{ 4, 1 },
		{ 9, 1 },
		{ 8, 1 },
		{ 10, 1 },
		{ 0, 121 },
		{ 4, 1 },
		{ 11, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 12, 1 },
		{ 121, 120 },
		{ 8, 1 },
		{ 13, 1 },
		{ 4, 1 },
		{ 14, 1 },
		{ 39, 11 },
		{ 0, 35 },
		{ 84, 59 },
		{ 79, 56 },
		{ 40, 11 },
		{ 57, 26 },
		{ 58, 26 },
		{ 44, 18 },
		{ 47, 19 },
		{ 33, 31 },
		{ 44, 20 },
		{ 4, 13 },
		{ 49, 20 },
		{ 88, 62 },
		{ 45, 18 },
		{ 65, 36 },
		{ 80, 56 },
		{ 59, 26 },
		{ 48, 19 },
		{ 85, 59 },
		{ 60, 26 },
		{ 46, 18 },
		{ 50, 20 },
		{ 89, 62 },
		{ 90, 63 },
		{ 35, 35 },
		{ 51, 21 },
		{ 91, 63 },
		{ 8, 1 },
		{ 52, 21 },
		{ 8, 1 },
		{ 4, 1 },
		{ 67, 67 },
		{ 4, 14 },
		{ 16, 1 },
		{ 17, 1 },
		{ 18, 1 },
		{ 19, 1 },
		{ 20, 1 },
		{ 21, 1 },
		{ 22, 1 },
		{ 33, 7 },
		{ 23, 1 },
		{ 0, 39 },
		{ 12, 40 },
		{ 24, 1 },
		{ 123, 122 },
		{ 42, 16 },
		{ 69, 42 },
		{ 70, 43 },
		{ 71, 44 },
		{ 25, 1 },
		{ 26, 1 },
		{ 27, 1 },
		{ 28, 1 },
		{ 29, 1 },
		{ 30, 1 },
		{ 52, 45 },
		{ 122, 122 },
		{ 73, 47 },
		{ 8, 1 },
		{ 31, 1 },
		{ 8, 1 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 41, 41 },
		{ 72, 46 },
		{ 123, 122 },
		{ 74, 48 },
		{ 75, 49 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 76, 50 },
		{ 77, 51 },
		{ 53, 52 },
		{ 15, 53 },
		{ 53, 54 },
		{ 78, 55 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 122, 122 },
		{ 68, 68 },
		{ 43, 17 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 68, 68 },
		{ 81, 57 },
		{ 83, 58 },
		{ 36, 6 },
		{ 86, 60 },
		{ 87, 61 },
		{ 32, 3 },
		{ 33, 9 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 12, 37 },
		{ 92, 64 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 37, 37 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 66, 66 },
		{ 93, 65 },
		{ 38, 37 },
		{ 33, 10 },
		{ 42, 22 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 67, 68 },
		{ 54, 23 },
		{ 53, 69 },
		{ 94, 70 },
		{ 53, 71 },
		{ 55, 24 },
		{ 96, 73 },
		{ 92, 74 },
		{ 53, 75 },
		{ 97, 76 },
		{ 54, 77 },
		{ 53, 78 },
		{ 98, 79 },
		{ 97, 80 },
		{ 54, 81 },
		{ 99, 82 },
		{ 100, 83 },
		{ 101, 84 },
		{ 102, 85 },
		{ 103, 86 },
		{ 104, 87 },
		{ 105, 88 },
		{ 68, 68 },
		{ 106, 89 },
		{ 38, 37 },
		{ 53, 90 },
		{ 107, 91 },
		{ 71, 92 },
		{ 108, 93 },
		{ 53, 94 },
		{ 109, 95 },
		{ 110, 96 },
		{ 105, 97 },
		{ 111, 98 },
		{ 90, 99 },
		{ 112, 100 },
		{ 113, 101 },
		{ 54, 102 },
		{ 114, 103 },
		{ 115, 104 },
		{ 53, 105 },
		{ 82, 106 },
		{ 64, 107 },
		{ 116, 108 },
		{ 117, 109 },
		{ 54, 110 },
		{ 118, 111 },
		{ 12, 37 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 53, 112 },
		{ 53, 113 },
		{ 53, 114 },
		{ 112, 115 },
		{ 15, 118 },
		{ 119, 116 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 52, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 15, 118 },
		{ 71, 117 },
		{ 15, 118 },
		{ 56, 25 },
		{ 120, 119 },
		{ 33, 4 },
		{ 61, 27 },
		{ 62, 28 }
	};
	yytransition = transition;

	static const yystate_t YYNEARFAR YYBASED_CODE state[] = {
		{ 0, 0, 0 },
		{ 118, -12, 0 },
		{ 1, 0, 0 },
		{ 0, 193, 0 },
		{ 0, 291, 8 },
		{ 35, 0, 5 },
		{ 0, 95, 0 },
		{ 4, -34, 0 },
		{ 0, 0, 5 },
		{ 4, 161, 8 },
		{ 4, 190, 8 },
		{ 37, -69, 0 },
		{ 37, 0, 0 },
		{ 4, 2, 5 },
		{ 4, 22, 5 },
		{ 53, 0, 6 },
		{ 117, -19, 6 },
		{ 97, 73, 6 },
		{ 114, -39, 6 },
		{ 118, -42, 6 },
		{ 110, -47, 6 },
		{ 110, -31, 6 },
		{ 100, 125, 6 },
		{ 112, 133, 6 },
		{ 100, 136, 6 },
		{ 118, 249, 6 },
		{ 114, -48, 6 },
		{ 53, 232, 6 },
		{ 109, 244, 6 },
		{ 100, -94, 6 },
		{ 114, -80, 6 },
		{ 53, -1, 6 },
		{ 0, 0, 7 },
		{ 0, 0, 8 },
		{ 35, 0, 0 },
		{ -34, 42, 3 },
		{ 0, -44, 0 },
		{ 0, 165, 2 },
		{ 66, 0, 0 },
		{ 67, 48, 0 },
		{ 68, 49, 0 },
		{ 0, 66, 6 },
		{ 111, -17, 6 },
		{ 118, -1, 6 },
		{ 98, -14, 6 },
		{ 91, 11, 6 },
		{ 109, 14, 6 },
		{ 112, 8, 6 },
		{ 117, 9, 4 },
		{ 117, 10, 6 },
		{ 111, 38, 6 },
		{ 100, 44, 6 },
		{ 97, 42, 6 },
		{ 118, 56, 4 },
		{ 111, 42, 6 },
		{ 109, 49, 6 },
		{ 111, -49, 6 },
		{ 100, 87, 6 },
		{ 106, 77, 6 },
		{ 97, -44, 6 },
		{ 101, 96, 6 },
		{ 53, 90, 6 },
		{ 101, -41, 6 },
		{ 110, -30, 6 },
		{ 101, 107, 6 },
		{ 0, 134, 0 },
		{ 0, 175, 2 },
		{ 68, -41, 2 },
		{ 0, 140, 2 },
		{ 100, 133, 6 },
		{ 91, 148, 6 },
		{ 118, 145, 6 },
		{ 111, -113, 6 },
		{ 91, 151, 6 },
		{ 53, 151, 6 },
		{ 53, 141, 6 },
		{ 118, 150, 6 },
		{ 91, 155, 6 },
		{ 106, 150, 6 },
		{ 101, 149, 6 },
		{ 117, 138, 6 },
		{ 97, 142, 6 },
		{ 109, 147, 6 },
		{ 118, 157, 6 },
		{ 111, 143, 6 },
		{ 117, 143, 6 },
		{ 111, 145, 6 },
		{ 118, 161, 6 },
		{ 100, 152, 6 },
		{ 101, 160, 6 },
		{ 104, 167, 6 },
		{ 53, 171, 6 },
		{ 110, 161, 6 },
		{ 0, 162, 0 },
		{ 53, 164, 6 },
		{ 101, 167, 6 },
		{ 117, 156, 6 },
		{ 53, 160, 6 },
		{ 53, 160, 6 },
		{ 118, 175, 6 },
		{ 53, 166, 6 },
		{ 53, 173, 6 },
		{ 113, 180, 6 },
		{ 113, 181, 6 },
		{ 53, 181, 6 },
		{ 109, 172, 6 },
		{ 53, 180, 6 },
		{ 111, 168, 6 },
		{ 0, 168, 0 },
		{ 53, 176, 6 },
		{ 53, 179, 6 },
		{ 53, 172, 6 },
		{ 53, 214, 6 },
		{ 53, 218, 6 },
		{ 53, 214, 6 },
		{ 118, 218, 6 },
		{ 0, 221, 0 },
		{ 53, 231, 6 },
		{ 41, 225, 6 },
		{ 0, 250, 0 },
		{ 0, -14, 0 },
		{ 122, -28, 0 },
		{ 0, 63, 0 },
		{ 0, 0, 1 }
	};
	yystate = state;

	static const yybackup_t YYNEARFAR YYBASED_CODE backup[] = {
		0,
		0,
		0,
		0,
		0,
		0,
		0,
		0,
		0
	};
	yybackup = backup;
}
#line 54 ".\\mylexer.l"


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

