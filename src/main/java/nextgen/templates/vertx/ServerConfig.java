package nextgen.templates.vertx;

public class ServerConfig {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _webCachingEnabled;
	private Object _webEnableRangeSupport;
	private Object _name;
	private Object _webHost;
	private Object _webPort;
	private Object _webRoot;
	private Object _sslCertPath;
	private Object _sslKeyPath;
	private Boolean _isSSL;
	private Object _jwtExpiresInMinutes;
	private Object _jwtSecretKey;
	private Object _jwtPublicKey;
	private Object _jwtAlgorithm;
	private Object _dbPath;
	private java.util.List<java.util.Map<String, Object>> _verticles = new java.util.ArrayList<>();

	ServerConfig(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ServerConfig");
		st.add("webCachingEnabled", _webCachingEnabled);
		st.add("webEnableRangeSupport", _webEnableRangeSupport);
		st.add("name", _name);
		st.add("webHost", _webHost);
		st.add("webPort", _webPort);
		st.add("webRoot", _webRoot);
		st.add("sslCertPath", _sslCertPath);
		st.add("sslKeyPath", _sslKeyPath);
		st.add("isSSL", _isSSL);
		st.add("jwtExpiresInMinutes", _jwtExpiresInMinutes);
		st.add("jwtSecretKey", _jwtSecretKey);
		st.add("jwtPublicKey", _jwtPublicKey);
		st.add("jwtAlgorithm", _jwtAlgorithm);
		st.add("dbPath", _dbPath);
		for (java.util.Map<String, Object> map : _verticles) st.addAggr("verticles.{name,className}", map.get("name"), map.get("className"));
		return st.render().trim();
	}

	public ServerConfig setWebCachingEnabled(Object value) {
		this._webCachingEnabled = value;
		return this;
	}

	public Object getWebCachingEnabled() {
		return this._webCachingEnabled;
	}

	public Object getWebCachingEnabled(Object defaultValue) {
		return this._webCachingEnabled == null ? defaultValue : this._webCachingEnabled;
	}

	public boolean hasWebCachingEnabled() {
		return this._webCachingEnabled != null;
	}

	public ServerConfig removeWebCachingEnabled() {
		this._webCachingEnabled = null;
		return this;
	} 

	public ServerConfig setWebEnableRangeSupport(Object value) {
		this._webEnableRangeSupport = value;
		return this;
	}

	public Object getWebEnableRangeSupport() {
		return this._webEnableRangeSupport;
	}

	public Object getWebEnableRangeSupport(Object defaultValue) {
		return this._webEnableRangeSupport == null ? defaultValue : this._webEnableRangeSupport;
	}

	public boolean hasWebEnableRangeSupport() {
		return this._webEnableRangeSupport != null;
	}

	public ServerConfig removeWebEnableRangeSupport() {
		this._webEnableRangeSupport = null;
		return this;
	} 

