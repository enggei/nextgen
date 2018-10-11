package com.generator.project;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
* Wraps STGroup-methods based on 'JsonModel.stg' file<br/>
*/
public final class JsonModelGroup {

	private final STGroup stGroup;
	private final char delimiter;

	public JsonModelGroup() {
		this(new STGroupString(stg));
	}

	public JsonModelGroup(STGroup stGroup) {
		this.stGroup = stGroup;
		this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
		this.delimiter = stGroup.delimiterStartChar;
	}

	public JsonModelGroup(java.io.File templateFile) {
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

	public interface JsonModelGroupTemplate {

	}

	public GeneratorST newGenerator() {
		return new GeneratorST(stGroup);
	}


	public enumST newenum() {
		return new enumST(stGroup);
	}


	public transformerST newtransformer() {
		return new transformerST(stGroup);
	}


	public entityST newentity() {
		return new entityST(stGroup);
	}


	public propertiesST newproperties() {
		return new propertiesST(stGroup);
	}


	public setJsonObjectST newsetJsonObject() {
		return new setJsonObjectST(stGroup);
	}


	public getEnumST newgetEnum() {
		return new getEnumST(stGroup);
	}


	public setEnumST newsetEnum() {
		return new setEnumST(stGroup);
	}


	public getTypeST newgetType() {
		return new getTypeST(stGroup);
	}


	public addTypeST newaddType() {
		return new addTypeST(stGroup);
	}


	public getBooleanST newgetBoolean() {
		return new getBooleanST(stGroup);
	}


	public setJsonArrayST newsetJsonArray() {
		return new setJsonArrayST(stGroup);
	}


	public getJsonArrayST newgetJsonArray() {
		return new getJsonArrayST(stGroup);
	}


	public getJsonObjectST newgetJsonObject() {
		return new getJsonObjectST(stGroup);
	}


	public addJsonObjectST newaddJsonObject() {
		return new addJsonObjectST(stGroup);
	}


	public setBooleanST newsetBoolean() {
		return new setBooleanST(stGroup);
	}


	public setStringST newsetString() {
		return new setStringST(stGroup);
	}


	public addStringST newaddString() {
		return new addStringST(stGroup);
	}


	public getStringST newgetString() {
		return new getStringST(stGroup);
	}


	public static final class GeneratorST implements JsonModelGroupTemplate {


		private Object _packageName;
		private Object _name;
		private java.util.Set<Object> _entities = new java.util.LinkedHashSet<>();

		private final ST template;

		private GeneratorST(STGroup group) {
			template = group.getInstanceOf("Generator");
		}

		public GeneratorST setPackageName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._packageName == null) {
				this._packageName = value;
				template.add("packageName", value);
			}

			return this;
		}

		public String getPackageName() {
			return (String) this._packageName;
		}

		public GeneratorST setName(Object value) {
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

		public GeneratorST addEntitiesValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._entities.add(value);
			template.add("entities", value);

			return this;
		}

		public java.util.Set<Object> getEntitiesValues() {
			return this._entities;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class enumST implements JsonModelGroupTemplate {


		private Object _packageName;
		private Object _name;
		private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

		private final ST template;

		private enumST(STGroup group) {
			template = group.getInstanceOf("enum");
		}

		public enumST setPackageName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._packageName == null) {
				this._packageName = value;
				template.add("packageName", value);
			}

			return this;
		}

		public String getPackageName() {
			return (String) this._packageName;
		}

		public enumST setName(Object value) {
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

		public enumST addValuesValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._values.add(value);
			template.add("values", value);

			return this;
		}

