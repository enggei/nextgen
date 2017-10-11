// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/scala/parser/Scala.g4 by ANTLR 4.7
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
		T__59=60, T__60=61, BooleanLiteral=62, CharacterLiteral=63, StringLiteral=64, 
		SymbolLiteral=65, IntegerLiteral=66, FloatingPointLiteral=67, Id=68, Varid=69, 
		WhiteSpace=70, Semi=71, Paren=72, Delim=73, Comment=74, LineComment=75, 
		Terminator=76;
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
		"T__57", "T__58", "T__59", "T__60", "BooleanLiteral", "CharacterLiteral", 
		"StringLiteral", "SymbolLiteral", "IntegerLiteral", "FloatingPointLiteral", 
		"Id", "Varid", "WhiteSpace", "Semi", "Paren", "Delim", "Comment", "LineComment", 
		"Terminator", "UnicodeEscape", "Opchar", "Op", "Plainid", "Idrest", "StringElement", 
		"MultiLineChars", "HexDigit", "FloatType", "Upper", "Lower", "Letter", 
		"ExponentPart", "PrintableChar", "CharEscapeSeq", "DecimalNumeral", "HexNumeral", 
		"Digit", "NonZeroDigit"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'-'", "'null'", "'.'", "','", "'this'", "'super'", "'['", "']'", 
		"'=>'", "'('", "')'", "'forSome'", "'{'", "'}'", "'type'", "'val'", "'with'", 
		"'#'", "':'", "'_'", "'*'", "'implicit'", "'if'", "'else'", "'while'", 
		"'try'", "'catch'", "'finally'", "'do'", "'for'", "'yield'", "'throw'", 
		"'return'", "'new'", "'='", "'match'", "'+'", "'~'", "'!'", "'lazy'", 
		"'<-'", "'case'", "'|'", "'@'", "'>:'", "'<:'", "'<%'", "'var'", "'override'", 
		"'abstract'", "'final'", "'sealed'", "'private'", "'protected'", "'import'", 
		"'def'", "'class'", "'object'", "'trait'", "'extends'", "'package'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "BooleanLiteral", "CharacterLiteral", "StringLiteral", "SymbolLiteral", 
		"IntegerLiteral", "FloatingPointLiteral", "Id", "Varid", "WhiteSpace", 
		"Semi", "Paren", "Delim", "Comment", "LineComment", "Terminator"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2N\u02d3\b\1\4\2\t"+
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
		"`\t`\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%\3"+
		"%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+"+
		"\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\39\39\39\39\3:\3:"+
		"\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3="+
		"\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\5?\u01e0\n?"+
		"\3@\3@\3@\5@\u01e5\n@\3@\3@\3A\3A\7A\u01eb\nA\fA\16A\u01ee\13A\3A\3A\3"+
		"A\3A\3A\3A\3A\3A\3A\3A\5A\u01fa\nA\3B\3B\3B\3C\3C\5C\u0201\nC\3C\3C\3"+
		"D\6D\u0206\nD\rD\16D\u0207\3D\3D\6D\u020c\nD\rD\16D\u020d\3D\5D\u0211"+
		"\nD\3D\5D\u0214\nD\3D\3D\6D\u0218\nD\rD\16D\u0219\3D\5D\u021d\nD\3D\5"+
		"D\u0220\nD\3D\3D\3D\5D\u0225\nD\3D\6D\u0228\nD\rD\16D\u0229\3D\5D\u022d"+
		"\nD\3D\3D\5D\u0231\nD\3E\3E\3E\3E\3E\5E\u0238\nE\3F\3F\3F\3G\3G\3G\3G"+
		"\3H\3H\5H\u0243\nH\3I\3I\3J\3J\3K\3K\3K\3K\7K\u024d\nK\fK\16K\u0250\13"+
		"K\3K\3K\3K\3K\3K\3L\3L\3L\3L\7L\u025b\nL\fL\16L\u025e\13L\3L\3L\3M\6M"+
		"\u0263\nM\rM\16M\u0264\3M\3M\3N\3N\3N\5N\u026c\nN\3N\3N\3N\3N\3N\3O\3"+
		"O\3P\6P\u0276\nP\rP\16P\u0277\3Q\3Q\3Q\3Q\5Q\u027e\nQ\3R\3R\7R\u0282\n"+
		"R\fR\16R\u0285\13R\3S\3S\5S\u0289\nS\3T\5T\u028c\nT\3T\5T\u028f\nT\3T"+
		"\7T\u0292\nT\fT\16T\u0295\13T\7T\u0297\nT\fT\16T\u029a\13T\3T\7T\u029d"+
		"\nT\fT\16T\u02a0\13T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\5Y\u02ac\nY\3Z\3Z\5"+
		"Z\u02b0\nZ\3Z\6Z\u02b3\nZ\rZ\16Z\u02b4\3[\3[\3\\\3\\\3\\\3]\3]\3]\7]\u02bf"+
		"\n]\f]\16]\u02c2\13]\5]\u02c4\n]\3^\3^\3^\3^\6^\u02ca\n^\r^\16^\u02cb"+
		"\3_\3_\5_\u02d0\n_\3`\3`\4\u024e\u0293\2a\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095"+
		"L\u0097M\u0099N\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7"+
		"\2\u00a9\2\u00ab\2\u00ad\2\u00af\2\u00b1\2\u00b3\2\u00b5\2\u00b7\2\u00b9"+
		"\2\u00bb\2\u00bd\2\u00bf\2\3\2\16\4\2NNnn\5\2\13\f\17\17\"\"\7\2*+]]_"+
		"_}}\177\177\b\2$$))..\60\60==bb\4\2\f\f\17\17\4\2\"#%\u0081\5\2\62;CH"+
		"ch\6\2FFHHffhh\5\2&&C\\aa\4\2GGgg\4\2--//\n\2$$))^^ddhhppttvv\2\u02e8"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\3\u00c1\3\2\2\2\5\u00c3\3\2\2\2\7\u00c8\3\2\2"+
		"\2\t\u00ca\3\2\2\2\13\u00cc\3\2\2\2\r\u00d1\3\2\2\2\17\u00d7\3\2\2\2\21"+
		"\u00d9\3\2\2\2\23\u00db\3\2\2\2\25\u00de\3\2\2\2\27\u00e0\3\2\2\2\31\u00e2"+
		"\3\2\2\2\33\u00ea\3\2\2\2\35\u00ec\3\2\2\2\37\u00ee\3\2\2\2!\u00f3\3\2"+
		"\2\2#\u00f7\3\2\2\2%\u00fc\3\2\2\2\'\u00fe\3\2\2\2)\u0100\3\2\2\2+\u0102"+
		"\3\2\2\2-\u0104\3\2\2\2/\u010d\3\2\2\2\61\u0110\3\2\2\2\63\u0115\3\2\2"+
		"\2\65\u011b\3\2\2\2\67\u011f\3\2\2\29\u0125\3\2\2\2;\u012d\3\2\2\2=\u0130"+
		"\3\2\2\2?\u0134\3\2\2\2A\u013a\3\2\2\2C\u0140\3\2\2\2E\u0147\3\2\2\2G"+
		"\u014b\3\2\2\2I\u014d\3\2\2\2K\u0153\3\2\2\2M\u0155\3\2\2\2O\u0157\3\2"+
		"\2\2Q\u0159\3\2\2\2S\u015e\3\2\2\2U\u0161\3\2\2\2W\u0166\3\2\2\2Y\u0168"+
		"\3\2\2\2[\u016a\3\2\2\2]\u016d\3\2\2\2_\u0170\3\2\2\2a\u0173\3\2\2\2c"+
		"\u0177\3\2\2\2e\u0180\3\2\2\2g\u0189\3\2\2\2i\u018f\3\2\2\2k\u0196\3\2"+
		"\2\2m\u019e\3\2\2\2o\u01a8\3\2\2\2q\u01af\3\2\2\2s\u01b3\3\2\2\2u\u01b9"+
		"\3\2\2\2w\u01c0\3\2\2\2y\u01c6\3\2\2\2{\u01ce\3\2\2\2}\u01df\3\2\2\2\177"+
		"\u01e1\3\2\2\2\u0081\u01f9\3\2\2\2\u0083\u01fb\3\2\2\2\u0085\u0200\3\2"+
		"\2\2\u0087\u0230\3\2\2\2\u0089\u0237\3\2\2\2\u008b\u0239\3\2\2\2\u008d"+
		"\u023c\3\2\2\2\u008f\u0242\3\2\2\2\u0091\u0244\3\2\2\2\u0093\u0246\3\2"+
		"\2\2\u0095\u0248\3\2\2\2\u0097\u0256\3\2\2\2\u0099\u0262\3\2\2\2\u009b"+
		"\u0268\3\2\2\2\u009d\u0272\3\2\2\2\u009f\u0275\3\2\2\2\u00a1\u027d\3\2"+
		"\2\2\u00a3\u0283\3\2\2\2\u00a5\u0288\3\2\2\2\u00a7\u0298\3\2\2\2\u00a9"+
		"\u02a1\3\2\2\2\u00ab\u02a3\3\2\2\2\u00ad\u02a5\3\2\2\2\u00af\u02a7\3\2"+
		"\2\2\u00b1\u02ab\3\2\2\2\u00b3\u02ad\3\2\2\2\u00b5\u02b6\3\2\2\2\u00b7"+
		"\u02b8\3\2\2\2\u00b9\u02c3\3\2\2\2\u00bb\u02c5\3\2\2\2\u00bd\u02cf\3\2"+
		"\2\2\u00bf\u02d1\3\2\2\2\u00c1\u00c2\7/\2\2\u00c2\4\3\2\2\2\u00c3\u00c4"+
		"\7p\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7n\2\2\u00c7"+
		"\6\3\2\2\2\u00c8\u00c9\7\60\2\2\u00c9\b\3\2\2\2\u00ca\u00cb\7.\2\2\u00cb"+
		"\n\3\2\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7j\2\2\u00ce\u00cf\7k\2\2\u00cf"+
		"\u00d0\7u\2\2\u00d0\f\3\2\2\2\u00d1\u00d2\7u\2\2\u00d2\u00d3\7w\2\2\u00d3"+
		"\u00d4\7r\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7t\2\2\u00d6\16\3\2\2\2\u00d7"+
		"\u00d8\7]\2\2\u00d8\20\3\2\2\2\u00d9\u00da\7_\2\2\u00da\22\3\2\2\2\u00db"+
		"\u00dc\7?\2\2\u00dc\u00dd\7@\2\2\u00dd\24\3\2\2\2\u00de\u00df\7*\2\2\u00df"+
		"\26\3\2\2\2\u00e0\u00e1\7+\2\2\u00e1\30\3\2\2\2\u00e2\u00e3\7h\2\2\u00e3"+
		"\u00e4\7q\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7U\2\2\u00e6\u00e7\7q\2\2"+
		"\u00e7\u00e8\7o\2\2\u00e8\u00e9\7g\2\2\u00e9\32\3\2\2\2\u00ea\u00eb\7"+
		"}\2\2\u00eb\34\3\2\2\2\u00ec\u00ed\7\177\2\2\u00ed\36\3\2\2\2\u00ee\u00ef"+
		"\7v\2\2\u00ef\u00f0\7{\2\2\u00f0\u00f1\7r\2\2\u00f1\u00f2\7g\2\2\u00f2"+
		" \3\2\2\2\u00f3\u00f4\7x\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7n\2\2\u00f6"+
		"\"\3\2\2\2\u00f7\u00f8\7y\2\2\u00f8\u00f9\7k\2\2\u00f9\u00fa\7v\2\2\u00fa"+
		"\u00fb\7j\2\2\u00fb$\3\2\2\2\u00fc\u00fd\7%\2\2\u00fd&\3\2\2\2\u00fe\u00ff"+
		"\7<\2\2\u00ff(\3\2\2\2\u0100\u0101\7a\2\2\u0101*\3\2\2\2\u0102\u0103\7"+
		",\2\2\u0103,\3\2\2\2\u0104\u0105\7k\2\2\u0105\u0106\7o\2\2\u0106\u0107"+
		"\7r\2\2\u0107\u0108\7n\2\2\u0108\u0109\7k\2\2\u0109\u010a\7e\2\2\u010a"+
		"\u010b\7k\2\2\u010b\u010c\7v\2\2\u010c.\3\2\2\2\u010d\u010e\7k\2\2\u010e"+
		"\u010f\7h\2\2\u010f\60\3\2\2\2\u0110\u0111\7g\2\2\u0111\u0112\7n\2\2\u0112"+
		"\u0113\7u\2\2\u0113\u0114\7g\2\2\u0114\62\3\2\2\2\u0115\u0116\7y\2\2\u0116"+
		"\u0117\7j\2\2\u0117\u0118\7k\2\2\u0118\u0119\7n\2\2\u0119\u011a\7g\2\2"+
		"\u011a\64\3\2\2\2\u011b\u011c\7v\2\2\u011c\u011d\7t\2\2\u011d\u011e\7"+
		"{\2\2\u011e\66\3\2\2\2\u011f\u0120\7e\2\2\u0120\u0121\7c\2\2\u0121\u0122"+
		"\7v\2\2\u0122\u0123\7e\2\2\u0123\u0124\7j\2\2\u01248\3\2\2\2\u0125\u0126"+
		"\7h\2\2\u0126\u0127\7k\2\2\u0127\u0128\7p\2\2\u0128\u0129\7c\2\2\u0129"+
		"\u012a\7n\2\2\u012a\u012b\7n\2\2\u012b\u012c\7{\2\2\u012c:\3\2\2\2\u012d"+
		"\u012e\7f\2\2\u012e\u012f\7q\2\2\u012f<\3\2\2\2\u0130\u0131\7h\2\2\u0131"+
		"\u0132\7q\2\2\u0132\u0133\7t\2\2\u0133>\3\2\2\2\u0134\u0135\7{\2\2\u0135"+
		"\u0136\7k\2\2\u0136\u0137\7g\2\2\u0137\u0138\7n\2\2\u0138\u0139\7f\2\2"+
		"\u0139@\3\2\2\2\u013a\u013b\7v\2\2\u013b\u013c\7j\2\2\u013c\u013d\7t\2"+
		"\2\u013d\u013e\7q\2\2\u013e\u013f\7y\2\2\u013fB\3\2\2\2\u0140\u0141\7"+
		"t\2\2\u0141\u0142\7g\2\2\u0142\u0143\7v\2\2\u0143\u0144\7w\2\2\u0144\u0145"+
		"\7t\2\2\u0145\u0146\7p\2\2\u0146D\3\2\2\2\u0147\u0148\7p\2\2\u0148\u0149"+
		"\7g\2\2\u0149\u014a\7y\2\2\u014aF\3\2\2\2\u014b\u014c\7?\2\2\u014cH\3"+
		"\2\2\2\u014d\u014e\7o\2\2\u014e\u014f\7c\2\2\u014f\u0150\7v\2\2\u0150"+
		"\u0151\7e\2\2\u0151\u0152\7j\2\2\u0152J\3\2\2\2\u0153\u0154\7-\2\2\u0154"+
		"L\3\2\2\2\u0155\u0156\7\u0080\2\2\u0156N\3\2\2\2\u0157\u0158\7#\2\2\u0158"+
		"P\3\2\2\2\u0159\u015a\7n\2\2\u015a\u015b\7c\2\2\u015b\u015c\7|\2\2\u015c"+
		"\u015d\7{\2\2\u015dR\3\2\2\2\u015e\u015f\7>\2\2\u015f\u0160\7/\2\2\u0160"+
		"T\3\2\2\2\u0161\u0162\7e\2\2\u0162\u0163\7c\2\2\u0163\u0164\7u\2\2\u0164"+
		"\u0165\7g\2\2\u0165V\3\2\2\2\u0166\u0167\7~\2\2\u0167X\3\2\2\2\u0168\u0169"+
		"\7B\2\2\u0169Z\3\2\2\2\u016a\u016b\7@\2\2\u016b\u016c\7<\2\2\u016c\\\3"+
		"\2\2\2\u016d\u016e\7>\2\2\u016e\u016f\7<\2\2\u016f^\3\2\2\2\u0170\u0171"+
		"\7>\2\2\u0171\u0172\7\'\2\2\u0172`\3\2\2\2\u0173\u0174\7x\2\2\u0174\u0175"+
		"\7c\2\2\u0175\u0176\7t\2\2\u0176b\3\2\2\2\u0177\u0178\7q\2\2\u0178\u0179"+
		"\7x\2\2\u0179\u017a\7g\2\2\u017a\u017b\7t\2\2\u017b\u017c\7t\2\2\u017c"+
		"\u017d\7k\2\2\u017d\u017e\7f\2\2\u017e\u017f\7g\2\2\u017fd\3\2\2\2\u0180"+
		"\u0181\7c\2\2\u0181\u0182\7d\2\2\u0182\u0183\7u\2\2\u0183\u0184\7v\2\2"+
		"\u0184\u0185\7t\2\2\u0185\u0186\7c\2\2\u0186\u0187\7e\2\2\u0187\u0188"+
		"\7v\2\2\u0188f\3\2\2\2\u0189\u018a\7h\2\2\u018a\u018b\7k\2\2\u018b\u018c"+
		"\7p\2\2\u018c\u018d\7c\2\2\u018d\u018e\7n\2\2\u018eh\3\2\2\2\u018f\u0190"+
		"\7u\2\2\u0190\u0191\7g\2\2\u0191\u0192\7c\2\2\u0192\u0193\7n\2\2\u0193"+
		"\u0194\7g\2\2\u0194\u0195\7f\2\2\u0195j\3\2\2\2\u0196\u0197\7r\2\2\u0197"+
		"\u0198\7t\2\2\u0198\u0199\7k\2\2\u0199\u019a\7x\2\2\u019a\u019b\7c\2\2"+
		"\u019b\u019c\7v\2\2\u019c\u019d\7g\2\2\u019dl\3\2\2\2\u019e\u019f\7r\2"+
		"\2\u019f\u01a0\7t\2\2\u01a0\u01a1\7q\2\2\u01a1\u01a2\7v\2\2\u01a2\u01a3"+
		"\7g\2\2\u01a3\u01a4\7e\2\2\u01a4\u01a5\7v\2\2\u01a5\u01a6\7g\2\2\u01a6"+
		"\u01a7\7f\2\2\u01a7n\3\2\2\2\u01a8\u01a9\7k\2\2\u01a9\u01aa\7o\2\2\u01aa"+
		"\u01ab\7r\2\2\u01ab\u01ac\7q\2\2\u01ac\u01ad\7t\2\2\u01ad\u01ae\7v\2\2"+
		"\u01aep\3\2\2\2\u01af\u01b0\7f\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b2\7h\2"+
		"\2\u01b2r\3\2\2\2\u01b3\u01b4\7e\2\2\u01b4\u01b5\7n\2\2\u01b5\u01b6\7"+
		"c\2\2\u01b6\u01b7\7u\2\2\u01b7\u01b8\7u\2\2\u01b8t\3\2\2\2\u01b9\u01ba"+
		"\7q\2\2\u01ba\u01bb\7d\2\2\u01bb\u01bc\7l\2\2\u01bc\u01bd\7g\2\2\u01bd"+
		"\u01be\7e\2\2\u01be\u01bf\7v\2\2\u01bfv\3\2\2\2\u01c0\u01c1\7v\2\2\u01c1"+
		"\u01c2\7t\2\2\u01c2\u01c3\7c\2\2\u01c3\u01c4\7k\2\2\u01c4\u01c5\7v\2\2"+
		"\u01c5x\3\2\2\2\u01c6\u01c7\7g\2\2\u01c7\u01c8\7z\2\2\u01c8\u01c9\7v\2"+
		"\2\u01c9\u01ca\7g\2\2\u01ca\u01cb\7p\2\2\u01cb\u01cc\7f\2\2\u01cc\u01cd"+
		"\7u\2\2\u01cdz\3\2\2\2\u01ce\u01cf\7r\2\2\u01cf\u01d0\7c\2\2\u01d0\u01d1"+
		"\7e\2\2\u01d1\u01d2\7m\2\2\u01d2\u01d3\7c\2\2\u01d3\u01d4\7i\2\2\u01d4"+
		"\u01d5\7g\2\2\u01d5|\3\2\2\2\u01d6\u01d7\7v\2\2\u01d7\u01d8\7t\2\2\u01d8"+
		"\u01d9\7w\2\2\u01d9\u01e0\7g\2\2\u01da\u01db\7h\2\2\u01db\u01dc\7c\2\2"+
		"\u01dc\u01dd\7n\2\2\u01dd\u01de\7u\2\2\u01de\u01e0\7g\2\2\u01df\u01d6"+
		"\3\2\2\2\u01df\u01da\3\2\2\2\u01e0~\3\2\2\2\u01e1\u01e4\7)\2\2\u01e2\u01e5"+
		"\5\u00b5[\2\u01e3\u01e5\5\u00b7\\\2\u01e4\u01e2\3\2\2\2\u01e4\u01e3\3"+
		"\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\7)\2\2\u01e7\u0080\3\2\2\2\u01e8"+
		"\u01ec\7$\2\2\u01e9\u01eb\5\u00a5S\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3"+
		"\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ef\u01fa\7$\2\2\u01f0\u01f1\7$\2\2\u01f1\u01f2\7$\2"+
		"\2\u01f2\u01f3\7$\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\5\u00a7T\2\u01f5"+
		"\u01f6\7$\2\2\u01f6\u01f7\7$\2\2\u01f7\u01f8\7$\2\2\u01f8\u01fa\3\2\2"+
		"\2\u01f9\u01e8\3\2\2\2\u01f9\u01f0\3\2\2\2\u01fa\u0082\3\2\2\2\u01fb\u01fc"+
		"\7)\2\2\u01fc\u01fd\5\u00a1Q\2\u01fd\u0084\3\2\2\2\u01fe\u0201\5\u00b9"+
		"]\2\u01ff\u0201\5\u00bb^\2\u0200\u01fe\3\2\2\2\u0200\u01ff\3\2\2\2\u0201"+
		"\u0202\3\2\2\2\u0202\u0203\t\2\2\2\u0203\u0086\3\2\2\2\u0204\u0206\5\u00bd"+
		"_\2\u0205\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0205\3\2\2\2\u0207"+
		"\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b\7\60\2\2\u020a\u020c\5"+
		"\u00bd_\2\u020b\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020b\3\2\2\2"+
		"\u020d\u020e\3\2\2\2\u020e\u0210\3\2\2\2\u020f\u0211\5\u00b3Z\2\u0210"+
		"\u020f\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u0214\5\u00ab"+
		"V\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0231\3\2\2\2\u0215"+
		"\u0217\7\60\2\2\u0216\u0218\5\u00bd_\2\u0217\u0216\3\2\2\2\u0218\u0219"+
		"\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b"+
		"\u021d\5\u00b3Z\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021f"+
		"\3\2\2\2\u021e\u0220\5\u00abV\2\u021f\u021e\3\2\2\2\u021f\u0220\3\2\2"+
		"\2\u0220\u0231\3\2\2\2\u0221\u0222\5\u00bd_\2\u0222\u0224\5\u00b3Z\2\u0223"+
		"\u0225\5\u00abV\2\u0224\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0231"+
		"\3\2\2\2\u0226\u0228\5\u00bd_\2\u0227\u0226\3\2\2\2\u0228\u0229\3\2\2"+
		"\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022c\3\2\2\2\u022b\u022d"+
		"\5\u00b3Z\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2"+
		"\2\u022e\u022f\5\u00abV\2\u022f\u0231\3\2\2\2\u0230\u0205\3\2\2\2\u0230"+
		"\u0215\3\2\2\2\u0230\u0221\3\2\2\2\u0230\u0227\3\2\2\2\u0231\u0088\3\2"+
		"\2\2\u0232\u0238\5\u00a1Q\2\u0233\u0234\7b\2\2\u0234\u0235\5\u0081A\2"+
		"\u0235\u0236\7b\2\2\u0236\u0238\3\2\2\2\u0237\u0232\3\2\2\2\u0237\u0233"+
		"\3\2\2\2\u0238\u008a\3\2\2\2\u0239\u023a\5\u00afX\2\u023a\u023b\5\u00a3"+
		"R\2\u023b\u008c\3\2\2\2\u023c\u023d\t\3\2\2\u023d\u023e\3\2\2\2\u023e"+
		"\u023f\bG\2\2\u023f\u008e\3\2\2\2\u0240\u0243\7=\2\2\u0241\u0243\5\u0099"+
		"M\2\u0242\u0240\3\2\2\2\u0242\u0241\3\2\2\2\u0243\u0090\3\2\2\2\u0244"+
		"\u0245\t\4\2\2\u0245\u0092\3\2\2\2\u0246\u0247\t\5\2\2\u0247\u0094\3\2"+
		"\2\2\u0248\u0249\7\61\2\2\u0249\u024a\7,\2\2\u024a\u024e\3\2\2\2\u024b"+
		"\u024d\13\2\2\2\u024c\u024b\3\2\2\2\u024d\u0250\3\2\2\2\u024e\u024f\3"+
		"\2\2\2\u024e\u024c\3\2\2\2\u024f\u0251\3\2\2\2\u0250\u024e\3\2\2\2\u0251"+
		"\u0252\7,\2\2\u0252\u0253\7\61\2\2\u0253\u0254\3\2\2\2\u0254\u0255\bK"+
		"\2\2\u0255\u0096\3\2\2\2\u0256\u0257\7\61\2\2\u0257\u0258\7\61\2\2\u0258"+
		"\u025c\3\2\2\2\u0259\u025b\n\6\2\2\u025a\u0259\3\2\2\2\u025b\u025e\3\2"+
		"\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025f\3\2\2\2\u025e"+
		"\u025c\3\2\2\2\u025f\u0260\bL\3\2\u0260\u0098\3\2\2\2\u0261\u0263\t\6"+
		"\2\2\u0262\u0261\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0262\3\2\2\2\u0264"+
		"\u0265\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0267\bM\2\2\u0267\u009a\3\2"+
		"\2\2\u0268\u0269\7^\2\2\u0269\u026b\7w\2\2\u026a\u026c\7w\2\2\u026b\u026a"+
		"\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\5\u00a9U"+
		"\2\u026e\u026f\5\u00a9U\2\u026f\u0270\5\u00a9U\2\u0270\u0271\5\u00a9U"+
		"\2\u0271\u009c\3\2\2\2\u0272\u0273\5\u00b5[\2\u0273\u009e\3\2\2\2\u0274"+
		"\u0276\5\u009dO\2\u0275\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0275"+
		"\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u00a0\3\2\2\2\u0279\u027a\5\u00adW"+
		"\2\u027a\u027b\5\u00a3R\2\u027b\u027e\3\2\2\2\u027c\u027e\5\u008bF\2\u027d"+
		"\u0279\3\2\2\2\u027d\u027c\3\2\2\2\u027e\u00a2\3\2\2\2\u027f\u0282\5\u00b1"+
		"Y\2\u0280\u0282\5\u00bd_\2\u0281\u027f\3\2\2\2\u0281\u0280\3\2\2\2\u0282"+
		"\u0285\3\2\2\2\u0283\u0281\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u00a4\3\2"+
		"\2\2\u0285\u0283\3\2\2\2\u0286\u0289\t\7\2\2\u0287\u0289\5\u00b7\\\2\u0288"+
		"\u0286\3\2\2\2\u0288\u0287\3\2\2\2\u0289\u00a6\3\2\2\2\u028a\u028c\7$"+
		"\2\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028e\3\2\2\2\u028d"+
		"\u028f\7$\2\2\u028e\u028d\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0293\3\2"+
		"\2\2\u0290\u0292\13\2\2\2\u0291\u0290\3\2\2\2\u0292\u0295\3\2\2\2\u0293"+
		"\u0294\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u0297\3\2\2\2\u0295\u0293\3\2"+
		"\2\2\u0296\u028b\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0298"+
		"\u0299\3\2\2\2\u0299\u029e\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u029d\7$"+
		"\2\2\u029c\u029b\3\2\2\2\u029d\u02a0\3\2\2\2\u029e\u029c\3\2\2\2\u029e"+
		"\u029f\3\2\2\2\u029f\u00a8\3\2\2\2\u02a0\u029e\3\2\2\2\u02a1\u02a2\t\b"+
		"\2\2\u02a2\u00aa\3\2\2\2\u02a3\u02a4\t\t\2\2\u02a4\u00ac\3\2\2\2\u02a5"+
		"\u02a6\t\n\2\2\u02a6\u00ae\3\2\2\2\u02a7\u02a8\4c|\2\u02a8\u00b0\3\2\2"+
		"\2\u02a9\u02ac\5\u00adW\2\u02aa\u02ac\5\u00afX\2\u02ab\u02a9\3\2\2\2\u02ab"+
		"\u02aa\3\2\2\2\u02ac\u00b2\3\2\2\2\u02ad\u02af\t\13\2\2\u02ae\u02b0\t"+
		"\f\2\2\u02af\u02ae\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b2\3\2\2\2\u02b1"+
		"\u02b3\5\u00bd_\2\u02b2\u02b1\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b2"+
		"\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u00b4\3\2\2\2\u02b6\u02b7\4\"\u0081"+
		"\2\u02b7\u00b6\3\2\2\2\u02b8\u02b9\7^\2\2\u02b9\u02ba\t\r\2\2\u02ba\u00b8"+
		"\3\2\2\2\u02bb\u02c4\7\62\2\2\u02bc\u02c0\5\u00bf`\2\u02bd\u02bf\5\u00bd"+
		"_\2\u02be\u02bd\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0"+
		"\u02c1\3\2\2\2\u02c1\u02c4\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02bb\3\2"+
		"\2\2\u02c3\u02bc\3\2\2\2\u02c4\u00ba\3\2\2\2\u02c5\u02c6\7\62\2\2\u02c6"+
		"\u02c7\7z\2\2\u02c7\u02c9\5\u00a9U\2\u02c8\u02ca\5\u00a9U\2\u02c9\u02c8"+
		"\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc"+
		"\u00bc\3\2\2\2\u02cd\u02d0\7\62\2\2\u02ce\u02d0\5\u00bf`\2\u02cf\u02cd"+
		"\3\2\2\2\u02cf\u02ce\3\2\2\2\u02d0\u00be\3\2\2\2\u02d1\u02d2\4\63;\2\u02d2"+
		"\u00c0\3\2\2\2*\2\u01df\u01e4\u01ec\u01f9\u0200\u0207\u020d\u0210\u0213"+
		"\u0219\u021c\u021f\u0224\u0229\u022c\u0230\u0237\u0242\u024e\u025c\u0264"+
		"\u026b\u0277\u027d\u0281\u0283\u0288\u028b\u028e\u0293\u0298\u029e\u02ab"+
		"\u02af\u02b4\u02c0\u02c3\u02cb\u02cf\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}