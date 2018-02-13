package com.generator.generators.easyFlow;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'easyFlow.stg' file<br/>
 */
public final class EasyFlowGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public EasyFlowGroup() {
		this(new STGroupString(stg));
   }

   public EasyFlowGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public EasyFlowGroup(java.io.File templateFile) {
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

	public interface EasyFlowGroupTemplate {

	}

   public statefulContextST newstatefulContext() {
      return new statefulContextST(stGroup);
   }

   public jsonMessageHandlerST newjsonMessageHandler() {
      return new jsonMessageHandlerST(stGroup);
   }

   public implST newimpl() {
      return new implST(stGroup);
   }

   public statesST newstates() {
      return new statesST(stGroup);
   }

   public easyFlowST neweasyFlow() {
      return new easyFlowST(stGroup);
   }

   public mvnST newmvn() {
      return new mvnST(stGroup);
   }

   public eventsST newevents() {
      return new eventsST(stGroup);
   }

   public declarationST newdeclaration() {
      return new declarationST(stGroup);
   }

   public stateDeclarationST newstateDeclaration() {
      return new stateDeclarationST(stGroup);
   }

   public transitST newtransit() {
      return new transitST(stGroup);
   }

   public final class statefulContextST implements EasyFlowGroupTemplate {

      private Object _contextGeneric;
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _properties = new java.util.LinkedHashSet<>();

      private final ST template;

      private statefulContextST(STGroup group) {
   		template = group.getInstanceOf("statefulContext");
   	}

      public statefulContextST setContextGeneric(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._contextGeneric == null) {
            this._contextGeneric = value;
         	template.add("contextGeneric", value);
         }

      	return this;
      }

      public String getContextGeneric() {
      	return (String) this._contextGeneric;
      }

      public statefulContextST setName(Object value) {
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

      public statefulContextST addPropertiesValue(Object comment_, Object modifier_, Object name_, Object type_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("comment", (comment_ == null || comment_.toString().length() == 0) ? null : comment_);
      	map.put("modifier", (modifier_ == null || modifier_.toString().length() == 0) ? null : modifier_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._properties.add(map);

         template.addAggr("properties.{comment, modifier, name, type, value}", map.get("comment"), map.get("modifier"), map.get("name"), map.get("type"), map.get("value"));
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

   public final class jsonMessageHandlerST implements EasyFlowGroupTemplate {

      private java.util.Set<Object> _states = new java.util.LinkedHashSet<>();
      private Object _name;

      private final ST template;

      private jsonMessageHandlerST(STGroup group) {
   		template = group.getInstanceOf("jsonMessageHandler");
   	}

      public jsonMessageHandlerST addStatesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._states.add(value);
      	template.add("states", value);

         return this;
      }

      public java.util.Set<Object> getStatesValues() {
      	return this._states;
      }

      public jsonMessageHandlerST setName(Object value) {
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

   public final class implST implements EasyFlowGroupTemplate {

      private Object _name;
      private Object _state;

      private final ST template;

      private implST(STGroup group) {
   		template = group.getInstanceOf("impl");
   	}

      public implST setName(Object value) {
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

      public implST setState(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._state == null) {
            this._state = value;
         	template.add("state", value);
         }

      	return this;
      }

      public String getState() {
      	return (String) this._state;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class statesST implements EasyFlowGroupTemplate {

      private java.util.Set<Object> _states = new java.util.LinkedHashSet<>();

      private final ST template;

      private statesST(STGroup group) {
   		template = group.getInstanceOf("states");
   	}

      public statesST addStatesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._states.add(value);
      	template.add("states", value);

         return this;
      }

      public java.util.Set<Object> getStatesValues() {
      	return this._states;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class easyFlowST implements EasyFlowGroupTemplate {

      private Object _context;
      private Object _events;
      private java.util.Set<java.util.Map<String, Object>> _bindings = new java.util.LinkedHashSet<>();
      private Object _extends;
      private Object _name;
      private Object _package;
      private Object _states;
      private java.util.Set<java.util.Map<String, Object>> _superParams = new java.util.LinkedHashSet<>();
      private Object _transit;
      private Object _isHandlingJsonMessages;
      private java.util.Set<Object> _imports = new java.util.LinkedHashSet<>();

      private final ST template;

      private easyFlowST(STGroup group) {
   		template = group.getInstanceOf("easyFlow");
   	}

      public easyFlowST setContext(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._context == null) {
            this._context = value;
         	template.add("context", value);
         }

      	return this;
      }

      public String getContext() {
      	return (String) this._context;
      }

      public easyFlowST setEvents(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._events == null) {
            this._events = value;
         	template.add("events", value);
         }

      	return this;
      }

      public String getEvents() {
      	return (String) this._events;
      }

      public easyFlowST addBindingsValue(Object declaration_, Object impl_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("declaration", (declaration_ == null || declaration_.toString().length() == 0) ? null : declaration_);
      	map.put("impl", (impl_ == null || impl_.toString().length() == 0) ? null : impl_);
      	this._bindings.add(map);

         template.addAggr("bindings.{declaration, impl}", map.get("declaration"), map.get("impl"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getBindings() {
      	return this._bindings;
      }

      public easyFlowST setExtends(Object value) {
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

      public easyFlowST setName(Object value) {
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

      public easyFlowST setPackage(Object value) {
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

      public easyFlowST setStates(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._states == null) {
            this._states = value;
         	template.add("states", value);
         }

      	return this;
      }

      public String getStates() {
      	return (String) this._states;
      }

      public easyFlowST addSuperParamsValue(Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._superParams.add(map);

         template.addAggr("superParams.{name, type}", map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getSuperParams() {
      	return this._superParams;
      }

      public easyFlowST setTransit(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._transit == null) {
            this._transit = value;
         	template.add("transit", value);
         }

      	return this;
      }

      public String getTransit() {
      	return (String) this._transit;
      }

      public easyFlowST setIsHandlingJsonMessages(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._isHandlingJsonMessages == null) {
            this._isHandlingJsonMessages = value;
         	template.add("isHandlingJsonMessages", value);
         }

      	return this;
      }

      public String getIsHandlingJsonMessages() {
      	return (String) this._isHandlingJsonMessages;
      }

      public easyFlowST addImportsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._imports.add(value);
      	template.add("imports", value);

         return this;
      }

      public java.util.Set<Object> getImportsValues() {
      	return this._imports;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvnST implements EasyFlowGroupTemplate {


      private final ST template;

      private mvnST(STGroup group) {
   		template = group.getInstanceOf("mvn");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class eventsST implements EasyFlowGroupTemplate {

      private java.util.Set<Object> _events = new java.util.LinkedHashSet<>();

      private final ST template;

      private eventsST(STGroup group) {
   		template = group.getInstanceOf("events");
   	}

      public eventsST addEventsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._events.add(value);
      	template.add("events", value);

         return this;
      }

      public java.util.Set<Object> getEventsValues() {
      	return this._events;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class declarationST implements EasyFlowGroupTemplate {

      private Object _name;
      private Object _state;

      private final ST template;

      private declarationST(STGroup group) {
   		template = group.getInstanceOf("declaration");
   	}

      public declarationST setName(Object value) {
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

      public declarationST setState(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._state == null) {
            this._state = value;
         	template.add("state", value);
         }

      	return this;
      }

      public String getState() {
      	return (String) this._state;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class stateDeclarationST implements EasyFlowGroupTemplate {

      private Object _comment;
      private Object _name;

      private final ST template;

      private stateDeclarationST(STGroup group) {
   		template = group.getInstanceOf("stateDeclaration");
   	}

      public stateDeclarationST setComment(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._comment == null) {
            this._comment = value;
         	template.add("comment", value);
         }

      	return this;
      }

      public String getComment() {
      	return (String) this._comment;
      }

      public stateDeclarationST setName(Object value) {
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

   public final class transitST implements EasyFlowGroupTemplate {

      private Object _event;
      private Object _isFinish;
      private Object _isInit;
      private Object _state;
      private java.util.Set<Object> _transits = new java.util.LinkedHashSet<>();

      private final ST template;

      private transitST(STGroup group) {
   		template = group.getInstanceOf("transit");
   	}

      public transitST setEvent(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._event == null) {
            this._event = value;
         	template.add("event", value);
         }

      	return this;
      }

      public String getEvent() {
      	return (String) this._event;
      }

      public transitST setIsFinish(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._isFinish == null) {
            this._isFinish = value;
         	template.add("isFinish", value);
         }

      	return this;
      }

      public String getIsFinish() {
      	return (String) this._isFinish;
      }

      public transitST setIsInit(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._isInit == null) {
            this._isInit = value;
         	template.add("isInit", value);
         }

      	return this;
      }

      public String getIsInit() {
      	return (String) this._isInit;
      }

      public transitST setState(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._state == null) {
            this._state = value;
         	template.add("state", value);
         }

      	return this;
      }

      public String getState() {
      	return (String) this._state;
      }

      public transitST addTransitsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._transits.add(value);
      	template.add("transits", value);

         return this;
      }

      public java.util.Set<Object> getTransitsValues() {
      	return this._transits;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "EasyFlowGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("statefulContext(contextGeneric,name,properties) ::= <<public static class ~name~~if(contextGeneric)~~contextGeneric~~endif~Context extends StatefulContext {\n" + 
		"    ~properties:{it|public ~if(it.modifier)~~it.modifier~ ~endif~~it.type~ ~it.name~~if(it.value)~ = ~it.value~~endif~;~if(it.comment)~ //~it.comment~~endif~};separator=\"\\n\"~\n" + 
		"}>>\n")
			.append("jsonMessageHandler(states,name) ::= <<// Json-message handler\n" + 
		"protected void handleMessage(~name~Context context, io.vertx.core.json.JsonObject message) {\n" + 
		"	log.info(\"message received in state \" + context.getState().name() + \" : \" + message.toString());\n" + 
		"\n" + 
		"   switch (States.valueOf(context.getState().name())) {\n" + 
		"		~states:{it|case ~it~:\n" + 
		"	handleMessageIn~it~State(context, message);\n" + 
		"	break;};separator=\"\\n\"~\n" + 
		"    }\n" + 
		"}\n" + 
		"\n" + 
		"~states:{it|protected void handleMessageIn~it~State(~name~Context context, io.vertx.core.json.JsonObject message) { log.info(\"ignoring \" + message.toString() + \" in ~it~ state\"); ~eom()~};separator=\"\\n\"~>>\n")
			.append("impl(name,state) ::= <<protected abstract void ~state;format=\"toLower\"~(final ~name~Context context) throws Exception;>>\n")
			.append("states(states) ::= <<public enum States implements StateEnum {\n" + 
		"    ~states:{it|~it~};separator=\",\\n\"~\n" + 
		"}>>\n")
			.append("easyFlow(context,events,bindings,extends,name,package,states,superParams,transit,isHandlingJsonMessages,imports) ::= <<package ~package~;\n" + 
		"\n" + 
		"import au.com.ds.ef.*;\n" + 
		"import au.com.ds.ef.call.ContextHandler;\n" + 
		"import au.com.ds.ef.call.StateHandler;\n" + 
		"import au.com.ds.ef.err.ExecutionError;\n" + 
		"\n" + 
		"import org.slf4j.Logger;\n" + 
		"import org.slf4j.LoggerFactory;\n" + 
		"\n" + 
		"import static au.com.ds.ef.FlowBuilder.*;\n" + 
		"~imports:{it|import ~it~;};separator=\"\\n\"~\n" + 
		"\n" + 
		"import static ~package~.~name~.States.*;\n" + 
		"import static ~package~.~name~.Events.*;\n" + 
		"\n" + 
		"/**\n" + 
		" * http://datasymphony.com.au/open-source/easyflow/\n" + 
		" */\n" + 
		"public abstract class ~name~ ~if(extends)~extends ~extends~ ~endif~{\n" + 
		"\n" + 
		"    protected static final Logger log = LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"    ~context~\n" + 
		"\n" + 
		"    ~states~\n" + 
		"\n" + 
		"    ~events~\n" + 
		"\n" + 
		"    /** ~name~Listener  **/\n" + 
		"    public interface ~name~Listener {\n" + 
		"        void onEnter(States state, ~name~Context context);\n" + 
		"        void onError(ExecutionError error, StatefulContext context);\n" + 
		"		  void onCompleted(~name~Context context);\n" + 
		"    }\n" + 
		"\n" + 
		"    private final EasyFlow<~name~Context> fsm;\n" + 
		"    protected ~name~Listener listener;\n" + 
		"\n" + 
		"    public ~name~(~superParams:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
		"        super(~superParams:{it|~it.name~};separator=\", \"~);\n" + 
		"\n" + 
		"        // states and transitions:\n" + 
		"        this.fsm = ~transit~;\n" + 
		"\n" + 
		"        // binding:\n" + 
		"        this.fsm\n" + 
		"            .executor(new SyncExecutor())\n" + 
		"            ~bindings:{it|~it.declaration~};separator=\"\\n\"~.\n" + 
		"            whenFinalState((StateHandler<~name~Context>) (stateEnum, context) -> {\n" + 
		"               log.info(\"completed\");\n" + 
		"					if (listener != null) listener.onCompleted(context);\n" + 
		"            }).\n" + 
		"				whenError((error, context) -> {\n" + 
		"					if (listener == null) log.error(\"ERROR in \" + context.getState() + \" : \" + error.getMessage(), error);\n" + 
		"               else listener.onError(error, context);\n" + 
		"               onERROR(error, (~name~Context) context);\n" + 
		"            });\n" + 
		"    }\n" + 
		"\n" + 
		"    public void start(final ~name~Context context) {\n" + 
		"        this.fsm.start(context);\n" + 
		"    }\n" + 
		"\n" + 
		"    public void start(final ~name~Context context, ~name~Listener listener) {\n" + 
		"        this.listener = listener;\n" + 
		"        this.fsm.start(context);\n" + 
		"    }\n" + 
		"\n" + 
		"    ~bindings:{it|~it.impl~};separator=\"\\n\"~\n" + 
		"\n" + 
		"    protected abstract void onERROR(final ExecutionError error, final ~name~Context context);\n" + 
		"\n" + 
		"	~if(isHandlingJsonMessages)~~isHandlingJsonMessages~~endif~\n" + 
		"\n" + 
		"}>>\n")
			.append("mvn() ::= <<<dependency>\n" + 
		"    <groupId>au.com.datasymphony</groupId>\n" + 
		"    <artifactId>EasyFlow</artifactId>\n" + 
		"    <version>1.3</version>\n" + 
		"<!-- test xx-->\n" + 
		"</dependency> >>\n")
			.append("events(events) ::= <<enum Events implements EventEnum {\n" + 
		"    ~events:{it|~it~};separator=\",\\n\"~\n" + 
		"}>>\n")
			.append("declaration(name,state) ::= <<.whenEnter(~state~, (ContextHandler<~name~Context>) context -> {\n" + 
		"	//log.debug(\"~state;format=\"humpToCap\"~\");\n" + 
		"   if (listener != null) listener.onEnter(~state~, context);\n" + 
		"   ~state;format=\"toLower\"~(context);\n" + 
		"})>>\n")
			.append("stateDeclaration(comment,name) ::= <<~name~~if(comment)~ /* ~comment~ */ ~endif~>>\n")
			.append("transit(event,isFinish,isInit,state,transits) ::= <<~if(isInit)~from(~state~)~else~on(~event~).~if(isFinish)~finish~else~to~endif~(~state~)~endif~~if(transits)~.transit(\n" + 
		"~transits:{it|~it~};separator=\",\\n\"~\n" + 
		")~endif~>>\n")
		.toString();
}