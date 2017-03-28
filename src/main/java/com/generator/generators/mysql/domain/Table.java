package com.generator.generators.mysql.domain;

/** Interface for table */
public interface Table {

	   String getName();

	   void setName(String name);

	   String getPrimaryKeyType();

	   void setPrimaryKeyType(String primaryKeyType);


	   void addColumn(Column table);

	   java.util.List<Column> getColumn();

	   java.util.Iterator<Column> iterateColumn();
	   void addKeys(Key table);

	   java.util.List<Key> getKeys();

	   java.util.Iterator<Key> iterateKeys();

}