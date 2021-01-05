package nextgen.templates.vertx;

public class DomainAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;

	DomainAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainAction");
		st.add("name", _name);
		return st.render().trim();
	}

	public DomainAction setName(Object value) {
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

	public DomainAction removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainAction that = (DomainAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainAction(name) ::= <<private void ~name~(Message<io.vertx.core.buffer.Buffer> message) {\n" + 
				"	debug(\"~name~\", message);\n" + 
				"	doInTransaction(transaction -> new ~name;format=\"capitalize\"~Handler(new Domain(db)).reply(message), throwable -> message.fail(500, throwable.getMessage()));\n" + 
				"} >>";
}  