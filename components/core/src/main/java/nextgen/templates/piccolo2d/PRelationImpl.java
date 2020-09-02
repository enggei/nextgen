package nextgen.templates.piccolo2d;

public class PRelationImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private Object _relationName;
	private Object _canvasName;
	private Object _srcNode;
	private Object _dstNode;
	private Object _nameExpression;
	private Object _uuidExpression;
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onRightClick = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _onKeyPressed = new java.util.ArrayList<>();

	PRelationImpl(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PRelationImpl");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("relationName", _relationName);
		st.add("canvasName", _canvasName);
		st.add("srcNode", _srcNode);
		st.add("dstNode", _dstNode);
		st.add("nameExpression", _nameExpression);
		st.add("uuidExpression", _uuidExpression);
		for (Object o : _actions) st.add("actions", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _onRightClick) st.addAggr("onRightClick.{isSeparator,name}", map.get("isSeparator"), map.get("name"));
		for (java.util.Map<String, Object> map : _onKeyPressed) st.addAggr("onKeyPressed.{key,name}", map.get("key"), map.get("name"));
		return st.render().trim();
	}

	public PRelationImpl setPackageName(String value) {
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

	public PRelationImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public PRelationImpl setName(String value) {
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

	public PRelationImpl removeName() {
		this._name = null;
		return this;
	} 

	public PRelationImpl setRelationName(Object value) {
		this._relationName = value;
		return this;
	}

	public Object getRelationName() {
		return this._relationName;
	}

	public Object getRelationName(Object defaultValue) {
		return this._relationName == null ? defaultValue : this._relationName;
	}

	public boolean hasRelationName() {
		return this._relationName != null;
	}

	public PRelationImpl removeRelationName() {
		this._relationName = null;
		return this;
	} 

	public PRelationImpl setCanvasName(Object value) {
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

	public PRelationImpl removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public PRelationImpl setSrcNode(Object value) {
		this._srcNode = value;
		return this;
	}

	public Object getSrcNode() {
		return this._srcNode;
	}

	public Object getSrcNode(Object defaultValue) {
		return this._srcNode == null ? defaultValue : this._srcNode;
	}

	public boolean hasSrcNode() {
		return this._srcNode != null;
	}

	public PRelationImpl removeSrcNode() {
		this._srcNode = null;
		return this;
	} 

	public PRelationImpl setDstNode(Object value) {
		this._dstNode = value;
		return this;
	}

	public Object getDstNode() {
		return this._dstNode;
	}

	public Object getDstNode(Object defaultValue) {
		return this._dstNode == null ? defaultValue : this._dstNode;
	}

	public boolean hasDstNode() {
		return this._dstNode != null;
	}

	public PRelationImpl removeDstNode() {
		this._dstNode = null;
		return this;
	} 

	public PRelationImpl setNameExpression(Object value) {
		this._nameExpression = value;
		return this;
	}

	public Object getNameExpression() {
		return this._nameExpression;
	}

	public Object getNameExpression(Object defaultValue) {
		return this._nameExpression == null ? defaultValue : this._nameExpression;
	}

	public boolean hasNameExpression() {
		return this._nameExpression != null;
	}

	public PRelationImpl removeNameExpression() {
		this._nameExpression = null;
		return this;
	} 

	public PRelationImpl setUuidExpression(Object value) {
		this._uuidExpression = value;
		return this;
	}

	public Object getUuidExpression() {
		return this._uuidExpression;
	}

	public Object getUuidExpression(Object defaultValue) {
		return this._uuidExpression == null ? defaultValue : this._uuidExpression;
	}

	public boolean hasUuidExpression() {
		return this._uuidExpression != null;
	}

	public PRelationImpl removeUuidExpression() {
		this._uuidExpression = null;
		return this;
	} 

	public PRelationImpl addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public PRelationImpl setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PRelationImpl setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public PRelationImpl removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public PRelationImpl removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public PRelationImpl addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public PRelationImpl addFields(PRelationImpl_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<PRelationImpl_Fields> streamFields() {
		return this._fields.stream().map(PRelationImpl_Fields::new);
	}

	public static final class PRelationImpl_Fields {

		Object _type;
		Object _name;

		public PRelationImpl_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private PRelationImpl_Fields(java.util.Map<String, Object> map) {
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

	public PRelationImpl addOnRightClick(Object _isSeparator, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("isSeparator", _isSeparator);
		map.put("name", _name);
		this._onRightClick.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnRightClick() {
		return this._onRightClick;
	}

	public PRelationImpl addOnRightClick(PRelationImpl_OnRightClick value) {
		return addOnRightClick(value._isSeparator, value._name);
	}

	public java.util.stream.Stream<PRelationImpl_OnRightClick> streamOnRightClick() {
		return this._onRightClick.stream().map(PRelationImpl_OnRightClick::new);
	}

	public static final class PRelationImpl_OnRightClick {

		Object _isSeparator;
		Object _name;

		public PRelationImpl_OnRightClick(Object _isSeparator, Object _name) {
			this._isSeparator = _isSeparator;
			this._name = _name;
		}

		private PRelationImpl_OnRightClick(java.util.Map<String, Object> map) {
			this._isSeparator = (Object) map.get("isSeparator");
			this._name = (Object) map.get("name");
		}

		public Object getIsSeparator() {
			return this._isSeparator;
		}

		public Object getName() {
			return this._name;
		}

	} 

	public PRelationImpl addOnKeyPressed(Object _key, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("name", _name);
		this._onKeyPressed.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getOnKeyPressed() {
		return this._onKeyPressed;
	}

	public PRelationImpl addOnKeyPressed(PRelationImpl_OnKeyPressed value) {
		return addOnKeyPressed(value._key, value._name);
	}

	public java.util.stream.Stream<PRelationImpl_OnKeyPressed> streamOnKeyPressed() {
		return this._onKeyPressed.stream().map(PRelationImpl_OnKeyPressed::new);
	}

	public static final class PRelationImpl_OnKeyPressed {

		Object _key;
		Object _name;

		public PRelationImpl_OnKeyPressed(Object _key, Object _name) {
			this._key = _key;
			this._name = _name;
		}

		private PRelationImpl_OnKeyPressed(java.util.Map<String, Object> map) {
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
		PRelationImpl that = (PRelationImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PRelationImpl(packageName,name,relationName,fields,canvasName,srcNode,dstNode,nameExpression,uuidExpression,onRightClick,onKeyPressed,actions) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import org.piccolo2d.event.PInputEvent;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.util.*;\n" + 
				"\n" + 
				"public class ~name~ extends ~relationName~ {\n" + 
				"\n" + 
				"	~fields:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(~canvasName~ canvas, ~srcNode~ src, ~dstNode~ dst~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(canvas, src, dst, ~if(nameExpression)~~nameExpression~~else~\"~name;format=\"lowFirst\"~\"~endif~, ~uuidExpression~);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~onRightClick:{it|~if(it.isSeparator)~pop.addSeparator()~else~pop.add(new ~it.name~(this, canvas, event))~endif~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onRelationKeyPressed(PInputEvent event) {\n" + 
				"~if(onKeyPressed)~\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"			~onKeyPressed:{it|\n" + 
				"case java.awt.event.KeyEvent.VK_~it.key~:\n" + 
				"	new ~it.name~(this, canvas, event).actionPerformed(null);\n" + 
				"	break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"~endif~\n" + 
				"		super.onRelationKeyPressed(event);\n" + 
				"	}\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  