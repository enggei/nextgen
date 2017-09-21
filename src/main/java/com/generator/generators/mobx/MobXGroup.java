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

   public ModelST newModel() {
      return new ModelST(stGroup);
   }

   public final class actionST implements MobXGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _statements = new java.util.LinkedHashSet<>();

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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class DomainStoreST implements MobXGroupTemplate {

      private java.util.Set<Object> _actions = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _observables = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _comments;
      private java.util.Set<java.util.Map<String, Object>> _stores = new java.util.LinkedHashSet<>();

      private final ST template;

      private DomainStoreST(STGroup group) {
   		template = group.getInstanceOf("DomainStore");
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

      public DomainStoreST addObservablesValue(Object init_, Object name_) {
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

      public DomainStoreST setComments(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._comments == null) {
            this._comments = value;
         	template.add("comments", value);
         }

      	return this;
      }

      public String getComments() {
      	return (String) this._comments;
      }

      public DomainStoreST addStoresValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._stores.add(map);

         template.addAggr("stores.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getStores() {
      	return this._stores;
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
			.append("action(name,statements) ::= <<@action ~name~() {\n" + 
		"	~statements:{it|~it~;};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("DomainStore(actions,observables,name,comments,stores) ::= <<import {observable, autorun, action} from 'mobx';\n" + 
		"import request from '../utils/request';\n" + 
		"import ~name~ from './~name~';\n" + 
		"\n" + 
		"~if(comments)~// ~comments~\n" + 
		"~endif~\n" + 
		"export class ~name~Store {\n" + 
		"\n" + 
		"	~stores:{it|~it.name~;};separator=\"\\n\"~\n" + 
		"	@observable elements = [];\n" + 
		"   @observable isLoading = true;\n" + 
		"\n" + 
		"	constructor(~stores:{it|~it.name~};separator=\",\"~) {\n" + 
		"		~stores:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
		"//		this.transportLayer.onReceive~name~Update(updated~name~ => this.update~name~FromServer(updated~name~));\n" + 
		"      this.load~name~();\n" + 
		"	}\n" + 
		"\n" + 
		"	load~name~() {\n" + 
		"   	this.isLoading = true;\n" + 
		"\n" + 
		"		request.get('/bk/scan/status').then(response => {\n" + 
		"			response.forEach(json => this.update~name~FromServer(json));\n" + 
		"      }).catch(error => { console.log(error); });\n" + 
		"\n" + 
		"      //this.transportLayer.fetch~name~().then(fetched~name~ => {\n" + 
		"      //	fetched~name~.forEach(json => this.update~name~FromServer(json));\n" + 
		"      // this.isLoading = false;\n" + 
		"		//});\n" + 
		"	}\n" + 
		"\n" + 
		"	/**\n" + 
		"     * Update a ~name~ with information from the server. Guarantees a ~name~\n" + 
		"     * only exists once. Might either construct a new ~name~, update an existing one,\n" + 
		"     * or remove an ~name~ if it has been deleted on the server.\n" + 
		"     */\n" + 
		"   update~name~FromServer(json) {\n" + 
		"\n" + 
		"   	var val = this.elements.find(val => val.id === json.id);\n" + 
		"\n" + 
		"      if (!val) {\n" + 
		"      	val = new ~name~(this, json.id);\n" + 
		"         this.elements.push(val);\n" + 
		"      }\n" + 
		"      \n" + 
		"		if (json.isDeleted) {\n" + 
		"      	this.remove~name~(val);\n" + 
		"      } else {\n" + 
		"      	val.updateFromJson(json);\n" + 
		"      }\n" + 
		"    }\n" + 
		"\n" + 
		"	/**\n" + 
		"     * Creates a fresh todo on the client and server\n" + 
		"     */\n" + 
		"   create~name~() {\n" + 
		"   	var val = new ~name~(this);\n" + 
		"      this.elements.push(val);\n" + 
		"      return val;\n" + 
		"	}\n" + 
		"\n" + 
		"	remove~name~(val) {\n" + 
		"   	this.elements.splice(this.elements.indexOf(val), 1);\n" + 
		"      val.dispose();\n" + 
		"	}\n" + 
		"\n" + 
		"	~observables:{it|//@observable ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~actions:{it|~it~};separator=\"\\n\"~\n" + 
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
		.toString();
}