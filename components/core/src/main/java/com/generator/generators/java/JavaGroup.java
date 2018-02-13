package com.generator.generators.java;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'java.stg' file<br/>
 */
public final class JavaGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public JavaGroup() {
		this(new STGroupString(stg));
   }

   public JavaGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public JavaGroup(java.io.File templateFile) {
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

	public interface JavaGroupTemplate {

	}

   public BeanST newBean() {
      return new BeanST(stGroup);
   }

   public methodST newmethod() {
      return new methodST(stGroup);
   }

   public PojoST newPojo() {
      return new PojoST(stGroup);
   }

   public EnumST newEnum() {
      return new EnumST(stGroup);
   }

   public toStringST newtoString() {
      return new toStringST(stGroup);
   }

   public setST newset() {
      return new setST(stGroup);
   }

   public ClassST newClass() {
      return new ClassST(stGroup);
   }

   public CollectionAccessorST newCollectionAccessor() {
      return new CollectionAccessorST(stGroup);
   }

   public mapMethodsST newmapMethods() {
      return new mapMethodsST(stGroup);
   }

   public constructorST newconstructor() {
      return new constructorST(stGroup);
   }

   public setMethodsST newsetMethods() {
      return new setMethodsST(stGroup);
   }

   public listMethodsST newlistMethods() {
      return new listMethodsST(stGroup);
   }

   public getST newget() {
      return new getST(stGroup);
   }

   public eqhaST neweqha() {
      return new eqhaST(stGroup);
   }

   public arrayMethodsST newarrayMethods() {
      return new arrayMethodsST(stGroup);
   }

   public final class BeanST implements JavaGroupTemplate {

      private java.util.Set<Object> _eqha = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _lexical = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();
      private Object _scope;

      private final ST template;

      private BeanST(STGroup group) {
   		template = group.getInstanceOf("Bean");
   	}

      public BeanST addEqhaValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._eqha.add(value);
      	template.add("eqha", value);

         return this;
      }

      public java.util.Set<Object> getEqhaValues() {
      	return this._eqha;
      }

      public BeanST addLexicalValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._lexical.add(value);
      	template.add("lexical", value);

         return this;
      }

      public java.util.Set<Object> getLexicalValues() {
      	return this._lexical;
      }

      public BeanST setName(Object value) {
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

      public BeanST setPackage(Object value) {
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

      public BeanST addPropertiesValue(Object init_, Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._properties.add(map);

         template.addAggr("properties.{init, name, type}", map.get("init"), map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public BeanST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
      }

      public BeanST setScope(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._scope == null) {
            this._scope = value;
         	template.add("scope", value);
         }

      	return this;
      }

      public String getScope() {
      	return (String) this._scope;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class methodST implements JavaGroupTemplate {

      private java.util.Set<Object> _annotations = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _parameters = new java.util.LinkedHashSet<>();
      private Object _returnValue;
      private Object _scope;
      private java.util.Set<Object> _statements = new java.util.LinkedHashSet<>();

      private final ST template;

      private methodST(STGroup group) {
   		template = group.getInstanceOf("method");
   	}

      public methodST addAnnotationsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._annotations.add(value);
      	template.add("annotations", value);

         return this;
      }

      public java.util.Set<Object> getAnnotationsValues() {
      	return this._annotations;
      }

      public methodST setName(Object value) {
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

      public methodST addParametersValue(Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._parameters.add(map);

         template.addAggr("parameters.{name, type}", map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getParameters() {
      	return this._parameters;
      }

      public methodST setReturnValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._returnValue == null) {
            this._returnValue = value;
         	template.add("returnValue", value);
         }

      	return this;
      }

      public String getReturnValue() {
      	return (String) this._returnValue;
      }

      public methodST setScope(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._scope == null) {
            this._scope = value;
         	template.add("scope", value);
         }

      	return this;
      }

      public String getScope() {
      	return (String) this._scope;
      }

      public methodST addStatementsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._statements.add(value);
      	template.add("statements", value);

         return this;
      }

      public java.util.Set<Object> getStatementsValues() {
      	return this._statements;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class PojoST implements JavaGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _classProperties = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _eqha = new java.util.LinkedHashSet<>();
      private Object _extends;
      private java.util.Set<Object> _implement = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _lexical = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();
      private Object _neoNode;
      private Object _json;

      private final ST template;

      private PojoST(STGroup group) {
   		template = group.getInstanceOf("Pojo");
   	}

      public PojoST addClassPropertiesValue(Object type_, Object init_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._classProperties.add(map);

         template.addAggr("classProperties.{type, init, name}", map.get("type"), map.get("init"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getClassProperties() {
      	return this._classProperties;
      }

      public PojoST addEqhaValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._eqha.add(value);
      	template.add("eqha", value);

         return this;
      }

      public java.util.Set<Object> getEqhaValues() {
      	return this._eqha;
      }

      public PojoST setExtends(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._extends == null) {
            this._extends = value;
         	template.add("extends", value);
         }

      	return this;
      }

      public String getExtends() {
      	return (String) this._extends;
      }

      public PojoST addImplementValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._implement.add(value);
      	template.add("implement", value);

         return this;
      }

      public java.util.Set<Object> getImplementValues() {
      	return this._implement;
      }

      public PojoST addLexicalValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._lexical.add(value);
      	template.add("lexical", value);

         return this;
      }

      public java.util.Set<Object> getLexicalValues() {
      	return this._lexical;
      }

      public PojoST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
      }

      public PojoST setName(Object value) {
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

      public PojoST setPackage(Object value) {
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

      public PojoST addPropertiesValue(Object init_, Object type_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._properties.add(map);

         template.addAggr("properties.{init, type, name}", map.get("init"), map.get("type"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getProperties() {
      	return this._properties;
      }

      public PojoST setNeoNode(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._neoNode == null) {
            this._neoNode = value;
         	template.add("neoNode", value);
         }

      	return this;
      }

      public String getNeoNode() {
      	return (String) this._neoNode;
      }

      public PojoST setJson(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._json == null) {
            this._json = value;
         	template.add("json", value);
         }

      	return this;
      }

      public String getJson() {
      	return (String) this._json;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class EnumST implements JavaGroupTemplate {

      private Object _name;
      private Object _package;
      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private EnumST(STGroup group) {
   		template = group.getInstanceOf("Enum");
   	}

      public EnumST setName(Object value) {
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

      public EnumST setPackage(Object value) {
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

      public EnumST addValuesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._values.add(value);
      	template.add("values", value);

         return this;
      }

      public java.util.Set<Object> getValuesValues() {
      	return this._values;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class toStringST implements JavaGroupTemplate {

      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private toStringST(STGroup group) {
   		template = group.getInstanceOf("toString");
   	}

      public toStringST addValuesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._values.add(value);
      	template.add("values", value);

         return this;
      }

      public java.util.Set<Object> getValuesValues() {
      	return this._values;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class setST implements JavaGroupTemplate {

      private Object _name;
      private Object _type;

      private final ST template;

      private setST(STGroup group) {
   		template = group.getInstanceOf("set");
   	}

      public setST setName(Object value) {
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

      public setST setType(Object value) {
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

   public final class ClassST implements JavaGroupTemplate {

      private Object _name;
      private Object _package;
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _innerClasses = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _fields = new java.util.LinkedHashSet<>();
      private Object _scope;
      private Object _isStatic;
      private Object _isFinal;
      private Object _isAbstract;

      private final ST template;

      private ClassST(STGroup group) {
   		template = group.getInstanceOf("Class");
   	}

      public ClassST setName(Object value) {
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

      public ClassST setPackage(Object value) {
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

      public ClassST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
      }

      public ClassST addInnerClassesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._innerClasses.add(value);
      	template.add("innerClasses", value);

         return this;
      }

      public java.util.Set<Object> getInnerClassesValues() {
      	return this._innerClasses;
      }

      public ClassST addFieldsValue(Object init_, Object name_, Object type_, Object scope_, Object isFinal_, Object isArray_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("scope", (scope_ == null || scope_.toString().length() == 0) ? null : scope_);
      	map.put("isFinal", (isFinal_ == null || isFinal_.toString().length() == 0) ? null : isFinal_);
      	map.put("isArray", (isArray_ == null || isArray_.toString().length() == 0) ? null : isArray_);
      	this._fields.add(map);

         template.addAggr("fields.{init, name, type, scope, isFinal, isArray}", map.get("init"), map.get("name"), map.get("type"), map.get("scope"), map.get("isFinal"), map.get("isArray"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getFields() {
      	return this._fields;
      }

      public ClassST setScope(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._scope == null) {
            this._scope = value;
         	template.add("scope", value);
         }

      	return this;
      }

      public String getScope() {
      	return (String) this._scope;
      }

      public ClassST setIsStatic(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._isStatic == null) {
            this._isStatic = value;
         	template.add("isStatic", value);
         }

      	return this;
      }

      public String getIsStatic() {
      	return (String) this._isStatic;
      }

      public ClassST setIsFinal(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._isFinal == null) {
            this._isFinal = value;
         	template.add("isFinal", value);
         }

      	return this;
      }

      public String getIsFinal() {
      	return (String) this._isFinal;
      }

      public ClassST setIsAbstract(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._isAbstract == null) {
            this._isAbstract = value;
         	template.add("isAbstract", value);
         }

      	return this;
      }

      public String getIsAbstract() {
      	return (String) this._isAbstract;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class CollectionAccessorST implements JavaGroupTemplate {

      private Object _name;
      private Object _type;
      private Object _elementType;

      private final ST template;

      private CollectionAccessorST(STGroup group) {
   		template = group.getInstanceOf("CollectionAccessor");
   	}

      public CollectionAccessorST setName(Object value) {
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

      public CollectionAccessorST setType(Object value) {
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

      public CollectionAccessorST setElementType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._elementType == null) {
            this._elementType = value;
         	template.add("elementType", value);
         }

      	return this;
      }

      public String getElementType() {
      	return (String) this._elementType;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mapMethodsST implements JavaGroupTemplate {

      private Object _name;
      private Object _keyType;
      private Object _valueType;

      private final ST template;

      private mapMethodsST(STGroup group) {
   		template = group.getInstanceOf("mapMethods");
   	}

      public mapMethodsST setName(Object value) {
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

      public mapMethodsST setKeyType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._keyType == null) {
            this._keyType = value;
         	template.add("keyType", value);
         }

      	return this;
      }

      public String getKeyType() {
      	return (String) this._keyType;
      }

      public mapMethodsST setValueType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._valueType == null) {
            this._valueType = value;
         	template.add("valueType", value);
         }

      	return this;
      }

      public String getValueType() {
      	return (String) this._valueType;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class constructorST implements JavaGroupTemplate {

      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _fields = new java.util.LinkedHashSet<>();
      private Object _scope;

      private final ST template;

      private constructorST(STGroup group) {
   		template = group.getInstanceOf("constructor");
   	}

      public constructorST setName(Object value) {
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

      public constructorST addFieldsValue(Object type_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._fields.add(map);

         template.addAggr("fields.{type, name}", map.get("type"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getFields() {
      	return this._fields;
      }

      public constructorST setScope(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._scope == null) {
            this._scope = value;
         	template.add("scope", value);
         }

      	return this;
      }

      public String getScope() {
      	return (String) this._scope;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class setMethodsST implements JavaGroupTemplate {

      private Object _elementName;
      private Object _elementType;
      private Object _name;

      private final ST template;

      private setMethodsST(STGroup group) {
   		template = group.getInstanceOf("setMethods");
   	}

      public setMethodsST setElementName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._elementName == null) {
            this._elementName = value;
         	template.add("elementName", value);
         }

      	return this;
      }

      public String getElementName() {
      	return (String) this._elementName;
      }

      public setMethodsST setElementType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._elementType == null) {
            this._elementType = value;
         	template.add("elementType", value);
         }

      	return this;
      }

      public String getElementType() {
      	return (String) this._elementType;
      }

      public setMethodsST setName(Object value) {
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

   public final class listMethodsST implements JavaGroupTemplate {

      private Object _elementName;
      private Object _elementType;
      private Object _name;

      private final ST template;

      private listMethodsST(STGroup group) {
   		template = group.getInstanceOf("listMethods");
   	}

      public listMethodsST setElementName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._elementName == null) {
            this._elementName = value;
         	template.add("elementName", value);
         }

      	return this;
      }

      public String getElementName() {
      	return (String) this._elementName;
      }

      public listMethodsST setElementType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._elementType == null) {
            this._elementType = value;
         	template.add("elementType", value);
         }

      	return this;
      }

      public String getElementType() {
      	return (String) this._elementType;
      }

      public listMethodsST setName(Object value) {
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

   public final class getST implements JavaGroupTemplate {

      private Object _name;
      private Object _type;

      private final ST template;

      private getST(STGroup group) {
   		template = group.getInstanceOf("get");
   	}

      public getST setName(Object value) {
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

      public getST setType(Object value) {
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

   public final class eqhaST implements JavaGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _eqha = new java.util.LinkedHashSet<>();

      private final ST template;

      private eqhaST(STGroup group) {
   		template = group.getInstanceOf("eqha");
   	}

      public eqhaST setName(Object value) {
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

      public eqhaST addEqhaValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._eqha.add(value);
      	template.add("eqha", value);

         return this;
      }

      public java.util.Set<Object> getEqhaValues() {
      	return this._eqha;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class arrayMethodsST implements JavaGroupTemplate {

      private Object _type;
      private Object _name;

      private final ST template;

      private arrayMethodsST(STGroup group) {
   		template = group.getInstanceOf("arrayMethods");
   	}

      public arrayMethodsST setType(Object value) {
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

      public arrayMethodsST setName(Object value) {
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "JavaGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("Bean(eqha,lexical,name,package,properties,methods,scope) ::= <<~if(package)~package ~package~;\n" + 
		"~endif~\n" + 
		"~if(scope)~~scope~~else~public~endif~ class ~name~ {\n" + 
		"~if(properties)~\n" + 
		"\n" + 
		"	~properties:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"~endif~\n" + 
		"	public ~name~() {\n" + 
		"	}\n" + 
		"~if(properties)~\n" + 
		"\n" + 
		"	public ~name~(~properties:{it|~it.type~ ~it.name~};separator=\",\"~) {\n" + 
		"		~properties:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"~endif~\n" + 
		"~properties:{it|\n" + 
		"	public ~it.type~ get~it.name;format=\"capitalize\"~() {\n" + 
		"		return ~it.name~;\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	public void set~it.name;format=\"capitalize\"~(~it.type~ ~it.name~) {\n" + 
		"   	this.~it.name~ = ~it.name~;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"~if(methods)~\n" + 
		"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"~endif~\n" + 
		"~if(eqha)~\n" + 
		"	@Override\n" + 
		"	public boolean equals(Object o) {\n" + 
		"   	if(this==o) return true;\n" + 
		"	   if(o==null||getClass()!=o.getClass()) return false;\n" + 
		"	   ~name~ that = (~name~) o;\n" + 
		"	   ~eqha:{it | if(~it~!=null ? !~it~.equals(that.~it~) : that.~it~!=null) return false;~\\n~}~		return true;\n" + 
		"	}\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public int hashCode() {\n" + 
		"   	int result;\n" + 
		"	   result = ~first(eqha):{it | (~it~!=null ? ~it~.hashCode() : 0)}~;\n" + 
		"	   ~rest(eqha):{it | result = 31*result+(~it~!=null ? ~it~.hashCode() : 0);~\\n~}~      return result;\n" + 
		"	}\n" + 
		"	\n" + 
		"~endif~\n" + 
		"~if(lexical)~\n" + 
		"	@Override\n" + 
		"   public String toString() {\n" + 
		"       return ~lexical:{it|\"~it~=\" + ~it~ };separator=\" + \\\" \\\" + \"~;\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"}>>\n")
			.append("method(annotations,name,parameters,returnValue,scope,statements) ::= <<~annotations:{it|@~it~};separator=\"\\n\"~\n" + 
		"~if(scope)~~scope~ ~else~~endif~~if(returnValue)~~returnValue~ ~else~void ~endif~~name~(~parameters:{it|~it.type~ ~it.name~};separator=\",\"~) {\n" + 
		"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("Pojo(classProperties,eqha,extends,implement,lexical,methods,name,package,properties,neoNode,json) ::= <<package ~package~;\n" + 
		"\n" + 
		"public class ~name~~if(extends)~ extends ~extends~~endif~~if(implement)~ implements ~implement:{it|~it~};separator=\", \"~~endif~ {\n" + 
		"~if(classProperties)~\n" + 
		"	~classProperties:{it|private static final ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"~endif~\n" + 
		"\n" + 
		"\n" + 
		"	private final String uuid;\n" + 
		"~if(properties)~\n" + 
		"	~properties:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"~endif~\n" + 
		"\n" + 
		"\n" + 
		"	public ~name~() {\n" + 
		"		uuid = java.util.UUID.randomUUID().toString();\n" + 
		"	}\n" + 
		"~if(properties)~\n" + 
		"\n" + 
		"	public ~name~(String uuid, ~properties:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
		"		this.uuid = uuid;\n" + 
		"		~properties:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"~endif~\n" + 
		"~if(json)~\n" + 
		"	public ~name~(io.vertx.core.json.JsonObject jsonObject) {\n" + 
		"		this.uuid = jsonObject.getString(\"uuid\");\n" + 
		"		~properties:{it|this.~it.name~ = jsonObject.get~it.type~(\"~it.name~\");};separator=\"\\n\"~\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"~if(neoNode)~\n" + 
		"\n" + 
		"	public ~name~(org.neo4j.graphdb.Node node) {\n" + 
		"		this.uuid = (String) node.getProperty(\"_uuid\");\n" + 
		"		~properties:{it|this.~it.name~ = node.hasProperty(\"~it.name~\") ? (~it.type~) node.getProperty(\"~it.name~\") : ~it.init~;};separator=\"\\n\"~\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"\n" + 
		"~properties:{it|\n" + 
		"	public ~it.type~ get~it.name;format=\"capitalize\"~() {\n" + 
		"		return ~it.name~;\n" + 
		"	~eom()~\n" + 
		"\n" + 
		"	public void set~it.name;format=\"capitalize\"~(~it.type~ ~it.name~) {\n" + 
		"      this.~it.name~ = ~it.name~;\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"~if(methods)~\n" + 
		"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"~endif~\n" + 
		"~if(eqha)~\n" + 
		"	@Override\n" + 
		"	public boolean equals(Object o) {\n" + 
		"   	if (this == o) return true;\n" + 
		"	   if (o == null || !(o instanceof ~name~)) return false;\n" + 
		"	   ~name~ that = (~name~) o;\n" + 
		"	   ~eqha:{it | if (~it~ != null ? !~it~.equals(that.~it~) : that.~it~ != null) return false;~\\n~}~		return true;\n" + 
		"	}\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public int hashCode() {\n" + 
		"   	int result;\n" + 
		"	   result = ~first(eqha):{it | (~it~ !=null ? ~it~.hashCode() : 0)}~;\n" + 
		"	   ~rest(eqha):{it | result = 31*result+(~it~ != null ? ~it~.hashCode() : 0);~\\n~}~      return result;\n" + 
		"	}\n" + 
		"	\n" + 
		"~endif~\n" + 
		"~if(lexical)~\n" + 
		"	@Override\n" + 
		"   public String toString() {\n" + 
		"       return ~lexical:{it|\"~it~=\" + ~it~ };separator=\" + \\\" \\\" + \"~;\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"~if(json)~\n" + 
		"\n" + 
		"	public io.vertx.core.json.JsonObject toJson() {\n" + 
		"		return new io.vertx.core.json.JsonObject().put(\"uuid\", uuid)~properties:{it|\n" + 
		"			.put(\"~it.name~\", ~it.name~)};separator=\"\\n\"~;\n" + 
		"	}\n" + 
		"~endif~\n" + 
		"~if(neoNode)~\n" + 
		"\n" + 
		"	public org.neo4j.graphdb.Node merge(org.neo4j.graphdb.Node node) {\n" + 
		"		~properties:{it|node.setProperty(\"~it.name~\", ~it.name~);};separator=\"\\n\"~\n" + 
		"		return node;\n" + 
		"	}\n" + 
		"\n" + 
		"	public org.neo4j.graphdb.Node newNode(org.neo4j.graphdb.GraphDatabaseService graphDb) {\n" + 
		"      final org.neo4j.graphdb.Node node = graphDb.createNode(org.neo4j.graphdb.Label.label(\"~name~\"));\n" + 
		"      node.setProperty(\"_uuid\", this.uuid);\n" + 
		"      return merge(node);\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"}>>\n")
			.append("Enum(name,package,values) ::= <<package ~package~;\n" + 
		"\n" + 
		"public enum ~name~ {\n" + 
		"   ~values:{it|~it~};separator=\", \"~\n" + 
		"}>>\n")
			.append("toString(values) ::= <<@Override\n" + 
		"public String toString() {\n" + 
		"	return ~values:{it|\"~it~=\" + ~it~};separator=\" + \\\" \\\" + \"~;\n" + 
		"}>>\n")
			.append("set(name,type) ::= <<public void set~name;format=\"capitalize\"~(~type~ ~name~) {\n" + 
		"	this.~name~ = ~name~;\n" + 
		"}>>\n")
			.append("Class(name,package,methods,innerClasses,fields,scope,isStatic,isFinal,isAbstract) ::= <<~if(package)~package ~package~;\n" + 
		"\n" + 
		"~endif~\n" + 
		"~if(scope)~~scope~ ~endif~~if(isStatic)~static ~endif~~if(isAbstract)~abstract ~endif~~if(isFinal)~final ~endif~class ~name~ {\n" + 
		"\n" + 
		"	~fields:{it|~if(it.scope)~~it.scope~ ~endif~~if(it.isFinal)~final ~endif~~it.type~~if(it.isArray)~[]~endif~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~methods:{it|~it~};separator=\"\\n\\n\"~~if(innerClasses)~\n" + 
		"	~innerClasses:{it|~it~};separator=\"\\n\"~~endif~\n" + 
		"\n" + 
		"}>>\n")
			.append("CollectionAccessor(name,type,elementType) ::= <<public void add(~elementType~ value) {\n" + 
		"	this.~name~.add(value);\n" + 
		"}\n" + 
		"\n" + 
		"public ~type~<~elementType~> get~name;format=\"capitalize\"~() {\n" + 
		"	return this.~name~;\n" + 
		"}>>\n")
			.append("mapMethods(name,keyType,valueType) ::= <<public void put~name;format=\"capitalize\"~(~keyType~ key, ~valueType~ value) {\n" + 
		"   ~name~.put(key, value);\n" + 
		"}\n" + 
		"\n" + 
		"public ~valueType~ remove~name;format=\"capitalize\"~(~keyType~ key) {\n" + 
		"   return ~name~.remove(key);\n" + 
		"}\n" + 
		"\n" + 
		"public int ~name~Size() {\n" + 
		"   return ~name~.size();\n" + 
		"}\n" + 
		"\n" + 
		"public ~valueType~ get~name;format=\"capitalize\"~(~keyType~ key) {\n" + 
		"   return ~name~.get(key);\n" + 
		"}\n" + 
		"\n" + 
		"public boolean containsKey(~keyType~ key) {\n" + 
		"   return ~name~.containsKey(key);\n" + 
		"}\n" + 
		"   \n" + 
		"public java.util.Iterator<java.util.Map.Entry<~keyType~,~valueType~~gt()~~gt()~ iterate~name;format=\"capitalize\"~() {\n" + 
		"   return ~name~.entrySet().iterator();\n" + 
		"}\n" + 
		"\n" + 
		"public java.util.Iterator<~keyType~> iterate~name;format=\"capitalize\"~Keys() {\n" + 
		"   return ~name~.keySet().iterator();\n" + 
		"}\n" + 
		"   \n" + 
		"public java.util.Iterator<~valueType~> iterate~name;format=\"capitalize\"~Values() {\n" + 
		"   return ~name~.values().iterator();\n" + 
		"}\n" + 
		"\n" + 
		"public String ~name~ToString() {\n" + 
		"   final StringBuilder out = new StringBuilder();\n" + 
		"   boolean first = true;\n" + 
		"	for (java.util.Map.Entry<~keyType~, ~valueType~> entry : ~name~.entrySet()) {\n" + 
		"   	if (!first) out.append(\" \");\n" + 
		"      out.append(entry.getKey() + \"=\" + entry.getValue());\n" + 
		"      first = false;\n" + 
		"   }\n" + 
		"   return out.toString();\n" + 
		"}>>\n")
			.append("constructor(name,fields,scope) ::= <<~if(scope)~~scope~ ~endif~~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
		"	~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("setMethods(elementName,elementType,name) ::= <<public void add~elementName;format=\"capitalize\"~(~elementType~ element) {\n" + 
		"	this.~name~.add(element);\n" + 
		"}\n" + 
		"\n" + 
		"public void remove~elementName;format=\"capitalize\"~(~elementType~ element) {\n" + 
		"   this.~name~.remove(element);\n" + 
		"}\n" + 
		"\n" + 
		"public int ~name~Size() { return this.~name~.size(); }\n" + 
		"\n" + 
		"public java.util.Iterator<~elementType~> iterate~name;format=\"capitalize\"~() {\n" + 
		"   return ~name~.iterator();\n" + 
		"}\n" + 
		"\n" + 
		"public java.util.Set<~elementType~> get~name;format=\"capitalize\"~() {\n" + 
		"  return java.util.Collections.unmodifiableSet(~name~);\n" + 
		"}\n" + 
		"\n" + 
		"public void process~name;format=\"capitalize\"~(java.util.function.Consumer<~elementType~> consumer) {\n" + 
		"   this.~name~.forEach(consumer);\n" + 
		"}\n" + 
		"\n" + 
		"public String ~name~ToString() {\n" + 
		"   final StringBuilder out = new StringBuilder();\n" + 
		"   boolean first = true;\n" + 
		"   for (~elementType~ ~elementName~ : ~name~) {\n" + 
		"      if (!first) out.append(\" \");\n" + 
		"      out.append(~elementName~.toString());\n" + 
		"      first = false;\n" + 
		"   }\n" + 
		"   return out.toString();\n" + 
		"}>>\n")
			.append("listMethods(elementName,elementType,name) ::= <<public void add~elementName;format=\"capitalize\"~(~elementType~ element) {\n" + 
		"	this.~name~.add(element);\n" + 
		"}\n" + 
		"\n" + 
		"public void remove~elementName;format=\"capitalize\"~(~elementType~ element) {\n" + 
		"   this.~name~.remove(element);\n" + 
		"}\n" + 
		"\n" + 
		"public int ~name~Size() { return this.~name~.size(); }\n" + 
		"\n" + 
		"public java.util.Iterator<~elementType~> iterate~name;format=\"capitalize\"~() {\n" + 
		"   return ~name~.iterator();\n" + 
		"}\n" + 
		"\n" + 
		"public ~elementType~ get~elementName;format=\"capitalize\"~(int index) {\n" + 
		"   return ~name~.get(index);\n" + 
		"}\n" + 
		"\n" + 
		"public void replace~elementName;format=\"capitalize\"~(int index, ~elementType~ replacement) {\n" + 
		"   this.~name~.add(index, replacement);\n" + 
		"   this.~name~.remove(index + 1);\n" + 
		"}\n" + 
		"\n" + 
		"public java.util.List<~elementType~> get~name;format=\"capitalize\"~() {\n" + 
		"  return java.util.Collections.unmodifiableList(~name~);\n" + 
		"}\n" + 
		"\n" + 
		"public void process~name;format=\"capitalize\"~(java.util.function.Consumer<~elementType~> consumer) {\n" + 
		"   this.~name~.forEach(consumer);\n" + 
		"}\n" + 
		"\n" + 
		"public String ~name~ToString() {\n" + 
		"   final StringBuilder out = new StringBuilder();\n" + 
		"   boolean first = true;\n" + 
		"   for (~elementType~ ~elementName~ : ~name~) {\n" + 
		"      if (!first) out.append(\" \");\n" + 
		"      out.append(~elementName~.toString());\n" + 
		"      first = false;\n" + 
		"   }\n" + 
		"   return out.toString();\n" + 
		"}>>\n")
			.append("get(name,type) ::= <<public ~type~ get~name;format=\"capitalize\"~() {\n" + 
		"	return this.~name~;\n" + 
		"}>>\n")
			.append("eqha(name,eqha) ::= <<@Override\n" + 
		"public boolean equals(Object o) {\n" + 
		"  	if (this == o) return true;\n" + 
		"   if (o == null || !(o instanceof ~name~)) return false;\n" + 
		"   ~name~ that = (~name~) o;\n" + 
		"   ~eqha:{it | if (~it~ != null ? !~it~.equals(that.~it~) : that.~it~ != null) return false;~\\n~}~	return true;\n" + 
		"}\n" + 
		"\n" + 
		"@Override\n" + 
		"public int hashCode() {\n" + 
		"  	int result;\n" + 
		"   result = ~first(eqha):{it | (~it~ !=null ? ~it~.hashCode() : 0)}~;\n" + 
		"   ~rest(eqha):{it | result = 31*result+(~it~ != null ? ~it~.hashCode() : 0);~\\n~}~   return result;\n" + 
		"}>>\n")
			.append("arrayMethods(type,name) ::= <<public void set~name;format=\"capitalize\"~(~type~[] ~name~) {\n" + 
		"    this.~name~ = ~name~;\n" + 
		"}\n" + 
		"\n" + 
		"public void set~name;format=\"capitalize\"~(~type~ index, ~type~ element) {\n" + 
		"    ~name~[index] = element;\n" + 
		"}\n" + 
		"\n" + 
		"public ~type~[] get~name;format=\"capitalize\"~() {\n" + 
		"    return this.~name~;\n" + 
		"}\n" + 
		"\n" + 
		"public ~type~ get~name;format=\"capitalize\"~(~type~ index) {\n" + 
		"    return this.~name~[index];\n" + 
		"}>>\n")
		.toString();
}