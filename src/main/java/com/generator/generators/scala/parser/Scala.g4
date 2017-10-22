/*
 [The "BSD licence"]
 Copyright (c) 2017 Ernst Sognnes
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
/*
   Derived from https://github.com/scala/scala/blob/2.13.x/spec/13-syntax-summary.md
 */

grammar Scala;

literal
   : '-'? INTEGER_LITERAL
   | '-'? FLOATING_POINT_LITERAL
   | BOOLEAN_LITERAL
   | CHARACTER_LITERAL
   | STRING_LITERAL
   | SYMBOL_LITERAL
   | 'null'
   ;

// QualId            ::=  id {‘.’ id}
qualId
   : ID ('.' ID)*
   ;

// ids               ::=  id {‘,’ id}
ids
   : ID (',' ID)*
   ;

// Path              ::=  StableId
//                     |  [id ‘.’] ‘this’
//path
//   : stableId
//   | (ID '.')? 'this'
//   ;

// StableId          ::=  id
//                     |  Path ‘.’ id
//                     |  [id ‘.’] ‘super’ [ClassQualifier] ‘.’ id
stableId
   : ID
//   | path '.' ID
   | (ID | (ID '.')? 'this') '.' ID
   | (ID '.')? 'super' classQualifier? '.' ID
   ;

// ClassQualifier    ::=  ‘[’ id ‘]’
classQualifier
   : '[' ID ']'
   ;

// Type              ::=  FunctionArgTypes ‘=>’ Type
//                     |  InfixType [ExistentialClause]
type
   : functionArgTypes '=>' type
   | infixType existentialClause?
   ;

// FunctionArgTypes  ::= InfixType
//                     | ‘(’ [ ParamType {‘,’ ParamType } ] ‘)’
functionArgTypes
   : infixType
   | '(' (paramType (',' paramType)*)? ')'
   ;

// ExistentialClause ::=  ‘forSome’ ‘{’ ExistentialDcl {semi ExistentialDcl} ‘}’
existentialClause
   : 'forSome' '{' existentialDcl (SEMI existentialDcl)* '}'
   ;

// ExistentialDcl    ::=  ‘type’ TypeDcl
//                     |  ‘val’ ValDcl
existentialDcl
   : 'type' typeDcl
   | 'val' valDcl
   ;

// InfixType         ::=  CompoundType {id [nl] CompoundType}
infixType
   : compoundType (ID '\n'? compoundType)*
   ;

// CompoundType      ::=  AnnotType {‘with’ AnnotType} [Refinement]
//                   |  Refinement
compoundType
   : annotType ('with' annotType)* refinement?
   | refinement
   ;

// AnnotType         ::=  SimpleType {Annotation}
annotType
   : simpleType annotation*
   ;

// SimpleType        ::=  SimpleType TypeArgs
//                     |  SimpleType ‘#’ id
//                     |  StableId
//                     |  Path ‘.’ ‘type’
//                     |  ‘(’ Types ‘)’
simpleType
   : simpleType typeArgs
   | simpleType '#' ID
   | stableId
//   | path '.' 'type'
   | (stableId | (ID '.')? 'this') '.' 'type'
   | '(' types ')'
   ;

// TypeArgs          ::=  ‘[’ Types ‘]’
typeArgs
   : '[' types ']'
   ;

// Types             ::=  Type {‘,’ Type}
types
   : type (',' type)*
   ;

// Refinement        ::=  [nl] ‘{’ RefineStat {semi RefineStat} ‘}’
refinement
   : '\n'? '{' refineStat (SEMI refineStat)* '}'
   ;

// RefineStat        ::=  Dcl
//                     |  ‘type’ TypeDef
//                     |
refineStat
   : dcl
   | 'type' typeDef
   |
   ;

// TypePat           ::=  Type
typePat
   : type
   ;

// Ascription        ::=  ‘:’ InfixType
//                     |  ‘:’ Annotation {Annotation}
//                     |  ‘:’ ‘_’ ‘*’
ascription
   : ':' infixType
   | ':' annotation+
   | ':' '_' '*'
   ;

// Expr              ::=  (Bindings | [‘implicit’] id | ‘_’) ‘=>’ Expr
//                     |  Expr1
expr
   : (bindings | 'implicit'? ID | '_') '=>' expr
   | expr1
   ;

