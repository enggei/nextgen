package nextgen.templates.javascript;

public class StoreComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _dependencies = new java.util.ArrayList<>();
	private java.util.List<Object> _components = new java.util.ArrayList<>();
	private java.util.List<Object> _decorators = new java.util.ArrayList<>();
	private java.util.List<Object> _stores = new java.util.ArrayList<>();
	private java.util.List<Object> _state = new java.util.ArrayList<>();
	private java.util.List<Object> _componentDidMountStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _renderStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _renderConstants = new java.util.ArrayList<>();
	private java.util.List<Object> _returnStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _events = new java.util.ArrayList<>();

	StoreComponent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StoreComponent");
		st.add("name", _name);
		for (Object o : _dependencies) st.add("dependencies", o);
		for (Object o : _components) st.add("components", o);
		for (Object o : _decorators) st.add("decorators", o);
		for (Object o : _stores) st.add("stores", o);
		for (Object o : _state) st.add("state", o);
		for (Object o : _componentDidMountStatements) st.add("componentDidMountStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _renderStatements) st.add("renderStatements", o);
		for (Object o : _renderConstants) st.add("renderConstants", o);
		for (Object o : _returnStatements) st.add("returnStatements", o);
		for (java.util.Map<String, Object> map : _events) st.addAggr("events.{methodName,declaration}", map.get("methodName"), map.get("declaration"));
		return st.render().trim();
	}

	public StoreComponent setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public StoreComponent removeName() {
		this._name = null;
		return this;
	} 

	public StoreComponent addDependencies(Object value) {
		this._dependencies.add(value);
		return this;
	}

	public StoreComponent setDependencies(Object[] value) {
		this._dependencies.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setDependencies(java.util.Collection<Object> values) {
		this._dependencies.addAll(values);
		return this;
	}

	public StoreComponent removeDependencies(Object value) {
		this._dependencies.remove(value);
		return this;
	}

	public StoreComponent removeDependencies(int index) {
		this._dependencies.remove(index);
		return this;
	}

	public java.util.List<Object> getDependencies() {
		return this._dependencies;
	} 

	public StoreComponent addComponents(Object value) {
		this._components.add(value);
		return this;
	}

	public StoreComponent setComponents(Object[] value) {
		this._components.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setComponents(java.util.Collection<Object> values) {
		this._components.addAll(values);
		return this;
	}

	public StoreComponent removeComponents(Object value) {
		this._components.remove(value);
		return this;
	}

	public StoreComponent removeComponents(int index) {
		this._components.remove(index);
		return this;
	}

	public java.util.List<Object> getComponents() {
		return this._components;
	} 

	public StoreComponent addDecorators(Object value) {
		this._decorators.add(value);
		return this;
	}

	public StoreComponent setDecorators(Object[] value) {
		this._decorators.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setDecorators(java.util.Collection<Object> values) {
		this._decorators.addAll(values);
		return this;
	}

	public StoreComponent removeDecorators(Object value) {
		this._decorators.remove(value);
		return this;
	}

	public StoreComponent removeDecorators(int index) {
		this._decorators.remove(index);
		return this;
	}

	public java.util.List<Object> getDecorators() {
		return this._decorators;
	} 

	public StoreComponent addStores(Object value) {
		this._stores.add(value);
		return this;
	}

	public StoreComponent setStores(Object[] value) {
		this._stores.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setStores(java.util.Collection<Object> values) {
		this._stores.addAll(values);
		return this;
	}

	public StoreComponent removeStores(Object value) {
		this._stores.remove(value);
		return this;
	}

	public StoreComponent removeStores(int index) {
		this._stores.remove(index);
		return this;
	}

	public java.util.List<Object> getStores() {
		return this._stores;
	} 

	public StoreComponent addState(Object value) {
		this._state.add(value);
		return this;
	}

	public StoreComponent setState(Object[] value) {
		this._state.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setState(java.util.Collection<Object> values) {
		this._state.addAll(values);
		return this;
	}

	public StoreComponent removeState(Object value) {
		this._state.remove(value);
		return this;
	}

	public StoreComponent removeState(int index) {
		this._state.remove(index);
		return this;
	}

	public java.util.List<Object> getState() {
		return this._state;
	} 

	public StoreComponent addComponentDidMountStatements(Object value) {
		this._componentDidMountStatements.add(value);
		return this;
	}

	public StoreComponent setComponentDidMountStatements(Object[] value) {
		this._componentDidMountStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setComponentDidMountStatements(java.util.Collection<Object> values) {
		this._componentDidMountStatements.addAll(values);
		return this;
	}

	public StoreComponent removeComponentDidMountStatements(Object value) {
		this._componentDidMountStatements.remove(value);
		return this;
	}

	public StoreComponent removeComponentDidMountStatements(int index) {
		this._componentDidMountStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getComponentDidMountStatements() {
		return this._componentDidMountStatements;
	} 

	public StoreComponent addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public StoreComponent setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public StoreComponent removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public StoreComponent removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public StoreComponent addRenderStatements(Object value) {
		this._renderStatements.add(value);
		return this;
	}

	public StoreComponent setRenderStatements(Object[] value) {
		this._renderStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setRenderStatements(java.util.Collection<Object> values) {
		this._renderStatements.addAll(values);
		return this;
	}

	public StoreComponent removeRenderStatements(Object value) {
		this._renderStatements.remove(value);
		return this;
	}

	public StoreComponent removeRenderStatements(int index) {
		this._renderStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRenderStatements() {
		return this._renderStatements;
	} 

	public StoreComponent addRenderConstants(Object value) {
		this._renderConstants.add(value);
		return this;
	}

	public StoreComponent setRenderConstants(Object[] value) {
		this._renderConstants.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setRenderConstants(java.util.Collection<Object> values) {
		this._renderConstants.addAll(values);
		return this;
	}

	public StoreComponent removeRenderConstants(Object value) {
		this._renderConstants.remove(value);
		return this;
	}

	public StoreComponent removeRenderConstants(int index) {
		this._renderConstants.remove(index);
		return this;
	}

	public java.util.List<Object> getRenderConstants() {
		return this._renderConstants;
	} 

	public StoreComponent addReturnStatements(Object value) {
		this._returnStatements.add(value);
		return this;
	}

	public StoreComponent setReturnStatements(Object[] value) {
		this._returnStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setReturnStatements(java.util.Collection<Object> values) {
		this._returnStatements.addAll(values);
		return this;
	}

	public StoreComponent removeReturnStatements(Object value) {
		this._returnStatements.remove(value);
		return this;
	}

	public StoreComponent removeReturnStatements(int index) {
		this._returnStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getReturnStatements() {
		return this._returnStatements;
	} 

	public StoreComponent addEvents(Object _methodName, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("methodName", _methodName);
		map.put("declaration", _declaration);
		this._events.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEvents() {
		return this._events;
	}

	public StoreComponent addEvents(StoreComponent_Events value) {
		return addEvents(value._methodName, value._declaration);
	}

	public java.util.stream.Stream<StoreComponent_Events> streamEvents() {
		return this._events.stream().map(StoreComponent_Events::new);
	}

	public static final class StoreComponent_Events {

		Object _methodName;
		Object _declaration;

		public StoreComponent_Events(Object _methodName, Object _declaration) {
			this._methodName = _methodName;
			this._declaration = _declaration;
		}

		private StoreComponent_Events(java.util.Map<String, Object> map) {
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
		StoreComponent that = (StoreComponent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StoreComponent(dependencies,components,decorators,stores,name,state,events,componentDidMountStatements,methods,renderStatements,renderConstants,returnStatements) ::= <<import React from 'react';\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"\n" + 
				"~dependencies:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~components:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"~decorators:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"@inject(~stores:{it|'~it~'};separator=\",\"~)\n" + 
				"@observer\n" + 
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
				"		~events:{it|this.~it.methodName~ = this.~it.methodName~.bind(this);};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	componentDidMount() {\n" + 
				"		console.log(\"mount ~name~ : \" +  this.props);\n" + 
				"		~componentDidMountStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"~if(events)~\n" + 
				"	~events:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"~endif~\n" + 
				"~if(methods)~\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"~endif~\n" + 
				"	render() {\n" + 
				"		console.log(\"render ~name~ : \" +  this.props);\n" + 
				"		~renderStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		~if(renderConstants)~const { ~renderConstants:{it|~it~};separator=\", \"~ } = this.state;~endif~\n" + 
				"		\n" + 
				"		~if(returnStatements)~return (~returnStatements:{it|~it~};separator=\"\\n\\n\"~)~else~return null;~endif~\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (~name~); >>";
} 