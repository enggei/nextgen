package com.generator.generators.neo4j;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Neo4j.stg' file<br/>
 */
public final class Neo4jGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public Neo4jGroup() {
		this(new STGroupString(stg));
   }

   public Neo4jGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public Neo4jGroup(java.io.File templateFile) {
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

	public interface Neo4jGroupTemplate {

	}

   public mvnST newmvn() {
      return new mvnST(stGroup);
   }

   public verticle_new_entityST newverticle_new_entity() {
      return new verticle_new_entityST(stGroup);
   }

   public NeoUtilST newNeoUtil() {
      return new NeoUtilST(stGroup);
   }

   public DomainCypherST newDomainCypher() {
      return new DomainCypherST(stGroup);
   }

   public entityMethodsST newentityMethods() {
      return new entityMethodsST(stGroup);
   }

   public methodsST newmethods() {
      return new methodsST(stGroup);
   }

   public relationMethodsST newrelationMethods() {
      return new relationMethodsST(stGroup);
   }

   public DomainST newDomain() {
      return new DomainST(stGroup);
   }

   public propertyAccessorsST newpropertyAccessors() {
      return new propertyAccessorsST(stGroup);
   }

   public oneToManyST newoneToMany() {
      return new oneToManyST(stGroup);
   }

   public oneToOneST newoneToOne() {
      return new oneToOneST(stGroup);
   }

   public manyToManyST newmanyToMany() {
      return new manyToManyST(stGroup);
   }

   public DomainVerticleST newDomainVerticle() {
      return new DomainVerticleST(stGroup);
   }

   public cypherMatchNodeST newcypherMatchNode() {
      return new cypherMatchNodeST(stGroup);
   }

   public cypherMatchRelationST newcypherMatchRelation() {
      return new cypherMatchRelationST(stGroup);
   }

   public NodeMatcherST newNodeMatcher() {
      return new NodeMatcherST(stGroup);
   }

   public RelationMatcherST newRelationMatcher() {
      return new RelationMatcherST(stGroup);
   }

   public verticle_update_entityST newverticle_update_entity() {
      return new verticle_update_entityST(stGroup);
   }

   public verticle_delete_entityST newverticle_delete_entity() {
      return new verticle_delete_entityST(stGroup);
   }

   public verticle_get_entityST newverticle_get_entity() {
      return new verticle_get_entityST(stGroup);
   }

   public verticle_get_all_entitiesST newverticle_get_all_entities() {
      return new verticle_get_all_entitiesST(stGroup);
   }

   public verticle_relateST newverticle_relate() {
      return new verticle_relateST(stGroup);
   }

   public static final class mvnST implements Neo4jGroupTemplate {



      private final ST template;

      private mvnST(STGroup group) {
   		template = group.getInstanceOf("mvn");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class verticle_new_entityST implements Neo4jGroupTemplate {


      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private Object _uniqueProperty;
      private Object _uniqueType;

      private final ST template;

      private verticle_new_entityST(STGroup group) {
   		template = group.getInstanceOf("verticle_new_entity");
   	}

      public verticle_new_entityST setLabel(Object value) {
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

      public verticle_new_entityST addPropertiesValue(Object isRequired_, Object name_, Object type_, Object isEnum_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("isRequired", (isRequired_ == null || isRequired_.toString().length() == 0) ? null : isRequired_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("isEnum", (isEnum_ == null || isEnum_.toString().length() == 0) ? null : isEnum_);
      	this._properties.add(map);

         template.addAggr("properties.{isRequired, name, type, isEnum}", map.get("isRequired"), map.get("name"), map.get("type"), map.get("isEnum"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public verticle_new_entityST setUniqueProperty(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._uniqueProperty == null) {
            this._uniqueProperty = value;
         	template.add("uniqueProperty", value);
         }

      	return this;
      }

      public String getUniqueProperty() {
      	return (String) this._uniqueProperty;
      }

      public verticle_new_entityST setUniqueType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._uniqueType == null) {
            this._uniqueType = value;
         	template.add("uniqueType", value);
         }

      	return this;
      }

      public String getUniqueType() {
      	return (String) this._uniqueType;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class NeoUtilST implements Neo4jGroupTemplate {


      private Object _packageName;

      private final ST template;

      private NeoUtilST(STGroup group) {
   		template = group.getInstanceOf("NeoUtil");
   	}

      public NeoUtilST setPackageName(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class DomainCypherST implements Neo4jGroupTemplate {


      private Object _description;
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;

      private final ST template;

      private DomainCypherST(STGroup group) {
   		template = group.getInstanceOf("DomainCypher");
   	}

      public DomainCypherST setDescription(Object value) {
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

      public DomainCypherST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
      }

      public DomainCypherST setName(Object value) {
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

      public DomainCypherST setPackageName(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class entityMethodsST implements Neo4jGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _requiredProperties = new java.util.LinkedHashSet<>();
      private Object _label;

      private final ST template;

      private entityMethodsST(STGroup group) {
   		template = group.getInstanceOf("entityMethods");
   	}

      public entityMethodsST addRequiredPropertiesValue(Object name_, Object type_, Object isEnum_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("isEnum", (isEnum_ == null || isEnum_.toString().length() == 0) ? null : isEnum_);
      	this._requiredProperties.add(map);

         template.addAggr("requiredProperties.{name, type, isEnum}", map.get("name"), map.get("type"), map.get("isEnum"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRequiredProperties() {
      	return this._requiredProperties;
      }

      public entityMethodsST setLabel(Object value) {
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

   public static final class methodsST implements Neo4jGroupTemplate {


      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();

      private final ST template;

      private methodsST(STGroup group) {
   		template = group.getInstanceOf("methods");
   	}

      public methodsST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class relationMethodsST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _requiredProperties = new java.util.LinkedHashSet<>();
      private Object _src;
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();

      private final ST template;

      private relationMethodsST(STGroup group) {
   		template = group.getInstanceOf("relationMethods");
   	}

      public relationMethodsST setDst(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dst == null) {
            this._dst = value;
         	template.add("dst", value);
         }

      	return this;
      }

      public String getDst() {
      	return (String) this._dst;
      }

      public relationMethodsST setName(Object value) {
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

      public relationMethodsST addRequiredPropertiesValue(Object name_, Object type_, Object enumType_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("enumType", (enumType_ == null || enumType_.toString().length() == 0) ? null : enumType_);
      	this._requiredProperties.add(map);

         template.addAggr("requiredProperties.{name, type, enumType}", map.get("name"), map.get("type"), map.get("enumType"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRequiredProperties() {
      	return this._requiredProperties;
      }

      public relationMethodsST setSrc(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._src == null) {
            this._src = value;
         	template.add("src", value);
         }

      	return this;
      }

      public String getSrc() {
      	return (String) this._src;
      }

      public relationMethodsST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class DomainST implements Neo4jGroupTemplate {


      private Object _description;
      private java.util.Set<Object> _entities = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _enums = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;
      private java.util.Set<Object> _properties = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _relations = new java.util.LinkedHashSet<>();

      private final ST template;

      private DomainST(STGroup group) {
   		template = group.getInstanceOf("Domain");
   	}

      public DomainST setDescription(Object value) {
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

      public DomainST addEntitiesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._entities.add(value);
      	template.add("entities", value);

         return this;
      }

      public java.util.Set<Object> getEntitiesValues() {
      	return this._entities;
      }

      public DomainST addEnumsValue(Object name_, Object enums_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("enums", (enums_ == null || enums_.toString().length() == 0) ? null : enums_);
      	this._enums.add(map);

         template.addAggr("enums.{name, enums}", map.get("name"), map.get("enums"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEnums() {
      	return this._enums;
      }

      public DomainST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
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

      public DomainST setPackageName(Object value) {
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

      public DomainST addPropertiesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._properties.add(value);
      	template.add("properties", value);

         return this;
      }

      public java.util.Set<Object> getPropertiesValues() {
      	return this._properties;
      }

      public DomainST addRelationsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._relations.add(value);
      	template.add("relations", value);

         return this;
      }

      public java.util.Set<Object> getRelationsValues() {
      	return this._relations;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class propertyAccessorsST implements Neo4jGroupTemplate {


      private Object _enumType;
      private Object _name;
      private Object _type;

      private final ST template;

      private propertyAccessorsST(STGroup group) {
   		template = group.getInstanceOf("propertyAccessors");
   	}

      public propertyAccessorsST setEnumType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._enumType == null) {
            this._enumType = value;
         	template.add("enumType", value);
         }

      	return this;
      }

      public String getEnumType() {
      	return (String) this._enumType;
      }

      public propertyAccessorsST setName(Object value) {
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

      public propertyAccessorsST setType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._type == null) {
            this._type = value;
         	template.add("type", value);
         }

      	return this;
      }

      public String getType() {
      	return (String) this._type;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class oneToManyST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _name;
      private Object _src;
      private Object _dstDirection;
      private Object _srcDirection;

      private final ST template;

      private oneToManyST(STGroup group) {
   		template = group.getInstanceOf("oneToMany");
   	}

      public oneToManyST setDst(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dst == null) {
            this._dst = value;
         	template.add("dst", value);
         }

      	return this;
      }

      public String getDst() {
      	return (String) this._dst;
      }

      public oneToManyST setName(Object value) {
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

      public oneToManyST setSrc(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._src == null) {
            this._src = value;
         	template.add("src", value);
         }

      	return this;
      }

      public String getSrc() {
      	return (String) this._src;
      }

      public oneToManyST setDstDirection(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dstDirection == null) {
            this._dstDirection = value;
         	template.add("dstDirection", value);
         }

      	return this;
      }

      public String getDstDirection() {
      	return (String) this._dstDirection;
      }

      public oneToManyST setSrcDirection(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcDirection == null) {
            this._srcDirection = value;
         	template.add("srcDirection", value);
         }

      	return this;
      }

      public String getSrcDirection() {
      	return (String) this._srcDirection;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class oneToOneST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _name;
      private Object _src;

      private final ST template;

      private oneToOneST(STGroup group) {
   		template = group.getInstanceOf("oneToOne");
   	}

      public oneToOneST setDst(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dst == null) {
            this._dst = value;
         	template.add("dst", value);
         }

      	return this;
      }

      public String getDst() {
      	return (String) this._dst;
      }

      public oneToOneST setName(Object value) {
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

      public oneToOneST setSrc(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._src == null) {
            this._src = value;
         	template.add("src", value);
         }

      	return this;
      }

      public String getSrc() {
      	return (String) this._src;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class manyToManyST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _name;
      private Object _src;

      private final ST template;

      private manyToManyST(STGroup group) {
   		template = group.getInstanceOf("manyToMany");
   	}

      public manyToManyST setDst(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dst == null) {
            this._dst = value;
         	template.add("dst", value);
         }

      	return this;
      }

      public String getDst() {
      	return (String) this._dst;
      }

      public manyToManyST setName(Object value) {
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

      public manyToManyST setSrc(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._src == null) {
            this._src = value;
         	template.add("src", value);
         }

      	return this;
      }

      public String getSrc() {
      	return (String) this._src;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class DomainVerticleST implements Neo4jGroupTemplate {


      private Object _hazelcastConfig;
      private Object _implementation;
      private java.util.Set<java.util.Map<String, Object>> _incoming = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _outgoing = new java.util.LinkedHashSet<>();
      private Object _packageName;

      private final ST template;

      private DomainVerticleST(STGroup group) {
   		template = group.getInstanceOf("DomainVerticle");
   	}

      public DomainVerticleST setHazelcastConfig(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._hazelcastConfig == null) {
            this._hazelcastConfig = value;
         	template.add("hazelcastConfig", value);
         }

      	return this;
      }

      public String getHazelcastConfig() {
      	return (String) this._hazelcastConfig;
      }

      public DomainVerticleST setImplementation(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._implementation == null) {
            this._implementation = value;
         	template.add("implementation", value);
         }

      	return this;
      }

      public String getImplementation() {
      	return (String) this._implementation;
      }

      public DomainVerticleST addIncomingValue(Object name_, Object impl_, Object address_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("impl", (impl_ == null || impl_.toString().length() == 0) ? null : impl_);
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	this._incoming.add(map);

         template.addAggr("incoming.{name, impl, address}", map.get("name"), map.get("impl"), map.get("address"));
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

      public DomainVerticleST setPackageName(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class cypherMatchNodeST implements Neo4jGroupTemplate {


      private Object _id;
      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private cypherMatchNodeST(STGroup group) {
   		template = group.getInstanceOf("cypherMatchNode");
   	}

      public cypherMatchNodeST setId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._id == null) {
            this._id = value;
         	template.add("id", value);
         }

      	return this;
      }

      public String getId() {
      	return (String) this._id;
      }

      public cypherMatchNodeST setLabel(Object value) {
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

      public cypherMatchNodeST addPropertiesValue(Object name_) {
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

   public static final class cypherMatchRelationST implements Neo4jGroupTemplate {


      private Object _dstRel;
      private Object _src;
      private Object _srcRel;
      private Object _type;
      private Object _dst;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private cypherMatchRelationST(STGroup group) {
   		template = group.getInstanceOf("cypherMatchRelation");
   	}

      public cypherMatchRelationST setDstRel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dstRel == null) {
            this._dstRel = value;
         	template.add("dstRel", value);
         }

      	return this;
      }

      public String getDstRel() {
      	return (String) this._dstRel;
      }

      public cypherMatchRelationST setSrc(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._src == null) {
            this._src = value;
         	template.add("src", value);
         }

      	return this;
      }

      public String getSrc() {
      	return (String) this._src;
      }

      public cypherMatchRelationST setSrcRel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcRel == null) {
            this._srcRel = value;
         	template.add("srcRel", value);
         }

      	return this;
      }

      public String getSrcRel() {
      	return (String) this._srcRel;
      }

      public cypherMatchRelationST setType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._type == null) {
            this._type = value;
         	template.add("type", value);
         }

      	return this;
      }

      public String getType() {
      	return (String) this._type;
      }

      public cypherMatchRelationST setDst(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dst == null) {
            this._dst = value;
         	template.add("dst", value);
         }

      	return this;
      }

      public String getDst() {
      	return (String) this._dst;
      }

      public cypherMatchRelationST addPropertiesValue(Object name_) {
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

   public static final class NodeMatcherST implements Neo4jGroupTemplate {


      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private NodeMatcherST(STGroup group) {
   		template = group.getInstanceOf("NodeMatcher");
   	}

      public NodeMatcherST setLabel(Object value) {
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

      public NodeMatcherST addPropertiesValue(Object name_) {
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

   public static final class RelationMatcherST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _src;
      private Object _type;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private RelationMatcherST(STGroup group) {
   		template = group.getInstanceOf("RelationMatcher");
   	}

      public RelationMatcherST setDst(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dst == null) {
            this._dst = value;
         	template.add("dst", value);
         }

      	return this;
      }

      public String getDst() {
      	return (String) this._dst;
      }

      public RelationMatcherST setSrc(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._src == null) {
            this._src = value;
         	template.add("src", value);
         }

      	return this;
      }

      public String getSrc() {
      	return (String) this._src;
      }

      public RelationMatcherST setType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._type == null) {
            this._type = value;
         	template.add("type", value);
         }

      	return this;
      }

      public String getType() {
      	return (String) this._type;
      }

      public RelationMatcherST addPropertiesValue(Object name_) {
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

   public static final class verticle_update_entityST implements Neo4jGroupTemplate {


      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private verticle_update_entityST(STGroup group) {
   		template = group.getInstanceOf("verticle_update_entity");
   	}

      public verticle_update_entityST setLabel(Object value) {
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

      public verticle_update_entityST addPropertiesValue(Object name_, Object isEnum_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("isEnum", (isEnum_ == null || isEnum_.toString().length() == 0) ? null : isEnum_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._properties.add(map);

         template.addAggr("properties.{name, isEnum, type}", map.get("name"), map.get("isEnum"), map.get("type"));
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

   public static final class verticle_delete_entityST implements Neo4jGroupTemplate {


      private Object _label;

      private final ST template;

      private verticle_delete_entityST(STGroup group) {
   		template = group.getInstanceOf("verticle_delete_entity");
   	}

      public verticle_delete_entityST setLabel(Object value) {
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

   public static final class verticle_get_entityST implements Neo4jGroupTemplate {


      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private verticle_get_entityST(STGroup group) {
   		template = group.getInstanceOf("verticle_get_entity");
   	}

      public verticle_get_entityST setLabel(Object value) {
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

      public verticle_get_entityST addPropertiesValue(Object name_) {
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

   public static final class verticle_get_all_entitiesST implements Neo4jGroupTemplate {


      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private verticle_get_all_entitiesST(STGroup group) {
   		template = group.getInstanceOf("verticle_get_all_entities");
   	}

      public verticle_get_all_entitiesST setLabel(Object value) {
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

      public verticle_get_all_entitiesST addPropertiesValue(Object name_) {
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

   public static final class verticle_relateST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _src;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private Object _relation;

      private final ST template;

      private verticle_relateST(STGroup group) {
   		template = group.getInstanceOf("verticle_relate");
   	}

      public verticle_relateST setDst(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dst == null) {
            this._dst = value;
         	template.add("dst", value);
         }

      	return this;
      }

      public String getDst() {
      	return (String) this._dst;
      }

      public verticle_relateST setSrc(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._src == null) {
            this._src = value;
         	template.add("src", value);
         }

      	return this;
      }

      public String getSrc() {
      	return (String) this._src;
      }

      public verticle_relateST addPropertiesValue(Object isEnum_, Object type_, Object isRequired_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("isEnum", (isEnum_ == null || isEnum_.toString().length() == 0) ? null : isEnum_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("isRequired", (isRequired_ == null || isRequired_.toString().length() == 0) ? null : isRequired_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._properties.add(map);

         template.addAggr("properties.{isEnum, type, isRequired, name}", map.get("isEnum"), map.get("type"), map.get("isRequired"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public verticle_relateST setRelation(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._relation == null) {
            this._relation = value;
         	template.add("relation", value);
         }

      	return this;
      }

      public String getRelation() {
      	return (String) this._relation;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "Neo4jGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("mvn() ::= <<<!-- https://mvnrepository.com/artifact/org.neo4j/neo4j -->\n" + 
		"<dependency>\n" + 
		"    <groupId>org.neo4j</groupId>\n" + 
		"    <artifactId>neo4j</artifactId>\n" + 
		"    <version>3.3.4</version>\n" + 
		"</dependency> >>\n")
			.append("verticle_new_entity(label,properties,uniqueProperty,uniqueType) ::= <<final JsonArray errors = new JsonArray();\n" + 
		"~properties:{it|~if(it.isRequired)~if (message.body().get~if(it.isEnum)~String~else~~it.type~~endif~(\"~it.name~\") == null) errors.add(\"missing ~it.name~\");\n" + 
		"~endif~}~\n" + 
		"if (!errors.isEmpty()) {\n" + 
		"   message.reply(newFail(errors));\n" + 
		"   return;\n" + 
		"}\n" + 
		"\n" + 
		"~if(uniqueProperty)~\n" + 
		"// ~uniqueProperty~ is unique, so check if already exists:\n" + 
		"final ResourceIterator<Node> nodes = db.findNodes(Label.label(\"~label~\"), \"~uniqueProperty~\", message.body().getString(\"~uniqueProperty~\"));\n" + 
		"while (nodes.hasNext()) {\n" + 
		"   if (!isDeleted(nodes.next())) {\n" + 
		"   	message.reply(newFail(\"~label~ \" + message.body().get~uniqueType~(\"~uniqueProperty~\") + \" exists\"));\n" + 
		"      return;\n" + 
		"   }\n" + 
		"}\n" + 
		"~endif~\n" + 
		"\n" + 
		"final Node node = newNode(db, \"~label~\");\n" + 
		"~properties:{it|map~if(it.isEnum)~String~else~~it.type~~endif~(message, node, \"~it.name~\");};separator=\"\\n\"~\n" + 
		"\n" + 
		"message.reply(newSuccess(node.getProperty(\"_uuid\").toString()));>>\n")
			.append("NeoUtil(packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.neo4j.graphdb.*;\n" + 
		"\n" + 
		"import java.util.Collections;\n" + 
		"import java.util.UUID;\n" + 
		"import java.util.function.Consumer;\n" + 
		"\n" + 
		"import static org.neo4j.graphdb.Direction.INCOMING;\n" + 
		"import static org.neo4j.graphdb.Direction.OUTGOING;\n" + 
		"\n" + 
		"/**\n" + 
		" */\n" + 
		"public class NeoUtil {\n" + 
		"\n" + 
		"   public static String getUuid(Node node) {\n" + 
		"      return (String) node.getProperty(Properties._uuid.name());\n" + 
		"   }\n" + 
		"\n" + 
		"   public enum Relations implements RelationshipType {\n" + 
		"      _VERSION\n" + 
		"   }\n" + 
		"\n" + 
		"   public enum Properties {\n" + 
		"      _uuid, _deleted, _timestamp\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Node newNode(GraphDatabaseService db, Label label) {\n" + 
		"      final Node node = db.createNode(label);\n" + 
		"      node.setProperty(Properties._uuid.name(), UUID.randomUUID().toString());\n" + 
		"      node.setProperty(Properties._deleted.name(), false);\n" + 
		"      return node;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Node newNode(GraphDatabaseService db, Label label, Object... propertyValues) {\n" + 
		"\n" + 
		"      if (propertyValues.length % 2 != 0)\n" + 
		"         throw new IllegalArgumentException(\"propertyValues must come in key-value pairs\");\n" + 
		"\n" + 
		"      final Node node = newNode(db, label);\n" + 
		"\n" + 
		"      for (int i = 0; i < propertyValues.length; i += 2)\n" + 
		"         node.setProperty(propertyValues[i].toString(), propertyValues[i + 1]);\n" + 
		"\n" + 
		"      return node;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Node findNode(GraphDatabaseService db, Label label, Object property, Object value) {\n" + 
		"      final Node node = db.findNode(label, property.toString(), value);\n" + 
		"      return (node == null || isDeleted(node)) ? null : node;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Node findNodeByUuid(GraphDatabaseService db, Label label, String uuid) {\n" + 
		"      final Node node = db.findNode(label, Properties._uuid.name(), uuid);\n" + 
		"      return (node == null || isDeleted(node)) ? null : node;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void findAll(GraphDatabaseService db, Label label, Consumer<Node> consumer) {\n" + 
		"      db.findNodes(label).forEachRemaining(node -> {\n" + 
		"         if (isDeleted(node)) return;\n" + 
		"         consumer.accept(node);\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void findAll(GraphDatabaseService db, Label label, Object property, Object value, Consumer<Node> consumer) {\n" + 
		"      db.findNodes(label, property.toString(), value).forEachRemaining(node -> {\n" + 
		"         if (isDeleted(node)) return;\n" + 
		"         consumer.accept(node);\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deleteNode(Node node) {\n" + 
		"      node.setProperty(Properties._deleted.name(), true);\n" + 
		"      node.setProperty(Properties._timestamp.name(), System.currentTimeMillis());\n" + 
		"   }\n" + 
		"\n" + 
		"   private static boolean isDeleted(Node node) {\n" + 
		"      return (Boolean) node.getProperty(Properties._deleted.name(), false);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void newVersion(Node oldNode, Node newNode) {\n" + 
		"      final Relationship versionRelation = newNode.createRelationshipTo(oldNode, Relations._VERSION);\n" + 
		"      versionRelation.setProperty(Properties._timestamp.name(), System.currentTimeMillis());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void getAllVersionsOf(Node node, Consumer<Node> consumer) {\n" + 
		"      final Relationship versionRelation = singleOutgoing(node, Relations._VERSION);\n" + 
		"      if (versionRelation == null) return;\n" + 
		"\n" + 
		"      final Node oldVersion = versionRelation.getOtherNode(node);\n" + 
		"      consumer.accept(oldVersion);\n" + 
		"\n" + 
		"      getAllVersionsOf(oldVersion, consumer);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Iterable<Relationship> outgoing(Node node, RelationshipType type) {\n" + 
		"      return node == null ? Collections.emptyList() : node.getRelationships(OUTGOING, type);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Relationship singleOutgoing(Node node, RelationshipType type) {\n" + 
		"      return node == null ? null : node.getSingleRelationship(type, OUTGOING);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Node singleOutgoingNode(Node node, RelationshipType type) {\n" + 
		"      return node == null ? null : singleOutgoing(node, type).getOtherNode(node);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Iterable<Relationship> incoming(Node node, RelationshipType type) {\n" + 
		"      return node == null ? Collections.emptySet() : node.getRelationships(INCOMING, type);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Relationship singleIncoming(Node node, RelationshipType type) {\n" + 
		"      return node == null ? null : node.getSingleRelationship(type, INCOMING);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Node singleIncomingNode(Node node, RelationshipType type) {\n" + 
		"      return node == null ? null : singleIncoming(node, type).getOtherNode(node);\n" + 
		"   }\n" + 
		"}>>\n")
			.append("DomainCypher(description,methods,name,packageName) ::= <<~if(packageName)~package ~packageName~;\n" + 
		"~endif~\n" + 
		"\n" + 
		"import org.neo4j.graphdb.*;\n" + 
		"\n" + 
		"import java.util.LinkedHashSet;\n" + 
		"import java.util.Map;\n" + 
		"import java.util.LinkedHashMap;\n" + 
		"import java.util.Set;\n" + 
		"\n" + 
		"/**\n" + 
		" * ~description~\n" + 
		" */\n" + 
		"public class ~name~Cypher {\n" + 
		"   \n" + 
		"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"	public static Long getLong(String name, Map<String, Object> map) {\n" + 
		"      return (Long) map.get(name);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static String getString(String name, Map<String, Object> map) {\n" + 
		"      return (String) map.get(name);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static Integer getInteger(String name, Map<String, Object> map) {\n" + 
		"      return (Integer) map.get(name);\n" + 
		"   }\n" + 
		"\n" + 
		"	public static Number getNumber(String name, Map<String, Object> map) {\n" + 
		"      return (Number) map.get(name);\n" + 
		"   }\n" + 
		"\n" + 
		"	public static abstract class CypherQuery {\n" + 
		"\n" + 
		"      public abstract String query();\n" + 
		"\n" + 
		"      public abstract Map<String, Object> params();\n" + 
		"   }\n" + 
		"	\n" + 
		"	public interface CypherConsumer {\n" + 
		"\n" + 
		"      /**\n" + 
		"       * @return true if stop iteration\n" + 
		"       */\n" + 
		"      boolean handle(Map<String,Object> element);\n" + 
		"   }\n" + 
		"\n" + 
		"	public static void execute(GraphDatabaseService db, String cypher, CypherConsumer consumer) {\n" + 
		"      final Result result = db.execute(cypher);\n" + 
		"      while (result.hasNext()) {\n" + 
		"         if (consumer.handle(result.next())) {\n" + 
		"            result.close();\n" + 
		"            return;\n" + 
		"         }\n" + 
		"      }\n" + 
		"      result.close();\n" + 
		"   }\n" + 
		"\n" + 
		"	public static void execute(GraphDatabaseService db, String cypher, Map<String,Object> params, CypherConsumer consumer) {\n" + 
		"      final Result result = db.execute(cypher, params);\n" + 
		"      while (result.hasNext()) {\n" + 
		"         if (consumer.handle(result.next())) {\n" + 
		"            result.close();\n" + 
		"            return;\n" + 
		"         }\n" + 
		"      }\n" + 
		"      result.close();\n" + 
		"   }\n" + 
		"\n" + 
		"	public static void execute(GraphDatabaseService db, CypherQuery query, CypherConsumer consumer) {\n" + 
		"      execute(db, query.query(), query.params(), consumer);\n" + 
		"   }\n" + 
		"\n" + 
		"	public interface Matcher {\n" + 
		"\n" + 
		"		Set<String> returnValues();\n" + 
		"	}\n" + 
		"\n" + 
		"	public static EmptyMatcher newEmptyMatcher(final String id) {\n" + 
		"      return new EmptyMatcher(id);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static final class EmptyMatcher extends NodeMatcher {\n" + 
		"\n" + 
		"      private EmptyMatcher(String id) {\n" + 
		"         super(id, null);\n" + 
		"      }\n" + 
		"\n" + 
		"      public EmptyMatcher returnNode() {\n" + 
		"         returnValues.add(id);\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public EmptyMatcher returnExpression(String expression) {\n" + 
		"         returnValues.add(expression);\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"	public static OrRelationMatcher newOrRelationMatcher(String... types) {\n" + 
		"      final StringBuilder params = new StringBuilder();\n" + 
		"      boolean first = true;\n" + 
		"      for (String type : types) {\n" + 
		"         if (!first) params.append(\"|\");\n" + 
		"         params.append(type);\n" + 
		"         first = false;\n" + 
		"      }\n" + 
		"      return new OrRelationMatcher(params.toString());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static final class OrRelationMatcher extends RelationMatcher {\n" + 
		"\n" + 
		"      private OrRelationMatcher(String type) {\n" + 
		"         super(type);\n" + 
		"      }\n" + 
		"\n" + 
		"      public OrRelationMatcher srcRel(String srcRel) {\n" + 
		"         this.srcRel = srcRel;\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public OrRelationMatcher dstRel(String dstRel) {\n" + 
		"         this.dstRel = dstRel;\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public OrRelationMatcher setSrcMatcher(Matcher srcMatcher) {\n" + 
		"         this.src = srcMatcher.toString();\n" + 
		"         this.returnValues.addAll(srcMatcher.returnValues());\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public OrRelationMatcher setDstMatcher(Matcher dstMatcher) {\n" + 
		"         this.dst = dstMatcher.toString();\n" + 
		"         this.returnValues.addAll(dstMatcher.returnValues());\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"	public static class NodeMatcher implements Matcher {\n" + 
		"\n" + 
		"      final String id;\n" + 
		"      final String label;\n" + 
		"      final Map<String, String> properties = new LinkedHashMap<>();\n" + 
		"		final Set<String> returnValues = new LinkedHashSet<>();\n" + 
		"\n" + 
		"      NodeMatcher(String id, String label) {\n" + 
		"         this.id = id;\n" + 
		"         this.label = label;\n" + 
		"      }\n" + 
		"      \n" + 
		"      @Override\n" + 
		"      public Set<String> returnValues() {\n" + 
		"      	return returnValues;\n" + 
		"		}\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public String toString() {\n" + 
		"         final StringBuilder cypher = new StringBuilder();\n" + 
		"\n" + 
		"         cypher.append(\"(\").append(id);\n" + 
		"\n" + 
		"         if (label != null)\n" + 
		"            cypher.append(\":\").append(label);\n" + 
		"\n" + 
		"         if (!properties.isEmpty()) {\n" + 
		"            cypher.append(\" {\");\n" + 
		"            boolean first = true;\n" + 
		"            for (Map.Entry<String, String> entry : properties.entrySet()) {\n" + 
		"               if (!first) cypher.append(\", \");\n" + 
		"               cypher.append(entry.getKey()).append(\":\").append(\"$\").append(entry.getValue());\n" + 
		"               first = false;\n" + 
		"            }\n" + 
		"            cypher.append(\"}\");\n" + 
		"         }\n" + 
		"         cypher.append(\")\");\n" + 
		"\n" + 
		"         return cypher.toString();\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"   public static class RelationMatcher implements Matcher {\n" + 
		"\n" + 
		"      final String type;\n" + 
		"      String src;\n" + 
		"      String srcRel;\n" + 
		"      String dst;\n" + 
		"      String dstRel;\n" + 
		"      final Map<String, String> properties = new LinkedHashMap<>();\n" + 
		"		final Set<String> returnValues = new LinkedHashSet<>();\n" + 
		"\n" + 
		"      RelationMatcher(String type) {\n" + 
		"         this.type = type;\n" + 
		"      }\n" + 
		"\n" + 
		"		@Override\n" + 
		"      public Set<String> returnValues() {\n" + 
		"      	return returnValues;\n" + 
		"		}\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public String toString() {\n" + 
		"         final StringBuilder cypher = new StringBuilder();\n" + 
		"\n" + 
		"         if (src != null) cypher.append(src);\n" + 
		"         if (srcRel != null) cypher.append(srcRel);\n" + 
		"         cypher.append(\"[:\").append(type);\n" + 
		"\n" + 
		"         if (!properties.isEmpty()) {\n" + 
		"            cypher.append(\" {\");\n" + 
		"            boolean first = true;\n" + 
		"            for (Map.Entry<String, String> entry : properties.entrySet()) {\n" + 
		"               if (!first) cypher.append(\", \");\n" + 
		"               cypher.append(entry.getKey()).append(\":\").append(\"$\").append(entry.getValue());\n" + 
		"               first = false;\n" + 
		"            }\n" + 
		"            cypher.append(\"}\");\n" + 
		"         }\n" + 
		"         cypher.append(\"]\");\n" + 
		"         if (dstRel != null) cypher.append(dstRel);\n" + 
		"         if (dst != null) cypher.append(dst);\n" + 
		"\n" + 
		"         return cypher.toString();\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"	public static CypherMatcher newCypherMatcher(Matcher matcher) {\n" + 
		"		return new CypherMatcher(matcher);\n" + 
		"	}\n" + 
		"\n" + 
		"	public static final class CypherMatcher extends CypherQuery {\n" + 
		"\n" + 
		"      private final Matcher matcher;\n" + 
		"      private final Set<CypherQuery> unions = new LinkedHashSet<>();\n" + 
		"      private boolean unionAll = false;\n" + 
		"      final Map<String, Object> parameters = new LinkedHashMap<>();\n" + 
		"      final Set<String> where = new LinkedHashSet<>();\n" + 
		"      final Set<String> orderBy = new LinkedHashSet<>();\n" + 
		"\n" + 
		"      private CypherMatcher(Matcher matcher) {\n" + 
		"         this.matcher = matcher;\n" + 
		"      }\n" + 
		"\n" + 
		"      public CypherMatcher addUnion(CypherQuery unionQuery) {\n" + 
		"         this.unions.add(unionQuery);\n" + 
		"         this.parameters.putAll(unionQuery.params());\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public CypherMatcher addUnionAll(CypherQuery unionQuery) {\n" + 
		"         this.unions.add(unionQuery);\n" + 
		"         this.parameters.putAll(unionQuery.params());\n" + 
		"         this.unionAll = true;\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public CypherMatcher addParam(String name, Object value) {\n" + 
		"         parameters.put(name, value);\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public CypherMatcher addWhere(String expression) {\n" + 
		"         where.add(expression);\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"\n" + 
		"      public CypherMatcher addOrderBy(String element) {\n" + 
		"         orderBy.add(element);\n" + 
		"         return this;\n" + 
		"      }\n" + 
		"      \n" + 
		"      @Override\n" + 
		"      public String query() {\n" + 
		"         final StringBuilder match = new StringBuilder(\"MATCH \" + matcher + where() + returnValues());\n" + 
		"         for (CypherQuery union : unions)\n" + 
		"            match.append(\" UNION \").append(unionAll ? \"ALL \" : \"\").append(union.query());\n" + 
		"\n" + 
		"         boolean first = true;\n" + 
		"         for (String element : orderBy) {\n" + 
		"            if (first) match.append(\" ORDER BY \");\n" + 
		"            else match.append(\", \");\n" + 
		"            match.append(element);\n" + 
		"            first = false;\n" + 
		"         }\n" + 
		"\n" + 
		"         return match.toString();\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public Map<String, Object> params() {\n" + 
		"         return parameters;\n" + 
		"      }\n" + 
		"\n" + 
		"      private String where() {\n" + 
		"         if (where.isEmpty()) return \"\";\n" + 
		"\n" + 
		"         final StringBuilder out = new StringBuilder(\" WHERE \");\n" + 
		"\n" + 
		"         boolean first = true;\n" + 
		"         for (String where : where) {\n" + 
		"            if (!first) out.append(\" AND \");\n" + 
		"            out.append(where);\n" + 
		"            first = false;\n" + 
		"         }\n" + 
		"\n" + 
		"         return out.toString();\n" + 
		"      }\n" + 
		"\n" + 
		"      private String returnValues() {\n" + 
		"         final StringBuilder out = new StringBuilder(\" return \");\n" + 
		"\n" + 
		"         boolean first = true;\n" + 
		"         for (String returnValue : matcher.returnValues()) {\n" + 
		"            if (!first) out.append(\", \");\n" + 
		"            out.append(returnValue);\n" + 
		"            first = false;\n" + 
		"         }\n" + 
		"\n" + 
		"         return out.toString();\n" + 
		"      }\n" + 
		"   }\n" + 
		"}>>\n")
			.append("entityMethods(requiredProperties,label) ::= <<public static Node new~label~(GraphDatabaseService db~if(requiredProperties)~, ~requiredProperties:{it|~it.type~ ~it.name;format=\"lowFirst\"~};separator=\", \"~~endif~) {\n" + 
		"   final Node node = db.createNode(Entities.~label~);\n" + 
		"	node.setProperty(\"_uuid\", UUID.randomUUID().toString());\n" + 
		"	~requiredProperties:{it|node.setProperty(Properties.~it.name;format=\"lowFirst\"~.name(), ~it.name;format=\"lowFirst\"~~if(it.isEnum)~.name()~endif~);};separator=\"\\n\"~\n" + 
		"	return node;\n" + 
		"}\n" + 
		"\n" + 
		"~requiredProperties:{it|\n" + 
		"public static void create~label~IndexOn~it.name;format=\"capitalize\"~(GraphDatabaseService db) {\n" + 
		"	db.execute(\"CREATE INDEX ON : ~label~ (~it.name~)\");\n" + 
		"~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"public static void findAll~label~(GraphDatabaseService db, NodeConsumer consumer) {\n" + 
		"	final ResourceIterator<Node> nodes = db.findNodes(Entities.~label~);\n" + 
		"   while (nodes.hasNext()) {\n" + 
		"   	if (consumer.handle(nodes.next())) {\n" + 
		"         nodes.close();\n" + 
		"      	return;\n" + 
		"   	}\n" + 
		"   }\n" + 
		"	nodes.close();\n" + 
		"}\n" + 
		"\n" + 
		"public static Node find~label~By_UUID(GraphDatabaseService db, String uuid) {\n" + 
		"	return db.findNode(Entities.~label~, \"_uuid\", uuid);\n" + 
		"~eom()~\n" + 
		"\n" + 
		"~requiredProperties:{it|\n" + 
		"\n" + 
		"public static Node find~label~By~it.name;format=\"capitalize\"~(GraphDatabaseService db, ~it.type~ ~it.name;format=\"lowFirst\"~) {\n" + 
		"	return db.findNode(Entities.~label~, Properties.~it.name;format=\"lowFirst\"~.name(), ~it.name;format=\"lowFirst\"~~if(it.isEnum)~.name()~endif~);\n" + 
		"~eom()~\n" + 
		"};separator=\"\\n\"~>>\n")
			.append("methods(methods) ::= <<~methods:{it|~it~};separator=\"\\n\\n\"~>>\n")
			.append("relationMethods(dst,name,requiredProperties,src,methods) ::= <<public static Relationship relate_~src~_~name;format=\"toUpper\"~_~dst~(Node ~src;format=\"lowFirst\"~, Node ~dst;format=\"lowFirst\"~~if(requiredProperties)~, ~requiredProperties:{it|~it.type~ ~it.name;format=\"lowFirst\"~};separator=\", \"~~endif~) {\n" + 
		"   ~if(requiredProperties)~final Relationship relation = relate(~src;format=\"lowFirst\"~, ~dst;format=\"lowFirst\"~, Relations.~name;format=\"toUpper\"~);\n" + 
		"~requiredProperties:{it|relation.setProperty(Properties.~it.name;format=\"lowFirst\"~.name(), ~it.name;format=\"lowFirst\"~~if(it.enumType)~.name()~endif~);};separator=\"\\n\"~\n" + 
		"return relation;\n" + 
		"~else~\n" + 
		"return relate(~src;format=\"lowFirst\"~, ~dst;format=\"lowFirst\"~, Relations.~name;format=\"toUpper\"~);\n" + 
		"~endif~\n" + 
		"}\n" + 
		"\n" + 
		"~methods:{it|~it~};separator=\"\\n\\n\"~>>\n")
			.append("Domain(description,entities,enums,methods,name,packageName,properties,relations) ::= <<~if(packageName)~package ~packageName~;\n" + 
		"~endif~\n" + 
		"\n" + 
		"import org.neo4j.graphdb.*;\n" + 
		"\n" + 
		"import java.util.UUID;\n" + 
		"\n" + 
		"/**\n" + 
		" * ~description~\n" + 
		" */\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"   public enum Entities implements Label {\n" + 
		"      ~entities:{it|~it;format=\"capitalize\"~};separator=\", \"~\n" + 
		"   }\n" + 
		"\n" + 
		"   public enum Relations implements RelationshipType {\n" + 
		"      _VERSION, ~relations:{it|~it;format=\"toUpper\"~};separator=\", \"~\n" + 
		"   }\n" + 
		"\n" + 
		"   public enum Properties {\n" + 
		"      _uuid, _deleted, _timestamp, ~properties:{it|~it;format=\"lowFirst\"~};separator=\", \"~\n" + 
		"   }\n" + 
		"\n" + 
		"	~enums:{it|public enum ~it.name~ {\n" + 
		"	~it.enums~\n" + 
		"~eom()~};separator=\"\\n\"~\n" + 
		"   \n" + 
		"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"	public static String getUuid(Node node) {\n" + 
		"		return (String) node.getProperty(Properties._uuid.name());\n" + 
		"	}\n" + 
		"\n" + 
		"	public interface NodeConsumer {\n" + 
		"\n" + 
		"      /**\n" + 
		"       * @return true if stop iteration\n" + 
		"       */\n" + 
		"	   boolean handle(Node node);\n" + 
		"   }\n" + 
		"\n" + 
		"	public interface RelationConsumer {\n" + 
		"\n" + 
		"      /**\n" + 
		"       * @return true if stop iteration\n" + 
		"       */\n" + 
		"      boolean handle(Relationship relationship, Node other);\n" + 
		"   }\n" + 
		"\n" + 
		"	public interface TransactionHandler {\n" + 
		"\n" + 
		"      void execute() throws Exception;\n" + 
		"\n" + 
		"      void handleException(Exception e);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void doInTransaction(GraphDatabaseService db, TransactionHandler transactionHandler) {\n" + 
		"      try (Transaction tx = db.beginTx()) {\n" + 
		"         transactionHandler.execute();\n" + 
		"         tx.success();\n" + 
		"      } catch (Exception e) {\n" + 
		"         transactionHandler.handleException(e);\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"	private static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {\n" + 
		"\n" + 
		"      // if already related, merge properties:\n" + 
		"      for (Object o : outgoing(source, relationshipType)) {\n" + 
		"         final Relationship relationship = (Relationship) o;\n" + 
		"         if (target.equals(other(source, relationship))) {\n" + 
		"            for (int i = 0; i < properties.length; i += 2)\n" + 
		"               relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"            return relationship;\n" + 
		"         }\n" + 
		"      }\n" + 
		"\n" + 
		"      final Relationship relationship = source.createRelationshipTo(target, relationshipType);\n" + 
		"      for (int i = 0; i < properties.length; i += 2)\n" + 
		"         relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"\n" + 
		"      return relationship;\n" + 
		"   }\n" + 
		"\n" + 
		"   private static Iterable<?> outgoing(Node node, RelationshipType type) {\n" + 
		"      return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);\n" + 
		"   }\n" + 
		"\n" + 
		"	private static Node other(Node node, Relationship relationship) {\n" + 
		"      return relationship == null ? null : relationship.getOtherNode(node);\n" + 
		"   }\n" + 
		"\n" + 
		"	public static void deleteNode(Node node) {\n" + 
		"      node.setProperty(Properties._deleted.name(), true);\n" + 
		"      node.setProperty(Properties._timestamp.name(), System.currentTimeMillis());\n" + 
		"   }\n" + 
		"\n" + 
		"   private static boolean isDeleted(Node node) {\n" + 
		"      return node==null ? true : (Boolean) node.getProperty(Properties._deleted.name(), false);\n" + 
		"   }\n" + 
		"\n" + 
		"	public static void newVersion(Node oldNode, Node newNode) {\n" + 
		"      final Relationship versionRelation = newNode.createRelationshipTo(oldNode, Relations._VERSION);\n" + 
		"      versionRelation.setProperty(Properties._timestamp.name(), System.currentTimeMillis());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void getAllVersionsOf(Node node, java.util.function.Consumer<Node> consumer) {\n" + 
		"      final Relationship versionRelation = node.getSingleRelationship(Relations._VERSION, Direction.OUTGOING);\n" + 
		"      if (versionRelation == null) return;\n" + 
		"\n" + 
		"      final Node oldVersion = versionRelation.getOtherNode(node);\n" + 
		"      consumer.accept(oldVersion);\n" + 
		"\n" + 
		"      getAllVersionsOf(oldVersion, consumer);\n" + 
		"   }\n" + 
		"}>>\n")
			.append("propertyAccessors(enumType,name,type) ::= <<public static ~type~ get~name;format=\"capitalize\"~(PropertyContainer container) {\n" + 
		"	return ~if(enumType)~~enumType~.valueOf(container.getProperty(Properties.~name;format=\"lowFirst\"~.name()).toString());~else~(~type~) container.getProperty(Properties.~name;format=\"lowFirst\"~.name());~endif~\n" + 
		"}\n" + 
		"\n" + 
		"public static ~type~ get~name;format=\"capitalize\"~(PropertyContainer container, ~type~ defaultValue) {\n" + 
		"	return container == null || !container.hasProperty(Properties.~name;format=\"lowFirst\"~.name()) ? defaultValue : ~if(enumType)~~enumType~.valueOf(container.getProperty(Properties.~name;format=\"lowFirst\"~.name()).toString());~else~(~type~) container.getProperty(Properties.~name;format=\"lowFirst\"~.name());~endif~\n" + 
		"}\n" + 
		"\n" + 
		"public static void set~name;format=\"capitalize\"~(PropertyContainer container, ~type~ ~name;format=\"lowFirst\"~) {\n" + 
		"	// todo validation\n" + 
		"	container.setProperty(Properties.~name;format=\"lowFirst\"~.name(), ~name;format=\"lowFirst\"~~if(enumType)~.name()~endif~);\n" + 
		"}>>\n")
			.append("oneToMany(dst,name,src,dstDirection,srcDirection) ::= <<public static void get_~dst~_~name;format=\"toUpper\"~_for_~src;format=\"capitalize\"~(Node ~src;format=\"lowFirst\"~, RelationConsumer consumer) {\n" + 
		"	final Iterable<Relationship> relations = ~src;format=\"lowFirst\"~.getRelationships(Direction.~srcDirection~, Relations.~name;format=\"toUpper\"~);\n" + 
		"   for (Relationship relationship : relations) {\n" + 
		"		final Node other = relationship.getOtherNode(~src;format=\"lowFirst\"~);\n" + 
		"      if (isDeleted(other)) continue;\n" + 
		"   	if (consumer.handle(relationship, other)) break;\n" + 
		"	}\n" + 
		"}\n" + 
		"\n" + 
		"public static Node get_~src~_~name;format=\"toUpper\"~_for_~dst~(Node ~dst;format=\"lowFirst\"~) {\n" + 
		"	final Relationship relationship = ~dst;format=\"lowFirst\"~.getSingleRelationship(Relations.~name;format=\"toUpper\"~, Direction.~dstDirection~);\n" + 
		"	if (relationship == null) return null;\n" + 
		"   final Node node = relationship.getOtherNode(~dst;format=\"lowFirst\"~);\n" + 
		"   return node == null || isDeleted(node) ? null : node;\n" + 
		"}>>\n")
			.append("oneToOne(dst,name,src) ::= <<public static Node get_~src~_~name;format=\"toUpper\"~_for_~dst~(Node ~dst;format=\"lowFirst\"~) {\n" + 
		"	final Relationship relationship = ~dst;format=\"lowFirst\"~.getSingleRelationship(Relations.~name;format=\"toUpper\"~, Direction.OUTGOING);\n" + 
		"	if (relationship == null) return null;\n" + 
		"   final Node other = relationship.getOtherNode(~dst;format=\"lowFirst\"~);\n" + 
		"   return other == null || isDeleted(other) ? null : other;\n" + 
		"}\n" + 
		"\n" + 
		"public static Node get_~dst~_~name;format=\"toUpper\"~_for_~src~(Node ~src;format=\"lowFirst\"~) {\n" + 
		"	final Relationship relationship = ~src;format=\"lowFirst\"~.getSingleRelationship(Relations.~name;format=\"toUpper\"~, Direction.INCOMING);\n" + 
		"	if (relationship == null) return null;\n" + 
		"   final Node other = relationship.getOtherNode(~src;format=\"lowFirst\"~);\n" + 
		"   return other == null || isDeleted(other) ? null : other;\n" + 
		"}>>\n")
			.append("manyToMany(dst,name,src) ::= <<public static void get_~src~_~name;format=\"toUpper\"~_for_~dst;format=\"capitalize\"~(Node ~dst;format=\"lowFirst\"~, RelationConsumer consumer) {\n" + 
		"	final Iterable<Relationship> relations = ~dst;format=\"lowFirst\"~.getRelationships(Direction.INCOMING, Relations.~name;format=\"toUpper\"~);\n" + 
		"   for (Relationship relationship : relations) {\n" + 
		"		final Node other = relationship.getOtherNode(~dst;format=\"lowFirst\"~);\n" + 
		"      if (isDeleted(other)) continue;\n" + 
		"   	if (consumer.handle(relationship, other)) break;\n" + 
		"	}\n" + 
		"}\n" + 
		"\n" + 
		"public static void get_~dst~_~name;format=\"toUpper\"~_for_~src;format=\"capitalize\"~(Node ~src;format=\"lowFirst\"~, RelationConsumer consumer) {\n" + 
		"	final Iterable<Relationship> relations = ~src;format=\"lowFirst\"~.getRelationships(Direction.OUTGOING, Relations.~name;format=\"toUpper\"~);\n" + 
		"   for (Relationship relationship : relations) {\n" + 
		"		final Node other = relationship.getOtherNode(~src;format=\"lowFirst\"~);\n" + 
		"      if (isDeleted(other)) continue;\n" + 
		"   	if (consumer.handle(relationship, other)) break;\n" + 
		"	}\n" + 
		"}>>\n")
			.append("DomainVerticle(hazelcastConfig,implementation,incoming,name,outgoing,packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import org.neo4j.graphdb.*;\n" + 
		"import org.neo4j.graphdb.factory.GraphDatabaseFactory;\n" + 
		"import org.neo4j.graphdb.factory.GraphDatabaseSettings;\n" + 
		"\n" + 
		"import java.io.File;\n" + 
		"import java.util.UUID;\n" + 
		"\n" + 
		"abstract class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"	protected GraphDatabaseService db;\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public void start(Future<Void> startFuture) throws Exception {\n" + 
		"      log.info(\"starting ~name~\");\n" + 
		"\n" + 
		"			vertx.executeBlocking(future -> {\n" + 
		"\n" + 
		"         try {\n" + 
		"\n" + 
		"            final String path = config().getString(\"path\");\n" + 
		"            log.info(\"Starting db at \" + path);\n" + 
		"\n" + 
		"            if (path == null || path.length() == 0)\n" + 
		"               throw new IllegalArgumentException(\"missing 'path' config parameter\");\n" + 
		"\n" + 
		"            db = new GraphDatabaseFactory().\n" + 
		"                  newEmbeddedDatabaseBuilder(new File(path)).\n" + 
		"                  setConfig(GraphDatabaseSettings.allow_upgrade, \"true\").\n" + 
		"                  newGraphDatabase();\n" + 
		"\n" + 
		"            try (Transaction tx = db.beginTx()) {\n" + 
		"               onStart(startFuture);\n" + 
		"               tx.success();\n" + 
		"            }\n" + 
		"\n" + 
		"            future.complete();\n" + 
		"\n" + 
		"         } catch (Throwable throwable) {\n" + 
		"            log.error(\"executeBlocking exception : \" + throwable.getMessage(), throwable);\n" + 
		"            future.fail(throwable);\n" + 
		"         }\n" + 
		"\n" + 
		"      }, res -> {\n" + 
		"\n" + 
		"         if (res.failed()) {\n" + 
		"            log.error(\"failed to start ~name~ : \", res.cause());\n" + 
		"            startFuture.fail(res.cause());\n" + 
		"\n" + 
		"         } else {\n" + 
		"            log.info(\"started ~name~ successfully \");\n" + 
		"            vertx.eventBus().consumer(deploymentID(), this::handleInstanceMessage);\n" + 
		"\n" + 
		"				~incoming:{it|log.info(\"consumer \" + deploymentID() + \" handles '~it.address~'\");\n" + 
		"vertx.eventBus().consumer(\"~it.address~\", new TransactionMessageHandler(\"~it.address~\", on~it.name;format=\"capitalize\"~()));};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"            startFuture.complete();\n" + 
		"         }\n" + 
		"      });\n" + 
		"	}\n" + 
		"	\n" + 
		"	protected interface TransactionalMessageHandler {\n" + 
		"\n" + 
		"      void handle(Transaction tx, Message<JsonObject> message) throws Exception;\n" + 
		"\n" + 
		"   }\n" + 
		"\n" + 
		"   protected final class TransactionMessageHandler implements Handler<Message<JsonObject~gt()~> {\n" + 
		"\n" + 
		"      private final String messageName;\n" + 
		"      private final TransactionalMessageHandler handler;\n" + 
		"\n" + 
		"      TransactionMessageHandler(String messageName, TransactionalMessageHandler handler) {\n" + 
		"         this.messageName = messageName;\n" + 
		"         this.handler = handler;\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public void handle(Message<JsonObject> message) {\n" + 
		"         log.info(deploymentID() + \" on \" + messageName + \" \" + message.body().encode());\n" + 
		"\n" + 
		"         try (Transaction tx = db.beginTx()) {\n" + 
		"            try {\n" + 
		"               handler.handle(tx, message);\n" + 
		"               tx.success();\n" + 
		"            } catch (Exception e) {\n" + 
		"               log.error(deploymentID() + \" exception on \" + messageName + \" \" + message.body().encode() + \" \" + e.getMessage(), e);\n" + 
		"               tx.failure();\n" + 
		"               message.reply(newException(e));\n" + 
		"            }\n" + 
		"         }\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"	~outgoing:{it|protected void publishTo~it.name~(JsonObject jsonObject) { log.info(\"publish to ~it.address~ \" + jsonObject.toString()); vertx.eventBus().publish(\"~it.address~\", jsonObject); ~eom()~};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~incoming:{it|protected TransactionalMessageHandler on~it.name;format=\"capitalize\"~() {~if(it.impl)~\n" + 
		"	return (tx, message) -> {\n" + 
		"		~it.impl~\n" + 
		"	~eom()~;~else~\n" + 
		"	return null;\n" + 
		"~endif~\n" + 
		"\n" + 
		"~eom()~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"	protected void handleInstanceMessage(Message<JsonObject> message) { log.info(\"handle instance message \" + deploymentID() + \" \" + message.body().toString()); }\n" + 
		"\n" + 
		"	protected void onStart(Future<Void> startFuture) {\n" + 
		"  	}\n" + 
		"\n" + 
		"	private enum ResponseStatus {\n" + 
		"      SUCCESS,\n" + 
		"      FAIL\n" + 
		"   }\n" + 
		"\n" + 
		"   private enum PayloadType {\n" + 
		"      STRING,\n" + 
		"      JSONOBJECT,\n" + 
		"      JSONARRAY,\n" + 
		"      EXCEPTION\n" + 
		"   }\n" + 
		"\n" + 
		"   protected static JsonObject newSuccess(String payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"            put(\"payloadType\", PayloadType.STRING).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   protected static JsonObject newSuccess(JsonObject payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"            put(\"payloadType\", PayloadType.JSONOBJECT).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   protected static JsonObject newSuccess(JsonArray payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"            put(\"payloadType\", PayloadType.JSONARRAY).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   protected static JsonObject newFail(String payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.FAIL).\n" + 
		"            put(\"payloadType\", PayloadType.STRING).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"	protected static JsonObject newFail(JsonArray payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.FAIL).\n" + 
		"            put(\"payloadType\", PayloadType.JSONARRAY).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   protected static JsonObject newException(Exception e) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.FAIL).\n" + 
		"            put(\"payloadType\", PayloadType.EXCEPTION).\n" + 
		"            put(\"payload\", e.getMessage());\n" + 
		"   }\n" + 
		"\n" + 
		"	private static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {\n" + 
		"\n" + 
		"      // if already related, merge properties:\n" + 
		"      for (Object o : outgoing(source, relationshipType)) {\n" + 
		"         final Relationship relationship = (Relationship) o;\n" + 
		"         if (target.equals(other(source, relationship))) {\n" + 
		"            for (int i = 0; i < properties.length; i += 2)\n" + 
		"               relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"            return relationship;\n" + 
		"         }\n" + 
		"      }\n" + 
		"\n" + 
		"      final Relationship relationship = source.createRelationshipTo(target, relationshipType);\n" + 
		"      for (int i = 0; i < properties.length; i += 2)\n" + 
		"         relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"\n" + 
		"      return relationship;\n" + 
		"   }\n" + 
		"\n" + 
		"	private static void mapString(Message<JsonObject> message, Node node, String name) {\n" + 
		"      if (message.body().getString(name) != null) node.setProperty(name, message.body().getString(name));\n" + 
		"   }\n" + 
		"\n" + 
		"	private static void mapInteger(Message<JsonObject> message, Node node, String name) {\n" + 
		"      if (message.body().getInteger(name) != null) node.setProperty(name, message.body().getInteger(name));\n" + 
		"   }\n" + 
		"\n" + 
		"	private static void mapLong(Message<JsonObject> message, Node node, String name) {\n" + 
		"      if (message.body().getLong(name) != null) node.setProperty(name, message.body().getLong(name));\n" + 
		"   }\n" + 
		"\n" + 
		"	private static void mapBoolean(Message<JsonObject> message, Node node, String name) {\n" + 
		"      if (message.body().getBoolean(name) != null) node.setProperty(name, message.body().getBoolean(name));\n" + 
		"   }\n" + 
		"\n" + 
		"	private static void map(String name, JsonObject jsonObject, Node node) {\n" + 
		"      if (node.hasProperty(name))\n" + 
		"         jsonObject.put(name, node.getProperty(name));\n" + 
		"   }\n" + 
		"\n" + 
		"	private static void map(JsonArray properties, String name, JsonObject jsonObject, Node node) {\n" + 
		"      if ((properties == null || properties.contains(name)) && node.hasProperty(name))\n" + 
		"         jsonObject.put(name, node.getProperty(name));\n" + 
		"   }\n" + 
		"\n" + 
		"	private static Node newNode(GraphDatabaseService db, String label) {\n" + 
		"      final Node node = db.createNode(Label.label(label));\n" + 
		"      node.setProperty(\"_deleted\", Boolean.FALSE);\n" + 
		"      node.setProperty(\"_uuid\", UUID.randomUUID().toString());\n" + 
		"      return node;\n" + 
		"   }\n" + 
		"\n" + 
		"	private static String deleteNode(Node node) {\n" + 
		"      final String uuid = node.getProperty(\"_uuid\").toString();\n" + 
		"      node.setProperty(\"_deleted\", Boolean.TRUE);\n" + 
		"      return uuid;\n" + 
		"   }\n" + 
		"\n" + 
		"   private static boolean isDeleted(Node node) {\n" + 
		"      return !((Boolean) node.getProperty(\"_deleted\"));\n" + 
		"   }\n" + 
		"	\n" + 
		"	private static Iterable<?> outgoing(Node node, RelationshipType type) {\n" + 
		"      return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);\n" + 
		"   }\n" + 
		"\n" + 
		"	private static Node other(Node node, Relationship relationship) {\n" + 
		"      return relationship == null ? null : relationship.getOtherNode(node);\n" + 
		"   }\n" + 
		"\n" + 
		"~if(implementation)~\n" + 
		"\n" + 
		"	// to run: java -Dlog4j.configuration=file:./log4j.properties~if(hazelcastConfig)~ -Dvertx.hazelcast.config=~hazelcastConfig~~endif~ -jar [name]-fat.jar\n" + 
		"   public static void main(String[] args) {\n" + 
		"		VertxUtil.deploy(io.vertx.core.Vertx.vertx(), ~implementation~.class, new io.vertx.core.DeploymentOptions(), log, new VertxUtil.SuccessHandler<String>() {\n" + 
		"         @Override\n" + 
		"         public void onSuccess(String result) {\n" + 
		"            log.info(\"deploy ~name~ \" + result);\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onFail(Throwable t) {\n" + 
		"            log.error(\"deploy ~name~ failed \" + t.getMessage(), t);\n" + 
		"         }\n" + 
		"      });\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"}>>\n")
			.append("cypherMatchNode(id,label,properties) ::= <<(~id~:~label~~if(properties)~ {~properties:{it|~it.name~: $~it.name~};separator=\", \"~}~endif~)>>\n")
			.append("cypherMatchRelation(dstRel,src,srcRel,type,dst,properties) ::= <<~src~~srcRel~[:~type;format=\"toUpper\"~~if(properties)~ {~properties:{it|~it.name;format=\"lowFirst\"~: $~it.name;format=\"lowFirst\"~};separator=\", \"~}~endif~]~dstRel~~dst~>>\n")
			.append("NodeMatcher(label,properties) ::= <<public static ~label~Matcher new~label~Matcher() {\n" + 
		"	return new ~label~Matcher();\n" + 
		"}\n" + 
		"\n" + 
		"public static ~label~Matcher new~label~Matcher(String id) {\n" + 
		"	return new ~label~Matcher(id);\n" + 
		"}\n" + 
		"\n" + 
		"public static final class ~label~Matcher extends NodeMatcher {\n" + 
		"\n" + 
		"   private ~label~Matcher() {\n" + 
		"      super(\"~label;format=\"lowFirst\"~\", \"~label~\");\n" + 
		"   }\n" + 
		"\n" + 
		"   private ~label~Matcher(String id) {\n" + 
		"   	super(id, \"~label~\");\n" + 
		"   }\n" + 
		"\n" + 
		"~properties:{it|\n" + 
		"   public ~label~Matcher match~it.name;format=\"capitalize\"~(String ~it.name;format=\"lowFirst\"~) {\n" + 
		"      properties.put(\"~it.name;format=\"lowFirst\"~\", ~it.name;format=\"lowFirst\"~);\n" + 
		"   	return this;\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	public ~label~Matcher return~it.name;format=\"capitalize\"~() {\n" + 
		"      returnValues.add(id + \".\" + \"~it.name;format=\"lowFirst\"~\");\n" + 
		"   	return this;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	public ~label~Matcher returnNode() {\n" + 
		"	   returnValues.add(id);\n" + 
		"		return this;\n" + 
		"	}\n" + 
		"	\n" + 
		"	public ~label~Matcher returnExpression(String expression) {\n" + 
		"		returnValues.add(expression);\n" + 
		"	   return this;\n" + 
		"	}\n" + 
		"}>>\n")
			.append("RelationMatcher(dst,src,type,properties) ::= <<public static ~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher new~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher() {\n" + 
		"	return new ~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher();\n" + 
		"}\n" + 
		"\n" + 
		"public static ~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher new~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher() {\n" + 
		"	return new ~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher();\n" + 
		"}\n" + 
		"\n" + 
		"public static final class ~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher extends RelationMatcher {\n" + 
		"\n" + 
		"   private ~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher() {\n" + 
		"      super(\"~type;format=\"toUpper\"~\");\n" + 
		"      this.srcRel = \"-\";\n" + 
		"      this.dstRel = \"->\";\n" + 
		"   }\n" + 
		"\n" + 
		"~properties:{it|\n" + 
		"   public ~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher match~it.name;format=\"capitalize\"~(String ~it.name;format=\"lowFirst\"~) {\n" + 
		"      properties.put(\"~it.name;format=\"lowFirst\"~\", ~it.name;format=\"lowFirst\"~);\n" + 
		"   	return this;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"   public ~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher set~src;format=\"capitalize\"~Matcher(Matcher ~src;format=\"lowFirst\"~Matcher) {\n" + 
		"      this.src = ~src;format=\"lowFirst\"~Matcher.toString();\n" + 
		"		this.returnValues.addAll(~src;format=\"lowFirst\"~Matcher.returnValues());\n" + 
		"      return this;\n" + 
		"   }\n" + 
		"\n" + 
		"   public ~src;format=\"capitalize\"~_~type;format=\"toUpper\"~_~dst;format=\"capitalize\"~Matcher set~dst;format=\"capitalize\"~Matcher(Matcher ~dst;format=\"lowFirst\"~Matcher) {\n" + 
		"      this.dst = ~dst;format=\"lowFirst\"~Matcher.toString();\n" + 
		"		this.returnValues.addAll(~dst;format=\"lowFirst\"~Matcher.returnValues());\n" + 
		"      return this;\n" + 
		"   }\n" + 
		"}\n" + 
		"\n" + 
		"public static final class ~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher extends RelationMatcher {\n" + 
		"\n" + 
		"   private ~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher() {\n" + 
		"      super(\"~type;format=\"toUpper\"~\");\n" + 
		"      this.srcRel = \"<-\";\n" + 
		"      this.dstRel = \"-\";\n" + 
		"   }\n" + 
		"\n" + 
		"~properties:{it|\n" + 
		"   public ~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher match~it.name;format=\"capitalize\"~(String ~it.name;format=\"lowFirst\"~) {\n" + 
		"      properties.put(\"~it.name;format=\"lowFirst\"~\", ~it.name;format=\"lowFirst\"~);\n" + 
		"   	return this;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"   public ~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher set~dst;format=\"capitalize\"~Matcher(Matcher ~dst;format=\"lowFirst\"~Matcher) {\n" + 
		"      this.src = ~dst;format=\"lowFirst\"~Matcher.toString();\n" + 
		"		this.returnValues.addAll(~dst;format=\"lowFirst\"~Matcher.returnValues());\n" + 
		"      return this;\n" + 
		"   }\n" + 
		"\n" + 
		"   public ~dst;format=\"capitalize\"~_~type;format=\"toUpper\"~_~src;format=\"capitalize\"~Matcher set~src;format=\"capitalize\"~Matcher(Matcher ~src;format=\"lowFirst\"~Matcher) {\n" + 
		"      this.dst = ~src;format=\"lowFirst\"~Matcher.toString();\n" + 
		"		this.returnValues.addAll(~src;format=\"lowFirst\"~Matcher.returnValues());\n" + 
		"      return this;\n" + 
		"   }\n" + 
		"}>>\n")
			.append("verticle_update_entity(label,properties) ::= <<final Node node = db.findNode(Label.label(\"~label~\"), \"_uuid\", message.body().getString(\"uuid\"));\n" + 
		"if (node == null) {\n" + 
		"   message.reply(newFail(\"~label;format=\"capitalize\"~ not found\"));\n" + 
		"   return;\n" + 
		"}\n" + 
		"\n" + 
		"~properties:{it|map~if(it.isEnum)~String~else~~it.type~~endif~(message, node, \"~it.name~\");};separator=\"\\n\"~\n" + 
		"\n" + 
		"message.reply(newSuccess(new JsonObject().put(\"uuid\", node.getProperty(\"_uuid\"))));>>\n")
			.append("verticle_delete_entity(label) ::= <<final Node node = db.findNode(Label.label(\"~label~\"), \"_uuid\", message.body().getString(\"uuid\"));\n" + 
		"if (node == null) {\n" + 
		"	message.reply(newFail(\"~label~ \" + message.body().getString(\"uuid\") + \" not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"final String uuid = deleteNode(node);\n" + 
		"\n" + 
		"message.reply(newSuccess(uuid));>>\n")
			.append("verticle_get_entity(label,properties) ::= <<final Node node = db.findNode(Label.label(\"~label~\"), \"_uuid\", message.body().getString(\"uuid\"));\n" + 
		"if (node == null) {\n" + 
		"   message.reply(newFail(\"~label~ \" + message.body().getString(\"uuid\") + \" not found\"));\n" + 
		"   return;\n" + 
		"}\n" + 
		"\n" + 
		"final JsonObject result = new JsonObject();\n" + 
		"result.put(\"uuid\", node.getProperty(\"_uuid\"));\n" + 
		"~properties:{it|map(\"~it.name~\", result, node);};separator=\"\\n\"~\n" + 
		"message.reply(newSuccess(result));>>\n")
			.append("verticle_get_all_entities(label,properties) ::= <<final JsonArray properties = message.body().getJsonArray(\"properties\");\n" + 
		"final JsonArray result = new JsonArray();\n" + 
		"db.findNodes(Label.label(\"~label~\")).forEachRemaining(node -> {\n" + 
		"   final JsonObject jsonObject = new JsonObject();\n" + 
		"   if (properties == null || properties.contains(\"uuid\")) jsonObject.put(\"uuid\", node.getProperty(\"_uuid\"));\n" + 
		"	~properties:{it|map(properties, \"~it.name~\", jsonObject, node);};separator=\"\\n\"~\n" + 
		"   result.add(jsonObject);\n" + 
		"});\n" + 
		"message.reply(newSuccess(result));>>\n")
			.append("verticle_relate(dst,src,properties,relation) ::= <<final Node src = db.findNode(Label.label(\"~src~\"), \"_uuid\", message.body().getString(\"src\"));\n" + 
		"final Node dst = db.findNode(Label.label(\"~dst~\"), \"_uuid\", message.body().getString(\"dst\"));\n" + 
		"\n" + 
		"if (src == null) {\n" + 
		"	message.reply(newFail(\"~src~ \" + message.body().getString(\"src\") + \" not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"if (dst == null) {\n" + 
		"	message.reply(newFail(\"~dst~ \" + message.body().getString(\"dst\") + \" not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"final Relationship relation = relate(src, dst, RelationshipType.withName(\"~relation~\"));\n" + 
		"~properties:{it|~if(it.isRequired)~relation.setProperty(\"~it.name~\", message.body().get~if(it.isEnum)~String~else~~it.type~~endif~(\"~it.name~\"));~else~if (message.body().get~if(it.isEnum)~String~else~~it.type~~endif~(\"~it.name~\") != null) relation.setProperty(\"~it.name~\", message.body().get~if(it.isEnum)~String~else~~it.type~~endif~(\"~it.name~\"));~endif~};separator=\"\\n\"~\n" + 
		"\n" + 
		"message.reply(newSuccess(\"\"));>>\n")
		.toString();
}