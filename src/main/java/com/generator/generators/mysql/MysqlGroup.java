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

      private final AtomicBoolean autoIncrementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rowFormatIsSet = new AtomicBoolean(false);
      private final AtomicBoolean avgRowLengthIsSet = new AtomicBoolean(false);
      private final AtomicBoolean charsetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean connectionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean engineIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxRowsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minRowsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packKeysIsSet = new AtomicBoolean(false);
      private final ST template;

      private tableFooterST(STGroup group) {
   		template = group.getInstanceOf("tableFooter");
   	}

      public tableFooterST setAutoIncrement(Object value) {
      	tryToSetStringProperty(template, value, autoIncrementIsSet, "autoIncrement");   
         return this;
      } 
      public tableFooterST setRowFormat(Object value) {
      	tryToSetStringProperty(template, value, rowFormatIsSet, "rowFormat");   
         return this;
      } 
      public tableFooterST setAvgRowLength(Object value) {
      	tryToSetStringProperty(template, value, avgRowLengthIsSet, "avgRowLength");   
         return this;
      } 
      public tableFooterST setCharset(Object value) {
      	tryToSetStringProperty(template, value, charsetIsSet, "charset");   
         return this;
      } 
      public tableFooterST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
      public tableFooterST setConnection(Object value) {
      	tryToSetStringProperty(template, value, connectionIsSet, "connection");   
         return this;
      } 
      public tableFooterST setEngine(Object value) {
      	tryToSetStringProperty(template, value, engineIsSet, "engine");   
         return this;
      } 
      public tableFooterST setMaxRows(Object value) {
      	tryToSetStringProperty(template, value, maxRowsIsSet, "maxRows");   
         return this;
      } 
      public tableFooterST setMinRows(Object value) {
      	tryToSetStringProperty(template, value, minRowsIsSet, "minRows");   
         return this;
      } 
      public tableFooterST setPackKeys(Object value) {
      	tryToSetStringProperty(template, value, packKeysIsSet, "packKeys");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableAddForeignKeyConstraintST implements MysqlGroupTemplate {

      private final AtomicBoolean columnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onDeleteIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onUpdateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean refColumnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean refTableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableAddForeignKeyConstraintST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddForeignKeyConstraint");
   	}

      public alterTableAddForeignKeyConstraintST setColumn(Object value) {
      	tryToSetStringProperty(template, value, columnIsSet, "column");   
         return this;
      } 
      public alterTableAddForeignKeyConstraintST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableAddForeignKeyConstraintST setOnDelete(Object value) {
      	tryToSetStringProperty(template, value, onDeleteIsSet, "onDelete");   
         return this;
      } 
      public alterTableAddForeignKeyConstraintST setOnUpdate(Object value) {
      	tryToSetStringProperty(template, value, onUpdateIsSet, "onUpdate");   
         return this;
      } 
      public alterTableAddForeignKeyConstraintST setRefColumn(Object value) {
      	tryToSetStringProperty(template, value, refColumnIsSet, "refColumn");   
         return this;
      } 
      public alterTableAddForeignKeyConstraintST setRefTable(Object value) {
      	tryToSetStringProperty(template, value, refTableIsSet, "refTable");   
         return this;
      } 
      public alterTableAddForeignKeyConstraintST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableAddColumnST implements MysqlGroupTemplate {

      private final AtomicBoolean beforeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableAddColumnST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddColumn");
   	}

      public alterTableAddColumnST setBefore(Object value) {
      	tryToSetStringProperty(template, value, beforeIsSet, "before");   
         return this;
      } 
      public alterTableAddColumnST setColumn(Object value) {
      	tryToSetStringProperty(template, value, columnIsSet, "column");   
         return this;
      } 
      public alterTableAddColumnST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createColumnST implements MysqlGroupTemplate {

      private final AtomicBoolean autoIncrementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nullableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onUpdateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private createColumnST(STGroup group) {
   		template = group.getInstanceOf("createColumn");
   	}

      public createColumnST setAutoIncrement(Object value) {
      	tryToSetStringProperty(template, value, autoIncrementIsSet, "autoIncrement");   
         return this;
      } 
      public createColumnST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 
      public createColumnST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
      public createColumnST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public createColumnST setNullable(Object value) {
      	tryToSetStringProperty(template, value, nullableIsSet, "nullable");   
         return this;
      } 
      public createColumnST setOnUpdate(Object value) {
      	tryToSetStringProperty(template, value, onUpdateIsSet, "onUpdate");   
         return this;
      } 
      public createColumnST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createDatabaseST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scriptIsSet = new AtomicBoolean(false);
      private final ST template;

      private createDatabaseST(STGroup group) {
   		template = group.getInstanceOf("createDatabase");
   	}

      public createDatabaseST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public createDatabaseST setScript(Object value) {
      	tryToSetStringProperty(template, value, scriptIsSet, "script");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createForeignConstraintsST implements MysqlGroupTemplate {

      private final AtomicBoolean columnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onDeleteIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onUpdateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean refColumnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean refTableIsSet = new AtomicBoolean(false);
      private final ST template;

      private createForeignConstraintsST(STGroup group) {
   		template = group.getInstanceOf("createForeignConstraints");
   	}

      public createForeignConstraintsST setColumn(Object value) {
      	tryToSetStringProperty(template, value, columnIsSet, "column");   
         return this;
      } 
      public createForeignConstraintsST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public createForeignConstraintsST setOnDelete(Object value) {
      	tryToSetStringProperty(template, value, onDeleteIsSet, "onDelete");   
         return this;
      } 
      public createForeignConstraintsST setOnUpdate(Object value) {
      	tryToSetStringProperty(template, value, onUpdateIsSet, "onUpdate");   
         return this;
      } 
      public createForeignConstraintsST setRefColumn(Object value) {
      	tryToSetStringProperty(template, value, refColumnIsSet, "refColumn");   
         return this;
      } 
      public createForeignConstraintsST setRefTable(Object value) {
      	tryToSetStringProperty(template, value, refTableIsSet, "refTable");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createKeyST implements MysqlGroupTemplate {

      private final AtomicBoolean key_IsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private createKeyST(STGroup group) {
   		template = group.getInstanceOf("createKey");
   	}

      public createKeyST addKey_Value(Object value) {
      	tryToSetListProperty(template, value, key_IsSet, "key_");
         return this;
      } 
      public createKeyST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 
      public createKeyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createPrimaryKeyST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean primariesIsSet = new AtomicBoolean(false);
      private final ST template;

      private createPrimaryKeyST(STGroup group) {
   		template = group.getInstanceOf("createPrimaryKey");
   	}

      public createPrimaryKeyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public createPrimaryKeyST addPrimariesValue(Object value) {
      	tryToSetListProperty(template, value, primariesIsSet, "primaries");
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableDropColumnST implements MysqlGroupTemplate {

      private final AtomicBoolean columnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableDropColumnST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropColumn");
   	}

      public alterTableDropColumnST setColumn(Object value) {
      	tryToSetStringProperty(template, value, columnIsSet, "column");   
         return this;
      } 
      public alterTableDropColumnST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableDropForeignKeyConstraintST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableDropForeignKeyConstraintST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropForeignKeyConstraint");
   	}

      public alterTableDropForeignKeyConstraintST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableDropForeignKeyConstraintST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableDropIndexST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableDropIndexST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropIndex");
   	}

      public alterTableDropIndexST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableDropIndexST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableDropUniqueKeyST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableDropUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableDropUniqueKey");
   	}

      public alterTableDropUniqueKeyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableDropUniqueKeyST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableModifyColumnST implements MysqlGroupTemplate {

      private final AtomicBoolean autoIncrementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nullableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onUpdateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableModifyColumnST(STGroup group) {
   		template = group.getInstanceOf("alterTableModifyColumn");
   	}

      public alterTableModifyColumnST setAutoIncrement(Object value) {
      	tryToSetStringProperty(template, value, autoIncrementIsSet, "autoIncrement");   
         return this;
      } 
      public alterTableModifyColumnST setColumn(Object value) {
      	tryToSetStringProperty(template, value, columnIsSet, "column");   
         return this;
      } 
      public alterTableModifyColumnST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 
      public alterTableModifyColumnST setDefaultValue(Object value) {
      	tryToSetStringProperty(template, value, defaultValueIsSet, "defaultValue");   
         return this;
      } 
      public alterTableModifyColumnST setNullable(Object value) {
      	tryToSetStringProperty(template, value, nullableIsSet, "nullable");   
         return this;
      } 
      public alterTableModifyColumnST setOnUpdate(Object value) {
      	tryToSetStringProperty(template, value, onUpdateIsSet, "onUpdate");   
         return this;
      } 
      public alterTableModifyColumnST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 
      public alterTableModifyColumnST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableUpdateForeignKeyConstraintST implements MysqlGroupTemplate {

      private final AtomicBoolean refTableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onDeleteIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onUpdateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean refColumnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableUpdateForeignKeyConstraintST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateForeignKeyConstraint");
   	}

      public alterTableUpdateForeignKeyConstraintST setRefTable(Object value) {
      	tryToSetStringProperty(template, value, refTableIsSet, "refTable");   
         return this;
      } 
      public alterTableUpdateForeignKeyConstraintST setColumn(Object value) {
      	tryToSetStringProperty(template, value, columnIsSet, "column");   
         return this;
      } 
      public alterTableUpdateForeignKeyConstraintST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableUpdateForeignKeyConstraintST setOnDelete(Object value) {
      	tryToSetStringProperty(template, value, onDeleteIsSet, "onDelete");   
         return this;
      } 
      public alterTableUpdateForeignKeyConstraintST setOnUpdate(Object value) {
      	tryToSetStringProperty(template, value, onUpdateIsSet, "onUpdate");   
         return this;
      } 
      public alterTableUpdateForeignKeyConstraintST setRefColumn(Object value) {
      	tryToSetStringProperty(template, value, refColumnIsSet, "refColumn");   
         return this;
      } 
      public alterTableUpdateForeignKeyConstraintST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class joinST implements MysqlGroupTemplate {

      private final AtomicBoolean tablesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean joinsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean orderIsSet = new AtomicBoolean(false);
      private final ST template;

      private joinST(STGroup group) {
   		template = group.getInstanceOf("join");
   	}

      public joinST addTablesValue(Object value) {
      	tryToSetListProperty(template, value, tablesIsSet, "tables");
         return this;
      } 
      public joinST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public joinST addJoinsValue(Object fk_, Object source_) {
         joinsIsSet.set(true);
         template.addAggr("joins.{fk, source}", ( (fk_==null || fk_.toString().length()==0) ? null : fk_), ( (source_==null || source_.toString().length()==0) ? null : source_));
         return this;
      } 
      public joinST addOrderValue(Object value) {
      	tryToSetListProperty(template, value, orderIsSet, "order");
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createTableST implements MysqlGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean footerIsSet = new AtomicBoolean(false);
      private final AtomicBoolean keysIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private createTableST(STGroup group) {
   		template = group.getInstanceOf("createTable");
   	}

      public createTableST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public createTableST setFooter(Object value) {
      	tryToSetStringProperty(template, value, footerIsSet, "footer");   
         return this;
      } 
      public createTableST addKeysValue(Object value) {
      	tryToSetListProperty(template, value, keysIsSet, "keys");
         return this;
      } 
      public createTableST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createUniqueKeyST implements MysqlGroupTemplate {

      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean key_IsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private createUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("createUniqueKey");
   	}

      public createUniqueKeyST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 
      public createUniqueKeyST addKey_Value(Object value) {
      	tryToSetListProperty(template, value, key_IsSet, "key_");
         return this;
      } 
      public createUniqueKeyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
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

      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private dropTableST(STGroup group) {
   		template = group.getInstanceOf("dropTable");
   	}

      public dropTableST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
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

      private final AtomicBoolean paramsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean sqlIsSet = new AtomicBoolean(false);
      private final ST template;

      private preparedStatementST(STGroup group) {
   		template = group.getInstanceOf("preparedStatement");
   	}

      public preparedStatementST addParamsValue(Object name_, Object type_) {
         paramsIsSet.set(true);
         template.addAggr("params.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      } 
      public preparedStatementST setSql(Object value) {
      	tryToSetStringProperty(template, value, sqlIsSet, "sql");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class updateST implements MysqlGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean primaryColumnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private updateST(STGroup group) {
   		template = group.getInstanceOf("update");
   	}

      public updateST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public updateST setPrimaryColumn(Object value) {
      	tryToSetStringProperty(template, value, primaryColumnIsSet, "primaryColumn");   
         return this;
      } 
      public updateST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class insertST implements MysqlGroupTemplate {

      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final ST template;

      private insertST(STGroup group) {
   		template = group.getInstanceOf("insert");
   	}

      public insertST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 
      public insertST addValuesValue(Object value) {
      	tryToSetListProperty(template, value, valuesIsSet, "values");
         return this;
      } 
      public insertST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableAddUniqueKeyST implements MysqlGroupTemplate {

      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableAddUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddUniqueKey");
   	}

      public alterTableAddUniqueKeyST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 
      public alterTableAddUniqueKeyST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public alterTableAddUniqueKeyST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 
      public alterTableAddUniqueKeyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableUpdateIndexST implements MysqlGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableUpdateIndexST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateIndex");
   	}

      public alterTableUpdateIndexST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public alterTableUpdateIndexST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 
      public alterTableUpdateIndexST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableUpdateIndexST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableUpdateUniqueKeyST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableUpdateUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateUniqueKey");
   	}

      public alterTableUpdateUniqueKeyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableUpdateUniqueKeyST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 
      public alterTableUpdateUniqueKeyST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public alterTableUpdateUniqueKeyST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class recreateDatabaseST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scriptIsSet = new AtomicBoolean(false);
      private final ST template;

      private recreateDatabaseST(STGroup group) {
   		template = group.getInstanceOf("recreateDatabase");
   	}

      public recreateDatabaseST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public recreateDatabaseST setScript(Object value) {
      	tryToSetStringProperty(template, value, scriptIsSet, "script");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableAddIndexST implements MysqlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableAddIndexST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddIndex");
   	}

      public alterTableAddIndexST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public alterTableAddIndexST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 
      public alterTableAddIndexST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public alterTableAddIndexST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class selectST implements MysqlGroupTemplate {

      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean orderIsSet = new AtomicBoolean(false);
      private final ST template;

      private selectST(STGroup group) {
   		template = group.getInstanceOf("select");
   	}

      public selectST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 
      public selectST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      } 
      public selectST addOrderValue(Object value) {
      	tryToSetListProperty(template, value, orderIsSet, "order");
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

	static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (alreadySet.get()) return;
		if (value == null || value.toString().length() == 0) return;
		alreadySet.set(true);
		template.add(name, value);
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

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
		.append("tableFooter(autoIncrement,rowFormat,avgRowLength,charset,comments,connection,engine,maxRows,minRows,packKeys) ::= <<~if(engine)~ ENGINE=~engine~~endif~~if(autoIncrement)~ AUTO_INCREMENT=~autoIncrement~~endif~~if(charset)~ COLLATE='~charset~'~endif~~if(connection)~ CONNECTION=~connection~~endif~~if(packKeys)~ PACK_KEYS=~packKeys~~endif~~if(rowFormat)~ ROW_FORMAT=~rowFormat~~endif~~if(avgRowLength)~ AVG_ROW_LENGTH=~avgRowLength~~endif~~if(minRows)~ MIN_ROWS=~minRows~~endif~~if(maxRows)~ MAX_ROWS=~maxRows~~endif~~if(comments)~ COMMENT='~comments~'~endif~ >>\n")
		.append("alterTableAddForeignKeyConstraint(column,name,onDelete,onUpdate,refColumn,refTable,table) ::= <<ALTER TABLE `~table~` ADD CONSTRAINT `~name~` FOREIGN KEY (`~column~`) REFERENCES `~refTable~` (`~refColumn~`) ON DELETE ~if(onDelete)~~onDelete~~else~RESTRICT~endif~ ON UPDATE ~if(onUpdate)~~onUpdate~~else~RESTRICT~endif~; >>\n")
		.append("alterTableAddColumn(before,column,table) ::= <<ALTER TABLE `~table~` ADD COLUMN ~column~~if(before)~ BEFORE ~before~~endif~; >>\n")
		.append("createColumn(autoIncrement,comment,defaultValue,name,nullable,onUpdate,type) ::= <<`~name~` ~type~~if(nullable)~~else~ NOT NULL~endif~~if(autoIncrement)~ auto_increment~endif~~if(defaultValue)~ default ~defaultValue~~endif~~if(onUpdate)~ on update ~onUpdate~~endif~~if(comment)~ COMMENT '~comment~'~endif~ >>\n")
		.append("createDatabase(name,script) ::= <<create database ~name~;\n" + 
	"use ~name~;\n" + 
	"~script~ >>\n")
		.append("createForeignConstraints(column,name,onDelete,onUpdate,refColumn,refTable) ::= <<CONSTRAINT ~if(name)~`~name~`~endif~ FOREIGN KEY (`~column~`) REFERENCES `~refTable~` (`~refColumn~`) ON DELETE ~if(onDelete)~~onDelete~~else~RESTRICT~endif~ ON UPDATE ~if(onUpdate)~~onUpdate~~else~RESTRICT~endif~ >>\n")
		.append("createKey(key_,indexType,name) ::= <<KEY ~if(name)~`~name~` ~endif~~if(indexType)~USING ~indexType~ ~endif~(~key_:{it|`~it~`}; separator=\",\"~) >>\n")
		.append("createPrimaryKey(name,primaries) ::= <<PRIMARY KEY ~if(name)~`~name~`~endif~ (~primaries:{it|`~it~`}; separator=\",\"~) >>\n")
		.append("alterTableDropColumn(column,table) ::= <<ALTER TABLE `~table~` DROP COLUMN `~column~`; >>\n")
		.append("alterTableDropForeignKeyConstraint(name,table) ::= <<ALTER TABLE `~table~` DROP FOREIGN KEY `~name~`; >>\n")
		.append("alterTableDropIndex(name,table) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`; >>\n")
		.append("alterTableDropUniqueKey(name,table) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`; >>\n")
		.append("alterTableModifyColumn(autoIncrement,column,comment,defaultValue,nullable,onUpdate,table,type) ::= <<ALTER TABLE `~table~` MODIFY COLUMN `~column~` ~type~~if(nullable)~~else~ NOT NULL~endif~~if(autoIncrement)~ auto_increment~endif~~if(defaultValue)~ default ~defaultValue~~endif~~if(onUpdate)~ on update ~onUpdate~~endif~~if(comment)~ COMMENT '~comment~'~endif~; >>\n")
		.append("alterTableUpdateForeignKeyConstraint(refTable,column,name,onDelete,onUpdate,refColumn,table) ::= <<ALTER TABLE `~table~` DROP FOREIGN KEY `~name~`, ADD CONSTRAINT `~name~` FOREIGN KEY (`~column~`) REFERENCES `~refTable~` (`~refColumn~`) ON DELETE ~if(onDelete)~~onDelete~~else~RESTRICT~endif~ ON UPDATE ~if(onUpdate)~~onUpdate~~else~RESTRICT~endif~; >>\n")
		.append("join(tables,columns,joins,order) ::= <<SELECT ~columns:{it|~it~};separator=\", \"~\n" + 
	"FROM ~tables:{it|~it~};separator=\", \"~~if(joins)~\n" + 
	"\n" + 
	"WHERE ~joins:{it|~it.source~=~it.fk~};separator=\" AND \"~~endif~~if(order)~\n" + 
	"ORDER BY ~order:{it|~it~};separator=\",\"~~endif~; >>\n")
		.append("createTable(columns,footer,keys,name) ::= <<CREATE TABLE `~name~` (~if(columns)~\n" + 
	"~columns:{it| ~it~};separator=\",\\n\"~~if(keys)~,~endif~~endif~~if(keys)~\n" + 
	"~keys:{it|~it~};separator=\",\\n\"~~endif~)~if(footer)~\n" + 
	"~footer~~endif~; >>\n")
		.append("createUniqueKey(indexType,key_,name) ::= <<UNIQUE KEY ~if(name)~`~name~` ~endif~~if(indexType)~USING ~indexType~ ~endif~(~key_:{it|`~it~`}; separator=\",\"~) >>\n")
		.append("disableKeys() ::= <</*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;\n" + 
	"/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;\n" + 
	"/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;\n" + 
	"/*!40101 SET NAMES utf8 */;\n" + 
	"/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;\n" + 
	"/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;\n" + 
	"/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;\n" + 
	"/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */; >>\n")
		.append("dropTable(table) ::= <<DROP TABLE `~table~`; >>\n")
		.append("enableKeys() ::= <</*!40101 SET SQL_MODE=@OLD_SQL_MODE */;\n" + 
	"/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;\n" + 
	"/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;\n" + 
	"/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;\n" + 
	"/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;\n" + 
	"/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;\n" + 
	"/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */; >>\n")
		.append("preparedStatement(params,sql) ::= <<final PreparedStatement stmt = connection.prepareStatement(\"~sql~\");\n" + 
	"~params:{it|set~it.type~(stmt, ~i~, siteWeather.get~it.name;format=\"capitalize\"~());};separator=\"\\n\"~ >>\n")
		.append("update(columns,primaryColumn,table) ::= <<UPDATE ~table~ SET ~columns:{it|~it~ = ?};separator=\", \"~ WHERE ~primaryColumn~=?; >>\n")
		.append("insert(table,values,columns) ::= <<INSERT INTO TABLE ~table~ (~columns:{it|~it~};separator=\",\"~) VALUES (~values:{it|~it~};separator=\",\"~); >>\n")
		.append("alterTableAddUniqueKey(table,columns,indexType,name) ::= <<ALTER TABLE `~table~` ADD UNIQUE INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~); >>\n")
		.append("alterTableUpdateIndex(columns,indexType,name,table) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`, ADD INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~); >>\n")
		.append("alterTableUpdateUniqueKey(name,table,columns,indexType) ::= <<ALTER TABLE `~table~` DROP INDEX `~name~`, ADD UNIQUE INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~); >>\n")
		.append("recreateDatabase(name,script) ::= <<drop database if exists ~name~;\n" + 
	"~createDatabase(name=name,script=script)~ >>\n")
		.append("alterTableAddIndex(name,table,columns,indexType) ::= <<ALTER TABLE `~table~` ADD INDEX `~name~` ~if(indexType)~USING ~indexType~ ~endif~(~columns:{it|`~it~`}; separator=\", \"~); >>\n")
		.append("select(table,columns,order) ::= <<SELECT ~columns:{it|~it~};separator=\", \"~ FROM ~table~~if(order)~ ORDER BY ~order:{it|~it~};separator=\",\"~~endif~; >>\n").toString();
} 