// Expr1             ::=  ‘if’ ‘(’ Expr ‘)’ {nl} Expr [[semi] ‘else’ Expr]
//                     |  ‘while’ ‘(’ Expr ‘)’ {nl} Expr
//                     |  ‘try’ (‘{’ Block ‘}’ | Expr) [‘catch’ ‘{’ CaseClauses ‘}’] [‘finally’ Expr]
//                     |  ‘do’ Expr [semi] ‘while’ ‘(’ Expr ‘)’
//                     |  ‘for’ (‘(’ Enumerators ‘)’ | ‘{’ Enumerators ‘}’) {nl} [‘yield’] Expr
//                     |  ‘throw’ Expr
//                     |  ‘return’ [Expr]
//                     |  [SimpleExpr ‘.’] id ‘=’ Expr
//                     |  SimpleExpr1 ArgumentExprs ‘=’ Expr
//                     |  PostfixExpr
//                     |  PostfixExpr Ascription
//                     |  PostfixExpr ‘match’ ‘{’ CaseClauses ‘}’
expr1
   : 'if' '(' expr ')' '\n'* expr (SEMI? 'else' expr)?
   | 'while' '(' expr ')' '\n'* expr
   | 'try' ('{' block '}' | expr) ('catch' '{' caseClauses '}')? ('finally' expr)?
   | 'do' expr SEMI? 'while' '(' expr ')'
   | 'for' ('(' enumerators ')' | '{' enumerators '}') '\n'* 'yield'? expr
   | 'throw' expr
   | 'return' expr?
   | (simpleExpr '.')? ID '=' expr
   | simpleExpr1 argumentExprs '=' expr
   | postfixExpr
   | postfixExpr ascription
   | postfixExpr 'match' '{' caseClauses '}'
   ;

// PostfixExpr       ::=  InfixExpr [id [nl]]
postfixExpr
   : infixExpr (ID '\n'?)?
   ;

// InfixExpr         ::=  PrefixExpr
//                     |  InfixExpr id [nl] InfixExpr
infixExpr
   : prefixExpr
   | infixExpr ID '\n'? infixExpr
   ;

// PrefixExpr        ::=  [‘-’ | ‘+’ | ‘~’ | ‘!’] SimpleExpr
prefixExpr
   : ('-' | '+' | '~' | '!')? simpleExpr /*('new' (classTemplate | templateBody) | blockExpr | simpleExpr1 '_'?)*/
   ;

//SimpleExpr        ::=  ‘new’ (ClassTemplate | TemplateBody)
//                      |  BlockExpr
//                      |  SimpleExpr1 [‘_’]
simpleExpr
//   : 'new' (classTemplate | templateBody)
//   | blockExpr
   : simpleExpr2
   | simpleExpr1 '_'?
   ;

// SimpleExpr1       ::=  Literal
//                     |  Path
//                     |  ‘_’
//                     |  ‘(’ [Exprs] ‘)’
//                     |  SimpleExpr ‘.’ id
//                     |  SimpleExpr TypeArgs
//                     |  SimpleExpr1 ArgumentExprs
//                     |  XmlExpr
// TODO: XmlExpr
simpleExpr1
   : literal
//   | path
   | (stableId | (ID '.')? 'this')
   | '_'
   | '(' exprs? ')'
//   | simpleExpr '.' ID
   | simpleExpr2 '.' ID
//   | simpleExpr '.' typeArgs
   | simpleExpr2 typeArgs
   | simpleExpr1 argumentExprs
   ;

simpleExpr2
   : 'new' (classTemplate | templateBody)
   | blockExpr
   ;

// Exprs             ::=  Expr {‘,’ Expr}
exprs
   : expr (',' expr)*
   ;

// ArgumentExprs     ::=  ‘(’ [Exprs] ‘)’
//                     |  ‘(’ [Exprs ‘,’] PostfixExpr ‘:’ ‘_’ ‘*’ ‘)’
//                     |  [nl] BlockExpr
argumentExprs
   : '(' exprs? ')'
   | '(' (exprs ',')? postfixExpr ':' '_' '*' ')'
   | '\n'? blockExpr
   ;

// BlockExpr         ::=  ‘{’ CaseClauses ‘}’
//                     |  ‘{’ Block ‘}’
blockExpr
   : '{' caseClauses '}'
   | '{' block '}'
   ;

// Block             ::=  BlockStat {semi BlockStat} [ResultExpr]
block
   : blockStat (SEMI blockStat)* resultExpr?
   ;

