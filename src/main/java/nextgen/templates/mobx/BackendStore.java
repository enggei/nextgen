package nextgen.templates.mobx;

public class BackendStore implements IStore {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<Observable> _observables = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<BackendAction> _backendActions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _imports = new java.util.ArrayList<>();

	BackendStore(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BackendStore");
		st.add("name", _name);
		for (Object o : _observables) st.add("observables", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _backendActions) st.add("backendActions", o);
		for (java.util.Map<String, Object> map : _imports) st.addAggr("imports.{ref,path}", map.get("ref"), map.get("path"));
		return st.render().trim();
	}

	public BackendStore setName(String value) {
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

	public BackendStore removeName() {
		this._name = null;
		return this;
	} 

	public BackendStore addObservables(Observable value) {
		this._observables.add(value);
		return this;
	}

	public BackendStore setObservables(Observable[] value) {
		this._observables.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BackendStore setObservables(java.util.Collection<Observable> values) {
		this._observables.addAll(values);
		return this;
	}

	public BackendStore removeObservables(Observable value) {
		this._observables.remove(value);
		return this;
	}

	public BackendStore removeObservables(int index) {
		this._observables.remove(index);
		return this;
	}

	public java.util.List<Observable> getObservables() {
		return this._observables;
	} 

	public BackendStore addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public BackendStore setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BackendStore setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public BackendStore removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public BackendStore removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public BackendStore addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public BackendStore setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BackendStore setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public BackendStore removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public BackendStore removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public BackendStore addBackendActions(BackendAction value) {
		this._backendActions.add(value);
		return this;
	}

	public BackendStore setBackendActions(BackendAction[] value) {
		this._backendActions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BackendStore setBackendActions(java.util.Collection<BackendAction> values) {
		this._backendActions.addAll(values);
		return this;
	}

	public BackendStore removeBackendActions(BackendAction value) {
		this._backendActions.remove(value);
		return this;
	}

	public BackendStore removeBackendActions(int index) {
		this._backendActions.remove(index);
		return this;
	}

	public java.util.List<BackendAction> getBackendActions() {
		return this._backendActions;
	} 

	public BackendStore addImports(Object _ref, Object _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("ref", _ref);
		map.put("path", _path);
		this._imports.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getImports() {
		return this._imports;
	}

	public BackendStore addImports(BackendStore_Imports value) {
		return addImports(value._ref, value._path);
	}

	public java.util.stream.Stream<BackendStore_Imports> streamImports() {
		return this._imports.stream().map(BackendStore_Imports::new);
	}

	public java.util.List<Object> getImports_Ref() {
		return streamImports().map(BackendStore_Imports::getRef).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getImports_Path() {
		return streamImports().map(BackendStore_Imports::getPath).collect(java.util.stream.Collectors.toList());
	}


	public static final class BackendStore_Imports {

		Object _ref;
		Object _path;

		public BackendStore_Imports(Object _ref, Object _path) {
			this._ref = _ref;
			this._path = _path;
		}

		private BackendStore_Imports(java.util.Map<String, Object> map) {
			this._ref = (Object) map.get("ref");
			this._path = (Object) map.get("path");
		}

		public Object getRef() {
			return this._ref;
		}

		public Object getPath() {
			return this._path;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BackendStore that = (BackendStore) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BackendStore(imports,name,observables,constructorStatements,actions,backendActions) ::= <<import { observable, action, reaction } from 'mobx';\n" + 
				"~imports:{it|import ~it.ref~ from '~it.path~';};separator=\"\\n\"~\n" + 
				"\n" + 
				"class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	~observables:{it|~it~};separator=\"\\n\"~\n" + 
				"	@observable errors;\n" + 
				"	@observable inProgress = false;\n" + 
				"\n" + 
				"	constructor() {\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~backendActions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@action setErrors(action, errors) {\n" + 
				"		console.info(\"action \" + action + \".errors \" + errors);\n" + 
				"		this.errors = errors;\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"export default new ~name;format=\"capitalize\"~(); >>";
}  