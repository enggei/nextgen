// Generated from src/com/generator/generators/mysql/parser/MySQL.g4 by ANTLR 4.1
package com.generator.generators.mysql.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MySQLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__164=1, T__163=2, T__162=3, T__161=4, T__160=5, T__159=6, T__158=7, 
		T__157=8, T__156=9, T__155=10, T__154=11, T__153=12, T__152=13, T__151=14, 
		T__150=15, T__149=16, T__148=17, T__147=18, T__146=19, T__145=20, T__144=21, 
		T__143=22, T__142=23, T__141=24, T__140=25, T__139=26, T__138=27, T__137=28, 
		T__136=29, T__135=30, T__134=31, T__133=32, T__132=33, T__131=34, T__130=35, 
		T__129=36, T__128=37, T__127=38, T__126=39, T__125=40, T__124=41, T__123=42, 
		T__122=43, T__121=44, T__120=45, T__119=46, T__118=47, T__117=48, T__116=49, 
		T__115=50, T__114=51, T__113=52, T__112=53, T__111=54, T__110=55, T__109=56, 
		T__108=57, T__107=58, T__106=59, T__105=60, T__104=61, T__103=62, T__102=63, 
		T__101=64, T__100=65, T__99=66, T__98=67, T__97=68, T__96=69, T__95=70, 
		T__94=71, T__93=72, T__92=73, T__91=74, T__90=75, T__89=76, T__88=77, 
		T__87=78, T__86=79, T__85=80, T__84=81, T__83=82, T__82=83, T__81=84, 
		T__80=85, T__79=86, T__78=87, T__77=88, T__76=89, T__75=90, T__74=91, 
		T__73=92, T__72=93, T__71=94, T__70=95, T__69=96, T__68=97, T__67=98, 
		T__66=99, T__65=100, T__64=101, T__63=102, T__62=103, T__61=104, T__60=105, 
		T__59=106, T__58=107, T__57=108, T__56=109, T__55=110, T__54=111, T__53=112, 
		T__52=113, T__51=114, T__50=115, T__49=116, T__48=117, T__47=118, T__46=119, 
		T__45=120, T__44=121, T__43=122, T__42=123, T__41=124, T__40=125, T__39=126, 
		T__38=127, T__37=128, T__36=129, T__35=130, T__34=131, T__33=132, T__32=133, 
		T__31=134, T__30=135, T__29=136, T__28=137, T__27=138, T__26=139, T__25=140, 
		T__24=141, T__23=142, T__22=143, T__21=144, T__20=145, T__19=146, T__18=147, 
		T__17=148, T__16=149, T__15=150, T__14=151, T__13=152, T__12=153, T__11=154, 
		T__10=155, T__9=156, T__8=157, T__7=158, T__6=159, T__5=160, T__4=161, 
		T__3=162, T__2=163, T__1=164, T__0=165, DEFAULTCHARSET=166, LINE_COMMENT=167, 
		COMMENT=168, ID=169, INT=170, WS=171;
	public static final String[] tokenNames = {
		"<INVALID>", "'ROW_FORMAT='", "'default'", "'INTEGER'", "'MATCH SIMPLE'", 
		"'CONSTRAINT'", "'USING'", "'ID'", "'set'", "'LONGBLOB'", "'ON UPDATE'", 
		"'MATCH FULL'", "'DECIMAL'", "'TINYTEXT'", "'DEFAULT CHARSET='", "'='", 
		"'COMMENT='", "'MEDIUMBLOB'", "'int'", "'on update'", "'binary'", "'BOOL'", 
		"','", "'PRIMARY'", "'MIN_ROWS='", "'RTREE'", "'modify'", "'DEFAULT CURRENT_TIMESTAMP'", 
		"'CURRENT_TIMESTAMP'", "'<'", "'//'", "'RESTRICT'", "'SMALLINT'", "'CHARACTER SET'", 
		"'TIMESTAMP'", "'BIT'", "'COMMENT'", "'+'", "'CREATE'", "'not null'", 
		"'NO ACTION'", "'primary key'", "'as'", "'AS'", "'datetime'", "'WHERE'", 
		"'integer'", "'INTO'", "'ON DELETE'", "';'", "'HASH'", "'PACK_KEYS='", 
		"'NOT NULL'", "'MATCH PARTIAL'", "'from'", "'IF EXISTS'", "'''", "'*'", 
		"'SELECT'", "'longtext'", "'ENGINE'", "'TEXT'", "'BINARY'", "'MODIFY'", 
		"'INT'", "'AUTO_INCREMENT'", "'CHAR'", "':'", "'INDEX'", "'COLLATE='", 
		"'select'", "'FIXED'", "'now()'", "'ALTER'", "'timestamp'", "'table'", 
		"'auto_increment'", "'FLOAT'", "'into'", "')'", "'CHECKSUM='", "'SET'", 
		"'FOREIGN KEY'", "'DOUBLE'", "'TIME'", "'CASCADE'", "'FROM'", "'alter'", 
		"'float'", "'REFERENCES'", "'DELAY_KEY_WRITE='", "'insert'", "'SET NULL'", 
		"'MAX_ROWS='", "'ZEROFILL'", "'COLLATE'", "'database'", "'bigint'", "'UNIQUE'", 
		"'null'", "'('", "'column'", "'AUTO_INCREMENT='", "'LONGTEXT'", "'DELIMITER'", 
		"'CAST'", "'foreign key'", "'DEFAULT b'0''", "'VARCHAR'", "'unique'", 
		"'UPDATE'", "'BTREE'", "'if exists'", "'BIGINT'", "'varchar'", "'DATETIME'", 
		"'ignore'", "'@'", "'tinyint'", "'IF NOT EXISTS'", "'INSERT'", "'TINYINT'", 
		"'NULL'", "'UNSIGNED'", "'/'", "'COLUMN'", "'TABLE'", "'unsigned'", "'CONNECTION='", 
		"'create'", "'DEFAULT'", "'bit'", "'BLOB'", "'NOT'", "'TYPE'", "'`'", 
		"'cast'", "'double'", "'ADD'", "'constraint'", "'KEY'", "'update'", "'MEDIUMTEXT'", 
		"'.'", "'DROP'", "'PRIMARY KEY'", "'add'", "'NOW()'", "'DATE'", "'key'", 
		"'DYNAMIC'", "'drop'", "'>'", "'where'", "'USE'", "'%'", "'IN'", "'\"'", 
		"'in'", "'DATABASE'", "'IGNORE'", "'not'", "'ENUM'", "'-'", "'references'", 
		"'index'", "DEFAULTCHARSET", "LINE_COMMENT", "COMMENT", "ID", "INT", "WS"
	};
	public static final int
		RULE_database = 0, RULE_createDatabase = 1, RULE_createTableStatement = 2, 
		RULE_alterTableStatement = 3, RULE_addColumn = 4, RULE_modifyColumn = 5, 
		RULE_dropColumn = 6, RULE_addIndex = 7, RULE_dropIndex = 8, RULE_addConstraint = 9, 
		RULE_procedure = 10, RULE_updateStatement = 11, RULE_insertStatement = 12, 
		RULE_selectStatement = 13, RULE_procedureContent = 14, RULE_tableConstraint = 15, 
		RULE_primaryKey = 16, RULE_primaryKeyCol = 17, RULE_uniqueKey = 18, RULE_uniqueKeyCol = 19, 
		RULE_indexKey = 20, RULE_indexKeyCol = 21, RULE_foreignKey = 22, RULE_referencesDefinition = 23, 
		RULE_referencesAction = 24, RULE_referenceOption = 25, RULE_indexType = 26, 
		RULE_columnSpecification = 27, RULE_nullable = 28, RULE_columnDefinition = 29, 
		RULE_autoIncrement = 30, RULE_defaultValue = 31, RULE_dataType = 32, RULE_tableOption = 33, 
		RULE_rowFormat = 34, RULE_onUpdate = 35, RULE_colName = 36, RULE_name = 37;
	public static final String[] ruleNames = {
		"database", "createDatabase", "createTableStatement", "alterTableStatement", 
		"addColumn", "modifyColumn", "dropColumn", "addIndex", "dropIndex", "addConstraint", 
		"procedure", "updateStatement", "insertStatement", "selectStatement", 
		"procedureContent", "tableConstraint", "primaryKey", "primaryKeyCol", 
		"uniqueKey", "uniqueKeyCol", "indexKey", "indexKeyCol", "foreignKey", 
		"referencesDefinition", "referencesAction", "referenceOption", "indexType", 
		"columnSpecification", "nullable", "columnDefinition", "autoIncrement", 
		"defaultValue", "dataType", "tableOption", "rowFormat", "onUpdate", "colName", 
		"name"
	};

	@Override
	public String getGrammarFileName() { return "MySQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	   public void createTable(String name) { };

	   public void procedure(String name) { };

	   public void newColumn(String name) { };

	   public void column(String type, boolean nullable, String defaultValue, String onUpdate, String autoIncrement) { };

	   public void primaryKeyColumn(String column) { };

	   public void primaryKeyType(String indexType) { };

	   public void newUniqueKey() { };

	   public void uniqueKey(String name) { };

	   public void uniqueKeyIndex(String indexType) { };

	   public void uniqueKeyColumn(String column) { };

	   public void newIndexKey() { };

	   public void indexKey(String name) { };

	   public void indexKeyIndex(String indexType) { };

	   public void indexKeyColumn(String column) { };

	   public void newConstraint() { };

	   public void foreignKey(String name) { };

	   public void foreignKeyColumn(String column) { };

	   public void foreignKeyReference(String refTable, String refColumn) { };

	   public void foreignKeyOnDelete(String onDelete) { };

	   public void foreignKeyOnUpdate(String onUpdate) { };

	   public void tableOption(String name, String value) { };

	   public void tableCreated() { };

	   public void done() { };
	   
	   static String prepDefaultValue(String val) {
	      if (val == null) return null;
	      val = val.substring("DEFAULT ".length());
	      return val.equals("'00000000'") ? "'0000-00-00'" : val;
	   }

	   static String prepComment(String val) {
	      if (val == null || val.length() == 0) return null;
	      val = val.startsWith("'") ? val.substring(1, val.length() - 1) : val;
	      return val;
	   }	

	   public static TokenStream createLexer(java.io.Reader reader) throws java.io.IOException {
		  final ANTLRInputStream input = new ANTLRInputStream(reader);
		  final MySQLLexer lexer = new MySQLLexer(input);
		  return new CommonTokenStream(lexer);
	   }

	public MySQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DatabaseContext extends ParserRuleContext {
		public List<TerminalNode> COMMENT() { return getTokens(MySQLParser.COMMENT); }
		public List<AlterTableStatementContext> alterTableStatement() {
			return getRuleContexts(AlterTableStatementContext.class);
		}
		public List<UpdateStatementContext> updateStatement() {
			return getRuleContexts(UpdateStatementContext.class);
		}
		public List<CreateDatabaseContext> createDatabase() {
			return getRuleContexts(CreateDatabaseContext.class);
		}
		public InsertStatementContext insertStatement(int i) {
			return getRuleContext(InsertStatementContext.class,i);
		}
		public CreateTableStatementContext createTableStatement(int i) {
			return getRuleContext(CreateTableStatementContext.class,i);
		}
		public ProcedureContext procedure(int i) {
			return getRuleContext(ProcedureContext.class,i);
		}
		public UpdateStatementContext updateStatement(int i) {
			return getRuleContext(UpdateStatementContext.class,i);
		}
		public List<InsertStatementContext> insertStatement() {
			return getRuleContexts(InsertStatementContext.class);
		}
		public List<ProcedureContext> procedure() {
			return getRuleContexts(ProcedureContext.class);
		}
		public List<TerminalNode> LINE_COMMENT() { return getTokens(MySQLParser.LINE_COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(MySQLParser.COMMENT, i);
		}
		public CreateDatabaseContext createDatabase(int i) {
			return getRuleContext(CreateDatabaseContext.class,i);
		}
		public List<CreateTableStatementContext> createTableStatement() {
			return getRuleContexts(CreateTableStatementContext.class);
		}
		public TerminalNode LINE_COMMENT(int i) {
			return getToken(MySQLParser.LINE_COMMENT, i);
		}
		public AlterTableStatementContext alterTableStatement(int i) {
			return getRuleContext(AlterTableStatementContext.class,i);
		}
		public DatabaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database; }
	}

	public final DatabaseContext database() throws RecognitionException {
		DatabaseContext _localctx = new DatabaseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_database);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					setState(87);
					switch (_input.LA(1)) {
					case LINE_COMMENT:
						{
						setState(76); match(LINE_COMMENT);
						}
						break;
					case COMMENT:
						{
						setState(77); match(COMMENT);
						}
						break;
					case 38:
					case 49:
					case 73:
					case 87:
					case 91:
					case 104:
					case 110:
					case 120:
					case 129:
					case 141:
					case 144:
					case 151:
					case 154:
						{
						setState(85);
						switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
						case 1:
							{
							setState(78); createDatabase();
							}
							break;

						case 2:
							{
							setState(79); createTableStatement();
							}
							break;

						case 3:
							{
							setState(80); alterTableStatement();
							}
							break;

						case 4:
							{
							setState(81); procedure();
							}
							break;

						case 5:
							{
							setState(82); updateStatement();
							}
							break;

						case 6:
							{
							setState(83); insertStatement();
							}
							break;

						case 7:
							{
							setState(84); match(49);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class CreateDatabaseContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public CreateDatabaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDatabase; }
	}

	public final CreateDatabaseContext createDatabase() throws RecognitionException {
		CreateDatabaseContext _localctx = new CreateDatabaseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_createDatabase);
		int _la;
		try {
			setState(104);
			switch (_input.LA(1)) {
			case 38:
			case 129:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				_la = _input.LA(1);
				if ( !(_la==38 || _la==129) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(93);
				_la = _input.LA(1);
				if ( !(_la==96 || _la==159) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(95);
				_la = _input.LA(1);
				if (_la==119) {
					{
					setState(94); match(119);
					}
				}

				setState(97); name();
				setState(98); match(49);
				}
				break;
			case 154:
				enterOuterAlt(_localctx, 2);
				{
				setState(100); match(154);
				setState(101); name();
				setState(102); match(49);
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

	public static class CreateTableStatementContext extends ParserRuleContext {
		public NameContext name;
		public ColumnSpecificationContext columnSpecification(int i) {
			return getRuleContext(ColumnSpecificationContext.class,i);
		}
		public TableConstraintContext tableConstraint(int i) {
			return getRuleContext(TableConstraintContext.class,i);
		}
		public TableOptionContext tableOption(int i) {
			return getRuleContext(TableOptionContext.class,i);
		}
		public List<ColumnSpecificationContext> columnSpecification() {
			return getRuleContexts(ColumnSpecificationContext.class);
		}
		public List<TableOptionContext> tableOption() {
			return getRuleContexts(TableOptionContext.class);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TableConstraintContext> tableConstraint() {
			return getRuleContexts(TableConstraintContext.class);
		}
		public CreateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStatement; }
	}

	public final CreateTableStatementContext createTableStatement() throws RecognitionException {
		CreateTableStatementContext _localctx = new CreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_createTableStatement);
		int _la;
		try {
			int _alt;
			setState(147);
			switch (_input.LA(1)) {
			case 144:
			case 151:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				_la = _input.LA(1);
				if ( !(_la==144 || _la==151) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(107);
				_la = _input.LA(1);
				if ( !(_la==75 || _la==126) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(109);
				_la = _input.LA(1);
				if (_la==55 || _la==112) {
					{
					setState(108);
					_la = _input.LA(1);
					if ( !(_la==55 || _la==112) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(111); name();
				}
				break;
			case 38:
			case 129:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				_la = _input.LA(1);
				if ( !(_la==38 || _la==129) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(113);
				_la = _input.LA(1);
				if ( !(_la==75 || _la==126) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(115);
				_la = _input.LA(1);
				if (_la==119) {
					{
					setState(114); match(119);
					}
				}

				setState(117); ((CreateTableStatementContext)_localctx).name = name();
				 createTable((((CreateTableStatementContext)_localctx).name!=null?_input.getText(((CreateTableStatementContext)_localctx).name.start,((CreateTableStatementContext)_localctx).name.stop):null).substring(0,(((CreateTableStatementContext)_localctx).name!=null?_input.getText(((CreateTableStatementContext)_localctx).name.start,((CreateTableStatementContext)_localctx).name.stop):null).length()-1));
				setState(119); match(100);
				setState(120); columnSpecification();
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(121); match(22);
						setState(122); columnSpecification();
						}
						} 
					}
					setState(127);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==22) {
					{
					{
					setState(128); match(22);
					setState(129); tableConstraint();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135); match(79);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 14) | (1L << 16) | (1L << 24) | (1L << 51) | (1L << 60))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (69 - 69)) | (1L << (80 - 69)) | (1L << (90 - 69)) | (1L << (93 - 69)) | (1L << (102 - 69)) | (1L << (128 - 69)))) != 0) || _la==134) {
					{
					{
					setState(136); tableOption();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(142); match(49);
					}
					break;
				}
				 tableCreated(); 
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

	public static class AlterTableStatementContext extends ParserRuleContext {
		public List<AddColumnContext> addColumn() {
			return getRuleContexts(AddColumnContext.class);
		}
		public List<ModifyColumnContext> modifyColumn() {
			return getRuleContexts(ModifyColumnContext.class);
		}
		public AddIndexContext addIndex(int i) {
			return getRuleContext(AddIndexContext.class,i);
		}
		public DropIndexContext dropIndex(int i) {
			return getRuleContext(DropIndexContext.class,i);
		}
		public DropColumnContext dropColumn(int i) {
			return getRuleContext(DropColumnContext.class,i);
		}
		public AddColumnContext addColumn(int i) {
			return getRuleContext(AddColumnContext.class,i);
		}
		public List<DropColumnContext> dropColumn() {
			return getRuleContexts(DropColumnContext.class);
		}
		public ModifyColumnContext modifyColumn(int i) {
			return getRuleContext(ModifyColumnContext.class,i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<AddConstraintContext> addConstraint() {
			return getRuleContexts(AddConstraintContext.class);
		}
		public AddConstraintContext addConstraint(int i) {
			return getRuleContext(AddConstraintContext.class,i);
		}
		public List<AddIndexContext> addIndex() {
			return getRuleContexts(AddIndexContext.class);
		}
		public List<DropIndexContext> dropIndex() {
			return getRuleContexts(DropIndexContext.class);
		}
		public AlterTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterTableStatement; }
	}

	public final AlterTableStatementContext alterTableStatement() throws RecognitionException {
		AlterTableStatementContext _localctx = new AlterTableStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_alterTableStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !(_la==73 || _la==87) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(150);
			_la = _input.LA(1);
			if ( !(_la==75 || _la==126) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(151); name();
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(159);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(152); addColumn();
						}
						break;

					case 2:
						{
						setState(153); dropColumn();
						}
						break;

					case 3:
						{
						setState(154); modifyColumn();
						}
						break;

					case 4:
						{
						setState(155); addIndex();
						}
						break;

					case 5:
						{
						setState(156); dropIndex();
						}
						break;

					case 6:
						{
						setState(157); addConstraint();
						}
						break;

					case 7:
						{
						setState(158); match(22);
						}
						break;
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class AddColumnContext extends ParserRuleContext {
		public ColumnSpecificationContext columnSpecification() {
			return getRuleContext(ColumnSpecificationContext.class,0);
		}
		public AddColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addColumn; }
	}

	public final AddColumnContext addColumn() throws RecognitionException {
		AddColumnContext _localctx = new AddColumnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_addColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==138 || _la==146) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(165);
			_la = _input.LA(1);
			if ( !(_la==101 || _la==125) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(166); columnSpecification();
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

	public static class ModifyColumnContext extends ParserRuleContext {
		public ColumnSpecificationContext columnSpecification() {
			return getRuleContext(ColumnSpecificationContext.class,0);
		}
		public ModifyColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifyColumn; }
	}

	public final ModifyColumnContext modifyColumn() throws RecognitionException {
		ModifyColumnContext _localctx = new ModifyColumnContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_modifyColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !(_la==26 || _la==63) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(170);
			_la = _input.LA(1);
			if (_la==101 || _la==125) {
				{
				setState(169);
				_la = _input.LA(1);
				if ( !(_la==101 || _la==125) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(172); columnSpecification();
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

	public static class DropColumnContext extends ParserRuleContext {
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public DropColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropColumn; }
	}

	public final DropColumnContext dropColumn() throws RecognitionException {
		DropColumnContext _localctx = new DropColumnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dropColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_la = _input.LA(1);
			if ( !(_la==144 || _la==151) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(175);
			_la = _input.LA(1);
			if ( !(_la==101 || _la==125) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(176); colName();
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

	public static class AddIndexContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public AddIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addIndex; }
	}

	public final AddIndexContext addIndex() throws RecognitionException {
		AddIndexContext _localctx = new AddIndexContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_addIndex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !(_la==138 || _la==146) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(179);
			_la = _input.LA(1);
			if ( !(_la==68 || _la==165) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(180); name();
			setState(181); match(100);
			setState(182); colName();
			setState(183); match(79);
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

	public static class DropIndexContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public DropIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropIndex; }
	}

	public final DropIndexContext dropIndex() throws RecognitionException {
		DropIndexContext _localctx = new DropIndexContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dropIndex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !(_la==144 || _la==151) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(186);
			_la = _input.LA(1);
			if ( !(_la==68 || _la==165) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(187); name();
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

	public static class AddConstraintContext extends ParserRuleContext {
		public ForeignKeyContext foreignKey() {
			return getRuleContext(ForeignKeyContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public AddConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addConstraint; }
	}

	public final AddConstraintContext addConstraint() throws RecognitionException {
		AddConstraintContext _localctx = new AddConstraintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_addConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !(_la==138 || _la==146) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==139) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(191); name();
				}
				break;

			case 2:
				{
				setState(192); foreignKey();
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

	public static class ProcedureContext extends ParserRuleContext {
		public ProcedureContentContext procedureContent;
		public ProcedureContentContext procedureContent() {
			return getRuleContext(ProcedureContentContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_procedure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(104);
			setState(196); match(30);
			setState(197); ((ProcedureContext)_localctx).procedureContent = procedureContent();
			 procedure((((ProcedureContext)_localctx).procedureContent!=null?_input.getText(((ProcedureContext)_localctx).procedureContent.start,((ProcedureContext)_localctx).procedureContent.stop):null));  
			setState(199); match(104);
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

	public static class UpdateStatementContext extends ParserRuleContext {
		public ColNameContext colName(int i) {
			return getRuleContext(ColNameContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(MySQLParser.ID); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<ColNameContext> colName() {
			return getRuleContexts(ColNameContext.class);
		}
		public TerminalNode ID(int i) {
			return getToken(MySQLParser.ID, i);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public UpdateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStatement; }
	}

	public final UpdateStatementContext updateStatement() throws RecognitionException {
		UpdateStatementContext _localctx = new UpdateStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_updateStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_la = _input.LA(1);
			if ( !(_la==110 || _la==141) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(203);
			_la = _input.LA(1);
			if (_la==116 || _la==160) {
				{
				setState(202);
				_la = _input.LA(1);
				if ( !(_la==116 || _la==160) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(205); name();
			setState(206);
			_la = _input.LA(1);
			if ( !(_la==8 || _la==81) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(207); colName();
					setState(208); match(15);
					setState(243);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						setState(209);
						_la = _input.LA(1);
						if ( !(_la==72 || _la==147) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;

					case 2:
						{
						setState(213);
						switch (_input.LA(1)) {
						case 122:
							{
							setState(210); match(122);
							}
							break;
						case EOF:
						case 7:
						case 22:
						case 34:
						case 36:
						case 38:
						case 45:
						case 49:
						case 61:
						case 73:
						case 87:
						case 91:
						case 104:
						case 110:
						case 120:
						case 129:
						case 134:
						case 135:
						case 141:
						case 144:
						case 148:
						case 151:
						case 153:
						case 154:
						case LINE_COMMENT:
						case COMMENT:
						case ID:
						case INT:
							{
							}
							break;
						case 99:
							{
							setState(212); match(99);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;

					case 3:
						{
						setState(216);
						_la = _input.LA(1);
						if (_la==56) {
							{
							setState(215); match(56);
							}
						}

						setState(218); match(ID);
						setState(220);
						_la = _input.LA(1);
						if (_la==56) {
							{
							setState(219); match(56);
							}
						}

						}
						break;

					case 4:
						{
						{
						setState(222);
						_la = _input.LA(1);
						if ( !(_la==105 || _la==136) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(224);
						_la = _input.LA(1);
						if (_la==100) {
							{
							setState(223); match(100);
							}
						}

						}
						setState(226); colName();
						setState(234);
						_la = _input.LA(1);
						if (_la==42 || _la==43) {
							{
							setState(227);
							_la = _input.LA(1);
							if ( !(_la==42 || _la==43) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(231);
							switch (_input.LA(1)) {
							case 123:
								{
								setState(228); match(123);
								}
								break;
							case 127:
								{
								setState(229); match(127);
								}
								break;
							case 3:
							case 9:
							case 12:
							case 13:
							case 17:
							case 18:
							case 21:
							case 32:
							case 34:
							case 35:
							case 44:
							case 46:
							case 59:
							case 61:
							case 62:
							case 64:
							case 66:
							case 74:
							case 77:
							case 83:
							case 84:
							case 88:
							case 97:
							case 103:
							case 108:
							case 113:
							case 114:
							case 115:
							case 118:
							case 121:
							case 131:
							case 132:
							case 137:
							case 142:
							case 148:
							case 162:
								{
								setState(230); dataType();
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(233); match(79);
							}
						}

						}
						break;

					case 5:
						{
						setState(237);
						_la = _input.LA(1);
						if (_la==157) {
							{
							setState(236); match(157);
							}
						}

						setState(239); match(ID);
						setState(241);
						_la = _input.LA(1);
						if (_la==157) {
							{
							setState(240); match(157);
							}
						}

						}
						break;
					}
					setState(246);
					_la = _input.LA(1);
					if (_la==22) {
						{
						setState(245); match(22);
						}
					}

					}
					} 
				}
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(301);
			_la = _input.LA(1);
			if (_la==45 || _la==153) {
				{
				setState(253);
				_la = _input.LA(1);
				if ( !(_la==45 || _la==153) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(254); colName();
				setState(255); match(15);
				setState(257);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(256);
					_la = _input.LA(1);
					if ( !(_la==133 || _la==161) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				}
				setState(299);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(262);
					switch (_input.LA(1)) {
					case 122:
						{
						setState(259); match(122);
						}
						break;
					case EOF:
					case 38:
					case 49:
					case 73:
					case 87:
					case 91:
					case 104:
					case 110:
					case 120:
					case 129:
					case 141:
					case 144:
					case 151:
					case 154:
					case LINE_COMMENT:
					case COMMENT:
						{
						}
						break;
					case 99:
						{
						setState(261); match(99);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;

				case 2:
					{
					setState(265);
					_la = _input.LA(1);
					if (_la==56) {
						{
						setState(264); match(56);
						}
					}

					setState(267); match(ID);
					setState(269);
					_la = _input.LA(1);
					if (_la==56) {
						{
						setState(268); match(56);
						}
					}

					}
					break;

				case 3:
					{
					setState(271); colName();
					}
					break;

				case 4:
					{
					setState(273);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						setState(272); match(157);
						}
						break;
					}
					{
					setState(278);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(275);
							matchWildcard();
							}
							} 
						}
						setState(280);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					}
					}
					setState(282);
					_la = _input.LA(1);
					if (_la==157) {
						{
						setState(281); match(157);
						}
					}

					}
					break;

				case 5:
					{
					setState(284);
					_la = _input.LA(1);
					if ( !(_la==156 || _la==158) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(285); match(100);
					{
					setState(287);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						setState(286); match(157);
						}
						break;
					}
					{
					setState(292);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(289);
							matchWildcard();
							}
							} 
						}
						setState(294);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					}
					}
					setState(296);
					_la = _input.LA(1);
					if (_la==157) {
						{
						setState(295); match(157);
						}
					}

					}
					setState(298); match(79);
					}
					break;
				}
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

	public static class InsertStatementContext extends ParserRuleContext {
		public ColNameContext colName(int i) {
			return getRuleContext(ColNameContext.class,i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<ColNameContext> colName() {
			return getRuleContexts(ColNameContext.class);
		}
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public InsertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStatement; }
	}

	public final InsertStatementContext insertStatement() throws RecognitionException {
		InsertStatementContext _localctx = new InsertStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_insertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_la = _input.LA(1);
			if ( !(_la==91 || _la==120) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(304);
			_la = _input.LA(1);
			if ( !(_la==47 || _la==78) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(305); name();
			setState(306); match(100);
			setState(311); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(307); colName();
				}
				setState(309);
				_la = _input.LA(1);
				if (_la==22) {
					{
					setState(308); match(22);
					}
				}

				}
				}
				setState(313); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (135 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)) | (1L << (INT - 134)))) != 0) );
			setState(315); match(79);
			setState(316); selectStatement();
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

	public static class SelectStatementContext extends ParserRuleContext {
		public ColNameContext colName(int i) {
			return getRuleContext(ColNameContext.class,i);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<ColNameContext> colName() {
			return getRuleContexts(ColNameContext.class);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !(_la==58 || _la==70) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(323); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(319); colName();
				}
				setState(321);
				_la = _input.LA(1);
				if (_la==22) {
					{
					setState(320); match(22);
					}
				}

				}
				}
				setState(325); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (135 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)) | (1L << (INT - 134)))) != 0) );
			setState(327);
			_la = _input.LA(1);
			if ( !(_la==54 || _la==86) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(332); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(328); name();
				}
				setState(330);
				_la = _input.LA(1);
				if (_la==22) {
					{
					setState(329); match(22);
					}
				}

				}
				}
				setState(334); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (135 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)))) != 0) );
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

	public static class ProcedureContentContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MySQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MySQLParser.ID, i);
		}
		public ProcedureContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureContent; }
	}

	public final ProcedureContentContext procedureContent() throws RecognitionException {
		ProcedureContentContext _localctx = new ProcedureContentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_procedureContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (75 - 64)) | (1L << (76 - 64)) | (1L << (77 - 64)) | (1L << (78 - 64)) | (1L << (79 - 64)) | (1L << (80 - 64)) | (1L << (81 - 64)) | (1L << (82 - 64)) | (1L << (83 - 64)) | (1L << (84 - 64)) | (1L << (85 - 64)) | (1L << (86 - 64)) | (1L << (87 - 64)) | (1L << (88 - 64)) | (1L << (89 - 64)) | (1L << (90 - 64)) | (1L << (91 - 64)) | (1L << (92 - 64)) | (1L << (93 - 64)) | (1L << (94 - 64)) | (1L << (95 - 64)) | (1L << (96 - 64)) | (1L << (97 - 64)) | (1L << (98 - 64)) | (1L << (99 - 64)) | (1L << (100 - 64)) | (1L << (101 - 64)) | (1L << (102 - 64)) | (1L << (103 - 64)) | (1L << (105 - 64)) | (1L << (106 - 64)) | (1L << (107 - 64)) | (1L << (108 - 64)) | (1L << (109 - 64)) | (1L << (110 - 64)) | (1L << (111 - 64)) | (1L << (112 - 64)) | (1L << (113 - 64)) | (1L << (114 - 64)) | (1L << (115 - 64)) | (1L << (116 - 64)) | (1L << (117 - 64)) | (1L << (118 - 64)) | (1L << (119 - 64)) | (1L << (120 - 64)) | (1L << (121 - 64)) | (1L << (122 - 64)) | (1L << (123 - 64)) | (1L << (124 - 64)) | (1L << (125 - 64)) | (1L << (126 - 64)) | (1L << (127 - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (128 - 128)) | (1L << (129 - 128)) | (1L << (130 - 128)) | (1L << (131 - 128)) | (1L << (132 - 128)) | (1L << (133 - 128)) | (1L << (134 - 128)) | (1L << (135 - 128)) | (1L << (136 - 128)) | (1L << (137 - 128)) | (1L << (138 - 128)) | (1L << (139 - 128)) | (1L << (140 - 128)) | (1L << (141 - 128)) | (1L << (142 - 128)) | (1L << (143 - 128)) | (1L << (144 - 128)) | (1L << (145 - 128)) | (1L << (146 - 128)) | (1L << (147 - 128)) | (1L << (148 - 128)) | (1L << (149 - 128)) | (1L << (150 - 128)) | (1L << (151 - 128)) | (1L << (152 - 128)) | (1L << (153 - 128)) | (1L << (154 - 128)) | (1L << (155 - 128)) | (1L << (156 - 128)) | (1L << (157 - 128)) | (1L << (158 - 128)) | (1L << (159 - 128)) | (1L << (160 - 128)) | (1L << (161 - 128)) | (1L << (162 - 128)) | (1L << (163 - 128)) | (1L << (164 - 128)) | (1L << (165 - 128)) | (1L << (DEFAULTCHARSET - 128)) | (1L << (LINE_COMMENT - 128)) | (1L << (COMMENT - 128)) | (1L << (ID - 128)) | (1L << (INT - 128)) | (1L << (WS - 128)))) != 0)) {
				{
				setState(349);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(336); match(ID);
					}
					break;

				case 2:
					{
					setState(337); match(117);
					}
					break;

				case 3:
					{
					setState(338); match(143);
					}
					break;

				case 4:
					{
					setState(339); match(155);
					}
					break;

				case 5:
					{
					setState(340); match(37);
					}
					break;

				case 6:
					{
					setState(341); match(163);
					}
					break;

				case 7:
					{
					setState(342); match(57);
					}
					break;

				case 8:
					{
					setState(343); match(124);
					}
					break;

				case 9:
					{
					setState(344); match(29);
					}
					break;

				case 10:
					{
					setState(345); match(152);
					}
					break;

				case 11:
					{
					setState(346); match(67);
					}
					break;

				case 12:
					{
					setState(347); match(49);
					}
					break;

				case 13:
					{
					setState(348);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==104) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				}
				}
				setState(353);
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

	public static class TableConstraintContext extends ParserRuleContext {
		public PrimaryKeyContext primaryKey() {
			return getRuleContext(PrimaryKeyContext.class,0);
		}
		public ForeignKeyContext foreignKey() {
			return getRuleContext(ForeignKeyContext.class,0);
		}
		public IndexKeyContext indexKey() {
			return getRuleContext(IndexKeyContext.class,0);
		}
		public UniqueKeyContext uniqueKey() {
			return getRuleContext(UniqueKeyContext.class,0);
		}
		public TableConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableConstraint; }
	}

	public final TableConstraintContext tableConstraint() throws RecognitionException {
		TableConstraintContext _localctx = new TableConstraintContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tableConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			switch (_input.LA(1)) {
			case 41:
			case 145:
				{
				setState(354); primaryKey();
				}
				break;
			case 98:
			case 109:
				{
				setState(355); uniqueKey();
				}
				break;
			case 68:
			case 140:
			case 149:
			case 165:
				{
				setState(356); indexKey();
				}
				break;
			case 5:
			case 7:
			case 34:
			case 36:
			case 61:
			case 82:
			case 106:
			case 134:
			case 135:
			case 139:
			case 148:
			case ID:
				{
				setState(357); foreignKey();
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

	public static class PrimaryKeyContext extends ParserRuleContext {
		public IndexTypeContext c;
		public PrimaryKeyColContext a;
		public PrimaryKeyColContext b;
		public IndexTypeContext d;
		public IndexTypeContext indexType(int i) {
			return getRuleContext(IndexTypeContext.class,i);
		}
		public PrimaryKeyColContext primaryKeyCol(int i) {
			return getRuleContext(PrimaryKeyColContext.class,i);
		}
		public List<PrimaryKeyColContext> primaryKeyCol() {
			return getRuleContexts(PrimaryKeyColContext.class);
		}
		public List<IndexTypeContext> indexType() {
			return getRuleContexts(IndexTypeContext.class);
		}
		public PrimaryKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryKey; }
	}

	public final PrimaryKeyContext primaryKey() throws RecognitionException {
		PrimaryKeyContext _localctx = new PrimaryKeyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primaryKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_la = _input.LA(1);
			if ( !(_la==41 || _la==145) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(365);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(361); match(6);
				setState(362); ((PrimaryKeyContext)_localctx).c = indexType();
				 primaryKeyType((((PrimaryKeyContext)_localctx).c!=null?_input.getText(((PrimaryKeyContext)_localctx).c.start,((PrimaryKeyContext)_localctx).c.stop):null)); 
				}
			}

			setState(367); match(100);
			setState(368); ((PrimaryKeyContext)_localctx).a = primaryKeyCol();
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(369); match(22);
				setState(370); ((PrimaryKeyContext)_localctx).b = primaryKeyCol();
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(376); match(79);
			setState(381);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(377); match(6);
				setState(378); ((PrimaryKeyContext)_localctx).d = indexType();
				 primaryKeyType((((PrimaryKeyContext)_localctx).d!=null?_input.getText(((PrimaryKeyContext)_localctx).d.start,((PrimaryKeyContext)_localctx).d.stop):null)); 
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

	public static class PrimaryKeyColContext extends ParserRuleContext {
		public ColNameContext colName;
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public PrimaryKeyColContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryKeyCol; }
	}

	public final PrimaryKeyColContext primaryKeyCol() throws RecognitionException {
		PrimaryKeyColContext _localctx = new PrimaryKeyColContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primaryKeyCol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383); ((PrimaryKeyColContext)_localctx).colName = colName();
			 primaryKeyColumn((((PrimaryKeyColContext)_localctx).colName!=null?_input.getText(((PrimaryKeyColContext)_localctx).colName.start,((PrimaryKeyColContext)_localctx).colName.stop):null).substring(1,(((PrimaryKeyColContext)_localctx).colName!=null?_input.getText(((PrimaryKeyColContext)_localctx).colName.start,((PrimaryKeyColContext)_localctx).colName.stop):null).length()-1)); 
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

	public static class UniqueKeyContext extends ParserRuleContext {
		public NameContext name;
		public IndexTypeContext a;
		public IndexTypeContext b;
		public IndexTypeContext indexType(int i) {
			return getRuleContext(IndexTypeContext.class,i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public UniqueKeyColContext uniqueKeyCol(int i) {
			return getRuleContext(UniqueKeyColContext.class,i);
		}
		public List<IndexTypeContext> indexType() {
			return getRuleContexts(IndexTypeContext.class);
		}
		public List<UniqueKeyColContext> uniqueKeyCol() {
			return getRuleContexts(UniqueKeyColContext.class);
		}
		public UniqueKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniqueKey; }
	}

	public final UniqueKeyContext uniqueKey() throws RecognitionException {
		UniqueKeyContext _localctx = new UniqueKeyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_uniqueKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if ( !(_la==98 || _la==109) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(389);
			switch (_input.LA(1)) {
			case 140:
			case 149:
				{
				setState(387);
				_la = _input.LA(1);
				if ( !(_la==140 || _la==149) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 68:
			case 165:
				{
				setState(388);
				_la = _input.LA(1);
				if ( !(_la==68 || _la==165) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 6:
			case 7:
			case 34:
			case 36:
			case 61:
			case 79:
			case 100:
			case 134:
			case 135:
			case 148:
			case ID:
				break;
			default:
				throw new NoViableAltException(this);
			}
			 newUniqueKey(); 
			setState(393);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(392); match(100);
				}
				break;
			}
			setState(398);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (135 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)))) != 0)) {
				{
				setState(395); ((UniqueKeyContext)_localctx).name = name();
				 uniqueKey((((UniqueKeyContext)_localctx).name!=null?_input.getText(((UniqueKeyContext)_localctx).name.start,((UniqueKeyContext)_localctx).name.stop):null).substring(1,(((UniqueKeyContext)_localctx).name!=null?_input.getText(((UniqueKeyContext)_localctx).name.start,((UniqueKeyContext)_localctx).name.stop):null).length()-1)); 
				}
			}

			setState(401);
			_la = _input.LA(1);
			if (_la==79) {
				{
				setState(400); match(79);
				}
			}

			setState(407);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(403); match(6);
				setState(404); ((UniqueKeyContext)_localctx).a = indexType();
				 uniqueKeyIndex((((UniqueKeyContext)_localctx).a!=null?_input.getText(((UniqueKeyContext)_localctx).a.start,((UniqueKeyContext)_localctx).a.stop):null)); 
				}
			}

			setState(409); match(100);
			setState(410); uniqueKeyCol();
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(411); match(22);
				setState(412); uniqueKeyCol();
				}
				}
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(418); match(79);
			setState(423);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(419); match(6);
				setState(420); ((UniqueKeyContext)_localctx).b = indexType();
				 uniqueKeyIndex((((UniqueKeyContext)_localctx).b!=null?_input.getText(((UniqueKeyContext)_localctx).b.start,((UniqueKeyContext)_localctx).b.stop):null)); 
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

	public static class UniqueKeyColContext extends ParserRuleContext {
		public ColNameContext colName;
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public UniqueKeyColContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniqueKeyCol; }
	}

	public final UniqueKeyColContext uniqueKeyCol() throws RecognitionException {
		UniqueKeyColContext _localctx = new UniqueKeyColContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_uniqueKeyCol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425); ((UniqueKeyColContext)_localctx).colName = colName();
			 uniqueKeyColumn((((UniqueKeyColContext)_localctx).colName!=null?_input.getText(((UniqueKeyColContext)_localctx).colName.start,((UniqueKeyColContext)_localctx).colName.stop):null).substring(1,(((UniqueKeyColContext)_localctx).colName!=null?_input.getText(((UniqueKeyColContext)_localctx).colName.start,((UniqueKeyColContext)_localctx).colName.stop):null).length()-1)); 
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

	public static class IndexKeyContext extends ParserRuleContext {
		public NameContext name;
		public IndexTypeContext a;
		public IndexTypeContext b;
		public IndexTypeContext indexType(int i) {
			return getRuleContext(IndexTypeContext.class,i);
		}
		public List<IndexKeyColContext> indexKeyCol() {
			return getRuleContexts(IndexKeyColContext.class);
		}
		public IndexKeyColContext indexKeyCol(int i) {
			return getRuleContext(IndexKeyColContext.class,i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<IndexTypeContext> indexType() {
			return getRuleContexts(IndexTypeContext.class);
		}
		public IndexKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexKey; }
	}

	public final IndexKeyContext indexKey() throws RecognitionException {
		IndexKeyContext _localctx = new IndexKeyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_indexKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			switch (_input.LA(1)) {
			case 140:
			case 149:
				{
				setState(428);
				_la = _input.LA(1);
				if ( !(_la==140 || _la==149) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 68:
			case 165:
				{
				setState(429);
				_la = _input.LA(1);
				if ( !(_la==68 || _la==165) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 newIndexKey(); 
			setState(436);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (135 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)))) != 0)) {
				{
				setState(433); ((IndexKeyContext)_localctx).name = name();
				 indexKey((((IndexKeyContext)_localctx).name!=null?_input.getText(((IndexKeyContext)_localctx).name.start,((IndexKeyContext)_localctx).name.stop):null).substring(1,(((IndexKeyContext)_localctx).name!=null?_input.getText(((IndexKeyContext)_localctx).name.start,((IndexKeyContext)_localctx).name.stop):null).length()-1));
				}
			}

			setState(442);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(438); match(6);
				setState(439); ((IndexKeyContext)_localctx).a = indexType();
				 indexKeyIndex((((IndexKeyContext)_localctx).a!=null?_input.getText(((IndexKeyContext)_localctx).a.start,((IndexKeyContext)_localctx).a.stop):null));
				}
			}

			setState(444); match(100);
			setState(445); indexKeyCol();
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(446); match(22);
				setState(447); indexKeyCol();
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(453); match(79);
			setState(458);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(454); match(6);
				setState(455); ((IndexKeyContext)_localctx).b = indexType();
				 indexKeyIndex((((IndexKeyContext)_localctx).b!=null?_input.getText(((IndexKeyContext)_localctx).b.start,((IndexKeyContext)_localctx).b.stop):null)); 
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

	public static class IndexKeyColContext extends ParserRuleContext {
		public ColNameContext colName;
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public IndexKeyColContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexKeyCol; }
	}

	public final IndexKeyColContext indexKeyCol() throws RecognitionException {
		IndexKeyColContext _localctx = new IndexKeyColContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_indexKeyCol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); ((IndexKeyColContext)_localctx).colName = colName();
			 indexKeyColumn((((IndexKeyColContext)_localctx).colName!=null?_input.getText(((IndexKeyColContext)_localctx).colName.start,((IndexKeyColContext)_localctx).colName.stop):null)); 
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

	public static class ForeignKeyContext extends ParserRuleContext {
		public NameContext name;
		public ColNameContext colName;
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public ReferencesDefinitionContext referencesDefinition() {
			return getRuleContext(ReferencesDefinitionContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ForeignKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreignKey; }
	}

	public final ForeignKeyContext foreignKey() throws RecognitionException {
		ForeignKeyContext _localctx = new ForeignKeyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_foreignKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_la = _input.LA(1);
			if (_la==5 || _la==139) {
				{
				setState(463);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==139) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			 newConstraint(); 
			setState(470);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (135 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)))) != 0)) {
				{
				setState(467); ((ForeignKeyContext)_localctx).name = name();
				 foreignKey((((ForeignKeyContext)_localctx).name!=null?_input.getText(((ForeignKeyContext)_localctx).name.start,((ForeignKeyContext)_localctx).name.stop):null).substring(1,(((ForeignKeyContext)_localctx).name!=null?_input.getText(((ForeignKeyContext)_localctx).name.start,((ForeignKeyContext)_localctx).name.stop):null).length()-1)); 
				}
			}

			setState(472);
			_la = _input.LA(1);
			if ( !(_la==82 || _la==106) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(473); match(100);
			setState(474); ((ForeignKeyContext)_localctx).colName = colName();
			 foreignKeyColumn((((ForeignKeyContext)_localctx).colName!=null?_input.getText(((ForeignKeyContext)_localctx).colName.start,((ForeignKeyContext)_localctx).colName.stop):null).substring(1,(((ForeignKeyContext)_localctx).colName!=null?_input.getText(((ForeignKeyContext)_localctx).colName.start,((ForeignKeyContext)_localctx).colName.stop):null).length()-1)); 
			setState(476); match(79);
			setState(477); referencesDefinition();
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

	public static class ReferencesDefinitionContext extends ParserRuleContext {
		public NameContext name;
		public ColNameContext colName;
		public List<ReferencesActionContext> referencesAction() {
			return getRuleContexts(ReferencesActionContext.class);
		}
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ReferencesActionContext referencesAction(int i) {
			return getRuleContext(ReferencesActionContext.class,i);
		}
		public ReferencesDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencesDefinition; }
	}

	public final ReferencesDefinitionContext referencesDefinition() throws RecognitionException {
		ReferencesDefinitionContext _localctx = new ReferencesDefinitionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_referencesDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_la = _input.LA(1);
			if ( !(_la==89 || _la==164) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(481);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (135 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)))) != 0)) {
				{
				setState(480); ((ReferencesDefinitionContext)_localctx).name = name();
				}
			}

			setState(483); match(100);
			setState(484); ((ReferencesDefinitionContext)_localctx).colName = colName();
			 foreignKeyReference((((ReferencesDefinitionContext)_localctx).name!=null?_input.getText(((ReferencesDefinitionContext)_localctx).name.start,((ReferencesDefinitionContext)_localctx).name.stop):null).substring(1,(((ReferencesDefinitionContext)_localctx).name!=null?_input.getText(((ReferencesDefinitionContext)_localctx).name.start,((ReferencesDefinitionContext)_localctx).name.stop):null).length()-1),(((ReferencesDefinitionContext)_localctx).colName!=null?_input.getText(((ReferencesDefinitionContext)_localctx).colName.start,((ReferencesDefinitionContext)_localctx).colName.stop):null).substring(1,(((ReferencesDefinitionContext)_localctx).colName!=null?_input.getText(((ReferencesDefinitionContext)_localctx).colName.start,((ReferencesDefinitionContext)_localctx).colName.stop):null).length()-1)); 
			setState(486); match(79);
			setState(488);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 11) | (1L << 53))) != 0)) {
				{
				setState(487);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 11) | (1L << 53))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==10 || _la==48) {
				{
				{
				setState(490); referencesAction();
				}
				}
				setState(495);
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

	public static class ReferencesActionContext extends ParserRuleContext {
		public ReferenceOptionContext referenceOption;
		public ReferenceOptionContext referenceOption() {
			return getRuleContext(ReferenceOptionContext.class,0);
		}
		public ReferencesActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencesAction; }
	}

	public final ReferencesActionContext referencesAction() throws RecognitionException {
		ReferencesActionContext _localctx = new ReferencesActionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_referencesAction);
		try {
			setState(504);
			switch (_input.LA(1)) {
			case 48:
				enterOuterAlt(_localctx, 1);
				{
				setState(496); match(48);
				setState(497); ((ReferencesActionContext)_localctx).referenceOption = referenceOption();
				 foreignKeyOnDelete((((ReferencesActionContext)_localctx).referenceOption!=null?_input.getText(((ReferencesActionContext)_localctx).referenceOption.start,((ReferencesActionContext)_localctx).referenceOption.stop):null)); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 2);
				{
				setState(500); match(10);
				setState(501); ((ReferencesActionContext)_localctx).referenceOption = referenceOption();
				 foreignKeyOnUpdate((((ReferencesActionContext)_localctx).referenceOption!=null?_input.getText(((ReferencesActionContext)_localctx).referenceOption.start,((ReferencesActionContext)_localctx).referenceOption.stop):null)); 
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

	public static class ReferenceOptionContext extends ParserRuleContext {
		public ReferenceOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceOption; }
	}

	public final ReferenceOptionContext referenceOption() throws RecognitionException {
		ReferenceOptionContext _localctx = new ReferenceOptionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_referenceOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			_la = _input.LA(1);
			if ( !(((((_la - 31)) & ~0x3f) == 0 && ((1L << (_la - 31)) & ((1L << (31 - 31)) | (1L << (40 - 31)) | (1L << (85 - 31)) | (1L << (92 - 31)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class IndexTypeContext extends ParserRuleContext {
		public IndexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexType; }
	}

	public final IndexTypeContext indexType() throws RecognitionException {
		IndexTypeContext _localctx = new IndexTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_indexType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_la = _input.LA(1);
			if ( !(_la==25 || _la==50 || _la==111) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ColumnSpecificationContext extends ParserRuleContext {
		public ColNameContext colName;
		public ColumnDefinitionContext columnDefinition() {
			return getRuleContext(ColumnDefinitionContext.class,0);
		}
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public ColumnSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnSpecification; }
	}

	public final ColumnSpecificationContext columnSpecification() throws RecognitionException {
		ColumnSpecificationContext _localctx = new ColumnSpecificationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_columnSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510); ((ColumnSpecificationContext)_localctx).colName = colName();
			 newColumn((((ColumnSpecificationContext)_localctx).colName!=null?_input.getText(((ColumnSpecificationContext)_localctx).colName.start,((ColumnSpecificationContext)_localctx).colName.stop):null).substring(1,(((ColumnSpecificationContext)_localctx).colName!=null?_input.getText(((ColumnSpecificationContext)_localctx).colName.start,((ColumnSpecificationContext)_localctx).colName.stop):null).length()-1)); 
			setState(512); columnDefinition();
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

	public static class NullableContext extends ParserRuleContext {
		public NullableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullable; }
	}

	public final NullableContext nullable() throws RecognitionException {
		NullableContext _localctx = new NullableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_nullable);
		int _la;
		try {
			setState(516);
			switch (_input.LA(1)) {
			case 52:
			case 122:
				enterOuterAlt(_localctx, 1);
				{
				setState(514);
				_la = _input.LA(1);
				if ( !(_la==52 || _la==122) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 39:
			case 99:
				enterOuterAlt(_localctx, 2);
				{
				setState(515);
				_la = _input.LA(1);
				if ( !(_la==39 || _la==99) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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

	public static class ColumnDefinitionContext extends ParserRuleContext {
		public DataTypeContext dataType;
		public NullableContext nullable;
		public DefaultValueContext defaultValue;
		public OnUpdateContext onUpdate;
		public AutoIncrementContext autoIncrement;
		public OnUpdateContext onUpdate() {
			return getRuleContext(OnUpdateContext.class,0);
		}
		public AutoIncrementContext autoIncrement() {
			return getRuleContext(AutoIncrementContext.class,0);
		}
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public NullableContext nullable() {
			return getRuleContext(NullableContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_columnDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(518); ((ColumnDefinitionContext)_localctx).dataType = dataType();
			setState(520);
			_la = _input.LA(1);
			if (_la==39 || _la==52 || _la==99 || _la==122) {
				{
				setState(519); ((ColumnDefinitionContext)_localctx).nullable = nullable();
				}
			}

			setState(523);
			_la = _input.LA(1);
			if (_la==2 || _la==27 || _la==107 || _la==130) {
				{
				setState(522); ((ColumnDefinitionContext)_localctx).defaultValue = defaultValue();
				}
			}

			setState(527);
			_la = _input.LA(1);
			if (_la==10 || _la==19) {
				{
				setState(525);
				_la = _input.LA(1);
				if ( !(_la==10 || _la==19) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				{
				setState(526); ((ColumnDefinitionContext)_localctx).onUpdate = onUpdate();
				}
				}
			}

			setState(530);
			_la = _input.LA(1);
			if (_la==65 || _la==76) {
				{
				setState(529); ((ColumnDefinitionContext)_localctx).autoIncrement = autoIncrement();
				}
			}

			setState(540);
			switch (_input.LA(1)) {
			case 98:
			case 109:
				{
				setState(532);
				_la = _input.LA(1);
				if ( !(_la==98 || _la==109) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(534);
				_la = _input.LA(1);
				if (_la==140 || _la==149) {
					{
					setState(533);
					_la = _input.LA(1);
					if ( !(_la==140 || _la==149) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				break;
			case 23:
			case 140:
				{
				setState(537);
				_la = _input.LA(1);
				if (_la==23) {
					{
					setState(536); match(23);
					}
				}

				setState(539); match(140);
				}
				break;
			case EOF:
			case 22:
			case 26:
			case 36:
			case 38:
			case 49:
			case 63:
			case 73:
			case 79:
			case 87:
			case 91:
			case 104:
			case 110:
			case 120:
			case 129:
			case 138:
			case 141:
			case 144:
			case 146:
			case 151:
			case 154:
			case LINE_COMMENT:
			case COMMENT:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(549);
			_la = _input.LA(1);
			if (_la==36) {
				{
				setState(542); match(36);
				{
				setState(546);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(543);
						matchWildcard();
						}
						} 
					}
					setState(548);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				}
				}
				}
			}

			 column((((ColumnDefinitionContext)_localctx).dataType!=null?_input.getText(((ColumnDefinitionContext)_localctx).dataType.start,((ColumnDefinitionContext)_localctx).dataType.stop):null),!"NOT NULL".equals((((ColumnDefinitionContext)_localctx).nullable!=null?_input.getText(((ColumnDefinitionContext)_localctx).nullable.start,((ColumnDefinitionContext)_localctx).nullable.stop):null)),prepDefaultValue((((ColumnDefinitionContext)_localctx).defaultValue!=null?_input.getText(((ColumnDefinitionContext)_localctx).defaultValue.start,((ColumnDefinitionContext)_localctx).defaultValue.stop):null)),(((ColumnDefinitionContext)_localctx).onUpdate!=null?_input.getText(((ColumnDefinitionContext)_localctx).onUpdate.start,((ColumnDefinitionContext)_localctx).onUpdate.stop):null),(((ColumnDefinitionContext)_localctx).autoIncrement!=null?_input.getText(((ColumnDefinitionContext)_localctx).autoIncrement.start,((ColumnDefinitionContext)_localctx).autoIncrement.stop):null)); 
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

	public static class AutoIncrementContext extends ParserRuleContext {
		public AutoIncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoIncrement; }
	}

	public final AutoIncrementContext autoIncrement() throws RecognitionException {
		AutoIncrementContext _localctx = new AutoIncrementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_autoIncrement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_la = _input.LA(1);
			if ( !(_la==65 || _la==76) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		public TerminalNode INT() { return getToken(MySQLParser.INT, 0); }
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_defaultValue);
		int _la;
		try {
			setState(559);
			switch (_input.LA(1)) {
			case 2:
			case 130:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(555);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==130) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(556);
				_la = _input.LA(1);
				if ( !(_la==99 || _la==122 || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 2);
				{
				setState(557); match(27);
				}
				break;
			case 107:
				enterOuterAlt(_localctx, 3);
				{
				setState(558); match(107);
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

	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT(int i) {
			return getToken(MySQLParser.INT, i);
		}
		public List<TerminalNode> ID() { return getTokens(MySQLParser.ID); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(MySQLParser.ID, i);
		}
		public TerminalNode DEFAULTCHARSET() { return getToken(MySQLParser.DEFAULTCHARSET, 0); }
		public List<TerminalNode> INT() { return getTokens(MySQLParser.INT); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_dataType);
		int _la;
		try {
			setState(756);
			switch (_input.LA(1)) {
			case 35:
			case 131:
				enterOuterAlt(_localctx, 1);
				{
				setState(561);
				_la = _input.LA(1);
				if ( !(_la==35 || _la==131) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(565);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(562); match(100);
					setState(563); match(INT);
					setState(564); match(79);
					}
				}

				}
				break;
			case 118:
			case 121:
				enterOuterAlt(_localctx, 2);
				{
				setState(567);
				_la = _input.LA(1);
				if ( !(_la==118 || _la==121) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(571);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(568); match(100);
					setState(569); match(INT);
					setState(570); match(79);
					}
				}

				setState(574);
				_la = _input.LA(1);
				if (_la==123) {
					{
					setState(573); match(123);
					}
				}

				setState(577);
				_la = _input.LA(1);
				if (_la==94) {
					{
					setState(576); match(94);
					}
				}

				}
				break;
			case 97:
			case 113:
				enterOuterAlt(_localctx, 3);
				{
				setState(579);
				_la = _input.LA(1);
				if ( !(_la==97 || _la==113) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(583);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(580); match(100);
					setState(581); match(INT);
					setState(582); match(79);
					}
				}

				setState(586);
				_la = _input.LA(1);
				if (_la==123) {
					{
					setState(585); match(123);
					}
				}

				setState(589);
				_la = _input.LA(1);
				if (_la==94) {
					{
					setState(588); match(94);
					}
				}

				}
				break;
			case 3:
			case 18:
			case 46:
			case 64:
				enterOuterAlt(_localctx, 4);
				{
				setState(591);
				_la = _input.LA(1);
				if ( !(((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & ((1L << (3 - 3)) | (1L << (18 - 3)) | (1L << (46 - 3)) | (1L << (64 - 3)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(595);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(592); match(100);
					setState(593); match(INT);
					setState(594); match(79);
					}
				}

				setState(598);
				_la = _input.LA(1);
				if (_la==123) {
					{
					setState(597); match(123);
					}
				}

				setState(601);
				_la = _input.LA(1);
				if (_la==94) {
					{
					setState(600); match(94);
					}
				}

				}
				break;
			case 108:
			case 114:
				enterOuterAlt(_localctx, 5);
				{
				setState(603);
				_la = _input.LA(1);
				if ( !(_la==108 || _la==114) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(607);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(604); match(100);
					setState(605); match(INT);
					setState(606); match(79);
					}
				}

				setState(611);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(609); match(33);
					setState(610); match(DEFAULTCHARSET);
					}
				}

				setState(615);
				_la = _input.LA(1);
				if (_la==95) {
					{
					setState(613); match(95);
					setState(614); name();
					}
				}

				}
				break;
			case 77:
			case 88:
				enterOuterAlt(_localctx, 6);
				{
				setState(617);
				_la = _input.LA(1);
				if ( !(_la==77 || _la==88) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 34:
			case 74:
				enterOuterAlt(_localctx, 7);
				{
				setState(618);
				_la = _input.LA(1);
				if ( !(_la==34 || _la==74) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 84:
				enterOuterAlt(_localctx, 8);
				{
				setState(619); match(84);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 9);
				{
				setState(620); match(21);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 10);
				{
				setState(621); match(32);
				setState(625);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(622); match(100);
					setState(623); match(INT);
					setState(624); match(79);
					}
				}

				setState(628);
				_la = _input.LA(1);
				if (_la==123) {
					{
					setState(627); match(123);
					}
				}

				setState(631);
				_la = _input.LA(1);
				if (_la==94) {
					{
					setState(630); match(94);
					}
				}

				}
				break;
			case 12:
			case 83:
			case 137:
				enterOuterAlt(_localctx, 11);
				{
				setState(633);
				_la = _input.LA(1);
				if ( !(_la==12 || _la==83 || _la==137) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(641);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(634); match(100);
					setState(635); match(INT);
					setState(638);
					_la = _input.LA(1);
					if (_la==22) {
						{
						setState(636); match(22);
						setState(637); match(INT);
						}
					}

					setState(640); match(79);
					}
				}

				setState(644);
				_la = _input.LA(1);
				if (_la==123) {
					{
					setState(643); match(123);
					}
				}

				setState(647);
				_la = _input.LA(1);
				if (_la==94) {
					{
					setState(646); match(94);
					}
				}

				}
				break;
			case 148:
				enterOuterAlt(_localctx, 12);
				{
				setState(649); match(148);
				}
				break;
			case 162:
				enterOuterAlt(_localctx, 13);
				{
				setState(650); match(162);
				setState(681);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(651); match(100);
					setState(653);
					_la = _input.LA(1);
					if (_la==56) {
						{
						setState(652); match(56);
						}
					}

					setState(655); match(ID);
					setState(657);
					_la = _input.LA(1);
					if (_la==56) {
						{
						setState(656); match(56);
						}
					}

					setState(669);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==22) {
						{
						{
						setState(659); match(22);
						setState(661);
						_la = _input.LA(1);
						if (_la==56) {
							{
							setState(660); match(56);
							}
						}

						setState(663); match(ID);
						setState(665);
						_la = _input.LA(1);
						if (_la==56) {
							{
							setState(664); match(56);
							}
						}

						}
						}
						setState(671);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(672); match(79);
					setState(675);
					_la = _input.LA(1);
					if (_la==33) {
						{
						setState(673); match(33);
						setState(674); match(DEFAULTCHARSET);
						}
					}

					setState(679);
					_la = _input.LA(1);
					if (_la==95) {
						{
						setState(677); match(95);
						setState(678); name();
						}
					}

					}
				}

				}
				break;
			case 61:
				enterOuterAlt(_localctx, 14);
				{
				setState(683); match(61);
				setState(685);
				_la = _input.LA(1);
				if (_la==20) {
					{
					setState(684); match(20);
					}
				}

				setState(689);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(687); match(33);
					setState(688); match(DEFAULTCHARSET);
					}
				}

				setState(693);
				_la = _input.LA(1);
				if (_la==95) {
					{
					setState(691); match(95);
					setState(692); name();
					}
				}

				}
				break;
			case 59:
			case 103:
				enterOuterAlt(_localctx, 15);
				{
				setState(695);
				_la = _input.LA(1);
				if ( !(_la==59 || _la==103) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(697);
				_la = _input.LA(1);
				if (_la==20) {
					{
					setState(696); match(20);
					}
				}

				setState(701);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(699); match(33);
					setState(700); match(DEFAULTCHARSET);
					}
				}

				setState(705);
				_la = _input.LA(1);
				if (_la==95) {
					{
					setState(703); match(95);
					setState(704); name();
					}
				}

				}
				break;
			case 142:
				enterOuterAlt(_localctx, 16);
				{
				setState(707); match(142);
				setState(709);
				_la = _input.LA(1);
				if (_la==20) {
					{
					setState(708); match(20);
					}
				}

				setState(713);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(711); match(33);
					setState(712); match(DEFAULTCHARSET);
					}
				}

				setState(717);
				_la = _input.LA(1);
				if (_la==95) {
					{
					setState(715); match(95);
					setState(716); name();
					}
				}

				}
				break;
			case 13:
				enterOuterAlt(_localctx, 17);
				{
				setState(719); match(13);
				setState(721);
				_la = _input.LA(1);
				if (_la==20) {
					{
					setState(720); match(20);
					}
				}

				setState(725);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(723); match(33);
					setState(724); match(DEFAULTCHARSET);
					}
				}

				setState(729);
				_la = _input.LA(1);
				if (_la==95) {
					{
					setState(727); match(95);
					setState(728); name();
					}
				}

				}
				break;
			case 62:
				enterOuterAlt(_localctx, 18);
				{
				setState(731); match(62);
				setState(735);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(732); match(100);
					setState(733); match(INT);
					setState(734); match(79);
					}
				}

				}
				break;
			case 132:
				enterOuterAlt(_localctx, 19);
				{
				setState(737); match(132);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 20);
				{
				setState(738); match(17);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 21);
				{
				setState(739); match(9);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 22);
				{
				setState(740); match(66);
				setState(744);
				_la = _input.LA(1);
				if (_la==100) {
					{
					setState(741); match(100);
					setState(742); match(INT);
					setState(743); match(79);
					}
				}

				setState(748);
				_la = _input.LA(1);
				if (_la==33) {
					{
					setState(746); match(33);
					setState(747); match(DEFAULTCHARSET);
					}
				}

				setState(752);
				_la = _input.LA(1);
				if (_la==95) {
					{
					setState(750); match(95);
					setState(751); name();
					}
				}

				}
				break;
			case 115:
				enterOuterAlt(_localctx, 23);
				{
				setState(754); match(115);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 24);
				{
				setState(755); match(44);
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

	public static class TableOptionContext extends ParserRuleContext {
		public NameContext name;
		public Token DEFAULTCHARSET;
		public RowFormatContext rowFormat;
		public Token INT;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode DEFAULTCHARSET() { return getToken(MySQLParser.DEFAULTCHARSET, 0); }
		public RowFormatContext rowFormat() {
			return getRuleContext(RowFormatContext.class,0);
		}
		public TerminalNode INT() { return getToken(MySQLParser.INT, 0); }
		public TableOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableOption; }
	}

	public final TableOptionContext tableOption() throws RecognitionException {
		TableOptionContext _localctx = new TableOptionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_tableOption);
		int _la;
		try {
			int _alt;
			setState(822);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(758);
				_la = _input.LA(1);
				if ( !(_la==60 || _la==134) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(759); match(15);
				setState(760); ((TableOptionContext)_localctx).name = name();
				 tableOption("engine",(((TableOptionContext)_localctx).name!=null?_input.getText(((TableOptionContext)_localctx).name.start,((TableOptionContext)_localctx).name.stop):null));  
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(763); match(14);
				setState(764); ((TableOptionContext)_localctx).DEFAULTCHARSET = match(DEFAULTCHARSET);
				 tableOption("charset",(((TableOptionContext)_localctx).DEFAULTCHARSET!=null?((TableOptionContext)_localctx).DEFAULTCHARSET.getText():null));  
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(766); match(1);
				setState(767); ((TableOptionContext)_localctx).rowFormat = rowFormat();
				 tableOption("rowFormat",(((TableOptionContext)_localctx).rowFormat!=null?_input.getText(((TableOptionContext)_localctx).rowFormat.start,((TableOptionContext)_localctx).rowFormat.stop):null));  
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(770); match(102);
				setState(771); ((TableOptionContext)_localctx).INT = match(INT);
				 tableOption("autoIncrement",(((TableOptionContext)_localctx).INT!=null?((TableOptionContext)_localctx).INT.getText():null));  
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(773); match(24);
				setState(774); ((TableOptionContext)_localctx).INT = match(INT);
				 tableOption("minRows",(((TableOptionContext)_localctx).INT!=null?((TableOptionContext)_localctx).INT.getText():null));  
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(776); match(93);
				setState(777); ((TableOptionContext)_localctx).INT = match(INT);
				 tableOption("maxRows",(((TableOptionContext)_localctx).INT!=null?((TableOptionContext)_localctx).INT.getText():null));  
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(779); match(128);
				setState(786);
				switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
				case 1:
					{
					setState(783);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(780);
							matchWildcard();
							}
							} 
						}
						setState(785);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
					}
					}
					break;
				}
				 tableOption("connection","");  
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(789); match(1);
				setState(796);
				switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
				case 1:
					{
					setState(793);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(790);
							matchWildcard();
							}
							} 
						}
						setState(795);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
					}
					}
					break;
				}
				 tableOption("rowFormat","");  
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(799); match(51);
				setState(800); ((TableOptionContext)_localctx).INT = match(INT);
				 tableOption("packKeys",(((TableOptionContext)_localctx).INT!=null?((TableOptionContext)_localctx).INT.getText():null));  
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(802); match(69);
				setState(809);
				switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
				case 1:
					{
					setState(806);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(803);
							matchWildcard();
							}
							} 
						}
						setState(808);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
					}
					}
					break;
				}
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(811); match(80);
				setState(812); match(INT);
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(813); match(90);
				setState(814); match(INT);
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(815); match(16);
				{
				setState(819);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(816);
						matchWildcard();
						}
						} 
					}
					setState(821);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
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

	public static class RowFormatContext extends ParserRuleContext {
		public RowFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowFormat; }
	}

	public final RowFormatContext rowFormat() throws RecognitionException {
		RowFormatContext _localctx = new RowFormatContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_rowFormat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			_la = _input.LA(1);
			if ( !(_la==71 || _la==150) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class OnUpdateContext extends ParserRuleContext {
		public OnUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onUpdate; }
	}

	public final OnUpdateContext onUpdate() throws RecognitionException {
		OnUpdateContext _localctx = new OnUpdateContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_onUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826); match(28);
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

	public static class ColNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MySQLParser.ID, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode INT() { return getToken(MySQLParser.INT, 0); }
		public ColNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colName; }
	}

	public final ColNameContext colName() throws RecognitionException {
		ColNameContext _localctx = new ColNameContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_colName);
		int _la;
		try {
			setState(837);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(828); name();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(830);
				_la = _input.LA(1);
				if (_la==135) {
					{
					setState(829); match(135);
					}
				}

				setState(832); match(INT);
				setState(833); match(ID);
				setState(835);
				switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
				case 1:
					{
					setState(834); match(135);
					}
					break;
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MySQLParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			_la = _input.LA(1);
			if (_la==135) {
				{
				setState(839); match(135);
				}
			}

			setState(842);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 34) | (1L << 36) | (1L << 61))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (134 - 134)) | (1L << (148 - 134)) | (1L << (ID - 134)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(844);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(843); match(135);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\u00ad\u0351\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2X\n\2\7\2Z\n\2\f\2\16\2]\13\2\3\3\3\3\3\3\5\3b\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3k\n\3\3\4\3\4\3\4\5\4p\n\4\3\4\3\4\3\4\3\4\5"+
		"\4v\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4~\n\4\f\4\16\4\u0081\13\4\3\4\3\4\7"+
		"\4\u0085\n\4\f\4\16\4\u0088\13\4\3\4\3\4\7\4\u008c\n\4\f\4\16\4\u008f"+
		"\13\4\3\4\5\4\u0092\n\4\3\4\3\4\5\4\u0096\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5\u00a2\n\5\f\5\16\5\u00a5\13\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\5\7\u00ad\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u00c4\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\5\r\u00ce\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d8"+
		"\n\r\3\r\5\r\u00db\n\r\3\r\3\r\5\r\u00df\n\r\3\r\3\r\5\r\u00e3\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00ea\n\r\3\r\5\r\u00ed\n\r\3\r\5\r\u00f0\n\r\3\r"+
		"\3\r\5\r\u00f4\n\r\5\r\u00f6\n\r\3\r\5\r\u00f9\n\r\7\r\u00fb\n\r\f\r\16"+
		"\r\u00fe\13\r\3\r\3\r\3\r\3\r\5\r\u0104\n\r\3\r\3\r\3\r\5\r\u0109\n\r"+
		"\3\r\5\r\u010c\n\r\3\r\3\r\5\r\u0110\n\r\3\r\3\r\5\r\u0114\n\r\3\r\7\r"+
		"\u0117\n\r\f\r\16\r\u011a\13\r\3\r\5\r\u011d\n\r\3\r\3\r\3\r\5\r\u0122"+
		"\n\r\3\r\7\r\u0125\n\r\f\r\16\r\u0128\13\r\3\r\5\r\u012b\n\r\3\r\5\r\u012e"+
		"\n\r\5\r\u0130\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0138\n\16\6\16"+
		"\u013a\n\16\r\16\16\16\u013b\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u0144"+
		"\n\17\6\17\u0146\n\17\r\17\16\17\u0147\3\17\3\17\3\17\5\17\u014d\n\17"+
		"\6\17\u014f\n\17\r\17\16\17\u0150\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\7\20\u0160\n\20\f\20\16\20\u0163\13\20\3"+
		"\21\3\21\3\21\3\21\5\21\u0169\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u0170"+
		"\n\22\3\22\3\22\3\22\3\22\7\22\u0176\n\22\f\22\16\22\u0179\13\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u0180\n\22\3\23\3\23\3\23\3\24\3\24\3\24\5\24"+
		"\u0188\n\24\3\24\3\24\5\24\u018c\n\24\3\24\3\24\3\24\5\24\u0191\n\24\3"+
		"\24\5\24\u0194\n\24\3\24\3\24\3\24\3\24\5\24\u019a\n\24\3\24\3\24\3\24"+
		"\3\24\7\24\u01a0\n\24\f\24\16\24\u01a3\13\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u01aa\n\24\3\25\3\25\3\25\3\26\3\26\5\26\u01b1\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u01b7\n\26\3\26\3\26\3\26\3\26\5\26\u01bd\n\26\3\26\3\26"+
		"\3\26\3\26\7\26\u01c3\n\26\f\26\16\26\u01c6\13\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u01cd\n\26\3\27\3\27\3\27\3\30\5\30\u01d3\n\30\3\30\3\30\3"+
		"\30\3\30\5\30\u01d9\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\5\31\u01e4\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u01eb\n\31\3\31\7\31\u01ee"+
		"\n\31\f\31\16\31\u01f1\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u01fb\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\5\36"+
		"\u0207\n\36\3\37\3\37\5\37\u020b\n\37\3\37\5\37\u020e\n\37\3\37\3\37\5"+
		"\37\u0212\n\37\3\37\5\37\u0215\n\37\3\37\3\37\5\37\u0219\n\37\3\37\5\37"+
		"\u021c\n\37\3\37\5\37\u021f\n\37\3\37\3\37\7\37\u0223\n\37\f\37\16\37"+
		"\u0226\13\37\5\37\u0228\n\37\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u0232\n!\3"+
		"\"\3\"\3\"\3\"\5\"\u0238\n\"\3\"\3\"\3\"\3\"\5\"\u023e\n\"\3\"\5\"\u0241"+
		"\n\"\3\"\5\"\u0244\n\"\3\"\3\"\3\"\3\"\5\"\u024a\n\"\3\"\5\"\u024d\n\""+
		"\3\"\5\"\u0250\n\"\3\"\3\"\3\"\3\"\5\"\u0256\n\"\3\"\5\"\u0259\n\"\3\""+
		"\5\"\u025c\n\"\3\"\3\"\3\"\3\"\5\"\u0262\n\"\3\"\3\"\5\"\u0266\n\"\3\""+
		"\3\"\5\"\u026a\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0274\n\"\3\"\5"+
		"\"\u0277\n\"\3\"\5\"\u027a\n\"\3\"\3\"\3\"\3\"\3\"\5\"\u0281\n\"\3\"\5"+
		"\"\u0284\n\"\3\"\5\"\u0287\n\"\3\"\5\"\u028a\n\"\3\"\3\"\3\"\3\"\5\"\u0290"+
		"\n\"\3\"\3\"\5\"\u0294\n\"\3\"\3\"\5\"\u0298\n\"\3\"\3\"\5\"\u029c\n\""+
		"\7\"\u029e\n\"\f\"\16\"\u02a1\13\"\3\"\3\"\3\"\5\"\u02a6\n\"\3\"\3\"\5"+
		"\"\u02aa\n\"\5\"\u02ac\n\"\3\"\3\"\5\"\u02b0\n\"\3\"\3\"\5\"\u02b4\n\""+
		"\3\"\3\"\5\"\u02b8\n\"\3\"\3\"\5\"\u02bc\n\"\3\"\3\"\5\"\u02c0\n\"\3\""+
		"\3\"\5\"\u02c4\n\"\3\"\3\"\5\"\u02c8\n\"\3\"\3\"\5\"\u02cc\n\"\3\"\3\""+
		"\5\"\u02d0\n\"\3\"\3\"\5\"\u02d4\n\"\3\"\3\"\5\"\u02d8\n\"\3\"\3\"\5\""+
		"\u02dc\n\"\3\"\3\"\3\"\3\"\5\"\u02e2\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u02eb\n\"\3\"\3\"\5\"\u02ef\n\"\3\"\3\"\5\"\u02f3\n\"\3\"\3\"\5\"\u02f7"+
		"\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\7#\u0310\n#\f#\16#\u0313\13#\5#\u0315\n#\3#\3#\3#\7#\u031a\n#\f#"+
		"\16#\u031d\13#\5#\u031f\n#\3#\3#\3#\3#\3#\3#\7#\u0327\n#\f#\16#\u032a"+
		"\13#\5#\u032c\n#\3#\3#\3#\3#\3#\3#\7#\u0334\n#\f#\16#\u0337\13#\5#\u0339"+
		"\n#\3$\3$\3%\3%\3&\3&\5&\u0341\n&\3&\3&\3&\5&\u0346\n&\5&\u0348\n&\3\'"+
		"\5\'\u034b\n\'\3\'\3\'\5\'\u034f\n\'\3\'\4[\u00fc(\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL\2\65\4\2((\u0083\u0083"+
		"\4\2bb\u00a1\u00a1\4\2\u0092\u0092\u0099\u0099\4\2MM\u0080\u0080\4\29"+
		"9rr\4\2KKYY\4\2\u008c\u008c\u0094\u0094\4\2gg\177\177\4\2\34\34AA\4\2"+
		"FF\u00a7\u00a7\4\2\7\7\u008d\u008d\4\2pp\u008f\u008f\4\2vv\u00a2\u00a2"+
		"\4\2\n\nSS\4\2JJ\u0095\u0095\4\2kk\u008a\u008a\3\2,-\4\2//\u009b\u009b"+
		"\4\2\u0087\u0087\u00a3\u00a3\4\2\u009e\u009e\u00a0\u00a0\4\2]]zz\4\2\61"+
		"\61PP\4\2<<HH\4\288XX\3\2jj\4\2++\u0093\u0093\4\2ddoo\4\2\u008e\u008e"+
		"\u0097\u0097\4\2TTll\4\2[[\u00a6\u00a6\5\2\6\6\r\r\67\67\6\2!!**WW^^\5"+
		"\2\33\33\64\64qq\4\2\66\66||\4\2))ee\4\2\f\f\25\25\4\2CCNN\4\2\4\4\u0084"+
		"\u0084\5\2ee||\u00ac\u00ac\4\2%%\u0085\u0085\4\2xx{{\4\2ccss\6\2\5\5\24"+
		"\24\60\60BB\4\2nntt\4\2OOZZ\4\2$$LL\5\2\16\16UU\u008b\u008b\4\2==ii\4"+
		"\2>>\u0088\u0088\4\2II\u0098\u0098\t\2\t\t$$&&??\u0088\u0088\u0096\u0096"+
		"\u00ab\u00ab\u03fa\2[\3\2\2\2\4j\3\2\2\2\6\u0095\3\2\2\2\b\u0097\3\2\2"+
		"\2\n\u00a6\3\2\2\2\f\u00aa\3\2\2\2\16\u00b0\3\2\2\2\20\u00b4\3\2\2\2\22"+
		"\u00bb\3\2\2\2\24\u00bf\3\2\2\2\26\u00c5\3\2\2\2\30\u00cb\3\2\2\2\32\u0131"+
		"\3\2\2\2\34\u0140\3\2\2\2\36\u0161\3\2\2\2 \u0168\3\2\2\2\"\u016a\3\2"+
		"\2\2$\u0181\3\2\2\2&\u0184\3\2\2\2(\u01ab\3\2\2\2*\u01b0\3\2\2\2,\u01ce"+
		"\3\2\2\2.\u01d2\3\2\2\2\60\u01e1\3\2\2\2\62\u01fa\3\2\2\2\64\u01fc\3\2"+
		"\2\2\66\u01fe\3\2\2\28\u0200\3\2\2\2:\u0206\3\2\2\2<\u0208\3\2\2\2>\u022b"+
		"\3\2\2\2@\u0231\3\2\2\2B\u02f6\3\2\2\2D\u0338\3\2\2\2F\u033a\3\2\2\2H"+
		"\u033c\3\2\2\2J\u0347\3\2\2\2L\u034a\3\2\2\2NZ\7\u00a9\2\2OZ\7\u00aa\2"+
		"\2PX\5\4\3\2QX\5\6\4\2RX\5\b\5\2SX\5\26\f\2TX\5\30\r\2UX\5\32\16\2VX\7"+
		"\63\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV"+
		"\3\2\2\2XZ\3\2\2\2YN\3\2\2\2YO\3\2\2\2YW\3\2\2\2Z]\3\2\2\2[\\\3\2\2\2"+
		"[Y\3\2\2\2\\\3\3\2\2\2][\3\2\2\2^_\t\2\2\2_a\t\3\2\2`b\7y\2\2a`\3\2\2"+
		"\2ab\3\2\2\2bc\3\2\2\2cd\5L\'\2de\7\63\2\2ek\3\2\2\2fg\7\u009c\2\2gh\5"+
		"L\'\2hi\7\63\2\2ik\3\2\2\2j^\3\2\2\2jf\3\2\2\2k\5\3\2\2\2lm\t\4\2\2mo"+
		"\t\5\2\2np\t\6\2\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2q\u0096\5L\'\2rs\t\2\2"+
		"\2su\t\5\2\2tv\7y\2\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5L\'\2xy\b\4\1\2"+
		"yz\7f\2\2z\177\58\35\2{|\7\30\2\2|~\58\35\2}{\3\2\2\2~\u0081\3\2\2\2\177"+
		"}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0086\3\2\2\2\u0081\177\3\2\2\2\u0082"+
		"\u0083\7\30\2\2\u0083\u0085\5 \21\2\u0084\u0082\3\2\2\2\u0085\u0088\3"+
		"\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u008d\7Q\2\2\u008a\u008c\5D#\2\u008b\u008a\3\2\2"+
		"\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\7\63\2\2\u0091\u0090\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\4\1\2\u0094\u0096"+
		"\3\2\2\2\u0095l\3\2\2\2\u0095r\3\2\2\2\u0096\7\3\2\2\2\u0097\u0098\t\7"+
		"\2\2\u0098\u0099\t\5\2\2\u0099\u00a3\5L\'\2\u009a\u00a2\5\n\6\2\u009b"+
		"\u00a2\5\16\b\2\u009c\u00a2\5\f\7\2\u009d\u00a2\5\20\t\2\u009e\u00a2\5"+
		"\22\n\2\u009f\u00a2\5\24\13\2\u00a0\u00a2\7\30\2\2\u00a1\u009a\3\2\2\2"+
		"\u00a1\u009b\3\2\2\2\u00a1\u009c\3\2\2\2\u00a1\u009d\3\2\2\2\u00a1\u009e"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\t\3\2\2\2\u00a5\u00a3\3\2\2\2"+
		"\u00a6\u00a7\t\b\2\2\u00a7\u00a8\t\t\2\2\u00a8\u00a9\58\35\2\u00a9\13"+
		"\3\2\2\2\u00aa\u00ac\t\n\2\2\u00ab\u00ad\t\t\2\2\u00ac\u00ab\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\58\35\2\u00af\r\3\2\2\2"+
		"\u00b0\u00b1\t\4\2\2\u00b1\u00b2\t\t\2\2\u00b2\u00b3\5J&\2\u00b3\17\3"+
		"\2\2\2\u00b4\u00b5\t\b\2\2\u00b5\u00b6\t\13\2\2\u00b6\u00b7\5L\'\2\u00b7"+
		"\u00b8\7f\2\2\u00b8\u00b9\5J&\2\u00b9\u00ba\7Q\2\2\u00ba\21\3\2\2\2\u00bb"+
		"\u00bc\t\4\2\2\u00bc\u00bd\t\13\2\2\u00bd\u00be\5L\'\2\u00be\23\3\2\2"+
		"\2\u00bf\u00c3\t\b\2\2\u00c0\u00c1\t\f\2\2\u00c1\u00c4\5L\'\2\u00c2\u00c4"+
		"\5.\30\2\u00c3\u00c0\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\25\3\2\2\2\u00c5"+
		"\u00c6\7j\2\2\u00c6\u00c7\7 \2\2\u00c7\u00c8\5\36\20\2\u00c8\u00c9\b\f"+
		"\1\2\u00c9\u00ca\7j\2\2\u00ca\27\3\2\2\2\u00cb\u00cd\t\r\2\2\u00cc\u00ce"+
		"\t\16\2\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2"+
		"\u00cf\u00d0\5L\'\2\u00d0\u00fc\t\17\2\2\u00d1\u00d2\5J&\2\u00d2\u00f5"+
		"\7\21\2\2\u00d3\u00f6\t\20\2\2\u00d4\u00d8\7|\2\2\u00d5\u00d8\3\2\2\2"+
		"\u00d6\u00d8\7e\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6"+
		"\3\2\2\2\u00d8\u00f6\3\2\2\2\u00d9\u00db\7:\2\2\u00da\u00d9\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\7\u00ab\2\2\u00dd\u00df"+
		"\7:\2\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00f6\3\2\2\2\u00e0"+
		"\u00e2\t\21\2\2\u00e1\u00e3\7f\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00ec\5J&\2\u00e5\u00e9\t\22\2\2\u00e6"+
		"\u00ea\7}\2\2\u00e7\u00ea\7\u0081\2\2\u00e8\u00ea\5B\"\2\u00e9\u00e6\3"+
		"\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ed\7Q\2\2\u00ec\u00e5\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f6\3\2"+
		"\2\2\u00ee\u00f0\7\u009f\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f3\7\u00ab\2\2\u00f2\u00f4\7\u009f\2\2\u00f3\u00f2"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00d3\3\2\2\2\u00f5"+
		"\u00d7\3\2\2\2\u00f5\u00da\3\2\2\2\u00f5\u00e0\3\2\2\2\u00f5\u00ef\3\2"+
		"\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f9\7\30\2\2\u00f8\u00f7\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00d1\3\2\2\2\u00fb\u00fe\3\2"+
		"\2\2\u00fc\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u012f\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00ff\u0100\t\23\2\2\u0100\u0101\5J&\2\u0101\u0103\7\21"+
		"\2\2\u0102\u0104\t\24\2\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u012d\3\2\2\2\u0105\u0109\7|\2\2\u0106\u0109\3\2\2\2\u0107\u0109\7e\2"+
		"\2\u0108\u0105\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\u012e"+
		"\3\2\2\2\u010a\u010c\7:\2\2\u010b\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010f\7\u00ab\2\2\u010e\u0110\7:\2\2\u010f\u010e"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u012e\3\2\2\2\u0111\u012e\5J&\2\u0112"+
		"\u0114\7\u009f\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0118"+
		"\3\2\2\2\u0115\u0117\13\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2"+
		"\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118"+
		"\3\2\2\2\u011b\u011d\7\u009f\2\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2"+
		"\2\u011d\u012e\3\2\2\2\u011e\u011f\t\25\2\2\u011f\u0121\7f\2\2\u0120\u0122"+
		"\7\u009f\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0126\3\2\2"+
		"\2\u0123\u0125\13\2\2\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0129\u012b\7\u009f\2\2\u012a\u0129\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012e\7Q\2\2\u012d\u0108\3\2\2\2\u012d\u010b\3\2"+
		"\2\2\u012d\u0111\3\2\2\2\u012d\u0113\3\2\2\2\u012d\u011e\3\2\2\2\u012e"+
		"\u0130\3\2\2\2\u012f\u00ff\3\2\2\2\u012f\u0130\3\2\2\2\u0130\31\3\2\2"+
		"\2\u0131\u0132\t\26\2\2\u0132\u0133\t\27\2\2\u0133\u0134\5L\'\2\u0134"+
		"\u0139\7f\2\2\u0135\u0137\5J&\2\u0136\u0138\7\30\2\2\u0137\u0136\3\2\2"+
		"\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0135\3\2\2\2\u013a\u013b"+
		"\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\7Q\2\2\u013e\u013f\5\34\17\2\u013f\33\3\2\2\2\u0140\u0145\t\30"+
		"\2\2\u0141\u0143\5J&\2\u0142\u0144\7\30\2\2\u0143\u0142\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0141\3\2\2\2\u0146\u0147\3\2"+
		"\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u014e\t\31\2\2\u014a\u014c\5L\'\2\u014b\u014d\7\30\2\2\u014c\u014b\3"+
		"\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014a\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\35\3\2\2"+
		"\2\u0152\u0160\7\u00ab\2\2\u0153\u0160\7w\2\2\u0154\u0160\7\u0091\2\2"+
		"\u0155\u0160\7\u009d\2\2\u0156\u0160\7\'\2\2\u0157\u0160\7\u00a5\2\2\u0158"+
		"\u0160\7;\2\2\u0159\u0160\7~\2\2\u015a\u0160\7\37\2\2\u015b\u0160\7\u009a"+
		"\2\2\u015c\u0160\7E\2\2\u015d\u0160\7\63\2\2\u015e\u0160\n\32\2\2\u015f"+
		"\u0152\3\2\2\2\u015f\u0153\3\2\2\2\u015f\u0154\3\2\2\2\u015f\u0155\3\2"+
		"\2\2\u015f\u0156\3\2\2\2\u015f\u0157\3\2\2\2\u015f\u0158\3\2\2\2\u015f"+
		"\u0159\3\2\2\2\u015f\u015a\3\2\2\2\u015f\u015b\3\2\2\2\u015f\u015c\3\2"+
		"\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\37\3\2\2\2\u0163\u0161\3\2\2"+
		"\2\u0164\u0169\5\"\22\2\u0165\u0169\5&\24\2\u0166\u0169\5*\26\2\u0167"+
		"\u0169\5.\30\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2\u0168\u0166\3\2"+
		"\2\2\u0168\u0167\3\2\2\2\u0169!\3\2\2\2\u016a\u016f\t\33\2\2\u016b\u016c"+
		"\7\b\2\2\u016c\u016d\5\66\34\2\u016d\u016e\b\22\1\2\u016e\u0170\3\2\2"+
		"\2\u016f\u016b\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172"+
		"\7f\2\2\u0172\u0177\5$\23\2\u0173\u0174\7\30\2\2\u0174\u0176\5$\23\2\u0175"+
		"\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017f\7Q\2\2\u017b"+
		"\u017c\7\b\2\2\u017c\u017d\5\66\34\2\u017d\u017e\b\22\1\2\u017e\u0180"+
		"\3\2\2\2\u017f\u017b\3\2\2\2\u017f\u0180\3\2\2\2\u0180#\3\2\2\2\u0181"+
		"\u0182\5J&\2\u0182\u0183\b\23\1\2\u0183%\3\2\2\2\u0184\u0187\t\34\2\2"+
		"\u0185\u0188\t\35\2\2\u0186\u0188\t\13\2\2\u0187\u0185\3\2\2\2\u0187\u0186"+
		"\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018b\b\24\1\2"+
		"\u018a\u018c\7f\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u0190"+
		"\3\2\2\2\u018d\u018e\5L\'\2\u018e\u018f\b\24\1\2\u018f\u0191\3\2\2\2\u0190"+
		"\u018d\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0194\7Q"+
		"\2\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0199\3\2\2\2\u0195"+
		"\u0196\7\b\2\2\u0196\u0197\5\66\34\2\u0197\u0198\b\24\1\2\u0198\u019a"+
		"\3\2\2\2\u0199\u0195\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u019c\7f\2\2\u019c\u01a1\5(\25\2\u019d\u019e\7\30\2\2\u019e\u01a0\5("+
		"\25\2\u019f\u019d\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a9\7Q"+
		"\2\2\u01a5\u01a6\7\b\2\2\u01a6\u01a7\5\66\34\2\u01a7\u01a8\b\24\1\2\u01a8"+
		"\u01aa\3\2\2\2\u01a9\u01a5\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\'\3\2\2\2"+
		"\u01ab\u01ac\5J&\2\u01ac\u01ad\b\25\1\2\u01ad)\3\2\2\2\u01ae\u01b1\t\35"+
		"\2\2\u01af\u01b1\t\13\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b6\b\26\1\2\u01b3\u01b4\5L\'\2\u01b4\u01b5\b\26"+
		"\1\2\u01b5\u01b7\3\2\2\2\u01b6\u01b3\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01bc\3\2\2\2\u01b8\u01b9\7\b\2\2\u01b9\u01ba\5\66\34\2\u01ba\u01bb\b"+
		"\26\1\2\u01bb\u01bd\3\2\2\2\u01bc\u01b8\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01be\3\2\2\2\u01be\u01bf\7f\2\2\u01bf\u01c4\5,\27\2\u01c0\u01c1\7\30"+
		"\2\2\u01c1\u01c3\5,\27\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2"+
		"\2\2\u01c7\u01cc\7Q\2\2\u01c8\u01c9\7\b\2\2\u01c9\u01ca\5\66\34\2\u01ca"+
		"\u01cb\b\26\1\2\u01cb\u01cd\3\2\2\2\u01cc\u01c8\3\2\2\2\u01cc\u01cd\3"+
		"\2\2\2\u01cd+\3\2\2\2\u01ce\u01cf\5J&\2\u01cf\u01d0\b\27\1\2\u01d0-\3"+
		"\2\2\2\u01d1\u01d3\t\f\2\2\u01d2\u01d1\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3"+
		"\u01d4\3\2\2\2\u01d4\u01d8\b\30\1\2\u01d5\u01d6\5L\'\2\u01d6\u01d7\b\30"+
		"\1\2\u01d7\u01d9\3\2\2\2\u01d8\u01d5\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01db\t\36\2\2\u01db\u01dc\7f\2\2\u01dc\u01dd\5J"+
		"&\2\u01dd\u01de\b\30\1\2\u01de\u01df\7Q\2\2\u01df\u01e0\5\60\31\2\u01e0"+
		"/\3\2\2\2\u01e1\u01e3\t\37\2\2\u01e2\u01e4\5L\'\2\u01e3\u01e2\3\2\2\2"+
		"\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\7f\2\2\u01e6\u01e7"+
		"\5J&\2\u01e7\u01e8\b\31\1\2\u01e8\u01ea\7Q\2\2\u01e9\u01eb\t \2\2\u01ea"+
		"\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ef\3\2\2\2\u01ec\u01ee\5\62"+
		"\32\2\u01ed\u01ec\3\2\2\2\u01ee\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0\61\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f3\7\62\2"+
		"\2\u01f3\u01f4\5\64\33\2\u01f4\u01f5\b\32\1\2\u01f5\u01fb\3\2\2\2\u01f6"+
		"\u01f7\7\f\2\2\u01f7\u01f8\5\64\33\2\u01f8\u01f9\b\32\1\2\u01f9\u01fb"+
		"\3\2\2\2\u01fa\u01f2\3\2\2\2\u01fa\u01f6\3\2\2\2\u01fb\63\3\2\2\2\u01fc"+
		"\u01fd\t!\2\2\u01fd\65\3\2\2\2\u01fe\u01ff\t\"\2\2\u01ff\67\3\2\2\2\u0200"+
		"\u0201\5J&\2\u0201\u0202\b\35\1\2\u0202\u0203\5<\37\2\u02039\3\2\2\2\u0204"+
		"\u0207\t#\2\2\u0205\u0207\t$\2\2\u0206\u0204\3\2\2\2\u0206\u0205\3\2\2"+
		"\2\u0207;\3\2\2\2\u0208\u020a\5B\"\2\u0209\u020b\5:\36\2\u020a\u0209\3"+
		"\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2\2\2\u020c\u020e\5@!\2\u020d"+
		"\u020c\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u0210\t%"+
		"\2\2\u0210\u0212\5H%\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214"+
		"\3\2\2\2\u0213\u0215\5> \2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u021e\3\2\2\2\u0216\u0218\t\34\2\2\u0217\u0219\t\35\2\2\u0218\u0217\3"+
		"\2\2\2\u0218\u0219\3\2\2\2\u0219\u021f\3\2\2\2\u021a\u021c\7\31\2\2\u021b"+
		"\u021a\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021f\7\u008e"+
		"\2\2\u021e\u0216\3\2\2\2\u021e\u021b\3\2\2\2\u021e\u021f\3\2\2\2\u021f"+
		"\u0227\3\2\2\2\u0220\u0224\7&\2\2\u0221\u0223\13\2\2\2\u0222\u0221\3\2"+
		"\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0220\3\2\2\2\u0227\u0228\3\2"+
		"\2\2\u0228\u0229\3\2\2\2\u0229\u022a\b\37\1\2\u022a=\3\2\2\2\u022b\u022c"+
		"\t&\2\2\u022c?\3\2\2\2\u022d\u022e\t\'\2\2\u022e\u0232\t(\2\2\u022f\u0232"+
		"\7\35\2\2\u0230\u0232\7m\2\2\u0231\u022d\3\2\2\2\u0231\u022f\3\2\2\2\u0231"+
		"\u0230\3\2\2\2\u0232A\3\2\2\2\u0233\u0237\t)\2\2\u0234\u0235\7f\2\2\u0235"+
		"\u0236\7\u00ac\2\2\u0236\u0238\7Q\2\2\u0237\u0234\3\2\2\2\u0237\u0238"+
		"\3\2\2\2\u0238\u02f7\3\2\2\2\u0239\u023d\t*\2\2\u023a\u023b\7f\2\2\u023b"+
		"\u023c\7\u00ac\2\2\u023c\u023e\7Q\2\2\u023d\u023a\3\2\2\2\u023d\u023e"+
		"\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u0241\7}\2\2\u0240\u023f\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u0243\3\2\2\2\u0242\u0244\7`\2\2\u0243\u0242\3\2"+
		"\2\2\u0243\u0244\3\2\2\2\u0244\u02f7\3\2\2\2\u0245\u0249\t+\2\2\u0246"+
		"\u0247\7f\2\2\u0247\u0248\7\u00ac\2\2\u0248\u024a\7Q\2\2\u0249\u0246\3"+
		"\2\2\2\u0249\u024a\3\2\2\2\u024a\u024c\3\2\2\2\u024b\u024d\7}\2\2\u024c"+
		"\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024f\3\2\2\2\u024e\u0250\7`"+
		"\2\2\u024f\u024e\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u02f7\3\2\2\2\u0251"+
		"\u0255\t,\2\2\u0252\u0253\7f\2\2\u0253\u0254\7\u00ac\2\2\u0254\u0256\7"+
		"Q\2\2\u0255\u0252\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0258\3\2\2\2\u0257"+
		"\u0259\7}\2\2\u0258\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025b\3\2"+
		"\2\2\u025a\u025c\7`\2\2\u025b\u025a\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u02f7\3\2\2\2\u025d\u0261\t-\2\2\u025e\u025f\7f\2\2\u025f\u0260\7\u00ac"+
		"\2\2\u0260\u0262\7Q\2\2\u0261\u025e\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u0265\3\2\2\2\u0263\u0264\7#\2\2\u0264\u0266\7\u00a8\2\2\u0265\u0263"+
		"\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0269\3\2\2\2\u0267\u0268\7a\2\2\u0268"+
		"\u026a\5L\'\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u02f7\3\2"+
		"\2\2\u026b\u02f7\t.\2\2\u026c\u02f7\t/\2\2\u026d\u02f7\7V\2\2\u026e\u02f7"+
		"\7\27\2\2\u026f\u0273\7\"\2\2\u0270\u0271\7f\2\2\u0271\u0272\7\u00ac\2"+
		"\2\u0272\u0274\7Q\2\2\u0273\u0270\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0276"+
		"\3\2\2\2\u0275\u0277\7}\2\2\u0276\u0275\3\2\2\2\u0276\u0277\3\2\2\2\u0277"+
		"\u0279\3\2\2\2\u0278\u027a\7`\2\2\u0279\u0278\3\2\2\2\u0279\u027a\3\2"+
		"\2\2\u027a\u02f7\3\2\2\2\u027b\u0283\t\60\2\2\u027c\u027d\7f\2\2\u027d"+
		"\u0280\7\u00ac\2\2\u027e\u027f\7\30\2\2\u027f\u0281\7\u00ac\2\2\u0280"+
		"\u027e\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0284\7Q"+
		"\2\2\u0283\u027c\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0286\3\2\2\2\u0285"+
		"\u0287\7}\2\2\u0286\u0285\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0289\3\2"+
		"\2\2\u0288\u028a\7`\2\2\u0289\u0288\3\2\2\2\u0289\u028a\3\2\2\2\u028a"+
		"\u02f7\3\2\2\2\u028b\u02f7\7\u0096\2\2\u028c\u02ab\7\u00a4\2\2\u028d\u028f"+
		"\7f\2\2\u028e\u0290\7:\2\2\u028f\u028e\3\2\2\2\u028f\u0290\3\2\2\2\u0290"+
		"\u0291\3\2\2\2\u0291\u0293\7\u00ab\2\2\u0292\u0294\7:\2\2\u0293\u0292"+
		"\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u029f\3\2\2\2\u0295\u0297\7\30\2\2"+
		"\u0296\u0298\7:\2\2\u0297\u0296\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0299"+
		"\3\2\2\2\u0299\u029b\7\u00ab\2\2\u029a\u029c\7:\2\2\u029b\u029a\3\2\2"+
		"\2\u029b\u029c\3\2\2\2\u029c\u029e\3\2\2\2\u029d\u0295\3\2\2\2\u029e\u02a1"+
		"\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a2\3\2\2\2\u02a1"+
		"\u029f\3\2\2\2\u02a2\u02a5\7Q\2\2\u02a3\u02a4\7#\2\2\u02a4\u02a6\7\u00a8"+
		"\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a9\3\2\2\2\u02a7"+
		"\u02a8\7a\2\2\u02a8\u02aa\5L\'\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa\3\2\2"+
		"\2\u02aa\u02ac\3\2\2\2\u02ab\u028d\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02f7"+
		"\3\2\2\2\u02ad\u02af\7?\2\2\u02ae\u02b0\7\26\2\2\u02af\u02ae\3\2\2\2\u02af"+
		"\u02b0\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1\u02b2\7#\2\2\u02b2\u02b4\7\u00a8"+
		"\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b7\3\2\2\2\u02b5"+
		"\u02b6\7a\2\2\u02b6\u02b8\5L\'\2\u02b7\u02b5\3\2\2\2\u02b7\u02b8\3\2\2"+
		"\2\u02b8\u02f7\3\2\2\2\u02b9\u02bb\t\61\2\2\u02ba\u02bc\7\26\2\2\u02bb"+
		"\u02ba\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bf\3\2\2\2\u02bd\u02be\7#"+
		"\2\2\u02be\u02c0\7\u00a8\2\2\u02bf\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0"+
		"\u02c3\3\2\2\2\u02c1\u02c2\7a\2\2\u02c2\u02c4\5L\'\2\u02c3\u02c1\3\2\2"+
		"\2\u02c3\u02c4\3\2\2\2\u02c4\u02f7\3\2\2\2\u02c5\u02c7\7\u0090\2\2\u02c6"+
		"\u02c8\7\26\2\2\u02c7\u02c6\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02cb\3"+
		"\2\2\2\u02c9\u02ca\7#\2\2\u02ca\u02cc\7\u00a8\2\2\u02cb\u02c9\3\2\2\2"+
		"\u02cb\u02cc\3\2\2\2\u02cc\u02cf\3\2\2\2\u02cd\u02ce\7a\2\2\u02ce\u02d0"+
		"\5L\'\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02f7\3\2\2\2\u02d1"+
		"\u02d3\7\17\2\2\u02d2\u02d4\7\26\2\2\u02d3\u02d2\3\2\2\2\u02d3\u02d4\3"+
		"\2\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d6\7#\2\2\u02d6\u02d8\7\u00a8\2\2"+
		"\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9\u02da"+
		"\7a\2\2\u02da\u02dc\5L\'\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02f7\3\2\2\2\u02dd\u02e1\7@\2\2\u02de\u02df\7f\2\2\u02df\u02e0\7\u00ac"+
		"\2\2\u02e0\u02e2\7Q\2\2\u02e1\u02de\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2"+
		"\u02f7\3\2\2\2\u02e3\u02f7\7\u0086\2\2\u02e4\u02f7\7\23\2\2\u02e5\u02f7"+
		"\7\13\2\2\u02e6\u02ea\7D\2\2\u02e7\u02e8\7f\2\2\u02e8\u02e9\7\u00ac\2"+
		"\2\u02e9\u02eb\7Q\2\2\u02ea\u02e7\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ee"+
		"\3\2\2\2\u02ec\u02ed\7#\2\2\u02ed\u02ef\7\u00a8\2\2\u02ee\u02ec\3\2\2"+
		"\2\u02ee\u02ef\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0\u02f1\7a\2\2\u02f1\u02f3"+
		"\5L\'\2\u02f2\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f7\3\2\2\2\u02f4"+
		"\u02f7\7u\2\2\u02f5\u02f7\7.\2\2\u02f6\u0233\3\2\2\2\u02f6\u0239\3\2\2"+
		"\2\u02f6\u0245\3\2\2\2\u02f6\u0251\3\2\2\2\u02f6\u025d\3\2\2\2\u02f6\u026b"+
		"\3\2\2\2\u02f6\u026c\3\2\2\2\u02f6\u026d\3\2\2\2\u02f6\u026e\3\2\2\2\u02f6"+
		"\u026f\3\2\2\2\u02f6\u027b\3\2\2\2\u02f6\u028b\3\2\2\2\u02f6\u028c\3\2"+
		"\2\2\u02f6\u02ad\3\2\2\2\u02f6\u02b9\3\2\2\2\u02f6\u02c5\3\2\2\2\u02f6"+
		"\u02d1\3\2\2\2\u02f6\u02dd\3\2\2\2\u02f6\u02e3\3\2\2\2\u02f6\u02e4\3\2"+
		"\2\2\u02f6\u02e5\3\2\2\2\u02f6\u02e6\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f6"+
		"\u02f5\3\2\2\2\u02f7C\3\2\2\2\u02f8\u02f9\t\62\2\2\u02f9\u02fa\7\21\2"+
		"\2\u02fa\u02fb\5L\'\2\u02fb\u02fc\b#\1\2\u02fc\u0339\3\2\2\2\u02fd\u02fe"+
		"\7\20\2\2\u02fe\u02ff\7\u00a8\2\2\u02ff\u0339\b#\1\2\u0300\u0301\7\3\2"+
		"\2\u0301\u0302\5F$\2\u0302\u0303\b#\1\2\u0303\u0339\3\2\2\2\u0304\u0305"+
		"\7h\2\2\u0305\u0306\7\u00ac\2\2\u0306\u0339\b#\1\2\u0307\u0308\7\32\2"+
		"\2\u0308\u0309\7\u00ac\2\2\u0309\u0339\b#\1\2\u030a\u030b\7_\2\2\u030b"+
		"\u030c\7\u00ac\2\2\u030c\u0339\b#\1\2\u030d\u0314\7\u0082\2\2\u030e\u0310"+
		"\13\2\2\2\u030f\u030e\3\2\2\2\u0310\u0313\3\2\2\2\u0311\u030f\3\2\2\2"+
		"\u0311\u0312\3\2\2\2\u0312\u0315\3\2\2\2\u0313\u0311\3\2\2\2\u0314\u0311"+
		"\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0339\b#\1\2\u0317"+
		"\u031e\7\3\2\2\u0318\u031a\13\2\2\2\u0319\u0318\3\2\2\2\u031a\u031d\3"+
		"\2\2\2\u031b\u0319\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031f\3\2\2\2\u031d"+
		"\u031b\3\2\2\2\u031e\u031b\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0320\3\2"+
		"\2\2\u0320\u0339\b#\1\2\u0321\u0322\7\65\2\2\u0322\u0323\7\u00ac\2\2\u0323"+
		"\u0339\b#\1\2\u0324\u032b\7G\2\2\u0325\u0327\13\2\2\2\u0326\u0325\3\2"+
		"\2\2\u0327\u032a\3\2\2\2\u0328\u0326\3\2\2\2\u0328\u0329\3\2\2\2\u0329"+
		"\u032c\3\2\2\2\u032a\u0328\3\2\2\2\u032b\u0328\3\2\2\2\u032b\u032c\3\2"+
		"\2\2\u032c\u0339\3\2\2\2\u032d\u032e\7R\2\2\u032e\u0339\7\u00ac\2\2\u032f"+
		"\u0330\7\\\2\2\u0330\u0339\7\u00ac\2\2\u0331\u0335\7\22\2\2\u0332\u0334"+
		"\13\2\2\2\u0333\u0332\3\2\2\2\u0334\u0337\3\2\2\2\u0335\u0333\3\2\2\2"+
		"\u0335\u0336\3\2\2\2\u0336\u0339\3\2\2\2\u0337\u0335\3\2\2\2\u0338\u02f8"+
		"\3\2\2\2\u0338\u02fd\3\2\2\2\u0338\u0300\3\2\2\2\u0338\u0304\3\2\2\2\u0338"+
		"\u0307\3\2\2\2\u0338\u030a\3\2\2\2\u0338\u030d\3\2\2\2\u0338\u0317\3\2"+
		"\2\2\u0338\u0321\3\2\2\2\u0338\u0324\3\2\2\2\u0338\u032d\3\2\2\2\u0338"+
		"\u032f\3\2\2\2\u0338\u0331\3\2\2\2\u0339E\3\2\2\2\u033a\u033b\t\63\2\2"+
		"\u033bG\3\2\2\2\u033c\u033d\7\36\2\2\u033dI\3\2\2\2\u033e\u0348\5L\'\2"+
		"\u033f\u0341\7\u0089\2\2\u0340\u033f\3\2\2\2\u0340\u0341\3\2\2\2\u0341"+
		"\u0342\3\2\2\2\u0342\u0343\7\u00ac\2\2\u0343\u0345\7\u00ab\2\2\u0344\u0346"+
		"\7\u0089\2\2\u0345\u0344\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0348\3\2\2"+
		"\2\u0347\u033e\3\2\2\2\u0347\u0340\3\2\2\2\u0348K\3\2\2\2\u0349\u034b"+
		"\7\u0089\2\2\u034a\u0349\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034c\3\2\2"+
		"\2\u034c\u034e\t\64\2\2\u034d\u034f\7\u0089\2\2\u034e\u034d\3\2\2\2\u034e"+
		"\u034f\3\2\2\2\u034fM\3\2\2\2\u008dWY[ajou\177\u0086\u008d\u0091\u0095"+
		"\u00a1\u00a3\u00ac\u00c3\u00cd\u00d7\u00da\u00de\u00e2\u00e9\u00ec\u00ef"+
		"\u00f3\u00f5\u00f8\u00fc\u0103\u0108\u010b\u010f\u0113\u0118\u011c\u0121"+
		"\u0126\u012a\u012d\u012f\u0137\u013b\u0143\u0147\u014c\u0150\u015f\u0161"+
		"\u0168\u016f\u0177\u017f\u0187\u018b\u0190\u0193\u0199\u01a1\u01a9\u01b0"+
		"\u01b6\u01bc\u01c4\u01cc\u01d2\u01d8\u01e3\u01ea\u01ef\u01fa\u0206\u020a"+
		"\u020d\u0211\u0214\u0218\u021b\u021e\u0224\u0227\u0231\u0237\u023d\u0240"+
		"\u0243\u0249\u024c\u024f\u0255\u0258\u025b\u0261\u0265\u0269\u0273\u0276"+
		"\u0279\u0280\u0283\u0286\u0289\u028f\u0293\u0297\u029b\u029f\u02a5\u02a9"+
		"\u02ab\u02af\u02b3\u02b7\u02bb\u02bf\u02c3\u02c7\u02cb\u02cf\u02d3\u02d7"+
		"\u02db\u02e1\u02ea\u02ee\u02f2\u02f6\u0311\u0314\u031b\u031e\u0328\u032b"+
		"\u0335\u0338\u0340\u0345\u0347\u034a\u034e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}