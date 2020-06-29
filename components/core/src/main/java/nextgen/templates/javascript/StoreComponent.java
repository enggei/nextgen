package nextgen.templates.javascript;

public class StoreComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _debug;
	private Object _renderElement;
	private java.util.List<Object> _components = new java.util.ArrayList<>();
	private java.util.List<Object> _stores = new java.util.ArrayList<>();
	private java.util.List<Object> _decorators = new java.util.ArrayList<>();
	private java.util.List<Object> _state = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _componentDidMountStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _renderStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _events = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _const = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _renderCondition = new java.util.ArrayList<>();

	StoreComponent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StoreComponent");
		st.add("name", _name);
		st.add("debug", _debug);
		st.add("renderElement", _renderElement);
		for (Object o : _components) st.add("components", o);
		for (Object o : _stores) st.add("stores", o);
		for (Object o : _decorators) st.add("decorators", o);
		for (Object o : _state) st.add("state", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _componentDidMountStatements) st.add("componentDidMountStatements", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _renderStatements) st.add("renderStatements", o);
		for (java.util.Map<String, Object> map : _imports) st.addAggr("imports.{name,path}", map.get("name"), map.get("path"));
		for (java.util.Map<String, Object> map : _events) st.addAggr("events.{methodName,declaration}", map.get("methodName"), map.get("declaration"));
		for (java.util.Map<String, Object> map : _const) st.addAggr("const.{name,declaration}", map.get("name"), map.get("declaration"));
		for (java.util.Map<String, Object> map : _renderCondition) st.addAggr("renderCondition.{condition,element}", map.get("condition"), map.get("element"));
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

	public StoreComponent setDebug(Object value) {
		this._debug = value;
		return this;
	}

	public Object getDebug() {
		return this._debug;
	}

	public Object getDebug(Object defaultValue) {
		return this._debug == null ? defaultValue : this._debug;
	}

	public boolean hasDebug() {
		return this._debug != null;
	}

	public StoreComponent removeDebug() {
		this._debug = null;
		return this;
	} 

	public StoreComponent setRenderElement(Object value) {
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

	public StoreComponent removeRenderElement() {
		this._renderElement = null;
		return this;
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

	public StoreComponent addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public StoreComponent setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StoreComponent setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public StoreComponent removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public StoreComponent removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
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

	public StoreComponent addImports(Object _name, Object _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("path", _path);
		this._imports.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getImports() {
		return this._imports;
	}

	public StoreComponent addImports(StoreComponent_Imports value) {
		return addImports(value._name, value._path);
	}

	public java.util.stream.Stream<StoreComponent_Imports> streamImports() {
		return this._imports.stream().map(StoreComponent_Imports::new);
	}

	public static final class StoreComponent_Imports {

		Object _name;
		Object _path;

		public StoreComponent_Imports(Object _name, Object _path) {
			this._name = _name;
			this._path = _path;
		}

		private StoreComponent_Imports(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._path = (Object) map.get("path");
		}

		public Object getName() {
			return this._name;
		}

		public Object getPath() {
			return this._path;
		}

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

	public StoreComponent addConst(Object _name, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("declaration", _declaration);
		this._const.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getConst() {
		return this._const;
	}

	public StoreComponent addConst(StoreComponent_Const value) {
		return addConst(value._name, value._declaration);
	}

	public java.util.stream.Stream<StoreComponent_Const> streamConst() {
		return this._const.stream().map(StoreComponent_Const::new);
	}

	public static final class StoreComponent_Const {

		Object _name;
		Object _declaration;

		public StoreComponent_Const(Object _name, Object _declaration) {
			this._name = _name;
			this._declaration = _declaration;
		}

		private StoreComponent_Const(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._declaration = (Object) map.get("declaration");
		}

		public Object getName() {
			return this._name;
		}

		public Object getDeclaration() {
			return this._declaration;
		}

	} 

	public StoreComponent addRenderCondition(Object _condition, Object _element) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("condition", _condition);
		map.put("element", _element);
		this._renderCondition.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRenderCondition() {
		return this._renderCondition;
	}

	public StoreComponent addRenderCondition(StoreComponent_RenderCondition value) {
		return addRenderCondition(value._condition, value._element);
	}

	public java.util.stream.Stream<StoreComponent_RenderCondition> streamRenderCondition() {
		return this._renderCondition.stream().map(StoreComponent_RenderCondition::new);
	}

	public static final class StoreComponent_RenderCondition {

		Object _condition;
		Object _element;

		public StoreComponent_RenderCondition(Object _condition, Object _element) {
			this._condition = _condition;
			this._element = _element;
		}

		private StoreComponent_RenderCondition(java.util.Map<String, Object> map) {
			this._condition = (Object) map.get("condition");
			this._element = (Object) map.get("element");
		}

		public Object getCondition() {
			return this._condition;
		}

		public Object getElement() {
			return this._element;
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

	static final String st = "StoreComponent(imports,components,stores,decorators,name,debug,state,constructorStatements,events,componentDidMountStatements,methods,renderStatements,const,renderCondition,renderElement) ::= <<import React from 'react';\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"~imports:{it|import ~it.name~ from '~it.path~';};separator=\"\\n\"~\n" + 
				"~components:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"@inject(~stores:{it|'~it~'};separator=\",\"~)\n" + 
				"@observer\n" + 
				"~decorators:{it|~it~};separator=\"\\n\"~\n" + 
				"class ~name~ extends React.Component {\n" + 
				"\n" + 
				"	constructor(props) {\n" + 
				"		super(props);\n" + 
				"~if(debug)~\n" + 
				"		console.log(\"new ~name~ : \" +  this.props);\n" + 
				"~endif~\n" + 
				"~if(state)~\n" + 
				"		this.state = {\n" + 
				"			~state:{it|~it~};separator=\",\\n\"~;\n" + 
				"		}\n" + 
				"~endif~\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		~events:{it|this.~it.methodName~ = this.~it.methodName~.bind(this);};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	componentDidMount() {\n" + 
				"~if(debug)~\n" + 
				"		console.log(\"mount ~name~ : \" +  this.props);\n" + 
				"~endif~\n" + 
				"		~componentDidMountStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"~if(events)~\n" + 
				"\n" + 
				"	~events:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"~endif~\n" + 
				"~if(methods)~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"~endif~\n" + 
				"	\n" + 
				"	render() {\n" + 
				"~if(debug)~\n" + 
				"		console.log(\"render ~name~ : \" +  this.props);\n" + 
				"~endif~\n" + 
				"		~renderStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		~const:{it|const ~it.name~ = ~it.declaration~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"~if(renderCondition)~\n" + 
				"		~renderCondition:{it|if (~it.condition~) \n" + 
				"	return (\n" + 
				"		~it.element~\n" + 
				"	);};separator=\"\\n\\nelse \"~\n" + 
				"	\n" + 
				"		else\n" + 
				"			return (\n" + 
				"				~renderElement~\n" + 
				"			);\n" + 
				"~else~\n" + 
				"		return (\n" + 
				"			~renderElement~\n" + 
				"		);\n" + 
				"~endif~\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (~name~); >>";
}  