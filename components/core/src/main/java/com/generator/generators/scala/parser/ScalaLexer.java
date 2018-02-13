// Generated from /media/Storage/projects/gullkode/nextgen/src/main/java/com/generator/generators/scala/parser/Scala.g4 by ANTLR 4.7
package com.generator.generators.scala.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScalaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, OP=64, ID=65, VARID=66, PLAINID=67, 
		INTEGER_LITERAL=68, FLOATING_POINT_LITERAL=69, BOOLEAN_LITERAL=70, CHARACTER_LITERAL=71, 
		STRING_LITERAL=72, SYMBOL_LITERAL=73, COMMENT=74, NL=75, WS=76;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
		"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "OP", "ID", "VARID", 
		"PLAINID", "INTEGER_LITERAL", "FLOATING_POINT_LITERAL", "BOOLEAN_LITERAL", 
		"CHARACTER_LITERAL", "STRING_LITERAL", "SYMBOL_LITERAL", "COMMENT", "NL", 
		"WS", "HEX_DIGIT", "UNICODE_ESCAPE", "UPPER", "LOWER", "LETTER", "OPCHAR", 
		"CHAR_NO_BACK_QUOTE_OR_NEW_LINE", "CHAR_NO_DOUBLE_QUOTE", "CHAR_ESCAPE_SEQ", 
		"DIGIT", "NON_ZERO_DIGIT", "IDREST", "DECIMAL_NUMERAL", "HEX_NUMERAL", 
		"EXPONENT_PART", "FLOAT_TYPE", "CHAR_NO_QUOTE_OR_NEW_LINE", "STRING_ELEMENT", 
		"MULTILINE_CHARS", "CHAR_NO_DOUBLE_QUOTE_OR_NEW_LINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'-'", "'null'", "'.'", "','", "'this'", "'super'", "'['", "']'", 
		"'=>'", "'('", "')'", "'forSome'", "'{'", "';'", "'}'", "'type'", "'val'", 
		"'with'", "'#'", "':'", "'_'", "'*'", "'implicit'", "'if'", "'else'", 
		"'while'", "'try'", "'catch'", "'finally'", "'do'", "'for'", "'yield'", 
		"'throw'", "'return'", "'='", "'match'", "'+'", "'~'", "'!'", "'new'", 
		"'lazy'", "'<-'", "'case'", "'|'", "'@'", "'>:'", "'<:'", "'<%'", "'var'", 
		"'override'", "'abstract'", "'final'", "'sealed'", "'private'", "'protected'", 
		"'import'", "'def'", "'<::'", "'class'", "'object'", "'trait'", "'extends'", 
		"'package'", null, null, null, null, null, null, null, null, null, null, 
		null, "'\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "OP", "ID", "VARID", "PLAINID", "INTEGER_LITERAL", 
		"FLOATING_POINT_LITERAL", "BOOLEAN_LITERAL", "CHARACTER_LITERAL", "STRING_LITERAL", 
		"SYMBOL_LITERAL", "COMMENT", "NL", "WS"
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


	public ScalaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Scala.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2N\u02df\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!"+
		"\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3%\3%\3%\3%"+
		"\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3"+
		"\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38"+
		"\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;"+
		"\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?"+
		"\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3A\6A\u01e0\nA\rA\16A\u01e1\3B\3"+
		"B\3B\3B\3B\7B\u01e9\nB\fB\16B\u01ec\13B\3B\5B\u01ef\nB\3C\3C\3C\3D\3D"+
		"\3D\3D\3D\5D\u01f9\nD\3E\3E\5E\u01fd\nE\3E\5E\u0200\nE\3F\6F\u0203\nF"+
		"\rF\16F\u0204\3F\3F\6F\u0209\nF\rF\16F\u020a\3F\5F\u020e\nF\3F\5F\u0211"+
		"\nF\3F\3F\6F\u0215\nF\rF\16F\u0216\3F\5F\u021a\nF\3F\5F\u021d\nF\3F\6"+
		"F\u0220\nF\rF\16F\u0221\3F\3F\5F\u0226\nF\3F\6F\u0229\nF\rF\16F\u022a"+
		"\3F\5F\u022e\nF\3F\3F\5F\u0232\nF\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u023d"+
		"\nG\3H\3H\3H\3H\5H\u0243\nH\3H\3H\3I\3I\7I\u0249\nI\fI\16I\u024c\13I\3"+
		"I\3I\3I\3I\3I\3I\3I\3I\3I\3I\5I\u0258\nI\3J\3J\3J\3K\3K\3K\3K\7K\u0261"+
		"\nK\fK\16K\u0264\13K\3K\3K\3K\3K\3K\3K\7K\u026c\nK\fK\16K\u026f\13K\5"+
		"K\u0271\nK\3K\3K\3L\3L\3M\6M\u0278\nM\rM\16M\u0279\3M\3M\3N\3N\3O\3O\3"+
		"O\3O\3O\3O\3O\3O\3P\3P\3Q\3Q\3R\3R\3R\5R\u028f\nR\3S\3S\3T\3T\3U\3U\3"+
		"V\3V\3V\3W\3W\3X\3X\3Y\3Y\7Y\u02a0\nY\fY\16Y\u02a3\13Y\3Y\3Y\5Y\u02a7"+
		"\nY\3Z\3Z\3Z\7Z\u02ac\nZ\fZ\16Z\u02af\13Z\5Z\u02b1\nZ\3[\3[\3[\6[\u02b6"+
		"\n[\r[\16[\u02b7\3\\\3\\\5\\\u02bc\n\\\3\\\6\\\u02bf\n\\\r\\\16\\\u02c0"+
		"\3]\3]\3^\3^\3_\3_\3_\5_\u02ca\n_\3`\5`\u02cd\n`\3`\5`\u02d0\n`\3`\7`"+
		"\u02d3\n`\f`\16`\u02d6\13`\3`\7`\u02d9\n`\f`\16`\u02dc\13`\3a\3a\3\u0262"+
		"\2b\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009b\2\u009d\2\u009f\2\u00a1"+
		"\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad\2\u00af\2\u00b1\2\u00b3"+
		"\2\u00b5\2\u00b7\2\u00b9\2\u00bb\2\u00bd\2\u00bf\2\u00c1\2\3\2\22\4\2"+
		"NNnn\4\2\f\f\17\17\4\2\13\13\"\"\5\2\62;CHch\r\2##%%\'(,-//\61\61<<>A"+
		"^^~~\u0080\u0080\4\2\"ac\u0080\5\2\f\f\"(*\u0080\n\2$$))^^ddhhppttvv\3"+
		"\2\62;\3\2\63;\4\2ZZzz\4\2GGgg\4\2--//\6\2FFHHffhh\4\2\"(*\u0080\4\2\""+
		"#%\u0080\5\u0277\2&\2&\2C\2\\\2a\2a\2\u00c2\2\u00d8\2\u00da\2\u00e0\2"+
		"\u0102\2\u0102\2\u0104\2\u0104\2\u0106\2\u0106\2\u0108\2\u0108\2\u010a"+
		"\2\u010a\2\u010c\2\u010c\2\u010e\2\u010e\2\u0110\2\u0110\2\u0112\2\u0112"+
		"\2\u0114\2\u0114\2\u0116\2\u0116\2\u0118\2\u0118\2\u011a\2\u011a\2\u011c"+
		"\2\u011c\2\u011e\2\u011e\2\u0120\2\u0120\2\u0122\2\u0122\2\u0124\2\u0124"+
		"\2\u0126\2\u0126\2\u0128\2\u0128\2\u012a\2\u012a\2\u012c\2\u012c\2\u012e"+
		"\2\u012e\2\u0130\2\u0130\2\u0132\2\u0132\2\u0134\2\u0134\2\u0136\2\u0136"+
		"\2\u0138\2\u0138\2\u013b\2\u013b\2\u013d\2\u013d\2\u013f\2\u013f\2\u0141"+
		"\2\u0141\2\u0143\2\u0143\2\u0145\2\u0145\2\u0147\2\u0147\2\u0149\2\u0149"+
		"\2\u014c\2\u014c\2\u014e\2\u014e\2\u0150\2\u0150\2\u0152\2\u0152\2\u0154"+
		"\2\u0154\2\u0156\2\u0156\2\u0158\2\u0158\2\u015a\2\u015a\2\u015c\2\u015c"+
		"\2\u015e\2\u015e\2\u0160\2\u0160\2\u0162\2\u0162\2\u0164\2\u0164\2\u0166"+
		"\2\u0166\2\u0168\2\u0168\2\u016a\2\u016a\2\u016c\2\u016c\2\u016e\2\u016e"+
		"\2\u0170\2\u0170\2\u0172\2\u0172\2\u0174\2\u0174\2\u0176\2\u0176\2\u0178"+
		"\2\u0178\2\u017a\2\u017b\2\u017d\2\u017d\2\u017f\2\u017f\2\u0183\2\u0184"+
		"\2\u0186\2\u0186\2\u0188\2\u0189\2\u018b\2\u018d\2\u0190\2\u0193\2\u0195"+
		"\2\u0196\2\u0198\2\u019a\2\u019e\2\u019f\2\u01a1\2\u01a2\2\u01a4\2\u01a4"+
		"\2\u01a6\2\u01a6\2\u01a8\2\u01a9\2\u01ab\2\u01ab\2\u01ae\2\u01ae\2\u01b0"+
		"\2\u01b1\2\u01b3\2\u01b5\2\u01b7\2\u01b7\2\u01b9\2\u01ba\2\u01be\2\u01be"+
		"\2\u01c6\2\u01c6\2\u01c9\2\u01c9\2\u01cc\2\u01cc\2\u01cf\2\u01cf\2\u01d1"+
		"\2\u01d1\2\u01d3\2\u01d3\2\u01d5\2\u01d5\2\u01d7\2\u01d7\2\u01d9\2\u01d9"+
		"\2\u01db\2\u01db\2\u01dd\2\u01dd\2\u01e0\2\u01e0\2\u01e2\2\u01e2\2\u01e4"+
		"\2\u01e4\2\u01e6\2\u01e6\2\u01e8\2\u01e8\2\u01ea\2\u01ea\2\u01ec\2\u01ec"+
		"\2\u01ee\2\u01ee\2\u01f0\2\u01f0\2\u01f3\2\u01f3\2\u01f6\2\u01f6\2\u01f8"+
		"\2\u01fa\2\u01fc\2\u01fc\2\u01fe\2\u01fe\2\u0200\2\u0200\2\u0202\2\u0202"+
		"\2\u0204\2\u0204\2\u0206\2\u0206\2\u0208\2\u0208\2\u020a\2\u020a\2\u020c"+
		"\2\u020c\2\u020e\2\u020e\2\u0210\2\u0210\2\u0212\2\u0212\2\u0214\2\u0214"+
		"\2\u0216\2\u0216\2\u0218\2\u0218\2\u021a\2\u021a\2\u021c\2\u021c\2\u021e"+
		"\2\u021e\2\u0220\2\u0220\2\u0222\2\u0222\2\u0224\2\u0224\2\u0226\2\u0226"+
		"\2\u0228\2\u0228\2\u022a\2\u022a\2\u022c\2\u022c\2\u022e\2\u022e\2\u0230"+
		"\2\u0230\2\u0232\2\u0232\2\u0234\2\u0234\2\u023c\2\u023d\2\u023f\2\u0240"+
		"\2\u0243\2\u0243\2\u0245\2\u0248\2\u024a\2\u024a\2\u024c\2\u024c\2\u024e"+
		"\2\u024e\2\u0250\2\u0250\2\u0372\2\u0372\2\u0374\2\u0374\2\u0378\2\u0378"+
		"\2\u0381\2\u0381\2\u0388\2\u0388\2\u038a\2\u038c\2\u038e\2\u038e\2\u0390"+
		"\2\u0391\2\u0393\2\u03a3\2\u03a5\2\u03ad\2\u03d1\2\u03d1\2\u03d4\2\u03d6"+
		"\2\u03da\2\u03da\2\u03dc\2\u03dc\2\u03de\2\u03de\2\u03e0\2\u03e0\2\u03e2"+
		"\2\u03e2\2\u03e4\2\u03e4\2\u03e6\2\u03e6\2\u03e8\2\u03e8\2\u03ea\2\u03ea"+
		"\2\u03ec\2\u03ec\2\u03ee\2\u03ee\2\u03f0\2\u03f0\2\u03f6\2\u03f6\2\u03f9"+
		"\2\u03f9\2\u03fb\2\u03fc\2\u03ff\2\u0431\2\u0462\2\u0462\2\u0464\2\u0464"+
		"\2\u0466\2\u0466\2\u0468\2\u0468\2\u046a\2\u046a\2\u046c\2\u046c\2\u046e"+
		"\2\u046e\2\u0470\2\u0470\2\u0472\2\u0472\2\u0474\2\u0474\2\u0476\2\u0476"+
		"\2\u0478\2\u0478\2\u047a\2\u047a\2\u047c\2\u047c\2\u047e\2\u047e\2\u0480"+
		"\2\u0480\2\u0482\2\u0482\2\u048c\2\u048c\2\u048e\2\u048e\2\u0490\2\u0490"+
		"\2\u0492\2\u0492\2\u0494\2\u0494\2\u0496\2\u0496\2\u0498\2\u0498\2\u049a"+
		"\2\u049a\2\u049c\2\u049c\2\u049e\2\u049e\2\u04a0\2\u04a0\2\u04a2\2\u04a2"+
		"\2\u04a4\2\u04a4\2\u04a6\2\u04a6\2\u04a8\2\u04a8\2\u04aa\2\u04aa\2\u04ac"+
		"\2\u04ac\2\u04ae\2\u04ae\2\u04b0\2\u04b0\2\u04b2\2\u04b2\2\u04b4\2\u04b4"+
		"\2\u04b6\2\u04b6\2\u04b8\2\u04b8\2\u04ba\2\u04ba\2\u04bc\2\u04bc\2\u04be"+
		"\2\u04be\2\u04c0\2\u04c0\2\u04c2\2\u04c3\2\u04c5\2\u04c5\2\u04c7\2\u04c7"+
		"\2\u04c9\2\u04c9\2\u04cb\2\u04cb\2\u04cd\2\u04cd\2\u04cf\2\u04cf\2\u04d2"+
		"\2\u04d2\2\u04d4\2\u04d4\2\u04d6\2\u04d6\2\u04d8\2\u04d8\2\u04da\2\u04da"+
		"\2\u04dc\2\u04dc\2\u04de\2\u04de\2\u04e0\2\u04e0\2\u04e2\2\u04e2\2\u04e4"+
		"\2\u04e4\2\u04e6\2\u04e6\2\u04e8\2\u04e8\2\u04ea\2\u04ea\2\u04ec\2\u04ec"+
		"\2\u04ee\2\u04ee\2\u04f0\2\u04f0\2\u04f2\2\u04f2\2\u04f4\2\u04f4\2\u04f6"+
		"\2\u04f6\2\u04f8\2\u04f8\2\u04fa\2\u04fa\2\u04fc\2\u04fc\2\u04fe\2\u04fe"+
		"\2\u0500\2\u0500\2\u0502\2\u0502\2\u0504\2\u0504\2\u0506\2\u0506\2\u0508"+
		"\2\u0508\2\u050a\2\u050a\2\u050c\2\u050c\2\u050e\2\u050e\2\u0510\2\u0510"+
		"\2\u0512\2\u0512\2\u0514\2\u0514\2\u0516\2\u0516\2\u0518\2\u0518\2\u051a"+
		"\2\u051a\2\u051c\2\u051c\2\u051e\2\u051e\2\u0520\2\u0520\2\u0522\2\u0522"+
		"\2\u0524\2\u0524\2\u0526\2\u0526\2\u0528\2\u0528\2\u052a\2\u052a\2\u052c"+
		"\2\u052c\2\u052e\2\u052e\2\u0530\2\u0530\2\u0533\2\u0558\2\u10a2\2\u10c7"+
		"\2\u10c9\2\u10c9\2\u10cf\2\u10cf\2\u13a2\2\u13f7\2\u1e02\2\u1e02\2\u1e04"+
		"\2\u1e04\2\u1e06\2\u1e06\2\u1e08\2\u1e08\2\u1e0a\2\u1e0a\2\u1e0c\2\u1e0c"+
		"\2\u1e0e\2\u1e0e\2\u1e10\2\u1e10\2\u1e12\2\u1e12\2\u1e14\2\u1e14\2\u1e16"+
		"\2\u1e16\2\u1e18\2\u1e18\2\u1e1a\2\u1e1a\2\u1e1c\2\u1e1c\2\u1e1e\2\u1e1e"+
		"\2\u1e20\2\u1e20\2\u1e22\2\u1e22\2\u1e24\2\u1e24\2\u1e26\2\u1e26\2\u1e28"+
		"\2\u1e28\2\u1e2a\2\u1e2a\2\u1e2c\2\u1e2c\2\u1e2e\2\u1e2e\2\u1e30\2\u1e30"+
		"\2\u1e32\2\u1e32\2\u1e34\2\u1e34\2\u1e36\2\u1e36\2\u1e38\2\u1e38\2\u1e3a"+
		"\2\u1e3a\2\u1e3c\2\u1e3c\2\u1e3e\2\u1e3e\2\u1e40\2\u1e40\2\u1e42\2\u1e42"+
		"\2\u1e44\2\u1e44\2\u1e46\2\u1e46\2\u1e48\2\u1e48\2\u1e4a\2\u1e4a\2\u1e4c"+
		"\2\u1e4c\2\u1e4e\2\u1e4e\2\u1e50\2\u1e50\2\u1e52\2\u1e52\2\u1e54\2\u1e54"+
		"\2\u1e56\2\u1e56\2\u1e58\2\u1e58\2\u1e5a\2\u1e5a\2\u1e5c\2\u1e5c\2\u1e5e"+
		"\2\u1e5e\2\u1e60\2\u1e60\2\u1e62\2\u1e62\2\u1e64\2\u1e64\2\u1e66\2\u1e66"+
		"\2\u1e68\2\u1e68\2\u1e6a\2\u1e6a\2\u1e6c\2\u1e6c\2\u1e6e\2\u1e6e\2\u1e70"+
		"\2\u1e70\2\u1e72\2\u1e72\2\u1e74\2\u1e74\2\u1e76\2\u1e76\2\u1e78\2\u1e78"+
		"\2\u1e7a\2\u1e7a\2\u1e7c\2\u1e7c\2\u1e7e\2\u1e7e\2\u1e80\2\u1e80\2\u1e82"+
		"\2\u1e82\2\u1e84\2\u1e84\2\u1e86\2\u1e86\2\u1e88\2\u1e88\2\u1e8a\2\u1e8a"+
		"\2\u1e8c\2\u1e8c\2\u1e8e\2\u1e8e\2\u1e90\2\u1e90\2\u1e92\2\u1e92\2\u1e94"+
		"\2\u1e94\2\u1e96\2\u1e96\2\u1ea0\2\u1ea0\2\u1ea2\2\u1ea2\2\u1ea4\2\u1ea4"+
		"\2\u1ea6\2\u1ea6\2\u1ea8\2\u1ea8\2\u1eaa\2\u1eaa\2\u1eac\2\u1eac\2\u1eae"+
		"\2\u1eae\2\u1eb0\2\u1eb0\2\u1eb2\2\u1eb2\2\u1eb4\2\u1eb4\2\u1eb6\2\u1eb6"+
		"\2\u1eb8\2\u1eb8\2\u1eba\2\u1eba\2\u1ebc\2\u1ebc\2\u1ebe\2\u1ebe\2\u1ec0"+
		"\2\u1ec0\2\u1ec2\2\u1ec2\2\u1ec4\2\u1ec4\2\u1ec6\2\u1ec6\2\u1ec8\2\u1ec8"+
		"\2\u1eca\2\u1eca\2\u1ecc\2\u1ecc\2\u1ece\2\u1ece\2\u1ed0\2\u1ed0\2\u1ed2"+
		"\2\u1ed2\2\u1ed4\2\u1ed4\2\u1ed6\2\u1ed6\2\u1ed8\2\u1ed8\2\u1eda\2\u1eda"+
		"\2\u1edc\2\u1edc\2\u1ede\2\u1ede\2\u1ee0\2\u1ee0\2\u1ee2\2\u1ee2\2\u1ee4"+
		"\2\u1ee4\2\u1ee6\2\u1ee6\2\u1ee8\2\u1ee8\2\u1eea\2\u1eea\2\u1eec\2\u1eec"+
		"\2\u1eee\2\u1eee\2\u1ef0\2\u1ef0\2\u1ef2\2\u1ef2\2\u1ef4\2\u1ef4\2\u1ef6"+
		"\2\u1ef6\2\u1ef8\2\u1ef8\2\u1efa\2\u1efa\2\u1efc\2\u1efc\2\u1efe\2\u1efe"+
		"\2\u1f00\2\u1f00\2\u1f0a\2\u1f11\2\u1f1a\2\u1f1f\2\u1f2a\2\u1f31\2\u1f3a"+
		"\2\u1f41\2\u1f4a\2\u1f4f\2\u1f5b\2\u1f5b\2\u1f5d\2\u1f5d\2\u1f5f\2\u1f5f"+
		"\2\u1f61\2\u1f61\2\u1f6a\2\u1f71\2\u1fba\2\u1fbd\2\u1fca\2\u1fcd\2\u1fda"+
		"\2\u1fdd\2\u1fea\2\u1fee\2\u1ffa\2\u1ffd\2\u2104\2\u2104\2\u2109\2\u2109"+
		"\2\u210d\2\u210f\2\u2112\2\u2114\2\u2117\2\u2117\2\u211b\2\u211f\2\u2126"+
		"\2\u2126\2\u2128\2\u2128\2\u212a\2\u212a\2\u212c\2\u212f\2\u2132\2\u2135"+
		"\2\u2140\2\u2141\2\u2147\2\u2147\2\u2185\2\u2185\2\u2c02\2\u2c30\2\u2c62"+
		"\2\u2c62\2\u2c64\2\u2c66\2\u2c69\2\u2c69\2\u2c6b\2\u2c6b\2\u2c6d\2\u2c6d"+
		"\2\u2c6f\2\u2c72\2\u2c74\2\u2c74\2\u2c77\2\u2c77\2\u2c80\2\u2c82\2\u2c84"+
		"\2\u2c84\2\u2c86\2\u2c86\2\u2c88\2\u2c88\2\u2c8a\2\u2c8a\2\u2c8c\2\u2c8c"+
		"\2\u2c8e\2\u2c8e\2\u2c90\2\u2c90\2\u2c92\2\u2c92\2\u2c94\2\u2c94\2\u2c96"+
		"\2\u2c96\2\u2c98\2\u2c98\2\u2c9a\2\u2c9a\2\u2c9c\2\u2c9c\2\u2c9e\2\u2c9e"+
		"\2\u2ca0\2\u2ca0\2\u2ca2\2\u2ca2\2\u2ca4\2\u2ca4\2\u2ca6\2\u2ca6\2\u2ca8"+
		"\2\u2ca8\2\u2caa\2\u2caa\2\u2cac\2\u2cac\2\u2cae\2\u2cae\2\u2cb0\2\u2cb0"+
		"\2\u2cb2\2\u2cb2\2\u2cb4\2\u2cb4\2\u2cb6\2\u2cb6\2\u2cb8\2\u2cb8\2\u2cba"+
		"\2\u2cba\2\u2cbc\2\u2cbc\2\u2cbe\2\u2cbe\2\u2cc0\2\u2cc0\2\u2cc2\2\u2cc2"+
		"\2\u2cc4\2\u2cc4\2\u2cc6\2\u2cc6\2\u2cc8\2\u2cc8\2\u2cca\2\u2cca\2\u2ccc"+
		"\2\u2ccc\2\u2cce\2\u2cce\2\u2cd0\2\u2cd0\2\u2cd2\2\u2cd2\2\u2cd4\2\u2cd4"+
		"\2\u2cd6\2\u2cd6\2\u2cd8\2\u2cd8\2\u2cda\2\u2cda\2\u2cdc\2\u2cdc\2\u2cde"+
		"\2\u2cde\2\u2ce0\2\u2ce0\2\u2ce2\2\u2ce2\2\u2ce4\2\u2ce4\2\u2ced\2\u2ced"+
		"\2\u2cef\2\u2cef\2\u2cf4\2\u2cf4\2\ua642\2\ua642\2\ua644\2\ua644\2\ua646"+
		"\2\ua646\2\ua648\2\ua648\2\ua64a\2\ua64a\2\ua64c\2\ua64c\2\ua64e\2\ua64e"+
		"\2\ua650\2\ua650\2\ua652\2\ua652\2\ua654\2\ua654\2\ua656\2\ua656\2\ua658"+
		"\2\ua658\2\ua65a\2\ua65a\2\ua65c\2\ua65c\2\ua65e\2\ua65e\2\ua660\2\ua660"+
		"\2\ua662\2\ua662\2\ua664\2\ua664\2\ua666\2\ua666\2\ua668\2\ua668\2\ua66a"+
		"\2\ua66a\2\ua66c\2\ua66c\2\ua66e\2\ua66e\2\ua682\2\ua682\2\ua684\2\ua684"+
		"\2\ua686\2\ua686\2\ua688\2\ua688\2\ua68a\2\ua68a\2\ua68c\2\ua68c\2\ua68e"+
		"\2\ua68e\2\ua690\2\ua690\2\ua692\2\ua692\2\ua694\2\ua694\2\ua696\2\ua696"+
		"\2\ua698\2\ua698\2\ua69a\2\ua69a\2\ua69c\2\ua69c\2\ua724\2\ua724\2\ua726"+
		"\2\ua726\2\ua728\2\ua728\2\ua72a\2\ua72a\2\ua72c\2\ua72c\2\ua72e\2\ua72e"+
		"\2\ua730\2\ua730\2\ua734\2\ua734\2\ua736\2\ua736\2\ua738\2\ua738\2\ua73a"+
		"\2\ua73a\2\ua73c\2\ua73c\2\ua73e\2\ua73e\2\ua740\2\ua740\2\ua742\2\ua742"+
		"\2\ua744\2\ua744\2\ua746\2\ua746\2\ua748\2\ua748\2\ua74a\2\ua74a\2\ua74c"+
		"\2\ua74c\2\ua74e\2\ua74e\2\ua750\2\ua750\2\ua752\2\ua752\2\ua754\2\ua754"+
		"\2\ua756\2\ua756\2\ua758\2\ua758\2\ua75a\2\ua75a\2\ua75c\2\ua75c\2\ua75e"+
		"\2\ua75e\2\ua760\2\ua760\2\ua762\2\ua762\2\ua764\2\ua764\2\ua766\2\ua766"+
		"\2\ua768\2\ua768\2\ua76a\2\ua76a\2\ua76c\2\ua76c\2\ua76e\2\ua76e\2\ua770"+
		"\2\ua770\2\ua77b\2\ua77b\2\ua77d\2\ua77d\2\ua77f\2\ua780\2\ua782\2\ua782"+
		"\2\ua784\2\ua784\2\ua786\2\ua786\2\ua788\2\ua788\2\ua78d\2\ua78d\2\ua78f"+
		"\2\ua78f\2\ua792\2\ua792\2\ua794\2\ua794\2\ua798\2\ua798\2\ua79a\2\ua79a"+
		"\2\ua79c\2\ua79c\2\ua79e\2\ua79e\2\ua7a0\2\ua7a0\2\ua7a2\2\ua7a2\2\ua7a4"+
		"\2\ua7a4\2\ua7a6\2\ua7a6\2\ua7a8\2\ua7a8\2\ua7aa\2\ua7aa\2\ua7ac\2\ua7b0"+
		"\2\ua7b2\2\ua7b6\2\ua7b8\2\ua7b8\2\uff23\2\uff3c\2\u0402\3\u0429\3\u04b2"+
		"\3\u04d5\3\u0c82\3\u0cb4\3\u18a2\3\u18c1\3\ud402\3\ud41b\3\ud436\3\ud44f"+
		"\3\ud46a\3\ud483\3\ud49e\3\ud49e\3\ud4a0\3\ud4a1\3\ud4a4\3\ud4a4\3\ud4a7"+
		"\3\ud4a8\3\ud4ab\3\ud4ae\3\ud4b0\3\ud4b7\3\ud4d2\3\ud4eb\3\ud506\3\ud507"+
		"\3\ud509\3\ud50c\3\ud50f\3\ud516\3\ud518\3\ud51e\3\ud53a\3\ud53b\3\ud53d"+
		"\3\ud540\3\ud542\3\ud546\3\ud548\3\ud548\3\ud54c\3\ud552\3\ud56e\3\ud587"+
		"\3\ud5a2\3\ud5bb\3\ud5d6\3\ud5ef\3\ud60a\3\ud623\3\ud63e\3\ud657\3\ud672"+
		"\3\ud68b\3\ud6aa\3\ud6c2\3\ud6e4\3\ud6fc\3\ud71e\3\ud736\3\ud758\3\ud770"+
		"\3\ud792\3\ud7aa\3\ud7cc\3\ud7cc\3\ue902\3\ue923\3\u027b\2c\2|\2\u00b7"+
		"\2\u00b7\2\u00e1\2\u00f8\2\u00fa\2\u0101\2\u0103\2\u0103\2\u0105\2\u0105"+
		"\2\u0107\2\u0107\2\u0109\2\u0109\2\u010b\2\u010b\2\u010d\2\u010d\2\u010f"+
		"\2\u010f\2\u0111\2\u0111\2\u0113\2\u0113\2\u0115\2\u0115\2\u0117\2\u0117"+
		"\2\u0119\2\u0119\2\u011b\2\u011b\2\u011d\2\u011d\2\u011f\2\u011f\2\u0121"+
		"\2\u0121\2\u0123\2\u0123\2\u0125\2\u0125\2\u0127\2\u0127\2\u0129\2\u0129"+
		"\2\u012b\2\u012b\2\u012d\2\u012d\2\u012f\2\u012f\2\u0131\2\u0131\2\u0133"+
		"\2\u0133\2\u0135\2\u0135\2\u0137\2\u0137\2\u0139\2\u013a\2\u013c\2\u013c"+
		"\2\u013e\2\u013e\2\u0140\2\u0140\2\u0142\2\u0142\2\u0144\2\u0144\2\u0146"+
		"\2\u0146\2\u0148\2\u0148\2\u014a\2\u014b\2\u014d\2\u014d\2\u014f\2\u014f"+
		"\2\u0151\2\u0151\2\u0153\2\u0153\2\u0155\2\u0155\2\u0157\2\u0157\2\u0159"+
		"\2\u0159\2\u015b\2\u015b\2\u015d\2\u015d\2\u015f\2\u015f\2\u0161\2\u0161"+
		"\2\u0163\2\u0163\2\u0165\2\u0165\2\u0167\2\u0167\2\u0169\2\u0169\2\u016b"+
		"\2\u016b\2\u016d\2\u016d\2\u016f\2\u016f\2\u0171\2\u0171\2\u0173\2\u0173"+
		"\2\u0175\2\u0175\2\u0177\2\u0177\2\u0179\2\u0179\2\u017c\2\u017c\2\u017e"+
		"\2\u017e\2\u0180\2\u0182\2\u0185\2\u0185\2\u0187\2\u0187\2\u018a\2\u018a"+
		"\2\u018e\2\u018f\2\u0194\2\u0194\2\u0197\2\u0197\2\u019b\2\u019d\2\u01a0"+
		"\2\u01a0\2\u01a3\2\u01a3\2\u01a5\2\u01a5\2\u01a7\2\u01a7\2\u01aa\2\u01aa"+
		"\2\u01ac\2\u01ad\2\u01af\2\u01af\2\u01b2\2\u01b2\2\u01b6\2\u01b6\2\u01b8"+
		"\2\u01b8\2\u01bb\2\u01bc\2\u01bf\2\u01c1\2\u01c8\2\u01c8\2\u01cb\2\u01cb"+
		"\2\u01ce\2\u01ce\2\u01d0\2\u01d0\2\u01d2\2\u01d2\2\u01d4\2\u01d4\2\u01d6"+
		"\2\u01d6\2\u01d8\2\u01d8\2\u01da\2\u01da\2\u01dc\2\u01dc\2\u01de\2\u01df"+
		"\2\u01e1\2\u01e1\2\u01e3\2\u01e3\2\u01e5\2\u01e5\2\u01e7\2\u01e7\2\u01e9"+
		"\2\u01e9\2\u01eb\2\u01eb\2\u01ed\2\u01ed\2\u01ef\2\u01ef\2\u01f1\2\u01f2"+
		"\2\u01f5\2\u01f5\2\u01f7\2\u01f7\2\u01fb\2\u01fb\2\u01fd\2\u01fd\2\u01ff"+
		"\2\u01ff\2\u0201\2\u0201\2\u0203\2\u0203\2\u0205\2\u0205\2\u0207\2\u0207"+
		"\2\u0209\2\u0209\2\u020b\2\u020b\2\u020d\2\u020d\2\u020f\2\u020f\2\u0211"+
		"\2\u0211\2\u0213\2\u0213\2\u0215\2\u0215\2\u0217\2\u0217\2\u0219\2\u0219"+
		"\2\u021b\2\u021b\2\u021d\2\u021d\2\u021f\2\u021f\2\u0221\2\u0221\2\u0223"+
		"\2\u0223\2\u0225\2\u0225\2\u0227\2\u0227\2\u0229\2\u0229\2\u022b\2\u022b"+
		"\2\u022d\2\u022d\2\u022f\2\u022f\2\u0231\2\u0231\2\u0233\2\u0233\2\u0235"+
		"\2\u023b\2\u023e\2\u023e\2\u0241\2\u0242\2\u0244\2\u0244\2\u0249\2\u0249"+
		"\2\u024b\2\u024b\2\u024d\2\u024d\2\u024f\2\u024f\2\u0251\2\u0295\2\u0297"+
		"\2\u02b1\2\u0373\2\u0373\2\u0375\2\u0375\2\u0379\2\u0379\2\u037d\2\u037f"+
		"\2\u0392\2\u0392\2\u03ae\2\u03d0\2\u03d2\2\u03d3\2\u03d7\2\u03d9\2\u03db"+
		"\2\u03db\2\u03dd\2\u03dd\2\u03df\2\u03df\2\u03e1\2\u03e1\2\u03e3\2\u03e3"+
		"\2\u03e5\2\u03e5\2\u03e7\2\u03e7\2\u03e9\2\u03e9\2\u03eb\2\u03eb\2\u03ed"+
		"\2\u03ed\2\u03ef\2\u03ef\2\u03f1\2\u03f5\2\u03f7\2\u03f7\2\u03fa\2\u03fa"+
		"\2\u03fd\2\u03fe\2\u0432\2\u0461\2\u0463\2\u0463\2\u0465\2\u0465\2\u0467"+
		"\2\u0467\2\u0469\2\u0469\2\u046b\2\u046b\2\u046d\2\u046d\2\u046f\2\u046f"+
		"\2\u0471\2\u0471\2\u0473\2\u0473\2\u0475\2\u0475\2\u0477\2\u0477\2\u0479"+
		"\2\u0479\2\u047b\2\u047b\2\u047d\2\u047d\2\u047f\2\u047f\2\u0481\2\u0481"+
		"\2\u0483\2\u0483\2\u048d\2\u048d\2\u048f\2\u048f\2\u0491\2\u0491\2\u0493"+
		"\2\u0493\2\u0495\2\u0495\2\u0497\2\u0497\2\u0499\2\u0499\2\u049b\2\u049b"+
		"\2\u049d\2\u049d\2\u049f\2\u049f\2\u04a1\2\u04a1\2\u04a3\2\u04a3\2\u04a5"+
		"\2\u04a5\2\u04a7\2\u04a7\2\u04a9\2\u04a9\2\u04ab\2\u04ab\2\u04ad\2\u04ad"+
		"\2\u04af\2\u04af\2\u04b1\2\u04b1\2\u04b3\2\u04b3\2\u04b5\2\u04b5\2\u04b7"+
		"\2\u04b7\2\u04b9\2\u04b9\2\u04bb\2\u04bb\2\u04bd\2\u04bd\2\u04bf\2\u04bf"+
		"\2\u04c1\2\u04c1\2\u04c4\2\u04c4\2\u04c6\2\u04c6\2\u04c8\2\u04c8\2\u04ca"+
		"\2\u04ca\2\u04cc\2\u04cc\2\u04ce\2\u04ce\2\u04d0\2\u04d1\2\u04d3\2\u04d3"+
		"\2\u04d5\2\u04d5\2\u04d7\2\u04d7\2\u04d9\2\u04d9\2\u04db\2\u04db\2\u04dd"+
		"\2\u04dd\2\u04df\2\u04df\2\u04e1\2\u04e1\2\u04e3\2\u04e3\2\u04e5\2\u04e5"+
		"\2\u04e7\2\u04e7\2\u04e9\2\u04e9\2\u04eb\2\u04eb\2\u04ed\2\u04ed\2\u04ef"+
		"\2\u04ef\2\u04f1\2\u04f1\2\u04f3\2\u04f3\2\u04f5\2\u04f5\2\u04f7\2\u04f7"+
		"\2\u04f9\2\u04f9\2\u04fb\2\u04fb\2\u04fd\2\u04fd\2\u04ff\2\u04ff\2\u0501"+
		"\2\u0501\2\u0503\2\u0503\2\u0505\2\u0505\2\u0507\2\u0507\2\u0509\2\u0509"+
		"\2\u050b\2\u050b\2\u050d\2\u050d\2\u050f\2\u050f\2\u0511\2\u0511\2\u0513"+
		"\2\u0513\2\u0515\2\u0515\2\u0517\2\u0517\2\u0519\2\u0519\2\u051b\2\u051b"+
		"\2\u051d\2\u051d\2\u051f\2\u051f\2\u0521\2\u0521\2\u0523\2\u0523\2\u0525"+
		"\2\u0525\2\u0527\2\u0527\2\u0529\2\u0529\2\u052b\2\u052b\2\u052d\2\u052d"+
		"\2\u052f\2\u052f\2\u0531\2\u0531\2\u0563\2\u0589\2\u13fa\2\u13ff\2\u1c82"+
		"\2\u1c8a\2\u1d02\2\u1d2d\2\u1d6d\2\u1d79\2\u1d7b\2\u1d9c\2\u1e03\2\u1e03"+
		"\2\u1e05\2\u1e05\2\u1e07\2\u1e07\2\u1e09\2\u1e09\2\u1e0b\2\u1e0b\2\u1e0d"+
		"\2\u1e0d\2\u1e0f\2\u1e0f\2\u1e11\2\u1e11\2\u1e13\2\u1e13\2\u1e15\2\u1e15"+
		"\2\u1e17\2\u1e17\2\u1e19\2\u1e19\2\u1e1b\2\u1e1b\2\u1e1d\2\u1e1d\2\u1e1f"+
		"\2\u1e1f\2\u1e21\2\u1e21\2\u1e23\2\u1e23\2\u1e25\2\u1e25\2\u1e27\2\u1e27"+
		"\2\u1e29\2\u1e29\2\u1e2b\2\u1e2b\2\u1e2d\2\u1e2d\2\u1e2f\2\u1e2f\2\u1e31"+
		"\2\u1e31\2\u1e33\2\u1e33\2\u1e35\2\u1e35\2\u1e37\2\u1e37\2\u1e39\2\u1e39"+
		"\2\u1e3b\2\u1e3b\2\u1e3d\2\u1e3d\2\u1e3f\2\u1e3f\2\u1e41\2\u1e41\2\u1e43"+
		"\2\u1e43\2\u1e45\2\u1e45\2\u1e47\2\u1e47\2\u1e49\2\u1e49\2\u1e4b\2\u1e4b"+
		"\2\u1e4d\2\u1e4d\2\u1e4f\2\u1e4f\2\u1e51\2\u1e51\2\u1e53\2\u1e53\2\u1e55"+
		"\2\u1e55\2\u1e57\2\u1e57\2\u1e59\2\u1e59\2\u1e5b\2\u1e5b\2\u1e5d\2\u1e5d"+
		"\2\u1e5f\2\u1e5f\2\u1e61\2\u1e61\2\u1e63\2\u1e63\2\u1e65\2\u1e65\2\u1e67"+
		"\2\u1e67\2\u1e69\2\u1e69\2\u1e6b\2\u1e6b\2\u1e6d\2\u1e6d\2\u1e6f\2\u1e6f"+
		"\2\u1e71\2\u1e71\2\u1e73\2\u1e73\2\u1e75\2\u1e75\2\u1e77\2\u1e77\2\u1e79"+
		"\2\u1e79\2\u1e7b\2\u1e7b\2\u1e7d\2\u1e7d\2\u1e7f\2\u1e7f\2\u1e81\2\u1e81"+
		"\2\u1e83\2\u1e83\2\u1e85\2\u1e85\2\u1e87\2\u1e87\2\u1e89\2\u1e89\2\u1e8b"+
		"\2\u1e8b\2\u1e8d\2\u1e8d\2\u1e8f\2\u1e8f\2\u1e91\2\u1e91\2\u1e93\2\u1e93"+
		"\2\u1e95\2\u1e95\2\u1e97\2\u1e9f\2\u1ea1\2\u1ea1\2\u1ea3\2\u1ea3\2\u1ea5"+
		"\2\u1ea5\2\u1ea7\2\u1ea7\2\u1ea9\2\u1ea9\2\u1eab\2\u1eab\2\u1ead\2\u1ead"+
		"\2\u1eaf\2\u1eaf\2\u1eb1\2\u1eb1\2\u1eb3\2\u1eb3\2\u1eb5\2\u1eb5\2\u1eb7"+
		"\2\u1eb7\2\u1eb9\2\u1eb9\2\u1ebb\2\u1ebb\2\u1ebd\2\u1ebd\2\u1ebf\2\u1ebf"+
		"\2\u1ec1\2\u1ec1\2\u1ec3\2\u1ec3\2\u1ec5\2\u1ec5\2\u1ec7\2\u1ec7\2\u1ec9"+
		"\2\u1ec9\2\u1ecb\2\u1ecb\2\u1ecd\2\u1ecd\2\u1ecf\2\u1ecf\2\u1ed1\2\u1ed1"+
		"\2\u1ed3\2\u1ed3\2\u1ed5\2\u1ed5\2\u1ed7\2\u1ed7\2\u1ed9\2\u1ed9\2\u1edb"+
		"\2\u1edb\2\u1edd\2\u1edd\2\u1edf\2\u1edf\2\u1ee1\2\u1ee1\2\u1ee3\2\u1ee3"+
		"\2\u1ee5\2\u1ee5\2\u1ee7\2\u1ee7\2\u1ee9\2\u1ee9\2\u1eeb\2\u1eeb\2\u1eed"+
		"\2\u1eed\2\u1eef\2\u1eef\2\u1ef1\2\u1ef1\2\u1ef3\2\u1ef3\2\u1ef5\2\u1ef5"+
		"\2\u1ef7\2\u1ef7\2\u1ef9\2\u1ef9\2\u1efb\2\u1efb\2\u1efd\2\u1efd\2\u1eff"+
		"\2\u1eff\2\u1f01\2\u1f09\2\u1f12\2\u1f17\2\u1f22\2\u1f29\2\u1f32\2\u1f39"+
		"\2\u1f42\2\u1f47\2\u1f52\2\u1f59\2\u1f62\2\u1f69\2\u1f72\2\u1f7f\2\u1f82"+
		"\2\u1f89\2\u1f92\2\u1f99\2\u1fa2\2\u1fa9\2\u1fb2\2\u1fb6\2\u1fb8\2\u1fb9"+
		"\2\u1fc0\2\u1fc0\2\u1fc4\2\u1fc6\2\u1fc8\2\u1fc9\2\u1fd2\2\u1fd5\2\u1fd8"+
		"\2\u1fd9\2\u1fe2\2\u1fe9\2\u1ff4\2\u1ff6\2\u1ff8\2\u1ff9\2\u210c\2\u210c"+
		"\2\u2110\2\u2111\2\u2115\2\u2115\2\u2131\2\u2131\2\u2136\2\u2136\2\u213b"+
		"\2\u213b\2\u213e\2\u213f\2\u2148\2\u214b\2\u2150\2\u2150\2\u2186\2\u2186"+
		"\2\u2c32\2\u2c60\2\u2c63\2\u2c63\2\u2c67\2\u2c68\2\u2c6a\2\u2c6a\2\u2c6c"+
		"\2\u2c6c\2\u2c6e\2\u2c6e\2\u2c73\2\u2c73\2\u2c75\2\u2c76\2\u2c78\2\u2c7d"+
		"\2\u2c83\2\u2c83\2\u2c85\2\u2c85\2\u2c87\2\u2c87\2\u2c89\2\u2c89\2\u2c8b"+
		"\2\u2c8b\2\u2c8d\2\u2c8d\2\u2c8f\2\u2c8f\2\u2c91\2\u2c91\2\u2c93\2\u2c93"+
		"\2\u2c95\2\u2c95\2\u2c97\2\u2c97\2\u2c99\2\u2c99\2\u2c9b\2\u2c9b\2\u2c9d"+
		"\2\u2c9d\2\u2c9f\2\u2c9f\2\u2ca1\2\u2ca1\2\u2ca3\2\u2ca3\2\u2ca5\2\u2ca5"+
		"\2\u2ca7\2\u2ca7\2\u2ca9\2\u2ca9\2\u2cab\2\u2cab\2\u2cad\2\u2cad\2\u2caf"+
		"\2\u2caf\2\u2cb1\2\u2cb1\2\u2cb3\2\u2cb3\2\u2cb5\2\u2cb5\2\u2cb7\2\u2cb7"+
		"\2\u2cb9\2\u2cb9\2\u2cbb\2\u2cbb\2\u2cbd\2\u2cbd\2\u2cbf\2\u2cbf\2\u2cc1"+
		"\2\u2cc1\2\u2cc3\2\u2cc3\2\u2cc5\2\u2cc5\2\u2cc7\2\u2cc7\2\u2cc9\2\u2cc9"+
		"\2\u2ccb\2\u2ccb\2\u2ccd\2\u2ccd\2\u2ccf\2\u2ccf\2\u2cd1\2\u2cd1\2\u2cd3"+
		"\2\u2cd3\2\u2cd5\2\u2cd5\2\u2cd7\2\u2cd7\2\u2cd9\2\u2cd9\2\u2cdb\2\u2cdb"+
		"\2\u2cdd\2\u2cdd\2\u2cdf\2\u2cdf\2\u2ce1\2\u2ce1\2\u2ce3\2\u2ce3\2\u2ce5"+
		"\2\u2ce6\2\u2cee\2\u2cee\2\u2cf0\2\u2cf0\2\u2cf5\2\u2cf5\2\u2d02\2\u2d27"+
		"\2\u2d29\2\u2d29\2\u2d2f\2\u2d2f\2\ua643\2\ua643\2\ua645\2\ua645\2\ua647"+
		"\2\ua647\2\ua649\2\ua649\2\ua64b\2\ua64b\2\ua64d\2\ua64d\2\ua64f\2\ua64f"+
		"\2\ua651\2\ua651\2\ua653\2\ua653\2\ua655\2\ua655\2\ua657\2\ua657\2\ua659"+
		"\2\ua659\2\ua65b\2\ua65b\2\ua65d\2\ua65d\2\ua65f\2\ua65f\2\ua661\2\ua661"+
		"\2\ua663\2\ua663\2\ua665\2\ua665\2\ua667\2\ua667\2\ua669\2\ua669\2\ua66b"+
		"\2\ua66b\2\ua66d\2\ua66d\2\ua66f\2\ua66f\2\ua683\2\ua683\2\ua685\2\ua685"+
		"\2\ua687\2\ua687\2\ua689\2\ua689\2\ua68b\2\ua68b\2\ua68d\2\ua68d\2\ua68f"+
		"\2\ua68f\2\ua691\2\ua691\2\ua693\2\ua693\2\ua695\2\ua695\2\ua697\2\ua697"+
		"\2\ua699\2\ua699\2\ua69b\2\ua69b\2\ua69d\2\ua69d\2\ua725\2\ua725\2\ua727"+
		"\2\ua727\2\ua729\2\ua729\2\ua72b\2\ua72b\2\ua72d\2\ua72d\2\ua72f\2\ua72f"+
		"\2\ua731\2\ua733\2\ua735\2\ua735\2\ua737\2\ua737\2\ua739\2\ua739\2\ua73b"+
		"\2\ua73b\2\ua73d\2\ua73d\2\ua73f\2\ua73f\2\ua741\2\ua741\2\ua743\2\ua743"+
		"\2\ua745\2\ua745\2\ua747\2\ua747\2\ua749\2\ua749\2\ua74b\2\ua74b\2\ua74d"+
		"\2\ua74d\2\ua74f\2\ua74f\2\ua751\2\ua751\2\ua753\2\ua753\2\ua755\2\ua755"+
		"\2\ua757\2\ua757\2\ua759\2\ua759\2\ua75b\2\ua75b\2\ua75d\2\ua75d\2\ua75f"+
		"\2\ua75f\2\ua761\2\ua761\2\ua763\2\ua763\2\ua765\2\ua765\2\ua767\2\ua767"+
		"\2\ua769\2\ua769\2\ua76b\2\ua76b\2\ua76d\2\ua76d\2\ua76f\2\ua76f\2\ua771"+
		"\2\ua771\2\ua773\2\ua77a\2\ua77c\2\ua77c\2\ua77e\2\ua77e\2\ua781\2\ua781"+
		"\2\ua783\2\ua783\2\ua785\2\ua785\2\ua787\2\ua787\2\ua789\2\ua789\2\ua78e"+
		"\2\ua78e\2\ua790\2\ua790\2\ua793\2\ua793\2\ua795\2\ua797\2\ua799\2\ua799"+
		"\2\ua79b\2\ua79b\2\ua79d\2\ua79d\2\ua79f\2\ua79f\2\ua7a1\2\ua7a1\2\ua7a3"+
		"\2\ua7a3\2\ua7a5\2\ua7a5\2\ua7a7\2\ua7a7\2\ua7a9\2\ua7a9\2\ua7ab\2\ua7ab"+
		"\2\ua7b7\2\ua7b7\2\ua7b9\2\ua7b9\2\ua7fc\2\ua7fc\2\uab32\2\uab5c\2\uab62"+
		"\2\uab67\2\uab72\2\uabc1\2\ufb02\2\ufb08\2\ufb15\2\ufb19\2\uff43\2\uff5c"+
		"\2\u042a\3\u0451\3\u04da\3\u04fd\3\u0cc2\3\u0cf4\3\u18c2\3\u18e1\3\ud41c"+
		"\3\ud435\3\ud450\3\ud456\3\ud458\3\ud469\3\ud484\3\ud49d\3\ud4b8\3\ud4bb"+
		"\3\ud4bd\3\ud4bd\3\ud4bf\3\ud4c5\3\ud4c7\3\ud4d1\3\ud4ec\3\ud505\3\ud520"+
		"\3\ud539\3\ud554\3\ud56d\3\ud588\3\ud5a1\3\ud5bc\3\ud5d5\3\ud5f0\3\ud609"+
		"\3\ud624\3\ud63d\3\ud658\3\ud671\3\ud68c\3\ud6a7\3\ud6c4\3\ud6dc\3\ud6de"+
		"\3\ud6e3\3\ud6fe\3\ud716\3\ud718\3\ud71d\3\ud738\3\ud750\3\ud752\3\ud757"+
		"\3\ud772\3\ud78a\3\ud78c\3\ud791\3\ud7ac\3\ud7c4\3\ud7c6\3\ud7cb\3\ud7cd"+
		"\3\ud7cd\3\ue924\3\ue945\3\u01cf\2\u00ac\2\u00ac\2\u00bc\2\u00bc\2\u01bd"+
		"\2\u01bd\2\u01c2\2\u01c5\2\u01c7\2\u01c7\2\u01ca\2\u01ca\2\u01cd\2\u01cd"+
		"\2\u01f4\2\u01f4\2\u0296\2\u0296\2\u05d2\2\u05ec\2\u05f2\2\u05f4\2\u0622"+
		"\2\u0641\2\u0643\2\u064c\2\u0670\2\u0671\2\u0673\2\u06d5\2\u06d7\2\u06d7"+
		"\2\u06f0\2\u06f1\2\u06fc\2\u06fe\2\u0701\2\u0701\2\u0712\2\u0712\2\u0714"+
		"\2\u0731\2\u074f\2\u07a7\2\u07b3\2\u07b3\2\u07cc\2\u07ec\2\u0802\2\u0817"+
		"\2\u0842\2\u085a\2\u08a2\2\u08b6\2\u08b8\2\u08bf\2\u0906\2\u093b\2\u093f"+
		"\2\u093f\2\u0952\2\u0952\2\u095a\2\u0963\2\u0974\2\u0982\2\u0987\2\u098e"+
		"\2\u0991\2\u0992\2\u0995\2\u09aa\2\u09ac\2\u09b2\2\u09b4\2\u09b4\2\u09b8"+
		"\2\u09bb\2\u09bf\2\u09bf\2\u09d0\2\u09d0\2\u09de\2\u09df\2\u09e1\2\u09e3"+
		"\2\u09f2\2\u09f3\2\u0a07\2\u0a0c\2\u0a11\2\u0a12\2\u0a15\2\u0a2a\2\u0a2c"+
		"\2\u0a32\2\u0a34\2\u0a35\2\u0a37\2\u0a38\2\u0a3a\2\u0a3b\2\u0a5b\2\u0a5e"+
		"\2\u0a60\2\u0a60\2\u0a74\2\u0a76\2\u0a87\2\u0a8f\2\u0a91\2\u0a93\2\u0a95"+
		"\2\u0aaa\2\u0aac\2\u0ab2\2\u0ab4\2\u0ab5\2\u0ab7\2\u0abb\2\u0abf\2\u0abf"+
		"\2\u0ad2\2\u0ad2\2\u0ae2\2\u0ae3\2\u0afb\2\u0afb\2\u0b07\2\u0b0e\2\u0b11"+
		"\2\u0b12\2\u0b15\2\u0b2a\2\u0b2c\2\u0b32\2\u0b34\2\u0b35\2\u0b37\2\u0b3b"+
		"\2\u0b3f\2\u0b3f\2\u0b5e\2\u0b5f\2\u0b61\2\u0b63\2\u0b73\2\u0b73\2\u0b85"+
		"\2\u0b85\2\u0b87\2\u0b8c\2\u0b90\2\u0b92\2\u0b94\2\u0b97\2\u0b9b\2\u0b9c"+
		"\2\u0b9e\2\u0b9e\2\u0ba0\2\u0ba1\2\u0ba5\2\u0ba6\2\u0baa\2\u0bac\2\u0bb0"+
		"\2\u0bbb\2\u0bd2\2\u0bd2\2\u0c07\2\u0c0e\2\u0c10\2\u0c12\2\u0c14\2\u0c2a"+
		"\2\u0c2c\2\u0c3b\2\u0c3f\2\u0c3f\2\u0c5a\2\u0c5c\2\u0c62\2\u0c63\2\u0c82"+
		"\2\u0c82\2\u0c87\2\u0c8e\2\u0c90\2\u0c92\2\u0c94\2\u0caa\2\u0cac\2\u0cb5"+
		"\2\u0cb7\2\u0cbb\2\u0cbf\2\u0cbf\2\u0ce0\2\u0ce0\2\u0ce2\2\u0ce3\2\u0cf3"+
		"\2\u0cf4\2\u0d07\2\u0d0e\2\u0d10\2\u0d12\2\u0d14\2\u0d3c\2\u0d3f\2\u0d3f"+
		"\2\u0d50\2\u0d50\2\u0d56\2\u0d58\2\u0d61\2\u0d63\2\u0d7c\2\u0d81\2\u0d87"+
		"\2\u0d98\2\u0d9c\2\u0db3\2\u0db5\2\u0dbd\2\u0dbf\2\u0dbf\2\u0dc2\2\u0dc8"+
		"\2\u0e03\2\u0e32\2\u0e34\2\u0e35\2\u0e42\2\u0e47\2\u0e83\2\u0e84\2\u0e86"+
		"\2\u0e86\2\u0e89\2\u0e8a\2\u0e8c\2\u0e8c\2\u0e8f\2\u0e8f\2\u0e96\2\u0e99"+
		"\2\u0e9b\2\u0ea1\2\u0ea3\2\u0ea5\2\u0ea7\2\u0ea7\2\u0ea9\2\u0ea9\2\u0eac"+
		"\2\u0ead\2\u0eaf\2\u0eb2\2\u0eb4\2\u0eb5\2\u0ebf\2\u0ebf\2\u0ec2\2\u0ec6"+
		"\2\u0ede\2\u0ee1\2\u0f02\2\u0f02\2\u0f42\2\u0f49\2\u0f4b\2\u0f6e\2\u0f8a"+
		"\2\u0f8e\2\u1002\2\u102c\2\u1041\2\u1041\2\u1052\2\u1057\2\u105c\2\u105f"+
		"\2\u1063\2\u1063\2\u1067\2\u1068\2\u1070\2\u1072\2\u1077\2\u1083\2\u1090"+
		"\2\u1090\2\u10d2\2\u10fc\2\u10ff\2\u124a\2\u124c\2\u124f\2\u1252\2\u1258"+
		"\2\u125a\2\u125a\2\u125c\2\u125f\2\u1262\2\u128a\2\u128c\2\u128f\2\u1292"+
		"\2\u12b2\2\u12b4\2\u12b7\2\u12ba\2\u12c0\2\u12c2\2\u12c2\2\u12c4\2\u12c7"+
		"\2\u12ca\2\u12d8\2\u12da\2\u1312\2\u1314\2\u1317\2\u131a\2\u135c\2\u1382"+
		"\2\u1391\2\u1403\2\u166e\2\u1671\2\u1681\2\u1683\2\u169c\2\u16a2\2\u16ec"+
		"\2\u16f0\2\u16fa\2\u1702\2\u170e\2\u1710\2\u1713\2\u1722\2\u1733\2\u1742"+
		"\2\u1753\2\u1762\2\u176e\2\u1770\2\u1772\2\u1782\2\u17b5\2\u17de\2\u17de"+
		"\2\u1822\2\u1844\2\u1846\2\u1879\2\u1882\2\u1886\2\u1889\2\u18aa\2\u18ac"+
		"\2\u18ac\2\u18b2\2\u18f7\2\u1902\2\u1920\2\u1952\2\u196f\2\u1972\2\u1976"+
		"\2\u1982\2\u19ad\2\u19b2\2\u19cb\2\u1a02\2\u1a18\2\u1a22\2\u1a56\2\u1b07"+
		"\2\u1b35\2\u1b47\2\u1b4d\2\u1b85\2\u1ba2\2\u1bb0\2\u1bb1\2\u1bbc\2\u1be7"+
		"\2\u1c02\2\u1c25\2\u1c4f\2\u1c51\2\u1c5c\2\u1c79\2\u1ceb\2\u1cee\2\u1cf0"+
		"\2\u1cf3\2\u1cf7\2\u1cf8\2\u1f8a\2\u1f91\2\u1f9a\2\u1fa1\2\u1faa\2\u1fb1"+
		"\2\u1fbe\2\u1fbe\2\u1fce\2\u1fce\2\u1ffe\2\u1ffe\2\u2137\2\u213a\2\u2162"+
		"\2\u2184\2\u2187\2\u218a\2\u2d32\2\u2d69\2\u2d82\2\u2d98\2\u2da2\2\u2da8"+
		"\2\u2daa\2\u2db0\2\u2db2\2\u2db8\2\u2dba\2\u2dc0\2\u2dc2\2\u2dc8\2\u2dca"+
		"\2\u2dd0\2\u2dd2\2\u2dd8\2\u2dda\2\u2de0\2\u3008\2\u3009\2\u3023\2\u302b"+
		"\2\u303a\2\u303c\2\u303e\2\u303e\2\u3043\2\u3098\2\u30a1\2\u30a1\2\u30a3"+
		"\2\u30fc\2\u3101\2\u3101\2\u3107\2\u312f\2\u3133\2\u3190\2\u31a2\2\u31bc"+
		"\2\u31f2\2\u3201\2\u3402\2\u4db7\2\u4e02\2\u9fd7\2\ua002\2\ua016\2\ua018"+
		"\2\ua48e\2\ua4d2\2\ua4f9\2\ua502\2\ua60d\2\ua612\2\ua621\2\ua62c\2\ua62d"+
		"\2\ua670\2\ua670\2\ua6a2\2\ua6f1\2\ua791\2\ua791\2\ua7f9\2\ua7f9\2\ua7fd"+
		"\2\ua803\2\ua805\2\ua807\2\ua809\2\ua80c\2\ua80e\2\ua824\2\ua842\2\ua875"+
		"\2\ua884\2\ua8b5\2\ua8f4\2\ua8f9\2\ua8fd\2\ua8fd\2\ua8ff\2\ua8ff\2\ua90c"+
		"\2\ua927\2\ua932\2\ua948\2\ua962\2\ua97e\2\ua986\2\ua9b4\2\ua9e2\2\ua9e6"+
		"\2\ua9e9\2\ua9f1\2\ua9fc\2\uaa00\2\uaa02\2\uaa2a\2\uaa42\2\uaa44\2\uaa46"+
		"\2\uaa4d\2\uaa62\2\uaa71\2\uaa73\2\uaa78\2\uaa7c\2\uaa7c\2\uaa80\2\uaab1"+
		"\2\uaab3\2\uaab3\2\uaab7\2\uaab8\2\uaabb\2\uaabf\2\uaac2\2\uaac2\2\uaac4"+
		"\2\uaac4\2\uaadd\2\uaade\2\uaae2\2\uaaec\2\uaaf4\2\uaaf4\2\uab03\2\uab08"+
		"\2\uab0b\2\uab10\2\uab13\2\uab18\2\uab22\2\uab28\2\uab2a\2\uab30\2\uabc2"+
		"\2\uabe4\2\uac02\2\ud7a5\2\ud7b2\2\ud7c8\2\ud7cd\2\ud7fd\2\uf902\2\ufa6f"+
		"\2\ufa72\2\ufadb\2\ufb1f\2\ufb1f\2\ufb21\2\ufb2a\2\ufb2c\2\ufb38\2\ufb3a"+
		"\2\ufb3e\2\ufb40\2\ufb40\2\ufb42\2\ufb43\2\ufb45\2\ufb46\2\ufb48\2\ufbb3"+
		"\2\ufbd5\2\ufd3f\2\ufd52\2\ufd91\2\ufd94\2\ufdc9\2\ufdf2\2\ufdfd\2\ufe72"+
		"\2\ufe76\2\ufe78\2\ufefe\2\uff68\2\uff71\2\uff73\2\uff9f\2\uffa2\2\uffc0"+
		"\2\uffc4\2\uffc9\2\uffcc\2\uffd1\2\uffd4\2\uffd9\2\uffdc\2\uffde\2\2\3"+
		"\r\3\17\3(\3*\3<\3>\3?\3A\3O\3R\3_\3\u0082\3\u00fc\3\u0142\3\u0176\3\u0282"+
		"\3\u029e\3\u02a2\3\u02d2\3\u0302\3\u0321\3\u0332\3\u034c\3\u0352\3\u0377"+
		"\3\u0382\3\u039f\3\u03a2\3\u03c5\3\u03ca\3\u03d1\3\u03d3\3\u03d7\3\u0452"+
		"\3\u049f\3\u0502\3\u0529\3\u0532\3\u0565\3\u0602\3\u0738\3\u0742\3\u0757"+
		"\3\u0762\3\u0769\3\u0802\3\u0807\3\u080a\3\u080a\3\u080c\3\u0837\3\u0839"+
		"\3\u083a\3\u083e\3\u083e\3\u0841\3\u0857\3\u0862\3\u0878\3\u0882\3\u08a0"+
		"\3\u08e2\3\u08f4\3\u08f6\3\u08f7\3\u0902\3\u0917\3\u0922\3\u093b\3\u0982"+
		"\3\u09b9\3\u09c0\3\u09c1\3\u0a02\3\u0a02\3\u0a12\3\u0a15\3\u0a17\3\u0a19"+
		"\3\u0a1b\3\u0a35\3\u0a62\3\u0a7e\3\u0a82\3\u0a9e\3\u0ac2\3\u0ac9\3\u0acb"+
		"\3\u0ae6\3\u0b02\3\u0b37\3\u0b42\3\u0b57\3\u0b62\3\u0b74\3\u0b82\3\u0b93"+
		"\3\u0c02\3\u0c4a\3\u1005\3\u1039\3\u1085\3\u10b1\3\u10d2\3\u10ea\3\u1105"+
		"\3\u1128\3\u1152\3\u1174\3\u1178\3\u1178\3\u1185\3\u11b4\3\u11c3\3\u11c6"+
		"\3\u11dc\3\u11dc\3\u11de\3\u11de\3\u1202\3\u1213\3\u1215\3\u122d\3\u1282"+
		"\3\u1288\3\u128a\3\u128a\3\u128c\3\u128f\3\u1291\3\u129f\3\u12a1\3\u12aa"+
		"\3\u12b2\3\u12e0\3\u1307\3\u130e\3\u1311\3\u1312\3\u1315\3\u132a\3\u132c"+
		"\3\u1332\3\u1334\3\u1335\3\u1337\3\u133b\3\u133f\3\u133f\3\u1352\3\u1352"+
		"\3\u135f\3\u1363\3\u1402\3\u1436\3\u1449\3\u144c\3\u1482\3\u14b1\3\u14c6"+
		"\3\u14c7\3\u14c9\3\u14c9\3\u1582\3\u15b0\3\u15da\3\u15dd\3\u1602\3\u1631"+
		"\3\u1646\3\u1646\3\u1682\3\u16ac\3\u1702\3\u171b\3\u1901\3\u1901\3\u1ac2"+
		"\3\u1afa\3\u1c02\3\u1c0a\3\u1c0c\3\u1c30\3\u1c42\3\u1c42\3\u1c74\3\u1c91"+
		"\3\u2002\3\u239b\3\u2402\3\u2470\3\u2482\3\u2545\3\u3002\3\u3430\3\u4402"+
		"\3\u4648\3\u6802\3\u6a3a\3\u6a42\3\u6a60\3\u6ad2\3\u6aef\3\u6b02\3\u6b31"+
		"\3\u6b65\3\u6b79\3\u6b7f\3\u6b91\3\u6f02\3\u6f46\3\u6f52\3\u6f52\3\u7002"+
		"\3\u87ee\3\u8802\3\u8af4\3\ub002\3\ub003\3\ubc02\3\ubc6c\3\ubc72\3\ubc7e"+
		"\3\ubc82\3\ubc8a\3\ubc92\3\ubc9b\3\ue802\3\ue8c6\3\uee02\3\uee05\3\uee07"+
		"\3\uee21\3\uee23\3\uee24\3\uee26\3\uee26\3\uee29\3\uee29\3\uee2b\3\uee34"+
		"\3\uee36\3\uee39\3\uee3b\3\uee3b\3\uee3d\3\uee3d\3\uee44\3\uee44\3\uee49"+
		"\3\uee49\3\uee4b\3\uee4b\3\uee4d\3\uee4d\3\uee4f\3\uee51\3\uee53\3\uee54"+
		"\3\uee56\3\uee56\3\uee59\3\uee59\3\uee5b\3\uee5b\3\uee5d\3\uee5d\3\uee5f"+
		"\3\uee5f\3\uee61\3\uee61\3\uee63\3\uee64\3\uee66\3\uee66\3\uee69\3\uee6c"+
		"\3\uee6e\3\uee74\3\uee76\3\uee79\3\uee7b\3\uee7e\3\uee80\3\uee80\3\uee82"+
		"\3\uee8b\3\uee8d\3\uee9d\3\ueea3\3\ueea5\3\ueea7\3\ueeab\3\ueead\3\ueebd"+
		"\3\2\4\ua6d8\4\ua702\4\ub736\4\ub742\4\ub81f\4\ub822\4\ucea3\4\uf802\4"+
		"\ufa1f\4\u02fa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2"+
		"\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\3\u00c3\3\2\2\2\5\u00c5\3\2\2"+
		"\2\7\u00ca\3\2\2\2\t\u00cc\3\2\2\2\13\u00ce\3\2\2\2\r\u00d3\3\2\2\2\17"+
		"\u00d9\3\2\2\2\21\u00db\3\2\2\2\23\u00dd\3\2\2\2\25\u00e0\3\2\2\2\27\u00e2"+
		"\3\2\2\2\31\u00e4\3\2\2\2\33\u00ec\3\2\2\2\35\u00ee\3\2\2\2\37\u00f0\3"+
		"\2\2\2!\u00f2\3\2\2\2#\u00f7\3\2\2\2%\u00fb\3\2\2\2\'\u0100\3\2\2\2)\u0102"+
		"\3\2\2\2+\u0104\3\2\2\2-\u0106\3\2\2\2/\u0108\3\2\2\2\61\u0111\3\2\2\2"+
		"\63\u0114\3\2\2\2\65\u0119\3\2\2\2\67\u011f\3\2\2\29\u0123\3\2\2\2;\u0129"+
		"\3\2\2\2=\u0131\3\2\2\2?\u0134\3\2\2\2A\u0138\3\2\2\2C\u013e\3\2\2\2E"+
		"\u0144\3\2\2\2G\u014b\3\2\2\2I\u014d\3\2\2\2K\u0153\3\2\2\2M\u0155\3\2"+
		"\2\2O\u0157\3\2\2\2Q\u0159\3\2\2\2S\u015d\3\2\2\2U\u0162\3\2\2\2W\u0165"+
		"\3\2\2\2Y\u016a\3\2\2\2[\u016c\3\2\2\2]\u016e\3\2\2\2_\u0171\3\2\2\2a"+
		"\u0174\3\2\2\2c\u0177\3\2\2\2e\u017b\3\2\2\2g\u0184\3\2\2\2i\u018d\3\2"+
		"\2\2k\u0193\3\2\2\2m\u019a\3\2\2\2o\u01a2\3\2\2\2q\u01ac\3\2\2\2s\u01b3"+
		"\3\2\2\2u\u01b7\3\2\2\2w\u01bb\3\2\2\2y\u01c1\3\2\2\2{\u01c8\3\2\2\2}"+
		"\u01ce\3\2\2\2\177\u01d6\3\2\2\2\u0081\u01df\3\2\2\2\u0083\u01ee\3\2\2"+
		"\2\u0085\u01f0\3\2\2\2\u0087\u01f8\3\2\2\2\u0089\u01fc\3\2\2\2\u008b\u0231"+
		"\3\2\2\2\u008d\u023c\3\2\2\2\u008f\u023e\3\2\2\2\u0091\u0257\3\2\2\2\u0093"+
		"\u0259\3\2\2\2\u0095\u0270\3\2\2\2\u0097\u0274\3\2\2\2\u0099\u0277\3\2"+
		"\2\2\u009b\u027d\3\2\2\2\u009d\u027f\3\2\2\2\u009f\u0287\3\2\2\2\u00a1"+
		"\u0289\3\2\2\2\u00a3\u028e\3\2\2\2\u00a5\u0290\3\2\2\2\u00a7\u0292\3\2"+
		"\2\2\u00a9\u0294\3\2\2\2\u00ab\u0296\3\2\2\2\u00ad\u0299\3\2\2\2\u00af"+
		"\u029b\3\2\2\2\u00b1\u02a1\3\2\2\2\u00b3\u02b0\3\2\2\2\u00b5\u02b2\3\2"+
		"\2\2\u00b7\u02b9\3\2\2\2\u00b9\u02c2\3\2\2\2\u00bb\u02c4\3\2\2\2\u00bd"+
		"\u02c9\3\2\2\2\u00bf\u02d4\3\2\2\2\u00c1\u02dd\3\2\2\2\u00c3\u00c4\7/"+
		"\2\2\u00c4\4\3\2\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8"+
		"\7n\2\2\u00c8\u00c9\7n\2\2\u00c9\6\3\2\2\2\u00ca\u00cb\7\60\2\2\u00cb"+
		"\b\3\2\2\2\u00cc\u00cd\7.\2\2\u00cd\n\3\2\2\2\u00ce\u00cf\7v\2\2\u00cf"+
		"\u00d0\7j\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7u\2\2\u00d2\f\3\2\2\2\u00d3"+
		"\u00d4\7u\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\7r\2\2\u00d6\u00d7\7g\2\2"+
		"\u00d7\u00d8\7t\2\2\u00d8\16\3\2\2\2\u00d9\u00da\7]\2\2\u00da\20\3\2\2"+
		"\2\u00db\u00dc\7_\2\2\u00dc\22\3\2\2\2\u00dd\u00de\7?\2\2\u00de\u00df"+
		"\7@\2\2\u00df\24\3\2\2\2\u00e0\u00e1\7*\2\2\u00e1\26\3\2\2\2\u00e2\u00e3"+
		"\7+\2\2\u00e3\30\3\2\2\2\u00e4\u00e5\7h\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7"+
		"\7t\2\2\u00e7\u00e8\7U\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7o\2\2\u00ea"+
		"\u00eb\7g\2\2\u00eb\32\3\2\2\2\u00ec\u00ed\7}\2\2\u00ed\34\3\2\2\2\u00ee"+
		"\u00ef\7=\2\2\u00ef\36\3\2\2\2\u00f0\u00f1\7\177\2\2\u00f1 \3\2\2\2\u00f2"+
		"\u00f3\7v\2\2\u00f3\u00f4\7{\2\2\u00f4\u00f5\7r\2\2\u00f5\u00f6\7g\2\2"+
		"\u00f6\"\3\2\2\2\u00f7\u00f8\7x\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7n"+
		"\2\2\u00fa$\3\2\2\2\u00fb\u00fc\7y\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe"+
		"\7v\2\2\u00fe\u00ff\7j\2\2\u00ff&\3\2\2\2\u0100\u0101\7%\2\2\u0101(\3"+
		"\2\2\2\u0102\u0103\7<\2\2\u0103*\3\2\2\2\u0104\u0105\7a\2\2\u0105,\3\2"+
		"\2\2\u0106\u0107\7,\2\2\u0107.\3\2\2\2\u0108\u0109\7k\2\2\u0109\u010a"+
		"\7o\2\2\u010a\u010b\7r\2\2\u010b\u010c\7n\2\2\u010c\u010d\7k\2\2\u010d"+
		"\u010e\7e\2\2\u010e\u010f\7k\2\2\u010f\u0110\7v\2\2\u0110\60\3\2\2\2\u0111"+
		"\u0112\7k\2\2\u0112\u0113\7h\2\2\u0113\62\3\2\2\2\u0114\u0115\7g\2\2\u0115"+
		"\u0116\7n\2\2\u0116\u0117\7u\2\2\u0117\u0118\7g\2\2\u0118\64\3\2\2\2\u0119"+
		"\u011a\7y\2\2\u011a\u011b\7j\2\2\u011b\u011c\7k\2\2\u011c\u011d\7n\2\2"+
		"\u011d\u011e\7g\2\2\u011e\66\3\2\2\2\u011f\u0120\7v\2\2\u0120\u0121\7"+
		"t\2\2\u0121\u0122\7{\2\2\u01228\3\2\2\2\u0123\u0124\7e\2\2\u0124\u0125"+
		"\7c\2\2\u0125\u0126\7v\2\2\u0126\u0127\7e\2\2\u0127\u0128\7j\2\2\u0128"+
		":\3\2\2\2\u0129\u012a\7h\2\2\u012a\u012b\7k\2\2\u012b\u012c\7p\2\2\u012c"+
		"\u012d\7c\2\2\u012d\u012e\7n\2\2\u012e\u012f\7n\2\2\u012f\u0130\7{\2\2"+
		"\u0130<\3\2\2\2\u0131\u0132\7f\2\2\u0132\u0133\7q\2\2\u0133>\3\2\2\2\u0134"+
		"\u0135\7h\2\2\u0135\u0136\7q\2\2\u0136\u0137\7t\2\2\u0137@\3\2\2\2\u0138"+
		"\u0139\7{\2\2\u0139\u013a\7k\2\2\u013a\u013b\7g\2\2\u013b\u013c\7n\2\2"+
		"\u013c\u013d\7f\2\2\u013dB\3\2\2\2\u013e\u013f\7v\2\2\u013f\u0140\7j\2"+
		"\2\u0140\u0141\7t\2\2\u0141\u0142\7q\2\2\u0142\u0143\7y\2\2\u0143D\3\2"+
		"\2\2\u0144\u0145\7t\2\2\u0145\u0146\7g\2\2\u0146\u0147\7v\2\2\u0147\u0148"+
		"\7w\2\2\u0148\u0149\7t\2\2\u0149\u014a\7p\2\2\u014aF\3\2\2\2\u014b\u014c"+
		"\7?\2\2\u014cH\3\2\2\2\u014d\u014e\7o\2\2\u014e\u014f\7c\2\2\u014f\u0150"+
		"\7v\2\2\u0150\u0151\7e\2\2\u0151\u0152\7j\2\2\u0152J\3\2\2\2\u0153\u0154"+
		"\7-\2\2\u0154L\3\2\2\2\u0155\u0156\7\u0080\2\2\u0156N\3\2\2\2\u0157\u0158"+
		"\7#\2\2\u0158P\3\2\2\2\u0159\u015a\7p\2\2\u015a\u015b\7g\2\2\u015b\u015c"+
		"\7y\2\2\u015cR\3\2\2\2\u015d\u015e\7n\2\2\u015e\u015f\7c\2\2\u015f\u0160"+
		"\7|\2\2\u0160\u0161\7{\2\2\u0161T\3\2\2\2\u0162\u0163\7>\2\2\u0163\u0164"+
		"\7/\2\2\u0164V\3\2\2\2\u0165\u0166\7e\2\2\u0166\u0167\7c\2\2\u0167\u0168"+
		"\7u\2\2\u0168\u0169\7g\2\2\u0169X\3\2\2\2\u016a\u016b\7~\2\2\u016bZ\3"+
		"\2\2\2\u016c\u016d\7B\2\2\u016d\\\3\2\2\2\u016e\u016f\7@\2\2\u016f\u0170"+
		"\7<\2\2\u0170^\3\2\2\2\u0171\u0172\7>\2\2\u0172\u0173\7<\2\2\u0173`\3"+
		"\2\2\2\u0174\u0175\7>\2\2\u0175\u0176\7\'\2\2\u0176b\3\2\2\2\u0177\u0178"+
		"\7x\2\2\u0178\u0179\7c\2\2\u0179\u017a\7t\2\2\u017ad\3\2\2\2\u017b\u017c"+
		"\7q\2\2\u017c\u017d\7x\2\2\u017d\u017e\7g\2\2\u017e\u017f\7t\2\2\u017f"+
		"\u0180\7t\2\2\u0180\u0181\7k\2\2\u0181\u0182\7f\2\2\u0182\u0183\7g\2\2"+
		"\u0183f\3\2\2\2\u0184\u0185\7c\2\2\u0185\u0186\7d\2\2\u0186\u0187\7u\2"+
		"\2\u0187\u0188\7v\2\2\u0188\u0189\7t\2\2\u0189\u018a\7c\2\2\u018a\u018b"+
		"\7e\2\2\u018b\u018c\7v\2\2\u018ch\3\2\2\2\u018d\u018e\7h\2\2\u018e\u018f"+
		"\7k\2\2\u018f\u0190\7p\2\2\u0190\u0191\7c\2\2\u0191\u0192\7n\2\2\u0192"+
		"j\3\2\2\2\u0193\u0194\7u\2\2\u0194\u0195\7g\2\2\u0195\u0196\7c\2\2\u0196"+
		"\u0197\7n\2\2\u0197\u0198\7g\2\2\u0198\u0199\7f\2\2\u0199l\3\2\2\2\u019a"+
		"\u019b\7r\2\2\u019b\u019c\7t\2\2\u019c\u019d\7k\2\2\u019d\u019e\7x\2\2"+
		"\u019e\u019f\7c\2\2\u019f\u01a0\7v\2\2\u01a0\u01a1\7g\2\2\u01a1n\3\2\2"+
		"\2\u01a2\u01a3\7r\2\2\u01a3\u01a4\7t\2\2\u01a4\u01a5\7q\2\2\u01a5\u01a6"+
		"\7v\2\2\u01a6\u01a7\7g\2\2\u01a7\u01a8\7e\2\2\u01a8\u01a9\7v\2\2\u01a9"+
		"\u01aa\7g\2\2\u01aa\u01ab\7f\2\2\u01abp\3\2\2\2\u01ac\u01ad\7k\2\2\u01ad"+
		"\u01ae\7o\2\2\u01ae\u01af\7r\2\2\u01af\u01b0\7q\2\2\u01b0\u01b1\7t\2\2"+
		"\u01b1\u01b2\7v\2\2\u01b2r\3\2\2\2\u01b3\u01b4\7f\2\2\u01b4\u01b5\7g\2"+
		"\2\u01b5\u01b6\7h\2\2\u01b6t\3\2\2\2\u01b7\u01b8\7>\2\2\u01b8\u01b9\7"+
		"<\2\2\u01b9\u01ba\7<\2\2\u01bav\3\2\2\2\u01bb\u01bc\7e\2\2\u01bc\u01bd"+
		"\7n\2\2\u01bd\u01be\7c\2\2\u01be\u01bf\7u\2\2\u01bf\u01c0\7u\2\2\u01c0"+
		"x\3\2\2\2\u01c1\u01c2\7q\2\2\u01c2\u01c3\7d\2\2\u01c3\u01c4\7l\2\2\u01c4"+
		"\u01c5\7g\2\2\u01c5\u01c6\7e\2\2\u01c6\u01c7\7v\2\2\u01c7z\3\2\2\2\u01c8"+
		"\u01c9\7v\2\2\u01c9\u01ca\7t\2\2\u01ca\u01cb\7c\2\2\u01cb\u01cc\7k\2\2"+
		"\u01cc\u01cd\7v\2\2\u01cd|\3\2\2\2\u01ce\u01cf\7g\2\2\u01cf\u01d0\7z\2"+
		"\2\u01d0\u01d1\7v\2\2\u01d1\u01d2\7g\2\2\u01d2\u01d3\7p\2\2\u01d3\u01d4"+
		"\7f\2\2\u01d4\u01d5\7u\2\2\u01d5~\3\2\2\2\u01d6\u01d7\7r\2\2\u01d7\u01d8"+
		"\7c\2\2\u01d8\u01d9\7e\2\2\u01d9\u01da\7m\2\2\u01da\u01db\7c\2\2\u01db"+
		"\u01dc\7i\2\2\u01dc\u01dd\7g\2\2\u01dd\u0080\3\2\2\2\u01de\u01e0\5\u00a5"+
		"S\2\u01df\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u0082\3\2\2\2\u01e3\u01ef\5\u0087D\2\u01e4\u01ea"+
		"\7b\2\2\u01e5\u01e9\5\u00a7T\2\u01e6\u01e9\5\u009dO\2\u01e7\u01e9\5\u00ab"+
		"V\2\u01e8\u01e5\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9"+
		"\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ed\3\2"+
		"\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01ef\7b\2\2\u01ee\u01e3\3\2\2\2\u01ee"+
		"\u01e4\3\2\2\2\u01ef\u0084\3\2\2\2\u01f0\u01f1\5\u00a1Q\2\u01f1\u01f2"+
		"\5\u00b1Y\2\u01f2\u0086\3\2\2\2\u01f3\u01f4\5\u009fP\2\u01f4\u01f5\5\u00b1"+
		"Y\2\u01f5\u01f9\3\2\2\2\u01f6\u01f9\5\u0085C\2\u01f7\u01f9\5\u0081A\2"+
		"\u01f8\u01f3\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f7\3\2\2\2\u01f9\u0088"+
		"\3\2\2\2\u01fa\u01fd\5\u00b3Z\2\u01fb\u01fd\5\u00b5[\2\u01fc\u01fa\3\2"+
		"\2\2\u01fc\u01fb\3\2\2\2\u01fd\u01ff\3\2\2\2\u01fe\u0200\t\2\2\2\u01ff"+
		"\u01fe\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u008a\3\2\2\2\u0201\u0203\5\u00ad"+
		"W\2\u0202\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0202\3\2\2\2\u0204"+
		"\u0205\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0208\7\60\2\2\u0207\u0209\5"+
		"\u00adW\2\u0208\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u0208\3\2\2\2"+
		"\u020a\u020b\3\2\2\2\u020b\u020d\3\2\2\2\u020c\u020e\5\u00b7\\\2\u020d"+
		"\u020c\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0210\3\2\2\2\u020f\u0211\5\u00b9"+
		"]\2\u0210\u020f\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0232\3\2\2\2\u0212"+
		"\u0214\7\60\2\2\u0213\u0215\5\u00adW\2\u0214\u0213\3\2\2\2\u0215\u0216"+
		"\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0219\3\2\2\2\u0218"+
		"\u021a\5\u00b7\\\2\u0219\u0218\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c"+
		"\3\2\2\2\u021b\u021d\5\u00b9]\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2"+
		"\2\u021d\u0232\3\2\2\2\u021e\u0220\5\u00adW\2\u021f\u021e\3\2\2\2\u0220"+
		"\u0221\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u0225\5\u00b7\\\2\u0224\u0226\5\u00b9]\2\u0225\u0224\3\2\2"+
		"\2\u0225\u0226\3\2\2\2\u0226\u0232\3\2\2\2\u0227\u0229\5\u00adW\2\u0228"+
		"\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u0228\3\2\2\2\u022a\u022b\3\2"+
		"\2\2\u022b\u022d\3\2\2\2\u022c\u022e\5\u00b7\\\2\u022d\u022c\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\5\u00b9]\2\u0230\u0232"+
		"\3\2\2\2\u0231\u0202\3\2\2\2\u0231\u0212\3\2\2\2\u0231\u021f\3\2\2\2\u0231"+
		"\u0228\3\2\2\2\u0232\u008c\3\2\2\2\u0233\u0234\7v\2\2\u0234\u0235\7t\2"+
		"\2\u0235\u0236\7w\2\2\u0236\u023d\7g\2\2\u0237\u0238\7h\2\2\u0238\u0239"+
		"\7c\2\2\u0239\u023a\7n\2\2\u023a\u023b\7u\2\2\u023b\u023d\7g\2\2\u023c"+
		"\u0233\3\2\2\2\u023c\u0237\3\2\2\2\u023d\u008e\3\2\2\2\u023e\u0242\7)"+
		"\2\2\u023f\u0243\5\u00bb^\2\u0240\u0243\5\u009dO\2\u0241\u0243\5\u00ab"+
		"V\2\u0242\u023f\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0241\3\2\2\2\u0243"+
		"\u0244\3\2\2\2\u0244\u0245\7)\2\2\u0245\u0090\3\2\2\2\u0246\u024a\7$\2"+
		"\2\u0247\u0249\5\u00bd_\2\u0248\u0247\3\2\2\2\u0249\u024c\3\2\2\2\u024a"+
		"\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024d\3\2\2\2\u024c\u024a\3\2"+
		"\2\2\u024d\u0258\7$\2\2\u024e\u024f\7$\2\2\u024f\u0250\7$\2\2\u0250\u0251"+
		"\7$\2\2\u0251\u0252\3\2\2\2\u0252\u0253\5\u00bf`\2\u0253\u0254\7$\2\2"+
		"\u0254\u0255\7$\2\2\u0255\u0256\7$\2\2\u0256\u0258\3\2\2\2\u0257\u0246"+
		"\3\2\2\2\u0257\u024e\3\2\2\2\u0258\u0092\3\2\2\2\u0259\u025a\7)\2\2\u025a"+
		"\u025b\5\u0087D\2\u025b\u0094\3\2\2\2\u025c\u025d\7\61\2\2\u025d\u025e"+
		"\7,\2\2\u025e\u0262\3\2\2\2\u025f\u0261\13\2\2\2\u0260\u025f\3\2\2\2\u0261"+
		"\u0264\3\2\2\2\u0262\u0263\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0265\3\2"+
		"\2\2\u0264\u0262\3\2\2\2\u0265\u0266\7,\2\2\u0266\u0271\7\61\2\2\u0267"+
		"\u0268\7\61\2\2\u0268\u0269\7\61\2\2\u0269\u026d\3\2\2\2\u026a\u026c\n"+
		"\3\2\2\u026b\u026a\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026d"+
		"\u026e\3\2\2\2\u026e\u0271\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u025c\3\2"+
		"\2\2\u0270\u0267\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\bK\2\2\u0273"+
		"\u0096\3\2\2\2\u0274\u0275\7\f\2\2\u0275\u0098\3\2\2\2\u0276\u0278\t\4"+
		"\2\2\u0277\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u0277\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\bM\3\2\u027c\u009a\3\2"+
		"\2\2\u027d\u027e\t\5\2\2\u027e\u009c\3\2\2\2\u027f\u0280\7^\2\2\u0280"+
		"\u0281\7w\2\2\u0281\u0282\3\2\2\2\u0282\u0283\5\u009bN\2\u0283\u0284\5"+
		"\u009bN\2\u0284\u0285\5\u009bN\2\u0285\u0286\5\u009bN\2\u0286\u009e\3"+
		"\2\2\2\u0287\u0288\t\22\2\2\u0288\u00a0\3\2\2\2\u0289\u028a\t\23\2\2\u028a"+
		"\u00a2\3\2\2\2\u028b\u028f\5\u009fP\2\u028c\u028f\5\u00a1Q\2\u028d\u028f"+
		"\t\24\2\2\u028e\u028b\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028d\3\2\2\2"+
		"\u028f\u00a4\3\2\2\2\u0290\u0291\t\6\2\2\u0291\u00a6\3\2\2\2\u0292\u0293"+
		"\t\7\2\2\u0293\u00a8\3\2\2\2\u0294\u0295\t\b\2\2\u0295\u00aa\3\2\2\2\u0296"+
		"\u0297\7^\2\2\u0297\u0298\t\t\2\2\u0298\u00ac\3\2\2\2\u0299\u029a\t\n"+
		"\2\2\u029a\u00ae\3\2\2\2\u029b\u029c\t\13\2\2\u029c\u00b0\3\2\2\2\u029d"+
		"\u02a0\5\u00a3R\2\u029e\u02a0\5\u00adW\2\u029f\u029d\3\2\2\2\u029f\u029e"+
		"\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2"+
		"\u02a6\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a5\7a\2\2\u02a5\u02a7\5\u0081"+
		"A\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u00b2\3\2\2\2\u02a8"+
		"\u02b1\7\62\2\2\u02a9\u02ad\5\u00afX\2\u02aa\u02ac\5\u00adW\2\u02ab\u02aa"+
		"\3\2\2\2\u02ac\u02af\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae"+
		"\u02b1\3\2\2\2\u02af\u02ad\3\2\2\2\u02b0\u02a8\3\2\2\2\u02b0\u02a9\3\2"+
		"\2\2\u02b1\u00b4\3\2\2\2\u02b2\u02b3\7\62\2\2\u02b3\u02b5\t\f\2\2\u02b4"+
		"\u02b6\5\u009bN\2\u02b5\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b5"+
		"\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u00b6\3\2\2\2\u02b9\u02bb\t\r\2\2\u02ba"+
		"\u02bc\t\16\2\2\u02bb\u02ba\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02be\3"+
		"\2\2\2\u02bd\u02bf\5\u00adW\2\u02be\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2"+
		"\u02c0\u02be\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u00b8\3\2\2\2\u02c2\u02c3"+
		"\t\17\2\2\u02c3\u00ba\3\2\2\2\u02c4\u02c5\t\20\2\2\u02c5\u00bc\3\2\2\2"+
		"\u02c6\u02ca\5\u00c1a\2\u02c7\u02ca\5\u009dO\2\u02c8\u02ca\5\u00abV\2"+
		"\u02c9\u02c6\3\2\2\2\u02c9\u02c7\3\2\2\2\u02c9\u02c8\3\2\2\2\u02ca\u00be"+
		"\3\2\2\2\u02cb\u02cd\7$\2\2\u02cc\u02cb\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd"+
		"\u02cf\3\2\2\2\u02ce\u02d0\7$\2\2\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3\2"+
		"\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d3\5\u00a9U\2\u02d2\u02cc\3\2\2\2\u02d3"+
		"\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02da\3\2"+
		"\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d9\7$\2\2\u02d8\u02d7\3\2\2\2\u02d9"+
		"\u02dc\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u00c0\3\2"+
		"\2\2\u02dc\u02da\3\2\2\2\u02dd\u02de\t\21\2\2\u02de\u00c2\3\2\2\2,\2\u01e1"+
		"\u01e8\u01ea\u01ee\u01f8\u01fc\u01ff\u0204\u020a\u020d\u0210\u0216\u0219"+
		"\u021c\u0221\u0225\u022a\u022d\u0231\u023c\u0242\u024a\u0257\u0262\u026d"+
		"\u0270\u0279\u028e\u029f\u02a1\u02a6\u02ad\u02b0\u02b7\u02bb\u02c0\u02c9"+
		"\u02cc\u02cf\u02d4\u02da\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}