// BlockStat         ::=  Import
//                     |  {Annotation} [‘implicit’ | ‘lazy’] Def
//                     |  {Annotation} {LocalModifier} TmplDef
//                     |  Expr1
//                     |
blockStat
   : import_
   | annotation* ('implicit' | 'lazy')? def
   | annotation* localModifier* tmplDef
   | expr1
   |
   ;

// ResultExpr        ::=  Expr1
//                     |  (Bindings | ([‘implicit’] id | ‘_’) ‘:’ CompoundType) ‘=>’ Block
resultExpr
   : expr1
   | (bindings | ('implicit'? ID | '_') ':' compoundType) '=>' block
   ;

// Enumerators       ::=  Generator {semi Generator}
enumerators
   : generator (SEMI generator)*
   ;

// Generator         ::=  Pattern1 ‘<-’ Expr {[semi] Guard | semi Pattern1 ‘=’ Expr}
generator
   : pattern1 '<-' expr (SEMI? guard | SEMI pattern1 '=' expr)*
   ;

// CaseClauses       ::=  CaseClause { CaseClause }
caseClauses
   : caseClause+
   ;

// CaseClause        ::=  ‘case’ Pattern [Guard] ‘=>’ Block
caseClause
   : 'case' pattern guard? '=>' block
   ;

// Guard             ::=  ‘if’ PostfixExpr
guard
   : 'if' postfixExpr
   ;

// Pattern           ::=  Pattern1 { ‘|’ Pattern1 }
pattern
   : pattern1 ('|' pattern1)*
   ;

// Pattern1          ::=  varid ‘:’ TypePat
//                     |  ‘_’ ‘:’ TypePat
//                     |  Pattern2
pattern1
   : VARID ':' typePat
   | '_' ':' typePat
   | pattern2
   ;

// Pattern2          ::=  varid [‘@’ Pattern3]
//                     |  Pattern3
pattern2
   : VARID ('@' pattern3)?
   | pattern3
   ;

// Pattern3          ::=  SimplePattern
//                     |  SimplePattern { id [nl] SimplePattern }
pattern3
   : simplePattern
   | simplePattern (ID '\n'? simplePattern)*
   ;

// SimplePattern     ::=  ‘_’
//                     |  varid
//                     |  Literal
//                     |  StableId
//                     |  StableId ‘(’ [Patterns] ‘)’
//                     |  StableId ‘(’ [Patterns ‘,’] [varid ‘@’] ‘_’ ‘*’ ‘)’
//                     |  ‘(’ [Patterns] ‘)’
//                     |  XmlPattern
// TODO: XmlPattern
simplePattern
   : '_'
   | VARID
   | literal
   | stableId
   | stableId '(' patterns? ')'
   | stableId '(' (patterns ',')? (VARID '@')? '_' '*' ')'
   | '(' patterns? ')'
   ;

// Patterns          ::=  Pattern [‘,’ Patterns]
//                     |  ‘_’ ‘*’
patterns
   : pattern (',' patterns)?
   | '_' '*'
   ;

// TypeParamClause   ::=  ‘[’ VariantTypeParam {‘,’ VariantTypeParam} ‘]’
typeParamClause
   : '[' variantTypeParam (',' variantTypeParam)* ']'
   ;

// FunTypeParamClause::=  ‘[’ TypeParam {‘,’ TypeParam} ‘]’
funTypeParamClause
   : '[' typeParam (',' typeParam)* ']'
   ;

// VariantTypeParam  ::=  {Annotation} [‘+’ | ‘-’] TypeParam
variantTypeParam
   : annotation* ('+' | '-')? typeParam
   ;

// TypeParam         ::=  (id | ‘_’) [TypeParamClause] [‘>:’ Type] [‘<:’ Type]
//                        {‘<%’ Type} {‘:’ Type}
typeParam
   : (ID | '_') typeParamClause? ('>:' type)? ('<:' type)? ('<%' type)* (':' type)*
   ;

// ParamClauses      ::=  {ParamClause} [[nl] ‘(’ ‘implicit’ Params ‘)’]
paramClauses
   : paramClause* ('\n'? '(' 'implicit' params ')')?
   ;

// ParamClause       ::=  [nl] ‘(’ [Params] ‘)’
paramClause
   : '\n'? '(' params? ')'
   ;

// Params            ::=  Param {‘,’ Param}
params
   : param (',' param)*
   ;

