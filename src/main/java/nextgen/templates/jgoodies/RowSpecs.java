package nextgen.templates.jgoodies;

public class RowSpecs {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<RowSpec> _rowSpec = new java.util.ArrayList<>();

	RowSpecs(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("rowSpecs");
		for (Object o : _rowSpec) st.add("rowSpec", o);
		return st.render().trim();
	}


	public RowSpecs addRowSpec(RowSpec value) {
		this._rowSpec.add(value);
		return this;
	}

	public RowSpecs setRowSpec(RowSpec[] value) {
		this._rowSpec.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public RowSpecs setRowSpec(java.util.Collection<RowSpec> values) {
		this._rowSpec.addAll(values);
		return this;
	}

	public RowSpecs removeRowSpec(RowSpec value) {
		this._rowSpec.remove(value);
		return this;
	}

	public RowSpecs removeRowSpec(int index) {
		this._rowSpec.remove(index);
		return this;
	}

	public java.util.List<RowSpec> getRowSpec() {
		return this._rowSpec;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RowSpecs that = (RowSpecs) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "rowSpecs(rowSpec) ::= <<~rowSpec:{it|~it~};separator=\", \"~ >>";
}  