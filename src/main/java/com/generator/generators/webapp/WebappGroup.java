
package com.generator.generators.webapp;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'WebappGroup.stg' file<br/>
 */
public final class WebappGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public WebappGroup() {
		this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "webapp" + java.io.File.separator + "webapp.stg"));
   }

   public WebappGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public WebappGroup(java.io.File templateFile) {
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

   public appHtmlST newappHtml() {
      return new appHtmlST(stGroup);
   }

   public appJsST newappJs() {
      return new appJsST(stGroup);
   }

   public shellHtmlST newshellHtml() {
      return new shellHtmlST(stGroup);
   }

   public shellJsST newshellJs() {
      return new shellJsST(stGroup);
   }

   public final class appHtmlST {

      private final AtomicBoolean appnameIsSet = new AtomicBoolean(false);
      private final ST template;

      private appHtmlST(STGroup group) {
   		template = group.getInstanceOf("appHtml");
   	}

      public appHtmlST setAppname(Object value) {
      	tryToSetStringProperty(template, value, appnameIsSet, "appname");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class appJsST {

      private final AtomicBoolean appnameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rootIsSet = new AtomicBoolean(false);
      private final ST template;

      private appJsST(STGroup group) {
   		template = group.getInstanceOf("appJs");
   	}

      public appJsST setAppname(Object value) {
      	tryToSetStringProperty(template, value, appnameIsSet, "appname");   
         return this;
      }

      public appJsST setRoot(Object value) {
      	tryToSetStringProperty(template, value, rootIsSet, "root");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class shellHtmlST {

      private final ST template;

      private shellHtmlST(STGroup group) {
   		template = group.getInstanceOf("shellHtml");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class shellJsST {

      private final ST template;

      private shellJsST(STGroup group) {
   		template = group.getInstanceOf("shellJs");
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
  }    