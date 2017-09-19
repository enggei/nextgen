package com.generator.generators.csv;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'CSV.stg' file<br/>
 */
public final class CSVGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public CSVGroup() {
		this(new STGroupString(stg));
   }

   public CSVGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public CSVGroup(java.io.File templateFile) {
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

	public interface CSVGroupTemplate {

	}

   public CSVST newCSV() {
      return new CSVST(stGroup);
   }

   public stringValueST newstringValue() {
      return new stringValueST(stGroup);
   }

   public rowST newrow() {
      return new rowST(stGroup);
   }

   public final class CSVST implements CSVGroupTemplate {

      private java.util.Set<Object> _header = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _row = new java.util.LinkedHashSet<>();

      private final ST template;

      private CSVST(STGroup group) {
   		template = group.getInstanceOf("CSV");
   	}

      public CSVST addHeaderValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._header.add(value);
      	template.add("header", value);

         return this;
      }

      public java.util.Set<Object> getHeaderValues() {
      	return this._header;
      }

      public CSVST addRowValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._row.add(value);
      	template.add("row", value);

         return this;
      }

      public java.util.Set<Object> getRowValues() {
      	return this._row;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class stringValueST implements CSVGroupTemplate {

      private Object _value;

      private final ST template;

      private stringValueST(STGroup group) {
   		template = group.getInstanceOf("stringValue");
   	}

      public stringValueST setValue(Object value) {
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

   public final class rowST implements CSVGroupTemplate {

      private java.util.Set<Object> _column = new java.util.LinkedHashSet<>();

      private final ST template;

      private rowST(STGroup group) {
   		template = group.getInstanceOf("row");
   	}

      public rowST addColumnValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._column.add(value);
      	template.add("column", value);

         return this;
      }

      public java.util.Set<Object> getColumnValues() {
      	return this._column;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "CSVGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("CSV(header,row) ::= <<~header:{it|\"~it~\"};separator=\",\"~\n" + 
		"~row:{it|~it~};separator=\"\\n\"~>>\n")
			.append("stringValue(value) ::= <<\"~value~\">>\n")
			.append("row(column) ::= <<~column:{it|~it~};separator=\",\"~>>\n")
		.toString();
}