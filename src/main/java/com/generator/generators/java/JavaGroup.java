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

      private java.util.Set<Object> _eqha = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _lexical = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private BeanST(STGroup group) {
         template = group.getInstanceOf("Bean");
      }

      public BeanST addEqhaValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._eqha.add(value);
         template.add("eqha", value);

         return this;
      }

      public java.util.Set<Object> getEqhaValues() {
         return this._eqha;
      }

      public BeanST addLexicalValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._lexical.add(value);
         template.add("lexical", value);

         return this;
      }

      public java.util.Set<Object> getLexicalValues() {
         return this._lexical;
      }

      public BeanST setName(Object value) {
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

      public BeanST setPackage(Object value) {
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

      public BeanST addPropertiesValue(Object init_, Object name_, Object type_) {
         final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
         map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
         map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
         map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
         this._properties.add(map);

         template.addAggr("properties.{init, name, type}", map.get("init"), map.get("name"), map.get("type"));
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

   public final class PojoST implements JavaGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _classProperties = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _eqha = new java.util.LinkedHashSet<>();
      private Object _extends;
      private java.util.Set<Object> _implement = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _lexical = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private PojoST(STGroup group) {
         template = group.getInstanceOf("Pojo");
      }

      public PojoST addClassPropertiesValue(Object type_, Object init_, Object name_) {
         final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
         map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
         map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
         map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
         this._classProperties.add(map);

         template.addAggr("classProperties.{type, init, name}", map.get("type"), map.get("init"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getClassProperties() {
         return this._classProperties;
      }

      public PojoST addEqhaValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._eqha.add(value);
         template.add("eqha", value);

         return this;
      }

      public java.util.Set<Object> getEqhaValues() {
         return this._eqha;
      }

      public PojoST setExtends(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         if (this._extends == null) {
            this._extends = value;
            template.add("extends", value);
         }

         return this;
      }

      public String getExtends() {
         return (String) this._extends;
      }

      public PojoST addImplementValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._implement.add(value);
         template.add("implement", value);

         return this;
      }

      public java.util.Set<Object> getImplementValues() {
         return this._implement;
      }

      public PojoST addLexicalValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._lexical.add(value);
         template.add("lexical", value);

         return this;
      }

      public java.util.Set<Object> getLexicalValues() {
         return this._lexical;
      }

      public PojoST addMethodsValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._methods.add(value);
         template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
         return this._methods;
      }

      public PojoST setName(Object value) {
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

      public PojoST setPackage(Object value) {
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

      public PojoST addPropertiesValue(Object init_, Object type_, Object name_) {
         final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
         map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
         map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
         map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
         this._properties.add(map);

         template.addAggr("properties.{init, type, name}", map.get("init"), map.get("type"), map.get("name"));
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

   public final class methodST implements JavaGroupTemplate {

      private java.util.Set<Object> _annotations = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _parameters = new java.util.LinkedHashSet<>();
      private Object _returnValue;
      private Object _scope;
      private java.util.Set<Object> _statements = new java.util.LinkedHashSet<>();

      private final ST template;

      private methodST(STGroup group) {
         template = group.getInstanceOf("method");
      }

      public methodST addAnnotationsValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._annotations.add(value);
         template.add("annotations", value);

         return this;
      }

      public java.util.Set<Object> getAnnotationsValues() {
         return this._annotations;
      }

      public methodST setName(Object value) {
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

      public methodST addParametersValue(Object name_, Object type_) {
         final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
         map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
         map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
         this._parameters.add(map);

         template.addAggr("parameters.{name, type}", map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getParameters() {
         return this._parameters;
      }

      public methodST setReturnValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         if (this._returnValue == null) {
            this._returnValue = value;
            template.add("returnValue", value);
         }

         return this;
      }

      public String getReturnValue() {
         return (String) this._returnValue;
      }

      public methodST setScope(Object value) {
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

      public methodST addStatementsValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._statements.add(value);
         template.add("statements", value);

         return this;
      }

      public java.util.Set<Object> getStatementsValues() {
         return this._statements;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class EnumST implements JavaGroupTemplate {

      private Object _name;
      private Object _package;
      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private EnumST(STGroup group) {
         template = group.getInstanceOf("Enum");
      }

      public EnumST setName(Object value) {
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

      public EnumST setPackage(Object value) {
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

      public EnumST addValuesValue(Object value) {
         if (value == null || value.toString().length() == 0)
            return this;

         this._values.add(value);
         template.add("values", value);

         return this;
      }

      public java.util.Set<Object> getValuesValues() {
         return this._values;
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
               else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts"))
                  return s.substring(0, s.length() - 1);
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

   private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
         .append("eom() ::= <<}>>\n")
         .append("gt() ::= \">\"\n")
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
               "}>>\n")
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
               "      this.~it.name~ = ~it.name~;\n" +
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
               "}>>\n")
         .append("method(annotations,name,parameters,returnValue,scope,statements) ::= <<~annotations:{it|@~it~};separator=\"\\n\"~\n" +
               "~if(scope)~~scope~ ~else~~endif~~if(returnValue)~~returnValue~ ~else~void ~endif~~name~(~parameters:{it|~it.type~ ~it.name~};separator=\",\"~) {\n" +
               "	~statements:{it|~it~};separator=\"\\n\"~\n" +
               "}>>\n")
         .append("Enum(name,package,values) ::= <<package ~package~;\n" +
               "\n" +
               "public enum ~name~ {\n" +
               "   ~values:{it|~it~};separator=\", \"~\n" +
               "}>>\n")
         .toString();
}