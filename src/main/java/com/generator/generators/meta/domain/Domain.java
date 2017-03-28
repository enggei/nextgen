package com.generator.generators.meta.domain;

/** Interface for Domain */
public interface Domain {

	   String getName();

	   void setName(String name);

	   String getPackageName();

	   void setPackageName(String packageName);


	   void addENTITY(Entity table);

	   java.util.List<Entity> getENTITY();

	   java.util.Iterator<Entity> iterateENTITY();
	   void addRELATION(Relation table);

	   java.util.List<Relation> getRELATION();

	   java.util.Iterator<Relation> iterateRELATION();

}