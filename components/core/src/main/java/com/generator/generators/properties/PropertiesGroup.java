package com.generator.generators.properties;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Properties.stg' file<br/>
 */
public final class PropertiesGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public PropertiesGroup() {
		this(new STGroupString(stg));
   }

   public PropertiesGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public PropertiesGroup(java.io.File templateFile) {
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

	public interface PropertiesGroupTemplate {

	}

   public fileAppenderST newfileAppender() {
      return new fileAppenderST(stGroup);
   }

   public propertiesFileST newpropertiesFile() {
      return new propertiesFileST(stGroup);
   }

   public log4jPropertiesST newlog4jProperties() {
      return new log4jPropertiesST(stGroup);
   }

   public consoleAppenderST newconsoleAppender() {
      return new consoleAppenderST(stGroup);
   }

   public final class fileAppenderST implements PropertiesGroupTemplate {

      private Object _maxFileSize;
      private Object _name;
      private Object _threshold;
      private Object _filePath;

      private final ST template;

      private fileAppenderST(STGroup group) {
   		template = group.getInstanceOf("fileAppender");
   	}

      public fileAppenderST setMaxFileSize(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._maxFileSize == null) {
            this._maxFileSize = value;
         	template.add("maxFileSize", value);
         }

      	return this;
      }

      public String getMaxFileSize() {
      	return (String) this._maxFileSize;
      }

      public fileAppenderST setName(Object value) {
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

      public fileAppenderST setThreshold(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._threshold == null) {
            this._threshold = value;
         	template.add("threshold", value);
         }

      	return this;
      }

      public String getThreshold() {
      	return (String) this._threshold;
      }

      public fileAppenderST setFilePath(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._filePath == null) {
            this._filePath = value;
         	template.add("filePath", value);
         }

      	return this;
      }

      public String getFilePath() {
      	return (String) this._filePath;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class propertiesFileST implements PropertiesGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private propertiesFileST(STGroup group) {
   		template = group.getInstanceOf("propertiesFile");
   	}

      public propertiesFileST addPropertiesValue(Object comments_, Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("comments", (comments_ == null || comments_.toString().length() == 0) ? null : comments_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._properties.add(map);

         template.addAggr("properties.{comments, name, value}", map.get("comments"), map.get("name"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class log4jPropertiesST implements PropertiesGroupTemplate {

      private java.util.Set<Object> _appenders = new java.util.LinkedHashSet<>();
      private Object _logLevel;
      private java.util.Set<Object> _rootLoggers = new java.util.LinkedHashSet<>();

      private final ST template;

      private log4jPropertiesST(STGroup group) {
   		template = group.getInstanceOf("log4jProperties");
   	}

      public log4jPropertiesST addAppendersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._appenders.add(value);
      	template.add("appenders", value);

         return this;
      }

      public java.util.Set<Object> getAppendersValues() {
      	return this._appenders;
      }

      public log4jPropertiesST setLogLevel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._logLevel == null) {
            this._logLevel = value;
         	template.add("logLevel", value);
         }

      	return this;
      }

      public String getLogLevel() {
      	return (String) this._logLevel;
      }

      public log4jPropertiesST addRootLoggersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._rootLoggers.add(value);
      	template.add("rootLoggers", value);

         return this;
      }

      public java.util.Set<Object> getRootLoggersValues() {
      	return this._rootLoggers;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class consoleAppenderST implements PropertiesGroupTemplate {

      private Object _name;
      private Object _threshold;

      private final ST template;

      private consoleAppenderST(STGroup group) {
   		template = group.getInstanceOf("consoleAppender");
   	}

      public consoleAppenderST setName(Object value) {
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

      public consoleAppenderST setThreshold(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._threshold == null) {
            this._threshold = value;
         	template.add("threshold", value);
         }

      	return this;
      }

      public String getThreshold() {
      	return (String) this._threshold;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "PropertiesGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("fileAppender(maxFileSize,name,threshold,filePath) ::= <<log4j.appender.~name~=org.apache.log4j.RollingFileAppender\n" + 
		"log4j.appender.~name~.file=~filePath~\n" + 
		"log4j.appender.~name~.MaxFileSize=~if(maxFileSize)~~maxFileSize~~else~20MB~endif~\n" + 
		"log4j.appender.~name~.MaxBackupIndex=100\n" + 
		"log4j.appender.~name~.layout=org.apache.log4j.PatternLayout\n" + 
		"log4j.appender.~name~.layout.ConversionPattern=%d{ISO8601} - %-5p- %c - %m%n\n" + 
		"log4j.appender.~name~.Threshold =~if(threshold)~~threshold~~else~INFO~endif~>>\n")
			.append("propertiesFile(properties) ::= <<~properties:{it|~if(it.comments)~\n" + 
		"# ~it.comments~\n" + 
		"~endif~\n" + 
		"~it.name~=~it.value~\n" + 
		"};separator=\"\\n\"~ebean.encryptKeyManager=org.tests.basic.encrypt.BasicEncyptKeyManager>>\n")
			.append("log4jProperties(appenders,logLevel,rootLoggers) ::= <<log4j.rootLogger=~logLevel~~rootLoggers:{it|, ~it~}~\n" + 
		"\n" + 
		"~appenders:{it|\n" + 
		"~it~}~>>\n")
			.append("consoleAppender(name,threshold) ::= <<log4j.appender.~name~=org.apache.log4j.ConsoleAppender\n" + 
		"log4j.appender.~name~.Target=System.out\n" + 
		"log4j.appender.~name~.layout=org.apache.log4j.PatternLayout\n" + 
		"log4j.appender.~name~.layout.ConversionPattern=%d{ISO8601} - %-5p- %c - %m%n\n" + 
		"log4j.appender.~name~.Threshold = ~threshold~>>\n")
		.toString();
}