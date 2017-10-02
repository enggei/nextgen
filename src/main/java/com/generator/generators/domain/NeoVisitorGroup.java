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

      private Object _name;
      private Object _packageName;
      private java.util.Set<java.util.Map<String, Object>> _entities = new java.util.LinkedHashSet<>();

      private final ST template;

      private DomainVisitorST(STGroup group) {
   		template = group.getInstanceOf("DomainVisitor");
   	}

      public DomainVisitorST setName(Object value) {
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

      public DomainVisitorST setPackageName(Object value) {
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

      public DomainVisitorST addEntitiesValue(Object name_, Object visit_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("visit", (visit_ == null || visit_.toString().length() == 0) ? null : visit_);
      	this._entities.add(map);

         template.addAggr("entities.{name, visit}", map.get("name"), map.get("visit"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEntities() {
      	return this._entities;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class entityVisitST implements NeoVisitorGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _outgoing = new java.util.LinkedHashSet<>();

      private final ST template;

      private entityVisitST(STGroup group) {
   		template = group.getInstanceOf("entityVisit");
   	}

      public entityVisitST setName(Object value) {
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

      public entityVisitST addOutgoingValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._outgoing.add(value);
      	template.add("outgoing", value);

         return this;
      }

      public java.util.Set<Object> getOutgoingValues() {
      	return this._outgoing;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "NeoVisitorGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("DomainVisitor(name,packageName,entities) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.neo4j.graphdb.*;\n" + 
		"\n" + 
		"public abstract class ~name~ {\n" + 
		"\n" + 
		"	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();\n" + 
		"\n" + 
		"   public void visit(Node node) {\n" + 
		"		~entities:{it|if(hasLabel(node, \"~it.name~\")) visit~it.name;format=\"capitalize\"~(node);};separator=\"\\nelse \"~\n" + 
		"   }\n" + 
		"\n" + 
		"	~entities:{it|~it.visit~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"	private boolean hasLabel(Node node, String label) {\n" + 
		"   	for (org.neo4j.graphdb.Label lbl : node.getLabels())\n" + 
		"      	if (lbl.name().equals(label)) return true;\n" + 
		"      return false;\n" + 
		"   }\n" + 
		"\n" + 
		"	protected Iterable<Relationship> outgoing(Node node, RelationshipType type) {\n" + 
		"     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type));\n" + 
		"   }\n" + 
		"\n" + 
		"	protected Iterable<Relationship> outgoing(Node node) {\n" + 
		"     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING));\n" + 
		"   }\n" + 
		"\n" + 
		"	protected static Iterable<Relationship> sort(Iterable<Relationship> relationships) {\n" + 
		"		final java.util.Set<Relationship> relations = new java.util.TreeSet<>(java.util.Comparator.comparingLong(Relationship::getId));\n" + 
		"		for (Relationship relationship : relationships)\n" + 
		"			relations.add(relationship);\n" + 
		"		return relations;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected Node other(Node node, Relationship relationship) {\n" + 
		"     	return relationship == null ? null : relationship.getOtherNode(node);\n" + 
		"   }\n" + 
		"}>>\n")
			.append("entityVisit(name,outgoing) ::= <<public void visit~name;format=\"capitalize\"~(Node node) {\n" + 
		"	if (visited.contains(node)) return;\n" + 
		"   visited.add(node);\n" + 
		"~if(outgoing)~\n" + 
		"	~outgoing:{it|outgoing(node, RelationshipType.withName(\"~it~\")).forEach(relationship -> visit(other(node, relationship)));};separator=\"\\n\"~\n" + 
		"~else~\n" + 
		"	outgoing(node).forEach(relationship -> visit(other(node, relationship)));\n" + 
		"~endif~\n" + 
		"}>>\n")
		.toString();
}