package nextgen.templates.neo4j;

public class DeleteNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _refs = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _refList = new java.util.ArrayList<>();

	DeleteNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("deleteNode");
		for (java.util.Map<String, Object> map : _refs) st.addAggr("refs.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _refList) st.addAggr("refList.{name}", map.get("name"));
		return st.render().trim();
	}



	public DeleteNode addRefs(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._refs.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRefs() {
		return this._refs;
	}

	public DeleteNode addRefs(DeleteNode_Refs value) {
		return addRefs(value._type, value._name);
	}

	public java.util.stream.Stream<DeleteNode_Refs> streamRefs() {
		return this._refs.stream().map(DeleteNode_Refs::new);
	}

	public static final class DeleteNode_Refs {

		Object _type;
		Object _name;

		public DeleteNode_Refs(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private DeleteNode_Refs(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	} 

	public DeleteNode addRefList(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._refList.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRefList() {
		return this._refList;
	}

	public DeleteNode addRefList(DeleteNode_RefList value) {
		return addRefList(value._name);
	}

	public java.util.stream.Stream<DeleteNode_RefList> streamRefList() {
		return this._refList.stream().map(DeleteNode_RefList::new);
	}

	public static final class DeleteNode_RefList {

		Object _name;

		public DeleteNode_RefList(Object _name) {
			this._name = _name;
		}

		private DeleteNode_RefList(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DeleteNode that = (DeleteNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "deleteNode(refs,refList) ::= <<public void deleteTree() {\n" + 
				"~refs:{it|\n" + 
				"	final ~it.type~ _~it.name~ = get~it.name;format=\"capitalize\"~();\n" + 
				"	if (_~it.name~ != null) _~it.name~.deleteTree();\n" + 
				"};separator=\"\\n\"~\n" + 
				"~refList:{it|\n" + 
				"	get~it.name;format=\"capitalize\"~().forEach(element -> element.deleteTree());\n" + 
				"};separator=\"\\n\"~\n" + 
				"	node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	node.delete();\n" + 
				"} >>";
} 