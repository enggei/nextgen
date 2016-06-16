grammar Java;

@members {

public void packageName(String name) {}
public void packageEnd() {}
public void importName(String packageName, String name) {}
public void className(String modifier, String name) {}
public void classExtends(String name) {}
public void classDeclarationEnd() {}
public void classEnd() {}
public void interfaceName(String name) {}
public void interfaceExtends(String name) {}
public void interfaceEnd() {}
public void enumName(String name) {}
public void enumImplements(String implement) {}
public void enumConstant(String name) {}
public void enumEnd() {}
public void newBlock() {}
public void endBlock() {}
public void newLocalVariableStatement(String statement) {}
public void newStatement(String statement) {}
public void newTypeDeclaration(String declaration) {}
public void annotationName(String name) {}
public void newMethod(String returnType, String name) {}
public void newConstructor(String name) {}
public void endConstructor(String constructorBody) {}
public void endMethod(String methodBody) {}
public void newParameter(String modifier, String type, String name) {}
public void newField(String modifier, String type, String name, String initalizer) {}
public void packageDeclarationStart() {}
public void fieldDeclarationStart() {}
public void fieldDeclarationEnd() {}

private final java.util.Stack<String> currentModifiers = new java.util.Stack<String>();
private final java.util.Stack<String> creators = new java.util.Stack<String>();

public static TokenStream createLexer(java.io.Reader reader) throws java.io.IOException {
	final ANTLRInputStream input = new ANTLRInputStream(reader);
	final JavaLexer lexer = new JavaLexer(input);
	return new CommonTokenStream(lexer);
}

public static TokenStream createLexerUsingParseCancellationException(java.io.Reader reader) throws java.io.IOException {
        final ANTLRInputStream input = new ANTLRInputStream(reader);
        final JavaLexer lexer = new JavaLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        return new CommonTokenStream(lexer);
    }

public static class ThrowingErrorListener extends BaseErrorListener {

    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException {
        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}

}

// starting point for parsing a java file
compilationUnit
    :   packageDeclaration? importDeclaration* typeDeclaration* { packageEnd(); } EOF
    ;

packageDeclaration
    :  { packageDeclarationStart(); } annotation* 'package' qualifiedName { packageName($qualifiedName.text); } ';'
    ;

importDeclaration
    :   'import' 'static'? qualifiedName importName  { importName($qualifiedName.text, $importName.text); } ';'
    ;
    
importName
    	:	('.' '*')?
    	;
    
typeDeclaration
    :   classOrInterfaceModifier* classDeclaration { currentModifiers.pop(); }
    |   classOrInterfaceModifier* enumDeclaration { currentModifiers.pop(); }
    |   classOrInterfaceModifier* interfaceDeclaration { currentModifiers.pop(); }
    |   classOrInterfaceModifier* annotationTypeDeclaration { currentModifiers.pop(); }
    |   ';'
    ;
    
modifier
    :   classOrInterfaceModifier
    |   (   'native'
        |   'synchronized'
        |   'transient'
        |   'volatile'
        )
    ;

classOrInterfaceModifier
    :   annotation       // class or interface
    |   (   'public'     // class or interface
        |   'protected'  // class or interface
        |   'private'    // class or interface
        |   'static'     // class or interface
        |   'abstract'   // class or interface
        |   'final'      // class only -- does not apply to interfaces
        |   'strictfp'   // class or interface
        ) { currentModifiers.push($classOrInterfaceModifier.text); }
    ;

variableModifier
    :   'final'
    |   annotation
    ;

classDeclaration
    :   'class' Identifier { className(currentModifiers.peek(),  $Identifier.getText()); } typeParameters?
        ('extends' type { classExtends($type.text); })?
        ('implements' typeList)? { classDeclarationEnd(); }
        classBody { classEnd(); }
    ;
    
typeParameters
    :   '<' typeParameter (',' typeParameter)* '>'
    ;

typeParameter
    :   Identifier ('extends' typeBound)?
    ;
        
typeBound
    :   type ('&' type)*
    ;

enumDeclaration
    :   ENUM Identifier { enumName($Identifier.getText()); } ('implements' typeList { enumImplements($typeList.text); })?
        '{' enumConstants? ','? enumBodyDeclarations? '}'{ enumEnd(); }
    ;

enumConstants
    :   enumConstant  (',' enumConstant )*
    ;
    
enumConstant
    :   annotation* Identifier { enumConstant($Identifier.getText()); } arguments? classBody?
    ;
    
enumBodyDeclarations
    :   ';' (classBodyDeclaration)*
    ;
    
interfaceDeclaration
    :   'interface' Identifier { interfaceName($Identifier.getText()); } typeParameters? ('extends' typeList { interfaceExtends($typeList.text); })? interfaceBody { interfaceEnd(); }
    ;
    
typeList
    :   type (',' type)*
    ;
    
classBody
    :   '{' classBodyDeclaration* '}'
    ;
    
interfaceBody
    :   '{' interfaceBodyDeclaration* '}'
    ;

classBodyDeclaration
    :   ';'
    |   'static'? block
    |   modifier* { currentModifiers.push($modifier.text); } memberDeclaration { currentModifiers.pop(); }
    ;
    
memberDeclaration
    :   methodDeclaration
    |   genericMethodDeclaration
    |   { fieldDeclarationStart(); } fieldDeclaration { fieldDeclarationEnd(); }
    |   constructorDeclaration
    |   genericConstructorDeclaration
    |   interfaceDeclaration
    |   annotationTypeDeclaration
    |   classDeclaration
    |   enumDeclaration
    ;
    
/* We use rule this even for void methods which cannot have [] after parameters.
   This simplifies grammar and we can consider void to be a type, which
   renders the [] matching as a context-sensitive issue or a semantic check
   for invalid return type after parsing.
 */
methodDeclaration
    :   (type|'void') Identifier { newMethod($type.text==null ? null : $type.text, $Identifier.getText()); } formalParameters ('[' ']')*
        ('throws' qualifiedNameList)?
        (   methodBody
        |   ';'
        ) { endMethod($methodBody.text); }
    ;

genericMethodDeclaration
    :   typeParameters methodDeclaration
    ;

constructorDeclaration
    :   Identifier { newConstructor($Identifier.getText()); } formalParameters ('throws' qualifiedNameList)?
        constructorBody { endConstructor($constructorBody.text); }
    ;

genericConstructorDeclaration
    :   typeParameters constructorDeclaration
    ;

fieldDeclaration
    :   type variableDeclarators {
    String modifier = currentModifiers.peek();
    String name = $variableDeclarators.text.contains("=") ? ($variableDeclarators.text.split("=")[0]) : ($variableDeclarators.text);
    String initializer = creators.isEmpty() ? null : creators.pop();
    newField( modifier, $type.text, name, initializer);  } ';'
    ;

interfaceBodyDeclaration
    :   modifier* interfaceMemberDeclaration
    |   ';'
    ;

interfaceMemberDeclaration
    :   constDeclaration
    |   interfaceMethodDeclaration
    |   genericInterfaceMethodDeclaration
    |   interfaceDeclaration
    |   annotationTypeDeclaration
    |   classDeclaration
    |   enumDeclaration
    ;

constDeclaration
    :   type constantDeclarator (',' constantDeclarator)* ';'
    ;

constantDeclarator
    :   Identifier ('[' ']')* '=' variableInitializer
    ;
    
// see matching of [] comment in methodDeclaratorRest
interfaceMethodDeclaration
    :   (type|'void') Identifier { newMethod($type.text==null ? null : $type.text, $Identifier.getText()); } formalParameters ('[' ']')* 
        ('throws' qualifiedNameList)?
        ';' { endMethod(null); }
    ;

genericInterfaceMethodDeclaration
    :   typeParameters interfaceMethodDeclaration
    ;

variableDeclarators
    :   variableDeclarator (',' variableDeclarator)*
    ;

variableDeclarator
    :   variableDeclaratorId ('=' variableInitializer)?
    ;    
    
variableDeclaratorId
    :   Identifier ('[' ']')*
    ;

variableInitializer
    :   arrayInitializer
    |   expression
    ;
        
arrayInitializer
    :   '{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
    ;

packageOrTypeName
    :   qualifiedName
    ;

enumConstantName
    :   Identifier
    ;

typeName
    :   qualifiedName
    ;

type
	:	classOrInterfaceType ('[' ']')*
	|	primitiveType ('[' ']')*
	;

classOrInterfaceType
	:	Identifier typeArguments? ('.' Identifier typeArguments? )*
	;

primitiveType
    :   'boolean'
    |   'char'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    ;

typeArguments
    :   '<' typeArgument (',' typeArgument)* '>'
    ;
    
typeArgument
    :   type
    |   '?' (('extends' | 'super') type)?
    ;
    
qualifiedNameList
    :   qualifiedName (',' qualifiedName)*
    ;

formalParameters
    :   '(' formalParameterList? ')'
    ;
    
formalParameterList
    :   formalParameter (',' formalParameter)* (',' lastFormalParameter)?
    |   lastFormalParameter
    ;

formalParameter
    :   variableModifier* type variableDeclaratorId { newParameter($variableModifier.text, $type.text, $variableDeclaratorId.text); }
    ;

lastFormalParameter
    :   variableModifier* type '...' variableDeclaratorId
    ;

methodBody
    :  { newBlock(); } block { endBlock(); }
    ;

constructorBody
    :   block
    ;

qualifiedName
    :   Identifier ('.' Identifier)*
    ;
    
literal 
    :   IntegerLiteral
    |   FloatingPointLiteral
    |   CharacterLiteral
    |   StringLiteral
    |   BooleanLiteral
    |   'null'
    ;

// ANNOTATIONS

annotation
    :   '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
    ;
    
annotationName : qualifiedName { annotationName($qualifiedName.text); };

elementValuePairs
    :   elementValuePair (',' elementValuePair)*
    ;

elementValuePair
    :   Identifier '=' elementValue
    ;
    
elementValue
    :   expression
    |   annotation
    |   elementValueArrayInitializer
    ;
    
elementValueArrayInitializer
    :   '{' (elementValue (',' elementValue)*)? (',')? '}'
    ;
    
annotationTypeDeclaration
    :   '@' 'interface' Identifier { annotationName($Identifier.getText()); } annotationTypeBody
    ;
    
annotationTypeBody
    :   '{' (annotationTypeElementDeclaration)* '}'
    ;
    
annotationTypeElementDeclaration
    :   modifier* annotationTypeElementRest
	|	';' // this is not allowed by the grammar, but apparently allowed by the actual compiler
    ;
    
annotationTypeElementRest
    :   type annotationMethodOrConstantRest ';'
    |   classDeclaration ';'?
    |   interfaceDeclaration ';'?
    |   enumDeclaration ';'?
    |   annotationTypeDeclaration ';'?
    ;
    
annotationMethodOrConstantRest
    :   annotationMethodRest
    |   annotationConstantRest
    ;
    
annotationMethodRest
    :   Identifier '(' ')' defaultValue?
    ;
    
annotationConstantRest
    :   variableDeclarators
    ;
    
defaultValue
    :   'default' elementValue
    ;

// STATEMENTS / BLOCKS

block
    :   '{' blockStatement* '}'
    ;
    
blockStatement
    :   localVariableDeclarationStatement { newLocalVariableStatement($localVariableDeclarationStatement.text); }
    |   statement { newStatement($statement.text); }
    |   typeDeclaration { newTypeDeclaration($typeDeclaration.text); }
    ;
    
localVariableDeclarationStatement
    :    localVariableDeclaration ';'
    ;

localVariableDeclaration
    :   variableModifier* type variableDeclarators
    ;
    
statement
    : block
    |   ASSERT expression (':' expression)? ';'
    |   'if' parExpression statement ('else' statement)?
    |   'for' '(' forControl ')' statement
    |   'while' parExpression statement
    |   'do' statement 'while' parExpression ';'
    |   'try' block (catches finallyBlock? | finallyBlock)
	|	'try' resourceSpecification block catches? finallyBlock?
    |   'switch' parExpression '{' switchBlockStatementGroup* switchLabel* '}'
    |   'synchronized' parExpression block
    |   'return' expression? ';'
    |   'throw' expression ';'
    |   'break' Identifier? ';'
    |   'continue' Identifier? ';'
    |   ';' 
    |   statementExpression ';'
    |   Identifier ':' statement
    ;

catches
    :   catchClause+
    ;

catchClause
    :   'catch' '(' variableModifier* catchType Identifier ')' block
    ;

catchType
	:	qualifiedName ('|' qualifiedName)*
	;

finallyBlock
	:	'finally' block
	;

resourceSpecification
	:	'(' resources ';'? ')'
	;

resources
	:	resource (';' resource)*
	;

resource
	:	variableModifier* classOrInterfaceType variableDeclaratorId '=' expression
	;

/** Matches cases then statements, both of which are mandatory.
 *  To handle empty cases at the end, we add switchLabel* to statement.
 */
switchBlockStatementGroup
    :   switchLabel+ blockStatement+
    ;
    
switchLabel
    :   'case' constantExpression ':'
    |   'case' enumConstantName ':'
    |   'default' ':'
    ;
    
forControl
    :   enhancedForControl
    |   forInit? ';' expression? ';' forUpdate?
    ;

forInit
    :   localVariableDeclaration
    |   expressionList
    ;
    
enhancedForControl
    :   variableModifier* type Identifier ':' expression
    ;

forUpdate
    :   expressionList
    ;

// EXPRESSIONS

parExpression
    :   '(' expression ')'
    ;
    
expressionList
    :   expression (',' expression)*
    ;

statementExpression
    :   expression
    ;
    
constantExpression
    :   expression
    ;
    
expression
	:   primary
    |   expression '.' Identifier
    |   expression '.' 'this'
    |   expression '.' 'new' nonWildcardTypeArguments? innerCreator
    |   expression '.' 'super' superSuffix
    |	expression '.' explicitGenericInvocation
    |   expression '[' expression ']'
    |   expression '(' expressionList? ')'
    |   'new' creator { creators.push("new " + $creator.text); }
    |   '(' type ')' expression
    |   expression ('++' | '--')
    |   ('+'|'-'|'++'|'--') expression
    |   ('~'|'!') expression
    |   expression ('*'|'/'|'%') expression
    |   expression ('+'|'-') expression
    |   expression ('<' '<' | '>' '>' '>' | '>' '>') expression
    |   expression ('<=' | '>=' | '>' | '<') expression
	|   expression 'instanceof' type
	|   expression ('==' | '!=') expression
	|   expression '&' expression
	|   expression '^' expression
	|   expression '|' expression
	|   expression '&&' expression
	|   expression '||' expression
	|   expression '?' expression ':' expression
	|   expression
        (	'='<assoc=right>
        |	'+='<assoc=right>
        |	'-='<assoc=right>
        |	'*='<assoc=right>
        |	'/='<assoc=right>
        |	'&='<assoc=right>
        |	'|='<assoc=right>
        |	'^='<assoc=right>
        |	'>>='<assoc=right>
        |	'>>>='<assoc=right>
        |	'<<='<assoc=right>
        |	'%='<assoc=right>
        )
        expression
    ;

primary
	:	'(' expression ')'
    |   'this'
    |   'super'
    |   literal
    |   Identifier
    |   type '.' 'class'
    |   'void' '.' 'class'
	|	nonWildcardTypeArguments (explicitGenericInvocationSuffix | 'this' arguments)
    ;

creator
    :   nonWildcardTypeArguments createdName classCreatorRest
    |   createdName (arrayCreatorRest | classCreatorRest)
    ;

createdName
    :   Identifier typeArgumentsOrDiamond? ('.' Identifier typeArgumentsOrDiamond?)*
    |   primitiveType
    ;
    
innerCreator
    :   Identifier nonWildcardTypeArgumentsOrDiamond? classCreatorRest
    ;

arrayCreatorRest
    :   '['
        (   ']' ('[' ']')* arrayInitializer
        |   expression ']' ('[' expression ']')* ('[' ']')*
        )
    ;

classCreatorRest
    :   arguments classBody?
    ;
    
explicitGenericInvocation
    :	nonWildcardTypeArguments explicitGenericInvocationSuffix
    ;
    
nonWildcardTypeArguments
    :   '<' typeList '>'
    ;

typeArgumentsOrDiamond
	:	'<' '>'
	|	typeArguments
	;

nonWildcardTypeArgumentsOrDiamond
	:	'<' '>'
	|	nonWildcardTypeArguments
	;

superSuffix
    :   arguments
    |   '.' Identifier arguments?
    ;

explicitGenericInvocationSuffix
	:	'super' superSuffix
	|	Identifier arguments
	;

arguments
    :   '(' expressionList? ')'
    ;

// LEXER

// �3.9 Keywords

ABSTRACT : 'abstract';
ASSERT : 'assert';
BOOLEAN : 'boolean';
BREAK : 'break';
BYTE : 'byte';
CASE : 'case';
CATCH : 'catch';
CHAR : 'char';
CLASS : 'class';
CONST : 'const';
CONTINUE : 'continue';
DEFAULT : 'default';
DO : 'do';
DOUBLE : 'double';
ELSE : 'else';
ENUM : 'enum';
EXTENDS : 'extends';
FINAL : 'final';
FINALLY : 'finally';
FLOAT : 'float';
FOR : 'for';
IF : 'if';
GOTO : 'goto';
IMPLEMENTS : 'implements';
IMPORT : 'import';
INSTANCEOF : 'instanceof';
INT : 'int';
INTERFACE : 'interface';
LONG : 'long';
NATIVE : 'native';
NEW : 'new';
PACKAGE : 'package';
PRIVATE : 'private';
PROTECTED : 'protected';
PUBLIC : 'public';
RETURN : 'return';
SHORT : 'short';
STATIC : 'static';
STRICTFP : 'strictfp';
SUPER : 'super';
SWITCH : 'switch';
SYNCHRONIZED : 'synchronized';
THIS : 'this';
THROW : 'throw';
THROWS : 'throws';
TRANSIENT : 'transient';
TRY : 'try';
VOID : 'void';
VOLATILE : 'volatile';
WHILE : 'while';

// �3.10.1 Integer Literals

IntegerLiteral
	:	DecimalIntegerLiteral
	|	HexIntegerLiteral
	|	OctalIntegerLiteral
	|	BinaryIntegerLiteral
	;

fragment
DecimalIntegerLiteral
	:	DecimalNumeral IntegerTypeSuffix?
	;

fragment
HexIntegerLiteral
	:	HexNumeral IntegerTypeSuffix?
	;

fragment
OctalIntegerLiteral
	:	OctalNumeral IntegerTypeSuffix?
	;

fragment
BinaryIntegerLiteral
	:	BinaryNumeral IntegerTypeSuffix?
	;

fragment
IntegerTypeSuffix
	:	[lL]
	;

fragment
DecimalNumeral
	:	'0'
	|	NonZeroDigit (Digits? | Underscores Digits)
	;

fragment
Digits
	:	Digit (DigitsAndUnderscores? Digit)?
	;

fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

fragment
NonZeroDigit
	:	[1-9]
	;

fragment
DigitsAndUnderscores
	:	DigitOrUnderscore+
	;

fragment
DigitOrUnderscore
	:	Digit
	|	'_'
	;

fragment
Underscores
	:	'_'+
	;

fragment
HexNumeral
	:	'0' [xX] HexDigits
	;

fragment
HexDigits
	:	HexDigit (HexDigitsAndUnderscores? HexDigit)?
	;

fragment
HexDigit
	:	[0-9a-fA-F]
	;

fragment
HexDigitsAndUnderscores
	:	HexDigitOrUnderscore+
	;

fragment
HexDigitOrUnderscore
	:	HexDigit
	|	'_'
	;

fragment
OctalNumeral
	:	'0' Underscores? OctalDigits
	;

fragment
OctalDigits
	:	OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
	;

fragment
OctalDigit
	:	[0-7]
	;

fragment
OctalDigitsAndUnderscores
	:	OctalDigitOrUnderscore+
	;

fragment
OctalDigitOrUnderscore
	:	OctalDigit
	|	'_'
	;

fragment
BinaryNumeral
	:	'0' [bB] BinaryDigits
	;

fragment
BinaryDigits
	:	BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
	;

fragment
BinaryDigit
	:	[01]
	;

fragment
BinaryDigitsAndUnderscores
	:	BinaryDigitOrUnderscore+
	;

fragment
BinaryDigitOrUnderscore
	:	BinaryDigit
	|	'_'
	;

// �3.10.2 Floating-Point Literals

FloatingPointLiteral
	:	DecimalFloatingPointLiteral
	|	HexadecimalFloatingPointLiteral
	;

fragment
DecimalFloatingPointLiteral
	:	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
	|	'.' Digits ExponentPart? FloatTypeSuffix?
	|	Digits ExponentPart FloatTypeSuffix?
	|	Digits FloatTypeSuffix
	;

fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;

fragment
ExponentIndicator
	:	[eE]
	;

fragment
SignedInteger
	:	Sign? Digits
	;

fragment
Sign
	:	[+-]
	;

fragment
FloatTypeSuffix
	:	[fFdD]
	;

fragment
HexadecimalFloatingPointLiteral
	:	HexSignificand BinaryExponent FloatTypeSuffix?
	;

fragment
HexSignificand
	:	HexNumeral '.'?
	|	'0' [xX] HexDigits? '.' HexDigits
	;

fragment
BinaryExponent
	:	BinaryExponentIndicator SignedInteger
	;

fragment
BinaryExponentIndicator
	:	[pP]
	;

// �3.10.3 Boolean Literals

BooleanLiteral
	:	'true'
	|	'false'
	;

// �3.10.4 Character Literals

CharacterLiteral
	:	'\'' SingleCharacter '\''
	|	'\'' EscapeSequence '\''
	;

fragment
SingleCharacter
	:	~['\\]
	;

// �3.10.5 String Literals

StringLiteral
	:	'"' StringCharacters? '"'
	;

fragment
StringCharacters
	:	StringCharacter+
	;

fragment
StringCharacter
	:	~["\\]
	|	EscapeSequence
	;

// �3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
	:	'\\' [btnfr"'\\]
	|	OctalEscape
    |   UnicodeEscape
	;

fragment
OctalEscape
	:	'\\' OctalDigit
	|	'\\' OctalDigit OctalDigit
	|	'\\' ZeroToThree OctalDigit OctalDigit
	;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
ZeroToThree
	:	[0-3]
	;

// �3.10.7 The Null Literal

NullLiteral
	:	'null'
	;

// �3.11 Separators

LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';
SEMI : ';';
COMMA : ',';
DOT : '.';

// �3.12 Operators

ASSIGN : '=';
GT : '>';
LT : '<';
BANG : '!';
TILDE : '~';
QUESTION : '?';
COLON : ':';
EQUAL : '==';
LE : '<=';
GE : '>=';
NOTEQUAL : '!=';
AND : '&&';
OR : '||';
INC : '++';
DEC : '--';
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
BITAND : '&';
BITOR : '|';
CARET : '^';
MOD : '%';

ADD_ASSIGN : '+=';
SUB_ASSIGN : '-=';
MUL_ASSIGN : '*=';
DIV_ASSIGN : '/=';
AND_ASSIGN : '&=';
OR_ASSIGN : '|=';
XOR_ASSIGN : '^=';
MOD_ASSIGN : '%=';
LSHIFT_ASSIGN : '<<=';
RSHIFT_ASSIGN : '>>=';
URSHIFT_ASSIGN : '>>>=';

// �3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
	:	JavaLetter JavaLetterOrDigit*
	;

fragment
JavaLetter
	:	[a-zA-Z$_] // these are the "java letters" below 0xFF
	|	// covers all characters above 0xFF which are not a surrogate
		~[\u0000-\u00FF\uD800-\uDBFF]
		{Character.isJavaIdentifierStart(_input.LA(-1))}?
	|	// covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
		[\uD800-\uDBFF] [\uDC00-\uDFFF]
		{Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

fragment
JavaLetterOrDigit
	:	[a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
	|	// covers all characters above 0xFF which are not a surrogate
		~[\u0000-\u00FF\uD800-\uDBFF]
		{Character.isJavaIdentifierPart(_input.LA(-1))}?
	|	// covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
		[\uD800-\uDBFF] [\uDC00-\uDFFF]
		{Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

//
// Additional symbols not defined in the lexical specification
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;