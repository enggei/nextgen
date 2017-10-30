// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/python/parser/Python3.g4 by ANTLR 4.7
package com.generator.generators.python.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Python3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=1, DEF=2, RETURN=3, RAISE=4, FROM=5, IMPORT=6, AS=7, GLOBAL=8, NONLOCAL=9, 
		ASSERT=10, IF=11, ELIF=12, ELSE=13, WHILE=14, FOR=15, IN=16, TRY=17, FINALLY=18, 
		WITH=19, EXCEPT=20, LAMBDA=21, OR=22, AND=23, NOT=24, IS=25, NONE=26, 
		TRUE=27, FALSE=28, CLASS=29, YIELD=30, DEL=31, PASS=32, CONTINUE=33, BREAK=34, 
		NEWLINE=35, NAME=36, STRING_LITERAL=37, BYTES_LITERAL=38, DECIMAL_INTEGER=39, 
		OCT_INTEGER=40, HEX_INTEGER=41, BIN_INTEGER=42, FLOAT_NUMBER=43, IMAG_NUMBER=44, 
		DOT=45, ELLIPSIS=46, STAR=47, OPEN_PAREN=48, CLOSE_PAREN=49, COMMA=50, 
		COLON=51, SEMI_COLON=52, POWER=53, ASSIGN=54, OPEN_BRACK=55, CLOSE_BRACK=56, 
		OR_OP=57, XOR=58, AND_OP=59, LEFT_SHIFT=60, RIGHT_SHIFT=61, ADD=62, MINUS=63, 
		DIV=64, MOD=65, IDIV=66, NOT_OP=67, OPEN_BRACE=68, CLOSE_BRACE=69, LESS_THAN=70, 
		GREATER_THAN=71, EQUALS=72, GT_EQ=73, LT_EQ=74, NOT_EQ_1=75, NOT_EQ_2=76, 
		AT=77, ARROW=78, ADD_ASSIGN=79, SUB_ASSIGN=80, MULT_ASSIGN=81, AT_ASSIGN=82, 
		DIV_ASSIGN=83, MOD_ASSIGN=84, AND_ASSIGN=85, OR_ASSIGN=86, XOR_ASSIGN=87, 
		LEFT_SHIFT_ASSIGN=88, RIGHT_SHIFT_ASSIGN=89, POWER_ASSIGN=90, IDIV_ASSIGN=91, 
		SKIP_=92, UNKNOWN_CHAR=93, INDENT=94, DEDENT=95;
	public static final int
		RULE_single_input = 0, RULE_file_input = 1, RULE_eval_input = 2, RULE_decorator = 3, 
		RULE_decorators = 4, RULE_decorated = 5, RULE_funcdef = 6, RULE_parameters = 7, 
		RULE_typedargslist = 8, RULE_tfpdef = 9, RULE_varargslist = 10, RULE_vfpdef = 11, 
		RULE_stmt = 12, RULE_simple_stmt = 13, RULE_small_stmt = 14, RULE_print_stmt = 15, 
		RULE_expr_stmt = 16, RULE_testlist_star_expr = 17, RULE_augassign = 18, 
		RULE_del_stmt = 19, RULE_pass_stmt = 20, RULE_flow_stmt = 21, RULE_break_stmt = 22, 
		RULE_continue_stmt = 23, RULE_return_stmt = 24, RULE_yield_stmt = 25, 
		RULE_raise_stmt = 26, RULE_import_stmt = 27, RULE_import_name = 28, RULE_import_from = 29, 
		RULE_import_as_name = 30, RULE_dotted_as_name = 31, RULE_import_as_names = 32, 
		RULE_dotted_as_names = 33, RULE_dotted_name = 34, RULE_global_stmt = 35, 
		RULE_nonlocal_stmt = 36, RULE_assert_stmt = 37, RULE_compound_stmt = 38, 
		RULE_if_stmt = 39, RULE_while_stmt = 40, RULE_for_stmt = 41, RULE_try_stmt = 42, 
		RULE_with_stmt = 43, RULE_with_item = 44, RULE_except_clause = 45, RULE_suite = 46, 
		RULE_test = 47, RULE_test_nocond = 48, RULE_lambdef = 49, RULE_lambdef_nocond = 50, 
		RULE_or_test = 51, RULE_and_test = 52, RULE_not_test = 53, RULE_comparison = 54, 
		RULE_comp_op = 55, RULE_star_expr = 56, RULE_expr = 57, RULE_xor_expr = 58, 
		RULE_and_expr = 59, RULE_shift_expr = 60, RULE_arith_expr = 61, RULE_term = 62, 
		RULE_factor = 63, RULE_power = 64, RULE_atom = 65, RULE_testlist_comp = 66, 
		RULE_trailer = 67, RULE_subscriptlist = 68, RULE_subscript = 69, RULE_sliceop = 70, 
		RULE_exprlist = 71, RULE_testlist = 72, RULE_dictorsetmaker = 73, RULE_classdef = 74, 
		RULE_arglist = 75, RULE_argument = 76, RULE_comp_iter = 77, RULE_comp_for = 78, 
		RULE_comp_if = 79, RULE_yield_expr = 80, RULE_yield_arg = 81, RULE_str = 82, 
		RULE_number = 83, RULE_integer = 84;
	public static final String[] ruleNames = {
		"single_input", "file_input", "eval_input", "decorator", "decorators", 
		"decorated", "funcdef", "parameters", "typedargslist", "tfpdef", "varargslist", 
		"vfpdef", "stmt", "simple_stmt", "small_stmt", "print_stmt", "expr_stmt", 
		"testlist_star_expr", "augassign", "del_stmt", "pass_stmt", "flow_stmt", 
		"break_stmt", "continue_stmt", "return_stmt", "yield_stmt", "raise_stmt", 
		"import_stmt", "import_name", "import_from", "import_as_name", "dotted_as_name", 
		"import_as_names", "dotted_as_names", "dotted_name", "global_stmt", "nonlocal_stmt", 
		"assert_stmt", "compound_stmt", "if_stmt", "while_stmt", "for_stmt", "try_stmt", 
		"with_stmt", "with_item", "except_clause", "suite", "test", "test_nocond", 
		"lambdef", "lambdef_nocond", "or_test", "and_test", "not_test", "comparison", 
		"comp_op", "star_expr", "expr", "xor_expr", "and_expr", "shift_expr", 
		"arith_expr", "term", "factor", "power", "atom", "testlist_comp", "trailer", 
		"subscriptlist", "subscript", "sliceop", "exprlist", "testlist", "dictorsetmaker", 
		"classdef", "arglist", "argument", "comp_iter", "comp_for", "comp_if", 
		"yield_expr", "yield_arg", "str", "number", "integer"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'print'", "'def'", "'return'", "'raise'", "'from'", "'import'", 
		"'as'", "'global'", "'nonlocal'", "'assert'", "'if'", "'elif'", "'else'", 
		"'while'", "'for'", "'in'", "'try'", "'finally'", "'with'", "'except'", 
		"'lambda'", "'or'", "'and'", "'not'", "'is'", "'None'", "'True'", "'False'", 
		"'class'", "'yield'", "'del'", "'pass'", "'continue'", "'break'", null, 
		null, null, null, null, null, null, null, null, null, "'.'", "'...'", 
		"'*'", "'('", "')'", "','", "':'", "';'", "'**'", "'='", "'['", "']'", 
		"'|'", "'^'", "'&'", "'<<'", "'>>'", "'+'", "'-'", "'/'", "'%'", "'//'", 
		"'~'", "'{'", "'}'", "'<'", "'>'", "'=='", "'>='", "'<='", "'<>'", "'!='", 
		"'@'", "'->'", "'+='", "'-='", "'*='", "'@='", "'/='", "'%='", "'&='", 
		"'|='", "'^='", "'<<='", "'>>='", "'**='", "'//='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PRINT", "DEF", "RETURN", "RAISE", "FROM", "IMPORT", "AS", "GLOBAL", 
		"NONLOCAL", "ASSERT", "IF", "ELIF", "ELSE", "WHILE", "FOR", "IN", "TRY", 
		"FINALLY", "WITH", "EXCEPT", "LAMBDA", "OR", "AND", "NOT", "IS", "NONE", 
		"TRUE", "FALSE", "CLASS", "YIELD", "DEL", "PASS", "CONTINUE", "BREAK", 
		"NEWLINE", "NAME", "STRING_LITERAL", "BYTES_LITERAL", "DECIMAL_INTEGER", 
		"OCT_INTEGER", "HEX_INTEGER", "BIN_INTEGER", "FLOAT_NUMBER", "IMAG_NUMBER", 
		"DOT", "ELLIPSIS", "STAR", "OPEN_PAREN", "CLOSE_PAREN", "COMMA", "COLON", 
		"SEMI_COLON", "POWER", "ASSIGN", "OPEN_BRACK", "CLOSE_BRACK", "OR_OP", 
		"XOR", "AND_OP", "LEFT_SHIFT", "RIGHT_SHIFT", "ADD", "MINUS", "DIV", "MOD", 
		"IDIV", "NOT_OP", "OPEN_BRACE", "CLOSE_BRACE", "LESS_THAN", "GREATER_THAN", 
		"EQUALS", "GT_EQ", "LT_EQ", "NOT_EQ_1", "NOT_EQ_2", "AT", "ARROW", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MULT_ASSIGN", "AT_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", 
		"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "LEFT_SHIFT_ASSIGN", "RIGHT_SHIFT_ASSIGN", 
		"POWER_ASSIGN", "IDIV_ASSIGN", "SKIP_", "UNKNOWN_CHAR", "INDENT", "DEDENT"
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
	public String getGrammarFileName() { return "Python3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	  // Used in preventing double NoViableAltException throws on the current context's same start token.
	  static protected final int ALREADY_THROWN_TOKEN_TYPE = Integer.MIN_VALUE + 23;


	  // Whether we've encountered something that is legal Python2
	  private boolean likelyIsPython2 = false;

	  // This overly long variable denotes whether we should emit exceptions on illegal Python 3 items
	  //	(for example, no parens used in a print statement.) If you wish to use this parser to detect
	  //	legal Python2, this should be set to false via setStrictPython3Parsing(boolean).
	  private boolean throwNoViableAltExceptionOnLegalPython2ButIllegalPython3 = true;

	  // This will return an invalid value if getStrictPython3Parsing() returned true prior to parsing.
	  public boolean parsedCodeWasPython2 () {
	  	return this.likelyIsPython2;
	  }

	  public boolean getStrictPython3Parsing () {
	  	return this.throwNoViableAltExceptionOnLegalPython2ButIllegalPython3;
	  }

	  // Setting this to true will throw NoViableAltExceptions upon encountering Python2-only code facets; this is true
	  //	by default. Set this to false prior to parsing if you wish to invoke parsedCodeWasPython2() after parsing.
	  public void setStrictPython3Parsing (boolean flag) {
	  	this.throwNoViableAltExceptionOnLegalPython2ButIllegalPython3 = flag;
	  }


	public Python3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Single_inputContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Single_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterSingle_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitSingle_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSingle_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_inputContext single_input() throws RecognitionException {
		Single_inputContext _localctx = new Single_inputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_single_input);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(NEWLINE);
				}
				break;
			case PRINT:
			case RETURN:
			case RAISE:
			case FROM:
			case IMPORT:
			case GLOBAL:
			case NONLOCAL:
			case ASSERT:
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case YIELD:
			case DEL:
			case PASS:
			case CONTINUE:
			case BREAK:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				simple_stmt();
				}
				break;
			case DEF:
			case IF:
			case WHILE:
			case FOR:
			case TRY:
			case WITH:
			case CLASS:
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				compound_stmt();
				setState(173);
				match(NEWLINE);
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

	public static class File_inputContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Python3Parser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(Python3Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(Python3Parser.NEWLINE, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public File_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterFile_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitFile_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFile_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_file_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << DEF) | (1L << RETURN) | (1L << RAISE) | (1L << FROM) | (1L << IMPORT) | (1L << GLOBAL) | (1L << NONLOCAL) | (1L << ASSERT) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << TRY) | (1L << WITH) | (1L << LAMBDA) | (1L << NOT) | (1L << NONE) | (1L << TRUE) | (1L << FALSE) | (1L << CLASS) | (1L << YIELD) | (1L << DEL) | (1L << PASS) | (1L << CONTINUE) | (1L << BREAK) | (1L << NEWLINE) | (1L << NAME) | (1L << STRING_LITERAL) | (1L << BYTES_LITERAL) | (1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER) | (1L << FLOAT_NUMBER) | (1L << IMAG_NUMBER) | (1L << ELLIPSIS) | (1L << STAR) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (NOT_OP - 67)) | (1L << (OPEN_BRACE - 67)) | (1L << (AT - 67)))) != 0)) {
				{
				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(177);
					match(NEWLINE);
					}
					break;
				case PRINT:
				case DEF:
				case RETURN:
				case RAISE:
				case FROM:
				case IMPORT:
				case GLOBAL:
				case NONLOCAL:
				case ASSERT:
				case IF:
				case WHILE:
				case FOR:
				case TRY:
				case WITH:
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case CLASS:
				case YIELD:
				case DEL:
				case PASS:
				case CONTINUE:
				case BREAK:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
				case AT:
					{
					setState(178);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
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

	public static class Eval_inputContext extends ParserRuleContext {
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Python3Parser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(Python3Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(Python3Parser.NEWLINE, i);
		}
		public Eval_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterEval_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitEval_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitEval_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eval_inputContext eval_input() throws RecognitionException {
		Eval_inputContext _localctx = new Eval_inputContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eval_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			testlist();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(187);
				match(NEWLINE);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
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

	public static class DecoratorContext extends ParserRuleContext {
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public DecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDecorator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDecorator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecoratorContext decorator() throws RecognitionException {
		DecoratorContext _localctx = new DecoratorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decorator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(AT);
			setState(196);
			dotted_name();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(197);
				match(OPEN_PAREN);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (POWER - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(198);
					arglist();
					}
				}

				setState(201);
				match(CLOSE_PAREN);
				}
			}

			setState(204);
			match(NEWLINE);
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

	public static class DecoratorsContext extends ParserRuleContext {
		public List<DecoratorContext> decorator() {
			return getRuleContexts(DecoratorContext.class);
		}
		public DecoratorContext decorator(int i) {
			return getRuleContext(DecoratorContext.class,i);
		}
		public DecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDecorators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDecorators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecoratorsContext decorators() throws RecognitionException {
		DecoratorsContext _localctx = new DecoratorsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decorators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(206);
				decorator();
				}
				}
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AT );
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

	public static class DecoratedContext extends ParserRuleContext {
		public DecoratorsContext decorators() {
			return getRuleContext(DecoratorsContext.class,0);
		}
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public DecoratedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDecorated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDecorated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDecorated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecoratedContext decorated() throws RecognitionException {
		DecoratedContext _localctx = new DecoratedContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decorated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			decorators();
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(212);
				classdef();
				}
				break;
			case DEF:
				{
				setState(213);
				funcdef();
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

	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(Python3Parser.DEF, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitFuncdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(DEF);
			setState(217);
			match(NAME);
			setState(218);
			parameters();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(219);
				match(ARROW);
				setState(220);
				test();
				}
			}

			setState(223);
			match(COLON);
			setState(224);
			suite();
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

	public static class ParametersContext extends ParserRuleContext {
		public TypedargslistContext typedargslist() {
			return getRuleContext(TypedargslistContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(OPEN_PAREN);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STAR) | (1L << POWER))) != 0)) {
				{
				setState(227);
				typedargslist();
				}
			}

			setState(230);
			match(CLOSE_PAREN);
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

	public static class TypedargslistContext extends ParserRuleContext {
		public List<TfpdefContext> tfpdef() {
			return getRuleContexts(TfpdefContext.class);
		}
		public TfpdefContext tfpdef(int i) {
			return getRuleContext(TfpdefContext.class,i);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TypedargslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedargslist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTypedargslist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTypedargslist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTypedargslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedargslistContext typedargslist() throws RecognitionException {
		TypedargslistContext _localctx = new TypedargslistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typedargslist);
		int _la;
		try {
			int _alt;
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				tfpdef();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(233);
					match(ASSIGN);
					setState(234);
					test();
					}
				}

				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(237);
						match(COMMA);
						setState(238);
						tfpdef();
						setState(241);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(239);
							match(ASSIGN);
							setState(240);
							test();
							}
						}

						}
						} 
					}
					setState(247);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(248);
					match(COMMA);
					setState(271);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STAR:
						{
						setState(249);
						match(STAR);
						setState(251);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NAME) {
							{
							setState(250);
							tfpdef();
							}
						}

						setState(261);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(253);
								match(COMMA);
								setState(254);
								tfpdef();
								setState(257);
								_errHandler.sync(this);
								_la = _input.LA(1);
								if (_la==ASSIGN) {
									{
									setState(255);
									match(ASSIGN);
									setState(256);
									test();
									}
								}

								}
								} 
							}
							setState(263);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						}
						setState(267);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(264);
							match(COMMA);
							setState(265);
							match(POWER);
							setState(266);
							tfpdef();
							}
						}

						}
						break;
					case POWER:
						{
						setState(269);
						match(POWER);
						setState(270);
						tfpdef();
						}
						break;
					case CLOSE_PAREN:
						break;
					default:
						break;
					}
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(STAR);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(276);
					tfpdef();
					}
				}

				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(279);
						match(COMMA);
						setState(280);
						tfpdef();
						setState(283);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(281);
							match(ASSIGN);
							setState(282);
							test();
							}
						}

						}
						} 
					}
					setState(289);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(290);
					match(COMMA);
					setState(291);
					match(POWER);
					setState(292);
					tfpdef();
					}
				}

				}
				break;
			case POWER:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(POWER);
				setState(296);
				tfpdef();
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

	public static class TfpdefContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TfpdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfpdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTfpdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTfpdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTfpdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TfpdefContext tfpdef() throws RecognitionException {
		TfpdefContext _localctx = new TfpdefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tfpdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(NAME);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(300);
				match(COLON);
				setState(301);
				test();
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

	public static class VarargslistContext extends ParserRuleContext {
		public List<VfpdefContext> vfpdef() {
			return getRuleContexts(VfpdefContext.class);
		}
		public VfpdefContext vfpdef(int i) {
			return getRuleContext(VfpdefContext.class,i);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public VarargslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varargslist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterVarargslist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitVarargslist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitVarargslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarargslistContext varargslist() throws RecognitionException {
		VarargslistContext _localctx = new VarargslistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varargslist);
		int _la;
		try {
			int _alt;
			setState(369);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				vfpdef();
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(305);
					match(ASSIGN);
					setState(306);
					test();
					}
				}

				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(309);
						match(COMMA);
						setState(310);
						vfpdef();
						setState(313);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(311);
							match(ASSIGN);
							setState(312);
							test();
							}
						}

						}
						} 
					}
					setState(319);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(320);
					match(COMMA);
					setState(343);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STAR:
						{
						setState(321);
						match(STAR);
						setState(323);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NAME) {
							{
							setState(322);
							vfpdef();
							}
						}

						setState(333);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(325);
								match(COMMA);
								setState(326);
								vfpdef();
								setState(329);
								_errHandler.sync(this);
								_la = _input.LA(1);
								if (_la==ASSIGN) {
									{
									setState(327);
									match(ASSIGN);
									setState(328);
									test();
									}
								}

								}
								} 
							}
							setState(335);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						}
						setState(339);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(336);
							match(COMMA);
							setState(337);
							match(POWER);
							setState(338);
							vfpdef();
							}
						}

						}
						break;
					case POWER:
						{
						setState(341);
						match(POWER);
						setState(342);
						vfpdef();
						}
						break;
					case COLON:
						break;
					default:
						break;
					}
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(STAR);
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(348);
					vfpdef();
					}
				}

				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(351);
						match(COMMA);
						setState(352);
						vfpdef();
						setState(355);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(353);
							match(ASSIGN);
							setState(354);
							test();
							}
						}

						}
						} 
					}
					setState(361);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(362);
					match(COMMA);
					setState(363);
					match(POWER);
					setState(364);
					vfpdef();
					}
				}

				}
				break;
			case POWER:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				match(POWER);
				setState(368);
				vfpdef();
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

	public static class VfpdefContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public VfpdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vfpdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterVfpdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitVfpdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitVfpdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VfpdefContext vfpdef() throws RecognitionException {
		VfpdefContext _localctx = new VfpdefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_vfpdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(NAME);
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

	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
			case RETURN:
			case RAISE:
			case FROM:
			case IMPORT:
			case GLOBAL:
			case NONLOCAL:
			case ASSERT:
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case YIELD:
			case DEL:
			case PASS:
			case CONTINUE:
			case BREAK:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				simple_stmt();
				}
				break;
			case DEF:
			case IF:
			case WHILE:
			case FOR:
			case TRY:
			case WITH:
			case CLASS:
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				compound_stmt();
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

	public static class Simple_stmtContext extends ParserRuleContext {
		public List<Small_stmtContext> small_stmt() {
			return getRuleContexts(Small_stmtContext.class);
		}
		public Small_stmtContext small_stmt(int i) {
			return getRuleContext(Small_stmtContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterSimple_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitSimple_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSimple_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_simple_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			small_stmt();
			setState(382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(378);
					match(SEMI_COLON);
					setState(379);
					small_stmt();
					}
					} 
				}
				setState(384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(385);
				match(SEMI_COLON);
				}
			}

			setState(388);
			match(NEWLINE);
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

	public static class Small_stmtContext extends ParserRuleContext {
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Del_stmtContext del_stmt() {
			return getRuleContext(Del_stmtContext.class,0);
		}
		public Pass_stmtContext pass_stmt() {
			return getRuleContext(Pass_stmtContext.class,0);
		}
		public Flow_stmtContext flow_stmt() {
			return getRuleContext(Flow_stmtContext.class,0);
		}
		public Import_stmtContext import_stmt() {
			return getRuleContext(Import_stmtContext.class,0);
		}
		public Global_stmtContext global_stmt() {
			return getRuleContext(Global_stmtContext.class,0);
		}
		public Nonlocal_stmtContext nonlocal_stmt() {
			return getRuleContext(Nonlocal_stmtContext.class,0);
		}
		public Assert_stmtContext assert_stmt() {
			return getRuleContext(Assert_stmtContext.class,0);
		}
		public Small_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_small_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterSmall_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitSmall_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSmall_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Small_stmtContext small_stmt() throws RecognitionException {
		Small_stmtContext _localctx = new Small_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_small_stmt);
		try {
			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				print_stmt();
				}
				break;
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				expr_stmt();
				}
				break;
			case DEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(392);
				del_stmt();
				}
				break;
			case PASS:
				enterOuterAlt(_localctx, 4);
				{
				setState(393);
				pass_stmt();
				}
				break;
			case RETURN:
			case RAISE:
			case YIELD:
			case CONTINUE:
			case BREAK:
				enterOuterAlt(_localctx, 5);
				{
				setState(394);
				flow_stmt();
				}
				break;
			case FROM:
			case IMPORT:
				enterOuterAlt(_localctx, 6);
				{
				setState(395);
				import_stmt();
				}
				break;
			case GLOBAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(396);
				global_stmt();
				}
				break;
			case NONLOCAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(397);
				nonlocal_stmt();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 9);
				{
				setState(398);
				assert_stmt();
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

	public static class Print_stmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(Python3Parser.PRINT, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Print_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterPrint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitPrint_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitPrint_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_stmtContext print_stmt() throws RecognitionException {
		Print_stmtContext _localctx = new Print_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_print_stmt);
		int _la;
		try {
			int _alt;
			setState(462);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(PRINT);
				setState(402);
				match(OPEN_PAREN);
				setState(429);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case CLOSE_PAREN:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
					{
					setState(414);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
						{
						setState(403);
						test();
						setState(408);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(404);
								match(COMMA);
								setState(405);
								test();
								}
								} 
							}
							setState(410);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
						}
						setState(412);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(411);
							match(COMMA);
							}
						}

						}
					}

					}
					break;
				case RIGHT_SHIFT:
					{
					setState(416);
					match(RIGHT_SHIFT);
					setState(417);
					test();
					setState(427);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(420); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(418);
								match(COMMA);
								setState(419);
								test();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(422); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(425);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(424);
							match(COMMA);
							}
						}

						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(431);
				match(CLOSE_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				match(PRINT);
				setState(459);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case NEWLINE:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case SEMI_COLON:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
					{
					setState(444);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
						{
						setState(433);
						test();
						setState(438);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(434);
								match(COMMA);
								setState(435);
								test();
								}
								} 
							}
							setState(440);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
						}
						setState(442);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(441);
							match(COMMA);
							}
						}

						}
					}

					}
					break;
				case RIGHT_SHIFT:
					{
					setState(446);
					match(RIGHT_SHIFT);
					setState(447);
					test();
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(450); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(448);
								match(COMMA);
								setState(449);
								test();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(452); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(455);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(454);
							match(COMMA);
							}
						}

						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}

				 	if (this.getStrictPython3Parsing()) {
						Token printToken = ((org.antlr.v4.runtime.tree.TerminalNodeImpl)this._ctx.children.get(0)).getSymbol();
						Token startingOffender = ((org.antlr.v4.runtime.ParserRuleContext)this._ctx.children.get(1)).getStart();

						throw new NoViableAltException(this, this.getInputStream(), printToken, startingOffender, null,
													   this._ctx);
				 	}
				 	else {
				 		this.likelyIsPython2 = true;
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

	public static class Expr_stmtContext extends ParserRuleContext {
		public List<Testlist_star_exprContext> testlist_star_expr() {
			return getRuleContexts(Testlist_star_exprContext.class);
		}
		public Testlist_star_exprContext testlist_star_expr(int i) {
			return getRuleContext(Testlist_star_exprContext.class,i);
		}
		public AugassignContext augassign() {
			return getRuleContext(AugassignContext.class,0);
		}
		public List<Yield_exprContext> yield_expr() {
			return getRuleContexts(Yield_exprContext.class);
		}
		public Yield_exprContext yield_expr(int i) {
			return getRuleContext(Yield_exprContext.class,i);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitExpr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			testlist_star_expr();
			setState(480);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD_ASSIGN:
			case SUB_ASSIGN:
			case MULT_ASSIGN:
			case AT_ASSIGN:
			case DIV_ASSIGN:
			case MOD_ASSIGN:
			case AND_ASSIGN:
			case OR_ASSIGN:
			case XOR_ASSIGN:
			case LEFT_SHIFT_ASSIGN:
			case RIGHT_SHIFT_ASSIGN:
			case POWER_ASSIGN:
			case IDIV_ASSIGN:
				{
				setState(465);
				augassign();
				setState(468);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(466);
					yield_expr();
					}
					break;
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
					{
					setState(467);
					testlist();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case NEWLINE:
			case SEMI_COLON:
			case ASSIGN:
				{
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ASSIGN) {
					{
					{
					setState(470);
					match(ASSIGN);
					setState(473);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case YIELD:
						{
						setState(471);
						yield_expr();
						}
						break;
					case LAMBDA:
					case NOT:
					case NONE:
					case TRUE:
					case FALSE:
					case NAME:
					case STRING_LITERAL:
					case BYTES_LITERAL:
					case DECIMAL_INTEGER:
					case OCT_INTEGER:
					case HEX_INTEGER:
					case BIN_INTEGER:
					case FLOAT_NUMBER:
					case IMAG_NUMBER:
					case ELLIPSIS:
					case STAR:
					case OPEN_PAREN:
					case OPEN_BRACK:
					case ADD:
					case MINUS:
					case NOT_OP:
					case OPEN_BRACE:
						{
						setState(472);
						testlist_star_expr();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(479);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class Testlist_star_exprContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public Testlist_star_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist_star_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTestlist_star_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTestlist_star_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTestlist_star_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Testlist_star_exprContext testlist_star_expr() throws RecognitionException {
		Testlist_star_exprContext _localctx = new Testlist_star_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_testlist_star_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(482);
				test();
				}
				break;
			case 2:
				{
				setState(483);
				star_expr();
				}
				break;
			}
			setState(493);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(486);
					match(COMMA);
					setState(489);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						setState(487);
						test();
						}
						break;
					case 2:
						{
						setState(488);
						star_expr();
						}
						break;
					}
					}
					} 
				}
				setState(495);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(496);
				match(COMMA);
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

	public static class AugassignContext extends ParserRuleContext {
		public AugassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterAugassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitAugassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAugassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AugassignContext augassign() throws RecognitionException {
		AugassignContext _localctx = new AugassignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_augassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_la = _input.LA(1);
			if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (ADD_ASSIGN - 79)) | (1L << (SUB_ASSIGN - 79)) | (1L << (MULT_ASSIGN - 79)) | (1L << (AT_ASSIGN - 79)) | (1L << (DIV_ASSIGN - 79)) | (1L << (MOD_ASSIGN - 79)) | (1L << (AND_ASSIGN - 79)) | (1L << (OR_ASSIGN - 79)) | (1L << (XOR_ASSIGN - 79)) | (1L << (LEFT_SHIFT_ASSIGN - 79)) | (1L << (RIGHT_SHIFT_ASSIGN - 79)) | (1L << (POWER_ASSIGN - 79)) | (1L << (IDIV_ASSIGN - 79)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Del_stmtContext extends ParserRuleContext {
		public TerminalNode DEL() { return getToken(Python3Parser.DEL, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public Del_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDel_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDel_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDel_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Del_stmtContext del_stmt() throws RecognitionException {
		Del_stmtContext _localctx = new Del_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_del_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(DEL);
			setState(502);
			exprlist();
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

	public static class Pass_stmtContext extends ParserRuleContext {
		public TerminalNode PASS() { return getToken(Python3Parser.PASS, 0); }
		public Pass_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pass_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterPass_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitPass_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitPass_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pass_stmtContext pass_stmt() throws RecognitionException {
		Pass_stmtContext _localctx = new Pass_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pass_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(PASS);
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

	public static class Flow_stmtContext extends ParserRuleContext {
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Continue_stmtContext continue_stmt() {
			return getRuleContext(Continue_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Raise_stmtContext raise_stmt() {
			return getRuleContext(Raise_stmtContext.class,0);
		}
		public Yield_stmtContext yield_stmt() {
			return getRuleContext(Yield_stmtContext.class,0);
		}
		public Flow_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterFlow_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitFlow_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFlow_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Flow_stmtContext flow_stmt() throws RecognitionException {
		Flow_stmtContext _localctx = new Flow_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_flow_stmt);
		try {
			setState(511);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				break_stmt();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
				continue_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(508);
				return_stmt();
				}
				break;
			case RAISE:
				enterOuterAlt(_localctx, 4);
				{
				setState(509);
				raise_stmt();
				}
				break;
			case YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(510);
				yield_stmt();
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

	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(Python3Parser.BREAK, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterBreak_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitBreak_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitBreak_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(BREAK);
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

	public static class Continue_stmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(Python3Parser.CONTINUE, 0); }
		public Continue_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterContinue_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitContinue_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitContinue_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Continue_stmtContext continue_stmt() throws RecognitionException {
		Continue_stmtContext _localctx = new Continue_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_continue_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(CONTINUE);
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(Python3Parser.RETURN, 0); }
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			match(RETURN);
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
				{
				setState(518);
				testlist();
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

	public static class Yield_stmtContext extends ParserRuleContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Yield_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterYield_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitYield_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitYield_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_stmtContext yield_stmt() throws RecognitionException {
		Yield_stmtContext _localctx = new Yield_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_yield_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			yield_expr();
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

	public static class Raise_stmtContext extends ParserRuleContext {
		public TerminalNode RAISE() { return getToken(Python3Parser.RAISE, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode FROM() { return getToken(Python3Parser.FROM, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public Raise_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterRaise_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitRaise_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitRaise_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Raise_stmtContext raise_stmt() throws RecognitionException {
		Raise_stmtContext _localctx = new Raise_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_raise_stmt);
		int _la;
		try {
			setState(537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(523);
				match(RAISE);
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(524);
					test();
					setState(527);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FROM) {
						{
						setState(525);
						match(FROM);
						setState(526);
						test();
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(531);
				match(RAISE);
				setState(532);
				match(NAME);
				setState(533);
				match(COMMA);
				setState(534);
				str();

				 	if (this.getStrictPython3Parsing()) {
						Token raiseToken = ((org.antlr.v4.runtime.tree.TerminalNodeImpl)this._ctx.children.get(0)).getSymbol();
						Token startingOffender = ((org.antlr.v4.runtime.tree.TerminalNodeImpl)this._ctx.children.get(1)).getSymbol();

						throw new NoViableAltException(this, this.getInputStream(), raiseToken, startingOffender, null,
													   this._ctx);
				 	}
				 	else {
				 		this.likelyIsPython2 = true;
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

	public static class Import_stmtContext extends ParserRuleContext {
		public Import_nameContext import_name() {
			return getRuleContext(Import_nameContext.class,0);
		}
		public Import_fromContext import_from() {
			return getRuleContext(Import_fromContext.class,0);
		}
		public Import_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterImport_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitImport_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_stmtContext import_stmt() throws RecognitionException {
		Import_stmtContext _localctx = new Import_stmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_import_stmt);
		try {
			setState(541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				import_name();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				import_from();
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

	public static class Import_nameContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Python3Parser.IMPORT, 0); }
		public Dotted_as_namesContext dotted_as_names() {
			return getRuleContext(Dotted_as_namesContext.class,0);
		}
		public Import_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterImport_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitImport_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_nameContext import_name() throws RecognitionException {
		Import_nameContext _localctx = new Import_nameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_import_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			match(IMPORT);
			setState(544);
			dotted_as_names();
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

	public static class Import_fromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(Python3Parser.FROM, 0); }
		public TerminalNode IMPORT() { return getToken(Python3Parser.IMPORT, 0); }
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public Import_as_namesContext import_as_names() {
			return getRuleContext(Import_as_namesContext.class,0);
		}
		public Import_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterImport_from(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitImport_from(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_from(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_fromContext import_from() throws RecognitionException {
		Import_fromContext _localctx = new Import_fromContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_import_from);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(FROM);
			setState(559);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT || _la==ELLIPSIS) {
					{
					{
					setState(547);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(552);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(553);
				dotted_name();
				}
				break;
			case 2:
				{
				setState(555); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(554);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(557); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT || _la==ELLIPSIS );
				}
				break;
			}
			setState(561);
			match(IMPORT);
			setState(568);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(562);
				match(STAR);
				}
				break;
			case OPEN_PAREN:
				{
				setState(563);
				match(OPEN_PAREN);
				setState(564);
				import_as_names();
				setState(565);
				match(CLOSE_PAREN);
				}
				break;
			case NAME:
				{
				setState(567);
				import_as_names();
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

	public static class Import_as_nameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public Import_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterImport_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitImport_as_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_as_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_as_nameContext import_as_name() throws RecognitionException {
		Import_as_nameContext _localctx = new Import_as_nameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_import_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(NAME);
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(571);
				match(AS);
				setState(572);
				match(NAME);
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

	public static class Dotted_as_nameContext extends ParserRuleContext {
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public Dotted_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDotted_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDotted_as_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDotted_as_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_as_nameContext dotted_as_name() throws RecognitionException {
		Dotted_as_nameContext _localctx = new Dotted_as_nameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_dotted_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			dotted_name();
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(576);
				match(AS);
				setState(577);
				match(NAME);
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

	public static class Import_as_namesContext extends ParserRuleContext {
		public List<Import_as_nameContext> import_as_name() {
			return getRuleContexts(Import_as_nameContext.class);
		}
		public Import_as_nameContext import_as_name(int i) {
			return getRuleContext(Import_as_nameContext.class,i);
		}
		public Import_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterImport_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitImport_as_names(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_as_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_as_namesContext import_as_names() throws RecognitionException {
		Import_as_namesContext _localctx = new Import_as_namesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_import_as_names);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			import_as_name();
			setState(585);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(581);
					match(COMMA);
					setState(582);
					import_as_name();
					}
					} 
				}
				setState(587);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			}
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(588);
				match(COMMA);
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

	public static class Dotted_as_namesContext extends ParserRuleContext {
		public List<Dotted_as_nameContext> dotted_as_name() {
			return getRuleContexts(Dotted_as_nameContext.class);
		}
		public Dotted_as_nameContext dotted_as_name(int i) {
			return getRuleContext(Dotted_as_nameContext.class,i);
		}
		public Dotted_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDotted_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDotted_as_names(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDotted_as_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_as_namesContext dotted_as_names() throws RecognitionException {
		Dotted_as_namesContext _localctx = new Dotted_as_namesContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_dotted_as_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			dotted_as_name();
			setState(596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(592);
				match(COMMA);
				setState(593);
				dotted_as_name();
				}
				}
				setState(598);
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

	public static class Dotted_nameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public Dotted_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDotted_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDotted_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDotted_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_nameContext dotted_name() throws RecognitionException {
		Dotted_nameContext _localctx = new Dotted_nameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_dotted_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(NAME);
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(600);
				match(DOT);
				setState(601);
				match(NAME);
				}
				}
				setState(606);
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

	public static class Global_stmtContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(Python3Parser.GLOBAL, 0); }
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public Global_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterGlobal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitGlobal_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitGlobal_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_stmtContext global_stmt() throws RecognitionException {
		Global_stmtContext _localctx = new Global_stmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_global_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(GLOBAL);
			setState(608);
			match(NAME);
			setState(613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(609);
				match(COMMA);
				setState(610);
				match(NAME);
				}
				}
				setState(615);
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

	public static class Nonlocal_stmtContext extends ParserRuleContext {
		public TerminalNode NONLOCAL() { return getToken(Python3Parser.NONLOCAL, 0); }
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public Nonlocal_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonlocal_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterNonlocal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitNonlocal_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitNonlocal_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nonlocal_stmtContext nonlocal_stmt() throws RecognitionException {
		Nonlocal_stmtContext _localctx = new Nonlocal_stmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_nonlocal_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			match(NONLOCAL);
			setState(617);
			match(NAME);
			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(618);
				match(COMMA);
				setState(619);
				match(NAME);
				}
				}
				setState(624);
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

	public static class Assert_stmtContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(Python3Parser.ASSERT, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Assert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterAssert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitAssert_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAssert_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assert_stmtContext assert_stmt() throws RecognitionException {
		Assert_stmtContext _localctx = new Assert_stmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_assert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(ASSERT);
			setState(626);
			test();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(627);
				match(COMMA);
				setState(628);
				test();
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Try_stmtContext try_stmt() {
			return getRuleContext(Try_stmtContext.class,0);
		}
		public With_stmtContext with_stmt() {
			return getRuleContext(With_stmtContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public DecoratedContext decorated() {
			return getRuleContext(DecoratedContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitCompound_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_compound_stmt);
		try {
			setState(639);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(632);
				while_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(633);
				for_stmt();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 4);
				{
				setState(634);
				try_stmt();
				}
				break;
			case WITH:
				enterOuterAlt(_localctx, 5);
				{
				setState(635);
				with_stmt();
				}
				break;
			case DEF:
				enterOuterAlt(_localctx, 6);
				{
				setState(636);
				funcdef();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 7);
				{
				setState(637);
				classdef();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 8);
				{
				setState(638);
				decorated();
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Python3Parser.IF, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(Python3Parser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(Python3Parser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			match(IF);
			setState(642);
			test();
			setState(643);
			match(COLON);
			setState(644);
			suite();
			setState(652);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(645);
				match(ELIF);
				setState(646);
				test();
				setState(647);
				match(COLON);
				setState(648);
				suite();
				}
				}
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(655);
				match(ELSE);
				setState(656);
				match(COLON);
				setState(657);
				suite();
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

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Python3Parser.WHILE, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			match(WHILE);
			setState(661);
			test();
			setState(662);
			match(COLON);
			setState(663);
			suite();
			setState(667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(664);
				match(ELSE);
				setState(665);
				match(COLON);
				setState(666);
				suite();
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

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Python3Parser.FOR, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public TerminalNode IN() { return getToken(Python3Parser.IN, 0); }
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			match(FOR);
			setState(670);
			exprlist();
			setState(671);
			match(IN);
			setState(672);
			testlist();
			setState(673);
			match(COLON);
			setState(674);
			suite();
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(675);
				match(ELSE);
				setState(676);
				match(COLON);
				setState(677);
				suite();
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

	public static class Try_stmtContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(Python3Parser.TRY, 0); }
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode FINALLY() { return getToken(Python3Parser.FINALLY, 0); }
		public List<Except_clauseContext> except_clause() {
			return getRuleContexts(Except_clauseContext.class);
		}
		public Except_clauseContext except_clause(int i) {
			return getRuleContext(Except_clauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public Try_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTry_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTry_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTry_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Try_stmtContext try_stmt() throws RecognitionException {
		Try_stmtContext _localctx = new Try_stmtContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_try_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			match(TRY);
			setState(681);
			match(COLON);
			setState(682);
			suite();
			setState(704);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXCEPT:
				{
				setState(687); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(683);
					except_clause();
					setState(684);
					match(COLON);
					setState(685);
					suite();
					}
					}
					setState(689); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(691);
					match(ELSE);
					setState(692);
					match(COLON);
					setState(693);
					suite();
					}
				}

				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(696);
					match(FINALLY);
					setState(697);
					match(COLON);
					setState(698);
					suite();
					}
				}

				}
				break;
			case FINALLY:
				{
				setState(701);
				match(FINALLY);
				setState(702);
				match(COLON);
				setState(703);
				suite();
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

	public static class With_stmtContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(Python3Parser.WITH, 0); }
		public List<With_itemContext> with_item() {
			return getRuleContexts(With_itemContext.class);
		}
		public With_itemContext with_item(int i) {
			return getRuleContext(With_itemContext.class,i);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public With_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterWith_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitWith_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitWith_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_stmtContext with_stmt() throws RecognitionException {
		With_stmtContext _localctx = new With_stmtContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_with_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(WITH);
			setState(707);
			with_item();
			setState(712);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(708);
				match(COMMA);
				setState(709);
				with_item();
				}
				}
				setState(714);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(715);
			match(COLON);
			setState(716);
			suite();
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

	public static class With_itemContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public With_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterWith_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitWith_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitWith_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_itemContext with_item() throws RecognitionException {
		With_itemContext _localctx = new With_itemContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_with_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			test();
			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(719);
				match(AS);
				setState(720);
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

	public static class Except_clauseContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(Python3Parser.EXCEPT, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public Except_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterExcept_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitExcept_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExcept_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_clauseContext except_clause() throws RecognitionException {
		Except_clauseContext _localctx = new Except_clauseContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_except_clause);
		int _la;
		try {
			setState(736);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(723);
				match(EXCEPT);
				setState(729);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(724);
					test();
					setState(727);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(725);
						match(AS);
						setState(726);
						match(NAME);
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(731);
				match(EXCEPT);
				setState(732);
				match(NAME);
				setState(733);
				match(COMMA);
				setState(734);
				match(NAME);

				 	if (this.getStrictPython3Parsing()) {
						Token exceptToken = ((org.antlr.v4.runtime.tree.TerminalNodeImpl)this._ctx.children.get(0)).getSymbol();
						Token startingOffender = ((org.antlr.v4.runtime.tree.TerminalNodeImpl)this._ctx.children.get(1)).getSymbol();

						throw new NoViableAltException(this, this.getInputStream(), exceptToken, startingOffender, null,
													   this._ctx);
				 	}
				 	else {
				 		this.likelyIsPython2 = true;
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

	public static class SuiteContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(Python3Parser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(Python3Parser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_suite);
		int _la;
		try {
			setState(748);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
			case RETURN:
			case RAISE:
			case FROM:
			case IMPORT:
			case GLOBAL:
			case NONLOCAL:
			case ASSERT:
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case YIELD:
			case DEL:
			case PASS:
			case CONTINUE:
			case BREAK:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(738);
				simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(739);
				match(NEWLINE);
				setState(740);
				match(INDENT);
				setState(742); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(741);
					stmt();
					}
					}
					setState(744); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << DEF) | (1L << RETURN) | (1L << RAISE) | (1L << FROM) | (1L << IMPORT) | (1L << GLOBAL) | (1L << NONLOCAL) | (1L << ASSERT) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << TRY) | (1L << WITH) | (1L << LAMBDA) | (1L << NOT) | (1L << NONE) | (1L << TRUE) | (1L << FALSE) | (1L << CLASS) | (1L << YIELD) | (1L << DEL) | (1L << PASS) | (1L << CONTINUE) | (1L << BREAK) | (1L << NAME) | (1L << STRING_LITERAL) | (1L << BYTES_LITERAL) | (1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER) | (1L << FLOAT_NUMBER) | (1L << IMAG_NUMBER) | (1L << ELLIPSIS) | (1L << STAR) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (NOT_OP - 67)) | (1L << (OPEN_BRACE - 67)) | (1L << (AT - 67)))) != 0) );
				setState(746);
				match(DEDENT);
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

	public static class TestContext extends ParserRuleContext {
		public List<Or_testContext> or_test() {
			return getRuleContexts(Or_testContext.class);
		}
		public Or_testContext or_test(int i) {
			return getRuleContext(Or_testContext.class,i);
		}
		public TerminalNode IF() { return getToken(Python3Parser.IF, 0); }
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public LambdefContext lambdef() {
			return getRuleContext(LambdefContext.class,0);
		}
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_test);
		int _la;
		try {
			setState(759);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(750);
				or_test();
				setState(756);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(751);
					match(IF);
					setState(752);
					or_test();
					setState(753);
					match(ELSE);
					setState(754);
					test();
					}
				}

				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(758);
				lambdef();
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

	public static class Test_nocondContext extends ParserRuleContext {
		public Or_testContext or_test() {
			return getRuleContext(Or_testContext.class,0);
		}
		public Lambdef_nocondContext lambdef_nocond() {
			return getRuleContext(Lambdef_nocondContext.class,0);
		}
		public Test_nocondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_nocond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTest_nocond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTest_nocond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTest_nocond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_nocondContext test_nocond() throws RecognitionException {
		Test_nocondContext _localctx = new Test_nocondContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_test_nocond);
		try {
			setState(763);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(761);
				or_test();
				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
				lambdef_nocond();
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

	public static class LambdefContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(Python3Parser.LAMBDA, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public VarargslistContext varargslist() {
			return getRuleContext(VarargslistContext.class,0);
		}
		public LambdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterLambdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitLambdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitLambdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdefContext lambdef() throws RecognitionException {
		LambdefContext _localctx = new LambdefContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_lambdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			match(LAMBDA);
			setState(767);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STAR) | (1L << POWER))) != 0)) {
				{
				setState(766);
				varargslist();
				}
			}

			setState(769);
			match(COLON);
			setState(770);
			test();
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

	public static class Lambdef_nocondContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(Python3Parser.LAMBDA, 0); }
		public Test_nocondContext test_nocond() {
			return getRuleContext(Test_nocondContext.class,0);
		}
		public VarargslistContext varargslist() {
			return getRuleContext(VarargslistContext.class,0);
		}
		public Lambdef_nocondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdef_nocond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterLambdef_nocond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitLambdef_nocond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitLambdef_nocond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambdef_nocondContext lambdef_nocond() throws RecognitionException {
		Lambdef_nocondContext _localctx = new Lambdef_nocondContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_lambdef_nocond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			match(LAMBDA);
			setState(774);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STAR) | (1L << POWER))) != 0)) {
				{
				setState(773);
				varargslist();
				}
			}

			setState(776);
			match(COLON);
			setState(777);
			test_nocond();
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

	public static class Or_testContext extends ParserRuleContext {
		public List<And_testContext> and_test() {
			return getRuleContexts(And_testContext.class);
		}
		public And_testContext and_test(int i) {
			return getRuleContext(And_testContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(Python3Parser.OR); }
		public TerminalNode OR(int i) {
			return getToken(Python3Parser.OR, i);
		}
		public Or_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterOr_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitOr_test(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitOr_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_testContext or_test() throws RecognitionException {
		Or_testContext _localctx = new Or_testContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_or_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			and_test();
			setState(784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(780);
				match(OR);
				setState(781);
				and_test();
				}
				}
				setState(786);
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

	public static class And_testContext extends ParserRuleContext {
		public List<Not_testContext> not_test() {
			return getRuleContexts(Not_testContext.class);
		}
		public Not_testContext not_test(int i) {
			return getRuleContext(Not_testContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(Python3Parser.AND); }
		public TerminalNode AND(int i) {
			return getToken(Python3Parser.AND, i);
		}
		public And_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterAnd_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitAnd_test(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAnd_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_testContext and_test() throws RecognitionException {
		And_testContext _localctx = new And_testContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_and_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			not_test();
			setState(792);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(788);
				match(AND);
				setState(789);
				not_test();
				}
				}
				setState(794);
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

	public static class Not_testContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(Python3Parser.NOT, 0); }
		public Not_testContext not_test() {
			return getRuleContext(Not_testContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public Not_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterNot_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitNot_test(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitNot_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_testContext not_test() throws RecognitionException {
		Not_testContext _localctx = new Not_testContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_not_test);
		try {
			setState(798);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(795);
				match(NOT);
				setState(796);
				not_test();
				}
				break;
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(797);
				comparison();
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public List<Comp_opContext> comp_op() {
			return getRuleContexts(Comp_opContext.class);
		}
		public Comp_opContext comp_op(int i) {
			return getRuleContext(Comp_opContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			star_expr();
			setState(806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & ((1L << (IN - 16)) | (1L << (NOT - 16)) | (1L << (IS - 16)) | (1L << (LESS_THAN - 16)) | (1L << (GREATER_THAN - 16)) | (1L << (EQUALS - 16)) | (1L << (GT_EQ - 16)) | (1L << (LT_EQ - 16)) | (1L << (NOT_EQ_1 - 16)) | (1L << (NOT_EQ_2 - 16)))) != 0)) {
				{
				{
				setState(801);
				comp_op();
				setState(802);
				star_expr();
				}
				}
				setState(808);
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

	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(Python3Parser.IN, 0); }
		public TerminalNode NOT() { return getToken(Python3Parser.NOT, 0); }
		public TerminalNode IS() { return getToken(Python3Parser.IS, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterComp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitComp_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_comp_op);
		try {
			setState(822);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(809);
				match(LESS_THAN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(810);
				match(GREATER_THAN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(811);
				match(EQUALS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(812);
				match(GT_EQ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(813);
				match(LT_EQ);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(814);
				match(NOT_EQ_1);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(815);
				match(NOT_EQ_2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(816);
				match(IN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(817);
				match(NOT);
				setState(818);
				match(IN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(819);
				match(IS);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(820);
				match(IS);
				setState(821);
				match(NOT);
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

	public static class Star_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Star_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterStar_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitStar_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitStar_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_exprContext star_expr() throws RecognitionException {
		Star_exprContext _localctx = new Star_exprContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_star_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(824);
				match(STAR);
				}
			}

			setState(827);
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

	public static class ExprContext extends ParserRuleContext {
		public List<Xor_exprContext> xor_expr() {
			return getRuleContexts(Xor_exprContext.class);
		}
		public Xor_exprContext xor_expr(int i) {
			return getRuleContext(Xor_exprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			xor_expr();
			setState(834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR_OP) {
				{
				{
				setState(830);
				match(OR_OP);
				setState(831);
				xor_expr();
				}
				}
				setState(836);
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

	public static class Xor_exprContext extends ParserRuleContext {
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public Xor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterXor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitXor_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitXor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Xor_exprContext xor_expr() throws RecognitionException {
		Xor_exprContext _localctx = new Xor_exprContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_xor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			and_expr();
			setState(842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==XOR) {
				{
				{
				setState(838);
				match(XOR);
				setState(839);
				and_expr();
				}
				}
				setState(844);
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

	public static class And_exprContext extends ParserRuleContext {
		public List<Shift_exprContext> shift_expr() {
			return getRuleContexts(Shift_exprContext.class);
		}
		public Shift_exprContext shift_expr(int i) {
			return getRuleContext(Shift_exprContext.class,i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterAnd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitAnd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			shift_expr();
			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_OP) {
				{
				{
				setState(846);
				match(AND_OP);
				setState(847);
				shift_expr();
				}
				}
				setState(852);
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

	public static class Shift_exprContext extends ParserRuleContext {
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterShift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitShift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitShift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_shift_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(853);
			arith_expr();
			setState(860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_SHIFT || _la==RIGHT_SHIFT) {
				{
				setState(858);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_SHIFT:
					{
					setState(854);
					match(LEFT_SHIFT);
					setState(855);
					arith_expr();
					}
					break;
				case RIGHT_SHIFT:
					{
					setState(856);
					match(RIGHT_SHIFT);
					setState(857);
					arith_expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(862);
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

	public static class Arith_exprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Arith_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterArith_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitArith_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitArith_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arith_exprContext arith_expr() throws RecognitionException {
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_arith_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			term();
			setState(870);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==MINUS) {
				{
				setState(868);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(864);
					match(ADD);
					setState(865);
					term();
					}
					break;
				case MINUS:
					{
					setState(866);
					match(MINUS);
					setState(867);
					term();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(872);
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			factor();
			setState(886);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (STAR - 47)) | (1L << (DIV - 47)) | (1L << (MOD - 47)) | (1L << (IDIV - 47)) | (1L << (AT - 47)))) != 0)) {
				{
				setState(884);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(874);
					match(STAR);
					setState(875);
					factor();
					}
					break;
				case DIV:
					{
					setState(876);
					match(DIV);
					setState(877);
					factor();
					}
					break;
				case MOD:
					{
					setState(878);
					match(MOD);
					setState(879);
					factor();
					}
					break;
				case IDIV:
					{
					setState(880);
					match(IDIV);
					setState(881);
					factor();
					}
					break;
				case AT:
					{
					setState(882);
					match(AT);
					setState(883);
					factor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(888);
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

	public static class FactorContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_factor);
		try {
			setState(896);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				match(ADD);
				setState(890);
				factor();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(891);
				match(MINUS);
				setState(892);
				factor();
				}
				break;
			case NOT_OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(893);
				match(NOT_OP);
				setState(894);
				factor();
				}
				break;
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(895);
				power();
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

	public static class PowerContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TrailerContext> trailer() {
			return getRuleContexts(TrailerContext.class);
		}
		public TrailerContext trailer(int i) {
			return getRuleContext(TrailerContext.class,i);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public PowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowerContext power() throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_power);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			atom();
			setState(902);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK))) != 0)) {
				{
				{
				setState(899);
				trailer();
				}
				}
				setState(904);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(907);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POWER) {
				{
				setState(905);
				match(POWER);
				setState(906);
				factor();
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

	public static class AtomContext extends ParserRuleContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Testlist_compContext testlist_comp() {
			return getRuleContext(Testlist_compContext.class,0);
		}
		public DictorsetmakerContext dictorsetmaker() {
			return getRuleContext(DictorsetmakerContext.class,0);
		}
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public TerminalNode NONE() { return getToken(Python3Parser.NONE, 0); }
		public TerminalNode TRUE() { return getToken(Python3Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(Python3Parser.FALSE, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_atom);
		int _la;
		try {
			setState(937);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(909);
				match(OPEN_PAREN);
				setState(912);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(910);
					yield_expr();
					}
					break;
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
					{
					setState(911);
					testlist_comp();
					}
					break;
				case CLOSE_PAREN:
					break;
				default:
					break;
				}
				setState(914);
				match(CLOSE_PAREN);
				}
				break;
			case OPEN_BRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(915);
				match(OPEN_BRACK);
				setState(917);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(916);
					testlist_comp();
					}
				}

				setState(919);
				match(CLOSE_BRACK);
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(920);
				match(OPEN_BRACE);
				setState(922);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(921);
					dictorsetmaker();
					}
				}

				setState(924);
				match(CLOSE_BRACE);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 4);
				{

					org.antlr.v4.runtime.CommonToken token = null;
					String tokenName = null;

					if (this._ctx.start instanceof org.antlr.v4.runtime.CommonToken) {
						token = (org.antlr.v4.runtime.CommonToken)this._ctx.start;

						if (token.getType() != Python3Parser.ALREADY_THROWN_TOKEN_TYPE) {
							tokenName = token.getText();
						}
					}

					if ("xrange".equals(tokenName) || "raw_input".equals(tokenName)) {
						if (this.getStrictPython3Parsing()) {
							// This throws twice - the second time on parenthesis close.
							token.setType(Python3Parser.ALREADY_THROWN_TOKEN_TYPE);

							throw new NoViableAltException(this);
						}
						else {
							this.likelyIsPython2 = true;
						}
					}
				 
				setState(926);
				match(NAME);
				}
				break;
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
				enterOuterAlt(_localctx, 5);
				{
				setState(927);
				number();
				}
				break;
			case STRING_LITERAL:
			case BYTES_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(929); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(928);
					str();
					}
					}
					setState(931); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STRING_LITERAL || _la==BYTES_LITERAL );
				}
				break;
			case ELLIPSIS:
				enterOuterAlt(_localctx, 7);
				{
				setState(933);
				match(ELLIPSIS);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 8);
				{
				setState(934);
				match(NONE);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 9);
				{
				setState(935);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 10);
				{
				setState(936);
				match(FALSE);
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

	public static class Testlist_compContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public Testlist_compContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTestlist_comp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTestlist_comp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTestlist_comp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Testlist_compContext testlist_comp() throws RecognitionException {
		Testlist_compContext _localctx = new Testlist_compContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_testlist_comp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			test();
			setState(951);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(940);
				comp_for();
				}
				break;
			case CLOSE_PAREN:
			case COMMA:
			case CLOSE_BRACK:
				{
				setState(945);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(941);
						match(COMMA);
						setState(942);
						test();
						}
						} 
					}
					setState(947);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				}
				setState(949);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(948);
					match(COMMA);
					}
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

	public static class TrailerContext extends ParserRuleContext {
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public SubscriptlistContext subscriptlist() {
			return getRuleContext(SubscriptlistContext.class,0);
		}
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public TrailerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTrailer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTrailer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTrailer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrailerContext trailer() throws RecognitionException {
		TrailerContext _localctx = new TrailerContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_trailer);
		int _la;
		try {
			setState(965);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(953);
				match(OPEN_PAREN);
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (POWER - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(954);
					arglist();
					}
				}

				setState(957);
				match(CLOSE_PAREN);
				}
				break;
			case OPEN_BRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(958);
				match(OPEN_BRACK);
				setState(959);
				subscriptlist();
				setState(960);
				match(CLOSE_BRACK);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(962);
				match(DOT);
				setState(963);
				match(NAME);

					if ("next".equals(this._ctx.children.get(1).getText())) {
						if (this.getStrictPython3Parsing()) {
							TerminalNode tn = ((org.antlr.v4.runtime.tree.TerminalNodeImpl)this._ctx.children.get(0));
							Token parentObject = ((PowerContext)tn.getParent().getParent()).start;
							Token offendingToken = ((org.antlr.v4.runtime.tree.TerminalNodeImpl)this._ctx.children.get(1)).getSymbol();

							throw new NoViableAltException(this, this.getInputStream(), parentObject, offendingToken, null,
														   this._ctx);
						}
						else {
							this.likelyIsPython2 = true;
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

	public static class SubscriptlistContext extends ParserRuleContext {
		public List<SubscriptContext> subscript() {
			return getRuleContexts(SubscriptContext.class);
		}
		public SubscriptContext subscript(int i) {
			return getRuleContext(SubscriptContext.class,i);
		}
		public SubscriptlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterSubscriptlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitSubscriptlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSubscriptlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscriptlistContext subscriptlist() throws RecognitionException {
		SubscriptlistContext _localctx = new SubscriptlistContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_subscriptlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(967);
			subscript();
			setState(972);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(968);
					match(COMMA);
					setState(969);
					subscript();
					}
					} 
				}
				setState(974);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			}
			setState(976);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(975);
				match(COMMA);
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

	public static class SubscriptContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public SliceopContext sliceop() {
			return getRuleContext(SliceopContext.class,0);
		}
		public SubscriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSubscript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscriptContext subscript() throws RecognitionException {
		SubscriptContext _localctx = new SubscriptContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_subscript);
		int _la;
		try {
			setState(989);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(978);
				test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(980);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(979);
					test();
					}
				}

				setState(982);
				match(COLON);
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(983);
					test();
					}
				}

				setState(987);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(986);
					sliceop();
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

	public static class SliceopContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public SliceopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterSliceop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitSliceop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSliceop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SliceopContext sliceop() throws RecognitionException {
		SliceopContext _localctx = new SliceopContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_sliceop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991);
			match(COLON);
			setState(993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
				{
				setState(992);
				test();
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

	public static class ExprlistContext extends ParserRuleContext {
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterExprlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitExprlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExprlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_exprlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(995);
			star_expr();
			setState(1000);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(996);
					match(COMMA);
					setState(997);
					star_expr();
					}
					} 
				}
				setState(1002);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			}
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1003);
				match(COMMA);
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

	public static class TestlistContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TestlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterTestlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitTestlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTestlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestlistContext testlist() throws RecognitionException {
		TestlistContext _localctx = new TestlistContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_testlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			test();
			setState(1011);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1007);
					match(COMMA);
					setState(1008);
					test();
					}
					} 
				}
				setState(1013);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
			}
			setState(1015);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1014);
				match(COMMA);
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

	public static class DictorsetmakerContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public DictorsetmakerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictorsetmaker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterDictorsetmaker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitDictorsetmaker(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDictorsetmaker(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictorsetmakerContext dictorsetmaker() throws RecognitionException {
		DictorsetmakerContext _localctx = new DictorsetmakerContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_dictorsetmaker);
		int _la;
		try {
			int _alt;
			setState(1050);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1017);
				test();
				setState(1018);
				match(COLON);
				setState(1019);
				test();
				setState(1034);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FOR:
					{
					setState(1020);
					comp_for();
					}
					break;
				case COMMA:
				case CLOSE_BRACE:
					{
					setState(1028);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1021);
							match(COMMA);
							setState(1022);
							test();
							setState(1023);
							match(COLON);
							setState(1024);
							test();
							}
							} 
						}
						setState(1030);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
					}
					setState(1032);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1031);
						match(COMMA);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1036);
				test();
				setState(1048);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FOR:
					{
					setState(1037);
					comp_for();
					}
					break;
				case COMMA:
				case CLOSE_BRACE:
					{
					setState(1042);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1038);
							match(COMMA);
							setState(1039);
							test();
							}
							} 
						}
						setState(1044);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
					}
					setState(1046);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1045);
						match(COMMA);
						}
					}

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

	public static class ClassdefContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(Python3Parser.CLASS, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterClassdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitClassdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitClassdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_classdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1052);
			match(CLASS);
			setState(1053);
			match(NAME);
			setState(1059);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(1054);
				match(OPEN_PAREN);
				setState(1056);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (LAMBDA - 21)) | (1L << (NOT - 21)) | (1L << (NONE - 21)) | (1L << (TRUE - 21)) | (1L << (FALSE - 21)) | (1L << (NAME - 21)) | (1L << (STRING_LITERAL - 21)) | (1L << (BYTES_LITERAL - 21)) | (1L << (DECIMAL_INTEGER - 21)) | (1L << (OCT_INTEGER - 21)) | (1L << (HEX_INTEGER - 21)) | (1L << (BIN_INTEGER - 21)) | (1L << (FLOAT_NUMBER - 21)) | (1L << (IMAG_NUMBER - 21)) | (1L << (ELLIPSIS - 21)) | (1L << (STAR - 21)) | (1L << (OPEN_PAREN - 21)) | (1L << (POWER - 21)) | (1L << (OPEN_BRACK - 21)) | (1L << (ADD - 21)) | (1L << (MINUS - 21)) | (1L << (NOT_OP - 21)) | (1L << (OPEN_BRACE - 21)))) != 0)) {
					{
					setState(1055);
					arglist();
					}
				}

				setState(1058);
				match(CLOSE_PAREN);
				}
			}

			setState(1061);
			match(COLON);
			setState(1062);
			suite();
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

	public static class ArglistContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitArglist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_arglist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1069);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1064);
					argument();
					setState(1065);
					match(COMMA);
					}
					} 
				}
				setState(1071);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			}
			setState(1092);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				{
				setState(1072);
				argument();
				setState(1074);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1073);
					match(COMMA);
					}
				}

				}
				break;
			case 2:
				{
				setState(1076);
				match(STAR);
				setState(1077);
				test();
				setState(1082);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1078);
						match(COMMA);
						setState(1079);
						argument();
						}
						} 
					}
					setState(1084);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
				}
				setState(1088);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1085);
					match(COMMA);
					setState(1086);
					match(POWER);
					setState(1087);
					test();
					}
				}

				}
				break;
			case 3:
				{
				setState(1090);
				match(POWER);
				setState(1091);
				test();
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

	public static class ArgumentContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_argument);
		int _la;
		try {
			setState(1102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1094);
				test();
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR) {
					{
					setState(1095);
					comp_for();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1098);
				test();
				setState(1099);
				match(ASSIGN);
				setState(1100);
				test();
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

	public static class Comp_iterContext extends ParserRuleContext {
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public Comp_ifContext comp_if() {
			return getRuleContext(Comp_ifContext.class,0);
		}
		public Comp_iterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_iter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterComp_iter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitComp_iter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_iter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_iterContext comp_iter() throws RecognitionException {
		Comp_iterContext _localctx = new Comp_iterContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_comp_iter);
		try {
			setState(1106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1104);
				comp_for();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(1105);
				comp_if();
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

	public static class Comp_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Python3Parser.FOR, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public TerminalNode IN() { return getToken(Python3Parser.IN, 0); }
		public Or_testContext or_test() {
			return getRuleContext(Or_testContext.class,0);
		}
		public Comp_iterContext comp_iter() {
			return getRuleContext(Comp_iterContext.class,0);
		}
		public Comp_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterComp_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitComp_for(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_forContext comp_for() throws RecognitionException {
		Comp_forContext _localctx = new Comp_forContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_comp_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108);
			match(FOR);
			setState(1109);
			exprlist();
			setState(1110);
			match(IN);
			setState(1111);
			or_test();
			setState(1113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF || _la==FOR) {
				{
				setState(1112);
				comp_iter();
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

	public static class Comp_ifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Python3Parser.IF, 0); }
		public Test_nocondContext test_nocond() {
			return getRuleContext(Test_nocondContext.class,0);
		}
		public Comp_iterContext comp_iter() {
			return getRuleContext(Comp_iterContext.class,0);
		}
		public Comp_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterComp_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitComp_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_ifContext comp_if() throws RecognitionException {
		Comp_ifContext _localctx = new Comp_ifContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_comp_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1115);
			match(IF);
			setState(1116);
			test_nocond();
			setState(1118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF || _la==FOR) {
				{
				setState(1117);
				comp_iter();
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

	public static class Yield_exprContext extends ParserRuleContext {
		public TerminalNode YIELD() { return getToken(Python3Parser.YIELD, 0); }
		public Yield_argContext yield_arg() {
			return getRuleContext(Yield_argContext.class,0);
		}
		public Yield_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterYield_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitYield_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitYield_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_exprContext yield_expr() throws RecognitionException {
		Yield_exprContext _localctx = new Yield_exprContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_yield_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1120);
			match(YIELD);
			setState(1122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (FROM - 5)) | (1L << (LAMBDA - 5)) | (1L << (NOT - 5)) | (1L << (NONE - 5)) | (1L << (TRUE - 5)) | (1L << (FALSE - 5)) | (1L << (NAME - 5)) | (1L << (STRING_LITERAL - 5)) | (1L << (BYTES_LITERAL - 5)) | (1L << (DECIMAL_INTEGER - 5)) | (1L << (OCT_INTEGER - 5)) | (1L << (HEX_INTEGER - 5)) | (1L << (BIN_INTEGER - 5)) | (1L << (FLOAT_NUMBER - 5)) | (1L << (IMAG_NUMBER - 5)) | (1L << (ELLIPSIS - 5)) | (1L << (STAR - 5)) | (1L << (OPEN_PAREN - 5)) | (1L << (OPEN_BRACK - 5)) | (1L << (ADD - 5)) | (1L << (MINUS - 5)) | (1L << (NOT_OP - 5)) | (1L << (OPEN_BRACE - 5)))) != 0)) {
				{
				setState(1121);
				yield_arg();
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

	public static class Yield_argContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(Python3Parser.FROM, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Yield_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterYield_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitYield_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitYield_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_argContext yield_arg() throws RecognitionException {
		Yield_argContext _localctx = new Yield_argContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_yield_arg);
		try {
			setState(1127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(1124);
				match(FROM);
				setState(1125);
				test();
				}
				break;
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1126);
				testlist();
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

	public static class StrContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(Python3Parser.STRING_LITERAL, 0); }
		public TerminalNode BYTES_LITERAL() { return getToken(Python3Parser.BYTES_LITERAL, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_str);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1129);
			_la = _input.LA(1);
			if ( !(_la==STRING_LITERAL || _la==BYTES_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class NumberContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode FLOAT_NUMBER() { return getToken(Python3Parser.FLOAT_NUMBER, 0); }
		public TerminalNode IMAG_NUMBER() { return getToken(Python3Parser.IMAG_NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_number);
		try {
			setState(1134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1131);
				integer();
				}
				break;
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1132);
				match(FLOAT_NUMBER);
				}
				break;
			case IMAG_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1133);
				match(IMAG_NUMBER);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL_INTEGER() { return getToken(Python3Parser.DECIMAL_INTEGER, 0); }
		public TerminalNode OCT_INTEGER() { return getToken(Python3Parser.OCT_INTEGER, 0); }
		public TerminalNode HEX_INTEGER() { return getToken(Python3Parser.HEX_INTEGER, 0); }
		public TerminalNode BIN_INTEGER() { return getToken(Python3Parser.BIN_INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Python3Listener ) ((Python3Listener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1136);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3a\u0475\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\2\3\2\3\2\5\2\u00b2\n\2\3\3\3\3\7\3\u00b6\n\3\f"+
		"\3\16\3\u00b9\13\3\3\3\3\3\3\4\3\4\7\4\u00bf\n\4\f\4\16\4\u00c2\13\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\5\5\u00ca\n\5\3\5\5\5\u00cd\n\5\3\5\3\5\3\6\6\6"+
		"\u00d2\n\6\r\6\16\6\u00d3\3\7\3\7\3\7\5\7\u00d9\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00e0\n\b\3\b\3\b\3\b\3\t\3\t\5\t\u00e7\n\t\3\t\3\t\3\n\3\n\3\n"+
		"\5\n\u00ee\n\n\3\n\3\n\3\n\3\n\5\n\u00f4\n\n\7\n\u00f6\n\n\f\n\16\n\u00f9"+
		"\13\n\3\n\3\n\3\n\5\n\u00fe\n\n\3\n\3\n\3\n\3\n\5\n\u0104\n\n\7\n\u0106"+
		"\n\n\f\n\16\n\u0109\13\n\3\n\3\n\3\n\5\n\u010e\n\n\3\n\3\n\5\n\u0112\n"+
		"\n\5\n\u0114\n\n\3\n\3\n\5\n\u0118\n\n\3\n\3\n\3\n\3\n\5\n\u011e\n\n\7"+
		"\n\u0120\n\n\f\n\16\n\u0123\13\n\3\n\3\n\3\n\5\n\u0128\n\n\3\n\3\n\5\n"+
		"\u012c\n\n\3\13\3\13\3\13\5\13\u0131\n\13\3\f\3\f\3\f\5\f\u0136\n\f\3"+
		"\f\3\f\3\f\3\f\5\f\u013c\n\f\7\f\u013e\n\f\f\f\16\f\u0141\13\f\3\f\3\f"+
		"\3\f\5\f\u0146\n\f\3\f\3\f\3\f\3\f\5\f\u014c\n\f\7\f\u014e\n\f\f\f\16"+
		"\f\u0151\13\f\3\f\3\f\3\f\5\f\u0156\n\f\3\f\3\f\5\f\u015a\n\f\5\f\u015c"+
		"\n\f\3\f\3\f\5\f\u0160\n\f\3\f\3\f\3\f\3\f\5\f\u0166\n\f\7\f\u0168\n\f"+
		"\f\f\16\f\u016b\13\f\3\f\3\f\3\f\5\f\u0170\n\f\3\f\3\f\5\f\u0174\n\f\3"+
		"\r\3\r\3\16\3\16\5\16\u017a\n\16\3\17\3\17\3\17\7\17\u017f\n\17\f\17\16"+
		"\17\u0182\13\17\3\17\5\17\u0185\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u0192\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u0199"+
		"\n\21\f\21\16\21\u019c\13\21\3\21\5\21\u019f\n\21\5\21\u01a1\n\21\3\21"+
		"\3\21\3\21\3\21\6\21\u01a7\n\21\r\21\16\21\u01a8\3\21\5\21\u01ac\n\21"+
		"\5\21\u01ae\n\21\5\21\u01b0\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u01b7\n"+
		"\21\f\21\16\21\u01ba\13\21\3\21\5\21\u01bd\n\21\5\21\u01bf\n\21\3\21\3"+
		"\21\3\21\3\21\6\21\u01c5\n\21\r\21\16\21\u01c6\3\21\5\21\u01ca\n\21\5"+
		"\21\u01cc\n\21\5\21\u01ce\n\21\3\21\5\21\u01d1\n\21\3\22\3\22\3\22\3\22"+
		"\5\22\u01d7\n\22\3\22\3\22\3\22\5\22\u01dc\n\22\7\22\u01de\n\22\f\22\16"+
		"\22\u01e1\13\22\5\22\u01e3\n\22\3\23\3\23\5\23\u01e7\n\23\3\23\3\23\3"+
		"\23\5\23\u01ec\n\23\7\23\u01ee\n\23\f\23\16\23\u01f1\13\23\3\23\5\23\u01f4"+
		"\n\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0202\n\27\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u020a\n\32\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\5\34\u0212\n\34\5\34\u0214\n\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u021c\n\34\3\35\3\35\5\35\u0220\n\35\3\36\3\36\3\36\3"+
		"\37\3\37\7\37\u0227\n\37\f\37\16\37\u022a\13\37\3\37\3\37\6\37\u022e\n"+
		"\37\r\37\16\37\u022f\5\37\u0232\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u023b\n\37\3 \3 \3 \5 \u0240\n \3!\3!\3!\5!\u0245\n!\3\"\3\"\3\""+
		"\7\"\u024a\n\"\f\"\16\"\u024d\13\"\3\"\5\"\u0250\n\"\3#\3#\3#\7#\u0255"+
		"\n#\f#\16#\u0258\13#\3$\3$\3$\7$\u025d\n$\f$\16$\u0260\13$\3%\3%\3%\3"+
		"%\7%\u0266\n%\f%\16%\u0269\13%\3&\3&\3&\3&\7&\u026f\n&\f&\16&\u0272\13"+
		"&\3\'\3\'\3\'\3\'\5\'\u0278\n\'\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0282\n(\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\7)\u028d\n)\f)\16)\u0290\13)\3)\3)\3)\5)\u0295"+
		"\n)\3*\3*\3*\3*\3*\3*\3*\5*\u029e\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u02a9"+
		"\n+\3,\3,\3,\3,\3,\3,\3,\6,\u02b2\n,\r,\16,\u02b3\3,\3,\3,\5,\u02b9\n"+
		",\3,\3,\3,\5,\u02be\n,\3,\3,\3,\5,\u02c3\n,\3-\3-\3-\3-\7-\u02c9\n-\f"+
		"-\16-\u02cc\13-\3-\3-\3-\3.\3.\3.\5.\u02d4\n.\3/\3/\3/\3/\5/\u02da\n/"+
		"\5/\u02dc\n/\3/\3/\3/\3/\3/\5/\u02e3\n/\3\60\3\60\3\60\3\60\6\60\u02e9"+
		"\n\60\r\60\16\60\u02ea\3\60\3\60\5\60\u02ef\n\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\5\61\u02f7\n\61\3\61\5\61\u02fa\n\61\3\62\3\62\5\62\u02fe\n\62"+
		"\3\63\3\63\5\63\u0302\n\63\3\63\3\63\3\63\3\64\3\64\5\64\u0309\n\64\3"+
		"\64\3\64\3\64\3\65\3\65\3\65\7\65\u0311\n\65\f\65\16\65\u0314\13\65\3"+
		"\66\3\66\3\66\7\66\u0319\n\66\f\66\16\66\u031c\13\66\3\67\3\67\3\67\5"+
		"\67\u0321\n\67\38\38\38\38\78\u0327\n8\f8\168\u032a\138\39\39\39\39\3"+
		"9\39\39\39\39\39\39\39\39\59\u0339\n9\3:\5:\u033c\n:\3:\3:\3;\3;\3;\7"+
		";\u0343\n;\f;\16;\u0346\13;\3<\3<\3<\7<\u034b\n<\f<\16<\u034e\13<\3=\3"+
		"=\3=\7=\u0353\n=\f=\16=\u0356\13=\3>\3>\3>\3>\3>\7>\u035d\n>\f>\16>\u0360"+
		"\13>\3?\3?\3?\3?\3?\7?\u0367\n?\f?\16?\u036a\13?\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\7@\u0377\n@\f@\16@\u037a\13@\3A\3A\3A\3A\3A\3A\3A\5A\u0383"+
		"\nA\3B\3B\7B\u0387\nB\fB\16B\u038a\13B\3B\3B\5B\u038e\nB\3C\3C\3C\5C\u0393"+
		"\nC\3C\3C\3C\5C\u0398\nC\3C\3C\3C\5C\u039d\nC\3C\3C\3C\3C\3C\6C\u03a4"+
		"\nC\rC\16C\u03a5\3C\3C\3C\3C\5C\u03ac\nC\3D\3D\3D\3D\7D\u03b2\nD\fD\16"+
		"D\u03b5\13D\3D\5D\u03b8\nD\5D\u03ba\nD\3E\3E\5E\u03be\nE\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\5E\u03c8\nE\3F\3F\3F\7F\u03cd\nF\fF\16F\u03d0\13F\3F\5F\u03d3"+
		"\nF\3G\3G\5G\u03d7\nG\3G\3G\5G\u03db\nG\3G\5G\u03de\nG\5G\u03e0\nG\3H"+
		"\3H\5H\u03e4\nH\3I\3I\3I\7I\u03e9\nI\fI\16I\u03ec\13I\3I\5I\u03ef\nI\3"+
		"J\3J\3J\7J\u03f4\nJ\fJ\16J\u03f7\13J\3J\5J\u03fa\nJ\3K\3K\3K\3K\3K\3K"+
		"\3K\3K\3K\7K\u0405\nK\fK\16K\u0408\13K\3K\5K\u040b\nK\5K\u040d\nK\3K\3"+
		"K\3K\3K\7K\u0413\nK\fK\16K\u0416\13K\3K\5K\u0419\nK\5K\u041b\nK\5K\u041d"+
		"\nK\3L\3L\3L\3L\5L\u0423\nL\3L\5L\u0426\nL\3L\3L\3L\3M\3M\3M\7M\u042e"+
		"\nM\fM\16M\u0431\13M\3M\3M\5M\u0435\nM\3M\3M\3M\3M\7M\u043b\nM\fM\16M"+
		"\u043e\13M\3M\3M\3M\5M\u0443\nM\3M\3M\5M\u0447\nM\3N\3N\5N\u044b\nN\3"+
		"N\3N\3N\3N\5N\u0451\nN\3O\3O\5O\u0455\nO\3P\3P\3P\3P\3P\5P\u045c\nP\3"+
		"Q\3Q\3Q\5Q\u0461\nQ\3R\3R\5R\u0465\nR\3S\3S\3S\5S\u046a\nS\3T\3T\3U\3"+
		"U\3U\5U\u0471\nU\3V\3V\3V\2\2W\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\2\6\3\2Q]\3\2/\60\3\2"+
		"\'(\3\2),\2\u04f6\2\u00b1\3\2\2\2\4\u00b7\3\2\2\2\6\u00bc\3\2\2\2\b\u00c5"+
		"\3\2\2\2\n\u00d1\3\2\2\2\f\u00d5\3\2\2\2\16\u00da\3\2\2\2\20\u00e4\3\2"+
		"\2\2\22\u012b\3\2\2\2\24\u012d\3\2\2\2\26\u0173\3\2\2\2\30\u0175\3\2\2"+
		"\2\32\u0179\3\2\2\2\34\u017b\3\2\2\2\36\u0191\3\2\2\2 \u01d0\3\2\2\2\""+
		"\u01d2\3\2\2\2$\u01e6\3\2\2\2&\u01f5\3\2\2\2(\u01f7\3\2\2\2*\u01fa\3\2"+
		"\2\2,\u0201\3\2\2\2.\u0203\3\2\2\2\60\u0205\3\2\2\2\62\u0207\3\2\2\2\64"+
		"\u020b\3\2\2\2\66\u021b\3\2\2\28\u021f\3\2\2\2:\u0221\3\2\2\2<\u0224\3"+
		"\2\2\2>\u023c\3\2\2\2@\u0241\3\2\2\2B\u0246\3\2\2\2D\u0251\3\2\2\2F\u0259"+
		"\3\2\2\2H\u0261\3\2\2\2J\u026a\3\2\2\2L\u0273\3\2\2\2N\u0281\3\2\2\2P"+
		"\u0283\3\2\2\2R\u0296\3\2\2\2T\u029f\3\2\2\2V\u02aa\3\2\2\2X\u02c4\3\2"+
		"\2\2Z\u02d0\3\2\2\2\\\u02e2\3\2\2\2^\u02ee\3\2\2\2`\u02f9\3\2\2\2b\u02fd"+
		"\3\2\2\2d\u02ff\3\2\2\2f\u0306\3\2\2\2h\u030d\3\2\2\2j\u0315\3\2\2\2l"+
		"\u0320\3\2\2\2n\u0322\3\2\2\2p\u0338\3\2\2\2r\u033b\3\2\2\2t\u033f\3\2"+
		"\2\2v\u0347\3\2\2\2x\u034f\3\2\2\2z\u0357\3\2\2\2|\u0361\3\2\2\2~\u036b"+
		"\3\2\2\2\u0080\u0382\3\2\2\2\u0082\u0384\3\2\2\2\u0084\u03ab\3\2\2\2\u0086"+
		"\u03ad\3\2\2\2\u0088\u03c7\3\2\2\2\u008a\u03c9\3\2\2\2\u008c\u03df\3\2"+
		"\2\2\u008e\u03e1\3\2\2\2\u0090\u03e5\3\2\2\2\u0092\u03f0\3\2\2\2\u0094"+
		"\u041c\3\2\2\2\u0096\u041e\3\2\2\2\u0098\u042f\3\2\2\2\u009a\u0450\3\2"+
		"\2\2\u009c\u0454\3\2\2\2\u009e\u0456\3\2\2\2\u00a0\u045d\3\2\2\2\u00a2"+
		"\u0462\3\2\2\2\u00a4\u0469\3\2\2\2\u00a6\u046b\3\2\2\2\u00a8\u0470\3\2"+
		"\2\2\u00aa\u0472\3\2\2\2\u00ac\u00b2\7%\2\2\u00ad\u00b2\5\34\17\2\u00ae"+
		"\u00af\5N(\2\u00af\u00b0\7%\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ac\3\2\2"+
		"\2\u00b1\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b2\3\3\2\2\2\u00b3\u00b6"+
		"\7%\2\2\u00b4\u00b6\5\32\16\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2"+
		"\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba"+
		"\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7\2\2\3\u00bb\5\3\2\2\2\u00bc"+
		"\u00c0\5\u0092J\2\u00bd\u00bf\7%\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3"+
		"\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7\2\2\3\u00c4\7\3\2\2\2\u00c5\u00c6\7O\2\2"+
		"\u00c6\u00cc\5F$\2\u00c7\u00c9\7\62\2\2\u00c8\u00ca\5\u0098M\2\u00c9\u00c8"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\7\63\2\2"+
		"\u00cc\u00c7\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf"+
		"\7%\2\2\u00cf\t\3\2\2\2\u00d0\u00d2\5\b\5\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\13\3\2\2"+
		"\2\u00d5\u00d8\5\n\6\2\u00d6\u00d9\5\u0096L\2\u00d7\u00d9\5\16\b\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\r\3\2\2\2\u00da\u00db\7\4\2\2"+
		"\u00db\u00dc\7&\2\2\u00dc\u00df\5\20\t\2\u00dd\u00de\7P\2\2\u00de\u00e0"+
		"\5`\61\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\7\65\2\2\u00e2\u00e3\5^\60\2\u00e3\17\3\2\2\2\u00e4\u00e6\7\62"+
		"\2\2\u00e5\u00e7\5\22\n\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\7\63\2\2\u00e9\21\3\2\2\2\u00ea\u00ed\5\24"+
		"\13\2\u00eb\u00ec\78\2\2\u00ec\u00ee\5`\61\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00f7\3\2\2\2\u00ef\u00f0\7\64\2\2\u00f0\u00f3\5"+
		"\24\13\2\u00f1\u00f2\78\2\2\u00f2\u00f4\5`\61\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00ef\3\2\2\2\u00f6\u00f9\3\2"+
		"\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u0113\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00fa\u0111\7\64\2\2\u00fb\u00fd\7\61\2\2\u00fc\u00fe\5"+
		"\24\13\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0107\3\2\2\2\u00ff"+
		"\u0100\7\64\2\2\u0100\u0103\5\24\13\2\u0101\u0102\78\2\2\u0102\u0104\5"+
		"`\61\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105"+
		"\u00ff\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u010d\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7\64\2\2\u010b"+
		"\u010c\7\67\2\2\u010c\u010e\5\24\13\2\u010d\u010a\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u0112\3\2\2\2\u010f\u0110\7\67\2\2\u0110\u0112\5\24\13"+
		"\2\u0111\u00fb\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114"+
		"\3\2\2\2\u0113\u00fa\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u012c\3\2\2\2\u0115"+
		"\u0117\7\61\2\2\u0116\u0118\5\24\13\2\u0117\u0116\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u0121\3\2\2\2\u0119\u011a\7\64\2\2\u011a\u011d\5\24\13"+
		"\2\u011b\u011c\78\2\2\u011c\u011e\5`\61\2\u011d\u011b\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u0119\3\2\2\2\u0120\u0123\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0127\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0124\u0125\7\64\2\2\u0125\u0126\7\67\2\2\u0126\u0128\5\24\13\2\u0127"+
		"\u0124\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012c\3\2\2\2\u0129\u012a\7\67"+
		"\2\2\u012a\u012c\5\24\13\2\u012b\u00ea\3\2\2\2\u012b\u0115\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\23\3\2\2\2\u012d\u0130\7&\2\2\u012e\u012f\7\65\2"+
		"\2\u012f\u0131\5`\61\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\25"+
		"\3\2\2\2\u0132\u0135\5\30\r\2\u0133\u0134\78\2\2\u0134\u0136\5`\61\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u013f\3\2\2\2\u0137\u0138\7\64"+
		"\2\2\u0138\u013b\5\30\r\2\u0139\u013a\78\2\2\u013a\u013c\5`\61\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u0137\3\2"+
		"\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\u015b\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0159\7\64\2\2\u0143\u0145\7"+
		"\61\2\2\u0144\u0146\5\30\r\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u014f\3\2\2\2\u0147\u0148\7\64\2\2\u0148\u014b\5\30\r\2\u0149\u014a\7"+
		"8\2\2\u014a\u014c\5`\61\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014e\3\2\2\2\u014d\u0147\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u014f\u0150\3\2\2\2\u0150\u0155\3\2\2\2\u0151\u014f\3\2\2\2\u0152"+
		"\u0153\7\64\2\2\u0153\u0154\7\67\2\2\u0154\u0156\5\30\r\2\u0155\u0152"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u015a\3\2\2\2\u0157\u0158\7\67\2\2"+
		"\u0158\u015a\5\30\r\2\u0159\u0143\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0142\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u0174\3\2\2\2\u015d\u015f\7\61\2\2\u015e\u0160\5\30\r\2\u015f\u015e\3"+
		"\2\2\2\u015f\u0160\3\2\2\2\u0160\u0169\3\2\2\2\u0161\u0162\7\64\2\2\u0162"+
		"\u0165\5\30\r\2\u0163\u0164\78\2\2\u0164\u0166\5`\61\2\u0165\u0163\3\2"+
		"\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0161\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016f\3\2"+
		"\2\2\u016b\u0169\3\2\2\2\u016c\u016d\7\64\2\2\u016d\u016e\7\67\2\2\u016e"+
		"\u0170\5\30\r\2\u016f\u016c\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0174\3"+
		"\2\2\2\u0171\u0172\7\67\2\2\u0172\u0174\5\30\r\2\u0173\u0132\3\2\2\2\u0173"+
		"\u015d\3\2\2\2\u0173\u0171\3\2\2\2\u0174\27\3\2\2\2\u0175\u0176\7&\2\2"+
		"\u0176\31\3\2\2\2\u0177\u017a\5\34\17\2\u0178\u017a\5N(\2\u0179\u0177"+
		"\3\2\2\2\u0179\u0178\3\2\2\2\u017a\33\3\2\2\2\u017b\u0180\5\36\20\2\u017c"+
		"\u017d\7\66\2\2\u017d\u017f\5\36\20\2\u017e\u017c\3\2\2\2\u017f\u0182"+
		"\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0184\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0183\u0185\7\66\2\2\u0184\u0183\3\2\2\2\u0184\u0185\3"+
		"\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\7%\2\2\u0187\35\3\2\2\2\u0188\u0192"+
		"\5 \21\2\u0189\u0192\5\"\22\2\u018a\u0192\5(\25\2\u018b\u0192\5*\26\2"+
		"\u018c\u0192\5,\27\2\u018d\u0192\58\35\2\u018e\u0192\5H%\2\u018f\u0192"+
		"\5J&\2\u0190\u0192\5L\'\2\u0191\u0188\3\2\2\2\u0191\u0189\3\2\2\2\u0191"+
		"\u018a\3\2\2\2\u0191\u018b\3\2\2\2\u0191\u018c\3\2\2\2\u0191\u018d\3\2"+
		"\2\2\u0191\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2\u0192"+
		"\37\3\2\2\2\u0193\u0194\7\3\2\2\u0194\u01af\7\62\2\2\u0195\u019a\5`\61"+
		"\2\u0196\u0197\7\64\2\2\u0197\u0199\5`\61\2\u0198\u0196\3\2\2\2\u0199"+
		"\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019e\3\2"+
		"\2\2\u019c\u019a\3\2\2\2\u019d\u019f\7\64\2\2\u019e\u019d\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u0195\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a1\u01b0\3\2\2\2\u01a2\u01a3\7?\2\2\u01a3\u01ad\5`\61\2\u01a4"+
		"\u01a5\7\64\2\2\u01a5\u01a7\5`\61\2\u01a6\u01a4\3\2\2\2\u01a7\u01a8\3"+
		"\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa"+
		"\u01ac\7\64\2\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae\3"+
		"\2\2\2\u01ad\u01a6\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af"+
		"\u01a0\3\2\2\2\u01af\u01a2\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01d1\7\63"+
		"\2\2\u01b2\u01cd\7\3\2\2\u01b3\u01b8\5`\61\2\u01b4\u01b5\7\64\2\2\u01b5"+
		"\u01b7\5`\61\2\u01b6\u01b4\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb"+
		"\u01bd\7\64\2\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3"+
		"\2\2\2\u01be\u01b3\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01ce\3\2\2\2\u01c0"+
		"\u01c1\7?\2\2\u01c1\u01cb\5`\61\2\u01c2\u01c3\7\64\2\2\u01c3\u01c5\5`"+
		"\61\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6"+
		"\u01c7\3\2\2\2\u01c7\u01c9\3\2\2\2\u01c8\u01ca\7\64\2\2\u01c9\u01c8\3"+
		"\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01c4\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01be\3\2\2\2\u01cd\u01c0\3\2"+
		"\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\b\21\1\2\u01d0\u0193\3\2\2\2\u01d0"+
		"\u01b2\3\2\2\2\u01d1!\3\2\2\2\u01d2\u01e2\5$\23\2\u01d3\u01d6\5&\24\2"+
		"\u01d4\u01d7\5\u00a2R\2\u01d5\u01d7\5\u0092J\2\u01d6\u01d4\3\2\2\2\u01d6"+
		"\u01d5\3\2\2\2\u01d7\u01e3\3\2\2\2\u01d8\u01db\78\2\2\u01d9\u01dc\5\u00a2"+
		"R\2\u01da\u01dc\5$\23\2\u01db\u01d9\3\2\2\2\u01db\u01da\3\2\2\2\u01dc"+
		"\u01de\3\2\2\2\u01dd\u01d8\3\2\2\2\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2"+
		"\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2"+
		"\u01d3\3\2\2\2\u01e2\u01df\3\2\2\2\u01e3#\3\2\2\2\u01e4\u01e7\5`\61\2"+
		"\u01e5\u01e7\5r:\2\u01e6\u01e4\3\2\2\2\u01e6\u01e5\3\2\2\2\u01e7\u01ef"+
		"\3\2\2\2\u01e8\u01eb\7\64\2\2\u01e9\u01ec\5`\61\2\u01ea\u01ec\5r:\2\u01eb"+
		"\u01e9\3\2\2\2\u01eb\u01ea\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01e8\3\2"+
		"\2\2\u01ee\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f4\7\64\2\2\u01f3\u01f2\3"+
		"\2\2\2\u01f3\u01f4\3\2\2\2\u01f4%\3\2\2\2\u01f5\u01f6\t\2\2\2\u01f6\'"+
		"\3\2\2\2\u01f7\u01f8\7!\2\2\u01f8\u01f9\5\u0090I\2\u01f9)\3\2\2\2\u01fa"+
		"\u01fb\7\"\2\2\u01fb+\3\2\2\2\u01fc\u0202\5.\30\2\u01fd\u0202\5\60\31"+
		"\2\u01fe\u0202\5\62\32\2\u01ff\u0202\5\66\34\2\u0200\u0202\5\64\33\2\u0201"+
		"\u01fc\3\2\2\2\u0201\u01fd\3\2\2\2\u0201\u01fe\3\2\2\2\u0201\u01ff\3\2"+
		"\2\2\u0201\u0200\3\2\2\2\u0202-\3\2\2\2\u0203\u0204\7$\2\2\u0204/\3\2"+
		"\2\2\u0205\u0206\7#\2\2\u0206\61\3\2\2\2\u0207\u0209\7\5\2\2\u0208\u020a"+
		"\5\u0092J\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2\2\2\u020a\63\3\2\2\2\u020b"+
		"\u020c\5\u00a2R\2\u020c\65\3\2\2\2\u020d\u0213\7\6\2\2\u020e\u0211\5`"+
		"\61\2\u020f\u0210\7\7\2\2\u0210\u0212\5`\61\2\u0211\u020f\3\2\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\u0214\3\2\2\2\u0213\u020e\3\2\2\2\u0213\u0214\3\2"+
		"\2\2\u0214\u021c\3\2\2\2\u0215\u0216\7\6\2\2\u0216\u0217\7&\2\2\u0217"+
		"\u0218\7\64\2\2\u0218\u0219\5\u00a6T\2\u0219\u021a\b\34\1\2\u021a\u021c"+
		"\3\2\2\2\u021b\u020d\3\2\2\2\u021b\u0215\3\2\2\2\u021c\67\3\2\2\2\u021d"+
		"\u0220\5:\36\2\u021e\u0220\5<\37\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2"+
		"\2\2\u02209\3\2\2\2\u0221\u0222\7\b\2\2\u0222\u0223\5D#\2\u0223;\3\2\2"+
		"\2\u0224\u0231\7\7\2\2\u0225\u0227\t\3\2\2\u0226\u0225\3\2\2\2\u0227\u022a"+
		"\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022b\3\2\2\2\u022a"+
		"\u0228\3\2\2\2\u022b\u0232\5F$\2\u022c\u022e\t\3\2\2\u022d\u022c\3\2\2"+
		"\2\u022e\u022f\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0232"+
		"\3\2\2\2\u0231\u0228\3\2\2\2\u0231\u022d\3\2\2\2\u0232\u0233\3\2\2\2\u0233"+
		"\u023a\7\b\2\2\u0234\u023b\7\61\2\2\u0235\u0236\7\62\2\2\u0236\u0237\5"+
		"B\"\2\u0237\u0238\7\63\2\2\u0238\u023b\3\2\2\2\u0239\u023b\5B\"\2\u023a"+
		"\u0234\3\2\2\2\u023a\u0235\3\2\2\2\u023a\u0239\3\2\2\2\u023b=\3\2\2\2"+
		"\u023c\u023f\7&\2\2\u023d\u023e\7\t\2\2\u023e\u0240\7&\2\2\u023f\u023d"+
		"\3\2\2\2\u023f\u0240\3\2\2\2\u0240?\3\2\2\2\u0241\u0244\5F$\2\u0242\u0243"+
		"\7\t\2\2\u0243\u0245\7&\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245"+
		"A\3\2\2\2\u0246\u024b\5> \2\u0247\u0248\7\64\2\2\u0248\u024a\5> \2\u0249"+
		"\u0247\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2"+
		"\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0250\7\64\2\2\u024f"+
		"\u024e\3\2\2\2\u024f\u0250\3\2\2\2\u0250C\3\2\2\2\u0251\u0256\5@!\2\u0252"+
		"\u0253\7\64\2\2\u0253\u0255\5@!\2\u0254\u0252\3\2\2\2\u0255\u0258\3\2"+
		"\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257E\3\2\2\2\u0258\u0256"+
		"\3\2\2\2\u0259\u025e\7&\2\2\u025a\u025b\7/\2\2\u025b\u025d\7&\2\2\u025c"+
		"\u025a\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2"+
		"\2\2\u025fG\3\2\2\2\u0260\u025e\3\2\2\2\u0261\u0262\7\n\2\2\u0262\u0267"+
		"\7&\2\2\u0263\u0264\7\64\2\2\u0264\u0266\7&\2\2\u0265\u0263\3\2\2\2\u0266"+
		"\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268I\3\2\2\2"+
		"\u0269\u0267\3\2\2\2\u026a\u026b\7\13\2\2\u026b\u0270\7&\2\2\u026c\u026d"+
		"\7\64\2\2\u026d\u026f\7&\2\2\u026e\u026c\3\2\2\2\u026f\u0272\3\2\2\2\u0270"+
		"\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271K\3\2\2\2\u0272\u0270\3\2\2\2"+
		"\u0273\u0274\7\f\2\2\u0274\u0277\5`\61\2\u0275\u0276\7\64\2\2\u0276\u0278"+
		"\5`\61\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278M\3\2\2\2\u0279"+
		"\u0282\5P)\2\u027a\u0282\5R*\2\u027b\u0282\5T+\2\u027c\u0282\5V,\2\u027d"+
		"\u0282\5X-\2\u027e\u0282\5\16\b\2\u027f\u0282\5\u0096L\2\u0280\u0282\5"+
		"\f\7\2\u0281\u0279\3\2\2\2\u0281\u027a\3\2\2\2\u0281\u027b\3\2\2\2\u0281"+
		"\u027c\3\2\2\2\u0281\u027d\3\2\2\2\u0281\u027e\3\2\2\2\u0281\u027f\3\2"+
		"\2\2\u0281\u0280\3\2\2\2\u0282O\3\2\2\2\u0283\u0284\7\r\2\2\u0284\u0285"+
		"\5`\61\2\u0285\u0286\7\65\2\2\u0286\u028e\5^\60\2\u0287\u0288\7\16\2\2"+
		"\u0288\u0289\5`\61\2\u0289\u028a\7\65\2\2\u028a\u028b\5^\60\2\u028b\u028d"+
		"\3\2\2\2\u028c\u0287\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c\3\2\2\2\u028e"+
		"\u028f\3\2\2\2\u028f\u0294\3\2\2\2\u0290\u028e\3\2\2\2\u0291\u0292\7\17"+
		"\2\2\u0292\u0293\7\65\2\2\u0293\u0295\5^\60\2\u0294\u0291\3\2\2\2\u0294"+
		"\u0295\3\2\2\2\u0295Q\3\2\2\2\u0296\u0297\7\20\2\2\u0297\u0298\5`\61\2"+
		"\u0298\u0299\7\65\2\2\u0299\u029d\5^\60\2\u029a\u029b\7\17\2\2\u029b\u029c"+
		"\7\65\2\2\u029c\u029e\5^\60\2\u029d\u029a\3\2\2\2\u029d\u029e\3\2\2\2"+
		"\u029eS\3\2\2\2\u029f\u02a0\7\21\2\2\u02a0\u02a1\5\u0090I\2\u02a1\u02a2"+
		"\7\22\2\2\u02a2\u02a3\5\u0092J\2\u02a3\u02a4\7\65\2\2\u02a4\u02a8\5^\60"+
		"\2\u02a5\u02a6\7\17\2\2\u02a6\u02a7\7\65\2\2\u02a7\u02a9\5^\60\2\u02a8"+
		"\u02a5\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9U\3\2\2\2\u02aa\u02ab\7\23\2\2"+
		"\u02ab\u02ac\7\65\2\2\u02ac\u02c2\5^\60\2\u02ad\u02ae\5\\/\2\u02ae\u02af"+
		"\7\65\2\2\u02af\u02b0\5^\60\2\u02b0\u02b2\3\2\2\2\u02b1\u02ad\3\2\2\2"+
		"\u02b2\u02b3\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b8"+
		"\3\2\2\2\u02b5\u02b6\7\17\2\2\u02b6\u02b7\7\65\2\2\u02b7\u02b9\5^\60\2"+
		"\u02b8\u02b5\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bd\3\2\2\2\u02ba\u02bb"+
		"\7\24\2\2\u02bb\u02bc\7\65\2\2\u02bc\u02be\5^\60\2\u02bd\u02ba\3\2\2\2"+
		"\u02bd\u02be\3\2\2\2\u02be\u02c3\3\2\2\2\u02bf\u02c0\7\24\2\2\u02c0\u02c1"+
		"\7\65\2\2\u02c1\u02c3\5^\60\2\u02c2\u02b1\3\2\2\2\u02c2\u02bf\3\2\2\2"+
		"\u02c3W\3\2\2\2\u02c4\u02c5\7\25\2\2\u02c5\u02ca\5Z.\2\u02c6\u02c7\7\64"+
		"\2\2\u02c7\u02c9\5Z.\2\u02c8\u02c6\3\2\2\2\u02c9\u02cc\3\2\2\2\u02ca\u02c8"+
		"\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cd\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cd"+
		"\u02ce\7\65\2\2\u02ce\u02cf\5^\60\2\u02cfY\3\2\2\2\u02d0\u02d3\5`\61\2"+
		"\u02d1\u02d2\7\t\2\2\u02d2\u02d4\5t;\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4"+
		"\3\2\2\2\u02d4[\3\2\2\2\u02d5\u02db\7\26\2\2\u02d6\u02d9\5`\61\2\u02d7"+
		"\u02d8\7\t\2\2\u02d8\u02da\7&\2\2\u02d9\u02d7\3\2\2\2\u02d9\u02da\3\2"+
		"\2\2\u02da\u02dc\3\2\2\2\u02db\u02d6\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02e3\3\2\2\2\u02dd\u02de\7\26\2\2\u02de\u02df\7&\2\2\u02df\u02e0\7\64"+
		"\2\2\u02e0\u02e1\7&\2\2\u02e1\u02e3\b/\1\2\u02e2\u02d5\3\2\2\2\u02e2\u02dd"+
		"\3\2\2\2\u02e3]\3\2\2\2\u02e4\u02ef\5\34\17\2\u02e5\u02e6\7%\2\2\u02e6"+
		"\u02e8\7`\2\2\u02e7\u02e9\5\32\16\2\u02e8\u02e7\3\2\2\2\u02e9\u02ea\3"+
		"\2\2\2\u02ea\u02e8\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec"+
		"\u02ed\7a\2\2\u02ed\u02ef\3\2\2\2\u02ee\u02e4\3\2\2\2\u02ee\u02e5\3\2"+
		"\2\2\u02ef_\3\2\2\2\u02f0\u02f6\5h\65\2\u02f1\u02f2\7\r\2\2\u02f2\u02f3"+
		"\5h\65\2\u02f3\u02f4\7\17\2\2\u02f4\u02f5\5`\61\2\u02f5\u02f7\3\2\2\2"+
		"\u02f6\u02f1\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02fa\3\2\2\2\u02f8\u02fa"+
		"\5d\63\2\u02f9\u02f0\3\2\2\2\u02f9\u02f8\3\2\2\2\u02faa\3\2\2\2\u02fb"+
		"\u02fe\5h\65\2\u02fc\u02fe\5f\64\2\u02fd\u02fb\3\2\2\2\u02fd\u02fc\3\2"+
		"\2\2\u02fec\3\2\2\2\u02ff\u0301\7\27\2\2\u0300\u0302\5\26\f\2\u0301\u0300"+
		"\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0304\7\65\2\2"+
		"\u0304\u0305\5`\61\2\u0305e\3\2\2\2\u0306\u0308\7\27\2\2\u0307\u0309\5"+
		"\26\f\2\u0308\u0307\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\3\2\2\2\u030a"+
		"\u030b\7\65\2\2\u030b\u030c\5b\62\2\u030cg\3\2\2\2\u030d\u0312\5j\66\2"+
		"\u030e\u030f\7\30\2\2\u030f\u0311\5j\66\2\u0310\u030e\3\2\2\2\u0311\u0314"+
		"\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313i\3\2\2\2\u0314"+
		"\u0312\3\2\2\2\u0315\u031a\5l\67\2\u0316\u0317\7\31\2\2\u0317\u0319\5"+
		"l\67\2\u0318\u0316\3\2\2\2\u0319\u031c\3\2\2\2\u031a\u0318\3\2\2\2\u031a"+
		"\u031b\3\2\2\2\u031bk\3\2\2\2\u031c\u031a\3\2\2\2\u031d\u031e\7\32\2\2"+
		"\u031e\u0321\5l\67\2\u031f\u0321\5n8\2\u0320\u031d\3\2\2\2\u0320\u031f"+
		"\3\2\2\2\u0321m\3\2\2\2\u0322\u0328\5r:\2\u0323\u0324\5p9\2\u0324\u0325"+
		"\5r:\2\u0325\u0327\3\2\2\2\u0326\u0323\3\2\2\2\u0327\u032a\3\2\2\2\u0328"+
		"\u0326\3\2\2\2\u0328\u0329\3\2\2\2\u0329o\3\2\2\2\u032a\u0328\3\2\2\2"+
		"\u032b\u0339\7H\2\2\u032c\u0339\7I\2\2\u032d\u0339\7J\2\2\u032e\u0339"+
		"\7K\2\2\u032f\u0339\7L\2\2\u0330\u0339\7M\2\2\u0331\u0339\7N\2\2\u0332"+
		"\u0339\7\22\2\2\u0333\u0334\7\32\2\2\u0334\u0339\7\22\2\2\u0335\u0339"+
		"\7\33\2\2\u0336\u0337\7\33\2\2\u0337\u0339\7\32\2\2\u0338\u032b\3\2\2"+
		"\2\u0338\u032c\3\2\2\2\u0338\u032d\3\2\2\2\u0338\u032e\3\2\2\2\u0338\u032f"+
		"\3\2\2\2\u0338\u0330\3\2\2\2\u0338\u0331\3\2\2\2\u0338\u0332\3\2\2\2\u0338"+
		"\u0333\3\2\2\2\u0338\u0335\3\2\2\2\u0338\u0336\3\2\2\2\u0339q\3\2\2\2"+
		"\u033a\u033c\7\61\2\2\u033b\u033a\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033d"+
		"\3\2\2\2\u033d\u033e\5t;\2\u033es\3\2\2\2\u033f\u0344\5v<\2\u0340\u0341"+
		"\7;\2\2\u0341\u0343\5v<\2\u0342\u0340\3\2\2\2\u0343\u0346\3\2\2\2\u0344"+
		"\u0342\3\2\2\2\u0344\u0345\3\2\2\2\u0345u\3\2\2\2\u0346\u0344\3\2\2\2"+
		"\u0347\u034c\5x=\2\u0348\u0349\7<\2\2\u0349\u034b\5x=\2\u034a\u0348\3"+
		"\2\2\2\u034b\u034e\3\2\2\2\u034c\u034a\3\2\2\2\u034c\u034d\3\2\2\2\u034d"+
		"w\3\2\2\2\u034e\u034c\3\2\2\2\u034f\u0354\5z>\2\u0350\u0351\7=\2\2\u0351"+
		"\u0353\5z>\2\u0352\u0350\3\2\2\2\u0353\u0356\3\2\2\2\u0354\u0352\3\2\2"+
		"\2\u0354\u0355\3\2\2\2\u0355y\3\2\2\2\u0356\u0354\3\2\2\2\u0357\u035e"+
		"\5|?\2\u0358\u0359\7>\2\2\u0359\u035d\5|?\2\u035a\u035b\7?\2\2\u035b\u035d"+
		"\5|?\2\u035c\u0358\3\2\2\2\u035c\u035a\3\2\2\2\u035d\u0360\3\2\2\2\u035e"+
		"\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f{\3\2\2\2\u0360\u035e\3\2\2\2"+
		"\u0361\u0368\5~@\2\u0362\u0363\7@\2\2\u0363\u0367\5~@\2\u0364\u0365\7"+
		"A\2\2\u0365\u0367\5~@\2\u0366\u0362\3\2\2\2\u0366\u0364\3\2\2\2\u0367"+
		"\u036a\3\2\2\2\u0368\u0366\3\2\2\2\u0368\u0369\3\2\2\2\u0369}\3\2\2\2"+
		"\u036a\u0368\3\2\2\2\u036b\u0378\5\u0080A\2\u036c\u036d\7\61\2\2\u036d"+
		"\u0377\5\u0080A\2\u036e\u036f\7B\2\2\u036f\u0377\5\u0080A\2\u0370\u0371"+
		"\7C\2\2\u0371\u0377\5\u0080A\2\u0372\u0373\7D\2\2\u0373\u0377\5\u0080"+
		"A\2\u0374\u0375\7O\2\2\u0375\u0377\5\u0080A\2\u0376\u036c\3\2\2\2\u0376"+
		"\u036e\3\2\2\2\u0376\u0370\3\2\2\2\u0376\u0372\3\2\2\2\u0376\u0374\3\2"+
		"\2\2\u0377\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0378\u0379\3\2\2\2\u0379"+
		"\177\3\2\2\2\u037a\u0378\3\2\2\2\u037b\u037c\7@\2\2\u037c\u0383\5\u0080"+
		"A\2\u037d\u037e\7A\2\2\u037e\u0383\5\u0080A\2\u037f\u0380\7E\2\2\u0380"+
		"\u0383\5\u0080A\2\u0381\u0383\5\u0082B\2\u0382\u037b\3\2\2\2\u0382\u037d"+
		"\3\2\2\2\u0382\u037f\3\2\2\2\u0382\u0381\3\2\2\2\u0383\u0081\3\2\2\2\u0384"+
		"\u0388\5\u0084C\2\u0385\u0387\5\u0088E\2\u0386\u0385\3\2\2\2\u0387\u038a"+
		"\3\2\2\2\u0388\u0386\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038d\3\2\2\2\u038a"+
		"\u0388\3\2\2\2\u038b\u038c\7\67\2\2\u038c\u038e\5\u0080A\2\u038d\u038b"+
		"\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u0083\3\2\2\2\u038f\u0392\7\62\2\2"+
		"\u0390\u0393\5\u00a2R\2\u0391\u0393\5\u0086D\2\u0392\u0390\3\2\2\2\u0392"+
		"\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u03ac\7\63"+
		"\2\2\u0395\u0397\79\2\2\u0396\u0398\5\u0086D\2\u0397\u0396\3\2\2\2\u0397"+
		"\u0398\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u03ac\7:\2\2\u039a\u039c\7F\2"+
		"\2\u039b\u039d\5\u0094K\2\u039c\u039b\3\2\2\2\u039c\u039d\3\2\2\2\u039d"+
		"\u039e\3\2\2\2\u039e\u03ac\7G\2\2\u039f\u03a0\bC\1\2\u03a0\u03ac\7&\2"+
		"\2\u03a1\u03ac\5\u00a8U\2\u03a2\u03a4\5\u00a6T\2\u03a3\u03a2\3\2\2\2\u03a4"+
		"\u03a5\3\2\2\2\u03a5\u03a3\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03ac\3\2"+
		"\2\2\u03a7\u03ac\7\60\2\2\u03a8\u03ac\7\34\2\2\u03a9\u03ac\7\35\2\2\u03aa"+
		"\u03ac\7\36\2\2\u03ab\u038f\3\2\2\2\u03ab\u0395\3\2\2\2\u03ab\u039a\3"+
		"\2\2\2\u03ab\u039f\3\2\2\2\u03ab\u03a1\3\2\2\2\u03ab\u03a3\3\2\2\2\u03ab"+
		"\u03a7\3\2\2\2\u03ab\u03a8\3\2\2\2\u03ab\u03a9\3\2\2\2\u03ab\u03aa\3\2"+
		"\2\2\u03ac\u0085\3\2\2\2\u03ad\u03b9\5`\61\2\u03ae\u03ba\5\u009eP\2\u03af"+
		"\u03b0\7\64\2\2\u03b0\u03b2\5`\61\2\u03b1\u03af\3\2\2\2\u03b2\u03b5\3"+
		"\2\2\2\u03b3\u03b1\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b7\3\2\2\2\u03b5"+
		"\u03b3\3\2\2\2\u03b6\u03b8\7\64\2\2\u03b7\u03b6\3\2\2\2\u03b7\u03b8\3"+
		"\2\2\2\u03b8\u03ba\3\2\2\2\u03b9\u03ae\3\2\2\2\u03b9\u03b3\3\2\2\2\u03ba"+
		"\u0087\3\2\2\2\u03bb\u03bd\7\62\2\2\u03bc\u03be\5\u0098M\2\u03bd\u03bc"+
		"\3\2\2\2\u03bd\u03be\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c8\7\63\2\2"+
		"\u03c0\u03c1\79\2\2\u03c1\u03c2\5\u008aF\2\u03c2\u03c3\7:\2\2\u03c3\u03c8"+
		"\3\2\2\2\u03c4\u03c5\7/\2\2\u03c5\u03c6\7&\2\2\u03c6\u03c8\bE\1\2\u03c7"+
		"\u03bb\3\2\2\2\u03c7\u03c0\3\2\2\2\u03c7\u03c4\3\2\2\2\u03c8\u0089\3\2"+
		"\2\2\u03c9\u03ce\5\u008cG\2\u03ca\u03cb\7\64\2\2\u03cb\u03cd\5\u008cG"+
		"\2\u03cc\u03ca\3\2\2\2\u03cd\u03d0\3\2\2\2\u03ce\u03cc\3\2\2\2\u03ce\u03cf"+
		"\3\2\2\2\u03cf\u03d2\3\2\2\2\u03d0\u03ce\3\2\2\2\u03d1\u03d3\7\64\2\2"+
		"\u03d2\u03d1\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u008b\3\2\2\2\u03d4\u03e0"+
		"\5`\61\2\u03d5\u03d7\5`\61\2\u03d6\u03d5\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7"+
		"\u03d8\3\2\2\2\u03d8\u03da\7\65\2\2\u03d9\u03db\5`\61\2\u03da\u03d9\3"+
		"\2\2\2\u03da\u03db\3\2\2\2\u03db\u03dd\3\2\2\2\u03dc\u03de\5\u008eH\2"+
		"\u03dd\u03dc\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e0\3\2\2\2\u03df\u03d4"+
		"\3\2\2\2\u03df\u03d6\3\2\2\2\u03e0\u008d\3\2\2\2\u03e1\u03e3\7\65\2\2"+
		"\u03e2\u03e4\5`\61\2\u03e3\u03e2\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u008f"+
		"\3\2\2\2\u03e5\u03ea\5r:\2\u03e6\u03e7\7\64\2\2\u03e7\u03e9\5r:\2\u03e8"+
		"\u03e6\3\2\2\2\u03e9\u03ec\3\2\2\2\u03ea\u03e8\3\2\2\2\u03ea\u03eb\3\2"+
		"\2\2\u03eb\u03ee\3\2\2\2\u03ec\u03ea\3\2\2\2\u03ed\u03ef\7\64\2\2\u03ee"+
		"\u03ed\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef\u0091\3\2\2\2\u03f0\u03f5\5`"+
		"\61\2\u03f1\u03f2\7\64\2\2\u03f2\u03f4\5`\61\2\u03f3\u03f1\3\2\2\2\u03f4"+
		"\u03f7\3\2\2\2\u03f5\u03f3\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03f9\3\2"+
		"\2\2\u03f7\u03f5\3\2\2\2\u03f8\u03fa\7\64\2\2\u03f9\u03f8\3\2\2\2\u03f9"+
		"\u03fa\3\2\2\2\u03fa\u0093\3\2\2\2\u03fb\u03fc\5`\61\2\u03fc\u03fd\7\65"+
		"\2\2\u03fd\u040c\5`\61\2\u03fe\u040d\5\u009eP\2\u03ff\u0400\7\64\2\2\u0400"+
		"\u0401\5`\61\2\u0401\u0402\7\65\2\2\u0402\u0403\5`\61\2\u0403\u0405\3"+
		"\2\2\2\u0404\u03ff\3\2\2\2\u0405\u0408\3\2\2\2\u0406\u0404\3\2\2\2\u0406"+
		"\u0407\3\2\2\2\u0407\u040a\3\2\2\2\u0408\u0406\3\2\2\2\u0409\u040b\7\64"+
		"\2\2\u040a\u0409\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u040d\3\2\2\2\u040c"+
		"\u03fe\3\2\2\2\u040c\u0406\3\2\2\2\u040d\u041d\3\2\2\2\u040e\u041a\5`"+
		"\61\2\u040f\u041b\5\u009eP\2\u0410\u0411\7\64\2\2\u0411\u0413\5`\61\2"+
		"\u0412\u0410\3\2\2\2\u0413\u0416\3\2\2\2\u0414\u0412\3\2\2\2\u0414\u0415"+
		"\3\2\2\2\u0415\u0418\3\2\2\2\u0416\u0414\3\2\2\2\u0417\u0419\7\64\2\2"+
		"\u0418\u0417\3\2\2\2\u0418\u0419\3\2\2\2\u0419\u041b\3\2\2\2\u041a\u040f"+
		"\3\2\2\2\u041a\u0414\3\2\2\2\u041b\u041d\3\2\2\2\u041c\u03fb\3\2\2\2\u041c"+
		"\u040e\3\2\2\2\u041d\u0095\3\2\2\2\u041e\u041f\7\37\2\2\u041f\u0425\7"+
		"&\2\2\u0420\u0422\7\62\2\2\u0421\u0423\5\u0098M\2\u0422\u0421\3\2\2\2"+
		"\u0422\u0423\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u0426\7\63\2\2\u0425\u0420"+
		"\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0427\3\2\2\2\u0427\u0428\7\65\2\2"+
		"\u0428\u0429\5^\60\2\u0429\u0097\3\2\2\2\u042a\u042b\5\u009aN\2\u042b"+
		"\u042c\7\64\2\2\u042c\u042e\3\2\2\2\u042d\u042a\3\2\2\2\u042e\u0431\3"+
		"\2\2\2\u042f\u042d\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u0446\3\2\2\2\u0431"+
		"\u042f\3\2\2\2\u0432\u0434\5\u009aN\2\u0433\u0435\7\64\2\2\u0434\u0433"+
		"\3\2\2\2\u0434\u0435\3\2\2\2\u0435\u0447\3\2\2\2\u0436\u0437\7\61\2\2"+
		"\u0437\u043c\5`\61\2\u0438\u0439\7\64\2\2\u0439\u043b\5\u009aN\2\u043a"+
		"\u0438\3\2\2\2\u043b\u043e\3\2\2\2\u043c\u043a\3\2\2\2\u043c\u043d\3\2"+
		"\2\2\u043d\u0442\3\2\2\2\u043e\u043c\3\2\2\2\u043f\u0440\7\64\2\2\u0440"+
		"\u0441\7\67\2\2\u0441\u0443\5`\61\2\u0442\u043f\3\2\2\2\u0442\u0443\3"+
		"\2\2\2\u0443\u0447\3\2\2\2\u0444\u0445\7\67\2\2\u0445\u0447\5`\61\2\u0446"+
		"\u0432\3\2\2\2\u0446\u0436\3\2\2\2\u0446\u0444\3\2\2\2\u0447\u0099\3\2"+
		"\2\2\u0448\u044a\5`\61\2\u0449\u044b\5\u009eP\2\u044a\u0449\3\2\2\2\u044a"+
		"\u044b\3\2\2\2\u044b\u0451\3\2\2\2\u044c\u044d\5`\61\2\u044d\u044e\78"+
		"\2\2\u044e\u044f\5`\61\2\u044f\u0451\3\2\2\2\u0450\u0448\3\2\2\2\u0450"+
		"\u044c\3\2\2\2\u0451\u009b\3\2\2\2\u0452\u0455\5\u009eP\2\u0453\u0455"+
		"\5\u00a0Q\2\u0454\u0452\3\2\2\2\u0454\u0453\3\2\2\2\u0455\u009d\3\2\2"+
		"\2\u0456\u0457\7\21\2\2\u0457\u0458\5\u0090I\2\u0458\u0459\7\22\2\2\u0459"+
		"\u045b\5h\65\2\u045a\u045c\5\u009cO\2\u045b\u045a\3\2\2\2\u045b\u045c"+
		"\3\2\2\2\u045c\u009f\3\2\2\2\u045d\u045e\7\r\2\2\u045e\u0460\5b\62\2\u045f"+
		"\u0461\5\u009cO\2\u0460\u045f\3\2\2\2\u0460\u0461\3\2\2\2\u0461\u00a1"+
		"\3\2\2\2\u0462\u0464\7 \2\2\u0463\u0465\5\u00a4S\2\u0464\u0463\3\2\2\2"+
		"\u0464\u0465\3\2\2\2\u0465\u00a3\3\2\2\2\u0466\u0467\7\7\2\2\u0467\u046a"+
		"\5`\61\2\u0468\u046a\5\u0092J\2\u0469\u0466\3\2\2\2\u0469\u0468\3\2\2"+
		"\2\u046a\u00a5\3\2\2\2\u046b\u046c\t\4\2\2\u046c\u00a7\3\2\2\2\u046d\u0471"+
		"\5\u00aaV\2\u046e\u0471\7-\2\2\u046f\u0471\7.\2\2\u0470\u046d\3\2\2\2"+
		"\u0470\u046e\3\2\2\2\u0470\u046f\3\2\2\2\u0471\u00a9\3\2\2\2\u0472\u0473"+
		"\t\5\2\2\u0473\u00ab\3\2\2\2\u00a9\u00b1\u00b5\u00b7\u00c0\u00c9\u00cc"+
		"\u00d3\u00d8\u00df\u00e6\u00ed\u00f3\u00f7\u00fd\u0103\u0107\u010d\u0111"+
		"\u0113\u0117\u011d\u0121\u0127\u012b\u0130\u0135\u013b\u013f\u0145\u014b"+
		"\u014f\u0155\u0159\u015b\u015f\u0165\u0169\u016f\u0173\u0179\u0180\u0184"+
		"\u0191\u019a\u019e\u01a0\u01a8\u01ab\u01ad\u01af\u01b8\u01bc\u01be\u01c6"+
		"\u01c9\u01cb\u01cd\u01d0\u01d6\u01db\u01df\u01e2\u01e6\u01eb\u01ef\u01f3"+
		"\u0201\u0209\u0211\u0213\u021b\u021f\u0228\u022f\u0231\u023a\u023f\u0244"+
		"\u024b\u024f\u0256\u025e\u0267\u0270\u0277\u0281\u028e\u0294\u029d\u02a8"+
		"\u02b3\u02b8\u02bd\u02c2\u02ca\u02d3\u02d9\u02db\u02e2\u02ea\u02ee\u02f6"+
		"\u02f9\u02fd\u0301\u0308\u0312\u031a\u0320\u0328\u0338\u033b\u0344\u034c"+
		"\u0354\u035c\u035e\u0366\u0368\u0376\u0378\u0382\u0388\u038d\u0392\u0397"+
		"\u039c\u03a5\u03ab\u03b3\u03b7\u03b9\u03bd\u03c7\u03ce\u03d2\u03d6\u03da"+
		"\u03dd\u03df\u03e3\u03ea\u03ee\u03f5\u03f9\u0406\u040a\u040c\u0414\u0418"+
		"\u041a\u041c\u0422\u0425\u042f\u0434\u043c\u0442\u0446\u044a\u0450\u0454"+
		"\u045b\u0460\u0464\u0469\u0470";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}