package com.generator.generators.meta.domain;

/** Interface for Entity */
public interface Entity {

	   String getName();

	   void setName(String name);

	   String getColor();

	   void setColor(String color);

	   String getRoot();

	   void setRoot(String root);

	   String getLabel();

	   void setLabel(String label);


	   void addPROPERTY(Property table);

	   java.util.List<Property> getPROPERTY();

	   java.util.Iterator<Property> iteratePROPERTY();
	   void addSRC(Relation table);

	   java.util.List<Relation> getSRC();

	   java.util.Iterator<Relation> iterateSRC();

}