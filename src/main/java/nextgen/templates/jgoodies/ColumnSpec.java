package nextgen.templates.jgoodies;

public class ColumnSpec {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private columnAlignment _columnAlignment;
	private Size _size;
	private ResizeBehavior _resizeBehavior;

	ColumnSpec(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("columnSpec");
		st.add("columnAlignment", _columnAlignment);
		st.add("size", _size);
		st.add("resizeBehavior", _resizeBehavior);
		return st.render().trim();
	}

	public ColumnSpec setColumnAlignment(columnAlignment value) {
		this._columnAlignment = value;
		return this;
	}

	public columnAlignment getColumnAlignment() {
		return this._columnAlignment;
	}

	public columnAlignment getColumnAlignment(columnAlignment defaultValue) {
		return this._columnAlignment == null ? defaultValue : this._columnAlignment;
	}

	public boolean hasColumnAlignment() {
		return this._columnAlignment != null;
	}

	public ColumnSpec removeColumnAlignment() {
		this._columnAlignment = null;
		return this;
	} 

	public ColumnSpec setSize(Size value) {
		this._size = value;
		return this;
	}

	public Size getSize() {
		return this._size;
	}

	public Size getSize(Size defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public ColumnSpec removeSize() {
		this._size = null;
		return this;
	} 

	public ColumnSpec setResizeBehavior(ResizeBehavior value) {
		this._resizeBehavior = value;
		return this;
	}

	public ResizeBehavior getResizeBehavior() {
		return this._resizeBehavior;
	}

	public ResizeBehavior getResizeBehavior(ResizeBehavior defaultValue) {
		return this._resizeBehavior == null ? defaultValue : this._resizeBehavior;
	}

	public boolean hasResizeBehavior() {
		return this._resizeBehavior != null;
	}

	public ColumnSpec removeResizeBehavior() {
		this._resizeBehavior = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ColumnSpec that = (ColumnSpec) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "columnSpec(columnAlignment,size,resizeBehavior) ::= <<~if(columnAlignment)~~columnAlignment~:~endif~~size~~if(resizeBehavior)~:~resizeBehavior~~endif~ >>";
}  