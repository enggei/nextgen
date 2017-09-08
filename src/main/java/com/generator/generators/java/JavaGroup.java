package com.generator.generators.java;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'java.stg' file<br/>
 */
public final class JavaGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public JavaGroup() {
		this(new STGroupString(stg));
   }

   public JavaGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public JavaGroup(java.io.File templateFile) {
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

	public interface JavaGroupTemplate {

	}

   public BeanST newBean() {
      return new BeanST(stGroup);
   } 

   public PojoST newPojo() {
      return new PojoST(stGroup);
   } 

   public methodST newmethod() {
      return new methodST(stGroup);
   } 

   public EnumST newEnum() {
      return new EnumST(stGroup);
   } 

   public final class BeanST implements JavaGroupTemplate {

      private final AtomicBoolean eqhaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean lexicalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private BeanST(STGroup group) {
   		template = group.getInstanceOf("Bean");
   	}

      public BeanST addEqhaValue(Object value) {
      	tryToSetListProperty(template, value, eqhaIsSet, "eqha");
         return this;
      } 
      public BeanST addLexicalValue(Object value) {
      	tryToSetListProperty(template, value, lexicalIsSet, "lexical");
         return this;
      } 
      public BeanST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public BeanST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public BeanST addPropertiesValue(Object init_, Object name_, Object type_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{init, name, type}", ( (init_==null || init_.toString().length()==0) ? null : init_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class PojoST implements JavaGroupTemplate {

      private final AtomicBoolean classPropertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean eqhaIsSet = new AtomicBoolean(false);
      private final AtomicBoolean extendsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean implementIsSet = new AtomicBoolean(false);
      private final AtomicBoolean lexicalIsSet = new AtomicBoolean(false);
      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private PojoST(STGroup group) {
   		template = group.getInstanceOf("Pojo");
   	}

      public PojoST addClassPropertiesValue(Object type_, Object init_, Object name_) {
         classPropertiesIsSet.set(true);
         template.addAggr("classProperties.{type, init, name}", ( (type_==null || type_.toString().length()==0) ? null : type_), ( (init_==null || init_.toString().length()==0) ? null : init_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      } 
      public PojoST addEqhaValue(Object value) {
      	tryToSetListProperty(template, value, eqhaIsSet, "eqha");
         return this;
      } 
      public PojoST setExtends(Object value) {
      	tryToSetStringProperty(template, value, extendsIsSet, "extends");   
         return this;
      } 
      public PojoST addImplementValue(Object value) {
      	tryToSetListProperty(template, value, implementIsSet, "implement");
         return this;
      } 
      public PojoST addLexicalValue(Object value) {
      	tryToSetListProperty(template, value, lexicalIsSet, "lexical");
         return this;
      } 
      public PojoST addMethodsValue(Object value) {
      	tryToSetListProperty(template, value, methodsIsSet, "methods");
         return this;
      } 
      public PojoST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public PojoST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public PojoST addPropertiesValue(Object init_, Object type_, Object name_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{init, type, name}", ( (init_==null || init_.toString().length()==0) ? null : init_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class methodST implements JavaGroupTemplate {

      private final AtomicBoolean annotationsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parametersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private methodST(STGroup group) {
   		template = group.getInstanceOf("method");
   	}

      public methodST addAnnotationsValue(Object value) {
      	tryToSetListProperty(template, value, annotationsIsSet, "annotations");
         return this;
      } 
      public methodST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public methodST addParametersValue(Object name_, Object type_) {
         parametersIsSet.set(true);
         template.addAggr("parameters.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      } 
      public methodST setReturnValue(Object value) {
      	tryToSetStringProperty(template, value, returnValueIsSet, "returnValue");   
         return this;
      } 
      public methodST setScope(Object value) {
      	tryToSetStringProperty(template, value, scopeIsSet, "scope");   
         return this;
      } 
      public methodST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class EnumST implements JavaGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private EnumST(STGroup group) {
   		template = group.getInstanceOf("Enum");
   	}

      public EnumST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public EnumST setPackage(Object value) {
      	tryToSetStringProperty(template, value, packageIsSet, "package");   
         return this;
      } 
      public EnumST addValuesValue(Object value) {
      	tryToSetListProperty(template, value, valuesIsSet, "values");
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "JavaGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
		.append("Bean(eqha,lexical,name,package,properties) ::= <<package ~package~;\n" + 
	"\n" + 
	"public class ~name~ {\n" + 
	"\n" + 
	"   ~properties:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
	"\n" + 
	"	public ~name~() {\n" + 
	"	}\n" + 
	"\n" + 
	"	public ~name~(~properties:{it|~it.type~ ~it.name~};separator=\",\"~) {\n" + 
	"		~properties:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
	"	}\n" + 
	"\n" + 
	"~properties:{it|\n" + 
	"	public ~it.type~ get~it.name;format=\"capitalize\"~() {\n" + 
	"		return ~it.name~;\n" + 
	"	~eom()~\n" + 
	"\n" + 
	"	public void set~it.name;format=\"capitalize\"~(~it.type~ ~it.name~) {\n" + 
	"   	this.~it.name~ = ~it.name~;\n" + 
	"	~eom()~\n" + 
	"};separator=\"\\n\"~\n" + 
	"~if(eqha)~\n" + 
	"	@Override\n" + 
	"	public boolean equals(Object o) {\n" + 
	"   	if(this==o) return true;\n" + 
	"	   if(o==null||getClass()!=o.getClass()) return false;\n" + 
	"	   ~name~ that = (~name~) o;\n" + 
	"	   ~eqha:{it | if(~it~!=null ? !~it~.equals(that.~it~) : that.~it~!=null) return false;~\\n~}~		return true;\n" + 
	"	}\n" + 
	"\n" + 
	"	@Override\n" + 
	"	public int hashCode() {\n" + 
	"   	int result;\n" + 
	"	   result = ~first(eqha):{it | (~it~!=null ? ~it~.hashCode() : 0)}~;\n" + 
	"	   ~rest(eqha):{it | result = 31*result+(~it~!=null ? ~it~.hashCode() : 0);~\\n~}~      return result;\n" + 
	"	}\n" + 
	"	\n" + 
	"~endif~\n" + 
	"~if(lexical)~\n" + 
	"	@Override\n" + 
	"   public String toString() {\n" + 
	"       return ~lexical:{it|\"~it~=\" + ~it~ };separator=\" + \\\" \\\" + \"~;\n" + 
	"   }\n" + 
	"~endif~\n" + 
	"} >>\n")
		.append("Pojo(classProperties,eqha,extends,implement,lexical,methods,name,package,properties) ::= <<package ~package~;\n" + 
	"\n" + 
	"public class ~name~~if(extends)~ extends ~extends~~endif~~if(implement)~ implements ~implement:{it|~it~};separator=\", \"~~endif~ {\n" + 
	"~if(classProperties)~\n" + 
	"	\n" + 
	"	~classProperties:{it|private static final ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"~if(properties)~\n" + 
	"\n" + 
	"	~properties:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
	"~endif~\n" + 
	"\n" + 
	"	public ~name~() {\n" + 
	"	}\n" + 
	"~if(properties)~\n" + 
	"\n" + 
	"	public ~name~(~properties:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
	"		~properties:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
	"	}\n" + 
	"~endif~\n" + 
	"\n" + 
	"~properties:{it|\n" + 
	"	public ~it.type~ get~it.name;format=\"capitalize\"~() {\n" + 
	"		return ~it.name~;\n" + 
	"	~eom()~\n" + 
	"\n" + 
	"	public void set~it.name;format=\"capitalize\"~(~it.type~ ~it.name~) {\n" + 
	"   	this.~it.name~ = ~it.name~;\n" + 
	"	~eom()~\n" + 
	"};separator=\"\\n\"~\n" + 
	"~if(methods)~\n" + 
	"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
	"\n" + 
	"~endif~\n" + 
	"~if(eqha)~\n" + 
	"	@Override\n" + 
	"	public boolean equals(Object o) {\n" + 
	"   	if (this == o) return true;\n" + 
	"	   if (o == null || !(o instanceof ~name~)) return false;\n" + 
	"	   ~name~ that = (~name~) o;\n" + 
	"	   ~eqha:{it | if (~it~ != null ? !~it~.equals(that.~it~) : that.~it~ != null) return false;~\\n~}~		return true;\n" + 
	"	}\n" + 
	"\n" + 
	"	@Override\n" + 
	"	public int hashCode() {\n" + 
	"   	int result;\n" + 
	"	   result = ~first(eqha):{it | (~it~ !=null ? ~it~.hashCode() : 0)}~;\n" + 
	"	   ~rest(eqha):{it | result = 31*result+(~it~ != null ? ~it~.hashCode() : 0);~\\n~}~      return result;\n" + 
	"	}\n" + 
	"	\n" + 
	"~endif~\n" + 
	"~if(lexical)~\n" + 
	"	@Override\n" + 
	"   public String toString() {\n" + 
	"       return ~lexical:{it|\"~it~=\" + ~it~ };separator=\" + \\\" \\\" + \"~;\n" + 
	"   }\n" + 
	"~endif~\n" + 
	"\n" + 
	"} >>\n")
		.append("method(annotations,name,parameters,returnValue,scope,statements) ::= <<~annotations:{it|@~it~};separator=\"\\n\"~\n" + 
	"~if(scope)~~scope~ ~else~~endif~~if(returnValue)~~returnValue~ ~else~void ~endif~~name~(~parameters:{it|~it.type~ ~it.name~};separator=\",\"~) {\n" + 
	"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
	"} >>\n")
		.append("Enum(name,package,values) ::= <<package ~package~;\n" + 
	"\n" + 
	"public enum ~name~ {\n" + 
	"   ~values:{it|~it~};separator=\", \"~\n" + 
	"} >>\n").toString();
} 