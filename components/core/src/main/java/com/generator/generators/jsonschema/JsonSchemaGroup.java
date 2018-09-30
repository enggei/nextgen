package com.generator.generators.jsonschema;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
* Wraps STGroup-methods based on 'JsonSchema.stg' file<br/>
*/
public final class JsonSchemaGroup {

	private final STGroup stGroup;
	private final char delimiter;

	public JsonSchemaGroup() {
		this(new STGroupString(stg));
	}

	public JsonSchemaGroup(STGroup stGroup) {
		this.stGroup = stGroup;
		this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
		this.delimiter = stGroup.delimiterStartChar;
	}

	public JsonSchemaGroup(java.io.File templateFile) {
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

	public interface JsonSchemaGroupTemplate {

	}

	public schemaST newschema() {
		return new schemaST(stGroup);
	}


	public propertyST newproperty() {
		return new propertyST(stGroup);
	}


	public itemsValidationST newitemsValidation() {
		return new itemsValidationST(stGroup);
	}


	public booleanValidationST newbooleanValidation() {
		return new booleanValidationST(stGroup);
	}


	public stringValidationST newstringValidation() {
		return new stringValidationST(stGroup);
	}


	public numberValidationST newnumberValidation() {
		return new numberValidationST(stGroup);
	}


	public static final class schemaST implements JsonSchemaGroupTemplate {


		private java.util.Set<Object> _required = new java.util.LinkedHashSet<>();
		private java.util.Set<Object> _properties = new java.util.LinkedHashSet<>();
		private java.util.Set<Object> _definitions = new java.util.LinkedHashSet<>();
		private Object _type;
		private Object _description;
		private Object _title;
		private Object _schema;
		private Object _id;

		private final ST template;

		private schemaST(STGroup group) {
			template = group.getInstanceOf("schema");
		}

		public schemaST addRequiredValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._required.add(value);
			template.add("required", value);

			return this;
		}

		public java.util.Set<Object> getRequiredValues() {
			return this._required;
		}

		public schemaST addPropertiesValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._properties.add(value);
			template.add("properties", value);

			return this;
		}

		public java.util.Set<Object> getPropertiesValues() {
			return this._properties;
		}

		public schemaST addDefinitionsValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._definitions.add(value);
			template.add("definitions", value);

