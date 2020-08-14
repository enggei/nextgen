package nextgen.templates.javascript;

public class ClassComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<Object> _dependencies = new java.util.ArrayList<>();
	private java.util.List<Object> _components = new java.util.ArrayList<>();
	private java.util.List<Object> _decorators = new java.util.ArrayList<>();
	private java.util.List<Object> _state = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _renderConstants = new java.util.ArrayList<>();
	private java.util.List<Object> _returnStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _events = new java.util.ArrayList<>();

	ClassComponent(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassComponent");
		st.add("name", _name);
		for (Object o : _dependencies) st.add("dependencies", o);
		for (Object o : _components) st.add("components", o);
		for (Object o : _decorators) st.add("decorators", o);
		for (Object o : _state) st.add("state", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _renderConstants) st.add("renderConstants", o);
		for (Object o : _returnStatements) st.add("returnStatements", o);
		for (java.util.Map<String, Object> map : _imports) st.addAggr("imports.{ref,path}", map.get("ref"), map.get("path"));
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

	public ClassComponent addComponents(Object value) {
		this._components.add(value);
		return this;
	}

	public ClassComponent setComponents(Object[] value) {
		this._components.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setComponents(java.util.Collection<Object> values) {
		this._components.addAll(values);
		return this;
	}

	public ClassComponent removeComponents(Object value) {
		this._components.remove(value);
		return this;
	}

	public ClassComponent removeComponents(int index) {
		this._components.remove(index);
		return this;
	}

	public java.util.List<Object> getComponents() {
		return this._components;
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

	public ClassComponent addRenderConstants(Object value) {
		this._renderConstants.add(value);
		return this;
	}

	public ClassComponent setRenderConstants(Object[] value) {
		this._renderConstants.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setRenderConstants(java.util.Collection<Object> values) {
		this._renderConstants.addAll(values);
		return this;
	}

	public ClassComponent removeRenderConstants(Object value) {
		this._renderConstants.remove(value);
		return this;
	}

	public ClassComponent removeRenderConstants(int index) {
		this._renderConstants.remove(index);
		return this;
	}

	public java.util.List<Object> getRenderConstants() {
		return this._renderConstants;
	} 

	public ClassComponent addReturnStatements(Object value) {
		this._returnStatements.add(value);
		return this;
	}

	public ClassComponent setReturnStatements(Object[] value) {
		this._returnStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassComponent setReturnStatements(java.util.Collection<Object> values) {
		this._returnStatements.addAll(values);
		return this;
	}

	public ClassComponent removeReturnStatements(Object value) {
		this._returnStatements.remove(value);
		return this;
	}

	public ClassComponent removeReturnStatements(int index) {
		this._returnStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getReturnStatements() {
		return this._returnStatements;
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

	static final String st = "ClassComponent(imports,dependencies,components,decorators,name,state,constructorStatements,events,methods,renderConstants,returnStatements) ::= <<import React from 'react';\n" + 
				"~imports:{it|import ~it.ref~ from '~it.path~';};separator=\"\\n\"~\n" + 
				"~dependencies:{it|~it~};separator=\"\\n\"~\n" + 
				"~components:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"~decorators:{it|~it~};separator=\"\\n\"~\n" + 
				"class ~name~ extends React.Component {\n" + 
				"\n" + 
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
				"	\n" + 
				"~endif~\n" + 
				"~if(methods)~\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"~endif~\n" + 
				"\n" + 
				"	render() {\n" + 
				"		console.log(\"render ~name~ : \" +  this.props);\n" + 
				"		~if(renderConstants)~const { ~renderConstants:{it|~it~};separator=\", \"~ } = this.state;~endif~\n" + 
				"		\n" + 
				"		~if(returnStatements)~return (~returnStatements:{it|~it~};separator=\"\\n\\n\"~)~else~return null;~endif~\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (~name~); >>";
}  