package nextgen.templates.jgoodies;

public class ColumnSpecs {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<ColumnSpec> _columnSpec = new java.util.ArrayList<>();

	ColumnSpecs(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("columnSpecs");
		for (Object o : _columnSpec) st.add("columnSpec", o);
		return st.render().trim();
	}


	public ColumnSpecs addColumnSpec(ColumnSpec value) {
		this._columnSpec.add(value);
		return this;
	}

	public ColumnSpecs setColumnSpec(ColumnSpec[] value) {
		this._columnSpec.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ColumnSpecs setColumnSpec(java.util.Collection<ColumnSpec> values) {
		this._columnSpec.addAll(values);
		return this;
	}

	public ColumnSpecs removeColumnSpec(ColumnSpec value) {
		this._columnSpec.remove(value);
		return this;
	}

	public ColumnSpecs removeColumnSpec(int index) {
		this._columnSpec.remove(index);
		return this;
	}

	public java.util.List<ColumnSpec> getColumnSpec() {
		return this._columnSpec;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ColumnSpecs that = (ColumnSpecs) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "columnSpecs(columnSpec) ::= <<~columnSpec:{it|~it~};separator=\", \"~ >>";
}  