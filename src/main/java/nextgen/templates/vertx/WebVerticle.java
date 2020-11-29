package nextgen.templates.vertx;

public class WebVerticle {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _startStatements = new java.util.ArrayList<>();
	private java.util.List<RouteHandler> _handlers = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _routes = new java.util.ArrayList<>();

	WebVerticle(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WebVerticle");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _startStatements) st.add("startStatements", o);
		for (Object o : _handlers) st.add("handlers", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name,init}", map.get("type"), map.get("name"), map.get("init"));
		for (java.util.Map<String, Object> map : _routes) st.addAggr("routes.{action,url,handler}", map.get("action"), map.get("url"), map.get("handler"));
		return st.render().trim();
	}

	public WebVerticle setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public WebVerticle removePackageName() {
		this._packageName = null;
		return this;
	} 

	public WebVerticle setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public WebVerticle removeName() {
		this._name = null;
		return this;
	} 

	public WebVerticle addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public WebVerticle setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public WebVerticle setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public WebVerticle removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public WebVerticle removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public WebVerticle addStartStatements(Object value) {
		this._startStatements.add(value);
		return this;
	}

	public WebVerticle setStartStatements(Object[] value) {
		this._startStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public WebVerticle setStartStatements(java.util.Collection<Object> values) {
		this._startStatements.addAll(values);
		return this;
	}

	public WebVerticle removeStartStatements(Object value) {
		this._startStatements.remove(value);
		return this;
	}

	public WebVerticle removeStartStatements(int index) {
		this._startStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getStartStatements() {
		return this._startStatements;
	} 

	public WebVerticle addHandlers(RouteHandler value) {
		this._handlers.add(value);
		return this;
	}

	public WebVerticle setHandlers(RouteHandler[] value) {
		this._handlers.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public WebVerticle setHandlers(java.util.Collection<RouteHandler> values) {
		this._handlers.addAll(values);
		return this;
	}

	public WebVerticle removeHandlers(RouteHandler value) {
		this._handlers.remove(value);
		return this;
	}

	public WebVerticle removeHandlers(int index) {
		this._handlers.remove(index);
		return this;
	}

	public java.util.List<RouteHandler> getHandlers() {
		return this._handlers;
	} 

	public WebVerticle addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public WebVerticle setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public WebVerticle setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public WebVerticle removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public WebVerticle removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public WebVerticle addFields(Object _type, String _name, Object _init) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		map.put("init", _init);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public WebVerticle addFields(WebVerticle_Fields value) {
		return addFields(value._type, value._name, value._init);
	}

	public java.util.stream.Stream<WebVerticle_Fields> streamFields() {
		return this._fields.stream().map(WebVerticle_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(WebVerticle_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFields_Name() {
		return streamFields().map(WebVerticle_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Init() {
		return streamFields().map(WebVerticle_Fields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public static final class WebVerticle_Fields {

		Object _type;
		String _name;
		Object _init;

		public WebVerticle_Fields(Object _type, String _name, Object _init) {
			this._type = _type;
			this._name = _name;
			this._init = _init;
		}

		private WebVerticle_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (String) map.get("name");
			this._init = (Object) map.get("init");
		}

		public Object getType() {
			return this._type;
		}

		public String getName() {
			return this._name;
		}

		public Object getInit() {
			return this._init;
		}

	}  

	public WebVerticle addRoutes(Object _action, Object _url, Object _handler) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("action", _action);
		map.put("url", _url);
		map.put("handler", _handler);
		this._routes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRoutes() {
		return this._routes;
	}

	public WebVerticle addRoutes(WebVerticle_Routes value) {
		return addRoutes(value._action, value._url, value._handler);
	}

	public java.util.stream.Stream<WebVerticle_Routes> streamRoutes() {
		return this._routes.stream().map(WebVerticle_Routes::new);
	}

	public java.util.List<Object> getRoutes_Action() {
		return streamRoutes().map(WebVerticle_Routes::getAction).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getRoutes_Url() {
		return streamRoutes().map(WebVerticle_Routes::getUrl).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getRoutes_Handler() {
		return streamRoutes().map(WebVerticle_Routes::getHandler).collect(java.util.stream.Collectors.toList());
	}


	public static final class WebVerticle_Routes {

		Object _action;
		Object _url;
		Object _handler;

		public WebVerticle_Routes(Object _action, Object _url, Object _handler) {
			this._action = _action;
			this._url = _url;
			this._handler = _handler;
		}

		private WebVerticle_Routes(java.util.Map<String, Object> map) {
			this._action = (Object) map.get("action");
			this._url = (Object) map.get("url");
			this._handler = (Object) map.get("handler");
		}

		public Object getAction() {
			return this._action;
		}

		public Object getUrl() {
			return this._url;
		}

		public Object getHandler() {
			return this._handler;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WebVerticle that = (WebVerticle) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "WebVerticle(packageName,imports,name,fields,startStatements,routes,handlers,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.netty.handler.codec.http.HttpResponseStatus;\n" + 
				"import io.vertx.core.AbstractVerticle;\n" + 
				"import io.vertx.core.Future;\n" + 
				"import io.vertx.core.MultiMap;\n" + 
				"import io.vertx.core.Vertx;\n" + 
				"import io.vertx.core.eventbus.DeliveryOptions;\n" + 
				"import io.vertx.core.http.HttpHeaders;\n" + 
				"import io.vertx.core.http.HttpServerOptions;\n" + 
				"import io.vertx.core.json.JsonArray;\n" + 
				"import io.vertx.core.json.JsonObject;\n" + 
				"import io.vertx.core.net.PemKeyCertOptions;\n" + 
				"import io.vertx.ext.auth.jwt.JWTAuth;\n" + 
				"import io.vertx.ext.auth.jwt.JWTAuthOptions;\n" + 
				"import io.vertx.ext.jwt.JWTOptions;\n" + 
				"import io.vertx.ext.web.Router;\n" + 
				"import io.vertx.ext.web.RoutingContext;\n" + 
				"import io.vertx.ext.web.handler.BodyHandler;\n" + 
				"import io.vertx.ext.web.handler.JWTAuthHandler;\n" + 
				"import io.vertx.ext.web.handler.SessionHandler;\n" + 
				"import io.vertx.ext.web.handler.StaticHandler;\n" + 
				"import io.vertx.ext.web.sstore.LocalSessionStore;\n" + 
				"\n" + 
				"import java.util.Map;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.concurrent.atomic.AtomicInteger;\n" + 
				"\n" + 
				"import static io.netty.handler.codec.http.HttpResponseStatus.*;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ extends AbstractVerticle {\n" + 
				"\n" + 
				"	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name;format=\"capitalize\"~.class);\n" + 
				"	private static final String JSON_CONTENT_TYPE = \"application/json; charset=utf-8\";\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void start(Future<Void> startFuture) throws Exception {\n" + 
				"		log.info(\"starting ~name;format=\"capitalize\"~\");\n" + 
				"\n" + 
				"		~startStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"		final Router router = Router.router(vertx);\n" + 
				"		router.route().handler(BodyHandler.create());\n" + 
				"		router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));\n" + 
				"		~routes:{it|router.~it.action~(\"/~it.url~\").handler(~it.handler~);};separator=\"\\n\"~\n" + 
				"\n" + 
				"		final HttpServerOptions serverOptions = new HttpServerOptions();\n" + 
				"\n" + 
				"		ssl.ifPresent(sslDeploymentSettings ->\n" + 
				"				serverOptions\n" + 
				"						.setSsl(true)\n" + 
				"						.setPemKeyCertOptions(\n" + 
				"								new PemKeyCertOptions().\n" + 
				"										setKeyPath(sslDeploymentSettings.getKey()).\n" + 
				"										setCertPath(sslDeploymentSettings.getCert())));\n" + 
				"\n" + 
				"		final StaticHandler staticHandler = StaticHandler.create();\n" + 
				"		staticHandler.setWebRoot(deploymentOptions.getWebRoot());\n" + 
				"		staticHandler.setCachingEnabled(false);\n" + 
				"		staticHandler.setEnableRangeSupport(true);\n" + 
				"		router.route(\"/*\").handler(staticHandler);\n" + 
				"\n" + 
				"		vertx.createHttpServer(serverOptions).requestHandler(router::accept).listen(deploymentOptions.getPort());\n" + 
				"\n" + 
				"		log.info(\"server running on \" + (ssl.isPresent() ? \"https\" : \"http\") + \"://\" + deploymentOptions.getTcpHost() + \":\" + deploymentOptions.getPort());\n" + 
				"		log.info(\"server running on \" + (ssl.isPresent() ? \"https\" : \"http\") + \"://\" + deploymentOptions.getTcpName() + \":\" + deploymentOptions.getPort());\n" + 
				"\n" + 
				"		startFuture.succeeded();\n" + 
				"	}\n" + 
				"\n" + 
				"	~handlers:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private static void getFromDomainDB(Vertx vertx, RoutingContext routingContext, String action, JsonObject params) {\n" + 
				"		vertx.eventBus().request(\"domain.db\", params, new DeliveryOptions().addHeader(\"action\", action), reply -> {\n" + 
				"			if (reply.succeeded()) {\n" + 
				"				JsonObject body = (JsonObject) reply.result().body();\n" + 
				"				log.info(body.encode());\n" + 
				"				sendResponse(routingContext, OK, body);\n" + 
				"			} else {\n" + 
				"				sendErrors(routingContext, INTERNAL_SERVER_ERROR,	\"Server Error\");\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private static void sendErrors(RoutingContext routingContext, HttpResponseStatus httpResponseStatus, String... errors) {\n" + 
				"		final JsonArray errorsArray = new JsonArray();\n" + 
				"		for (String error : errors)\n" + 
				"				errorsArray.add(error.trim());\n" + 
				"\n" + 
				"		final String encode = new JsonObject().put(\"errors\", errorsArray).encode();\n" + 
				"		log.info(routingContext.request().absoluteURI() + \" \" + encode);\n" + 
				"		routingContext.response()\n" + 
				"					.setStatusCode(httpResponseStatus.code())\n" + 
				"					.putHeader(HttpHeaders.CONTENT_LENGTH, encode.length() + \"\")\n" + 
				"					.putHeader(HttpHeaders.CONTENT_TYPE, JSON_CONTENT_TYPE)\n" + 
				"					.end(encode);\n" + 
				"	}\n" + 
				"\n" + 
				"	private static void sendResponse(RoutingContext routingContext, HttpResponseStatus httpResponseStatus, JsonObject response) {\n" + 
				"		final String encode = response.encode();\n" + 
				"		log.info(routingContext.request().absoluteURI() + \" \" + encode);\n" + 
				"		routingContext.response()\n" + 
				"					.setStatusCode(httpResponseStatus.code())\n" + 
				"					.putHeader(HttpHeaders.CONTENT_LENGTH, encode.length() + \"\")\n" + 
				"					.putHeader(HttpHeaders.CONTENT_TYPE, JSON_CONTENT_TYPE)\n" + 
				"					.end(encode);\n" + 
				"	}\n" + 
				"\n" + 
				"	private static void debug(String method, RoutingContext routingContext) {\n" + 
				"		final String uri = method + \" \" + routingContext.request().method().name() + \" \" + routingContext.request().uri();\n" + 
				"		boolean isAuthenticated = routingContext.user() != null;\n" + 
				"		log.info(uri + \" \" + (isAuthenticated ? \"(authenticated)\" : \"(NOT authenticated)\"));\n" + 
				"		final MultiMap headers = routingContext.request().headers();\n" + 
				"		for (Map.Entry<String, String> header : headers)\n" + 
				"				log.info(\"\\t\" + header.getKey() + \"=\" + header.getValue());\n" + 
				"		log.info(\"body \" + routingContext.getBody().toString());\n" + 
				"	}\n" + 
				"} >>";
}  