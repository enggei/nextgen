package nextgen.templates.piccolo2d;

public class PNodeImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private String _name;
	private Object _nodeName;
	private Object _canvasName;
	private Object _initText;
	private Object _uuid;
	private Object _outgoingReferences;
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _rightClickStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _anonymousRightClickActions = new java.util.ArrayList<>();
	private java.util.List<Object> _onLeftClick = new java.util.ArrayList<>();
	private java.util.List<Object> _onPropertyChange = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onRightClick = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onKeyPressed = new java.util.ArrayList<>();

	PNodeImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PNodeImpl");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("nodeName", _nodeName);
		st.add("canvasName", _canvasName);
		st.add("initText", _initText);
		st.add("uuid", _uuid);
		st.add("outgoingReferences", _outgoingReferences);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _rightClickStatements) st.add("rightClickStatements", o);
		for (Object o : _anonymousRightClickActions) st.add("anonymousRightClickActions", o);
		for (Object o : _onLeftClick) st.add("onLeftClick", o);
		for (Object o : _onPropertyChange) st.add("onPropertyChange", o);
		for (Object o : _actions) st.add("actions", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _onRightClick) st.addAggr("onRightClick.{name}", map.get("name"));
		for (java.util.Map<String, Object> map : _onKeyPressed) st.addAggr("onKeyPressed.{key,name}", map.get("key"), map.get("name"));
		return st.render().trim();
	}

	public PNodeImpl setPackageName(Object value) {
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

	public PNodeImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public PNodeImpl setName(String value) {
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

	public PNodeImpl removeName() {
		this._name = null;
		return this;
	} 

	public PNodeImpl setNodeName(Object value) {
		this._nodeName = value;
		return this;
	}

	public Object getNodeName() {
		return this._nodeName;
	}

	public Object getNodeName(Object defaultValue) {
		return this._nodeName == null ? defaultValue : this._nodeName;
	}

	public boolean hasNodeName() {
		return this._nodeName != null;
	}

	public PNodeImpl removeNodeName() {
		this._nodeName = null;
		return this;
	} 

	public PNodeImpl setCanvasName(Object value) {
		this._canvasName = value;
		return this;
	}

	public Object getCanvasName() {
		return this._canvasName;
	}

	public Object getCanvasName(Object defaultValue) {
		return this._canvasName == null ? defaultValue : this._canvasName;
	}

	public boolean hasCanvasName() {
		return this._canvasName != null;
	}

	public PNodeImpl removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public PNodeImpl setInitText(Object value) {
		this._initText = value;
		return this;
	}

	public Object getInitText() {
		return this._initText;
	}

	public Object getInitText(Object defaultValue) {
		return this._initText == null ? defaultValue : this._initText;
	}

	public boolean hasInitText() {
		return this._initText != null;
	}

	public PNodeImpl removeInitText() {
		this._initText = null;
		return this;
	} 

	public PNodeImpl setUuid(Object value) {
		this._uuid = value;
		return this;
	}

	public Object getUuid() {
		return this._uuid;
	}

	public Object getUuid(Object defaultValue) {
		return this._uuid == null ? defaultValue : this._uuid;
	}

	public boolean hasUuid() {
		return this._uuid != null;
	}

	public PNodeImpl removeUuid() {
		this._uuid = null;
		return this;
	} 

	public PNodeImpl setOutgoingReferences(Object value) {
		this._outgoingReferences = value;
		return this;
	}

	public Object getOutgoingReferences() {
		return this._outgoingReferences;
	}

	public Object getOutgoingReferences(Object defaultValue) {
		return this._outgoingReferences == null ? defaultValue : this._outgoingReferences;
	}

	public boolean hasOutgoingReferences() {
		return this._outgoingReferences != null;
	}

	public PNodeImpl removeOutgoingReferences() {
		this._outgoingReferences = null;
		return this;
	} 

	public PNodeImpl addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public PNodeImpl setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNodeImpl setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public PNodeImpl removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public PNodeImpl removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public PNodeImpl addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public PNodeImpl setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNodeImpl setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public PNodeImpl removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public PNodeImpl removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public PNodeImpl addRightClickStatements(Object value) {
		this._rightClickStatements.add(value);
		return this;
	}

	public PNodeImpl setRightClickStatements(Object[] value) {
		this._rightClickStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNodeImpl setRightClickStatements(java.util.Collection<Object> values) {
		this._rightClickStatements.addAll(values);
		return this;
	}

	public PNodeImpl removeRightClickStatements(Object value) {
		this._rightClickStatements.remove(value);
		return this;
	}

	public PNodeImpl removeRightClickStatements(int index) {
		this._rightClickStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRightClickStatements() {
		return this._rightClickStatements;
	} 

	public PNodeImpl addAnonymousRightClickActions(Object value) {
		this._anonymousRightClickActions.add(value);
		return this;
	}

	public PNodeImpl setAnonymousRightClickActions(Object[] value) {
		this._anonymousRightClickActions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNodeImpl setAnonymousRightClickActions(java.util.Collection<Object> values) {
		this._anonymousRightClickActions.addAll(values);
		return this;
	}

	public PNodeImpl removeAnonymousRightClickActions(Object value) {
		this._anonymousRightClickActions.remove(value);
		return this;
	}

	public PNodeImpl removeAnonymousRightClickActions(int index) {
		this._anonymousRightClickActions.remove(index);
		return this;
	}

	public java.util.List<Object> getAnonymousRightClickActions() {
		return this._anonymousRightClickActions;
	} 

	public PNodeImpl addOnLeftClick(Object value) {
		this._onLeftClick.add(value);
		return this;
	}

	public PNodeImpl setOnLeftClick(Object[] value) {
		this._onLeftClick.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNodeImpl setOnLeftClick(java.util.Collection<Object> values) {
		this._onLeftClick.addAll(values);
		return this;
	}

	public PNodeImpl removeOnLeftClick(Object value) {
		this._onLeftClick.remove(value);
		return this;
	}

	public PNodeImpl removeOnLeftClick(int index) {
		this._onLeftClick.remove(index);
		return this;
	}

	public java.util.List<Object> getOnLeftClick() {
		return this._onLeftClick;
	} 

	public PNodeImpl addOnPropertyChange(Object value) {
		this._onPropertyChange.add(value);
		return this;
	}

	public PNodeImpl setOnPropertyChange(Object[] value) {
		this._onPropertyChange.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNodeImpl setOnPropertyChange(java.util.Collection<Object> values) {
		this._onPropertyChange.addAll(values);
		return this;
	}

	public PNodeImpl removeOnPropertyChange(Object value) {
		this._onPropertyChange.remove(value);
		return this;
	}

	public PNodeImpl removeOnPropertyChange(int index) {
		this._onPropertyChange.remove(index);
		return this;
	}

	public java.util.List<Object> getOnPropertyChange() {
		return this._onPropertyChange;
	} 

	public PNodeImpl addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public PNodeImpl setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PNodeImpl setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public PNodeImpl removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public PNodeImpl removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public PNodeImpl addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public PNodeImpl addFields(PNodeImpl_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<PNodeImpl_Fields> streamFields() {
		return this._fields.stream().map(PNodeImpl_Fields::new);
	}

	public static final class PNodeImpl_Fields {

		Object _type;
		Object _name;

		public PNodeImpl_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private PNodeImpl_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	} 

	public PNodeImpl addOnRightClick(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._onRightClick.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnRightClick() {
		return this._onRightClick;
	}

	public PNodeImpl addOnRightClick(PNodeImpl_OnRightClick value) {
		return addOnRightClick(value._name);
	}

	public java.util.stream.Stream<PNodeImpl_OnRightClick> streamOnRightClick() {
		return this._onRightClick.stream().map(PNodeImpl_OnRightClick::new);
	}

	public static final class PNodeImpl_OnRightClick {

		Object _name;

		public PNodeImpl_OnRightClick(Object _name) {
			this._name = _name;
		}

		private PNodeImpl_OnRightClick(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	public PNodeImpl addOnKeyPressed(Object _key, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("name", _name);
		this._onKeyPressed.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnKeyPressed() {
		return this._onKeyPressed;
	}

	public PNodeImpl addOnKeyPressed(PNodeImpl_OnKeyPressed value) {
		return addOnKeyPressed(value._key, value._name);
	}

	public java.util.stream.Stream<PNodeImpl_OnKeyPressed> streamOnKeyPressed() {
		return this._onKeyPressed.stream().map(PNodeImpl_OnKeyPressed::new);
	}

	public static final class PNodeImpl_OnKeyPressed {

		Object _key;
		Object _name;

		public PNodeImpl_OnKeyPressed(Object _key, Object _name) {
			this._key = _key;
			this._name = _name;
		}

		private PNodeImpl_OnKeyPressed(java.util.Map<String, Object> map) {
			this._key = (Object) map.get("key");
			this._name = (Object) map.get("name");
		}

		public Object getKey() {
			return this._key;
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PNodeImpl that = (PNodeImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PNodeImpl(packageName,name,nodeName,fields,canvasName,initText,uuid,constructorStatements,methods,outgoingReferences,rightClickStatements,anonymousRightClickActions,onRightClick,onKeyPressed,onLeftClick,onPropertyChange,actions) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.piccolo2d.event.PInputEvent;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.util.*;\n" + 
				"import java.util.stream.Stream;\n" + 
				"\n" + 
				"public class ~name~ extends ~nodeName~ {\n" + 
				"\n" + 
				"	~fields:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"		\n" + 
				"	public ~name~(~canvasName~ canvas~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(canvas, ~initText~, ~uuid~);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public Stream<UUID> getOutgoingReferences() {\n" + 
				"		return ~if(outgoingReferences)~~outgoingReferences~~else~super.getOutgoingReferences();~endif~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~rightClickStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		~anonymousRightClickActions:{it|pop.add(~it~);};separator=\"\\n\"~\n" + 
				"		~onRightClick:{it|pop.add(new ~it.name~(this, canvas, event));};separator=\"\\n\"~\n" + 
				"		~if(onRightClick)~\n" + 
				"		pop.addSeparator();\n" + 
				"		~endif~\n" + 
				"		super.onNodeRightClick(event, pop);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeKeyPressed(PInputEvent event) {\n" + 
				"~if(onKeyPressed)~\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"			~onKeyPressed:{it|\n" + 
				"case java.awt.event.KeyEvent.VK_~it.key~:\n" + 
				"	new ~it.name~(this, canvas, event).actionPerformed(null);\n" + 
				"	return;\n" + 
				"};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"~endif~\n" + 
				"		super.onNodeKeyPressed(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeLeftClick(PInputEvent event) {\n" + 
				"		super.onNodeLeftClick(event);\n" + 
				"		~onLeftClick:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~if(onPropertyChange)~\n" + 
				"	@Override\n" + 
				"	public void propertyChange(java.beans.PropertyChangeEvent evt) {\n" + 
				"		~onPropertyChange:{it|~it~};separator=\"\\n\"~	\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  