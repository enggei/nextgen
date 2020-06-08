package nextgen.templates.kotlin;

public class DataClass {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _isFinal;
	private Object _className;
	private Object _single;
	private java.util.List<Object> _liste = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _users = new java.util.ArrayList<>();

	DataClass(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DataClass that = (DataClass) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DataClass");
		st.add("isFinal", _isFinal);
		st.add("className", _className);
		st.add("single", _single);
		for (Object o : _liste) st.add("liste", o);
		for (java.util.Map<String, Object> map : _users) st.addAggr("users.{username,age}", map.get("username"), map.get("age"));
		return st.render().trim();
	}

	public DataClass setIsFinal(Object value) {
		this._isFinal = value;
		return this;
	}

	public Object getIsFinal() {
		return this._isFinal;
	}

	public boolean hasIsFinal() {
		return this._isFinal != null;
	}

	public DataClass removeIsFinal() {
		this._isFinal = null;
		return this;
	} 

	public DataClass setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public DataClass removeClassName() {
		this._className = null;
		return this;
	} 

	public DataClass setSingle(Object value) {
		this._single = value;
		return this;
	}

	public Object getSingle() {
		return this._single;
	}

	public boolean hasSingle() {
		return this._single != null;
	}

	public DataClass removeSingle() {
		this._single = null;
		return this;
	} 
	public DataClass addListe(Object value) {
		this._liste.add(value);
		return this;
	}

	public DataClass removeListe(Object value) {
		this._liste.remove(value);
		return this;
	}

	public DataClass removeListe(int index) {
		this._liste.remove(index);
		return this;
	}

	public java.util.List<Object> getListe() {
		return this._liste;
	} 
	public DataClass addUsers(Object _username, Object _age) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("username", _username);
		map.put("age", _age);
		this._users.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getUsers() {
		return this._users;
	}

	public DataClass addUsers(DataClass_Users value) {
		return addUsers(value._username, value._age);
	}

	public java.util.stream.Stream<DataClass_Users> streamUsers() {
		return this._users.stream().map(DataClass_Users::new);
	}

	public static final class DataClass_Users {

		Object _username;
		Object _age;

		public DataClass_Users(Object _username, Object _age) {
			this._username = _username;
			this._age = _age;
		}

		private DataClass_Users(java.util.Map<String, Object> map) {
			this._username = (Object) map.get("username");
			this._age = (Object) map.get("age");
		}

		public Object getUsername() {
			return this._username;
		}

		public Object getAge() {
			return this._age;
		}

	} 

	static final String st = "DataClass(isFinal,className,single,liste,users) ::= <<// This is a dataclass:\n" + 
				"\n" + 
				"~if(isFinal)~final ~endif~~className~\n" + 
				"\n" + 
				"single : ~single~\n" + 
				"\n" + 
				"list : ~liste:{it|~it~};separator=\", \"~\n" + 
				"\n" + 
				"kv : ~users:{it|~it.username~:~it.age~};separator=\"\\n\"~>> ";
} 