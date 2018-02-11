package com.generator.generators.openapi3;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'openapi3.stg' file<br/>
 */
public final class Openapi3Group {

   private final STGroup stGroup;
   private final char delimiter;

	public Openapi3Group() {
		this(new STGroupString(stg));
   }

   public Openapi3Group(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public Openapi3Group(java.io.File templateFile) {
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

	public interface Openapi3GroupTemplate {

	}

   public parameterST newparameter() {
      return new parameterST(stGroup);
   }

   public actionST newaction() {
      return new actionST(stGroup);
   }

   public responseST newresponse() {
      return new responseST(stGroup);
   }

   public responseContentST newresponseContent() {
      return new responseContentST(stGroup);
   }

   public specificationST newspecification() {
      return new specificationST(stGroup);
   }

   public endpointST newendpoint() {
      return new endpointST(stGroup);
   }

   public final class parameterST implements Openapi3GroupTemplate {

      private Object _description;
      private Object _format;
      private Object _name;
      private Object _path;
      private Object _required;
      private Object _type;

      private final ST template;

      private parameterST(STGroup group) {
   		template = group.getInstanceOf("parameter");
   	}

      public parameterST setDescription(Object value) {
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

      public parameterST setFormat(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._format == null) {
            this._format = value;
         	template.add("format", value);
         }

      	return this;
      }

      public String getFormat() {
      	return (String) this._format;
      }

      public parameterST setName(Object value) {
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

      public parameterST setPath(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._path == null) {
            this._path = value;
         	template.add("path", value);
         }

      	return this;
      }

      public String getPath() {
      	return (String) this._path;
      }

      public parameterST setRequired(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._required == null) {
            this._required = value;
         	template.add("required", value);
         }

      	return this;
      }

      public String getRequired() {
      	return (String) this._required;
      }

      public parameterST setType(Object value) {
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

   public final class actionST implements Openapi3GroupTemplate {

      private Object _action;
      private java.util.Set<Object> _users = new java.util.LinkedHashSet<>();
      private Object _description;
      private Object _summary;
      private Object _operationId;
      private java.util.Set<Object> _parameters = new java.util.LinkedHashSet<>();
      private Object _externalDocsDescription;
      private java.util.Set<Object> _responses = new java.util.LinkedHashSet<>();
      private Object _externalDocUrl;

      private final ST template;

      private actionST(STGroup group) {
   		template = group.getInstanceOf("action");
   	}

      public actionST setAction(Object value) {
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

      public actionST addUsersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._users.add(value);
      	template.add("users", value);

         return this;
      }

      public java.util.Set<Object> getUsersValues() {
      	return this._users;
      }

      public actionST setDescription(Object value) {
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

      public actionST setSummary(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._summary == null) {
            this._summary = value;
         	template.add("summary", value);
         }

      	return this;
      }

      public String getSummary() {
      	return (String) this._summary;
      }

      public actionST setOperationId(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._operationId == null) {
            this._operationId = value;
         	template.add("operationId", value);
         }

      	return this;
      }

      public String getOperationId() {
      	return (String) this._operationId;
      }

      public actionST addParametersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._parameters.add(value);
      	template.add("parameters", value);

         return this;
      }

      public java.util.Set<Object> getParametersValues() {
      	return this._parameters;
      }

      public actionST setExternalDocsDescription(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._externalDocsDescription == null) {
            this._externalDocsDescription = value;
         	template.add("externalDocsDescription", value);
         }

      	return this;
      }

      public String getExternalDocsDescription() {
      	return (String) this._externalDocsDescription;
      }

      public actionST addResponsesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._responses.add(value);
      	template.add("responses", value);

         return this;
      }

      public java.util.Set<Object> getResponsesValues() {
      	return this._responses;
      }

      public actionST setExternalDocUrl(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._externalDocUrl == null) {
            this._externalDocUrl = value;
         	template.add("externalDocUrl", value);
         }

