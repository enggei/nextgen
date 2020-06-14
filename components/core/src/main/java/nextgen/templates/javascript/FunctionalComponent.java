package nextgen.templates.javascript;

public class FunctionalComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _element;
	private java.util.List<Object> _dependencies = new java.util.ArrayList<>();

	FunctionalComponent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionalComponent");
		st.add("name", _name);
		st.add("element", _element);
		for (Object o : _dependencies) st.add("dependencies", o);
		return st.render().trim();
	}

	public FunctionalComponent setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public FunctionalComponent removeName() {
		this._name = null;
		return this;
	} 

	public FunctionalComponent setElement(Object value) {
		this._element = value;
		return this;
	}

	public Object getElement() {
		return this._element;
	}

	public Object getElement(Object defaultValue) {
		return this._element == null ? defaultValue : this._element;
	}

	public boolean hasElement() {
		return this._element != null;
	}

	public FunctionalComponent removeElement() {
		this._element = null;
		return this;
	} 

	public FunctionalComponent addDependencies(Object value) {
		this._dependencies.add(value);
		return this;
	}

	public FunctionalComponent setDependencies(Object[] value) {
		this._dependencies.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionalComponent setDependencies(java.util.Collection<Object> values) {
		this._dependencies.addAll(values);
		return this;
	}

	public FunctionalComponent removeDependencies(Object value) {
		this._dependencies.remove(value);
		return this;
	}

	public FunctionalComponent removeDependencies(int index) {
		this._dependencies.remove(index);
		return this;
	}

	public java.util.List<Object> getDependencies() {
		return this._dependencies;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionalComponent that = (FunctionalComponent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionalComponent(dependencies,name,element) ::= <<~dependencies:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"function ~name~(props) {\n" + 
				"\n" + 
				"	return (\n" + 
				"		~element~\n" + 
				"	)\n" + 
				"}\n" + 
				"\n" + 
				"export default ~name~; >>";
} 