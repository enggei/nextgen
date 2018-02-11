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

   public EntityMessageHandlerST newEntityMessageHandler() {
      return new EntityMessageHandlerST(stGroup);
   }

   public DomainVerticleST newDomainVerticle() {
      return new DomainVerticleST(stGroup);
   }

   public newEntityNodeParametersST newnewEntityNodeParameters() {
      return new newEntityNodeParametersST(stGroup);
   }

   public DomainVerticleFacadeST newDomainVerticleFacade() {
      return new DomainVerticleFacadeST(stGroup);
   }

   public DomainFacadeEntityMessagesST newDomainFacadeEntityMessages() {
      return new DomainFacadeEntityMessagesST(stGroup);
   }

   public DomainPluginST newDomainPlugin() {
      return new DomainPluginST(stGroup);
   }

   public VisitorST newVisitor() {
      return new VisitorST(stGroup);
   }

   public final class EntityMethodsST implements DomainPluginGroupTemplate {

      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private Object _entity;

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

      public EntityMethodsST setEntity(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._entity == null) {
            this._entity = value;
         	template.add("entity", value);
         }

      	return this;
      }

      public String getEntity() {
      	return (String) this._entity;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class EntityMessageHandlerST implements DomainPluginGroupTemplate {

      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private EntityMessageHandlerST(STGroup group) {
   		template = group.getInstanceOf("EntityMessageHandler");
   	}

      public EntityMessageHandlerST setLabel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._label == null) {
            this._label = value;
         	template.add("label", value);
         }

      	return this;
      }

      public String getLabel() {
      	return (String) this._label;
      }

      public EntityMessageHandlerST addPropertiesValue(Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._properties.add(map);

         template.addAggr("properties.{name, type}", map.get("name"), map.get("type"));
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

   public final class DomainVerticleST implements DomainPluginGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _relateEntities = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _entities = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _visitors = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _incoming = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _outgoing = new java.util.LinkedHashSet<>();
      private Object _package;
      private Object _domain;

      private final ST template;

      private DomainVerticleST(STGroup group) {
   		template = group.getInstanceOf("DomainVerticle");
   	}

      public DomainVerticleST addRelateEntitiesValue(Object dst_, Object src_, Object relationshipType_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("dst", (dst_ == null || dst_.toString().length() == 0) ? null : dst_);
      	map.put("src", (src_ == null || src_.toString().length() == 0) ? null : src_);
      	map.put("relationshipType", (relationshipType_ == null || relationshipType_.toString().length() == 0) ? null : relationshipType_);
      	this._relateEntities.add(map);

         template.addAggr("relateEntities.{dst, src, relationshipType}", map.get("dst"), map.get("src"), map.get("relationshipType"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRelateEntities() {
      	return this._relateEntities;
      }

      public DomainVerticleST addEntitiesValue(Object label_, Object messageHandlers_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("label", (label_ == null || label_.toString().length() == 0) ? null : label_);
      	map.put("messageHandlers", (messageHandlers_ == null || messageHandlers_.toString().length() == 0) ? null : messageHandlers_);
      	this._entities.add(map);

         template.addAggr("entities.{label, messageHandlers}", map.get("label"), map.get("messageHandlers"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEntities() {
      	return this._entities;
      }

      public DomainVerticleST addVisitorsValue(Object name_, Object class_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("class", (class_ == null || class_.toString().length() == 0) ? null : class_);
      	this._visitors.add(map);

         template.addAggr("visitors.{name, class}", map.get("name"), map.get("class"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getVisitors() {
      	return this._visitors;
      }

      public DomainVerticleST addIncomingValue(Object address_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._incoming.add(map);

         template.addAggr("incoming.{address, name}", map.get("address"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getIncoming() {
      	return this._incoming;
      }

      public DomainVerticleST setName(Object value) {
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

      public DomainVerticleST addOutgoingValue(Object address_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._outgoing.add(map);

         template.addAggr("outgoing.{address, name}", map.get("address"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getOutgoing() {
      	return this._outgoing;
      }

      public DomainVerticleST setPackage(Object value) {
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

      public DomainVerticleST setDomain(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class newEntityNodeParametersST implements DomainPluginGroupTemplate {

      private Object _action;
      private Object _label;

      private final ST template;

      private newEntityNodeParametersST(STGroup group) {
   		template = group.getInstanceOf("newEntityNodeParameters");
   	}

      public newEntityNodeParametersST setAction(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._action == null) {
            this._action = value;
         	template.add("action", value);
         }

      	return this;
      }

      public String getAction() {
      	return (String) this._action;
      }

      public newEntityNodeParametersST setLabel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._label == null) {
            this._label = value;
         	template.add("label", value);
         }

      	return this;
      }

      public String getLabel() {
      	return (String) this._label;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class DomainVerticleFacadeST implements DomainPluginGroupTemplate {

      private Object _domain;
      private java.util.Set<Object> _entities = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _relations = new java.util.LinkedHashSet<>();

      private final ST template;

      private DomainVerticleFacadeST(STGroup group) {
   		template = group.getInstanceOf("DomainVerticleFacade");
   	}

      public DomainVerticleFacadeST setDomain(Object value) {
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

      public DomainVerticleFacadeST addEntitiesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._entities.add(value);
      	template.add("entities", value);

         return this;
      }

      public java.util.Set<Object> getEntitiesValues() {
      	return this._entities;
      }

      public DomainVerticleFacadeST setName(Object value) {
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

      public DomainVerticleFacadeST setPackage(Object value) {
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

      public DomainVerticleFacadeST addRelationsValue(Object dst_, Object relationshipType_, Object src_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("dst", (dst_ == null || dst_.toString().length() == 0) ? null : dst_);
      	map.put("relationshipType", (relationshipType_ == null || relationshipType_.toString().length() == 0) ? null : relationshipType_);
      	map.put("src", (src_ == null || src_.toString().length() == 0) ? null : src_);
      	this._relations.add(map);

         template.addAggr("relations.{dst, relationshipType, src}", map.get("dst"), map.get("relationshipType"), map.get("src"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRelations() {
      	return this._relations;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class DomainFacadeEntityMessagesST implements DomainPluginGroupTemplate {

      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private DomainFacadeEntityMessagesST(STGroup group) {
   		template = group.getInstanceOf("DomainFacadeEntityMessages");
   	}

      public DomainFacadeEntityMessagesST setLabel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._label == null) {
            this._label = value;
         	template.add("label", value);
         }

      	return this;
      }

      public String getLabel() {
      	return (String) this._label;
      }

      public DomainFacadeEntityMessagesST addPropertiesValue(Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._properties.add(map);

         template.addAggr("properties.{name, type}", map.get("name"), map.get("type"));
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

   public final class VisitorST implements DomainPluginGroupTemplate {

      private java.util.Set<Object> _labels = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _paths = new java.util.LinkedHashSet<>();
      private Object _package;
      private Object _name;

      private final ST template;

      private VisitorST(STGroup group) {
   		template = group.getInstanceOf("Visitor");
   	}

      public VisitorST addLabelsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._labels.add(value);
      	template.add("labels", value);

         return this;
      }

      public java.util.Set<Object> getLabelsValues() {
      	return this._labels;
      }

      public VisitorST addPathsValue(Object path_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("path", (path_ == null || path_.toString().length() == 0) ? null : path_);
      	this._paths.add(map);

         template.addAggr("paths.{path}", map.get("path"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getPaths() {
      	return this._paths;
      }

      public VisitorST setPackage(Object value) {
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

      public VisitorST setName(Object value) {
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
			.append("EntityMethods(name,properties,entity) ::= <<protected Node new~name~() { return new~name~(getGraph()); }~if(properties)~ \n" + 
		"protected Node new~name~(~properties:{it|Object ~it.name~};separator=\", \"~) { return new~name~(getGraph(), ~properties:{it|~it.name~};separator=\", \"~); } \n" + 
		"~endif~\n" + 
		"\n" + 
		"public static Node new~name~(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.~name~)); }~if(properties)~ \n" + 
		"public static Node new~name~(NeoModel graph, ~properties:{it|Object ~it.name~};separator=\", \"~) {  	\n" + 
		"	final Node newNode = new~name~(graph); 	\n" + 
		"	~properties:{it|if (~it.name~ != null) relate(newNode, DomainMotif.newValueNode(graph, ~it.name~), RelationshipType.withName(Properties.~it.name~.name()));};separator=\"\\n\"~ 	\n" + 
		"	return newNode; \n" + 
		"}~endif~\n" + 
		"\n" + 
		"/* todo\n" + 
		"public Action new~name~Action() {\n" + 
		"	return new App.TransactionAction(\"New ~name~\", app) {\n" + 
		"		@Override\n" + 
		"   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {\n" + 
		"\n" + 
		"		final Map<String,String> properties = new java.util.HashMap<>();\n" + 
		"	~properties:{it|\n" + 
		"	   final String ~it.name~ = com.generator.util.SwingUtil.showInputDialog(\"~it.name~\", app);\n" + 
		"		if (~it.name~ != null && ~it.name~.length() > 0)\n" + 
		"			properties.put(\"~it.name~\", ~it.name~);\n" + 
		"	};separator=\"\\n\"~\n" + 
		"\n" + 
		"		if (properties.isEmpty()) return;\n" + 
		"\n" + 
		"	   //fireNodesLoaded(new~entity~());\n" + 
		"   	}\n" + 
		"	};\n" + 
		"}\n" + 
		"*/>>\n")
			.append("EntityMessageHandler(label,properties) ::= <<private void new~label~(Message<JsonObject> message) {\n" + 
		"   log.info(deploymentID() + \".new.~label~ \" + message.body().toString());\n" + 
		"\n" + 
		"   final JsonObject request = new JsonObject();\n" + 
		"   request.put(\"action\", \"createNode\");\n" + 
		"   request.put(\"label\", \"~label~\");\n" + 
		"\n" + 
		"   // todo add constraints - which properties are required for new ~label~\n" + 
		"\n" + 
		"   final JsonArray properties = new JsonArray();\n" + 
		"	~properties:{it|if (message.body().get~it.type~(\"~it.name~\") != null) properties.add(new JsonObject().put(\"name\", \"~it.name~\").put(\"value\", message.body().get~it.type~(\"~it.name~\")));};separator=\"\\n\"~\n" + 
		"   request.put(\"properties\", properties);\n" + 
		"\n" + 
		"   sendNeoMessage(message, request);\n" + 
		"}\n" + 
		"\n" + 
		"private void update~label~(Message<JsonObject> message) {\n" + 
		"   log.info(deploymentID() + \".update.~label~ \" + message.body().toString());\n" + 
		"\n" + 
		"   final JsonObject request = new JsonObject();\n" + 
		"   request.put(\"action\", \"updateNode\");\n" + 
		"   request.put(\"uuid\", message.body().getString(\"uuid\"));\n" + 
		"\n" + 
		"   final JsonArray properties = new JsonArray();\n" + 
		"	~properties:{it|if (message.body().get~it.type~(\"~it.name~\") != null) properties.add(new JsonObject().put(\"name\", \"~it.name~\").put(\"value\", message.body().get~it.type~(\"~it.name~\")));};separator=\"\\n\"~\n" + 
		"   request.put(\"properties\", properties);\n" + 
		"\n" + 
		"   sendNeoMessage(message, request);\n" + 
		"}\n" + 
		"\n" + 
		"private void get~label~(Message<JsonObject> message) {\n" + 
		"   log.info(deploymentID() + \".get.~label~ \" + message.body().toString());\n" + 
		"\n" + 
		"   final JsonObject request = new JsonObject();\n" + 
		"   request.put(\"action\", \"inspectNode\");\n" + 
		"   request.put(\"uuid\", message.body().getString(\"uuid\"));\n" + 
		"\n" + 
		"   sendNeoMessage(message, request);\n" + 
		"}\n" + 
		"\n" + 
		"private void list~label~(Message<JsonObject> message) {\n" + 
		"   log.info(deploymentID() + \".list.~label~ \" + message.body().toString());\n" + 
		"\n" + 
		"   final JsonObject request = new JsonObject();\n" + 
		"   request.put(\"action\", \"listNodesByLabel\");\n" + 
		"   request.put(\"label\", \"~label~\");\n" + 
		"   request.put(\"properties\", message.body().getJsonArray(\"properties\"));\n" + 
		"\n" + 
		"   sendNeoMessage(message, request);\n" + 
		"}\n" + 
		"\n" + 
		"private void remove~label~(Message<JsonObject> message) {\n" + 
		"   log.info(deploymentID() + \".remove.~label~ \" + message.body().toString());\n" + 
		"\n" + 
		"   final JsonObject request = new JsonObject();\n" + 
		"   request.put(\"action\", \"removeNode\");\n" + 
		"   request.put(\"uuid\", message.body().getString(\"uuid\"));\n" + 
		"   request.put(\"force\", message.body().getBoolean(\"force\"));\n" + 
		"   request.put(\"cascade\", message.body().getBoolean(\"cascade\"));\n" + 
		"\n" + 
		"   sendNeoMessage(message, request);\n" + 
		"}>>\n")
			.append("DomainVerticle(relateEntities,entities,visitors,incoming,name,outgoing,package,domain) ::= <<package ~package~;\n" + 
		"\n" + 
		"import com.generator.util.VertxUtil;\n" + 
		"\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"// Domain: ~domain~\n" + 
		"public class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"   protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(~name~.class);\n" + 
		"\n" + 
		"	private String neoAddress;\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public void start(Future<Void> startFuture) throws Exception {\n" + 
		"      log.info(\"Starting ~name~\");\n" + 
		"\n" + 
		"		neoAddress = config().getString(\"neo.instance\");\n" + 
		"\n" + 
		"		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {\n" + 
		"			@Override\n" + 
		"			public JsonObject execute() throws Throwable {\n" + 
		"				return onStart();\n" + 
		"			}\n" + 
		"\n" + 
		"			@Override\n" + 
		"			public void onSuccess(JsonObject result) {\n" + 
		"				log.info(\"~name~ started : \" + result.toString());\n" + 
		"				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject~gt()~>) message -> handleInstanceMessage(message));\n" + 
		"\n" + 
		"				~entities:{it| vertx.eventBus().consumer(deploymentID() + \".new.~it.label~\", (Handler<Message<JsonObject~gt()~>) message -> new~it.label~(message));\n" + 
		"vertx.eventBus().consumer(deploymentID() + \".update.~it.label~\", (Handler<Message<JsonObject~gt()~>) message -> update~it.label~(message)); \n" + 
		"vertx.eventBus().consumer(deploymentID() + \".get.~it.label~\", (Handler<Message<JsonObject~gt()~>) message -> get~it.label~(message)); \n" + 
		"vertx.eventBus().consumer(deploymentID() + \".list.~it.label~\", (Handler<Message<JsonObject~gt()~>) message -> list~it.label~(message)); \n" + 
		"vertx.eventBus().consumer(deploymentID() + \".remove.~it.label~\", (Handler<Message<JsonObject~gt()~>) message -> remove~it.label~(message)); };separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"				~relateEntities:{it| vertx.eventBus().consumer(deploymentID() + \".relate.~it.src~.~it.relationshipType~.~it.dst~\", (Handler<Message<JsonObject~gt()~>) message -> relate~it.src~_~it.relationshipType~_~it.dst~(message)); \n" + 
		"vertx.eventBus().consumer(deploymentID() + \".unrelate.~it.src~.~it.relationshipType~.~it.dst~\", (Handler<Message<JsonObject~gt()~>) message -> unrelate~it.src~_~it.relationshipType~_~it.dst~(message));};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"				~visitors:{it| vertx.eventBus().consumer(deploymentID() + \".visitor.~it.name~\", (Handler<Message<JsonObject~gt()~>) message -> visit~it.name~(message));};separator=\"\\n\"~\n" + 
		"\n" + 
		"				~incoming:{it| vertx.eventBus().consumer(\"~it.address~\", (Handler<Message<JsonObject~gt()~>) message -> handle~it.name~(message)); }~\n" + 
		"				startFuture.complete();\n" + 
		"			}\n" + 
		"\n" + 
		"			@Override\n" + 
		"			public void onFail(Throwable t) {\n" + 
		"				log.error(\"~name~ failed to start : \", t);\n" + 
		"				startFuture.fail(t);\n" + 
		"			}\n" + 
		"		});\n" + 
		"	}\n" + 
		"\n" + 
		"	protected JsonObject onStart() throws Exception { return new JsonObject(); } \n" + 
		"\n" + 
		"	~outgoing:{it|protected void publishTo~it.name~(JsonObject jsonObject) { vertx.eventBus().publish(\"~it.address~\", jsonObject); ~eom()~};separator=\"\\n\"~\n" + 
		"~entities:{it|\n" + 
		"	~it.messageHandlers~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~relateEntities:{it|protected void relate~it.src~_~it.relationshipType~_~it.dst~(Message<JsonObject> message) { \n" + 
		"	log.info(deploymentID() + \" -> relate.~it.src~.~it.relationshipType~.~it.dst~ -> \" + message.body().toString());\n" + 
		"\n" + 
		"	final JsonObject request = new JsonObject();\n" + 
		"   request.put(\"action\", \"relateNodes\");\n" + 
		"   request.put(\"src\", message.body().getString(\"src\"));\n" + 
		"   request.put(\"dst\", message.body().getString(\"dst\"));\n" + 
		"   request.put(\"relationshipType\", \"~it.relationshipType~\");\n" + 
		"	// todo add properties\n" + 
		"\n" + 
		"	sendNeoMessage(message, request);\n" + 
		"~eom()~\n" + 
		"\n" + 
		"protected void unrelate~it.src~_~it.relationshipType~_~it.dst~(Message<JsonObject> message) { \n" + 
		"	log.info(deploymentID() + \" -> unrelate.~it.src~.~it.relationshipType~.~it.dst~ -> \" + message.body().toString());\n" + 
		"\n" + 
		"	final JsonObject request = new JsonObject();\n" + 
		"   request.put(\"action\", \"unrelateNodes\");\n" + 
		"   request.put(\"src\", message.body().getString(\"src\"));\n" + 
		"   request.put(\"dst\", message.body().getString(\"dst\"));\n" + 
		"   request.put(\"relationshipType\", \"~it.relationshipType~\");\n" + 
		"\n" + 
		"	sendNeoMessage(message, request);\n" + 
		"~eom()~\n" + 
		"	};separator=\"\\n\"~\n" + 
		"	\n" + 
		"~visitors:{it| \n" + 
		"	private void visit~it.name~(Message<JsonObject> message) {\n" + 
		"   	log.info(deploymentID() + \" -> visitor.~it.name~ -> \" + message.body().toString());\n" + 
		"\n" + 
		"		final JsonObject request = new JsonObject();\n" + 
		"		request.put(\"action\", \"visitor\");\n" + 
		"		request.put(\"className\", ~it.class~.class.getCanonicalName());\n" + 
		"		request.put(\"params\", message.body());\n" + 
		"\n" + 
		"		sendNeoMessage(message, request);\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected void handleInstanceMessage(Message<JsonObject> message) { log.info(\"instance message \" + deploymentID() + \" -> \" + message.body().toString()); }\n" + 
		"\n" + 
		"	protected void sendNeoMessage(Message<JsonObject> message, JsonObject request) {\n" + 
		"		VertxUtil.sendMessage(vertx, neoAddress, request, log, new VertxUtil.SuccessHandler<Message<JsonObject>~gt()~() {\n" + 
		"			@Override\n" + 
		"			public void onSuccess(Message<JsonObject> result) {\n" + 
		"				message.reply(result.body());\n" + 
		"			}\n" + 
		"\n" + 
		"			@Override\n" + 
		"			public void onFail(Throwable t) {\n" + 
		"				message.reply(VertxUtil.newFail(t.getMessage()));\n" + 
		"			}\n" + 
		"		});\n" + 
		"	}\n" + 
		"}>>\n")
			.append("newEntityNodeParameters(action,label) ::= <<request.put(\"action\",\"~action~\");\n" + 
		"request.put(\"label\", \"~label~\");\n" + 
		"request.put(\"properties\", message.body().getJsonArray(\"properties\"));>>\n")
			.append("DomainVerticleFacade(domain,entities,name,package,relations) ::= <<package ~package~;\n" + 
		"\n" + 
		"import com.generator.util.VertxUtil;\n" + 
		"import io.vertx.core.Vertx;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import io.vertx.core.net.NetSocket;\n" + 
		"\n" + 
		"/**\n" + 
		" * ~domain~- Facade\n" + 
		" */\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"   private final String address;\n" + 
		"   private final String replyAddress;\n" + 
		"   private final NetSocket socket;\n" + 
		"\n" + 
		"   public ~name~(String address, String replyAddress, NetSocket socket) {\n" + 
		"      this.address = address;\n" + 
		"      this.replyAddress = replyAddress;\n" + 
		"      this.socket = socket;\n" + 
		"   }\n" + 
		"\n" + 
		"~entities:{it|\n" + 
		"	~it~\n" + 
		"};separator=\"\\n\"~\n" + 
		"   \n" + 
		"~relations:{it|\n" + 
		"   public void relate~it.src~_~it.relationshipType~_~it.dst~(String src, String dst) {\n" + 
		"\n" + 
		"      final JsonObject parameters = new JsonObject().\n" + 
		"            put(\"src\", src).\n" + 
		"            put(\"dst\", dst);\n" + 
		"\n" + 
		"      VertxUtil.sendFrame(log, address + \".relate.~it.src~.~it.relationshipType~.~it.dst~\", replyAddress, parameters, socket);\n" + 
		"   ~eom()~\n" + 
		"\n" + 
		"   public void unrelate~it.src~_~it.relationshipType~_~it.dst~(String src, String dst) {\n" + 
		"\n" + 
		"      final JsonObject parameters = new JsonObject().\n" + 
		"            put(\"src\", src).\n" + 
		"            put(\"dst\", dst);\n" + 
		"\n" + 
		"      VertxUtil.sendFrame(log, address + \".unrelate.~it.src~.~it.relationshipType~.~it.dst~\", replyAddress, parameters, socket);\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("DomainFacadeEntityMessages(label,properties) ::= <<public JsonObject new~label~(~properties:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
		"\n" + 
		"   final JsonObject parameters = new JsonObject()~properties:{it|.\n" + 
		"			put(\"~it.name~\", ~it.name~)}~;\n" + 
		"\n" + 
		"	return parameters;\n" + 
		"}\n" + 
		"\n" + 
		"public JsonObject update~label~(String uuid~if(properties)~, ~properties:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
		"\n" + 
		"   final JsonObject parameters = new JsonObject().\n" + 
		"         put(\"uuid\", uuid)~properties:{it|.\n" + 
		"			put(\"~it.name~\", ~it.name~)}~;\n" + 
		"\n" + 
		"	return parameters;\n" + 
		"}\n" + 
		"\n" + 
		"public JsonObject get~label~(String uuid) {\n" + 
		"\n" + 
		"   final JsonObject parameters = new JsonObject().\n" + 
		"         put(\"uuid\", uuid);\n" + 
		"\n" + 
		"	return parameters;\n" + 
		"}\n" + 
		"\n" + 
		"public JsonObject list~label~s(String... properties) {\n" + 
		"\n" + 
		"   final JsonObject parameters = new JsonObject();\n" + 
		"\n" + 
		"   final JsonArray propertiesParameter = new JsonArray();\n" + 
		"   for (String property : properties) propertiesParameter.add(property);\n" + 
		"   parameters.put(\"properties\", propertiesParameter);\n" + 
		"\n" + 
		"	return parameters;\n" + 
		"}\n" + 
		"\n" + 
		"public JsonObject remove~label~(String uuid, boolean force, boolean cascade) {\n" + 
		"\n" + 
		"   final JsonObject parameter = new JsonObject().\n" + 
		"         put(\"uuid\", uuid).\n" + 
		"         put(\"force\", force).\n" + 
		"         put(\"cascade\", cascade);\n" + 
		"\n" + 
		"   return parameter;\n" + 
		"}\n" + 
		"\n" + 
		"public void sendNew~label~Frame(JsonObject parameters) {\n" + 
		"	VertxUtil.sendFrame(log, address + \".new.~label~\", replyAddress, parameters, socket);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendNew~label~Message(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject~gt()~> handler) {\n" + 
		"  	VertxUtil.sendMessage(vertx, address + \".new.~label~\", parameters, log, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendUpdate~label~Frame(JsonObject parameters) {\n" + 
		"	VertxUtil.sendFrame(log, address + \".update.~label~\", replyAddress, parameters, socket);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendUpdate~label~Message(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject~gt()~> handler) {\n" + 
		"  	VertxUtil.sendMessage(vertx, address + \".update.~label~\", parameters, log, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendGet~label~Frame(JsonObject parameters) {\n" + 
		"	VertxUtil.sendFrame(log, address + \".get.~label~\", replyAddress, parameters, socket);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendGet~label~Message(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject~gt()~> handler) {\n" + 
		"  	VertxUtil.sendMessage(vertx, address + \".get.~label~\", parameters, log, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendList~label~Frame(JsonObject parameters) {\n" + 
		"   VertxUtil.sendFrame(log, address + \".list.~label~\", replyAddress, parameters, socket);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendList~label~Message(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject~gt()~> handler) {\n" + 
		"  	VertxUtil.sendMessage(vertx, address + \".list.~label~\", parameters, log, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendRemove~label~Frame(JsonObject parameters) {\n" + 
		"   VertxUtil.sendFrame(log, address + \".remove.~label~\", replyAddress, parameters, socket);\n" + 
		"}\n" + 
		"\n" + 
		"public void sendRemove~label~Message(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject~gt()~> handler) {\n" + 
		"  	VertxUtil.sendMessage(vertx, address + \".remove.~label~\", parameters, log, handler);\n" + 
		"}>>\n")
			.append("DomainPlugin(relations,rootRelations,title,entities,entityProperties,entityRelations,name,packageName,properties) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.generator.app.App;\n" + 
		"import com.generator.app.DomainMotif;\n" + 
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
		"import static com.generator.util.NeoUtil.*;\n" + 
		"\n" + 
		"/**\n" + 
		" * Auto-generated from domain ~name~\n" + 
		" */\n" + 
		"public abstract class ~name~ extends Plugin {\n" + 
		"\n" + 
		"	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(~name~.class);\n" + 
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
		"		domainNode = DomainMotif.newDomainNode(getGraph(), \"~title~\");\n" + 
		"		~entities:{it|entitiesNodeMap.put(Entities.~it.name~, DomainMotif.newDomainEntity(getGraph(), Entities.~it.name~, domainNode));};separator=\"\\n\"~\n" + 
		"		\n" + 
		"		~entityProperties:{it|DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.~it.entityName~), Properties.~it.propertyName~.name());};separator=\"\\n\"~\n" + 
		"		\n" + 
		"		~rootRelations:{it|relate(domainNode, entitiesNodeMap.get(Entities.~it.entity~), DomainPlugin.Relations.ENTITY);};separator=\"\\n\"~\n" + 
		"		~entityRelations:{it|DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.~it.src~), Relations.~it.relation~.name(), DomainPlugin.RelationCardinality.~it.cardinality~, entitiesNodeMap.get(Entities.~it.dst~));};separator=\"\\n\"~\n" + 
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
		"	public Node getDomainNode() { return domainNode; }\n" + 
		"\n" + 
		"	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }\n" + 
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
		"public static <T> T get~it.name;format=\"capitalize\"~Property(PropertyContainer container) { return get~it.name;format=\"capitalize\"~Property(container, null); ~eom()~\n" + 
		"public static <T> T get~it.name;format=\"capitalize\"~Property(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.~it.name~.name(), defaultValue); ~eom()~\n" + 
		"public static boolean has~it.name;format=\"capitalize\"~Property(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.~it.name~.name()); ~eom()~\n" + 
		"public static <T extends PropertyContainer> T set~it.name;format=\"capitalize\"~Property(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.~it.name~.name(), value); return container; ~eom()~\n" + 
		"public static <T extends PropertyContainer> T remove~it.name;format=\"capitalize\"~Property(T container) { DomainMotif.removeEntityProperty(container, Properties.~it.name~.name()); return container; ~eom()~\n" + 
		"\n" + 
		"protected <T extends PropertyContainer> T set~it.name;format=\"capitalize\"~Property(T container, Object value) { set~it.name;format=\"capitalize\"~Property(getGraph(), container, value); return container; ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("Visitor(labels,paths,package,name) ::= <<package ~package~;\n" + 
		"\n" + 
		"import com.generator.generators.domain.Visitor;\n" + 
		"import com.generator.util.NeoUtil;\n" + 
		"import org.neo4j.graphdb.Label;\n" + 
		"import org.neo4j.graphdb.Node;\n" + 
		"\n" + 
		"import static com.generator.util.NeoUtil.hasLabel;\n" + 
		"\n" + 
		"public class ~name~<T> implements Visitor<T> {\n" + 
		"\n" + 
		"   protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();\n" + 
		"	private final java.util.Stack<String> path = new java.util.Stack<>();\n" + 
		"\n" + 
		"	private final java.util.Map<String, PathHandler> pathHandlers = new java.util.LinkedHashMap<>();   \n" + 
		"	~paths:{it|// ~it.path~};separator=\"\\n\"~\n" + 
		"\n" + 
		"	public ~name~() {\n" + 
		"		~paths:{it|pathHandlers.put(\"~it.path~\", new~it.path~());};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public void visit(Node node) {\n" + 
		"		~labels:{it|if (hasLabel(node,\"~it~\")) visit~it~(node); };separator=\"\\nelse \"~\n" + 
		"   }\n" + 
		"\n" + 
		"~paths:{it|\n" + 
		"	protected PathHandler new~it.path~() {\n" + 
		"		return node ->  System.out.println(\"handle ~it.path~\"); \n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~labels:{it|\n" + 
		"	private void visit~it~(Node node) {\n" + 
		"   	if (visited.contains(node)) return;\n" + 
		"      visited.add(node);\n" + 
		"		path.push(\"~it~\");\n" + 
		"		final String currentPath = getPath(path);\n" + 
		"		pathHandlers.get(currentPath).handle(node);\n" + 
		"      NeoUtil.outgoing(node).forEach(relationship -> visit(NeoUtil.other(node, relationship)));\n" + 
		"		path.pop();\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public T getResult() {\n" + 
		"      return null;\n" + 
		"   }\n" + 
		"\n" + 
		"	public interface PathHandler {\n" + 
		"		void handle(Node node);\n" + 
		"	}\n" + 
		"\n" + 
		"	private String getPath(java.util.Stack<String> stack) {\n" + 
		"      if (stack.isEmpty()) return \"\";\n" + 
		"      final StringBuilder path = new StringBuilder();\n" + 
		"      boolean first = true;\n" + 
		"      for (String s : stack) {\n" + 
		"         if (!first) path.append(\"_\");\n" + 
		"         path.append(s);\n" + 
		"         first = false;\n" + 
		"      }\n" + 
		"      //System.out.println(path.toString());\n" + 
		"      return path.toString();\n" + 
		"   }\n" + 
		"}>>\n")
		.toString();
}