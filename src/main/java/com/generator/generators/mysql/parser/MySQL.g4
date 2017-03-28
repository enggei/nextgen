grammar MySQL;

@members {
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
}

database    :	(LINE_COMMENT|COMMENT|(createDatabase|createTableStatement|alterTableStatement|procedure|updateStatement|insertStatement|';'))*?
			;

createDatabase
            :	('CREATE'|'create') ('DATABASE'|'database') 'IF NOT EXISTS'? name ';'
			|	'USE' name ';'
			;

createTableStatement
            :	('DROP'|'drop') ('TABLE'|'table') ('IF EXISTS'|'if exists')? name
			|	('CREATE'|'create') ('TABLE'|'table') 'IF NOT EXISTS'? name { createTable($name.text.substring(0,$name.text.length()-1));} '(' columnSpecification (',' columnSpecification)* (',' tableConstraint)* ')' tableOption* ';'? { tableCreated(); }
			;

alterTableStatement
            :   ('ALTER'|'alter') ('TABLE'|'table') name (addColumn|dropColumn|modifyColumn|addIndex|dropIndex|addConstraint|',')*
            ;

addColumn   :   ('ADD'|'add') ('COLUMN'|'column') columnSpecification
            ;

modifyColumn
            :   ('MODIFY'|'modify') ('COLUMN'|'column')? columnSpecification
            ;

dropColumn  :   ('DROP'|'drop') ('COLUMN'|'column') colName
            ;

addIndex    :   ('ADD'|'add') ('INDEX'|'index') name '(' colName ')'
            ;

dropIndex   :   ('DROP'|'drop') ('INDEX'|'index') name
            ;

addConstraint
            :   ('ADD'|'add') (('CONSTRAINT'|'constraint') name | foreignKey)
            ;

procedure	:	'DELIMITER' '//' procedureContent { procedure($procedureContent.text);  } 'DELIMITER'
			;

updateStatement
            :   ('UPDATE'|'update') ('IGNORE'|'ignore')? name ('SET'|'set') (colName '=' (('NOW()'|'now()') | ('NULL'||'null')|'\''? ID '\''?|(('CAST'|'cast') '('?) colName (('AS'|'as') ('UNSIGNED'|'unsigned'|dataType) ')')? |'\"'? ID '\"'?) ','?)*? (('WHERE'|'where') colName '=' ('NOT'|'not')? (('NULL'||'null')|'\''? ID '\''?|colName|'\"'? (.*) '\"'?| ('IN'|'in') '(' ('\"'? (.*) '\"'?) ')' ))?
            ;

insertStatement
            :   ('INSERT'|'insert') ('INTO'|'into') name '(' ((colName) ','?)+ ')' selectStatement
            ;

selectStatement
            :   ('SELECT'|'select') ((colName) ','?)+ ('FROM'|'from') ((name) ','?)+
            ;

procedureContent
            :	(ID|'@'|'.'|'%'|'+'|'-'|'*'|'/'|'<'|'>'|':'|';'|~('DELIMITER'))*
			;

tableConstraint
            :	(primaryKey | uniqueKey | indexKey | foreignKey )
			;

primaryKey	:	('PRIMARY KEY'|'primary key') ('USING' c=indexType { primaryKeyType($c.text); })? '(' a=primaryKeyCol (',' b=primaryKeyCol)* ')' ('USING' d=indexType { primaryKeyType($d.text); })?
			;

primaryKeyCol
            :	colName { primaryKeyColumn($colName.text.substring(1,$colName.text.length()-1)); }
			;

uniqueKey	:	('UNIQUE'|'unique') (('KEY'|'key')|('INDEX'|'index'))? { newUniqueKey(); } '('? (name { uniqueKey($name.text.substring(1,$name.text.length()-1)); })? ')'? ('USING' a=indexType { uniqueKeyIndex($a.text); })? '(' uniqueKeyCol (',' uniqueKeyCol)* ')' ('USING' b=indexType { uniqueKeyIndex($b.text); })?
			;

uniqueKeyCol
		    :	colName { uniqueKeyColumn($colName.text.substring(1,$colName.text.length()-1)); }
			;			

indexKey	:	(('KEY'|'key')|('INDEX'|'index')) { newIndexKey(); } (name { indexKey($name.text.substring(1,$name.text.length()-1));})? ('USING' a=indexType { indexKeyIndex($a.text);} )? '(' indexKeyCol (',' indexKeyCol)* ')' ('USING' b=indexType { indexKeyIndex($b.text); })?
			;

indexKeyCol	:	colName { indexKeyColumn($colName.text); }
			;

foreignKey	:	('CONSTRAINT'|'constraint')? { newConstraint(); } (name { foreignKey($name.text.substring(1,$name.text.length()-1)); })? ('FOREIGN KEY'|'foreign key') '(' colName { foreignKeyColumn($colName.text.substring(1,$colName.text.length()-1)); } ')' referencesDefinition
			;

referencesDefinition
            :	('REFERENCES'|'references') (name)? '(' colName { foreignKeyReference($name.text.substring(1,$name.text.length()-1),$colName.text.substring(1,$colName.text.length()-1)); } ')' ('MATCH FULL'|'MATCH PARTIAL'|'MATCH SIMPLE')? (referencesAction)*
			;

referencesAction
            :	'ON DELETE' referenceOption { foreignKeyOnDelete($referenceOption.text); }
			|	'ON UPDATE' referenceOption { foreignKeyOnUpdate($referenceOption.text); }
			;

