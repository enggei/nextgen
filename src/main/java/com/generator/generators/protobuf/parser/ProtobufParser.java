// Generated from src/main/java/com/generator/generators/protobuf/parser/Protobuf.g4 by ANTLR 4.5.3
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

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



	public enum FieldRules { required, optional, repeated  }

	public void packageName(String name) {}

	public void option(String name, String value) {}
	public void imports(String name) {}

	public void newMessage(String name, String comment) { }
	public void newExtension(String name) { }
	public void newProperty(FieldRules rule, String propertyType, String propertyName, Integer ordinal, String comment, String parent, String defaultValue, String packedValue) { }
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

	private String getPackedValue(String text) {
	    //'[' 'packed' '=' ('true'|'false') ']'
	    return text.substring(text.indexOf("=") + 1, text.length() - 1);
	}

	public static TokenStream createLexer(java.io.Reader reader) throws java.io.IOException {
		final ANTLRInputStream input = new ANTLRInputStream(reader);
		final ProtobufLexer lexer = new ProtobufLexer(input);
		return new CommonTokenStream(lexer);
	}

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
			 end(); 
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
		public PackageNameContext packageName;
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
			setState(52);
			match(T__0);
			setState(53);
			((PackageDeclContext)_localctx).packageName = packageName();
			 packageName((((PackageDeclContext)_localctx).packageName!=null?_input.getText(((PackageDeclContext)_localctx).packageName.start,((PackageDeclContext)_localctx).packageName.stop):null)); 
			setState(55);
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
			setState(57);
			match(ID);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(58);
				match(T__2);
				setState(59);
				match(ID);
				}
				}
				setState(64);
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
		public PropertyNameContext propertyName;
		public Token ID;
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
			setState(65);
			match(T__3);
			setState(66);
			((OptionContext)_localctx).propertyName = propertyName();
			setState(67);
			match(T__4);
			setState(68);
			((OptionContext)_localctx).ID = match(ID);
			 option((((OptionContext)_localctx).propertyName!=null?_input.getText(((OptionContext)_localctx).propertyName.start,((OptionContext)_localctx).propertyName.stop):null), ((OptionContext)_localctx).ID.getText()); 
			setState(70);
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
		public Token ID;
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
			setState(72);
			match(T__5);
			setState(73);
			match(T__6);
			setState(74);
			((ImportsContext)_localctx).ID = match(ID);
			setState(75);
			match(T__6);
			 imports(((ImportsContext)_localctx).ID.getText()); 
			setState(77);
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
		public Token SL_COMMENT;
		public Token ID;
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
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(79);
					((MessageContext)_localctx).SL_COMMENT = match(SL_COMMENT);
					}
				}

				setState(82);
				match(T__7);
				setState(83);
				((MessageContext)_localctx).ID = match(ID);
				 newMessage(((MessageContext)_localctx).ID.getText(), ((MessageContext)_localctx).SL_COMMENT!=null ? ((MessageContext)_localctx).SL_COMMENT.getText() : null); 
				setState(85);
				match(T__8);
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(86);
					((MessageContext)_localctx).SL_COMMENT = match(SL_COMMENT);
					}
					break;
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(89);
					messageContent();
					}
					}
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__19) | (1L << FIELDRULE) | (1L << SL_COMMENT))) != 0) );
				setState(94);
				match(T__9);
				 endMessage(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(97);
					((MessageContext)_localctx).SL_COMMENT = match(SL_COMMENT);
					}
				}

				setState(100);
				match(T__10);
				setState(101);
				((MessageContext)_localctx).ID = match(ID);
				 newEnum(((MessageContext)_localctx).ID.getText(), ((MessageContext)_localctx).SL_COMMENT!=null ? ((MessageContext)_localctx).SL_COMMENT.getText() : null); 
				setState(103);
				match(T__8);
				setState(105);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(104);
					((MessageContext)_localctx).SL_COMMENT = match(SL_COMMENT);
					}
				}

				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(107);
					enumName();
					}
					}
					setState(110); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(112);
				match(T__9);
				 endEnum(); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				_la = _input.LA(1);
				if (_la==SL_COMMENT) {
					{
					setState(115);
					match(SL_COMMENT);
					}
				}

				setState(118);
				match(T__11);
				setState(119);
				((MessageContext)_localctx).ID = match(ID);
				 newExtension(((MessageContext)_localctx).ID.getText()); 
				setState(121);
				match(T__8);
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(122);
					match(SL_COMMENT);
					}
					break;
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(125);
					messageContent();
					}
					}
					setState(128); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__19) | (1L << FIELDRULE) | (1L << SL_COMMENT))) != 0) );
				setState(130);
				match(T__9);
				 endExtension(); 
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
		public Token ID;
		public Token INT;
		public Token SL_COMMENT;
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
			setState(135);
			((EnumNameContext)_localctx).ID = match(ID);
			setState(136);
			match(T__4);
			setState(137);
			((EnumNameContext)_localctx).INT = match(INT);
			setState(138);
			match(T__1);
			setState(140);
			_la = _input.LA(1);
			if (_la==SL_COMMENT) {
				{
				setState(139);
				((EnumNameContext)_localctx).SL_COMMENT = match(SL_COMMENT);
				}
			}

			 newEnumValue(((EnumNameContext)_localctx).ID.getText(), Integer.valueOf(((EnumNameContext)_localctx).INT.getText()), ((EnumNameContext)_localctx).SL_COMMENT!=null ? ((EnumNameContext)_localctx).SL_COMMENT.getText() : null); 
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
			setState(147);
			switch (_input.LA(1)) {
			case FIELDRULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				property();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				extensions();
				}
				break;
			case T__7:
			case T__10:
			case T__11:
			case SL_COMMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
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
		public Token FIELDRULE;
		public PropertyTypeContext propertyType;
		public Token ID;
		public Token INT;
		public DefaultValueContext defaultValue;
		public PackedValueContext packedValue;
		public Token SL_COMMENT;
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
			setState(149);
			((PropertyContext)_localctx).FIELDRULE = match(FIELDRULE);
			setState(150);
			((PropertyContext)_localctx).propertyType = propertyType();
			setState(151);
			((PropertyContext)_localctx).ID = match(ID);
			setState(152);
			match(T__4);
			setState(153);
			((PropertyContext)_localctx).INT = match(INT);
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(154);
				((PropertyContext)_localctx).defaultValue = defaultValue();
				}
				break;
			case 2:
				{
				setState(155);
				((PropertyContext)_localctx).packedValue = packedValue();
				}
				break;
			}
			setState(158);
			match(T__1);
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(159);
				((PropertyContext)_localctx).SL_COMMENT = match(SL_COMMENT);
				}
				break;
			}
			 newProperty(FieldRules.valueOf(((PropertyContext)_localctx).FIELDRULE.getText()), (((PropertyContext)_localctx).propertyType!=null?_input.getText(((PropertyContext)_localctx).propertyType.start,((PropertyContext)_localctx).propertyType.stop):null), ((PropertyContext)_localctx).ID.getText(), Integer.valueOf(((PropertyContext)_localctx).INT.getText()), ((PropertyContext)_localctx).SL_COMMENT!=null ? ((PropertyContext)_localctx).SL_COMMENT.getText() : null, (((PropertyContext)_localctx).propertyType!=null?_input.getText(((PropertyContext)_localctx).propertyType.start,((PropertyContext)_localctx).propertyType.stop):null).contains(".") ? (((PropertyContext)_localctx).propertyType!=null?_input.getText(((PropertyContext)_localctx).propertyType.start,((PropertyContext)_localctx).propertyType.stop):null).substring(0,(((PropertyContext)_localctx).propertyType!=null?_input.getText(((PropertyContext)_localctx).propertyType.start,((PropertyContext)_localctx).propertyType.stop):null).lastIndexOf(".")) : null, (((PropertyContext)_localctx).defaultValue!=null?_input.getText(((PropertyContext)_localctx).defaultValue.start,((PropertyContext)_localctx).defaultValue.stop):null)==null ? null : getDefaultValue((((PropertyContext)_localctx).defaultValue!=null?_input.getText(((PropertyContext)_localctx).defaultValue.start,((PropertyContext)_localctx).defaultValue.stop):null)), (((PropertyContext)_localctx).packedValue!=null?_input.getText(((PropertyContext)_localctx).packedValue.start,((PropertyContext)_localctx).packedValue.stop):null)==null ? null : getPackedValue((((PropertyContext)_localctx).packedValue!=null?_input.getText(((PropertyContext)_localctx).packedValue.start,((PropertyContext)_localctx).packedValue.stop):null)) ); 
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
			setState(164);
			match(T__12);
			setState(165);
			match(T__13);
			setState(166);
			match(T__4);
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << INT) | (1L << ID))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << INT) | (1L << ID))) != 0) );
			setState(172);
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
			setState(174);
			match(T__12);
			setState(175);
			match(T__16);
			setState(176);
			match(T__4);
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(178);
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
		public Token INT;
		public ExtensionMaxContext extensionMax;
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
			setState(180);
			match(T__19);
			setState(181);
			((ExtensionsContext)_localctx).INT = match(INT);
			setState(182);
			match(T__20);
			setState(183);
			((ExtensionsContext)_localctx).extensionMax = extensionMax();
			setState(184);
			match(T__1);
			 newExtensions(((ExtensionsContext)_localctx).INT.getText(), (((ExtensionsContext)_localctx).extensionMax!=null?_input.getText(((ExtensionsContext)_localctx).extensionMax.start,((ExtensionsContext)_localctx).extensionMax.stop):null)); 
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
			setState(187);
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
			setState(189);
			match(ID);
			setState(191);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(190);
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
			setState(193);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==INT) ) {
			_errHandler.recoverInline(this);
			} else {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00c6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\5\2\"\n\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\6\2\61\n\2\r"+
		"\2\16\2\62\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B"+
		"\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\5\7"+
		"S\n\7\3\7\3\7\3\7\3\7\3\7\5\7Z\n\7\3\7\6\7]\n\7\r\7\16\7^\3\7\3\7\3\7"+
		"\3\7\5\7e\n\7\3\7\3\7\3\7\3\7\3\7\5\7l\n\7\3\7\6\7o\n\7\r\7\16\7p\3\7"+
		"\3\7\3\7\3\7\5\7w\n\7\3\7\3\7\3\7\3\7\3\7\5\7~\n\7\3\7\6\7\u0081\n\7\r"+
		"\7\16\7\u0082\3\7\3\7\3\7\5\7\u0088\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u008f"+
		"\n\b\3\b\3\b\3\t\3\t\3\t\5\t\u0096\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u009f\n\n\3\n\3\n\5\n\u00a3\n\n\3\n\3\n\3\13\3\13\3\13\3\13\6\13\u00ab"+
		"\n\13\r\13\16\13\u00ac\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\5\17\u00c2\n\17\3\20\3\20\3\20\2\2"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\5\5\2\t\t\21\21\32\33\3\2"+
		"\24\25\4\2\30\30\32\32\u00ce\2!\3\2\2\2\4\66\3\2\2\2\6;\3\2\2\2\bC\3\2"+
		"\2\2\nJ\3\2\2\2\f\u0087\3\2\2\2\16\u0089\3\2\2\2\20\u0095\3\2\2\2\22\u0097"+
		"\3\2\2\2\24\u00a6\3\2\2\2\26\u00b0\3\2\2\2\30\u00b6\3\2\2\2\32\u00bd\3"+
		"\2\2\2\34\u00bf\3\2\2\2\36\u00c3\3\2\2\2 \"\5\4\3\2! \3\2\2\2!\"\3\2\2"+
		"\2\"&\3\2\2\2#%\5\b\5\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\',\3"+
		"\2\2\2(&\3\2\2\2)+\5\n\6\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\60"+
		"\3\2\2\2.,\3\2\2\2/\61\5\f\7\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2"+
		"\62\63\3\2\2\2\63\64\3\2\2\2\64\65\b\2\1\2\65\3\3\2\2\2\66\67\7\3\2\2"+
		"\678\5\6\4\289\b\3\1\29:\7\4\2\2:\5\3\2\2\2;@\7\33\2\2<=\7\5\2\2=?\7\33"+
		"\2\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\7\3\2\2\2B@\3\2\2\2CD\7"+
		"\6\2\2DE\5\32\16\2EF\7\7\2\2FG\7\33\2\2GH\b\5\1\2HI\7\4\2\2I\t\3\2\2\2"+
		"JK\7\b\2\2KL\7\t\2\2LM\7\33\2\2MN\7\t\2\2NO\b\6\1\2OP\7\4\2\2P\13\3\2"+
		"\2\2QS\7\35\2\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\n\2\2UV\7\33\2\2VW\b"+
		"\7\1\2WY\7\13\2\2XZ\7\35\2\2YX\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\5\20\t\2"+
		"\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\f\2\2ab\b\7\1"+
		"\2b\u0088\3\2\2\2ce\7\35\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\r\2\2g"+
		"h\7\33\2\2hi\b\7\1\2ik\7\13\2\2jl\7\35\2\2kj\3\2\2\2kl\3\2\2\2ln\3\2\2"+
		"\2mo\5\16\b\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\f"+
		"\2\2st\b\7\1\2t\u0088\3\2\2\2uw\7\35\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2"+
		"xy\7\16\2\2yz\7\33\2\2z{\b\7\1\2{}\7\13\2\2|~\7\35\2\2}|\3\2\2\2}~\3\2"+
		"\2\2~\u0080\3\2\2\2\177\u0081\5\20\t\2\u0080\177\3\2\2\2\u0081\u0082\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\7\f\2\2\u0085\u0086\b\7\1\2\u0086\u0088\3\2\2\2\u0087R\3\2\2\2"+
		"\u0087d\3\2\2\2\u0087v\3\2\2\2\u0088\r\3\2\2\2\u0089\u008a\7\33\2\2\u008a"+
		"\u008b\7\7\2\2\u008b\u008c\7\32\2\2\u008c\u008e\7\4\2\2\u008d\u008f\7"+
		"\35\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\b\b\1\2\u0091\17\3\2\2\2\u0092\u0096\5\22\n\2\u0093\u0096\5\30"+
		"\r\2\u0094\u0096\5\f\7\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\21\3\2\2\2\u0097\u0098\7\31\2\2\u0098\u0099\5\34"+
		"\17\2\u0099\u009a\7\33\2\2\u009a\u009b\7\7\2\2\u009b\u009e\7\32\2\2\u009c"+
		"\u009f\5\24\13\2\u009d\u009f\5\26\f\2\u009e\u009c\3\2\2\2\u009e\u009d"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\7\4\2\2\u00a1"+
		"\u00a3\7\35\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3"+
		"\2\2\2\u00a4\u00a5\b\n\1\2\u00a5\23\3\2\2\2\u00a6\u00a7\7\17\2\2\u00a7"+
		"\u00a8\7\20\2\2\u00a8\u00aa\7\7\2\2\u00a9\u00ab\t\2\2\2\u00aa\u00a9\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00af\7\22\2\2\u00af\25\3\2\2\2\u00b0\u00b1\7\17"+
		"\2\2\u00b1\u00b2\7\23\2\2\u00b2\u00b3\7\7\2\2\u00b3\u00b4\t\3\2\2\u00b4"+
		"\u00b5\7\22\2\2\u00b5\27\3\2\2\2\u00b6\u00b7\7\26\2\2\u00b7\u00b8\7\32"+
		"\2\2\u00b8\u00b9\7\27\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\7\4\2\2\u00bb"+
		"\u00bc\b\r\1\2\u00bc\31\3\2\2\2\u00bd\u00be\7\33\2\2\u00be\33\3\2\2\2"+
		"\u00bf\u00c1\7\33\2\2\u00c0\u00c2\7\32\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\35\3\2\2\2\u00c3\u00c4\t\4\2\2\u00c4\37\3\2\2\2\27!&,\62"+
		"@RY^dkpv}\u0082\u0087\u008e\u0095\u009e\u00a2\u00ac\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}