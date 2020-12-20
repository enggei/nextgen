package nextgen.templates.jgoodies;

public class Constraints {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _hAlign;
	private Object _rowSpan;
	private Object _colSpan;
	private Object _row;
	private Object _vAlign;
	private Object _column;

	Constraints(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("constraints");
		st.add("hAlign", _hAlign);
		st.add("rowSpan", _rowSpan);
		st.add("colSpan", _colSpan);
		st.add("row", _row);
		st.add("vAlign", _vAlign);
		st.add("column", _column);
		return st.render().trim();
	}

	public Constraints setHAlign(Object value) {
		this._hAlign = value;
		return this;
	}

	public Object getHAlign() {
		return this._hAlign;
	}

	public Object getHAlign(Object defaultValue) {
		return this._hAlign == null ? defaultValue : this._hAlign;
	}

	public boolean hasHAlign() {
		return this._hAlign != null;
	}

	public Constraints removeHAlign() {
		this._hAlign = null;
		return this;
	} 

	public Constraints setRowSpan(Object value) {
		this._rowSpan = value;
		return this;
	}

	public Object getRowSpan() {
		return this._rowSpan;
	}

	public Object getRowSpan(Object defaultValue) {
		return this._rowSpan == null ? defaultValue : this._rowSpan;
	}

	public boolean hasRowSpan() {
		return this._rowSpan != null;
	}

	public Constraints removeRowSpan() {
		this._rowSpan = null;
		return this;
	} 

	public Constraints setColSpan(Object value) {
		this._colSpan = value;
		return this;
	}

	public Object getColSpan() {
		return this._colSpan;
	}

	public Object getColSpan(Object defaultValue) {
		return this._colSpan == null ? defaultValue : this._colSpan;
	}

	public boolean hasColSpan() {
		return this._colSpan != null;
	}

	public Constraints removeColSpan() {
		this._colSpan = null;
		return this;
	} 

	public Constraints setRow(Object value) {
		this._row = value;
		return this;
	}

	public Object getRow() {
		return this._row;
	}

	public Object getRow(Object defaultValue) {
		return this._row == null ? defaultValue : this._row;
	}

	public boolean hasRow() {
		return this._row != null;
	}

	public Constraints removeRow() {
		this._row = null;
		return this;
	} 

	public Constraints setVAlign(Object value) {
		this._vAlign = value;
		return this;
	}

	public Object getVAlign() {
		return this._vAlign;
	}

	public Object getVAlign(Object defaultValue) {
		return this._vAlign == null ? defaultValue : this._vAlign;
	}

	public boolean hasVAlign() {
		return this._vAlign != null;
	}

	public Constraints removeVAlign() {
		this._vAlign = null;
		return this;
	} 

	public Constraints setColumn(Object value) {
		this._column = value;
		return this;
	}

	public Object getColumn() {
		return this._column;
	}

	public Object getColumn(Object defaultValue) {
		return this._column == null ? defaultValue : this._column;
	}

	public boolean hasColumn() {
		return this._column != null;
	}

	public Constraints removeColumn() {
		this._column = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Constraints that = (Constraints) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "constraints(hAlign,rowSpan,colSpan,row,vAlign,column) ::= <<~column~, ~row ~[, ~colSpan~, ~rowSpan~][, ~hAlign~, ~vAlign~] >>";
}  