referenceOption
            :	('RESTRICT'|'CASCADE'|'SET NULL'|'NO ACTION');
			
indexType	:	('BTREE'|'HASH'|'RTREE')
			;

columnSpecification
            :	colName { newColumn($colName.text.substring(1,$colName.text.length()-1)); } columnDefinition
			;

nullable	:	('NOT NULL'|'NULL') | ('not null'|'null');

columnDefinition
            :	dataType nullable? defaultValue? (('ON UPDATE'|'on update') (onUpdate))? (autoIncrement)? (('UNIQUE'|'unique') ('KEY'|'key')? | 'PRIMARY'? 'KEY')?  ('COMMENT' (.*))? { column($dataType.text,!"NOT NULL".equals($nullable.text),prepDefaultValue($defaultValue.text),$onUpdate.text,$autoIncrement.text); }
			;

autoIncrement
            :	('AUTO_INCREMENT'|'auto_increment')
			;

defaultValue
            :	(('DEFAULT'|'default') ('NULL'|'null'|INT))
			|	'DEFAULT CURRENT_TIMESTAMP'
			|	'DEFAULT b\'0\'' 
			;

dataType
            :	('BIT'|'bit') ('(' INT ')')?
			|	('TINYINT'|'tinyint') ('(' INT ')')? 'UNSIGNED'? 'ZEROFILL'?
			|	('BIGINT'|'bigint') ('(' INT ')')? 'UNSIGNED'? 'ZEROFILL'?
			|	('INT'|'INTEGER'|'integer'|'int') ('(' INT ')')? 'UNSIGNED'? 'ZEROFILL'?
			|	('VARCHAR'|'varchar') ('(' INT ')')? ('CHARACTER SET' DEFAULTCHARSET)? ('COLLATE' name)?
			|	('FLOAT'|'float')
			|	('TIMESTAMP'|'timestamp')
			|	'TIME'
			|	'BOOL'
			|	'SMALLINT' ('(' INT ')')? 'UNSIGNED'? 'ZEROFILL'?
			|	('DECIMAL'|'DOUBLE'|'double') ('(' INT (',' INT)? ')')? 'UNSIGNED'? 'ZEROFILL'?
			|	'DATE'
			|	'ENUM' ('(' '\''? ID '\''? (',' '\''? ID '\''?)* ')' ('CHARACTER SET' DEFAULTCHARSET)? ('COLLATE' name)?)?
			|	'TEXT' 'binary'? ('CHARACTER SET' DEFAULTCHARSET)? ('COLLATE' name)?
			|	('LONGTEXT'|'longtext') 'binary'? ('CHARACTER SET' DEFAULTCHARSET)? ('COLLATE' name)?
			|	'MEDIUMTEXT' 'binary'? ('CHARACTER SET' DEFAULTCHARSET)? ('COLLATE' name)?			
			|	'TINYTEXT' 'binary'? ('CHARACTER SET' DEFAULTCHARSET)? ('COLLATE' name)?			
			|	'BINARY' ('(' INT ')')?
			|	'BLOB'
			|	'MEDIUMBLOB'
			|	'LONGBLOB'
			|	'CHAR' ('(' INT ')')? ('CHARACTER SET' DEFAULTCHARSET)? ('COLLATE' name)?
			|	'DATETIME'
			|	'datetime'
			;

tableOption	:	('ENGINE'|'TYPE') '=' name { tableOption("engine",$name.text);  }
			|	'DEFAULT CHARSET=' DEFAULTCHARSET { tableOption("charset",$DEFAULTCHARSET.text);  }
			|	'ROW_FORMAT=' rowFormat { tableOption("rowFormat",$rowFormat.text);  }
			|	'AUTO_INCREMENT=' INT { tableOption("autoIncrement",$INT.text);  }
			|	'MIN_ROWS=' INT { tableOption("minRows",$INT.text);  }
			|	'MAX_ROWS=' INT { tableOption("maxRows",$INT.text);  }
			|	'CONNECTION=' (.*)? { tableOption("connection","");  }
			|	'ROW_FORMAT=' (.*)? { tableOption("rowFormat","");  }
			|	'PACK_KEYS=' INT { tableOption("packKeys",$INT.text);  }
			|	'COLLATE=' (.*)?
			|	'CHECKSUM=' INT
			|	'DELAY_KEY_WRITE=' INT
			|	'COMMENT=' (.*)
			;

rowFormat   :	'DYNAMIC'
			|	'FIXED';

onUpdate    :	'CURRENT_TIMESTAMP'
			;
	
colName     :	name
			| 	'`'? INT ID '`'?
			;

name        :	'`'? (ID|'TIMESTAMP'|'DATE'|'TEXT'|'ID'|'COMMENT'|'TYPE') '`'?
			;

DEFAULTCHARSET
            :	'LATIN1'
			|	'latin1'
			|	'UTF8'
			|   'utf8'
			;

LINE_COMMENT
            : 	('--'|'#') .*? '\r'? '\n' -> skip
			;
			
COMMENT     : 	'/*' '!'? .*? '*/' -> skip
			;
		
ID			: 	('a'..'z' |'A'..'Z' | '_') ('a'..'z' |'A'..'Z' | '_' | '-' | '0'..'9')*;
			
INT			: 	('0'..'9'|'\\0')+;

WS  		:   [ \t\n\r]+ -> skip
			;