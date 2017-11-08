package com.generator.generators.domain;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'DomainPlugin.stg' file<br/>
 */
public final class DomainPluginGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public DomainPluginGroup() {
		this(new STGroupString(stg));
   }

   public DomainPluginGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public DomainPluginGroup(java.io.File templateFile) {
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

	public interface DomainPluginGroupTemplate {

	}

   public EntityMethodsST newEntityMethods() {
      return new EntityMethodsST(stGroup);
   }

   public DomainPluginST newDomainPlugin() {
      return new DomainPluginST(stGroup);
   }

   public final class EntityMethodsST implements DomainPluginGroupTemplate {

      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private EntityMethodsST(STGroup group) {
   		template = group.getInstanceOf("EntityMethods");
   	}

      public EntityMethodsST setName(Object value) {
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

      public EntityMethodsST addPropertiesValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._properties.add(map);

         template.addAggr("properties.{name}", map.get("name"));
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

   public final class DomainPluginST implements DomainPluginGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _relations = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _rootRelations = new java.util.LinkedHashSet<>();
      private Object _title;
      private java.util.Set<java.util.Map<String, Object>> _entities = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _entityProperties = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _entityRelations = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private DomainPluginST(STGroup group) {
   		template = group.getInstanceOf("DomainPlugin");
   	}

      public DomainPluginST addRelationsValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._relations.add(map);

         template.addAggr("relations.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRelations() {
      	return this._relations;
      }

      public DomainPluginST addRootRelationsValue(Object entity_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("entity", (entity_ == null || entity_.toString().length() == 0) ? null : entity_);
      	this._rootRelations.add(map);

         template.addAggr("rootRelations.{entity}", map.get("entity"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRootRelations() {
      	return this._rootRelations;
      }

      public DomainPluginST setTitle(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._title == null) {
            this._title = value;
         	template.add("title", value);
         }

      	return this;
      }

      public String getTitle() {
      	return (String) this._title;
      }

      public DomainPluginST addEntitiesValue(Object methods_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("methods", (methods_ == null || methods_.toString().length() == 0) ? null : methods_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._entities.add(map);

         template.addAggr("entities.{methods, name}", map.get("methods"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEntities() {
      	return this._entities;
      }

      public DomainPluginST addEntityPropertiesValue(Object entityName_, Object propertyName_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("entityName", (entityName_ == null || entityName_.toString().length() == 0) ? null : entityName_);
      	map.put("propertyName", (propertyName_ == null || propertyName_.toString().length() == 0) ? null : propertyName_);
      	this._entityProperties.add(map);

         template.addAggr("entityProperties.{entityName, propertyName}", map.get("entityName"), map.get("propertyName"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEntityProperties() {
      	return this._entityProperties;
      }

      public DomainPluginST addEntityRelationsValue(Object cardinality_, Object dst_, Object relation_, Object src_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("cardinality", (cardinality_ == null || cardinality_.toString().length() == 0) ? null : cardinality_);
      	map.put("dst", (dst_ == null || dst_.toString().length() == 0) ? null : dst_);
      	map.put("relation", (relation_ == null || relation_.toString().length() == 0) ? null : relation_);
      	map.put("src", (src_ == null || src_.toString().length() == 0) ? null : src_);
      	this._entityRelations.add(map);

         template.addAggr("entityRelations.{cardinality, dst, relation, src}", map.get("cardinality"), map.get("dst"), map.get("relation"), map.get("src"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEntityRelations() {
      	return this._entityRelations;
      }

      public DomainPluginST setName(Object value) {
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

      public DomainPluginST setPackageName(Object value) {
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

      public DomainPluginST addPropertiesValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._properties.add(map);

         template.addAggr("properties.{name}", map.get("name"));
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "DomainPluginGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("EntityMethods(name,properties) ::= <<protected Node new~name~() { return new~name~(getGraph()); } \n" + 
		"public static Node new~name~(NeoModel graph) { return newInstanceNode(graph, Entities.~name~.name(), entitiesNodeMap.get(Entities.~name~)); }~if(properties)~ \n" + 
		"protected Node new~name~(~properties:{it|Object ~it.name~};separator=\", \"~) { return new~name~(getGraph(), ~properties:{it|~it.name~};separator=\", \"~); } \n" + 
		"public static Node new~name~(NeoModel graph, ~properties:{it|Object ~it.name~};separator=\", \"~) {  	\n" + 
		"	final Node newNode = new~name~(graph); 	\n" + 
		"	~properties:{it|if (~it.name~ != null) relate(newNode, newValueNode(graph, ~it.name~), RelationshipType.withName(Properties.~it.name~.name()));};separator=\"\\n\"~ 	\n" + 
		"	return newNode; \n" + 
		"}~endif~>>\n")
			.append("DomainPlugin(relations,rootRelations,title,entities,entityProperties,entityRelations,name,packageName,properties) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.generator.app.App;\n" + 
		"import com.generator.app.AppMotif;\n" + 
		"import com.generator.app.Plugin;\n" + 
		"import com.generator.app.nodes.NeoNode;\n" + 
		"import com.generator.generators.domain.DomainPlugin;\n" + 
		"import com.generator.neo.NeoModel;\n" + 
		"import org.neo4j.graphdb.*;\n" + 
		"\n" + 
		"import javax.swing.*;\n" + 
		"import java.util.LinkedHashMap;\n" + 
		"import java.util.Map;\n" + 
		"import java.util.Set;\n" + 
		"\n" + 
		"import static com.generator.app.DomainMotif.*;\n" + 
		"import static com.generator.generators.domain.DomainDomainPlugin.Entities.Domain;\n" + 
		"import static com.generator.util.NeoUtil.*;\n" + 
		"\n" + 
		"/**\n" + 
		" * Auto-generated from domain ~name~\n" + 
		" */\n" + 
		"public abstract class ~name~ extends Plugin {\n" + 
		"\n" + 
		"	public enum Entities implements Label {\n" + 
		"      ~entities:{it|~it.name~};separator=\", \"~\n" + 
		"   }\n" + 
		"\n" + 
		"   public enum Relations implements RelationshipType {\n" + 
		"      ~relations:{it|~it.name~};separator=\", \"~\n" + 
		"   }\n" + 
		"\n" + 
		"   public enum Properties {\n" + 
		"      ~properties:{it|~it.name~};separator=\", \"~\n" + 
		"   }\n" + 
		"\n" + 
		"	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();\n" + 
		"\n" + 
		"	private final Node domainNode;\n" + 
		"\n" + 
		"   ~name~(App app) {\n" + 
		"      super(app, \"~title~\");\n" + 
		"\n" + 
		"		domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), \"~title~\");\n" + 
		"		~entities:{it|entitiesNodeMap.put(Entities.~it.name~, newDomainEntity(getGraph(), Entities.~it.name~, domainNode));};separator=\"\\n\"~\n" + 
		"		\n" + 
		"		~entityProperties:{it|newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.~it.entityName~), Properties.~it.propertyName~.name());};separator=\"\\n\"~\n" + 
		"		\n" + 
		"		~rootRelations:{it|relate(domainNode, entitiesNodeMap.get(Entities.~it.entity~), DomainPlugin.Relations.ENTITY);};separator=\"\\n\"~\n" + 
		"		~entityRelations:{it|newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.~it.src~), Relations.~it.relation~.name(), DomainPlugin.RelationCardinality.~it.cardinality~, entitiesNodeMap.get(Entities.~it.dst~));};separator=\"\\n\"~\n" + 
		"   }\n" + 
		"\n" + 
		"   @Override\n" + 
		"   protected Label[] getLabels() {\n" + 
		"      return Entities.values();\n" + 
		"   }\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {\n" + 
		"		~entities:{it|if (is~it.name~(neoNode.getNode())) handle~it.name~(pop, neoNode, selectedNodes);};separator=\"\\n\"~\n" + 
		"   }\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public JComponent getEditorFor(NeoNode neoNode) {\n" + 
		"		~entities:{it|if (is~it.name~(neoNode.getNode())) return new~it.name~Editor(neoNode);};separator=\"\\n\"~\n" + 
		"      return null;\n" + 
		"   }\n" + 
		"\n" + 
		"	protected Node getDomainNode() { return domainNode; }\n" + 
		"\n" + 
		"	~entities:{it|protected void handle~it.name~(JPopupMenu pop, NeoNode ~it.name;format=\"lowFirst\"~Node, Set<NeoNode> selectedNodes) { ~eom()~};separator=\"\\n\"~	\n" + 
		"\n" + 
		"	~entities:{it|protected JComponent new~it.name~Editor(NeoNode ~it.name;format=\"lowFirst\"~Node) { return null; ~eom()~};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~entities:{it|public static boolean is~it.name~(Node node) { return hasLabel(node, Entities.~it.name~); ~eom()~};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~entities:{it|\n" + 
		"~it.methods~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~relations:{it|public static void outgoing~it.name~(Node src, RelationConsumer consumer) { outgoing(src, Relations.~it.name~).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); ~eom()~\n" + 
		"public static Node singleOutgoing~it.name~(Node src) { return other(src, singleOutgoing(src, Relations.~it.name~)); ~eom()~\n" + 
		"public static void incoming~it.name~(Node src, RelationConsumer consumer) { incoming(src, Relations.~it.name~).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); ~eom()~\n" + 
		"public static Node singleIncoming~it.name~(Node src) { return other(src, singleIncoming(src, Relations.~it.name~)); ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~relations:{it|public static Relationship relate~it.name~(Node src, Node dst) { return relate(src, dst, Relations.~it.name~); ~eom()~};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~properties:{it|// ~it.name~\n" + 
		"public static <T> T get~it.name;format=\"capitalize\"~Property(PropertyContainer container) { return getEntityProperty(container, Properties.~it.name~.name()); ~eom()~\n" + 
		"public static <T> T get~it.name;format=\"capitalize\"~Property(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.~it.name~.name(), defaultValue); ~eom()~\n" + 
		"public static boolean has~it.name;format=\"capitalize\"~Property(PropertyContainer container) { return hasEntityProperty(container, Properties.~it.name~.name()); ~eom()~\n" + 
		"public static <T extends PropertyContainer> T set~it.name;format=\"capitalize\"~Property(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.~it.name~.name(), value); return container; ~eom()~\n" + 
		"protected <T extends PropertyContainer> T set~it.name;format=\"capitalize\"~Property(T container, Object value) { setEntityProperty(getGraph(), container, Properties.~it.name~.name(), value); return container; ~eom()~\n" + 
		"public static <T extends PropertyContainer> T remove~it.name;format=\"capitalize\"~Property(T container) { removeEntityProperty(container, Properties.~it.name~.name()); return container; ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
		.toString();
}