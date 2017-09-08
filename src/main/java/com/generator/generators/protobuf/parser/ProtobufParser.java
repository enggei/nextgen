// Generated from /home/goe/projects/nextgen/src/main/java/com/generator/generators/protobuf/parser/Protobuf.g4 by ANTLR 4.7
package com.generator.generators.protobuf.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProtobufParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, FIELDRULE=23, INT=24, 
		ID=25, WS=26, SL_COMMENT=27;
	public static final int
		RULE_file = 0, RULE_packageDecl = 1, RULE_packageName = 2, RULE_option = 3, 
		RULE_imports = 4, RULE_message = 5, RULE_enumName = 6, RULE_messageContent = 7, 
		RULE_property = 8, RULE_defaultValue = 9, RULE_packedValue = 10, RULE_extensions = 11, 
		RULE_propertyName = 12, RULE_propertyType = 13, RULE_extensionMax = 14;
	public static final String[] ruleNames = {
		"file", "packageDecl", "packageName", "option", "imports", "message", 
		"enumName", "messageContent", "property", "defaultValue", "packedValue", 
		"extensions", "propertyName", "propertyType", "extensionMax"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'package'", "';'", "'.'", "'option'", "'='", "'import'", "'\"'", 
		"'message'", "'{'", "'}'", "'enum'", "'extend'", "'['", "'default'", "'-'", 
		"']'", "'packed'", "'true'", "'false'", "'extensions'", "'to'", "'max'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "FIELDRULE", 
		"INT", "ID", "WS", "SL_COMMENT"
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
	public String getGrammarFileName() { return "Protobuf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProtobufParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public PackageDeclContext packageDecl() {
			return getRuleContext(PackageDeclContext.class,0);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<ImportsContext> imports() {
			return getRuleContexts(ImportsContext.class);
		}
		public ImportsContext imports(int i) {
			return getRuleContext(ImportsContext.class,i);
		}
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(30);
				packageDecl();
				}
			}

			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(33);
				option();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(39);
				imports();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				message();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << SL_COMMENT))) != 0) );
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

	public static class PackageDeclContext extends ParserRuleContext {
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public PackageDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterPackageDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitPackageDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitPackageDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclContext packageDecl() throws RecognitionException {
		PackageDeclContext _localctx = new PackageDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			packageName();
			setState(52);
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

	public static class PackageNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProtobufParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProtobufParser.ID, i);
		}
		public PackageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitPackageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitPackageName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageNameContext packageName() throws RecognitionException {
		PackageNameContext _localctx = new PackageNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_packageName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ID);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(55);
				match(T__2);
				setState(56);
				match(ID);
				}
				}
				setState(61);
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
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode ID() { return getToken(ProtobufParser.ID, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__3);
			setState(63);
			propertyName();
			setState(64);
			match(T__4);
			setState(65);
			match(ID);
			setState(66);
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

	public static class ImportsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProtobufParser.ID, 0); }
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_imports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__5);
			setState(69);
			match(T__6);
			setState(70);
			match(ID);
			setState(71);
			match(T__6);
			setState(72);
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

	public static class MessageContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProtobufParser.ID, 0); }
		public List<TerminalNode> SL_COMMENT() { return getTokens(ProtobufParser.SL_COMMENT); }
		public TerminalNode SL_COMMENT(int i) {
			return getToken(ProtobufParser.SL_COMMENT, i);
		}
		public List<MessageContentContext> messageContent() {
			return getRuleContexts(MessageContentContext.class);
		}
		public MessageContentContext messageContent(int i) {
			return getRuleContext(MessageContentContext.class,i);
		}
		public List<EnumNameContext> enumName() {
			return getRuleContexts(EnumNameContext.class);
		}
		public EnumNameContext enumName(int i) {
			return getRuleContext(EnumNameContext.class,i);
		}
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_message);
		int _la;
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(74);
					match(SL_COMMENT);
					}
				}

				setState(77);
				match(T__7);
				setState(78);
				match(ID);
				setState(79);
				match(T__8);
				setState(81);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(80);
					match(SL_COMMENT);
					}
					break;
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(83);
					messageContent();
					}
					}
					setState(86); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__19) | (1L << FIELDRULE) | (1L << SL_COMMENT))) != 0) );
				setState(88);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(90);
					match(SL_COMMENT);
					}
				}

				setState(93);
				match(T__10);
				setState(94);
				match(ID);
				setState(95);
				match(T__8);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(96);
					match(SL_COMMENT);
					}
				}

				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					enumName();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(104);
				match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(106);
					match(SL_COMMENT);
					}
				}

				setState(109);
				match(T__11);
				setState(110);
				match(ID);
				setState(111);
				match(T__8);
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(112);
					match(SL_COMMENT);
					}
					break;
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(115);
					messageContent();
					}
					}
					setState(118); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__19) | (1L << FIELDRULE) | (1L << SL_COMMENT))) != 0) );
				setState(120);
				match(T__9);
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

	public static class EnumNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProtobufParser.ID, 0); }
		public TerminalNode INT() { return getToken(ProtobufParser.INT, 0); }
		public TerminalNode SL_COMMENT() { return getToken(ProtobufParser.SL_COMMENT, 0); }
		public EnumNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterEnumName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitEnumName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitEnumName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumNameContext enumName() throws RecognitionException {
		EnumNameContext _localctx = new EnumNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_enumName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(ID);
			setState(125);
			match(T__4);
			setState(126);
			match(INT);
			setState(127);
			match(T__1);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SL_COMMENT) {
				{
				setState(128);
				match(SL_COMMENT);
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

	public static class MessageContentContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public ExtensionsContext extensions() {
			return getRuleContext(ExtensionsContext.class,0);
		}
		public MessageContext message() {
			return getRuleContext(MessageContext.class,0);
		}
		public MessageContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterMessageContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitMessageContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitMessageContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageContentContext messageContent() throws RecognitionException {
		MessageContentContext _localctx = new MessageContentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_messageContent);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIELDRULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				property();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				extensions();
				}
				break;
			case T__7:
			case T__10:
			case T__11:
			case SL_COMMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				message();
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

	public static class PropertyContext extends ParserRuleContext {
		public TerminalNode FIELDRULE() { return getToken(ProtobufParser.FIELDRULE, 0); }
		public PropertyTypeContext propertyType() {
			return getRuleContext(PropertyTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ProtobufParser.ID, 0); }
		public TerminalNode INT() { return getToken(ProtobufParser.INT, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public PackedValueContext packedValue() {
			return getRuleContext(PackedValueContext.class,0);
		}
		public TerminalNode SL_COMMENT() { return getToken(ProtobufParser.SL_COMMENT, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(FIELDRULE);
			setState(137);
			propertyType();
			setState(138);
			match(ID);
			setState(139);
			match(T__4);
			setState(140);
			match(INT);
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(141);
				defaultValue();
				}
				break;
			case 2:
				{
				setState(142);
				packedValue();
				}
				break;
			}
			setState(145);
			match(T__1);
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(146);
				match(SL_COMMENT);
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

	public static class DefaultValueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProtobufParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProtobufParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(ProtobufParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ProtobufParser.INT, i);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defaultValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__12);
			setState(150);
			match(T__13);
			setState(151);
			match(T__4);
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << INT) | (1L << ID))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << INT) | (1L << ID))) != 0) );
			setState(157);
			match(T__15);
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

	public static class PackedValueContext extends ParserRuleContext {
		public PackedValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packedValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterPackedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitPackedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitPackedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackedValueContext packedValue() throws RecognitionException {
		PackedValueContext _localctx = new PackedValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_packedValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__12);
			setState(160);
			match(T__16);
			setState(161);
			match(T__4);
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(163);
			match(T__15);
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

	public static class ExtensionsContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ProtobufParser.INT, 0); }
		public ExtensionMaxContext extensionMax() {
			return getRuleContext(ExtensionMaxContext.class,0);
		}
		public ExtensionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterExtensions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitExtensions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitExtensions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionsContext extensions() throws RecognitionException {
		ExtensionsContext _localctx = new ExtensionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_extensions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__19);
			setState(166);
			match(INT);
			setState(167);
			match(T__20);
			setState(168);
			extensionMax();
			setState(169);
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

	public static class PropertyNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProtobufParser.ID, 0); }
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitPropertyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitPropertyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_propertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(ID);
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

	public static class PropertyTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProtobufParser.ID, 0); }
		public TerminalNode INT() { return getToken(ProtobufParser.INT, 0); }
		public PropertyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterPropertyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitPropertyType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitPropertyType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyTypeContext propertyType() throws RecognitionException {
		PropertyTypeContext _localctx = new PropertyTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_propertyType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ID);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(174);
				match(INT);
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

	public static class ExtensionMaxContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ProtobufParser.INT, 0); }
		public ExtensionMaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensionMax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).enterExtensionMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufListener ) ((ProtobufListener)listener).exitExtensionMax(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufVisitor ) return ((ProtobufVisitor<? extends T>)visitor).visitExtensionMax(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionMaxContext extensionMax() throws RecognitionException {
		ExtensionMaxContext _localctx = new ExtensionMaxContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_extensionMax);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==INT) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00b6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\5\2\"\n\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\6\2\61\n\2\r"+
		"\2\16\2\62\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\5\7N\n\7\3\7\3\7\3\7\3\7"+
		"\5\7T\n\7\3\7\6\7W\n\7\r\7\16\7X\3\7\3\7\3\7\5\7^\n\7\3\7\3\7\3\7\3\7"+
		"\5\7d\n\7\3\7\6\7g\n\7\r\7\16\7h\3\7\3\7\3\7\5\7n\n\7\3\7\3\7\3\7\3\7"+
		"\5\7t\n\7\3\7\6\7w\n\7\r\7\16\7x\3\7\3\7\5\7}\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u0084\n\b\3\t\3\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0092\n\n\3\n\3\n\5\n\u0096\n\n\3\13\3\13\3\13\3\13\6\13\u009c\n\13"+
		"\r\13\16\13\u009d\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\5\17\u00b2\n\17\3\20\3\20\3\20\2\2\21\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36\2\5\5\2\t\t\21\21\32\33\3\2\24\25\4"+
		"\2\30\30\32\32\2\u00be\2!\3\2\2\2\4\64\3\2\2\2\68\3\2\2\2\b@\3\2\2\2\n"+
		"F\3\2\2\2\f|\3\2\2\2\16~\3\2\2\2\20\u0088\3\2\2\2\22\u008a\3\2\2\2\24"+
		"\u0097\3\2\2\2\26\u00a1\3\2\2\2\30\u00a7\3\2\2\2\32\u00ad\3\2\2\2\34\u00af"+
		"\3\2\2\2\36\u00b3\3\2\2\2 \"\5\4\3\2! \3\2\2\2!\"\3\2\2\2\"&\3\2\2\2#"+
		"%\5\b\5\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\',\3\2\2\2(&\3\2\2"+
		"\2)+\5\n\6\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2.,\3\2"+
		"\2\2/\61\5\f\7\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2"+
		"\63\3\3\2\2\2\64\65\7\3\2\2\65\66\5\6\4\2\66\67\7\4\2\2\67\5\3\2\2\28"+
		"=\7\33\2\29:\7\5\2\2:<\7\33\2\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2"+
		"\2>\7\3\2\2\2?=\3\2\2\2@A\7\6\2\2AB\5\32\16\2BC\7\7\2\2CD\7\33\2\2DE\7"+
		"\4\2\2E\t\3\2\2\2FG\7\b\2\2GH\7\t\2\2HI\7\33\2\2IJ\7\t\2\2JK\7\4\2\2K"+
		"\13\3\2\2\2LN\7\35\2\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\n\2\2PQ\7\33"+
		"\2\2QS\7\13\2\2RT\7\35\2\2SR\3\2\2\2ST\3\2\2\2TV\3\2\2\2UW\5\20\t\2VU"+
		"\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\f\2\2[}\3\2\2\2\\"+
		"^\7\35\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\r\2\2`a\7\33\2\2ac\7\13"+
		"\2\2bd\7\35\2\2cb\3\2\2\2cd\3\2\2\2df\3\2\2\2eg\5\16\b\2fe\3\2\2\2gh\3"+
		"\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\f\2\2k}\3\2\2\2ln\7\35\2\2ml"+
		"\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\16\2\2pq\7\33\2\2qs\7\13\2\2rt\7\35\2"+
		"\2sr\3\2\2\2st\3\2\2\2tv\3\2\2\2uw\5\20\t\2vu\3\2\2\2wx\3\2\2\2xv\3\2"+
		"\2\2xy\3\2\2\2yz\3\2\2\2z{\7\f\2\2{}\3\2\2\2|M\3\2\2\2|]\3\2\2\2|m\3\2"+
		"\2\2}\r\3\2\2\2~\177\7\33\2\2\177\u0080\7\7\2\2\u0080\u0081\7\32\2\2\u0081"+
		"\u0083\7\4\2\2\u0082\u0084\7\35\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3"+
		"\2\2\2\u0084\17\3\2\2\2\u0085\u0089\5\22\n\2\u0086\u0089\5\30\r\2\u0087"+
		"\u0089\5\f\7\2\u0088\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2"+
		"\2\2\u0089\21\3\2\2\2\u008a\u008b\7\31\2\2\u008b\u008c\5\34\17\2\u008c"+
		"\u008d\7\33\2\2\u008d\u008e\7\7\2\2\u008e\u0091\7\32\2\2\u008f\u0092\5"+
		"\24\13\2\u0090\u0092\5\26\f\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\7\4\2\2\u0094\u0096"+
		"\7\35\2\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\23\3\2\2\2\u0097"+
		"\u0098\7\17\2\2\u0098\u0099\7\20\2\2\u0099\u009b\7\7\2\2\u009a\u009c\t"+
		"\2\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7\22\2\2\u00a0\25\3\2\2"+
		"\2\u00a1\u00a2\7\17\2\2\u00a2\u00a3\7\23\2\2\u00a3\u00a4\7\7\2\2\u00a4"+
		"\u00a5\t\3\2\2\u00a5\u00a6\7\22\2\2\u00a6\27\3\2\2\2\u00a7\u00a8\7\26"+
		"\2\2\u00a8\u00a9\7\32\2\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\5\36\20\2\u00ab"+
		"\u00ac\7\4\2\2\u00ac\31\3\2\2\2\u00ad\u00ae\7\33\2\2\u00ae\33\3\2\2\2"+
		"\u00af\u00b1\7\33\2\2\u00b0\u00b2\7\32\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\35\3\2\2\2\u00b3\u00b4\t\4\2\2\u00b4\37\3\2\2\2\27!&,\62"+
		"=MSX]chmsx|\u0083\u0088\u0091\u0095\u009d\u00b1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}