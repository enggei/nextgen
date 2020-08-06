package nextgen.templates.greenrobot;

public class Post {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _event;

	Post(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("post");
		st.add("event", _event);
		return st.render().trim();
	}

	public Post setEvent(Object value) {
		this._event = value;
		return this;
	}

	public Object getEvent() {
		return this._event;
	}

	public Object getEvent(Object defaultValue) {
		return this._event == null ? defaultValue : this._event;
	}

	public boolean hasEvent() {
		return this._event != null;
	}

	public Post removeEvent() {
		this._event = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Post that = (Post) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "post(event) ::= <<org.greenrobot.eventbus.EventBus.getDefault().post(new ~event~); >>";
}  