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

   public static final class ProjectST implements ProjectGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _generators = new java.util.LinkedHashSet<>();
      private Object _version;
      private Object _artifactId;
      private Object _groupId;
      private Object _comments;
      private Object _name;
      private Object _packageName;
      private Object _configPath;
      private Object _description;
      private Object _verticleTests;

      private final ST template;

      private ProjectST(STGroup group) {
   		template = group.getInstanceOf("Project");
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

      public ProjectST setConfigPath(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._configPath == null) {
            this._configPath = value;
         	template.add("configPath", value);
         }

      	return this;
      }

      public String getConfigPath() {
      	return (String) this._configPath;
      }

      public ProjectST setDescription(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._description == null) {
            this._description = value;
         	template.add("description", value);
         }

      	return this;
      }

      public String getDescription() {
      	return (String) this._description;
      }

      public ProjectST setVerticleTests(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._verticleTests == null) {
            this._verticleTests = value;
         	template.add("verticleTests", value);
         }

      	return this;
      }

      public String getVerticleTests() {
      	return (String) this._verticleTests;
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
			.append("Project(generators,version,artifactId,groupId,comments,name,packageName,configPath,description,verticleTests) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.generator.util.GeneratedFile;\n" + 
		"import com.generator.generators.vertx.VertxGroup;\n" + 
		"import com.generator.util.FileUtil;\n" + 
		"import org.zeroturnaround.exec.ProcessExecutor;\n" + 
		"import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;\n" + 
		"\n" + 
		"import java.io.File;\n" + 
		"import java.io.IOException;\n" + 
		"import java.util.Map;\n" + 
		"import java.util.Set;\n" + 
		"import java.util.concurrent.TimeoutException;\n" + 
		"\n" + 
		"/**\n" + 
		" * ~comments~\n" + 
		" */\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"	protected final String name = \"~name~\";\n" + 
		"	protected final String version = \"~version~\";\n" + 
		"   protected final String groupId = \"~groupId~\";\n" + 
		"   protected final String artifactId = \"~artifactId~\";\n" + 
		"	protected final String description = \"~description~\";\n" + 
		"\n" + 
		"	~generators:{it|protected static final ~it.packageName~.~it.name~ ~it.name;format=\"lowFirst\"~ = new ~it.packageName~.~it.name~();};separator=\"\\n\"~\n" + 
		"\n" + 
		"~if(configPath)~\n" + 
		"	private static final io.vertx.core.json.JsonObject config = new io.vertx.core.json.JsonObject(FileUtil.read(new File(\"~configPath~\")));\n" + 
		"	\n" + 
		"	protected static String config(String key) {\n" + 
		"	   return config.getString(key);\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"\n" + 
		"	protected String asString(String s) {\n" + 
		"      return \"\\\"\" + s + \"\\\"\";\n" + 
		"   }\n" + 
		"\n" + 
		"	protected static void execute(String key, String... command) throws InterruptedException, TimeoutException, IOException {\n" + 
		"		new ProcessExecutor().\n" + 
		"				directory(new File(config(key))).\n" + 
		"				command(command).\n" + 
		"				redirectOutput(Slf4jStream.ofCaller().asInfo()).execute();\n" + 
		"	}\n" + 
		"~if(verticleTests)~\n" + 
		"\n" + 
		"	protected void generateVerticleTest(VertxGroup.VerticleST verticleST, String utilsPackage, String testRoot) throws IOException {\n" + 
		"\n" + 
		"		final String name = verticleST.getName();\n" + 
		"		final String verticleSTPackage = verticleST.getPackage();\n" + 
		"		final Set<Map<String, Object~gt()~> verticleSTIncoming = verticleST.getIncoming();\n" + 
		"		final Set<Map<String, Object~gt()~> verticleSTOutgoing = verticleST.getOutgoing();\n" + 
		"\n" + 
		"		final String testName = \"Base\" + name + \"Test\";\n" + 
		"		final VertxGroup.VerticleTestST verticleTestST = vertxGroup.newVerticleTest().\n" + 
		"				setPackageName(verticleSTPackage).\n" + 
		"				setName(testName).\n" + 
		"				setVerticle(name + \"Impl\").\n" + 
		"				setVertxUtilPackage(utilsPackage);\n" + 
		"\n" + 
		"		for (Map<String, Object> map : verticleSTOutgoing)\n" + 
		"			verticleTestST.addIncomingValue(map.get(\"address\"), map.get(\"name\"));\n" + 
		"\n" + 
		"		for (Map<String, Object> map : verticleSTIncoming)\n" + 
		"			verticleTestST.addOutgoingValue(map.get(\"address\"), map.get(\"name\"));\n" + 
		"\n" + 
		"		GeneratedFile.newJavaFile(testRoot, verticleSTPackage, testName).write(verticleTestST);\n" + 
		"\n" + 
		"		final GeneratedFile testImplementation = GeneratedFile.newJavaFile(testRoot, verticleSTPackage, name + \"Test\");\n" + 
		"		if (!testImplementation.exists())\n" + 
		"			testImplementation.write(javaGroup.newClass().\n" + 
		"					setPackage(verticleSTPackage).\n" + 
		"					setScope(\"public\").\n" + 
		"					setName(name + \"Test\").\n" + 
		"					setExtends(testName));\n" + 
		"	}\n" + 
		"\n" + 
		"	protected void generateNeoVerticleTest(com.generator.generators.neo4j.Neo4jGroup.DomainVerticleST verticleST, String utilsPackage, String testRoot) throws IOException {\n" + 
		"\n" + 
		"		final String name = verticleST.getName();\n" + 
		"		final String verticleSTPackage = verticleST.getPackageName();\n" + 
		"		final Set<Map<String, Object>~gt()~ actions = verticleST.getIncoming();\n" + 
		"\n" + 
		"		final String testName = \"Base\" + name + \"Test\";\n" + 
		"		final VertxGroup.VerticleTestST verticleTestST = vertxGroup.newVerticleTest().\n" + 
		"				setPackageName(verticleSTPackage).\n" + 
		"				setName(testName).\n" + 
		"				setVerticle(name + \"Impl\").\n" + 
		"				setVertxUtilPackage(utilsPackage);\n" + 
		"\n" + 
		"		for (Map<String, Object> map : actions)\n" + 
		"			verticleTestST.addOutgoingValue(map.get(\"address\"), map.get(\"name\"));\n" + 
		"\n" + 
		"		GeneratedFile.newJavaFile(testRoot, verticleSTPackage, testName).write(verticleTestST);\n" + 
		"\n" + 
		"		final GeneratedFile testImplementation = GeneratedFile.newJavaFile(testRoot, verticleSTPackage, name + \"Test\");\n" + 
		"		if (!testImplementation.exists())\n" + 
		"			testImplementation.write(javaGroup.newClass().\n" + 
		"					addImportsValue(utilsPackage + \".ResponseUtil\").\n" + 
		"					addImportsValue(utilsPackage + \".VertxUtil\").\n" + 
		"					addImportsValue(\"io.vertx.core.eventbus.Message\").\n" + 
		"					addImportsValue(\"io.vertx.core.json.JsonObject\").\n" + 
		"					addImportsValue(\"io.vertx.ext.unit.Async\").\n" + 
		"					addImportsValue(\"io.vertx.ext.unit.TestContext\").\n" + 
		"					addImportsValue(\"org.junit.Test\").\n" + 
		"					setPackage(verticleSTPackage).\n" + 
		"					setScope(\"public\").\n" + 
		"					setName(name + \"Test\").\n" + 
		"					setExtends(testName).\n" + 
		"					addMethodsValue(javaGroup.newmethod().\n" + 
		"							addAnnotationsValue(\"Test\").\n" + 
		"							setName(\"test\").\n" + 
		"							setScope(\"public\").\n" + 
		"							addParametersValue(\"context\", \"TestContext\")));\n" + 
		"	}\n" + 
		"\n" + 
		"	protected void generateNeoVerticleTest(VertxGroup.NeoVerticleST verticleST, String utilsPackage, String testRoot) throws IOException {\n" + 
		"\n" + 
		"		final String name = verticleST.getName();\n" + 
		"		final String verticleSTPackage = verticleST.getPackageName();\n" + 
		"		final Set<Map<String, Object~gt()~> actions = verticleST.getActions();\n" + 
		"\n" + 
		"		final String testName = \"Base\" + name + \"Test\";\n" + 
		"		final VertxGroup.VerticleTestST verticleTestST = vertxGroup.newVerticleTest().\n" + 
		"				setPackageName(verticleSTPackage).\n" + 
		"				setName(testName).\n" + 
		"				setVerticle(name + \"Impl\").\n" + 
		"				setVertxUtilPackage(utilsPackage);\n" + 
		"\n" + 
		"		for (Map<String, Object> map : actions)\n" + 
		"			verticleTestST.addOutgoingValue(map.get(\"address\"), map.get(\"name\"));\n" + 
		"\n" + 
		"		GeneratedFile.newJavaFile(testRoot, verticleSTPackage, testName).write(verticleTestST);\n" + 
		"\n" + 
		"		final GeneratedFile testImplementation = GeneratedFile.newJavaFile(testRoot, verticleSTPackage, name + \"Test\");\n" + 
		"		if (!testImplementation.exists())\n" + 
		"			testImplementation.write(javaGroup.newClass().\n" + 
		"					addImportsValue(utilsPackage + \".ResponseUtil\").\n" + 
		"					addImportsValue(utilsPackage + \".VertxUtil\").\n" + 
		"					addImportsValue(\"io.vertx.core.eventbus.Message\").\n" + 
		"					addImportsValue(\"io.vertx.core.json.JsonObject\").\n" + 
		"					addImportsValue(\"io.vertx.ext.unit.Async\").\n" + 
		"					addImportsValue(\"io.vertx.ext.unit.TestContext\").\n" + 
		"					addImportsValue(\"org.junit.Test\").\n" + 
		"					setPackage(verticleSTPackage).\n" + 
		"					setScope(\"public\").\n" + 
		"					setName(name + \"Test\").\n" + 
		"					setExtends(testName).\n" + 
		"					addMethodsValue(javaGroup.newmethod().\n" + 
		"							addAnnotationsValue(\"Test\").\n" + 
		"							setName(\"test\").\n" + 
		"							setScope(\"public\").\n" + 
		"							addParametersValue(\"context\", \"TestContext\")));\n" + 
		"	}\n" + 
		"~endif~\n" + 
		"}>>\n")
		.toString();
}