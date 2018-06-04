package com.generator.generators.antlr;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Antlr.stg' file<br/>
 */
public final class AntlrGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public AntlrGroup() {
		this(new STGroupString(stg));
   }

   public AntlrGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public AntlrGroup(java.io.File templateFile) {
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

	public interface AntlrGroupTemplate {

	}

   public AntlrGrammarNodeST newAntlrGrammarNode() {
      return new AntlrGrammarNodeST(stGroup);
   }

   public AntlrBnfRendererST newAntlrBnfRenderer() {
      return new AntlrBnfRendererST(stGroup);
   }

   public AntlrSymbolNodeST newAntlrSymbolNode() {
      return new AntlrSymbolNodeST(stGroup);
   }

   public AntlrDomainST newAntlrDomain() {
      return new AntlrDomainST(stGroup);
   }

   public grammarBlockST newgrammarBlock() {
      return new grammarBlockST(stGroup);
   }

   public grammarParserRuleSpecST newgrammarParserRuleSpec() {
      return new grammarParserRuleSpecST(stGroup);
   }

   public grammarST newgrammar() {
      return new grammarST(stGroup);
   }

   public NeoListenerST newNeoListener() {
      return new NeoListenerST(stGroup);
   }

   public BaseNodeListenerST newBaseNodeListener() {
      return new BaseNodeListenerST(stGroup);
   }

   public BaseNodeVisitorST newBaseNodeVisitor() {
      return new BaseNodeVisitorST(stGroup);
   }

   public NeoVisitorST newNeoVisitor() {
      return new NeoVisitorST(stGroup);
   }

   public mvnST newmvn() {
      return new mvnST(stGroup);
   }

   public static final class AntlrGrammarNodeST implements AntlrGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _children = new java.util.LinkedHashSet<>();
      private Object _name;

      private final ST template;

      private AntlrGrammarNodeST(STGroup group) {
   		template = group.getInstanceOf("AntlrGrammarNode");
   	}

      public AntlrGrammarNodeST addChildrenValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._children.add(map);

         template.addAggr("children.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getChildren() {
      	return this._children;
      }

      public AntlrGrammarNodeST setName(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class AntlrBnfRendererST implements AntlrGroupTemplate {


      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _nodes = new java.util.LinkedHashSet<>();
      private Object _package;

      private final ST template;

      private AntlrBnfRendererST(STGroup group) {
   		template = group.getInstanceOf("AntlrBnfRenderer");
   	}

      public AntlrBnfRendererST setName(Object value) {
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

      public AntlrBnfRendererST addNodesValue(Object name_, Object declaration_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("declaration", (declaration_ == null || declaration_.toString().length() == 0) ? null : declaration_);
      	this._nodes.add(map);

         template.addAggr("nodes.{name, declaration}", map.get("name"), map.get("declaration"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getNodes() {
      	return this._nodes;
      }

      public AntlrBnfRendererST setPackage(Object value) {
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

   public static final class AntlrSymbolNodeST implements AntlrGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _children = new java.util.LinkedHashSet<>();
      private Object _name;

      private final ST template;

      private AntlrSymbolNodeST(STGroup group) {
   		template = group.getInstanceOf("AntlrSymbolNode");
   	}

      public AntlrSymbolNodeST addChildrenValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._children.add(map);

         template.addAggr("children.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getChildren() {
      	return this._children;
      }

      public AntlrSymbolNodeST setName(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class AntlrDomainST implements AntlrGroupTemplate {


      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _nodes = new java.util.LinkedHashSet<>();
      private Object _package;

      private final ST template;

      private AntlrDomainST(STGroup group) {
   		template = group.getInstanceOf("AntlrDomain");
   	}

      public AntlrDomainST setName(Object value) {
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

      public AntlrDomainST addNodesValue(Object declaration_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("declaration", (declaration_ == null || declaration_.toString().length() == 0) ? null : declaration_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._nodes.add(map);

         template.addAggr("nodes.{declaration, name}", map.get("declaration"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getNodes() {
      	return this._nodes;
      }

      public AntlrDomainST setPackage(Object value) {
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

   public static final class grammarBlockST implements AntlrGroupTemplate {


      private Object _ebnfSuffix;
      private java.util.Set<Object> _elements = new java.util.LinkedHashSet<>();

      private final ST template;

      private grammarBlockST(STGroup group) {
   		template = group.getInstanceOf("grammarBlock");
   	}

      public grammarBlockST setEbnfSuffix(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._ebnfSuffix == null) {
            this._ebnfSuffix = value;
         	template.add("ebnfSuffix", value);
         }

      	return this;
      }

      public String getEbnfSuffix() {
      	return (String) this._ebnfSuffix;
      }

      public grammarBlockST addElementsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._elements.add(value);
      	template.add("elements", value);

         return this;
      }

      public java.util.Set<Object> getElementsValues() {
      	return this._elements;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class grammarParserRuleSpecST implements AntlrGroupTemplate {


      private Object _name;
      private java.util.Set<Object> _comments = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _alternatives = new java.util.LinkedHashSet<>();

      private final ST template;

      private grammarParserRuleSpecST(STGroup group) {
   		template = group.getInstanceOf("grammarParserRuleSpec");
   	}

      public grammarParserRuleSpecST setName(Object value) {
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

      public grammarParserRuleSpecST addCommentsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._comments.add(value);
      	template.add("comments", value);

         return this;
      }

      public java.util.Set<Object> getCommentsValues() {
      	return this._comments;
      }

      public grammarParserRuleSpecST addAlternativesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._alternatives.add(value);
      	template.add("alternatives", value);

         return this;
      }

      public java.util.Set<Object> getAlternativesValues() {
      	return this._alternatives;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class grammarST implements AntlrGroupTemplate {


      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _options = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _rules = new java.util.LinkedHashSet<>();

      private final ST template;

      private grammarST(STGroup group) {
   		template = group.getInstanceOf("grammar");
   	}

      public grammarST setName(Object value) {
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

      public grammarST addOptionsValue(Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._options.add(map);

         template.addAggr("options.{name, value}", map.get("name"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getOptions() {
      	return this._options;
      }

      public grammarST addRulesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._rules.add(value);
      	template.add("rules", value);

         return this;
      }

      public java.util.Set<Object> getRulesValues() {
      	return this._rules;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class NeoListenerST implements AntlrGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;
      private Object _parser;

      private final ST template;

      private NeoListenerST(STGroup group) {
   		template = group.getInstanceOf("NeoListener");
   	}

      public NeoListenerST addMethodsValue(Object name_, Object param_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("param", (param_ == null || param_.toString().length() == 0) ? null : param_);
      	this._methods.add(map);

         template.addAggr("methods.{name, param}", map.get("name"), map.get("param"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getMethods() {
      	return this._methods;
      }

      public NeoListenerST setName(Object value) {
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

      public NeoListenerST setPackageName(Object value) {
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

      public NeoListenerST setParser(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._parser == null) {
            this._parser = value;
         	template.add("parser", value);
         }

      	return this;
      }

      public String getParser() {
      	return (String) this._parser;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class BaseNodeListenerST implements AntlrGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;
      private Object _parser;

      private final ST template;

      private BaseNodeListenerST(STGroup group) {
   		template = group.getInstanceOf("BaseNodeListener");
   	}

      public BaseNodeListenerST addMethodsValue(Object param_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("param", (param_ == null || param_.toString().length() == 0) ? null : param_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._methods.add(map);

         template.addAggr("methods.{param, name}", map.get("param"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getMethods() {
      	return this._methods;
      }

      public BaseNodeListenerST setName(Object value) {
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

      public BaseNodeListenerST setPackageName(Object value) {
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

      public BaseNodeListenerST setParser(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._parser == null) {
            this._parser = value;
         	template.add("parser", value);
         }

      	return this;
      }

      public String getParser() {
      	return (String) this._parser;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class BaseNodeVisitorST implements AntlrGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;
      private Object _parser;

      private final ST template;

      private BaseNodeVisitorST(STGroup group) {
   		template = group.getInstanceOf("BaseNodeVisitor");
   	}

      public BaseNodeVisitorST addMethodsValue(Object name_, Object param_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("param", (param_ == null || param_.toString().length() == 0) ? null : param_);
      	this._methods.add(map);

         template.addAggr("methods.{name, param}", map.get("name"), map.get("param"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getMethods() {
      	return this._methods;
      }

      public BaseNodeVisitorST setName(Object value) {
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

      public BaseNodeVisitorST setPackageName(Object value) {
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

      public BaseNodeVisitorST setParser(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._parser == null) {
            this._parser = value;
         	template.add("parser", value);
         }

      	return this;
      }

      public String getParser() {
      	return (String) this._parser;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class NeoVisitorST implements AntlrGroupTemplate {


      private Object _packageName;
      private Object _parser;
      private java.util.Set<java.util.Map<String, Object>> _methods = new java.util.LinkedHashSet<>();
      private Object _name;

      private final ST template;

      private NeoVisitorST(STGroup group) {
   		template = group.getInstanceOf("NeoVisitor");
   	}

      public NeoVisitorST setPackageName(Object value) {
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

      public NeoVisitorST setParser(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._parser == null) {
            this._parser = value;
         	template.add("parser", value);
         }

      	return this;
      }

      public String getParser() {
      	return (String) this._parser;
      }

      public NeoVisitorST addMethodsValue(Object name_, Object param_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("param", (param_ == null || param_.toString().length() == 0) ? null : param_);
      	this._methods.add(map);

         template.addAggr("methods.{name, param}", map.get("name"), map.get("param"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getMethods() {
      	return this._methods;
      }

      public NeoVisitorST setName(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class mvnST implements AntlrGroupTemplate {


      private Object _version;

      private final ST template;

      private mvnST(STGroup group) {
   		template = group.getInstanceOf("mvn");
   	}

      public mvnST setVersion(Object value) {
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "AntlrGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("AntlrGrammarNode(children,name) ::= <<public ~name~ new~name;format=\"capitalize\"~(String text, String startToken, String endToken) {\n" + 
		"	return new ~name~(text, startToken, endToken);\n" + 
		"}\n" + 
		"\n" + 
		"public class ~name~ extends AntlrGrammarNode {\n" + 
		"\n" + 
		"	public ~name~(String text, String startToken, String endToken) {\n" + 
		"		super(\"~name~\", startToken, text, startToken, endToken);\n" + 
		"	}\n" + 
		"\n" + 
		"~children:{it|\n" + 
		"	public AntlrGrammarNode add~it.name;format=\"capitalize\"~(~it.name~ child) { return super.addChild(child); ~eom()~\n" + 
		"\n" + 
		"	public AntlrGrammarNode set~it.name;format=\"capitalize\"~(~it.name~ child) { return super.setChild(child); ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public Object toGrammar(AntlrGroup antlrGroup) {\n" + 
		"		return super.toGrammar(antlrGroup);\n" + 
		"	}\n" + 
		"}>>\n")
			.append("AntlrBnfRenderer(name,nodes,package) ::= <<package ~package~;\n" + 
		"\n" + 
		"import com.generator.generators.antlr.AntlrGroup;\n" + 
		"import com.generator.generators.antlr.parser.ANTLRv4ParserDomain;\n" + 
		"\n" + 
		"import javax.swing.*;\n" + 
		"import java.awt.*;\n" + 
		"import java.awt.event.ActionEvent;\n" + 
		"import java.beans.PropertyChangeSupport;\n" + 
		"import java.util.Stack;\n" + 
		"\n" + 
		"public class ~name~ extends ANTLRv4ParserDomain.ANTLRv4Visitor { \n" + 
		"	\n" + 
		"	protected final Stack<AntlrGrammarSymbol> symbolStack = new Stack<>();\n" + 
		"	\n" + 
		"	~nodes:{it|\n" + 
		"	@Override\n" + 
		"	public void visit~it.name~(ANTLRv4ParserDomain.~it.name~ node) {\n" + 
		"		final ~it.name~Symbol symbol = new~it.name~Symbol(node);\n" + 
		"		if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);\n" + 
		"		symbolStack.push(symbol);\n" + 
		"		super.visit~it.name~(node);\n" + 
		"		if (symbolStack.size() > 1) symbolStack.pop();\n" + 
		"	~eom()~\n" + 
		"	};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~nodes:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
		"}>>\n")
			.append("AntlrSymbolNode(children,name) ::= <<public ~name~Symbol new~name;format=\"capitalize\"~Symbol(ANTLRv4ParserDomain.~name~ node) {\n" + 
		"	return new ~name~Symbol(node);\n" + 
		"}\n" + 
		"\n" + 
		"public class ~name~Symbol extends AntlrGrammarSymbol {\n" + 
		"\n" + 
		"	public ~name~Symbol(ANTLRv4ParserDomain.~name~ node) {\n" + 
		"		super(node);\n" + 
		"	}\n" + 
		"~children:{it|\n" + 
		"//	public AntlrGrammarSymbol add~it.name;format=\"capitalize\"~(~it.name~Symbol child) { return (AntlrGrammarSymbol) super.addChild(child); ~eom()~\n" + 
		"//	public AntlrGrammarSymbol set~it.name;format=\"capitalize\"~(~it.name~Symbol child) { return (AntlrGrammarSymbol) super.setChild(child); ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {\n" + 
		"   	return super.paint(startX, startY, g, shapeMap, level);\n" + 
		"	}\n" + 
		"	\n" + 
		"	@Override\n" + 
		"	public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {\n" + 
		"		super.addActionsTo(menu, modelChangeSupport);\n" + 
		"	}\n" + 
		"}>>\n")
			.append("AntlrDomain(name,nodes,package) ::= <<package ~package~;\n" + 
		"\n" + 
		"import com.generator.generators.antlr.AntlrGroup;\n" + 
		"import com.generator.util.NeoUtil;\n" + 
		"\n" + 
		"import java.util.ArrayList;\n" + 
		"import java.util.Stack;\n" + 
		"import java.util.UUID;\n" + 
		"\n" + 
		"public class ~name~ { \n" + 
		"\n" + 
		"	protected static final java.util.Random random = new java.util.Random(System.currentTimeMillis());\n" + 
		"	\n" + 
		"	protected final Stack<AntlrGrammarNode> grammarStack = new Stack<>();\n" + 
		"\n" + 
		"   public GrammarSpec getGrammarSpec() {\n" + 
		"		return grammarStack.isEmpty() ? null : (GrammarSpec) grammarStack.peek();\n" + 
		"	}\n" + 
		"\n" + 
		"	public static abstract class ANTLRv4Visitor {\n" + 
		"\n" + 
		"		public void visit(AntlrGrammarNode node) {\n" + 
		"			switch(node.type) {\n" + 
		"				~nodes:{it|case \"~it.name~\": \n" + 
		"	visit~it.name~((~it.name~) node); \n" + 
		"	break;};separator=\"\\n\"~\n" + 
		"			}\n" + 
		"		}\n" + 
		"		\n" + 
		"		~nodes:{it|public void visit~it.name~(~it.name~ node) {\n" + 
		"	for (AntlrGrammarNode child : node.children) visit(child);\n" + 
		"~eom()~};separator=\"\\n\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"	public void onNode(AntlrGrammarNode grammarNode) { \n" + 
		"	}\n" + 
		"\n" + 
		"	protected ANTLRv4ParserDomainVisitor getANTLRv4ParserDomainVisitor() {\n" + 
		"   	return new ANTLRv4ParserDomainVisitor() {\n" + 
		"	~nodes:{it| 	\n" + 
		"		@Override\n" + 
		"		public void visit~it.name~(org.neo4j.graphdb.Node node) { \n" + 
		"			final ~it.name~ grammarNode = new~it.name~(NeoUtil.getString(node, \"text\"), NeoUtil.getString(node, \"startToken\"), NeoUtil.getString(node, \"endToken\"));\n" + 
		"			onNode(grammarNode);\n" + 
		"	 		if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);\n" + 
		"	 		grammarStack.push(grammarNode);\n" + 
		"	 		super.visit~it.name~(node);\n" + 
		"	 		if (grammarStack.size() > 1) grammarStack.pop();\n" + 
		"		~eom()~ };\n" + 
		"		separator=\"\\n\"~\n" + 
		"		};\n" + 
		"	}\n" + 
		"\n" + 
		"	public ANTLRv4ParserNodeListener getANTLRv4ParserNodeListener(boolean debug) {\n" + 
		"		return new ANTLRv4ParserNodeListener(debug) {\n" + 
		"\n" + 
		"	~nodes:{it|\n" + 
		"		@Override\n" + 
		"		public void enter~it.name~(ANTLRv4Parser.~it.name~Context arg) {\n" + 
		"			super.enter~it.name~(arg);\n" + 
		"			final ~it.name~ grammarNode = new~it.name~(arg.getText(), arg.getStart().getText(), arg.getStop().getText());\n" + 
		"	      onNode(grammarNode);\n" + 
		"			if (!grammarStack.isEmpty()) grammarStack.peek().addChild(grammarNode);\n" + 
		"	      grammarStack.push(grammarNode);\n" + 
		"		~eom()~\n" + 
		"\n" + 
		"		@Override\n" + 
		"		public void exit~it.name~(ANTLRv4Parser.~it.name~Context arg) {\n" + 
		"			super.exit~it.name~(arg);\n" + 
		"			if (grammarStack.size() > 1) grammarStack.pop();\n" + 
		"		~eom()~\n" + 
		"		};separator=\"\\n\"~\n" + 
		"		};\n" + 
		"	}\n" + 
		"\n" + 
		"	~nodes:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
		"}>>\n")
			.append("grammarBlock(ebnfSuffix,elements) ::= <<(~elements:{it|~it~};separator=\" \"~)~ebnfSuffix~>>\n")
			.append("grammarParserRuleSpec(name,comments,alternatives) ::= <<~comments:{it|// ~it~};separator=\"\\n\"~\n" + 
		"~name~\n" + 
		"	: ~alternatives:{it|~it~};separator=\"\\n\\t|\"~\n" + 
		"	;>>\n")
			.append("grammar(name,options,rules) ::= <<grammar ~name~;\n" + 
		"\n" + 
		"~if(options)~\n" + 
		"options\n" + 
		"	~options:{it|{ ~it.name~ = ~it.value~; ~eom()~};separator=\"\\n\"~\n" + 
		"~endif~\n" + 
		"\n" + 
		"~rules:{it|\n" + 
		"~it~};separator=\"\\n\\n\"~>>\n")
			.append("NeoListener(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.neo4j.graphdb.Node;\n" + 
		"import org.neo4j.graphdb.Label;\n" + 
		"import org.neo4j.graphdb.RelationshipType;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseListener {\n" + 
		"\n" + 
		"	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(~name~.class);\n" + 
		"\n" + 
		"   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" + 
		"	protected final StringBuilder delim = new StringBuilder(\"\");\n" + 
		"	protected final boolean debug;\n" + 
		"	private final com.generator.neo.NeoModel model;\n" + 
		"\n" + 
		"	public ~name~(com.generator.neo.NeoModel model) {\n" + 
		"		this(model, false);\n" + 
		"	}\n" + 
		"\n" + 
		"	public ~name~(com.generator.neo.NeoModel model, boolean debug) {\n" + 
		"		this.model = model;\n" + 
		"		this.debug = debug;\n" + 
		"	}\n" + 
		"\n" + 
		"   protected void onEnter(Node node) {\n" + 
		"		if (!nodeStack.isEmpty())\n" + 
		"      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName(\"child\"));\n" + 
		"      nodeStack.push(node);\n" + 
		"		if (debug) log.debug(delim.toString() + node.getProperty(\"text\"));\n" + 
		"		delim.append(\"\\t\");\n" + 
		"   }\n" + 
		"\n" + 
		"   protected void onExit() {\n" + 
		"      if (nodeStack.size() > 1) {\n" + 
		"			nodeStack.pop();\n" + 
		"         delim.deleteCharAt(delim.length() - 1);\n" + 
		"		}\n" + 
		"   }\n" + 
		"\n" + 
		"   public Node getRoot() {\n" + 
		"      return nodeStack.peek();\n" + 
		"   }\n" + 
		"\n" + 
		"~methods:{it|\n" + 
		"	protected java.util.Stack<Boolean> in~it.name~ = new java.util.Stack<>();\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public void enter~it.name~(~it.param~ arg) {\n" + 
		"		final Node node = model.newNode(Label.label(\"~it.name~\"), \"text\", arg.getText(), \"startToken\", arg.getStart().getText(), \"endToken\", (arg.getStop() == null ? \"\" : arg.getStop().getText()));\n" + 
		"		onEnter(node);\n" + 
		"		this.in~it.name~.push(true);\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	public void exit~it.name~(~it.param~ arg) {\n" + 
		"		onExit();\n" + 
		"		this.in~it.name~.pop();\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	public boolean in~it.name~() {\n" + 
		"      return !in~it.name~.isEmpty(); \n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("BaseNodeListener(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseListener {\n" + 
		"\n" + 
		"	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(~name~.class);\n" + 
		"\n" + 
		"   public static class Node {\n" + 
		"\n" + 
		"      public final String name;\n" + 
		"      public final String value;\n" + 
		"      public final String startToken;\n" + 
		"      public final String endToken;\n" + 
		"      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();\n" + 
		"\n" + 
		"      public Node(String name, String value, String startToken, String endToken) {\n" + 
		"         this.name = name;\n" + 
		"         this.value = value;\n" + 
		"			this.startToken = startToken;\n" + 
		"			this.endToken = endToken;\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" + 
		"	protected final StringBuilder delim = new StringBuilder(\"\");\n" + 
		"	protected final boolean debug;\n" + 
		"	\n" + 
		"	public ~name~() {\n" + 
		"		this(false);\n" + 
		"	}\n" + 
		"\n" + 
		"	public ~name~(boolean debug) {\n" + 
		"		this.debug = debug;\n" + 
		"	}\n" + 
		"\n" + 
		"   protected void onEnter(Node node) {\n" + 
		"      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);\n" + 
		"      nodeStack.push(node);\n" + 
		"		if (debug) log.debug(delim.toString() + node.name + \" : (\" + nodeStack.peek().startToken + \") (\" + node.value + \") (\" + nodeStack.peek().endToken + \")\");\n" + 
		"		delim.append(\"\\t\");\n" + 
		"   }\n" + 
		"\n" + 
		"   protected void onExit() {\n" + 
		"      if (nodeStack.size() > 1) {\n" + 
		"			nodeStack.pop();\n" + 
		"         delim.deleteCharAt(delim.length() - 1);\n" + 
		"		}\n" + 
		"   }\n" + 
		"\n" + 
		"   public Node getRoot() {\n" + 
		"      return nodeStack.peek();\n" + 
		"   }\n" + 
		"\n" + 
		"~methods:{it|\n" + 
		"	protected java.util.Stack<Boolean> in~it.name~ = new java.util.Stack<>();\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public void enter~it.name~(~it.param~ arg) {\n" + 
		"		onEnter(new Node(\"~it.name~\", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? \"\" : arg.getStop().getText()));\n" + 
		"		this.in~it.name~.push(true);\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	public void exit~it.name~(~it.param~ arg) {\n" + 
		"		onExit();\n" + 
		"		this.in~it.name~.pop();\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	public boolean in~it.name~() {\n" + 
		"      return !in~it.name~.isEmpty(); \n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("BaseNodeVisitor(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseVisitor<~name~.Node> {\n" + 
		"\n" + 
		"	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(~name~.class);\n" + 
		"\n" + 
		"   public static class Node {\n" + 
		"\n" + 
		"      public final String name;\n" + 
		"      public final String value;\n" + 
		"      public final String startToken;\n" + 
		"      public final String endToken;\n" + 
		"      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();\n" + 
		"\n" + 
		"      public Node(String name, String value, String startToken, String endToken) {\n" + 
		"         this.name = name;\n" + 
		"         this.value = value;\n" + 
		"			this.startToken = startToken;\n" + 
		"			this.endToken = endToken;\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" + 
		"	protected final StringBuilder delim = new StringBuilder(\"\");\n" + 
		"	protected final boolean debug;\n" + 
		"	\n" + 
		"	public ~name~() {\n" + 
		"		this(false);\n" + 
		"	}\n" + 
		"\n" + 
		"	public ~name~(boolean debug) {\n" + 
		"		this.debug = debug;\n" + 
		"	}\n" + 
		"\n" + 
		"   protected void onEnter(Node node) {\n" + 
		"      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);\n" + 
		"      nodeStack.push(node);\n" + 
		"				if (debug) log.debug(delim.toString() + node.name + \" : (\" + nodeStack.peek().startToken + \") (\" + node.value + \") (\" + nodeStack.peek().endToken + \")\");\n" + 
		"		delim.append(\"\\t\");\n" + 
		"   }\n" + 
		"\n" + 
		"   protected void onExit() {\n" + 
		"      if (nodeStack.size() > 1) {\n" + 
		"         nodeStack.pop();\n" + 
		"         delim.deleteCharAt(delim.length() - 1);\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"   public Node getRoot() {\n" + 
		"      return nodeStack.peek();\n" + 
		"   }\n" + 
		"\n" + 
		"~methods:{it|\n" + 
		"	@Override\n" + 
		"	public Node visit~it.name~(~it.param~ arg) {\n" + 
		"		final Node node = new Node(\"~it.name~\", arg.getText(), arg.getStart().getText(), arg.getStop().getText());\n" + 
		"		onEnter(node);\n" + 
		"      visitChildren(arg);\n" + 
		"      onExit();\n" + 
		"      return node;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("NeoVisitor(packageName,parser,methods,name) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.neo4j.graphdb.Node;\n" + 
		"import org.neo4j.graphdb.Label;\n" + 
		"import org.neo4j.graphdb.RelationshipType;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseVisitor<Node> {\n" + 
		"\n" + 
		"	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(~name~.class);\n" + 
		"\n" + 
		"   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" + 
		"	protected final com.generator.neo.NeoModel model;\n" + 
		"\n" + 
		"	public ~name~(com.generator.neo.NeoModel model) {\n" + 
		"		this.model = model;\n" + 
		"	}\n" + 
		"\n" + 
		"   protected void onEnter(Node node) {\n" + 
		"      if (!nodeStack.isEmpty())\n" + 
		"         com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName(\"child\"));\n" + 
		"      nodeStack.push(node);\n" + 
		"   }\n" + 
		"\n" + 
		"   protected void onExit() {\n" + 
		"      if (nodeStack.size() > 1) nodeStack.pop();\n" + 
		"   }\n" + 
		"\n" + 
		"   public Node getRoot() {\n" + 
		"      return nodeStack.peek();\n" + 
		"   }\n" + 
		"\n" + 
		"~methods:{it|\n" + 
		"	@Override\n" + 
		"	public Node visit~it.name~(~it.param~ arg) {\n" + 
		"		log.info(\"~it.name~\");\n" + 
		"		final Node node = model.newNode(Label.label(\"~it.name~\"), \"text\", arg.getText(), \"startToken\", arg.getStart().getText(), \"endToken\", arg.getStop().getText());\n" + 
		"      onEnter(node);\n" + 
		"      visitChildren(arg);\n" + 
		"      onExit();\n" + 
		"      return node;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("mvn(version) ::= <<<dependency>\n" + 
		"   <groupId>org.antlr</groupId>\n" + 
		"   <artifactId>antlr4</artifactId>\n" + 
		"	<version>~if(version)~~version~~else~4.7~endif~</version>\n" + 
		"</dependency> >>\n")
		.toString();
}