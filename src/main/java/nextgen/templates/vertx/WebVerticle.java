package nextgen.templates.vertx;

public class WebVerticle {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _packageName;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _startStatements = new java.util.ArrayList<>();
	private java.util.List<RouteHandler> _handlers = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _routes = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	WebVerticle(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WebVerticle");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _startStatements) st.add("startStatements", o);
		for (Object o : _handlers) st.add("handlers", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _routes) st.addAggr("routes.{order,url,action,handler}", map.get("order"), map.get("url"), map.get("action"), map.get("handler"));
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{init,name,type}", map.get("init"), map.get("name"), map.get("type"));
		return st.render().trim();
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

	public WebVerticle setRoutes(java.util.Collection<WebVerticle_Routes> values) {
			this._routes.clear();
			values.stream().map(WebVerticle_Routes::asMap).forEach(map -> _routes.add(map));
			return this;
		}

	public WebVerticle addRoutes(Object _order, Object _url, Object _action, Object _handler) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("order", _order);
		map.put("url", _url);
		map.put("action", _action);
		map.put("handler", _handler);
		this._routes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRoutes() {
		return this._routes;
	}

	public WebVerticle addRoutes(WebVerticle_Routes value) {
		return addRoutes(value._order, value._url, value._action, value._handler);
	}

	public java.util.stream.Stream<WebVerticle_Routes> streamRoutes() {
		return this._routes.stream().map(WebVerticle_Routes::new);
	}

	public java.util.List<Object> getRoutes_Order() {
		return streamRoutes().map(WebVerticle_Routes::getOrder).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getRoutes_Url() {
		return streamRoutes().map(WebVerticle_Routes::getUrl).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getRoutes_Action() {
		return streamRoutes().map(WebVerticle_Routes::getAction).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getRoutes_Handler() {
		return streamRoutes().map(WebVerticle_Routes::getHandler).collect(java.util.stream.Collectors.toList());
	}


	public static final class WebVerticle_Routes {

		Object _order;
		Object _url;
		Object _action;
		Object _handler;

		public WebVerticle_Routes(Object _order, Object _url, Object _action, Object _handler) {
			this._order = _order;
			this._url = _url;
			this._action = _action;
			this._handler = _handler;
		}

		private WebVerticle_Routes(java.util.Map<String, Object> map) {
			this._order = (Object) map.get("order");
			this._url = (Object) map.get("url");
			this._action = (Object) map.get("action");
			this._handler = (Object) map.get("handler");
		}

		public Object getOrder() {
			return this._order;
		}

		public Object getUrl() {
			return this._url;
		}

		public Object getAction() {
			return this._action;
		}

		public Object getHandler() {
			return this._handler;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("order", _order);
			map.put("url", _url);
			map.put("action", _action);
			map.put("handler", _handler);
			return map;
		}

	}  

	public WebVerticle setFields(java.util.Collection<WebVerticle_Fields> values) {
			this._fields.clear();
			values.stream().map(WebVerticle_Fields::asMap).forEach(map -> _fields.add(map));
			return this;
		}

	public WebVerticle addFields(Object _init, String _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("init", _init);
		map.put("name", _name);
		map.put("type", _type);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public WebVerticle addFields(WebVerticle_Fields value) {
		return addFields(value._init, value._name, value._type);
	}

	public java.util.stream.Stream<WebVerticle_Fields> streamFields() {
		return this._fields.stream().map(WebVerticle_Fields::new);
	}

	public java.util.List<Object> getFields_Init() {
		return streamFields().map(WebVerticle_Fields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFields_Name() {
		return streamFields().map(WebVerticle_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(WebVerticle_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class WebVerticle_Fields {

		Object _init;
		String _name;
		Object _type;

		public WebVerticle_Fields(Object _init, String _name, Object _type) {
			this._init = _init;
			this._name = _name;
			this._type = _type;
		}

		private WebVerticle_Fields(java.util.Map<String, Object> map) {
			this._init = (Object) map.get("init");
			this._name = (String) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getInit() {
			return this._init;
		}

		public String getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("init", _init);
			map.put("name", _name);
			map.put("type", _type);
			return map;
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

	static final String st = "WebVerticle(imports,startStatements,handlers,routes,methods,name,fields,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.netty.handler.codec.http.HttpResponseStatus;\n" + 
				"import io.vertx.core.AbstractVerticle;\n" + 
				"import io.vertx.core.Future;\n" + 
				"import io.vertx.core.MultiMap;\n" + 
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
				"\n" + 
				"import static io.netty.handler.codec.http.HttpResponseStatus.*;\n" + 
				"\n" + 
				"~imports:{it|import ~it~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ extends AbstractVerticle {\n" + 
				"\n" + 
				"	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name;format=\"capitalize\"~.class);\n" + 
				"	private static final String JSON_CONTENT_TYPE = \"application/json; charset=utf-8\";\n" + 
				"	private static final String HTML_CONTENT_TYPE = \"text/html; charset=utf-8\";\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void start(Future<Void> startFuture) throws Exception {\n" + 
				"		log.info(\"starting ~name;format=\"capitalize\"~\");\n" + 
				"\n" + 
				"		~startStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"		final JWTAuth auth = JWTAuth.create(vertx, new JWTAuthOptions()\n" + 
				"				.addPubSecKey(new io.vertx.ext.auth.PubSecKeyOptions()\n" + 
				"						.setAlgorithm(config().getString(\"jwt.algorithm\"))\n" + 
				"						.setPublicKey(readPem(config().getString(\"jwt.publicKey\")))\n" + 
				"						.setSecretKey(readPem(config().getString(\"jwt.secretKey\")))\n" + 
				"				));\n" + 
				"\n" + 
				"		final Router router = Router.router(vertx);\n" + 
				"		router.route().handler(BodyHandler.create());\n" + 
				"		router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));\n" + 
				"		router.post(\"/login\").handler(routingContext -> login(routingContext, auth));\n" + 
				"		router.route(\"/secure/*\").handler(JWTAuthHandler.create(auth, \"/login\"));\n" + 
				"		~routes:{it|router.~it.action~(\"/~it.url~\")~if(it.order)~.order(~it.order~)~endif~.handler(this::~it.handler~);};separator=\"\\n\"~\n" + 
				"		\n" + 
				"		final HttpServerOptions serverOptions = new HttpServerOptions();\n" + 
				"\n" + 
				"		if (config().getBoolean(\"ssl\", false)) {\n" + 
				"			serverOptions\n" + 
				"					.setSsl(true)\n" + 
				"					.setPemKeyCertOptions(\n" + 
				"							new PemKeyCertOptions().\n" + 
				"									setKeyPath(config().getString(\"ssl.keyPath\")).\n" + 
				"									setCertPath(config().getString(\"ssl.certPath\")));\n" + 
				"		}\n" + 
				"\n" + 
				"		final StaticHandler staticHandler = StaticHandler.create();\n" + 
				"		staticHandler.setWebRoot(config().getString(\"web.root\"));\n" + 
				"		staticHandler.setCachingEnabled(config().getBoolean(\"web.cachingEnabled\"));\n" + 
				"		staticHandler.setEnableRangeSupport(config().getBoolean(\"web.enableRangeSupport\"));\n" + 
				"		router.route(\"/*\").handler(staticHandler);\n" + 
				"\n" + 
				"		vertx.createHttpServer(serverOptions).requestHandler(router::accept).listen(config().getInteger(\"web.port\"));\n" + 
				"\n" + 
				"		log.info(\"server running on \" + (config().getBoolean(\"ssl\",false) ? \"https\" : \"http\") + \"://\" + config().getString(\"web.host\") + \":\" + config().getInteger(\"web.port\"));\n" + 
				"\n" + 
				"		startFuture.succeeded();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void login(RoutingContext routingContext, JWTAuth auth) {\n" + 
				"		debug(\"login\", routingContext);\n" + 
				"\n" + 
				"		vertx.eventBus().request(\"login\", routingContext.getBodyAsJson(), reply -> {\n" + 
				"\n" + 
				"			if (reply.succeeded()) {\n" + 
				"				final JsonObject replyBody = (JsonObject) reply.result().body();\n" + 
				"\n" + 
				"				if (replyBody.getBoolean(\"login.success\", false)) {\n" + 
				"\n" + 
				"					final String token = auth.generateToken(\n" + 
				"							new io.vertx.core.json.JsonObject().put(\"sub\", replyBody.getString(\"username\")),\n" + 
				"							new JWTOptions()\n" + 
				"									.setAlgorithm(config().getString(\"jwt.algorithm\"))\n" + 
				"									.setExpiresInMinutes(config().getInteger(\"jwt.expiresInMinutes\"))\n" + 
				"									.setSubject(replyBody.getString(\"username\")));\n" + 
				"\n" + 
				"					final JsonObject session = new io.vertx.core.json.JsonObject()\n" + 
				"							.put(\"username\", replyBody.getString(\"username\"))\n" + 
				"							.put(\"token\", token);\n" + 
				"\n" + 
				"					sendResponse(routingContext, OK, session);\n" + 
				"\n" + 
				"				} else {\n" + 
				"\n" + 
				"					sendResponse(routingContext, OK, replyBody);	\n" + 
				"				}\n" + 
				"\n" + 
				"			} else {\n" + 
				"\n" + 
				"				sendErrors(routingContext, INTERNAL_SERVER_ERROR,	\"Server Error\");\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	~handlers:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	static void sendErrors(RoutingContext routingContext, HttpResponseStatus httpResponseStatus, String... errors) {\n" + 
				"		final JsonArray errorsArray = new JsonArray();\n" + 
				"		for (String error : errors)\n" + 
				"			errorsArray.add(error.trim());\n" + 
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
				"	static void sendResponse(RoutingContext routingContext, HttpResponseStatus httpResponseStatus, JsonObject response) {\n" + 
				"		final String encode = response.encode();\n" + 
				"		log.info(routingContext.request().absoluteURI() + \" \" + encode);\n" + 
				"		routingContext.response()\n" + 
				"				.setStatusCode(httpResponseStatus.code())\n" + 
				"				.putHeader(HttpHeaders.CONTENT_LENGTH, encode.length() + \"\")\n" + 
				"				.putHeader(HttpHeaders.CONTENT_TYPE, JSON_CONTENT_TYPE)\n" + 
				"				.end(encode);\n" + 
				"	}\n" + 
				"\n" + 
				"	static void sendHtmlResponse(RoutingContext routingContext, HttpResponseStatus httpResponseStatus, String html) {\n" + 
				"		log.info(routingContext.request().absoluteURI() + \" \" + html);\n" + 
				"		routingContext.response()\n" + 
				"				.setStatusCode(httpResponseStatus.code())\n" + 
				"				.putHeader(HttpHeaders.CONTENT_LENGTH, html.length() + \"\")\n" + 
				"				.putHeader(HttpHeaders.CONTENT_TYPE, HTML_CONTENT_TYPE)\n" + 
				"				.end(html);\n" + 
				"	}\n" + 
				"\n" + 
				"	static void debug(String method, RoutingContext routingContext) {\n" + 
				"		final String uri = method + \" \" + routingContext.request().method().name() + \" \" + routingContext.request().uri();\n" + 
				"		boolean isAuthenticated = routingContext.user() != null;\n" + 
				"		log.info(uri + \" \" + (isAuthenticated ? \"(authenticated)\" : \"(NOT authenticated)\"));\n" + 
				"		final MultiMap headers = routingContext.request().headers();\n" + 
				"		for (Map.Entry<String, String> header : headers)\n" + 
				"				log.info(\"\\t\" + header.getKey() + \"=\" + header.getValue());\n" + 
				"		log.info(\"body \" + routingContext.getBody().toString());\n" + 
				"	}\n" + 
				"\n" + 
				"	private String readPem(String path) throws java.io.IOException {\n" + 
				"		final java.io.File file = new java.io.File(path);\n" + 
				"		final java.io.BufferedInputStream inputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));\n" + 
				"		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();\n" + 
				"		int read;\n" + 
				"		byte[] data = new byte[2048];\n" + 
				"		while ((read = inputStream.read(data, 0, data.length)) != -1)\n" + 
				"			buffer.write(data, 0, read);\n" + 
				"		inputStream.close();\n" + 
				"		final byte[] content = buffer.toByteArray();\n" + 
				"		buffer.close();\n" + 
				"		final String s = new String(content);\n" + 
				"		final int startIndex = s.indexOf(\"KEY-----\") + 8;\n" + 
				"		final int endIndex = s.indexOf(\"-----END\");\n" + 
				"		return s.substring(startIndex, endIndex).trim();\n" + 
				"	}\n" + 
				"} >>";
}  