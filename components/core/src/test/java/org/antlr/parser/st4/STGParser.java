// Generated from STGParser.g4 by ANTLR 4.7
package org.antlr.parser.st4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class STGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOC_COMMENT=1, BLOCK_COMMENT=2, LINE_COMMENT=3, TMPL_COMMENT=4, HORZ_WS=5, 
		VERT_WS=6, ID=7, STRING=8, BIGSTRING=9, BIGSTRING_NO_NL=10, ANON_TEMPLATE=11, 
		TMPL_ASSIGN=12, ASSIGN=13, DOT=14, COMMA=15, COLON=16, LPAREN=17, RPAREN=18, 
		LBRACK=19, RBRACK=20, AT=21, TRUE=22, FALSE=23, ELLIPSIS=24, DELIMITERS=25, 
		IMPORT=26, DEFAULT=27, KEY=28, VALUE=29, FIRST=30, LAST=31, REST=32, TRUNC=33, 
		STRIP=34, TRIM=35, LENGTH=36, STRLEN=37, REVERSE=38, GROUP=39, WRAP=40, 
		ANCHOR=41, SEPARATOR=42;
	public static final int
		RULE_group = 0, RULE_delimiters = 1, RULE_imports = 2, RULE_template = 3, 
		RULE_formalArgs = 4, RULE_formalArg = 5, RULE_dict = 6, RULE_dictPairs = 7, 
		RULE_keyValuePair = 8, RULE_defaultValuePair = 9, RULE_keyValue = 10;
	public static final String[] ruleNames = {
		"group", "delimiters", "imports", "template", "formalArgs", "formalArg", 
		"dict", "dictPairs", "keyValuePair", "defaultValuePair", "keyValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "'delimiters'", "'import'", "'default'", "'key'", "'value'", "'first'", 
		"'last'", "'rest'", "'trunc'", "'strip'", "'trim'", "'length'", "'strlen'", 
		"'reverse'", "'group'", "'wrap'", "'anchor'", "'separator'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "TMPL_COMMENT", 
		"HORZ_WS", "VERT_WS", "ID", "STRING", "BIGSTRING", "BIGSTRING_NO_NL", 
		"ANON_TEMPLATE", "TMPL_ASSIGN", "ASSIGN", "DOT", "COMMA", "COLON", "LPAREN", 
		"RPAREN", "LBRACK", "RBRACK", "AT", "TRUE", "FALSE", "ELLIPSIS", "DELIMITERS", 
		"IMPORT", "DEFAULT", "KEY", "VALUE", "FIRST", "LAST", "REST", "TRUNC", 
		"STRIP", "TRIM", "LENGTH", "STRLEN", "REVERSE", "GROUP", "WRAP", "ANCHOR", 
		"SEPARATOR"
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
	public String getGrammarFileName() { return "STGParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public STGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GroupContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(STGParser.EOF, 0); }
		public DelimitersContext delimiters() {
			return getRuleContext(DelimitersContext.class,0);
		}
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public List<TemplateContext> template() {
			return getRuleContexts(TemplateContext.class);
		}
		public TemplateContext template(int i) {
			return getRuleContext(TemplateContext.class,i);
		}
		public List<DictContext> dict() {
			return getRuleContexts(DictContext.class);
		}
		public DictContext dict(int i) {
			return getRuleContext(DictContext.class,i);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DELIMITERS) {
				{
				setState(22);
				delimiters();
				}
			}

			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORT) {
				{
				setState(25);
				imports();
				}
			}

			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(30);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(28);
					template();
					}
					break;
				case 2:
					{
					setState(29);
					dict();
					}
					break;
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==AT );
			setState(34);
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

	public static class DelimitersContext extends ParserRuleContext {
		public TerminalNode DELIMITERS() { return getToken(STGParser.DELIMITERS, 0); }
		public List<TerminalNode> STRING() { return getTokens(STGParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(STGParser.STRING, i);
		}
		public TerminalNode COMMA() { return getToken(STGParser.COMMA, 0); }
		public DelimitersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delimiters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterDelimiters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitDelimiters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitDelimiters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelimitersContext delimiters() throws RecognitionException {
		DelimitersContext _localctx = new DelimitersContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_delimiters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(DELIMITERS);
			setState(37);
			match(STRING);
			setState(38);
			match(COMMA);
			setState(39);
			match(STRING);
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

	public static class ImportsContext extends ParserRuleContext {
		public List<TerminalNode> IMPORT() { return getTokens(STGParser.IMPORT); }
		public TerminalNode IMPORT(int i) {
			return getToken(STGParser.IMPORT, i);
		}
		public List<TerminalNode> STRING() { return getTokens(STGParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(STGParser.STRING, i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				match(IMPORT);
				setState(42);
				match(STRING);
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
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

	public static class TemplateContext extends ParserRuleContext {
		public TerminalNode TMPL_ASSIGN() { return getToken(STGParser.TMPL_ASSIGN, 0); }
		public TerminalNode STRING() { return getToken(STGParser.STRING, 0); }
		public TerminalNode BIGSTRING() { return getToken(STGParser.BIGSTRING, 0); }
		public TerminalNode BIGSTRING_NO_NL() { return getToken(STGParser.BIGSTRING_NO_NL, 0); }
		public TerminalNode AT() { return getToken(STGParser.AT, 0); }
		public List<TerminalNode> ID() { return getTokens(STGParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(STGParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(STGParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(STGParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(STGParser.RPAREN, 0); }
		public FormalArgsContext formalArgs() {
			return getRuleContext(FormalArgsContext.class,0);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_template);
		int _la;
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AT:
					{
					setState(47);
					match(AT);
					setState(48);
					match(ID);
					setState(49);
					match(DOT);
					setState(50);
					match(ID);
					setState(51);
					match(LPAREN);
					setState(52);
					match(RPAREN);
					}
					break;
				case ID:
					{
					setState(53);
					match(ID);
					setState(54);
					match(LPAREN);
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(55);
						formalArgs();
						}
					}

					setState(58);
					match(RPAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(61);
				match(TMPL_ASSIGN);
				setState(62);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BIGSTRING) | (1L << BIGSTRING_NO_NL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(ID);
				setState(64);
				match(TMPL_ASSIGN);
				setState(65);
				match(ID);
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

	public static class FormalArgsContext extends ParserRuleContext {
		public List<FormalArgContext> formalArg() {
			return getRuleContexts(FormalArgContext.class);
		}
		public FormalArgContext formalArg(int i) {
			return getRuleContext(FormalArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(STGParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(STGParser.COMMA, i);
		}
		public FormalArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterFormalArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitFormalArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitFormalArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalArgsContext formalArgs() throws RecognitionException {
		FormalArgsContext _localctx = new FormalArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formalArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			formalArg();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(69);
				match(COMMA);
				setState(70);
				formalArg();
				}
				}
				setState(75);
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

	public static class FormalArgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(STGParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(STGParser.ASSIGN, 0); }
		public TerminalNode STRING() { return getToken(STGParser.STRING, 0); }
		public TerminalNode ANON_TEMPLATE() { return getToken(STGParser.ANON_TEMPLATE, 0); }
		public TerminalNode TRUE() { return getToken(STGParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(STGParser.FALSE, 0); }
		public TerminalNode LBRACK() { return getToken(STGParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(STGParser.RBRACK, 0); }
		public FormalArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterFormalArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitFormalArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitFormalArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalArgContext formalArg() throws RecognitionException {
		FormalArgContext _localctx = new FormalArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ID);
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(77);
				match(ASSIGN);
				setState(78);
				match(STRING);
				}
				break;
			case 2:
				{
				setState(79);
				match(ASSIGN);
				setState(80);
				match(ANON_TEMPLATE);
				}
				break;
			case 3:
				{
				setState(81);
				match(ASSIGN);
				setState(82);
				match(TRUE);
				}
				break;
			case 4:
				{
				setState(83);
				match(ASSIGN);
				setState(84);
				match(FALSE);
				}
				break;
			case 5:
				{
				setState(85);
				match(ASSIGN);
				setState(86);
				match(LBRACK);
				setState(87);
				match(RBRACK);
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

	public static class DictContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(STGParser.ID, 0); }
		public TerminalNode TMPL_ASSIGN() { return getToken(STGParser.TMPL_ASSIGN, 0); }
		public TerminalNode LBRACK() { return getToken(STGParser.LBRACK, 0); }
		public DictPairsContext dictPairs() {
			return getRuleContext(DictPairsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(STGParser.RBRACK, 0); }
		public DictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterDict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitDict(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitDict(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictContext dict() throws RecognitionException {
		DictContext _localctx = new DictContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(ID);
			setState(91);
			match(TMPL_ASSIGN);
			setState(92);
			match(LBRACK);
			setState(93);
			dictPairs();
			setState(94);
			match(RBRACK);
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

	public static class DictPairsContext extends ParserRuleContext {
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(STGParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(STGParser.COMMA, i);
		}
		public DefaultValuePairContext defaultValuePair() {
			return getRuleContext(DefaultValuePairContext.class,0);
		}
		public DictPairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictPairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterDictPairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitDictPairs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitDictPairs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictPairsContext dictPairs() throws RecognitionException {
		DictPairsContext _localctx = new DictPairsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dictPairs);
		int _la;
		try {
			int _alt;
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				keyValuePair();
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(97);
						match(COMMA);
						setState(98);
						keyValuePair();
						}
						} 
					}
					setState(103);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(104);
					match(COMMA);
					setState(105);
					defaultValuePair();
					}
				}

				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				defaultValuePair();
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

	public static class KeyValuePairContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(STGParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(STGParser.COLON, 0); }
		public KeyValueContext keyValue() {
			return getRuleContext(KeyValueContext.class,0);
		}
		public KeyValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterKeyValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitKeyValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitKeyValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValuePairContext keyValuePair() throws RecognitionException {
		KeyValuePairContext _localctx = new KeyValuePairContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_keyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(STRING);
			setState(112);
			match(COLON);
			setState(113);
			keyValue();
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

	public static class DefaultValuePairContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(STGParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(STGParser.COLON, 0); }
		public KeyValueContext keyValue() {
			return getRuleContext(KeyValueContext.class,0);
		}
		public DefaultValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterDefaultValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitDefaultValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitDefaultValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValuePairContext defaultValuePair() throws RecognitionException {
		DefaultValuePairContext _localctx = new DefaultValuePairContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defaultValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(DEFAULT);
			setState(116);
			match(COLON);
			setState(117);
			keyValue();
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

	public static class KeyValueContext extends ParserRuleContext {
		public TerminalNode BIGSTRING() { return getToken(STGParser.BIGSTRING, 0); }
		public TerminalNode BIGSTRING_NO_NL() { return getToken(STGParser.BIGSTRING_NO_NL, 0); }
		public TerminalNode ANON_TEMPLATE() { return getToken(STGParser.ANON_TEMPLATE, 0); }
		public TerminalNode STRING() { return getToken(STGParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(STGParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(STGParser.FALSE, 0); }
		public TerminalNode LBRACK() { return getToken(STGParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(STGParser.RBRACK, 0); }
		public TerminalNode KEY() { return getToken(STGParser.KEY, 0); }
		public KeyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).enterKeyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STGParserListener ) ((STGParserListener)listener).exitKeyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STGParserVisitor ) return ((STGParserVisitor<? extends T>)visitor).visitKeyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValueContext keyValue() throws RecognitionException {
		KeyValueContext _localctx = new KeyValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_keyValue);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BIGSTRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(BIGSTRING);
				}
				break;
			case BIGSTRING_NO_NL:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(BIGSTRING_NO_NL);
				}
				break;
			case ANON_TEMPLATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(ANON_TEMPLATE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(STRING);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				match(FALSE);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 7);
				{
				setState(125);
				match(LBRACK);
				setState(126);
				match(RBRACK);
				}
				break;
			case KEY:
				enterOuterAlt(_localctx, 8);
				{
				setState(127);
				match(KEY);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0085\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\5\2\32\n\2\3\2\5\2\35\n\2\3\2\3\2\6\2!\n\2\r\2\16\2\""+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\6\4.\n\4\r\4\16\4/\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5;\n\5\3\5\5\5>\n\5\3\5\3\5\3\5\3\5\3\5\5\5E"+
		"\n\5\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tf\n"+
		"\t\f\t\16\ti\13\t\3\t\3\t\5\tm\n\t\3\t\5\tp\n\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0083\n\f\3\f\2"+
		"\2\r\2\4\6\b\n\f\16\20\22\24\26\2\3\3\2\n\f\2\u0091\2\31\3\2\2\2\4&\3"+
		"\2\2\2\6-\3\2\2\2\bD\3\2\2\2\nF\3\2\2\2\fN\3\2\2\2\16\\\3\2\2\2\20o\3"+
		"\2\2\2\22q\3\2\2\2\24u\3\2\2\2\26\u0082\3\2\2\2\30\32\5\4\3\2\31\30\3"+
		"\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\35\5\6\4\2\34\33\3\2\2\2\34\35\3"+
		"\2\2\2\35 \3\2\2\2\36!\5\b\5\2\37!\5\16\b\2 \36\3\2\2\2 \37\3\2\2\2!\""+
		"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\7\2\2\3%\3\3\2\2\2&\'\7\33"+
		"\2\2\'(\7\n\2\2()\7\21\2\2)*\7\n\2\2*\5\3\2\2\2+,\7\34\2\2,.\7\n\2\2-"+
		"+\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\7\3\2\2\2\61\62\7\27\2\2"+
		"\62\63\7\t\2\2\63\64\7\20\2\2\64\65\7\t\2\2\65\66\7\23\2\2\66>\7\24\2"+
		"\2\678\7\t\2\28:\7\23\2\29;\5\n\6\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<>\7"+
		"\24\2\2=\61\3\2\2\2=\67\3\2\2\2>?\3\2\2\2?@\7\16\2\2@E\t\2\2\2AB\7\t\2"+
		"\2BC\7\16\2\2CE\7\t\2\2D=\3\2\2\2DA\3\2\2\2E\t\3\2\2\2FK\5\f\7\2GH\7\21"+
		"\2\2HJ\5\f\7\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\13\3\2\2\2MK\3"+
		"\2\2\2NZ\7\t\2\2OP\7\17\2\2P[\7\n\2\2QR\7\17\2\2R[\7\r\2\2ST\7\17\2\2"+
		"T[\7\30\2\2UV\7\17\2\2V[\7\31\2\2WX\7\17\2\2XY\7\25\2\2Y[\7\26\2\2ZO\3"+
		"\2\2\2ZQ\3\2\2\2ZS\3\2\2\2ZU\3\2\2\2ZW\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2\\"+
		"]\7\t\2\2]^\7\16\2\2^_\7\25\2\2_`\5\20\t\2`a\7\26\2\2a\17\3\2\2\2bg\5"+
		"\22\n\2cd\7\21\2\2df\5\22\n\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2"+
		"hl\3\2\2\2ig\3\2\2\2jk\7\21\2\2km\5\24\13\2lj\3\2\2\2lm\3\2\2\2mp\3\2"+
		"\2\2np\5\24\13\2ob\3\2\2\2on\3\2\2\2p\21\3\2\2\2qr\7\n\2\2rs\7\22\2\2"+
		"st\5\26\f\2t\23\3\2\2\2uv\7\35\2\2vw\7\22\2\2wx\5\26\f\2x\25\3\2\2\2y"+
		"\u0083\7\13\2\2z\u0083\7\f\2\2{\u0083\7\r\2\2|\u0083\7\n\2\2}\u0083\7"+
		"\30\2\2~\u0083\7\31\2\2\177\u0080\7\25\2\2\u0080\u0083\7\26\2\2\u0081"+
		"\u0083\7\36\2\2\u0082y\3\2\2\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082|\3"+
		"\2\2\2\u0082}\3\2\2\2\u0082~\3\2\2\2\u0082\177\3\2\2\2\u0082\u0081\3\2"+
		"\2\2\u0083\27\3\2\2\2\20\31\34 \"/:=DKZglo\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}