			return this;
		}

		public java.util.Set<Object> getDefinitionsValues() {
			return this._definitions;
		}

		public schemaST setType(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._type == null) {
				this._type = value;
				template.add("type", value);
			}

			return this;
		}

		public String getType() {
			return (String) this._type;
		}

		public schemaST setDescription(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._description == null) {
				this._description = value;
				template.add("description", value);
			}

			return this;
		}

		public String getDescription() {
			return (String) this._description;
		}

		public schemaST setTitle(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._title == null) {
				this._title = value;
				template.add("title", value);
			}

			return this;
		}

		public String getTitle() {
			return (String) this._title;
		}

		public schemaST setSchema(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._schema == null) {
				this._schema = value;
				template.add("schema", value);
			}

			return this;
		}

		public String getSchema() {
			return (String) this._schema;
		}

		public schemaST setId(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._id == null) {
				this._id = value;
				template.add("id", value);
			}

			return this;
		}

		public String getId() {
			return (String) this._id;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class propertyST implements JsonSchemaGroupTemplate {


		private java.util.Set<Object> _validations = new java.util.LinkedHashSet<>();
		private Object _type;
		private Object _description;
		private Object _name;

		private final ST template;

		private propertyST(STGroup group) {
			template = group.getInstanceOf("property");
		}

		public propertyST addValidationsValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._validations.add(value);
			template.add("validations", value);

			return this;
		}

		public java.util.Set<Object> getValidationsValues() {
			return this._validations;
		}

		public propertyST setType(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._type == null) {
				this._type = value;
				template.add("type", value);
			}

			return this;
		}

		public String getType() {
			return (String) this._type;
		}

		public propertyST setDescription(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._description == null) {
				this._description = value;
				template.add("description", value);
			}

			return this;
		}

		public String getDescription() {
			return (String) this._description;
		}

		public propertyST setName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._name == null) {
				this._name = value;
				template.add("name", value);
			}

			return this;
		}

		public String getName() {
			return (String) this._name;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class itemsValidationST implements JsonSchemaGroupTemplate {


		private Object _type;

		private final ST template;

		private itemsValidationST(STGroup group) {
			template = group.getInstanceOf("itemsValidation");
		}

		public itemsValidationST setType(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._type == null) {
				this._type = value;
				template.add("type", value);
			}

			return this;
		}

		public String getType() {
			return (String) this._type;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class booleanValidationST implements JsonSchemaGroupTemplate {


		private Object _value;
		private Object _name;

		private final ST template;

		private booleanValidationST(STGroup group) {
			template = group.getInstanceOf("booleanValidation");
		}

		public booleanValidationST setValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._value == null) {
				this._value = value;
				template.add("value", value);
			}

			return this;
		}

		public String getValue() {
			return (String) this._value;
		}

		public booleanValidationST setName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._name == null) {
				this._name = value;
				template.add("name", value);
			}

			return this;
		}

		public String getName() {
			return (String) this._name;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class stringValidationST implements JsonSchemaGroupTemplate {


		private Object _value;
		private Object _name;

		private final ST template;

		private stringValidationST(STGroup group) {
			template = group.getInstanceOf("stringValidation");
		}

		public stringValidationST setValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._value == null) {
				this._value = value;
				template.add("value", value);
			}

			return this;
		}

		public String getValue() {
			return (String) this._value;
		}

		public stringValidationST setName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._name == null) {
				this._name = value;
				template.add("name", value);
			}

			return this;
		}

		public String getName() {
			return (String) this._name;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class numberValidationST implements JsonSchemaGroupTemplate {


		private Object _value;
		private Object _name;

		private final ST template;

		private numberValidationST(STGroup group) {
			template = group.getInstanceOf("numberValidation");
		}

		public numberValidationST setValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._value == null) {
				this._value = value;
				template.add("value", value);
			}

			return this;
		}

		public String getValue() {
			return (String) this._value;
		}

		public numberValidationST setName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._name == null) {
				this._name = value;
				template.add("name", value);
			}

			return this;
		}

		public String getName() {
			return (String) this._name;
		}

		@Override
		public String toString() {
			return template.render();
		}
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "JsonSchemaGroup.stg")));
		out.write(stg);
		out.close();
	}

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("schema(required,properties,definitions,type,description,title,schema,id) ::= <<{\n" + 
		"	\"$id\": \"~id~\",\n" + 
		"	\"$schema\": \"~schema~\",\n" + 
		"	\"title\": \"~title~\",\n" + 
		"	\"description\": \"~description~\",\n" + 
		"	\"type\": \"~type~\",\n" + 
		"	\"properties\": {\n" + 
		"		~properties:{it|~it~};separator=\",\\n\"~ \n" + 
		"	},\n" + 
		"	\"required\": [ ~required:{it|\"~it~\"};separator=\", \"~ ],\n" + 
		"	\"definitions\": {\n" + 
		"		~definitions:{it|~it~};separator=\",\\n\"~\n" + 
		"	}\n" + 
		"}>>\n")
			.append("property(validations,type,description,name) ::= <<\"~name~\": {\n" + 
		"	\"description\": \"~description~\",\n" + 
		"	\"type\": \"~type~\"~if(validations)~,\n" + 
		"	~validations:{it|~it~};separator=\",\\n\"~\n" + 
		"	~endif~\n" + 
		"}>>\n")
			.append("itemsValidation(type) ::= <<\"items\" : {\n" + 
		"	\"type\": ~type~\n" + 
		"}>>\n")
			.append("booleanValidation(value,name) ::= <<\"~name~\": ~value~>>\n")
			.append("stringValidation(value,name) ::= <<\"~name~\": \"~value~\">>\n")
			.append("numberValidation(value,name) ::= <<\"~name~\": ~value~>>\n")
		.toString();
}