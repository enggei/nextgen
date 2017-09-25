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

   public actionST newaction() {
      return new actionST(stGroup);
   }

   public DomainStoreST newDomainStore() {
      return new DomainStoreST(stGroup);
   }

   public MobXContainerST newMobXContainer() {
      return new MobXContainerST(stGroup);
   }

   public ModelST newModel() {
      return new ModelST(stGroup);
   }

   public requestST newrequest() {
      return new requestST(stGroup);
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
			.append("action(name,statements,parameter) ::= <<@action ~name~(~parameter:{it|~it.name~};separator=\",\"~) {\n" + 
		"	~statements:{it|~it~;};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("DomainStore(observables,name,actions) ::= <<import {observable, autorun, action} from 'mobx';\n" + 
		"import request from '../utils/request';\n" + 
		"~observables:{it|import ~it.name~ from '~it.path~';};separator=\"\\n\"~\n" + 
		"\n" + 
		"class ~name~ {\n" + 
		"\n" + 
		"	~observables:{it|@observable ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~actions:{it|~it~};separator=\"\\n\"~\n" + 
		"\n" + 
		"}\n" + 
		"\n" + 
		"export default new ~name~();>>\n")
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
			.append("Model(name,observables) ::= <<import {observable, autorun, action, toJS} from 'mobx';\n" + 
		"\n" + 
		"class ~name~ {\n" + 
		"\n" + 
		"	~observables:{it|@observable ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	fromJson(json) {\n" + 
		"		~observables:{it|this.~it.name~ = json.~it.name~;};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"   toJson() {\n" + 
		"   	return '{ \"~name~\" : '+ JSON.stringify(toJS(this)) + '}';\n" + 
		"	}\n" + 
		"}\n" + 
		"\n" + 
		"export default ~name~;>>\n")
			.append("request(handleResponse,uri,action,param) ::= <<request.~action~('~uri~'~if(param)~, ~param~~endif~).then(response => {\n" + 
		"   console.info(\"~uri~ : \" + response);\n" + 
		"	~handleResponse~\n" + 
		"}).catch(error => { console.log(error); });>>\n")
		.toString();
}