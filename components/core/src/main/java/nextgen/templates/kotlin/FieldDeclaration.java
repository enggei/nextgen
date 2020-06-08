package nextgen.templates.kotlin;

public class FieldDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _annotations = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	FieldDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FieldDeclaration that = (FieldDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FieldDeclaration");
		for (Object o : _annotations) st.add("annotations", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{isMutable,isNonMember,name,type,initializer}", map.get("isMutable"), map.get("isNonMember"), map.get("name"), map.get("type"), map.get("initializer"));
		return st.render().trim();
	}

	public FieldDeclaration addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public FieldDeclaration removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public FieldDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	} 
	public FieldDeclaration addFields(Object _isMutable, Object _isNonMember, Object _name, Object _type, Object _initializer) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("isMutable", _isMutable);
		map.put("isNonMember", _isNonMember);
		map.put("name", _name);
		map.put("type", _type);
		map.put("initializer", _initializer);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public FieldDeclaration addFields(FieldDeclaration_Fields value) {
		return addFields(value._isMutable, value._isNonMember, value._name, value._type, value._initializer);
	}

	public java.util.stream.Stream<FieldDeclaration_Fields> streamFields() {
		return this._fields.stream().map(FieldDeclaration_Fields::new);
	}

	public static final class FieldDeclaration_Fields {

		Object _isMutable;
		Object _isNonMember;
		Object _name;
		Object _type;
		Object _initializer;

		public FieldDeclaration_Fields(Object _isMutable, Object _isNonMember, Object _name, Object _type, Object _initializer) {
			this._isMutable = _isMutable;
			this._isNonMember = _isNonMember;
			this._name = _name;
			this._type = _type;
			this._initializer = _initializer;
		}

		private FieldDeclaration_Fields(java.util.Map<String, Object> map) {
			this._isMutable = (Object) map.get("isMutable");
			this._isNonMember = (Object) map.get("isNonMember");
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
			this._initializer = (Object) map.get("initializer");
		}

		public Object getIsMutable() {
			return this._isMutable;
		}

		public Object getIsNonMember() {
			return this._isNonMember;
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

		public Object getInitializer() {
			return this._initializer;
		}

	} 

	static final String st = "FieldDeclaration(annotations,fields) ::= <<~annotations:{it|~it~};separator=\"\\n\"~\n" + 
				"~fields:{it|~if(it.isMutable)~var ~elseif(it.isNonMember)~~else~val ~endif~~it.name~: ~it.type~~if(it.initializer)~ = ~it.initializer~~endif~};separator=\",\\n\"~>> ";
} 