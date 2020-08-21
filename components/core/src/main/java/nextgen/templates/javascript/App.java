package nextgen.templates.javascript;

public class App {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _theme;
	private java.util.List<Object> _stores = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _routes = new java.util.ArrayList<>();

	App(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("App");
		st.add("theme", _theme);
		for (Object o : _stores) st.add("stores", o);
		for (java.util.Map<String, Object> map : _routes) st.addAggr("routes.{component,filename,path,render}", map.get("component"), map.get("filename"), map.get("path"), map.get("render"));
		return st.render().trim();
	}

	public App setTheme(Object value) {
		this._theme = value;
		return this;
	}

	public Object getTheme() {
		return this._theme;
	}

	public Object getTheme(Object defaultValue) {
		return this._theme == null ? defaultValue : this._theme;
	}

	public boolean hasTheme() {
		return this._theme != null;
	}

	public App removeTheme() {
		this._theme = null;
		return this;
	} 

	public App addStores(Object value) {
		this._stores.add(value);
		return this;
	}

	public App setStores(Object[] value) {
		this._stores.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public App setStores(java.util.Collection<Object> values) {
		this._stores.addAll(values);
		return this;
	}

	public App removeStores(Object value) {
		this._stores.remove(value);
		return this;
	}

	public App removeStores(int index) {
		this._stores.remove(index);
		return this;
	}

	public java.util.List<Object> getStores() {
		return this._stores;
	} 

	public App addRoutes(String _component, String _filename, String _path, Object _render) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("component", _component);
		map.put("filename", _filename);
		map.put("path", _path);
		map.put("render", _render);
		this._routes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRoutes() {
		return this._routes;
	}

	public App addRoutes(App_Routes value) {
		return addRoutes(value._component, value._filename, value._path, value._render);
	}

	public java.util.stream.Stream<App_Routes> streamRoutes() {
		return this._routes.stream().map(App_Routes::new);
	}

	public static final class App_Routes {

		String _component;
		String _filename;
		String _path;
		Object _render;

		public App_Routes(String _component, String _filename, String _path, Object _render) {
			this._component = _component;
			this._filename = _filename;
			this._path = _path;
			this._render = _render;
		}

		private App_Routes(java.util.Map<String, Object> map) {
			this._component = (String) map.get("component");
			this._filename = (String) map.get("filename");
			this._path = (String) map.get("path");
			this._render = (Object) map.get("render");
		}

		public String getComponent() {
			return this._component;
		}

		public String getFilename() {
			return this._filename;
		}

		public String getPath() {
			return this._path;
		}

		public Object getRender() {
			return this._render;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		App that = (App) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "App(routes,theme,stores) ::= <<import React, { Component } from 'react';\n" + 
				"import { Switch, Route, withRouter } from 'react-router-dom';\n" + 
				"\n" + 
				"import { Provider } from 'mobx-react';\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"\n" + 
				"~routes:{it|import ~it.component~ from './pages/~it.filename~';};separator=\"\\n\"~\n" + 
				"\n" + 
				"import NavigationBar from './components/NavigationBar.js';\n" + 
				"\n" + 
				"import CssBaseline from '@material-ui/core/CssBaseline';\n" + 
				"import { ThemeProvider } from '@material-ui/styles';\n" + 
				"import { createMuiTheme } from '@material-ui/core/styles';\n" + 
				"\n" + 
				"// https://in-your-saas.github.io/material-ui-theme-editor/\n" + 
				"//const theme = createMuiTheme({\"palette\":{\"common\":{\"black\":\"#000\",\"white\":\"#fff\"},\"background\":{\"paper\":\"#fff\",\"default\":\"#fafafa\"},\"primary\":{\"light\":\"rgba(255, 255, 255, 1)\",\"main\":\"rgba(22, 22, 23, 1)\",\"dark\":\"rgba(74, 74, 74, 1)\",\"contrastText\":\"#fff\"},\"secondary\":{\"light\":\"#ff4081\",\"main\":\"rgba(245, 166, 35, 1)\",\"dark\":\"#c51162\",\"contrastText\":\"#fff\"},\"error\":{\"light\":\"#e57373\",\"main\":\"#f44336\",\"dark\":\"#d32f2f\",\"contrastText\":\"#fff\"},\"text\":{\"primary\":\"rgba(0, 0, 0, 0.87)\",\"secondary\":\"rgba(0, 0, 0, 0.54)\",\"disabled\":\"rgba(0, 0, 0, 0.38)\",\"hint\":\"rgba(0, 0, 0, 0.38)\"}}});\n" + 
				"const theme = createMuiTheme(~theme~);\n" + 
				"\n" + 
				"@inject(~stores:{it|'~it~'};separator=\", \"~)\n" + 
				"@withRouter\n" + 
				"@observer\n" + 
				"class App extends Component {\n" + 
				"\n" + 
				"	constructor(props) {\n" + 
				"		super(props);\n" + 
				"		\n" + 
				"		if (!this.props.appStore.token) \n" + 
				"			this.props.appStore.setAppLoaded();\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	componentDidMount() {\n" + 
				"		\n" + 
				"		if (this.props.appStore.token) \n" + 
				"			this.props.userStore.pullUser().finally(() => this.props.appStore.setAppLoaded());\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"\n" + 
				"		if (this.props.appStore.appLoaded) {\n" + 
				"			return (\n" + 
				"				<ThemeProvider theme={theme}>\n" + 
				"					<CssBaseline />\n" + 
				"					<div>\n" + 
				"						<NavigationBar userStore={ this.props.userStore }></NavigationBar>\n" + 
				"					</div>\n" + 
				"					<Switch>\n" + 
				"						~routes:{it|<Route path=\"~it.path~\" ~if(it.render)~render=~it.render~~else~component={~it.component~\\}~endif~ />};separator=\"\\n\"~\n" + 
				"					</Switch>\n" + 
				"				</ThemeProvider>);\n" + 
				"		} else return null;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default App; >>";
}  