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

   public verticle_map_entityST newverticle_map_entity() {
      return new verticle_map_entityST(stGroup);
   }

   public verticle_get_singleST newverticle_get_single() {
      return new verticle_get_singleST(stGroup);
   }

   public verticle_get_manyST newverticle_get_many() {
      return new verticle_get_manyST(stGroup);
   }

   public DomainVerticleFacadeST newDomainVerticleFacade() {
      return new DomainVerticleFacadeST(stGroup);
   }

   public ExportDatabaseST newExportDatabase() {
      return new ExportDatabaseST(stGroup);
   }

   public DomainNodeST newDomainNode() {
      return new DomainNodeST(stGroup);
   }

   public facade_entityMethodsST newfacade_entityMethods() {
      return new facade_entityMethodsST(stGroup);
   }

   public DomainFacadeRelationST newDomainFacadeRelation() {
      return new DomainFacadeRelationST(stGroup);
   }

   public exportNodeST newexportNode() {
      return new exportNodeST(stGroup);
   }

   public exportRelationST newexportRelation() {
      return new exportRelationST(stGroup);
   }

   public domainPNode_getActionST newdomainPNode_getAction() {
      return new domainPNode_getActionST(stGroup);
   }

   public DomainPNodesST newDomainPNodes() {
      return new DomainPNodesST(stGroup);
   }

   public facade_functionMethodST newfacade_functionMethod() {
      return new facade_functionMethodST(stGroup);
   }

   public domainPNode_getManyMethodST newdomainPNode_getManyMethod() {
      return new domainPNode_getManyMethodST(stGroup);
   }

   public domainPNode_getKeyPressedST newdomainPNode_getKeyPressed() {
      return new domainPNode_getKeyPressedST(stGroup);
   }

   public domainPNode_getSingleMethodST newdomainPNode_getSingleMethod() {
      return new domainPNode_getSingleMethodST(stGroup);
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
      private Object _domain;

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

      public verticle_new_entityST setDomain(Object value) {
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
      private java.util.Set<Object> _mappings = new java.util.LinkedHashSet<>();

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

      public DomainVerticleST addMappingsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._mappings.add(value);
      	template.add("mappings", value);

         return this;
      }

      public java.util.Set<Object> getMappingsValues() {
      	return this._mappings;
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
      private Object _domain;

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

      public verticle_update_entityST setDomain(Object value) {
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
      private Object _domain;

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

      public verticle_get_entityST setDomain(Object value) {
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

   public static final class verticle_get_all_entitiesST implements Neo4jGroupTemplate {


      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private Object _domain;

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

      public verticle_get_all_entitiesST setDomain(Object value) {
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

   public static final class verticle_map_entityST implements Neo4jGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private Object _label;

      private final ST template;

      private verticle_map_entityST(STGroup group) {
   		template = group.getInstanceOf("verticle_map_entity");
   	}

      public verticle_map_entityST addPropertiesValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._properties.add(map);

         template.addAggr("properties.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public verticle_map_entityST setLabel(Object value) {
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

   public static final class verticle_get_singleST implements Neo4jGroupTemplate {


      private Object _relation;
      private Object _direction;
      private Object _domain;
      private Object _dstName;
      private Object _srcName;
      private Object _dst;

      private final ST template;

      private verticle_get_singleST(STGroup group) {
   		template = group.getInstanceOf("verticle_get_single");
   	}

      public verticle_get_singleST setRelation(Object value) {
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

      public verticle_get_singleST setDirection(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._direction == null) {
            this._direction = value;
         	template.add("direction", value);
         }

      	return this;
      }

      public String getDirection() {
      	return (String) this._direction;
      }

      public verticle_get_singleST setDomain(Object value) {
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

      public verticle_get_singleST setDstName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dstName == null) {
            this._dstName = value;
         	template.add("dstName", value);
         }

      	return this;
      }

      public String getDstName() {
      	return (String) this._dstName;
      }

      public verticle_get_singleST setSrcName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcName == null) {
            this._srcName = value;
         	template.add("srcName", value);
         }

      	return this;
      }

      public String getSrcName() {
      	return (String) this._srcName;
      }

      public verticle_get_singleST setDst(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class verticle_get_manyST implements Neo4jGroupTemplate {


      private Object _relation;
      private Object _domain;
      private Object _dstName;
      private Object _srcName;

      private final ST template;

      private verticle_get_manyST(STGroup group) {
   		template = group.getInstanceOf("verticle_get_many");
   	}

      public verticle_get_manyST setRelation(Object value) {
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

      public verticle_get_manyST setDomain(Object value) {
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

      public verticle_get_manyST setDstName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dstName == null) {
            this._dstName = value;
         	template.add("dstName", value);
         }

      	return this;
      }

      public String getDstName() {
      	return (String) this._dstName;
      }

      public verticle_get_manyST setSrcName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcName == null) {
            this._srcName = value;
         	template.add("srcName", value);
         }

      	return this;
      }

      public String getSrcName() {
      	return (String) this._srcName;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class DomainVerticleFacadeST implements Neo4jGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _relations = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _entities = new java.util.LinkedHashSet<>();
      private Object _packageName;
      private Object _domain;
      private java.util.Set<java.util.Map<String, Object>> _functions = new java.util.LinkedHashSet<>();
      private Object _interface;

      private final ST template;

      private DomainVerticleFacadeST(STGroup group) {
   		template = group.getInstanceOf("DomainVerticleFacade");
   	}

      public DomainVerticleFacadeST addRelationsValue(Object directionOne_, Object directionTwo_, Object relation_, Object dst_, Object src_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("directionOne", (directionOne_ == null || directionOne_.toString().length() == 0) ? null : directionOne_);
      	map.put("directionTwo", (directionTwo_ == null || directionTwo_.toString().length() == 0) ? null : directionTwo_);
      	map.put("relation", (relation_ == null || relation_.toString().length() == 0) ? null : relation_);
      	map.put("dst", (dst_ == null || dst_.toString().length() == 0) ? null : dst_);
      	map.put("src", (src_ == null || src_.toString().length() == 0) ? null : src_);
      	this._relations.add(map);

         template.addAggr("relations.{directionOne, directionTwo, relation, dst, src}", map.get("directionOne"), map.get("directionTwo"), map.get("relation"), map.get("dst"), map.get("src"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRelations() {
      	return this._relations;
      }

      public DomainVerticleFacadeST addEntitiesValue(Object methods_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("methods", (methods_ == null || methods_.toString().length() == 0) ? null : methods_);
      	this._entities.add(map);

         template.addAggr("entities.{methods}", map.get("methods"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEntities() {
      	return this._entities;
      }

      public DomainVerticleFacadeST setPackageName(Object value) {
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

      public DomainVerticleFacadeST addFunctionsValue(Object methods_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("methods", (methods_ == null || methods_.toString().length() == 0) ? null : methods_);
      	this._functions.add(map);

         template.addAggr("functions.{methods}", map.get("methods"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getFunctions() {
      	return this._functions;
      }

      public DomainVerticleFacadeST setInterface(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._interface == null) {
            this._interface = value;
         	template.add("interface", value);
         }

      	return this;
      }

      public String getInterface() {
      	return (String) this._interface;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class ExportDatabaseST implements Neo4jGroupTemplate {


      private Object _name;
      private Object _packageName;
      private java.util.Set<Object> _relations = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _nodes = new java.util.LinkedHashSet<>();
      private Object _rootLabel;
      private Object _rootUUID;

      private final ST template;

      private ExportDatabaseST(STGroup group) {
   		template = group.getInstanceOf("ExportDatabase");
   	}

      public ExportDatabaseST setName(Object value) {
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

      public ExportDatabaseST setPackageName(Object value) {
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

      public ExportDatabaseST addRelationsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._relations.add(value);
      	template.add("relations", value);

         return this;
      }

      public java.util.Set<Object> getRelationsValues() {
      	return this._relations;
      }

      public ExportDatabaseST addNodesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._nodes.add(value);
      	template.add("nodes", value);

         return this;
      }

      public java.util.Set<Object> getNodesValues() {
      	return this._nodes;
      }

      public ExportDatabaseST setRootLabel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._rootLabel == null) {
            this._rootLabel = value;
         	template.add("rootLabel", value);
         }

      	return this;
      }

      public String getRootLabel() {
      	return (String) this._rootLabel;
      }

      public ExportDatabaseST setRootUUID(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._rootUUID == null) {
            this._rootUUID = value;
         	template.add("rootUUID", value);
         }

      	return this;
      }

      public String getRootUUID() {
      	return (String) this._rootUUID;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class DomainNodeST implements Neo4jGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _incoming = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _outgoing = new java.util.LinkedHashSet<>();
      private Object _labelName;
      private Object _label;

      private final ST template;

      private DomainNodeST(STGroup group) {
   		template = group.getInstanceOf("DomainNode");
   	}

      public DomainNodeST addIncomingValue(Object action_, Object method_, Object keyPressed_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("action", (action_ == null || action_.toString().length() == 0) ? null : action_);
      	map.put("method", (method_ == null || method_.toString().length() == 0) ? null : method_);
      	map.put("keyPressed", (keyPressed_ == null || keyPressed_.toString().length() == 0) ? null : keyPressed_);
      	this._incoming.add(map);

         template.addAggr("incoming.{action, method, keyPressed}", map.get("action"), map.get("method"), map.get("keyPressed"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getIncoming() {
      	return this._incoming;
      }

      public DomainNodeST addOutgoingValue(Object action_, Object keyPressed_, Object method_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("action", (action_ == null || action_.toString().length() == 0) ? null : action_);
      	map.put("keyPressed", (keyPressed_ == null || keyPressed_.toString().length() == 0) ? null : keyPressed_);
      	map.put("method", (method_ == null || method_.toString().length() == 0) ? null : method_);
      	this._outgoing.add(map);

         template.addAggr("outgoing.{action, keyPressed, method}", map.get("action"), map.get("keyPressed"), map.get("method"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getOutgoing() {
      	return this._outgoing;
      }

      public DomainNodeST setLabelName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._labelName == null) {
            this._labelName = value;
         	template.add("labelName", value);
         }

      	return this;
      }

      public String getLabelName() {
      	return (String) this._labelName;
      }

      public DomainNodeST setLabel(Object value) {
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

   public static final class facade_entityMethodsST implements Neo4jGroupTemplate {


      private Object _domain;
      private Object _label;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private facade_entityMethodsST(STGroup group) {
   		template = group.getInstanceOf("facade_entityMethods");
   	}

      public facade_entityMethodsST setDomain(Object value) {
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

      public facade_entityMethodsST setLabel(Object value) {
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

      public facade_entityMethodsST addPropertiesValue(Object name_, Object type_) {
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

   public static final class DomainFacadeRelationST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _name;
      private Object _src;

      private final ST template;

      private DomainFacadeRelationST(STGroup group) {
   		template = group.getInstanceOf("DomainFacadeRelation");
   	}

      public DomainFacadeRelationST setDst(Object value) {
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

      public DomainFacadeRelationST setName(Object value) {
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

      public DomainFacadeRelationST setSrc(Object value) {
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

   public static final class exportNodeST implements Neo4jGroupTemplate {


      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private Object _uuid;
      private java.util.Set<Object> _labels = new java.util.LinkedHashSet<>();

      private final ST template;

      private exportNodeST(STGroup group) {
   		template = group.getInstanceOf("exportNode");
   	}

      public exportNodeST addPropertiesValue(Object value_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._properties.add(map);

         template.addAggr("properties.{value, name}", map.get("value"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public exportNodeST setUuid(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._uuid == null) {
            this._uuid = value;
         	template.add("uuid", value);
         }

      	return this;
      }

      public String getUuid() {
      	return (String) this._uuid;
      }

      public exportNodeST addLabelsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._labels.add(value);
      	template.add("labels", value);

         return this;
      }

      public java.util.Set<Object> getLabelsValues() {
      	return this._labels;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class exportRelationST implements Neo4jGroupTemplate {


      private Object _dstLabel;
      private Object _dstUuid;
      private Object _srcLabel;
      private Object _srcUuid;
      private Object _type;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private exportRelationST(STGroup group) {
   		template = group.getInstanceOf("exportRelation");
   	}

      public exportRelationST setDstLabel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dstLabel == null) {
            this._dstLabel = value;
         	template.add("dstLabel", value);
         }

      	return this;
      }

      public String getDstLabel() {
      	return (String) this._dstLabel;
      }

      public exportRelationST setDstUuid(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dstUuid == null) {
            this._dstUuid = value;
         	template.add("dstUuid", value);
         }

      	return this;
      }

      public String getDstUuid() {
      	return (String) this._dstUuid;
      }

      public exportRelationST setSrcLabel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcLabel == null) {
            this._srcLabel = value;
         	template.add("srcLabel", value);
         }

      	return this;
      }

      public String getSrcLabel() {
      	return (String) this._srcLabel;
      }

      public exportRelationST setSrcUuid(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcUuid == null) {
            this._srcUuid = value;
         	template.add("srcUuid", value);
         }

      	return this;
      }

      public String getSrcUuid() {
      	return (String) this._srcUuid;
      }

      public exportRelationST setType(Object value) {
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

      public exportRelationST addPropertiesValue(Object name_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._properties.add(map);

         template.addAggr("properties.{name, value}", map.get("name"), map.get("value"));
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

   public static final class domainPNode_getActionST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _relation;
      private Object _src;

      private final ST template;

      private domainPNode_getActionST(STGroup group) {
   		template = group.getInstanceOf("domainPNode_getAction");
   	}

      public domainPNode_getActionST setDst(Object value) {
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

      public domainPNode_getActionST setRelation(Object value) {
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

      public domainPNode_getActionST setSrc(Object value) {
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

   public static final class DomainPNodesST implements Neo4jGroupTemplate {


      private Object _packageName;
      private Object _domain;
      private java.util.Set<java.util.Map<String, Object>> _entities = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _relations = new java.util.LinkedHashSet<>();
      private Object _interface;

      private final ST template;

      private DomainPNodesST(STGroup group) {
   		template = group.getInstanceOf("DomainPNodes");
   	}

      public DomainPNodesST setPackageName(Object value) {
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

      public DomainPNodesST setDomain(Object value) {
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

      public DomainPNodesST addEntitiesValue(Object implementation_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("implementation", (implementation_ == null || implementation_.toString().length() == 0) ? null : implementation_);
      	this._entities.add(map);

         template.addAggr("entities.{implementation}", map.get("implementation"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEntities() {
      	return this._entities;
      }

      public DomainPNodesST addRelationsValue(Object implementation_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("implementation", (implementation_ == null || implementation_.toString().length() == 0) ? null : implementation_);
      	this._relations.add(map);

         template.addAggr("relations.{implementation}", map.get("implementation"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRelations() {
      	return this._relations;
      }

      public DomainPNodesST setInterface(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._interface == null) {
            this._interface = value;
         	template.add("interface", value);
         }

      	return this;
      }

      public String getInterface() {
      	return (String) this._interface;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class facade_functionMethodST implements Neo4jGroupTemplate {


      private Object _name;
      private Object _domain;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private facade_functionMethodST(STGroup group) {
   		template = group.getInstanceOf("facade_functionMethod");
   	}

      public facade_functionMethodST setName(Object value) {
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

      public facade_functionMethodST setDomain(Object value) {
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

      public facade_functionMethodST addPropertiesValue(Object name_, Object type_) {
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

   public static final class domainPNode_getManyMethodST implements Neo4jGroupTemplate {


      private Object _relation;
      private Object _domain;
      private Object _dst;
      private Object _src;
      private Object _srcNode;
      private Object _incoming;

      private final ST template;

      private domainPNode_getManyMethodST(STGroup group) {
   		template = group.getInstanceOf("domainPNode_getManyMethod");
   	}

      public domainPNode_getManyMethodST setRelation(Object value) {
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

      public domainPNode_getManyMethodST setDomain(Object value) {
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

      public domainPNode_getManyMethodST setDst(Object value) {
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

      public domainPNode_getManyMethodST setSrc(Object value) {
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

      public domainPNode_getManyMethodST setSrcNode(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcNode == null) {
            this._srcNode = value;
         	template.add("srcNode", value);
         }

      	return this;
      }

      public String getSrcNode() {
      	return (String) this._srcNode;
      }

      public domainPNode_getManyMethodST setIncoming(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._incoming == null) {
            this._incoming = value;
         	template.add("incoming", value);
         }

      	return this;
      }

      public String getIncoming() {
      	return (String) this._incoming;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public static final class domainPNode_getKeyPressedST implements Neo4jGroupTemplate {


      private Object _dst;
      private Object _relation;
      private Object _src;

      private final ST template;

      private domainPNode_getKeyPressedST(STGroup group) {
   		template = group.getInstanceOf("domainPNode_getKeyPressed");
   	}

      public domainPNode_getKeyPressedST setDst(Object value) {
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

      public domainPNode_getKeyPressedST setRelation(Object value) {
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

      public domainPNode_getKeyPressedST setSrc(Object value) {
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

   public static final class domainPNode_getSingleMethodST implements Neo4jGroupTemplate {


      private Object _srcNode;
      private Object _src;
      private Object _dst;
      private Object _relation;
      private Object _incoming;
      private Object _domain;

      private final ST template;

      private domainPNode_getSingleMethodST(STGroup group) {
   		template = group.getInstanceOf("domainPNode_getSingleMethod");
   	}

      public domainPNode_getSingleMethodST setSrcNode(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._srcNode == null) {
            this._srcNode = value;
         	template.add("srcNode", value);
         }

      	return this;
      }

      public String getSrcNode() {
      	return (String) this._srcNode;
      }

      public domainPNode_getSingleMethodST setSrc(Object value) {
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

      public domainPNode_getSingleMethodST setDst(Object value) {
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

      public domainPNode_getSingleMethodST setRelation(Object value) {
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

      public domainPNode_getSingleMethodST setIncoming(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._incoming == null) {
            this._incoming = value;
         	template.add("incoming", value);
         }

      	return this;
      }

      public String getIncoming() {
      	return (String) this._incoming;
      }

      public domainPNode_getSingleMethodST setDomain(Object value) {
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
			.append("verticle_new_entity(label,properties,uniqueProperty,uniqueType,domain) ::= <<final JsonArray errors = new JsonArray();\n" + 
		"~properties:{it|~if(it.isRequired)~if (message.body().get~if(it.isEnum)~String~else~~it.type~~endif~(\"~it.name~\") == null) errors.add(\"missing ~it.name~\");\n" + 
		"~endif~}~\n" + 
		"if (!errors.isEmpty()) {\n" + 
		"	message.reply(newFail(errors));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"~if(uniqueProperty)~\n" + 
		"// ~uniqueProperty~ is unique, so check if already exists:\n" + 
		"final Node existing = ~domain~.find~label~By~uniqueProperty;format=\"capitalize\"~(db, message.body().getString(\"~uniqueProperty~\"));\n" + 
		"if (existing != null) {\n" + 
		"	if (!isDeleted(existing)) {\n" + 
		"		message.reply(newFail(\"~label~ \" + message.body().get~uniqueType~(\"~uniqueProperty~\") + \" exists\"));\n" + 
		"		return;	\n" + 
		"	}\n" + 
		"}\n" + 
		"~endif~\n" + 
		"\n" + 
		"final Node node = ~domain~.new~label~(db~if(properties)~~properties:{it|~if(it.isRequired)~, ~if(it.isEnum)~~domain~.~it.name~.valueOf(~endif~message.body().get~if(it.isEnum)~String~else~~it.type~~endif~(\"~it.name~\")~if(it.isEnum)~)~endif~~endif~};separator=\" \"~~endif~);\n" + 
		"message.reply(newSuccess(map~label~toJson(node)));>>\n")
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
		"	~requiredProperties:{it|if (~it.name;format=\"lowFirst\"~ != null ) node.setProperty(Properties.~it.name;format=\"lowFirst\"~.name(), ~it.name;format=\"lowFirst\"~~if(it.isEnum)~.name()~endif~);};separator=\"\\n\"~\n" + 
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
		"* ~description~\n" + 
		"*/\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"	public enum Entities implements Label {\n" + 
		"		~entities:{it|~it;format=\"capitalize\"~};separator=\", \"~\n" + 
		"	}\n" + 
		"\n" + 
		"	public enum Relations implements RelationshipType {\n" + 
		"		_VERSION, ~relations:{it|~it;format=\"toUpper\"~};separator=\", \"~\n" + 
		"	}\n" + 
		"\n" + 
		"	public enum Properties {\n" + 
		"		_uuid, _deleted, _timestamp, ~properties:{it|~it;format=\"lowFirst\"~};separator=\", \"~\n" + 
		"	}\n" + 
		"\n" + 
		"~enums:{it|\n" + 
		"	public enum ~it.name~ {\n" + 
		"	~it.enums~\n" + 
		"~eom()~};separator=\"\\n\"~\n" + 
		"	\n" + 
		"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"	public static GraphDatabaseService newDatabase(String path) {\n" + 
		"		return new org.neo4j.graphdb.factory.GraphDatabaseFactory().\n" + 
		"				newEmbeddedDatabaseBuilder(new java.io.File(path)).\n" + 
		"				setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_store_upgrade, \"true\").\n" + 
		"				newGraphDatabase();\n" + 
		"	}\n" + 
		"\n" + 
		"	public static String getUuid(Node node) {\n" + 
		"		return (String) node.getProperty(Properties._uuid.name());\n" + 
		"	}\n" + 
		"\n" + 
		"	public interface NodeConsumer {\n" + 
		"\n" + 
		"		/**\n" + 
		"		* @return true if stop iteration\n" + 
		"		*/\n" + 
		"		boolean handle(Node node);\n" + 
		"	}\n" + 
		"\n" + 
		"	public interface RelationConsumer {\n" + 
		"\n" + 
		"		/**\n" + 
		"		* @return true if stop iteration\n" + 
		"		*/\n" + 
		"		boolean handle(Relationship relationship, Node other);\n" + 
		"	}\n" + 
		"\n" + 
		"	public interface TransactionHandler {\n" + 
		"\n" + 
		"		void execute() throws Exception;\n" + 
		"\n" + 
		"		void handleException(Exception e);\n" + 
		"	}\n" + 
		"\n" + 
		"	public static void doInTransaction(GraphDatabaseService db, TransactionHandler transactionHandler) {\n" + 
		"		try (Transaction tx = db.beginTx()) {\n" + 
		"			transactionHandler.execute();\n" + 
		"			tx.success();\n" + 
		"		} catch (Exception e) {\n" + 
		"			transactionHandler.handleException(e);\n" + 
		"		}\n" + 
		"	}\n" + 
		"\n" + 
		"	private static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {\n" + 
		"\n" + 
		"		// if already related, merge properties:\n" + 
		"		for (Object o : outgoing(source, relationshipType)) {\n" + 
		"			final Relationship relationship = (Relationship) o;\n" + 
		"			if (target.equals(other(source, relationship))) {\n" + 
		"				for (int i = 0; i < properties.length; i += 2)\n" + 
		"					relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"				return relationship;\n" + 
		"			}\n" + 
		"		}\n" + 
		"\n" + 
		"		final Relationship relationship = source.createRelationshipTo(target, relationshipType);\n" + 
		"		for (int i = 0; i < properties.length; i += 2)\n" + 
		"			relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"\n" + 
		"		return relationship;\n" + 
		"	}\n" + 
		"\n" + 
		"	private static Iterable<?> outgoing(Node node, RelationshipType type) {\n" + 
		"		return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);\n" + 
		"	}\n" + 
		"\n" + 
		"	private static Node other(Node node, Relationship relationship) {\n" + 
		"		return relationship == null ? null : relationship.getOtherNode(node);\n" + 
		"	}\n" + 
		"\n" + 
		"	public static void deleteNode(Node node) {\n" + 
		"		node.setProperty(Properties._deleted.name(), true);\n" + 
		"		node.setProperty(Properties._timestamp.name(), System.currentTimeMillis());\n" + 
		"	}\n" + 
		"\n" + 
		"	private static boolean isDeleted(Node node) {\n" + 
		"		return node==null ? true : (Boolean) node.getProperty(Properties._deleted.name(), false);\n" + 
		"	}\n" + 
		"\n" + 
		"	public static void newVersion(Node oldNode, Node newNode) {\n" + 
		"		final Relationship versionRelation = newNode.createRelationshipTo(oldNode, Relations._VERSION);\n" + 
		"		versionRelation.setProperty(Properties._timestamp.name(), System.currentTimeMillis());\n" + 
		"	}\n" + 
		"\n" + 
		"	public static void getAllVersionsOf(Node node, java.util.function.Consumer<Node> consumer) {\n" + 
		"		final Relationship versionRelation = node.getSingleRelationship(Relations._VERSION, Direction.OUTGOING);\n" + 
		"		if (versionRelation == null) return;\n" + 
		"\n" + 
		"		final Node oldVersion = versionRelation.getOtherNode(node);\n" + 
		"		consumer.accept(oldVersion);\n" + 
		"\n" + 
		"		getAllVersionsOf(oldVersion, consumer);\n" + 
		"	}\n" + 
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
		"	for (Relationship relationship : relations) {\n" + 
		"		final Node other = relationship.getOtherNode(~src;format=\"lowFirst\"~);\n" + 
		"		if (isDeleted(other)) continue;\n" + 
		"		if (consumer.handle(relationship, other)) break;\n" + 
		"	}\n" + 
		"}\n" + 
		"\n" + 
		"public static Node get_~src~_~name;format=\"toUpper\"~_for_~dst~(Node ~dst;format=\"lowFirst\"~) {\n" + 
		"	final Relationship relationship = ~dst;format=\"lowFirst\"~.getSingleRelationship(Relations.~name;format=\"toUpper\"~, Direction.~dstDirection~);\n" + 
		"	if (relationship == null) return null;\n" + 
		"	final Node node = relationship.getOtherNode(~dst;format=\"lowFirst\"~);\n" + 
		"	return node == null || isDeleted(node) ? null : node;\n" + 
		"}>>\n")
			.append("oneToOne(dst,name,src) ::= <<public static Node get_~src~_~name;format=\"toUpper\"~_for_~dst~(Node ~dst;format=\"lowFirst\"~) {\n" + 
		"	final Relationship relationship = ~dst;format=\"lowFirst\"~.getSingleRelationship(Relations.~name;format=\"toUpper\"~, Direction.OUTGOING);\n" + 
		"	if (relationship == null) return null;\n" + 
		"	final Node other = relationship.getOtherNode(~dst;format=\"lowFirst\"~);\n" + 
		"	return other == null || isDeleted(other) ? null : other;\n" + 
		"}\n" + 
		"\n" + 
		"public static Node get_~dst~_~name;format=\"toUpper\"~_for_~src~(Node ~src;format=\"lowFirst\"~) {\n" + 
		"	final Relationship relationship = ~src;format=\"lowFirst\"~.getSingleRelationship(Relations.~name;format=\"toUpper\"~, Direction.INCOMING);\n" + 
		"	if (relationship == null) return null;\n" + 
		"	final Node other = relationship.getOtherNode(~src;format=\"lowFirst\"~);\n" + 
		"	return other == null || isDeleted(other) ? null : other;\n" + 
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
			.append("DomainVerticle(hazelcastConfig,implementation,incoming,name,outgoing,packageName,mappings) ::= <<package ~packageName~;\n" + 
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
		"import java.util.Map;\n" + 
		"import java.util.UUID;\n" + 
		"\n" + 
		"public abstract class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"	~incoming:{it|public static final String ~it.name;format=\"toUpper\"~ = \"~it.address~\";};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~outgoing:{it|public static final String ~it.name;format=\"toUpper\"~ = \"~it.address~\";};separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"	protected GraphDatabaseService db;\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public void start(Future<Void> startFuture) throws Exception {\n" + 
		"		log.info(\"starting ~name~\");\n" + 
		"\n" + 
		"			vertx.executeBlocking(future -> {\n" + 
		"\n" + 
		"				try {\n" + 
		"\n" + 
		"					final String path = config().getString(\"path\");\n" + 
		"					log.info(\"Starting db at \" + path);\n" + 
		"\n" + 
		"					if (path == null || path.length() == 0)\n" + 
		"					throw new IllegalArgumentException(\"missing 'path' config parameter\");\n" + 
		"\n" + 
		"					db = new GraphDatabaseFactory().\n" + 
		"						newEmbeddedDatabaseBuilder(new File(path)).\n" + 
		"						setConfig(GraphDatabaseSettings.allow_upgrade, \"true\").\n" + 
		"						newGraphDatabase();\n" + 
		"\n" + 
		"					try (Transaction tx = db.beginTx()) {\n" + 
		"						try {\n" + 
		"							onDatabaseStarted(tx, config());\n" + 
		"							tx.success();\n" + 
		"							future.complete();\n" + 
		"						} catch (Exception e) {\n" + 
		"							log.error(deploymentID() + \" exception onDatabaseStarted \" + e.getMessage(), e);\n" + 
		"							tx.failure();\n" + 
		"							future.fail(e);\n" + 
		"						}\n" + 
		"					}\n" + 
		"\n" + 
		"				} catch (Throwable throwable) {\n" + 
		"					log.error(\"executeBlocking exception : \" + throwable.getMessage(), throwable);\n" + 
		"					future.fail(throwable);\n" + 
		"				}\n" + 
		"\n" + 
		"			}, res -> {\n" + 
		"\n" + 
		"			if (res.failed()) {\n" + 
		"				log.error(\"failed to start ~name~ : \", res.cause());\n" + 
		"				startFuture.fail(res.cause());\n" + 
		"\n" + 
		"			} else {\n" + 
		"				log.info(\"started ~name~ successfully \");\n" + 
		"				vertx.eventBus().consumer(deploymentID(), this::handleInstanceMessage);\n" + 
		"\n" + 
		"				~incoming:{it|log.info(\"consumer \" + deploymentID() + \" handles '~it.address~'\");\n" + 
		"vertx.eventBus().consumer(deploymentID() + \".\" + ~it.name;format=\"toUpper\"~, new TransactionMessageHandler(\"~it.address~\", on~it.name;format=\"capitalize\"~()));};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"			startFuture.complete();\n" + 
		"		}\n" + 
		"	});\n" + 
		"	}\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public void stop(Future<Void> stopFuture) throws Exception {\n" + 
		"		if (db != null) {\n" + 
		"			log.info(\"shutting down db\");\n" + 
		"			db.shutdown();\n" + 
		"		}\n" + 
		"		super.stop(stopFuture);\n" + 
		"	}\n" + 
		"\n" + 
		"	protected interface TransactionalMessageHandler {\n" + 
		"		void handle(Transaction tx, Message<JsonObject> message) throws Exception;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected final class TransactionMessageHandler implements Handler<Message<JsonObject~gt()~> {\n" + 
		"\n" + 
		"		private final String messageName;\n" + 
		"		private final TransactionalMessageHandler handler;\n" + 
		"\n" + 
		"		TransactionMessageHandler(String messageName, TransactionalMessageHandler handler) {\n" + 
		"			this.messageName = messageName;\n" + 
		"			this.handler = handler;\n" + 
		"		}\n" + 
		"\n" + 
		"		@Override\n" + 
		"		public void handle(Message<JsonObject> message) {\n" + 
		"			log.info(deploymentID() + \" on \" + messageName + \" \" + message.body().encode());\n" + 
		"\n" + 
		"			try (Transaction tx = db.beginTx()) {\n" + 
		"				try {\n" + 
		"					handler.handle(tx, message);\n" + 
		"				tx.success();\n" + 
		"			} catch (Exception e) {\n" + 
		"				log.error(deploymentID() + \" exception on \" + messageName + \" \" + message.body().encode() + \" \" + e.getMessage(), e);\n" + 
		"				tx.failure();\n" + 
		"				message.reply(newException(e));\n" + 
		"			}\n" + 
		"		}\n" + 
		"	}\n" + 
		"}\n" + 
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
		"	protected void onDatabaseStarted(Transaction tx, JsonObject config) throws Exception {\n" + 
		"	}\n" + 
		"\n" + 
		"	private enum ResponseStatus {\n" + 
		"		SUCCESS,\n" + 
		"		FAIL\n" + 
		"	}\n" + 
		"\n" + 
		"	private enum PayloadType {\n" + 
		"		STRING,\n" + 
		"		JSONOBJECT,\n" + 
		"		JSONARRAY,\n" + 
		"		EXCEPTION\n" + 
		"	}\n" + 
		"\n" + 
		"	protected static JsonObject newSuccess(String payload) {\n" + 
		"		final JsonObject response = new JsonObject().\n" + 
		"			put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"			put(\"payloadType\", PayloadType.STRING).\n" + 
		"			put(\"payload\", payload);\n" + 
		"		log.info(response.encode());\n" + 
		"		return response;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected static JsonObject newSuccess(JsonObject payload) {\n" + 
		"		final JsonObject response = new JsonObject().\n" + 
		"			put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"			put(\"payloadType\", PayloadType.JSONOBJECT).\n" + 
		"			put(\"payload\", payload);\n" + 
		"		log.info(response.encode());\n" + 
		"		return response;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected static JsonObject newSuccess(JsonArray payload) {\n" + 
		"		final JsonObject response =  new JsonObject().\n" + 
		"			put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"			put(\"payloadType\", PayloadType.JSONARRAY).\n" + 
		"			put(\"payload\", payload);\n" + 
		"		log.info(response.encode());\n" + 
		"		return response;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected static JsonObject newFail(String payload) {\n" + 
		"		final JsonObject response =  new JsonObject().\n" + 
		"			put(\"status\", ResponseStatus.FAIL).\n" + 
		"			put(\"payloadType\", PayloadType.STRING).\n" + 
		"			put(\"payload\", payload);\n" + 
		"		log.info(response.encode());\n" + 
		"		return response;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected static JsonObject newFail(JsonArray payload) {\n" + 
		"		final JsonObject response =  new JsonObject().\n" + 
		"			put(\"status\", ResponseStatus.FAIL).\n" + 
		"			put(\"payloadType\", PayloadType.JSONARRAY).\n" + 
		"			put(\"payload\", payload);\n" + 
		"		log.info(response.encode());\n" + 
		"		return response;\n" + 
		"	}\n" + 
		"\n" + 
		"	protected static JsonObject newException(Throwable e) {\n" + 
		"\n" + 
		"		final JsonArray stacktrace = new JsonArray();\n" + 
		"		for (StackTraceElement stackTraceElement : e.getStackTrace())\n" + 
		"			stacktrace.add(new JsonObject().\n" + 
		"				put(\"declaringClass\", stackTraceElement.getClassName()).\n" + 
		"				put(\"methodName\", stackTraceElement.getMethodName()).\n" + 
		"				put(\"fileName\", stackTraceElement.getFileName()).\n" + 
		"				put(\"lineNumber\", stackTraceElement.getLineNumber()));\n" + 
		"\n" + 
		"		final JsonObject response =  new JsonObject().\n" + 
		"				put(\"status\", ResponseStatus.FAIL).\n" + 
		"				put(\"payloadType\", PayloadType.EXCEPTION).\n" + 
		"				put(\"payload\", new JsonObject().\n" + 
		"					put(\"message\", e.getMessage() == null ? \"null\" : e.getMessage()).\n" + 
		"					put(\"stackTrace\", stacktrace));\n" + 
		"		log.info(response.encode());\n" + 
		"		return response;\n" + 
		"	}\n" + 
		"\n" + 
		"	private static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {\n" + 
		"\n" + 
		"	// if already related, merge properties:\n" + 
		"	for (Object o : outgoing(source, relationshipType)) {\n" + 
		"		final Relationship relationship = (Relationship) o;\n" + 
		"		if (target.equals(other(source, relationship))) {\n" + 
		"			for (int i = 0; i < properties.length; i += 2)\n" + 
		"			relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"			return relationship;\n" + 
		"		}\n" + 
		"	}\n" + 
		"\n" + 
		"	final Relationship relationship = source.createRelationshipTo(target, relationshipType);\n" + 
		"	for (int i = 0; i < properties.length; i += 2)\n" + 
		"		relationship.setProperty(properties[i].toString(), properties[i + 1]);\n" + 
		"\n" + 
		"	return relationship;\n" + 
		"}\n" + 
		"\n" + 
		"	protected String getUuid(Message<JsonObject> message) {\n" + 
		"		return message.body().getString(\"uuid\");\n" + 
		"	}\n" + 
		"	protected static void mapString(Message<JsonObject> message, Node node, String name) {\n" + 
		"	if (message.body().getString(name) != null) node.setProperty(name, message.body().getString(name));\n" + 
		"}\n" + 
		"\n" + 
		"	protected static void mapInteger(Message<JsonObject> message, Node node, String name) {\n" + 
		"	if (message.body().getInteger(name) != null) node.setProperty(name, message.body().getInteger(name));\n" + 
		"}\n" + 
		"\n" + 
		"	protected static void mapLong(Message<JsonObject> message, Node node, String name) {\n" + 
		"	if (message.body().getLong(name) != null) node.setProperty(name, message.body().getLong(name));\n" + 
		"}\n" + 
		"\n" + 
		"	protected static void mapBoolean(Message<JsonObject> message, Node node, String name) {\n" + 
		"	if (message.body().getBoolean(name) != null) node.setProperty(name, message.body().getBoolean(name));\n" + 
		"}\n" + 
		"\n" + 
		"	protected static void map(String name, JsonObject jsonObject, Node node) {\n" + 
		"	if (node.hasProperty(name))\n" + 
		"		jsonObject.put(name, node.getProperty(name));\n" + 
		"}\n" + 
		"\n" + 
		"	protected static void map(JsonArray properties, String name, JsonObject jsonObject, Node node) {\n" + 
		"	if ((properties == null || properties.contains(name)) && node.hasProperty(name))\n" + 
		"		jsonObject.put(name, node.getProperty(name));\n" + 
		"}\n" + 
		"\n" + 
		"	~mappings:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"	private static Node newNode(GraphDatabaseService db, String label) {\n" + 
		"	final Node node = db.createNode(Label.label(label));\n" + 
		"	node.setProperty(\"_deleted\", Boolean.FALSE);\n" + 
		"	node.setProperty(\"_uuid\", UUID.randomUUID().toString());\n" + 
		"	return node;\n" + 
		"}\n" + 
		"\n" + 
		"	private static String deleteNode(Node node) {\n" + 
		"	final String uuid = node.getProperty(\"_uuid\").toString();\n" + 
		"	node.setProperty(\"_deleted\", Boolean.TRUE);\n" + 
		"	return uuid;\n" + 
		"}\n" + 
		"\n" + 
		"private static boolean isDeleted(Node node) {\n" + 
		"	return !((Boolean) node.getProperty(\"_deleted\"));\n" + 
		"}\n" + 
		"		private static Iterable<?> outgoing(Node node, RelationshipType type) {\n" + 
		"	return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);\n" + 
		"}\n" + 
		"\n" + 
		"	private static Node other(Node node, Relationship relationship) {\n" + 
		"	return relationship == null ? null : relationship.getOtherNode(node);\n" + 
		"}\n" + 
		"\n" + 
		"~if(implementation)~\n" + 
		"\n" + 
		"	// to run: java -Dlog4j.configuration=file:./log4j.properties~if(hazelcastConfig)~ -Dvertx.hazelcast.config=~hazelcastConfig~~endif~ -jar [name]-fat.jar\n" + 
		"public static void main(String[] args) {\n" + 
		"		VertxUtil.deploy(io.vertx.core.Vertx.vertx(), ~implementation~.class, new io.vertx.core.DeploymentOptions(), log, new VertxUtil.SuccessHandler<String>() {\n" + 
		"		@Override\n" + 
		"		public void onSuccess(String result) {\n" + 
		"			log.info(\"deploy ~name~ \" + result);\n" + 
		"		}\n" + 
		"\n" + 
		"		@Override\n" + 
		"		public void onFail(Throwable t) {\n" + 
		"			log.error(\"deploy ~name~ failed \" + t.getMessage(), t);\n" + 
		"		}\n" + 
		"	});\n" + 
		"}\n" + 
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
			.append("verticle_update_entity(label,properties,domain) ::= <<final Node node = ~domain~.find~label~By_UUID(db, getUuid(message));\n" + 
		"if (node == null) {\n" + 
		"	message.reply(newFail(\"~label~ \" + getUuid(message) + \" not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"~properties:{it|map~if(it.isEnum)~String~else~~it.type~~endif~(message, node, \"~it.name~\");};separator=\"\\n\"~\n" + 
		"\n" + 
		"message.reply(newSuccess(map~label~toJson(node)));>>\n")
			.append("verticle_delete_entity(label) ::= <<final Node node = db.findNode(Label.label(\"~label~\"), \"_uuid\", getUuid(message));\n" + 
		"if (node == null) {\n" + 
		"	message.reply(newFail(\"~label~ \" + getUuid(message) + \" not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"final String uuid = deleteNode(node);\n" + 
		"\n" + 
		"message.reply(newSuccess(uuid));>>\n")
			.append("verticle_get_entity(label,domain) ::= <<final Node node = ~domain~.find~label~By_UUID(db, getUuid(message));\n" + 
		"if (node == null) {\n" + 
		"   message.reply(newFail(\"~label~ \" + getUuid(message) + \" not found\"));\n" + 
		"   return;\n" + 
		"}\n" + 
		"\n" + 
		"message.reply(newSuccess(map~label~toJson(node)));>>\n")
			.append("verticle_get_all_entities(label,properties,domain) ::= <<final JsonArray properties = message.body().getJsonArray(\"properties\");\n" + 
		"final JsonArray result = new JsonArray();\n" + 
		"~domain~.findAll~label~(db, node -> {\n" + 
		"	final JsonObject jsonObject = new JsonObject();\n" + 
		"	if (properties == null || properties.contains(\"uuid\")) jsonObject.put(\"uuid\", node.getProperty(\"_uuid\"));\n" + 
		"	~properties:{it|map(properties, \"~it.name~\", jsonObject, node);};separator=\"\\n\"~\n" + 
		"	result.add(jsonObject);\n" + 
		"	return false;\n" + 
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
			.append("verticle_map_entity(properties,label) ::= <<protected JsonObject map~label~toJson(Node node) {\n" + 
		"	final JsonObject result = new JsonObject();\n" + 
		"	result.put(\"uuid\", node.getProperty(\"_uuid\"));\n" + 
		"	~properties:{it|map(\"~it.name~\", result, node);};separator=\"\\n\"~\n" + 
		"	return result;\n" + 
		"}>>\n")
			.append("verticle_get_single(relation,direction,domain,dstName,srcName,dst) ::= <<final Node paramNode = ~domain~.find~srcName~By_UUID(db, getUuid(message));\n" + 
		"if (paramNode == null) {\n" + 
		"	message.reply(newFail(\"~srcName~ \" + getUuid(message)+ \" not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"final Relationship relation = paramNode.getSingleRelationship(RelationshipType.withName(\"~relation~\"), Direction.~direction~);\n" + 
		"final Node node = relation == null ? null : other(paramNode, relation);\n" + 
		"if (node == null) {\n" + 
		"	message.reply(newFail(\"~dstName~ not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"message.reply(newSuccess(map~dst~toJson(node)));>>\n")
			.append("verticle_get_many(relation,domain,dstName,srcName) ::= <<final Node paramNode = ~domain~.find~dstName~By_UUID(db,  getUuid(message));\n" + 
		"\n" + 
		"if (paramNode == null) {\n" + 
		"	message.reply(newFail(\"~dstName~ \" + getUuid(message) + \" not found\"));\n" + 
		"	return;\n" + 
		"}\n" + 
		"\n" + 
		"final JsonArray result = new JsonArray();\n" + 
		"~domain~.get_~srcName~_~relation;format=\"toUpper\"~_for_~dstName;format=\"capitalize\"~(paramNode, (relationship, other) -> {\n" + 
		"	final JsonObject relation = new JsonObject();\n" + 
		"	final Map<String, Object> allProperties = relationship.getAllProperties();\n" + 
		"	for (Map.Entry<String, Object> entry : allProperties.entrySet())\n" + 
		"		relation.put(entry.getKey(), entry.getValue().toString());\n" + 
		"	relation.put(\"other\", map~srcName~toJson(relationship.getOtherNode(paramNode)));\n" + 
		"	result.add(relation);\n" + 
		"	return false;\n" + 
		"});\n" + 
		"\n" + 
		"message.reply(newSuccess(result));>>\n")
			.append("DomainVerticleFacade(relations,entities,packageName,domain,functions,interface) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.nextgen.generators.~domain;format=\"lowFirst\"~.~domain;format=\"capitalize\"~;\n" + 
		"import com.nextgen.generators.~domain;format=\"lowFirst\"~.~domain;format=\"capitalize\"~Verticle;\n" + 
		"import com.nextgen.util.ResponseUtil;\n" + 
		"import io.vertx.core.Vertx;\n" + 
		"import io.vertx.core.http.HttpClient;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"import java.util.UUID;\n" + 
		"\n" + 
		"public class ~domain;format=\"capitalize\"~VerticleFacade implements ~interface~ {\n" + 
		"\n" + 
		"	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~domain;format=\"capitalize\"~VerticleFacade.class);\n" + 
		"\n" + 
		"	private final String uuid = UUID.randomUUID().toString();\n" + 
		"	private final UUID deploymentID;\n" + 
		"	protected final Vertx vertx;\n" + 
		"	protected final JsonObject hostParameters;\n" + 
		"\n" + 
		"	public ~domain;format=\"capitalize\"~VerticleFacade(UUID deploymentID, Vertx vertx, JsonObject hostParameters) {\n" + 
		"		this.deploymentID = deploymentID;\n" + 
		"		this.vertx = vertx;\n" + 
		"		this.hostParameters = hostParameters;\n" + 
		"	}\n" + 
		"\n" + 
		"~entities:{it|\n" + 
		"	~it.methods~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~functions:{it|\n" + 
		"	~it.methods~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~relations:{it|\n" + 
		"	void ~it.relation;format=\"lowFirst\"~(UUID ~it.src~, UUID ~it.dst~, ResponseUtil.EventbusHandler handler) {\n" + 
		"		send(~domain;format=\"capitalize\"~Verticle.~it.relation;format=\"toUpper\"~, new JsonObject().put(\"src\", ~it.src~.toString()).put(\"dst\", ~it.dst~.toString()), handler);\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	void ~it.directionOne;format=\"lowFirst\"~(UUID uuid, ResponseUtil.EventbusHandler handler) {\n" + 
		"		send(~domain;format=\"capitalize\"~Verticle.~it.directionOne;format=\"toUpper\"~, new JsonObject().put(\"uuid\", uuid.toString()), handler);\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	void ~it.directionTwo;format=\"lowFirst\"~(UUID uuid, ResponseUtil.EventbusHandler handler) {\n" + 
		"		send(~domain;format=\"capitalize\"~Verticle.~it.directionTwo;format=\"toUpper\"~, new JsonObject().put(\"uuid\", uuid.toString()), handler);\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected void send(String address, JsonObject parameters, ResponseUtil.EventbusHandler handler) {\n" + 
		"\n" + 
		"		final JsonObject buffer = new JsonObject().\n" + 
		"				put(\"type\", \"send\").\n" + 
		"				put(\"address\", (deploymentID==null ? \"\" : (deploymentID + \".\")) + address).\n" + 
		"				put(\"replyAddress\", uuid).\n" + 
		"				put(\"body\", parameters);\n" + 
		"\n" + 
		"		log.info(\"sending \" + buffer.encode() + \" to \" + hostParameters.getString(\"host\") + \":\" + hostParameters.getInteger(\"port\"));\n" + 
		"\n" + 
		"		final HttpClient client = vertx.createHttpClient();\n" + 
		"		client.websocket(hostParameters.getInteger(\"port\"), hostParameters.getString(\"host\"), hostParameters.getString(\"eventbus\"), ws -> {\n" + 
		"\n" + 
		"			ws.handler(handler);\n" + 
		"\n" + 
		"			ws.writeFrame(io.vertx.core.http.WebSocketFrame.textFrame(buffer.encode(), true));\n" + 
		"\n" + 
		"			// Send pings periodically to avoid the websocket connection being closed\n" + 
		"//		 vertx.setPeriodic(5000, id -> {\n" + 
		"//			JsonObject msg = new JsonObject().put(\"type\", \"ping\");\n" + 
		"//			ws.writeFrame(io.vertx.core.http.WebSocketFrame.textFrame(msg.encode(), true));\n" + 
		"//		 });\n" + 
		"		});\n" + 
		"	}\n" + 
		"}>>\n")
			.append("ExportDatabase(name,packageName,relations,nodes,rootLabel,rootUUID) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.neo4j.graphdb.*;\n" + 
		"import org.neo4j.graphdb.factory.GraphDatabaseSettings;\n" + 
		"\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"    public static void main(String[] args) {\n" + 
		"        new ~name~(args[0]);\n" + 
		"    }\n" + 
		"\n" + 
		"    private final GraphDatabaseService db;\n" + 
		"\n" + 
		"    public ~name~(String dir) {\n" + 
		"        db = newDatabase(dir);\n" + 
		"    }\n" + 
		"\n" + 
		"    public void merge() {\n" + 
		"        try (Transaction tx = db.beginTx()) {\n" + 
		"            try {\n" + 
		"                insertNodes();\n" + 
		"                insertRelations();\n" + 
		"                tx.success();\n" + 
		"            } catch (Exception e) {\n" + 
		"                tx.failure();\n" + 
		"            }\n" + 
		"        }\n" + 
		"    }\n" + 
		"\n" + 
		"    public GraphDatabaseService getDb() {\n" + 
		"        return db;\n" + 
		"    }\n" + 
		"\n" + 
		"    public void shutdown() {\n" + 
		"        db.shutdown();\n" + 
		"    }\n" + 
		"\n" + 
		"    private void insertNodes() {\n" + 
		"~nodes:{it|\n" + 
		"		~it~};separator=\"\\n\"~\n" + 
		"    }\n" + 
		"\n" + 
		"    private void insertRelations() {\n" + 
		"	~relations:{it|~it~};separator=\"\\n\"~\n" + 
		"    }\n" + 
		"\n" + 
		"    public Node getRoot() {\n" + 
		"		return getNode(\"~rootLabel~\", \"~rootUUID~\");\n" + 
		"    	}\n" + 
		"\n" + 
		"    public Node getNode(String label, String uuid) {\n" + 
		"        return db.findNode(Label.label(label), \"_uuid\", uuid);\n" + 
		"    }\n" + 
		"\n" + 
		"    public Node mergeNode(String[] labels, String uuid, Tuple<String, Object>... properties) {\n" + 
		"\n" + 
		"        for (String label : labels) {\n" + 
		"            final Node existing = getNode(label, uuid);\n" + 
		"            if (existing != null) {\n" + 
		"                for (String lbl : labels)\n" + 
		"                    existing.addLabel(Label.label(lbl));\n" + 
		"                setProperties(existing, properties);\n" + 
		"                return existing;\n" + 
		"            }\n" + 
		"        }\n" + 
		"\n" + 
		"        final Node node = db.createNode();\n" + 
		"        for (String label : labels)\n" + 
		"            node.addLabel(Label.label(label));\n" + 
		"        node.setProperty(\"_uuid\", uuid);\n" + 
		"        setProperties(node, properties);\n" + 
		"        return node;\n" + 
		"    }\n" + 
		"\n" + 
		"    public Relationship mergeRelation(String type, Node src, Node dst, Tuple<String, Object>... properties) {\n" + 
		"\n" + 
		"        for (Relationship relationship : src.getRelationships(RelationshipType.withName(type), Direction.OUTGOING)) {\n" + 
		"            if (dst.equals(relationship.getOtherNode(src))) {\n" + 
		"                setProperties(relationship, properties);\n" + 
		"                return relationship;\n" + 
		"            }\n" + 
		"        }\n" + 
		"\n" + 
		"        final Relationship relationship = src.createRelationshipTo(dst, RelationshipType.withName(type));\n" + 
		"        setProperties(relationship, properties);\n" + 
		"        return relationship;\n" + 
		"    }\n" + 
		"\n" + 
		"    public void setProperties(PropertyContainer propertyContainer, Tuple<String, Object>[] properties) {\n" + 
		"        for (Tuple<String, Object> property : properties)\n" + 
		"            propertyContainer.setProperty(property.getFirst(), property.getSecond());\n" + 
		"    }\n" + 
		"\n" + 
		"    public Tuple<String, Object> newProperty(String key, Object value) {\n" + 
		"        return new Tuple<>(key, value);\n" + 
		"    }\n" + 
		"\n" + 
		"    private static GraphDatabaseService newDatabase(String path) {\n" + 
		"        return new org.neo4j.graphdb.factory.GraphDatabaseFactory().\n" + 
		"                newEmbeddedDatabaseBuilder(new java.io.File(path)).\n" + 
		"                setConfig(GraphDatabaseSettings.allow_upgrade, \"true\").\n" + 
		"                newGraphDatabase();\n" + 
		"    }\n" + 
		"\n" + 
		"    class Tuple<F, S> {\n" + 
		"\n" + 
		"        private F first;\n" + 
		"        private S second;\n" + 
		"\n" + 
		"        Tuple(F first, S second) {\n" + 
		"            this.first = first;\n" + 
		"            this.second = second;\n" + 
		"        }\n" + 
		"\n" + 
		"        public F getFirst() {\n" + 
		"            return first;\n" + 
		"        }\n" + 
		"\n" + 
		"        public S getSecond() {\n" + 
		"            return second;\n" + 
		"        }\n" + 
		"\n" + 
		"        public void setFirst(F first) {\n" + 
		"            this.first = first;\n" + 
		"        }\n" + 
		"\n" + 
		"        public void setSecond(S second) {\n" + 
		"            this.second = second;\n" + 
		"        }\n" + 
		"\n" + 
		"        @Override\n" + 
		"        public boolean equals(Object o) {\n" + 
		"            if (this == o) return true;\n" + 
		"            if (o == null || getClass() != o.getClass()) return false;\n" + 
		"\n" + 
		"            Tuple<?, ?> tuple = (Tuple<?, ?>) o;\n" + 
		"\n" + 
		"            return first.equals(tuple.first) && second.equals(tuple.second);\n" + 
		"        }\n" + 
		"\n" + 
		"        @Override\n" + 
		"        public int hashCode() {\n" + 
		"            int result = first.hashCode();\n" + 
		"            result = 31 * result + second.hashCode();\n" + 
		"            return result;\n" + 
		"        }\n" + 
		"\n" + 
		"        @Override\n" + 
		"        public String toString() {\n" + 
		"            return \"[\" + first + \",\" + second + \"]\";\n" + 
		"        }\n" + 
		"    }\n" + 
		"}>>\n")
			.append("DomainNode(incoming,outgoing,labelName,label) ::= <<public ~label~Node new~label~Node(JsonObject content) {\n" + 
		"	return new ~label~Node(content);\n" + 
		"}\n" + 
		"\n" + 
		"class ~label~Node extends NodeCanvas.JsonPNode {\n" + 
		"\n" + 
		"	~label~Node(JsonObject content) {\n" + 
		"		super(content.getString(\"uuid\"), content, content.getString(\"~labelName~\"));	\n" + 
		"	}\n" + 
		"\n" + 
		"	@Override\n" + 
		"	protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas) {\n" + 
		"\n" + 
		"~outgoing:{it|\n" + 
		"		~it.action~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~incoming:{it|\n" + 
		"		~it.action~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"		super.onRightClick(event, pop, canvas);\n" + 
		"	}\n" + 
		"\n" + 
		"	@Override\n" + 
		"	protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {\n" + 
		"\n" + 
		"		switch (event.getKeyCode()) {\n" + 
		"~if(outgoing)~\n" + 
		"			case KeyEvent.VK_E:\n" + 
		"				~outgoing:{it|~it.keyPressed~};separator=\"\\n\"~\n" + 
		"				return;\n" + 
		"~endif~\n" + 
		"~if(incoming)~\n" + 
		"			case KeyEvent.VK_I:\n" + 
		"				~incoming:{it|~it.keyPressed~};separator=\"\\n\"~\n" + 
		"				return;\n" + 
		"~endif~		\n" + 
		"		}	\n" + 
		"\n" + 
		"		super.onKeyPressed(event, canvas);\n" + 
		"	}\n" + 
		"\n" + 
		"~outgoing:{it|\n" + 
		"	~it.method~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~incoming:{it|\n" + 
		"	~it.method~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"}>>\n")
			.append("facade_entityMethods(domain,label,properties) ::= <<public void new~label~(~if(properties)~~properties:{it|~it.type~ ~it.name;format=\"lowFirst\"~};separator=\", \"~, ~endif~ResponseUtil.JsonObjectEventHandler handler) {	\n" + 
		"	final JsonObject parameters = new JsonObject();\n" + 
		"	~properties:{it|parameters.put(\"~it.name~\", ~it.name;format=\"lowFirst\"~);};separator=\"\\n\"~\n" + 
		"	send(~domain;format=\"capitalize\"~Verticle.NEW~label;format=\"toUpper\"~, parameters, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void update~label~(UUID uuid, ~if(properties)~~properties:{it|~it.type~ ~it.name;format=\"lowFirst\"~};separator=\", \"~, ~endif~ResponseUtil.JsonObjectEventHandler handler) {	\n" + 
		"	final JsonObject parameters = new JsonObject();\n" + 
		"	parameters.put(\"uuid\", uuid.toString());\n" + 
		"	~properties:{it|parameters.put(\"~it.name~\", ~it.name;format=\"lowFirst\"~);};separator=\"\\n\"~\n" + 
		"	send(~domain;format=\"capitalize\"~Verticle.UPDATE~label;format=\"toUpper\"~, parameters, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void delete~label~(UUID uuid, ResponseUtil.StringEventHandler handler) {	\n" + 
		"	final JsonObject parameters = new JsonObject();\n" + 
		"	parameters.put(\"uuid\", uuid.toString());\n" + 
		"	send(~domain;format=\"capitalize\"~Verticle.DELETE~label;format=\"toUpper\"~, parameters, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void get~label~(UUID uuid, ResponseUtil.JsonObjectEventHandler handler) {	\n" + 
		"	final JsonObject parameters = new JsonObject();\n" + 
		"	parameters.put(\"uuid\", uuid.toString());\n" + 
		"	send(~domain;format=\"capitalize\"~Verticle.GET~label;format=\"toUpper\"~, parameters, handler);\n" + 
		"}\n" + 
		"\n" + 
		"public void getAll~label~(ResponseUtil.JsonArrayEventHandler handler) {	\n" + 
		"	final JsonObject parameters = new JsonObject();\n" + 
		"	send(~domain;format=\"capitalize\"~Verticle.GETALL~label;format=\"toUpper\"~, parameters, handler);\n" + 
		"}>>\n")
			.append("DomainFacadeRelation(dst,name,src) ::= <<class ~name~Relation extends NodeCanvas.Relation {\n" + 
		"\n" + 
		"        public ~name~Relation(JsonObject content, ~src~Node src, ~dst~Node dst) {\n" + 
		"            super(UUID.randomUUID(), content, \"~name~\", src, dst, Color.DARK_GRAY, Color.ORANGE, Color.RED);\n" + 
		"        }\n" + 
		"}>>\n")
			.append("exportNode(properties,uuid,labels) ::= <<mergeNode(new String[]{~labels:{it|\"~it~\"};separator=\",\"~}, \"~uuid~\"~if(properties)~, ~properties:{it|newProperty(\"~it.name~\", \"~it.value~\")};separator=\", \"~~endif~);>>\n")
			.append("exportRelation(dstLabel,dstUuid,srcLabel,srcUuid,type,properties) ::= <<mergeRelation(\"~type~\", getNode(\"~srcLabel~\", \"~srcUuid~\"), getNode(\"~dstLabel~\", \"~dstUuid~\")~if(properties)~, ~properties:{it|newProperty(\"~it.name~\", \"~it.value~\")};separator=\", \"~~endif~);>>\n")
			.append("domainPNode_getAction(dst,relation,src) ::= <<pop.add(new SwingUtil.SwingAction(\"Get ~src~ ~relation~\") {\n" + 
		"	@Override\n" + 
		"	protected void onActionPerformed(ActionEvent e) {\n" + 
		"		get_~src~_~relation~_FOR_~dst~(canvas);\n" + 
		"	}\n" + 
		"});>>\n")
			.append("DomainPNodes(packageName,domain,entities,relations,interface) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.nextgen.swing.NodeCanvas;\n" + 
		"import com.nextgen.util.JsonUtil;\n" + 
		"import com.nextgen.util.ResponseUtil;\n" + 
		"import com.nextgen.util.SwingUtil;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import org.piccolo2d.event.PInputEvent;\n" + 
		"\n" + 
		"import javax.swing.*;\n" + 
		"import java.awt.*;\n" + 
		"import java.awt.event.ActionEvent;\n" + 
		"import java.awt.event.KeyEvent;\n" + 
		"import java.util.Collections;\n" + 
		"import java.util.LinkedHashMap;\n" + 
		"import java.util.Map;\n" + 
		"import java.util.UUID;\n" + 
		"\n" + 
		"public class ~domain~PNodes implements ~interface~ {\n" + 
		"	\n" + 
		"	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~domain~PNodes.class);\n" + 
		"\n" + 
		"	protected final ~domain~VerticleFacade facade;\n" + 
		"\n" + 
		"	public ~domain~PNodes(~domain~VerticleFacade facade) {\n" + 
		"		this.facade = facade;\n" + 
		"	}\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public NodeCanvas.BasePNode newVerticleNode(UUID uuid, JsonObject content) {\n" + 
		"		return new ~domain~VerticlePNode(uuid, content);\n" + 
		"	}\n" + 
		"\n" + 
		"	class ~domain~VerticlePNode extends NodeCanvas.JsonPNode {\n" + 
		"		~domain~VerticlePNode(UUID uuid, JsonObject content) {\n" + 
		"			super(uuid, content, \"~domain~\");\n" + 
		"		}\n" + 
		"	}\n" + 
		"\n" + 
		"~entities:{it|\n" + 
		"	~it.implementation~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"~relations:{it|\n" + 
		"	~it.implementation~\n" + 
		"};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("facade_functionMethod(name,domain,properties) ::= <<public void ~name;format=\"lowFirst\"~(~if(properties)~~properties:{it|~it.type~ ~it.name;format=\"lowFirst\"~};separator=\", \"~, ~endif~ResponseUtil.EventbusHandler handler) {	\n" + 
		"	final JsonObject parameters = new JsonObject();\n" + 
		"	~properties:{it|parameters.put(\"~it.name~\", ~it.name;format=\"lowFirst\"~);};separator=\"\\n\"~\n" + 
		"	send(~domain;format=\"capitalize\"~Verticle.~name;format=\"toUpper\"~, parameters, handler);\n" + 
		"}>>\n")
			.append("domainPNode_getManyMethod(relation,domain,dst,src,srcNode,incoming) ::= <<private void get_~src~_~relation;format=\"toUpper\"~_FOR_~dst~(NodeCanvas canvas) {\n" + 
		"	facade.get_~src~_~relation;format=\"toUpper\"~_FOR_~dst~(getUUID(), new ResponseUtil.EventbusHandler(log) {\n" + 
		"		@Override\n" + 
		"		protected void handleSuccess(JsonArray payload) {\n" + 
		"			final Map<NodeCanvas.BasePNode, NodeCanvas.Relation> map = new LinkedHashMap<>();\n" + 
		"			JsonUtil.streamJsonObject(payload).forEach(jsonObject -> {\n" + 
		"				final ~domain~PNodes.~srcNode~Node node = new~srcNode~Node(jsonObject.getJsonObject(\"other\").put(\"~dst~\", getThis().getUUID().toString()));\n" + 
		"				map.put(node, new ~relation;format=\"toUpper\"~Relation(jsonObject, ~if(incoming)~node, getThis()~else~getThis(), node~endif~));\n" + 
		"			});\n" + 
		"\n" + 
		"			canvas.addNodes(map.keySet(), new NodeCanvas.LayoutRelativeTo(getThis()));\n" + 
		"			canvas.addRelations(map.values());\n" + 
		"		}\n" + 
		"\n" + 
		"		@Override\n" + 
		"		protected void handleException(Throwable throwable) {\n" + 
		"			SwingUtil.showExceptionNoStack(canvas, throwable);\n" + 
		"		}\n" + 
		"	});\n" + 
		"}>>\n")
			.append("domainPNode_getKeyPressed(dst,relation,src) ::= <<get_~src~_~relation~_FOR_~dst~(canvas);>>\n")
			.append("domainPNode_getSingleMethod(srcNode,src,dst,relation,incoming,domain) ::= <<private void get_~src~_~relation;format=\"toUpper\"~_FOR_~dst~(NodeCanvas canvas) {\n" + 
		"	facade.get_~src~_~relation;format=\"toUpper\"~_FOR_~dst~(getUUID(), new ResponseUtil.JsonObjectEventHandler(log) {\n" + 
		"		@Override\n" + 
		"		protected void handle(JsonObject jsonObject) {\n" + 
		"			final ~domain~PNodes.~srcNode~Node node = new~srcNode~Node(jsonObject);\n" + 
		"			canvas.addNodes(Collections.singleton(node),new NodeCanvas.LayoutRelativeTo(getThis()));\n" + 
		"			canvas.addRelations(Collections.singleton(new ~relation;format=\"toUpper\"~Relation(jsonObject, ~if(incoming)~node, getThis()~else~getThis(), node~endif~)));\n" + 
		"		}\n" + 
		"	});\n" + 
		"}>>\n")
		.toString();
}