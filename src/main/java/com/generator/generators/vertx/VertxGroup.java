package com.generator.generators.vertx;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Vertx.stg' file<br/>
 */
public final class VertxGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public VertxGroup() {
		this(new STGroupString(stg));
   }

   public VertxGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public VertxGroup(java.io.File templateFile) {
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

	public interface VertxGroupTemplate {

	}

   public VerticleST newVerticle() {
      return new VerticleST(stGroup);
   }

   public RESTVerticleST newRESTVerticle() {
      return new RESTVerticleST(stGroup);
   }

   public APIST newAPI() {
      return new APIST(stGroup);
   }

   public socksJSHandlerST newsocksJSHandler() {
      return new socksJSHandlerST(stGroup);
   }

   public socksJSBridgeST newsocksJSBridge() {
      return new socksJSBridgeST(stGroup);
   }

   public BaseRouterVerticleST newBaseRouterVerticle() {
      return new BaseRouterVerticleST(stGroup);
   }

   public final class VerticleST implements VertxGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _incoming = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _outgoing = new java.util.LinkedHashSet<>();

      private final ST template;

      private VerticleST(STGroup group) {
   		template = group.getInstanceOf("Verticle");
   	}

      public VerticleST addIncomingValue(Object address_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._incoming.add(map);

         template.addAggr("incoming.{address, name}", map.get("address"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getIncoming() {
      	return this._incoming;
      }

      public VerticleST setName(Object value) {
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

      public VerticleST setPackage(Object value) {
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

      public VerticleST addOutgoingValue(Object name_, Object address_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	this._outgoing.add(map);

         template.addAggr("outgoing.{name, address}", map.get("name"), map.get("address"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getOutgoing() {
      	return this._outgoing;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class RESTVerticleST implements VertxGroupTemplate {

      private Object _name;
      private Object _packageName;
      private java.util.Set<java.util.Map<String, Object>> _endpoints = new java.util.LinkedHashSet<>();

      private final ST template;

      private RESTVerticleST(STGroup group) {
   		template = group.getInstanceOf("RESTVerticle");
   	}

      public RESTVerticleST setName(Object value) {
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

      public RESTVerticleST setPackageName(Object value) {
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

      public RESTVerticleST addEndpointsValue(Object name_, Object uri_, Object action_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("uri", (uri_ == null || uri_.toString().length() == 0) ? null : uri_);
      	map.put("action", (action_ == null || action_.toString().length() == 0) ? null : action_);
      	this._endpoints.add(map);

         template.addAggr("endpoints.{name, uri, action}", map.get("name"), map.get("uri"), map.get("action"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEndpoints() {
      	return this._endpoints;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class APIST implements VertxGroupTemplate {


      private final ST template;

      private APIST(STGroup group) {
   		template = group.getInstanceOf("API");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class socksJSHandlerST implements VertxGroupTemplate {

      private Object _route;

      private final ST template;

      private socksJSHandlerST(STGroup group) {
   		template = group.getInstanceOf("socksJSHandler");
   	}

      public socksJSHandlerST setRoute(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._route == null) {
            this._route = value;
         	template.add("route", value);
         }

      	return this;
      }

      public String getRoute() {
      	return (String) this._route;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class socksJSBridgeST implements VertxGroupTemplate {

      private java.util.Set<Object> _inbound = new java.util.LinkedHashSet<>();
      private java.util.Set<Object> _outbound = new java.util.LinkedHashSet<>();
      private Object _route;

      private final ST template;

      private socksJSBridgeST(STGroup group) {
   		template = group.getInstanceOf("socksJSBridge");
   	}

      public socksJSBridgeST addInboundValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._inbound.add(value);
      	template.add("inbound", value);

         return this;
      }

      public java.util.Set<Object> getInboundValues() {
      	return this._inbound;
      }

      public socksJSBridgeST addOutboundValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._outbound.add(value);
      	template.add("outbound", value);

         return this;
      }

      public java.util.Set<Object> getOutboundValues() {
      	return this._outbound;
      }

      public socksJSBridgeST setRoute(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._route == null) {
            this._route = value;
         	template.add("route", value);
         }

      	return this;
      }

      public String getRoute() {
      	return (String) this._route;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class BaseRouterVerticleST implements VertxGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _endpoints = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;
      private Object _comments;
      private java.util.Set<java.util.Map<String, Object>> _messageHandlers = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _publishMessages = new java.util.LinkedHashSet<>();

      private final ST template;

      private BaseRouterVerticleST(STGroup group) {
   		template = group.getInstanceOf("BaseRouterVerticle");
   	}

      public BaseRouterVerticleST addEndpointsValue(Object action_, Object name_, Object uri_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("action", (action_ == null || action_.toString().length() == 0) ? null : action_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("uri", (uri_ == null || uri_.toString().length() == 0) ? null : uri_);
      	this._endpoints.add(map);

         template.addAggr("endpoints.{action, name, uri}", map.get("action"), map.get("name"), map.get("uri"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEndpoints() {
      	return this._endpoints;
      }

      public BaseRouterVerticleST setName(Object value) {
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

      public BaseRouterVerticleST setPackageName(Object value) {
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

      public BaseRouterVerticleST setComments(Object value) {
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

      public BaseRouterVerticleST addMessageHandlersValue(Object name_, Object type_, Object address_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	this._messageHandlers.add(map);

         template.addAggr("messageHandlers.{name, type, address}", map.get("name"), map.get("type"), map.get("address"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getMessageHandlers() {
      	return this._messageHandlers;
      }

      public BaseRouterVerticleST addPublishMessagesValue(Object address_, Object name_, Object type_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("type", (type_ == null || type_.toString().length() == 0) ? null : type_);
      	this._publishMessages.add(map);

         template.addAggr("publishMessages.{address, name, type}", map.get("address"), map.get("name"), map.get("type"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getPublishMessages() {
      	return this._publishMessages;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "VertxGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("Verticle(incoming,name,package,outgoing) ::= <<package ~package~;\n" + 
		"\n" + 
		"import com.generator.util.VertxUtil;\n" + 
		"\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"public class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"   protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(~name~.class);\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public void start(Future<Void> startFuture) throws Exception {\n" + 
		"      log.info(\"starting ~name~\");\n" + 
		"\n" + 
		"		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {\n" + 
		"			@Override\n" + 
		"			public JsonObject execute() throws Throwable {\n" + 
		"				return onStart();\n" + 
		"			}\n" + 
		"\n" + 
		"			@Override\n" + 
		"			public void onSuccess(JsonObject result) {\n" + 
		"				log.info(\"started ~name~ successfully : \" + result.toString());\n" + 
		"				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject~gt()~>) message -> handleInstanceMessage(message));\n" + 
		"				~incoming:{it| vertx.eventBus().consumer(\"~it.address~\", (Handler<Message<JsonObject~gt()~>) message -> handle~it.name~(message)); };separator=\"\\n\"~\n" + 
		"				startFuture.complete();\n" + 
		"			}\n" + 
		"\n" + 
		"			@Override\n" + 
		"			public void onFail(Throwable t) {\n" + 
		"				log.error(\"failed to start ~name~ : \", t);\n" + 
		"				startFuture.fail(t);\n" + 
		"			}\n" + 
		"		});\n" + 
		"	}\n" + 
		"\n" + 
		"	protected JsonObject onStart() throws Exception { return new JsonObject(); } \n" + 
		"	\n" + 
		"	~outgoing:{it|protected void publishTo~it.name~(JsonObject jsonObject) { log.info(\"publish to ~it.address~ \" + jsonObject.toString()); vertx.eventBus().publish(\"~it.address~\", jsonObject); ~eom()~};separator=\"\\n\"~\n" + 
		"\n" + 
		"	~incoming:{it|protected void handle~it.name~(Message<JsonObject> message) { log.info(\"handle message ~it.address~ \" + message.body().toString()); ~eom()~ };separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected void handleInstanceMessage(Message<JsonObject> message) { log.info(\"handle instance message \" + deploymentID() + \" \" + message.body().toString()); }\n" + 
		"}>>\n")
			.append("RESTVerticle(name,packageName,endpoints) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.http.HttpServerResponse;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import io.vertx.ext.web.Router;\n" + 
		"import io.vertx.ext.web.RoutingContext;\n" + 
		"import io.vertx.ext.web.handler.BodyHandler;\n" + 
		"\n" + 
		"public class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"  protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"  @Override\n" + 
		"  public void start() {\n" + 
		"\n" + 
		"    setUpInitialData();\n" + 
		"\n" + 
		"    Router router = Router.router(vertx);\n" + 
		"\n" + 
		"    router.route().handler(BodyHandler.create());\n" + 
		"    ~endpoints:{it|router.~it.action;format=\"toLower\"~(\"~it.uri~\").handler(this::handle~it.name;format=\"capitalize\"~);};separator=\"\\n\"~\n" + 
		"\n" + 
		"    vertx.createHttpServer().requestHandler(router::accept).listen(8080);\n" + 
		"  }\n" + 
		"\n" + 
		"	~endpoints:{it|\n" + 
		"	protected void handle~it.name;format=\"capitalize\"~(RoutingContext routingContext) {\n" + 
		"		log.info(\"handle~it.name~ \" + routingContext.getBodyAsString());\n" + 
		"		\n" + 
		"	~eom()~\n" + 
		"	};separator=\"\\n\"~\n" + 
		"\n" + 
		"  protected void setUpInitialData() {\n" + 
		"  }\n" + 
		"}>>\n")
			.append("API() ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.ud.vertx.VertxUtil;\n" + 
		"import com.ud.vertx.VertxWebUtil;\n" + 
		"import io.netty.handler.codec.http.HttpResponseStatus;\n" + 
		"import io.vertx.core.AsyncResult;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.Vertx;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import io.vertx.ext.web.Router;\n" + 
		"import io.vertx.ext.web.RoutingContext;\n" + 
		"import org.neo4j.graphdb.Node;\n" + 
		"import org.slf4j.Logger;\n" + 
		"import org.slf4j.LoggerFactory;\n" + 
		"\n" + 
		"import java.util.Set;\n" + 
		"\n" + 
		"import static com.ud.bk.api.VersionAPI.VISITORS.version;\n" + 
		"import static com.ud.vertx.JsonUtil.newJsonObject;\n" + 
		"import static com.ud.vertx.VertxWebUtil.*;\n" + 
		"import static com.ud.vertx.VertxWebUtil.newErrorResponse;\n" + 
		"import static io.netty.handler.codec.http.HttpResponseStatus.*;\n" + 
		"import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;\n" + 
		"\n" + 
		"/**\n" + 
		" * Generated\n" + 
		" * ~comments~\n" + 
		" */\n" + 
		"public abstract class ~name~ {\n" + 
		"\n" + 
		"	protected static final Logger log = LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"	public enum VISITORS {\n" + 
		"		~visitors:{it|~it.name~};separator=\", \"~\n" + 
		"	}\n" + 
		"\n" + 
		"	public enum ENTITIES {\n" + 
		"		~entities:{it|~it~};separator=\", \"~\n" + 
		"	}\n" + 
		"\n" + 
		"	public enum PROPERTIES {\n" + 
		"		~properties:{it|~it~};separator=\", \"~\n" + 
		"	}\n" + 
		"\n" + 
		"	public static void attach(Router router, Vertx vertx, JsonObject config) {\n" + 
		"~visitors:{it|\n" + 
		"		router.~it.action~(\"~it.route~\").handler(routingContext -> {\n" + 
		"\n" + 
		"         logRequest(log, routingContext);\n" + 
		"\n" + 
		"         final JsonArray errors = new JsonArray();\n" + 
		"         final JsonObject data = newJsonObject();\n" + 
		"\n" + 
		"         // handleRequest(data, errors, routingContext);\n" + 
		"         verifyRequiredStringParam(data, version.name(), routingContext, errors);\n" + 
		"\n" + 
		"         if (!errors.isEmpty()) {\n" + 
		"            newErrorResponse(routingContext, BAD_REQUEST, null, errors);\n" + 
		"            return;\n" + 
		"         ~eom()~\n" + 
		"\n" + 
		"         VertxUtil.sendMessage(vertx, \"NEO.VISIT\", new JsonObject().\n" + 
		"                     put(\"api\", \"~name~\").\n" + 
		"                     put(\"visitor\", ~it.name~.name()).\n" + 
		"                     put(\"params\", data), log,\n" + 
		"\n" + 
		"               new VertxUtil.SuccessHandler<Message<JsonObject>~gt()~() {\n" + 
		"                  @Override\n" + 
		"                  public void onSuccess(AsyncResult<Message<JsonObject~gt()~> result) {\n" + 
		"                     final JsonObject body = result.result().body();\n" + 
		"                     final HttpResponseStatus status = valueOf(getStatus(body));\n" + 
		"\n" + 
		"                     if (OK.equals(status)) {\n" + 
		"                        newJsonResponse(routingContext, OK, body.getJsonObject(\"content\"));\n" + 
		"                     ~eom()~ else {\n" + 
		"                        newErrorResponse(routingContext, status, body.getString(\"message\"), body.getJsonArray(\"details\"));\n" + 
		"                     ~eom()~\n" + 
		"                  ~eom()~\n" + 
		"\n" + 
		"                  @Override\n" + 
		"                  public void onFail(AsyncResult<Message<JsonObject~gt()~> result) {\n" + 
		"                     final Throwable cause = result.cause();\n" + 
		"                     if (cause != null) {\n" + 
		"                        newErrorResponse(routingContext, INTERNAL_SERVER_ERROR, cause.getMessage());\n" + 
		"                     ~eom()~ else {\n" + 
		"                        newErrorResponse(routingContext, INTERNAL_SERVER_ERROR, \"Error\");\n" + 
		"                     ~eom()~\n" + 
		"                  ~eom()~\n" + 
		"               ~eom()~);\n" + 
		"      ~eom()~);\n" + 
		"};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"}>>\n")
			.append("socksJSHandler(route) ::= <<// options\n" + 
		"io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions options = new io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions().\n" + 
		"    setHeartbeatInterval(2000);\n" + 
		"\n" + 
		"BridgeOptions bridgeOptions = new BridgeOptions();\n" + 
		"sockJSHandler.bridge(bridgeOptions);\n" + 
		"\n" + 
		"io.vertx.ext.web.handler.sockjs.SockJSHandler sockJSHandler = io.vertx.ext.web.handler.sockjs.SockJSHandler.\n" + 
		"    create(vertx, bridgeOptions);\n" + 
		"\n" + 
		"router.route(\"~route~\").handler(sockJSHandler);>>\n")
			.append("socksJSBridge(inbound,outbound,route) ::= <<final BridgeOptions bridgeOptions = new BridgeOptions()\n" + 
		"    ~outbound:{it|.addOutboundPermitted(new PermittedOptions().setAddress(\"~it~\"))};separator=\"\\n\"~\n" + 
		"    ~inbound:{it|.addInboundPermitted(new PermittedOptions().setAddress(\"~it~\"))};separator=\"\\n\"~;\n" + 
		"\n" + 
		"router.route(\"~route~\").handler(SockJSHandler.create(vertx).bridge(bridgeOptions, event -> {\n" + 
		"\n" + 
		"  // You can also optionally provide a handler like this which will be passed any events that occur on the bridge\n" + 
		"  // You can use this for monitoring or logging, or to change the raw messages in-flight.\n" + 
		"  // It can also be used for fine grained access control.\n" + 
		"\n" + 
		"  if (event.type() == BridgeEvent.Type.SOCKET_CREATED) {\n" + 
		"    System.out.println(\"A socket was created\");\n" + 
		"  }\n" + 
		"\n" + 
		"  // This signals that it's ok to process the event\n" + 
		"  event.complete(true);\n" + 
		"}));>>\n")
			.append("BaseRouterVerticle(endpoints,name,packageName,comments,messageHandlers,publishMessages) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.http.HttpServerOptions;\n" + 
		"import io.vertx.ext.web.Router;\n" + 
		"import io.vertx.ext.web.RoutingContext;\n" + 
		"import io.vertx.ext.web.handler.BodyHandler;\n" + 
		"import io.vertx.ext.web.handler.StaticHandler;\n" + 
		"import org.slf4j.Logger;\n" + 
		"import org.slf4j.LoggerFactory;\n" + 
		"~if(messageHandlers)~\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.eventbus.Message;~endif~\n" + 
		"\n" + 
		"import java.util.Map;\n" + 
		"\n" + 
		"import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;\n" + 
		"\n" + 
		"/**\n" + 
		" * Generated\n" + 
		" * ~comments~\n" + 
		" */\n" + 
		"public abstract class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"	protected static final Logger log = LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public void start(Future<Void> startFuture) throws Exception {\n" + 
		"      log.info(\"Starting ~name~ using config \" + config().encode());\n" + 
		"\n" + 
		"      final Router router = Router.router(vertx);\n" + 
		"      router.route().handler(BodyHandler.create());\n" + 
		"\n" + 
		"~endpoints:{it|\n" + 
		"      router.~it.action~(\"~it.uri~\").handler(routingContext -> {\n" + 
		"         log.debug(debug(routingContext));\n" + 
		"         on~it.name;format=\"capitalize\"~(routingContext);\n" + 
		"		~eom()~);\n" + 
		"};separator=\"\\n\"~\n" + 
		"~messageHandlers:{it|\n" + 
		"		vertx.eventBus().consumer(\"~it.address~\", (Handler<Message<~it.type~>~gt()~) message -> {\n" + 
		"		   log.debug(message.address() + \" -> \" + message.body());\n" + 
		"         on~it.name;format=\"capitalize\"~(message);\n" + 
		"      ~eom()~);\n" + 
		"};separator=\"\\n\"~\n" + 
		"      router.route().handler(StaticHandler.create().\n" + 
		"            setWebRoot(config().getString(\"web.root\")).\n" + 
		"            setIndexPage(\"/index.html\"));\n" + 
		"\n" + 
		"      // fallback handler (400 - BAD REQUEST)\n" + 
		"      router.route().last().handler(routingContext -> routingContext.put(BAD_REQUEST.reasonPhrase(), routingContext.request().path()).\n" + 
		"            fail(BAD_REQUEST.code()));\n" + 
		"\n" + 
		"      vertx.createHttpServer(new HttpServerOptions()).\n" + 
		"            requestHandler(router::accept).\n" + 
		"            listen(config().getInteger(\"content.port\"));\n" + 
		"\n" + 
		"      startFuture.complete();\n" + 
		"   }\n" + 
		"\n" + 
		"   ~endpoints:{it|protected abstract void on~it.name;format=\"capitalize\"~(RoutingContext routingContext);};separator=\"\\n\"~\n" + 
		"\n" + 
		"   ~messageHandlers:{it|protected abstract void on~it.name;format=\"capitalize\"~(Message<~it.type~> message);};separator=\"\\n\"~\n" + 
		"~publishMessages:{it|\n" + 
		"\n" + 
		"	protected void publish~it.name;format=\"capitalize\"~(~it.type~ content) {\n" + 
		"      vertx.eventBus().publish(\"~it.address~\", content);\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"   protected static String debug(RoutingContext request) {\n" + 
		"      final StringBuilder out = new StringBuilder();\n" + 
		"      for (Map.Entry<String, String> param : request.request().params())\n" + 
		"         out.append(param.getKey()).append(\"=\").append(param.getValue()).append(\"\\n\");\n" + 
		"      return request.request().uri() + \" \" + out.toString().trim();\n" + 
		"   }\n" + 
		"}>>\n")
		.toString();
}