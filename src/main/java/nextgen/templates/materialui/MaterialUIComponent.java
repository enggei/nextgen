package nextgen.templates.materialui;

public class MaterialUIComponent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _renderCondition;
	private Object _renderTrue;
	private Object _renderFalse;
	private Object _renderElement;
	private java.util.List<StyleClass> _styleClasses = new java.util.ArrayList<>();
	private java.util.List<Object> _componentImports = new java.util.ArrayList<>();
	private java.util.List<Object> _functions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _const = new java.util.ArrayList<>();

	MaterialUIComponent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MaterialUIComponent");
		st.add("name", _name);
		st.add("renderCondition", _renderCondition);
		st.add("renderTrue", _renderTrue);
		st.add("renderFalse", _renderFalse);
		st.add("renderElement", _renderElement);
		for (Object o : _styleClasses) st.add("styleClasses", o);
		for (Object o : _componentImports) st.add("componentImports", o);
		for (Object o : _functions) st.add("functions", o);
		for (java.util.Map<String, Object> map : _imports) st.addAggr("imports.{name,path}", map.get("name"), map.get("path"));
		for (java.util.Map<String, Object> map : _const) st.addAggr("const.{name,declaration}", map.get("name"), map.get("declaration"));
		return st.render().trim();
	}

	public MaterialUIComponent setName(String value) {
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

	public MaterialUIComponent removeName() {
		this._name = null;
		return this;
	} 

	public MaterialUIComponent setRenderCondition(Object value) {
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

	public MaterialUIComponent removeRenderCondition() {
		this._renderCondition = null;
		return this;
	} 

	public MaterialUIComponent setRenderTrue(Object value) {
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

	public MaterialUIComponent removeRenderTrue() {
		this._renderTrue = null;
		return this;
	} 

	public MaterialUIComponent setRenderFalse(Object value) {
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

	public MaterialUIComponent removeRenderFalse() {
		this._renderFalse = null;
		return this;
	} 

	public MaterialUIComponent setRenderElement(Object value) {
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

	public MaterialUIComponent removeRenderElement() {
		this._renderElement = null;
		return this;
	} 

	public MaterialUIComponent addStyleClasses(StyleClass value) {
		this._styleClasses.add(value);
		return this;
	}

	public MaterialUIComponent setStyleClasses(StyleClass[] value) {
		this._styleClasses.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MaterialUIComponent setStyleClasses(java.util.Collection<StyleClass> values) {
		this._styleClasses.addAll(values);
		return this;
	}

	public MaterialUIComponent removeStyleClasses(StyleClass value) {
		this._styleClasses.remove(value);
		return this;
	}

	public MaterialUIComponent removeStyleClasses(int index) {
		this._styleClasses.remove(index);
		return this;
	}

	public java.util.List<StyleClass> getStyleClasses() {
		return this._styleClasses;
	} 

	public MaterialUIComponent addComponentImports(Object value) {
		this._componentImports.add(value);
		return this;
	}

	public MaterialUIComponent setComponentImports(Object[] value) {
		this._componentImports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MaterialUIComponent setComponentImports(java.util.Collection<Object> values) {
		this._componentImports.addAll(values);
		return this;
	}

	public MaterialUIComponent removeComponentImports(Object value) {
		this._componentImports.remove(value);
		return this;
	}

	public MaterialUIComponent removeComponentImports(int index) {
		this._componentImports.remove(index);
		return this;
	}

	public java.util.List<Object> getComponentImports() {
		return this._componentImports;
	} 

	public MaterialUIComponent addFunctions(Object value) {
		this._functions.add(value);
		return this;
	}

	public MaterialUIComponent setFunctions(Object[] value) {
		this._functions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MaterialUIComponent setFunctions(java.util.Collection<Object> values) {
		this._functions.addAll(values);
		return this;
	}

	public MaterialUIComponent removeFunctions(Object value) {
		this._functions.remove(value);
		return this;
	}

	public MaterialUIComponent removeFunctions(int index) {
		this._functions.remove(index);
		return this;
	}

	public java.util.List<Object> getFunctions() {
		return this._functions;
	} 

	public MaterialUIComponent addImports(Object _name, Object _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("path", _path);
		this._imports.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getImports() {
		return this._imports;
	}

	public MaterialUIComponent addImports(MaterialUIComponent_Imports value) {
		return addImports(value._name, value._path);
	}

	public java.util.stream.Stream<MaterialUIComponent_Imports> streamImports() {
		return this._imports.stream().map(MaterialUIComponent_Imports::new);
	}

	public java.util.List<Object> getImports_Name() {
		return streamImports().map(MaterialUIComponent_Imports::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getImports_Path() {
		return streamImports().map(MaterialUIComponent_Imports::getPath).collect(java.util.stream.Collectors.toList());
	}


	public static final class MaterialUIComponent_Imports {

		Object _name;
		Object _path;

		public MaterialUIComponent_Imports(Object _name, Object _path) {
			this._name = _name;
			this._path = _path;
		}

		private MaterialUIComponent_Imports(java.util.Map<String, Object> map) {
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

	public MaterialUIComponent addConst(Object _name, Object _declaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("declaration", _declaration);
		this._const.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getConst() {
		return this._const;
	}

	public MaterialUIComponent addConst(MaterialUIComponent_Const value) {
		return addConst(value._name, value._declaration);
	}

	public java.util.stream.Stream<MaterialUIComponent_Const> streamConst() {
		return this._const.stream().map(MaterialUIComponent_Const::new);
	}

	public java.util.List<Object> getConst_Name() {
		return streamConst().map(MaterialUIComponent_Const::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getConst_Declaration() {
		return streamConst().map(MaterialUIComponent_Const::getDeclaration).collect(java.util.stream.Collectors.toList());
	}


	public static final class MaterialUIComponent_Const {

		Object _name;
		Object _declaration;

		public MaterialUIComponent_Const(Object _name, Object _declaration) {
			this._name = _name;
			this._declaration = _declaration;
		}

		private MaterialUIComponent_Const(java.util.Map<String, Object> map) {
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
		MaterialUIComponent that = (MaterialUIComponent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MaterialUIComponent(styleClasses,componentImports,imports,name,const,functions,renderCondition,renderTrue,renderFalse,renderElement) ::= <<import React from 'react';\n" + 
				"~if(styleClasses)~\n" + 
				"import { makeStyles } from '@material-ui/core/styles';\n" + 
				"\n" + 
				"~endif~\n" + 
				"~componentImports:{it|~it~};separator=\"\\n\"~\n" + 
				"~imports:{it|import ~it.name~ from '~it.path~';};separator=\"\\n\"~\n" + 
				"~if(styleClasses)~\n" + 
				"\n" + 
				"const useStyles = makeStyles((theme) => ({\n" + 
				"	~styleClasses:{it|~it~};separator=\",\\n\"~\n" + 
				"}));\n" + 
				"~endif~\n" + 
				"\n" + 
				"export default function ~name~(props) {\n" + 
				"\n" + 
				"~if(styleClasses)~\n" + 
				"	const classes = useStyles();\n" + 
				"	\n" + 
				"~endif~\n" + 
				"	~const:{it|const ~it.name~ = ~it.declaration~;};separator=\"\\n\"~\n" + 
				"~if(functions)~\n" + 
				"	\n" + 
				"	~functions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"~endif~\n" + 
				"~if(renderCondition)~\n" + 
				"	if(~renderCondition~) {\n" + 
				"		console.info(\"~name~.~renderCondition~ TRUE\");\n" + 
				"		return ( \n" + 
				"			~renderTrue~\n" + 
				"		);\n" + 
				"	} else {\n" + 
				"		console.info(\"~name~.~renderCondition~ FALSE\");\n" + 
				"		return (\n" + 
				"			~renderFalse~\n" + 
				"		);\n" + 
				"	}\n" + 
				"~else~\n" + 
				"	console.info(\"render ~name~ \" + props);\n" + 
				"	return (\n" + 
				"		~renderElement~\n" + 
				"	);\n" + 
				"~endif~\n" + 
				"} >>";
}  