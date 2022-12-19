grammar VarDeclaration;

varDeclaration
: VAR VAR_ID COLON genericType endline
;

endline
: SEMICOLON
|
;

genericType
: TYPE_ID genericParameteresList
;

genericParameteresList
: LANGLE genericParameters RANGLE
|
;

genericParameters
: genericType genericParametersNext
;

genericParametersNext
: COMMA genericParameters
|
;


VAR: 'var';
COLON: ':';
LANGLE: '<';
RANGLE: '>';
COMMA: ',';
SEMICOLON: ';';
TYPE_ID  : '[A-Z][A-Za-z_0-9]*' ;
VAR_ID : '[a-z][A-Za-z_0-9]*' ;
WS : '[ \t\r\n]+' -> skip ;