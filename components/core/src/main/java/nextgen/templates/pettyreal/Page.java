package nextgen.templates.pettyreal;

public class Page {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _renderCondition;
	private Object _renderTrue;
	private Object _renderFalse;
	private Object _renderElement;
	private java.util.List<Object> _stores = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _componentDidMountStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _renderConst = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _components = new java.util.ArrayList<>();

	Page(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Page");
		st.add("name", _name);
		st.add("renderCondition", _renderCondition);
		st.add("renderTrue", _renderTrue);
		st.add("renderFalse", _renderFalse);
		st.add("renderElement", _renderElement);
		for (Object o : _stores) st.add("stores", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _componentDidMountStatements) st.add("componentDidMountStatements", o);
		for (Object o : _renderConst) st.add("renderConst", o);
		for (java.util.Map<String, Object> map : _components) st.addAggr("components.{name}", map.get("name"));
		return st.render().trim();
	}

	public Page setName(Object value) {
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

	public Page removeName() {
		this._name = null;
		return this;
	} 

	public Page setRenderCondition(Object value) {
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

	public Page removeRenderCondition() {
		this._renderCondition = null;
		return this;
	} 

	public Page setRenderTrue(Object value) {
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

	public Page removeRenderTrue() {
		this._renderTrue = null;
		return this;
	} 

	public Page setRenderFalse(Object value) {
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

	public Page removeRenderFalse() {
		this._renderFalse = null;
		return this;
	} 

	public Page setRenderElement(Object value) {
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

	public Page removeRenderElement() {
		this._renderElement = null;
		return this;
	} 

	public Page addStores(Object value) {
		this._stores.add(value);
		return this;
	}

	public Page setStores(Object[] value) {
		this._stores.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Page setStores(java.util.Collection<Object> values) {
		this._stores.addAll(values);
		return this;
	}

	public Page removeStores(Object value) {
		this._stores.remove(value);
		return this;
	}

	public Page removeStores(int index) {
		this._stores.remove(index);
		return this;
	}

	public java.util.List<Object> getStores() {
		return this._stores;
	} 

	public Page addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public Page setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Page setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public Page removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public Page removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public Page addComponentDidMountStatements(Object value) {
		this._componentDidMountStatements.add(value);
		return this;
	}

	public Page setComponentDidMountStatements(Object[] value) {
		this._componentDidMountStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Page setComponentDidMountStatements(java.util.Collection<Object> values) {
		this._componentDidMountStatements.addAll(values);
		return this;
	}

	public Page removeComponentDidMountStatements(Object value) {
		this._componentDidMountStatements.remove(value);
		return this;
	}

	public Page removeComponentDidMountStatements(int index) {
		this._componentDidMountStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getComponentDidMountStatements() {
		return this._componentDidMountStatements;
	} 

	public Page addRenderConst(Object value) {
		this._renderConst.add(value);
		return this;
	}

	public Page setRenderConst(Object[] value) {
		this._renderConst.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Page setRenderConst(java.util.Collection<Object> values) {
		this._renderConst.addAll(values);
		return this;
	}

	public Page removeRenderConst(Object value) {
		this._renderConst.remove(value);
		return this;
	}

	public Page removeRenderConst(int index) {
		this._renderConst.remove(index);
		return this;
	}

	public java.util.List<Object> getRenderConst() {
		return this._renderConst;
	} 

	public Page addComponents(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._components.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getComponents() {
		return this._components;
	}

	public Page addComponents(Page_Components value) {
		return addComponents(value._name);
	}

	public java.util.stream.Stream<Page_Components> streamComponents() {
		return this._components.stream().map(Page_Components::new);
	}

	public java.util.List<Object> getComponents_Name() {
		return streamComponents().map(Page_Components::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Page_Components {

		Object _name;

		public Page_Components(Object _name) {
			this._name = _name;
		}

		private Page_Components(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Page that = (Page) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Page(components,stores,name,constructorStatements,componentDidMountStatements,renderConst,renderCondition,renderTrue,renderFalse,renderElement) ::= <<import React from 'react';\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"~components:{it|import ~it.name~ from '../components/~it.name~';};separator=\"\\n\"~\n" + 
				"\n" + 
				"~if(stores)~@inject(~stores:{it|'~it~'};separator=\",\"~)~endif~\n" + 
				"@observer\n" + 
				"class ~name~ extends React.Component {\n" + 
				"\n" + 
				"	constructor(props) {\n" + 
				"		super(props);\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	componentDidMount() {\n" + 
				"		~componentDidMountStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		// this.props.siteStore.load~name~(this.props.match.params.id);\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"\n" + 
				"		~renderConst:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~if(renderCondition)~\n" + 
				"	if(~renderCondition~)\n" + 
				"		return ( \n" + 
				"			~renderTrue~\n" + 
				"		);\n" + 
				"	else\n" + 
				"		return (\n" + 
				"			~renderFalse~\n" + 
				"		);\n" + 
				"~else~\n" + 
				"	return (\n" + 
				"		~renderElement~\n" + 
				"	);\n" + 
				"~endif~\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default (~name~); >>";
}  