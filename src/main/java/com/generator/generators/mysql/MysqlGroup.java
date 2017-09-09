package com.generator.generators.mysql;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'mysql.stg' file<br/>
 */
public final class MysqlGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public MysqlGroup() {
		this(new STGroupString(stg));
   }

   public MysqlGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public MysqlGroup(java.io.File templateFile) {
   	this.stGroup = new org.stringtemplate.v4.STGroupFile(templateFile.getAbsolutePath());
	   this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
	   this.delimiter = stGroup.delimiterStartChar;
	}

   public STGroup getSTGroup() {
      return stGroup;
   }

   public char getDelimiter() {
      return delimiter;
   }

	public interface MysqlGroupTemplate {

	}

   public tableFooterST newtableFooter() {
      return new tableFooterST(stGroup);
   }

   public alterTableAddForeignKeyConstraintST newalterTableAddForeignKeyConstraint() {
      return new alterTableAddForeignKeyConstraintST(stGroup);
   }

   public alterTableAddColumnST newalterTableAddColumn() {
      return new alterTableAddColumnST(stGroup);
   }

   public createColumnST newcreateColumn() {
      return new createColumnST(stGroup);
   }

   public createDatabaseST newcreateDatabase() {
      return new createDatabaseST(stGroup);
   }

   public createForeignConstraintsST newcreateForeignConstraints() {
      return new createForeignConstraintsST(stGroup);
   }

   public createKeyST newcreateKey() {
      return new createKeyST(stGroup);
   }

   public createPrimaryKeyST newcreatePrimaryKey() {
      return new createPrimaryKeyST(stGroup);
   }

   public alterTableDropColumnST newalterTableDropColumn() {
      return new alterTableDropColumnST(stGroup);
   }

   public alterTableDropForeignKeyConstraintST newalterTableDropForeignKeyConstraint() {
      return new alterTableDropForeignKeyConstraintST(stGroup);
   }

   public alterTableDropIndexST newalterTableDropIndex() {
      return new alterTableDropIndexST(stGroup);
   }

   public alterTableDropUniqueKeyST newalterTableDropUniqueKey() {
      return new alterTableDropUniqueKeyST(stGroup);
   }

   public alterTableModifyColumnST newalterTableModifyColumn() {
      return new alterTableModifyColumnST(stGroup);
   }

   public alterTableUpdateForeignKeyConstraintST newalterTableUpdateForeignKeyConstraint() {
      return new alterTableUpdateForeignKeyConstraintST(stGroup);
   }

   public joinST newjoin() {
      return new joinST(stGroup);
   }

   public createTableST newcreateTable() {
      return new createTableST(stGroup);
   }

   public createUniqueKeyST newcreateUniqueKey() {
      return new createUniqueKeyST(stGroup);
   }

   public disableKeysST newdisableKeys() {
      return new disableKeysST(stGroup);
   }

   public dropTableST newdropTable() {
      return new dropTableST(stGroup);
   }

   public enableKeysST newenableKeys() {
      return new enableKeysST(stGroup);
   }

   public preparedStatementST newpreparedStatement() {
      return new preparedStatementST(stGroup);
   }

   public updateST newupdate() {
      return new updateST(stGroup);
   }

   public insertST newinsert() {
      return new insertST(stGroup);
   }

   public alterTableAddUniqueKeyST newalterTableAddUniqueKey() {
      return new alterTableAddUniqueKeyST(stGroup);
   }

   public alterTableUpdateIndexST newalterTableUpdateIndex() {
      return new alterTableUpdateIndexST(stGroup);
   }

   public alterTableUpdateUniqueKeyST newalterTableUpdateUniqueKey() {
      return new alterTableUpdateUniqueKeyST(stGroup);
   }

   public recreateDatabaseST newrecreateDatabase() {
      return new recreateDatabaseST(stGroup);
   }

   public alterTableAddIndexST newalterTableAddIndex() {
      return new alterTableAddIndexST(stGroup);
   }

   public selectST newselect() {
      return new selectST(stGroup);
   }

   public final class tableFooterST implements MysqlGroupTemplate {

      private Object _autoIncrement;
      private Object _rowFormat;
      private Object _avgRowLength;
      private Object _charset;
      private Object _comments;
      private Object _connection;
      private Object _engine;
      private Object _maxRows;
      private Object _minRows;
      private Object _packKeys;

      private final ST template;

      private tableFooterST(STGroup group) {
   		template = group.getInstanceOf("tableFooter");
   	}

      public tableFooterST setAutoIncrement(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._autoIncrement == null) {
            this._autoIncrement = value;
         	template.add("autoIncrement", value);
         }

      	return this;
      }

      public String getAutoIncrement() {
      	return (String) this._autoIncrement;
      }

      public tableFooterST setRowFormat(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._rowFormat == null) {
            this._rowFormat = value;
         	template.add("rowFormat", value);
         }

      	return this;
      }

      public String getRowFormat() {
      	return (String) this._rowFormat;
      }

      public tableFooterST setAvgRowLength(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._avgRowLength == null) {
            this._avgRowLength = value;
         	template.add("avgRowLength", value);
         }

      	return this;
      }

      public String getAvgRowLength() {
      	return (String) this._avgRowLength;
      }

      public tableFooterST setCharset(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._charset == null) {
            this._charset = value;
         	template.add("charset", value);
         }

      	return this;
      }

      public String getCharset() {
      	return (String) this._charset;
      }

      public tableFooterST setComments(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._comments == null) {
            this._comments = value;
         	template.add("comments", value);
         }

      	return this;
      }

      public String getComments() {
      	return (String) this._comments;
      }

      public tableFooterST setConnection(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._connection == null) {
            this._connection = value;
         	template.add("connection", value);
         }

      	return this;
      }

      public String getConnection() {
      	return (String) this._connection;
      }

      public tableFooterST setEngine(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._engine == null) {
            this._engine = value;
         	template.add("engine", value);
         }

      	return this;
      }

      public String getEngine() {
      	return (String) this._engine;
      }

      public tableFooterST setMaxRows(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._maxRows == null) {
            this._maxRows = value;
         	template.add("maxRows", value);
         }

      	return this;
      }

      public String getMaxRows() {
      	return (String) this._maxRows;
      }

      public tableFooterST setMinRows(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._minRows == null) {
            this._minRows = value;
         	template.add("minRows", value);
         }

      	return this;
      }

      public String getMinRows() {
      	return (String) this._minRows;
      }

      public tableFooterST setPackKeys(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._packKeys == null) {
            this._packKeys = value;
         	template.add("packKeys", value);
         }

      	return this;
      }

      public String getPackKeys() {
      	return (String) this._packKeys;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableAddForeignKeyConstraintST implements MysqlGroupTemplate {

      private Object _column;
      private Object _name;
      private Object _onDelete;
      private Object _onUpdate;
      private Object _refColumn;
      private Object _refTable;
      private Object _table;

      private final ST template;

      private alterTableAddForeignKeyConstraintST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddForeignKeyConstraint");
   	}

      public alterTableAddForeignKeyConstraintST setColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._column == null) {
            this._column = value;
         	template.add("column", value);
         }

      	return this;
      }

      public String getColumn() {
      	return (String) this._column;
      }

      public alterTableAddForeignKeyConstraintST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableAddForeignKeyConstraintST setOnDelete(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onDelete == null) {
            this._onDelete = value;
         	template.add("onDelete", value);
         }

      	return this;
      }

      public String getOnDelete() {
      	return (String) this._onDelete;
      }

      public alterTableAddForeignKeyConstraintST setOnUpdate(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onUpdate == null) {
            this._onUpdate = value;
         	template.add("onUpdate", value);
         }

      	return this;
      }

      public String getOnUpdate() {
      	return (String) this._onUpdate;
      }

      public alterTableAddForeignKeyConstraintST setRefColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._refColumn == null) {
            this._refColumn = value;
         	template.add("refColumn", value);
         }

      	return this;
      }

      public String getRefColumn() {
      	return (String) this._refColumn;
      }

      public alterTableAddForeignKeyConstraintST setRefTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._refTable == null) {
            this._refTable = value;
         	template.add("refTable", value);
         }

      	return this;
      }

      public String getRefTable() {
      	return (String) this._refTable;
      }

      public alterTableAddForeignKeyConstraintST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableAddColumnST implements MysqlGroupTemplate {

      private Object _before;
      private Object _column;
      private Object _table;

      private final ST template;

      private alterTableAddColumnST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddColumn");
   	}

      public alterTableAddColumnST setBefore(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._before == null) {
            this._before = value;
         	template.add("before", value);
         }

      	return this;
      }

      public String getBefore() {
      	return (String) this._before;
      }

      public alterTableAddColumnST setColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._column == null) {
            this._column = value;
         	template.add("column", value);
         }

      	return this;
      }

      public String getColumn() {
      	return (String) this._column;
      }

      public alterTableAddColumnST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createColumnST implements MysqlGroupTemplate {

      private Object _autoIncrement;
      private Object _comment;
      private Object _defaultValue;
      private Object _name;
      private Object _nullable;
      private Object _onUpdate;
      private Object _type;

      private final ST template;

      private createColumnST(STGroup group) {
   		template = group.getInstanceOf("createColumn");
   	}

      public createColumnST setAutoIncrement(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._autoIncrement == null) {
            this._autoIncrement = value;
         	template.add("autoIncrement", value);
         }

      	return this;
      }

      public String getAutoIncrement() {
      	return (String) this._autoIncrement;
      }

      public createColumnST setComment(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._comment == null) {
            this._comment = value;
         	template.add("comment", value);
         }

      	return this;
      }

      public String getComment() {
      	return (String) this._comment;
      }

      public createColumnST setDefaultValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._defaultValue == null) {
            this._defaultValue = value;
         	template.add("defaultValue", value);
         }

      	return this;
      }

      public String getDefaultValue() {
      	return (String) this._defaultValue;
      }

      public createColumnST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public createColumnST setNullable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._nullable == null) {
            this._nullable = value;
         	template.add("nullable", value);
         }

      	return this;
      }

      public String getNullable() {
      	return (String) this._nullable;
      }

      public createColumnST setOnUpdate(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onUpdate == null) {
            this._onUpdate = value;
         	template.add("onUpdate", value);
         }

      	return this;
      }

      public String getOnUpdate() {
      	return (String) this._onUpdate;
      }

      public createColumnST setType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._type == null) {
            this._type = value;
         	template.add("type", value);
         }

      	return this;
      }

      public String getType() {
      	return (String) this._type;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createDatabaseST implements MysqlGroupTemplate {

      private Object _name;
      private Object _script;

      private final ST template;

      private createDatabaseST(STGroup group) {
   		template = group.getInstanceOf("createDatabase");
   	}

      public createDatabaseST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public createDatabaseST setScript(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._script == null) {
            this._script = value;
         	template.add("script", value);
         }

      	return this;
      }

      public String getScript() {
      	return (String) this._script;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createForeignConstraintsST implements MysqlGroupTemplate {

      private Object _column;
      private Object _name;
      private Object _onDelete;
      private Object _onUpdate;
      private Object _refColumn;
      private Object _refTable;

      private final ST template;

      private createForeignConstraintsST(STGroup group) {
   		template = group.getInstanceOf("createForeignConstraints");
   	}

      public createForeignConstraintsST setColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._column == null) {
            this._column = value;
         	template.add("column", value);
         }

      	return this;
      }

      public String getColumn() {
      	return (String) this._column;
      }

      public createForeignConstraintsST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public createForeignConstraintsST setOnDelete(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onDelete == null) {
            this._onDelete = value;
         	template.add("onDelete", value);
         }

      	return this;
      }

      public String getOnDelete() {
      	return (String) this._onDelete;
      }

      public createForeignConstraintsST setOnUpdate(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onUpdate == null) {
            this._onUpdate = value;
         	template.add("onUpdate", value);
         }

      	return this;
      }

      public String getOnUpdate() {
      	return (String) this._onUpdate;
      }

      public createForeignConstraintsST setRefColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._refColumn == null) {
            this._refColumn = value;
         	template.add("refColumn", value);
         }

      	return this;
      }

      public String getRefColumn() {
      	return (String) this._refColumn;
      }

      public createForeignConstraintsST setRefTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._refTable == null) {
            this._refTable = value;
         	template.add("refTable", value);
         }

      	return this;
      }

      public String getRefTable() {
      	return (String) this._refTable;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createKeyST implements MysqlGroupTemplate {

      private java.util.Set<Object> _key_ = new java.util.LinkedHashSet<>();
      private Object _indexType;
      private Object _name;

      private final ST template;

      private createKeyST(STGroup group) {
   		template = group.getInstanceOf("createKey");
   	}

      public createKeyST addKey_Value(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._key_.add(value);
      	template.add("key_", value);

         return this;
      }

      public java.util.Set<Object> getKey_Values() {
      	return this._key_;
      }

      public createKeyST setIndexType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._indexType == null) {
            this._indexType = value;
         	template.add("indexType", value);
         }

      	return this;
      }

      public String getIndexType() {
      	return (String) this._indexType;
      }

      public createKeyST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createPrimaryKeyST implements MysqlGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _primaries = new java.util.LinkedHashSet<>();

      private final ST template;

      private createPrimaryKeyST(STGroup group) {
   		template = group.getInstanceOf("createPrimaryKey");
   	}

      public createPrimaryKeyST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public createPrimaryKeyST addPrimariesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._primaries.add(value);
      	template.add("primaries", value);

         return this;
      }

      public java.util.Set<Object> getPrimariesValues() {
      	return this._primaries;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableDropColumnST implements MysqlGroupTemplate {

      private Object _column;
      private Object _table;

      private final ST template;

      private alterTableDropColumnST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropColumn");
   	}

      public alterTableDropColumnST setColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._column == null) {
            this._column = value;
         	template.add("column", value);
         }

      	return this;
      }

      public String getColumn() {
      	return (String) this._column;
      }

      public alterTableDropColumnST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableDropForeignKeyConstraintST implements MysqlGroupTemplate {

      private Object _name;
      private Object _table;

      private final ST template;

      private alterTableDropForeignKeyConstraintST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropForeignKeyConstraint");
   	}

      public alterTableDropForeignKeyConstraintST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableDropForeignKeyConstraintST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableDropIndexST implements MysqlGroupTemplate {

      private Object _name;
      private Object _table;

      private final ST template;

      private alterTableDropIndexST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropIndex");
   	}

      public alterTableDropIndexST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableDropIndexST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableDropUniqueKeyST implements MysqlGroupTemplate {

      private Object _name;
      private Object _table;

      private final ST template;

      private alterTableDropUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropUniqueKey");
   	}

      public alterTableDropUniqueKeyST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableDropUniqueKeyST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableModifyColumnST implements MysqlGroupTemplate {

      private Object _autoIncrement;
      private Object _column;
      private Object _comment;
      private Object _defaultValue;
      private Object _nullable;
      private Object _onUpdate;
      private Object _table;
      private Object _type;

      private final ST template;

      private alterTableModifyColumnST(STGroup group) {
   		template = group.getInstanceOf("alterTableModifyColumn");
   	}

      public alterTableModifyColumnST setAutoIncrement(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._autoIncrement == null) {
            this._autoIncrement = value;
         	template.add("autoIncrement", value);
         }

      	return this;
      }

      public String getAutoIncrement() {
      	return (String) this._autoIncrement;
      }

      public alterTableModifyColumnST setColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._column == null) {
            this._column = value;
         	template.add("column", value);
         }

      	return this;
      }

      public String getColumn() {
      	return (String) this._column;
      }

      public alterTableModifyColumnST setComment(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._comment == null) {
            this._comment = value;
         	template.add("comment", value);
         }

      	return this;
      }

      public String getComment() {
      	return (String) this._comment;
      }

      public alterTableModifyColumnST setDefaultValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._defaultValue == null) {
            this._defaultValue = value;
         	template.add("defaultValue", value);
         }

      	return this;
      }

      public String getDefaultValue() {
      	return (String) this._defaultValue;
      }

      public alterTableModifyColumnST setNullable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._nullable == null) {
            this._nullable = value;
         	template.add("nullable", value);
         }

      	return this;
      }

      public String getNullable() {
      	return (String) this._nullable;
      }

      public alterTableModifyColumnST setOnUpdate(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onUpdate == null) {
            this._onUpdate = value;
         	template.add("onUpdate", value);
         }

      	return this;
      }

      public String getOnUpdate() {
      	return (String) this._onUpdate;
      }

      public alterTableModifyColumnST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      public alterTableModifyColumnST setType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._type == null) {
            this._type = value;
         	template.add("type", value);
         }

      	return this;
      }

      public String getType() {
      	return (String) this._type;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableUpdateForeignKeyConstraintST implements MysqlGroupTemplate {

      private Object _refTable;
      private Object _column;
      private Object _name;
      private Object _onDelete;
      private Object _onUpdate;
      private Object _refColumn;
      private Object _table;

      private final ST template;

      private alterTableUpdateForeignKeyConstraintST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateForeignKeyConstraint");
   	}

      public alterTableUpdateForeignKeyConstraintST setRefTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._refTable == null) {
            this._refTable = value;
         	template.add("refTable", value);
         }

      	return this;
      }

      public String getRefTable() {
      	return (String) this._refTable;
      }

      public alterTableUpdateForeignKeyConstraintST setColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._column == null) {
            this._column = value;
         	template.add("column", value);
         }

      	return this;
      }

      public String getColumn() {
      	return (String) this._column;
      }

      public alterTableUpdateForeignKeyConstraintST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableUpdateForeignKeyConstraintST setOnDelete(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onDelete == null) {
            this._onDelete = value;
         	template.add("onDelete", value);
         }

      	return this;
      }

      public String getOnDelete() {
      	return (String) this._onDelete;
      }

      public alterTableUpdateForeignKeyConstraintST setOnUpdate(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._onUpdate == null) {
            this._onUpdate = value;
         	template.add("onUpdate", value);
         }

      	return this;
      }

      public String getOnUpdate() {
      	return (String) this._onUpdate;
      }

      public alterTableUpdateForeignKeyConstraintST setRefColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._refColumn == null) {
            this._refColumn = value;
         	template.add("refColumn", value);
         }

      	return this;
      }

      public String getRefColumn() {
      	return (String) this._refColumn;
      }

      public alterTableUpdateForeignKeyConstraintST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class joinST implements MysqlGroupTemplate {

      private java.util.Set<Object> _tables = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _joins = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _order = new java.util.LinkedHashSet<>();

      private final ST template;

      private joinST(STGroup group) {
   		template = group.getInstanceOf("join");
   	}

      public joinST addTablesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._tables.add(value);
      	template.add("tables", value);

         return this;
      }

      public java.util.Set<Object> getTablesValues() {
      	return this._tables;
      }

      public joinST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public joinST addJoinsValue(Object fk_, Object source_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("fk", (fk_==null || fk_.toString().length()==0) ? null : fk_);
      	map.put("source", (source_==null || source_.toString().length()==0) ? null : source_);
      	this._joins.add(map);

         template.addAggr("joins.{fk, source}", map.get("fk"), map.get("source"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getJoins() {
      	return this._joins;
      }

      public joinST addOrderValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._order.add(value);
      	template.add("order", value);

         return this;
      }

      public java.util.Set<Object> getOrderValues() {
      	return this._order;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createTableST implements MysqlGroupTemplate {

      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private Object _footer;
      private java.util.Set<Object> _keys = new java.util.LinkedHashSet<>();
      private Object _name;

      private final ST template;

      private createTableST(STGroup group) {
   		template = group.getInstanceOf("createTable");
   	}

      public createTableST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public createTableST setFooter(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._footer == null) {
            this._footer = value;
         	template.add("footer", value);
         }

      	return this;
      }

      public String getFooter() {
      	return (String) this._footer;
      }

      public createTableST addKeysValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._keys.add(value);
      	template.add("keys", value);

         return this;
      }

      public java.util.Set<Object> getKeysValues() {
      	return this._keys;
      }

      public createTableST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createUniqueKeyST implements MysqlGroupTemplate {

      private Object _indexType;
      private java.util.Set<Object> _key_ = new java.util.LinkedHashSet<>();
      private Object _name;

      private final ST template;

      private createUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("createUniqueKey");
   	}

      public createUniqueKeyST setIndexType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._indexType == null) {
            this._indexType = value;
         	template.add("indexType", value);
         }

      	return this;
      }

      public String getIndexType() {
      	return (String) this._indexType;
      }

      public createUniqueKeyST addKey_Value(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._key_.add(value);
      	template.add("key_", value);

         return this;
      }

      public java.util.Set<Object> getKey_Values() {
      	return this._key_;
      }

      public createUniqueKeyST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class disableKeysST implements MysqlGroupTemplate {


      private final ST template;

      private disableKeysST(STGroup group) {
   		template = group.getInstanceOf("disableKeys");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class dropTableST implements MysqlGroupTemplate {

      private Object _table;

      private final ST template;

      private dropTableST(STGroup group) {
   		template = group.getInstanceOf("dropTable");
   	}

      public dropTableST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class enableKeysST implements MysqlGroupTemplate {


      private final ST template;

      private enableKeysST(STGroup group) {
   		template = group.getInstanceOf("enableKeys");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class preparedStatementST implements MysqlGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _params = new java.util.LinkedHashSet<>();
      private Object _sql;

      private final ST template;

      private preparedStatementST(STGroup group) {
   		template = group.getInstanceOf("preparedStatement");
   	}

      public preparedStatementST addParamsValue(Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_==null || name_.toString().length()==0) ? null : name_);
      	map.put("type", (type_==null || type_.toString().length()==0) ? null : type_);
      	this._params.add(map);

         template.addAggr("params.{name, type}", map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getParams() {
      	return this._params;
      }

      public preparedStatementST setSql(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._sql == null) {
            this._sql = value;
         	template.add("sql", value);
         }

      	return this;
      }

      public String getSql() {
      	return (String) this._sql;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class updateST implements MysqlGroupTemplate {

      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private Object _primaryColumn;
      private Object _table;

      private final ST template;

      private updateST(STGroup group) {
   		template = group.getInstanceOf("update");
   	}

      public updateST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public updateST setPrimaryColumn(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._primaryColumn == null) {
            this._primaryColumn = value;
         	template.add("primaryColumn", value);
         }

      	return this;
      }

      public String getPrimaryColumn() {
      	return (String) this._primaryColumn;
      }

      public updateST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class insertST implements MysqlGroupTemplate {

      private Object _table;
      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();

      private final ST template;

      private insertST(STGroup group) {
   		template = group.getInstanceOf("insert");
   	}

      public insertST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      public insertST addValuesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._values.add(value);
      	template.add("values", value);

         return this;
      }

      public java.util.Set<Object> getValuesValues() {
      	return this._values;
      }

      public insertST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableAddUniqueKeyST implements MysqlGroupTemplate {

      private Object _table;
      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private Object _indexType;
      private Object _name;

      private final ST template;

      private alterTableAddUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddUniqueKey");
   	}

      public alterTableAddUniqueKeyST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      public alterTableAddUniqueKeyST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public alterTableAddUniqueKeyST setIndexType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._indexType == null) {
            this._indexType = value;
         	template.add("indexType", value);
         }

      	return this;
      }

      public String getIndexType() {
      	return (String) this._indexType;
      }

      public alterTableAddUniqueKeyST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableUpdateIndexST implements MysqlGroupTemplate {

      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private Object _indexType;
      private Object _name;
      private Object _table;

      private final ST template;

      private alterTableUpdateIndexST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateIndex");
   	}

      public alterTableUpdateIndexST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public alterTableUpdateIndexST setIndexType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._indexType == null) {
            this._indexType = value;
         	template.add("indexType", value);
         }

      	return this;
      }

      public String getIndexType() {
      	return (String) this._indexType;
      }

      public alterTableUpdateIndexST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableUpdateIndexST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableUpdateUniqueKeyST implements MysqlGroupTemplate {

      private Object _name;
      private Object _table;
      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private Object _indexType;

      private final ST template;

      private alterTableUpdateUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateUniqueKey");
   	}

      public alterTableUpdateUniqueKeyST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableUpdateUniqueKeyST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      public alterTableUpdateUniqueKeyST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public alterTableUpdateUniqueKeyST setIndexType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._indexType == null) {
            this._indexType = value;
         	template.add("indexType", value);
         }

      	return this;
      }

      public String getIndexType() {
      	return (String) this._indexType;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class recreateDatabaseST implements MysqlGroupTemplate {

      private Object _name;
      private Object _script;

      private final ST template;

      private recreateDatabaseST(STGroup group) {
   		template = group.getInstanceOf("recreateDatabase");
   	}

      public recreateDatabaseST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public recreateDatabaseST setScript(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._script == null) {
            this._script = value;
         	template.add("script", value);
         }

      	return this;
      }

      public String getScript() {
      	return (String) this._script;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class alterTableAddIndexST implements MysqlGroupTemplate {

      private Object _name;
      private Object _table;
      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private Object _indexType;

      private final ST template;

      private alterTableAddIndexST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddIndex");
   	}

      public alterTableAddIndexST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public alterTableAddIndexST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      public alterTableAddIndexST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public alterTableAddIndexST setIndexType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._indexType == null) {
            this._indexType = value;
         	template.add("indexType", value);
         }

      	return this;
      }

      public String getIndexType() {
      	return (String) this._indexType;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class selectST implements MysqlGroupTemplate {

      private Object _table;
      private java.util.Set<Object> _columns = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _order = new java.util.LinkedHashSet<>();

      private final ST template;

      private selectST(STGroup group) {
   		template = group.getInstanceOf("select");
   	}

      public selectST setTable(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._table == null) {
            this._table = value;
         	template.add("table", value);
         }

      	return this;
      }

      public String getTable() {
      	return (String) this._table;
      }

      public selectST addColumnsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._columns.add(value);
      	template.add("columns", value);

         return this;
      }

      public java.util.Set<Object> getColumnsValues() {
      	return this._columns;
      }

      public selectST addOrderValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._order.add(value);
      	template.add("order", value);

         return this;
      }

      public java.util.Set<Object> getOrderValues() {
      	return this._order;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

	static boolean tryToSetListProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (value == null || value.toString().length() == 0) return true;
		alreadySet.set(true);
		template.add(name, value);
		return false;
	}

	private enum FormatCode {
	      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath
	   }

	   private final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

	      @Override
	      public String toString(Object o, String formatString, java.util.Locale locale) {

	         final String text = o.toString();

	         if (formatString == null) return text;

	         switch (FormatCode.valueOf(formatString)) {
	            case capitalize:
	               return capitalize(text);
	            case toUpper:
	               return toUpper(text);
	            case lowFirst:
	               return lowFirst(text);
	            case toLower:
	               return text.toLowerCase();
	            case humpToCap:
	               return humpToCap(text);
	            case camelHump:
	               return camelHump(text);
	            case splitCamelHump:
	               return splitCamelHump(text);
	            case singlify:
	               String s = toUpper(text).substring(0, 1) + text.substring(1);
	               if (s.toLowerCase().endsWith("ies")) return s.substring(0, s.length() - 3) + "y";
	               else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts")) return s.substring(0, s.length() - 1);
	               else if (s.toLowerCase().endsWith("ions") || s.toLowerCase().endsWith("mns"))
	                  return s.substring(0, s.length() - 1);
	               return s;
	            case packageToPath:
	               return packageToPath((text));
	            default:
	               return o.toString();
	         }
	      }

	      private String capitalize(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String lowFirst(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String toUpper(String text) {
	         return text.toUpperCase();
	      }

	      private String humpToCap(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (int i = 0; i < chars.length; i++) {
	            char aChar = chars[i];
	            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
	               out.append("_");
	            }
	            first = false;
	            out.append(Character.toUpperCase(aChar));
	         }
	         return out.toString();
	      }

	      private String camelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean capitalize = true;
	         for (char aChar : chars) {
	            if (Character.isWhitespace(aChar)) {
	               capitalize = true;
	               continue;
	            }
	            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
	            capitalize = false;
	         }
	         return out.toString();
	      }

	      private String splitCamelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (char aChar : chars) {
	            if (Character.isUpperCase(aChar)) out.append(" ");
	            out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
	            first = false;
	         }
	         return out.toString();
	      }

	      private String packageToPath(String packageName) {
	          return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + java.io.File.separator));
	      }
	   }

	public String list(String delimiter, Object... elements) {
		final StringBuilder list = new StringBuilder();
		boolean first = true;
		for (Object element : elements) {
			if (!first) list.append(delimiter);
			list.append(element);
			first = false;
		}
		return list.toString() + delimiter;
	}

	public static void toSTGFile(java.io.File dir) throws java.io.IOException {
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "MysqlGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("tableFooter(autoIncrement,rowFormat,avgRowLength,charset,comments,connection,engine,maxRows,minRows,packKeys) ::= <<~if(engine)~ ENGINE=~engine~~endif~~if(autoIncrement)~ AUTO_INCREMENT=~autoIncrement~~endif~~if(charset)~ COLLATE='~charset~'~endif~~if(connection)~ CONNECTION=~connection~~endif~~if(packKeys)~ PACK_KEYS=~packKeys~~endif~~if(rowFormat)~ ROW_FORMAT=~rowFormat~~endif~~if(avgRowLength)~ AVG_ROW_LENGTH=~avgRowLength~~endif~~if(minRows)~ MIN_ROWS=~minRows~~endif~~if(maxRows)~ MAX_ROWS=~maxRows~~endif~~if(comments)~ COMMENT='~comments~'~endif~>>\n")
			.append("alterTableAddForeignKeyConstraint(column,name,onDelete,onUpdate,refColumn,refTable,table) ::= <<ALTER TABLE `~table~` ADD CONSTRAINT `~name~` FOREIGN KEY (`~column~`) REFERENCES `~refTable~` (`~refColumn~`) ON DELETE ~if(onDelete)~~onDelete~~else~RESTRICT~endif~ ON UPDATE ~if(onUpdate)~~onUpdate~~else~RESTRICT~endif~;>>\n")
			.append("alterTableAddColumn(before,column,table) ::= <<ALTER TABLE `~table~` ADD COLUMN ~column~~if(before)~ BEFORE ~before~~endif~;>>\n")
			.append("createColumn(autoIncrement,comment,defaultValue,name,nullable,onUpdate,type) ::= <<`~name~` ~type~~if(nullable)~~else~ NOT NULL~endif~~if(autoIncrement)~ auto_increment~endif~~if(defaultValue)~ default ~defaultValue~~endif~~if(onUpdate)~ on update ~onUpdate~~endif~~if(comment)~ COMMENT '~comment~'~endif~>>\n")
			.append("createDatabase(name,script) ::= <<create database ~name~;\n" + 
		"use ~name~;\n" + 
		"~script~>>\n")
			.append("createForeignConstraints(column,name,onDelete,onUpdate,refColumn,refTable) ::= <<CONSTRAINT ~if(name)~`~name~`~endif~ FOREIGN KEY (`~column~`) REFERENCES `~refTable~` (`~refColumn~`) ON DELETE ~if(onDelete)~~onDelete~~else~RESTRICT~endif~ ON UPDATE ~if(onUpdate)~~onUpdate~~else~RESTRICT~endif~>>\n")
			.append("createKey(key_,indexType,name) ::= <<KEY ~if(name)~`~name~` ~endif~~if(indexType)~USING ~indexType~ ~endif~(~key_:{it|`~it~`}; separator=\",\"~)>>\n")
			.append("createPrimaryKey(name,primaries) ::= <<PRIMARY KEY ~if(name)~`~name~`~endif~ (~primaries:{it|`~it~`}; separator=\",\"~)>>\n")
			.append("alterTableDropColumn(column,table) ::= <<ALTER TABLE `~table~` DROP COLUMN `~column~`;>>\n")
			.append("alterTableDropForeignKeyConstraint(name,table) ::= <<ALTER TABLE `~table~` DROP FOREIGN KEY `~name~`;>>\n")
			.append("alterTableDropIndex(name,table) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`;>>\n")
			.append("alterTableDropUniqueKey(name,table) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`;>>\n")
			.append("alterTableModifyColumn(autoIncrement,column,comment,defaultValue,nullable,onUpdate,table,type) ::= <<ALTER TABLE `~table~` MODIFY COLUMN `~column~` ~type~~if(nullable)~~else~ NOT NULL~endif~~if(autoIncrement)~ auto_increment~endif~~if(defaultValue)~ default ~defaultValue~~endif~~if(onUpdate)~ on update ~onUpdate~~endif~~if(comment)~ COMMENT '~comment~'~endif~;>>\n")
			.append("alterTableUpdateForeignKeyConstraint(refTable,column,name,onDelete,onUpdate,refColumn,table) ::= <<ALTER TABLE `~table~` DROP FOREIGN KEY `~name~`, ADD CONSTRAINT `~name~` FOREIGN KEY (`~column~`) REFERENCES `~refTable~` (`~refColumn~`) ON DELETE ~if(onDelete)~~onDelete~~else~RESTRICT~endif~ ON UPDATE ~if(onUpdate)~~onUpdate~~else~RESTRICT~endif~;>>\n")
			.append("join(tables,columns,joins,order) ::= <<SELECT ~columns:{it|~it~};separator=\", \"~\n" + 
		"FROM ~tables:{it|~it~};separator=\", \"~~if(joins)~\n" + 
		"\n" + 
		"WHERE ~joins:{it|~it.source~=~it.fk~};separator=\" AND \"~~endif~~if(order)~\n" + 
		"ORDER BY ~order:{it|~it~};separator=\",\"~~endif~;>>\n")
			.append("createTable(columns,footer,keys,name) ::= <<CREATE TABLE `~name~` (~if(columns)~\n" + 
		"~columns:{it| ~it~};separator=\",\\n\"~~if(keys)~,~endif~~endif~~if(keys)~\n" + 
		"~keys:{it|~it~};separator=\",\\n\"~~endif~)~if(footer)~\n" + 
		"~footer~~endif~;>>\n")
			.append("createUniqueKey(indexType,key_,name) ::= <<UNIQUE KEY ~if(name)~`~name~` ~endif~~if(indexType)~USING ~indexType~ ~endif~(~key_:{it|`~it~`}; separator=\",\"~)>>\n")
			.append("disableKeys() ::= <</*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;\n" + 
		"/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;\n" + 
		"/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;\n" + 
		"/*!40101 SET NAMES utf8 */;\n" + 
		"/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;\n" + 
		"/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;\n" + 
		"/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;\n" + 
		"/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;>>\n")
			.append("dropTable(table) ::= <<DROP TABLE `~table~`;>>\n")
			.append("enableKeys() ::= <</*!40101 SET SQL_MODE=@OLD_SQL_MODE */;\n" + 
		"/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;\n" + 
		"/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;\n" + 
		"/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;\n" + 
		"/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;\n" + 
		"/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;\n" + 
		"/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;>>\n")
			.append("preparedStatement(params,sql) ::= <<final PreparedStatement stmt = connection.prepareStatement(\"~sql~\");\n" + 
		"~params:{it|set~it.type~(stmt, ~i~, siteWeather.get~it.name;format=\"capitalize\"~());};separator=\"\\n\"~>>\n")
			.append("update(columns,primaryColumn,table) ::= <<UPDATE ~table~ SET ~columns:{it|~it~ = ?};separator=\", \"~ WHERE ~primaryColumn~=?;>>\n")
			.append("insert(table,values,columns) ::= <<INSERT INTO TABLE ~table~ (~columns:{it|~it~};separator=\",\"~) VALUES (~values:{it|~it~};separator=\",\"~);>>\n")
			.append("alterTableAddUniqueKey(table,columns,indexType,name) ::= <<ALTER TABLE `~table~` ADD UNIQUE INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~);>>\n")
			.append("alterTableUpdateIndex(columns,indexType,name,table) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`, ADD INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~);>>\n")
			.append("alterTableUpdateUniqueKey(name,table,columns,indexType) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`, ADD UNIQUE INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~);>>\n")
			.append("recreateDatabase(name,script) ::= <<drop database if exists ~name~;\n" + 
		"~createDatabase(name=name,script=script)~>>\n")
			.append("alterTableAddIndex(name,table,columns,indexType) ::= <<ALTER TABLE `~table~` ADD INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~);>>\n")
			.append("select(table,columns,order) ::= <<SELECT ~columns:{it|~it~};separator=\", \"~ FROM ~table~~if(order)~ ORDER BY ~order:{it|~it~};separator=\",\"~~endif~;>>\n")
		.toString();
}