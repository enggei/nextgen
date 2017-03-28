package com.generator.generators.meta.domain;

/** Interface for Relation */
public interface Relation {

	   String getName();

	   void setName(String name);

	   Enum getCardinality();

	   void setCardinality(Enum cardinality);

	   String getProperty();

	   void setProperty(String property);


	   void addDST(Entity table);

	   java.util.List<Entity> getDST();

	   java.util.Iterator<Entity> iterateDST();

}