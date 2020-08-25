package nextgen.templates.vertx;

public class WebVerticle {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _startStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _routes = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _rawRoutes = new java.util.ArrayList<>();

	WebVerticle(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
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
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name,init}", map.get("type"), map.get("name"), map.get("init"));
		for (java.util.Map<String, Object> map : _routes) st.addAggr("routes.{action,url,methodName,declaration}", map.get("action"), map.get("url"), map.get("methodName"), map.get("declaration"));
		for (java.util.Map<String, Object> map : _rawRoutes) st.addAggr("rawRoutes.{action,url,methodName,declaration}", map.get("action"), map.get("url"), map.get("methodName"), map.get("declaration"));
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

	public WebVerticle addFields(Object _type, Object _name, Object _init) {
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

	public static final class WebVerticle_Fields {

		Object _type;
		Object _name;
		Object _init;

		public WebVerticle_Fields(Object _type, Object _name, Object _init) {
			this._type = _type;
			this._name = _name;
			this._init = _init;
		}

		private WebVerticle_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._init = (Object) map.get("init");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getInit() {
			return this._init;
		}

	} 

	public WebVerticle addRoutes(String _action, String _url, String _methodName, RouteHandler _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("action", _action);
		map.put("url", _url);
		map.put("methodName", _methodName);
		map.put("declaration", _declaration);
		this._routes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRoutes() {
		return this._routes;
	}

	public WebVerticle addRoutes(WebVerticle_Routes value) {
		return addRoutes(value._action, value._url, value._methodName, value._declaration);
	}

	public java.util.stream.Stream<WebVerticle_Routes> streamRoutes() {
		return this._routes.stream().map(WebVerticle_Routes::new);
	}

	public static final class WebVerticle_Routes {

		String _action;
		String _url;
		String _methodName;
		RouteHandler _declaration;

		public WebVerticle_Routes(String _action, String _url, String _methodName, RouteHandler _declaration) {
			this._action = _action;
			this._url = _url;
			this._methodName = _methodName;
			this._declaration = _declaration;
		}

		private WebVerticle_Routes(java.util.Map<String, Object> map) {
			this._action = (String) map.get("action");
			this._url = (String) map.get("url");
			this._methodName = (String) map.get("methodName");
			this._declaration = (RouteHandler) map.get("declaration");
		}

		public String getAction() {
			return this._action;
		}

		public String getUrl() {
			return this._url;
		}

		public String getMethodName() {
			return this._methodName;
		}

		public RouteHandler getDeclaration() {
			return this._declaration;
		}

	} 

	public WebVerticle addRawRoutes(Object _action, Object _url, Object _methodName, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("action", _action);
		map.put("url", _url);
		map.put("methodName", _methodName);
		map.put("declaration", _declaration);
		this._rawRoutes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRawRoutes() {
		return this._rawRoutes;
	}

	public WebVerticle addRawRoutes(WebVerticle_RawRoutes value) {
		return addRawRoutes(value._action, value._url, value._methodName, value._declaration);
	}

	public java.util.stream.Stream<WebVerticle_RawRoutes> streamRawRoutes() {
		return this._rawRoutes.stream().map(WebVerticle_RawRoutes::new);
	}

	public static final class WebVerticle_RawRoutes {

		Object _action;
		Object _url;
		Object _methodName;
		Object _declaration;

		public WebVerticle_RawRoutes(Object _action, Object _url, Object _methodName, Object _declaration) {
			this._action = _action;
			this._url = _url;
			this._methodName = _methodName;
			this._declaration = _declaration;
		}

		private WebVerticle_RawRoutes(java.util.Map<String, Object> map) {
			this._action = (Object) map.get("action");
			this._url = (Object) map.get("url");
			this._methodName = (Object) map.get("methodName");
			this._declaration = (Object) map.get("declaration");
		}

		public Object getAction() {
			return this._action;
		}

		public Object getUrl() {
			return this._url;
		}

		public Object getMethodName() {
			return this._methodName;
		}

		public Object getDeclaration() {
			return this._declaration;
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

	static final String st = "WebVerticle(packageName,imports,name,fields,startStatements,routes,rawRoutes) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.vertx.core.AbstractVerticle;\n" + 
				"import io.vertx.core.Future;\n" + 
				"import io.vertx.core.Vertx;\n" + 
				"import io.vertx.core.eventbus.DeliveryOptions;\n" + 
				"import io.vertx.core.http.HttpServerOptions;\n" + 
				"import io.vertx.core.json.JsonObject;\n" + 
				"import io.vertx.core.net.PemKeyCertOptions;\n" + 
				"import io.vertx.ext.auth.KeyStoreOptions;\n" + 
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
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void start(Future<Void> startFuture) throws Exception {\n" + 
				"		log.info(\"starting ~name;format=\"capitalize\"~\");\n" + 
				"\n" + 
				"		~startStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		\n" + 
				"		final Router router = Router.router(vertx);\n" + 
				"		router.route().handler(BodyHandler.create());\n" + 
				"		router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));\n" + 
				"		router.post(\"/login\").handler(routingContext -> login(routingContext, auth, config));\n" + 
				"		router.route(\"/api/*\").handler(JWTAuthHandler.create(auth, \"/login\"));\n" + 
				"		router.get(\"/user\").handler(routingContext -> getUser(routingContext, config));\n" + 
				"		~routes:{it|router.~it.action~(\"/~it.url~\").handler(this::~it.methodName~);};separator=\"\\n\"~\n" + 
				"		~rawRoutes:{it|router.~it.action~(\"~it.url~\").handler(this::~it.methodName~);};separator=\"\\n\"~\n" + 
				"		\n" + 
				"		final HttpServerOptions serverOptions = new HttpServerOptions();\n" + 
				"		final Optional<SSLConfig> ssl = Optional.ofNullable(config.getSsl());\n" + 
				"\n" + 
				"		ssl.ifPresent(sslConfig ->\n" + 
				"				serverOptions\n" + 
				"						.setSsl(true)\n" + 
				"						.setPemKeyCertOptions(\n" + 
				"								new PemKeyCertOptions().\n" + 
				"											setKeyPath(sslConfig.getKey()).\n" + 
				"											setCertPath(sslConfig.getCert())));\n" + 
				"\n" + 
				"		final StaticHandler staticHandler = StaticHandler.create();\n" + 
				"		staticHandler.setWebRoot(config.getWebRoot());\n" + 
				"		staticHandler.setCachingEnabled(false);\n" + 
				"		staticHandler.setIndexPage(\"index.html\");\n" + 
				"		router.route(\"/*\").handler(staticHandler);\n" + 
				"\n" + 
				"		vertx.createHttpServer(serverOptions).requestHandler(router::accept).listen(config.getPort());\n" + 
				"\n" + 
				"		log.info(\"server running on \" + (ssl.isPresent() ? \"https\" : \"http\") + \"://\" + config.getTcpHost() + \":\" + config.getPort());\n" + 
				"		log.info(\"server running on \" + (ssl.isPresent() ? \"https\" : \"http\") + \"://\" + config.getTcpName(\"securityxresidential.info\") + \":\" + config.getPort());\n" + 
				"\n" + 
				"		startFuture.succeeded();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void login(RoutingContext routingContext, JWTAuth auth, ~name;format=\"capitalize\"~Config deploymentOptions) {\n" + 
				"		WebUtils.debug(\"login\", routingContext);\n" + 
				"\n" + 
				"		final LoginRequest loginRequest = newLoginRequest(routingContext.getBodyAsJson());\n" + 
				"\n" + 
				"		final Optional<UserConfig> foundUserConfig = deploymentOptions.getJwt().getUsers()\n" + 
				"				.filter(userConfig -> userConfig.getUsername() != null && userConfig.getPassword() != null)\n" + 
				"				.filter(userConfig -> userConfig.getUsername().equals(loginRequest.getUsername()))\n" + 
				"				.findFirst();\n" + 
				"\n" + 
				"		if (!foundUserConfig.isPresent()) {\n" + 
				"			sendErrors(routingContext, UNAUTHORIZED, \"User credentials not found\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final boolean passwordMatch = verifyUserPassword(loginRequest.getPassword(), foundUserConfig.get().getPassword(), foundUserConfig.get().getSalt());\n" + 
				"\n" + 
				"		if (!passwordMatch) {\n" + 
				"			sendErrors(routingContext, UNAUTHORIZED, \"User credentials not found\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final UserSession userSession = newUserSession()\n" + 
				"			.setToken(auth.generateToken(\n" + 
				"					newJWTPayload()\n" + 
				"							.setSub(foundUserConfig.get().getUsername())\n" + 
				"							.getJsonObject(),\n" + 
				"					new JWTOptions()\n" + 
				"							.setExpiresInMinutes(deploymentOptions.getJwt().getExpiresInMinutes())\n" + 
				"							.setSubject(foundUserConfig.get().getUsername())))\n" + 
				"			.setUsername(foundUserConfig.get().getUsername());\n" + 
				"\n" + 
				"		final AtomicInteger id = new AtomicInteger(0);\n" + 
				"		foundUserConfig.get().getAccess()\n" + 
				"			.forEach(webPageAccessSettings -> userSession.addMenus(newUserMenu()\n" + 
				"						.setKey(id.incrementAndGet())\n" + 
				"						.setLabel(webPageAccessSettings.getLabel())\n" + 
				"						.setUrl(webPageAccessSettings.getUrl())));\n" + 
				"\n" + 
				"		foundUserConfig.get().setSession(userSession);\n" + 
				"\n" + 
				"		sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getUser(RoutingContext routingContext, ~name;format=\"capitalize\"~Config deploymentOptions) {\n" + 
				"		WebUtils.debug(\"getUser\", routingContext);\n" + 
				"\n" + 
				"		final String authorization = routingContext.request().getHeader(\"Authorization\");\n" + 
				"		final String token = authorization == null ? null : authorization.substring(7).trim();\n" + 
				"\n" + 
				"		final Optional<UserSession> userSession = deploymentOptions.getJwt().getUsers()\n" + 
				"				.filter(userConfig -> userConfig.getSession() != null)\n" + 
				"				.map(UserConfig::getSession)\n" + 
				"				.filter(session -> session.getToken().equals(token))\n" + 
				"				.findFirst();\n" + 
				"\n" + 
				"		if (!userSession.isPresent())\n" + 
				"			sendErrors(routingContext, UNAUTHORIZED,	\"User session not found\");\n" + 
				"		else\n" + 
				"			sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.get().getJsonObject()));\n" + 
				"	}\n" + 
				"\n" + 
				"	~routes:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"	~rawRoutes:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private static void getFromDomainDB(Vertx vertx, RoutingContext routingContext, String action, JsonObject params) {\n" + 
				"		vertx.eventBus().request(\"domain.db\", params, new DeliveryOptions().addHeader(\"action\", action), reply -> {\n" + 
				"			if (reply.succeeded()) {\n" + 
				"				sendResponse(routingContext, OK, (JsonObject) reply.result().body());\n" + 
				"			} else {\n" + 
				"				sendErrors(routingContext, INTERNAL_SERVER_ERROR,	\"Server Error\");\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"} >>";
}  