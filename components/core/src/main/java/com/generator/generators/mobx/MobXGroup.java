package com.generator.generators.mobx;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'MobX.stg' file<br/>
 */
public final class MobXGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public MobXGroup() {
		this(new STGroupString(stg));
   }

   public MobXGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public MobXGroup(java.io.File templateFile) {
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

	public interface MobXGroupTemplate {

	}

   public getRequestST newgetRequest() {
      return new getRequestST(stGroup);
   }

   public postRequestST newpostRequest() {
      return new postRequestST(stGroup);
   }

   public MobXContainerST newMobXContainer() {
      return new MobXContainerST(stGroup);
   }

   public requestST newrequest() {
      return new requestST(stGroup);
   }

   public ModelST newModel() {
      return new ModelST(stGroup);
   }

   public actionST newaction() {
      return new actionST(stGroup);
   }

   public DomainStoreST newDomainStore() {
      return new DomainStoreST(stGroup);
   }

   public indexHTMLST newindexHTML() {
      return new indexHTMLST(stGroup);
   }

   public indexJSST newindexJS() {
      return new indexJSST(stGroup);
   }

   public AppST newApp() {
      return new AppST(stGroup);
   }

   public AppMenuST newAppMenu() {
      return new AppMenuST(stGroup);
   }

   public AppStoreST newAppStore() {
      return new AppStoreST(stGroup);
   }

   public AppAgentST newAppAgent() {
      return new AppAgentST(stGroup);
   }

   public AuthStoreST newAuthStore() {
      return new AuthStoreST(stGroup);
   }

   public UserStoreST newUserStore() {
      return new UserStoreST(stGroup);
   }

   public final class getRequestST implements MobXGroupTemplate {

      private Object _entity;
      private Object _url;

      private final ST template;

      private getRequestST(STGroup group) {
   		template = group.getInstanceOf("getRequest");
   	}

      public getRequestST setEntity(Object value) {
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

      public getRequestST setUrl(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class postRequestST implements MobXGroupTemplate {

      private Object _entity;
      private Object _url;

      private final ST template;

      private postRequestST(STGroup group) {
   		template = group.getInstanceOf("postRequest");
   	}

      public postRequestST setEntity(Object value) {
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

      public postRequestST setUrl(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class MobXContainerST implements MobXGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _components = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _store;
      private java.util.Set<Object> _constructorStatements = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _methodDeclarations = new java.util.LinkedHashSet<>();
      private Object _element;

      private final ST template;

      private MobXContainerST(STGroup group) {
   		template = group.getInstanceOf("MobXContainer");
   	}

      public MobXContainerST addComponentsValue(Object importPath_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("importPath", (importPath_ == null || importPath_.toString().length() == 0) ? null : importPath_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._components.add(map);

         template.addAggr("components.{importPath, name}", map.get("importPath"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getComponents() {
      	return this._components;
      }

      public MobXContainerST setName(Object value) {
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

      public MobXContainerST setStore(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._store == null) {
            this._store = value;
         	template.add("store", value);
         }

      	return this;
      }

      public String getStore() {
      	return (String) this._store;
      }

      public MobXContainerST addConstructorStatementsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._constructorStatements.add(value);
      	template.add("constructorStatements", value);

         return this;
      }

      public java.util.Set<Object> getConstructorStatementsValues() {
      	return this._constructorStatements;
      }

      public MobXContainerST addMethodDeclarationsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._methodDeclarations.add(value);
      	template.add("methodDeclarations", value);

         return this;
      }

      public java.util.Set<Object> getMethodDeclarationsValues() {
      	return this._methodDeclarations;
      }

      public MobXContainerST setElement(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._element == null) {
            this._element = value;
         	template.add("element", value);
         }

      	return this;
      }

      public String getElement() {
      	return (String) this._element;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class requestST implements MobXGroupTemplate {

      private Object _handleResponse;
      private Object _uri;
      private Object _action;
      private Object _param;

      private final ST template;

      private requestST(STGroup group) {
   		template = group.getInstanceOf("request");
   	}

      public requestST setHandleResponse(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._handleResponse == null) {
            this._handleResponse = value;
         	template.add("handleResponse", value);
         }

      	return this;
      }

      public String getHandleResponse() {
      	return (String) this._handleResponse;
      }

      public requestST setUri(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._uri == null) {
            this._uri = value;
         	template.add("uri", value);
         }

      	return this;
      }

      public String getUri() {
      	return (String) this._uri;
      }

      public requestST setAction(Object value) {
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

      public requestST setParam(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._param == null) {
            this._param = value;
         	template.add("param", value);
         }

      	return this;
      }

      public String getParam() {
      	return (String) this._param;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ModelST implements MobXGroupTemplate {

      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _observables = new java.util.LinkedHashSet<>();

      private final ST template;

      private ModelST(STGroup group) {
   		template = group.getInstanceOf("Model");
   	}

      public ModelST setName(Object value) {
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

      public ModelST addObservablesValue(Object init_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._observables.add(map);

         template.addAggr("observables.{init, name}", map.get("init"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getObservables() {
      	return this._observables;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class actionST implements MobXGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _statements = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _parameter = new java.util.LinkedHashSet<>();

      private final ST template;

      private actionST(STGroup group) {
   		template = group.getInstanceOf("action");
   	}

      public actionST setName(Object value) {
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

      public actionST addStatementsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._statements.add(value);
      	template.add("statements", value);

         return this;
      }

      public java.util.Set<Object> getStatementsValues() {
      	return this._statements;
      }

      public actionST addParameterValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._parameter.add(map);

         template.addAggr("parameter.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getParameter() {
      	return this._parameter;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class DomainStoreST implements MobXGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _observables = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<Object> _actions = new java.util.LinkedHashSet<>();

      private final ST template;

      private DomainStoreST(STGroup group) {
   		template = group.getInstanceOf("DomainStore");
   	}

      public DomainStoreST addObservablesValue(Object name_, Object init_, Object path_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("init", (init_ == null || init_.toString().length() == 0) ? null : init_);
      	map.put("path", (path_ == null || path_.toString().length() == 0) ? null : path_);
      	this._observables.add(map);

         template.addAggr("observables.{name, init, path}", map.get("name"), map.get("init"), map.get("path"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getObservables() {
      	return this._observables;
      }

      public DomainStoreST setName(Object value) {
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

      public DomainStoreST addActionsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._actions.add(value);
      	template.add("actions", value);

         return this;
      }

      public java.util.Set<Object> getActionsValues() {
      	return this._actions;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class indexHTMLST implements MobXGroupTemplate {


      private final ST template;

      private indexHTMLST(STGroup group) {
   		template = group.getInstanceOf("indexHTML");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class indexJSST implements MobXGroupTemplate {


      private final ST template;

      private indexJSST(STGroup group) {
   		template = group.getInstanceOf("indexJS");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class AppST implements MobXGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _modules = new java.util.LinkedHashSet<>();

      private final ST template;

      private AppST(STGroup group) {
   		template = group.getInstanceOf("App");
   	}

      public AppST addModulesValue(Object path_, Object appName_, Object appStore_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("path", (path_ == null || path_.toString().length() == 0) ? null : path_);
      	map.put("appName", (appName_ == null || appName_.toString().length() == 0) ? null : appName_);
      	map.put("appStore", (appStore_ == null || appStore_.toString().length() == 0) ? null : appStore_);
      	this._modules.add(map);

         template.addAggr("modules.{path, appName, appStore}", map.get("path"), map.get("appName"), map.get("appStore"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getModules() {
      	return this._modules;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class AppMenuST implements MobXGroupTemplate {


      private final ST template;

      private AppMenuST(STGroup group) {
   		template = group.getInstanceOf("AppMenu");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class AppStoreST implements MobXGroupTemplate {


      private final ST template;

      private AppStoreST(STGroup group) {
   		template = group.getInstanceOf("AppStore");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class AppAgentST implements MobXGroupTemplate {


      private final ST template;

      private AppAgentST(STGroup group) {
   		template = group.getInstanceOf("AppAgent");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class AuthStoreST implements MobXGroupTemplate {


      private final ST template;

      private AuthStoreST(STGroup group) {
   		template = group.getInstanceOf("AuthStore");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class UserStoreST implements MobXGroupTemplate {


      private final ST template;

      private UserStoreST(STGroup group) {
   		template = group.getInstanceOf("UserStore");
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "MobXGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("getRequest(entity,url) ::= <<console.info(\"get~entity~\");\n" + 
		"request.get('~url~').then(response => {\n" + 
		"	console.info(\"~url~ : \" + response);\n" + 
		"	this.~entity~.fromJson(response.data.~entity~);\n" + 
		"}).catch(error => { console.log(error); });>>\n")
			.append("postRequest(entity,url) ::= <<console.info(\"save~entity~\");\n" + 
		"request.post('~url~', this.~entity~.toJson()).then(response => {\n" + 
		"	console.info(\"~url~ : \" + response);\n" + 
		"	this.~entity~.fromJson(response.data.~entity~);\n" + 
		"}).catch(error => { console.log(error); });>>\n")
			.append("MobXContainer(components,name,store,constructorStatements,methodDeclarations,element) ::= <<import React from 'react';\n" + 
		"~components:{it|import ~it.name~ from '~it.importPath~';};separator=\"\\n\"~\n" + 
		"import { inject, observer } from 'mobx-react';\n" + 
		"\n" + 
		"@inject('~store~')\n" + 
		"@observer\n" + 
		"export default class ~name~ extends React.Component {\n" + 
		"\n" + 
		"  constructor(props) {\n" + 
		"    super(props);\n" + 
		"\n" + 
		"	 ~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
		"  }\n" + 
		"\n" + 
		"  componentWillMount() {\n" + 
		"  }\n" + 
		"\n" + 
		"  componentDidMount() {\n" + 
		"  }\n" + 
		"\n" + 
		"  componentWillUnmount() {\n" + 
		"  }\n" + 
		"\n" + 
		"  ~methodDeclarations:{it|~it~};separator=\"\\n\\n\"~\n" + 
		"\n" + 
		"  render() {\n" + 
		"    return (\n" + 
		"		  ~element~\n" + 
		"    );\n" + 
		"  }\n" + 
		"}>>\n")
			.append("request(handleResponse,uri,action,param) ::= <<request.~action~('~uri~'~if(param)~, ~param~~endif~).then(response => {\n" + 
		"   console.info(\"~uri~ : \" + response);\n" + 
		"	~handleResponse~\n" + 
		"}).catch(error => { console.log(error); });>>\n")
			.append("Model(name,observables) ::= <<import {observable, autorun, action, toJS} from 'mobx';\n" + 
		"\n" + 
		"class ~name~ {\n" + 
		"\n" + 
		"	@observable uuid;\n" + 
		"	~observables:{it|@observable ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	fromJson(json) {\n" + 
		"		this.uuid = json.uuid;\n" + 
		"		~observables:{it|this.~it.name~ = json.~it.name~;};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"   toJson() {\n" + 
		"   	return JSON.stringify(toJS(this));\n" + 
		"	}\n" + 
		"}\n" + 
		"\n" + 
		"export default ~name~;>>\n")
			.append("action(name,statements,parameter) ::= <<@action ~name~(~parameter:{it|~it.name~};separator=\",\"~) {\n" + 
		"	~statements:{it|~it~;};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("DomainStore(observables,name,actions) ::= <<import {observable, autorun, action} from 'mobx';\n" + 
		"import request from '../utils/request';\n" + 
		"~observables:{it|import ~it.name~ from '~it.path~';};separator=\"\\n\"~\n" + 
		"\n" + 
		"class ~name~ {\n" + 
		"\n" + 
		"	~observables:{it|@observable ~it.name;format=\"lowFirst\"~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~actions:{it|~it~};separator=\"\\n\"~\n" + 
		"\n" + 
		"}\n" + 
		"\n" + 
		"export default new ~name~();>>\n")
			.append("indexHTML() ::= <<<!doctype html>\n" + 
		"<html lang=\"en\">\n" + 
		"<head>\n" + 
		"    <meta charset=\"UTF-8\">\n" + 
		"    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" + 
		"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + 
		"    <title>Probe</title>\n" + 
		"\n" + 
		"    <link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/icon?family=Material+Icons\">\n" + 
		"</head>\n" + 
		"<body>\n" + 
		"<div id=\"app\"></div>\n" + 
		"<script src=\"./index.js\"></script>\n" + 
		"</body>\n" + 
		"</html> >>\n")
			.append("indexJS() ::= <<import './app.css'\n" + 
		"import React from 'react';\n" + 
		"import { render } from 'react-dom';\n" + 
		"import injectTapEventPlugin from 'react-tap-event-plugin';\n" + 
		"import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';\n" + 
		"import getMuiTheme from 'material-ui/styles/getMuiTheme';\n" + 
		"import {\n" + 
		"  cyan500, cyan700,\n" + 
		"  pinkA200,\n" + 
		"  grey100, grey300, grey400, grey500,\n" + 
		"  white, darkBlack, fullBlack,\n" + 
		"} from 'material-ui/styles/colors';\n" + 
		"import {fade} from 'material-ui/utils/colorManipulator';\n" + 
		"import spacing from 'material-ui/styles/spacing';\n" + 
		"\n" + 
		"import App from './app/App';\n" + 
		"\n" + 
		"injectTapEventPlugin();\n" + 
		"\n" + 
		"const font = \"Cadiz-Bold\";\n" + 
		"\n" + 
		"// Unique theme\n" + 
		"const muiTheme = getMuiTheme({\n" + 
		"    spacing: spacing,\n" + 
		"    fontFamily: font,\n" + 
		"    palette: {\n" + 
		"        primary1Color: \"#00F7A6\",\n" + 
		"        primary2Color: \"#EDEEEF\",\n" + 
		"        primary3Color: grey400,\n" + 
		"        accent1Color: pinkA200,\n" + 
		"        accent2Color: grey100,\n" + 
		"        accent3Color: grey500,\n" + 
		"        textColor: darkBlack,\n" + 
		"        alternateTextColor: white,\n" + 
		"        canvasColor: white,\n" + 
		"        borderColor: grey300,\n" + 
		"        disabledColor: fade(darkBlack, 0.3),\n" + 
		"        pickerHeaderColor: cyan500,\n" + 
		"        clockCircleColor: fade(darkBlack, 0.07),\n" + 
		"        shadowColor: fullBlack,\n" + 
		"  }\n" + 
		"});\n" + 
		"\n" + 
		"render(\n" + 
		"    <MuiThemeProvider muiTheme={muiTheme}>\n" + 
		"        <App style={{fontFamily: font}}/>\n" + 
		"    </MuiThemeProvider>,\n" + 
		"  document.getElementById('app'))>>\n")
			.append("App(modules) ::= <<import React from 'react';\n" + 
		"import { BrowserRouter as Router, Route, Link, Switch, Redirect, browserHistory} from 'react-router-dom'\n" + 
		"import AppBar from 'material-ui/AppBar';\n" + 
		"import { Provider } from 'mobx-react';\n" + 
		"\n" + 
		"import AppMenu from './AppMenu';\n" + 
		"~modules:{it|import ~it.appName~ from '../~it.path~'};separator=\"\\n\"~\n" + 
		"\n" + 
		"import AppStore from '../app/AppStore';\n" + 
		"~modules:{it|import ~it.appStore~ from '../~it.path~'};separator=\"\\n\"~\n" + 
		"\n" + 
		"const stores = {\n" + 
		"	AppStore~if(modules)~~modules:{it|, ~it.appStore~}~~endif~\n" + 
		"};\n" + 
		"\n" + 
		"// For easier debugging\n" + 
		"window._____APP_STATE_____ = stores;\n" + 
		"\n" + 
		"const styles = {\n" + 
		"      subheader: {\n" + 
		"        fontFamily: 'Cadiz-Bold'\n" + 
		"      }\n" + 
		"    };\n" + 
		"\n" + 
		"const Home = (props) => (\n" + 
		"    <h2 style={styles.subheader}>Basekey</h2>\n" + 
		");\n" + 
		"\n" + 
		"\n" + 
		"export default class App extends React.Component {\n" + 
		"\n" + 
		"	render() {\n" + 
		"		return (\n" + 
		"			<Provider {...stores}>\n" + 
		"         	<Router history={browserHistory}>\n" + 
		"            	<div>\n" + 
		"               	    <AppBar iconElementLeft={<img src=\"res/bk_logo.png\" width=\"210px\"/>} iconElementRight={<AppMenu />} />\n" + 
		"               	    <Switch>\n" + 
		"                   		<Route path=\"/\" exact component={Home}/>\n" + 
		"                   		<Route path=\"/config\" component={ConfigApp}/>\n" + 
		"                   		<Route path=\"/scan\" component={ScanApp}/>\n" + 
		"                   		<Route path=\"/territory\" component={TerritoryApp}/>\n" + 
		"                    </Switch>\n" + 
		"					</div>\n" + 
		"				</Router>\n" + 
		"			</Provider>\n" + 
		"        );\n" + 
		"    }\n" + 
		"}>>\n")
			.append("AppMenu() ::= <<import React from 'react';\n" + 
		"import { inject, observer } from 'mobx-react';\n" + 
		"import { Link} from 'react-router-dom'\n" + 
		"import IconButton from 'material-ui/IconButton';\n" + 
		"import IconMenu from 'material-ui/IconMenu';\n" + 
		"import DropDownMenu from 'material-ui/DropDownMenu';\n" + 
		"import Avatar from 'material-ui/Avatar';\n" + 
		"import MenuItem from 'material-ui/MenuItem';\n" + 
		"\n" + 
		"@inject('AppStore')\n" + 
		"@observer\n" + 
		"export default class EstateApp extends React.Component {\n" + 
		"\n" + 
		"  constructor(props) {\n" + 
		"    super(props);\n" + 
		"    this.state = {value: 1};\n" + 
		"  }\n" + 
		"\n" + 
		"  componentWillMount() {\n" + 
		"  }\n" + 
		"\n" + 
		"  componentDidMount() {\n" + 
		"  }\n" + 
		"\n" + 
		"  componentWillUnmount() {\n" + 
		"  }\n" + 
		"\n" + 
		"  handleChange = (event, index, value) => this.setState({value});\n" + 
		"\n" + 
		"  render() {\n" + 
		"\n" + 
		"    return (\n" + 
		"		<div>\n" + 
		"            <DropDownMenu value={this.state.value} onChange={this.handleChange}>\n" + 
		"                <MenuItem value={1} primaryText=\"Home\" containerElement={<Link to=\"/\" />} />\n" + 
		"                <MenuItem value={2} primaryText=\"Configuration\" containerElement={<Link to=\"/config\" />} />\n" + 
		"                <MenuItem value={3} primaryText=\"Scan\" containerElement={<Link to=\"/scan\" />} />\n" + 
		"                <MenuItem value={4} primaryText=\"Territory\" containerElement={<Link to=\"/territory\" />} />\n" + 
		"            </DropDownMenu>\n" + 
		"\n" + 
		"            <Avatar src=\"res/avatar.png\" />\n" + 
		"\n" + 
		"            <DropDownMenu>\n" + 
		"                <MenuItem primaryText=\"Phil\" containerElement={<Link to=\"/\" />} />\n" + 
		"            </DropDownMenu>\n" + 
		"\n" + 
		"            <IconMenu\n" + 
		"                iconButtonElement={ <IconButton style={{width: '180px'}}><img src=\"res/ud_logo.png\" width=\"150px\"/></IconButton> }\n" + 
		"                targetOrigin={{horizontal: 'right', vertical: 'center'}}\n" + 
		"                anchorOrigin={{horizontal: 'right', vertical: 'center'}}>\n" + 
		"            </IconMenu>\n" + 
		"        </div>\n" + 
		"    );\n" + 
		"  }\n" + 
		"}>>\n")
			.append("AppStore() ::= <<import { observable, action, reaction } from 'mobx';\n" + 
		"import agent from './AppAgent';\n" + 
		"\n" + 
		"class AppStore {\n" + 
		"\n" + 
		"  @observable appName = 'Conduit';\n" + 
		"  @observable token = window.localStorage.getItem('jwt');\n" + 
		"  @observable appLoaded = false;\n" + 
		"\n" + 
		"  @observable tags = [];\n" + 
		"  @observable isLoadingTags = false;\n" + 
		"\n" + 
		"  constructor() {\n" + 
		"    reaction(\n" + 
		"      () => this.token,\n" + 
		"      token => {\n" + 
		"        if (token) {\n" + 
		"          window.localStorage.setItem('jwt', token);\n" + 
		"        } else {\n" + 
		"          window.localStorage.removeItem('jwt');\n" + 
		"        }\n" + 
		"      }\n" + 
		"    );\n" + 
		"  }\n" + 
		"\n" + 
		"  @action loadTags() {\n" + 
		"    this.isLoadingTags = true;\n" + 
		"    return agent.Tags.getAll()\n" + 
		"      .then(action(({ tags }) => { this.tags = tags.map(t => t.toLowerCase()); }))\n" + 
		"      .finally(action(() => { this.isLoadingTags = false; }))\n" + 
		"  }\n" + 
		"\n" + 
		"  @action setToken(token) {\n" + 
		"    this.token = token;\n" + 
		"  }\n" + 
		"\n" + 
		"  @action setAppLoaded() {\n" + 
		"    this.appLoaded = true;\n" + 
		"  }\n" + 
		"\n" + 
		"}\n" + 
		"\n" + 
		"export default new AppStore();>>\n")
			.append("AppAgent() ::= <<import superagentPromise from 'superagent-promise';\n" + 
		"import _superagent from 'superagent';\n" + 
		"import commonStore from './AppStore';\n" + 
		"import authStore from './AuthStore';\n" + 
		"\n" + 
		"const superagent = superagentPromise(_superagent, global.Promise);\n" + 
		"\n" + 
		"const API_ROOT = 'https://conduit.productionready.io/api';\n" + 
		"\n" + 
		"const encode = encodeURIComponent;\n" + 
		"\n" + 
		"const handleErrors = err => {\n" + 
		"  if (err && err.response && err.response.status === 401) {\n" + 
		"    authStore.logout();\n" + 
		"  }\n" + 
		"  return err;\n" + 
		"};\n" + 
		"\n" + 
		"const responseBody = res => res.body;\n" + 
		"\n" + 
		"const tokenPlugin = req => {\n" + 
		"  if (commonStore.token) {\n" + 
		"    req.set('authorization', `Token ${commonStore.token}`);\n" + 
		"  }\n" + 
		"};\n" + 
		"\n" + 
		"const requests = {\n" + 
		"  del: url =>\n" + 
		"    superagent\n" + 
		"      .del(`${API_ROOT}${url}`)\n" + 
		"      .use(tokenPlugin)\n" + 
		"      .end(handleErrors)\n" + 
		"      .then(responseBody),\n" + 
		"  get: url =>\n" + 
		"    superagent\n" + 
		"      .get(`${API_ROOT}${url}`)\n" + 
		"      .use(tokenPlugin)\n" + 
		"      .end(handleErrors)\n" + 
		"      .then(responseBody),\n" + 
		"  put: (url, body) =>\n" + 
		"    superagent\n" + 
		"      .put(`${API_ROOT}${url}`, body)\n" + 
		"      .use(tokenPlugin)\n" + 
		"      .end(handleErrors)\n" + 
		"      .then(responseBody),\n" + 
		"  post: (url, body) =>\n" + 
		"    superagent\n" + 
		"      .post(`${API_ROOT}${url}`, body)\n" + 
		"      .use(tokenPlugin)\n" + 
		"      .end(handleErrors)\n" + 
		"      .then(responseBody),\n" + 
		"};\n" + 
		"\n" + 
		"const Auth = {\n" + 
		"  current: () =>\n" + 
		"    requests.get('/user'),\n" + 
		"  login: (email, password) =>\n" + 
		"    requests.post('/users/login', { user: { email, password } }),\n" + 
		"  register: (username, email, password) =>\n" + 
		"    requests.post('/users', { user: { username, email, password } }),\n" + 
		"  save: user =>\n" + 
		"    requests.put('/user', { user })\n" + 
		"};\n" + 
		"\n" + 
		"const Tags = {\n" + 
		"  getAll: () => requests.get('/tags')\n" + 
		"};\n" + 
		"\n" + 
		"const limit = (count, p) => `limit=${count}&offset=${p ? p * count : 0}`;\n" + 
		"const omitSlug = article => Object.assign({}, article, { slug: undefined })\n" + 
		"\n" + 
		"const Articles = {\n" + 
		"  all: (page, lim = 10) =>\n" + 
		"    requests.get(`/articles?${limit(lim, page)}`),\n" + 
		"  byAuthor: (author, page, query) =>\n" + 
		"    requests.get(`/articles?author=${encode(author)}&${limit(5, page)}`),\n" + 
		"  byTag: (tag, page, lim = 10) =>\n" + 
		"    requests.get(`/articles?tag=${encode(tag)}&${limit(lim, page)}`),\n" + 
		"  del: slug =>\n" + 
		"    requests.del(`/articles/${slug}`),\n" + 
		"  favorite: slug =>\n" + 
		"    requests.post(`/articles/${slug}/favorite`),\n" + 
		"  favoritedBy: (author, page) =>\n" + 
		"    requests.get(`/articles?favorited=${encode(author)}&${limit(5, page)}`),\n" + 
		"  feed: () =>\n" + 
		"    requests.get('/articles/feed?limit=10&offset=0'),\n" + 
		"  get: slug =>\n" + 
		"    requests.get(`/articles/${slug}`),\n" + 
		"  unfavorite: slug =>\n" + 
		"    requests.del(`/articles/${slug}/favorite`),\n" + 
		"  update: article =>\n" + 
		"    requests.put(`/articles/${article.slug}`, { article: omitSlug(article) }),\n" + 
		"  create: article =>\n" + 
		"    requests.post('/articles', { article })\n" + 
		"};\n" + 
		"\n" + 
		"const Comments = {\n" + 
		"  create: (slug, comment) =>\n" + 
		"    requests.post(`/articles/${slug}/comments`, { comment }),\n" + 
		"  delete: (slug, commentId) =>\n" + 
		"    requests.del(`/articles/${slug}/comments/${commentId}`),\n" + 
		"  forArticle: slug =>\n" + 
		"    requests.get(`/articles/${slug}/comments`)\n" + 
		"};\n" + 
		"\n" + 
		"const Profile = {\n" + 
		"  follow: username =>\n" + 
		"    requests.post(`/profiles/${username}/follow`),\n" + 
		"  get: username =>\n" + 
		"    requests.get(`/profiles/${username}`),\n" + 
		"  unfollow: username =>\n" + 
		"    requests.del(`/profiles/${username}/follow`)\n" + 
		"};\n" + 
		"\n" + 
		"export default {\n" + 
		"  Articles,\n" + 
		"  Auth,\n" + 
		"  Comments,\n" + 
		"  Profile,\n" + 
		"  Tags,\n" + 
		"};>>\n")
			.append("AuthStore() ::= <<import { observable, action } from 'mobx';\n" + 
		"import agent from './AppAgent';\n" + 
		"import userStore from './UserStore';\n" + 
		"import commonStore from './AppStore';\n" + 
		"\n" + 
		"class AuthStore {\n" + 
		"  @observable inProgress = false;\n" + 
		"  @observable errors = undefined;\n" + 
		"\n" + 
		"  @observable values = {\n" + 
		"    username: '',\n" + 
		"    email: '',\n" + 
		"    password: '',\n" + 
		"  };\n" + 
		"\n" + 
		"  @action setUsername(username) {\n" + 
		"    this.values.username = username;\n" + 
		"  }\n" + 
		"\n" + 
		"  @action setEmail(email) {\n" + 
		"    this.values.email = email;\n" + 
		"  }\n" + 
		"\n" + 
		"  @action setPassword(password) {\n" + 
		"    this.values.password = password;\n" + 
		"  }\n" + 
		"\n" + 
		"  @action reset() {\n" + 
		"    this.values.username = '';\n" + 
		"    this.values.email = '';\n" + 
		"    this.values.password = '';\n" + 
		"  }\n" + 
		"\n" + 
		"  @action login() {\n" + 
		"    this.inProgress = true;\n" + 
		"    this.errors = undefined;\n" + 
		"    return agent.Auth.login(this.values.email, this.values.password)\n" + 
		"      .then(({ user }) => commonStore.setToken(user.token))\n" + 
		"      .then(() => userStore.pullUser())\n" + 
		"      .catch(action((err) => {\n" + 
		"        this.errors = err.response && err.response.body && err.response.body.errors;\n" + 
		"        throw err;\n" + 
		"      }))\n" + 
		"      .finally(action(() => { this.inProgress = false; }));\n" + 
		"  }\n" + 
		"\n" + 
		"  @action register() {\n" + 
		"    this.inProgress = true;\n" + 
		"    this.errors = undefined;\n" + 
		"    return agent.Auth.register(this.values.username, this.values.email, this.values.password)\n" + 
		"      .then(({ user }) => commonStore.setToken(user.token))\n" + 
		"      .then(() => userStore.pullUser())\n" + 
		"      .catch(action((err) => {\n" + 
		"        this.errors = err.response && err.response.body && err.response.body.errors;\n" + 
		"        throw err;\n" + 
		"      }))\n" + 
		"      .finally(action(() => { this.inProgress = false; }));\n" + 
		"  }\n" + 
		"\n" + 
		"  @action logout() {\n" + 
		"    commonStore.setToken(undefined);\n" + 
		"    userStore.forgetUser();\n" + 
		"    return Promise.resolve();\n" + 
		"  }\n" + 
		"}\n" + 
		"\n" + 
		"export default new AuthStore();>>\n")
			.append("UserStore() ::= <<import { observable, action } from 'mobx';\n" + 
		"import agent from './AppAgent';\n" + 
		"\n" + 
		"class UserStore {\n" + 
		"\n" + 
		"  @observable currentUser;\n" + 
		"  @observable loadingUser;\n" + 
		"  @observable updatingUser;\n" + 
		"  @observable updatingUserErrors;\n" + 
		"\n" + 
		"  @action pullUser() {\n" + 
		"    this.loadingUser = true;\n" + 
		"    return agent.Auth.current()\n" + 
		"      .then(action(({ user }) => { this.currentUser = user; }))\n" + 
		"      .finally(action(() => { this.loadingUser = false; }))\n" + 
		"  }\n" + 
		"\n" + 
		"  @action updateUser(newUser) {\n" + 
		"    this.updatingUser = true;\n" + 
		"    return agent.Auth.save(newUser)\n" + 
		"      .then(action(({ user }) => { this.currentUser = user; }))\n" + 
		"      .finally(action(() => { this.updatingUser = false; }))\n" + 
		"  }\n" + 
		"\n" + 
		"  @action forgetUser() {\n" + 
		"    this.currentUser = undefined;\n" + 
		"  }\n" + 
		"\n" + 
		"}\n" + 
		"\n" + 
		"export default new UserStore();>>\n")
		.toString();
}