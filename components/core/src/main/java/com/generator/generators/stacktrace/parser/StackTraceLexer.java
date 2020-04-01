// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/stacktrace/parser/StackTrace.g4 by ANTLR 4.7
package com.generator.generators.stacktrace.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StackTraceLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, Number=5, JavaWord=6, DOT=7, AT=8, CAUSED_BY=9, 
		MORE_=10, ELLIPSIS=11, COLON=12, NATIVE_METHOD=13, UNKNOWN_SOURCE=14, 
		INIT=15, NonCapitalLetter=16, CapitalLetter=17, Symbol=18, Digit=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "Number", "JavaWord", "JavaCharacter", 
		"DOT", "AT", "CAUSED_BY", "MORE_", "ELLIPSIS", "COLON", "NATIVE_METHOD", 
		"UNKNOWN_SOURCE", "INIT", "NonCapitalLetter", "CapitalLetter", "Symbol", 
		"Digit", "WS"
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


	public StackTraceLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "StackTrace.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0094\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6;\n\6\r\6\16\6<\3\7\6\7@\n\7\r\7\16\7"+
		"A\3\b\3\b\3\b\3\b\5\bH\n\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\2\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26"+
		"\3\2\3\5\2\13\f\16\17\"\"\2\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13:\3\2\2\2\r?\3\2\2"+
		"\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25N\3\2\2\2\27Y\3\2\2\2\31^\3\2"+
		"\2\2\33b\3\2\2\2\35d\3\2\2\2\37r\3\2\2\2!\u0081\3\2\2\2#\u0088\3\2\2\2"+
		"%\u008a\3\2\2\2\'\u008c\3\2\2\2)\u008e\3\2\2\2+\u0090\3\2\2\2-.\7*\2\2"+
		".\4\3\2\2\2/\60\7+\2\2\60\6\3\2\2\2\61\62\7&\2\2\62\b\3\2\2\2\63\64\7"+
		"\60\2\2\64\65\7l\2\2\65\66\7c\2\2\66\67\7x\2\2\678\7c\2\28\n\3\2\2\29"+
		";\5)\25\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\f\3\2\2\2>@\5\17\b"+
		"\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\16\3\2\2\2CH\5%\23\2DH\5#"+
		"\22\2EH\5\'\24\2FH\5)\25\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\20"+
		"\3\2\2\2IJ\7\60\2\2J\22\3\2\2\2KL\7c\2\2LM\7v\2\2M\24\3\2\2\2NO\7E\2\2"+
		"OP\7c\2\2PQ\7w\2\2QR\7u\2\2RS\7g\2\2ST\7f\2\2TU\7\"\2\2UV\7d\2\2VW\7{"+
		"\2\2WX\7<\2\2X\26\3\2\2\2YZ\7o\2\2Z[\7q\2\2[\\\7t\2\2\\]\7g\2\2]\30\3"+
		"\2\2\2^_\7\60\2\2_`\7\60\2\2`a\7\60\2\2a\32\3\2\2\2bc\7<\2\2c\34\3\2\2"+
		"\2de\7P\2\2ef\7c\2\2fg\7v\2\2gh\7k\2\2hi\7x\2\2ij\7g\2\2jk\7\"\2\2kl\7"+
		"O\2\2lm\7g\2\2mn\7v\2\2no\7j\2\2op\7q\2\2pq\7f\2\2q\36\3\2\2\2rs\7W\2"+
		"\2st\7p\2\2tu\7m\2\2uv\7p\2\2vw\7q\2\2wx\7y\2\2xy\7p\2\2yz\7\"\2\2z{\7"+
		"U\2\2{|\7q\2\2|}\7w\2\2}~\7t\2\2~\177\7e\2\2\177\u0080\7g\2\2\u0080 \3"+
		"\2\2\2\u0081\u0082\7>\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084"+
		"\u0085\7k\2\2\u0085\u0086\7v\2\2\u0086\u0087\7@\2\2\u0087\"\3\2\2\2\u0088"+
		"\u0089\4c|\2\u0089$\3\2\2\2\u008a\u008b\4C\\\2\u008b&\3\2\2\2\u008c\u008d"+
		"\7a\2\2\u008d(\3\2\2\2\u008e\u008f\4\62;\2\u008f*\3\2\2\2\u0090\u0091"+
		"\t\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\26\2\2\u0093,\3\2\2\2\6\2<"+
		"AG\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}