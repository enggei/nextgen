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

   public NeoVisitorST newNeoVisitor() {
      return new NeoVisitorST(stGroup);
   }

   public BaseNodeVisitorST newBaseNodeVisitor() {
      return new BaseNodeVisitorST(stGroup);
   }

   public BaseParserListenerST newBaseParserListener() {
      return new BaseParserListenerST(stGroup);
   }

   public final class NeoVisitorST implements AntlrGroupTemplate {

      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parserIsSet = new AtomicBoolean(false);
      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private NeoVisitorST(STGroup group) {
   		template = group.getInstanceOf("NeoVisitor");
   	}

      public NeoVisitorST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      }
      public NeoVisitorST setParser(Object value) {
      	tryToSetStringProperty(template, value, parserIsSet, "parser");   
         return this;
      }
      public NeoVisitorST addMethodsValue(Object name_, Object param_) {
         methodsIsSet.set(true);
         template.addAggr("methods.{name, param}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (param_==null || param_.toString().length()==0) ? null : param_));
         return this;
      }
      public NeoVisitorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class BaseNodeVisitorST implements AntlrGroupTemplate {

      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parserIsSet = new AtomicBoolean(false);
      private final ST template;

      private BaseNodeVisitorST(STGroup group) {
   		template = group.getInstanceOf("BaseNodeVisitor");
   	}

      public BaseNodeVisitorST addMethodsValue(Object name_, Object param_) {
         methodsIsSet.set(true);
         template.addAggr("methods.{name, param}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (param_==null || param_.toString().length()==0) ? null : param_));
         return this;
      }
      public BaseNodeVisitorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public BaseNodeVisitorST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      }
      public BaseNodeVisitorST setParser(Object value) {
      	tryToSetStringProperty(template, value, parserIsSet, "parser");   
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class BaseParserListenerST implements AntlrGroupTemplate {

      private final AtomicBoolean methodsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean parserIsSet = new AtomicBoolean(false);
      private final ST template;

      private BaseParserListenerST(STGroup group) {
   		template = group.getInstanceOf("BaseParserListener");
   	}

      public BaseParserListenerST addMethodsValue(Object param_, Object name_) {
         methodsIsSet.set(true);
         template.addAggr("methods.{param, name}", ( (param_==null || param_.toString().length()==0) ? null : param_), ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      }
      public BaseParserListenerST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      }
      public BaseParserListenerST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      }
      public BaseParserListenerST setParser(Object value) {
      	tryToSetStringProperty(template, value, parserIsSet, "parser");   
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "AntlrGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = "delimiters \"~\", \"~\"\n" + 
	"\n" + 
	"eom() ::= <<}>>\n" + 
	"\n" + 
	"gt() ::= <<> >>\n" + 
	"\n" + 
	"NeoVisitor(packageName,parser,methods,name) ::= <<package ~packageName~;\n" + 
	"\n" + 
	"import org.neo4j.graphdb.Node;\n" + 
	"import org.neo4j.graphdb.Label;\n" + 
	"import org.neo4j.graphdb.RelationshipType;\n" + 
	"\n" + 
	"public class ~name~ extends ~parser~ParserBaseVisitor<Node> {\n" + 
	"\n" + 
	"   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" + 
	"	private final com.generator.editors.NeoModel model;\n" + 
	"\n" + 
	"	public ~name~(com.generator.editors.NeoModel model) {\n" + 
	"		this.model = model;\n" + 
	"	}\n" + 
	"\n" + 
	"   protected void onEnter(Node node) {\n" + 
	"      if (!nodeStack.isEmpty())\n" + 
	"         com.generator.editors.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName(\"child\"));\n" + 
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
	"		final Node node = model.findOrCreate(Label.label(\"~it.name~\"), \"text\", arg.getText());\n" + 
	"      onEnter(node);\n" + 
	"      visitChildren(arg);\n" + 
	"      onExit();\n" + 
	"      return node;\n" + 
	"	~eom()~\n" + 
	"};separator=\"\\n\"~\n" + 
	"}\n" + 
	">>\n" + 
	"\n" + 
	"BaseNodeVisitor(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
	"\n" + 
	"public class ~name~ extends ~parser~ParserBaseVisitor<~name~.Node> {\n" + 
	"\n" + 
	"   public static class Node {\n" + 
	"\n" + 
	"      public final String name;\n" + 
	"      public final String value;\n" + 
	"      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();\n" + 
	"\n" + 
	"      public Node(String name, String value) {\n" + 
	"         this.name = name;\n" + 
	"         this.value = value;\n" + 
	"      }\n" + 
	"   }\n" + 
	"\n" + 
	"   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" + 
	"\n" + 
	"   void onEnter(Node node) {\n" + 
	"      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);\n" + 
	"      nodeStack.push(node);\n" + 
	"   }\n" + 
	"\n" + 
	"   void onExit() {\n" + 
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
	"		final Node node = new Node(\"GrammarSpec\", arg.getText());\n" + 
	"		onEnter(node);\n" + 
	"      visitChildren(arg);\n" + 
	"      onExit();\n" + 
	"      return node;\n" + 
	"	~eom()~\n" + 
	"};separator=\"\\n\"~\n" + 
	"}\n" + 
	">>\n" + 
	"\n" + 
	"BaseParserListener(methods,name,packageName,parser) ::= <<package ~packageName~;\n" + 
	"\n" + 
	"public class ~name~ extends ~parser~ParserBaseListener {\n" + 
	"\n" + 
	"   public static class Node {\n" + 
	"\n" + 
	"      public final String name;\n" + 
	"      public final String value;\n" + 
	"      public final String startToken;\n" + 
	"      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();\n" + 
	"\n" + 
	"      public Node(String name, String value, String startToken) {\n" + 
	"         this.name = name;\n" + 
	"         this.value = value;\n" + 
	"			this.startToken = startToken;\n" + 
	"      }\n" + 
	"   }\n" + 
	"\n" + 
	"   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" + 
	"\n" + 
	"   void onEnter(Node node) {\n" + 
	"      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);\n" + 
	"      nodeStack.push(node);\n" + 
	"   }\n" + 
	"\n" + 
	"   void onExit() {\n" + 
	"      if (nodeStack.size() > 1) nodeStack.pop();\n" + 
	"   }\n" + 
	"\n" + 
	"   public Node getRoot() {\n" + 
	"      return nodeStack.peek();\n" + 
	"   }\n" + 
	"\n" + 
	"~methods:{it|\n" + 
	"	@Override\n" + 
	"	public void enter~it.name~(~it.param~ arg) {\n" + 
	"		 //System.out.println(\"~it.name~\");\n" + 
	"		 //System.out.println(\"\\t\"+ arg.getText());\n" + 
	"		 onEnter(new Node(\"~it.name~\", arg.getText(), arg.getStart().getText()));\n" + 
	"	~eom()~\n" + 
	"\n" + 
	"	public void exit~it.name~(~it.param~ arg) {\n" + 
	"		 onExit();\n" + 
	"	~eom()~\n" + 
	"};separator=\"\\n\"~\n" + 
	"}\n" + 
	">>\n" + 
	"\n" + 
	"";
}