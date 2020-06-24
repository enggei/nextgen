package nextgen.templates.javascript;

public class MapProps {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _property;
	private Object _forEach;

	MapProps(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MapProps");
		st.add("property", _property);
		st.add("forEach", _forEach);
		return st.render().trim();
	}

	public MapProps setProperty(Object value) {
		this._property = value;
		return this;
	}

	public Object getProperty() {
		return this._property;
	}

	public Object getProperty(Object defaultValue) {
		return this._property == null ? defaultValue : this._property;
	}

	public boolean hasProperty() {
		return this._property != null;
	}

	public MapProps removeProperty() {
		this._property = null;
		return this;
	} 

	public MapProps setForEach(Object value) {
		this._forEach = value;
		return this;
	}

	public Object getForEach() {
		return this._forEach;
	}

	public Object getForEach(Object defaultValue) {
		return this._forEach == null ? defaultValue : this._forEach;
	}

	public boolean hasForEach() {
		return this._forEach != null;
	}

	public MapProps removeForEach() {
		this._forEach = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MapProps that = (MapProps) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MapProps(property,forEach) ::= <<{\n" + 
				"	props.~property~.map((element) => (\n" + 
				"		~forEach~\n" + 
				"	)) \n" + 
				"} >>";
} 