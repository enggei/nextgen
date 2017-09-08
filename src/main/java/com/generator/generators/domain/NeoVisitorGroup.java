package com.generator.generators.domain;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'NeoVisitor.stg' file<br/>
 */
public final class NeoVisitorGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public NeoVisitorGroup() {
		this(new STGroupString(stg));
   }

   public NeoVisitorGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public NeoVisitorGroup(java.io.File templateFile) {
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

	public interface NeoVisitorGroupTemplate {

	}

   public DomainVisitorST newDomainVisitor() {
      return new DomainVisitorST(stGroup);
   } 

   public entityVisitST newentityVisit() {
      return new entityVisitST(stGroup);
   } 

   public final class DomainVisitorST implements NeoVisitorGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean entitiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private DomainVisitorST(STGroup group) {
   		template = group.getInstanceOf("DomainVisitor");
   	}

      public DomainVisitorST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public DomainVisitorST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public DomainVisitorST addEntitiesValue(Object name_, Object visit_) {
         entitiesIsSet.set(true);
         template.addAggr("entities.{name, visit}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (visit_==null || visit_.toString().length()==0) ? null : visit_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class entityVisitST implements NeoVisitorGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean outgoingIsSet = new AtomicBoolean(false);
      private final ST template;

      private entityVisitST(STGroup group) {
   		template = group.getInstanceOf("entityVisit");
   	}

      public entityVisitST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public entityVisitST addOutgoingValue(Object value) {
      	tryToSetListProperty(template, value, outgoingIsSet, "outgoing");
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "NeoVisitorGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
		.append("DomainVisitor(name,packageName,entities) ::= <<package ~packageName~;\n" + 
	"\n" + 
	"import org.neo4j.graphdb.*;\n" + 
	"\n" + 
	"public abstract class ~name~ {\n" + 
	"\n" + 
	"      final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();\n" + 
	"\n" + 
	"      public void visit(Node node) {\n" + 
	"			~entities:{it|if(hasLabel(node, \"~it.name~\")) visit~it.name;format=\"capitalize\"~(node);};separator=\"\\n\"~\n" + 
	"      }\n" + 
	"\n" + 
	"		~entities:{it|~it.visit~};separator=\"\\n\\n\"~\n" + 
	"\n" + 
	"		private boolean hasLabel(Node node, String label) {\n" + 
	"      	for (org.neo4j.graphdb.Label lbl : node.getLabels())\n" + 
	"         	if (lbl.name().equals(label)) return true;\n" + 
	"      	return false;\n" + 
	"   	}\n" + 
	"\n" + 
	"		private Iterable<Relationship> outgoing(Node node, RelationshipType type) {\n" + 
	"      	return node == null ? java.util.Collections.emptyList() : node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type);\n" + 
	"   	}\n" + 
	"\n" + 
	"		private Node other(Node node, Relationship relationship) {\n" + 
	"      	return relationship == null ? null : relationship.getOtherNode(node);\n" + 
	"   	}\n" + 
	"} >>\n")
		.append("entityVisit(name,outgoing) ::= <<void visit~name;format=\"capitalize\"~(Node node) {\n" + 
	"	if (visited.contains(node)) return;\n" + 
	"   visited.add(node);\n" + 
	"	~outgoing:{it|outgoing(node, RelationshipType.withName(\"~it~\")).forEach(relationship -> visit(other(node, relationship)));};separator=\"\\n\"~\n" + 
	"} >>\n").toString();
} 