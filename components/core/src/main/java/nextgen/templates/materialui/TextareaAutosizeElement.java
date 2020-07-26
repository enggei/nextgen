package nextgen.templates.materialui;

public class TextareaAutosizeElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _rows;
	private Object _rowsMax;
	private Object _rowsMin;

	TextareaAutosizeElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TextareaAutosizeElement");
		st.add("className", _className);
		st.add("rows", _rows);
		st.add("rowsMax", _rowsMax);
		st.add("rowsMin", _rowsMin);
		return st.render().trim();
	}

	public TextareaAutosizeElement setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public TextareaAutosizeElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TextareaAutosizeElement setRows(Object value) {
		this._rows = value;
		return this;
	}

	public Object getRows() {
		return this._rows;
	}

	public Object getRows(Object defaultValue) {
		return this._rows == null ? defaultValue : this._rows;
	}

	public boolean hasRows() {
		return this._rows != null;
	}

	public TextareaAutosizeElement removeRows() {
		this._rows = null;
		return this;
	} 

	public TextareaAutosizeElement setRowsMax(Object value) {
		this._rowsMax = value;
		return this;
	}

	public Object getRowsMax() {
		return this._rowsMax;
	}

	public Object getRowsMax(Object defaultValue) {
		return this._rowsMax == null ? defaultValue : this._rowsMax;
	}

	public boolean hasRowsMax() {
		return this._rowsMax != null;
	}

	public TextareaAutosizeElement removeRowsMax() {
		this._rowsMax = null;
		return this;
	} 

	public TextareaAutosizeElement setRowsMin(Object value) {
		this._rowsMin = value;
		return this;
	}

	public Object getRowsMin() {
		return this._rowsMin;
	}

	public Object getRowsMin(Object defaultValue) {
		return this._rowsMin == null ? defaultValue : this._rowsMin;
	}

	public boolean hasRowsMin() {
		return this._rowsMin != null;
	}

	public TextareaAutosizeElement removeRowsMin() {
		this._rowsMin = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TextareaAutosizeElement that = (TextareaAutosizeElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TextareaAutosizeElement(className,rows,rowsMax,rowsMin) ::= <<<TextareaAutosize~if(className)~\n" + 
				"	className=~className~~endif~~if(rows)~\n" + 
				"	rows=~rows~~endif~~if(rowsMax)~\n" + 
				"	rowsMax=~rowsMax~~endif~~if(rowsMin)~\n" + 
				"	rowsMin=~rowsMin~~endif~ /> >>";
}  