package nextgen.templates.test;

public class Temp {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _yolo;
	private java.util.List<Object> _yys = new java.util.ArrayList<>();

	Temp(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Temp");
		st.add("yolo", _yolo);
		for (Object o : _yys) st.add("yys", o);
		return st.render().trim();
	}

	public Temp setYolo(Object value) {
		this._yolo = value;
		return this;
	}

	public Object getYolo() {
		return this._yolo;
	}

	public Object getYolo(Object defaultValue) {
		return this._yolo == null ? defaultValue : this._yolo;
	}

	public boolean hasYolo() {
		return this._yolo != null;
	}

	public Temp removeYolo() {
		this._yolo = null;
		return this;
	} 

	public Temp addYys(Object value) {
		this._yys.add(value);
		return this;
	}

	public Temp setYys(Object[] value) {
		this._yys.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Temp setYys(java.util.Collection<Object> values) {
		this._yys.addAll(values);
		return this;
	}

	public Temp removeYys(Object value) {
		this._yys.remove(value);
		return this;
	}

	public Temp removeYys(int index) {
		this._yys.remove(index);
		return this;
	}

	public java.util.List<Object> getYys() {
		return this._yys;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Temp that = (Temp) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Temp(yolo,yys) ::= <<lol ~yolo~\n" + 
				"\n" + 
				"class test\n" + 
				"\n" + 
				"xxxxx ~yys:{it|~it~};separator=\",\"~ >>";
}  