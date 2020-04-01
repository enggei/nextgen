package com.generator.generators.tomcat;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Tomcat.stg' file<br/>
 */
public final class TomcatGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public TomcatGroup() {
		this(new STGroupString(stg));
   }

   public TomcatGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TomcatGroup(java.io.File templateFile) {
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

	public interface TomcatGroupTemplate {

	}

   public mvn_war_pluginST newmvn_war_plugin() {
      return new mvn_war_pluginST(stGroup);
   }

   public mvn_tomcat_pluginST newmvn_tomcat_plugin() {
      return new mvn_tomcat_pluginST(stGroup);
   }

   public final class mvn_war_pluginST implements TomcatGroupTemplate {


      private final ST template;

      private mvn_war_pluginST(STGroup group) {
   		template = group.getInstanceOf("mvn_war_plugin");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_tomcat_pluginST implements TomcatGroupTemplate {

      private Object _path;

      private final ST template;

      private mvn_tomcat_pluginST(STGroup group) {
   		template = group.getInstanceOf("mvn_tomcat_plugin");
   	}

      public mvn_tomcat_pluginST setPath(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._path == null) {
            this._path = value;
         	template.add("path", value);
         }

      	return this;
      }

      public String getPath() {
      	return (String) this._path;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "TomcatGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("mvn_war_plugin() ::= <<<plugin>\n" + 
		"    <groupId>org.apache.maven.plugins</groupId>\n" + 
		"    <artifactId>maven-war-plugin</artifactId>\n" + 
		"    <version>2.2</version>\n" + 
		"    <configuration>\n" + 
		"        <failOnMissingWebXml>false</failOnMissingWebXml>\n" + 
		"    </configuration>\n" + 
		"</plugin> >>\n")
			.append("mvn_tomcat_plugin(path) ::= <<<plugin>\n" + 
		"    <groupId>org.apache.tomcat.maven</groupId>\n" + 
		"    <artifactId>tomcat7-maven-plugin</artifactId>\n" + 
		"    <version>2.2</version>\n" + 
		"    <configuration>\n" + 
		"        <server>TomcatServer</server>\n" + 
		"        <url>http://localhost:8080/manager/text</url>\n" + 
		"        <path>~path~</path>\n" + 
		"    </configuration>\n" + 
		"</plugin> >>\n")
		.toString();
}