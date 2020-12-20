package nextgen.templates.jgoodies;

public class RowSpec {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private ResizeBehavior _resizeBehavior;
	private rowAlignment _rowAlignment;
	private Size _size;

	RowSpec(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("rowSpec");
		st.add("resizeBehavior", _resizeBehavior);
		st.add("rowAlignment", _rowAlignment);
		st.add("size", _size);
		return st.render().trim();
	}

	public RowSpec setResizeBehavior(ResizeBehavior value) {
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

	public RowSpec removeResizeBehavior() {
		this._resizeBehavior = null;
		return this;
	} 

	public RowSpec setRowAlignment(rowAlignment value) {
		this._rowAlignment = value;
		return this;
	}

	public rowAlignment getRowAlignment() {
		return this._rowAlignment;
	}

	public rowAlignment getRowAlignment(rowAlignment defaultValue) {
		return this._rowAlignment == null ? defaultValue : this._rowAlignment;
	}

	public boolean hasRowAlignment() {
		return this._rowAlignment != null;
	}

	public RowSpec removeRowAlignment() {
		this._rowAlignment = null;
		return this;
	} 

	public RowSpec setSize(Size value) {
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

	public RowSpec removeSize() {
		this._size = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RowSpec that = (RowSpec) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "rowSpec(resizeBehavior,rowAlignment,size) ::= <<~if(rowAlignment)~~rowAlignment~:~endif~~size~~if(resizeBehavior)~:~resizeBehavior~~endif~ >>";
}  