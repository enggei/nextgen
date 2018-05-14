package com.generator.generators.spring;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Spring.stg' file<br/>
 */
public final class SpringGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public SpringGroup() {
		this(new STGroupString(stg));
   }

   public SpringGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public SpringGroup(java.io.File templateFile) {
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

	public interface SpringGroupTemplate {

	}

   public DAOST newDAO() {
      return new DAOST(stGroup);
   }

   public createJdbcTemplateST newcreateJdbcTemplate() {
      return new createJdbcTemplateST(stGroup);
   }

   public queryMethodST newqueryMethod() {
      return new queryMethodST(stGroup);
   }

   public mvn_starter_webST newmvn_starter_web() {
      return new mvn_starter_webST(stGroup);
   }

   public mvn_springboot_pluginST newmvn_springboot_plugin() {
      return new mvn_springboot_pluginST(stGroup);
   }

   public ControllerST newController() {
      return new ControllerST(stGroup);
   }

   public mvn_starter_thymeleafST newmvn_starter_thymeleaf() {
      return new mvn_starter_thymeleafST(stGroup);
   }

   public mvn_starter_devtoolsST newmvn_starter_devtools() {
      return new mvn_starter_devtoolsST(stGroup);
   }

   public GET_methodST newGET_method() {
      return new GET_methodST(stGroup);
   }

   public parameterDeclarationST newparameterDeclaration() {
      return new parameterDeclarationST(stGroup);
   }

   public ApplicationST newApplication() {
      return new ApplicationST(stGroup);
   }

   public mvn_starter_jpaST newmvn_starter_jpa() {
      return new mvn_starter_jpaST(stGroup);
   }

   public mvn_mysql_connectorST newmvn_mysql_connector() {
      return new mvn_mysql_connectorST(stGroup);
   }

   public jpa_hibernate_propertiesST newjpa_hibernate_properties() {
      return new jpa_hibernate_propertiesST(stGroup);
   }

   public entityST newentity() {
      return new entityST(stGroup);
   }

   public RepositoryST newRepository() {
      return new RepositoryST(stGroup);
   }

   public final class DAOST implements SpringGroupTemplate {

      private Object _name;
      private Object _package;
      private java.util.Set<Object> _queries = new java.util.LinkedHashSet<>();
      private Object _database;
      private Object _host;
      private Object _port;
      private Object _username;

      private final ST template;

      private DAOST(STGroup group) {
   		template = group.getInstanceOf("DAO");
   	}

      public DAOST setName(Object value) {
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

      public DAOST setPackage(Object value) {
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

      public DAOST addQueriesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._queries.add(value);
      	template.add("queries", value);

         return this;
      }

      public java.util.Set<Object> getQueriesValues() {
      	return this._queries;
      }

      public DAOST setDatabase(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._database == null) {
            this._database = value;
         	template.add("database", value);
         }

      	return this;
      }

      public String getDatabase() {
      	return (String) this._database;
      }

      public DAOST setHost(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._host == null) {
            this._host = value;
         	template.add("host", value);
         }

      	return this;
      }

      public String getHost() {
      	return (String) this._host;
      }

      public DAOST setPort(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._port == null) {
            this._port = value;
         	template.add("port", value);
         }

      	return this;
      }

      public String getPort() {
      	return (String) this._port;
      }

      public DAOST setUsername(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._username == null) {
            this._username = value;
         	template.add("username", value);
         }

      	return this;
      }

      public String getUsername() {
      	return (String) this._username;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class createJdbcTemplateST implements SpringGroupTemplate {

      private Object _database;
      private Object _host;
      private Object _port;
      private Object _username;

      private final ST template;

      private createJdbcTemplateST(STGroup group) {
   		template = group.getInstanceOf("createJdbcTemplate");
   	}

      public createJdbcTemplateST setDatabase(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._database == null) {
            this._database = value;
         	template.add("database", value);
         }

      	return this;
      }

      public String getDatabase() {
      	return (String) this._database;
      }

      public createJdbcTemplateST setHost(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._host == null) {
            this._host = value;
         	template.add("host", value);
         }

      	return this;
      }

      public String getHost() {
      	return (String) this._host;
      }

      public createJdbcTemplateST setPort(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._port == null) {
            this._port = value;
         	template.add("port", value);
         }

      	return this;
      }

      public String getPort() {
      	return (String) this._port;
      }

      public createJdbcTemplateST setUsername(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._username == null) {
            this._username = value;
         	template.add("username", value);
         }

      	return this;
      }

      public String getUsername() {
      	return (String) this._username;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class queryMethodST implements SpringGroupTemplate {

      private Object _entityDeclaration;
      private Object _logger;
      private Object _entity;
      private java.util.Set<java.util.Map<String, Object>> _columns = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _params = new java.util.LinkedHashSet<>();
      private Object _sql;

      private final ST template;

      private queryMethodST(STGroup group) {
   		template = group.getInstanceOf("queryMethod");
   	}

      public queryMethodST setEntityDeclaration(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._entityDeclaration == null) {
            this._entityDeclaration = value;
         	template.add("entityDeclaration", value);
         }

      	return this;
      }

      public String getEntityDeclaration() {
      	return (String) this._entityDeclaration;
      }

      public queryMethodST setLogger(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._logger == null) {
            this._logger = value;
         	template.add("logger", value);
         }

      	return this;
      }

      public String getLogger() {
      	return (String) this._logger;
      }

      public queryMethodST setEntity(Object value) {
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

      public queryMethodST addColumnsValue(Object name_, Object queryName_, Object resultSetGetter_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("queryName", (queryName_ == null || queryName_.toString().length() == 0) ? null : queryName_);
      	map.put("resultSetGetter", (resultSetGetter_ == null || resultSetGetter_.toString().length() == 0) ? null : resultSetGetter_);
      	this._columns.add(map);

         template.addAggr("columns.{name, queryName, resultSetGetter}", map.get("name"), map.get("queryName"), map.get("resultSetGetter"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getColumns() {
      	return this._columns;
      }

      public queryMethodST setName(Object value) {
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

      public queryMethodST addParamsValue(Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._params.add(map);

         template.addAggr("params.{name, type}", map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getParams() {
      	return this._params;
      }

      public queryMethodST setSql(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._sql == null) {
            this._sql = value;
         	template.add("sql", value);
         }

      	return this;
      }

      public String getSql() {
      	return (String) this._sql;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_starter_webST implements SpringGroupTemplate {


      private final ST template;

      private mvn_starter_webST(STGroup group) {
   		template = group.getInstanceOf("mvn_starter_web");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_springboot_pluginST implements SpringGroupTemplate {


      private final ST template;

      private mvn_springboot_pluginST(STGroup group) {
   		template = group.getInstanceOf("mvn_springboot_plugin");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ControllerST implements SpringGroupTemplate {

      private Object _name;
      private Object _packageName;
      private java.util.Set<Object> _methods = new java.util.LinkedHashSet<>();
      private Object _requestMapping;
      private java.util.Set<java.util.Map<String, Object>> _autoWired = new java.util.LinkedHashSet<>();

      private final ST template;

      private ControllerST(STGroup group) {
   		template = group.getInstanceOf("Controller");
   	}

      public ControllerST setName(Object value) {
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

      public ControllerST setPackageName(Object value) {
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

      public ControllerST addMethodsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methods.add(value);
      	template.add("methods", value);

         return this;
      }

      public java.util.Set<Object> getMethodsValues() {
      	return this._methods;
      }

      public ControllerST setRequestMapping(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._requestMapping == null) {
            this._requestMapping = value;
         	template.add("requestMapping", value);
         }

      	return this;
      }

      public String getRequestMapping() {
      	return (String) this._requestMapping;
      }

      public ControllerST addAutoWiredValue(Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._autoWired.add(map);

         template.addAggr("autoWired.{name, type}", map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getAutoWired() {
      	return this._autoWired;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_starter_thymeleafST implements SpringGroupTemplate {


      private final ST template;

      private mvn_starter_thymeleafST(STGroup group) {
   		template = group.getInstanceOf("mvn_starter_thymeleaf");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_starter_devtoolsST implements SpringGroupTemplate {


      private final ST template;

      private mvn_starter_devtoolsST(STGroup group) {
   		template = group.getInstanceOf("mvn_starter_devtools");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class GET_methodST implements SpringGroupTemplate {

      private Object _url;
      private Object _name;
      private java.util.Set<Object> _parameters = new java.util.LinkedHashSet<>();
      private Object _returnType;
      private Object _returnValue;
      private java.util.Set<Object> _statements = new java.util.LinkedHashSet<>();
      private Object _hasModel;

      private final ST template;

      private GET_methodST(STGroup group) {
   		template = group.getInstanceOf("GET_method");
   	}

      public GET_methodST setUrl(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._url == null) {
            this._url = value;
         	template.add("url", value);
         }

      	return this;
      }

      public String getUrl() {
      	return (String) this._url;
      }

      public GET_methodST setName(Object value) {
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

      public GET_methodST addParametersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._parameters.add(value);
      	template.add("parameters", value);

         return this;
      }

      public java.util.Set<Object> getParametersValues() {
      	return this._parameters;
      }

      public GET_methodST setReturnType(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._returnType == null) {
            this._returnType = value;
         	template.add("returnType", value);
         }

      	return this;
      }

      public String getReturnType() {
      	return (String) this._returnType;
      }

      public GET_methodST setReturnValue(Object value) {
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

      public GET_methodST addStatementsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._statements.add(value);
      	template.add("statements", value);

         return this;
      }

      public java.util.Set<Object> getStatementsValues() {
      	return this._statements;
      }

      public GET_methodST setHasModel(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._hasModel == null) {
            this._hasModel = value;
         	template.add("hasModel", value);
         }

      	return this;
      }

      public String getHasModel() {
      	return (String) this._hasModel;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class parameterDeclarationST implements SpringGroupTemplate {

      private Object _defaultValue;
      private Object _isRequired;
      private Object _name;
      private Object _type;

      private final ST template;

      private parameterDeclarationST(STGroup group) {
   		template = group.getInstanceOf("parameterDeclaration");
   	}

      public parameterDeclarationST setDefaultValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._defaultValue == null) {
            this._defaultValue = value;
         	template.add("defaultValue", value);
         }

      	return this;
      }

      public String getDefaultValue() {
      	return (String) this._defaultValue;
      }

      public parameterDeclarationST setIsRequired(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._isRequired == null) {
            this._isRequired = value;
         	template.add("isRequired", value);
         }

      	return this;
      }

      public String getIsRequired() {
      	return (String) this._isRequired;
      }

      public parameterDeclarationST setName(Object value) {
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

      public parameterDeclarationST setType(Object value) {
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

   public final class ApplicationST implements SpringGroupTemplate {

      private Object _packageName;

      private final ST template;

      private ApplicationST(STGroup group) {
   		template = group.getInstanceOf("Application");
   	}

      public ApplicationST setPackageName(Object value) {
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

   public final class mvn_starter_jpaST implements SpringGroupTemplate {


      private final ST template;

      private mvn_starter_jpaST(STGroup group) {
   		template = group.getInstanceOf("mvn_starter_jpa");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_mysql_connectorST implements SpringGroupTemplate {


      private final ST template;

      private mvn_mysql_connectorST(STGroup group) {
   		template = group.getInstanceOf("mvn_mysql_connector");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class jpa_hibernate_propertiesST implements SpringGroupTemplate {

      private Object _db;
      private Object _password;
      private Object _username;
      private Object _ddl_auto;

      private final ST template;

      private jpa_hibernate_propertiesST(STGroup group) {
   		template = group.getInstanceOf("jpa_hibernate_properties");
   	}

      public jpa_hibernate_propertiesST setDb(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._db == null) {
            this._db = value;
         	template.add("db", value);
         }

      	return this;
      }

      public String getDb() {
      	return (String) this._db;
      }

      public jpa_hibernate_propertiesST setPassword(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._password == null) {
            this._password = value;
         	template.add("password", value);
         }

      	return this;
      }

      public String getPassword() {
      	return (String) this._password;
      }

      public jpa_hibernate_propertiesST setUsername(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._username == null) {
            this._username = value;
         	template.add("username", value);
         }

      	return this;
      }

      public String getUsername() {
      	return (String) this._username;
      }

      public jpa_hibernate_propertiesST setDdl_auto(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._ddl_auto == null) {
            this._ddl_auto = value;
         	template.add("ddl_auto", value);
         }

      	return this;
      }

      public String getDdl_auto() {
      	return (String) this._ddl_auto;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class entityST implements SpringGroupTemplate {

      private Object _packageName;

      private final ST template;

      private entityST(STGroup group) {
   		template = group.getInstanceOf("entity");
   	}

      public entityST setPackageName(Object value) {
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

   public final class RepositoryST implements SpringGroupTemplate {

      private Object _packageName;

      private final ST template;

      private RepositoryST(STGroup group) {
   		template = group.getInstanceOf("Repository");
   	}

      public RepositoryST setPackageName(Object value) {
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "SpringGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("DAO(name,package,queries,database,host,port,username) ::= <<package ~package~;\n" + 
		"\n" + 
		"import org.springframework.jdbc.core.JdbcTemplate;\n" + 
		"import org.springframework.jdbc.core.RowMapper;\n" + 
		"\n" + 
		"import java.sql.ResultSet;\n" + 
		"import java.sql.SQLException;\n" + 
		"\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"	~queries:{it|~it~};separator=\"\\n\"~\n" + 
		"\n" + 
		"   protected org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate(String password) {\n" + 
		"      return getJdbcTemplate(\"~database~\", \"~username~\", password, \"~host~\", ~port~);\n" + 
		"   }\n" + 
		"\n" + 
		"   protected org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate(String database, String username, String password, String serverName, int port) {\n" + 
		"      final com.mysql.jdbc.jdbc2.optional.MysqlDataSource dataSource = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();\n" + 
		"      dataSource.setDatabaseName(database);\n" + 
		"      dataSource.setUser(username);\n" + 
		"      dataSource.setPassword(password);\n" + 
		"      dataSource.setServerName(serverName);\n" + 
		"      dataSource.setPort(port);\n" + 
		"\n" + 
		"      return new org.springframework.jdbc.core.JdbcTemplate(dataSource);\n" + 
		"   }\n" + 
		"}>>\n")
			.append("createJdbcTemplate(database,host,port,username) ::= <<public static org.springframework.jdbc.core.JdbcTemplate getJdbcTemplate(String password) {\n" + 
		"   final com.mysql.jdbc.jdbc2.optional.MysqlDataSource dataSource = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();\n" + 
		"   dataSource.setDatabaseName(\"~database~\");\n" + 
		"   dataSource.setUser(\"~username~\");\n" + 
		"   dataSource.setPassword(password);\n" + 
		"   dataSource.setServerName(\"~host~\");\n" + 
		"   dataSource.setPort(~port~);\n" + 
		"	return new org.springframework.jdbc.core.JdbcTemplate(dataSource);\n" + 
		"}>>\n")
			.append("queryMethod(entityDeclaration,logger,entity,columns,name,params,sql) ::= <<public static java.util.List<~entity~> ~name~(JdbcTemplate jdbcTemplate~if(params)~, ~params:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
		"\n" + 
		"	~if(logger)~\n" + 
		"	~logger~.info(\"query ~name~~if(params)~ with ~params:{it|~it.type~ ~it.name~};separator=\" + \\\" \"~~else~\"~endif~);~endif~\n" + 
		"   return jdbcTemplate.query(\"~sql~\", new RowMapper<~entity~>() {\n" + 
		"   	@Override\n" + 
		"	   public ~entity~ mapRow(ResultSet resultSet, int i) throws SQLException {\n" + 
		"	   	final ~entity~ entity = new ~entity~();\n" + 
		"			~columns:{it|entity.set~it.name;format=\"capitalize\"~(resultSet.get~it.resultSetGetter~(\"~it.queryName~\"));};separator=\"\\n\"~\n" + 
		"	      return entity;\n" + 
		"		}\n" + 
		"   }~if(params)~, ~params:{it|~it.name~};separator=\", \"~~endif~);\n" + 
		"} ~if(entityDeclaration)~\n" + 
		"\n" + 
		"~entityDeclaration~\n" + 
		"~endif~>>\n")
			.append("mvn_starter_web() ::= <<<dependency>\n" + 
		"   <groupId>org.springframework.boot</groupId>\n" + 
		"	<artifactId>spring-boot-starter-web</artifactId>\n" + 
		"</dependency> >>\n")
			.append("mvn_springboot_plugin() ::= <<<plugin>\n" + 
		"   <groupId>org.springframework.boot</groupId>\n" + 
		"	<artifactId>spring-boot-maven-plugin</artifactId>\n" + 
		"</plugin> >>\n")
			.append("Controller(name,packageName,methods,requestMapping,autoWired) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.springframework.stereotype.Controller;\n" + 
		"import org.springframework.ui.Model;\n" + 
		"import org.springframework.web.bind.annotation.GetMapping;\n" + 
		"import org.springframework.web.bind.annotation.RequestParam;\n" + 
		"import org.springframework.beans.factory.annotation.Autowired;\n" + 
		"import org.springframework.stereotype.Controller;\n" + 
		"import org.springframework.web.bind.annotation.RequestMapping;\n" + 
		"import org.springframework.web.bind.annotation.GetMapping;\n" + 
		"import org.springframework.web.bind.annotation.RequestParam;\n" + 
		"import org.springframework.web.bind.annotation.ResponseBody;\n" + 
		"\n" + 
		"@Controller~if(requestMapping)~\n" + 
		"@RequestMapping(path=\"~requestMapping~\")\n" + 
		"~endif~\n" + 
		"public class ~name~ {\n" + 
		"\n" + 
		"~autoWired:{it|\n" + 
		"	@Autowired\n" + 
		"	private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~methods:{it|~it~};separator=\"\\n\"~    \n" + 
		"\n" + 
		"}>>\n")
			.append("mvn_starter_thymeleaf() ::= <<<dependency>\n" + 
		"   <groupId>org.springframework.boot</groupId>\n" + 
		"	<artifactId>spring-boot-starter-thymeleaf</artifactId>\n" + 
		"</dependency> >>\n")
			.append("mvn_starter_devtools() ::= <<<dependency>\n" + 
		"   <groupId>org.springframework.boot</groupId>\n" + 
		"	<artifactId>spring-boot-devtools</artifactId>\n" + 
		"   <optional>true</optional>\n" + 
		"</dependency> >>\n")
			.append("GET_method(url,name,parameters,returnType,returnValue,statements,hasModel) ::= <<@GetMapping(\"~url~\")\n" + 
		"public ~returnType~ ~name~(~parameters:{it|~it~};separator=\",\"~~if(hasModel)~~if(parameters)~,~endif~Model model~endif~) {\n" + 
		"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
		"   return ~returnValue~;\n" + 
		"}>>\n")
			.append("parameterDeclaration(defaultValue,isRequired,name,type) ::= <<@RequestParam(name=\"~name~\", required=~isRequired~, defaultValue=\"~defaultValue~\") ~type~ ~name~>>\n")
			.append("Application(packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.springframework.boot.SpringApplication;\n" + 
		"import org.springframework.boot.autoconfigure.SpringBootApplication;\n" + 
		"\n" + 
		"@SpringBootApplication\n" + 
		"public class Application {\n" + 
		"\n" + 
		"    public static void main(String[] args) {\n" + 
		"        SpringApplication.run(Application.class, args);\n" + 
		"    }\n" + 
		"\n" + 
		"}>>\n")
			.append("mvn_starter_jpa() ::= <<<dependency>\n" + 
		"	<groupId>org.springframework.boot</groupId>\n" + 
		"   <artifactId>spring-boot-starter-data-jpa</artifactId>\n" + 
		"</dependency> >>\n")
			.append("mvn_mysql_connector() ::= <<<dependency>\n" + 
		"	<groupId>mysql</groupId>\n" + 
		"   <artifactId>mysql-connector-java</artifactId>\n" + 
		"</dependency> >>\n")
			.append("jpa_hibernate_properties(db,password,username,ddl_auto) ::= <<spring.jpa.hibernate.ddl-auto=~if(ddl_auto)~~ddl_auto~~else~create~endif~\n" + 
		"spring.datasource.url=jdbc:mysql://localhost:3306/~db~\n" + 
		"spring.datasource.username=~username~\n" + 
		"spring.datasource.password=~password~>>\n")
			.append("entity(packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import javax.persistence.Entity;\n" + 
		"import javax.persistence.GeneratedValue;\n" + 
		"import javax.persistence.GenerationType;\n" + 
		"import javax.persistence.Id;\n" + 
		"\n" + 
		"@Entity\n" + 
		"public class User {\n" + 
		"    @Id\n" + 
		"    @GeneratedValue(strategy=GenerationType.AUTO)\n" + 
		"    private Integer id;\n" + 
		"// todo use properties:\n" + 
		"    private String name;\n" + 
		"\n" + 
		"    private String email;\n" + 
		"\n" + 
		"	public Integer getId() {\n" + 
		"		return id;\n" + 
		"	}\n" + 
		"\n" + 
		"	public void setId(Integer id) {\n" + 
		"		this.id = id;\n" + 
		"	}\n" + 
		"\n" + 
		"	public String getName() {\n" + 
		"		return name;\n" + 
		"	}\n" + 
		"\n" + 
		"	public void setName(String name) {\n" + 
		"		this.name = name;\n" + 
		"	}\n" + 
		"\n" + 
		"	public String getEmail() {\n" + 
		"		return email;\n" + 
		"	}\n" + 
		"\n" + 
		"	public void setEmail(String email) {\n" + 
		"		this.email = email;\n" + 
		"	}\n" + 
		"\n" + 
		"\n" + 
		"}>>\n")
			.append("Repository(packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import org.springframework.data.repository.CrudRepository;\n" + 
		"\n" + 
		"import hello.User;\n" + 
		"\n" + 
		"// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository\n" + 
		"// CRUD refers Create, Read, Update, Delete\n" + 
		"\n" + 
		"public interface UserRepository extends CrudRepository<User, Long> {\n" + 
		"\n" + 
		"}>>\n")
		.toString();
}