package com.generator.generators.mysql.domain;

/** Interface for database */
public interface Database {

	   String getName();

	   void setName(String name);


	   void addTable(Table table);

	   java.util.List<Table> getTable();

	   java.util.Iterator<Table> iterateTable();

}