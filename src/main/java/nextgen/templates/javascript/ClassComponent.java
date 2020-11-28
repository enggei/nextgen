package nextgen.templates.javascript;

public class ClassComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _renderCondition;
	private Object _renderTrue;
	private Object _renderFalse;
	private Object _renderElement;
	private java.util.List<Object> _componentImports = new java.util.ArrayList<>();
	private java.util.List<Object> _dependencies = new java.util.ArrayList<>();
	private java.util.List<Object> _constDeclarations = new java.util.ArrayList<>();
	private java.util.List<Object> _decorators = new java.util.ArrayList<>();
	private java.util.List<Object> _state = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _events = new java.util.ArrayList<>();

	ClassComponent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassComponent");
		st.add("name", _name);
		st.add("renderCondition", _renderCondition);
		st.add("renderTrue", _renderTrue);
		st.add("renderFalse", _renderFalse);
		st.add("renderElement", _renderElement);
		for (Object o : _componentImports) st.add("componentImports", o);
		for (Object o : _dependencies) st.add("dependencies", o);
		for (Object o : _constDeclarations) st.add("constDeclarations", o);
		for (Object o : _decorators) st.add("decorators", o);
		for (Object o : _state) st.add("state", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _imports) st.addAggr("imports.{ref,path}", map.get("ref"), map.get("path"));
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name}", map.get("name"));
		for (java.util.Map<String, Object> map : _events) st.addAggr("events.{methodName,declaration}", map.get("methodName"), map.get("declaration"));
		return st.render().trim();
	}

	public ClassComponent setName(String value) {
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

	public ClassComponent removeName() {
		this._name = null;
		return this;
	} 

	public ClassComponent setRenderCondition(Object value) {
		this._renderCondition = value;
		return this;
	}

	public Object getRenderCondition() {
		return this._renderCondition;
	}

	public Object getRenderCondition(Object defaultValue) {
		return this._renderCondition == null ? defaultValue : this._renderCondition;
	}

	public boolean hasRenderCondition() {
		return this._renderCondition != null;
	}

	public ClassComponent removeRenderCondition() {
		this._renderCondition = null;
		return this;
	} 

	public ClassComponent setRenderTrue(Object value) {
		this._renderTrue = value;
		return this;
	}

	public Object getRenderTrue() {
		return this._renderTrue;
	}

	public Object getRenderTrue(Object defaultValue) {
		return this._renderTrue == null ? defaultValue : this._renderTrue;
	}

	public boolean hasRenderTrue() {
		return this._renderTrue != null;
	}

	public ClassComponent removeRenderTrue() {
		this._renderTrue = null;
		return this;
	} 

	public ClassComponent setRenderFalse(Object value) {
		this._renderFalse = value;
		return this;
	}

	public Object getRenderFalse() {
		return this._renderFalse;
	}

	public Object getRenderFalse(Object defaultValue) {
		return this._renderFalse == null ? defaultValue : this._renderFalse;
	}

	public boolean hasRenderFalse() {
		return this._renderFalse != null;
	}

	public ClassComponent removeRenderFalse() {
		this._renderFalse = null;
		return this;
	} 

	public ClassComponent setRenderElement(Object value) {
		this._renderElement = value;
		return this;
	}

	public Object getRenderElement() {
		return this._renderElement;
	}

	public Object getRenderElement(Object defaultValue) {
		return this._renderElement == null ? defaultValue : this._renderElement;
	}

	public boolean hasRenderElement() {
		return this._renderElement != null;
	}

	public ClassComponent removeRenderElement() {
		this._renderElement = null;
		return this;
	} 

	public ClassComponent addComponentImports(Object value) {
		this._componentImports.add(value);
		return this;
	}

	public ClassComponent setComponentImports(Object[] value) {
		this._componentImports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setComponentImports(java.util.Collection<Object> values) {
		this._componentImports.addAll(values);
		return this;
	}

	public ClassComponent removeComponentImports(Object value) {
		this._componentImports.remove(value);
		return this;
	}

	public ClassComponent removeComponentImports(int index) {
		this._componentImports.remove(index);
		return this;
	}

	public java.util.List<Object> getComponentImports() {
		return this._componentImports;
	} 

	public ClassComponent addDependencies(Object value) {
		this._dependencies.add(value);
		return this;
	}

	public ClassComponent setDependencies(Object[] value) {
		this._dependencies.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setDependencies(java.util.Collection<Object> values) {
		this._dependencies.addAll(values);
		return this;
	}

	public ClassComponent removeDependencies(Object value) {
		this._dependencies.remove(value);
		return this;
	}

	public ClassComponent removeDependencies(int index) {
		this._dependencies.remove(index);
		return this;
	}

	public java.util.List<Object> getDependencies() {
		return this._dependencies;
	} 

	public ClassComponent addConstDeclarations(Object value) {
		this._constDeclarations.add(value);
		return this;
	}

	public ClassComponent setConstDeclarations(Object[] value) {
		this._constDeclarations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setConstDeclarations(java.util.Collection<Object> values) {
		this._constDeclarations.addAll(values);
		return this;
	}

	public ClassComponent removeConstDeclarations(Object value) {
		this._constDeclarations.remove(value);
		return this;
	}

	public ClassComponent removeConstDeclarations(int index) {
		this._constDeclarations.remove(index);
		return this;
	}

	public java.util.List<Object> getConstDeclarations() {
		return this._constDeclarations;
	} 

	public ClassComponent addDecorators(Object value) {
		this._decorators.add(value);
		return this;
	}

	public ClassComponent setDecorators(Object[] value) {
		this._decorators.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setDecorators(java.util.Collection<Object> values) {
		this._decorators.addAll(values);
		return this;
	}

	public ClassComponent removeDecorators(Object value) {
		this._decorators.remove(value);
		return this;
	}

	public ClassComponent removeDecorators(int index) {
		this._decorators.remove(index);
		return this;
	}

	public java.util.List<Object> getDecorators() {
		return this._decorators;
	} 

	public ClassComponent addState(Object value) {
		this._state.add(value);
		return this;
	}

	public ClassComponent setState(Object[] value) {
		this._state.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setState(java.util.Collection<Object> values) {
		this._state.addAll(values);
		return this;
	}

	public ClassComponent removeState(Object value) {
		this._state.remove(value);
		return this;
	}

	public ClassComponent removeState(int index) {
		this._state.remove(index);
		return this;
	}

	public java.util.List<Object> getState() {
		return this._state;
	} 

	public ClassComponent addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public ClassComponent setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public ClassComponent removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public ClassComponent removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public ClassComponent addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public ClassComponent setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public ClassComponent removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public ClassComponent removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public ClassComponent addImports(Object _ref, Object _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("ref", _ref);
		map.put("path", _path);
		this._imports.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getImports() {
		return this._imports;
	}

	public ClassComponent addImports(ClassComponent_Imports value) {
		return addImports(value._ref, value._path);
	}

	public java.util.stream.Stream<ClassComponent_Imports> streamImports() {
		return this._imports.stream().map(ClassComponent_Imports::new);
	}

	public java.util.List<Object> getImports_Ref() {
		return streamImports().map(ClassComponent_Imports::getRef).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getImports_Path() {
		return streamImports().map(ClassComponent_Imports::getPath).collect(java.util.stream.Collectors.toList());
	}


	public static final class ClassComponent_Imports {

		Object _ref;
		Object _path;

		public ClassComponent_Imports(Object _ref, Object _path) {
			this._ref = _ref;
			this._path = _path;
		}

		private ClassComponent_Imports(java.util.Map<String, Object> map) {
			this._ref = (Object) map.get("ref");
			this._path = (Object) map.get("path");
		}

		public Object getRef() {
			return this._ref;
		}

		public Object getPath() {
			return this._path;
		}

	}  

	public ClassComponent addFields(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public ClassComponent addFields(ClassComponent_Fields value) {
		return addFields(value._name);
	}

	public java.util.stream.Stream<ClassComponent_Fields> streamFields() {
		return this._fields.stream().map(ClassComponent_Fields::new);
	}

	public java.util.List<Object> getFields_Name() {
		return streamFields().map(ClassComponent_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class ClassComponent_Fields {

		Object _name;

		public ClassComponent_Fields(Object _name) {
			this._name = _name;
		}

		private ClassComponent_Fields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	}  

	public ClassComponent addEvents(Object _methodName, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("methodName", _methodName);
		map.put("declaration", _declaration);
		this._events.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEvents() {
		return this._events;
	}

	public ClassComponent addEvents(ClassComponent_Events value) {
		return addEvents(value._methodName, value._declaration);
	}

	public java.util.stream.Stream<ClassComponent_Events> streamEvents() {
		return this._events.stream().map(ClassComponent_Events::new);
	}

	public java.util.List<Object> getEvents_MethodName() {
		return streamEvents().map(ClassComponent_Events::getMethodName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getEvents_Declaration() {
		return streamEvents().map(ClassComponent_Events::getDeclaration).collect(java.util.stream.Collectors.toList());
	}


	public static final class ClassComponent_Events {

		Object _methodName;
		Object _declaration;

		public ClassComponent_Events(Object _methodName, Object _declaration) {
			this._methodName = _methodName;
			this._declaration = _declaration;
		}

		private ClassComponent_Events(java.util.Map<String, Object> map) {
			this._methodName = (Object) map.get("methodName");
			this._declaration = (Object) map.get("declaration");
		}

		public Object getMethodName() {
			return this._methodName;
		}

		public Object getDeclaration() {
			return this._declaration;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClassComponent that = (ClassComponent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ClassComponent(imports,componentImports,dependencies,constDeclarations,decorators,name,fields,state,constructorStatements,events,methods,renderCondition,renderTrue,renderFalse,renderElement) ::= <<import React from 'react';\n" + 
				"~imports:{it|import ~it.ref~ from '~it.path~';};separator=\"\\n\"~\n" + 
				"~componentImports:{it|~it~};separator=\"\\n\"~\n" + 
				"~dependencies:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~constDeclarations:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"~decorators:{it|~it~};separator=\"\\n\"~\n" + 
				"class ~name~ extends React.Component {\n" + 
				"\n" + 
				"	~fields:{it|~it.name~};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	constructor(props) {\n" + 
				"		super(props);\n" + 
				"		console.log(\"new ~name~ : \" +  this.props);\n" + 
				"~if(state)~\n" + 
				"		this.state = {\n" + 
				"			~state:{it|~it~};separator=\",\\n\"~;\n" + 
				"		}\n" + 
				"~endif~\n" + 
				"\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		~events:{it|this.~it.methodName~ = this.~it.methodName~.bind(this);};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~if(events)~\n" + 
				"	~events:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"~endif~\n" + 
				"~if(methods)~\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"~endif~\n" + 
				"\n" + 
				"	static getDerivedStateFromError(error) {\n" + 
				"		// Update state so the next render will show the fallback UI.\n" + 
				"		return { hasError: true };\n" + 
				"	}\n" + 
				"\n" + 
				"	componentDidCatch(error, errorInfo) {\n" + 
				"		// You can also log the error to an error reporting service\n" + 
				"		console.info(error);\n" + 
				"		console.info(errorInfo);\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"		console.log(\"render ~name~ : \" +  this.props);\n" + 
				"~if(renderCondition)~\n" + 
				"		if(~renderCondition~) {\n" + 
				"			console.info(\"~name~.~renderCondition~ TRUE\");\n" + 
				"			return ( \n" + 
				"				~renderTrue~\n" + 
				"			);\n" + 
				"		} else {\n" + 
				"			console.info(\"~name~.~renderCondition~ FALSE\");\n" + 
				"			return (\n" + 
				"				~renderFalse~\n" + 
				"			);\n" + 
				"		}\n" + 
				"~else~\n" + 
				"		return (\n" + 
				"			~if(renderElement)~~renderElement~~else~null~endif~\n" + 
				"		);\n" + 
				"~endif~\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (~name~); >>";
}  