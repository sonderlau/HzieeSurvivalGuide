#############################################################################
#                     U N R E G I S T E R E D   C O P Y
# 
# You are on day 7 of your 30 day trial period.
# 
# This file was produced by an UNREGISTERED COPY of Parser Generator. It is
# for evaluation purposes only. If you continue to use Parser Generator 30
# days after installation then you are required to purchase a license. For
# more information see the online help or go to the Bumble-Bee Software
# homepage at:
# 
# http://www.bumblebeesoftware.com
# 
# This notice must remain present in the file. It cannot be removed.
#############################################################################

#############################################################################
# myparser.v
# YACC verbose file generated from myparser.y.
# 
# Date: 06/04/20
# Time: 20:55:49
# 
# AYACC Version: 2.07
#############################################################################


##############################################################################
# Rules
##############################################################################

    0  $accept : lines $end

    1  lines : ID EQUAL expr EOL
    2        | lines EOL
    3        | lines COMMENT
    4        |

    5  expr : expr PLUS expr
    6       | expr MINUS expr
    7       | expr MULTI expr
    8       | expr DIVIDE expr
    9       | LP expr RP
   10       | '-' expr
   11       | NUMBER
   12       | ID


##############################################################################
# States
##############################################################################

state 0
	$accept : . lines $end
	lines : .  (4)

	ID  shift 1
	.  reduce 4

	lines  goto 2


state 1
	lines : ID . EQUAL expr EOL

	EQUAL  shift 3


state 2
	$accept : lines . $end  (0)
	lines : lines . EOL
	lines : lines . COMMENT

	$end  accept
	EOL  shift 4
	COMMENT  shift 5


state 3
	lines : ID EQUAL . expr EOL

	'-'  shift 6
	NUMBER  shift 7
	ID  shift 8
	LP  shift 9

	expr  goto 10


state 4
	lines : lines EOL .  (2)

	.  reduce 2


state 5
	lines : lines COMMENT .  (3)

	.  reduce 3


state 6
	expr : '-' . expr

	'-'  shift 6
	NUMBER  shift 7
	ID  shift 8
	LP  shift 9

	expr  goto 11


state 7
	expr : NUMBER .  (11)

	.  reduce 11


state 8
	expr : ID .  (12)

	.  reduce 12


state 9
	expr : LP . expr RP

	'-'  shift 6
	NUMBER  shift 7
	ID  shift 8
	LP  shift 9

	expr  goto 12


state 10
	lines : ID EQUAL expr . EOL
	expr : expr . PLUS expr
	expr : expr . MINUS expr
	expr : expr . MULTI expr
	expr : expr . DIVIDE expr

	PLUS  shift 13
	MINUS  shift 14
	DIVIDE  shift 15
	MULTI  shift 16
	EOL  shift 17


state 11
	expr : expr . PLUS expr
	expr : expr . MINUS expr
	expr : expr . MULTI expr
	expr : expr . DIVIDE expr
	expr : '-' expr .  (10)

	.  reduce 10


state 12
	expr : expr . PLUS expr
	expr : expr . MINUS expr
	expr : expr . MULTI expr
	expr : expr . DIVIDE expr
	expr : LP expr . RP

	PLUS  shift 13
	MINUS  shift 14
	DIVIDE  shift 15
	MULTI  shift 16
	RP  shift 18


state 13
	expr : expr PLUS . expr

	'-'  shift 6
	NUMBER  shift 7
	ID  shift 8
	LP  shift 9

	expr  goto 19


state 14
	expr : expr MINUS . expr

	'-'  shift 6
	NUMBER  shift 7
	ID  shift 8
	LP  shift 9

	expr  goto 20


state 15
	expr : expr DIVIDE . expr

	'-'  shift 6
	NUMBER  shift 7
	ID  shift 8
	LP  shift 9

	expr  goto 21


state 16
	expr : expr MULTI . expr

	'-'  shift 6
	NUMBER  shift 7
	ID  shift 8
	LP  shift 9

	expr  goto 22


state 17
	lines : ID EQUAL expr EOL .  (1)

	.  reduce 1


state 18
	expr : LP expr RP .  (9)

	.  reduce 9


state 19
	expr : expr PLUS expr .  (5)
	expr : expr . PLUS expr
	expr : expr . MINUS expr
	expr : expr . MULTI expr
	expr : expr . DIVIDE expr

	DIVIDE  shift 15
	MULTI  shift 16
	.  reduce 5


state 20
	expr : expr . PLUS expr
	expr : expr MINUS expr .  (6)
	expr : expr . MINUS expr
	expr : expr . MULTI expr
	expr : expr . DIVIDE expr

	DIVIDE  shift 15
	MULTI  shift 16
	.  reduce 6


state 21
	expr : expr . PLUS expr
	expr : expr . MINUS expr
	expr : expr . MULTI expr
	expr : expr DIVIDE expr .  (8)
	expr : expr . DIVIDE expr

	.  reduce 8


state 22
	expr : expr . PLUS expr
	expr : expr . MINUS expr
	expr : expr MULTI expr .  (7)
	expr : expr . MULTI expr
	expr : expr . DIVIDE expr

	.  reduce 7


##############################################################################
# Summary
##############################################################################

15 token(s), 3 nonterminal(s)
13 grammar rule(s), 23 state(s)


##############################################################################
# End of File
##############################################################################