// Param             ::=  {Annotation} id [‘:’ ParamType] [‘=’ Expr]
param
   : annotation* ID (':' paramType)? ('=' expr)?
   ;

// ParamType         ::=  Type
//                     |  ‘=>’ Type
//                     |  Type ‘*’
paramType
   : type
   | '=>' type
   | type '*'
   ;

// ClassParamClauses ::=  {ClassParamClause}
//                        [[nl] ‘(’ ‘implicit’ ClassParams ‘)’]
classParamClauses
   : classParamClause* ('\n'? '(' 'implicit' classParams ')')?
   ;

// ClassParamClause  ::=  [nl] ‘(’ [ClassParams] ‘)’
classParamClause
   : '\n'? '(' classParams? ')'
   ;

// ClassParams       ::=  ClassParam {‘,’ ClassParam}
classParams
   : classParam (',' classParam)*
   ;

// ClassParam        ::=  {Annotation} {Modifier} [(‘val’ | ‘var’)]
//                        id ‘:’ ParamType [‘=’ Expr]
classParam
   : annotation* modifier* ('val' | 'var')? ID ':' paramType ('=' expr)?
   ;

// Bindings          ::=  ‘(’ Binding {‘,’ Binding} ‘)’
bindings
   : '(' binding (',' binding)* ')'
   ;

// Binding           ::=  (id | ‘_’) [‘:’ Type]
binding
   : (ID | '_') (':' type)?
   ;

// Modifier          ::=  LocalModifier
//                     |  AccessModifier
//                     |  ‘override’
modifier
   : localModifier
   | accessModifier
   | 'override'
   ;

// LocalModifier     ::=  ‘abstract’
//                     |  ‘final’
//                     |  ‘sealed’
//                     |  ‘implicit’
//                     |  ‘lazy’
localModifier
   : 'abstract'
   | 'final'
   | 'sealed'
   | 'implicit'
   | 'lazy'
   ;

// AccessModifier    ::=  (‘private’ | ‘protected’) [AccessQualifier]
accessModifier
   : ('private' | 'protected') accessQualifier?
   ;

// AccessQualifier   ::=  ‘[’ (id | ‘this’) ‘]’
accessQualifier
   : '[' (ID | 'this') ']'
   ;

// Annotation        ::=  ‘@’ SimpleType {ArgumentExprs}
annotation
   : '@' simpleType argumentExprs*
   ;

// ConstrAnnotation  ::=  ‘@’ SimpleType ArgumentExprs
constrAnnotation
   : '@' simpleType argumentExprs
   ;

// TemplateBody      ::=  [nl] ‘{’ [SelfType] TemplateStat {semi TemplateStat} ‘}’
templateBody
   : '\n'? '{' selfType? templateStat (SEMI templateStat)* '}'
   ;

// TemplateStat      ::=  Import
//                     |  {Annotation [nl]} {Modifier} Def
//                     |  {Annotation [nl]} {Modifier} Dcl
//                     |  Expr
//                     |
templateStat
   : import_
   | (annotation '\n'?)* modifier* def
   | (annotation '\n'?)* modifier* dcl
   | expr
   |
   ;

// SelfType          ::=  id [‘:’ Type] ‘=>’
//                     |  ‘this’ ‘:’ Type ‘=>’
selfType
   : ID (':' type)? '=>'
   | 'this' ':' type '=>'
   ;

// Import            ::=  ‘import’ ImportExpr {‘,’ ImportExpr}
import_
   : 'import' importExpr (',' importExpr)*
   ;

// ImportExpr        ::=  StableId ‘.’ (id | ‘_’ | ImportSelectors)
importExpr
   : stableId '.' (ID | '_' | importSelectors)
   ;

// ImportSelectors   ::=  ‘{’ {ImportSelector ‘,’} (ImportSelector | ‘_’) ‘}’
importSelectors
   : '{' (importSelector ',')* (importSelector | '_') '}'
   ;

// ImportSelector    ::=  id [‘=>’ id | ‘=>’ ‘_’]
importSelector
   : ID ('=>' ID | '=>' '_')
   ;

// Dcl               ::=  ‘val’ ValDcl
//                     |  ‘var’ VarDcl
//                     |  ‘def’ FunDcl
//                     |  ‘type’ {nl} TypeDcl
dcl
   : 'val' valDcl
   | 'var' varDcl
   | 'def' funDcl
   | 'type' '\n'* typeDcl
   ;

