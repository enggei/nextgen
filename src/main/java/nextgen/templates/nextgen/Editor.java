package nextgen.templates.nextgen;

public class Editor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _modelType;
	private String _name;
	private Object _packageName;
	private java.util.List<java.util.Map<String, Object>> _editors = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _events = new java.util.ArrayList<>();

	Editor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Editor");
		st.add("modelType", _modelType);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (java.util.Map<String, Object> map : _editors) st.addAggr("editors.{setModel,type,name}", map.get("setModel"), map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _events) st.addAggr("events.{predicate,type}", map.get("predicate"), map.get("type"));
		return st.render().trim();
	}

	public Editor setModelType(Object value) {
		this._modelType = value;
		return this;
	}

	public Object getModelType() {
		return this._modelType;
	}

	public Object getModelType(Object defaultValue) {
		return this._modelType == null ? defaultValue : this._modelType;
	}

	public boolean hasModelType() {
		return this._modelType != null;
	}

	public Editor removeModelType() {
		this._modelType = null;
		return this;
	} 

	public Editor setName(String value) {
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

	public Editor removeName() {
		this._name = null;
		return this;
	} 

	public Editor setPackageName(Object value) {
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

	public Editor removePackageName() {
		this._packageName = null;
		return this;
	} 


	public Editor setEditors(java.util.Collection<Editor_Editors> values) {
			this._editors.clear();
			values.stream().map(Editor_Editors::asMap).forEach(map -> _editors.add(map));
			return this;
		}

	public Editor addEditors(Object _setModel, Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("setModel", _setModel);
		map.put("type", _type);
		map.put("name", _name);
		this._editors.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEditors() {
		return this._editors;
	}

	public Editor addEditors(Editor_Editors value) {
		return addEditors(value._setModel, value._type, value._name);
	}

	public java.util.stream.Stream<Editor_Editors> streamEditors() {
		return this._editors.stream().map(Editor_Editors::new);
	}

	public java.util.List<Object> getEditors_SetModel() {
		return streamEditors().map(Editor_Editors::getSetModel).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getEditors_Type() {
		return streamEditors().map(Editor_Editors::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getEditors_Name() {
		return streamEditors().map(Editor_Editors::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Editor_Editors {

		Object _setModel;
		Object _type;
		Object _name;

		public Editor_Editors(Object _setModel, Object _type, Object _name) {
			this._setModel = _setModel;
			this._type = _type;
			this._name = _name;
		}

		private Editor_Editors(java.util.Map<String, Object> map) {
			this._setModel = (Object) map.get("setModel");
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getSetModel() {
			return this._setModel;
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("setModel", _setModel);
			map.put("type", _type);
			map.put("name", _name);
			return map;
		}

	}  

	public Editor setEvents(java.util.Collection<Editor_Events> values) {
			this._events.clear();
			values.stream().map(Editor_Events::asMap).forEach(map -> _events.add(map));
			return this;
		}

	public Editor addEvents(Object _predicate, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("predicate", _predicate);
		map.put("type", _type);
		this._events.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEvents() {
		return this._events;
	}

	public Editor addEvents(Editor_Events value) {
		return addEvents(value._predicate, value._type);
	}

	public java.util.stream.Stream<Editor_Events> streamEvents() {
		return this._events.stream().map(Editor_Events::new);
	}

	public java.util.List<Object> getEvents_Predicate() {
		return streamEvents().map(Editor_Events::getPredicate).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getEvents_Type() {
		return streamEvents().map(Editor_Events::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class Editor_Events {

		Object _predicate;
		Object _type;

		public Editor_Events(Object _predicate, Object _type) {
			this._predicate = _predicate;
			this._type = _type;
		}

		private Editor_Events(java.util.Map<String, Object> map) {
			this._predicate = (Object) map.get("predicate");
			this._type = (Object) map.get("type");
		}

		public Object getPredicate() {
			return this._predicate;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("predicate", _predicate);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Editor that = (Editor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Editor(editors,events,modelType,name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import java.awt.*;\n" + 
				"\n" + 
				"public class ~name~ extends nextgen.swing.BaseEditor<~modelType~> {\n" + 
				"\n" + 
				"	private String uuid = java.util.UUID.randomUUID().toString();\n" + 
				"\n" + 
				"	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();\n" + 
				"	~editors:{it|private final ~it.type~ ~it.name~ = new ~it.type~();};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~() {\n" + 
				"		super();\n" + 
				"		~if(events)~org.greenrobot.eventbus.EventBus.getDefault().register(this);~endif~\n" + 
				"	}\n" + 
				"	\n" + 
				"	public ~name~(~modelType~ model) {\n" + 
				"		super(model);\n" + 
				"		setModel(model);\n" + 
				"		~if(events)~org.greenrobot.eventbus.EventBus.getDefault().register(this);~endif~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void setModel(~modelType~ model) {\n" + 
				"		super.setModel(model);\n" + 
				"\n" + 
				"		this.uuid = model.getUuid();\n" + 
				"\n" + 
				"		if (getComponentCount() == 0) {\n" + 
				"		   ~editors:{it|editors.add(\"~it.name;format=\"capitalize\"~\", ~it.name~);};separator=\"\\n\"~\n" + 
				"			add(editors, BorderLayout.CENTER);\n" + 
				"		   invalidate();\n" + 
				"		}\n" + 
				"\n" + 
				"		~editors:{it|~it.name~.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	protected void tryToSave() {\n" + 
				"		if (model == null) return;\n" + 
				"		appModel().doInTransaction(transaction -> ~editors:{it|~it.name~.onSave(model)};separator=\"\\n\"~);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		~name~ that = (~name~) o;\n" + 
				"		return uuid.equals(that.uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return java.util.Objects.hash(uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return uuid;\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getUuid() {\n" + 
				"		return uuid;\n" + 
				"	}\n" + 
				"~events:{it|\n" + 
				"	@org.greenrobot.eventbus.Subscribe()\n" + 
				"	public void on~it.type~(~it.type~ event) {\n" + 
				"		if (~it.predicate~) {\n" + 
				"			~editors:{it|~it.name~.setModel(~it.setModel~);};separator=\"\\n\"~\n" + 
				"		~eom()~\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  