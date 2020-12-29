package nextgen.templates.vertx;

public class DomainVerticle {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _packageName;
	private java.util.List<String> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _messages = new java.util.ArrayList<>();

	DomainVerticle(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainVerticle");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _imports) st.add("imports", o);
		for (java.util.Map<String, Object> map : _messages) st.addAggr("messages.{implementation,handler,address}", map.get("implementation"), map.get("handler"), map.get("address"));
		return st.render().trim();
	}

	public DomainVerticle setName(String value) {
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

	public DomainVerticle removeName() {
		this._name = null;
		return this;
	} 

	public DomainVerticle setPackageName(String value) {
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

	public DomainVerticle removePackageName() {
		this._packageName = null;
		return this;
	} 

	public DomainVerticle addImports(String value) {
		this._imports.add(value);
		return this;
	}

	public DomainVerticle setImports(String[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVerticle setImports(java.util.Collection<String> values) {
		this._imports.addAll(values);
		return this;
	}

	public DomainVerticle removeImports(String value) {
		this._imports.remove(value);
		return this;
	}

	public DomainVerticle removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<String> getImports() {
		return this._imports;
	} 

	public DomainVerticle setMessages(java.util.Collection<DomainVerticle_Messages> values) {
			this._messages.clear();
			values.stream().map(DomainVerticle_Messages::asMap).forEach(map -> _messages.add(map));
			return this;
		}

	public DomainVerticle addMessages(DomainAction _implementation, String _handler, String _address) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("implementation", _implementation);
		map.put("handler", _handler);
		map.put("address", _address);
		this._messages.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getMessages() {
		return this._messages;
	}

	public DomainVerticle addMessages(DomainVerticle_Messages value) {
		return addMessages(value._implementation, value._handler, value._address);
	}

	public java.util.stream.Stream<DomainVerticle_Messages> streamMessages() {
		return this._messages.stream().map(DomainVerticle_Messages::new);
	}

	public java.util.List<DomainAction> getMessages_Implementation() {
		return streamMessages().map(DomainVerticle_Messages::getImplementation).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getMessages_Handler() {
		return streamMessages().map(DomainVerticle_Messages::getHandler).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getMessages_Address() {
		return streamMessages().map(DomainVerticle_Messages::getAddress).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainVerticle_Messages {

		DomainAction _implementation;
		String _handler;
		String _address;

		public DomainVerticle_Messages(DomainAction _implementation, String _handler, String _address) {
			this._implementation = _implementation;
			this._handler = _handler;
			this._address = _address;
		}

		private DomainVerticle_Messages(java.util.Map<String, Object> map) {
			this._implementation = (DomainAction) map.get("implementation");
			this._handler = (String) map.get("handler");
			this._address = (String) map.get("address");
		}

		public DomainAction getImplementation() {
			return this._implementation;
		}

		public String getHandler() {
			return this._handler;
		}

		public String getAddress() {
			return this._address;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("implementation", _implementation);
			map.put("handler", _handler);
			map.put("address", _address);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainVerticle that = (DomainVerticle) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainVerticle(messages,name,imports,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.vertx.core.AbstractVerticle;\n" + 
				"import io.vertx.core.Promise;\n" + 
				"import io.vertx.core.eventbus.Message;\n" + 
				"import io.vertx.core.json.JsonObject;\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ extends AbstractVerticle {\n" + 
				"\n" + 
				"	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name;format=\"capitalize\"~.class);\n" + 
				"\n" + 
				"	private org.neo4j.graphdb.GraphDatabaseService db;\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void start(Promise<Void> promise) throws Exception {\n" + 
				"		new Thread(() -> {\n" + 
				"\n" + 
				"			db = new org.neo4j.graphdb.factory.GraphDatabaseFactory()\n" + 
				"				.newEmbeddedDatabaseBuilder(new java.io.File(config().getString(\"db.path\")))\n" + 
				"				.setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, \"true\")\n" + 
				"				.newGraphDatabase();\n" + 
				"		\n" + 
				"			log.info(\"db started\");\n" + 
				"\n" + 
				"			~messages:{it|vertx.eventBus().consumer(\"~it.address~\", this::~it.handler~);};separator=\"\\n\"~\n" + 
				"			\n" + 
				"		}).start();\n" + 
				"	}\n" + 
				"\n" + 
				"	~messages:{it|~it.implementation~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private static void debug(String method, Message<io.vertx.core.buffer.Buffer> message) {\n" + 
				"		log.info(method + \" : \" + message.body());\n" + 
				"	}\n" + 
				"\n" + 
				"	private void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action, java.util.function.Consumer<java.lang.Throwable> onException) {\n" + 
				"		try (org.neo4j.graphdb.Transaction tx = db.beginTx())  {\n" + 
				"			action.accept(tx);\n" + 
				"			tx.success();\n" + 
				"		} catch (java.lang.Throwable t)  {\n" + 
				"			onException.accept(t);\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  