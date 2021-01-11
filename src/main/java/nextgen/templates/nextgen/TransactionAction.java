package nextgen.templates.nextgen;

public class TransactionAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _icon;
	private Object _titleExpression;
	private String _name;
	private Object _title;
	private Object _packageName;
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _staticFields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	TransactionAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TransactionAction");
		st.add("icon", _icon);
		st.add("titleExpression", _titleExpression);
		st.add("name", _name);
		st.add("title", _title);
		st.add("packageName", _packageName);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _statements) st.add("statements", o);
		for (Object o : _imports) st.add("imports", o);
		for (java.util.Map<String, Object> map : _staticFields) st.addAggr("staticFields.{type,name,init}", map.get("type"), map.get("name"), map.get("init"));
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public TransactionAction setIcon(Object value) {
		this._icon = value;
		return this;
	}

	public Object getIcon() {
		return this._icon;
	}

	public Object getIcon(Object defaultValue) {
		return this._icon == null ? defaultValue : this._icon;
	}

	public boolean hasIcon() {
		return this._icon != null;
	}

	public TransactionAction removeIcon() {
		this._icon = null;
		return this;
	} 

	public TransactionAction setTitleExpression(Object value) {
		this._titleExpression = value;
		return this;
	}

	public Object getTitleExpression() {
		return this._titleExpression;
	}

	public Object getTitleExpression(Object defaultValue) {
		return this._titleExpression == null ? defaultValue : this._titleExpression;
	}

	public boolean hasTitleExpression() {
		return this._titleExpression != null;
	}

	public TransactionAction removeTitleExpression() {
		this._titleExpression = null;
		return this;
	} 

	public TransactionAction setName(String value) {
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

	public TransactionAction removeName() {
		this._name = null;
		return this;
	} 

	public TransactionAction setTitle(Object value) {
		this._title = value;
		return this;
	}

	public Object getTitle() {
		return this._title;
	}

	public Object getTitle(Object defaultValue) {
		return this._title == null ? defaultValue : this._title;
	}

	public boolean hasTitle() {
		return this._title != null;
	}

	public TransactionAction removeTitle() {
		this._title = null;
		return this;
	} 

	public TransactionAction setPackageName(Object value) {
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

	public TransactionAction removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TransactionAction addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public TransactionAction setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TransactionAction setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public TransactionAction removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public TransactionAction removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public TransactionAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public TransactionAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TransactionAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public TransactionAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public TransactionAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public TransactionAction addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public TransactionAction setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TransactionAction setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public TransactionAction removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public TransactionAction removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public TransactionAction setStaticFields(java.util.Collection<TransactionAction_StaticFields> values) {
			this._staticFields.clear();
			values.stream().map(TransactionAction_StaticFields::asMap).forEach(map -> _staticFields.add(map));
			return this;
		}

	public TransactionAction addStaticFields(Object _type, Object _name, Object _init) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		map.put("init", _init);
		this._staticFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getStaticFields() {
		return this._staticFields;
	}

	public TransactionAction addStaticFields(TransactionAction_StaticFields value) {
		return addStaticFields(value._type, value._name, value._init);
	}

	public java.util.stream.Stream<TransactionAction_StaticFields> streamStaticFields() {
		return this._staticFields.stream().map(TransactionAction_StaticFields::new);
	}

	public java.util.List<Object> getStaticFields_Type() {
		return streamStaticFields().map(TransactionAction_StaticFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getStaticFields_Name() {
		return streamStaticFields().map(TransactionAction_StaticFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getStaticFields_Init() {
		return streamStaticFields().map(TransactionAction_StaticFields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public static final class TransactionAction_StaticFields {

		Object _type;
		Object _name;
		Object _init;

		public TransactionAction_StaticFields(Object _type, Object _name, Object _init) {
			this._type = _type;
			this._name = _name;
			this._init = _init;
		}

		private TransactionAction_StaticFields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._init = (Object) map.get("init");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getInit() {
			return this._init;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("type", _type);
			map.put("name", _name);
			map.put("init", _init);
			return map;
		}

	}  

	public TransactionAction setFields(java.util.Collection<TransactionAction_Fields> values) {
			this._fields.clear();
			values.stream().map(TransactionAction_Fields::asMap).forEach(map -> _fields.add(map));
			return this;
		}

	public TransactionAction addFields(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public TransactionAction addFields(TransactionAction_Fields value) {
		return addFields(value._name, value._type);
	}

	public java.util.stream.Stream<TransactionAction_Fields> streamFields() {
		return this._fields.stream().map(TransactionAction_Fields::new);
	}

	public java.util.List<Object> getFields_Name() {
		return streamFields().map(TransactionAction_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(TransactionAction_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class TransactionAction_Fields {

		Object _name;
		Object _type;

		public TransactionAction_Fields(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private TransactionAction_Fields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TransactionAction that = (TransactionAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TransactionAction(icon,methods,statements,titleExpression,name,title,staticFields,fields,packageName,imports) ::= <<package ~if(packageName)~~packageName~~else~nextgen.actions~endif~;\n" + 
				"\n" + 
				"~if(imports)~\n" + 
				"~imports:{it|import ~it~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"~endif~\n" + 
				"import static nextgen.utils.SwingUtil.*;\n" + 
				"import static nextgen.swing.ComponentFactory.*;\n" + 
				"import nextgen.model.*;\n" + 
				"import javax.swing.*;\n" + 
				"import org.neo4j.graphdb.Transaction;\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"import java.util.stream.Collectors;\n" + 
				"\n" + 
				"public class ~name~ extends nextgen.actions.TransactionAction {\n" + 
				"~if(staticFields)~\n" + 
				"   \n" + 
				"   ~staticFields:{it|private static final ~it.type~ ~it.name~ = ~it.init~;};separator=\"\\n\"~\n" + 
				"~endif~\n" + 
				"\n" + 
				"\n" + 
				"   ~fields:{it|private final ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"~if(title)~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(\"~title~\");\n" + 
				"		~if(icon)~setIcon(\"~icon~\");~endif~\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~elseif(titleExpression)~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(~titleExpression~);\n" + 
				"		~if(icon)~setIcon(\"~icon~\");~endif~\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~elseif(icon)~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(\"\");\n" + 
				"		setIcon(\"~icon~\");\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~else~\n" + 
				"\n" + 
				"	public ~name~(String name~if(fields)~, ~endif~~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"      super(name);\n" + 
				"      ~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"   }\n" + 
				"\n" + 
				"~endif~\n" + 
				"   @Override\n" + 
				"   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {\n" + 
				"   	log.info(\"~name~\"~fields:{it|  + \" ~it.name~\"}~);\n" + 
				"   	\n" + 
				"      ~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"   }\n" + 
				"\n" + 
				"   ~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  