// ValDcl            ::=  ids ‘:’ Type
valDcl
   : ids ':' type
   ;

// VarDcl            ::=  ids ‘:’ Type
varDcl
   : ids ':' type
   ;

// FunDcl            ::=  FunSig [‘:’ Type]
funDcl
   : funSig (':' type)?
   ;

// FunSig            ::=  id [FunTypeParamClause] ParamClauses
funSig
   : ID funTypeParamClause? paramClauses
   ;

// TypeDcl           ::=  id [TypeParamClause] [‘>:’ Type] [‘<:’ Type]
typeDcl
   : ID typeParamClause? ('>:' type)? ('<::' type)?
   ;

// PatVarDef         ::=  ‘val’ PatDef
//                     |  ‘var’ VarDef
patVarDef
   : 'val' patDef
   | 'var' varDef
   ;

// Def               ::=  PatVarDef
//                     |  ‘def’ FunDef
//                     |  ‘type’ {nl} TypeDef
//                     |  TmplDef
def
   : patVarDef
   | 'def' funDef
   | 'type' '\n'* typeDef
   | tmplDef
   ;

// PatDef            ::=  Pattern2 {‘,’ Pattern2} [‘:’ Type] ‘=’ Expr
patDef
   : pattern2 (',' pattern2)* (':' type)? '=' expr
   ;

// VarDef            ::=  PatDef
//                     |  ids ‘:’ Type ‘=’ ‘_’
varDef
   : patDef
   | ids ':' type '=' '_'
   ;

// FunDef            ::=  FunSig [‘:’ Type] ‘=’ Expr
//                     |  FunSig [nl] ‘{’ Block ‘}’
//                     |  ‘this’ ParamClause ParamClauses
//                        (‘=’ ConstrExpr | [nl] ConstrBlock)
funDef
   : funSig (':' type)? '=' expr
   | funSig '\n'? '{' block '}'
   | 'this' paramClause paramClauses ('=' constrExpr | '\n'? constrBlock)
   ;

// TypeDef           ::=  id [TypeParamClause] ‘=’ Type
typeDef
   : ID typeParamClause? '=' type
   ;

// TmplDef           ::=  [‘case’] ‘class’ ClassDef
//                     |  [‘case’] ‘object’ ObjectDef
//                     |  ‘trait’ TraitDef
tmplDef
   : 'case'? 'class' classDef
   | 'case'? 'object' objectDef
   | 'trait' traitDef
   ;

// ClassDef          ::=  id [TypeParamClause] {ConstrAnnotation} [AccessModifier]
//                        ClassParamClauses ClassTemplateOpt
classDef
   : ID typeParamClause? constrAnnotation* accessModifier? classParamClauses classTemplateOpt
   ;

// TraitDef          ::=  id [TypeParamClause] TraitTemplateOpt
traitDef
   : ID typeParamClause? traitTemplateOpt
   ;

// ObjectDef         ::=  id ClassTemplateOpt
objectDef
   : ID classTemplateOpt
   ;

// ClassTemplateOpt  ::=  ‘extends’ ClassTemplate
//                     | [[‘extends’] TemplateBody]
classTemplateOpt
   : 'extends' classTemplate
   | ('extends'? templateBody)?
   ;

// TraitTemplateOpt  ::=  ‘extends’ TraitTemplate | [[‘extends’] TemplateBody]
traitTemplateOpt
   : 'extends' traitTemplate
   | ('extends'? templateBody)?
   ;

// ClassTemplate     ::=  [EarlyDefs] ClassParents [TemplateBody]
classTemplate
   : earlyDefs? classParents templateBody?
   ;

// TraitTemplate     ::=  [EarlyDefs] TraitParents [TemplateBody]
traitTemplate
   : earlyDefs? traitParents templateBody?
   ;

// ClassParents      ::=  Constr {‘with’ AnnotType}
classParents
   : constr ('with' annotType)*
   ;

// TraitParents      ::=  AnnotType {‘with’ AnnotType}
traitParents
   : annotType ('with' annotType)*
   ;

// Constr            ::=  AnnotType {ArgumentExprs}
constr
   : annotType argumentExprs*
   ;

// EarlyDefs         ::= ‘{’ [EarlyDef {semi EarlyDef}] ‘}’ ‘with’
earlyDefs
   : '{' (earlyDef (SEMI earlyDef)*)? '}' 'with'
   ;

