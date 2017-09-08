package com.generator.generators.xml;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'XML.stg' file<br/>
 */
public final class XMLGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public XMLGroup() {
		this(new STGroupString(stg));
   }

   public XMLGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public XMLGroup(java.io.File templateFile) {
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

	public interface XMLGroupTemplate {

	}

   public CDATAST newCDATA() {
      return new CDATAST(stGroup);
   } 

   public documentST newdocument() {
      return new documentST(stGroup);
   } 

   public elementST newelement() {
      return new elementST(stGroup);
   } 

   public final class CDATAST implements XMLGroupTemplate {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final ST template;

      private CDATAST(STGroup group) {
   		template = group.getInstanceOf("CDATA");
   	}

      public CDATAST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class documentST implements XMLGroupTemplate {

      private final AtomicBoolean contentIsSet = new AtomicBoolean(false);
      private final ST template;

      private documentST(STGroup group) {
   		template = group.getInstanceOf("document");
   	}

      public documentST setContent(Object value) {
      	tryToSetStringProperty(template, value, contentIsSet, "content");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class elementST implements XMLGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean childrenIsSet = new AtomicBoolean(false);
      private final AtomicBoolean attributesIsSet = new AtomicBoolean(false);
      private final ST template;

      private elementST(STGroup group) {
   		template = group.getInstanceOf("element");
   	}

      public elementST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public elementST addChildrenValue(Object value) {
      	tryToSetListProperty(template, value, childrenIsSet, "children");
         return this;
      } 
      public elementST addAttributesValue(Object name_, Object value_) {
         attributesIsSet.set(true);
         template.addAggr("attributes.{name, value}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

	static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (alreadySet.get()) return;
		if (value == null || value.toString().length() == 0) return;
		alreadySet.set(true);
		template.add(name, value);
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "XMLGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
		.append("CDATA(content) ::= <<<![CDATA[~content~]]> >>\n")
		.append("document(content) ::= <<<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
	"~content~ >>\n")
		.append("element(name,children,attributes) ::= <<<~name~~attributes:{it|  ~it.name~=\"~it.value~\"}~>\n" + 
	"	~children:{it|~it~};separator=\"\\n\"~\n" + 
	"</~name~> >>\n").toString();
} 