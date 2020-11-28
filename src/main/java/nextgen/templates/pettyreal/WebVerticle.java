package nextgen.templates.pettyreal;

public class WebVerticle {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _endpoints = new java.util.ArrayList<>();

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
		for (java.util.Map<String, Object> map : _endpoints) st.addAggr("endpoints.{action,route,handler,handlerImpl}", map.get("action"), map.get("route"), map.get("handler"), map.get("handlerImpl"));
		return st.render().trim();
	}

	public WebVerticle setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public WebVerticle removePackageName() {
		this._packageName = null;
		return this;
	} 

	public WebVerticle setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public WebVerticle removeName() {
		this._name = null;
		return this;
	} 


	public WebVerticle addEndpoints(Object _action, Object _route, Object _handler, Object _handlerImpl) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("action", _action);
		map.put("route", _route);
		map.put("handler", _handler);
		map.put("handlerImpl", _handlerImpl);
		this._endpoints.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEndpoints() {
		return this._endpoints;
	}

	public WebVerticle addEndpoints(WebVerticle_Endpoints value) {
		return addEndpoints(value._action, value._route, value._handler, value._handlerImpl);
	}

	public java.util.stream.Stream<WebVerticle_Endpoints> streamEndpoints() {
		return this._endpoints.stream().map(WebVerticle_Endpoints::new);
	}

	public java.util.List<Object> getEndpoints_Action() {
		return streamEndpoints().map(WebVerticle_Endpoints::getAction).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getEndpoints_Route() {
		return streamEndpoints().map(WebVerticle_Endpoints::getRoute).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getEndpoints_Handler() {
		return streamEndpoints().map(WebVerticle_Endpoints::getHandler).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getEndpoints_HandlerImpl() {
		return streamEndpoints().map(WebVerticle_Endpoints::getHandlerImpl).collect(java.util.stream.Collectors.toList());
	}


	public static final class WebVerticle_Endpoints {

		Object _action;
		Object _route;
		Object _handler;
		Object _handlerImpl;

		public WebVerticle_Endpoints(Object _action, Object _route, Object _handler, Object _handlerImpl) {
			this._action = _action;
			this._route = _route;
			this._handler = _handler;
			this._handlerImpl = _handlerImpl;
		}

		private WebVerticle_Endpoints(java.util.Map<String, Object> map) {
			this._action = (Object) map.get("action");
			this._route = (Object) map.get("route");
			this._handler = (Object) map.get("handler");
			this._handlerImpl = (Object) map.get("handlerImpl");
		}

		public Object getAction() {
			return this._action;
		}

		public Object getRoute() {
			return this._route;
		}

		public Object getHandler() {
			return this._handler;
		}

		public Object getHandlerImpl() {
			return this._handlerImpl;
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

	static final String st = "WebVerticle(packageName,name,endpoints) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import ~packageName~.api.LoginRequest;\n" + 
				"import ~packageName~.api.UserSession;\n" + 
				"import ~packageName~.domain.SSLDeploymentSettings;\n" + 
				"import ~packageName~.domain.ServerDeploymentOptions;\n" + 
				"import ~packageName~.domain.UserDeploymentSettings;\n" + 
				"import io.netty.handler.codec.http.HttpResponseStatus;\n" + 
				"import io.vertx.core.AbstractVerticle;\n" + 
				"import io.vertx.core.Future;\n" + 
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
				"import java.io.File;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.concurrent.atomic.AtomicInteger;\n" + 
				"\n" + 
				"import static ~packageName~.PasswordUtils.verifyUserPassword;\n" + 
				"import static ~packageName~.WebUtils.*;\n" + 
				"import static ~packageName~.api.WebApiJsonFactory.*;\n" + 
				"import static io.netty.handler.codec.http.HttpResponseStatus.*;\n" + 
				"\n" + 
				"public class ~name~ extends AbstractVerticle {\n" + 
				"\n" + 
				"	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void start(Future<Void> startFuture) throws Exception {\n" + 
				"		log.info(\"starting ~name~\");\n" + 
				"\n" + 
				"		final ServerDeploymentOptions deploymentOptions = new ServerDeploymentOptions(config());\n" + 
				"		final Optional<SSLDeploymentSettings> ssl = Optional.ofNullable(deploymentOptions.getSsl());\n" + 
				"\n" + 
				"		final KeyStoreOptions keyStoreOptions = new KeyStoreOptions().\n" + 
				"					setPath(deploymentOptions.getJwt().getPath()).\n" + 
				"					setPassword(deploymentOptions.getJwt().getPassword()).\n" + 
				"					setType(deploymentOptions.getJwt().getType());\n" + 
				"\n" + 
				"		final JWTAuthOptions jwtAuthOptions = new JWTAuthOptions().setKeyStore(keyStoreOptions);\n" + 
				"		final JWTAuth auth = JWTAuth.create(vertx, jwtAuthOptions);\n" + 
				"\n" + 
				"		final Router router = Router.router(vertx);\n" + 
				"		router.route().handler(BodyHandler.create());\n" + 
				"		router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));\n" + 
				"		router.post(\"/login\").handler(routingContext -> login(routingContext, auth));\n" + 
				"		router.route(\"/api/*\").handler(JWTAuthHandler.create(auth, \"/login\"));\n" + 
				"		router.get(\"/user\").handler(this::getUser);\n" + 
				"		router.get(\"/images/:name\").handler(this::getImage);\n" + 
				"		~endpoints:{it|router.~it.action~(\"~it.route~\").handler(this::~it.handler~);};separator=\"\\n\"~\n" + 
				"		router.get(\"/api/current\").handler(this::getCurrent);\n" + 
				"		router.get(\"/report/current\").handler(this::getReport);\n" + 
				"\n" + 
				"		final HttpServerOptions serverOptions = new HttpServerOptions();\n" + 
				"\n" + 
				"		ssl.ifPresent(sslDeploymentSettings ->\n" + 
				"					serverOptions\n" + 
				"								.setSsl(true)\n" + 
				"								.setPemKeyCertOptions(\n" + 
				"										new PemKeyCertOptions().\n" + 
				"													setKeyPath(sslDeploymentSettings.getKey()).\n" + 
				"													setCertPath(sslDeploymentSettings.getCert())));\n" + 
				"\n" + 
				"		final StaticHandler staticHandler = StaticHandler.create();\n" + 
				"		staticHandler.setWebRoot(deploymentOptions.getWebRoot());\n" + 
				"		staticHandler.setCachingEnabled(false);\n" + 
				"		router.route(\"/*\").handler(staticHandler);\n" + 
				"\n" + 
				"		vertx.createHttpServer(serverOptions).requestHandler(router::accept).listen(deploymentOptions.getPort());\n" + 
				"\n" + 
				"		log.info(\"server running on \" + (ssl.isPresent() ? \"https\" : \"http\") + \"://\" + deploymentOptions.getTcpHost() + \":\" + deploymentOptions.getPort());\n" + 
				"		log.info(\"server running on \" + (ssl.isPresent() ? \"https\" : \"http\") + \"://\" + deploymentOptions.getTcpName(\"pettyresidential.info\") + \":\" + deploymentOptions.getPort());\n" + 
				"\n" + 
				"		startFuture.succeeded();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void login(RoutingContext routingContext, JWTAuth auth) {\n" + 
				"		WebUtils.debug(\"login\", routingContext);\n" + 
				"\n" + 
				"		final LoginRequest loginRequest = newLoginRequest(routingContext.getBodyAsJson());\n" + 
				"		final ServerDeploymentOptions deploymentOptions = new ServerDeploymentOptions(config());\n" + 
				"\n" + 
				"		final Optional<UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()\n" + 
				"					.filter(userDeploymentSettings -> userDeploymentSettings.getUsername().equals(loginRequest.getUsername()))\n" + 
				"					.findFirst();\n" + 
				"\n" + 
				"		if (!userFound.isPresent()) {\n" + 
				"				sendErrors(routingContext, UNAUTHORIZED, \"User credentials not found\");\n" + 
				"				return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final boolean passwordMatch = verifyUserPassword(loginRequest.getPassword(), userFound.get().getPassword(), userFound.get().getSalt());\n" + 
				"\n" + 
				"		if (!passwordMatch) {\n" + 
				"				sendFailResponse(routingContext, BAD_REQUEST, \"User credentials not found\");\n" + 
				"				return;\n" + 
				"		}\n" + 
				"\n" + 
				"		userFound.get()\n" + 
				"					.setToken(auth.generateToken(\n" + 
				"								newJWTPayload()\n" + 
				"										.setSub(userFound.get().getUsername())\n" + 
				"										.getJsonObject(),\n" + 
				"								new JWTOptions()\n" + 
				"										.setExpiresInMinutes(deploymentOptions.getJwt().getExpiresInMinutes())\n" + 
				"										.setSubject(userFound.get().getUsername())));\n" + 
				"\n" + 
				"		final UserSession userSession = newUserSession()\n" + 
				"					.setToken(userFound.get().getToken())\n" + 
				"					.setUsername(userFound.get().getUsername());\n" + 
				"\n" + 
				"		setUserMenus(userFound.get(), userSession);\n" + 
				"\n" + 
				"		sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getUser(RoutingContext routingContext) {\n" + 
				"\n" + 
				"		final String authorization = routingContext.request().getHeader(\"Authorization\");\n" + 
				"		final String token = authorization == null ? null : authorization.substring(7).trim();\n" + 
				"\n" + 
				"		final ServerDeploymentOptions deploymentOptions = new ServerDeploymentOptions(config());\n" + 
				"		final Optional<UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()\n" + 
				"					.filter(userDeploymentSettings -> userDeploymentSettings.getToken()!=null)\n" + 
				"					.filter(userDeploymentSettings -> userDeploymentSettings.getToken().equals(token))\n" + 
				"					.findFirst();\n" + 
				"\n" + 
				"		if (!userFound.isPresent()) {\n" + 
				"				sendFailResponse(routingContext, BAD_REQUEST, \"User session not found\");\n" + 
				"				return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final UserSession userSession = newUserSession()\n" + 
				"					.setToken(userFound.get().getToken())\n" + 
				"					.setUsername(userFound.get().getUsername())\n" + 
				"					.addMenus(newUserMenu()\n" + 
				"					.setLabel(\"Trends\")\n" + 
				"					.setUrl(\"/trends\")\n" + 
				"					.setKey(1));\n" + 
				"\n" + 
				"		setUserMenus(userFound.get(), userSession);\n" + 
				"\n" + 
				"		sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getImage(RoutingContext routingContext) {\n" + 
				"		routingContext.response()\n" + 
				"					.putHeader(\"Content-Type\", \"image/jpg\")\n" + 
				"					.sendFile(new File(\".\", routingContext.pathParam(\"name\")).getAbsolutePath());\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getCurrent(RoutingContext routingContext) {\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	~endpoints:{it|~it.handlerImpl~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private void getReport(RoutingContext routingContext) {\n" + 
				"		routingContext.response()\n" + 
				"					.putHeader(\"Content-Type\", \"application/pdf\")\n" + 
				"					.setStatusCode(HttpResponseStatus.OK.code())\n" + 
				"					.sendFile(\"./report.pdf\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void setUserMenus(UserDeploymentSettings settings, UserSession session) {\n" + 
				"\n" + 
				"		final AtomicInteger key = new AtomicInteger(0);\n" + 
				"		settings.getAccess().forEach(userAccess -> session.addMenus(newUserMenu().setKey(key.incrementAndGet()).setUrl(userAccess.getUrl()).setLabel(userAccess.getLabel())));\n" + 
				"	}\n" + 
				"} >>";
}  