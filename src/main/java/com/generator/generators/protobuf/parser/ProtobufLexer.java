// Generated from src/com/generator/generators/protobuf/parser/Protobuf.g4 by ANTLR 4.1
package com.generator.generators.protobuf.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProtobufLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, FIELDRULE=20, INT=21, ID=22, WS=23, SL_COMMENT=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'import'", "']'", "'max'", "'extensions'", "'.'", "'default'", "'['", 
		"'-'", "'='", "';'", "'extend'", "'package'", "'to'", "'{'", "'message'", 
		"'option'", "'}'", "'\"'", "'enum'", "FIELDRULE", "INT", "ID", "WS", "SL_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "FIELDRULE", "INT", "ID", "WS", "SL_COMMENT"
	};



	public enum FieldRules { required, optional, repeated  }

	public void packageName(String name) {}

	public void option(String name, String value) {}
	public void imports(String name) {}

	public void newMessage(String name, String comment) { }
	public void newExtension(String name) { }
	public void newProperty(FieldRules rule, String propertyType, String propertyName, Integer ordinal, String comment, String parent, String defaultValue) { }
	public void endMessage() { }

	public void newExtensions(String min, String max) { }
	public void endExtension() {}

	public void newEnum(String name, String comment) { }
	public void newEnumValue(String name, Integer ordinal, String comment) { }
	public void endEnum() { }
	public void end() { }

	private String getDefaultValue(String text) {
	    //'[' 'default' '=' (ID|INT|'-'|'"')+ ']'
	    return text.substring(text.indexOf("=") + 1, text.length() - 1);
	}

	public static TokenStream createLexer(java.io.Reader reader) throws java.io.IOException {
		final ANTLRInputStream input = new ANTLRInputStream(reader);
		final ProtobufLexer lexer = new ProtobufLexer(input);
		return new CommonTokenStream(lexer);
	}


	public ProtobufLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Protobuf.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 22: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\32\u00bf\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u00a2\n\25\3\26\6\26\u00a5\n\26\r\26\16\26\u00a6\3\27"+
		"\6\27\u00aa\n\27\r\27\16\27\u00ab\3\30\6\30\u00af\n\30\r\30\16\30\u00b0"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00b9\n\31\f\31\16\31\u00bc\13\31"+
		"\3\31\3\31\3\u00ba\32\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n"+
		"\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%"+
		"\24\1\'\25\1)\26\1+\27\1-\30\1/\31\2\61\32\1\3\2\5\3\2\62;\b\2))\60\60"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5:\3\2"+
		"\2\2\7<\3\2\2\2\t@\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17U\3\2\2\2\21W\3\2"+
		"\2\2\23Y\3\2\2\2\25[\3\2\2\2\27]\3\2\2\2\31d\3\2\2\2\33l\3\2\2\2\35o\3"+
		"\2\2\2\37q\3\2\2\2!y\3\2\2\2#\u0080\3\2\2\2%\u0082\3\2\2\2\'\u0084\3\2"+
		"\2\2)\u00a1\3\2\2\2+\u00a4\3\2\2\2-\u00a9\3\2\2\2/\u00ae\3\2\2\2\61\u00b4"+
		"\3\2\2\2\63\64\7k\2\2\64\65\7o\2\2\65\66\7r\2\2\66\67\7q\2\2\678\7t\2"+
		"\289\7v\2\29\4\3\2\2\2:;\7_\2\2;\6\3\2\2\2<=\7o\2\2=>\7c\2\2>?\7z\2\2"+
		"?\b\3\2\2\2@A\7g\2\2AB\7z\2\2BC\7v\2\2CD\7g\2\2DE\7p\2\2EF\7u\2\2FG\7"+
		"k\2\2GH\7q\2\2HI\7p\2\2IJ\7u\2\2J\n\3\2\2\2KL\7\60\2\2L\f\3\2\2\2MN\7"+
		"f\2\2NO\7g\2\2OP\7h\2\2PQ\7c\2\2QR\7w\2\2RS\7n\2\2ST\7v\2\2T\16\3\2\2"+
		"\2UV\7]\2\2V\20\3\2\2\2WX\7/\2\2X\22\3\2\2\2YZ\7?\2\2Z\24\3\2\2\2[\\\7"+
		"=\2\2\\\26\3\2\2\2]^\7g\2\2^_\7z\2\2_`\7v\2\2`a\7g\2\2ab\7p\2\2bc\7f\2"+
		"\2c\30\3\2\2\2de\7r\2\2ef\7c\2\2fg\7e\2\2gh\7m\2\2hi\7c\2\2ij\7i\2\2j"+
		"k\7g\2\2k\32\3\2\2\2lm\7v\2\2mn\7q\2\2n\34\3\2\2\2op\7}\2\2p\36\3\2\2"+
		"\2qr\7o\2\2rs\7g\2\2st\7u\2\2tu\7u\2\2uv\7c\2\2vw\7i\2\2wx\7g\2\2x \3"+
		"\2\2\2yz\7q\2\2z{\7r\2\2{|\7v\2\2|}\7k\2\2}~\7q\2\2~\177\7p\2\2\177\""+
		"\3\2\2\2\u0080\u0081\7\177\2\2\u0081$\3\2\2\2\u0082\u0083\7$\2\2\u0083"+
		"&\3\2\2\2\u0084\u0085\7g\2\2\u0085\u0086\7p\2\2\u0086\u0087\7w\2\2\u0087"+
		"\u0088\7o\2\2\u0088(\3\2\2\2\u0089\u008a\7t\2\2\u008a\u008b\7g\2\2\u008b"+
		"\u008c\7s\2\2\u008c\u008d\7w\2\2\u008d\u008e\7k\2\2\u008e\u008f\7t\2\2"+
		"\u008f\u0090\7g\2\2\u0090\u00a2\7f\2\2\u0091\u0092\7q\2\2\u0092\u0093"+
		"\7r\2\2\u0093\u0094\7v\2\2\u0094\u0095\7k\2\2\u0095\u0096\7q\2\2\u0096"+
		"\u0097\7p\2\2\u0097\u0098\7c\2\2\u0098\u00a2\7n\2\2\u0099\u009a\7t\2\2"+
		"\u009a\u009b\7g\2\2\u009b\u009c\7r\2\2\u009c\u009d\7g\2\2\u009d\u009e"+
		"\7c\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7g\2\2\u00a0\u00a2\7f\2\2\u00a1"+
		"\u0089\3\2\2\2\u00a1\u0091\3\2\2\2\u00a1\u0099\3\2\2\2\u00a2*\3\2\2\2"+
		"\u00a3\u00a5\t\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7,\3\2\2\2\u00a8\u00aa\t\3\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac.\3\2\2\2\u00ad\u00af\t\4\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\b\30\2\2\u00b3\60\3\2\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b6\7\61"+
		"\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b9\13\2\2\2\u00b8\u00b7\3\2\2\2\u00b9"+
		"\u00bc\3\2\2\2\u00ba\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\f\2\2\u00be\62\3\2\2\2\b\2\u00a1"+
		"\u00a6\u00ab\u00b0\u00ba";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}