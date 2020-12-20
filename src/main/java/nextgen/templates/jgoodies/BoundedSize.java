package nextgen.templates.jgoodies;

public class BoundedSize implements Size {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _componentSize;
	private Object _constantSize;

	BoundedSize(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("boundedSize");
		st.add("componentSize", _componentSize);
		st.add("constantSize", _constantSize);
		return st.render().trim();
	}

	public BoundedSize setComponentSize(Object value) {
		this._componentSize = value;
		return this;
	}

	public Object getComponentSize() {
		return this._componentSize;
	}

	public Object getComponentSize(Object defaultValue) {
		return this._componentSize == null ? defaultValue : this._componentSize;
	}

	public boolean hasComponentSize() {
		return this._componentSize != null;
	}

	public BoundedSize removeComponentSize() {
		this._componentSize = null;
		return this;
	} 

	public BoundedSize setConstantSize(Object value) {
		this._constantSize = value;
		return this;
	}

	public Object getConstantSize() {
		return this._constantSize;
	}

	public Object getConstantSize(Object defaultValue) {
		return this._constantSize == null ? defaultValue : this._constantSize;
	}

	public boolean hasConstantSize() {
		return this._constantSize != null;
	}

	public BoundedSize removeConstantSize() {
		this._constantSize = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BoundedSize that = (BoundedSize) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "boundedSize(componentSize,constantSize) ::= <<MIN(~constantSize~;~componentSize~) | MAX(~constantSize~;~componentSize~) >>";
}  