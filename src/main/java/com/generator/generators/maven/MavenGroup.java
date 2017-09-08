package com.generator.generators.maven;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Maven.stg' file<br/>
 */
public final class MavenGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public MavenGroup() {
		this(new STGroupString(stg));
   }

   public MavenGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public MavenGroup(java.io.File templateFile) {
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

	public interface MavenGroupTemplate {

	}

   public pomST newpom() {
      return new pomST(stGroup);
   }

   public pluginST newplugin() {
      return new pluginST(stGroup);
   }

   public final class pomST implements MavenGroupTemplate {

      private final AtomicBoolean artifactIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dependenciesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packagingIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pluginIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final ST template;

      private pomST(STGroup group) {
   		template = group.getInstanceOf("pom");
   	}

      public pomST setArtifactId(Object value) {
      	tryToSetStringProperty(template, value, artifactIdIsSet, "artifactId");   
         return this;
      }
      public pomST addDependenciesValue(Object artifactId_, Object groupId_, Object scope_, Object version_) {
         dependenciesIsSet.set(true);
         template.addAggr("dependencies.{artifactId, groupId, scope, version}", ( (artifactId_==null || artifactId_.toString().length()==0) ? null : artifactId_), ( (groupId_==null || groupId_.toString().length()==0) ? null : groupId_), ( (scope_==null || scope_.toString().length()==0) ? null : scope_), ( (version_==null || version_.toString().length()==0) ? null : version_));
         return this;
      }
      public pomST setGroupId(Object value) {
      	tryToSetStringProperty(template, value, groupIdIsSet, "groupId");   
         return this;
      }
      public pomST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public pomST setPackaging(Object value) {
      	tryToSetStringProperty(template, value, packagingIsSet, "packaging");   
         return this;
      }
      public pomST addPluginValue(Object value) {
      	tryToSetListProperty(template, value, pluginIsSet, "plugin");
         return this;
      }
      public pomST setVersion(Object value) {
      	tryToSetStringProperty(template, value, versionIsSet, "version");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class pluginST implements MavenGroupTemplate {

      private final AtomicBoolean configurationIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean artifactIdIsSet = new AtomicBoolean(false);
      private final ST template;

      private pluginST(STGroup group) {
   		template = group.getInstanceOf("plugin");
   	}

      public pluginST addConfigurationValue(Object value_, Object name_) {
         configurationIsSet.set(true);
         template.addAggr("configuration.{value, name}", ( (value_==null || value_.toString().length()==0) ? null : value_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
      public pluginST setGroupId(Object value) {
      	tryToSetStringProperty(template, value, groupIdIsSet, "groupId");   
         return this;
      }
      public pluginST setVersion(Object value) {
      	tryToSetStringProperty(template, value, versionIsSet, "version");   
         return this;
      }
      public pluginST setArtifactId(Object value) {
      	tryToSetStringProperty(template, value, artifactIdIsSet, "artifactId");   
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "MavenGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = "delimiters \"~\", \"~\"\n" + 
	"\n" + 
	"eom() ::= <<}>>\n" + 
	"\n" + 
	"gt() ::= <<> >>\n" + 
	"\n" + 
	"pom(artifactId,dependencies,groupId,name,packaging,plugin,version) ::= <<<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
	"<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" + 
	"    \n" + 
	"	<modelVersion>4.0.0</modelVersion>\n" + 
	"\n" + 
	"   <groupId>~groupId~</groupId>\n" + 
	"   <artifactId>~artifactId~</artifactId>\n" + 
	"   <version>~version~</version>\n" + 
	"   <packaging>~packaging~</packaging>\n" + 
	"   <name>~name~</name>\n" + 
	"\n" + 
	"   <scm>\n" + 
	"   	<connection>scm:svn:https://mobius.lan/svn/trailer_report/branches/tr-1.0.x</connection>\n" + 
	"   </scm>\n" + 
	"\n" + 
	"   <properties>\n" + 
	"   	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n" + 
	"      <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n" + 
	"      <maven.compiler.source>1.7</maven.compiler.source>\n" + 
	"      <maven.compiler.target>1.7</maven.compiler.target>\n" + 
	"	</properties>\n" + 
	"\n" + 
	"   <build>\n" + 
	"   	<plugins>\n" + 
	"			~plugin:{it|~it~};separator=\"\\n\"~\n" + 
	"   	</plugins>\n" + 
	"   </build>\n" + 
	"\n" + 
	"   <dependencies>\n" + 
	"		~dependencies:{it|\n" + 
	"<dependency>\n" + 
	"	<groupId>~it.groupId~</groupId>\n" + 
	"   <artifactId>~it.artifactId~</artifactId>\n" + 
	"   <version>~it.version~</version>~if(it.scope)~\n" + 
	"   <scope>~it.scope~</scope>\n" + 
	"~endif~\n" + 
	"</dependency>};separator=\"\\n\"~  \n" + 
	"    </dependencies>\n" + 
	"\n" + 
	"    <distributionManagement>\n" + 
	"        <repository>\n" + 
	"            <id>UCSInternal</id>\n" + 
	"            <name>UCSInternal</name>\n" + 
	"            <url>https://mobius.lan/nexus/content/repositories/releases/</url>\n" + 
	"        </repository>\n" + 
	"        <snapshotRepository>\n" + 
	"            <id>UCSInternal</id>\n" + 
	"            <name>UCSInternal</name>\n" + 
	"            <url>https://mobius.lan/nexus/content/repositories/snapshots/</url>\n" + 
	"        </snapshotRepository>\n" + 
	"    </distributionManagement>\n" + 
	"\n" + 
	"    <repositories>\n" + 
	"        <repository>\n" + 
	"            <id>UCSRepository</id>\n" + 
	"            <url>https://mobius.lan/nexus/content/groups/accord/</url>\n" + 
	"        </repository>\n" + 
	"\n" + 
	"        <repository>\n" + 
	"            <id>mavenCentral</id>\n" + 
	"            <name>retarded</name>\n" + 
	"            <url>http://repo1.maven.org/maven2/</url>\n" + 
	"        </repository>\n" + 
	"    </repositories>\n" + 
	"</project>\n" + 
	">>\n" + 
	"\n" + 
	"plugin(configuration,groupId,version,artifactId) ::= <<<plugin>\n" + 
	"	<groupId>~groupId~</groupId>\n" + 
	"   <artifactId>~artifactId~</artifactId>\n" + 
	"   <version>~version~</version>\n" + 
	"   <configuration>\n" + 
	"   		~configuration:{it|<~it.name~>~it.value~</~it.name~>};separator=\"\\n\"~\n" + 
	"	</configuration>\n" + 
	"</plugin>\n" + 
	">>\n" + 
	"\n" + 
	"";
}