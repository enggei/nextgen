package com.generator.generators.xml;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'XmlGroup.stg' file<br/>
 */
public final class XmlGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public XmlGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "xml" + java.io.File.separator + "xml.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(XmlGroup.class.getResource("/com/generator/generators/xml/xml.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}
   }

   public XmlGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public XmlGroup(java.io.File templateFile) {
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

	public interface XmlGroupTemplate {

	}


   public attributeST newattribute() {
      return new attributeST(stGroup);
   } 


   public fileST newfile() {
      return new fileST(stGroup);
   } 


   public tagST newtag() {
      return new tagST(stGroup);
   } 

   public final class attributeST implements XmlGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private attributeST(STGroup group) {
   		template = group.getInstanceOf("attribute");
   	}

       public attributeST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public attributeST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class fileST implements XmlGroupTemplate {

      private final AtomicBoolean encodingIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rootIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final ST template;

      private fileST(STGroup group) {
   		template = group.getInstanceOf("file");
   	}

       public fileST setEncoding(Object value) {
      	tryToSetStringProperty(template, value, encodingIsSet, "encoding");   
         return this;
      } 
       public fileST setRoot(Object value) {
      	tryToSetStringProperty(template, value, rootIsSet, "root");   
         return this;
      } 
       public fileST setVersion(Object value) {
      	tryToSetStringProperty(template, value, versionIsSet, "version");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class tagST implements XmlGroupTemplate {

      private final AtomicBoolean attributesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean contentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean elementsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private tagST(STGroup group) {
   		template = group.getInstanceOf("tag");
   	}

      public tagST addAttributesValue(Object value) {
      	tryToSetListProperty(template, value, attributesIsSet, "attributes");
         return this;
      }
       public tagST setContents(Object value) {
      	tryToSetStringProperty(template, value, contentsIsSet, "contents");   
         return this;
      } 
      public tagST addElementsValue(Object value) {
      	tryToSetListProperty(template, value, elementsIsSet, "elements");
         return this;
      }
       public tagST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
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
} 