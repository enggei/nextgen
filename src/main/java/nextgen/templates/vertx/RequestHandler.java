package nextgen.templates.vertx;

public class RequestHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _page;
	private Object _packageName;
	private String _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	RequestHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RequestHandler");
		st.add("page", _page);
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public RequestHandler setPage(Object value) {
		this._page = value;
		return this;
	}

	public Object getPage() {
		return this._page;
	}

	public Object getPage(Object defaultValue) {
		return this._page == null ? defaultValue : this._page;
	}

	public boolean hasPage() {
		return this._page != null;
	}

	public RequestHandler removePage() {
		this._page = null;
		return this;
	} 

	public RequestHandler setPackageName(Object value) {
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

	public RequestHandler removePackageName() {
		this._packageName = null;
		return this;
	} 

	public RequestHandler setName(String value) {
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

	public RequestHandler removeName() {
		this._name = null;
		return this;
	} 

	public RequestHandler addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public RequestHandler setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public RequestHandler setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public RequestHandler removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public RequestHandler removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RequestHandler that = (RequestHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RequestHandler(page,statements,packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.vertx.core.eventbus.Message;\n" + 
				"import io.vertx.core.json.JsonObject;\n" + 
				"import io.vertx.ext.web.RoutingContext;\n" + 
				"import ui.materialdesignlight.*;\n" + 
				"\n" + 
				"import static ui.materialdesignlight.MaterialDesignLightST.*;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	public static String handle(Message<Object> message) {\n" + 
				"		final Object body = message.body();\n" + 
				"		final JsonObject js = (JsonObject) body;\n" + 
				"		\n" + 
				"		final Page page = newPage();\n" + 
				"		final String name = js.getString(\"name\", \"~page~\");\n" + 
				"		final String title = js.getString(\"title\", \"~page;format=\"capitalize\"~\");\n" + 
				"		\n" + 
				"		page.setHeader(newHeader()\n" + 
				"				.setTitle(title)\n" + 
				"				.setLgMenu(java.util.Arrays.stream(PageModel._pageRoutes)\n" + 
				"						.map(pageRoute -> new Header.Header_LgMenu(name.equals(pageRoute.name()), pageRoute.name(), pageRoute.route()))\n" + 
				"						.collect(java.util.stream.Collectors.toList()))\n" + 
				"				.setSmMenu(java.util.Arrays.stream(PageModel._pageRoutes)\n" + 
				"						.map(pageRoute -> new Header.Header_SmMenu(name.equals(pageRoute.name()), pageRoute.name(), pageRoute.route()))\n" + 
				"						.collect(java.util.stream.Collectors.toList())))\n" + 
				"				.setFooter(newMiniFooter()\n" + 
				"						.setHeading(title));\n" + 
				"		\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"		\n" + 
				"		return page.toString();\n" + 
				"	}\n" + 
				"} >>";
}  