package nextgen.templates.materialui;

public class TextareaAutosizeElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _id;
	private Object _rows;
	private Object _rowsMax;
	private Object _rowsMin;
	private Object _style;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TextareaAutosizeElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TextareaAutosizeElement");
		st.add("className", _className);
		st.add("id", _id);
		st.add("rows", _rows);
		st.add("rowsMax", _rowsMax);
		st.add("rowsMin", _rowsMin);
		st.add("style", _style);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
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

	public TextareaAutosizeElement setId(Object value) {
		this._id = value;
		return this;
	}

	public Object getId() {
		return this._id;
	}

	public Object getId(Object defaultValue) {
		return this._id == null ? defaultValue : this._id;
	}

	public boolean hasId() {
		return this._id != null;
	}

	public TextareaAutosizeElement removeId() {
		this._id = null;
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

	public TextareaAutosizeElement setStyle(Object value) {
		this._style = value;
		return this;
	}

	public Object getStyle() {
		return this._style;
	}

	public Object getStyle(Object defaultValue) {
		return this._style == null ? defaultValue : this._style;
	}

	public boolean hasStyle() {
		return this._style != null;
	}

	public TextareaAutosizeElement removeStyle() {
		this._style = null;
		return this;
	} 


	public TextareaAutosizeElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TextareaAutosizeElement addAttribute(TextareaAutosizeElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TextareaAutosizeElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TextareaAutosizeElement_Attribute::new);
	}

	public static final class TextareaAutosizeElement_Attribute {

		Object _name;
		Object _value;

		public TextareaAutosizeElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TextareaAutosizeElement_Attribute(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

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

	static final String st = "TextareaAutosizeElement(className,id,rows,rowsMax,rowsMin,style,attribute) ::= <<<TextareaAutosize~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(rows)~\n" + 
				"	rows=~rows~~endif~~if(rowsMax)~\n" + 
				"	rowsMax=~rowsMax~~endif~~if(rowsMin)~\n" + 
				"	rowsMin=~rowsMin~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  