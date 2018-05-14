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

   public NeoVerticleST newNeoVerticle() {
      return new NeoVerticleST(stGroup);
   }

   public ServerST newServer() {
      return new ServerST(stGroup);
   }

   public VerticleST newVerticle() {
      return new VerticleST(stGroup);
   }

   public RESTVerticleST newRESTVerticle() {
      return new RESTVerticleST(stGroup);
   }

   public VerticleTestST newVerticleTest() {
      return new VerticleTestST(stGroup);
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

   public mvn_coreST newmvn_core() {
      return new mvn_coreST(stGroup);
   }

   public VertxUtilST newVertxUtil() {
      return new VertxUtilST(stGroup);
   }

   public DockerST newDocker() {
      return new DockerST(stGroup);
   }

   public mvn_unitST newmvn_unit() {
      return new mvn_unitST(stGroup);
   }

   public JsonUtilST newJsonUtil() {
      return new JsonUtilST(stGroup);
   }

   public mvn_fat_jarST newmvn_fat_jar() {
      return new mvn_fat_jarST(stGroup);
   }

   public mvn_hazelcastST newmvn_hazelcast() {
      return new mvn_hazelcastST(stGroup);
   }

   public hazelcastConfigXMLST newhazelcastConfigXML() {
      return new hazelcastConfigXMLST(stGroup);
   }

   public ResponseUtilST newResponseUtil() {
      return new ResponseUtilST(stGroup);
   }

   public mvn_eventbus_bridgeST newmvn_eventbus_bridge() {
      return new mvn_eventbus_bridgeST(stGroup);
   }

   public mvn_webST newmvn_web() {
      return new mvn_webST(stGroup);
   }

   public mvn_webClientST newmvn_webClient() {
      return new mvn_webClientST(stGroup);
   }

   public final class NeoVerticleST implements VertxGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _actions = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _packageName;
      private Object _vertxUtilPackage;

      private final ST template;

      private NeoVerticleST(STGroup group) {
   		template = group.getInstanceOf("NeoVerticle");
   	}

      public NeoVerticleST addActionsValue(Object address_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._actions.add(map);

         template.addAggr("actions.{address, name}", map.get("address"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getActions() {
      	return this._actions;
      }

      public NeoVerticleST setName(Object value) {
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

      public NeoVerticleST setPackageName(Object value) {
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

      public NeoVerticleST setVertxUtilPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._vertxUtilPackage == null) {
            this._vertxUtilPackage = value;
         	template.add("vertxUtilPackage", value);
         }

      	return this;
      }

      public String getVertxUtilPackage() {
      	return (String) this._vertxUtilPackage;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ServerST implements VertxGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _inbound = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _outbound = new java.util.LinkedHashSet<>();
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _routes = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _verticles = new java.util.LinkedHashSet<>();
      private Object _vertxUtilPackage;

      private final ST template;

      private ServerST(STGroup group) {
   		template = group.getInstanceOf("Server");
   	}

      public ServerST addInboundValue(Object address_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	this._inbound.add(map);

         template.addAggr("inbound.{address}", map.get("address"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getInbound() {
      	return this._inbound;
      }

      public ServerST setName(Object value) {
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

      public ServerST addOutboundValue(Object address_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	this._outbound.add(map);

         template.addAggr("outbound.{address}", map.get("address"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getOutbound() {
      	return this._outbound;
      }

      public ServerST setPackage(Object value) {
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

      public ServerST addRoutesValue(Object url_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("url", (url_ == null || url_.toString().length() == 0) ? null : url_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._routes.add(map);

         template.addAggr("routes.{url, name}", map.get("url"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getRoutes() {
      	return this._routes;
      }

      public ServerST addVerticlesValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._verticles.add(map);

         template.addAggr("verticles.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getVerticles() {
      	return this._verticles;
      }

      public ServerST setVertxUtilPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._vertxUtilPackage == null) {
            this._vertxUtilPackage = value;
         	template.add("vertxUtilPackage", value);
         }

      	return this;
      }

      public String getVertxUtilPackage() {
      	return (String) this._vertxUtilPackage;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class VerticleST implements VertxGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _incoming = new java.util.LinkedHashSet<>();
      private Object _name;
      private Object _package;
      private java.util.Set<java.util.Map<String, Object>> _outgoing = new java.util.LinkedHashSet<>();
      private Object _vertxUtilPackage;
      private Object _implementation;
      private Object _hazelcastConfig;

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

      public VerticleST setVertxUtilPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._vertxUtilPackage == null) {
            this._vertxUtilPackage = value;
         	template.add("vertxUtilPackage", value);
         }

      	return this;
      }

      public String getVertxUtilPackage() {
      	return (String) this._vertxUtilPackage;
      }

      public VerticleST setImplementation(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._implementation == null) {
            this._implementation = value;
         	template.add("implementation", value);
         }

      	return this;
      }

      public String getImplementation() {
      	return (String) this._implementation;
      }

      public VerticleST setHazelcastConfig(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._hazelcastConfig == null) {
            this._hazelcastConfig = value;
         	template.add("hazelcastConfig", value);
         }

      	return this;
      }

      public String getHazelcastConfig() {
      	return (String) this._hazelcastConfig;
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
      private java.util.Set<java.util.Map<String, Object>> _events = new java.util.LinkedHashSet<>();

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

      public RESTVerticleST addEndpointsValue(Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._endpoints.add(map);

         template.addAggr("endpoints.{name}", map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEndpoints() {
      	return this._endpoints;
      }

      public RESTVerticleST addEventsValue(Object comments_, Object address_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("comments", (comments_ == null || comments_.toString().length() == 0) ? null : comments_);
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._events.add(map);

         template.addAggr("events.{comments, address, name}", map.get("comments"), map.get("address"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getEvents() {
      	return this._events;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class VerticleTestST implements VertxGroupTemplate {

      private Object _name;
      private Object _verticle;
      private Object _packageName;
      private java.util.Set<java.util.Map<String, Object>> _outgoing = new java.util.LinkedHashSet<>();
      private Object _vertxUtilPackage;
      private java.util.Set<java.util.Map<String, Object>> _incoming = new java.util.LinkedHashSet<>();

      private final ST template;

      private VerticleTestST(STGroup group) {
   		template = group.getInstanceOf("VerticleTest");
   	}

      public VerticleTestST setName(Object value) {
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

      public VerticleTestST setVerticle(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._verticle == null) {
            this._verticle = value;
         	template.add("verticle", value);
         }

      	return this;
      }

      public String getVerticle() {
      	return (String) this._verticle;
      }

      public VerticleTestST setPackageName(Object value) {
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

      public VerticleTestST addOutgoingValue(Object address_, Object name_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("address", (address_ == null || address_.toString().length() == 0) ? null : address_);
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	this._outgoing.add(map);

         template.addAggr("outgoing.{address, name}", map.get("address"), map.get("name"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getOutgoing() {
      	return this._outgoing;
      }

      public VerticleTestST setVertxUtilPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._vertxUtilPackage == null) {
            this._vertxUtilPackage = value;
         	template.add("vertxUtilPackage", value);
         }

      	return this;
      }

      public String getVertxUtilPackage() {
      	return (String) this._vertxUtilPackage;
      }

      public VerticleTestST addIncomingValue(Object address_, Object name_) {
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

   public final class mvn_coreST implements VertxGroupTemplate {


      private final ST template;

      private mvn_coreST(STGroup group) {
   		template = group.getInstanceOf("mvn_core");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class VertxUtilST implements VertxGroupTemplate {

      private Object _packageName;
      private Object _tcpEventbus;

      private final ST template;

      private VertxUtilST(STGroup group) {
   		template = group.getInstanceOf("VertxUtil");
   	}

      public VertxUtilST setPackageName(Object value) {
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

      public VertxUtilST setTcpEventbus(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._tcpEventbus == null) {
            this._tcpEventbus = value;
         	template.add("tcpEventbus", value);
         }

      	return this;
      }

      public String getTcpEventbus() {
      	return (String) this._tcpEventbus;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class DockerST implements VertxGroupTemplate {

      private Object _exposePort;
      private Object _verticleFile;
      private Object _verticleHome;
      private Object _verticleName;
      private java.util.Set<java.util.Map<String, Object>> _vertxOptions = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _javaOptions = new java.util.LinkedHashSet<>();
      private java.util.Set<java.util.Map<String, Object>> _copies = new java.util.LinkedHashSet<>();
      private Object _cluster;

      private final ST template;

      private DockerST(STGroup group) {
   		template = group.getInstanceOf("Docker");
   	}

      public DockerST setExposePort(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._exposePort == null) {
            this._exposePort = value;
         	template.add("exposePort", value);
         }

      	return this;
      }

      public String getExposePort() {
      	return (String) this._exposePort;
      }

      public DockerST setVerticleFile(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._verticleFile == null) {
            this._verticleFile = value;
         	template.add("verticleFile", value);
         }

      	return this;
      }

      public String getVerticleFile() {
      	return (String) this._verticleFile;
      }

      public DockerST setVerticleHome(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._verticleHome == null) {
            this._verticleHome = value;
         	template.add("verticleHome", value);
         }

      	return this;
      }

      public String getVerticleHome() {
      	return (String) this._verticleHome;
      }

      public DockerST setVerticleName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._verticleName == null) {
            this._verticleName = value;
         	template.add("verticleName", value);
         }

      	return this;
      }

      public String getVerticleName() {
      	return (String) this._verticleName;
      }

      public DockerST addVertxOptionsValue(Object key_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("key", (key_ == null || key_.toString().length() == 0) ? null : key_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._vertxOptions.add(map);

         template.addAggr("vertxOptions.{key, value}", map.get("key"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getVertxOptions() {
      	return this._vertxOptions;
      }

      public DockerST addJavaOptionsValue(Object key_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("key", (key_ == null || key_.toString().length() == 0) ? null : key_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._javaOptions.add(map);

         template.addAggr("javaOptions.{key, value}", map.get("key"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getJavaOptions() {
      	return this._javaOptions;
      }

      public DockerST addCopiesValue(Object filename_, Object src_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("filename", (filename_ == null || filename_.toString().length() == 0) ? null : filename_);
      	map.put("src", (src_ == null || src_.toString().length() == 0) ? null : src_);
      	this._copies.add(map);

         template.addAggr("copies.{filename, src}", map.get("filename"), map.get("src"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getCopies() {
      	return this._copies;
      }

      public DockerST setCluster(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._cluster == null) {
            this._cluster = value;
         	template.add("cluster", value);
         }

      	return this;
      }

      public String getCluster() {
      	return (String) this._cluster;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_unitST implements VertxGroupTemplate {


      private final ST template;

      private mvn_unitST(STGroup group) {
   		template = group.getInstanceOf("mvn_unit");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class JsonUtilST implements VertxGroupTemplate {

      private Object _packageName;

      private final ST template;

      private JsonUtilST(STGroup group) {
   		template = group.getInstanceOf("JsonUtil");
   	}

      public JsonUtilST setPackageName(Object value) {
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

   public final class mvn_fat_jarST implements VertxGroupTemplate {

      private Object _mainClass;

      private final ST template;

      private mvn_fat_jarST(STGroup group) {
   		template = group.getInstanceOf("mvn_fat_jar");
   	}

      public mvn_fat_jarST setMainClass(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._mainClass == null) {
            this._mainClass = value;
         	template.add("mainClass", value);
         }

      	return this;
      }

      public String getMainClass() {
      	return (String) this._mainClass;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_hazelcastST implements VertxGroupTemplate {


      private final ST template;

      private mvn_hazelcastST(STGroup group) {
   		template = group.getInstanceOf("mvn_hazelcast");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class hazelcastConfigXMLST implements VertxGroupTemplate {


      private final ST template;

      private hazelcastConfigXMLST(STGroup group) {
   		template = group.getInstanceOf("hazelcastConfigXML");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ResponseUtilST implements VertxGroupTemplate {

      private Object _packageName;

      private final ST template;

      private ResponseUtilST(STGroup group) {
   		template = group.getInstanceOf("ResponseUtil");
   	}

      public ResponseUtilST setPackageName(Object value) {
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

   public final class mvn_eventbus_bridgeST implements VertxGroupTemplate {

      private Object _version;

      private final ST template;

      private mvn_eventbus_bridgeST(STGroup group) {
   		template = group.getInstanceOf("mvn_eventbus_bridge");
   	}

      public mvn_eventbus_bridgeST setVersion(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_webST implements VertxGroupTemplate {

      private Object _version;

      private final ST template;

      private mvn_webST(STGroup group) {
   		template = group.getInstanceOf("mvn_web");
   	}

      public mvn_webST setVersion(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class mvn_webClientST implements VertxGroupTemplate {

      private Object _version;

      private final ST template;

      private mvn_webClientST(STGroup group) {
   		template = group.getInstanceOf("mvn_webClient");
   	}

      public mvn_webClientST setVersion(Object value) {
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
			.append("NeoVerticle(actions,name,packageName,vertxUtilPackage) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.VertxUtil;\n" + 
		"import ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.ResponseUtil;\n" + 
		"\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import org.neo4j.graphdb.GraphDatabaseService;\n" + 
		"import org.neo4j.graphdb.Transaction;\n" + 
		"import org.neo4j.graphdb.factory.GraphDatabaseFactory;\n" + 
		"import org.neo4j.graphdb.factory.GraphDatabaseSettings;\n" + 
		"\n" + 
		"import java.io.File;\n" + 
		"\n" + 
		"import static ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.VertxUtil.executeBlocking;\n" + 
		"\n" + 
		"public abstract class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"  	protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"	protected GraphDatabaseService db;\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public void start(Future<Void> startFuture) {\n" + 
		"\n" + 
		"		executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onSuccess(JsonObject result) {\n" + 
		"            log.info(\"~name~ started: \" + result.encode());\n" + 
		"            startFuture.complete();\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onFail(Throwable t) {\n" + 
		"            log.error(\"~name~ failed: \" + t.getMessage());\n" + 
		"            startFuture.fail(t);\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public JsonObject execute() {\n" + 
		"\n" + 
		"				final String path = config().getString(\"path\");\n" + 
		"            log.info(\"Starting db at \" + path);\n" + 
		"            \n" + 
		"            if (path == null || path.length() == 0)\n" + 
		"            	throw new IllegalArgumentException(\"missing 'path' config parameter\");\n" + 
		"\n" + 
		"            db = new GraphDatabaseFactory().\n" + 
		"                  newEmbeddedDatabaseBuilder(new File(path)).\n" + 
		"                  setConfig(GraphDatabaseSettings.allow_upgrade, \"true\").\n" + 
		"                  newGraphDatabase();\n" + 
		"\n" + 
		"				try (Transaction tx = db.beginTx()){\n" + 
		"               onStart(startFuture);\n" + 
		"					tx.success();\n" + 
		"            }\n" + 
		"\n" + 
		"            return new JsonObject();\n" + 
		"         }\n" + 
		"      });\n" + 
		"    	\n" + 
		"~actions:{it|\n" + 
		"		VertxUtil.consume(vertx, deploymentID(), \"~it.address~\", log, (Handler<Message<JsonObject>~gt()~) message -> {\n" + 
		"         log.info(deploymentID() + \" on ~it.address~ \" + message.body().encode());\n" + 
		"\n" + 
		"         try (Transaction tx = db.beginTx()) {\n" + 
		"				try {\n" + 
		"               on~it.name;format=\"capitalize\"~(tx, message);\n" + 
		"	            tx.success();\n" + 
		"            ~eom()~ catch (Exception e) {\n" + 
		"               log.error(deploymentID() + \" exception on ~it.address~ \" + message.body().encode() + \" \" + e.getMessage(), e);\n" + 
		"               tx.failure();\n" + 
		"               message.reply(ResponseUtil.newException(e));\n" + 
		"            ~eom()~\n" + 
		"         ~eom()~      \n" + 
		"      ~eom()~);};separator=\"\\n\"~\n" + 
		"	}\n" + 
		"\n" + 
		"	@Override\n" + 
		"   public void stop(Future<Void> stopFuture) throws Exception {\n" + 
		"      log.info(\"stop ~name~ \" + deploymentID());\n" + 
		"      db.shutdown();\n" + 
		"		super.stop(stopFuture);\n" + 
		"   }\n" + 
		"\n" + 
		"~actions:{it|\n" + 
		"	protected abstract void on~it.name;format=\"capitalize\"~(Transaction tx, Message<JsonObject> message) throws Exception;};separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected void onStart(Future<Void> startFuture) {\n" + 
		"  	}\n" + 
		"}>>\n")
			.append("Server(inbound,name,outbound,package,routes,verticles,vertxUtilPackage) ::= <<package ~package~;\n" + 
		"\n" + 
		"import ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.VertxUtil;\n" + 
		"import ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.ResponseUtil;\n" + 
		"\n" + 
		"import io.netty.handler.codec.http.HttpResponseStatus;\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.DeploymentOptions;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.http.HttpServerOptions;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import io.vertx.ext.bridge.BridgeEventType;\n" + 
		"import io.vertx.ext.web.Router;\n" + 
		"import io.vertx.ext.web.RoutingContext;\n" + 
		"import io.vertx.ext.web.handler.BodyHandler;\n" + 
		"import io.vertx.ext.web.handler.StaticHandler;\n" + 
		"import io.vertx.ext.web.handler.sockjs.BridgeOptions;\n" + 
		"import io.vertx.ext.web.handler.sockjs.PermittedOptions;\n" + 
		"import io.vertx.ext.web.handler.sockjs.SockJSHandler;\n" + 
		"import org.slf4j.Logger;\n" + 
		"import org.slf4j.LoggerFactory;\n" + 
		"\n" + 
		"import java.util.Map;\n" + 
		"\n" + 
		"import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;\n" + 
		"\n" + 
		"/**\n" + 
		" * Generated\n" + 
		" */\n" + 
		"public abstract class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"   protected static final Logger log = LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"   @Override\n" + 
		"   public void start(Future<Void> startFuture) throws Exception {\n" + 
		"      log.info(\"Starting ~name~ using config \" + config().encode());\n" + 
		"\n" + 
		"      VertxUtil.deploySilent(vertx, new Class[] { ~verticles:{it|\n" + 
		"			~it.name~.class };separator=\",\\n\"~ },\n" + 
		"            new DeploymentOptions().setConfig(config()), log);\n" + 
		"\n" + 
		"      final Router router = Router.router(vertx);\n" + 
		"      router.route().handler(BodyHandler.create());\n" + 
		"\n" + 
		"		~routes:{it|router.get(\"~it.url~\").handler(routingContext -> on~it.name;format=\"capitalize\"~(routingContext));};separator=\"\\n\"~\n" + 
		"\n" + 
		"		final BridgeOptions options = new BridgeOptions()\n" + 
		"			~outbound:{it|.addOutboundPermitted(new PermittedOptions().setAddress(\"~it.address~\"))};separator=\"\\n\"~\n" + 
		"			~inbound:{it|.addInboundPermitted(new PermittedOptions().setAddress(\"~it.address~\"))};separator=\"\\n\"~;\n" + 
		"\n" + 
		"      router.route(\"/eventbus/*\").handler(SockJSHandler.create(vertx).bridge(options, event -> {\n" + 
		"         if (event.type() == BridgeEventType.SOCKET_CREATED) \n" + 
		"            log.info(\"A socket was created\");\n" + 
		"         event.complete(true);\n" + 
		"      }));\n" + 
		"\n" + 
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
		"	}\n" + 
		"\n" + 
		"~routes:{it|\n" + 
		"	protected void on~it.name;format=\"capitalize\"~(RoutingContext routingContext) {\n" + 
		"      log.info(\"on ~it.name~ \" + debug(routingContext));\n" + 
		"   ~eom()~};separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected void forward(RoutingContext routingContext, String address) {\n" + 
		"      log.info(debug(routingContext) + \" => \" + address);\n" + 
		"      VertxUtil.sendJsonMessage(vertx, address, new JsonObject(), log, new VertxUtil.SuccessHandler<Message<JsonObject>~gt()~() {\n" + 
		"         @Override\n" + 
		"         public void onSuccess(Message<JsonObject> result) {\n" + 
		"            VertxWebUtil.newJsonResponse(routingContext, HttpResponseStatus.OK, result.body());\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onFail(Throwable t) {\n" + 
		"            VertxWebUtil.newErrorResponse(routingContext, HttpResponseStatus.INTERNAL_SERVER_ERROR, t.getMessage());\n" + 
		"         }\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"	private static String debug(RoutingContext request) {\n" + 
		"      final StringBuilder out = new StringBuilder();\n" + 
		"      for (Map.Entry<String, String> param : request.request().params())\n" + 
		"         out.append(param.getKey()).append(\"=\").append(param.getValue()).append(\"\\n\");\n" + 
		"      return request.request().uri() + \" \" + out.toString().trim();\n" + 
		"   }\n" + 
		"}>>\n")
			.append("Verticle(incoming,name,package,outgoing,vertxUtilPackage,implementation,hazelcastConfig) ::= <<package ~package~;\n" + 
		"\n" + 
		"import ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.VertxUtil;\n" + 
		"\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"public class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
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
		"~if(implementation)~\n" + 
		"\n" + 
		"	// to run: java -Dlog4j.configuration=file:./log4j.properties~if(hazelcastConfig)~ -Dvertx.hazelcast.config=~hazelcastConfig~~endif~ -jar [name]-fat.jar\n" + 
		"   public static void main(String[] args) {\n" + 
		"		VertxUtil.deploy(io.vertx.core.Vertx.vertx(), ~implementation~.class, new io.vertx.core.DeploymentOptions(), log, new VertxUtil.SuccessHandler<String>() {\n" + 
		"         @Override\n" + 
		"         public void onSuccess(String result) {\n" + 
		"            log.info(\"deploy ~name~ \" + result);\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onFail(Throwable t) {\n" + 
		"            log.error(\"deploy ~name~ failed \" + t.getMessage(), t);\n" + 
		"         }\n" + 
		"      });\n" + 
		"   }\n" + 
		"~endif~\n" + 
		"}>>\n")
			.append("RESTVerticle(name,packageName,endpoints,events) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import com.ud.vertx.VertxUtil;\n" + 
		"import io.vertx.core.AbstractVerticle;\n" + 
		"import io.vertx.core.Future;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"import static com.ud.vertx.VertxWebUtil.logRequest;\n" + 
		"\n" + 
		"public class ~name~ extends AbstractVerticle {\n" + 
		"\n" + 
		"   protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"	@Override\n" + 
		"	public void start(Future<Void> startFuture) {\n" + 
		"\n" + 
		"   	onStart(startFuture);\n" + 
		"		if (startFuture.failed()) return;\n" + 
		"\n" + 
		"		VertxUtil.consume(vertx, deploymentID(), deploymentID(), log, this::onDirectMessage);\n" + 
		"~events:{it|\n" + 
		"		// ~it.comments~\n" + 
		"		VertxUtil.consume(vertx, deploymentID(), \"~it.address~\", log, this::on~it.name;format=\"capitalize\"~);};separator=\"\\n\"~\n" + 
		"\n" + 
		"		startFuture.complete();\n" + 
		"	}\n" + 
		"\n" + 
		"~endpoints:{it|\n" + 
		"	protected void handle~it.name;format=\"capitalize\"~(RoutingContext routingContext) {\n" + 
		"		logRequest(log, routingContext);\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected void onDirectMessage(Message<JsonObject> message) {\n" + 
		"		log.info(\"onDirect message \" + message.body().encode());\n" + 
		"	}\n" + 
		"\n" + 
		"~events:{it|\n" + 
		"	protected void on~it.name;format=\"capitalize\"~(Message<JsonObject> message) {\n" + 
		"		log.info(\"on~it.name;format=\"capitalize\"~ \" + message.body().encode());\n" + 
		"	~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"\n" + 
		"	protected void onStart(Future<Void> startFuture) {\n" + 
		"  	}\n" + 
		"}>>\n")
			.append("VerticleTest(name,verticle,packageName,outgoing,vertxUtilPackage,incoming) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.VertxUtil;\n" + 
		"import ~if(vertxUtilPackage)~~vertxUtilPackage~~else~com.generator.util~endif~.ResponseUtil;\n" + 
		"\n" + 
		"import io.vertx.core.DeploymentOptions;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.Vertx;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.ext.unit.Async;\n" + 
		"import io.vertx.ext.unit.TestContext;\n" + 
		"import io.vertx.ext.unit.junit.VertxUnitRunner;\n" + 
		"import org.junit.After;\n" + 
		"import org.junit.Before;\n" + 
		"import org.junit.runner.RunWith;\n" + 
		"\n" + 
		"import java.io.IOException;\n" + 
		"\n" + 
		"/**\n" + 
		" * ~name~ test base class\n" + 
		" */\n" + 
		"@RunWith(VertxUnitRunner.class)\n" + 
		"public abstract class ~name~ {\n" + 
		"\n" + 
		"   static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
		"\n" + 
		"   Vertx vertx;\n" + 
		"   String deploymentID;\n" + 
		"\n" + 
		"   @Before\n" + 
		"   public void before(TestContext context) throws IOException {\n" + 
		"\n" + 
		"      final DeploymentOptions options = getDeploymentOptions();\n" + 
		"\n" + 
		"      vertx = Vertx.vertx();\n" + 
		"\n" + 
		"      Async async = context.async();\n" + 
		"\n" + 
		"      VertxUtil.deploy(vertx, ~verticle~.class, options, log, new VertxUtil.SuccessHandler<String>() {\n" + 
		"         @Override\n" + 
		"         public void onSuccess(String result) {\n" + 
		"            deploymentID = result;\n" + 
		"            async.complete();\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onFail(Throwable t) {\n" + 
		"            context.fail(t);\n" + 
		"         }\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   DeploymentOptions getDeploymentOptions() {\n" + 
		"      return new DeploymentOptions();\n" + 
		"   }\n" + 
		"\n" + 
		"   @After\n" + 
		"   public void after(TestContext context) {\n" + 
		"      vertx.close(context.asyncAssertSuccess());\n" + 
		"   }\n" + 
		"\n" + 
		"~outgoing:{it|\n" + 
		"\n" + 
		"	void send~it.name;format=\"capitalize\"~(JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject~gt()~> handler) {\n" + 
		"      VertxUtil.sendJsonMessage(vertx, \"~it.address~\", parameters, log, handler);\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"~incoming:{it|\n" + 
		"\n" + 
		"	void consume~it.name;format=\"capitalize\"~(Handler<Message<JsonObject~gt()~> handler) {\n" + 
		"      VertxUtil.consume(vertx, \"~name~\", \"~it.address~\", log, handler);\n" + 
		"   ~eom()~\n" + 
		"};separator=\"\\n\"~\n" + 
		"	class TestResponseHandler extends ResponseUtil.ResponseHandler {\n" + 
		"\n" + 
		"      private final TestContext context;\n" + 
		"\n" + 
		"      TestResponseHandler(org.slf4j.Logger log, TestContext context) {\n" + 
		"         super(log);\n" + 
		"         this.context = context;\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      protected void handleFail(JsonArray payload) {\n" + 
		"         context.fail(payload.encodePrettily());\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      protected void handleFail(JsonObject payload) {\n" + 
		"         context.fail(payload.encodePrettily());\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      protected void handleFail(String payload) {\n" + 
		"         context.fail(payload);\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public void onFail(Throwable t) {\n" + 
		"         context.fail(t);\n" + 
		"      }\n" + 
		"\n" + 
		"		@Override\n" + 
		"      protected void handleException(String payload) { context.fail(payload); }\n" + 
		"   }\n" + 
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
			.append("mvn_core() ::= <<<!-- https://mvnrepository.com/artifact/io.vertx/vertx-core -->\n" + 
		"<dependency>\n" + 
		"    <groupId>io.vertx</groupId>\n" + 
		"    <artifactId>vertx-core</artifactId>\n" + 
		"    <version>3.5.1</version>\n" + 
		"</dependency> >>\n")
			.append("VertxUtil(packageName,tcpEventbus) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.DeploymentOptions;\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.Verticle;\n" + 
		"import io.vertx.core.Vertx;\n" + 
		"import io.vertx.core.eventbus.DeliveryOptions;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.file.FileSystem;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import io.vertx.core.net.NetSocket;\n" + 
		"import io.vertx.core.shareddata.LocalMap;\n" + 
		"import io.vertx.core.shareddata.SharedData;\n" + 
		"import org.slf4j.Logger;\n" + 
		"\n" + 
		"import java.io.File;\n" + 
		"import java.util.ArrayList;\n" + 
		"import java.util.List;\n" + 
		"\n" + 
		"public class VertxUtil {\n" + 
		"\n" + 
		"   public static final String BODY = \"body\";\n" + 
		"   public static final String RESULT = \"result\";\n" + 
		"   public static final String SUCCESS = \"success\";\n" + 
		"   public static final String FAIL = \"fail\";\n" + 
		"   public static final String FAILURE_CODE = \"failureCode\";\n" + 
		"   public static final String FAILURE_TYPE = \"failureType\";\n" + 
		"   public static final String MESSAGE = \"message\";\n" + 
		"   public static final String CONTENT = \"content\";\n" + 
		"   public static final String CAUSE = \"cause\";\n" + 
		"   public static final String UNKNOWN = \"unknown\";\n" + 
		"   public static final String DEPLOYMENT_ID = \"deploymentID\";\n" + 
		"   public static final String STATUS = \"status\";\n" + 
		"\n" + 
		"   public static void putInLocalMap(Vertx vertx, Logger log, String mapName, String key, Object value) {\n" + 
		"      final SharedData sharedData = vertx.sharedData();\n" + 
		"      final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);\n" + 
		"      log.info(\"putInLocalMap \" + mapName + \" \" + key + \" = \" + value);\n" + 
		"      localMap.put(key, value);\n" + 
		"   }\n" + 
		"\n" + 
		"   @SuppressWarnings(\"unchecked\")\n" + 
		"   public static <V> V removeFromLocalMap(Vertx vertx, Logger log, String mapName, String key) {\n" + 
		"      final SharedData sharedData = vertx.sharedData();\n" + 
		"      final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);\n" + 
		"      log.info(\"removeFromLocalMap \" + mapName + \" \" + key + \" = \" + localMap.get(key));\n" + 
		"      return (V) localMap.remove(key);\n" + 
		"   }\n" + 
		"\n" + 
		"   @SuppressWarnings(\"unchecked\")\n" + 
		"   public static <V> V getFromLocalMap(Vertx vertx, Logger log, String mapName, String key) {\n" + 
		"      final SharedData sharedData = vertx.sharedData();\n" + 
		"      final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);\n" + 
		"      log.info(\"getFromLocalMap \" + mapName + \" \" + key + \" = \" + localMap.get(key));\n" + 
		"      return (V) localMap.get(key);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static <K, V> LocalMap<K, V> getLocalMap(Vertx vertx, Logger log, String mapName) {\n" + 
		"      final SharedData sharedData = vertx.sharedData();\n" + 
		"      log.info(\"getLocalMap \" + mapName);\n" + 
		"      return sharedData.getLocalMap(mapName);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void readDir(Vertx vertx, Logger log, File directory, SuccessHandler<List<File~gt()~> successHandler) {\n" + 
		"\n" + 
		"      final FileSystem fileSystem = vertx.fileSystem();\n" + 
		"      log.info(\"readDir \" + directory.getAbsolutePath());\n" + 
		"\n" + 
		"      fileSystem.readDir(directory.getAbsolutePath(), result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            log.error(\"readDir \" + directory.getAbsolutePath() + \" failed : \" + result.cause().getMessage(), result.cause());\n" + 
		"            successHandler.onFail(result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         final List<File> list = new ArrayList<>(result.result().size());\n" + 
		"         for (String s : result.result())\n" + 
		"            list.add(new File(s));\n" + 
		"\n" + 
		"         successHandler.onSuccess(list);\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void putInClusterMap(Vertx vertx, Logger log, String mapName, String key, Object value, SuccessHandler<Void> successHandler) {\n" + 
		"\n" + 
		"      vertx.sharedData().getClusterWideMap(mapName, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            log.error(\"putInClusterMap \" + mapName + \" failed : \" + result.cause().getMessage(), result.cause());\n" + 
		"            successHandler.onFail(result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         result.result().put(key, value, resultPut -> {\n" + 
		"            if (resultPut.failed()) {\n" + 
		"               log.error(\"putInClusterMap \" + mapName + \" failed to put \" + key + \" = \" + value + \" : \" + result.cause().getMessage(), result.cause());\n" + 
		"               successHandler.onFail(resultPut.cause());\n" + 
		"               return;\n" + 
		"            }\n" + 
		"\n" + 
		"            log.info(\"putInClusterMap \" + mapName + \" \" + key + \" = \" + value + \" success\");\n" + 
		"            successHandler.onSuccess(null);\n" + 
		"         });\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   @SuppressWarnings(\"unchecked\")\n" + 
		"   public static <V> void removeFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {\n" + 
		"\n" + 
		"      vertx.sharedData().getClusterWideMap(mapName, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            log.error(\"removeFromClusterMap \" + mapName + \" failed : \" + result.cause().getMessage(), result.cause());\n" + 
		"            successHandler.onFail(result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         result.result().remove(key, resultGet -> {\n" + 
		"\n" + 
		"            if (resultGet.failed()) {\n" + 
		"               log.error(\"removeFromClusterMap \" + mapName + \" failed to remove key \" + key + \" : \" + result.cause().getMessage(), result.cause());\n" + 
		"               successHandler.onFail(resultGet.cause());\n" + 
		"               return;\n" + 
		"            }\n" + 
		"\n" + 
		"            log.info(\"removeFromClusterMap \" + mapName + \".\" + key + \" removed \" + resultGet.result());\n" + 
		"            successHandler.onSuccess((V) resultGet);\n" + 
		"         });\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   @SuppressWarnings(\"unchecked\")\n" + 
		"   public static <V> void getFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {\n" + 
		"\n" + 
		"      vertx.sharedData().getClusterWideMap(mapName, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            log.error(\"getFromClusterMap \" + mapName + \" failed : \" + result.cause().getMessage(), result.cause());\n" + 
		"            successHandler.onFail(result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         result.result().get(key, resultGet -> {\n" + 
		"\n" + 
		"            if (resultGet.failed()) {\n" + 
		"               log.error(\"getFromClusterMap \" + mapName + \".\" + key + \" failed : \" + result.cause().getMessage(), result.cause());\n" + 
		"               successHandler.onFail(resultGet.cause());\n" + 
		"               return;\n" + 
		"            }\n" + 
		"\n" + 
		"            if (resultGet.result() == null) {\n" + 
		"               log.error(\"getFromClusterMap \" + mapName + \".\" + key + \" is null\", result.cause());\n" + 
		"               successHandler.onFail(new Throwable(mapName + \".\" + key + \" is null\"));\n" + 
		"               return;\n" + 
		"            }\n" + 
		"\n" + 
		"            log.info(\"getFromClusterMap \" + mapName + \".\" + key + \" = \" + resultGet.result());\n" + 
		"            successHandler.onSuccess((V) resultGet);\n" + 
		"         });\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"~if(tcpEventbus)~\n" + 
		"   public static void sendFrame(org.slf4j.Logger log, String address, String replyAddress, JsonObject parameters, NetSocket socket) {\n" + 
		"      log.info(\"sending frame \" + address + \" \" + replyAddress + \" \" + parameters);\n" + 
		"      io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameHelper.sendFrame(\"send\", address, replyAddress, parameters, socket);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void sendFrame(org.apache.log4j.Logger log, String address, String replyAddress, JsonObject parameters, NetSocket socket) {\n" + 
		"      log.info(\"sending frame \" + address + \" \" + replyAddress + \" \" + parameters);\n" + 
		"      io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameHelper.sendFrame(\"send\", address, replyAddress, parameters, socket);\n" + 
		"   }\n" + 
		"\n" + 
		"~endif~\n" + 
		"   public static void reply(Logger log, String deploymentID, JsonObject result, Message<JsonObject> message) {\n" + 
		"      log.info(\"reply \" + deploymentID + \" \" + message.replyAddress() + \" \" + result);\n" + 
		"      message.reply(result);\n" + 
		"   }\n" + 
		"\n" + 
		"   public interface SuccessHandler<T> {\n" + 
		"\n" + 
		"      void onSuccess(T result);\n" + 
		"\n" + 
		"      void onFail(Throwable t);\n" + 
		"\n" + 
		"   }\n" + 
		"\n" + 
		"   public interface Executor<R, T> extends SuccessHandler<T> {\n" + 
		"\n" + 
		"      R execute() throws Throwable;\n" + 
		"   }\n" + 
		"\n" + 
		"   @SuppressWarnings(\"unchecked\")\n" + 
		"   public static <R> void executeBlocking(Vertx vertx, Logger log, Executor<R, R> executor) {\n" + 
		"\n" + 
		"      vertx.executeBlocking(future -> {\n" + 
		"\n" + 
		"         try {\n" + 
		"\n" + 
		"            final R result = executor.execute();\n" + 
		"\n" + 
		"            if (result == null) future.complete();\n" + 
		"            else future.complete(result);\n" + 
		"\n" + 
		"         } catch (Throwable throwable) {\n" + 
		"            log.error(\"executeBlocking exception : \" + throwable.getMessage(), throwable);\n" + 
		"            future.fail(throwable);\n" + 
		"         }\n" + 
		"\n" + 
		"      }, res -> {\n" + 
		"\n" + 
		"         if (res.failed())\n" + 
		"            executor.onFail(res.cause());\n" + 
		"         else\n" + 
		"            executor.onSuccess((R) res.result());\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static <T> void consume(Vertx vertx, String consumer, String address, Logger log, Handler<Message<T~gt()~> messageHandler) {\n" + 
		"      log.info(\"consumer \" + consumer + \" handles '\" + address + \"'\");\n" + 
		"      vertx.eventBus().consumer(address, messageHandler);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static <T, R> void sendMessage(Vertx vertx, String address, T content, Logger log, SuccessHandler<Message<R~gt()~> handler) {\n" + 
		"      sendMessage(vertx, address, content, null, log, handler);\n" + 
		"   }\n" + 
		"\n" + 
		"	public static <T, R> void sendJsonMessage(Vertx vertx, String address, JsonObject content, Logger log, SuccessHandler<Message<JsonObject~gt()~> handler) {\n" + 
		"      sendMessage(vertx, address, content, null, log, handler);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static <T, R> void sendJsonMessageSilent(Vertx vertx, String address, JsonObject content, Logger log) {\n" + 
		"      sendMessage(vertx, address, content, null, log, new SuccessHandler<Message<JsonObject~gt()~>() {\n" + 
		"         @Override\n" + 
		"         public void onSuccess(Message<JsonObject> result) {\n" + 
		"            // log.info(\"message sent to \" + address + \" \" + content.encode() + \" \" + result.body());\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onFail(Throwable t) {\n" + 
		"            // log.warn(\"message sent to \" + address + \" \" + content.encode());\n" + 
		"         }\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static <T, R> void sendMessage(Vertx vertx, String address, T content, Logger log) {\n" + 
		"      sendMessage(vertx, address, content, null, log, new SuccessHandler<JsonObject>() {\n" + 
		"         @Override\n" + 
		"         public void onSuccess(JsonObject result) {\n" + 
		"            log.info(\"message sent to \" + address + \" \" + result);\n" + 
		"         }\n" + 
		"\n" + 
		"         @Override\n" + 
		"         public void onFail(Throwable t) {\n" + 
		"            log.info(\"sendMessage failed \" + address + \" \" + t.getCause().getMessage(), t.getCause());\n" + 
		"         }\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   @SuppressWarnings(\"unchecked\")\n" + 
		"   public static <T, R> void sendMessage(Vertx vertx, String address, T content, DeliveryOptions options, Logger log, SuccessHandler<R> handler) {\n" + 
		"\n" + 
		"      log.info(\"sendingMessage to \" + address + \" \" + content.toString());\n" + 
		"\n" + 
		"      if (options == null) options = new DeliveryOptions();\n" + 
		"\n" + 
		"      vertx.eventBus().send(address, content, options, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            log.error(\"sendMessage failed \" + address + \" \" + result.cause().getMessage());\n" + 
		"            handler.onFail(result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"         log.info(\"message sent to \" + address + \" \" + result.result().body());\n" + 
		"         handler.onSuccess((R) result.result());\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void publish(Vertx vertx, String address, Object content, Logger log) {\n" + 
		"      publish(vertx, address, content, null, log);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void publish(Vertx vertx, String address, Object content, DeliveryOptions options, Logger log) {\n" + 
		"      if (options == null) options = new DeliveryOptions();\n" + 
		"      log.info(\"publish to \" + address + \" : \" + content);\n" + 
		"      vertx.eventBus().publish(address, content, options);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void undeploy(Vertx vertx, Logger log, String deploymentId, SuccessHandler<Void> handler) {\n" + 
		"\n" + 
		"      log.info(\"undeploy \" + deploymentId);\n" + 
		"\n" + 
		"      vertx.undeploy(deploymentId, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            handler.onFail(result.cause());\n" + 
		"            log.error(\"undeploy failed \" + deploymentId + \" \" + result.cause().getMessage(), result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         log.info(\"undeploy success \" + deploymentId);\n" + 
		"         handler.onSuccess(null);\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deploy(Vertx vertx, Class verticleClass, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {\n" + 
		"      deploy(vertx, verticleClass.getCanonicalName(), deploymentOptions, log, handler);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deploy(Vertx vertx, Verticle verticle, Logger log, SuccessHandler<String> handler) {\n" + 
		"      deploy(vertx, verticle, null, log, handler);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deploy(Vertx vertx, Verticle verticle, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {\n" + 
		"\n" + 
		"      if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();\n" + 
		"		log.info(\"deploying \" + verticle.getClass().getCanonicalName() + \" using \" + deploymentOptions.getConfig().encode());\n" + 
		"\n" + 
		"      vertx.deployVerticle(verticle, deploymentOptions, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            handler.onFail(result.cause());\n" + 
		"            log.error(\"deploy failed \" + verticle + \" \" + result.cause().getMessage(), result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         log.info(\"deploy success \" + verticle + \" \" + result.result());\n" + 
		"         handler.onSuccess(result.result());\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deploy(Vertx vertx, String className, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {\n" + 
		"\n" + 
		"      if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();\n" + 
		"		log.info(\"deploying \" + className + \" using \" + deploymentOptions.getConfig().encode());\n" + 
		"\n" + 
		"      vertx.deployVerticle(className, deploymentOptions, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            handler.onFail(result.cause());\n" + 
		"            log.error(\"deploy failed \" + className + \" \" + result.cause().getMessage(), result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         log.info(\"deploy success \" + className + \" \" + result.result());\n" + 
		"         handler.onSuccess(result.result());\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deploy(Vertx vertx, String className, DeploymentOptions deploymentOptions, Logger log) {\n" + 
		"\n" + 
		"      if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();\n" + 
		"		log.info(\"deploying \" + className + \" using \" + deploymentOptions.getConfig().encode());\n" + 
		"\n" + 
		"      vertx.deployVerticle(className, deploymentOptions, result -> {\n" + 
		"\n" + 
		"         if (result.failed()) {\n" + 
		"            log.error(\"deploy failed \" + className + \" \" + result.cause().getMessage(), result.cause());\n" + 
		"            return;\n" + 
		"         }\n" + 
		"\n" + 
		"         log.info(\"deploy success \" + className + \" : \" + result.result());\n" + 
		"      });\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deploy(Vertx vertx, String className, JsonObject config, Logger log, SuccessHandler<String> handler) {\n" + 
		"\n" + 
		"      final DeploymentOptions deploymentOptions = new DeploymentOptions();\n" + 
		"      if (config != null) deploymentOptions.setConfig(config);\n" + 
		"\n" + 
		"      deploy(vertx, className, deploymentOptions, log, handler);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static void deploy(Vertx vertx, String className, Logger log, SuccessHandler<String> handler) {\n" + 
		"      deploy(vertx, className, new DeploymentOptions(), log, handler);\n" + 
		"   }\n" + 
		"\n" + 
		"   // ENVELOPE-MESSAGES\n" + 
		"\n" + 
		"   public static JsonObject newStatus(String deploymentId, String status) {\n" + 
		"      final JsonObject msg = new JsonObject();\n" + 
		"      msg.put(DEPLOYMENT_ID, deploymentId);\n" + 
		"      msg.put(STATUS, status);\n" + 
		"      return msg;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newSuccess(final Object content) {\n" + 
		"      final JsonObject reply = new JsonObject();\n" + 
		"      reply.put(RESULT, SUCCESS);\n" + 
		"      reply.put(CONTENT, content);\n" + 
		"      return reply;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newFail(final Object cause) {\n" + 
		"      final JsonObject reply = new JsonObject();\n" + 
		"      reply.put(RESULT, FAIL);\n" + 
		"      if (cause != null && ((cause instanceof Throwable) && ((Throwable) cause).getMessage() != null))\n" + 
		"         reply.put(CAUSE, ((Throwable) cause).getMessage());\n" + 
		"      return reply;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static boolean isSuccess(Message<JsonObject> message) {\n" + 
		"      return isSuccess(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static boolean isFail(Message<JsonObject> message) {\n" + 
		"      return isFail(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static String getFailCause(Message<JsonObject> message) {\n" + 
		"      return getFailCause(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static boolean isSuccess(JsonObject jsonObject) {\n" + 
		"\n" + 
		"      final JsonObject body = jsonObject.getJsonObject(BODY);\n" + 
		"      if (body != null) {\n" + 
		"         final String result = body.getString(RESULT);\n" + 
		"         return result != null && SUCCESS.equals(result);\n" + 
		"      }\n" + 
		"\n" + 
		"      final String result = jsonObject.getString(RESULT);\n" + 
		"      return result != null && SUCCESS.equals(result);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static boolean isFail(JsonObject jsonObject) {\n" + 
		"\n" + 
		"      final JsonObject body = jsonObject.getJsonObject(BODY);\n" + 
		"      if (body != null) {\n" + 
		"         final String result = body.getString(RESULT);\n" + 
		"         return result != null && FAIL.equals(result);\n" + 
		"      }\n" + 
		"\n" + 
		"      final String result = jsonObject.getString(RESULT);\n" + 
		"      if (result != null)\n" + 
		"         return FAIL.equals(result);\n" + 
		"\n" + 
		"      return jsonObject.getString(FAILURE_CODE) != null;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static String getFailCause(JsonObject jsonObject) {\n" + 
		"\n" + 
		"      final JsonObject body = jsonObject.getJsonObject(BODY);\n" + 
		"      if (body != null)\n" + 
		"         return body.getString(CAUSE);\n" + 
		"\n" + 
		"      final String cause = jsonObject.getString(CAUSE);\n" + 
		"      if (cause != null) return cause;\n" + 
		"\n" + 
		"      final String failureCode = jsonObject.getString(FAILURE_CODE);\n" + 
		"      if (failureCode != null)\n" + 
		"         return failureCode + \" : \" + jsonObject.getString(FAILURE_TYPE) + \" : \" + jsonObject.getString(MESSAGE);\n" + 
		"\n" + 
		"      return UNKNOWN + \" : \" + jsonObject;\n" + 
		"   }\n" + 
		"}>>\n")
			.append("Docker(exposePort,verticleFile,verticleHome,verticleName,vertxOptions,javaOptions,copies,cluster) ::= <<# Extend vert.x image\n" + 
		"FROM vertx/vertx3\n" + 
		"\n" + 
		"#                                                      \n" + 
		"ENV VERTICLE_NAME ~verticleName~\n" + 
		"ENV VERTICLE_FILE ~verticleFile~\n" + 
		"~if(javaOptions)~\n" + 
		"ENV JAVA_OPTS \"~javaOptions:{it|-D~it.key~=~it.value~};separator=\" \"~\"\n" + 
		"\n" + 
		"~endif~\n" + 
		"~if(vertxOptions)~\n" + 
		"ENV VERTX_OPTS \"~vertxOptions:{it|-D~it.key~=~it.value~};separator=\" \"~\"\n" + 
		"~if(cluster)~\n" + 
		"COPY ~cluster~ $VERTICLE_HOME/~endif~\n" + 
		"\n" + 
		"~endif~\n" + 
		"# Set the location of the verticles\n" + 
		"ENV VERTICLE_HOME ~verticleHome~\n" + 
		"\n" + 
		"EXPOSE ~exposePort~\n" + 
		"\n" + 
		"# Copy your verticle to the container                  \n" + 
		"COPY $VERTICLE_FILE $VERTICLE_HOME/\n" + 
		"~copies:{it|COPY ~it.src~ $VERTICLE_HOME/~it.filename~};separator=\"\\n\"~\n" + 
		"~if(cluster)~COPY ~cluster~ $VERTICLE_HOME/~endif~\n" + 
		"\n" + 
		"# Launch the verticle\n" + 
		"WORKDIR $VERTICLE_HOME\n" + 
		"ENTRYPOINT [\"sh\", \"-c\"]\n" + 
		"CMD [\"exec vertx $VERTX_OPTS -cp $VERTICLE_HOME/*\"]>>\n")
			.append("mvn_unit() ::= <<<!-- https://mvnrepository.com/artifact/io.vertx/vertx-unit -->\n" + 
		"<dependency>\n" + 
		"    <groupId>io.vertx</groupId>\n" + 
		"    <artifactId>vertx-unit</artifactId>\n" + 
		"    <version>3.5.1</version>\n" + 
		"    <scope>test</scope>\n" + 
		"</dependency> >>\n")
			.append("JsonUtil(packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.netty.handler.codec.http.HttpResponseStatus;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"\n" + 
		"import static ~packageName~.JsonUtil.KEYS.*;\n" + 
		"import static io.netty.handler.codec.http.HttpResponseStatus.OK;\n" + 
		"\n" + 
		"public class JsonUtil {\n" + 
		"\n" + 
		"   public enum RESULT {\n" + 
		"      SUCCESS,\n" + 
		"      FAIL,\n" + 
		"      EXCEPTION\n" + 
		"   }\n" + 
		"\n" + 
		"   public static RESULT getResult(JsonObject jsonObject) {\n" + 
		"      return RESULT.valueOf(jsonObject.getString(\"RESULT\"));\n" + 
		"   }\n" + 
		"\n" + 
		"   public static RESULT getResult(Message<JsonObject> message) {\n" + 
		"      return getResult(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static boolean isSuccess(JsonObject jsonObject) {\n" + 
		"      return RESULT.SUCCESS.name().equals(jsonObject.getString(\"RESULT\"));\n" + 
		"   }\n" + 
		"\n" + 
		"   public static boolean isSuccess(Message<JsonObject> message) {\n" + 
		"      return isSuccess(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject getJsonObjectContent(JsonObject jsonObject) {\n" + 
		"      return jsonObject.getJsonObject(\"CONTENT\");\n" + 
		"   }\n" + 
		"\n" + 
		"   public static String getStringContent(JsonObject jsonObject) {\n" + 
		"      return jsonObject.getString(\"CONTENT\");\n" + 
		"   }\n" + 
		"\n" + 
		"   public static String getStringContent(Message<JsonObject> message) {\n" + 
		"      return getStringContent(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject getJsonObjectContent(Message<JsonObject> message) {\n" + 
		"      return getJsonObjectContent(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonArray getJsonArrayContent(Message<JsonObject> message) {\n" + 
		"      return getJsonArrayContent(message.body());\n" + 
		"   }\n" + 
		"\n" + 
		"   private static JsonArray getJsonArrayContent(JsonObject jsonObject) {\n" + 
		"      return jsonObject.getJsonArray(\"CONTENT\");\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newSuccess(JsonObject content) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"RESULT\", RESULT.SUCCESS).\n" + 
		"            put(\"CONTENT\", content);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newSuccess(String content) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"RESULT\", RESULT.SUCCESS).\n" + 
		"            put(\"CONTENT\", content);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newSuccess(JsonArray content) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"RESULT\", RESULT.SUCCESS).\n" + 
		"            put(\"CONTENT\", content);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newFail(JsonArray errors) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"RESULT\", RESULT.FAIL).\n" + 
		"            put(\"ERRORS\", errors);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newFail(String message) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"RESULT\", RESULT.FAIL).\n" + 
		"            put(\"ERRORS\", message);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newException(Throwable t) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"RESULT\", RESULT.EXCEPTION).\n" + 
		"            put(\"MESSAGE\", t.getMessage());\n" + 
		"   }\n" + 
		"\n" + 
		"   public enum KEYS {\n" + 
		"      STATUS, DETAILS, CONTENT, VISITOR, PARAMS, API, MESSAGE, TYPE, FIELD, CONTEXT, HEADER, REQUIRED, ILLEGAL, MALFORMED, ERROR, REASON\n" + 
		"   }\n" + 
		"\n" + 
		"   public static String getMessage(JsonObject body) {\n" + 
		"      return body.containsKey(MESSAGE.name()) ? body.getString(MESSAGE.name()) : null;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newJsonObject(Object... kv) {\n" + 
		"      final JsonObject content = new JsonObject();\n" + 
		"      if (kv.length % 2 != 0)\n" + 
		"         throw new IllegalArgumentException(\"Expecting key value PAIRS\");\n" + 
		"\n" + 
		"      for (int i = 0; i < kv.length; i += 2)\n" + 
		"         content.put(kv[i].toString(), kv[i + 1]);\n" + 
		"\n" + 
		"      return content;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonArray newJsonArray(Object... values) {\n" + 
		"      final JsonArray array = new JsonArray();\n" + 
		"      for (Object v : values)\n" + 
		"         array.add(v);\n" + 
		"      return array;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject success(JsonObject result, JsonObject content) {\n" + 
		"      return result.\n" + 
		"            put(STATUS.name(), OK.code()).\n" + 
		"            put(TYPE.name(), OK.reasonPhrase()).\n" + 
		"            put(CONTENT.name(), content);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject fail(JsonObject result, HttpResponseStatus status, final Throwable throwable) {\n" + 
		"      return fail(result, status, newError(throwable.getMessage()));\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject fail(JsonObject result, HttpResponseStatus status, JsonObject... cause) {\n" + 
		"\n" + 
		"      result.\n" + 
		"            put(STATUS.name(), status.code()).\n" + 
		"            put(TYPE.name(), status.reasonPhrase());\n" + 
		"\n" + 
		"      JsonArray details = new JsonArray();\n" + 
		"      for (JsonObject aCause : cause) details.add(aCause);\n" + 
		"\n" + 
		"      if (!details.isEmpty())\n" + 
		"         result.put(DETAILS.name(), details);\n" + 
		"\n" + 
		"      return result;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newRequiredContext(String attributeName) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(CONTEXT.name(), attributeName).\n" + 
		"            put(REQUIRED.name(), true);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newRequiredField(String attributeName) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(FIELD.name(), attributeName).\n" + 
		"            put(REQUIRED.name(), true);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newRequiredHeader(String attributeName) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(HEADER.name(), attributeName).\n" + 
		"            put(REQUIRED.name(), true);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newError(String error) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(ERROR.name(), error);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newJsonError(final int status, String type, final String message, final JsonArray details) {\n" + 
		"\n" + 
		"      final JsonObject response = new JsonObject().\n" + 
		"            put(STATUS.name(), status).\n" + 
		"            put(TYPE.name(), type);\n" + 
		"\n" + 
		"      if (message != null) {\n" + 
		"         response.put(MESSAGE.name(), message);\n" + 
		"      }\n" + 
		"\n" + 
		"      if (details != null)\n" + 
		"         response.put(DETAILS.name(), details);\n" + 
		"\n" + 
		"      return response;\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject error(JsonObject result, String error) {\n" + 
		"      return result.put(ERROR.name(), error);\n" + 
		"   }\n" + 
		"}>>\n")
			.append("mvn_fat_jar(mainClass) ::= <<<plugin>\n" + 
		"    <groupId>org.apache.maven.plugins</groupId>\n" + 
		"    <artifactId>maven-shade-plugin</artifactId>\n" + 
		"    <version>2.3</version>\n" + 
		"    <executions>\n" + 
		"        <execution>\n" + 
		"            <phase>package</phase>\n" + 
		"            <goals>\n" + 
		"                <goal>shade</goal>\n" + 
		"            </goals>\n" + 
		"            <configuration>\n" + 
		"                <filters>\n" + 
		"                    <filter>\n" + 
		"                        <artifact>*:*</artifact>\n" + 
		"                        <excludes>\n" + 
		"                            <exclude>META-INF/*.SF</exclude>\n" + 
		"                            <exclude>META-INF/*.DSA</exclude>\n" + 
		"                            <exclude>META-INF/*.RSA</exclude>\n" + 
		"                        </excludes>\n" + 
		"                    </filter>\n" + 
		"                </filters>\n" + 
		"                <transformers>\n" + 
		"                    <transformer implementation=\"org.apache.maven.plugins.shade.resource.ManifestResourceTransformer\">\n" + 
		"                        <manifestEntries>\n" + 
		"                            <Main-Class>~mainClass~</Main-Class>\n" + 
		"                        </manifestEntries>\n" + 
		"                    </transformer>\n" + 
		"                    <transformer implementation=\"org.apache.maven.plugins.shade.resource.AppendingTransformer\">\n" + 
		"                        <resource>META-INF/services/io.vertx.core.spi.VerticleFactory</resource>\n" + 
		"                    </transformer>\n" + 
		"                </transformers>\n" + 
		"                <artifactSet>\n" + 
		"                </artifactSet>\n" + 
		"                <outputFile>${project.build.directory}/${project.artifactId}-${project.version}-fat.jar</outputFile>\n" + 
		"            </configuration>\n" + 
		"        </execution>\n" + 
		"    </executions>\n" + 
		"</plugin>\n" + 
		"\n" + 
		"<plugin>\n" + 
		"    <groupId>org.codehaus.mojo</groupId>\n" + 
		"    <artifactId>exec-maven-plugin</artifactId>\n" + 
		"    <version>1.4.0</version>\n" + 
		"    <executions>\n" + 
		"        <execution>\n" + 
		"            <!-- run the application using the fat jar -->\n" + 
		"            <id>run-app</id>\n" + 
		"            <goals>\n" + 
		"                <goal>exec</goal>\n" + 
		"            </goals>\n" + 
		"            <configuration>\n" + 
		"                <executable>java</executable>\n" + 
		"                <arguments>\n" + 
		"                    <argument>-jar</argument>\n" + 
		"                    <argument>target/${project.artifactId}-${project.version}-fat.jar</argument>\n" + 
		"                </arguments>\n" + 
		"            </configuration>\n" + 
		"        </execution>\n" + 
		"    </executions>\n" + 
		"</plugin> >>\n")
			.append("mvn_hazelcast() ::= <<<dependency>\n" + 
		"  <groupId>io.vertx</groupId>\n" + 
		"  <artifactId>vertx-hazelcast</artifactId>\n" + 
		"  <version>3.5.1</version>\n" + 
		"</dependency> >>\n")
			.append("hazelcastConfigXML() ::= <<<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
		"\n" + 
		"<hazelcast xsi:schemaLocation=\"http://www.hazelcast.com/schema/config hazelcast-config-3.8.xsd\"\n" + 
		"           xmlns=\"http://www.hazelcast.com/schema/config\"\n" + 
		"           xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
		"  <properties>\n" + 
		"    <property name=\"hazelcast.mancenter.enabled\">false</property>\n" + 
		"    <property name=\"hazelcast.memcache.enabled\">false</property>\n" + 
		"    <property name=\"hazelcast.rest.enabled\">false</property>\n" + 
		"    <property name=\"hazelcast.wait.seconds.before.join\">0</property>\n" + 
		"  </properties>\n" + 
		"\n" + 
		"  <group>\n" + 
		"    <name>dev</name>\n" + 
		"    <password>dev-pass</password>\n" + 
		"  </group>\n" + 
		"  <management-center enabled=\"false\">http://localhost:8080/mancenter</management-center>\n" + 
		"  <network>\n" + 
		"    <port auto-increment=\"true\" port-count=\"10000\">5701</port>\n" + 
		"    <outbound-ports>\n" + 
		"      <!--\n" + 
		"      Allowed port range when connecting to other nodes.\n" + 
		"      0 or * means use system provided port.\n" + 
		"      -->\n" + 
		"      <ports>0</ports>\n" + 
		"    </outbound-ports>\n" + 
		"    <join>\n" + 
		"      <multicast enabled=\"true\">\n" + 
		"        <multicast-group>224.2.2.3</multicast-group>\n" + 
		"        <multicast-port>54327</multicast-port>\n" + 
		"      </multicast>\n" + 
		"      <tcp-ip enabled=\"false\">\n" + 
		"        <interface>192.168.1.28</interface>\n" + 
		"      </tcp-ip>\n" + 
		"      <aws enabled=\"false\">\n" + 
		"        <access-key>my-access-key</access-key>\n" + 
		"        <secret-key>my-secret-key</secret-key>\n" + 
		"        <!--optional, default is us-east-1 -->\n" + 
		"        <region>us-west-1</region>\n" + 
		"        <!--optional, default is ec2.amazonaws.com. If set, region shouldn't be set as it will override this property -->\n" + 
		"        <host-header>ec2.amazonaws.com</host-header>\n" + 
		"        <!-- optional, only instances belonging to this group will be discovered, default will try all running instances -->\n" + 
		"        <security-group-name>hazelcast-sg</security-group-name>\n" + 
		"        <tag-key>type</tag-key>\n" + 
		"        <tag-value>hz-nodes</tag-value>\n" + 
		"      </aws>\n" + 
		"    </join>\n" + 
		"    <interfaces enabled=\"false\">\n" + 
		"      <interface>10.10.1.*</interface>\n" + 
		"    </interfaces>\n" + 
		"    <ssl enabled=\"false\"/>\n" + 
		"    <socket-interceptor enabled=\"false\"/>\n" + 
		"    <symmetric-encryption enabled=\"false\">\n" + 
		"      <!--\n" + 
		"         encryption algorithm such as\n" + 
		"         DES/ECB/PKCS5Padding,\n" + 
		"         PBEWithMD5AndDES,\n" + 
		"         AES/CBC/PKCS5Padding,\n" + 
		"         Blowfish,\n" + 
		"         DESede\n" + 
		"      -->\n" + 
		"      <algorithm>PBEWithMD5AndDES</algorithm>\n" + 
		"      <!-- salt value to use when generating the secret key -->\n" + 
		"      <salt>thesalt</salt>\n" + 
		"      <!-- pass phrase to use when generating the secret key -->\n" + 
		"      <password>thepass</password>\n" + 
		"      <!-- iteration count to use when generating the secret key -->\n" + 
		"      <iteration-count>19</iteration-count>\n" + 
		"    </symmetric-encryption>\n" + 
		"  </network>\n" + 
		"  <partition-group enabled=\"false\"/>\n" + 
		"  <executor-service name=\"default\">\n" + 
		"    <pool-size>16</pool-size>\n" + 
		"    <!--Queue capacity. 0 means Integer.MAX_VALUE.-->\n" + 
		"    <queue-capacity>0</queue-capacity>\n" + 
		"  </executor-service>\n" + 
		"\n" + 
		"  <multimap name=\"__vertx.subs\">\n" + 
		"\n" + 
		"    <!--\n" + 
		"        Number of backups. If 1 is set as the backup-count for example,\n" + 
		"        then all entries of the map will be copied to another JVM for\n" + 
		"        fail-safety. 0 means no backup.\n" + 
		"    -->\n" + 
		"    <backup-count>1</backup-count>\n" + 
		"  </multimap>\n" + 
		"\n" + 
		"  <map name=\"__vertx.haInfo\">\n" + 
		"\n" + 
		"    <!--\n" + 
		"        Number of backups. If 1 is set as the backup-count for example,\n" + 
		"        then all entries of the map will be copied to another JVM for\n" + 
		"        fail-safety. 0 means no backup.\n" + 
		"    -->\n" + 
		"    <backup-count>1</backup-count>\n" + 
		"    <!--\n" + 
		"  Maximum number of seconds for each entry to stay in the map. Entries that are\n" + 
		"  older than <time-to-live-seconds> and not updated for <time-to-live-seconds>\n" + 
		"  will get automatically evicted from the map.\n" + 
		"  Any integer between 0 and Integer.MAX_VALUE. 0 means infinite. Default is 0.\n" + 
		"-->\n" + 
		"    <time-to-live-seconds>0</time-to-live-seconds>\n" + 
		"    <!--\n" + 
		"  Maximum number of seconds for each entry to stay idle in the map. Entries that are\n" + 
		"  idle(not touched) for more than <max-idle-seconds> will get\n" + 
		"  automatically evicted from the map. Entry is touched if get, put or containsKey is called.\n" + 
		"  Any integer between 0 and Integer.MAX_VALUE. 0 means infinite. Default is 0.\n" + 
		"-->\n" + 
		"    <max-idle-seconds>0</max-idle-seconds>\n" + 
		"    <!--\n" + 
		"        Valid values are:\n" + 
		"        NONE (no eviction),\n" + 
		"        LRU (Least Recently Used),\n" + 
		"        LFU (Least Frequently Used).\n" + 
		"        NONE is the default.\n" + 
		"    -->\n" + 
		"    <eviction-policy>NONE</eviction-policy>\n" + 
		"    <!--\n" + 
		"        Maximum size of the map. When max size is reached,\n" + 
		"        map is evicted based on the policy defined.\n" + 
		"        Any integer between 0 and Integer.MAX_VALUE. 0 means\n" + 
		"        Integer.MAX_VALUE. Default is 0.\n" + 
		"    -->\n" + 
		"    <max-size policy=\"PER_NODE\">0</max-size>\n" + 
		"    <!--\n" + 
		"        When max. size is reached, specified percentage of\n" + 
		"        the map will be evicted. Any integer between 0 and 100.\n" + 
		"        If 25 is set for example, 25% of the entries will\n" + 
		"        get evicted.\n" + 
		"    -->\n" + 
		"    <eviction-percentage>25</eviction-percentage>\n" + 
		"    <!--\n" + 
		"        While recovering from split-brain (network partitioning),\n" + 
		"        map entries in the small cluster will merge into the bigger cluster\n" + 
		"        based on the policy set here. When an entry merge into the\n" + 
		"        cluster, there might an existing entry with the same key already.\n" + 
		"        Values of these entries might be different for that same key.\n" + 
		"        Which value should be set for the key? Conflict is resolved by\n" + 
		"        the policy set here. Default policy is PutIfAbsentMapMergePolicy\n" + 
		"\n" + 
		"        There are built-in merge policies such as\n" + 
		"        com.hazelcast.map.merge.PassThroughMergePolicy; entry will be added if there is no existing entry for the key.\n" + 
		"        com.hazelcast.map.merge.PutIfAbsentMapMergePolicy ; entry will be added if the merging entry doesn't exist in the cluster.\n" + 
		"        com.hazelcast.map.merge.HigherHitsMapMergePolicy ; entry with the higher hits wins.\n" + 
		"        com.hazelcast.map.merge.LatestUpdateMapMergePolicy ; entry with the latest update wins.\n" + 
		"    -->\n" + 
		"    <merge-policy>com.hazelcast.map.merge.LatestUpdateMapMergePolicy</merge-policy>\n" + 
		"\n" + 
		"  </map>\n" + 
		"\n" + 
		"  <!-- Used internally in Vert.x to implement async locks -->\n" + 
		"  <semaphore name=\"__vertx.*\">\n" + 
		"    <initial-permits>1</initial-permits>\n" + 
		"  </semaphore>\n" + 
		"\n" + 
		"</hazelcast> >>\n")
			.append("ResponseUtil(packageName) ::= <<package ~packageName~;\n" + 
		"\n" + 
		"import io.vertx.core.Handler;\n" + 
		"import io.vertx.core.buffer.Buffer;\n" + 
		"import io.vertx.core.eventbus.Message;\n" + 
		"import io.vertx.core.json.JsonArray;\n" + 
		"import io.vertx.core.json.JsonObject;\n" + 
		"import org.slf4j.Logger;\n" + 
		"\n" + 
		"public class ResponseUtil {\n" + 
		"\n" + 
		"   private enum ResponseStatus {\n" + 
		"      SUCCESS,\n" + 
		"      FAIL\n" + 
		"   }\n" + 
		"\n" + 
		"   private enum PayloadType {\n" + 
		"      STRING,\n" + 
		"      JSONOBJECT,\n" + 
		"      JSONARRAY,\n" + 
		"      EXCEPTION\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newSuccess(String payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"            put(\"payloadType\", PayloadType.STRING).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newSuccess(JsonObject payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"            put(\"payloadType\", PayloadType.JSONOBJECT).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newSuccess(JsonArray payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.SUCCESS).\n" + 
		"            put(\"payloadType\", PayloadType.JSONARRAY).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newFail(String payload) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.FAIL).\n" + 
		"            put(\"payloadType\", PayloadType.STRING).\n" + 
		"            put(\"payload\", payload);\n" + 
		"   }\n" + 
		"\n" + 
		"   public static JsonObject newException(Exception e) {\n" + 
		"      return new JsonObject().\n" + 
		"            put(\"status\", ResponseStatus.FAIL).\n" + 
		"            put(\"payloadType\", PayloadType.EXCEPTION).\n" + 
		"            put(\"payload\", e.getMessage());\n" + 
		"   }\n" + 
		"\n" + 
		"   public abstract static class EventbusHandler extends ResponseHandler implements Handler<Buffer> {\n" + 
		"\n" + 
		"      protected EventbusHandler(Logger log) {\n" + 
		"         super(log);\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public void handle(Buffer buffer) {\n" + 
		"         final JsonObject message = new JsonObject(buffer.toString());\n" + 
		"         log.debug(message.encode());\n" + 
		"         handleResponse(message.getJsonObject(\"body\"));\n" + 
		"      }\n" + 
		"   }\n" + 
		"\n" + 
		"   public abstract static class ResponseHandler implements VertxUtil.SuccessHandler<Message<JsonObject~gt()~> {\n" + 
		"\n" + 
		"      protected final Logger log;\n" + 
		"\n" + 
		"      protected ResponseHandler(Logger log) {\n" + 
		"         this.log = log;\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public final void onSuccess(Message<JsonObject> result) {\n" + 
		"         handleResponse(result.body());\n" + 
		"      }\n" + 
		"\n" + 
		"      void handleResponse(JsonObject message) {\n" + 
		"         switch (ResponseStatus.valueOf(message.getString(\"status\"))) {\n" + 
		"\n" + 
		"            case SUCCESS:\n" + 
		"               switch (PayloadType.valueOf(message.getString(\"payloadType\"))) {\n" + 
		"                  case STRING:\n" + 
		"                     handleSuccess(message.getString(\"payload\"));\n" + 
		"                     break;\n" + 
		"                  case JSONOBJECT:\n" + 
		"                     handleSuccess(message.getJsonObject(\"payload\"));\n" + 
		"                     break;\n" + 
		"                  case JSONARRAY:\n" + 
		"                     handleSuccess(message.getJsonArray(\"payload\"));\n" + 
		"                     break;\n" + 
		"               }\n" + 
		"               break;\n" + 
		"\n" + 
		"            case FAIL:\n" + 
		"               switch (PayloadType.valueOf(message.getString(\"payloadType\"))) {\n" + 
		"                  case STRING:\n" + 
		"                     handleFail(message.getString(\"payload\"));\n" + 
		"                     break;\n" + 
		"                  case JSONOBJECT:\n" + 
		"                     handleFail(message.getJsonObject(\"payload\"));\n" + 
		"                     break;\n" + 
		"                  case JSONARRAY:\n" + 
		"                     handleFail(message.getJsonArray(\"payload\"));\n" + 
		"                     break;\n" + 
		"                  case EXCEPTION:\n" + 
		"                     handleException(message.getString(\"payload\"));\n" + 
		"                     break;\n" + 
		"               }\n" + 
		"               break;\n" + 
		"\n" + 
		"            default:\n" + 
		"               log.error(\"unrecognized status '\" + message.getString(\"status\") + \"'\");\n" + 
		"               break;\n" + 
		"         }\n" + 
		"      }\n" + 
		"\n" + 
		"      protected void handleException(String payload) {\n" + 
		"         log.warn(\"unhandled exception \" + payload);\n" + 
		"      }\n" + 
		"\n" + 
		"      protected void handleSuccess(String payload) {\n" + 
		"         log.warn(\"unhandled success \" + payload);\n" + 
		"      }\n" + 
		"\n" + 
		"      protected void handleSuccess(JsonObject payload) {\n" + 
		"         log.warn(\"unhandled success \" + payload.encode());\n" + 
		"      }\n" + 
		"\n" + 
		"      protected void handleSuccess(JsonArray payload) {\n" + 
		"         log.warn(\"unhandled success \" + payload.encode());\n" + 
		"      }\n" + 
		"\n" + 
		"      protected void handleFail(JsonArray payload) {\n" + 
		"         log.warn(\"unhandled fail\" + payload.encode());\n" + 
		"      }\n" + 
		"\n" + 
		"      protected void handleFail(JsonObject payload) {\n" + 
		"         log.warn(\"unhandled fail \" + payload.encode());\n" + 
		"      }\n" + 
		"\n" + 
		"      protected void handleFail(String payload) {\n" + 
		"         log.warn(\"unhandled fail \" + payload);\n" + 
		"      }\n" + 
		"\n" + 
		"      @Override\n" + 
		"      public void onFail(Throwable t) {\n" + 
		"         log.error(\"unhandled error \" + t.getMessage(), t);\n" + 
		"      }\n" + 
		"   }\n" + 
		"}>>\n")
			.append("mvn_eventbus_bridge(version) ::= <<<dependency>\n" + 
		"   <groupId>io.vertx</groupId>\n" + 
		"   <artifactId>vertx-tcp-eventbus-bridge</artifactId>\n" + 
		"	<version>~version~</version>\n" + 
		"</dependency> >>\n")
			.append("mvn_web(version) ::= <<<dependency>\n" + 
		"	<groupId>io.vertx</groupId>\n" + 
		"   <artifactId>vertx-web</artifactId>\n" + 
		"   <version>~version~</version>\n" + 
		"</dependency> >>\n")
			.append("mvn_webClient(version) ::= <<<dependency>\n" + 
		"  <groupId>io.vertx</groupId>\n" + 
		"  <artifactId>vertx-web-client</artifactId>\n" + 
		"  <version>~version~</version>\n" + 
		"</dependency> >>\n")
		.toString();
}