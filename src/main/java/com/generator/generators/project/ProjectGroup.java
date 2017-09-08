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

      private final AtomicBoolean generatorsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final AtomicBoolean artifactIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean rootIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final ST template;

      private ProjectST(STGroup group) {
   		template = group.getInstanceOf("Project");
   	}

      public ProjectST addGeneratorsValue(Object name_, Object packageName_) {
         generatorsIsSet.set(true);
         template.addAggr("generators.{name, packageName}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (packageName_==null || packageName_.toString().length()==0) ? null : packageName_));
         return this;
      }
      public ProjectST setVersion(Object value) {
      	tryToSetStringProperty(template, value, versionIsSet, "version");   
         return this;
      }
      public ProjectST setArtifactId(Object value) {
      	tryToSetStringProperty(template, value, artifactIdIsSet, "artifactId");   
         return this;
      }
      public ProjectST setGroupId(Object value) {
      	tryToSetStringProperty(template, value, groupIdIsSet, "groupId");   
         return this;
      }
      public ProjectST setRoot(Object value) {
      	tryToSetStringProperty(template, value, rootIsSet, "root");   
         return this;
      }
      public ProjectST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      }
      public ProjectST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public ProjectST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "ProjectGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = "delimiters \"~\", \"~\"\n" + 
	"\n" + 
	"eom() ::= <<}>>\n" + 
	"\n" + 
	"gt() ::= <<> >>\n" + 
	"\n" + 
	"Project(generators,version,artifactId,groupId,root,comments,name,packageName) ::= <<package ~packageName~;\n" + 
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
	"}\n" + 
	">>\n" + 
	"\n" + 
	"";
}