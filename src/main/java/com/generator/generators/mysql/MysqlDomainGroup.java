package com.generator.generators.mysql;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'mysql.stg' file<br/>
 */
public final class MysqlDomainGroup {
   // old mysql
   private final STGroup stGroup;
   private final char delimiter;

	public MysqlDomainGroup() {
		final String generatorPath = System.getProperty("generator.path");

        if (generatorPath != null) {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "mysql" + java.io.File.separator + "mysql.stg");
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        } else {
        	this.stGroup = new org.stringtemplate.v4.STGroupFile(MysqlDomainGroup.class.getResource("/com/generator/generators/mysql/mysql.stg"), "UTF-8", '~', '~');
        	this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
        	this.delimiter = stGroup.delimiterStartChar;
        }
   }

   public MysqlDomainGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public MysqlDomainGroup(java.io.File templateFile) {
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

	public interface MysqlDomainGroupTemplate {

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


   public createDatabaseST newcreateDatabase() {
      return new createDatabaseST(stGroup);
   } 


   public createForeignConstraintsST newcreateForeignConstraints() {
      return new createForeignConstraintsST(stGroup);
   } 


   public createKeyST newcreateKey() {
      return new createKeyST(stGroup);
   } 


   public eomST neweom() {
      return new eomST(stGroup);
   } 


   public gtST newgt() {
      return new gtST(stGroup);
   } 


   public alterTableAddColumnST newalterTableAddColumn() {
      return new alterTableAddColumnST(stGroup);
   } 


   public alterTableAddForeignKeyConstraintST newalterTableAddForeignKeyConstraint() {
      return new alterTableAddForeignKeyConstraintST(stGroup);
   } 


   public alterTableAddIndexST newalterTableAddIndex() {
      return new alterTableAddIndexST(stGroup);
   } 


   public alterTableUpdateIndexST newalterTableUpdateIndex() {
      return new alterTableUpdateIndexST(stGroup);
   } 


   public alterTableUpdateUniqueKeyST newalterTableUpdateUniqueKey() {
      return new alterTableUpdateUniqueKeyST(stGroup);
   } 


   public createColumnST newcreateColumn() {
      return new createColumnST(stGroup);
   } 


   public alterTableAddUniqueKeyST newalterTableAddUniqueKey() {
      return new alterTableAddUniqueKeyST(stGroup);
   } 


   public createPrimaryKeyST newcreatePrimaryKey() {
      return new createPrimaryKeyST(stGroup);
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


   public insertST newinsert() {
      return new insertST(stGroup);
   } 


   public joinST newjoin() {
      return new joinST(stGroup);
   } 


   public preparedStatementST newpreparedStatement() {
      return new preparedStatementST(stGroup);
   } 


   public recreateDatabaseST newrecreateDatabase() {
      return new recreateDatabaseST(stGroup);
   } 


   public selectST newselect() {
      return new selectST(stGroup);
   } 


   public tableFooterST newtableFooter() {
      return new tableFooterST(stGroup);
   } 


   public updateST newupdate() {
      return new updateST(stGroup);
   } 

   public final class alterTableDropColumnST implements MysqlDomainGroupTemplate {

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

   public final class alterTableDropForeignKeyConstraintST implements MysqlDomainGroupTemplate {

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

   public final class alterTableDropIndexST implements MysqlDomainGroupTemplate {

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

   public final class alterTableDropUniqueKeyST implements MysqlDomainGroupTemplate {

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

   public final class alterTableModifyColumnST implements MysqlDomainGroupTemplate {

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

   public final class alterTableUpdateForeignKeyConstraintST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean columnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onDeleteIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onUpdateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean refColumnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean refTableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableUpdateForeignKeyConstraintST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateForeignKeyConstraint");
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
       public alterTableUpdateForeignKeyConstraintST setRefTable(Object value) {
      	tryToSetStringProperty(template, value, refTableIsSet, "refTable");   
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

   public final class createDatabaseST implements MysqlDomainGroupTemplate {

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

   public final class createForeignConstraintsST implements MysqlDomainGroupTemplate {

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

   public final class createKeyST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean key_IsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private createKeyST(STGroup group) {
   		template = group.getInstanceOf("createKey");
   	}

       public createKeyST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 
      public createKeyST addKey_Value(Object value) {
      	tryToSetListProperty(template, value, key_IsSet, "key_");
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

   public final class eomST implements MysqlDomainGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class gtST implements MysqlDomainGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableAddColumnST implements MysqlDomainGroupTemplate {

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

   public final class alterTableAddForeignKeyConstraintST implements MysqlDomainGroupTemplate {

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

   public final class alterTableAddIndexST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableAddIndexST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddIndex");
   	}

      public alterTableAddIndexST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      }
       public alterTableAddIndexST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 
       public alterTableAddIndexST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public alterTableAddIndexST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableUpdateIndexST implements MysqlDomainGroupTemplate {

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

   public final class alterTableUpdateUniqueKeyST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableUpdateUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableUpdateUniqueKey");
   	}

      public alterTableUpdateUniqueKeyST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      }
       public alterTableUpdateUniqueKeyST setIndexType(Object value) {
      	tryToSetStringProperty(template, value, indexTypeIsSet, "indexType");   
         return this;
      } 
       public alterTableUpdateUniqueKeyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public alterTableUpdateUniqueKeyST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createColumnST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean autoIncrementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean defaultValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nullableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean onUpdateIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentIsSet = new AtomicBoolean(false);
      private final ST template;

      private createColumnST(STGroup group) {
   		template = group.getInstanceOf("createColumn");
   	}

       public createColumnST setAutoIncrement(Object value) {
      	tryToSetStringProperty(template, value, autoIncrementIsSet, "autoIncrement");   
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
       public createColumnST setComment(Object value) {
      	tryToSetStringProperty(template, value, commentIsSet, "comment");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class alterTableAddUniqueKeyST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean indexTypeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final ST template;

      private alterTableAddUniqueKeyST(STGroup group) {
   		template = group.getInstanceOf("alterTableAddUniqueKey");
   	}

       public alterTableAddUniqueKeyST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
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
      public alterTableAddUniqueKeyST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class createPrimaryKeyST implements MysqlDomainGroupTemplate {

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

   public final class createTableST implements MysqlDomainGroupTemplate {

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

   public final class createUniqueKeyST implements MysqlDomainGroupTemplate {

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

   public final class disableKeysST implements MysqlDomainGroupTemplate {

      private final ST template;

      private disableKeysST(STGroup group) {
   		template = group.getInstanceOf("disableKeys");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class dropTableST implements MysqlDomainGroupTemplate {

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

   public final class enableKeysST implements MysqlDomainGroupTemplate {

      private final ST template;

      private enableKeysST(STGroup group) {
   		template = group.getInstanceOf("enableKeys");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class insertST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private insertST(STGroup group) {
   		template = group.getInstanceOf("insert");
   	}

      public insertST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      }
       public insertST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 
      public insertST addValuesValue(Object value) {
      	tryToSetListProperty(template, value, valuesIsSet, "values");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class joinST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean joinsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean orderIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tablesIsSet = new AtomicBoolean(false);
      private final ST template;

      private joinST(STGroup group) {
   		template = group.getInstanceOf("join");
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
      public joinST addTablesValue(Object value) {
      	tryToSetListProperty(template, value, tablesIsSet, "tables");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class preparedStatementST implements MysqlDomainGroupTemplate {

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

   public final class recreateDatabaseST implements MysqlDomainGroupTemplate {

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

   public final class selectST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean columnsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean orderIsSet = new AtomicBoolean(false);
      private final AtomicBoolean tableIsSet = new AtomicBoolean(false);
      private final ST template;

      private selectST(STGroup group) {
   		template = group.getInstanceOf("select");
   	}

      public selectST addColumnsValue(Object value) {
      	tryToSetListProperty(template, value, columnsIsSet, "columns");
         return this;
      }
      public selectST addOrderValue(Object value) {
      	tryToSetListProperty(template, value, orderIsSet, "order");
         return this;
      }
       public selectST setTable(Object value) {
      	tryToSetStringProperty(template, value, tableIsSet, "table");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class tableFooterST implements MysqlDomainGroupTemplate {

      private final AtomicBoolean autoIncrementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean avgRowLengthIsSet = new AtomicBoolean(false);
      private final AtomicBoolean charsetIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean connectionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean engineIsSet = new AtomicBoolean(false);
      private final AtomicBoolean maxRowsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean minRowsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packKeysIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rowFormatIsSet = new AtomicBoolean(false);
      private final ST template;

      private tableFooterST(STGroup group) {
   		template = group.getInstanceOf("tableFooter");
   	}

       public tableFooterST setAutoIncrement(Object value) {
      	tryToSetStringProperty(template, value, autoIncrementIsSet, "autoIncrement");   
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
       public tableFooterST setRowFormat(Object value) {
      	tryToSetStringProperty(template, value, rowFormatIsSet, "rowFormat");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class updateST implements MysqlDomainGroupTemplate {

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
}