// EarlyDef          ::=  {Annotation [nl]} {Modifier} PatVarDef
earlyDef
   : (annotation '\n'?)* modifier* patVarDef
   ;

// ConstrExpr        ::=  SelfInvocation
//                     |  ConstrBlock
constrExpr
   : selfInvocation
   | constrBlock
   ;

// ConstrBlock       ::=  ‘{’ SelfInvocation {semi BlockStat} ‘}’
constrBlock
   : '{' selfInvocation (SEMI blockStat)* '}'
   ;

// SelfInvocation    ::=  ‘this’ ArgumentExprs {ArgumentExprs}
selfInvocation
   : 'this' argumentExprs+
   ;

// TopStatSeq        ::=  TopStat {semi TopStat}
topStatSeq
   : topStat (SEMI topStat)*
   ;

// TopStat           ::=  {Annotation [nl]} {Modifier} TmplDef
//                     |  Import
//                     |  Packaging
//                     |  PackageObject
//                     |
topStat
   : (annotation '\n'?)* modifier* tmplDef
   | import_
   | packaging
   | packageObject
   |
   ;

// Packaging         ::=  ‘package’ QualId [nl] ‘{’ TopStatSeq ‘}’
packaging
   : 'package' qualId '\n'? '{' topStatSeq '}'
   ;

// PackageObject     ::=  ‘package’ ‘object’ ObjectDef
packageObject
   : 'package' 'object' objectDef
   ;

// CompilationUnit   ::=  {‘package’ QualId semi} TopStatSeq
compilationUnit
   : ('package' qualId SEMI)* topStatSeq
   ;


///
/// LEXER
///

// op               ::=  opchar {opchar}
OP
   : OPCHAR+
   ;

// id               ::=  plainid
//                  |  ‘`’ { charNoBackQuoteOrNewline | UnicodeEscape | charEscapeSeq } ‘`’
ID
   : PLAINID
   | '`' (CHAR_NO_BACK_QUOTE_OR_NEW_LINE | UNICODE_ESCAPE | CHAR_ESCAPE_SEQ)* '`'
   ;

// varid            ::=  lower idrest
VARID
   : LOWER IDREST
   ;

// plainid          ::=  upper idrest
//                  |  varid
//                  |  op
PLAINID
   : UPPER IDREST
   | VARID
   | OP
   ;

// integerLiteral   ::=  (decimalNumeral | hexNumeral) [‘L’ | ‘l’]
INTEGER_LITERAL
   : (DECIMAL_NUMERAL | HEX_NUMERAL) ('L' | 'l')?
   ;

// floatingPointLiteral
//                  ::=  digit {digit} ‘.’ digit {digit} [exponentPart] [floatType]
//                  |  ‘.’ digit {digit} [exponentPart] [floatType]
//                  |  digit {digit} exponentPart [floatType]
//                  |  digit {digit} [exponentPart] floatType
FLOATING_POINT_LITERAL
   : DIGIT+ '.' DIGIT+ EXPONENT_PART? FLOAT_TYPE?
   | '.' DIGIT+ EXPONENT_PART? FLOAT_TYPE?
   | DIGIT+ EXPONENT_PART FLOAT_TYPE?
   | DIGIT+ EXPONENT_PART? FLOAT_TYPE
   ;

// booleanLiteral   ::=  ‘true’ | ‘false’
BOOLEAN_LITERAL
   : 'true' | 'false'
   ;

// characterLiteral ::=  ‘'’ (charNoQuoteOrNewline | UnicodeEscape | charEscapeSeq) ‘'’
CHARACTER_LITERAL
   : '\'' (CHAR_NO_QUOTE_OR_NEW_LINE | UNICODE_ESCAPE | CHAR_ESCAPE_SEQ) '\''
   ;

// stringLiteral    ::=  ‘"’ {stringElement} ‘"’
//                  |  ‘"""’ multiLineChars ‘"""’
STRING_LITERAL
   : '"' STRING_ELEMENT* '"'
   | '"""' MULTILINE_CHARS '"""'
   ;

// symbolLiteral    ::=  ‘'’ plainid
SYMBOL_LITERAL
   : '\'' PLAINID
   ;

// comment          ::=  ‘/*’ “any sequence of characters; nested comments are allowed” ‘*/’
//                  |  ‘//’ “any sequence of characters up to end of line”
COMMENT
   : (('/*' .*? '*/') | ('//' ~[\r\n]*)) -> skip
   ;

