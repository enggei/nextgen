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

   public PomST newPom() {
      return new PomST(stGroup);
   }

   public pluginST newplugin() {
      return new pluginST(stGroup);
   }

   public executionST newexecution() {
      return new executionST(stGroup);
   }

   public dependencyST newdependency() {
      return new dependencyST(stGroup);
   }

   public buildST newbuild() {
      return new buildST(stGroup);
   }

   public testResourceST newtestResource() {
      return new testResourceST(stGroup);
   }

   public final class PomST implements MavenGroupTemplate {

      private Object _artifactId;
      private Object _groupId;
      private Object _name;
      private Object _packaging;
      private Object _version;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _dependencies = new java.util.LinkedHashSet<>();
      private Object _baseBuild;

      private final ST template;

      private PomST(STGroup group) {
   		template = group.getInstanceOf("Pom");
   	}

      public PomST setArtifactId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._artifactId == null) {
            this._artifactId = value;
         	template.add("artifactId", value);
         }

      	return this;
      }

      public String getArtifactId() {
      	return (String) this._artifactId;
      }

      public PomST setGroupId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._groupId == null) {
            this._groupId = value;
         	template.add("groupId", value);
         }

      	return this;
      }

      public String getGroupId() {
      	return (String) this._groupId;
      }

      public PomST setName(Object value) {
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

      public PomST setPackaging(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._packaging == null) {
            this._packaging = value;
         	template.add("packaging", value);
         }

      	return this;
      }

      public String getPackaging() {
      	return (String) this._packaging;
      }

      public PomST setVersion(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._version == null) {
            this._version = value;
         	template.add("version", value);
         }

      	return this;
      }

      public String getVersion() {
      	return (String) this._version;
      }

      public PomST addPropertiesValue(Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._properties.add(map);

         template.addAggr("properties.{name, value}", map.get("name"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public PomST addDependenciesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._dependencies.add(value);
      	template.add("dependencies", value);

         return this;
      }

      public java.util.Set<Object> getDependenciesValues() {
      	return this._dependencies;
      }

      public PomST setBaseBuild(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._baseBuild == null) {
            this._baseBuild = value;
         	template.add("baseBuild", value);
         }

      	return this;
      }

      public String getBaseBuild() {
      	return (String) this._baseBuild;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class pluginST implements MavenGroupTemplate {

      private Object _groupId;
      private Object _version;
      private Object _artifactId;
      private java.util.Set<java.util.Map<String, Object>> _configuration = new java.util.LinkedHashSet<>();

      private final ST template;

      private pluginST(STGroup group) {
   		template = group.getInstanceOf("plugin");
   	}

      public pluginST setGroupId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._groupId == null) {
            this._groupId = value;
         	template.add("groupId", value);
         }

      	return this;
      }

      public String getGroupId() {
      	return (String) this._groupId;
      }

      public pluginST setVersion(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._version == null) {
            this._version = value;
         	template.add("version", value);
         }

      	return this;
      }

      public String getVersion() {
      	return (String) this._version;
      }

      public pluginST setArtifactId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._artifactId == null) {
            this._artifactId = value;
         	template.add("artifactId", value);
         }

      	return this;
      }

      public String getArtifactId() {
      	return (String) this._artifactId;
      }

      public pluginST addConfigurationValue(Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._configuration.add(map);

         template.addAggr("configuration.{name, value}", map.get("name"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getConfiguration() {
      	return this._configuration;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class executionST implements MavenGroupTemplate {

      private java.util.Set<Object> _goals = new java.util.LinkedHashSet<>();
      private Object _id;
      private Object _inherited;
      private Object _phase;
      private java.util.Set<Object> _tasks = new java.util.LinkedHashSet<>();

      private final ST template;

      private executionST(STGroup group) {
   		template = group.getInstanceOf("execution");
   	}

      public executionST addGoalsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._goals.add(value);
      	template.add("goals", value);

         return this;
      }

      public java.util.Set<Object> getGoalsValues() {
      	return this._goals;
      }

      public executionST setId(Object value) {
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

      public executionST setInherited(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._inherited == null) {
            this._inherited = value;
         	template.add("inherited", value);
         }

      	return this;
      }

      public String getInherited() {
      	return (String) this._inherited;
      }

      public executionST setPhase(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._phase == null) {
            this._phase = value;
         	template.add("phase", value);
         }

      	return this;
      }

      public String getPhase() {
      	return (String) this._phase;
      }

      public executionST addTasksValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._tasks.add(value);
      	template.add("tasks", value);

         return this;
      }

      public java.util.Set<Object> getTasksValues() {
      	return this._tasks;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class dependencyST implements MavenGroupTemplate {

      private Object _artifactId;
      private Object _groupId;
      private Object _scope;
      private Object _version;

      private final ST template;

      private dependencyST(STGroup group) {
   		template = group.getInstanceOf("dependency");
   	}

      public dependencyST setArtifactId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._artifactId == null) {
            this._artifactId = value;
         	template.add("artifactId", value);
         }

      	return this;
      }

      public String getArtifactId() {
      	return (String) this._artifactId;
      }

      public dependencyST setGroupId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._groupId == null) {
            this._groupId = value;
         	template.add("groupId", value);
         }

      	return this;
      }

      public String getGroupId() {
      	return (String) this._groupId;
      }

      public dependencyST setScope(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._scope == null) {
            this._scope = value;
         	template.add("scope", value);
         }

      	return this;
      }

      public String getScope() {
      	return (String) this._scope;
      }

      public dependencyST setVersion(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._version == null) {
            this._version = value;
         	template.add("version", value);
         }

      	return this;
      }

      public String getVersion() {
      	return (String) this._version;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class buildST implements MavenGroupTemplate {

      private java.util.Set<Object> _plugin = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _testResources = new java.util.LinkedHashSet<>();

      private final ST template;

      private buildST(STGroup group) {
   		template = group.getInstanceOf("build");
   	}

      public buildST addPluginValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._plugin.add(value);
      	template.add("plugin", value);

         return this;
      }

      public java.util.Set<Object> getPluginValues() {
      	return this._plugin;
      }

      public buildST addTestResourcesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._testResources.add(value);
      	template.add("testResources", value);

         return this;
      }

      public java.util.Set<Object> getTestResourcesValues() {
      	return this._testResources;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class testResourceST implements MavenGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _keyValues = new java.util.LinkedHashSet<>();

      private final ST template;

      private testResourceST(STGroup group) {
   		template = group.getInstanceOf("testResource");
   	}

      public testResourceST addKeyValuesValue(Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._keyValues.add(map);

         template.addAggr("keyValues.{name, value}", map.get("name"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getKeyValues() {
      	return this._keyValues;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "MavenGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("Pom(artifactId,groupId,name,packaging,version,properties,dependencies,baseBuild) ::= <<<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
		"<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" + 
		"    \n" + 
		"	<modelVersion>4.0.0</modelVersion>\n" + 
		"\n" + 
		"   <groupId>~groupId~</groupId>\n" + 
		"   <artifactId>~artifactId~</artifactId>\n" + 
		"   <version>~version~</version>\n" + 
		"~if(packaging)~   <packaging>~packaging~</packaging>\n" + 
		"~endif~\n" + 
		"   <name>~name~</name>\n" + 
		"\n" + 
		"   <properties>\n" + 
		"		~properties:{it|<~it.name~>~it.value~</~it.name~>};separator=\"\\n\"~   	\n" + 
		"	</properties>\n" + 
		"~if(baseBuild)~\n" + 
		"\n" + 
		"	~baseBuild~\n" + 
		"\n" + 
		"~endif~\n" + 
		"   <dependencies>\n" + 
		"		~dependencies:{it|~it~};separator=\"\\n\"~  \n" + 
		"   </dependencies>\n" + 
		"\n" + 
		"</project> >>\n")
			.append("plugin(groupId,version,artifactId,configuration) ::= <<<plugin>\n" + 
		"	<groupId>~groupId~</groupId>\n" + 
		"   <artifactId>~artifactId~</artifactId>\n" + 
		"   <version>~version~</version>\n" + 
		"   <configuration>\n" + 
		"   	~configuration:{it|<~it.name~>~it.value~</~it.name~>};separator=\"\\n\"~\n" + 
		"	</configuration>\n" + 
		"</plugin> >>\n")
			.append("execution(goals,id,inherited,phase,tasks) ::= <<<execution>\n" + 
		"	<id>~id~</id>\n" + 
		"   <goals>\n" + 
		"		~goals:{it|<goal>~it~</goal>};separator=\"\\n\"~\n" + 
		"   </goals>\n" + 
		"   <phase>~phase~</phase>\n" + 
		"   <inherited>~inherited~</inherited>\n" + 
		"   <configuration>\n" + 
		"   	<tasks>\n" + 
		"		   ~tasks:{it|~it~};separator=\"\\n\"~\n" + 
		"	   </tasks>\n" + 
		"   </configuration>\n" + 
		"</execution> >>\n")
			.append("dependency(artifactId,groupId,scope,version) ::= <<<dependency>\n" + 
		"	<groupId>~groupId~</groupId>\n" + 
		"   <artifactId>~artifactId~</artifactId>\n" + 
		"   <version>~version~</version>~if(scope)~\n" + 
		"   <scope>~scope~</scope>\n" + 
		"~else~\n" + 
		"~endif~\n" + 
		"</dependency> >>\n")
			.append("build(plugin,testResources) ::= <<<build>\n" + 
		"	<testResources>\n" + 
		"		~testResources:{it|~it~};separator=\"\\n\"~\n" + 
		"	</testResources>\n" + 
		"	<plugins>\n" + 
		"		~plugin:{it|~it~};separator=\"\\n\"~\n" + 
		"   </plugins>\n" + 
		"</build> >>\n")
			.append("testResource(keyValues) ::= <<<testResource>\n" + 
		"   ~keyValues:{it|<~it.name~>~it.value~</~it.name~>};separator=\"\\n\"~\n" + 
		"</testResource> >>\n")
		.toString();
}