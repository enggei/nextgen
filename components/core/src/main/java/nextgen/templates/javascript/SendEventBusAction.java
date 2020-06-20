package nextgen.templates.javascript;

public class SendEventBusAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _actionName;

	SendEventBusAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SendEventBusAction");
		st.add("actionName", _actionName);
		return st.render().trim();
	}

	public SendEventBusAction setActionName(Object value) {
		this._actionName = value;
		return this;
	}

	public Object getActionName() {
		return this._actionName;
	}

	public Object getActionName(Object defaultValue) {
		return this._actionName == null ? defaultValue : this._actionName;
	}

	public boolean hasActionName() {
		return this._actionName != null;
	}

	public SendEventBusAction removeActionName() {
		this._actionName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SendEventBusAction that = (SendEventBusAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SendEventBusAction(actionName) ::= <<getFromDomainDB(vertx, routingContext, \"~actionName~\", new JsonObject()); >>";
} 