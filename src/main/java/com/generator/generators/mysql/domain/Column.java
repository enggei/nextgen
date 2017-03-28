package com.generator.generators.mysql.domain;

/** Interface for column */
public interface Column {

	   String getName();

	   void setName(String name);

	   String getType();

	   void setType(String type);

	   String getComment();

	   void setComment(String comment);

	   Boolean getNullable();

	   void setNullable(Boolean nullable);

	   String getDefaultValue();

	   void setDefaultValue(String defaultValue);

	   String getOnUpdate();

	   void setOnUpdate(String onUpdate);

	   String getAutoIncrement();

	   void setAutoIncrement(String autoIncrement);



}