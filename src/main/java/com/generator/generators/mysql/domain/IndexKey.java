package com.generator.generators.mysql.domain;

/** Interface for IndexKey */
public interface IndexKey {

	   String getName();

	   void setName(String name);

	   String getIndexType();

	   void setIndexType(String indexType);


	   void addColumns(Column table);

	   java.util.List<Column> getColumns();

	   java.util.Iterator<Column> iterateColumns();

}