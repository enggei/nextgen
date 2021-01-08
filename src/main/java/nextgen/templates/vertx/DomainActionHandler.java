package nextgen.templates.vertx;

public class DomainActionHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _replyName;
	private Object _replyTitle;
	private Object _model;
	private String _name;
	private Object _packageName;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	DomainActionHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainActionHandler");
		st.add("replyName", _replyName);
		st.add("replyTitle", _replyTitle);
		st.add("model", _model);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public DomainActionHandler setReplyName(Object value) {
		this._replyName = value;
		return this;
	}

	public Object getReplyName() {
		return this._replyName;
	}

	public Object getReplyName(Object defaultValue) {
		return this._replyName == null ? defaultValue : this._replyName;
	}

	public boolean hasReplyName() {
		return this._replyName != null;
	}

	public DomainActionHandler removeReplyName() {
		this._replyName = null;
		return this;
	} 

	public DomainActionHandler setReplyTitle(Object value) {
		this._replyTitle = value;
		return this;
	}

	public Object getReplyTitle() {
		return this._replyTitle;
	}

	public Object getReplyTitle(Object defaultValue) {
		return this._replyTitle == null ? defaultValue : this._replyTitle;
	}

	public boolean hasReplyTitle() {
		return this._replyTitle != null;
	}

	public DomainActionHandler removeReplyTitle() {
		this._replyTitle = null;
		return this;
	} 

	public DomainActionHandler setModel(Object value) {
		this._model = value;
		return this;
	}

	public Object getModel() {
		return this._model;
	}

	public Object getModel(Object defaultValue) {
		return this._model == null ? defaultValue : this._model;
	}

	public boolean hasModel() {
		return this._model != null;
	}

	public DomainActionHandler removeModel() {
		this._model = null;
		return this;
	} 

	public DomainActionHandler setName(String value) {
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

	public DomainActionHandler removeName() {
		this._name = null;
		return this;
	} 

	public DomainActionHandler setPackageName(Object value) {
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

	public DomainActionHandler removePackageName() {
		this._packageName = null;
		return this;
	} 

	public DomainActionHandler addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public DomainActionHandler setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainActionHandler setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public DomainActionHandler removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public DomainActionHandler removeStatements(int index) {
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
		DomainActionHandler that = (DomainActionHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainActionHandler(statements,replyName,replyTitle,model,name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.vertx.core.buffer.Buffer;\n" + 
				"import io.vertx.core.eventbus.Message;\n" + 
				"import munster.domain.*;\n" + 
				"import munster.models.*;\n" + 
				"\n" + 
				"import static java.util.Comparator.*;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"   final ~model~ reply = new ~model~();\n" + 
				"\n" + 
				"   public ~name~(Domain domain) {\n" + 
				"\n" + 
				"      reply.setName(~replyName~);\n" + 
				"      reply.setTitle(~replyTitle~);\n" + 
				"\n" + 
				"      ~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"   }\n" + 
				"\n" + 
				"   public void reply(Message<Buffer> message) {\n" + 
				"      message.reply(reply.toBuffer());\n" + 
				"   }\n" + 
				"} >>";
}  