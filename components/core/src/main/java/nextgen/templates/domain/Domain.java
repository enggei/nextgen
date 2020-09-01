package nextgen.templates.domain;

public class Domain {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _packageName;
	private Object _observable;
	private java.util.List<Entity> _entities = new java.util.ArrayList<>();

	Domain(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Domain");
		st.add("name", _name);
		st.add("packageName", _packageName);
		st.add("observable", _observable);
		for (Object o : _entities) st.add("entities", o);
		return st.render().trim();
	}

	public Domain setName(String value) {
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

	public Domain removeName() {
		this._name = null;
		return this;
	} 

	public Domain setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public Domain removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Domain setObservable(Object value) {
		this._observable = value;
		return this;
	}

	public Object getObservable() {
		return this._observable;
	}

	public Object getObservable(Object defaultValue) {
		return this._observable == null ? defaultValue : this._observable;
	}

	public boolean hasObservable() {
		return this._observable != null;
	}

	public Domain removeObservable() {
		this._observable = null;
		return this;
	} 

	public Domain addEntities(Entity value) {
		this._entities.add(value);
		return this;
	}

	public Domain setEntities(Entity[] value) {
		this._entities.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Domain setEntities(java.util.Collection<Entity> values) {
		this._entities.addAll(values);
		return this;
	}

	public Domain removeEntities(Entity value) {
		this._entities.remove(value);
		return this;
	}

	public Domain removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Entity> getEntities() {
		return this._entities;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Domain that = (Domain) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Domain(name,packageName,observable,entities) ::= <<Domain: ~name~ ~if(packageName)~(~packageName~)~endif~ ~if(observable)~observable~endif~\n" + 
				"Entities:\n" + 
				"~entities:{it|~it~};separator=\"\\n\"~ >>";
}  