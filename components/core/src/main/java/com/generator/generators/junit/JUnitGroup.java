package com.generator.generators.junit;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'JUnit.stg' file<br/>
 */
public final class JUnitGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public JUnitGroup() {
		this(new STGroupString(stg));
   }

   public JUnitGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public JUnitGroup(java.io.File templateFile) {
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

	public interface JUnitGroupTemplate {

	}

   public SuiteST newSuite() {
      return new SuiteST(stGroup);
   }

   public TestClassST newTestClass() {
      return new TestClassST(stGroup);
   }

   public mvnST newmvn() {
      return new mvnST(stGroup);
   }

   public static final class SuiteST implements JUnitGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _classes = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;

      private final ST template;

      private SuiteST(STGroup group) {
   		template = group.getInstanceOf("Suite");
   	}

      public SuiteST addClassesValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._classes.add(map);

         template.addAggr("classes.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getClasses() {
      	return this._classes;
      }

      public SuiteST setName(Object value) {
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

      public SuiteST setPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._package == null) {
            this._package = value;
         	template.add("package", value);
         }

      	return this;
      }

      public String getPackage() {
      	return (String) this._package;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class TestClassST implements JUnitGroupTemplate {

   	public enum MethodSorter {
   		NAME_ASCENDING, DEFAULT, JVM
   	}

      private java.util.Set<java.util.Map<String, Object>> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private Object _methodSorter;

      private final ST template;

      private TestClassST(STGroup group) {
   		template = group.getInstanceOf("TestClass");
   	}

      public TestClassST addMethodsValue(Object body_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("body", (body_ == null || body_.toString().length() == 0) ? null : body_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._methods.add(map);

         template.addAggr("methods.{body, name}", map.get("body"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getMethods() {
      	return this._methods;
      }

      public TestClassST setName(Object value) {
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

      public TestClassST setPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._package == null) {
            this._package = value;
         	template.add("package", value);
         }

      	return this;
      }

      public String getPackage() {
      	return (String) this._package;
      }

      public TestClassST setMethodSorter(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._methodSorter == null) {
            this._methodSorter = value;
         	template.add("methodSorter", value);
         }

      	return this;
      }

      public String getMethodSorter() {
      	return (String) this._methodSorter;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class mvnST implements JUnitGroupTemplate {



      private final ST template;

      private mvnST(STGroup group) {
   		template = group.getInstanceOf("mvn");
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "JUnitGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("Suite(classes,name,package) ::= <<package ~package~;\n" + 
		"\n" + 
		"import org.junit.runner.RunWith;\n" + 
		"import org.junit.runners.Suite;\n" + 
		"\n" + 
		"@RunWith(Suite.class)\n" + 
		"@Suite.SuiteClasses({ \n" + 
		"	~classes:{it|~it.name~.class};separator=\",\\n\"~\n" + 
		"})\n" + 
		"\n" + 
		"public class ~name~ {\n" + 
		"}>>\n")
			.append("TestClass(methods,name,package,methodSorter) ::= <<package ~package~;\n" + 
		"\n" + 
		"import org.junit.Test;\n" + 
		"\n" + 
		"~if(methodSorter)~@org.junit.FixMethodOrder(org.junit.runners.MethodSorters.~methodSorter~)~endif~\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"~methods:{it|\n" + 
		"	@Test\n" + 
		"	public void ~it.name~() throws Exception {\n" + 
		"   	~it.body~\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("mvn() ::= <<<!-- https://mvnrepository.com/artifact/junit/junit -->\n" + 
		"<dependency>\n" + 
		"    <groupId>junit</groupId>\n" + 
		"    <artifactId>junit</artifactId>\n" + 
		"    <version>4.12</version>\n" + 
		"    <scope>test</scope>\n" + 
		"</dependency> >>\n")
		.toString();
}