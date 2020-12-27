package nextgen.templates.jgoodies;

public class FormPanel {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private Object _rowSpec;
	private Object _rows;
	private String _name;
	private Object _model;
	private Object _colSpec;
	private Object _columns;
	private Object _extending;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _components = new java.util.ArrayList<>();

	FormPanel(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FormPanel");
		st.add("package", _package);
		st.add("rowSpec", _rowSpec);
		st.add("rows", _rows);
		st.add("name", _name);
		st.add("model", _model);
		st.add("colSpec", _colSpec);
		st.add("columns", _columns);
		st.add("extending", _extending);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _components) st.addAggr("components.{w,vAlign,h,hAlign,x,init,type,name,y}", map.get("w"), map.get("vAlign"), map.get("h"), map.get("hAlign"), map.get("x"), map.get("init"), map.get("type"), map.get("name"), map.get("y"));
		return st.render().trim();
	}

	public FormPanel setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public Object getPackage(Object defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public FormPanel removePackage() {
		this._package = null;
		return this;
	} 

	public FormPanel setRowSpec(Object value) {
		this._rowSpec = value;
		return this;
	}

	public Object getRowSpec() {
		return this._rowSpec;
	}

	public Object getRowSpec(Object defaultValue) {
		return this._rowSpec == null ? defaultValue : this._rowSpec;
	}

	public boolean hasRowSpec() {
		return this._rowSpec != null;
	}

	public FormPanel removeRowSpec() {
		this._rowSpec = null;
		return this;
	} 

	public FormPanel setRows(Object value) {
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

	public FormPanel removeRows() {
		this._rows = null;
		return this;
	} 

	public FormPanel setName(String value) {
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

	public FormPanel removeName() {
		this._name = null;
		return this;
	} 

	public FormPanel setModel(Object value) {
		this._model = value;
		return this;
	}

	public Object getModel() {
		return this._model;
	}

	public Object getModel(Object defaultValue) {
		return this._model == null ? defaultValue : this._model;
	}

	public boolean hasModel() {
		return this._model != null;
	}

	public FormPanel removeModel() {
		this._model = null;
		return this;
	} 

	public FormPanel setColSpec(Object value) {
		this._colSpec = value;
		return this;
	}

	public Object getColSpec() {
		return this._colSpec;
	}

	public Object getColSpec(Object defaultValue) {
		return this._colSpec == null ? defaultValue : this._colSpec;
	}

	public boolean hasColSpec() {
		return this._colSpec != null;
	}

	public FormPanel removeColSpec() {
		this._colSpec = null;
		return this;
	} 

	public FormPanel setColumns(Object value) {
		this._columns = value;
		return this;
	}

	public Object getColumns() {
		return this._columns;
	}

	public Object getColumns(Object defaultValue) {
		return this._columns == null ? defaultValue : this._columns;
	}

	public boolean hasColumns() {
		return this._columns != null;
	}

	public FormPanel removeColumns() {
		this._columns = null;
		return this;
	} 

	public FormPanel setExtending(Object value) {
		this._extending = value;
		return this;
	}

	public Object getExtending() {
		return this._extending;
	}

	public Object getExtending(Object defaultValue) {
		return this._extending == null ? defaultValue : this._extending;
	}

	public boolean hasExtending() {
		return this._extending != null;
	}

	public FormPanel removeExtending() {
		this._extending = null;
		return this;
	} 

	public FormPanel addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public FormPanel setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FormPanel setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public FormPanel removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public FormPanel removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public FormPanel addComponents(Object _w, Object _vAlign, Object _h, Object _hAlign, Object _x, Object _init, Object _type, Object _name, Object _y) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("w", _w);
		map.put("vAlign", _vAlign);
		map.put("h", _h);
		map.put("hAlign", _hAlign);
		map.put("x", _x);
		map.put("init", _init);
		map.put("type", _type);
		map.put("name", _name);
		map.put("y", _y);
		this._components.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getComponents() {
		return this._components;
	}

	public FormPanel addComponents(FormPanel_Components value) {
		return addComponents(value._w, value._vAlign, value._h, value._hAlign, value._x, value._init, value._type, value._name, value._y);
	}

	public java.util.stream.Stream<FormPanel_Components> streamComponents() {
		return this._components.stream().map(FormPanel_Components::new);
	}

	public java.util.List<Object> getComponents_W() {
		return streamComponents().map(FormPanel_Components::getW).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_VAlign() {
		return streamComponents().map(FormPanel_Components::getVAlign).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_H() {
		return streamComponents().map(FormPanel_Components::getH).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_HAlign() {
		return streamComponents().map(FormPanel_Components::getHAlign).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_X() {
		return streamComponents().map(FormPanel_Components::getX).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_Init() {
		return streamComponents().map(FormPanel_Components::getInit).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_Type() {
		return streamComponents().map(FormPanel_Components::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_Name() {
		return streamComponents().map(FormPanel_Components::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getComponents_Y() {
		return streamComponents().map(FormPanel_Components::getY).collect(java.util.stream.Collectors.toList());
	}


	public static final class FormPanel_Components {

		Object _w;
		Object _vAlign;
		Object _h;
		Object _hAlign;
		Object _x;
		Object _init;
		Object _type;
		Object _name;
		Object _y;

		public FormPanel_Components(Object _w, Object _vAlign, Object _h, Object _hAlign, Object _x, Object _init, Object _type, Object _name, Object _y) {
			this._w = _w;
			this._vAlign = _vAlign;
			this._h = _h;
			this._hAlign = _hAlign;
			this._x = _x;
			this._init = _init;
			this._type = _type;
			this._name = _name;
			this._y = _y;
		}

		private FormPanel_Components(java.util.Map<String, Object> map) {
			this._w = (Object) map.get("w");
			this._vAlign = (Object) map.get("vAlign");
			this._h = (Object) map.get("h");
			this._hAlign = (Object) map.get("hAlign");
			this._x = (Object) map.get("x");
			this._init = (Object) map.get("init");
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._y = (Object) map.get("y");
		}

		public Object getW() {
			return this._w;
		}

		public Object getVAlign() {
			return this._vAlign;
		}

		public Object getH() {
			return this._h;
		}

		public Object getHAlign() {
			return this._hAlign;
		}

		public Object getX() {
			return this._x;
		}

		public Object getInit() {
			return this._init;
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getY() {
			return this._y;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormPanel that = (FormPanel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FormPanel(package,rowSpec,rows,name,components,model,colSpec,columns,extending,statements) ::= <<package ~package~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"\n" + 
				"public class ~name~~if(extending)~ extends ~extending~~endif~ {\n" + 
				"	\n" + 
				"	// columns 	~columns~	\"~colSpec~\"\n" + 
				"	// rows 		~rows~ 	\"~rowSpec~\"\n" + 
				"	\n" + 
				"	~components:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~() {\n" + 
				"		setLayout(new com.jgoodies.forms.layout.FormLayout(\"~colSpec~\", \"~rowSpec~\"));\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"~components:{it|~if(it.init)~\n" + 
				"		set~it.name;format=\"capitalize\"~(~it.init~);\n" + 
				"~endif~}~\n" + 
				"	}\n" + 
				"\n" + 
				"~components:{it|\n" + 
				"	public ~name~ set~it.name;format=\"capitalize\"~(~it.type~ component) {\n" + 
				"		add(this.~it.name~ = component, new com.jgoodies.forms.layout.CellConstraints().xywh(~it.x~, ~it.y~, ~it.w~, ~it.h~, \"~it.hAlign~, ~it.vAlign~\"));\n" + 
				"		return this;\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\"~\n" + 
				"\n" + 
				"	/* \n" + 
				"	   \n" + 
				"	 /~model~\n" + 
				"	 \n" + 
				"	*/\n" + 
				"} >>";
}  