package nextgen.templates.javascript;

public class App {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _footerName;
	private java.util.List<String> _stores = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _routes = new java.util.ArrayList<>();

	App(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("App");
		st.add("footerName", _footerName);
		for (Object o : _stores) st.add("stores", o);
		for (java.util.Map<String, Object> map : _routes) st.addAggr("routes.{component,filename,path}", map.get("component"), map.get("filename"), map.get("path"));
		return st.render().trim();
	}

	public App setFooterName(String value) {
		this._footerName = value;
		return this;
	}

	public String getFooterName() {
		return this._footerName;
	}

	public String getFooterName(String defaultValue) {
		return this._footerName == null ? defaultValue : this._footerName;
	}

	public boolean hasFooterName() {
		return this._footerName != null;
	}

	public App removeFooterName() {
		this._footerName = null;
		return this;
	} 

	public App addStores(String value) {
		this._stores.add(value);
		return this;
	}

	public App setStores(String[] value) {
		this._stores.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public App setStores(java.util.Collection<String> values) {
		this._stores.addAll(values);
		return this;
	}

	public App removeStores(String value) {
		this._stores.remove(value);
		return this;
	}

	public App removeStores(int index) {
		this._stores.remove(index);
		return this;
	}

	public java.util.List<String> getStores() {
		return this._stores;
	} 

	public App addRoutes(String _component, String _filename, String _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("component", _component);
		map.put("filename", _filename);
		map.put("path", _path);
		this._routes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRoutes() {
		return this._routes;
	}

	public App addRoutes(App_Routes value) {
		return addRoutes(value._component, value._filename, value._path);
	}

	public java.util.stream.Stream<App_Routes> streamRoutes() {
		return this._routes.stream().map(App_Routes::new);
	}

	public static final class App_Routes {

		String _component;
		String _filename;
		String _path;

		public App_Routes(String _component, String _filename, String _path) {
			this._component = _component;
			this._filename = _filename;
			this._path = _path;
		}

		private App_Routes(java.util.Map<String, Object> map) {
			this._component = (String) map.get("component");
			this._filename = (String) map.get("filename");
			this._path = (String) map.get("path");
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

	static final String st = "App(routes,stores,footerName) ::= <<import React, { Component } from 'react';\n" + 
				"import { Switch, Route, withRouter } from 'react-router-dom';\n" + 
				"\n" + 
				"import { Provider } from 'mobx-react';\n" + 
				"import { inject, observer } from 'mobx-react';\n" + 
				"\n" + 
				"import CssBaseline from '@material-ui/core/CssBaseline';\n" + 
				"\n" + 
				"import NavigationBar from './components/NavigationBar.js';\n" + 
				"import LoginForm from './components/LoginForm.js';\n" + 
				"import LogoutForm from './components/LogoutForm.js';\n" + 
				"\n" + 
				"~routes:{it|import ~it.component~ from './components/~it.filename~';};separator=\"\\n\"~\n" + 
				"\n" + 
				"@inject(~stores:{it|'~it~'};separator=\", \"~)\n" + 
				"@withRouter\n" + 
				"@observer\n" + 
				"class App extends Component {\n" + 
				"\n" + 
				"    constructor(props) {\n" + 
				"        super(props);\n" + 
				"        if (!this.props.appStore.token) {\n" + 
				"            this.props.appStore.setAppLoaded();\n" + 
				"        }\n" + 
				"    }\n" + 
				"\n" + 
				"	componentDidMount() {\n" + 
				"		if (this.props.appStore.token) {\n" + 
				"			this.props.userStore.pullUser().finally(() => this.props.appStore.setAppLoaded());\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	render() {\n" + 
				"\n" + 
				"	    if (this.props.appStore.appLoaded) {\n" + 
				"            return (\n" + 
				"                <div>\n" + 
				"                    <div>\n" + 
				"                        <NavigationBar></NavigationBar>\n" + 
				"                  </div>\n" + 
				"                    <Switch>\n" + 
				"                        <Route path=\"/login\" component={LoginForm} />\n" + 
				"                        <Route path=\"/logout\" component={LogoutForm} />\n" + 
				"                        ~routes:{it|<Route path=\"/~it.path~\" component={~it.component~\\} />};separator=\"\\n\"~\n" + 
				"                    </Switch>\n" + 
				"                </div>\n" + 
				"            );\n" + 
				"        }\n" + 
				"\n" + 
				"		return (\n" + 
				"            <React.Fragment>\n" + 
				"                  <CssBaseline />\n" + 
				"                  <NavigationBar />\n" + 
				"                    <footer className=\"footer\">\n" + 
				"                        &copy; Copyright <span>{(new Date().getFullYear())}</span> ~footerName~\n" + 
				"                    </footer>\n" + 
				"            </React.Fragment>\n" + 
				"			);\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default App; >>";
} 