	public ServerConfig setName(Object value) {
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

	public ServerConfig removeName() {
		this._name = null;
		return this;
	} 

	public ServerConfig setWebHost(Object value) {
		this._webHost = value;
		return this;
	}

	public Object getWebHost() {
		return this._webHost;
	}

	public Object getWebHost(Object defaultValue) {
		return this._webHost == null ? defaultValue : this._webHost;
	}

	public boolean hasWebHost() {
		return this._webHost != null;
	}

	public ServerConfig removeWebHost() {
		this._webHost = null;
		return this;
	} 

	public ServerConfig setWebPort(Object value) {
		this._webPort = value;
		return this;
	}

	public Object getWebPort() {
		return this._webPort;
	}

	public Object getWebPort(Object defaultValue) {
		return this._webPort == null ? defaultValue : this._webPort;
	}

	public boolean hasWebPort() {
		return this._webPort != null;
	}

	public ServerConfig removeWebPort() {
		this._webPort = null;
		return this;
	} 

	public ServerConfig setWebRoot(Object value) {
		this._webRoot = value;
		return this;
	}

	public Object getWebRoot() {
		return this._webRoot;
	}

	public Object getWebRoot(Object defaultValue) {
		return this._webRoot == null ? defaultValue : this._webRoot;
	}

	public boolean hasWebRoot() {
		return this._webRoot != null;
	}

	public ServerConfig removeWebRoot() {
		this._webRoot = null;
		return this;
	} 

	public ServerConfig setSslCertPath(Object value) {
		this._sslCertPath = value;
		return this;
	}

	public Object getSslCertPath() {
		return this._sslCertPath;
	}

	public Object getSslCertPath(Object defaultValue) {
		return this._sslCertPath == null ? defaultValue : this._sslCertPath;
	}

	public boolean hasSslCertPath() {
		return this._sslCertPath != null;
	}

	public ServerConfig removeSslCertPath() {
		this._sslCertPath = null;
		return this;
	} 

	public ServerConfig setSslKeyPath(Object value) {
		this._sslKeyPath = value;
		return this;
	}

	public Object getSslKeyPath() {
		return this._sslKeyPath;
	}

	public Object getSslKeyPath(Object defaultValue) {
		return this._sslKeyPath == null ? defaultValue : this._sslKeyPath;
	}

	public boolean hasSslKeyPath() {
		return this._sslKeyPath != null;
	}

	public ServerConfig removeSslKeyPath() {
		this._sslKeyPath = null;
		return this;
	} 

	public ServerConfig setIsSSL(Boolean value) {
		this._isSSL = value;
		return this;
	}

	public Boolean getIsSSL() {
		return this._isSSL;
	}

	public Boolean getIsSSL(Boolean defaultValue) {
		return this._isSSL == null ? defaultValue : this._isSSL;
	}

	public boolean hasIsSSL() {
		return this._isSSL != null;
	}

	public ServerConfig removeIsSSL() {
		this._isSSL = null;
		return this;
	} 

	public ServerConfig setJwtExpiresInMinutes(Object value) {
		this._jwtExpiresInMinutes = value;
		return this;
	}

	public Object getJwtExpiresInMinutes() {
		return this._jwtExpiresInMinutes;
	}

	public Object getJwtExpiresInMinutes(Object defaultValue) {
		return this._jwtExpiresInMinutes == null ? defaultValue : this._jwtExpiresInMinutes;
	}

	public boolean hasJwtExpiresInMinutes() {
		return this._jwtExpiresInMinutes != null;
	}

	public ServerConfig removeJwtExpiresInMinutes() {
		this._jwtExpiresInMinutes = null;
		return this;
	} 

	public ServerConfig setJwtSecretKey(Object value) {
		this._jwtSecretKey = value;
		return this;
	}

	public Object getJwtSecretKey() {
		return this._jwtSecretKey;
	}

	public Object getJwtSecretKey(Object defaultValue) {
		return this._jwtSecretKey == null ? defaultValue : this._jwtSecretKey;
	}

	public boolean hasJwtSecretKey() {
		return this._jwtSecretKey != null;
	}

	public ServerConfig removeJwtSecretKey() {
		this._jwtSecretKey = null;
		return this;
	} 

	public ServerConfig setJwtPublicKey(Object value) {
		this._jwtPublicKey = value;
		return this;
	}

	public Object getJwtPublicKey() {
		return this._jwtPublicKey;
	}

	public Object getJwtPublicKey(Object defaultValue) {
		return this._jwtPublicKey == null ? defaultValue : this._jwtPublicKey;
	}

	public boolean hasJwtPublicKey() {
		return this._jwtPublicKey != null;
	}

	public ServerConfig removeJwtPublicKey() {
		this._jwtPublicKey = null;
		return this;
	} 

	public ServerConfig setJwtAlgorithm(Object value) {
		this._jwtAlgorithm = value;
		return this;
	}

	public Object getJwtAlgorithm() {
		return this._jwtAlgorithm;
	}

	public Object getJwtAlgorithm(Object defaultValue) {
		return this._jwtAlgorithm == null ? defaultValue : this._jwtAlgorithm;
	}

	public boolean hasJwtAlgorithm() {
		return this._jwtAlgorithm != null;
	}

	public ServerConfig removeJwtAlgorithm() {
		this._jwtAlgorithm = null;
		return this;
	} 

	public ServerConfig setDbPath(Object value) {
		this._dbPath = value;
		return this;
	}

	public Object getDbPath() {
		return this._dbPath;
	}

	public Object getDbPath(Object defaultValue) {
		return this._dbPath == null ? defaultValue : this._dbPath;
	}

	public boolean hasDbPath() {
		return this._dbPath != null;
	}

	public ServerConfig removeDbPath() {
		this._dbPath = null;
		return this;
	} 


	public ServerConfig setVerticles(java.util.Collection<ServerConfig_Verticles> values) {
			this._verticles.clear();
			values.stream().map(ServerConfig_Verticles::asMap).forEach(map -> _verticles.add(map));
			return this;
		}

	public ServerConfig addVerticles(Object _name, Object _className) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("className", _className);
		this._verticles.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getVerticles() {
		return this._verticles;
	}

	public ServerConfig addVerticles(ServerConfig_Verticles value) {
		return addVerticles(value._name, value._className);
	}

	public java.util.stream.Stream<ServerConfig_Verticles> streamVerticles() {
		return this._verticles.stream().map(ServerConfig_Verticles::new);
	}

	public java.util.List<Object> getVerticles_Name() {
		return streamVerticles().map(ServerConfig_Verticles::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getVerticles_ClassName() {
		return streamVerticles().map(ServerConfig_Verticles::getClassName).collect(java.util.stream.Collectors.toList());
	}


	public static final class ServerConfig_Verticles {

		Object _name;
		Object _className;

		public ServerConfig_Verticles(Object _name, Object _className) {
			this._name = _name;
			this._className = _className;
		}

		private ServerConfig_Verticles(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._className = (Object) map.get("className");
		}

		public Object getName() {
			return this._name;
		}

		public Object getClassName() {
			return this._className;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("className", _className);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ServerConfig that = (ServerConfig) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ServerConfig(webCachingEnabled,webEnableRangeSupport,verticles,name,webHost,webPort,webRoot,sslCertPath,sslKeyPath,isSSL,jwtExpiresInMinutes,jwtSecretKey,jwtPublicKey,jwtAlgorithm,dbPath) ::= <<{\n" + 
				"	\"name\" : \"~name~\",\n" + 
				"	\"web.host\" : \"~webHost~\",\n" + 
				"	\"web.port\" : ~webPort~,\n" + 
				"	\"web.root\" : \"~webRoot~\",\n" + 
				"	\"web.cachingEnabled\" : ~webCachingEnabled~,\n" + 
				"	\"web.enableRangeSupport\" : ~webEnableRangeSupport~,\n" + 
				"	\"verticles\" : [ \n" + 
				"		~verticles:{it|{\n" + 
				"	\"name\" : \"~it.name~\",\n" + 
				"	\"className\" : \"~it.className~\"\n" + 
				"~eom()~};separator=\",\\n\"~\n" + 
				"	],\n" + 
				"	\"jwt.algorithm\" : \"~jwtAlgorithm~\",\n" + 
				"	\"jwt.publicKey\" : \"~jwtPublicKey~\",\n" + 
				"	\"jwt.secretKey\" : \"~jwtSecretKey~\",\n" + 
				"	\"jwt.expiresInMinutes\" : \"~jwtExpiresInMinutes~\",\n" + 
				"	\"ssl\" : ~if(isSSL)~true~else~false~endif~,\n" + 
				"	\"ssl.keyPath\" : \"~sslKeyPath~\",\n" + 
				"	\"ssl.certPath\" : \"~sslCertPath~\",\n" + 
				"	\"db.path\" : \"~dbPath~\"\n" + 
				"} >>";
}  