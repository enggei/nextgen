// Generated from STParser.g4 by ANTLR 4.7
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
public class STParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOC_COMMENT=1, BLOCK_COMMENT=2, LINE_COMMENT=3, TMPL_COMMENT=4, HORZ_WS=5, 
		VERT_WS=6, ESCAPE=7, LDELIM=8, RBRACE=9, TEXT=10, LBRACE=11, RDELIM=12, 
		STRING=13, IF=14, ELSEIF=15, ELSE=16, ENDIF=17, SUPER=18, END=19, TRUE=20, 
		FALSE=21, AT=22, ELLIPSIS=23, DOT=24, COMMA=25, COLON=26, SEMI=27, AND=28, 
		OR=29, LPAREN=30, RPAREN=31, LBRACK=32, RBRACK=33, EQUALS=34, BANG=35, 
		ERR_CHAR=36, ID=37, PIPE=38;
	public static final int
		RULE_template = 0, RULE_elements = 1, RULE_element = 2, RULE_singleElement = 3, 
		RULE_compoundElement = 4, RULE_exprTag = 5, RULE_region = 6, RULE_subtemplate = 7, 
		RULE_ifstat = 8, RULE_conditional = 9, RULE_andConditional = 10, RULE_notConditional = 11, 
		RULE_notConditionalExpr = 12, RULE_exprOptions = 13, RULE_option = 14, 
		RULE_expr = 15, RULE_mapExpr = 16, RULE_memberExpr = 17, RULE_mapTemplateRef = 18, 
		RULE_includeExpr = 19, RULE_primary = 20, RULE_list = 21, RULE_args = 22, 
		RULE_argExprList = 23, RULE_namedArg = 24;
	public static final String[] ruleNames = {
		"template", "elements", "element", "singleElement", "compoundElement", 
		"exprTag", "region", "subtemplate", "ifstat", "conditional", "andConditional", 
		"notConditional", "notConditionalExpr", "exprOptions", "option", "expr", 
		"mapExpr", "memberExpr", "mapTemplateRef", "includeExpr", "primary", "list", 
		"args", "argExprList", "namedArg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'if'", "'elseif'", "'else'", "'endif'", "'super'", "'@end'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "TMPL_COMMENT", 
		"HORZ_WS", "VERT_WS", "ESCAPE", "LDELIM", "RBRACE", "TEXT", "LBRACE", 
		"RDELIM", "STRING", "IF", "ELSEIF", "ELSE", "ENDIF", "SUPER", "END", "TRUE", 
		"FALSE", "AT", "ELLIPSIS", "DOT", "COMMA", "COLON", "SEMI", "AND", "OR", 
		"LPAREN", "RPAREN", "LBRACK", "RBRACK", "EQUALS", "BANG", "ERR_CHAR", 
		"ID", "PIPE"
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
	public String getGrammarFileName() { return "STParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public STParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TemplateContext extends ParserRuleContext {
		public ElementsContext elements() {
			return getRuleContext(ElementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(STParser.EOF, 0); }
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_template);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			elements();
			setState(51);
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

	public static class ElementsContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementsContext elements() throws RecognitionException {
		ElementsContext _localctx = new ElementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_elements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(53);
					element();
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class ElementContext extends ParserRuleContext {
		public SingleElementContext singleElement() {
			return getRuleContext(SingleElementContext.class,0);
		}
		public CompoundElementContext compoundElement() {
			return getRuleContext(CompoundElementContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_element);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				singleElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				compoundElement();
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

	public static class SingleElementContext extends ParserRuleContext {
		public ExprTagContext exprTag() {
			return getRuleContext(ExprTagContext.class,0);
		}
		public List<TerminalNode> TEXT() { return getTokens(STParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(STParser.TEXT, i);
		}
		public SingleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterSingleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitSingleElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitSingleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleElementContext singleElement() throws RecognitionException {
		SingleElementContext _localctx = new SingleElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_singleElement);
		try {
			int _alt;
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LDELIM:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				exprTag();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(65); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(64);
						match(TEXT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(67); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class CompoundElementContext extends ParserRuleContext {
		public IfstatContext ifstat() {
			return getRuleContext(IfstatContext.class,0);
		}
		public RegionContext region() {
			return getRuleContext(RegionContext.class,0);
		}
		public CompoundElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterCompoundElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitCompoundElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitCompoundElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundElementContext compoundElement() throws RecognitionException {
		CompoundElementContext _localctx = new CompoundElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compoundElement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				ifstat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				region();
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

	public static class ExprTagContext extends ParserRuleContext {
		public TerminalNode LDELIM() { return getToken(STParser.LDELIM, 0); }
		public MapExprContext mapExpr() {
			return getRuleContext(MapExprContext.class,0);
		}
		public TerminalNode RDELIM() { return getToken(STParser.RDELIM, 0); }
		public TerminalNode SEMI() { return getToken(STParser.SEMI, 0); }
		public ExprOptionsContext exprOptions() {
			return getRuleContext(ExprOptionsContext.class,0);
		}
		public ExprTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterExprTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitExprTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitExprTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprTagContext exprTag() throws RecognitionException {
		ExprTagContext _localctx = new ExprTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exprTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(LDELIM);
			setState(76);
			mapExpr();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(77);
				match(SEMI);
				setState(78);
				exprOptions();
				}
			}

			setState(81);
			match(RDELIM);
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

	public static class RegionContext extends ParserRuleContext {
		public List<TerminalNode> LDELIM() { return getTokens(STParser.LDELIM); }
		public TerminalNode LDELIM(int i) {
			return getToken(STParser.LDELIM, i);
		}
		public TerminalNode AT() { return getToken(STParser.AT, 0); }
		public TerminalNode ID() { return getToken(STParser.ID, 0); }
		public List<TerminalNode> RDELIM() { return getTokens(STParser.RDELIM); }
		public TerminalNode RDELIM(int i) {
			return getToken(STParser.RDELIM, i);
		}
		public ElementsContext elements() {
			return getRuleContext(ElementsContext.class,0);
		}
		public TerminalNode END() { return getToken(STParser.END, 0); }
		public RegionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_region; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterRegion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitRegion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitRegion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegionContext region() throws RecognitionException {
		RegionContext _localctx = new RegionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_region);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(LDELIM);
			setState(84);
			match(AT);
			setState(85);
			match(ID);
			setState(86);
			match(RDELIM);
			setState(87);
			elements();
			setState(88);
			match(LDELIM);
			setState(89);
			match(END);
			setState(90);
			match(RDELIM);
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

	public static class SubtemplateContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(STParser.LBRACE, 0); }
		public ElementsContext elements() {
			return getRuleContext(ElementsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(STParser.RBRACE, 0); }
		public List<TerminalNode> ID() { return getTokens(STParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(STParser.ID, i);
		}
		public TerminalNode PIPE() { return getToken(STParser.PIPE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(STParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(STParser.COMMA, i);
		}
		public SubtemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterSubtemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitSubtemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitSubtemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtemplateContext subtemplate() throws RecognitionException {
		SubtemplateContext _localctx = new SubtemplateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_subtemplate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(LBRACE);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(93);
				match(ID);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(94);
					match(COMMA);
					setState(95);
					match(ID);
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
				match(PIPE);
				}
			}

			setState(104);
			elements();
			setState(105);
			match(RBRACE);
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

	public static class IfstatContext extends ParserRuleContext {
		public List<TerminalNode> LDELIM() { return getTokens(STParser.LDELIM); }
		public TerminalNode LDELIM(int i) {
			return getToken(STParser.LDELIM, i);
		}
		public TerminalNode IF() { return getToken(STParser.IF, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(STParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(STParser.LPAREN, i);
		}
		public List<ConditionalContext> conditional() {
			return getRuleContexts(ConditionalContext.class);
		}
		public ConditionalContext conditional(int i) {
			return getRuleContext(ConditionalContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(STParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(STParser.RPAREN, i);
		}
		public List<TerminalNode> RDELIM() { return getTokens(STParser.RDELIM); }
		public TerminalNode RDELIM(int i) {
			return getToken(STParser.RDELIM, i);
		}
		public List<ElementsContext> elements() {
			return getRuleContexts(ElementsContext.class);
		}
		public ElementsContext elements(int i) {
			return getRuleContext(ElementsContext.class,i);
		}
		public TerminalNode ENDIF() { return getToken(STParser.ENDIF, 0); }
		public List<TerminalNode> ELSEIF() { return getTokens(STParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(STParser.ELSEIF, i);
		}
		public TerminalNode ELSE() { return getToken(STParser.ELSE, 0); }
		public IfstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterIfstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitIfstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitIfstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatContext ifstat() throws RecognitionException {
		IfstatContext _localctx = new IfstatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifstat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(LDELIM);
			setState(108);
			match(IF);
			setState(109);
			match(LPAREN);
			setState(110);
			conditional();
			setState(111);
			match(RPAREN);
			setState(112);
			match(RDELIM);
			setState(113);
			elements();
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					match(LDELIM);
					setState(115);
					match(ELSEIF);
					setState(116);
					match(LPAREN);
					setState(117);
					conditional();
					setState(118);
					match(RPAREN);
					setState(119);
					match(RDELIM);
					setState(120);
					elements();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(127);
				match(LDELIM);
				setState(128);
				match(ELSE);
				setState(129);
				match(RDELIM);
				setState(130);
				elements();
				}
				break;
			}
			setState(133);
			match(LDELIM);
			setState(134);
			match(ENDIF);
			setState(135);
			match(RDELIM);
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

	public static class ConditionalContext extends ParserRuleContext {
		public List<AndConditionalContext> andConditional() {
			return getRuleContexts(AndConditionalContext.class);
		}
		public AndConditionalContext andConditional(int i) {
			return getRuleContext(AndConditionalContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(STParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(STParser.OR, i);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			andConditional();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(138);
				match(OR);
				setState(139);
				andConditional();
				}
				}
				setState(144);
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

	public static class AndConditionalContext extends ParserRuleContext {
		public List<NotConditionalContext> notConditional() {
			return getRuleContexts(NotConditionalContext.class);
		}
		public NotConditionalContext notConditional(int i) {
			return getRuleContext(NotConditionalContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(STParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(STParser.AND, i);
		}
		public AndConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andConditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterAndConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitAndConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitAndConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndConditionalContext andConditional() throws RecognitionException {
		AndConditionalContext _localctx = new AndConditionalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_andConditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			notConditional();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(146);
				match(AND);
				setState(147);
				notConditional();
				}
				}
				setState(152);
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

	public static class NotConditionalContext extends ParserRuleContext {
		public TerminalNode BANG() { return getToken(STParser.BANG, 0); }
		public NotConditionalContext notConditional() {
			return getRuleContext(NotConditionalContext.class,0);
		}
		public MemberExprContext memberExpr() {
			return getRuleContext(MemberExprContext.class,0);
		}
		public NotConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notConditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterNotConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitNotConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitNotConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotConditionalContext notConditional() throws RecognitionException {
		NotConditionalContext _localctx = new NotConditionalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_notConditional);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BANG:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(BANG);
				setState(154);
				notConditional();
				}
				break;
			case LBRACE:
			case STRING:
			case SUPER:
			case TRUE:
			case FALSE:
			case AT:
			case LPAREN:
			case LBRACK:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				memberExpr();
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

	public static class NotConditionalExprContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(STParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(STParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(STParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(STParser.DOT, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(STParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(STParser.LPAREN, i);
		}
		public List<MapExprContext> mapExpr() {
			return getRuleContexts(MapExprContext.class);
		}
		public MapExprContext mapExpr(int i) {
			return getRuleContext(MapExprContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(STParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(STParser.RPAREN, i);
		}
		public NotConditionalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notConditionalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterNotConditionalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitNotConditionalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitNotConditionalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotConditionalExprContext notConditionalExpr() throws RecognitionException {
		NotConditionalExprContext _localctx = new NotConditionalExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_notConditionalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(ID);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				setState(166);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(159);
					match(DOT);
					setState(160);
					match(ID);
					}
					break;
				case 2:
					{
					setState(161);
					match(DOT);
					setState(162);
					match(LPAREN);
					setState(163);
					mapExpr();
					setState(164);
					match(RPAREN);
					}
					break;
				}
				}
				setState(170);
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

	public static class ExprOptionsContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(STParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(STParser.COMMA, i);
		}
		public ExprOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterExprOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitExprOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitExprOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprOptionsContext exprOptions() throws RecognitionException {
		ExprOptionsContext _localctx = new ExprOptionsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			option();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(172);
				match(COMMA);
				setState(173);
				option();
				}
				}
				setState(178);
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

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(STParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(STParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(ID);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(180);
				match(EQUALS);
				setState(181);
				expr();
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

	public static class ExprContext extends ParserRuleContext {
		public MemberExprContext memberExpr() {
			return getRuleContext(MemberExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(STParser.COLON, 0); }
		public MapTemplateRefContext mapTemplateRef() {
			return getRuleContext(MapTemplateRefContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			memberExpr();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(185);
				match(COLON);
				setState(186);
				mapTemplateRef();
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

	public static class MapExprContext extends ParserRuleContext {
		public List<MemberExprContext> memberExpr() {
			return getRuleContexts(MemberExprContext.class);
		}
		public MemberExprContext memberExpr(int i) {
			return getRuleContext(MemberExprContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(STParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(STParser.COLON, i);
		}
		public List<MapTemplateRefContext> mapTemplateRef() {
			return getRuleContexts(MapTemplateRefContext.class);
		}
		public MapTemplateRefContext mapTemplateRef(int i) {
			return getRuleContext(MapTemplateRefContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(STParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(STParser.COMMA, i);
		}
		public MapExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterMapExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitMapExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitMapExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapExprContext mapExpr() throws RecognitionException {
		MapExprContext _localctx = new MapExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mapExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			memberExpr();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(192); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190);
					match(COMMA);
					setState(191);
					memberExpr();
					}
					}
					setState(194); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(196);
				match(COLON);
				setState(197);
				mapTemplateRef();
				}
			}

			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON) {
				{
				{
				setState(201);
				match(COLON);
				setState(202);
				mapTemplateRef();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(203);
					match(COMMA);
					setState(204);
					mapTemplateRef();
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(214);
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

	public static class MemberExprContext extends ParserRuleContext {
		public IncludeExprContext includeExpr() {
			return getRuleContext(IncludeExprContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(STParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(STParser.DOT, i);
		}
		public List<TerminalNode> ID() { return getTokens(STParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(STParser.ID, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(STParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(STParser.LPAREN, i);
		}
		public List<MapExprContext> mapExpr() {
			return getRuleContexts(MapExprContext.class);
		}
		public MapExprContext mapExpr(int i) {
			return getRuleContext(MapExprContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(STParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(STParser.RPAREN, i);
		}
		public MemberExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberExprContext memberExpr() throws RecognitionException {
		MemberExprContext _localctx = new MemberExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_memberExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			includeExpr();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				setState(223);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(216);
					match(DOT);
					setState(217);
					match(ID);
					}
					break;
				case 2:
					{
					setState(218);
					match(DOT);
					setState(219);
					match(LPAREN);
					setState(220);
					mapExpr();
					setState(221);
					match(RPAREN);
					}
					break;
				}
				}
				setState(227);
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

	public static class MapTemplateRefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(STParser.ID, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(STParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(STParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(STParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(STParser.RPAREN, i);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SubtemplateContext subtemplate() {
			return getRuleContext(SubtemplateContext.class,0);
		}
		public MapExprContext mapExpr() {
			return getRuleContext(MapExprContext.class,0);
		}
		public ArgExprListContext argExprList() {
			return getRuleContext(ArgExprListContext.class,0);
		}
		public MapTemplateRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapTemplateRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterMapTemplateRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitMapTemplateRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitMapTemplateRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapTemplateRefContext mapTemplateRef() throws RecognitionException {
		MapTemplateRefContext _localctx = new MapTemplateRefContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mapTemplateRef);
		int _la;
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(ID);
				setState(229);
				match(LPAREN);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << STRING) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << AT) | (1L << ELLIPSIS) | (1L << LPAREN) | (1L << LBRACK) | (1L << ID))) != 0)) {
					{
					setState(230);
					args();
					}
				}

				setState(233);
				match(RPAREN);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				subtemplate();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(LPAREN);
				setState(236);
				mapExpr();
				setState(237);
				match(RPAREN);
				setState(238);
				match(LPAREN);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << STRING) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << AT) | (1L << LPAREN) | (1L << LBRACK) | (1L << ID))) != 0)) {
					{
					setState(239);
					argExprList();
					}
				}

				setState(242);
				match(RPAREN);
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

	public static class IncludeExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(STParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(STParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(STParser.RPAREN, 0); }
		public MapExprContext mapExpr() {
			return getRuleContext(MapExprContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(STParser.SUPER, 0); }
		public TerminalNode DOT() { return getToken(STParser.DOT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode AT() { return getToken(STParser.AT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public IncludeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterIncludeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitIncludeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitIncludeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeExprContext includeExpr() throws RecognitionException {
		IncludeExprContext _localctx = new IncludeExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_includeExpr);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(ID);
				setState(247);
				match(LPAREN);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << STRING) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << AT) | (1L << LPAREN) | (1L << LBRACK) | (1L << ID))) != 0)) {
					{
					setState(248);
					mapExpr();
					}
				}

				setState(251);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				match(SUPER);
				setState(253);
				match(DOT);
				setState(254);
				match(ID);
				setState(255);
				match(LPAREN);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << STRING) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << AT) | (1L << ELLIPSIS) | (1L << LPAREN) | (1L << LBRACK) | (1L << ID))) != 0)) {
					{
					setState(256);
					args();
					}
				}

				setState(259);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				match(ID);
				setState(261);
				match(LPAREN);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << STRING) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << AT) | (1L << ELLIPSIS) | (1L << LPAREN) | (1L << LBRACK) | (1L << ID))) != 0)) {
					{
					setState(262);
					args();
					}
				}

				setState(265);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(266);
				match(AT);
				setState(267);
				match(SUPER);
				setState(268);
				match(DOT);
				setState(269);
				match(ID);
				setState(270);
				match(LPAREN);
				setState(271);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(272);
				match(AT);
				setState(273);
				match(ID);
				setState(274);
				match(LPAREN);
				setState(275);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(276);
				primary();
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

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(STParser.ID, 0); }
		public TerminalNode STRING() { return getToken(STParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(STParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(STParser.FALSE, 0); }
		public SubtemplateContext subtemplate() {
			return getRuleContext(SubtemplateContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(STParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(STParser.LPAREN, i);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(STParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(STParser.RPAREN, i);
		}
		public MapExprContext mapExpr() {
			return getRuleContext(MapExprContext.class,0);
		}
		public ArgExprListContext argExprList() {
			return getRuleContext(ArgExprListContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primary);
		int _la;
		try {
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				subtemplate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
				list();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(285);
				match(LPAREN);
				setState(286);
				conditional();
				setState(287);
				match(RPAREN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(289);
				match(LPAREN);
				setState(290);
				mapExpr();
				setState(291);
				match(RPAREN);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(292);
					match(LPAREN);
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << STRING) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << AT) | (1L << LPAREN) | (1L << LBRACK) | (1L << ID))) != 0)) {
						{
						setState(293);
						argExprList();
						}
					}

					setState(296);
					match(RPAREN);
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(STParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(STParser.RBRACK, 0); }
		public ArgExprListContext argExprList() {
			return getRuleContext(ArgExprListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(LBRACK);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << STRING) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << AT) | (1L << LPAREN) | (1L << LBRACK) | (1L << ID))) != 0)) {
				{
				setState(302);
				argExprList();
				}
			}

			setState(305);
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

	public static class ArgsContext extends ParserRuleContext {
		public ArgExprListContext argExprList() {
			return getRuleContext(ArgExprListContext.class,0);
		}
		public List<NamedArgContext> namedArg() {
			return getRuleContexts(NamedArgContext.class);
		}
		public NamedArgContext namedArg(int i) {
			return getRuleContext(NamedArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(STParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(STParser.COMMA, i);
		}
		public TerminalNode ELLIPSIS() { return getToken(STParser.ELLIPSIS, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_args);
		int _la;
		try {
			int _alt;
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				argExprList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				namedArg();
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(309);
						match(COMMA);
						setState(310);
						namedArg();
						}
						} 
					}
					setState(315);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(316);
					match(COMMA);
					setState(317);
					match(ELLIPSIS);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				match(ELLIPSIS);
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

	public static class ArgExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(STParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(STParser.COMMA, i);
		}
		public ArgExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argExprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterArgExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitArgExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitArgExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgExprListContext argExprList() throws RecognitionException {
		ArgExprListContext _localctx = new ArgExprListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_argExprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			expr();
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(324);
				match(COMMA);
				setState(325);
				expr();
				}
				}
				setState(330);
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

	public static class NamedArgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(STParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(STParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NamedArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).enterNamedArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof STParserListener ) ((STParserListener)listener).exitNamedArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof STParserVisitor ) return ((STParserVisitor<? extends T>)visitor).visitNamedArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedArgContext namedArg() throws RecognitionException {
		NamedArgContext _localctx = new NamedArgContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_namedArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(ID);
			setState(332);
			match(EQUALS);
			setState(333);
			expr();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0152\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\3\7\39\n\3\f\3\16\3<\13\3\3\4\3\4\5\4@\n\4\3"+
		"\5\3\5\6\5D\n\5\r\5\16\5E\5\5H\n\5\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\5"+
		"\7R\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7"+
		"\tc\n\t\f\t\16\tf\13\t\3\t\5\ti\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n}\n\n\f\n\16\n\u0080\13\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0086\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u008f"+
		"\n\13\f\13\16\13\u0092\13\13\3\f\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a"+
		"\13\f\3\r\3\r\3\r\5\r\u009f\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u00a9\n\16\f\16\16\16\u00ac\13\16\3\17\3\17\3\17\7\17\u00b1\n\17"+
		"\f\17\16\17\u00b4\13\17\3\20\3\20\3\20\5\20\u00b9\n\20\3\21\3\21\3\21"+
		"\5\21\u00be\n\21\3\22\3\22\3\22\6\22\u00c3\n\22\r\22\16\22\u00c4\3\22"+
		"\3\22\3\22\5\22\u00ca\n\22\3\22\3\22\3\22\3\22\7\22\u00d0\n\22\f\22\16"+
		"\22\u00d3\13\22\7\22\u00d5\n\22\f\22\16\22\u00d8\13\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u00e2\n\23\f\23\16\23\u00e5\13\23\3\24"+
		"\3\24\3\24\5\24\u00ea\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f3"+
		"\n\24\3\24\3\24\5\24\u00f7\n\24\3\25\3\25\3\25\5\25\u00fc\n\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0104\n\25\3\25\3\25\3\25\3\25\5\25\u010a"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u0118\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u0129\n\26\3\26\5\26\u012c\n\26\5\26\u012e\n\26\3"+
		"\27\3\27\5\27\u0132\n\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u013a\n\30"+
		"\f\30\16\30\u013d\13\30\3\30\3\30\5\30\u0141\n\30\3\30\5\30\u0144\n\30"+
		"\3\31\3\31\3\31\7\31\u0149\n\31\f\31\16\31\u014c\13\31\3\32\3\32\3\32"+
		"\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\2\2\2\u016b\2\64\3\2\2\2\4:\3\2\2\2\6?\3\2\2\2\bG\3\2\2\2\nK\3\2\2\2"+
		"\fM\3\2\2\2\16U\3\2\2\2\20^\3\2\2\2\22m\3\2\2\2\24\u008b\3\2\2\2\26\u0093"+
		"\3\2\2\2\30\u009e\3\2\2\2\32\u00a0\3\2\2\2\34\u00ad\3\2\2\2\36\u00b5\3"+
		"\2\2\2 \u00ba\3\2\2\2\"\u00bf\3\2\2\2$\u00d9\3\2\2\2&\u00f6\3\2\2\2(\u0117"+
		"\3\2\2\2*\u012d\3\2\2\2,\u012f\3\2\2\2.\u0143\3\2\2\2\60\u0145\3\2\2\2"+
		"\62\u014d\3\2\2\2\64\65\5\4\3\2\65\66\7\2\2\3\66\3\3\2\2\2\679\5\6\4\2"+
		"8\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\5\3\2\2\2<:\3\2\2\2=@\5\b"+
		"\5\2>@\5\n\6\2?=\3\2\2\2?>\3\2\2\2@\7\3\2\2\2AH\5\f\7\2BD\7\f\2\2CB\3"+
		"\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GA\3\2\2\2GC\3\2\2\2H\t"+
		"\3\2\2\2IL\5\22\n\2JL\5\16\b\2KI\3\2\2\2KJ\3\2\2\2L\13\3\2\2\2MN\7\n\2"+
		"\2NQ\5\"\22\2OP\7\35\2\2PR\5\34\17\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7"+
		"\16\2\2T\r\3\2\2\2UV\7\n\2\2VW\7\30\2\2WX\7\'\2\2XY\7\16\2\2YZ\5\4\3\2"+
		"Z[\7\n\2\2[\\\7\25\2\2\\]\7\16\2\2]\17\3\2\2\2^h\7\r\2\2_d\7\'\2\2`a\7"+
		"\33\2\2ac\7\'\2\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd"+
		"\3\2\2\2gi\7(\2\2h_\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\5\4\3\2kl\7\13\2\2l"+
		"\21\3\2\2\2mn\7\n\2\2no\7\20\2\2op\7 \2\2pq\5\24\13\2qr\7!\2\2rs\7\16"+
		"\2\2s~\5\4\3\2tu\7\n\2\2uv\7\21\2\2vw\7 \2\2wx\5\24\13\2xy\7!\2\2yz\7"+
		"\16\2\2z{\5\4\3\2{}\3\2\2\2|t\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3"+
		"\2\2\2\177\u0085\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\n\2\2\u0082\u0083"+
		"\7\22\2\2\u0083\u0084\7\16\2\2\u0084\u0086\5\4\3\2\u0085\u0081\3\2\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\n\2\2\u0088\u0089"+
		"\7\23\2\2\u0089\u008a\7\16\2\2\u008a\23\3\2\2\2\u008b\u0090\5\26\f\2\u008c"+
		"\u008d\7\37\2\2\u008d\u008f\5\26\f\2\u008e\u008c\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\25\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0098\5\30\r\2\u0094\u0095\7\36\2\2\u0095\u0097\5"+
		"\30\r\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\27\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7%\2\2"+
		"\u009c\u009f\5\30\r\2\u009d\u009f\5$\23\2\u009e\u009b\3\2\2\2\u009e\u009d"+
		"\3\2\2\2\u009f\31\3\2\2\2\u00a0\u00aa\7\'\2\2\u00a1\u00a2\7\32\2\2\u00a2"+
		"\u00a9\7\'\2\2\u00a3\u00a4\7\32\2\2\u00a4\u00a5\7 \2\2\u00a5\u00a6\5\""+
		"\22\2\u00a6\u00a7\7!\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8"+
		"\u00a3\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\33\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b2\5\36\20\2\u00ae"+
		"\u00af\7\33\2\2\u00af\u00b1\5\36\20\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\35\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b5\u00b8\7\'\2\2\u00b6\u00b7\7$\2\2\u00b7\u00b9\5 \21"+
		"\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\37\3\2\2\2\u00ba\u00bd"+
		"\5$\23\2\u00bb\u00bc\7\34\2\2\u00bc\u00be\5&\24\2\u00bd\u00bb\3\2\2\2"+
		"\u00bd\u00be\3\2\2\2\u00be!\3\2\2\2\u00bf\u00c9\5$\23\2\u00c0\u00c1\7"+
		"\33\2\2\u00c1\u00c3\5$\23\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7\34"+
		"\2\2\u00c7\u00c8\5&\24\2\u00c8\u00ca\3\2\2\2\u00c9\u00c2\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00d6\3\2\2\2\u00cb\u00cc\7\34\2\2\u00cc\u00d1\5"+
		"&\24\2\u00cd\u00ce\7\33\2\2\u00ce\u00d0\5&\24\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00cb\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7#\3\2\2\2\u00d8\u00d6\3\2\2\2"+
		"\u00d9\u00e3\5(\25\2\u00da\u00db\7\32\2\2\u00db\u00e2\7\'\2\2\u00dc\u00dd"+
		"\7\32\2\2\u00dd\u00de\7 \2\2\u00de\u00df\5\"\22\2\u00df\u00e0\7!\2\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00da\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e2\u00e5\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4%\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e6\u00e7\7\'\2\2\u00e7\u00e9\7 \2\2\u00e8\u00ea\5.\30\2\u00e9"+
		"\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f7\7!"+
		"\2\2\u00ec\u00f7\5\20\t\2\u00ed\u00ee\7 \2\2\u00ee\u00ef\5\"\22\2\u00ef"+
		"\u00f0\7!\2\2\u00f0\u00f2\7 \2\2\u00f1\u00f3\5\60\31\2\u00f2\u00f1\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7!\2\2\u00f5"+
		"\u00f7\3\2\2\2\u00f6\u00e6\3\2\2\2\u00f6\u00ec\3\2\2\2\u00f6\u00ed\3\2"+
		"\2\2\u00f7\'\3\2\2\2\u00f8\u00f9\7\'\2\2\u00f9\u00fb\7 \2\2\u00fa\u00fc"+
		"\5\"\22\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2"+
		"\u00fd\u0118\7!\2\2\u00fe\u00ff\7\24\2\2\u00ff\u0100\7\32\2\2\u0100\u0101"+
		"\7\'\2\2\u0101\u0103\7 \2\2\u0102\u0104\5.\30\2\u0103\u0102\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0118\7!\2\2\u0106\u0107\7\'"+
		"\2\2\u0107\u0109\7 \2\2\u0108\u010a\5.\30\2\u0109\u0108\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0118\7!\2\2\u010c\u010d\7\30"+
		"\2\2\u010d\u010e\7\24\2\2\u010e\u010f\7\32\2\2\u010f\u0110\7\'\2\2\u0110"+
		"\u0111\7 \2\2\u0111\u0118\7!\2\2\u0112\u0113\7\30\2\2\u0113\u0114\7\'"+
		"\2\2\u0114\u0115\7 \2\2\u0115\u0118\7!\2\2\u0116\u0118\5*\26\2\u0117\u00f8"+
		"\3\2\2\2\u0117\u00fe\3\2\2\2\u0117\u0106\3\2\2\2\u0117\u010c\3\2\2\2\u0117"+
		"\u0112\3\2\2\2\u0117\u0116\3\2\2\2\u0118)\3\2\2\2\u0119\u012e\7\'\2\2"+
		"\u011a\u012e\7\17\2\2\u011b\u012e\7\26\2\2\u011c\u012e\7\27\2\2\u011d"+
		"\u012e\5\20\t\2\u011e\u012e\5,\27\2\u011f\u0120\7 \2\2\u0120\u0121\5\24"+
		"\13\2\u0121\u0122\7!\2\2\u0122\u012e\3\2\2\2\u0123\u0124\7 \2\2\u0124"+
		"\u0125\5\"\22\2\u0125\u012b\7!\2\2\u0126\u0128\7 \2\2\u0127\u0129\5\60"+
		"\31\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012c\7!\2\2\u012b\u0126\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2"+
		"\2\2\u012d\u0119\3\2\2\2\u012d\u011a\3\2\2\2\u012d\u011b\3\2\2\2\u012d"+
		"\u011c\3\2\2\2\u012d\u011d\3\2\2\2\u012d\u011e\3\2\2\2\u012d\u011f\3\2"+
		"\2\2\u012d\u0123\3\2\2\2\u012e+\3\2\2\2\u012f\u0131\7\"\2\2\u0130\u0132"+
		"\5\60\31\2\u0131\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2"+
		"\u0133\u0134\7#\2\2\u0134-\3\2\2\2\u0135\u0144\5\60\31\2\u0136\u013b\5"+
		"\62\32\2\u0137\u0138\7\33\2\2\u0138\u013a\5\62\32\2\u0139\u0137\3\2\2"+
		"\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u0140"+
		"\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7\33\2\2\u013f\u0141\7\31\2\2"+
		"\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0144"+
		"\7\31\2\2\u0143\u0135\3\2\2\2\u0143\u0136\3\2\2\2\u0143\u0142\3\2\2\2"+
		"\u0144/\3\2\2\2\u0145\u014a\5 \21\2\u0146\u0147\7\33\2\2\u0147\u0149\5"+
		" \21\2\u0148\u0146\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\61\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\7\'\2"+
		"\2\u014e\u014f\7$\2\2\u014f\u0150\5 \21\2\u0150\63\3\2\2\2):?EGKQdh~\u0085"+
		"\u0090\u0098\u009e\u00a8\u00aa\u00b2\u00b8\u00bd\u00c4\u00c9\u00d1\u00d6"+
		"\u00e1\u00e3\u00e9\u00f2\u00f6\u00fb\u0103\u0109\u0117\u0128\u012b\u012d"+
		"\u0131\u013b\u0140\u0143\u014a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}