      	return this;
      }

      public String getExternalDocUrl() {
      	return (String) this._externalDocUrl;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class responseST implements Openapi3GroupTemplate {

      private Object _code;
      private Object _description;

      private final ST template;

      private responseST(STGroup group) {
   		template = group.getInstanceOf("response");
   	}

      public responseST setCode(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._code == null) {
            this._code = value;
         	template.add("code", value);
         }

      	return this;
      }

      public String getCode() {
      	return (String) this._code;
      }

      public responseST setDescription(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class responseContentST implements Openapi3GroupTemplate {

      private Object _type;
      private Object _schemaRef;

      private final ST template;

      private responseContentST(STGroup group) {
   		template = group.getInstanceOf("responseContent");
   	}

      public responseContentST setType(Object value) {
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

      public responseContentST setSchemaRef(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._schemaRef == null) {
            this._schemaRef = value;
         	template.add("schemaRef", value);
         }

      	return this;
      }

      public String getSchemaRef() {
      	return (String) this._schemaRef;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class specificationST implements Openapi3GroupTemplate {

      private Object _description;
      private Object _title;
      private Object _version;
      private java.util.Set<java.util.Map<String, Object>> _servers = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _paths = new java.util.LinkedHashSet<>();

      private final ST template;

      private specificationST(STGroup group) {
   		template = group.getInstanceOf("specification");
   	}

      public specificationST setDescription(Object value) {
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

      public specificationST setTitle(Object value) {
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

      public specificationST setVersion(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._version == null) {
            this._version = value;
         	template.add("version", value);
         }

      	return this;
      }

      public String getVersion() {
      	return (String) this._version;
      }

      public specificationST addServersValue(Object description_, Object url_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("description", (description_ == null || description_.toString().length() == 0) ? null : description_);
      	map.put("url", (url_ == null || url_.toString().length() == 0) ? null : url_);
      	this._servers.add(map);

         template.addAggr("servers.{description, url}", map.get("description"), map.get("url"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getServers() {
      	return this._servers;
      }

      public specificationST addPathsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._paths.add(value);
      	template.add("paths", value);

         return this;
      }

      public java.util.Set<Object> getPathsValues() {
      	return this._paths;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class endpointST implements Openapi3GroupTemplate {

      private java.util.Set<Object> _actions = new java.util.LinkedHashSet<>();
      private Object _description;
      private Object _path;
      private Object _summary;

      private final ST template;

      private endpointST(STGroup group) {
   		template = group.getInstanceOf("endpoint");
   	}

      public endpointST addActionsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._actions.add(value);
      	template.add("actions", value);

         return this;
      }

      public java.util.Set<Object> getActionsValues() {
      	return this._actions;
      }

      public endpointST setDescription(Object value) {
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

      public endpointST setPath(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._path == null) {
            this._path = value;
         	template.add("path", value);
         }

      	return this;
      }

      public String getPath() {
      	return (String) this._path;
      }

      public endpointST setSummary(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._summary == null) {
            this._summary = value;
         	template.add("summary", value);
         }

      	return this;
      }

      public String getSummary() {
      	return (String) this._summary;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "Openapi3Group.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("parameter(description,format,name,path,required,type) ::= <<- 	name: ~name~\n" + 
		"	in: ~path~\n" + 
		"   description: ~description~\n" + 
		"   required: ~required~\n" + 
		"   schema:\n" + 
		"   	type: ~type~\n" + 
		"      format: ~format~>>\n")
			.append("action(action,users,description,summary,operationId,parameters,externalDocsDescription,responses,externalDocUrl) ::= <<~action~:\n" + 
		"	tags:\n" + 
		"   	- ~users:{it|};separator=\" \"~\n" + 
		"	summary: ~summary~\n" + 
		"   description: >\n" + 
		"   	~description~\n" + 
		"	operationId: ~operationId~\n" + 
		"   parameters:\n" + 
		"   	~parameters:{it|~it~};separator=\"\\n\"~\n" + 
		"	responses:\n" + 
		"   	~responses:{it|~it~};separator=\"\\n\"~'\n" + 
		"	externalDocs:\n" + 
		"   	description: ~externalDocsDescription~\n" + 
		"		url: ~externalDocUrl~>>\n")
			.append("response(code,description) ::= <<'~code~':\n" + 
		"	description: ~description~\n" + 
		"   content:\n" + 
		"   	~content:{it|~it~};separator=\"\\n\"~>>\n")
			.append("responseContent(type,schemaRef) ::= <<~type~:\n" + 
		"	schema:\n" + 
		"   	$ref: '#/components/schemas/~schemaRef~'>>\n")
			.append("specification(description,title,version,servers,paths) ::= <<openapi: 3.0.0\n" + 
		"info:\n" + 
		"  title: ~title~\n" + 
		"  description: ~description~\n" + 
		"  version: ~version~\n" + 
		"\n" + 
		"servers:\n" + 
		"	~servers:{it|- url: ~it.url~\n" + 
		"    description: ~it.description~};separator=\"\\n\"~\n" + 
		"\n" + 
		"paths:\n" + 
		"	~paths:{it|~it~};separator=\"\\n\"~>>\n")
			.append("endpoint(actions,description,path,summary) ::= <<~path~:\n" + 
		"	summary: ~summary~\n" + 
		"   description: ~description~\n" + 
		"	~actions:{it|~it~};separator=\"\\n\"~>>\n")
		.toString();
}