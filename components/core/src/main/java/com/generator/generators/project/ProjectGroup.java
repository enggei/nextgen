package com.generator.generators.project;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Project.stg' file<br/>
 */
public final class ProjectGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public ProjectGroup() {
		this(new STGroupString(stg));
   }

   public ProjectGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public ProjectGroup(java.io.File templateFile) {
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

	public interface ProjectGroupTemplate {

	}

   public ProjectST newProject() {
      return new ProjectST(stGroup);
   }

   public final class ProjectST implements ProjectGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _DIRECTORY = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _generators = new java.util.LinkedHashSet<>();
      private Object _version;
      private Object _artifactId;
      private Object _groupId;
      private Object _root;
      private Object _comments;
      private Object _name;
      private Object _packageName;

      private final ST template;

      private ProjectST(STGroup group) {
   		template = group.getInstanceOf("Project");
   	}

      public ProjectST addDIRECTORYValue(Object name_, Object path_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("path", (path_ == null || path_.toString().length() == 0) ? null : path_);
      	this._DIRECTORY.add(map);

         template.addAggr("DIRECTORY.{name, path}", map.get("name"), map.get("path"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getDIRECTORY() {
      	return this._DIRECTORY;
      }

      public ProjectST addGeneratorsValue(Object name_, Object packageName_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("packageName", (packageName_ == null || packageName_.toString().length() == 0) ? null : packageName_);
      	this._generators.add(map);

         template.addAggr("generators.{name, packageName}", map.get("name"), map.get("packageName"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getGenerators() {
      	return this._generators;
      }

      public ProjectST setVersion(Object value) {
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

      public ProjectST setArtifactId(Object value) {
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

      public ProjectST setGroupId(Object value) {
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

      public ProjectST setRoot(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._root == null) {
            this._root = value;
         	template.add("root", value);
         }

      	return this;
      }

      public String getRoot() {
      	return (String) this._root;
      }

      public ProjectST setComments(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._comments == null) {
            this._comments = value;
         	template.add("comments", value);
         }

      	return this;
      }

      public String getComments() {
      	return (String) this._comments;
      }

      public ProjectST setName(Object value) {
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

      public ProjectST setPackageName(Object value) {
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "ProjectGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("Project(DIRECTORY,generators,version,artifactId,groupId,root,comments,name,packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import java.io.BufferedWriter;\n" + 
		"import java.io.File;\n" + 
		"import java.io.FileWriter;\n" + 
		"import java.io.IOException;\n" + 
		"\n" + 
		"/**\n" + 
		" * ~comments~\n" + 
		" */\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"	protected final String version = \"~version~\";\n" + 
		"   protected final String groupId = \"~groupId~\";\n" + 
		"   protected final String artifactId = \"~artifactId~\";\n" + 
		"\n" + 
		"   protected final File root = new File(\"~root~\");\n" + 
		"   protected final File javaSource = new File(root, \"src/main/java\");\n" + 
		"   protected final File resources = new File(root, \"src/main/resources\");\n" + 
		"\n" + 
		"   protected final File webRoot = new File(root, \"web\");\n" + 
		"   protected final File webApp = new File(webRoot, \"app\");\n" + 
		"   protected final File webLib = new File(webRoot, \"lib\");\n" + 
		"\n" + 
		"	~generators:{it|protected ~it.packageName~.~it.name~Group ~it.name;format=\"lowFirst\"~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	@org.junit.Before\n" + 
		"   public void setupGenerators() {\n" + 
		"		~generators:{it|~it.name;format=\"lowFirst\"~ = new ~it.packageName~.~it.name~Group();};separator=\"\\n\"~\n" + 
		"   }\n" + 
		"\n" + 
		"	protected void write(Object content, File file) throws IOException {\n" + 
		"\n" + 
		"      if (!file.exists()) {\n" + 
		"\n" + 
		"         final File dir = file.getParentFile();\n" + 
		"         if (dir == null) throw new RuntimeException(\"File cannot be null\");\n" + 
		"\n" + 
		"         if (!dir.exists()) {\n" + 
		"            if (dir.getParentFile() != null && !dir.getParentFile().exists() && !dir.getParentFile().mkdirs())\n" + 
		"               throw new RuntimeException(\"Could not create parent dirs for \" + dir.getAbsolutePath());\n" + 
		"            if (!dir.mkdir()) throw new RuntimeException(\"Could not create directory \" + dir.getName());\n" + 
		"         }\n" + 
		"\n" + 
		"         try {\n" + 
		"            if (!file.createNewFile()) throw new RuntimeException(\"Could not create file \" + file.getName());\n" + 
		"         } catch (IOException e) {\n" + 
		"            throw new RuntimeException(\"Could not create file \" + file.getName());\n" + 
		"         }\n" + 
		"      }\n" + 
		"\n" + 
		"      final BufferedWriter out = new BufferedWriter(new FileWriter(file));\n" + 
		"      out.write(content.toString());\n" + 
		"      out.close();\n" + 
		"   }\n" + 
		"}>>\n")
		.toString();
}