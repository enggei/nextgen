// Generated from LexBasic.g4 by ANTLR 4.7
package org.antlr.parser.st4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LexBasic extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();

	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Ws", "Hws", "Vws", "DocComment", "BlockComment", "LineComment", "LineCommentExt", 
		"EscSeq", "EscAny", "UnicodeEsc", "OctalEscape", "HexNumeral", "OctalNumeral", 
		"DecimalNumeral", "BinaryNumeral", "HexDigits", "DecDigits", "OctalDigits", 
		"BinaryDigits", "HexDigit", "DecDigit", "OctalDigit", "BinaryDigit", "BoolLiteral", 
		"CharLiteral", "SQuoteLiteral", "DQuoteLiteral", "USQuoteLiteral", "DecimalFloatingPointLiteral", 
		"ExponentPart", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", 
		"HexSignificand", "BinaryExponent", "NameChar", "NameStartChar", "JavaLetter", 
		"JavaLetterOrDigit", "JavaUnicodeChars", "Boolean", "Byte", "Short", "Int", 
		"Long", "Char", "Float", "Double", "True", "False", "Esc", "Colon", "DColon", 
		"SQuote", "DQuote", "BQuote", "LParen", "RParen", "LBrace", "RBrace", 
		"LBrack", "RBrack", "RArrow", "Lt", "Gt", "Lte", "Gte", "Equal", "NotEqual", 
		"Question", "Bang", "Star", "Slash", "Percent", "Caret", "Plus", "Minus", 
		"PlusAssign", "MinusAssign", "MulAssign", "DivAssign", "AndAssign", "OrAssign", 
		"XOrAssign", "ModAssign", "LShiftAssign", "RShiftAssign", "URShiftAssign", 
		"Underscore", "Pipe", "Amp", "And", "Or", "Inc", "Dec", "LShift", "RShift", 
		"Dollar", "Comma", "Semi", "Dot", "Range", "Ellipsis", "At", "Pound", 
		"Tilde", "UnicodeLetter", "UnicodeClass_LU", "UnicodeClass_LL", "UnicodeClass_LT", 
		"UnicodeClass_LM", "UnicodeClass_LO", "UnicodeDigit"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
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


	public LexBasic(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LexBasic.g4"; }

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

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 38:
			return JavaUnicodeChars_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean JavaUnicodeChars_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return Character.isJavaIdentifierPart(_input.LA(-1));
		case 1:
			return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\2\u02d7\b\1\4\2\t"+
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
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\3\2\3\2\5\2\u00e6\n\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5\u00f1\n\5\f\5\16\5\u00f4\13\5\3\5\3\5\3"+
		"\5\5\5\u00f9\n\5\3\6\3\6\3\6\3\6\7\6\u00ff\n\6\f\6\16\6\u0102\13\6\3\6"+
		"\3\6\3\6\5\6\u0107\n\6\3\7\3\7\3\7\3\7\7\7\u010d\n\7\f\7\16\7\u0110\13"+
		"\7\3\b\3\b\3\b\3\b\7\b\u0116\n\b\f\b\16\b\u0119\13\b\3\b\3\b\7\b\u011d"+
		"\n\b\f\b\16\b\u0120\13\b\3\b\3\b\3\b\3\b\7\b\u0126\n\b\f\b\16\b\u0129"+
		"\13\b\7\b\u012b\n\b\f\b\16\b\u012e\13\b\3\t\3\t\3\t\3\t\3\t\5\t\u0135"+
		"\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u013f\n\13\5\13\u0141\n"+
		"\13\5\13\u0143\n\13\5\13\u0145\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u014f\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u015c"+
		"\n\17\f\17\16\17\u015f\13\17\5\17\u0161\n\17\3\20\3\20\3\20\3\20\3\21"+
		"\6\21\u0168\n\21\r\21\16\21\u0169\3\22\6\22\u016d\n\22\r\22\16\22\u016e"+
		"\3\23\6\23\u0172\n\23\r\23\16\23\u0173\3\24\6\24\u0177\n\24\r\24\16\24"+
		"\u0178\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\5\31\u0185\n"+
		"\31\3\32\3\32\3\32\5\32\u018a\n\32\3\32\3\32\3\33\3\33\3\33\7\33\u0191"+
		"\n\33\f\33\16\33\u0194\13\33\3\33\3\33\3\34\3\34\3\34\7\34\u019b\n\34"+
		"\f\34\16\34\u019e\13\34\3\34\3\34\3\35\3\35\3\35\7\35\u01a5\n\35\f\35"+
		"\16\35\u01a8\13\35\3\36\3\36\3\36\5\36\u01ad\n\36\3\36\5\36\u01b0\n\36"+
		"\3\36\5\36\u01b3\n\36\3\36\3\36\3\36\5\36\u01b8\n\36\3\36\5\36\u01bb\n"+
		"\36\3\36\3\36\3\36\5\36\u01c0\n\36\3\36\3\36\3\36\5\36\u01c5\n\36\3\37"+
		"\3\37\5\37\u01c9\n\37\3\37\3\37\3 \3 \3!\3!\3!\5!\u01d2\n!\3\"\3\"\5\""+
		"\u01d6\n\"\3\"\3\"\3\"\5\"\u01db\n\"\3\"\3\"\3\"\5\"\u01e0\n\"\3#\3#\5"+
		"#\u01e4\n#\3#\3#\3$\3$\3$\3$\5$\u01ec\n$\3%\3%\3&\3&\5&\u01f2\n&\3\'\3"+
		"\'\5\'\u01f6\n\'\3(\3(\3(\3(\3(\5(\u01fd\n(\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		"*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3"+
		".\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3"+
		">\3?\3?\3?\3@\3@\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3E\3E\3E\3F\3F\3G\3G\3"+
		"H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3P\3Q\3Q\3"+
		"Q\3R\3R\3R\3S\3S\3S\3T\3T\3T\3U\3U\3U\3V\3V\3V\3V\3W\3W\3W\3W\3X\3X\3"+
		"X\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3\\\3]\3]\3]\3^\3^\3^\3_\3_\3_\3`\3"+
		"`\3`\3a\3a\3a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3f\3g\3g\3g\3g\3h\3h\3i\3"+
		"i\3j\3j\3k\3k\3k\3k\3k\5k\u02ca\nk\3l\3l\3m\3m\3n\3n\3o\3o\3p\3p\3q\3"+
		"q\4\u00f2\u0100\2r\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31"+
		"\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2="+
		"\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k"+
		"\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089"+
		"\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b"+
		"\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad"+
		"\2\u00af\2\u00b1\2\u00b3\2\u00b5\2\u00b7\2\u00b9\2\u00bb\2\u00bd\2\u00bf"+
		"\2\u00c1\2\u00c3\2\u00c5\2\u00c7\2\u00c9\2\u00cb\2\u00cd\2\u00cf\2\u00d1"+
		"\2\u00d3\2\u00d5\2\u00d7\2\u00d9\2\u00db\2\u00dd\2\u00df\2\u00e1\2\3\2"+
		"\"\4\2\13\13\"\"\4\2\f\f\16\17\4\2\f\f\17\17\3\2\f\f\n\2$$))^^ddhhppt"+
		"tvv\3\2\62\65\4\2ZZzz\3\2\63;\4\2DDdd\5\2\62;CHch\3\2\62;\3\2\629\3\2"+
		"\62\63\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\4\2GGgg\4\2--//\6\2FFHHffh"+
		"h\4\2RRrr\5\2\u00b9\u00b9\u0302\u0371\u2041\u2042\17\2C\\c|\u00c2\u00d8"+
		"\u00da\u00f8\u00fa\u0301\u0372\u037f\u0381\u2001\u200e\u200f\u2072\u2191"+
		"\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff\6\2&&C\\aac|\7\2&&\62"+
		";C\\aac|\4\2\2\u0101\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001T\2C\\"+
		"\u00c2\u00d8\u00da\u00e0\u0102\u0138\u013b\u0149\u014c\u017f\u0183\u0184"+
		"\u0186\u018d\u0190\u0193\u0195\u0196\u0198\u019a\u019e\u019f\u01a1\u01a2"+
		"\u01a4\u01ab\u01ae\u01b5\u01b7\u01be\u01c6\u01cf\u01d1\u01dd\u01e0\u01f0"+
		"\u01f3\u01f6\u01f8\u01fa\u01fc\u0234\u023c\u023d\u023f\u0240\u0243\u0248"+
		"\u024a\u0250\u0372\u0374\u0378\u0381\u0388\u038c\u038e\u03a3\u03a5\u03ad"+
		"\u03d1\u03d6\u03da\u03f0\u03f6\u03f9\u03fb\u03fc\u03ff\u0431\u0462\u0482"+
		"\u048c\u04cf\u04d2\u0530\u0533\u0558\u10a2\u10c7\u10c9\u10cf\u1e02\u1e96"+
		"\u1ea0\u1f00\u1f0a\u1f11\u1f1a\u1f1f\u1f2a\u1f31\u1f3a\u1f41\u1f4a\u1f4f"+
		"\u1f5b\u1f61\u1f6a\u1f71\u1fba\u1fbd\u1fca\u1fcd\u1fda\u1fdd\u1fea\u1fee"+
		"\u1ffa\u1ffd\u2104\u2109\u210d\u210f\u2112\u2114\u2117\u211f\u2126\u212f"+
		"\u2132\u2135\u2140\u2141\u2147\u2185\u2c02\u2c30\u2c62\u2c66\u2c69\u2c72"+
		"\u2c74\u2c77\u2c80\u2c82\u2c84\u2ce4\u2ced\u2cef\u2cf4\ua642\ua644\ua66e"+
		"\ua682\ua69c\ua724\ua730\ua734\ua770\ua77b\ua788\ua78d\ua78f\ua792\ua794"+
		"\ua798\ua7af\ua7b2\ua7b3\uff23\uff3cS\2c|\u00b7\u00f8\u00fa\u0101\u0103"+
		"\u0179\u017c\u0182\u0185\u0187\u018a\u0194\u0197\u019d\u01a0\u01a3\u01a5"+
		"\u01a7\u01aa\u01af\u01b2\u01b6\u01b8\u01c1\u01c8\u01ce\u01d0\u01f5\u01f7"+
		"\u01fb\u01fd\u023b\u023e\u0244\u0249\u0295\u0297\u02b1\u0373\u0375\u0379"+
		"\u037f\u0392\u03d0\u03d2\u03d3\u03d7\u03d9\u03db\u03f5\u03f7\u0461\u0463"+
		"\u0483\u048d\u04c1\u04c4\u0531\u0563\u0589\u1d02\u1d2d\u1d6d\u1d79\u1d7b"+
		"\u1d9c\u1e03\u1e9f\u1ea1\u1f09\u1f12\u1f17\u1f22\u1f29\u1f32\u1f39\u1f42"+
		"\u1f47\u1f52\u1f59\u1f62\u1f69\u1f72\u1f7f\u1f82\u1f89\u1f92\u1f99\u1fa2"+
		"\u1fa9\u1fb2\u1fb6\u1fb8\u1fb9\u1fc0\u1fc6\u1fc8\u1fc9\u1fd2\u1fd5\u1fd8"+
		"\u1fd9\u1fe2\u1fe9\u1ff4\u1ff6\u1ff8\u1ff9\u210c\u2115\u2131\u213b\u213e"+
		"\u213f\u2148\u214b\u2150\u2186\u2c32\u2c60\u2c63\u2c6e\u2c73\u2c7d\u2c83"+
		"\u2cee\u2cf0\u2cf5\u2d02\u2d27\u2d29\u2d2f\ua643\ua66f\ua683\ua69d\ua725"+
		"\ua733\ua735\ua77a\ua77c\ua77e\ua781\ua789\ua78e\ua790\ua793\ua797\ua799"+
		"\ua7ab\ua7fc\uab5c\uab66\uab67\ufb02\ufb08\ufb15\ufb19\uff43\uff5c\b\2"+
		"\u01c7\u01cd\u01f4\u1f91\u1f9a\u1fa1\u1faa\u1fb1\u1fbe\u1fce\u1ffe\u1ffe"+
		"#\2\u02b2\u02c3\u02c8\u02d3\u02e2\u02e6\u02ee\u02f0\u0376\u037c\u055b"+
		"\u0642\u06e7\u06e8\u07f6\u07f7\u07fc\u081c\u0826\u082a\u0973\u0e48\u0ec8"+
		"\u10fe\u17d9\u1845\u1aa9\u1c7f\u1d2e\u1d6c\u1d7a\u1dc1\u2073\u2081\u2092"+
		"\u209e\u2c7e\u2c7f\u2d71\u2e31\u3007\u3037\u303d\u3100\ua017\ua4ff\ua60e"+
		"\ua681\ua69e\ua69f\ua719\ua721\ua772\ua78a\ua7fa\ua7fb\ua9d1\ua9e8\uaa72"+
		"\uaadf\uaaf5\uaaf6\uab5e\uab61\uff72\uffa1\u00ec\2\u00ac\u00bc\u01bd\u01c5"+
		"\u0296\u05ec\u05f2\u05f4\u0622\u0641\u0643\u064c\u0670\u0671\u0673\u06d5"+
		"\u06d7\u06fe\u0701\u0712\u0714\u0731\u074f\u07a7\u07b3\u07ec\u0802\u0817"+
		"\u0842\u085a\u08a2\u08b4\u0906\u093b\u093f\u0952\u095a\u0963\u0974\u0982"+
		"\u0987\u098e\u0991\u0992\u0995\u09aa\u09ac\u09b2\u09b4\u09bb\u09bf\u09d0"+
		"\u09de\u09df\u09e1\u09e3\u09f2\u09f3\u0a07\u0a0c\u0a11\u0a12\u0a15\u0a2a"+
		"\u0a2c\u0a32\u0a34\u0a35\u0a37\u0a38\u0a3a\u0a3b\u0a5b\u0a5e\u0a60\u0a76"+
		"\u0a87\u0a8f\u0a91\u0a93\u0a95\u0aaa\u0aac\u0ab2\u0ab4\u0ab5\u0ab7\u0abb"+
		"\u0abf\u0ad2\u0ae2\u0ae3\u0b07\u0b0e\u0b11\u0b12\u0b15\u0b2a\u0b2c\u0b32"+
		"\u0b34\u0b35\u0b37\u0b3b\u0b3f\u0b63\u0b73\u0b85\u0b87\u0b8c\u0b90\u0b92"+
		"\u0b94\u0b97\u0b9b\u0b9c\u0b9e\u0bac\u0bb0\u0bbb\u0bd2\u0c0e\u0c10\u0c12"+
		"\u0c14\u0c2a\u0c2c\u0c3b\u0c3f\u0c8e\u0c90\u0c92\u0c94\u0caa\u0cac\u0cb5"+
		"\u0cb7\u0cbb\u0cbf\u0ce0\u0ce2\u0ce3\u0cf3\u0cf4\u0d07\u0d0e\u0d10\u0d12"+
		"\u0d14\u0d3c\u0d3f\u0d50\u0d62\u0d63\u0d7c\u0d81\u0d87\u0d98\u0d9c\u0db3"+
		"\u0db5\u0dbd\u0dbf\u0dc8\u0e03\u0e32\u0e34\u0e35\u0e42\u0e47\u0e83\u0e84"+
		"\u0e86\u0e8c\u0e8f\u0e99\u0e9b\u0ea1\u0ea3\u0ea5\u0ea7\u0ea9\u0eac\u0ead"+
		"\u0eaf\u0eb2\u0eb4\u0eb5\u0ebf\u0ec6\u0ede\u0ee1\u0f02\u0f49\u0f4b\u0f6e"+
		"\u0f8a\u0f8e\u1002\u102c\u1041\u1057\u105c\u105f\u1063\u1072\u1077\u1083"+
		"\u1090\u10fc\u10ff\u124a\u124c\u124f\u1252\u1258\u125a\u125f\u1262\u128a"+
		"\u128c\u128f\u1292\u12b2\u12b4\u12b7\u12ba\u12c0\u12c2\u12c7\u12ca\u12d8"+
		"\u12da\u1312\u1314\u1317\u131a\u135c\u1382\u1391\u13a2\u13f6\u1403\u166e"+
		"\u1671\u1681\u1683\u169c\u16a2\u16ec\u16f3\u16fa\u1702\u170e\u1710\u1713"+
		"\u1722\u1733\u1742\u1753\u1762\u176e\u1770\u1772\u1782\u17b5\u17de\u1844"+
		"\u1846\u1879\u1882\u18aa\u18ac\u18f7\u1902\u1920\u1952\u196f\u1972\u1976"+
		"\u1982\u19ad\u19c3\u19c9\u1a02\u1a18\u1a22\u1a56\u1b07\u1b35\u1b47\u1b4d"+
		"\u1b85\u1ba2\u1bb0\u1bb1\u1bbc\u1be7\u1c02\u1c25\u1c4f\u1c51\u1c5c\u1c79"+
		"\u1ceb\u1cee\u1cf0\u1cf3\u1cf7\u1cf8\u2137\u213a\u2d32\u2d69\u2d82\u2d98"+
		"\u2da2\u2da8\u2daa\u2db0\u2db2\u2db8\u2dba\u2dc0\u2dc2\u2dc8\u2dca\u2dd0"+
		"\u2dd2\u2dd8\u2dda\u2de0\u3008\u303e\u3043\u3098\u30a1\u30fc\u3101\u312f"+
		"\u3133\u3190\u31a2\u31bc\u31f2\u3201\u3402\u4db7\u4e02\u9fce\ua002\ua016"+
		"\ua018\ua48e\ua4d2\ua4f9\ua502\ua60d\ua612\ua621\ua62c\ua62d\ua670\ua6e7"+
		"\ua7f9\ua803\ua805\ua807\ua809\ua80c\ua80e\ua824\ua842\ua875\ua884\ua8b5"+
		"\ua8f4\ua8f9\ua8fd\ua927\ua932\ua948\ua962\ua97e\ua986\ua9b4\ua9e2\ua9e6"+
		"\ua9e9\ua9f1\ua9fc\uaa00\uaa02\uaa2a\uaa42\uaa44\uaa46\uaa4d\uaa62\uaa71"+
		"\uaa73\uaa78\uaa7c\uaab1\uaab3\uaabf\uaac2\uaac4\uaadd\uaade\uaae2\uaaec"+
		"\uaaf4\uab08\uab0b\uab10\uab13\uab18\uab22\uab28\uab2a\uab30\uabc2\uabe4"+
		"\uac02\ud7a5\ud7b2\ud7c8\ud7cd\ud7fd\uf902\ufa6f\ufa72\ufadb\ufb1f\ufb2a"+
		"\ufb2c\ufb38\ufb3a\ufb3e\ufb40\ufbb3\ufbd5\ufd3f\ufd52\ufd91\ufd94\ufdc9"+
		"\ufdf2\ufdfd\ufe72\ufe76\ufe78\ufefe\uff68\uff71\uff73\uff9f\uffa2\uffc0"+
		"\uffc4\uffc9\uffcc\uffd1\uffd4\uffd9\uffdc\uffde\'\2\62;\u0662\u066b\u06f2"+
		"\u06fb\u07c2\u07cb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68"+
		"\u0b71\u0be8\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0de8\u0df1\u0e52"+
		"\u0e5b\u0ed2\u0edb\u0f22\u0f2b\u1042\u104b\u1092\u109b\u17e2\u17eb\u1812"+
		"\u181b\u1948\u1951\u19d2\u19db\u1a82\u1a8b\u1a92\u1a9b\u1b52\u1b5b\u1bb2"+
		"\u1bbb\u1c42\u1c4b\u1c52\u1c5b\ua622\ua62b\ua8d2\ua8db\ua902\ua90b\ua9d2"+
		"\ua9db\ua9f2\ua9fb\uaa52\uaa5b\uabf2\uabfb\uff12\uff1b\2\u02a0\3\u00e5"+
		"\3\2\2\2\5\u00e7\3\2\2\2\7\u00e9\3\2\2\2\t\u00eb\3\2\2\2\13\u00fa\3\2"+
		"\2\2\r\u0108\3\2\2\2\17\u0111\3\2\2\2\21\u012f\3\2\2\2\23\u0136\3\2\2"+
		"\2\25\u0139\3\2\2\2\27\u014e\3\2\2\2\31\u0150\3\2\2\2\33\u0154\3\2\2\2"+
		"\35\u0160\3\2\2\2\37\u0162\3\2\2\2!\u0167\3\2\2\2#\u016c\3\2\2\2%\u0171"+
		"\3\2\2\2\'\u0176\3\2\2\2)\u017a\3\2\2\2+\u017c\3\2\2\2-\u017e\3\2\2\2"+
		"/\u0180\3\2\2\2\61\u0184\3\2\2\2\63\u0186\3\2\2\2\65\u018d\3\2\2\2\67"+
		"\u0197\3\2\2\29\u01a1\3\2\2\2;\u01c4\3\2\2\2=\u01c6\3\2\2\2?\u01cc\3\2"+
		"\2\2A\u01ce\3\2\2\2C\u01df\3\2\2\2E\u01e1\3\2\2\2G\u01eb\3\2\2\2I\u01ed"+
		"\3\2\2\2K\u01f1\3\2\2\2M\u01f5\3\2\2\2O\u01fc\3\2\2\2Q\u01fe\3\2\2\2S"+
		"\u0206\3\2\2\2U\u020b\3\2\2\2W\u0211\3\2\2\2Y\u0215\3\2\2\2[\u021a\3\2"+
		"\2\2]\u021f\3\2\2\2_\u0225\3\2\2\2a\u022c\3\2\2\2c\u0231\3\2\2\2e\u0237"+
		"\3\2\2\2g\u0239\3\2\2\2i\u023b\3\2\2\2k\u023e\3\2\2\2m\u0240\3\2\2\2o"+
		"\u0242\3\2\2\2q\u0244\3\2\2\2s\u0246\3\2\2\2u\u0248\3\2\2\2w\u024a\3\2"+
		"\2\2y\u024c\3\2\2\2{\u024e\3\2\2\2}\u0250\3\2\2\2\177\u0253\3\2\2\2\u0081"+
		"\u0255\3\2\2\2\u0083\u0257\3\2\2\2\u0085\u025a\3\2\2\2\u0087\u025d\3\2"+
		"\2\2\u0089\u025f\3\2\2\2\u008b\u0262\3\2\2\2\u008d\u0264\3\2\2\2\u008f"+
		"\u0266\3\2\2\2\u0091\u0268\3\2\2\2\u0093\u026a\3\2\2\2\u0095\u026c\3\2"+
		"\2\2\u0097\u026e\3\2\2\2\u0099\u0270\3\2\2\2\u009b\u0272\3\2\2\2\u009d"+
		"\u0275\3\2\2\2\u009f\u0278\3\2\2\2\u00a1\u027b\3\2\2\2\u00a3\u027e\3\2"+
		"\2\2\u00a5\u0281\3\2\2\2\u00a7\u0284\3\2\2\2\u00a9\u0287\3\2\2\2\u00ab"+
		"\u028a\3\2\2\2\u00ad\u028e\3\2\2\2\u00af\u0292\3\2\2\2\u00b1\u0297\3\2"+
		"\2\2\u00b3\u0299\3\2\2\2\u00b5\u029b\3\2\2\2\u00b7\u029d\3\2\2\2\u00b9"+
		"\u02a0\3\2\2\2\u00bb\u02a3\3\2\2\2\u00bd\u02a6\3\2\2\2\u00bf\u02a9\3\2"+
		"\2\2\u00c1\u02ac\3\2\2\2\u00c3\u02af\3\2\2\2\u00c5\u02b1\3\2\2\2\u00c7"+
		"\u02b3\3\2\2\2\u00c9\u02b5\3\2\2\2\u00cb\u02b7\3\2\2\2\u00cd\u02ba\3\2"+
		"\2\2\u00cf\u02be\3\2\2\2\u00d1\u02c0\3\2\2\2\u00d3\u02c2\3\2\2\2\u00d5"+
		"\u02c9\3\2\2\2\u00d7\u02cb\3\2\2\2\u00d9\u02cd\3\2\2\2\u00db\u02cf\3\2"+
		"\2\2\u00dd\u02d1\3\2\2\2\u00df\u02d3\3\2\2\2\u00e1\u02d5\3\2\2\2\u00e3"+
		"\u00e6\5\5\3\2\u00e4\u00e6\5\7\4\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e6\4\3\2\2\2\u00e7\u00e8\t\2\2\2\u00e8\6\3\2\2\2\u00e9\u00ea\t"+
		"\3\2\2\u00ea\b\3\2\2\2\u00eb\u00ec\7\61\2\2\u00ec\u00ed\7,\2\2\u00ed\u00ee"+
		"\7,\2\2\u00ee\u00f2\3\2\2\2\u00ef\u00f1\13\2\2\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f8\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6\u00f9\7\61\2\2\u00f7"+
		"\u00f9\7\2\2\3\u00f8\u00f5\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\n\3\2\2\2"+
		"\u00fa\u00fb\7\61\2\2\u00fb\u00fc\7,\2\2\u00fc\u0100\3\2\2\2\u00fd\u00ff"+
		"\13\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u0101\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0101\u0106\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104"+
		"\7,\2\2\u0104\u0107\7\61\2\2\u0105\u0107\7\2\2\3\u0106\u0103\3\2\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\f\3\2\2\2\u0108\u0109\7\61\2\2\u0109\u010a\7\61\2"+
		"\2\u010a\u010e\3\2\2\2\u010b\u010d\n\4\2\2\u010c\u010b\3\2\2\2\u010d\u0110"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\16\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111\u0112\7\61\2\2\u0112\u0113\7\61\2\2\u0113\u0117\3"+
		"\2\2\2\u0114\u0116\n\5\2\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u012c\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u011a\u011e\7\f\2\2\u011b\u011d\5\5\3\2\u011c\u011b\3\2\2\2\u011d"+
		"\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\61\2\2\u0122\u0123\7\61\2\2\u0123"+
		"\u0127\3\2\2\2\u0124\u0126\n\5\2\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2"+
		"\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012b\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u012a\u011a\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\20\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0134"+
		"\5e\63\2\u0130\u0135\t\6\2\2\u0131\u0135\5\25\13\2\u0132\u0135\13\2\2"+
		"\2\u0133\u0135\7\2\2\3\u0134\u0130\3\2\2\2\u0134\u0131\3\2\2\2\u0134\u0132"+
		"\3\2\2\2\u0134\u0133\3\2\2\2\u0135\22\3\2\2\2\u0136\u0137\5e\63\2\u0137"+
		"\u0138\13\2\2\2\u0138\24\3\2\2\2\u0139\u0144\7w\2\2\u013a\u0142\5)\25"+
		"\2\u013b\u0140\5)\25\2\u013c\u013e\5)\25\2\u013d\u013f\5)\25\2\u013e\u013d"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013c\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u013b\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\u0145\3\2\2\2\u0144\u013a\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\26\3\2\2\2\u0146\u014f\5-\27\2\u0147\u0148\5-\27\2\u0148\u0149\5-\27"+
		"\2\u0149\u014f\3\2\2\2\u014a\u014b\t\7\2\2\u014b\u014c\5-\27\2\u014c\u014d"+
		"\5-\27\2\u014d\u014f\3\2\2\2\u014e\u0146\3\2\2\2\u014e\u0147\3\2\2\2\u014e"+
		"\u014a\3\2\2\2\u014f\30\3\2\2\2\u0150\u0151\7\62\2\2\u0151\u0152\t\b\2"+
		"\2\u0152\u0153\5!\21\2\u0153\32\3\2\2\2\u0154\u0155\7\62\2\2\u0155\u0156"+
		"\7a\2\2\u0156\u0157\5%\23\2\u0157\34\3\2\2\2\u0158\u0161\7\62\2\2\u0159"+
		"\u015d\t\t\2\2\u015a\u015c\5+\26\2\u015b\u015a\3\2\2\2\u015c\u015f\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0161\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u0160\u0158\3\2\2\2\u0160\u0159\3\2\2\2\u0161\36\3\2\2"+
		"\2\u0162\u0163\7\62\2\2\u0163\u0164\t\n\2\2\u0164\u0165\5\'\24\2\u0165"+
		" \3\2\2\2\u0166\u0168\5)\25\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2"+
		"\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\"\3\2\2\2\u016b\u016d\5"+
		"+\26\2\u016c\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f$\3\2\2\2\u0170\u0172\5-\27\2\u0171\u0170\3\2\2\2"+
		"\u0172\u0173\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174&\3"+
		"\2\2\2\u0175\u0177\5/\30\2\u0176\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179(\3\2\2\2\u017a\u017b\t\13\2\2"+
		"\u017b*\3\2\2\2\u017c\u017d\t\f\2\2\u017d,\3\2\2\2\u017e\u017f\t\r\2\2"+
		"\u017f.\3\2\2\2\u0180\u0181\t\16\2\2\u0181\60\3\2\2\2\u0182\u0185\5a\61"+
		"\2\u0183\u0185\5c\62\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185\62"+
		"\3\2\2\2\u0186\u0189\5k\66\2\u0187\u018a\5\21\t\2\u0188\u018a\n\17\2\2"+
		"\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c"+
		"\5k\66\2\u018c\64\3\2\2\2\u018d\u0192\5k\66\2\u018e\u0191\5\21\t\2\u018f"+
		"\u0191\n\17\2\2\u0190\u018e\3\2\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3"+
		"\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194"+
		"\u0192\3\2\2\2\u0195\u0196\5k\66\2\u0196\66\3\2\2\2\u0197\u019c\5m\67"+
		"\2\u0198\u019b\5\21\t\2\u0199\u019b\n\20\2\2\u019a\u0198\3\2\2\2\u019a"+
		"\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2"+
		"\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01a0\5m\67\2\u01a0"+
		"8\3\2\2\2\u01a1\u01a6\5k\66\2\u01a2\u01a5\5\21\t\2\u01a3\u01a5\n\17\2"+
		"\2\u01a4\u01a2\3\2\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4"+
		"\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7:\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9"+
		"\u01aa\5#\22\2\u01aa\u01ac\5\u00c9e\2\u01ab\u01ad\5#\22\2\u01ac\u01ab"+
		"\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae\u01b0\5=\37\2\u01af"+
		"\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01b3\5?"+
		" \2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01c5\3\2\2\2\u01b4"+
		"\u01b5\5\u00c9e\2\u01b5\u01b7\5#\22\2\u01b6\u01b8\5=\37\2\u01b7\u01b6"+
		"\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2\2\2\u01b9\u01bb\5? \2\u01ba"+
		"\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01c5\3\2\2\2\u01bc\u01bd\5#"+
		"\22\2\u01bd\u01bf\5=\37\2\u01be\u01c0\5? \2\u01bf\u01be\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01c5\3\2\2\2\u01c1\u01c2\5#\22\2\u01c2\u01c3\5?"+
		" \2\u01c3\u01c5\3\2\2\2\u01c4\u01a9\3\2\2\2\u01c4\u01b4\3\2\2\2\u01c4"+
		"\u01bc\3\2\2\2\u01c4\u01c1\3\2\2\2\u01c5<\3\2\2\2\u01c6\u01c8\t\21\2\2"+
		"\u01c7\u01c9\t\22\2\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01ca\u01cb\5#\22\2\u01cb>\3\2\2\2\u01cc\u01cd\t\23\2\2\u01cd"+
		"@\3\2\2\2\u01ce\u01cf\5C\"\2\u01cf\u01d1\5E#\2\u01d0\u01d2\5? \2\u01d1"+
		"\u01d0\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2B\3\2\2\2\u01d3\u01d5\5\31\r\2"+
		"\u01d4\u01d6\5\u00c9e\2\u01d5\u01d4\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u01e0\3\2\2\2\u01d7\u01d8\7\62\2\2\u01d8\u01da\t\b\2\2\u01d9\u01db\5"+
		"!\21\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01dd\5\u00c9e\2\u01dd\u01de\5!\21\2\u01de\u01e0\3\2\2\2\u01df\u01d3"+
		"\3\2\2\2\u01df\u01d7\3\2\2\2\u01e0D\3\2\2\2\u01e1\u01e3\t\24\2\2\u01e2"+
		"\u01e4\t\22\2\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3"+
		"\2\2\2\u01e5\u01e6\5#\22\2\u01e6F\3\2\2\2\u01e7\u01ec\5I%\2\u01e8\u01ec"+
		"\4\62;\2\u01e9\u01ec\5\u00b1Y\2\u01ea\u01ec\t\25\2\2\u01eb\u01e7\3\2\2"+
		"\2\u01eb\u01e8\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ea\3\2\2\2\u01ecH"+
		"\3\2\2\2\u01ed\u01ee\t\26\2\2\u01eeJ\3\2\2\2\u01ef\u01f2\t\27\2\2\u01f0"+
		"\u01f2\5O(\2\u01f1\u01ef\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2L\3\2\2\2\u01f3"+
		"\u01f6\t\30\2\2\u01f4\u01f6\5O(\2\u01f5\u01f3\3\2\2\2\u01f5\u01f4\3\2"+
		"\2\2\u01f6N\3\2\2\2\u01f7\u01f8\n\31\2\2\u01f8\u01fd\6(\2\2\u01f9\u01fa"+
		"\t\32\2\2\u01fa\u01fb\t\33\2\2\u01fb\u01fd\6(\3\2\u01fc\u01f7\3\2\2\2"+
		"\u01fc\u01f9\3\2\2\2\u01fdP\3\2\2\2\u01fe\u01ff\7d\2\2\u01ff\u0200\7q"+
		"\2\2\u0200\u0201\7q\2\2\u0201\u0202\7n\2\2\u0202\u0203\7g\2\2\u0203\u0204"+
		"\7c\2\2\u0204\u0205\7p\2\2\u0205R\3\2\2\2\u0206\u0207\7d\2\2\u0207\u0208"+
		"\7{\2\2\u0208\u0209\7v\2\2\u0209\u020a\7g\2\2\u020aT\3\2\2\2\u020b\u020c"+
		"\7u\2\2\u020c\u020d\7j\2\2\u020d\u020e\7q\2\2\u020e\u020f\7t\2\2\u020f"+
		"\u0210\7v\2\2\u0210V\3\2\2\2\u0211\u0212\7k\2\2\u0212\u0213\7p\2\2\u0213"+
		"\u0214\7v\2\2\u0214X\3\2\2\2\u0215\u0216\7n\2\2\u0216\u0217\7q\2\2\u0217"+
		"\u0218\7p\2\2\u0218\u0219\7i\2\2\u0219Z\3\2\2\2\u021a\u021b\7e\2\2\u021b"+
		"\u021c\7j\2\2\u021c\u021d\7c\2\2\u021d\u021e\7t\2\2\u021e\\\3\2\2\2\u021f"+
		"\u0220\7h\2\2\u0220\u0221\7n\2\2\u0221\u0222\7q\2\2\u0222\u0223\7c\2\2"+
		"\u0223\u0224\7v\2\2\u0224^\3\2\2\2\u0225\u0226\7f\2\2\u0226\u0227\7q\2"+
		"\2\u0227\u0228\7w\2\2\u0228\u0229\7d\2\2\u0229\u022a\7n\2\2\u022a\u022b"+
		"\7g\2\2\u022b`\3\2\2\2\u022c\u022d\7v\2\2\u022d\u022e\7t\2\2\u022e\u022f"+
		"\7w\2\2\u022f\u0230\7g\2\2\u0230b\3\2\2\2\u0231\u0232\7h\2\2\u0232\u0233"+
		"\7c\2\2\u0233\u0234\7n\2\2\u0234\u0235\7u\2\2\u0235\u0236\7g\2\2\u0236"+
		"d\3\2\2\2\u0237\u0238\7^\2\2\u0238f\3\2\2\2\u0239\u023a\7<\2\2\u023ah"+
		"\3\2\2\2\u023b\u023c\7<\2\2\u023c\u023d\7<\2\2\u023dj\3\2\2\2\u023e\u023f"+
		"\7)\2\2\u023fl\3\2\2\2\u0240\u0241\7$\2\2\u0241n\3\2\2\2\u0242\u0243\7"+
		"b\2\2\u0243p\3\2\2\2\u0244\u0245\7*\2\2\u0245r\3\2\2\2\u0246\u0247\7+"+
		"\2\2\u0247t\3\2\2\2\u0248\u0249\7}\2\2\u0249v\3\2\2\2\u024a\u024b\7\177"+
		"\2\2\u024bx\3\2\2\2\u024c\u024d\7]\2\2\u024dz\3\2\2\2\u024e\u024f\7_\2"+
		"\2\u024f|\3\2\2\2\u0250\u0251\7/\2\2\u0251\u0252\7@\2\2\u0252~\3\2\2\2"+
		"\u0253\u0254\7>\2\2\u0254\u0080\3\2\2\2\u0255\u0256\7@\2\2\u0256\u0082"+
		"\3\2\2\2\u0257\u0258\7>\2\2\u0258\u0259\7?\2\2\u0259\u0084\3\2\2\2\u025a"+
		"\u025b\7@\2\2\u025b\u025c\7?\2\2\u025c\u0086\3\2\2\2\u025d\u025e\7?\2"+
		"\2\u025e\u0088\3\2\2\2\u025f\u0260\7#\2\2\u0260\u0261\7?\2\2\u0261\u008a"+
		"\3\2\2\2\u0262\u0263\7A\2\2\u0263\u008c\3\2\2\2\u0264\u0265\7#\2\2\u0265"+
		"\u008e\3\2\2\2\u0266\u0267\7,\2\2\u0267\u0090\3\2\2\2\u0268\u0269\7\61"+
		"\2\2\u0269\u0092\3\2\2\2\u026a\u026b\7\'\2\2\u026b\u0094\3\2\2\2\u026c"+
		"\u026d\7`\2\2\u026d\u0096\3\2\2\2\u026e\u026f\7-\2\2\u026f\u0098\3\2\2"+
		"\2\u0270\u0271\7/\2\2\u0271\u009a\3\2\2\2\u0272\u0273\7-\2\2\u0273\u0274"+
		"\7?\2\2\u0274\u009c\3\2\2\2\u0275\u0276\7/\2\2\u0276\u0277\7?\2\2\u0277"+
		"\u009e\3\2\2\2\u0278\u0279\7,\2\2\u0279\u027a\7?\2\2\u027a\u00a0\3\2\2"+
		"\2\u027b\u027c\7\61\2\2\u027c\u027d\7?\2\2\u027d\u00a2\3\2\2\2\u027e\u027f"+
		"\7(\2\2\u027f\u0280\7?\2\2\u0280\u00a4\3\2\2\2\u0281\u0282\7~\2\2\u0282"+
		"\u0283\7?\2\2\u0283\u00a6\3\2\2\2\u0284\u0285\7`\2\2\u0285\u0286\7?\2"+
		"\2\u0286\u00a8\3\2\2\2\u0287\u0288\7\'\2\2\u0288\u0289\7?\2\2\u0289\u00aa"+
		"\3\2\2\2\u028a\u028b\7>\2\2\u028b\u028c\7>\2\2\u028c\u028d\7?\2\2\u028d"+
		"\u00ac\3\2\2\2\u028e\u028f\7@\2\2\u028f\u0290\7@\2\2\u0290\u0291\7?\2"+
		"\2\u0291\u00ae\3\2\2\2\u0292\u0293\7@\2\2\u0293\u0294\7@\2\2\u0294\u0295"+
		"\7@\2\2\u0295\u0296\7?\2\2\u0296\u00b0\3\2\2\2\u0297\u0298\7a\2\2\u0298"+
		"\u00b2\3\2\2\2\u0299\u029a\7~\2\2\u029a\u00b4\3\2\2\2\u029b\u029c\7(\2"+
		"\2\u029c\u00b6\3\2\2\2\u029d\u029e\7(\2\2\u029e\u029f\7(\2\2\u029f\u00b8"+
		"\3\2\2\2\u02a0\u02a1\7~\2\2\u02a1\u02a2\7~\2\2\u02a2\u00ba\3\2\2\2\u02a3"+
		"\u02a4\7-\2\2\u02a4\u02a5\7-\2\2\u02a5\u00bc\3\2\2\2\u02a6\u02a7\7/\2"+
		"\2\u02a7\u02a8\7/\2\2\u02a8\u00be\3\2\2\2\u02a9\u02aa\7>\2\2\u02aa\u02ab"+
		"\7>\2\2\u02ab\u00c0\3\2\2\2\u02ac\u02ad\7@\2\2\u02ad\u02ae\7@\2\2\u02ae"+
		"\u00c2\3\2\2\2\u02af\u02b0\7&\2\2\u02b0\u00c4\3\2\2\2\u02b1\u02b2\7.\2"+
		"\2\u02b2\u00c6\3\2\2\2\u02b3\u02b4\7=\2\2\u02b4\u00c8\3\2\2\2\u02b5\u02b6"+
		"\7\60\2\2\u02b6\u00ca\3\2\2\2\u02b7\u02b8\7\60\2\2\u02b8\u02b9\7\60\2"+
		"\2\u02b9\u00cc\3\2\2\2\u02ba\u02bb\7\60\2\2\u02bb\u02bc\7\60\2\2\u02bc"+
		"\u02bd\7\60\2\2\u02bd\u00ce\3\2\2\2\u02be\u02bf\7B\2\2\u02bf\u00d0\3\2"+
		"\2\2\u02c0\u02c1\7%\2\2\u02c1\u00d2\3\2\2\2\u02c2\u02c3\7\u0080\2\2\u02c3"+
		"\u00d4\3\2\2\2\u02c4\u02ca\5\u00d7l\2\u02c5\u02ca\5\u00d9m\2\u02c6\u02ca"+
		"\5\u00dbn\2\u02c7\u02ca\5\u00ddo\2\u02c8\u02ca\5\u00dfp\2\u02c9\u02c4"+
		"\3\2\2\2\u02c9\u02c5\3\2\2\2\u02c9\u02c6\3\2\2\2\u02c9\u02c7\3\2\2\2\u02c9"+
		"\u02c8\3\2\2\2\u02ca\u00d6\3\2\2\2\u02cb\u02cc\t\34\2\2\u02cc\u00d8\3"+
		"\2\2\2\u02cd\u02ce\t\35\2\2\u02ce\u00da\3\2\2\2\u02cf\u02d0\t\36\2\2\u02d0"+
		"\u00dc\3\2\2\2\u02d1\u02d2\t\37\2\2\u02d2\u00de\3\2\2\2\u02d3\u02d4\t"+
		" \2\2\u02d4\u00e0\3\2\2\2\u02d5\u02d6\t!\2\2\u02d6\u00e2\3\2\2\2\63\2"+
		"\u00e5\u00f2\u00f8\u0100\u0106\u010e\u0117\u011e\u0127\u012c\u0134\u013e"+
		"\u0140\u0142\u0144\u014e\u015d\u0160\u0169\u016e\u0173\u0178\u0184\u0189"+
		"\u0190\u0192\u019a\u019c\u01a4\u01a6\u01ac\u01af\u01b2\u01b7\u01ba\u01bf"+
		"\u01c4\u01c8\u01d1\u01d5\u01da\u01df\u01e3\u01eb\u01f1\u01f5\u01fc\u02c9"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}