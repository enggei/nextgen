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

   public socksJSBridgeST newsocksJSBridge() {
      return new socksJSBridgeST(stGroup);
   } 

   public socksJSHandlerST newsocksJSHandler() {
      return new socksJSHandlerST(stGroup);
   } 

   public BaseVerticleST newBaseVerticle() {
      return new BaseVerticleST(stGroup);
   } 

   public final class socksJSBridgeST implements VertxGroupTemplate {

      private final AtomicBoolean inboundIsSet = new AtomicBoolean(false);
      private final AtomicBoolean outboundIsSet = new AtomicBoolean(false);
      private final AtomicBoolean routeIsSet = new AtomicBoolean(false);
      private final ST template;

      private socksJSBridgeST(STGroup group) {
   		template = group.getInstanceOf("socksJSBridge");
   	}

      public socksJSBridgeST addInboundValue(Object value) {
      	tryToSetListProperty(template, value, inboundIsSet, "inbound");
         return this;
      } 
      public socksJSBridgeST addOutboundValue(Object value) {
      	tryToSetListProperty(template, value, outboundIsSet, "outbound");
         return this;
      } 
      public socksJSBridgeST setRoute(Object value) {
      	tryToSetStringProperty(template, value, routeIsSet, "route");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class socksJSHandlerST implements VertxGroupTemplate {

      private final AtomicBoolean routeIsSet = new AtomicBoolean(false);
      private final ST template;

      private socksJSHandlerST(STGroup group) {
   		template = group.getInstanceOf("socksJSHandler");
   	}

      public socksJSHandlerST setRoute(Object value) {
      	tryToSetStringProperty(template, value, routeIsSet, "route");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class BaseVerticleST implements VertxGroupTemplate {

      private final AtomicBoolean endpointsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean packageNameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean commentsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean messageHandlersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean publishMessagesIsSet = new AtomicBoolean(false);
      private final ST template;

      private BaseVerticleST(STGroup group) {
   		template = group.getInstanceOf("BaseVerticle");
   	}

      public BaseVerticleST addEndpointsValue(Object action_, Object name_, Object uri_) {
         endpointsIsSet.set(true);
         template.addAggr("endpoints.{action, name, uri}", ( (action_==null || action_.toString().length()==0) ? null : action_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (uri_==null || uri_.toString().length()==0) ? null : uri_));
         return this;
      } 
      public BaseVerticleST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public BaseVerticleST setPackageName(Object value) {
      	tryToSetStringProperty(template, value, packageNameIsSet, "packageName");   
         return this;
      } 
      public BaseVerticleST setComments(Object value) {
      	tryToSetStringProperty(template, value, commentsIsSet, "comments");   
         return this;
      } 
      public BaseVerticleST addMessageHandlersValue(Object name_, Object type_, Object address_) {
         messageHandlersIsSet.set(true);
         template.addAggr("messageHandlers.{name, type, address}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (address_==null || address_.toString().length()==0) ? null : address_));
         return this;
      } 
      public BaseVerticleST addPublishMessagesValue(Object address_, Object name_, Object type_) {
         publishMessagesIsSet.set(true);
         template.addAggr("publishMessages.{address, name, type}", ( (address_==null || address_.toString().length()==0) ? null : address_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

	static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (alreadySet.get()) return;
		if (value == null || value.toString().length() == 0) return;
		alreadySet.set(true);
		template.add(name, value);
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

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
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
	"})); >>\n")
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
	"router.route(\"~route~\").handler(sockJSHandler); >>\n")
		.append("BaseVerticle(endpoints,name,packageName,comments,messageHandlers,publishMessages) ::= <<package ~packageName~;\n" + 
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
	"} >>\n").toString();
} 