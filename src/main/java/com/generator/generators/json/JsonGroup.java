package com.generator.generators.json;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'json.stg' file<br/>
 */
public final class JsonGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public JsonGroup() {
		this(new STGroupString(stg));
   }

   public JsonGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public JsonGroup(java.io.File templateFile) {
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

	public interface JsonGroupTemplate {

	}

   public arrayST newarray() {
      return new arrayST(stGroup);
   }

   public documentST newdocument() {
      return new documentST(stGroup);
   }

   public objectST newobject() {
      return new objectST(stGroup);
   }

   public primitiveST newprimitive() {
      return new primitiveST(stGroup);
   }

   public primitiveStringST newprimitiveString() {
      return new primitiveStringST(stGroup);
   }

   public final class arrayST implements JsonGroupTemplate {

      private java.util.Set<Object> _elements = new java.util.LinkedHashSet<>();

      private final ST template;

      private arrayST(STGroup group) {
   		template = group.getInstanceOf("array");
   	}

      public arrayST addElementsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._elements.add(value);
      	template.add("elements", value);

         return this;
      }

      public java.util.Set<Object> getElementsValues() {
      	return this._elements;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class documentST implements JsonGroupTemplate {

      private java.util.Set<Object> _content = new java.util.LinkedHashSet<>();

      private final ST template;

      private documentST(STGroup group) {
   		template = group.getInstanceOf("document");
   	}

      public documentST addContentValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._content.add(value);
      	template.add("content", value);

         return this;
      }

      public java.util.Set<Object> getContentValues() {
      	return this._content;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class objectST implements JsonGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _functions = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _pairs = new java.util.LinkedHashSet<>();

      private final ST template;

      private objectST(STGroup group) {
   		template = group.getInstanceOf("object");
   	}

      public objectST addFunctionsValue(Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._functions.add(map);

         template.addAggr("functions.{name, value}", map.get("name"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getFunctions() {
      	return this._functions;
      }

      public objectST addPairsValue(Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._pairs.add(map);

         template.addAggr("pairs.{name, value}", map.get("name"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getPairs() {
      	return this._pairs;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class primitiveST implements JsonGroupTemplate {

      private Object _value;

      private final ST template;

      private primitiveST(STGroup group) {
   		template = group.getInstanceOf("primitive");
   	}

      public primitiveST setValue(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class primitiveStringST implements JsonGroupTemplate {

      private Object _value;

      private final ST template;

      private primitiveStringST(STGroup group) {
   		template = group.getInstanceOf("primitiveString");
   	}

      public primitiveStringST setValue(Object value) {
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "JsonGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("array(elements) ::= <<[\n" + 
		"  ~elements:{it|~it~};separator=\",\\n\"~\n" + 
		"]>>\n")
			.append("document(content) ::= <<~content:{it|~it~};separator=\"\\n\"~>>\n")
			.append("object(functions,pairs) ::= <<{\n" + 
		"  ~pairs:{it|\"~it.name~\": ~it.value~};separator=\",\\n\"~~if(functions)~,~endif~\n" + 
		"  ~functions:{it|~it.name~: ~it.value~};separator=\",\\n\"~\n" + 
		"}>>\n")
			.append("primitive(value) ::= <<~value~>>\n")
			.append("primitiveString(value) ::= <<\"~value~\">>\n")
		.toString();
}