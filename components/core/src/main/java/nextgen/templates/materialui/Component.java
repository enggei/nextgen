package nextgen.templates.materialui;

public class Component {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _renderCondition;
	private Object _renderTrue;
	private Object _renderFalse;
	private Object _renderElement;
	private java.util.List<StyleClass> _styleClasses = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _components = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _const = new java.util.ArrayList<>();

	Component(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Component");
		st.add("name", _name);
		st.add("renderCondition", _renderCondition);
		st.add("renderTrue", _renderTrue);
		st.add("renderFalse", _renderFalse);
		st.add("renderElement", _renderElement);
		for (Object o : _styleClasses) st.add("styleClasses", o);
		for (java.util.Map<String, Object> map : _imports) st.addAggr("imports.{name,path}", map.get("name"), map.get("path"));
		for (java.util.Map<String, Object> map : _components) st.addAggr("components.{name,lexical}", map.get("name"), map.get("lexical"));
		for (java.util.Map<String, Object> map : _const) st.addAggr("const.{name,declaration}", map.get("name"), map.get("declaration"));
		return st.render().trim();
	}

	public Component setName(String value) {
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

	public Component removeName() {
		this._name = null;
		return this;
	} 

	public Component setRenderCondition(Object value) {
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

	public Component removeRenderCondition() {
		this._renderCondition = null;
		return this;
	} 

	public Component setRenderTrue(Object value) {
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

	public Component removeRenderTrue() {
		this._renderTrue = null;
		return this;
	} 

	public Component setRenderFalse(Object value) {
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

	public Component removeRenderFalse() {
		this._renderFalse = null;
		return this;
	} 

	public Component setRenderElement(Object value) {
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

	public Component removeRenderElement() {
		this._renderElement = null;
		return this;
	} 

	public Component addStyleClasses(StyleClass value) {
		this._styleClasses.add(value);
		return this;
	}

	public Component setStyleClasses(StyleClass[] value) {
		this._styleClasses.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Component setStyleClasses(java.util.Collection<StyleClass> values) {
		this._styleClasses.addAll(values);
		return this;
	}

	public Component removeStyleClasses(StyleClass value) {
		this._styleClasses.remove(value);
		return this;
	}

	public Component removeStyleClasses(int index) {
		this._styleClasses.remove(index);
		return this;
	}

	public java.util.List<StyleClass> getStyleClasses() {
		return this._styleClasses;
	} 

	public Component addImports(Object _name, Object _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("path", _path);
		this._imports.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getImports() {
		return this._imports;
	}

	public Component addImports(Component_Imports value) {
		return addImports(value._name, value._path);
	}

	public java.util.stream.Stream<Component_Imports> streamImports() {
		return this._imports.stream().map(Component_Imports::new);
	}

	public static final class Component_Imports {

		Object _name;
		Object _path;

		public Component_Imports(Object _name, Object _path) {
			this._name = _name;
			this._path = _path;
		}

		private Component_Imports(java.util.Map<String, Object> map) {
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

	public Component addComponents(String _name, String _lexical) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("lexical", _lexical);
		this._components.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getComponents() {
		return this._components;
	}

	public Component addComponents(Component_Components value) {
		return addComponents(value._name, value._lexical);
	}

	public java.util.stream.Stream<Component_Components> streamComponents() {
		return this._components.stream().map(Component_Components::new);
	}

	public static final class Component_Components {

		String _name;
		String _lexical;

		public Component_Components(String _name, String _lexical) {
			this._name = _name;
			this._lexical = _lexical;
		}

		private Component_Components(java.util.Map<String, Object> map) {
			this._name = (String) map.get("name");
			this._lexical = (String) map.get("lexical");
		}

		public String getName() {
			return this._name;
		}

		public String getLexical() {
			return this._lexical;
		}

	} 

	public Component addConst(Object _name, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("declaration", _declaration);
		this._const.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getConst() {
		return this._const;
	}

	public Component addConst(Component_Const value) {
		return addConst(value._name, value._declaration);
	}

	public java.util.stream.Stream<Component_Const> streamConst() {
		return this._const.stream().map(Component_Const::new);
	}

	public static final class Component_Const {

		Object _name;
		Object _declaration;

		public Component_Const(Object _name, Object _declaration) {
			this._name = _name;
			this._declaration = _declaration;
		}

		private Component_Const(java.util.Map<String, Object> map) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Component that = (Component) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Component(imports,components,styleClasses,name,const,renderCondition,renderTrue,renderFalse,renderElement) ::= <<import React from 'react';\n" + 
				"import { makeStyles } from '@material-ui/core/styles';\n" + 
				"~imports:{it|import ~it.name~ from '~it.path~';};separator=\"\\n\"~\n" + 
				"~components:{it|import ~it.name~ from '~it.lexical~';};separator=\"\\n\"~\n" + 
				"\n" + 
				"const useStyles = makeStyles((theme) => ({\n" + 
				"	~styleClasses:{it|~it~};separator=\",\\n\"~\n" + 
				"}));\n" + 
				"\n" + 
				"export default function ~name~(props) {\n" + 
				"\n" + 
				"	const classes = useStyles();\n" + 
				"	~const:{it|const ~it.name~ = ~it.declaration~;};separator=\"\\n\"~\n" + 
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
				"} >>";
}  