package nextgen.templates.javascript;

public class IndexJS {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _stores = new java.util.ArrayList<>();

	IndexJS(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("indexJS");
		for (Object o : _stores) st.add("stores", o);
		return st.render().trim();
	}


	public IndexJS addStores(Object value) {
		this._stores.add(value);
		return this;
	}

	public IndexJS setStores(Object[] value) {
		this._stores.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public IndexJS setStores(java.util.Collection<Object> values) {
		this._stores.addAll(values);
		return this;
	}

	public IndexJS removeStores(Object value) {
		this._stores.remove(value);
		return this;
	}

	public IndexJS removeStores(int index) {
		this._stores.remove(index);
		return this;
	}

	public java.util.List<Object> getStores() {
		return this._stores;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IndexJS that = (IndexJS) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "indexJS(stores) ::= <<import ReactDOM from 'react-dom';\n" + 
				"import React from 'react';\n" + 
				"import { BrowserRouter } from 'react-router-dom';\n" + 
				"import { useStrict } from 'mobx';\n" + 
				"import { Provider } from 'mobx-react';\n" + 
				"\n" + 
				"import App from './App';\n" + 
				"\n" + 
				"~stores:{it|import ~it;format=\"lowFirst\"~ from './stores/~it;format=\"capitalize\"~.js';};separator=\"\\n\"~\n" + 
				"\n" + 
				"const stores = {\n" + 
				"	~stores:{it|~it;format=\"lowFirst\"~};separator=\",\\n\"~\n" + 
				"};\n" + 
				"\n" + 
				"ReactDOM.render((\n" + 
				"	<Provider {...stores}>\n" + 
				"		<BrowserRouter>\n" + 
				"			<App />\n" + 
				"		</BrowserRouter>\n" + 
				"	</Provider>\n" + 
				"), document.getElementById('root')); >>";
}  