//NL
//   : [\u000A]
//   ;

// whiteSpace       ::=  ‘\u0020’ | ‘\u0009’ | ‘\u000D’ | ‘\u000A’
WS
   :  ([\u0020\u0009]+) -> channel(HIDDEN)
   ;

// semi             ::=  ‘;’ |  nl {nl}
SEMI
   : ';' | [\u000A]+
   ;

// hexDigit      ::= ‘0’ | … | ‘9’ | ‘A’ | … | ‘F’ | ‘a’ | … | ‘f’
fragment HEX_DIGIT
   : [0-9a-fA-F]
   ;

// UnicodeEscape ::= ‘\’ ‘u’ {‘u’} hexDigit hexDigit hexDigit hexDigit
fragment UNICODE_ESCAPE
   : '\\u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
   ;

// upper            ::=  ‘A’ | … | ‘Z’ | ‘\$’ | ‘_’  // and Unicode category Lu
fragment UPPER
   : [A-Z\u005F\u0024\p{Lu}]
   ;

// lower            ::=  ‘a’ | … | ‘z’ // and Unicode category Ll
fragment LOWER
   : [a-z\p{Ll}]
   ;

// letter           ::=  upper | lower // and Unicode categories Lo, Lt, Nl
fragment LETTER
   : UPPER
   | LOWER
   | [\p{Lo}\p{Lt}\p{Nl}]
   ;

// opchar           ::= // printableChar not matched by (whiteSpace | upper | lower |
//                      // letter | digit | paren | delim | opchar | Unicode_Sm | Unicode_So)
fragment OPCHAR
//   : ~[\u0000-\u001FA-Z\u005F\u0024\p{Lu}a-z\p{Ll}\p{Lo}\p{Lt}\p{Nl}0-9()[\]{}`'".;,\p{Sm}\p{So}]
   : [+<=>|~!:#%&*\\\-/?]
   ;

fragment CHAR_NO_BACK_QUOTE_OR_NEW_LINE
   : [\u0020-\u005F\u0061-\u007E]
   ;

fragment CHAR_NO_DOUBLE_QUOTE
   : [\u000A\u0020-\u0026\u0028-\u007E]
   ;

fragment CHAR_ESCAPE_SEQ
   : '\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\')
   ;

// digit            ::=  ‘0’ | nonZeroDigit
fragment DIGIT
   : [0-9]
   ;

// nonZeroDigit     ::=  ‘1’ | … | ‘9’
fragment NON_ZERO_DIGIT
   : [1-9]
   ;

// idrest           ::=  {letter | digit} [‘_’ op]
fragment IDREST
   : (LETTER | DIGIT)* ('_' OP)?
   ;

// decimalNumeral   ::=  ‘0’ | nonZeroDigit {digit}
fragment DECIMAL_NUMERAL
   : '0'
   | NON_ZERO_DIGIT DIGIT*
   ;

// hexNumeral       ::=  ‘0’ (‘x’ | ‘X’) hexDigit {hexDigit}
fragment HEX_NUMERAL
   : '0' ('x' | 'X') HEX_DIGIT+
   ;

// exponentPart     ::=  (‘E’ | ‘e’) [‘+’ | ‘-’] digit {digit}
fragment EXPONENT_PART
   : [Ee] [+\-]? DIGIT+
   ;

// floatType        ::=  ‘F’ | ‘f’ | ‘D’ | ‘d’
fragment FLOAT_TYPE
//   : 'F' | 'f' | 'D' | 'd'
   : [FfDd]
   ;

fragment CHAR_NO_QUOTE_OR_NEW_LINE
   : [\u0020-\u0026\u0028-\u007E]
   ;

// stringElement    ::=  charNoDoubleQuoteOrNewline
//                  |  UnicodeEscape
//                  |  charEscapeSeq
fragment STRING_ELEMENT
   : CHAR_NO_DOUBLE_QUOTE_OR_NEW_LINE
   | UNICODE_ESCAPE
   | CHAR_ESCAPE_SEQ
   ;

// multiLineChars   ::=  {[‘"’] [‘"’] charNoDoubleQuote} {‘"’}
fragment MULTILINE_CHARS
   : ('"'? '"'? CHAR_NO_DOUBLE_QUOTE)* '"'*
   ;

fragment CHAR_NO_DOUBLE_QUOTE_OR_NEW_LINE
   : [\u0020\u0021\u0023-\u007E]
   ;
