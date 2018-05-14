package com.generator.generators.esperCEP;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'EsperCEP.stg' file<br/>
 */
public final class EsperCEPGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public EsperCEPGroup() {
		this(new STGroupString(stg));
   }

   public EsperCEPGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public EsperCEPGroup(java.io.File templateFile) {
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

	public interface EsperCEPGroupTemplate {

	}

   public mvnST newmvn() {
      return new mvnST(stGroup);
   }

   public StatementST newStatement() {
      return new StatementST(stGroup);
   }

   public final class mvnST implements EsperCEPGroupTemplate {


      private final ST template;

      private mvnST(STGroup group) {
   		template = group.getInstanceOf("mvn");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class StatementST implements EsperCEPGroupTemplate {

      private Object _packageName;
      private java.util.Set<java.util.Map<String, Object>> _columns = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _description;
      private Object _eventName;
      private Object _query;

      private final ST template;

      private StatementST(STGroup group) {
   		template = group.getInstanceOf("Statement");
   	}

      public StatementST setPackageName(Object value) {
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

      public StatementST addColumnsValue(Object type_, Object colName_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("colName", (colName_ == null || colName_.toString().length() == 0) ? null : colName_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._columns.add(map);

         template.addAggr("columns.{type, colName, name}", map.get("type"), map.get("colName"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getColumns() {
      	return this._columns;
      }

      public StatementST setName(Object value) {
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

      public StatementST setDescription(Object value) {
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

      public StatementST setEventName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._eventName == null) {
            this._eventName = value;
         	template.add("eventName", value);
         }

      	return this;
      }

      public String getEventName() {
      	return (String) this._eventName;
      }

      public StatementST setQuery(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._query == null) {
            this._query = value;
         	template.add("query", value);
         }

      	return this;
      }

      public String getQuery() {
      	return (String) this._query;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "EsperCEPGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("mvn() ::= <<<!-- https://mvnrepository.com/artifact/com.espertech/esper -->\n" + 
		"<dependency>\n" + 
		"    <groupId>com.espertech</groupId>\n" + 
		"    <artifactId>esper</artifactId>\n" + 
		"    <version>7.1.0</version>\n" + 
		"</dependency> >>\n")
			.append("Statement(packageName,columns,name,description,eventName,query) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.espertech.esper.client.EPServiceProvider;\n" + 
		"import com.espertech.esper.client.EPStatement;\n" + 
		"import com.espertech.esper.client.EventBean;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import org.neo4j.graphdb.GraphDatabaseService;\n" + 
		"import org.neo4j.graphdb.Label;\n" + 
		"import org.neo4j.graphdb.Node;\n" + 
		"\n" + 
		"import java.util.UUID;\n" + 
		"\n" + 
		"/**\n" + 
		" * ~description~\n" + 
		" */\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"   public ~name~(EPServiceProvider engine, ~eventName~Listener ...listener) {\n" + 
		"      \n" + 
		"		engine.getEPAdministrator().getConfiguration().addEventType(~eventName~.class);\n" + 
		"\n" + 
		"      final EPStatement statement = engine.getEPAdministrator().createEPL(\"~query~\");\n" + 
		"\n" + 
		"      for (~eventName~Listener eventListener : listener) {\n" + 
		"         statement.addListener((newEvents, oldEvents) -> {\n" + 
		"            for (EventBean event : newEvents) {\n" + 
		"               eventListener.onEvent(new ~eventName~(event));\n" + 
		"            }\n" + 
		"         });\n" + 
		"      }\n" + 
		"   }\n" + 
		"   \n" + 
		"   public interface ~eventName~Listener {\n" + 
		"      \n" + 
		"      void onEvent(~eventName~ event);\n" + 
		"      \n" + 
		"   }\n" + 
		"   \n" + 
		"   public static final class ~eventName~ {\n" + 
		"\n" + 
		"		private final String uuid;\n" + 
		"      ~columns:{it|private final ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"		public ~eventName~(~columns:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
		"         this.uuid = UUID.randomUUID().toString();\n" + 
		"			~columns:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
		"      }\n" + 
		"\n" + 
		"		public ~eventName~(JsonObject jsonObject) {\n" + 
		"         this.uuid = jsonObject.getString(\"uuid\", UUID.randomUUID().toString());\n" + 
		"			~columns:{it|this.~it.name~ = jsonObject.get~it.type~(\"~it.name~\");};separator=\"\\n\"~\n" + 
		"      }\n" + 
		"\n" + 
		"		public ~eventName~(Node node) {\n" + 
		"         this.uuid = (String) node.getProperty(\"uuid\");\n" + 
		"			~columns:{it|this.~it.name~ = (~it.type~) node.getProperty(\"~it.name~\");};separator=\"\\n\"~\n" + 
		"      }\n" + 
		"\n" + 
		"		~eventName~(EventBean event) {\n" + 
		"   		this.uuid = UUID.randomUUID().toString();\n" + 
		"			~columns:{it|this.~it.name~ = (~it.type~) event.get(\"~it.colName~\");};separator=\"\\n\"~\n" + 
		"		}\n" + 
		"\n" + 
		"		public JsonObject toJson() {\n" + 
		"         return new JsonObject().\n" + 
		"					put(\"uuid\", uuid).\n" + 
		"               ~columns:{it|put(\"~it.name~\", ~it.name~)};separator=\".\\n\"~;\n" + 
		"      }\n" + 
		"\n" + 
		"		public Node toNode(GraphDatabaseService db) {\n" + 
		"         \n" + 
		"         Node node = db.findNode(Label.label(\"~eventName~\"), \"uuid\", uuid);\n" + 
		"         if (node == null) node = db.createNode(Label.label(\"~eventName~\"));\n" + 
		"\n" + 
		"			node.setProperty(\"uuid\", uuid);\n" + 
		"			~columns:{it|node.setProperty(\"~it.name~\", ~it.name~);};separator=\"\\n\"~\n" + 
		"\n" + 
		"         return node;\n" + 
		"      }\n" + 
		"	}\n" + 
		"}>>\n")
		.toString();
}