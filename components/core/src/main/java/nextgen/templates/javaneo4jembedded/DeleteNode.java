package nextgen.templates.javaneo4jembedded;

public class DeleteNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _deleteStatements = new java.util.ArrayList<>();

	DeleteNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("deleteNode");
		for (Object o : _deleteStatements) st.add("deleteStatements", o);
		return st.render().trim();
	}


	public DeleteNode addDeleteStatements(Object value) {
		this._deleteStatements.add(value);
		return this;
	}

	public DeleteNode setDeleteStatements(Object[] value) {
		this._deleteStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DeleteNode setDeleteStatements(java.util.Collection<Object> values) {
		this._deleteStatements.addAll(values);
		return this;
	}

	public DeleteNode removeDeleteStatements(Object value) {
		this._deleteStatements.remove(value);
		return this;
	}

	public DeleteNode removeDeleteStatements(int index) {
		this._deleteStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getDeleteStatements() {
		return this._deleteStatements;
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

	static final String st = "deleteNode(deleteStatements) ::= <<public void delete() {\n" + 
				"\n" + 
				"	final String uuid = node.hasProperty(\"uuid\") ? node.getProperty(\"uuid\").toString() : null;\n" + 
				"\n" + 
				"	node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	node.delete();\n" + 
				"\n" + 
				"	~deleteStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  