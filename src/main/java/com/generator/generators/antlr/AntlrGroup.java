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

   public NeoListenerST newNeoListener() {
      return new NeoListenerST(stGroup);
   }

   public grammarST newgrammar() {
      return new grammarST(stGroup);
   }

   public NeoVisitorST newNeoVisitor() {
      return new NeoVisitorST(stGroup);
   }

   public BaseNodeVisitorST newBaseNodeVisitor() {
      return new BaseNodeVisitorST(stGroup);
   }

   public BaseNodeListenerST newBaseNodeListener() {
      return new BaseNodeListenerST(stGroup);
   }

   public ruleST newrule() {
      return new ruleST(stGroup);
   }

   public DomainElementST newDomainElement() {
      return new DomainElementST(stGroup);
   }

   public DomainST newDomain() {
      return new DomainST(stGroup);
   }

   public blockST newblock() {
      return new blockST(stGroup);
   }

   public final class NeoListenerST implements AntlrGroupTemplate {

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

   public final class grammarST implements AntlrGroupTemplate {

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

   public final class NeoVisitorST implements AntlrGroupTemplate {

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

   public final class BaseNodeVisitorST implements AntlrGroupTemplate {

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

   public final class BaseNodeListenerST implements AntlrGroupTemplate {

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

   public final class ruleST implements AntlrGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _comments = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _alternatives = new java.util.LinkedHashSet<>();

      private final ST template;

      private ruleST(STGroup group) {
   		template = group.getInstanceOf("rule");
   	}

      public ruleST setName(Object value) {
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

      public ruleST addCommentsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._comments.add(value);
      	template.add("comments", value);

         return this;
      }

      public java.util.Set<Object> getCommentsValues() {
      	return this._comments;
      }

      public ruleST addAlternativesValue(Object value) {
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

   public final class DomainElementST implements AntlrGroupTemplate {

      private Object _domain;
      private Object _name;

      private final ST template;

      private DomainElementST(STGroup group) {
   		template = group.getInstanceOf("DomainElement");
   	}

      public DomainElementST setDomain(Object value) {
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

      public DomainElementST setName(Object value) {
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

   public final class DomainST implements AntlrGroupTemplate {

      private java.util.Set<Object> _elements = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;

      private final ST template;

      private DomainST(STGroup group) {
   		template = group.getInstanceOf("Domain");
   	}

      public DomainST addElementsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._elements.add(value);
      	template.add("elements", value);

         return this;
      }

      public java.util.Set<Object> getElementsValues() {
      	return this._elements;
      }

      public DomainST setName(Object value) {
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

      public DomainST setPackage(Object value) {
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

   public final class blockST implements AntlrGroupTemplate {

      private Object _ebnfSuffix;
      private java.util.Set<Object> _elements = new java.util.LinkedHashSet<>();

      private final ST template;

      private blockST(STGroup group) {
   		template = group.getInstanceOf("block");
   	}

      public blockST setEbnfSuffix(Object value) {
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

      public blockST addElementsValue(Object value) {
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
			.append("NeoListener(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.neo4j.graphdb.Node;\n" + 
		"import org.neo4j.graphdb.Label;\n" + 
		"import org.neo4j.graphdb.RelationshipType;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseListener {\n" + 
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
		"		if (debug) System.out.println(delim.toString() + node.getProperty(\"text\"));\n" + 
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
		"		final Node node = model.findOrCreate(Label.label(\"~it.name~\"), \"text\", arg.getText(), \"startToken\", arg.getStart().getText(), \"endtoken\", arg.getStop().getText());\n" + 
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
			.append("grammar(name,options,rules) ::= <<grammar ~name~;\n" + 
		"\n" + 
		"~if(options)~\n" + 
		"options\n" + 
		"	~options:{it|{ ~it.name~ = ~it.value~; ~eom()~};separator=\"\\n\"~\n" + 
		"~endif~\n" + 
		"\n" + 
		"~rules:{it|\n" + 
		"~it~};separator=\"\\n\\n\"~>>\n")
			.append("NeoVisitor(packageName,parser,methods,name) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.neo4j.graphdb.Node;\n" + 
		"import org.neo4j.graphdb.Label;\n" + 
		"import org.neo4j.graphdb.RelationshipType;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseVisitor<Node> {\n" + 
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
		"		System.out.println(\"~it.name~\");\n" + 
		"		final Node node = model.findOrCreate(Label.label(\"~it.name~\"), \"text\", arg.getText(), \"startToken\", arg.getStart().getText(), \"endToken\", arg.getStop().getText());\n" + 
		"      onEnter(node);\n" + 
		"      visitChildren(arg);\n" + 
		"      onExit();\n" + 
		"      return node;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("BaseNodeVisitor(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseVisitor<~name~.Node> {\n" + 
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
		"				if (debug) System.out.println(delim.toString() + node.name + \" : (\" + nodeStack.peek().startToken + \") (\" + node.value + \") (\" + nodeStack.peek().endToken + \")\");\n" + 
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
			.append("BaseNodeListener(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"public class ~name~ extends ~parser~BaseListener {\n" + 
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
		"		if (debug) System.out.println(delim.toString() + node.name + \" : (\" + nodeStack.peek().startToken + \") (\" + node.value + \") (\" + nodeStack.peek().endToken + \")\");\n" + 
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
		"		onEnter(new Node(\"~it.name~\", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));\n" + 
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
			.append("rule(name,comments,alternatives) ::= <<~comments:{it|// ~it~};separator=\"\\n\"~\n" + 
		"~name~\n" + 
		"	: ~alternatives:{it|~it~};separator=\"\\n\\t|\"~\n" + 
		"	;>>\n")
			.append("DomainElement(domain,name) ::= <<public final class ~name~ extends ~domain~Symbol {\n" + 
		"      \n" + 
		"}>>\n")
			.append("Domain(elements,name,package) ::= <<package ~package~;\n" + 
		"\n" + 
		"public class ~name~ {\n" + 
		" \n" + 
		"   public class ~name~Symbol {\n" + 
		"      \n" + 
		"   }\n" + 
		"~elements:{it|\n" + 
		"   ~it~\n" + 
		"};separator=\"\\n\"~   \n" + 
		"}>>\n")
			.append("block(ebnfSuffix,elements) ::= <<(~elements:{it|~it~};separator=\" \"~)~ebnfSuffix~>>\n")
		.toString();
}