// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/stacktrace/parser/StackTrace.g4 by ANTLR 4.7
package com.generator.generators.stacktrace.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StackTraceParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, Number=5, JavaWord=6, DOT=7, AT=8, CAUSED_BY=9, 
		MORE_=10, ELLIPSIS=11, COLON=12, NATIVE_METHOD=13, UNKNOWN_SOURCE=14, 
		INIT=15, NonCapitalLetter=16, CapitalLetter=17, Symbol=18, Digit=19, WS=20;
	public static final int
		RULE_startRule = 0, RULE_stackTrace = 1, RULE_stackTraceLine = 2, RULE_atLine = 3, 
		RULE_causedByLine = 4, RULE_ellipsisLine = 5, RULE_messageLine = 6, RULE_qualifiedClass = 7, 
		RULE_innerClassName = 8, RULE_classFile = 9, RULE_qualifiedMethod = 10, 
		RULE_constructor = 11, RULE_methodName = 12, RULE_packagePath = 13, RULE_className = 14, 
		RULE_identifier = 15, RULE_message = 16;
	public static final String[] ruleNames = {
		"startRule", "stackTrace", "stackTraceLine", "atLine", "causedByLine", 
		"ellipsisLine", "messageLine", "qualifiedClass", "innerClassName", "classFile", 
		"qualifiedMethod", "constructor", "methodName", "packagePath", "className", 
		"identifier", "message"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'$'", "'.java'", null, null, "'.'", "'at'", "'Caused by:'", 
		"'more'", "'...'", "':'", "'Native Method'", "'Unknown Source'", "'<init>'", 
		null, null, "'_'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "Number", "JavaWord", "DOT", "AT", "CAUSED_BY", 
		"MORE_", "ELLIPSIS", "COLON", "NATIVE_METHOD", "UNKNOWN_SOURCE", "INIT", 
		"NonCapitalLetter", "CapitalLetter", "Symbol", "Digit", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "StackTrace.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StackTraceParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartRuleContext extends ParserRuleContext {
		public StackTraceContext stackTrace() {
			return getRuleContext(StackTraceContext.class,0);
		}
		public TerminalNode EOF() { return getToken(StackTraceParser.EOF, 0); }
		public StartRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterStartRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitStartRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitStartRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartRuleContext startRule() throws RecognitionException {
		StartRuleContext _localctx = new StartRuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_startRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			stackTrace();
			setState(35);
			match(EOF);
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

	public static class StackTraceContext extends ParserRuleContext {
		public List<MessageLineContext> messageLine() {
			return getRuleContexts(MessageLineContext.class);
		}
		public MessageLineContext messageLine(int i) {
			return getRuleContext(MessageLineContext.class,i);
		}
		public List<StackTraceLineContext> stackTraceLine() {
			return getRuleContexts(StackTraceLineContext.class);
		}
		public StackTraceLineContext stackTraceLine(int i) {
			return getRuleContext(StackTraceLineContext.class,i);
		}
		public CausedByLineContext causedByLine() {
			return getRuleContext(CausedByLineContext.class,0);
		}
		public StackTraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stackTrace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterStackTrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitStackTrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitStackTrace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StackTraceContext stackTrace() throws RecognitionException {
		StackTraceContext _localctx = new StackTraceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stackTrace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				messageLine();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==JavaWord );
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT || _la==ELLIPSIS) {
				{
				{
				setState(42);
				stackTraceLine();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CAUSED_BY) {
				{
				setState(48);
				causedByLine();
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

	public static class StackTraceLineContext extends ParserRuleContext {
		public AtLineContext atLine() {
			return getRuleContext(AtLineContext.class,0);
		}
		public EllipsisLineContext ellipsisLine() {
			return getRuleContext(EllipsisLineContext.class,0);
		}
		public StackTraceLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stackTraceLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterStackTraceLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitStackTraceLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitStackTraceLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StackTraceLineContext stackTraceLine() throws RecognitionException {
		StackTraceLineContext _localctx = new StackTraceLineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stackTraceLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				{
				setState(51);
				atLine();
				}
				break;
			case ELLIPSIS:
				{
				setState(52);
				ellipsisLine();
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

	public static class AtLineContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(StackTraceParser.AT, 0); }
		public QualifiedMethodContext qualifiedMethod() {
			return getRuleContext(QualifiedMethodContext.class,0);
		}
		public ClassFileContext classFile() {
			return getRuleContext(ClassFileContext.class,0);
		}
		public TerminalNode COLON() { return getToken(StackTraceParser.COLON, 0); }
		public TerminalNode Number() { return getToken(StackTraceParser.Number, 0); }
		public AtLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterAtLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitAtLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitAtLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtLineContext atLine() throws RecognitionException {
		AtLineContext _localctx = new AtLineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(AT);
			setState(56);
			qualifiedMethod();
			setState(57);
			match(T__0);
			setState(58);
			classFile();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(59);
				match(COLON);
				setState(60);
				match(Number);
				}
			}

			setState(63);
			match(T__1);
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

	public static class CausedByLineContext extends ParserRuleContext {
		public TerminalNode CAUSED_BY() { return getToken(StackTraceParser.CAUSED_BY, 0); }
		public StackTraceContext stackTrace() {
			return getRuleContext(StackTraceContext.class,0);
		}
		public CausedByLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_causedByLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterCausedByLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitCausedByLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitCausedByLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CausedByLineContext causedByLine() throws RecognitionException {
		CausedByLineContext _localctx = new CausedByLineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_causedByLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(CAUSED_BY);
			setState(66);
			stackTrace();
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

	public static class EllipsisLineContext extends ParserRuleContext {
		public TerminalNode ELLIPSIS() { return getToken(StackTraceParser.ELLIPSIS, 0); }
		public TerminalNode Number() { return getToken(StackTraceParser.Number, 0); }
		public TerminalNode MORE_() { return getToken(StackTraceParser.MORE_, 0); }
		public EllipsisLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ellipsisLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterEllipsisLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitEllipsisLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitEllipsisLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EllipsisLineContext ellipsisLine() throws RecognitionException {
		EllipsisLineContext _localctx = new EllipsisLineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ellipsisLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ELLIPSIS);
			setState(69);
			match(Number);
			setState(70);
			match(MORE_);
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

	public static class MessageLineContext extends ParserRuleContext {
		public QualifiedClassContext qualifiedClass() {
			return getRuleContext(QualifiedClassContext.class,0);
		}
		public MessageContext message() {
			return getRuleContext(MessageContext.class,0);
		}
		public MessageLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterMessageLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitMessageLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitMessageLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageLineContext messageLine() throws RecognitionException {
		MessageLineContext _localctx = new MessageLineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_messageLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(72);
			qualifiedClass();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(73);
				message();
				}
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

	public static class QualifiedClassContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public PackagePathContext packagePath() {
			return getRuleContext(PackagePathContext.class,0);
		}
		public List<InnerClassNameContext> innerClassName() {
			return getRuleContexts(InnerClassNameContext.class);
		}
		public InnerClassNameContext innerClassName(int i) {
			return getRuleContext(InnerClassNameContext.class,i);
		}
		public QualifiedClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterQualifiedClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitQualifiedClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitQualifiedClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedClassContext qualifiedClass() throws RecognitionException {
		QualifiedClassContext _localctx = new QualifiedClassContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_qualifiedClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(76);
				packagePath();
				}
				break;
			}
			setState(79);
			className();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(80);
				innerClassName();
				}
				}
				setState(85);
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

	public static class InnerClassNameContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public InnerClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerClassName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterInnerClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitInnerClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitInnerClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerClassNameContext innerClassName() throws RecognitionException {
		InnerClassNameContext _localctx = new InnerClassNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_innerClassName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(86);
			match(T__2);
			setState(87);
			className();
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

	public static class ClassFileContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NATIVE_METHOD() { return getToken(StackTraceParser.NATIVE_METHOD, 0); }
		public TerminalNode UNKNOWN_SOURCE() { return getToken(StackTraceParser.UNKNOWN_SOURCE, 0); }
		public ClassFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterClassFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitClassFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitClassFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassFileContext classFile() throws RecognitionException {
		ClassFileContext _localctx = new ClassFileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JavaWord:
				{
				setState(89);
				identifier();
				setState(90);
				match(T__3);
				}
				break;
			case NATIVE_METHOD:
				{
				setState(92);
				match(NATIVE_METHOD);
				}
				break;
			case UNKNOWN_SOURCE:
				{
				setState(93);
				match(UNKNOWN_SOURCE);
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

	public static class QualifiedMethodContext extends ParserRuleContext {
		public QualifiedClassContext qualifiedClass() {
			return getRuleContext(QualifiedClassContext.class,0);
		}
		public TerminalNode DOT() { return getToken(StackTraceParser.DOT, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public QualifiedMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterQualifiedMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitQualifiedMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitQualifiedMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedMethodContext qualifiedMethod() throws RecognitionException {
		QualifiedMethodContext _localctx = new QualifiedMethodContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_qualifiedMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			qualifiedClass();
			setState(97);
			match(DOT);
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JavaWord:
				{
				setState(98);
				methodName();
				}
				break;
			case INIT:
				{
				setState(99);
				constructor();
				}
				break;
			case T__0:
				break;
			default:
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

	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode INIT() { return getToken(StackTraceParser.INIT, 0); }
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(INIT);
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

	public static class MethodNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			identifier();
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

	public static class PackagePathContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(StackTraceParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(StackTraceParser.DOT, i);
		}
		public PackagePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packagePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterPackagePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitPackagePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitPackagePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackagePathContext packagePath() throws RecognitionException {
		PackagePathContext _localctx = new PackagePathContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_packagePath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(106);
					identifier();
					setState(107);
					match(DOT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(111); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode JavaWord() { return getToken(StackTraceParser.JavaWord, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(JavaWord);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode JavaWord() { return getToken(StackTraceParser.JavaWord, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(JavaWord);
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

	public static class MessageContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(StackTraceParser.COLON, 0); }
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).enterMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StackTraceListener ) ((StackTraceListener)listener).exitMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StackTraceVisitor ) return ((StackTraceVisitor<? extends T>)visitor).visitMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_message);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(COLON);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(118);
					matchWildcard();
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\6\3)\n\3\r\3\16\3*\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3"+
		"\5\3\64\n\3\3\4\3\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5@\n\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\5\bM\n\b\3\t\5\tP\n\t\3\t\3\t\7\t"+
		"T\n\t\f\t\16\tW\13\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13a\n\13\3"+
		"\f\3\f\3\f\3\f\5\fg\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\6\17p\n\17\r"+
		"\17\16\17q\3\20\3\20\3\21\3\21\3\22\3\22\7\22z\n\22\f\22\16\22}\13\22"+
		"\3\22\3{\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\2{\2$\3\2"+
		"\2\2\4(\3\2\2\2\6\67\3\2\2\2\b9\3\2\2\2\nC\3\2\2\2\fF\3\2\2\2\16J\3\2"+
		"\2\2\20O\3\2\2\2\22X\3\2\2\2\24`\3\2\2\2\26b\3\2\2\2\30h\3\2\2\2\32j\3"+
		"\2\2\2\34o\3\2\2\2\36s\3\2\2\2 u\3\2\2\2\"w\3\2\2\2$%\5\4\3\2%&\7\2\2"+
		"\3&\3\3\2\2\2\')\5\16\b\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+/\3"+
		"\2\2\2,.\5\6\4\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\63\3\2"+
		"\2\2\61/\3\2\2\2\62\64\5\n\6\2\63\62\3\2\2\2\63\64\3\2\2\2\64\5\3\2\2"+
		"\2\658\5\b\5\2\668\5\f\7\2\67\65\3\2\2\2\67\66\3\2\2\28\7\3\2\2\29:\7"+
		"\n\2\2:;\5\26\f\2;<\7\3\2\2<?\5\24\13\2=>\7\16\2\2>@\7\7\2\2?=\3\2\2\2"+
		"?@\3\2\2\2@A\3\2\2\2AB\7\4\2\2B\t\3\2\2\2CD\7\13\2\2DE\5\4\3\2E\13\3\2"+
		"\2\2FG\7\r\2\2GH\7\7\2\2HI\7\f\2\2I\r\3\2\2\2JL\5\20\t\2KM\5\"\22\2LK"+
		"\3\2\2\2LM\3\2\2\2M\17\3\2\2\2NP\5\34\17\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2"+
		"\2QU\5\36\20\2RT\5\22\n\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\21"+
		"\3\2\2\2WU\3\2\2\2XY\7\5\2\2YZ\5\36\20\2Z\23\3\2\2\2[\\\5 \21\2\\]\7\6"+
		"\2\2]a\3\2\2\2^a\7\17\2\2_a\7\20\2\2`[\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\25"+
		"\3\2\2\2bc\5\20\t\2cf\7\t\2\2dg\5\32\16\2eg\5\30\r\2fd\3\2\2\2fe\3\2\2"+
		"\2fg\3\2\2\2g\27\3\2\2\2hi\7\21\2\2i\31\3\2\2\2jk\5 \21\2k\33\3\2\2\2"+
		"lm\5 \21\2mn\7\t\2\2np\3\2\2\2ol\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"r\35\3\2\2\2st\7\b\2\2t\37\3\2\2\2uv\7\b\2\2v!\3\2\2\2w{\7\16\2\2xz\13"+
		"\2\2\2yx\3\2\2\2z}\3\2\2\2{|\3\2\2\2{y\3\2\2\2|#\3\2\2\2}{\3\2\2\2\16"+
		"*/\63\67?LOU`fq{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}