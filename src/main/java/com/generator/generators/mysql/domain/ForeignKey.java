package com.generator.generators.mysql.domain;

/** Interface for ForeignKey */
public interface ForeignKey {

	   String getName();

	   void setName(String name);

	   String getOnDelete();

	   void setOnDelete(String onDelete);

	   String getOnUpdate();

	   void setOnUpdate(String onUpdate);


	   void addColumns(Column table);

	   java.util.List<Column> getColumns();

	   java.util.Iterator<Column> iterateColumns();

}