package nextgen.templates.jgoodies;

public class ResizeBehavior {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Grow _GROW;

	ResizeBehavior(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("resizeBehavior");
		st.add("GROW", _GROW);
		return st.render().trim();
	}

	public ResizeBehavior setGROW(Grow value) {
		this._GROW = value;
		return this;
	}

	public Grow getGROW() {
		return this._GROW;
	}

	public Grow getGROW(Grow defaultValue) {
		return this._GROW == null ? defaultValue : this._GROW;
	}

	public boolean hasGROW() {
		return this._GROW != null;
	}

	public ResizeBehavior removeGROW() {
		this._GROW = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ResizeBehavior that = (ResizeBehavior) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "resizeBehavior(GROW) ::= <<~if(GROW)~~GROW~~else~NONE~endif~ >>";
}  