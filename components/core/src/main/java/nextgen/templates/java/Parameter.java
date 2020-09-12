package nextgen.templates.java;

public class Parameter {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _isVarargs;
	private Object _name;
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();

	Parameter(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Parameter");
		st.add("type", _type);
		st.add("isVarargs", _isVarargs);
		st.add("name", _name);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _modifiers) st.add("modifiers", o);
		return st.render().trim();
	}

	public Parameter setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public Parameter removeType() {
		this._type = null;
		return this;
	} 

	public Parameter setIsVarargs(Object value) {
		this._isVarargs = value;
		return this;
	}

	public Object getIsVarargs() {
		return this._isVarargs;
	}

	public Object getIsVarargs(Object defaultValue) {
		return this._isVarargs == null ? defaultValue : this._isVarargs;
	}

	public boolean hasIsVarargs() {
		return this._isVarargs != null;
	}

	public Parameter removeIsVarargs() {
		this._isVarargs = null;
		return this;
	} 

	public Parameter setName(Object value) {
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

	public Parameter removeName() {
		this._name = null;
		return this;
	} 

	public Parameter addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public Parameter setAnnotations(Object[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Parameter setAnnotations(java.util.Collection<Object> values) {
		this._annotations.addAll(values);
		return this;
	}

	public Parameter removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public Parameter removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	} 

	public Parameter addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public Parameter setModifiers(Object[] value) {
		this._modifiers.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Parameter setModifiers(java.util.Collection<Object> values) {
		this._modifiers.addAll(values);
		return this;
	}

	public Parameter removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public Parameter removeModifiers(int index) {
		this._modifiers.remove(index);
		return this;
	}

	public java.util.List<Object> getModifiers() {
		return this._modifiers;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Parameter that = (Parameter) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Parameter(annotations,modifiers,type,isVarargs,name) ::= <<~annotations:{it|~it~};separator=\" \"~~if(annotations)~ ~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~~if(type)~~type~ ~endif~~if(isVarargs)~... ~endif~~name~ >>";
}  