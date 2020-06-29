package nextgen.templates.javascript;

public class MobXStore {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<Observable> _observables = new java.util.ArrayList<>();
	private java.util.List<Action> _actions = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _imports = new java.util.ArrayList<>();

	MobXStore(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MobXStore");
		st.add("name", _name);
		for (Object o : _observables) st.add("observables", o);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (java.util.Map<String, Object> map : _imports) st.addAggr("imports.{ref,path}", map.get("ref"), map.get("path"));
		return st.render().trim();
	}

	public MobXStore setName(String value) {
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

	public MobXStore removeName() {
		this._name = null;
		return this;
	} 

	public MobXStore addObservables(Observable value) {
		this._observables.add(value);
		return this;
	}

	public MobXStore setObservables(Observable[] value) {
		this._observables.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MobXStore setObservables(java.util.Collection<Observable> values) {
		this._observables.addAll(values);
		return this;
	}

	public MobXStore removeObservables(Observable value) {
		this._observables.remove(value);
		return this;
	}

	public MobXStore removeObservables(int index) {
		this._observables.remove(index);
		return this;
	}

	public java.util.List<Observable> getObservables() {
		return this._observables;
	} 

	public MobXStore addActions(Action value) {
		this._actions.add(value);
		return this;
	}

	public MobXStore setActions(Action[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MobXStore setActions(java.util.Collection<Action> values) {
		this._actions.addAll(values);
		return this;
	}

	public MobXStore removeActions(Action value) {
		this._actions.remove(value);
		return this;
	}

	public MobXStore removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Action> getActions() {
		return this._actions;
	} 

	public MobXStore addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public MobXStore setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MobXStore setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public MobXStore removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public MobXStore removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public MobXStore addImports(Object _ref, Object _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("ref", _ref);
		map.put("path", _path);
		this._imports.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getImports() {
		return this._imports;
	}

	public MobXStore addImports(MobXStore_Imports value) {
		return addImports(value._ref, value._path);
	}

	public java.util.stream.Stream<MobXStore_Imports> streamImports() {
		return this._imports.stream().map(MobXStore_Imports::new);
	}

	public static final class MobXStore_Imports {

		Object _ref;
		Object _path;

		public MobXStore_Imports(Object _ref, Object _path) {
			this._ref = _ref;
			this._path = _path;
		}

		private MobXStore_Imports(java.util.Map<String, Object> map) {
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
		MobXStore that = (MobXStore) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MobXStore(observables,actions,imports,name,constructorStatements) ::= <<import { ~if(observables)~observable~endif~~if(actions)~~if(observables)~, ~endif~action, ~endif~ reaction } from 'mobx';\n" + 
				"~imports:{it|import ~it.ref~ from '~it.path~';};separator=\"\\n\"~\n" + 
				"\n" + 
				"class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	~observables:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	constructor() {\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"export default new ~name;format=\"capitalize\"~(); >>";
}  