		public java.util.Set<Object> getValuesValues() {
			return this._values;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class transformerST implements JsonModelGroupTemplate {


		private Object _name;
		private Object _packageName;

		private final ST template;

		private transformerST(STGroup group) {
			template = group.getInstanceOf("transformer");
		}

		public transformerST setName(Object value) {
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

		public transformerST setPackageName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._packageName == null) {
				this._packageName = value;
				template.add("packageName", value);
			}

			return this;
		}

		public String getPackageName() {
			return (String) this._packageName;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class entityST implements JsonModelGroupTemplate {


		private java.util.Set<java.util.Map<String, Object>> _requiredProperties = new java.util.LinkedHashSet<>();
		private java.util.Set<Object> _properties = new java.util.LinkedHashSet<>();
		private Object _packageName;
		private Object _name;

		private final ST template;

		private entityST(STGroup group) {
			template = group.getInstanceOf("entity");
		}

		public entityST addRequiredPropertiesValue(Object type_, Object name_) {
			final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
			map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
			this._requiredProperties.add(map);

			template.addAggr("requiredProperties.{type, name}", map.get("type"), map.get("name"));
			return this;
		}

		public java.util.Set<java.util.Map<String, Object>> getRequiredProperties() {
			return this._requiredProperties;
		}

		public entityST addPropertiesValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._properties.add(value);
			template.add("properties", value);

			return this;
		}

		public java.util.Set<Object> getPropertiesValues() {
			return this._properties;
		}

		public entityST setPackageName(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._packageName == null) {
				this._packageName = value;
				template.add("packageName", value);
			}

			return this;
		}

		public String getPackageName() {
			return (String) this._packageName;
		}

		public entityST setName(Object value) {
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

	public static final class propertiesST implements JsonModelGroupTemplate {


		private java.util.Set<Object> _setters = new java.util.LinkedHashSet<>();
		private java.util.Set<Object> _getters = new java.util.LinkedHashSet<>();

		private final ST template;

		private propertiesST(STGroup group) {
			template = group.getInstanceOf("properties");
		}

		public propertiesST addSettersValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._setters.add(value);
			template.add("setters", value);

			return this;
		}

		public java.util.Set<Object> getSettersValues() {
			return this._setters;
		}

		public propertiesST addGettersValue(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			this._getters.add(value);
			template.add("getters", value);

			return this;
		}

		public java.util.Set<Object> getGettersValues() {
			return this._getters;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class setJsonObjectST implements JsonModelGroupTemplate {


		private Object _type;
		private Object _name;
		private Object _entity;

		private final ST template;

		private setJsonObjectST(STGroup group) {
			template = group.getInstanceOf("setJsonObject");
		}

		public setJsonObjectST setType(Object value) {
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

		public setJsonObjectST setName(Object value) {
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

		public setJsonObjectST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class getEnumST implements JsonModelGroupTemplate {


		private Object _name;
		private Object _type;

		private final ST template;

		private getEnumST(STGroup group) {
			template = group.getInstanceOf("getEnum");
		}

		public getEnumST setName(Object value) {
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

		public getEnumST setType(Object value) {
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

	public static final class setEnumST implements JsonModelGroupTemplate {


		private Object _entity;
		private Object _name;
		private Object _type;

		private final ST template;

		private setEnumST(STGroup group) {
			template = group.getInstanceOf("setEnum");
		}

		public setEnumST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		public setEnumST setName(Object value) {
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

		public setEnumST setType(Object value) {
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

	public static final class getTypeST implements JsonModelGroupTemplate {


		private Object _valueType;
		private Object _name;

		private final ST template;

		private getTypeST(STGroup group) {
			template = group.getInstanceOf("getType");
		}

		public getTypeST setValueType(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._valueType == null) {
				this._valueType = value;
				template.add("valueType", value);
			}

			return this;
		}

		public String getValueType() {
			return (String) this._valueType;
		}

		public getTypeST setName(Object value) {
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

	public static final class addTypeST implements JsonModelGroupTemplate {


		private Object _valueType;
		private Object _name;
		private Object _entity;

		private final ST template;

		private addTypeST(STGroup group) {
			template = group.getInstanceOf("addType");
		}

		public addTypeST setValueType(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._valueType == null) {
				this._valueType = value;
				template.add("valueType", value);
			}

			return this;
		}

		public String getValueType() {
			return (String) this._valueType;
		}

		public addTypeST setName(Object value) {
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

		public addTypeST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class getBooleanST implements JsonModelGroupTemplate {


		private Object _name;

		private final ST template;

		private getBooleanST(STGroup group) {
			template = group.getInstanceOf("getBoolean");
		}

		public getBooleanST setName(Object value) {
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

	public static final class setJsonArrayST implements JsonModelGroupTemplate {


		private Object _name;
		private Object _entity;

		private final ST template;

		private setJsonArrayST(STGroup group) {
			template = group.getInstanceOf("setJsonArray");
		}

		public setJsonArrayST setName(Object value) {
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

		public setJsonArrayST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class getJsonArrayST implements JsonModelGroupTemplate {


		private Object _name;

		private final ST template;

		private getJsonArrayST(STGroup group) {
			template = group.getInstanceOf("getJsonArray");
		}

		public getJsonArrayST setName(Object value) {
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

	public static final class getJsonObjectST implements JsonModelGroupTemplate {


		private Object _type;
		private Object _name;

		private final ST template;

		private getJsonObjectST(STGroup group) {
			template = group.getInstanceOf("getJsonObject");
		}

		public getJsonObjectST setType(Object value) {
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

		public getJsonObjectST setName(Object value) {
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

	public static final class addJsonObjectST implements JsonModelGroupTemplate {


		private Object _type;
		private Object _entity;
		private Object _name;

		private final ST template;

		private addJsonObjectST(STGroup group) {
			template = group.getInstanceOf("addJsonObject");
		}

		public addJsonObjectST setType(Object value) {
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

		public addJsonObjectST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		public addJsonObjectST setName(Object value) {
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

	public static final class setBooleanST implements JsonModelGroupTemplate {


		private Object _name;
		private Object _entity;

		private final ST template;

		private setBooleanST(STGroup group) {
			template = group.getInstanceOf("setBoolean");
		}

		public setBooleanST setName(Object value) {
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

		public setBooleanST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class setStringST implements JsonModelGroupTemplate {


		private Object _name;
		private Object _entity;

		private final ST template;

		private setStringST(STGroup group) {
			template = group.getInstanceOf("setString");
		}

		public setStringST setName(Object value) {
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

		public setStringST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public static final class addStringST implements JsonModelGroupTemplate {


		private Object _entity;
		private Object _name;

		private final ST template;

		private addStringST(STGroup group) {
			template = group.getInstanceOf("addString");
		}

		public addStringST setEntity(Object value) {
			if (value == null || value.toString().length() == 0)
				return this;

			if (this._entity == null) {
				this._entity = value;
				template.add("entity", value);
			}

			return this;
		}

		public String getEntity() {
			return (String) this._entity;
		}

		public addStringST setName(Object value) {
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

	public static final class getStringST implements JsonModelGroupTemplate {


		private Object _name;

		private final ST template;

		private getStringST(STGroup group) {
			template = group.getInstanceOf("getString");
		}

		public getStringST setName(Object value) {
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "JsonModelGroup.stg")));
		out.write(stg);
		out.close();
	}

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("Generator(packageName,name,entities) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import java.io.IOException;\n" + 
		"\n" + 
		"public abstract class ~name;format=\"capitalize\"~ {\n" + 
		"\n" + 
		"	protected final String src;\n" + 
		"\n" + 
		"	public ~name;format=\"capitalize\"~(String src) {\n" + 
		"		this.src = src;\n" + 
		"	}\n" + 
		"\n" + 
		"	public void generate(Object element) throws IOException {\n" + 
		"		~entities:{it|if (element instanceof ~it;format=\"capitalize\"~) generate~it;format=\"capitalize\"~((~it;format=\"capitalize\"~) element, src);};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"	~entities:{it|protected void generate~it;format=\"capitalize\"~(~it;format=\"capitalize\"~ model, String src) throws IOException { ~eom()~};separator=\"\\n\\n\"~\n" + 
		"}>>\n")
			.append("enum(packageName,name,values) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"public enum ~name;format=\"capitalize\"~ {\n" + 
		"\n" + 
		"	~values:{it|~it~};separator=\", \"~\n" + 
		"}>>\n")
			.append("transformer(name,packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"public class ~name;format=\"capitalize\"~ extends JsonObject {\n" + 
		"\n" + 
		"	public ~name;format=\"capitalize\"~(JsonObject source, JsonObject parameters) {\n" + 
		"		map(source, parameters);\n" + 
		"	}\n" + 
		"\n" + 
		"	public JsonObject map(JsonObject source, JsonObject parameters) {\n" + 
		"		return this;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected interface Handler<T> {\n" + 
		"		void handle(T element);\n" + 
		"	}\n" + 
		"\n" + 
		"	protected <T> void forEach(String key, Handler<T> handler) {\n" + 
		"		forEach(key, this, handler);\n" + 
		"	}\n" + 
		"\n" + 
		"	protected JsonArray getOrCreateJsonArray(String key) {\n" + 
		"		JsonArray jsonArray = getJsonArray(key);\n" + 
		"		if (jsonArray == null) put(key, jsonArray = new JsonArray());\n" + 
		"		return jsonArray;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected static <T> void forEach(String key, JsonObject jsonObject, Handler<T> handler) {\n" + 
		"		for (Object o : jsonObject.getJsonArray(key, new JsonArray()))\n" + 
		"			handler.handle((T) o);\n" + 
		"	}\n" + 
		"	\n" + 
		"	protected static JsonArray getOrCreateJsonArray(String key, JsonObject jsonObject) {\n" + 
		"		JsonArray jsonArray = jsonObject.getJsonArray(key);\n" + 
		"		if (jsonArray == null) jsonObject.put(key, jsonArray = new JsonArray());\n" + 
		"		return jsonArray;\n" + 
		"	}\n" + 
		"}>>\n")
			.append("entity(requiredProperties,properties,packageName,name) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"public class ~name;format=\"capitalize\"~ extends JsonObject {\n" + 
		"\n" + 
		"	public ~name;format=\"capitalize\"~(Object object) {\n" + 
		"		this((JsonObject)object);\n" + 
		"	}\n" + 
		"\n" + 
		"	public ~name;format=\"capitalize\"~(JsonObject jsonObject) {\n" + 
		"		mergeIn(jsonObject, true);\n" + 
		"	}\n" + 
		"	\n" + 
		"	public ~name;format=\"capitalize\"~(~requiredProperties:{it|~it.type~ ~it.name;format=\"lowFirst\"~};separator=\", \"~) {\n" + 
		"		~requiredProperties:{it|put(\"~it.name~\", ~it.name;format=\"lowFirst\"~);};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"	~properties:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"	public <T> T findElement(JsonArray jsonArray, String key, String value) {\n" + 
		"		for (Object o : jsonArray) {\n" + 
		"				final JsonObject element = (JsonObject) o;\n" + 
		"				if (element.getString(key).equals(value)) return (T) o;\n" + 
		"		}\n" + 
		"		return null;\n" + 
		"	}\n" + 
		"}>>\n")
			.append("properties(setters,getters) ::= <<~setters:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"~getters:{it|~it~};separator=\"\\n\\n\"~>>\n")
			.append("setJsonObject(type,name,entity) ::= <<public ~entity;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) {\n" + 
		"	put(\"~name~\", value);\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("getEnum(name,type) ::= <<public ~type~ get~name;format=\"capitalize\"~() {\n" + 
		"	return getString(\"~name~\") == null ? null : ~type~.valueOf(getString(\"~name~\"));\n" + 
		"}>>\n")
			.append("setEnum(entity,name,type) ::= <<public ~entity;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) {\n" + 
		"	put(\"~name~\", value.name());\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("getType(valueType,name) ::= <<public ~valueType~ get~name;format=\"capitalize\"~() {\n" + 
		"	return new ~valueType~(getJsonObject(\"~name~\"));\n" + 
		"}>>\n")
			.append("addType(valueType,name,entity) ::= <<public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~valueType~ value) {\n" + 
		"	JsonArray jsonArray = getJsonArray(\"~name~\");\n" + 
		"	if (jsonArray == null) put(\"~name~\", jsonArray = new JsonArray());\n" + 
		"	jsonArray.add(value);\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("getBoolean(name) ::= <<public Boolean get~name;format=\"capitalize\"~() {\n" + 
		"	return getBoolean(\"~name~\", false);\n" + 
		"}>>\n")
			.append("setJsonArray(name,entity) ::= <<public ~entity;format=\"capitalize\"~ set~name;format=\"capitalize\"~(JsonArray value) {\n" + 
		"	put(\"~name~\", value);\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("getJsonArray(name) ::= <<public JsonArray get~name;format=\"capitalize\"~() {\n" + 
		"	return getJsonArray(\"~name~\", new JsonArray());\n" + 
		"}>>\n")
			.append("getJsonObject(type,name) ::= <<public ~type~ get~name;format=\"capitalize\"~() {\n" + 
		"	return getJsonObject(\"~name~\") == null ? null : new ~type~(getJsonObject(\"~name~\"));\n" + 
		"}>>\n")
			.append("addJsonObject(type,entity,name) ::= <<public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~type~ value) {\n" + 
		"	JsonArray jsonArray = getJsonArray(\"~name~\");\n" + 
		"	if (jsonArray == null) put(\"~name~\", jsonArray = new JsonArray());\n" + 
		"	jsonArray.add(value);\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("setBoolean(name,entity) ::= <<public ~entity;format=\"capitalize\"~ set~name;format=\"capitalize\"~(Boolean value) {\n" + 
		"	put(\"~name~\", value);\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("setString(name,entity) ::= <<public ~entity;format=\"capitalize\"~ set~name;format=\"capitalize\"~(String value) {\n" + 
		"	put(\"~name~\", value);\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("addString(entity,name) ::= <<public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(String value) {\n" + 
		"	JsonArray jsonArray = getJsonArray(\"~name~\");\n" + 
		"	if (jsonArray == null) put(\"~name~\", jsonArray = new JsonArray());\n" + 
		"	jsonArray.add(value);\n" + 
		"	return this;\n" + 
		"}>>\n")
			.append("getString(name) ::= <<public String get~name;format=\"capitalize\"~() {\n" + 
		"	return getString(\"~name~\");\n" + 
		"}>>\n")
		.toString();
}