package nextgen.templates.vertx;

public class WebVerticle {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _startStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _routes = new java.util.ArrayList<>();

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
		for (java.util.Map<String, Object> map : _routes) st.addAggr("routes.{action,url,methodName}", map.get("action"), map.get("url"), map.get("methodName"));
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

	public WebVerticle addRoutes(Object _action, Object _url, Object _methodName) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("action", _action);
		map.put("url", _url);
		map.put("methodName", _methodName);
		this._routes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRoutes() {
		return this._routes;
	}

	public WebVerticle addRoutes(WebVerticle_Routes value) {
		return addRoutes(value._action, value._url, value._methodName);
	}

	public java.util.stream.Stream<WebVerticle_Routes> streamRoutes() {
		return this._routes.stream().map(WebVerticle_Routes::new);
	}

	public static final class WebVerticle_Routes {

		Object _action;
		Object _url;
		Object _methodName;

		public WebVerticle_Routes(Object _action, Object _url, Object _methodName) {
			this._action = _action;
			this._url = _url;
			this._methodName = _methodName;
		}

		private WebVerticle_Routes(java.util.Map<String, Object> map) {
			this._action = (Object) map.get("action");
			this._url = (Object) map.get("url");
			this._methodName = (Object) map.get("methodName");
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

	static final String st = "WebVerticle(packageName,imports,fields,name,startStatements,routes) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import com.petty.web.api.LoginRequest;\n" + 
				"import com.petty.web.api.UserSession;\n" + 
				"import com.petty.web.domain.SSLDeploymentSettings;\n" + 
				"import com.petty.web.domain.ServerDeploymentOptions;\n" + 
				"import com.petty.web.domain.UserDeploymentSettings;\n" + 
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
				"import java.util.Map;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.concurrent.ConcurrentHashMap;\n" + 
				"import java.util.concurrent.atomic.AtomicInteger;\n" + 
				"\n" + 
				"import static com.petty.web.PasswordUtils.verifyUserPassword;\n" + 
				"import static com.petty.web.WebUtils.*;\n" + 
				"import static com.petty.web.api.WebApiJsonFactory.*;\n" + 
				"import static io.netty.handler.codec.http.HttpResponseStatus.*;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class WebVerticle extends AbstractVerticle {\n" + 
				"\n" + 
				"	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WebVerticle.class);\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void start(Future<Void> startFuture) throws Exception {\n" + 
				"		log.info(\"starting ~name;format=\"capitalize\"~\");\n" + 
				"\n" + 
				"		~startStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"		deploymentOptions = new ServerDeploymentOptions(config());\n" + 
				"		final Optional<SSLDeploymentSettings> ssl = Optional.ofNullable(deploymentOptions.getSsl());\n" + 
				"\n" + 
				"		final KeyStoreOptions keyStoreOptions = new KeyStoreOptions().\n" + 
				"				setPath(deploymentOptions.getJwt().getPath()).\n" + 
				"				setPassword(deploymentOptions.getJwt().getPassword()).\n" + 
				"				setType(deploymentOptions.getJwt().getType());\n" + 
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
				"		~routes:{it|router.~it.action~(\"/~it.url~\").handler(this::~it.methodName~);};separator=\"\\n\"~\n" + 
				"		router.get(\"/images/:name\").handler(this::getImage);\n" + 
				"		router.get(\"/api/currentTrends\").handler(this::onCurrentTrends);\n" + 
				"		router.get(\"/api/prime/:id\").handler(this::getPrime);\n" + 
				"		router.get(\"/api/rent/:id\").handler(this::getRent);\n" + 
				"		router.get(\"/api/branch/:id\").handler(this::getBranch);\n" + 
				"		router.get(\"/api/agent/:id\").handler(this::getAgent);\n" + 
				"		router.get(\"/report/current\").handler(this::getReport);\n" + 
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
				"\n" + 
				"		final Optional<UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()\n" + 
				"				.filter(userDeploymentSettings -> userDeploymentSettings.getUsername().equals(loginRequest.getUsername()))\n" + 
				"				.findFirst();\n" + 
				"\n" + 
				"		if (!userFound.isPresent()) {\n" + 
				"			sendErrors(routingContext, UNAUTHORIZED, \"User credentials not found\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final boolean passwordMatch = verifyUserPassword(loginRequest.getPassword(), userFound.get().getPassword(), userFound.get().getSalt());\n" + 
				"		if (!passwordMatch) {\n" + 
				"			sendErrors(routingContext, BAD_REQUEST, \"User credentials not found\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final String token = auth.generateToken(\n" + 
				"				newJWTPayload()\n" + 
				"						.setSub(userFound.get().getUsername())\n" + 
				"						.getJsonObject(),\n" + 
				"				new JWTOptions()\n" + 
				"						.setExpiresInMinutes(deploymentOptions.getJwt().getExpiresInMinutes())\n" + 
				"						.setSubject(userFound.get().getUsername()));\n" + 
				"\n" + 
				"		log.info(\"login user token \" + userFound.get().getToken());\n" + 
				"\n" + 
				"\n" + 
				"		final UserSession userSession = newUserSession()\n" + 
				"				.setToken(token)\n" + 
				"				.setUsername(userFound.get().getUsername());\n" + 
				"		sessionMap.put(token, userSession);\n" + 
				"\n" + 
				"		sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getUser(RoutingContext routingContext) {\n" + 
				"\n" + 
				"		final String authorization = routingContext.request().getHeader(\"Authorization\");\n" + 
				"		final String token = authorization == null ? null : authorization.substring(7).trim();\n" + 
				"		log.info(\"request token \" + token);\n" + 
				"\n" + 
				"		final UserSession userSession = sessionMap.get(token);\n" + 
				"\n" + 
				"		if (userSession == null) {\n" + 
				"			sendErrors(routingContext, BAD_REQUEST, \"User session not found\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final Optional<UserDeploymentSettings> userFound = deploymentOptions.getJwt().getUsers()\n" + 
				"				.filter(userDeploymentSettings -> userDeploymentSettings.getUsername().equals(userSession.getUsername()))\n" + 
				"				.findFirst();\n" + 
				"\n" + 
				"		if (!userFound.isPresent()) {\n" + 
				"			sendErrors(routingContext, BAD_REQUEST, \"User session not found\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		setUserMenus(userFound.get(), userSession);\n" + 
				"\n" + 
				"		sendResponse(routingContext, OK, new JsonObject().put(\"user\", userSession.getJsonObject()));\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getImage(RoutingContext routingContext) {\n" + 
				"		routingContext.response()\n" + 
				"				.putHeader(\"Content-Type\", \"image/jpg\")\n" + 
				"				.sendFile(new File(\".\", routingContext.pathParam(\"name\")).getAbsolutePath());\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getPrime(RoutingContext routingContext) {\n" + 
				"\n" + 
				"		final String id = routingContext.request().getParam(\"id\");\n" + 
				"		log.info(\"handle getPrime \" + id);\n" + 
				"\n" + 
				"		sendJsonFile(routingContext, \"./prime_\" + id + \".json\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getRent(RoutingContext routingContext) {\n" + 
				"\n" + 
				"		final String id = routingContext.request().getParam(\"id\");\n" + 
				"		log.info(\"handle getRent \" + id);\n" + 
				"\n" + 
				"		sendJsonFile(routingContext, \"./rent_\" + id + \".json\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getBranch(RoutingContext routingContext) {\n" + 
				"\n" + 
				"		final String id = routingContext.request().getParam(\"id\");\n" + 
				"		log.info(\"handle getBranch \" + id);\n" + 
				"\n" + 
				"		sendJsonFile(routingContext, \"./branch_\" + id + \".json\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getAgent(RoutingContext routingContext) {\n" + 
				"\n" + 
				"		final String id = routingContext.request().getParam(\"id\");\n" + 
				"		log.info(\"handle getAgent \" + id);\n" + 
				"\n" + 
				"		sendJsonFile(routingContext, \"./agent_\" + id + \".json\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void onCurrentTrends(RoutingContext routingContext) {\n" + 
				"		log.info(\"handle onCurrentTrends\");\n" + 
				"		sendJsonFile(routingContext, \"./currentTrends.json\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void getReport(RoutingContext routingContext) {\n" + 
				"		routingContext.response()\n" + 
				"				.putHeader(\"Content-Type\", \"application/pdf\")\n" + 
				"				.setStatusCode(HttpResponseStatus.OK.code())\n" + 
				"				.sendFile(\"./report.pdf\");\n" + 
				"	}\n" + 
				"\n" + 
				"	private void setUserMenus(UserDeploymentSettings settings, UserSession session) {\n" + 
				"\n" + 
				"		if (session.getMenus().count() != 0L) return;\n" + 
				"\n" + 
				"		final AtomicInteger key = new AtomicInteger(0);\n" + 
				"\n" + 
				"		session.addMenus(newUserMenu()\n" + 
				"				.setLabel(\"Trends\")\n" + 
				"				.setUrl(\"/currentTrends\")\n" + 
				"				.setKey(key.incrementAndGet()));\n" + 
				"\n" + 
				"		for (String prime : new String[]{\n" + 
				"				\"Barnoldswick\",\n" + 
				"				\"Barrowford\",\n" + 
				"				\"Burnley\",\n" + 
				"				\"Buxton\",\n" + 
				"				\"Chester\",\n" + 
				"				\"Clitheroe\",\n" + 
				"				\"Colne\",\n" + 
				"				\"Crewe\",\n" + 
				"				\"Knutsford\",\n" + 
				"				\"Nantwich\",\n" + 
				"				\"Northwich\",\n" + 
				"				\"Skipton\",\n" + 
				"				\"Tarporley\"}) {\n" + 
				"			session.addMenus(newUserMenu()\n" + 
				"					.setLabel(\"Prime \" + prime)\n" + 
				"					.setUrl(\"/primeReport/\" + prime)\n" + 
				"					.setKey(key.incrementAndGet()));\n" + 
				"		}\n" + 
				"		for (String rent : new String[]{\n" + 
				"				\"Barnoldswick\",\n" + 
				"				\"Barrowford\",\n" + 
				"				\"Burnley\",\n" + 
				"				\"Buxton\",\n" + 
				"				\"Chester\",\n" + 
				"				\"Colne\",\n" + 
				"				\"Crewe\",\n" + 
				"				\"Knutsford\",\n" + 
				"				\"Nantwich\",\n" + 
				"				\"Northwich\",\n" + 
				"				\"Tarporley\"}) {\n" + 
				"			session.addMenus(newUserMenu()\n" + 
				"					.setLabel(\"Rent \" + rent)\n" + 
				"					.setUrl(\"/rentReport/\" + rent)\n" + 
				"					.setKey(key.incrementAndGet()));\n" + 
				"		}\n" + 
				"\n" + 
				"		for (String branch : new String[]{\n" + 
				"				\"Barnoldswick\",\n" + 
				"				\"Barrowford\",\n" + 
				"				\"Burnley\",\n" + 
				"				\"Buxton\",\n" + 
				"				\"Chester\",\n" + 
				"				\"Colne\",\n" + 
				"				\"Crewe\",\n" + 
				"				\"Knutsford\",\n" + 
				"				\"Nantwich\",\n" + 
				"				\"Northwich\",\n" + 
				"				\"Tarporley\"}) {\n" + 
				"			session.addMenus(newUserMenu()\n" + 
				"					.setLabel(\"Branch \" + branch)\n" + 
				"					.setUrl(\"/branch/\" + branch)\n" + 
				"					.setKey(key.incrementAndGet()));\n" + 
				"		}\n" + 
				"\n" + 
				"		settings.getAccess().forEach(userAccess -> session.addMenus(newUserMenu().setKey(key.incrementAndGet()).setUrl(userAccess.getUrl()).setLabel(userAccess.getLabel())));\n" + 
				"	}\n" + 
				"} >>";
}  