package nextgen.templates.javascript;

public class IndexJS {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<String> _stores = new java.util.ArrayList<>();

	IndexJS(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("indexJS");
		st.add("name", _name);
		for (Object o : _stores) st.add("stores", o);
		return st.render().trim();
	}

	public IndexJS setName(String value) {
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

	public IndexJS removeName() {
		this._name = null;
		return this;
	} 

	public IndexJS addStores(String value) {
		this._stores.add(value);
		return this;
	}

	public IndexJS setStores(String[] value) {
		this._stores.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public IndexJS setStores(java.util.Collection<String> values) {
		this._stores.addAll(values);
		return this;
	}

	public IndexJS removeStores(String value) {
		this._stores.remove(value);
		return this;
	}

	public IndexJS removeStores(int index) {
		this._stores.remove(index);
		return this;
	}

	public java.util.List<String> getStores() {
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

	static final String st = "indexJS(name,stores) ::= <<import ReactDOM from 'react-dom';\n" + 
				"import React from 'react';\n" + 
				"import { BrowserRouter } from 'react-router-dom';\n" + 
				"import { useStrict } from 'mobx';\n" + 
				"import { Provider } from 'mobx-react';\n" + 
				"\n" + 
				"import ~name~ from './~name~';\n" + 
				"\n" + 
				"~stores:{it|import ~it~ from './stores/~it;format=\"capitalize\"~'};separator=\"\\n\"~\n" + 
				"\n" + 
				"const stores = {\n" + 
				"	~stores:{it|~it~};separator=\",\\n\"~\n" + 
				"};\n" + 
				"\n" + 
				"ReactDOM.render((\n" + 
				"	<Provider {...stores}>\n" + 
				"		<BrowserRouter>\n" + 
				"			<~name~ />\n" + 
				"		</BrowserRouter>\n" + 
				"	</Provider>\n" + 
				"), document.getElementById('root')); >>";
}  