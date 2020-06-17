package nextgen.templates.vertx;

public class DomainVerticle {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _domainPackage;
	private Object _name;
	private Object _domainFactory;
	private Object _address;
	private java.util.List<java.util.Map<String, Object>> _actions = new java.util.ArrayList<>();

	DomainVerticle(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainVerticle");
		st.add("packageName", _packageName);
		st.add("domainPackage", _domainPackage);
		st.add("name", _name);
		st.add("domainFactory", _domainFactory);
		st.add("address", _address);
		for (java.util.Map<String, Object> map : _actions) st.addAggr("actions.{name,declaration}", map.get("name"), map.get("declaration"));
		return st.render().trim();
	}

	public DomainVerticle setPackageName(Object value) {
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

	public DomainVerticle removePackageName() {
		this._packageName = null;
		return this;
	} 

	public DomainVerticle setDomainPackage(Object value) {
		this._domainPackage = value;
		return this;
	}

	public Object getDomainPackage() {
		return this._domainPackage;
	}

	public Object getDomainPackage(Object defaultValue) {
		return this._domainPackage == null ? defaultValue : this._domainPackage;
	}

	public boolean hasDomainPackage() {
		return this._domainPackage != null;
	}

	public DomainVerticle removeDomainPackage() {
		this._domainPackage = null;
		return this;
	} 

	public DomainVerticle setName(Object value) {
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

	public DomainVerticle removeName() {
		this._name = null;
		return this;
	} 

	public DomainVerticle setDomainFactory(Object value) {
		this._domainFactory = value;
		return this;
	}

	public Object getDomainFactory() {
		return this._domainFactory;
	}

	public Object getDomainFactory(Object defaultValue) {
		return this._domainFactory == null ? defaultValue : this._domainFactory;
	}

	public boolean hasDomainFactory() {
		return this._domainFactory != null;
	}

	public DomainVerticle removeDomainFactory() {
		this._domainFactory = null;
		return this;
	} 

	public DomainVerticle setAddress(Object value) {
		this._address = value;
		return this;
	}

	public Object getAddress() {
		return this._address;
	}

	public Object getAddress(Object defaultValue) {
		return this._address == null ? defaultValue : this._address;
	}

	public boolean hasAddress() {
		return this._address != null;
	}

	public DomainVerticle removeAddress() {
		this._address = null;
		return this;
	} 


	public DomainVerticle addActions(Object _name, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("declaration", _declaration);
		this._actions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getActions() {
		return this._actions;
	}

	public DomainVerticle addActions(DomainVerticle_Actions value) {
		return addActions(value._name, value._declaration);
	}

	public java.util.stream.Stream<DomainVerticle_Actions> streamActions() {
		return this._actions.stream().map(DomainVerticle_Actions::new);
	}

	public static final class DomainVerticle_Actions {

		Object _name;
		Object _declaration;

		public DomainVerticle_Actions(Object _name, Object _declaration) {
			this._name = _name;
			this._declaration = _declaration;
		}

		private DomainVerticle_Actions(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._declaration = (Object) map.get("declaration");
		}

		public Object getName() {
			return this._name;
		}

		public Object getDeclaration() {
			return this._declaration;
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

	static final String st = "DomainVerticle(packageName,domainPackage,name,actions,domainFactory,address) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import ~domainPackage~.*;\n" + 
				"import io.vertx.core.AbstractVerticle;\n" + 
				"import io.vertx.core.Promise;\n" + 
				"import io.vertx.core.eventbus.Message;\n" + 
				"import io.vertx.core.json.JsonArray;\n" + 
				"import io.vertx.core.json.JsonObject;\n" + 
				"import org.slf4j.Logger;\n" + 
				"import org.slf4j.LoggerFactory;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ extends AbstractVerticle {\n" + 
				"\n" + 
				"	private static final Logger log = LoggerFactory.getLogger(~name;format=\"capitalize\"~.class);\n" + 
				"\n" + 
				"	public enum Action {\n" + 
				"		~actions:{it|~it.name~};separator=\",\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	public enum ErrorCodes {\n" + 
				"		NO_ACTION_HEADER,\n" + 
				"		UNKNOWN_ACTION\n" + 
				"	}\n" + 
				"\n" + 
				"	private ~domainFactory~ db;\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void start(Promise<Void> promise) throws Exception {\n" + 
				"		db = new ~domainFactory~(config().getString(\"path\"));\n" + 
				"		vertx.eventBus().consumer(config().getString(\"~address~\", \"~address~\"), this::onMessage);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void onMessage(Message<JsonObject> message) {\n" + 
				"\n" + 
				"		if (!message.headers().contains(\"action\")) {\n" + 
				"			log.error(\"No action header specified for message with headers {} and body {}\", message.headers(), message.body().encodePrettily());\n" + 
				"			message.fail(ErrorCodes.NO_ACTION_HEADER.ordinal(), \"No action header specified\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		final Action action = getAction(message);\n" + 
				"		\n" + 
				"		if (action == null) {\n" + 
				"			message.fail(ErrorCodes.UNKNOWN_ACTION.ordinal(), \"Unknown action\");\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		switch (action) {\n" + 
				"~actions:{it|\n" + 
				"			case ~it.name~: {\n" + 
				"				~it.name~(message);\n" + 
				"				break;\n" + 
				"			\\}};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	~actions:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	private Action getAction(Message<JsonObject> message) {\n" + 
				"		final String action = message.headers().get(\"action\");\n" + 
				"		try {\n" + 
				"				return Action.valueOf(action);\n" + 
				"		} catch (Throwable e) {\n" + 
				"				log.error(\"Unknown action \" + action);\n" + 
				"				return null;\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
} 