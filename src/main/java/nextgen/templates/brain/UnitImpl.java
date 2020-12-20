package nextgen.templates.brain;

public class UnitImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _unit;
	private Object _packageName;
	private String _name;
	private Object _T;
	private Object _get;

	UnitImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UnitImpl");
		st.add("unit", _unit);
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("T", _T);
		st.add("get", _get);
		return st.render().trim();
	}

	public UnitImpl setUnit(Object value) {
		this._unit = value;
		return this;
	}

	public Object getUnit() {
		return this._unit;
	}

	public Object getUnit(Object defaultValue) {
		return this._unit == null ? defaultValue : this._unit;
	}

	public boolean hasUnit() {
		return this._unit != null;
	}

	public UnitImpl removeUnit() {
		this._unit = null;
		return this;
	} 

	public UnitImpl setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public UnitImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public UnitImpl setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public UnitImpl removeName() {
		this._name = null;
		return this;
	} 

	public UnitImpl setT(Object value) {
		this._T = value;
		return this;
	}

	public Object getT() {
		return this._T;
	}

	public Object getT(Object defaultValue) {
		return this._T == null ? defaultValue : this._T;
	}

	public boolean hasT() {
		return this._T != null;
	}

	public UnitImpl removeT() {
		this._T = null;
		return this;
	} 

	public UnitImpl setGet(Object value) {
		this._get = value;
		return this;
	}

	public Object getGet() {
		return this._get;
	}

	public Object getGet(Object defaultValue) {
		return this._get == null ? defaultValue : this._get;
	}

	public boolean hasGet() {
		return this._get != null;
	}

	public UnitImpl removeGet() {
		this._get = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UnitImpl that = (UnitImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "UnitImpl(unit,packageName,name,T,get) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ implements ~unit~ {\n" + 
				"\n" + 
				"	@Override\n" + 
				"   public ~T~ get() {\n" + 
				"      ~get~\n" + 
				"   }\n" + 
				"} >>";
}  