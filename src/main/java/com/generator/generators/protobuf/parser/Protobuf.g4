grammar Protobuf;

file
	:	packageDecl? option* imports*  message+
	;

packageDecl :	'package' packageName ';'
	;

packageName 
	:	ID ('.' ID)*
	;

option 	:	'option' propertyName '=' ID ';'
	;

imports	:	'import' '"' ID '"' ';'
	;

message	
	:	SL_COMMENT? 'message' ID '{' SL_COMMENT? messageContent+ '}'
	|	SL_COMMENT? 'enum' ID '{' SL_COMMENT? enumName+ '}'
	|	SL_COMMENT? 'extend' ID '{' SL_COMMENT? messageContent+ '}'
	;

enumName	
	:	ID '=' INT ';' SL_COMMENT?
	;

messageContent
	:	property
	|	extensions
	|	message
	;

property 
	:	FIELDRULE propertyType ID '=' INT (defaultValue|packedValue)? ';' SL_COMMENT?
	;

defaultValue
	:	 '[' 'default' '=' (ID|INT|'-'|'"')+ ']'
	;
	
packedValue
	:	 '[' 'packed' '=' ('true'|'false') ']'
	;

extensions
	:	'extensions' INT 'to' extensionMax ';'
	;

propertyName 
	:	ID
	;

propertyType 
	:	ID INT?
	;

extensionMax
	:	INT
	|	'max'
	;

FIELDRULE
	:	'required'
	|	'optional'
	|	'repeated'
	;

INT : [0-9]+ ;

ID 	: [a-zA-Z'_''.'0-9]+ ;

WS  :   [ \t\n\r]+ -> skip ;

SL_COMMENT
	: '//' .*? '\n'
	;