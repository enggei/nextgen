package nextgen.templates.java;

public class Bean {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _package;
	private String _name;
	private Object _beanListener;
	private Object _eqha;
	private java.util.List<String> _lexical = new java.util.ArrayList<>();
	private java.util.List<Object> _fieldDeclarations = new java.util.ArrayList<>();
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Bean(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Bean");
		st.add("package", _package);
		st.add("name", _name);
		st.add("beanListener", _beanListener);
		st.add("eqha", _eqha);
		for (Object o : _lexical) st.add("lexical", o);
		for (Object o : _fieldDeclarations) st.add("fieldDeclarations", o);
		for (Object o : _accessors) st.add("accessors", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name,initializer,type}", map.get("name"), map.get("initializer"), map.get("type"));
		return st.render().trim();
	}

	public Bean setPackage(String value) {
		this._package = value;
		return this;
	}

	public String getPackage() {
		return this._package;
	}

	public String getPackage(String defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public Bean removePackage() {
		this._package = null;
		return this;
	} 

	public Bean setName(String value) {
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

	public Bean removeName() {
		this._name = null;
		return this;
	} 

	public Bean setBeanListener(Object value) {
		this._beanListener = value;
		return this;
	}

	public Object getBeanListener() {
		return this._beanListener;
	}

	public Object getBeanListener(Object defaultValue) {
		return this._beanListener == null ? defaultValue : this._beanListener;
	}

	public boolean hasBeanListener() {
		return this._beanListener != null;
	}

	public Bean removeBeanListener() {
		this._beanListener = null;
		return this;
	} 

	public Bean setEqha(Object value) {
		this._eqha = value;
		return this;
	}

	public Object getEqha() {
		return this._eqha;
	}

	public Object getEqha(Object defaultValue) {
		return this._eqha == null ? defaultValue : this._eqha;
	}

	public boolean hasEqha() {
		return this._eqha != null;
	}

	public Bean removeEqha() {
		this._eqha = null;
		return this;
	} 

	public Bean addLexical(String value) {
		this._lexical.add(value);
		return this;
	}

	public Bean setLexical(String[] value) {
		this._lexical.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Bean setLexical(java.util.Collection<String> values) {
		this._lexical.addAll(values);
		return this;
	}

	public Bean removeLexical(String value) {
		this._lexical.remove(value);
		return this;
	}

	public Bean removeLexical(int index) {
		this._lexical.remove(index);
		return this;
	}

	public java.util.List<String> getLexical() {
		return this._lexical;
	} 

	public Bean addFieldDeclarations(Object value) {
		this._fieldDeclarations.add(value);
		return this;
	}

	public Bean setFieldDeclarations(Object[] value) {
		this._fieldDeclarations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Bean setFieldDeclarations(java.util.Collection<Object> values) {
		this._fieldDeclarations.addAll(values);
		return this;
	}

	public Bean removeFieldDeclarations(Object value) {
		this._fieldDeclarations.remove(value);
		return this;
	}

	public Bean removeFieldDeclarations(int index) {
		this._fieldDeclarations.remove(index);
		return this;
	}

	public java.util.List<Object> getFieldDeclarations() {
		return this._fieldDeclarations;
	} 

	public Bean addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public Bean setAccessors(Object[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Bean setAccessors(java.util.Collection<Object> values) {
		this._accessors.addAll(values);
		return this;
	}

	public Bean removeAccessors(Object value) {
		this._accessors.remove(value);
		return this;
	}

	public Bean removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Object> getAccessors() {
		return this._accessors;
	} 

	public Bean addFields(String _name, Object _initializer, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("initializer", _initializer);
		map.put("type", _type);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Bean addFields(Bean_Fields value) {
		return addFields(value._name, value._initializer, value._type);
	}

	public java.util.stream.Stream<Bean_Fields> streamFields() {
		return this._fields.stream().map(Bean_Fields::new);
	}

	public java.util.List<String> getFields_Name() {
		return streamFields().map(Bean_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Initializer() {
		return streamFields().map(Bean_Fields::getInitializer).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Bean_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class Bean_Fields {

		String _name;
		Object _initializer;
		Object _type;

		public Bean_Fields(String _name, Object _initializer, Object _type) {
			this._name = _name;
			this._initializer = _initializer;
			this._type = _type;
		}

		private Bean_Fields(java.util.Map<String, Object> map) {
			this._name = (String) map.get("name");
			this._initializer = (Object) map.get("initializer");
			this._type = (Object) map.get("type");
		}

		public String getName() {
			return this._name;
		}

		public Object getInitializer() {
			return this._initializer;
		}

		public Object getType() {
			return this._type;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Bean that = (Bean) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Bean(fields,package,name,beanListener,lexical,eqha,fieldDeclarations,accessors) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name~ implements java.beans.PropertyChangeListener {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
				"	~fieldDeclarations:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);\n" + 
				"	\n" + 
				"	public ~name~() {\n" + 
				"	}\n" + 
				"	\n" + 
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"~if(lexical)~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return \"\" + ~lexical:{it|_~it~};separator=\" + \\\" \\\" + \"~;\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"\n" + 
				"~if(eqha)~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		~name~ that = (~name~) o;\n" + 
				"		return _~eqha~.equals(that._~eqha~);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return java.util.Objects.hash(_~eqha~);\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void propertyChange(java.beans.PropertyChangeEvent evt) {\n" + 
				"		this.pcs.firePropertyChange(\"~name~\", this, evt);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {\n" + 
				"		this.pcs.addPropertyChangeListener(listener);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {\n" + 
				"		this.pcs.removePropertyChangeListener(listener);\n" + 
				"	}\n" + 
				"\n" + 
				"	~beanListener~\n" + 
				"} >>";
}  