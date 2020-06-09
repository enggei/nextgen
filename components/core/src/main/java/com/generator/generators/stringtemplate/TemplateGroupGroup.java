package com.generator.generators.stringtemplate;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'templateGroup.stg' file<br/>
 */
public final class TemplateGroupGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public TemplateGroupGroup() {
		this(new STGroupString(stg));
   }

   public TemplateGroupGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public TemplateGroupGroup(java.io.File templateFile) {
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

	public interface TemplateGroupGroupTemplate {

	}

   public stgST newstg() {
      return new stgST(stGroup);
   }

   public eotST neweot() {
      return new eotST(stGroup);
   }

   public stgBuilderST newstgBuilder() {
      return new stgBuilderST(stGroup);
   }

   public templateST newtemplate() {
      return new templateST(stGroup);
   }

   public GroupClassDeclarationST newGroupClassDeclaration() {
      return new GroupClassDeclarationST(stGroup);
   }

   public AttributeRendererDeclarationST newAttributeRendererDeclaration() {
      return new AttributeRendererDeclarationST(stGroup);
   }

   public StatementKeyValueListPropertySetterST newStatementKeyValueListPropertySetter() {
      return new StatementKeyValueListPropertySetterST(stGroup);
   }

   public NewStatementDeclarationST newNewStatementDeclaration() {
      return new NewStatementDeclarationST(stGroup);
   }

   public StatementListPropertySetterST newStatementListPropertySetter() {
      return new StatementListPropertySetterST(stGroup);
   }

   public StatementStringPropertySetterST newStatementStringPropertySetter() {
      return new StatementStringPropertySetterST(stGroup);
   }

   public TemplateParameterBuilderST newTemplateParameterBuilder() {
      return new TemplateParameterBuilderST(stGroup);
   }

   public enumDeclarationST newenumDeclaration() {
      return new enumDeclarationST(stGroup);
   }

   public static final class stgST implements TemplateGroupGroupTemplate {
      private Object _delimiter;
      private java.util.Set<Object> _templates = new java.util.LinkedHashSet<>();

      private final ST template;

      private stgST(STGroup group) {
   		template = group.getInstanceOf("stg");
   	}

      public stgST setDelimiter(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._delimiter == null) {
            this._delimiter = value;
         	template.add("delimiter", value);
         }

      	return this;
      }

      public String getDelimiter() {
      	return (String) this._delimiter;
      }

      public stgST addTemplatesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._templates.add(value);
      	template.add("templates", value);

         return this;
      }

      public java.util.Set<Object> getTemplatesValues() {
      	return this._templates;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class eotST implements TemplateGroupGroupTemplate {

      private final ST template;

      private eotST(STGroup group) {
   		template = group.getInstanceOf("eot");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class stgBuilderST implements TemplateGroupGroupTemplate {
      private java.util.Set<Object> _appends = new java.util.LinkedHashSet<>();
      private Object _delimiter;

      private final ST template;

      private stgBuilderST(STGroup group) {
   		template = group.getInstanceOf("stgBuilder");
   	}

      public stgBuilderST addAppendsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._appends.add(value);
      	template.add("appends", value);

         return this;
      }

      public java.util.Set<Object> getAppendsValues() {
      	return this._appends;
      }

      public stgBuilderST setDelimiter(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._delimiter == null) {
            this._delimiter = value;
         	template.add("delimiter", value);
         }

      	return this;
      }

      public String getDelimiter() {
      	return (String) this._delimiter;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class templateST implements TemplateGroupGroupTemplate {
      private Object _content;
      private Object _name;
      private java.util.Set<Object> _params = new java.util.LinkedHashSet<>();

      private final ST template;

      private templateST(STGroup group) {
   		template = group.getInstanceOf("template");
   	}

      public templateST setContent(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._content == null) {
            this._content = value;
         	template.add("content", value);
         }

      	return this;
      }

      public String getContent() {
      	return (String) this._content;
      }

      public templateST setName(Object value) {
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

      public templateST addParamsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._params.add(value);
      	template.add("params", value);

         return this;
      }

      public java.util.Set<Object> getParamsValues() {
      	return this._params;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class GroupClassDeclarationST implements TemplateGroupGroupTemplate {
      private Object _domain;
      private Object _name;
      private Object _packageName;
      private java.util.Set<java.util.Map<String, Object>> _statements = new java.util.LinkedHashSet<>();
      private Object _stg;

      private final ST template;

      private GroupClassDeclarationST(STGroup group) {
   		template = group.getInstanceOf("GroupClassDeclaration");
   	}

      public GroupClassDeclarationST setDomain(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._domain == null) {
            this._domain = value;
         	template.add("domain", value);
         }

      	return this;
      }

      public String getDomain() {
      	return (String) this._domain;
      }

      public GroupClassDeclarationST setName(Object value) {
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

      public GroupClassDeclarationST setPackageName(Object value) {
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

      public GroupClassDeclarationST addStatementsValue(Object declaration_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("declaration", (declaration_ == null || declaration_.toString().length() == 0) ? null : declaration_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._statements.add(map);

         template.addAggr("statements.{declaration, name}", map.get("declaration"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getStatements() {
      	return this._statements;
      }

      public GroupClassDeclarationST setStg(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._stg == null) {
            this._stg = value;
         	template.add("stg", value);
         }

      	return this;
      }

      public String getStg() {
      	return (String) this._stg;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class AttributeRendererDeclarationST implements TemplateGroupGroupTemplate {

      private final ST template;

      private AttributeRendererDeclarationST(STGroup group) {
   		template = group.getInstanceOf("AttributeRendererDeclaration");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class StatementKeyValueListPropertySetterST implements TemplateGroupGroupTemplate {
      private java.util.Set<Object> _kvNames = new java.util.LinkedHashSet<>();
      private Object _propertyName;
      private Object _statementName;

      private final ST template;

      private StatementKeyValueListPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementKeyValueListPropertySetter");
   	}

      public StatementKeyValueListPropertySetterST addKvNamesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._kvNames.add(value);
      	template.add("kvNames", value);

         return this;
      }

      public java.util.Set<Object> getKvNamesValues() {
      	return this._kvNames;
      }

      public StatementKeyValueListPropertySetterST setPropertyName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._propertyName == null) {
            this._propertyName = value;
         	template.add("propertyName", value);
         }

      	return this;
      }

      public String getPropertyName() {
      	return (String) this._propertyName;
      }

      public StatementKeyValueListPropertySetterST setStatementName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._statementName == null) {
            this._statementName = value;
         	template.add("statementName", value);
         }

      	return this;
      }

      public String getStatementName() {
      	return (String) this._statementName;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class NewStatementDeclarationST implements TemplateGroupGroupTemplate {
      private Object _groupname;
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _enumDeclarations = new java.util.LinkedHashSet<>();

      private final ST template;

      private NewStatementDeclarationST(STGroup group) {
   		template = group.getInstanceOf("NewStatementDeclaration");
   	}

      public NewStatementDeclarationST setGroupname(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._groupname == null) {
            this._groupname = value;
         	template.add("groupname", value);
         }

      	return this;
      }

      public String getGroupname() {
      	return (String) this._groupname;
      }

      public NewStatementDeclarationST setName(Object value) {
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

      public NewStatementDeclarationST addPropertiesValue(Object name_, Object setter_, Object type_, Object init_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("setter", (setter_ == null || setter_.toString().length() == 0) ? null : setter_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
      	this._properties.add(map);

         template.addAggr("properties.{name, setter, type, init}", map.get("name"), map.get("setter"), map.get("type"), map.get("init"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public NewStatementDeclarationST addEnumDeclarationsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._enumDeclarations.add(value);
      	template.add("enumDeclarations", value);

         return this;
      }

      public java.util.Set<Object> getEnumDeclarationsValues() {
      	return this._enumDeclarations;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class StatementListPropertySetterST implements TemplateGroupGroupTemplate {
      private Object _propertyName;
      private Object _statementName;

      private final ST template;

      private StatementListPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementListPropertySetter");
   	}

      public StatementListPropertySetterST setPropertyName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._propertyName == null) {
            this._propertyName = value;
         	template.add("propertyName", value);
         }

      	return this;
      }

      public String getPropertyName() {
      	return (String) this._propertyName;
      }

      public StatementListPropertySetterST setStatementName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._statementName == null) {
            this._statementName = value;
         	template.add("statementName", value);
         }

      	return this;
      }

      public String getStatementName() {
      	return (String) this._statementName;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class StatementStringPropertySetterST implements TemplateGroupGroupTemplate {
      private Object _propertyName;
      private Object _statementName;

      private final ST template;

      private StatementStringPropertySetterST(STGroup group) {
   		template = group.getInstanceOf("StatementStringPropertySetter");
   	}

      public StatementStringPropertySetterST setPropertyName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._propertyName == null) {
            this._propertyName = value;
         	template.add("propertyName", value);
         }

      	return this;
      }

      public String getPropertyName() {
      	return (String) this._propertyName;
      }

      public StatementStringPropertySetterST setStatementName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._statementName == null) {
            this._statementName = value;
         	template.add("statementName", value);
         }

      	return this;
      }

      public String getStatementName() {
      	return (String) this._statementName;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class TemplateParameterBuilderST implements TemplateGroupGroupTemplate {
      private java.util.Set<java.util.Map<String, Object>> _keyValueList = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _listElements = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _singleValues = new java.util.LinkedHashSet<>();
      private Object _stGroup;

      private final ST template;

      private TemplateParameterBuilderST(STGroup group) {
   		template = group.getInstanceOf("TemplateParameterBuilder");
   	}

      public TemplateParameterBuilderST addKeyValueListValue(Object name_, Object paramsAssignment_, Object paramsDeclaration_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("paramsAssignment", (paramsAssignment_ == null || paramsAssignment_.toString().length() == 0) ? null : paramsAssignment_);
      	map.put("paramsDeclaration", (paramsDeclaration_ == null || paramsDeclaration_.toString().length() == 0) ? null : paramsDeclaration_);
      	this._keyValueList.add(map);

         template.addAggr("keyValueList.{name, paramsAssignment, paramsDeclaration}", map.get("name"), map.get("paramsAssignment"), map.get("paramsDeclaration"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getKeyValueList() {
      	return this._keyValueList;
      }

      public TemplateParameterBuilderST addListElementsValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._listElements.add(map);

         template.addAggr("listElements.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getListElements() {
      	return this._listElements;
      }

      public TemplateParameterBuilderST setName(Object value) {
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

      public TemplateParameterBuilderST setPackage(Object value) {
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

      public TemplateParameterBuilderST addSingleValuesValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._singleValues.add(map);

         template.addAggr("singleValues.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getSingleValues() {
      	return this._singleValues;
      }

      public TemplateParameterBuilderST setStGroup(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._stGroup == null) {
            this._stGroup = value;
         	template.add("stGroup", value);
         }

      	return this;
      }

      public String getStGroup() {
      	return (String) this._stGroup;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class enumDeclarationST implements TemplateGroupGroupTemplate {
      private Object _name;
      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private enumDeclarationST(STGroup group) {
   		template = group.getInstanceOf("enumDeclaration");
   	}

      public enumDeclarationST setName(Object value) {
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

      public enumDeclarationST addValuesValue(Object value) {
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "TemplateGroupGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("stg(delimiter,templates) ::= <<delimiters \"~delimiter~\", \"~delimiter~\"\n" + 
		"\n" + 
		"~templates:{it|~it~};separator=\"\\n\"~>>\n")
			.append("eot() ::= <<~gt()~~gt()~>>\n")
			.append("stgBuilder(appends,delimiter) ::= <<private static final String stg = new StringBuilder(\"delimiters \\\"~delimiter~\\\", \\\"~delimiter~\\\"\\\\n\")\n" + 
		"	.append(\"eom() ::= <<}~eot()~\\\\n\")\n" + 
		"	.append(\"gt() ::= \\\">\\\"\\\\n\")\n" + 
		"	~appends:{it|		.append(\"~it~\\\\n\")};separator=\"\\n\"~\n" + 
		"	.toString();>>\n")
			.append("template(content,name,params) ::= <<~name~(~params:{it|~it~};separator=\",\"~) ::= <<~content~~eot()~>>\n")
			.append("GroupClassDeclaration(domain,name,packageName,statements,stg) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.stringtemplate.v4.ST;\n" + 
		"import org.stringtemplate.v4.STGroup;\n" + 
		"import org.stringtemplate.v4.STGroupString;\n" + 
		"\n" + 
		"import java.util.concurrent.atomic.AtomicBoolean;\n" + 
		"\n" + 
		"/**\n" + 
		" * Wraps STGroup-methods based on '~domain~.stg' file<br/>\n" + 
		" */\n" + 
		"public final class ~name;format=\"capitalize\"~ {\n" + 
		"\n" + 
		"   private final STGroup stGroup;\n" + 
		"   private final char delimiter;\n" + 
		"\n" + 
		"	public ~name;format=\"capitalize\"~() {\n" + 
		"		this(new STGroupString(stg));\n" + 
		"   }\n" + 
		"\n" + 
		"   public ~name;format=\"capitalize\"~(STGroup stGroup) {\n" + 
		"      this.stGroup = stGroup;\n" + 
		"      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());\n" + 
		"      this.delimiter = stGroup.delimiterStartChar;\n" + 
		"   }\n" + 
		"\n" + 
		"   public ~name;format=\"capitalize\"~(java.io.File templateFile) {\n" + 
		"   	this.stGroup = new org.stringtemplate.v4.STGroupFile(templateFile.getAbsolutePath());\n" + 
		"	   this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());\n" + 
		"	   this.delimiter = stGroup.delimiterStartChar;\n" + 
		"	}\n" + 
		"\n" + 
		"   public STGroup getSTGroup() {\n" + 
		"      return stGroup;\n" + 
		"   }\n" + 
		"\n" + 
		"   public char getDelimiter() {\n" + 
		"      return delimiter;\n" + 
		"   }\n" + 
		"\n" + 
		"	public interface ~name~Template {\n" + 
		"\n" + 
		"	}\n" + 
		"\n" + 
		"   ~statements:{it|public ~it.name~ST new~it.name~() {\n" + 
		"   return new ~it.name~ST(stGroup);\n" + 
		"~eom()~};separator=\"\\r\\n\\r\\n\"~\n" + 
		"\n" + 
		"   ~statements:{it|~it.declaration~};separator=\"\\r\\n\\r\\n\"~\n" + 
		"\n" + 
		"	static boolean tryToSetListProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {\n" + 
		"		if (value == null || value.toString().length() == 0) return true;\n" + 
		"		alreadySet.set(true);\n" + 
		"		template.add(name, value);\n" + 
		"		return false;\n" + 
		"	}\n" + 
		"\n" + 
		"	~AttributeRendererDeclaration()~\n" + 
		"\n" + 
		"	public String list(String delimiter, Object... elements) {\n" + 
		"		final StringBuilder list = new StringBuilder();\n" + 
		"		boolean first = true;\n" + 
		"		for (Object element : elements) {\n" + 
		"			if (!first) list.append(delimiter);\n" + 
		"			list.append(element);\n" + 
		"			first = false;\n" + 
		"		}\n" + 
		"		return list.toString() + delimiter;\n" + 
		"	}\n" + 
		"\n" + 
		"	public static void toSTGFile(java.io.File dir) throws java.io.IOException {\n" + 
		"		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, \"~name~.stg\")));\n" + 
		"		out.write(stg);\n" + 
		"		out.close();\n" + 
		"   }\n" + 
		"	\n" + 
		"	~if(stg)~~stg~~endif~\n" + 
		"}>>\n")
			.append("AttributeRendererDeclaration() ::= <<private enum FormatCode {\n" + 
		"      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath\n" + 
		"   }\n" + 
		"\n" + 
		"   private final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public String toString(Object o, String formatString, java.util.Locale locale) {\n" + 
		"\n" + 
		"         final String text = o.toString();\n" + 
		"\n" + 
		"         if (formatString == null) return text;\n" + 
		"\n" + 
		"         switch (FormatCode.valueOf(formatString)) {\n" + 
		"            case capitalize:\n" + 
		"               return capitalize(text);\n" + 
		"            case toUpper:\n" + 
		"               return toUpper(text);\n" + 
		"            case lowFirst:\n" + 
		"               return lowFirst(text);\n" + 
		"            case toLower:\n" + 
		"               return text.toLowerCase();\n" + 
		"            case humpToCap:\n" + 
		"               return humpToCap(text);\n" + 
		"            case camelHump:\n" + 
		"               return camelHump(text);\n" + 
		"            case splitCamelHump:\n" + 
		"               return splitCamelHump(text);\n" + 
		"            case singlify:\n" + 
		"               String s = toUpper(text).substring(0, 1) + text.substring(1);\n" + 
		"               if (s.toLowerCase().endsWith(\"ies\")) return s.substring(0, s.length() - 3) + \"y\";\n" + 
		"               else if (s.toLowerCase().endsWith(\"es\") || s.toLowerCase().endsWith(\"nts\")) return s.substring(0, s.length() - 1);\n" + 
		"               else if (s.toLowerCase().endsWith(\"ions\") || s.toLowerCase().endsWith(\"mns\"))\n" + 
		"                  return s.substring(0, s.length() - 1);\n" + 
		"               return s;\n" + 
		"            case packageToPath:\n" + 
		"               return packageToPath((text));\n" + 
		"            default:\n" + 
		"               return o.toString();\n" + 
		"         }\n" + 
		"      }\n" + 
		"\n" + 
		"      private String capitalize(String string) {\n" + 
		"         if (string == null || string.length() == 0) return \"\";\n" + 
		"         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : \"\");\n" + 
		"      }\n" + 
		"\n" + 
		"      private String lowFirst(String string) {\n" + 
		"         if (string == null || string.length() == 0) return \"\";\n" + 
		"         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : \"\");\n" + 
		"      }\n" + 
		"\n" + 
		"      private String toUpper(String text) {\n" + 
		"         return text.toUpperCase();\n" + 
		"      }\n" + 
		"\n" + 
		"      private String humpToCap(String text) {\n" + 
		"         final char[] chars = text.toCharArray();\n" + 
		"         final StringBuilder out = new StringBuilder();\n" + 
		"         boolean first = true;\n" + 
		"         for (int i = 0; i < chars.length; i++) {\n" + 
		"            char aChar = chars[i];\n" + 
		"            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {\n" + 
		"               out.append(\"_\");\n" + 
		"            }\n" + 
		"            first = false;\n" + 
		"            out.append(Character.toUpperCase(aChar));\n" + 
		"         }\n" + 
		"         return out.toString();\n" + 
		"      }\n" + 
		"\n" + 
		"      private String camelHump(String text) {\n" + 
		"         final char[] chars = text.toCharArray();\n" + 
		"         final StringBuilder out = new StringBuilder();\n" + 
		"         boolean capitalize = true;\n" + 
		"         for (char aChar : chars) {\n" + 
		"            if (Character.isWhitespace(aChar)) {\n" + 
		"               capitalize = true;\n" + 
		"               continue;\n" + 
		"            }\n" + 
		"            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);\n" + 
		"            capitalize = false;\n" + 
		"         }\n" + 
		"         return out.toString();\n" + 
		"      }\n" + 
		"\n" + 
		"      private String splitCamelHump(String text) {\n" + 
		"         final char[] chars = text.toCharArray();\n" + 
		"         final StringBuilder out = new StringBuilder();\n" + 
		"         boolean first = true;\n" + 
		"         for (char aChar : chars) {\n" + 
		"            if (Character.isUpperCase(aChar)) out.append(\" \");\n" + 
		"            out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));\n" + 
		"            first = false;\n" + 
		"         }\n" + 
		"         return out.toString();\n" + 
		"      }\n" + 
		"\n" + 
		"      private String packageToPath(String packageName) {\n" + 
		"          return (packageName == null ? \"\" : (packageName.replaceAll(\"[.]\", \"/\") + java.io.File.separator));\n" + 
		"      }\n" + 
		"   }>>\n")
			.append("StatementKeyValueListPropertySetter(kvNames,propertyName,statementName) ::= <<public ~statementName~ST add~propertyName;format=\"capitalize\"~Value(~kvNames:{it|Object ~it~_};separator=\", \"~) {\n" + 
		"	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();\n" + 
		"	~kvNames:{it|map.put(\"~it~\", (~it~_ == null || ~it~_.toString().length() == 0) ? null : ~it~_);};separator=\"\\n\"~\n" + 
		"	this._~propertyName~.add(map);\n" + 
		"\n" + 
		"   template.addAggr(\"~propertyName~.{~kvNames:{it|~it~};separator=\", \"~}\", ~kvNames:{it|map.get(\"~it~\")};separator=\", \"~);\n" + 
		"   return this;\n" + 
		"}\n" + 
		"\n" + 
		"public java.util.Set<java.util.Map<String, Object>~gt()~ get~propertyName;format=\"capitalize\"~() {\n" + 
		"	return this._~propertyName~;\n" + 
		"}>>\n")
			.append("NewStatementDeclaration(groupname,name,properties,enumDeclarations) ::= <<public static final class ~name~ST implements ~groupname~Template {\n" + 
		"	\n" + 
		"	~enumDeclarations:{it|~it~};separator=\"\\n\"~\n" + 
		"\n" + 
		"   ~properties:{it|private ~it.type~ _~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"   private final ST template;\n" + 
		"\n" + 
		"   private ~name~ST(STGroup group) {\n" + 
		"		template = group.getInstanceOf(\"~name~\");\n" + 
		"	}\n" + 
		"\n" + 
		"~if(properties)~\n" + 
		"   ~properties:{it|~it.setter~};separator=\"\\n\\n\"~\n" + 
		"~endif~\n" + 
		"\n" + 
		"   @Override\n" + 
		"	public String toString() {\n" + 
		"		return template.render();\n" + 
		"	}\n" + 
		"}>>\n")
			.append("StatementListPropertySetter(propertyName,statementName) ::= <<public ~statementName~ST add~propertyName;format=\"capitalize\"~Value(Object value) {\n" + 
		"	if (value == null || value.toString().length() == 0)\n" + 
		"   	return this;\n" + 
		"\n" + 
		"	this._~propertyName~.add(value);\n" + 
		"	template.add(\"~propertyName~\", value);\n" + 
		"\n" + 
		"   return this;\n" + 
		"}\n" + 
		"\n" + 
		"public java.util.Set<Object> get~propertyName;format=\"capitalize\"~Values() {\n" + 
		"	return this._~propertyName~;\n" + 
		"}>>\n")
			.append("StatementStringPropertySetter(propertyName,statementName) ::= <<public ~statementName~ST set~propertyName;format=\"capitalize\"~(Object value) {\n" + 
		"	if (value == null || value.toString().length() == 0)\n" + 
		"   	return this;\n" + 
		"\n" + 
		"	if (this._~propertyName~ == null) {\n" + 
		"      this._~propertyName~ = value;\n" + 
		"   	template.add(\"~propertyName~\", value);\n" + 
		"   }\n" + 
		"\n" + 
		"	return this;\n" + 
		"}\n" + 
		"\n" + 
		"public String get~propertyName;format=\"capitalize\"~() {\n" + 
		"	return (String) this._~propertyName~;\n" + 
		"}>>\n")
			.append("TemplateParameterBuilder(keyValueList,listElements,name,package,singleValues,stGroup) ::= <<package ~package~;\n" + 
		"\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"/**\n" + 
		" * AUTO-GENERATED\n" + 
		" */\n" + 
		"public final class ~name~ParamsBuilder {\n" + 
		"\n" + 
		"~singleValues:{it|\n" + 
		"	private JsonObject _~it.name~;};separator=\"\\n\"~\n" + 
		"~listElements:{it|\n" + 
		"	private final JsonArray _~it.name~Elements = new JsonArray();};separator=\"\\n\"~\n" + 
		"~keyValueList:{it|\n" + 
		"	private final JsonArray _~it.name~Elements = new JsonArray();};separator=\"\\n\"~\n" + 
		"\n" + 
		"~singleValues:{it|\n" + 
		"   public ~name~ParamsBuilder set~it.name;format=\"capitalize\"~(Object value) {\n" + 
		"      this._~it.name~ = newSingleValue(\"~it.name~\", value);\n" + 
		"      return this;\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~listElements:{it|\n" + 
		"   public ~name~ParamsBuilder add~it.name;format=\"capitalize\"~Element(Object element) {\n" + 
		"      this._~it.name~Elements.add(newSingleValue(element));\n" + 
		"      return this;\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~keyValueList:{it|\n" + 
		"   public ~name~ParamsBuilder add~it.name;format=\"capitalize\"~Element(~it.paramsDeclaration~) {\n" + 
		"      this._~it.name~Elements.add(arrayOf(~it.paramsAssignment~));\n" + 
		"      return this;\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"   public JsonObject build() {\n" + 
		"      final JsonArray templateParameters = new JsonArray();\n" + 
		"~singleValues:{it|\n" + 
		"      templateParameters.add(this._~it.name~);};separator=\"\\n\"~\n" + 
		"~listElements:{it|\n" + 
		"      templateParameters.add(newList(\"~it.name~\", this._~it.name~Elements));};separator=\"\\n\"~\n" + 
		"~keyValueList:{it|\n" + 
		"      templateParameters.add(newKeyValueList(\"~it.name~\", this._~it.name~Elements));};separator=\"\\n\"~\n" + 
		"\n" + 
		"      return newTemplate(\"~name~\", templateParameters);\n" + 
		"   }\n" + 
		"\n" + 
		"	public JsonObject asRootParameter() {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"STGroup\", \"~stGroup~\").\n" + 
		"            put(\"root\", build());\n" + 
		"   }\n" + 
		"\n" + 
		"   private JsonObject newTemplate(String name, JsonArray parameters) {\n" + 
		"      return new JsonObject().put(\"name\", name).put(\"parameters\", parameters);\n" + 
		"   }\n" + 
		"\n" + 
		"   private JsonObject newSingleValue(Object value) {\n" + 
		"      return new JsonObject().put(\"type\", \"single\").put(\"value\", value);\n" + 
		"   }\n" + 
		"\n" + 
		"   private JsonObject newSingleValue(String name, Object value) {\n" + 
		"      return new JsonObject().put(\"name\", name).put(\"type\", \"single\").put(\"value\", value);\n" + 
		"   }\n" + 
		"\n" + 
		"   private JsonObject newList(String name, JsonArray elements) {\n" + 
		"      return new JsonObject().put(\"name\", name).put(\"type\", \"list\").put(\"elements\", elements);\n" + 
		"   }\n" + 
		"\n" + 
		"   private JsonObject newKeyValueList(String name, JsonArray elements) {\n" + 
		"      return new JsonObject().put(\"name\", name).put(\"type\", \"keyValue\").put(\"elements\", elements);\n" + 
		"   }\n" + 
		"\n" + 
		"   private JsonArray arrayOf(Object... keyValues) {\n" + 
		"      final JsonArray element = new JsonArray();\n" + 
		"      for (Object keyValue : keyValues)\n" + 
		"         element.add(keyValue);\n" + 
		"      return element;\n" + 
		"   }\n" + 
		"\n" + 
		"   private JsonObject newKeyValue(String key, Object value) {\n" + 
		"      return new JsonObject().put(\"name\", key).put(\"value\", value);\n" + 
		"   }\n" + 
		"}>>\n")
			.append("enumDeclaration(name,values) ::= <<public enum ~name;format=\"capitalize\"~ {\n" + 
		"	~values:{it|~it~};separator=\", \"~\n" + 
		"}>>\n")
		.toString();
}