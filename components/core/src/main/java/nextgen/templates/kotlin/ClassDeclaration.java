package nextgen.templates.kotlin;

public class ClassDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _annotations;
	private Object _isOpen;
	private Object _isAbstract;
	private Object _name;
	private Object _extends;
	private java.util.List<Object> _fields = new java.util.ArrayList<>();

	ClassDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClassDeclaration that = (ClassDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassDeclaration");
		st.add("annotations", _annotations);
		st.add("isOpen", _isOpen);
		st.add("isAbstract", _isAbstract);
		st.add("name", _name);
		st.add("extends", _extends);
		for (Object o : _fields) st.add("fields", o);
		return st.render().trim();
	}

	public ClassDeclaration setAnnotations(Object value) {
		this._annotations = value;
		return this;
	}

	public Object getAnnotations() {
		return this._annotations;
	}

	public boolean hasAnnotations() {
		return this._annotations != null;
	}

	public ClassDeclaration removeAnnotations() {
		this._annotations = null;
		return this;
	} 

	public ClassDeclaration setIsOpen(Object value) {
		this._isOpen = value;
		return this;
	}

	public Object getIsOpen() {
		return this._isOpen;
	}

	public boolean hasIsOpen() {
		return this._isOpen != null;
	}

	public ClassDeclaration removeIsOpen() {
		this._isOpen = null;
		return this;
	} 

	public ClassDeclaration setIsAbstract(Object value) {
		this._isAbstract = value;
		return this;
	}

	public Object getIsAbstract() {
		return this._isAbstract;
	}

	public boolean hasIsAbstract() {
		return this._isAbstract != null;
	}

	public ClassDeclaration removeIsAbstract() {
		this._isAbstract = null;
		return this;
	} 

	public ClassDeclaration setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public ClassDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public ClassDeclaration setExtends(Object value) {
		this._extends = value;
		return this;
	}

	public Object getExtends() {
		return this._extends;
	}

	public boolean hasExtends() {
		return this._extends != null;
	}

	public ClassDeclaration removeExtends() {
		this._extends = null;
		return this;
	} 
	public ClassDeclaration addFields(Object value) {
		this._fields.add(value);
		return this;
	}

	public ClassDeclaration removeFields(Object value) {
		this._fields.remove(value);
		return this;
	}

	public ClassDeclaration removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<Object> getFields() {
		return this._fields;
	} 

	static final String st = "ClassDeclaration(annotations,isOpen,isAbstract,name,fields,extends) ::= <<~annotations~\n" + 
				"~if(isOpen)~open ~elseif(isAbstract)~abstract ~endif~class ~name~(\n" + 
				"	~fields:{it|~it~};separator=\"\\n\"~\n" + 
				") ~if(extends)~extends : ~extends~~endif~{\n" + 
				"	\n" + 
				"}>> ";
} 