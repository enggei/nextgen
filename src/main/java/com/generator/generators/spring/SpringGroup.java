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
		.toString();
}