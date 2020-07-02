package nextgen.templates.kotlin;

public class ImplementingInterface implements Extending {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _interfaceName;

	ImplementingInterface(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ImplementingInterface");
		st.add("interfaceName", _interfaceName);
		return st.render().trim();
	}

	public ImplementingInterface setInterfaceName(String value) {
		this._interfaceName = value;
		return this;
	}

	public String getInterfaceName() {
		return this._interfaceName;
	}

	public String getInterfaceName(String defaultValue) {
		return this._interfaceName == null ? defaultValue : this._interfaceName;
	}

	public boolean hasInterfaceName() {
		return this._interfaceName != null;
	}

	public ImplementingInterface removeInterfaceName() {
		this._interfaceName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ImplementingInterface that = (ImplementingInterface) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ImplementingInterface(interfaceName) ::= <<~interfaceName~ >>";
}  