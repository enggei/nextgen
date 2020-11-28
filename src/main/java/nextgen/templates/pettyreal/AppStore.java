package nextgen.templates.pettyreal;

public class AppStore {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _appName;

	AppStore(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AppStore");
		st.add("appName", _appName);
		return st.render().trim();
	}

	public AppStore setAppName(Object value) {
		this._appName = value;
		return this;
	}

	public Object getAppName() {
		return this._appName;
	}

	public Object getAppName(Object defaultValue) {
		return this._appName == null ? defaultValue : this._appName;
	}

	public boolean hasAppName() {
		return this._appName != null;
	}

	public AppStore removeAppName() {
		this._appName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AppStore that = (AppStore) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AppStore(appName) ::= <<import { observable, action,  reaction } from 'mobx';\n" + 
				"import agent from '../Agent.js';\n" + 
				"\n" + 
				"class AppStore {\n" + 
				"\n" + 
				"	@observable loading;\n" + 
				"	@observable errors = undefined;\n" + 
				"	@observable appName = '~appName~';\n" + 
				"	@observable token = window.localStorage.getItem('jwt');\n" + 
				"	@observable appLoaded = false;\n" + 
				"\n" + 
				"	constructor() {\n" + 
				"		reaction(() => this.token, (token) => { if (token) window.localStorage.setItem('jwt',token); else window.localStorage.removeItem('jwt'); });\n" + 
				"	}\n" + 
				"\n" + 
				"	@action setToken(token) {\n" + 
				"		this.token = token;\n" + 
				"	}\n" + 
				"\n" + 
				"	@action setAppLoaded() {\n" + 
				"		this.appLoaded = true;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default new AppStore(); >>";
}  