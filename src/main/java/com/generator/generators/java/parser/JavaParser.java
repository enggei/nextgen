// Generated from src/com/generator/generators/java/parser/Java.g4 by ANTLR 4.1
package com.generator.generators.java.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABSTRACT=1, ASSERT=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CATCH=7, CHAR=8, 
		CLASS=9, CONST=10, CONTINUE=11, DEFAULT=12, DO=13, DOUBLE=14, ELSE=15, 
		ENUM=16, EXTENDS=17, FINAL=18, FINALLY=19, FLOAT=20, FOR=21, IF=22, GOTO=23, 
		IMPLEMENTS=24, IMPORT=25, INSTANCEOF=26, INT=27, INTERFACE=28, LONG=29, 
		NATIVE=30, NEW=31, PACKAGE=32, PRIVATE=33, PROTECTED=34, PUBLIC=35, RETURN=36, 
		SHORT=37, STATIC=38, STRICTFP=39, SUPER=40, SWITCH=41, SYNCHRONIZED=42, 
		THIS=43, THROW=44, THROWS=45, TRANSIENT=46, TRY=47, VOID=48, VOLATILE=49, 
		WHILE=50, IntegerLiteral=51, FloatingPointLiteral=52, BooleanLiteral=53, 
		CharacterLiteral=54, StringLiteral=55, NullLiteral=56, LPAREN=57, RPAREN=58, 
		LBRACE=59, RBRACE=60, LBRACK=61, RBRACK=62, SEMI=63, COMMA=64, DOT=65, 
		ASSIGN=66, GT=67, LT=68, BANG=69, TILDE=70, QUESTION=71, COLON=72, EQUAL=73, 
		LE=74, GE=75, NOTEQUAL=76, AND=77, OR=78, INC=79, DEC=80, ADD=81, SUB=82, 
		MUL=83, DIV=84, BITAND=85, BITOR=86, CARET=87, MOD=88, ADD_ASSIGN=89, 
		SUB_ASSIGN=90, MUL_ASSIGN=91, DIV_ASSIGN=92, AND_ASSIGN=93, OR_ASSIGN=94, 
		XOR_ASSIGN=95, MOD_ASSIGN=96, LSHIFT_ASSIGN=97, RSHIFT_ASSIGN=98, URSHIFT_ASSIGN=99, 
		Identifier=100, AT=101, ELLIPSIS=102, WS=103, COMMENT=104, LINE_COMMENT=105;
	public static final String[] tokenNames = {
		"<INVALID>", "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", 
		"'case'", "'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
		"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
		"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
		"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
		"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
		"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
		"'transient'", "'try'", "'void'", "'volatile'", "'while'", "IntegerLiteral", 
		"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
		"'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", 
		"'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", 
		"'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
		"'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", 
		"'%='", "'<<='", "'>>='", "'>>>='", "Identifier", "'@'", "'...'", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_importName = 3, RULE_typeDeclaration = 4, RULE_modifier = 5, RULE_classOrInterfaceModifier = 6, 
		RULE_variableModifier = 7, RULE_classDeclaration = 8, RULE_typeParameters = 9, 
		RULE_typeParameter = 10, RULE_typeBound = 11, RULE_enumDeclaration = 12, 
		RULE_enumConstants = 13, RULE_enumConstant = 14, RULE_enumBodyDeclarations = 15, 
		RULE_interfaceDeclaration = 16, RULE_typeList = 17, RULE_classBody = 18, 
		RULE_interfaceBody = 19, RULE_classBodyDeclaration = 20, RULE_memberDeclaration = 21, 
		RULE_methodDeclaration = 22, RULE_genericMethodDeclaration = 23, RULE_constructorDeclaration = 24, 
		RULE_genericConstructorDeclaration = 25, RULE_fieldDeclaration = 26, RULE_interfaceBodyDeclaration = 27, 
		RULE_interfaceMemberDeclaration = 28, RULE_constDeclaration = 29, RULE_constantDeclarator = 30, 
		RULE_interfaceMethodDeclaration = 31, RULE_genericInterfaceMethodDeclaration = 32, 
		RULE_variableDeclarators = 33, RULE_variableDeclarator = 34, RULE_variableDeclaratorId = 35, 
		RULE_variableInitializer = 36, RULE_arrayInitializer = 37, RULE_packageOrTypeName = 38, 
		RULE_enumConstantName = 39, RULE_typeName = 40, RULE_type = 41, RULE_classOrInterfaceType = 42, 
		RULE_primitiveType = 43, RULE_typeArguments = 44, RULE_typeArgument = 45, 
		RULE_qualifiedNameList = 46, RULE_formalParameters = 47, RULE_formalParameterList = 48, 
		RULE_formalParameter = 49, RULE_lastFormalParameter = 50, RULE_methodBody = 51, 
		RULE_constructorBody = 52, RULE_qualifiedName = 53, RULE_literal = 54, 
		RULE_annotation = 55, RULE_annotationName = 56, RULE_elementValuePairs = 57, 
		RULE_elementValuePair = 58, RULE_elementValue = 59, RULE_elementValueArrayInitializer = 60, 
		RULE_annotationTypeDeclaration = 61, RULE_annotationTypeBody = 62, RULE_annotationTypeElementDeclaration = 63, 
		RULE_annotationTypeElementRest = 64, RULE_annotationMethodOrConstantRest = 65, 
		RULE_annotationMethodRest = 66, RULE_annotationConstantRest = 67, RULE_defaultValue = 68, 
		RULE_block = 69, RULE_blockStatement = 70, RULE_localVariableDeclarationStatement = 71, 
		RULE_localVariableDeclaration = 72, RULE_statement = 73, RULE_catches = 74, 
		RULE_catchClause = 75, RULE_catchType = 76, RULE_finallyBlock = 77, RULE_resourceSpecification = 78, 
		RULE_resources = 79, RULE_resource = 80, RULE_switchBlockStatementGroup = 81, 
		RULE_switchLabel = 82, RULE_forControl = 83, RULE_forInit = 84, RULE_enhancedForControl = 85, 
		RULE_forUpdate = 86, RULE_parExpression = 87, RULE_expressionList = 88, 
		RULE_statementExpression = 89, RULE_constantExpression = 90, RULE_expression = 91, 
		RULE_primary = 92, RULE_creator = 93, RULE_createdName = 94, RULE_innerCreator = 95, 
		RULE_arrayCreatorRest = 96, RULE_classCreatorRest = 97, RULE_explicitGenericInvocation = 98, 
		RULE_nonWildcardTypeArguments = 99, RULE_typeArgumentsOrDiamond = 100, 
		RULE_nonWildcardTypeArgumentsOrDiamond = 101, RULE_superSuffix = 102, 
		RULE_explicitGenericInvocationSuffix = 103, RULE_arguments = 104;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "importName", 
		"typeDeclaration", "modifier", "classOrInterfaceModifier", "variableModifier", 
		"classDeclaration", "typeParameters", "typeParameter", "typeBound", "enumDeclaration", 
		"enumConstants", "enumConstant", "enumBodyDeclarations", "interfaceDeclaration", 
		"typeList", "classBody", "interfaceBody", "classBodyDeclaration", "memberDeclaration", 
		"methodDeclaration", "genericMethodDeclaration", "constructorDeclaration", 
		"genericConstructorDeclaration", "fieldDeclaration", "interfaceBodyDeclaration", 
		"interfaceMemberDeclaration", "constDeclaration", "constantDeclarator", 
		"interfaceMethodDeclaration", "genericInterfaceMethodDeclaration", "variableDeclarators", 
		"variableDeclarator", "variableDeclaratorId", "variableInitializer", "arrayInitializer", 
		"packageOrTypeName", "enumConstantName", "typeName", "type", "classOrInterfaceType", 
		"primitiveType", "typeArguments", "typeArgument", "qualifiedNameList", 
		"formalParameters", "formalParameterList", "formalParameter", "lastFormalParameter", 
		"methodBody", "constructorBody", "qualifiedName", "literal", "annotation", 
		"annotationName", "elementValuePairs", "elementValuePair", "elementValue", 
		"elementValueArrayInitializer", "annotationTypeDeclaration", "annotationTypeBody", 
		"annotationTypeElementDeclaration", "annotationTypeElementRest", "annotationMethodOrConstantRest", 
		"annotationMethodRest", "annotationConstantRest", "defaultValue", "block", 
		"blockStatement", "localVariableDeclarationStatement", "localVariableDeclaration", 
		"statement", "catches", "catchClause", "catchType", "finallyBlock", "resourceSpecification", 
		"resources", "resource", "switchBlockStatementGroup", "switchLabel", "forControl", 
		"forInit", "enhancedForControl", "forUpdate", "parExpression", "expressionList", 
		"statementExpression", "constantExpression", "expression", "primary", 
		"creator", "createdName", "innerCreator", "arrayCreatorRest", "classCreatorRest", 
		"explicitGenericInvocation", "nonWildcardTypeArguments", "typeArgumentsOrDiamond", 
		"nonWildcardTypeArgumentsOrDiamond", "superSuffix", "explicitGenericInvocationSuffix", 
		"arguments"
	};

	@Override
	public String getGrammarFileName() { return "Java.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }



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


	public JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public TerminalNode EOF() { return getToken(JavaParser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(210); packageDeclaration();
				}
				break;
			}
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(213); importDeclaration();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << ENUM) | (1L << FINAL) | (1L << INTERFACE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP) | (1L << SEMI))) != 0) || _la==AT) {
				{
				{
				setState(219); typeDeclaration();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 packageEnd(); 
			setState(226); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName;
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 packageDeclarationStart(); 
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(229); annotation();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235); match(PACKAGE);
			setState(236); ((PackageDeclarationContext)_localctx).qualifiedName = qualifiedName();
			 packageName((((PackageDeclarationContext)_localctx).qualifiedName!=null?_input.getText(((PackageDeclarationContext)_localctx).qualifiedName.start,((PackageDeclarationContext)_localctx).qualifiedName.stop):null)); 
			setState(238); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName;
		public ImportNameContext importName;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ImportNameContext importName() {
			return getRuleContext(ImportNameContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); match(IMPORT);
			setState(242);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(241); match(STATIC);
				}
			}

			setState(244); ((ImportDeclarationContext)_localctx).qualifiedName = qualifiedName();
			setState(245); ((ImportDeclarationContext)_localctx).importName = importName();
			 importName((((ImportDeclarationContext)_localctx).qualifiedName!=null?_input.getText(((ImportDeclarationContext)_localctx).qualifiedName.start,((ImportDeclarationContext)_localctx).qualifiedName.stop):null), (((ImportDeclarationContext)_localctx).importName!=null?_input.getText(((ImportDeclarationContext)_localctx).importName.start,((ImportDeclarationContext)_localctx).importName.stop):null)); 
			setState(247); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportNameContext extends ParserRuleContext {
		public ImportNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importName; }
	}

	public final ImportNameContext importName() throws RecognitionException {
		ImportNameContext _localctx = new ImportNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(249); match(DOT);
				setState(250); match(MUL);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
			return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public List<ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
			return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeDeclaration);
		int _la;
		try {
			int _alt;
			setState(290);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
					{
					{
					setState(253); classOrInterfaceModifier();
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(259); classDeclaration();
				 currentModifiers.pop(); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
					{
					{
					setState(262); classOrInterfaceModifier();
					}
					}
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(268); enumDeclaration();
				 currentModifiers.pop(); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0) || _la==AT) {
					{
					{
					setState(271); classOrInterfaceModifier();
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(277); interfaceDeclaration();
				 currentModifiers.pop(); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(280); classOrInterfaceModifier();
						}
						} 
					}
					setState(285);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(286); annotationTypeDeclaration();
				 currentModifiers.pop(); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(289); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public ClassOrInterfaceModifierContext classOrInterfaceModifier() {
			return getRuleContext(ClassOrInterfaceModifierContext.class,0);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_modifier);
		int _la;
		try {
			setState(294);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case FINAL:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(292); classOrInterfaceModifier();
				}
				break;
			case NATIVE:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOLATILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NATIVE) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ClassOrInterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifier; }
	}

	public final ClassOrInterfaceModifierContext classOrInterfaceModifier() throws RecognitionException {
		ClassOrInterfaceModifierContext _localctx = new ClassOrInterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classOrInterfaceModifier);
		int _la;
		try {
			setState(299);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(296); annotation();
				}
				break;
			case ABSTRACT:
			case FINAL:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << FINAL) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << STRICTFP))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				 currentModifiers.push(_input.getText(_localctx.start, _input.LT(-1))); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableModifier);
		try {
			setState(303);
			switch (_input.LA(1)) {
			case FINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(301); match(FINAL);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(302); annotation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public Token Identifier;
		public TypeContext type;
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(CLASS);
			setState(306); ((ClassDeclarationContext)_localctx).Identifier = match(Identifier);
			 className(currentModifiers.peek(),  ((ClassDeclarationContext)_localctx).Identifier.getText()); 
			setState(309);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(308); typeParameters();
				}
			}

			setState(315);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(311); match(EXTENDS);
				setState(312); ((ClassDeclarationContext)_localctx).type = type();
				 classExtends((((ClassDeclarationContext)_localctx).type!=null?_input.getText(((ClassDeclarationContext)_localctx).type.start,((ClassDeclarationContext)_localctx).type.stop):null)); 
				}
			}

			setState(319);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(317); match(IMPLEMENTS);
				setState(318); typeList();
				}
			}

			 classDeclarationEnd(); 
			setState(322); classBody();
			 classEnd(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325); match(LT);
			setState(326); typeParameter();
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(327); match(COMMA);
				setState(328); typeParameter();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(334); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336); match(Identifier);
			setState(339);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(337); match(EXTENDS);
				setState(338); typeBound();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBoundContext extends ParserRuleContext {
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeBound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341); type();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITAND) {
				{
				{
				setState(342); match(BITAND);
				setState(343); type();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclarationContext extends ParserRuleContext {
		public Token Identifier;
		public TypeListContext typeList;
		public TerminalNode ENUM() { return getToken(JavaParser.ENUM, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public EnumConstantsContext enumConstants() {
			return getRuleContext(EnumConstantsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); match(ENUM);
			setState(350); ((EnumDeclarationContext)_localctx).Identifier = match(Identifier);
			 enumName(((EnumDeclarationContext)_localctx).Identifier.getText()); 
			setState(356);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(352); match(IMPLEMENTS);
				setState(353); ((EnumDeclarationContext)_localctx).typeList = typeList();
				 enumImplements((((EnumDeclarationContext)_localctx).typeList!=null?_input.getText(((EnumDeclarationContext)_localctx).typeList.start,((EnumDeclarationContext)_localctx).typeList.stop):null)); 
				}
			}

			setState(358); match(LBRACE);
			setState(360);
			_la = _input.LA(1);
			if (_la==Identifier || _la==AT) {
				{
				setState(359); enumConstants();
				}
			}

			setState(363);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(362); match(COMMA);
				}
			}

			setState(366);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(365); enumBodyDeclarations();
				}
			}

			setState(368); match(RBRACE);
			 enumEnd(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantsContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public EnumConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstants; }
	}

	public final EnumConstantsContext enumConstants() throws RecognitionException {
		EnumConstantsContext _localctx = new EnumConstantsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enumConstants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(371); enumConstant();
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(372); match(COMMA);
					setState(373); enumConstant();
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantContext extends ParserRuleContext {
		public Token Identifier;
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(379); annotation();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(385); ((EnumConstantContext)_localctx).Identifier = match(Identifier);
			 enumConstant(((EnumConstantContext)_localctx).Identifier.getText()); 
			setState(388);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(387); arguments();
				}
			}

			setState(391);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(390); classBody();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393); match(SEMI);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOID) | (1L << VOLATILE) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				{
				setState(394); classBodyDeclaration();
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public Token Identifier;
		public TypeListContext typeList;
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); match(INTERFACE);
			setState(401); ((InterfaceDeclarationContext)_localctx).Identifier = match(Identifier);
			 interfaceName(((InterfaceDeclarationContext)_localctx).Identifier.getText()); 
			setState(404);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(403); typeParameters();
				}
			}

			setState(410);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(406); match(EXTENDS);
				setState(407); ((InterfaceDeclarationContext)_localctx).typeList = typeList();
				 interfaceExtends((((InterfaceDeclarationContext)_localctx).typeList!=null?_input.getText(((InterfaceDeclarationContext)_localctx).typeList.start,((InterfaceDeclarationContext)_localctx).typeList.stop):null)); 
				}
			}

			setState(412); interfaceBody();
			 interfaceEnd(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeListContext extends ParserRuleContext {
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415); type();
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(416); match(COMMA);
				setState(417); type();
				}
				}
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423); match(LBRACE);
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOID) | (1L << VOLATILE) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				{
				setState(424); classBodyDeclaration();
				}
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(430); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyContext extends ParserRuleContext {
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
			return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public List<InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
			return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432); match(LBRACE);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOID) | (1L << VOLATILE) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				{
				setState(433); interfaceBodyDeclaration();
				}
				}
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(439); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ModifierContext modifier;
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classBodyDeclaration);
		int _la;
		try {
			int _alt;
			setState(456);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(441); match(SEMI);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(442); match(STATIC);
					}
				}

				setState(445); block();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(446); ((ClassBodyDeclarationContext)_localctx).modifier = modifier();
						}
						} 
					}
					setState(451);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				 currentModifiers.push((((ClassBodyDeclarationContext)_localctx).modifier!=null?_input.getText(((ClassBodyDeclarationContext)_localctx).modifier.start,((ClassBodyDeclarationContext)_localctx).modifier.stop):null)); 
				setState(453); memberDeclaration();
				 currentModifiers.pop(); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberDeclarationContext extends ParserRuleContext {
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext genericMethodDeclaration() {
			return getRuleContext(GenericMethodDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext genericConstructorDeclaration() {
			return getRuleContext(GenericConstructorDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_memberDeclaration);
		try {
			setState(470);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(458); methodDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(459); genericMethodDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				 fieldDeclarationStart(); 
				setState(461); fieldDeclaration();
				 fieldDeclarationEnd(); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(464); constructorDeclaration();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(465); genericConstructorDeclaration();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(466); interfaceDeclaration();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(467); annotationTypeDeclaration();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(468); classDeclaration();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(469); enumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TypeContext type;
		public Token Identifier;
		public MethodBodyContext methodBody;
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(472); ((MethodDeclarationContext)_localctx).type = type();
				}
				break;
			case VOID:
				{
				setState(473); match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(476); ((MethodDeclarationContext)_localctx).Identifier = match(Identifier);
			 newMethod((((MethodDeclarationContext)_localctx).type!=null?_input.getText(((MethodDeclarationContext)_localctx).type.start,((MethodDeclarationContext)_localctx).type.stop):null)==null ? null : (((MethodDeclarationContext)_localctx).type!=null?_input.getText(((MethodDeclarationContext)_localctx).type.start,((MethodDeclarationContext)_localctx).type.stop):null), ((MethodDeclarationContext)_localctx).Identifier.getText()); 
			setState(478); formalParameters();
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(479); match(LBRACK);
				setState(480); match(RBRACK);
				}
				}
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(488);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(486); match(THROWS);
				setState(487); qualifiedNameList();
				}
			}

			setState(492);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(490); ((MethodDeclarationContext)_localctx).methodBody = methodBody();
				}
				break;
			case SEMI:
				{
				setState(491); match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 endMethod((((MethodDeclarationContext)_localctx).methodBody!=null?_input.getText(((MethodDeclarationContext)_localctx).methodBody.start,((MethodDeclarationContext)_localctx).methodBody.stop):null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericMethodDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericMethodDeclaration; }
	}

	public final GenericMethodDeclarationContext genericMethodDeclaration() throws RecognitionException {
		GenericMethodDeclarationContext _localctx = new GenericMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_genericMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496); typeParameters();
			setState(497); methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public Token Identifier;
		public ConstructorBodyContext constructorBody;
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499); ((ConstructorDeclarationContext)_localctx).Identifier = match(Identifier);
			 newConstructor(((ConstructorDeclarationContext)_localctx).Identifier.getText()); 
			setState(501); formalParameters();
			setState(504);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(502); match(THROWS);
				setState(503); qualifiedNameList();
				}
			}

			setState(506); ((ConstructorDeclarationContext)_localctx).constructorBody = constructorBody();
			 endConstructor((((ConstructorDeclarationContext)_localctx).constructorBody!=null?_input.getText(((ConstructorDeclarationContext)_localctx).constructorBody.start,((ConstructorDeclarationContext)_localctx).constructorBody.stop):null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericConstructorDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericConstructorDeclaration; }
	}

	public final GenericConstructorDeclarationContext genericConstructorDeclaration() throws RecognitionException {
		GenericConstructorDeclarationContext _localctx = new GenericConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_genericConstructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509); typeParameters();
			setState(510); constructorDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeContext type;
		public VariableDeclaratorsContext variableDeclarators;
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512); ((FieldDeclarationContext)_localctx).type = type();
			setState(513); ((FieldDeclarationContext)_localctx).variableDeclarators = variableDeclarators();

			    String modifier = currentModifiers.peek();
			    String name = (((FieldDeclarationContext)_localctx).variableDeclarators!=null?_input.getText(((FieldDeclarationContext)_localctx).variableDeclarators.start,((FieldDeclarationContext)_localctx).variableDeclarators.stop):null).contains("=") ? ((((FieldDeclarationContext)_localctx).variableDeclarators!=null?_input.getText(((FieldDeclarationContext)_localctx).variableDeclarators.start,((FieldDeclarationContext)_localctx).variableDeclarators.stop):null).split("=")[0]) : ((((FieldDeclarationContext)_localctx).variableDeclarators!=null?_input.getText(((FieldDeclarationContext)_localctx).variableDeclarators.start,((FieldDeclarationContext)_localctx).variableDeclarators.stop):null));
			    String initializer = creators.isEmpty() ? null : creators.pop();
			    newField( modifier, (((FieldDeclarationContext)_localctx).type!=null?_input.getText(((FieldDeclarationContext)_localctx).type.start,((FieldDeclarationContext)_localctx).type.stop):null), name, initializer);  
			setState(515); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyDeclarationContext extends ParserRuleContext {
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration() {
			return getRuleContext(InterfaceMemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration() throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_interfaceBodyDeclaration);
		try {
			int _alt;
			setState(525);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOID:
			case VOLATILE:
			case LT:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(520);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(517); modifier();
						}
						} 
					}
					setState(522);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				setState(523); interfaceMemberDeclaration();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(524); match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() {
			return getRuleContext(GenericInterfaceMethodDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_interfaceMemberDeclaration);
		try {
			setState(534);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(527); constDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(528); interfaceMethodDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(529); genericInterfaceMethodDeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(530); interfaceDeclaration();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(531); annotationTypeDeclaration();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(532); classDeclaration();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(533); enumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclarationContext extends ParserRuleContext {
		public List<ConstantDeclaratorContext> constantDeclarator() {
			return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
			return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_constDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536); type();
			setState(537); constantDeclarator();
			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(538); match(COMMA);
				setState(539); constantDeclarator();
				}
				}
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(545); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public ConstantDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_constantDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547); match(Identifier);
			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(548); match(LBRACK);
				setState(549); match(RBRACK);
				}
				}
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(555); match(ASSIGN);
			setState(556); variableInitializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public TypeContext type;
		public Token Identifier;
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				{
				setState(558); ((InterfaceMethodDeclarationContext)_localctx).type = type();
				}
				break;
			case VOID:
				{
				setState(559); match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(562); ((InterfaceMethodDeclarationContext)_localctx).Identifier = match(Identifier);
			 newMethod((((InterfaceMethodDeclarationContext)_localctx).type!=null?_input.getText(((InterfaceMethodDeclarationContext)_localctx).type.start,((InterfaceMethodDeclarationContext)_localctx).type.stop):null)==null ? null : (((InterfaceMethodDeclarationContext)_localctx).type!=null?_input.getText(((InterfaceMethodDeclarationContext)_localctx).type.start,((InterfaceMethodDeclarationContext)_localctx).type.stop):null), ((InterfaceMethodDeclarationContext)_localctx).Identifier.getText()); 
			setState(564); formalParameters();
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(565); match(LBRACK);
				setState(566); match(RBRACK);
				}
				}
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(574);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(572); match(THROWS);
				setState(573); qualifiedNameList();
				}
			}

			setState(576); match(SEMI);
			 endMethod(null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericInterfaceMethodDeclarationContext extends ParserRuleContext {
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public GenericInterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericInterfaceMethodDeclaration; }
	}

	public final GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() throws RecognitionException {
		GenericInterfaceMethodDeclarationContext _localctx = new GenericInterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_genericInterfaceMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579); typeParameters();
			setState(580); interfaceMethodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582); variableDeclarator();
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(583); match(COMMA);
				setState(584); variableDeclarator();
				}
				}
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590); variableDeclaratorId();
			setState(593);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(591); match(ASSIGN);
				setState(592); variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595); match(Identifier);
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(596); match(LBRACK);
				setState(597); match(RBRACK);
				}
				}
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_variableInitializer);
		try {
			setState(605);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(603); arrayInitializer();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(604); expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(607); match(LBRACE);
			setState(619);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)))) != 0)) {
				{
				setState(608); variableInitializer();
				setState(613);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(609); match(COMMA);
						setState(610); variableInitializer();
						}
						} 
					}
					setState(615);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				setState(617);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(616); match(COMMA);
					}
				}

				}
			}

			setState(621); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageOrTypeNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PackageOrTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageOrTypeName; }
	}

	public final PackageOrTypeNameContext packageOrTypeName() throws RecognitionException {
		PackageOrTypeNameContext _localctx = new PackageOrTypeNameContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_packageOrTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623); qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public EnumConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantName; }
	}

	public final EnumConstantNameContext enumConstantName() throws RecognitionException {
		EnumConstantNameContext _localctx = new EnumConstantNameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_enumConstantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627); qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		try {
			int _alt;
			setState(645);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(629); classOrInterfaceType();
				setState(634);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(630); match(LBRACK);
						setState(631); match(RBRACK);
						}
						} 
					}
					setState(636);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(637); primitiveType();
				setState(642);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(638); match(LBRACK);
						setState(639); match(RBRACK);
						}
						} 
					}
					setState(644);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public TerminalNode Identifier(int i) {
			return getToken(JavaParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(JavaParser.Identifier); }
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(647); match(Identifier);
			setState(649);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(648); typeArguments();
				}
				break;
			}
			setState(658);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(651); match(DOT);
					setState(652); match(Identifier);
					setState(654);
					switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
					case 1:
						{
						setState(653); typeArguments();
						}
						break;
					}
					}
					} 
				}
				setState(660);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663); match(LT);
			setState(664); typeArgument();
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(665); match(COMMA);
				setState(666); typeArgument();
				}
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(672); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_typeArgument);
		int _la;
		try {
			setState(680);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(674); type();
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(675); match(QUESTION);
				setState(678);
				_la = _input.LA(1);
				if (_la==EXTENDS || _la==SUPER) {
					{
					setState(676);
					_la = _input.LA(1);
					if ( !(_la==EXTENDS || _la==SUPER) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(677); type();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameListContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682); qualifiedName();
			setState(687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(683); match(COMMA);
				setState(684); qualifiedName();
				}
				}
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690); match(LPAREN);
			setState(692);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT))) != 0) || _la==Identifier || _la==AT) {
				{
				setState(691); formalParameterList();
				}
			}

			setState(694); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(709);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(696); formalParameter();
				setState(701);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(697); match(COMMA);
						setState(698); formalParameter();
						}
						} 
					}
					setState(703);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				}
				setState(706);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(704); match(COMMA);
					setState(705); lastFormalParameter();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(708); lastFormalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public VariableModifierContext variableModifier;
		public TypeContext type;
		public VariableDeclaratorIdContext variableDeclaratorId;
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(711); ((FormalParameterContext)_localctx).variableModifier = variableModifier();
				}
				}
				setState(716);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(717); ((FormalParameterContext)_localctx).type = type();
			setState(718); ((FormalParameterContext)_localctx).variableDeclaratorId = variableDeclaratorId();
			 newParameter((((FormalParameterContext)_localctx).variableModifier!=null?_input.getText(((FormalParameterContext)_localctx).variableModifier.start,((FormalParameterContext)_localctx).variableModifier.stop):null), (((FormalParameterContext)_localctx).type!=null?_input.getText(((FormalParameterContext)_localctx).type.start,((FormalParameterContext)_localctx).type.stop):null), (((FormalParameterContext)_localctx).variableDeclaratorId!=null?_input.getText(((FormalParameterContext)_localctx).variableDeclaratorId.start,((FormalParameterContext)_localctx).variableDeclaratorId.stop):null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LastFormalParameterContext extends ParserRuleContext {
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_lastFormalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(721); variableModifier();
				}
				}
				setState(726);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(727); type();
			setState(728); match(ELLIPSIS);
			setState(729); variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 newBlock(); 
			setState(732); block();
			 endBlock(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_constructorBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public TerminalNode Identifier(int i) {
			return getToken(JavaParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(JavaParser.Identifier); }
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(737); match(Identifier);
			setState(742);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(738); match(DOT);
					setState(739); match(Identifier);
					}
					} 
				}
				setState(744);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode CharacterLiteral() { return getToken(JavaParser.CharacterLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(JavaParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(JavaParser.StringLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(JavaParser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(JavaParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairsContext elementValuePairs() {
			return getRuleContext(ElementValuePairsContext.class,0);
		}
		public AnnotationNameContext annotationName() {
			return getRuleContext(AnnotationNameContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747); match(AT);
			setState(748); annotationName();
			setState(755);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(749); match(LPAREN);
				setState(752);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(750); elementValuePairs();
					}
					break;

				case 2:
					{
					setState(751); elementValue();
					}
					break;
				}
				setState(754); match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public AnnotationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationName; }
	}

	public final AnnotationNameContext annotationName() throws RecognitionException {
		AnnotationNameContext _localctx = new AnnotationNameContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_annotationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757); ((AnnotationNameContext)_localctx).qualifiedName = qualifiedName();
			 annotationName((((AnnotationNameContext)_localctx).qualifiedName!=null?_input.getText(((AnnotationNameContext)_localctx).qualifiedName.start,((AnnotationNameContext)_localctx).qualifiedName.stop):null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairsContext extends ParserRuleContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public ElementValuePairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairs; }
	}

	public final ElementValuePairsContext elementValuePairs() throws RecognitionException {
		ElementValuePairsContext _localctx = new ElementValuePairsContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_elementValuePairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760); elementValuePair();
			setState(765);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(761); match(COMMA);
				setState(762); elementValuePair();
				}
				}
				setState(767);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768); match(Identifier);
			setState(769); match(ASSIGN);
			setState(770); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueContext extends ParserRuleContext {
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_elementValue);
		try {
			setState(775);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(772); expression(0);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(773); annotation();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(774); elementValueArrayInitializer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_elementValueArrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(777); match(LBRACE);
			setState(786);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				setState(778); elementValue();
				setState(783);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(779); match(COMMA);
						setState(780); elementValue();
						}
						} 
					}
					setState(785);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
				}
				}
			}

			setState(789);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(788); match(COMMA);
				}
			}

			setState(791); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public Token Identifier;
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_annotationTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793); match(AT);
			setState(794); match(INTERFACE);
			setState(795); ((AnnotationTypeDeclarationContext)_localctx).Identifier = match(Identifier);
			 annotationName(((AnnotationTypeDeclarationContext)_localctx).Identifier.getText()); 
			setState(797); annotationTypeBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public List<AnnotationTypeElementDeclarationContext> annotationTypeElementDeclaration() {
			return getRuleContexts(AnnotationTypeElementDeclarationContext.class);
		}
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration(int i) {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799); match(LBRACE);
			setState(803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NATIVE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SYNCHRONIZED) | (1L << TRANSIENT) | (1L << VOLATILE) | (1L << SEMI))) != 0) || _la==Identifier || _la==AT) {
				{
				{
				setState(800); annotationTypeElementDeclaration();
				}
				}
				setState(805);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(806); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public AnnotationTypeElementRestContext annotationTypeElementRest() {
			return getRuleContext(AnnotationTypeElementRestContext.class,0);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_annotationTypeElementDeclaration);
		try {
			int _alt;
			setState(816);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOLATILE:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(811);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(808); modifier();
						}
						} 
					}
					setState(813);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				}
				setState(814); annotationTypeElementRest();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(815); match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementRestContext extends ParserRuleContext {
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() {
			return getRuleContext(AnnotationMethodOrConstantRestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public AnnotationTypeElementRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementRest; }
	}

	public final AnnotationTypeElementRestContext annotationTypeElementRest() throws RecognitionException {
		AnnotationTypeElementRestContext _localctx = new AnnotationTypeElementRestContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_annotationTypeElementRest);
		try {
			setState(838);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(818); type();
				setState(819); annotationMethodOrConstantRest();
				setState(820); match(SEMI);
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(822); classDeclaration();
				setState(824);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(823); match(SEMI);
					}
					break;
				}
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(826); interfaceDeclaration();
				setState(828);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(827); match(SEMI);
					}
					break;
				}
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(830); enumDeclaration();
				setState(832);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(831); match(SEMI);
					}
					break;
				}
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(834); annotationTypeDeclaration();
				setState(836);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(835); match(SEMI);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationMethodOrConstantRestContext extends ParserRuleContext {
		public AnnotationConstantRestContext annotationConstantRest() {
			return getRuleContext(AnnotationConstantRestContext.class,0);
		}
		public AnnotationMethodRestContext annotationMethodRest() {
			return getRuleContext(AnnotationMethodRestContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodOrConstantRest; }
	}

	public final AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() throws RecognitionException {
		AnnotationMethodOrConstantRestContext _localctx = new AnnotationMethodOrConstantRestContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_annotationMethodOrConstantRest);
		try {
			setState(842);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(840); annotationMethodRest();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(841); annotationConstantRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationMethodRestContext extends ParserRuleContext {
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public AnnotationMethodRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodRest; }
	}

	public final AnnotationMethodRestContext annotationMethodRest() throws RecognitionException {
		AnnotationMethodRestContext _localctx = new AnnotationMethodRestContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_annotationMethodRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844); match(Identifier);
			setState(845); match(LPAREN);
			setState(846); match(RPAREN);
			setState(848);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(847); defaultValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationConstantRestContext extends ParserRuleContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
	}

	public final AnnotationConstantRestContext annotationConstantRest() throws RecognitionException {
		AnnotationConstantRestContext _localctx = new AnnotationConstantRestContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_annotationConstantRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850); variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultValueContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852); match(DEFAULT);
			setState(853); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(855); match(LBRACE);
			setState(859);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
				{
				{
				setState(856); blockStatement();
				}
				}
				setState(861);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(862); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement;
		public StatementContext statement;
		public TypeDeclarationContext typeDeclaration;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_blockStatement);
		try {
			setState(873);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(864); ((BlockStatementContext)_localctx).localVariableDeclarationStatement = localVariableDeclarationStatement();
				 newLocalVariableStatement((((BlockStatementContext)_localctx).localVariableDeclarationStatement!=null?_input.getText(((BlockStatementContext)_localctx).localVariableDeclarationStatement.start,((BlockStatementContext)_localctx).localVariableDeclarationStatement.stop):null)); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(867); ((BlockStatementContext)_localctx).statement = statement();
				 newStatement((((BlockStatementContext)_localctx).statement!=null?_input.getText(((BlockStatementContext)_localctx).statement.start,((BlockStatementContext)_localctx).statement.stop):null)); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(870); ((BlockStatementContext)_localctx).typeDeclaration = typeDeclaration();
				 newTypeDeclaration((((BlockStatementContext)_localctx).typeDeclaration!=null?_input.getText(((BlockStatementContext)_localctx).typeDeclaration.start,((BlockStatementContext)_localctx).typeDeclaration.stop):null)); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875); localVariableDeclaration();
			setState(876); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(878); variableModifier();
				}
				}
				setState(883);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(884); type();
			setState(885); variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ASSERT() { return getToken(JavaParser.ASSERT, 0); }
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(984);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(887); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(888); match(ASSERT);
				setState(889); expression(0);
				setState(892);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(890); match(COLON);
					setState(891); expression(0);
					}
				}

				setState(894); match(SEMI);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(896); match(IF);
				setState(897); parExpression();
				setState(898); statement();
				setState(901);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(899); match(ELSE);
					setState(900); statement();
					}
					break;
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(903); match(FOR);
				setState(904); match(LPAREN);
				setState(905); forControl();
				setState(906); match(RPAREN);
				setState(907); statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(909); match(WHILE);
				setState(910); parExpression();
				setState(911); statement();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(913); match(DO);
				setState(914); statement();
				setState(915); match(WHILE);
				setState(916); parExpression();
				setState(917); match(SEMI);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(919); match(TRY);
				setState(920); block();
				setState(926);
				switch (_input.LA(1)) {
				case CATCH:
					{
					setState(921); catches();
					setState(923);
					_la = _input.LA(1);
					if (_la==FINALLY) {
						{
						setState(922); finallyBlock();
						}
					}

					}
					break;
				case FINALLY:
					{
					setState(925); finallyBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(928); match(TRY);
				setState(929); resourceSpecification();
				setState(930); block();
				setState(932);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(931); catches();
					}
				}

				setState(935);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(934); finallyBlock();
					}
				}

				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(937); match(SWITCH);
				setState(938); parExpression();
				setState(939); match(LBRACE);
				setState(943);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(940); switchBlockStatementGroup();
						}
						} 
					}
					setState(945);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				}
				setState(949);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(946); switchLabel();
					}
					}
					setState(951);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(952); match(RBRACE);
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(954); match(SYNCHRONIZED);
				setState(955); parExpression();
				setState(956); block();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(958); match(RETURN);
				setState(960);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)))) != 0)) {
					{
					setState(959); expression(0);
					}
				}

				setState(962); match(SEMI);
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(963); match(THROW);
				setState(964); expression(0);
				setState(965); match(SEMI);
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(967); match(BREAK);
				setState(969);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(968); match(Identifier);
					}
				}

				setState(971); match(SEMI);
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(972); match(CONTINUE);
				setState(974);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(973); match(Identifier);
					}
				}

				setState(976); match(SEMI);
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(977); match(SEMI);
				}
				break;

			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(978); statementExpression();
				setState(979); match(SEMI);
				}
				break;

			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(981); match(Identifier);
				setState(982); match(COLON);
				setState(983); statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchesContext extends ParserRuleContext {
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catches; }
	}

	public final CatchesContext catches() throws RecognitionException {
		CatchesContext _localctx = new CatchesContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_catches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(986); catchClause();
				}
				}
				setState(989); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CATCH );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchClauseContext extends ParserRuleContext {
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991); match(CATCH);
			setState(992); match(LPAREN);
			setState(996);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(993); variableModifier();
				}
				}
				setState(998);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(999); catchType();
			setState(1000); match(Identifier);
			setState(1001); match(RPAREN);
			setState(1002); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchTypeContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004); qualifiedName();
			setState(1009);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1005); match(BITOR);
				setState(1006); qualifiedName();
				}
				}
				setState(1011);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinallyBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1012); match(FINALLY);
			setState(1013); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceSpecificationContext extends ParserRuleContext {
		public ResourcesContext resources() {
			return getRuleContext(ResourcesContext.class,0);
		}
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1015); match(LPAREN);
			setState(1016); resources();
			setState(1018);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1017); match(SEMI);
				}
			}

			setState(1020); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourcesContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public ResourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resources; }
	}

	public final ResourcesContext resources() throws RecognitionException {
		ResourcesContext _localctx = new ResourcesContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_resources);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1022); resource();
			setState(1027);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(1023); match(SEMI);
					setState(1024); resource();
					}
					} 
				}
				setState(1029);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceContext extends ParserRuleContext {
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1033);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1030); variableModifier();
				}
				}
				setState(1035);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1036); classOrInterfaceType();
			setState(1037); variableDeclaratorId();
			setState(1038); match(ASSIGN);
			setState(1039); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1041); switchLabel();
				}
				}
				setState(1044); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(1047); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1046); blockStatement();
				}
				}
				setState(1049); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << ASSERT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << BYTE) | (1L << CHAR) | (1L << CLASS) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << FINAL) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << INTERFACE) | (1L << LONG) | (1L << NEW) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << RETURN) | (1L << SHORT) | (1L << STATIC) | (1L << STRICTFP) | (1L << SUPER) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THIS) | (1L << THROW) | (1L << TRY) | (1L << VOID) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumConstantNameContext enumConstantName() {
			return getRuleContext(EnumConstantNameContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_switchLabel);
		try {
			setState(1061);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1051); match(CASE);
				setState(1052); constantExpression();
				setState(1053); match(COLON);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1055); match(CASE);
				setState(1056); enumConstantName();
				setState(1057); match(COLON);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1059); match(DEFAULT);
				setState(1060); match(COLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForControlContext extends ParserRuleContext {
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_forControl);
		int _la;
		try {
			setState(1075);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1063); enhancedForControl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FINAL) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)) | (1L << (AT - 68)))) != 0)) {
					{
					setState(1064); forInit();
					}
				}

				setState(1067); match(SEMI);
				setState(1069);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)))) != 0)) {
					{
					setState(1068); expression(0);
					}
				}

				setState(1071); match(SEMI);
				setState(1073);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)))) != 0)) {
					{
					setState(1072); forUpdate();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_forInit);
		try {
			setState(1079);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1077); localVariableDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1078); expressionList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForControlContext extends ParserRuleContext {
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_enhancedForControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1081); variableModifier();
				}
				}
				setState(1086);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1087); type();
			setState(1088); match(Identifier);
			setState(1089); match(COLON);
			setState(1090); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1092); expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094); match(LPAREN);
			setState(1095); expression(0);
			setState(1096); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1098); expression(0);
			setState(1103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1099); match(COMMA);
				setState(1100); expression(0);
				}
				}
				setState(1105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1106); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public CreatorContext creator;
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExplicitGenericInvocationContext explicitGenericInvocation() {
			return getRuleContext(ExplicitGenericInvocationContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public InnerCreatorContext innerCreator() {
			return getRuleContext(InnerCreatorContext.class,0);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 182;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1125);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				{
				setState(1111); match(LPAREN);
				setState(1112); type();
				setState(1113); match(RPAREN);
				setState(1114); expression(17);
				}
				break;

			case 2:
				{
				setState(1116);
				_la = _input.LA(1);
				if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (INC - 79)) | (1L << (DEC - 79)) | (1L << (ADD - 79)) | (1L << (SUB - 79)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1117); expression(15);
				}
				break;

			case 3:
				{
				setState(1118);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1119); expression(14);
				}
				break;

			case 4:
				{
				setState(1120); primary();
				}
				break;

			case 5:
				{
				setState(1121); match(NEW);
				setState(1122); ((ExpressionContext)_localctx).creator = creator();
				 creators.push("new " + (((ExpressionContext)_localctx).creator!=null?_input.getText(((ExpressionContext)_localctx).creator.start,((ExpressionContext)_localctx).creator.stop):null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1223);
					switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1127);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(1128);
						_la = _input.LA(1);
						if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (MUL - 83)) | (1L << (DIV - 83)) | (1L << (MOD - 83)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1129); expression(14);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1130);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(1131);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1132); expression(13);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1133);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(1141);
						switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
						case 1:
							{
							setState(1134); match(LT);
							setState(1135); match(LT);
							}
							break;

						case 2:
							{
							setState(1136); match(GT);
							setState(1137); match(GT);
							setState(1138); match(GT);
							}
							break;

						case 3:
							{
							setState(1139); match(GT);
							setState(1140); match(GT);
							}
							break;
						}
						setState(1143); expression(12);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1144);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(1145);
						_la = _input.LA(1);
						if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (GT - 67)) | (1L << (LT - 67)) | (1L << (LE - 67)) | (1L << (GE - 67)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1146); expression(11);
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1147);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(1148);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1149); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1150);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(1151); match(BITAND);
						setState(1152); expression(8);
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1153);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(1154); match(CARET);
						setState(1155); expression(7);
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1156);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(1157); match(BITOR);
						setState(1158); expression(6);
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1159);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(1160); match(AND);
						setState(1161); expression(5);
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1162);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(1163); match(OR);
						setState(1164); expression(4);
						}
						break;

					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1165);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(1178);
						switch (_input.LA(1)) {
						case ASSIGN:
							{
							setState(1166); match(ASSIGN);
							}
							break;
						case ADD_ASSIGN:
							{
							setState(1167); match(ADD_ASSIGN);
							}
							break;
						case SUB_ASSIGN:
							{
							setState(1168); match(SUB_ASSIGN);
							}
							break;
						case MUL_ASSIGN:
							{
							setState(1169); match(MUL_ASSIGN);
							}
							break;
						case DIV_ASSIGN:
							{
							setState(1170); match(DIV_ASSIGN);
							}
							break;
						case AND_ASSIGN:
							{
							setState(1171); match(AND_ASSIGN);
							}
							break;
						case OR_ASSIGN:
							{
							setState(1172); match(OR_ASSIGN);
							}
							break;
						case XOR_ASSIGN:
							{
							setState(1173); match(XOR_ASSIGN);
							}
							break;
						case RSHIFT_ASSIGN:
							{
							setState(1174); match(RSHIFT_ASSIGN);
							}
							break;
						case URSHIFT_ASSIGN:
							{
							setState(1175); match(URSHIFT_ASSIGN);
							}
							break;
						case LSHIFT_ASSIGN:
							{
							setState(1176); match(LSHIFT_ASSIGN);
							}
							break;
						case MOD_ASSIGN:
							{
							setState(1177); match(MOD_ASSIGN);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1180); expression(1);
						}
						break;

					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1181);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(1182); match(QUESTION);
						setState(1183); expression(0);
						setState(1184); match(COLON);
						setState(1185); expression(3);
						}
						break;

					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1187);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						setState(1188); match(DOT);
						setState(1189); match(Identifier);
						}
						break;

					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1190);
						if (!(24 >= _localctx._p)) throw new FailedPredicateException(this, "24 >= $_p");
						setState(1191); match(DOT);
						setState(1192); match(THIS);
						}
						break;

					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1193);
						if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
						setState(1194); match(DOT);
						setState(1195); match(NEW);
						setState(1197);
						_la = _input.LA(1);
						if (_la==LT) {
							{
							setState(1196); nonWildcardTypeArguments();
							}
						}

						setState(1199); innerCreator();
						}
						break;

					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1200);
						if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
						setState(1201); match(DOT);
						setState(1202); match(SUPER);
						setState(1203); superSuffix();
						}
						break;

					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1204);
						if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
						setState(1205); match(DOT);
						setState(1206); explicitGenericInvocation();
						}
						break;

					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1207);
						if (!(20 >= _localctx._p)) throw new FailedPredicateException(this, "20 >= $_p");
						setState(1208); match(LBRACK);
						setState(1209); expression(0);
						setState(1210); match(RBRACK);
						}
						break;

					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1212);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(1213); match(LPAREN);
						setState(1215);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)))) != 0)) {
							{
							setState(1214); expressionList();
							}
						}

						setState(1217); match(RPAREN);
						}
						break;

					case 20:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1218);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(1219);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;

					case 21:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1220);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(1221); match(INSTANCEOF);
						setState(1222); type();
						}
						break;
					}
					} 
				}
				setState(1227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_primary);
		try {
			setState(1249);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1228); match(LPAREN);
				setState(1229); expression(0);
				setState(1230); match(RPAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1232); match(THIS);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1233); match(SUPER);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1234); literal();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1235); match(Identifier);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1236); type();
				setState(1237); match(DOT);
				setState(1238); match(CLASS);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1240); match(VOID);
				setState(1241); match(DOT);
				setState(1242); match(CLASS);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1243); nonWildcardTypeArguments();
				setState(1247);
				switch (_input.LA(1)) {
				case SUPER:
				case Identifier:
					{
					setState(1244); explicitGenericInvocationSuffix();
					}
					break;
				case THIS:
					{
					setState(1245); match(THIS);
					setState(1246); arguments();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_creator);
		try {
			setState(1260);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1251); nonWildcardTypeArguments();
				setState(1252); createdName();
				setState(1253); classCreatorRest();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1255); createdName();
				setState(1258);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					setState(1256); arrayCreatorRest();
					}
					break;
				case LPAREN:
					{
					setState(1257); classCreatorRest();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatedNameContext extends ParserRuleContext {
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond(int i) {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,i);
		}
		public TerminalNode Identifier(int i) {
			return getToken(JavaParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(JavaParser.Identifier); }
		public List<TypeArgumentsOrDiamondContext> typeArgumentsOrDiamond() {
			return getRuleContexts(TypeArgumentsOrDiamondContext.class);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_createdName);
		int _la;
		try {
			setState(1277);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1262); match(Identifier);
				setState(1264);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1263); typeArgumentsOrDiamond();
					}
				}

				setState(1273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(1266); match(DOT);
					setState(1267); match(Identifier);
					setState(1269);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1268); typeArgumentsOrDiamond();
						}
					}

					}
					}
					setState(1275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1276); primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnerCreatorContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() {
			return getRuleContext(NonWildcardTypeArgumentsOrDiamondContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public InnerCreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerCreator; }
	}

	public final InnerCreatorContext innerCreator() throws RecognitionException {
		InnerCreatorContext _localctx = new InnerCreatorContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_innerCreator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1279); match(Identifier);
			setState(1281);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1280); nonWildcardTypeArgumentsOrDiamond();
				}
			}

			setState(1283); classCreatorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1285); match(LBRACK);
			setState(1313);
			switch (_input.LA(1)) {
			case RBRACK:
				{
				setState(1286); match(RBRACK);
				setState(1291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1287); match(LBRACK);
					setState(1288); match(RBRACK);
					}
					}
					setState(1293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1294); arrayInitializer();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
				{
				setState(1295); expression(0);
				setState(1296); match(RBRACK);
				setState(1303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(1297); match(LBRACK);
						setState(1298); expression(0);
						setState(1299); match(RBRACK);
						}
						} 
					}
					setState(1305);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
				}
				setState(1310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(1306); match(LBRACK);
						setState(1307); match(RBRACK);
						}
						} 
					}
					setState(1312);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1315); arguments();
			setState(1317);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1316); classBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitGenericInvocationContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1319); nonWildcardTypeArguments();
			setState(1320); explicitGenericInvocationSuffix();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonWildcardTypeArgumentsContext extends ParserRuleContext {
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public NonWildcardTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1322); match(LT);
			setState(1323); typeList();
			setState(1324); match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_typeArgumentsOrDiamond);
		try {
			setState(1329);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1326); match(LT);
				setState(1327); match(GT);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1328); typeArguments();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonWildcardTypeArgumentsOrDiamondContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public NonWildcardTypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArgumentsOrDiamond; }
	}

	public final NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() throws RecognitionException {
		NonWildcardTypeArgumentsOrDiamondContext _localctx = new NonWildcardTypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_nonWildcardTypeArgumentsOrDiamond);
		try {
			setState(1334);
			switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1331); match(LT);
				setState(1332); match(GT);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1333); nonWildcardTypeArguments();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperSuffixContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public SuperSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superSuffix; }
	}

	public final SuperSuffixContext superSuffix() throws RecognitionException {
		SuperSuffixContext _localctx = new SuperSuffixContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_superSuffix);
		try {
			setState(1342);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1336); arguments();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1337); match(DOT);
				setState(1338); match(Identifier);
				setState(1340);
				switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
				case 1:
					{
					setState(1339); arguments();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitGenericInvocationSuffixContext extends ParserRuleContext {
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JavaParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocationSuffix; }
	}

	public final ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() throws RecognitionException {
		ExplicitGenericInvocationSuffixContext _localctx = new ExplicitGenericInvocationSuffixContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_explicitGenericInvocationSuffix);
		try {
			setState(1348);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1344); match(SUPER);
				setState(1345); superSuffix();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1346); match(Identifier);
				setState(1347); arguments();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1350); match(LPAREN);
			setState(1352);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << NEW) | (1L << SHORT) | (1L << SUPER) | (1L << THIS) | (1L << VOID) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LPAREN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LT - 68)) | (1L << (BANG - 68)) | (1L << (TILDE - 68)) | (1L << (INC - 68)) | (1L << (DEC - 68)) | (1L << (ADD - 68)) | (1L << (SUB - 68)) | (1L << (Identifier - 68)))) != 0)) {
				{
				setState(1351); expressionList();
				}
			}

			setState(1354); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 91: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 13 >= _localctx._p;

		case 1: return 12 >= _localctx._p;

		case 2: return 11 >= _localctx._p;

		case 3: return 10 >= _localctx._p;

		case 4: return 8 >= _localctx._p;

		case 5: return 7 >= _localctx._p;

		case 6: return 6 >= _localctx._p;

		case 7: return 5 >= _localctx._p;

		case 8: return 4 >= _localctx._p;

		case 9: return 3 >= _localctx._p;

		case 10: return 1 >= _localctx._p;

		case 11: return 2 >= _localctx._p;

		case 12: return 25 >= _localctx._p;

		case 13: return 24 >= _localctx._p;

		case 14: return 23 >= _localctx._p;

		case 15: return 22 >= _localctx._p;

		case 17: return 20 >= _localctx._p;

		case 16: return 21 >= _localctx._p;

		case 19: return 16 >= _localctx._p;

		case 18: return 19 >= _localctx._p;

		case 20: return 9 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3k\u054f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\3\2\5"+
		"\2\u00d6\n\2\3\2\7\2\u00d9\n\2\f\2\16\2\u00dc\13\2\3\2\7\2\u00df\n\2\f"+
		"\2\16\2\u00e2\13\2\3\2\3\2\3\2\3\3\3\3\7\3\u00e9\n\3\f\3\16\3\u00ec\13"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\5\4\u00f5\n\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\5\5\u00fe\n\5\3\6\7\6\u0101\n\6\f\6\16\6\u0104\13\6\3\6\3\6\3\6\3\6"+
		"\7\6\u010a\n\6\f\6\16\6\u010d\13\6\3\6\3\6\3\6\3\6\7\6\u0113\n\6\f\6\16"+
		"\6\u0116\13\6\3\6\3\6\3\6\3\6\7\6\u011c\n\6\f\6\16\6\u011f\13\6\3\6\3"+
		"\6\3\6\3\6\5\6\u0125\n\6\3\7\3\7\5\7\u0129\n\7\3\b\3\b\3\b\5\b\u012e\n"+
		"\b\3\t\3\t\5\t\u0132\n\t\3\n\3\n\3\n\3\n\5\n\u0138\n\n\3\n\3\n\3\n\3\n"+
		"\5\n\u013e\n\n\3\n\3\n\5\n\u0142\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\7\13\u014c\n\13\f\13\16\13\u014f\13\13\3\13\3\13\3\f\3\f\3\f\5\f\u0156"+
		"\n\f\3\r\3\r\3\r\7\r\u015b\n\r\f\r\16\r\u015e\13\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u0167\n\16\3\16\3\16\5\16\u016b\n\16\3\16\5\16\u016e"+
		"\n\16\3\16\5\16\u0171\n\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u0179\n"+
		"\17\f\17\16\17\u017c\13\17\3\20\7\20\u017f\n\20\f\20\16\20\u0182\13\20"+
		"\3\20\3\20\3\20\5\20\u0187\n\20\3\20\5\20\u018a\n\20\3\21\3\21\7\21\u018e"+
		"\n\21\f\21\16\21\u0191\13\21\3\22\3\22\3\22\3\22\5\22\u0197\n\22\3\22"+
		"\3\22\3\22\3\22\5\22\u019d\n\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u01a5"+
		"\n\23\f\23\16\23\u01a8\13\23\3\24\3\24\7\24\u01ac\n\24\f\24\16\24\u01af"+
		"\13\24\3\24\3\24\3\25\3\25\7\25\u01b5\n\25\f\25\16\25\u01b8\13\25\3\25"+
		"\3\25\3\26\3\26\5\26\u01be\n\26\3\26\3\26\7\26\u01c2\n\26\f\26\16\26\u01c5"+
		"\13\26\3\26\3\26\3\26\3\26\5\26\u01cb\n\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01d9\n\27\3\30\3\30\5\30\u01dd"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\7\30\u01e4\n\30\f\30\16\30\u01e7\13\30"+
		"\3\30\3\30\5\30\u01eb\n\30\3\30\3\30\5\30\u01ef\n\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u01fb\n\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\7\35\u0209\n\35\f\35\16\35\u020c"+
		"\13\35\3\35\3\35\5\35\u0210\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5"+
		"\36\u0219\n\36\3\37\3\37\3\37\3\37\7\37\u021f\n\37\f\37\16\37\u0222\13"+
		"\37\3\37\3\37\3 \3 \3 \7 \u0229\n \f \16 \u022c\13 \3 \3 \3 \3!\3!\5!"+
		"\u0233\n!\3!\3!\3!\3!\3!\7!\u023a\n!\f!\16!\u023d\13!\3!\3!\5!\u0241\n"+
		"!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\7#\u024c\n#\f#\16#\u024f\13#\3$\3$\3$"+
		"\5$\u0254\n$\3%\3%\3%\7%\u0259\n%\f%\16%\u025c\13%\3&\3&\5&\u0260\n&\3"+
		"\'\3\'\3\'\3\'\7\'\u0266\n\'\f\'\16\'\u0269\13\'\3\'\5\'\u026c\n\'\5\'"+
		"\u026e\n\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\7+\u027b\n+\f+\16+\u027e"+
		"\13+\3+\3+\3+\7+\u0283\n+\f+\16+\u0286\13+\5+\u0288\n+\3,\3,\5,\u028c"+
		"\n,\3,\3,\3,\5,\u0291\n,\7,\u0293\n,\f,\16,\u0296\13,\3-\3-\3.\3.\3.\3"+
		".\7.\u029e\n.\f.\16.\u02a1\13.\3.\3.\3/\3/\3/\3/\5/\u02a9\n/\5/\u02ab"+
		"\n/\3\60\3\60\3\60\7\60\u02b0\n\60\f\60\16\60\u02b3\13\60\3\61\3\61\5"+
		"\61\u02b7\n\61\3\61\3\61\3\62\3\62\3\62\7\62\u02be\n\62\f\62\16\62\u02c1"+
		"\13\62\3\62\3\62\5\62\u02c5\n\62\3\62\5\62\u02c8\n\62\3\63\7\63\u02cb"+
		"\n\63\f\63\16\63\u02ce\13\63\3\63\3\63\3\63\3\63\3\64\7\64\u02d5\n\64"+
		"\f\64\16\64\u02d8\13\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3"+
		"\66\3\67\3\67\3\67\7\67\u02e7\n\67\f\67\16\67\u02ea\13\67\38\38\39\39"+
		"\39\39\39\59\u02f3\n9\39\59\u02f6\n9\3:\3:\3:\3;\3;\3;\7;\u02fe\n;\f;"+
		"\16;\u0301\13;\3<\3<\3<\3<\3=\3=\3=\5=\u030a\n=\3>\3>\3>\3>\7>\u0310\n"+
		">\f>\16>\u0313\13>\5>\u0315\n>\3>\5>\u0318\n>\3>\3>\3?\3?\3?\3?\3?\3?"+
		"\3@\3@\7@\u0324\n@\f@\16@\u0327\13@\3@\3@\3A\7A\u032c\nA\fA\16A\u032f"+
		"\13A\3A\3A\5A\u0333\nA\3B\3B\3B\3B\3B\3B\5B\u033b\nB\3B\3B\5B\u033f\n"+
		"B\3B\3B\5B\u0343\nB\3B\3B\5B\u0347\nB\5B\u0349\nB\3C\3C\5C\u034d\nC\3"+
		"D\3D\3D\3D\5D\u0353\nD\3E\3E\3F\3F\3F\3G\3G\7G\u035c\nG\fG\16G\u035f\13"+
		"G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u036c\nH\3I\3I\3I\3J\7J\u0372\n"+
		"J\fJ\16J\u0375\13J\3J\3J\3J\3K\3K\3K\3K\3K\5K\u037f\nK\3K\3K\3K\3K\3K"+
		"\3K\3K\5K\u0388\nK\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K"+
		"\3K\3K\3K\5K\u039e\nK\3K\5K\u03a1\nK\3K\3K\3K\3K\5K\u03a7\nK\3K\5K\u03aa"+
		"\nK\3K\3K\3K\3K\7K\u03b0\nK\fK\16K\u03b3\13K\3K\7K\u03b6\nK\fK\16K\u03b9"+
		"\13K\3K\3K\3K\3K\3K\3K\3K\3K\5K\u03c3\nK\3K\3K\3K\3K\3K\3K\3K\5K\u03cc"+
		"\nK\3K\3K\3K\5K\u03d1\nK\3K\3K\3K\3K\3K\3K\3K\3K\5K\u03db\nK\3L\6L\u03de"+
		"\nL\rL\16L\u03df\3M\3M\3M\7M\u03e5\nM\fM\16M\u03e8\13M\3M\3M\3M\3M\3M"+
		"\3N\3N\3N\7N\u03f2\nN\fN\16N\u03f5\13N\3O\3O\3O\3P\3P\3P\5P\u03fd\nP\3"+
		"P\3P\3Q\3Q\3Q\7Q\u0404\nQ\fQ\16Q\u0407\13Q\3R\7R\u040a\nR\fR\16R\u040d"+
		"\13R\3R\3R\3R\3R\3R\3S\6S\u0415\nS\rS\16S\u0416\3S\6S\u041a\nS\rS\16S"+
		"\u041b\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\5T\u0428\nT\3U\3U\5U\u042c\nU\3U"+
		"\3U\5U\u0430\nU\3U\3U\5U\u0434\nU\5U\u0436\nU\3V\3V\5V\u043a\nV\3W\7W"+
		"\u043d\nW\fW\16W\u0440\13W\3W\3W\3W\3W\3W\3X\3X\3Y\3Y\3Y\3Y\3Z\3Z\3Z\7"+
		"Z\u0450\nZ\fZ\16Z\u0453\13Z\3[\3[\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\5]\u0468\n]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3"+
		"]\5]\u0478\n]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u049d\n]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04b0\n]\3]\3]\3]\3]\3"+
		"]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04c2\n]\3]\3]\3]\3]\3]\3]\7]\u04ca"+
		"\n]\f]\16]\u04cd\13]\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3"+
		"^\3^\3^\5^\u04e2\n^\5^\u04e4\n^\3_\3_\3_\3_\3_\3_\3_\5_\u04ed\n_\5_\u04ef"+
		"\n_\3`\3`\5`\u04f3\n`\3`\3`\3`\5`\u04f8\n`\7`\u04fa\n`\f`\16`\u04fd\13"+
		"`\3`\5`\u0500\n`\3a\3a\5a\u0504\na\3a\3a\3b\3b\3b\3b\7b\u050c\nb\fb\16"+
		"b\u050f\13b\3b\3b\3b\3b\3b\3b\3b\7b\u0518\nb\fb\16b\u051b\13b\3b\3b\7"+
		"b\u051f\nb\fb\16b\u0522\13b\5b\u0524\nb\3c\3c\5c\u0528\nc\3d\3d\3d\3e"+
		"\3e\3e\3e\3f\3f\3f\5f\u0534\nf\3g\3g\3g\5g\u0539\ng\3h\3h\3h\3h\5h\u053f"+
		"\nh\5h\u0541\nh\3i\3i\3i\3i\5i\u0547\ni\3j\3j\5j\u054b\nj\3j\3j\3j\2k"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc"+
		"\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\2\16"+
		"\6\2  ,,\60\60\63\63\6\2\3\3\24\24#%()\n\2\5\5\7\7\n\n\20\20\26\26\35"+
		"\35\37\37\'\'\4\2\23\23**\3\2\65:\3\2QT\3\2GH\4\2UVZZ\3\2ST\4\2EFLM\4"+
		"\2KKNN\3\2QR\u05c8\2\u00d5\3\2\2\2\4\u00e6\3\2\2\2\6\u00f2\3\2\2\2\b\u00fd"+
		"\3\2\2\2\n\u0124\3\2\2\2\f\u0128\3\2\2\2\16\u012d\3\2\2\2\20\u0131\3\2"+
		"\2\2\22\u0133\3\2\2\2\24\u0147\3\2\2\2\26\u0152\3\2\2\2\30\u0157\3\2\2"+
		"\2\32\u015f\3\2\2\2\34\u0175\3\2\2\2\36\u0180\3\2\2\2 \u018b\3\2\2\2\""+
		"\u0192\3\2\2\2$\u01a1\3\2\2\2&\u01a9\3\2\2\2(\u01b2\3\2\2\2*\u01ca\3\2"+
		"\2\2,\u01d8\3\2\2\2.\u01dc\3\2\2\2\60\u01f2\3\2\2\2\62\u01f5\3\2\2\2\64"+
		"\u01ff\3\2\2\2\66\u0202\3\2\2\28\u020f\3\2\2\2:\u0218\3\2\2\2<\u021a\3"+
		"\2\2\2>\u0225\3\2\2\2@\u0232\3\2\2\2B\u0245\3\2\2\2D\u0248\3\2\2\2F\u0250"+
		"\3\2\2\2H\u0255\3\2\2\2J\u025f\3\2\2\2L\u0261\3\2\2\2N\u0271\3\2\2\2P"+
		"\u0273\3\2\2\2R\u0275\3\2\2\2T\u0287\3\2\2\2V\u0289\3\2\2\2X\u0297\3\2"+
		"\2\2Z\u0299\3\2\2\2\\\u02aa\3\2\2\2^\u02ac\3\2\2\2`\u02b4\3\2\2\2b\u02c7"+
		"\3\2\2\2d\u02cc\3\2\2\2f\u02d6\3\2\2\2h\u02dd\3\2\2\2j\u02e1\3\2\2\2l"+
		"\u02e3\3\2\2\2n\u02eb\3\2\2\2p\u02ed\3\2\2\2r\u02f7\3\2\2\2t\u02fa\3\2"+
		"\2\2v\u0302\3\2\2\2x\u0309\3\2\2\2z\u030b\3\2\2\2|\u031b\3\2\2\2~\u0321"+
		"\3\2\2\2\u0080\u0332\3\2\2\2\u0082\u0348\3\2\2\2\u0084\u034c\3\2\2\2\u0086"+
		"\u034e\3\2\2\2\u0088\u0354\3\2\2\2\u008a\u0356\3\2\2\2\u008c\u0359\3\2"+
		"\2\2\u008e\u036b\3\2\2\2\u0090\u036d\3\2\2\2\u0092\u0373\3\2\2\2\u0094"+
		"\u03da\3\2\2\2\u0096\u03dd\3\2\2\2\u0098\u03e1\3\2\2\2\u009a\u03ee\3\2"+
		"\2\2\u009c\u03f6\3\2\2\2\u009e\u03f9\3\2\2\2\u00a0\u0400\3\2\2\2\u00a2"+
		"\u040b\3\2\2\2\u00a4\u0414\3\2\2\2\u00a6\u0427\3\2\2\2\u00a8\u0435\3\2"+
		"\2\2\u00aa\u0439\3\2\2\2\u00ac\u043e\3\2\2\2\u00ae\u0446\3\2\2\2\u00b0"+
		"\u0448\3\2\2\2\u00b2\u044c\3\2\2\2\u00b4\u0454\3\2\2\2\u00b6\u0456\3\2"+
		"\2\2\u00b8\u0467\3\2\2\2\u00ba\u04e3\3\2\2\2\u00bc\u04ee\3\2\2\2\u00be"+
		"\u04ff\3\2\2\2\u00c0\u0501\3\2\2\2\u00c2\u0507\3\2\2\2\u00c4\u0525\3\2"+
		"\2\2\u00c6\u0529\3\2\2\2\u00c8\u052c\3\2\2\2\u00ca\u0533\3\2\2\2\u00cc"+
		"\u0538\3\2\2\2\u00ce\u0540\3\2\2\2\u00d0\u0546\3\2\2\2\u00d2\u0548\3\2"+
		"\2\2\u00d4\u00d6\5\4\3\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00da\3\2\2\2\u00d7\u00d9\5\6\4\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00e0\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00df\5\n\6\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00e4\b\2\1\2\u00e4\u00e5\7\2\2\3\u00e5\3\3\2\2\2"+
		"\u00e6\u00ea\b\3\1\2\u00e7\u00e9\5p9\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ed\u00ee\7\"\2\2\u00ee\u00ef\5l\67\2\u00ef\u00f0\b\3"+
		"\1\2\u00f0\u00f1\7A\2\2\u00f1\5\3\2\2\2\u00f2\u00f4\7\33\2\2\u00f3\u00f5"+
		"\7(\2\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\5l\67\2\u00f7\u00f8\5\b\5\2\u00f8\u00f9\b\4\1\2\u00f9\u00fa\7A"+
		"\2\2\u00fa\7\3\2\2\2\u00fb\u00fc\7C\2\2\u00fc\u00fe\7U\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\t\3\2\2\2\u00ff\u0101\5\16\b\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\5\22\n\2\u0106"+
		"\u0107\b\6\1\2\u0107\u0125\3\2\2\2\u0108\u010a\5\16\b\2\u0109\u0108\3"+
		"\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\5\32\16\2\u010f\u0110\b"+
		"\6\1\2\u0110\u0125\3\2\2\2\u0111\u0113\5\16\b\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0117\u0118\5\"\22\2\u0118\u0119\b\6\1\2\u0119"+
		"\u0125\3\2\2\2\u011a\u011c\5\16\b\2\u011b\u011a\3\2\2\2\u011c\u011f\3"+
		"\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0121\5|?\2\u0121\u0122\b\6\1\2\u0122\u0125\3\2\2"+
		"\2\u0123\u0125\7A\2\2\u0124\u0102\3\2\2\2\u0124\u010b\3\2\2\2\u0124\u0114"+
		"\3\2\2\2\u0124\u011d\3\2\2\2\u0124\u0123\3\2\2\2\u0125\13\3\2\2\2\u0126"+
		"\u0129\5\16\b\2\u0127\u0129\t\2\2\2\u0128\u0126\3\2\2\2\u0128\u0127\3"+
		"\2\2\2\u0129\r\3\2\2\2\u012a\u012e\5p9\2\u012b\u012c\t\3\2\2\u012c\u012e"+
		"\b\b\1\2\u012d\u012a\3\2\2\2\u012d\u012b\3\2\2\2\u012e\17\3\2\2\2\u012f"+
		"\u0132\7\24\2\2\u0130\u0132\5p9\2\u0131\u012f\3\2\2\2\u0131\u0130\3\2"+
		"\2\2\u0132\21\3\2\2\2\u0133\u0134\7\13\2\2\u0134\u0135\7f\2\2\u0135\u0137"+
		"\b\n\1\2\u0136\u0138\5\24\13\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2"+
		"\u0138\u013d\3\2\2\2\u0139\u013a\7\23\2\2\u013a\u013b\5T+\2\u013b\u013c"+
		"\b\n\1\2\u013c\u013e\3\2\2\2\u013d\u0139\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0141\3\2\2\2\u013f\u0140\7\32\2\2\u0140\u0142\5$\23\2\u0141\u013f\3"+
		"\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\b\n\1\2\u0144"+
		"\u0145\5&\24\2\u0145\u0146\b\n\1\2\u0146\23\3\2\2\2\u0147\u0148\7F\2\2"+
		"\u0148\u014d\5\26\f\2\u0149\u014a\7B\2\2\u014a\u014c\5\26\f\2\u014b\u0149"+
		"\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u0150\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\7E\2\2\u0151\25\3\2\2\2"+
		"\u0152\u0155\7f\2\2\u0153\u0154\7\23\2\2\u0154\u0156\5\30\r\2\u0155\u0153"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\27\3\2\2\2\u0157\u015c\5T+\2\u0158"+
		"\u0159\7W\2\2\u0159\u015b\5T+\2\u015a\u0158\3\2\2\2\u015b\u015e\3\2\2"+
		"\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\31\3\2\2\2\u015e\u015c"+
		"\3\2\2\2\u015f\u0160\7\22\2\2\u0160\u0161\7f\2\2\u0161\u0166\b\16\1\2"+
		"\u0162\u0163\7\32\2\2\u0163\u0164\5$\23\2\u0164\u0165\b\16\1\2\u0165\u0167"+
		"\3\2\2\2\u0166\u0162\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u016a\7=\2\2\u0169\u016b\5\34\17\2\u016a\u0169\3\2\2\2\u016a\u016b\3"+
		"\2\2\2\u016b\u016d\3\2\2\2\u016c\u016e\7B\2\2\u016d\u016c\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u0171\5 \21\2\u0170\u016f\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\7>\2\2\u0173"+
		"\u0174\b\16\1\2\u0174\33\3\2\2\2\u0175\u017a\5\36\20\2\u0176\u0177\7B"+
		"\2\2\u0177\u0179\5\36\20\2\u0178\u0176\3\2\2\2\u0179\u017c\3\2\2\2\u017a"+
		"\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\35\3\2\2\2\u017c\u017a\3\2\2"+
		"\2\u017d\u017f\5p9\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e"+
		"\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0180\3\2\2\2\u0183"+
		"\u0184\7f\2\2\u0184\u0186\b\20\1\2\u0185\u0187\5\u00d2j\2\u0186\u0185"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u018a\5&\24\2\u0189"+
		"\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\37\3\2\2\2\u018b\u018f\7A\2\2"+
		"\u018c\u018e\5*\26\2\u018d\u018c\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d"+
		"\3\2\2\2\u018f\u0190\3\2\2\2\u0190!\3\2\2\2\u0191\u018f\3\2\2\2\u0192"+
		"\u0193\7\36\2\2\u0193\u0194\7f\2\2\u0194\u0196\b\22\1\2\u0195\u0197\5"+
		"\24\13\2\u0196\u0195\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u019c\3\2\2\2\u0198"+
		"\u0199\7\23\2\2\u0199\u019a\5$\23\2\u019a\u019b\b\22\1\2\u019b\u019d\3"+
		"\2\2\2\u019c\u0198\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u019f\5(\25\2\u019f\u01a0\b\22\1\2\u01a0#\3\2\2\2\u01a1\u01a6\5T+\2\u01a2"+
		"\u01a3\7B\2\2\u01a3\u01a5\5T+\2\u01a4\u01a2\3\2\2\2\u01a5\u01a8\3\2\2"+
		"\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7%\3\2\2\2\u01a8\u01a6"+
		"\3\2\2\2\u01a9\u01ad\7=\2\2\u01aa\u01ac\5*\26\2\u01ab\u01aa\3\2\2\2\u01ac"+
		"\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\3\2"+
		"\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\7>\2\2\u01b1\'\3\2\2\2\u01b2\u01b6"+
		"\7=\2\2\u01b3\u01b5\58\35\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b9\u01ba\7>\2\2\u01ba)\3\2\2\2\u01bb\u01cb\7A\2\2\u01bc\u01be"+
		"\7(\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01cb\5\u008cG\2\u01c0\u01c2\5\f\7\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c6\u01c7\b\26\1\2\u01c7\u01c8\5,\27\2\u01c8\u01c9\b"+
		"\26\1\2\u01c9\u01cb\3\2\2\2\u01ca\u01bb\3\2\2\2\u01ca\u01bd\3\2\2\2\u01ca"+
		"\u01c3\3\2\2\2\u01cb+\3\2\2\2\u01cc\u01d9\5.\30\2\u01cd\u01d9\5\60\31"+
		"\2\u01ce\u01cf\b\27\1\2\u01cf\u01d0\5\66\34\2\u01d0\u01d1\b\27\1\2\u01d1"+
		"\u01d9\3\2\2\2\u01d2\u01d9\5\62\32\2\u01d3\u01d9\5\64\33\2\u01d4\u01d9"+
		"\5\"\22\2\u01d5\u01d9\5|?\2\u01d6\u01d9\5\22\n\2\u01d7\u01d9\5\32\16\2"+
		"\u01d8\u01cc\3\2\2\2\u01d8\u01cd\3\2\2\2\u01d8\u01ce\3\2\2\2\u01d8\u01d2"+
		"\3\2\2\2\u01d8\u01d3\3\2\2\2\u01d8\u01d4\3\2\2\2\u01d8\u01d5\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9-\3\2\2\2\u01da\u01dd\5T+\2\u01db"+
		"\u01dd\7\62\2\2\u01dc\u01da\3\2\2\2\u01dc\u01db\3\2\2\2\u01dd\u01de\3"+
		"\2\2\2\u01de\u01df\7f\2\2\u01df\u01e0\b\30\1\2\u01e0\u01e5\5`\61\2\u01e1"+
		"\u01e2\7?\2\2\u01e2\u01e4\7@\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e7\3\2\2"+
		"\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01ea\3\2\2\2\u01e7\u01e5"+
		"\3\2\2\2\u01e8\u01e9\7/\2\2\u01e9\u01eb\5^\60\2\u01ea\u01e8\3\2\2\2\u01ea"+
		"\u01eb\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ef\5h\65\2\u01ed\u01ef\7A"+
		"\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f1\b\30\1\2\u01f1/\3\2\2\2\u01f2\u01f3\5\24\13\2\u01f3\u01f4\5.\30"+
		"\2\u01f4\61\3\2\2\2\u01f5\u01f6\7f\2\2\u01f6\u01f7\b\32\1\2\u01f7\u01fa"+
		"\5`\61\2\u01f8\u01f9\7/\2\2\u01f9\u01fb\5^\60\2\u01fa\u01f8\3\2\2\2\u01fa"+
		"\u01fb\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\5j\66\2\u01fd\u01fe\b\32"+
		"\1\2\u01fe\63\3\2\2\2\u01ff\u0200\5\24\13\2\u0200\u0201\5\62\32\2\u0201"+
		"\65\3\2\2\2\u0202\u0203\5T+\2\u0203\u0204\5D#\2\u0204\u0205\b\34\1\2\u0205"+
		"\u0206\7A\2\2\u0206\67\3\2\2\2\u0207\u0209\5\f\7\2\u0208\u0207\3\2\2\2"+
		"\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d"+
		"\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u0210\5:\36\2\u020e\u0210\7A\2\2\u020f"+
		"\u020a\3\2\2\2\u020f\u020e\3\2\2\2\u02109\3\2\2\2\u0211\u0219\5<\37\2"+
		"\u0212\u0219\5@!\2\u0213\u0219\5B\"\2\u0214\u0219\5\"\22\2\u0215\u0219"+
		"\5|?\2\u0216\u0219\5\22\n\2\u0217\u0219\5\32\16\2\u0218\u0211\3\2\2\2"+
		"\u0218\u0212\3\2\2\2\u0218\u0213\3\2\2\2\u0218\u0214\3\2\2\2\u0218\u0215"+
		"\3\2\2\2\u0218\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219;\3\2\2\2\u021a"+
		"\u021b\5T+\2\u021b\u0220\5> \2\u021c\u021d\7B\2\2\u021d\u021f\5> \2\u021e"+
		"\u021c\3\2\2\2\u021f\u0222\3\2\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2"+
		"\2\2\u0221\u0223\3\2\2\2\u0222\u0220\3\2\2\2\u0223\u0224\7A\2\2\u0224"+
		"=\3\2\2\2\u0225\u022a\7f\2\2\u0226\u0227\7?\2\2\u0227\u0229\7@\2\2\u0228"+
		"\u0226\3\2\2\2\u0229\u022c\3\2\2\2\u022a\u0228\3\2\2\2\u022a\u022b\3\2"+
		"\2\2\u022b\u022d\3\2\2\2\u022c\u022a\3\2\2\2\u022d\u022e\7D\2\2\u022e"+
		"\u022f\5J&\2\u022f?\3\2\2\2\u0230\u0233\5T+\2\u0231\u0233\7\62\2\2\u0232"+
		"\u0230\3\2\2\2\u0232\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\7f"+
		"\2\2\u0235\u0236\b!\1\2\u0236\u023b\5`\61\2\u0237\u0238\7?\2\2\u0238\u023a"+
		"\7@\2\2\u0239\u0237\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b"+
		"\u023c\3\2\2\2\u023c\u0240\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u023f\7/"+
		"\2\2\u023f\u0241\5^\60\2\u0240\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241"+
		"\u0242\3\2\2\2\u0242\u0243\7A\2\2\u0243\u0244\b!\1\2\u0244A\3\2\2\2\u0245"+
		"\u0246\5\24\13\2\u0246\u0247\5@!\2\u0247C\3\2\2\2\u0248\u024d\5F$\2\u0249"+
		"\u024a\7B\2\2\u024a\u024c\5F$\2\u024b\u0249\3\2\2\2\u024c\u024f\3\2\2"+
		"\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024eE\3\2\2\2\u024f\u024d"+
		"\3\2\2\2\u0250\u0253\5H%\2\u0251\u0252\7D\2\2\u0252\u0254\5J&\2\u0253"+
		"\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254G\3\2\2\2\u0255\u025a\7f\2\2\u0256"+
		"\u0257\7?\2\2\u0257\u0259\7@\2\2\u0258\u0256\3\2\2\2\u0259\u025c\3\2\2"+
		"\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025bI\3\2\2\2\u025c\u025a"+
		"\3\2\2\2\u025d\u0260\5L\'\2\u025e\u0260\5\u00b8]\2\u025f\u025d\3\2\2\2"+
		"\u025f\u025e\3\2\2\2\u0260K\3\2\2\2\u0261\u026d\7=\2\2\u0262\u0267\5J"+
		"&\2\u0263\u0264\7B\2\2\u0264\u0266\5J&\2\u0265\u0263\3\2\2\2\u0266\u0269"+
		"\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026b\3\2\2\2\u0269"+
		"\u0267\3\2\2\2\u026a\u026c\7B\2\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2"+
		"\2\2\u026c\u026e\3\2\2\2\u026d\u0262\3\2\2\2\u026d\u026e\3\2\2\2\u026e"+
		"\u026f\3\2\2\2\u026f\u0270\7>\2\2\u0270M\3\2\2\2\u0271\u0272\5l\67\2\u0272"+
		"O\3\2\2\2\u0273\u0274\7f\2\2\u0274Q\3\2\2\2\u0275\u0276\5l\67\2\u0276"+
		"S\3\2\2\2\u0277\u027c\5V,\2\u0278\u0279\7?\2\2\u0279\u027b\7@\2\2\u027a"+
		"\u0278\3\2\2\2\u027b\u027e\3\2\2\2\u027c\u027a\3\2\2\2\u027c\u027d\3\2"+
		"\2\2\u027d\u0288\3\2\2\2\u027e\u027c\3\2\2\2\u027f\u0284\5X-\2\u0280\u0281"+
		"\7?\2\2\u0281\u0283\7@\2\2\u0282\u0280\3\2\2\2\u0283\u0286\3\2\2\2\u0284"+
		"\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0288\3\2\2\2\u0286\u0284\3\2"+
		"\2\2\u0287\u0277\3\2\2\2\u0287\u027f\3\2\2\2\u0288U\3\2\2\2\u0289\u028b"+
		"\7f\2\2\u028a\u028c\5Z.\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c"+
		"\u0294\3\2\2\2\u028d\u028e\7C\2\2\u028e\u0290\7f\2\2\u028f\u0291\5Z.\2"+
		"\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0293\3\2\2\2\u0292\u028d"+
		"\3\2\2\2\u0293\u0296\3\2\2\2\u0294\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295"+
		"W\3\2\2\2\u0296\u0294\3\2\2\2\u0297\u0298\t\4\2\2\u0298Y\3\2\2\2\u0299"+
		"\u029a\7F\2\2\u029a\u029f\5\\/\2\u029b\u029c\7B\2\2\u029c\u029e\5\\/\2"+
		"\u029d\u029b\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0"+
		"\3\2\2\2\u02a0\u02a2\3\2\2\2\u02a1\u029f\3\2\2\2\u02a2\u02a3\7E\2\2\u02a3"+
		"[\3\2\2\2\u02a4\u02ab\5T+\2\u02a5\u02a8\7I\2\2\u02a6\u02a7\t\5\2\2\u02a7"+
		"\u02a9\5T+\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ab\3\2\2"+
		"\2\u02aa\u02a4\3\2\2\2\u02aa\u02a5\3\2\2\2\u02ab]\3\2\2\2\u02ac\u02b1"+
		"\5l\67\2\u02ad\u02ae\7B\2\2\u02ae\u02b0\5l\67\2\u02af\u02ad\3\2\2\2\u02b0"+
		"\u02b3\3\2\2\2\u02b1\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2_\3\2\2\2"+
		"\u02b3\u02b1\3\2\2\2\u02b4\u02b6\7;\2\2\u02b5\u02b7\5b\62\2\u02b6\u02b5"+
		"\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\7<\2\2\u02b9"+
		"a\3\2\2\2\u02ba\u02bf\5d\63\2\u02bb\u02bc\7B\2\2\u02bc\u02be\5d\63\2\u02bd"+
		"\u02bb\3\2\2\2\u02be\u02c1\3\2\2\2\u02bf\u02bd\3\2\2\2\u02bf\u02c0\3\2"+
		"\2\2\u02c0\u02c4\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c2\u02c3\7B\2\2\u02c3"+
		"\u02c5\5f\64\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c8\3\2"+
		"\2\2\u02c6\u02c8\5f\64\2\u02c7\u02ba\3\2\2\2\u02c7\u02c6\3\2\2\2\u02c8"+
		"c\3\2\2\2\u02c9\u02cb\5\20\t\2\u02ca\u02c9\3\2\2\2\u02cb\u02ce\3\2\2\2"+
		"\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cf\3\2\2\2\u02ce\u02cc"+
		"\3\2\2\2\u02cf\u02d0\5T+\2\u02d0\u02d1\5H%\2\u02d1\u02d2\b\63\1\2\u02d2"+
		"e\3\2\2\2\u02d3\u02d5\5\20\t\2\u02d4\u02d3\3\2\2\2\u02d5\u02d8\3\2\2\2"+
		"\u02d6\u02d4\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d9\3\2\2\2\u02d8\u02d6"+
		"\3\2\2\2\u02d9\u02da\5T+\2\u02da\u02db\7h\2\2\u02db\u02dc\5H%\2\u02dc"+
		"g\3\2\2\2\u02dd\u02de\b\65\1\2\u02de\u02df\5\u008cG\2\u02df\u02e0\b\65"+
		"\1\2\u02e0i\3\2\2\2\u02e1\u02e2\5\u008cG\2\u02e2k\3\2\2\2\u02e3\u02e8"+
		"\7f\2\2\u02e4\u02e5\7C\2\2\u02e5\u02e7\7f\2\2\u02e6\u02e4\3\2\2\2\u02e7"+
		"\u02ea\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9m\3\2\2\2"+
		"\u02ea\u02e8\3\2\2\2\u02eb\u02ec\t\6\2\2\u02eco\3\2\2\2\u02ed\u02ee\7"+
		"g\2\2\u02ee\u02f5\5r:\2\u02ef\u02f2\7;\2\2\u02f0\u02f3\5t;\2\u02f1\u02f3"+
		"\5x=\2\u02f2\u02f0\3\2\2\2\u02f2\u02f1\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3"+
		"\u02f4\3\2\2\2\u02f4\u02f6\7<\2\2\u02f5\u02ef\3\2\2\2\u02f5\u02f6\3\2"+
		"\2\2\u02f6q\3\2\2\2\u02f7\u02f8\5l\67\2\u02f8\u02f9\b:\1\2\u02f9s\3\2"+
		"\2\2\u02fa\u02ff\5v<\2\u02fb\u02fc\7B\2\2\u02fc\u02fe\5v<\2\u02fd\u02fb"+
		"\3\2\2\2\u02fe\u0301\3\2\2\2\u02ff\u02fd\3\2\2\2\u02ff\u0300\3\2\2\2\u0300"+
		"u\3\2\2\2\u0301\u02ff\3\2\2\2\u0302\u0303\7f\2\2\u0303\u0304\7D\2\2\u0304"+
		"\u0305\5x=\2\u0305w\3\2\2\2\u0306\u030a\5\u00b8]\2\u0307\u030a\5p9\2\u0308"+
		"\u030a\5z>\2\u0309\u0306\3\2\2\2\u0309\u0307\3\2\2\2\u0309\u0308\3\2\2"+
		"\2\u030ay\3\2\2\2\u030b\u0314\7=\2\2\u030c\u0311\5x=\2\u030d\u030e\7B"+
		"\2\2\u030e\u0310\5x=\2\u030f\u030d\3\2\2\2\u0310\u0313\3\2\2\2\u0311\u030f"+
		"\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0315\3\2\2\2\u0313\u0311\3\2\2\2\u0314"+
		"\u030c\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0317\3\2\2\2\u0316\u0318\7B"+
		"\2\2\u0317\u0316\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\3\2\2\2\u0319"+
		"\u031a\7>\2\2\u031a{\3\2\2\2\u031b\u031c\7g\2\2\u031c\u031d\7\36\2\2\u031d"+
		"\u031e\7f\2\2\u031e\u031f\b?\1\2\u031f\u0320\5~@\2\u0320}\3\2\2\2\u0321"+
		"\u0325\7=\2\2\u0322\u0324\5\u0080A\2\u0323\u0322\3\2\2\2\u0324\u0327\3"+
		"\2\2\2\u0325\u0323\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0328\3\2\2\2\u0327"+
		"\u0325\3\2\2\2\u0328\u0329\7>\2\2\u0329\177\3\2\2\2\u032a\u032c\5\f\7"+
		"\2\u032b\u032a\3\2\2\2\u032c\u032f\3\2\2\2\u032d\u032b\3\2\2\2\u032d\u032e"+
		"\3\2\2\2\u032e\u0330\3\2\2\2\u032f\u032d\3\2\2\2\u0330\u0333\5\u0082B"+
		"\2\u0331\u0333\7A\2\2\u0332\u032d\3\2\2\2\u0332\u0331\3\2\2\2\u0333\u0081"+
		"\3\2\2\2\u0334\u0335\5T+\2\u0335\u0336\5\u0084C\2\u0336\u0337\7A\2\2\u0337"+
		"\u0349\3\2\2\2\u0338\u033a\5\22\n\2\u0339\u033b\7A\2\2\u033a\u0339\3\2"+
		"\2\2\u033a\u033b\3\2\2\2\u033b\u0349\3\2\2\2\u033c\u033e\5\"\22\2\u033d"+
		"\u033f\7A\2\2\u033e\u033d\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0349\3\2"+
		"\2\2\u0340\u0342\5\32\16\2\u0341\u0343\7A\2\2\u0342\u0341\3\2\2\2\u0342"+
		"\u0343\3\2\2\2\u0343\u0349\3\2\2\2\u0344\u0346\5|?\2\u0345\u0347\7A\2"+
		"\2\u0346\u0345\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0349\3\2\2\2\u0348\u0334"+
		"\3\2\2\2\u0348\u0338\3\2\2\2\u0348\u033c\3\2\2\2\u0348\u0340\3\2\2\2\u0348"+
		"\u0344\3\2\2\2\u0349\u0083\3\2\2\2\u034a\u034d\5\u0086D\2\u034b\u034d"+
		"\5\u0088E\2\u034c\u034a\3\2\2\2\u034c\u034b\3\2\2\2\u034d\u0085\3\2\2"+
		"\2\u034e\u034f\7f\2\2\u034f\u0350\7;\2\2\u0350\u0352\7<\2\2\u0351\u0353"+
		"\5\u008aF\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0087\3\2\2"+
		"\2\u0354\u0355\5D#\2\u0355\u0089\3\2\2\2\u0356\u0357\7\16\2\2\u0357\u0358"+
		"\5x=\2\u0358\u008b\3\2\2\2\u0359\u035d\7=\2\2\u035a\u035c\5\u008eH\2\u035b"+
		"\u035a\3\2\2\2\u035c\u035f\3\2\2\2\u035d\u035b\3\2\2\2\u035d\u035e\3\2"+
		"\2\2\u035e\u0360\3\2\2\2\u035f\u035d\3\2\2\2\u0360\u0361\7>\2\2\u0361"+
		"\u008d\3\2\2\2\u0362\u0363\5\u0090I\2\u0363\u0364\bH\1\2\u0364\u036c\3"+
		"\2\2\2\u0365\u0366\5\u0094K\2\u0366\u0367\bH\1\2\u0367\u036c\3\2\2\2\u0368"+
		"\u0369\5\n\6\2\u0369\u036a\bH\1\2\u036a\u036c\3\2\2\2\u036b\u0362\3\2"+
		"\2\2\u036b\u0365\3\2\2\2\u036b\u0368\3\2\2\2\u036c\u008f\3\2\2\2\u036d"+
		"\u036e\5\u0092J\2\u036e\u036f\7A\2\2\u036f\u0091\3\2\2\2\u0370\u0372\5"+
		"\20\t\2\u0371\u0370\3\2\2\2\u0372\u0375\3\2\2\2\u0373\u0371\3\2\2\2\u0373"+
		"\u0374\3\2\2\2\u0374\u0376\3\2\2\2\u0375\u0373\3\2\2\2\u0376\u0377\5T"+
		"+\2\u0377\u0378\5D#\2\u0378\u0093\3\2\2\2\u0379\u03db\5\u008cG\2\u037a"+
		"\u037b\7\4\2\2\u037b\u037e\5\u00b8]\2\u037c\u037d\7J\2\2\u037d\u037f\5"+
		"\u00b8]\2\u037e\u037c\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0380\3\2\2\2"+
		"\u0380\u0381\7A\2\2\u0381\u03db\3\2\2\2\u0382\u0383\7\30\2\2\u0383\u0384"+
		"\5\u00b0Y\2\u0384\u0387\5\u0094K\2\u0385\u0386\7\21\2\2\u0386\u0388\5"+
		"\u0094K\2\u0387\u0385\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u03db\3\2\2\2"+
		"\u0389\u038a\7\27\2\2\u038a\u038b\7;\2\2\u038b\u038c\5\u00a8U\2\u038c"+
		"\u038d\7<\2\2\u038d\u038e\5\u0094K\2\u038e\u03db\3\2\2\2\u038f\u0390\7"+
		"\64\2\2\u0390\u0391\5\u00b0Y\2\u0391\u0392\5\u0094K\2\u0392\u03db\3\2"+
		"\2\2\u0393\u0394\7\17\2\2\u0394\u0395\5\u0094K\2\u0395\u0396\7\64\2\2"+
		"\u0396\u0397\5\u00b0Y\2\u0397\u0398\7A\2\2\u0398\u03db\3\2\2\2\u0399\u039a"+
		"\7\61\2\2\u039a\u03a0\5\u008cG\2\u039b\u039d\5\u0096L\2\u039c\u039e\5"+
		"\u009cO\2\u039d\u039c\3\2\2\2\u039d\u039e\3\2\2\2\u039e\u03a1\3\2\2\2"+
		"\u039f\u03a1\5\u009cO\2\u03a0\u039b\3\2\2\2\u03a0\u039f\3\2\2\2\u03a1"+
		"\u03db\3\2\2\2\u03a2\u03a3\7\61\2\2\u03a3\u03a4\5\u009eP\2\u03a4\u03a6"+
		"\5\u008cG\2\u03a5\u03a7\5\u0096L\2\u03a6\u03a5\3\2\2\2\u03a6\u03a7\3\2"+
		"\2\2\u03a7\u03a9\3\2\2\2\u03a8\u03aa\5\u009cO\2\u03a9\u03a8\3\2\2\2\u03a9"+
		"\u03aa\3\2\2\2\u03aa\u03db\3\2\2\2\u03ab\u03ac\7+\2\2\u03ac\u03ad\5\u00b0"+
		"Y\2\u03ad\u03b1\7=\2\2\u03ae\u03b0\5\u00a4S\2\u03af\u03ae\3\2\2\2\u03b0"+
		"\u03b3\3\2\2\2\u03b1\u03af\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b7\3\2"+
		"\2\2\u03b3\u03b1\3\2\2\2\u03b4\u03b6\5\u00a6T\2\u03b5\u03b4\3\2\2\2\u03b6"+
		"\u03b9\3\2\2\2\u03b7\u03b5\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8\u03ba\3\2"+
		"\2\2\u03b9\u03b7\3\2\2\2\u03ba\u03bb\7>\2\2\u03bb\u03db\3\2\2\2\u03bc"+
		"\u03bd\7,\2\2\u03bd\u03be\5\u00b0Y\2\u03be\u03bf\5\u008cG\2\u03bf\u03db"+
		"\3\2\2\2\u03c0\u03c2\7&\2\2\u03c1\u03c3\5\u00b8]\2\u03c2\u03c1\3\2\2\2"+
		"\u03c2\u03c3\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03db\7A\2\2\u03c5\u03c6"+
		"\7.\2\2\u03c6\u03c7\5\u00b8]\2\u03c7\u03c8\7A\2\2\u03c8\u03db\3\2\2\2"+
		"\u03c9\u03cb\7\6\2\2\u03ca\u03cc\7f\2\2\u03cb\u03ca\3\2\2\2\u03cb\u03cc"+
		"\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03db\7A\2\2\u03ce\u03d0\7\r\2\2\u03cf"+
		"\u03d1\7f\2\2\u03d0\u03cf\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d2\3\2"+
		"\2\2\u03d2\u03db\7A\2\2\u03d3\u03db\7A\2\2\u03d4\u03d5\5\u00b4[\2\u03d5"+
		"\u03d6\7A\2\2\u03d6\u03db\3\2\2\2\u03d7\u03d8\7f\2\2\u03d8\u03d9\7J\2"+
		"\2\u03d9\u03db\5\u0094K\2\u03da\u0379\3\2\2\2\u03da\u037a\3\2\2\2\u03da"+
		"\u0382\3\2\2\2\u03da\u0389\3\2\2\2\u03da\u038f\3\2\2\2\u03da\u0393\3\2"+
		"\2\2\u03da\u0399\3\2\2\2\u03da\u03a2\3\2\2\2\u03da\u03ab\3\2\2\2\u03da"+
		"\u03bc\3\2\2\2\u03da\u03c0\3\2\2\2\u03da\u03c5\3\2\2\2\u03da\u03c9\3\2"+
		"\2\2\u03da\u03ce\3\2\2\2\u03da\u03d3\3\2\2\2\u03da\u03d4\3\2\2\2\u03da"+
		"\u03d7\3\2\2\2\u03db\u0095\3\2\2\2\u03dc\u03de\5\u0098M\2\u03dd\u03dc"+
		"\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03dd\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0"+
		"\u0097\3\2\2\2\u03e1\u03e2\7\t\2\2\u03e2\u03e6\7;\2\2\u03e3\u03e5\5\20"+
		"\t\2\u03e4\u03e3\3\2\2\2\u03e5\u03e8\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e6"+
		"\u03e7\3\2\2\2\u03e7\u03e9\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e9\u03ea\5\u009a"+
		"N\2\u03ea\u03eb\7f\2\2\u03eb\u03ec\7<\2\2\u03ec\u03ed\5\u008cG\2\u03ed"+
		"\u0099\3\2\2\2\u03ee\u03f3\5l\67\2\u03ef\u03f0\7X\2\2\u03f0\u03f2\5l\67"+
		"\2\u03f1\u03ef\3\2\2\2\u03f2\u03f5\3\2\2\2\u03f3\u03f1\3\2\2\2\u03f3\u03f4"+
		"\3\2\2\2\u03f4\u009b\3\2\2\2\u03f5\u03f3\3\2\2\2\u03f6\u03f7\7\25\2\2"+
		"\u03f7\u03f8\5\u008cG\2\u03f8\u009d\3\2\2\2\u03f9\u03fa\7;\2\2\u03fa\u03fc"+
		"\5\u00a0Q\2\u03fb\u03fd\7A\2\2\u03fc\u03fb\3\2\2\2\u03fc\u03fd\3\2\2\2"+
		"\u03fd\u03fe\3\2\2\2\u03fe\u03ff\7<\2\2\u03ff\u009f\3\2\2\2\u0400\u0405"+
		"\5\u00a2R\2\u0401\u0402\7A\2\2\u0402\u0404\5\u00a2R\2\u0403\u0401\3\2"+
		"\2\2\u0404\u0407\3\2\2\2\u0405\u0403\3\2\2\2\u0405\u0406\3\2\2\2\u0406"+
		"\u00a1\3\2\2\2\u0407\u0405\3\2\2\2\u0408\u040a\5\20\t\2\u0409\u0408\3"+
		"\2\2\2\u040a\u040d\3\2\2\2\u040b\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040c"+
		"\u040e\3\2\2\2\u040d\u040b\3\2\2\2\u040e\u040f\5V,\2\u040f\u0410\5H%\2"+
		"\u0410\u0411\7D\2\2\u0411\u0412\5\u00b8]\2\u0412\u00a3\3\2\2\2\u0413\u0415"+
		"\5\u00a6T\2\u0414\u0413\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u0414\3\2\2"+
		"\2\u0416\u0417\3\2\2\2\u0417\u0419\3\2\2\2\u0418\u041a\5\u008eH\2\u0419"+
		"\u0418\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u0419\3\2\2\2\u041b\u041c\3\2"+
		"\2\2\u041c\u00a5\3\2\2\2\u041d\u041e\7\b\2\2\u041e\u041f\5\u00b6\\\2\u041f"+
		"\u0420\7J\2\2\u0420\u0428\3\2\2\2\u0421\u0422\7\b\2\2\u0422\u0423\5P)"+
		"\2\u0423\u0424\7J\2\2\u0424\u0428\3\2\2\2\u0425\u0426\7\16\2\2\u0426\u0428"+
		"\7J\2\2\u0427\u041d\3\2\2\2\u0427\u0421\3\2\2\2\u0427\u0425\3\2\2\2\u0428"+
		"\u00a7\3\2\2\2\u0429\u0436\5\u00acW\2\u042a\u042c\5\u00aaV\2\u042b\u042a"+
		"\3\2\2\2\u042b\u042c\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u042f\7A\2\2\u042e"+
		"\u0430\5\u00b8]\2\u042f\u042e\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u0431"+
		"\3\2\2\2\u0431\u0433\7A\2\2\u0432\u0434\5\u00aeX\2\u0433\u0432\3\2\2\2"+
		"\u0433\u0434\3\2\2\2\u0434\u0436\3\2\2\2\u0435\u0429\3\2\2\2\u0435\u042b"+
		"\3\2\2\2\u0436\u00a9\3\2\2\2\u0437\u043a\5\u0092J\2\u0438\u043a\5\u00b2"+
		"Z\2\u0439\u0437\3\2\2\2\u0439\u0438\3\2\2\2\u043a\u00ab\3\2\2\2\u043b"+
		"\u043d\5\20\t\2\u043c\u043b\3\2\2\2\u043d\u0440\3\2\2\2\u043e\u043c\3"+
		"\2\2\2\u043e\u043f\3\2\2\2\u043f\u0441\3\2\2\2\u0440\u043e\3\2\2\2\u0441"+
		"\u0442\5T+\2\u0442\u0443\7f\2\2\u0443\u0444\7J\2\2\u0444\u0445\5\u00b8"+
		"]\2\u0445\u00ad\3\2\2\2\u0446\u0447\5\u00b2Z\2\u0447\u00af\3\2\2\2\u0448"+
		"\u0449\7;\2\2\u0449\u044a\5\u00b8]\2\u044a\u044b\7<\2\2\u044b\u00b1\3"+
		"\2\2\2\u044c\u0451\5\u00b8]\2\u044d\u044e\7B\2\2\u044e\u0450\5\u00b8]"+
		"\2\u044f\u044d\3\2\2\2\u0450\u0453\3\2\2\2\u0451\u044f\3\2\2\2\u0451\u0452"+
		"\3\2\2\2\u0452\u00b3\3\2\2\2\u0453\u0451\3\2\2\2\u0454\u0455\5\u00b8]"+
		"\2\u0455\u00b5\3\2\2\2\u0456\u0457\5\u00b8]\2\u0457\u00b7\3\2\2\2\u0458"+
		"\u0459\b]\1\2\u0459\u045a\7;\2\2\u045a\u045b\5T+\2\u045b\u045c\7<\2\2"+
		"\u045c\u045d\5\u00b8]\2\u045d\u0468\3\2\2\2\u045e\u045f\t\7\2\2\u045f"+
		"\u0468\5\u00b8]\2\u0460\u0461\t\b\2\2\u0461\u0468\5\u00b8]\2\u0462\u0468"+
		"\5\u00ba^\2\u0463\u0464\7!\2\2\u0464\u0465\5\u00bc_\2\u0465\u0466\b]\1"+
		"\2\u0466\u0468\3\2\2\2\u0467\u0458\3\2\2\2\u0467\u045e\3\2\2\2\u0467\u0460"+
		"\3\2\2\2\u0467\u0462\3\2\2\2\u0467\u0463\3\2\2\2\u0468\u04cb\3\2\2\2\u0469"+
		"\u046a\6]\2\3\u046a\u046b\t\t\2\2\u046b\u04ca\5\u00b8]\2\u046c\u046d\6"+
		"]\3\3\u046d\u046e\t\n\2\2\u046e\u04ca\5\u00b8]\2\u046f\u0477\6]\4\3\u0470"+
		"\u0471\7F\2\2\u0471\u0478\7F\2\2\u0472\u0473\7E\2\2\u0473\u0474\7E\2\2"+
		"\u0474\u0478\7E\2\2\u0475\u0476\7E\2\2\u0476\u0478\7E\2\2\u0477\u0470"+
		"\3\2\2\2\u0477\u0472\3\2\2\2\u0477\u0475\3\2\2\2\u0478\u0479\3\2\2\2\u0479"+
		"\u04ca\5\u00b8]\2\u047a\u047b\6]\5\3\u047b\u047c\t\13\2\2\u047c\u04ca"+
		"\5\u00b8]\2\u047d\u047e\6]\6\3\u047e\u047f\t\f\2\2\u047f\u04ca\5\u00b8"+
		"]\2\u0480\u0481\6]\7\3\u0481\u0482\7W\2\2\u0482\u04ca\5\u00b8]\2\u0483"+
		"\u0484\6]\b\3\u0484\u0485\7Y\2\2\u0485\u04ca\5\u00b8]\2\u0486\u0487\6"+
		"]\t\3\u0487\u0488\7X\2\2\u0488\u04ca\5\u00b8]\2\u0489\u048a\6]\n\3\u048a"+
		"\u048b\7O\2\2\u048b\u04ca\5\u00b8]\2\u048c\u048d\6]\13\3\u048d\u048e\7"+
		"P\2\2\u048e\u04ca\5\u00b8]\2\u048f\u049c\6]\f\3\u0490\u049d\7D\2\2\u0491"+
		"\u049d\7[\2\2\u0492\u049d\7\\\2\2\u0493\u049d\7]\2\2\u0494\u049d\7^\2"+
		"\2\u0495\u049d\7_\2\2\u0496\u049d\7`\2\2\u0497\u049d\7a\2\2\u0498\u049d"+
		"\7d\2\2\u0499\u049d\7e\2\2\u049a\u049d\7c\2\2\u049b\u049d\7b\2\2\u049c"+
		"\u0490\3\2\2\2\u049c\u0491\3\2\2\2\u049c\u0492\3\2\2\2\u049c\u0493\3\2"+
		"\2\2\u049c\u0494\3\2\2\2\u049c\u0495\3\2\2\2\u049c\u0496\3\2\2\2\u049c"+
		"\u0497\3\2\2\2\u049c\u0498\3\2\2\2\u049c\u0499\3\2\2\2\u049c\u049a\3\2"+
		"\2\2\u049c\u049b\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u04ca\5\u00b8]\2\u049f"+
		"\u04a0\6]\r\3\u04a0\u04a1\7I\2\2\u04a1\u04a2\5\u00b8]\2\u04a2\u04a3\7"+
		"J\2\2\u04a3\u04a4\5\u00b8]\2\u04a4\u04ca\3\2\2\2\u04a5\u04a6\6]\16\3\u04a6"+
		"\u04a7\7C\2\2\u04a7\u04ca\7f\2\2\u04a8\u04a9\6]\17\3\u04a9\u04aa\7C\2"+
		"\2\u04aa\u04ca\7-\2\2\u04ab\u04ac\6]\20\3\u04ac\u04ad\7C\2\2\u04ad\u04af"+
		"\7!\2\2\u04ae\u04b0\5\u00c8e\2\u04af\u04ae\3\2\2\2\u04af\u04b0\3\2\2\2"+
		"\u04b0\u04b1\3\2\2\2\u04b1\u04ca\5\u00c0a\2\u04b2\u04b3\6]\21\3\u04b3"+
		"\u04b4\7C\2\2\u04b4\u04b5\7*\2\2\u04b5\u04ca\5\u00ceh\2\u04b6\u04b7\6"+
		"]\22\3\u04b7\u04b8\7C\2\2\u04b8\u04ca\5\u00c6d\2\u04b9\u04ba\6]\23\3\u04ba"+
		"\u04bb\7?\2\2\u04bb\u04bc\5\u00b8]\2\u04bc\u04bd\7@\2\2\u04bd\u04ca\3"+
		"\2\2\2\u04be\u04bf\6]\24\3\u04bf\u04c1\7;\2\2\u04c0\u04c2\5\u00b2Z\2\u04c1"+
		"\u04c0\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04ca\7<"+
		"\2\2\u04c4\u04c5\6]\25\3\u04c5\u04ca\t\r\2\2\u04c6\u04c7\6]\26\3\u04c7"+
		"\u04c8\7\34\2\2\u04c8\u04ca\5T+\2\u04c9\u0469\3\2\2\2\u04c9\u046c\3\2"+
		"\2\2\u04c9\u046f\3\2\2\2\u04c9\u047a\3\2\2\2\u04c9\u047d\3\2\2\2\u04c9"+
		"\u0480\3\2\2\2\u04c9\u0483\3\2\2\2\u04c9\u0486\3\2\2\2\u04c9\u0489\3\2"+
		"\2\2\u04c9\u048c\3\2\2\2\u04c9\u048f\3\2\2\2\u04c9\u049f\3\2\2\2\u04c9"+
		"\u04a5\3\2\2\2\u04c9\u04a8\3\2\2\2\u04c9\u04ab\3\2\2\2\u04c9\u04b2\3\2"+
		"\2\2\u04c9\u04b6\3\2\2\2\u04c9\u04b9\3\2\2\2\u04c9\u04be\3\2\2\2\u04c9"+
		"\u04c4\3\2\2\2\u04c9\u04c6\3\2\2\2\u04ca\u04cd\3\2\2\2\u04cb\u04c9\3\2"+
		"\2\2\u04cb\u04cc\3\2\2\2\u04cc\u00b9\3\2\2\2\u04cd\u04cb\3\2\2\2\u04ce"+
		"\u04cf\7;\2\2\u04cf\u04d0\5\u00b8]\2\u04d0\u04d1\7<\2\2\u04d1\u04e4\3"+
		"\2\2\2\u04d2\u04e4\7-\2\2\u04d3\u04e4\7*\2\2\u04d4\u04e4\5n8\2\u04d5\u04e4"+
		"\7f\2\2\u04d6\u04d7\5T+\2\u04d7\u04d8\7C\2\2\u04d8\u04d9\7\13\2\2\u04d9"+
		"\u04e4\3\2\2\2\u04da\u04db\7\62\2\2\u04db\u04dc\7C\2\2\u04dc\u04e4\7\13"+
		"\2\2\u04dd\u04e1\5\u00c8e\2\u04de\u04e2\5\u00d0i\2\u04df\u04e0\7-\2\2"+
		"\u04e0\u04e2\5\u00d2j\2\u04e1\u04de\3\2\2\2\u04e1\u04df\3\2\2\2\u04e2"+
		"\u04e4\3\2\2\2\u04e3\u04ce\3\2\2\2\u04e3\u04d2\3\2\2\2\u04e3\u04d3\3\2"+
		"\2\2\u04e3\u04d4\3\2\2\2\u04e3\u04d5\3\2\2\2\u04e3\u04d6\3\2\2\2\u04e3"+
		"\u04da\3\2\2\2\u04e3\u04dd\3\2\2\2\u04e4\u00bb\3\2\2\2\u04e5\u04e6\5\u00c8"+
		"e\2\u04e6\u04e7\5\u00be`\2\u04e7\u04e8\5\u00c4c\2\u04e8\u04ef\3\2\2\2"+
		"\u04e9\u04ec\5\u00be`\2\u04ea\u04ed\5\u00c2b\2\u04eb\u04ed\5\u00c4c\2"+
		"\u04ec\u04ea\3\2\2\2\u04ec\u04eb\3\2\2\2\u04ed\u04ef\3\2\2\2\u04ee\u04e5"+
		"\3\2\2\2\u04ee\u04e9\3\2\2\2\u04ef\u00bd\3\2\2\2\u04f0\u04f2\7f\2\2\u04f1"+
		"\u04f3\5\u00caf\2\u04f2\u04f1\3\2\2\2\u04f2\u04f3\3\2\2\2\u04f3\u04fb"+
		"\3\2\2\2\u04f4\u04f5\7C\2\2\u04f5\u04f7\7f\2\2\u04f6\u04f8\5\u00caf\2"+
		"\u04f7\u04f6\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04fa\3\2\2\2\u04f9\u04f4"+
		"\3\2\2\2\u04fa\u04fd\3\2\2\2\u04fb\u04f9\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc"+
		"\u0500\3\2\2\2\u04fd\u04fb\3\2\2\2\u04fe\u0500\5X-\2\u04ff\u04f0\3\2\2"+
		"\2\u04ff\u04fe\3\2\2\2\u0500\u00bf\3\2\2\2\u0501\u0503\7f\2\2\u0502\u0504"+
		"\5\u00ccg\2\u0503\u0502\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0505\3\2\2"+
		"\2\u0505\u0506\5\u00c4c\2\u0506\u00c1\3\2\2\2\u0507\u0523\7?\2\2\u0508"+
		"\u050d\7@\2\2\u0509\u050a\7?\2\2\u050a\u050c\7@\2\2\u050b\u0509\3\2\2"+
		"\2\u050c\u050f\3\2\2\2\u050d\u050b\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u0510"+
		"\3\2\2\2\u050f\u050d\3\2\2\2\u0510\u0524\5L\'\2\u0511\u0512\5\u00b8]\2"+
		"\u0512\u0519\7@\2\2\u0513\u0514\7?\2\2\u0514\u0515\5\u00b8]\2\u0515\u0516"+
		"\7@\2\2\u0516\u0518\3\2\2\2\u0517\u0513\3\2\2\2\u0518\u051b\3\2\2\2\u0519"+
		"\u0517\3\2\2\2\u0519\u051a\3\2\2\2\u051a\u0520\3\2\2\2\u051b\u0519\3\2"+
		"\2\2\u051c\u051d\7?\2\2\u051d\u051f\7@\2\2\u051e\u051c\3\2\2\2\u051f\u0522"+
		"\3\2\2\2\u0520\u051e\3\2\2\2\u0520\u0521\3\2\2\2\u0521\u0524\3\2\2\2\u0522"+
		"\u0520\3\2\2\2\u0523\u0508\3\2\2\2\u0523\u0511\3\2\2\2\u0524\u00c3\3\2"+
		"\2\2\u0525\u0527\5\u00d2j\2\u0526\u0528\5&\24\2\u0527\u0526\3\2\2\2\u0527"+
		"\u0528\3\2\2\2\u0528\u00c5\3\2\2\2\u0529\u052a\5\u00c8e\2\u052a\u052b"+
		"\5\u00d0i\2\u052b\u00c7\3\2\2\2\u052c\u052d\7F\2\2\u052d\u052e\5$\23\2"+
		"\u052e\u052f\7E\2\2\u052f\u00c9\3\2\2\2\u0530\u0531\7F\2\2\u0531\u0534"+
		"\7E\2\2\u0532\u0534\5Z.\2\u0533\u0530\3\2\2\2\u0533\u0532\3\2\2\2\u0534"+
		"\u00cb\3\2\2\2\u0535\u0536\7F\2\2\u0536\u0539\7E\2\2\u0537\u0539\5\u00c8"+
		"e\2\u0538\u0535\3\2\2\2\u0538\u0537\3\2\2\2\u0539\u00cd\3\2\2\2\u053a"+
		"\u0541\5\u00d2j\2\u053b\u053c\7C\2\2\u053c\u053e\7f\2\2\u053d\u053f\5"+
		"\u00d2j\2\u053e\u053d\3\2\2\2\u053e\u053f\3\2\2\2\u053f\u0541\3\2\2\2"+
		"\u0540\u053a\3\2\2\2\u0540\u053b\3\2\2\2\u0541\u00cf\3\2\2\2\u0542\u0543"+
		"\7*\2\2\u0543\u0547\5\u00ceh\2\u0544\u0545\7f\2\2\u0545\u0547\5\u00d2"+
		"j\2\u0546\u0542\3\2\2\2\u0546\u0544\3\2\2\2\u0547\u00d1\3\2\2\2\u0548"+
		"\u054a\7;\2\2\u0549\u054b\5\u00b2Z\2\u054a\u0549\3\2\2\2\u054a\u054b\3"+
		"\2\2\2\u054b\u054c\3\2\2\2\u054c\u054d\7<\2\2\u054d\u00d3\3\2\2\2\u0098"+
		"\u00d5\u00da\u00e0\u00ea\u00f4\u00fd\u0102\u010b\u0114\u011d\u0124\u0128"+
		"\u012d\u0131\u0137\u013d\u0141\u014d\u0155\u015c\u0166\u016a\u016d\u0170"+
		"\u017a\u0180\u0186\u0189\u018f\u0196\u019c\u01a6\u01ad\u01b6\u01bd\u01c3"+
		"\u01ca\u01d8\u01dc\u01e5\u01ea\u01ee\u01fa\u020a\u020f\u0218\u0220\u022a"+
		"\u0232\u023b\u0240\u024d\u0253\u025a\u025f\u0267\u026b\u026d\u027c\u0284"+
		"\u0287\u028b\u0290\u0294\u029f\u02a8\u02aa\u02b1\u02b6\u02bf\u02c4\u02c7"+
		"\u02cc\u02d6\u02e8\u02f2\u02f5\u02ff\u0309\u0311\u0314\u0317\u0325\u032d"+
		"\u0332\u033a\u033e\u0342\u0346\u0348\u034c\u0352\u035d\u036b\u0373\u037e"+
		"\u0387\u039d\u03a0\u03a6\u03a9\u03b1\u03b7\u03c2\u03cb\u03d0\u03da\u03df"+
		"\u03e6\u03f3\u03fc\u0405\u040b\u0416\u041b\u0427\u042b\u042f\u0433\u0435"+
		"\u0439\u043e\u0451\u0467\u0477\u049c\u04af\u04c1\u04c9\u04cb\u04e1\u04e3"+
		"\u04ec\u04ee\u04f2\u04f7\u04fb\u04ff\u0503\u050d\u0519\u0520\u0523\u0527"+
		"\u0533\u0538\u053e\u0540\u0546\u054a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}