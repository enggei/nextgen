package nextgen.model;

public class STGroupModel {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public STGroupModel(org.neo4j.graphdb.Node node) { 
		this.node = node;
		if (!node.hasProperty("uuid")) this.node.setProperty("uuid", this.uuid = java.util.UUID.randomUUID().toString());
		else this.uuid = node.getProperty("uuid").toString();}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}


	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGroupModel other = (STGroupModel) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public STGroupModel setUuid(String value) { 
		if (value == null) {
			removeUuid(); 
		} else {
			node.setProperty(_uuid, value);
		}
		return this;
	}

	public String getUuid() { 
		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);
		return null;
	}

	public String getUuid(String defaultValue) { 
		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);
		return defaultValue;
	}

	public boolean hasUuid() { 
		return node.hasProperty(_uuid);
	}

	public STGroupModel removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	public static final String _language = "language";

	public STGroupModel setLanguage(String value) { 
		if (value == null) {
			removeLanguage(); 
		} else {
		 	node.setProperty(_language, value);
		}
		return this;
	}

	public String getLanguage() { 
		if (node.hasProperty(_language)) return (String) node.getProperty(_language);
		return null;
	}

	public String getLanguage(String defaultValue) { 
		if (node.hasProperty(_language)) return (String) node.getProperty(_language);
		return defaultValue;
	}

	public boolean hasLanguage() { 
		return node.hasProperty(_language);
	}

	public STGroupModel removeLanguage() { 
		node.removeProperty(_language);
		return this;
	}  

	public static final String _name = "name";

	public STGroupModel setName(String value) { 
		if (value == null) {
			removeName(); 
		} else {
		 	node.setProperty(_name, value);
		}
		return this;
	}

	public String getName() { 
		if (node.hasProperty(_name)) return (String) node.getProperty(_name);
		return null;
	}

	public String getName(String defaultValue) { 
		if (node.hasProperty(_name)) return (String) node.getProperty(_name);
		return defaultValue;
	}

	public boolean hasName() { 
		return node.hasProperty(_name);
	}

	public STGroupModel removeName() { 
		node.removeProperty(_name);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _files = org.neo4j.graphdb.RelationshipType.withName("files");

	public STGroupModel addFiles(STGroupFile dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _files);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STGroupFile> getFiles() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).map((relationship) -> new STGroupFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STGroupFile> getFilesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STGroupFile(relationship.getOtherNode(node)));
	}

	public STGroupModel removeFiles(STGroupFile dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STGroupModel removeAllFiles() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _templates = org.neo4j.graphdb.RelationshipType.withName("templates");

	public STGroupModel addTemplates(STTemplate dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _templates);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STTemplate> getTemplates() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STTemplate> getTemplatesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}

	public STGroupModel removeTemplates(STTemplate dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STGroupModel removeAllTemplates() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _interfaces = org.neo4j.graphdb.RelationshipType.withName("interfaces");

	public STGroupModel addInterfaces(STInterface dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _interfaces).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _interfaces);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STInterface> getInterfaces() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _interfaces).spliterator(), false).map((relationship) -> new STInterface(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STInterface> getInterfacesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _interfaces).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STInterface(relationship.getOtherNode(node)));
	}

	public STGroupModel removeInterfaces(STInterface dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _interfaces).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STGroupModel removeAllInterfaces() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _interfaces).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _enums = org.neo4j.graphdb.RelationshipType.withName("enums");

	public STGroupModel addEnums(STEnum dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _enums).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _enums);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STEnum> getEnums() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _enums).spliterator(), false).map((relationship) -> new STEnum(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STEnum> getEnumsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _enums).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STEnum(relationship.getOtherNode(node)));
	}

	public STGroupModel removeEnums(STEnum dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _enums).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STGroupModel removeAllEnums() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _enums).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _actions = org.neo4j.graphdb.RelationshipType.withName("actions");

	public STGroupModel addActions(STGroupAction dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _actions).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _actions);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STGroupAction> getActions() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _actions).spliterator(), false).map((relationship) -> new STGroupAction(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STGroupAction> getActionsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _actions).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STGroupAction(relationship.getOtherNode(node)));
	}

	public STGroupModel removeActions(STGroupAction dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _actions).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STGroupModel removeAllActions() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _actions).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final String _delimiter = "delimiter";

	public STGroupModel setDelimiter(String value) { 
		if (value == null) {
			removeDelimiter(); 
		} else {
		 	node.setProperty(_delimiter, value);
		}
		return this;
	}

	public String getDelimiter() { 
		if (node.hasProperty(_delimiter)) return (String) node.getProperty(_delimiter);
		return null;
	}

	public String getDelimiter(String defaultValue) { 
		if (node.hasProperty(_delimiter)) return (String) node.getProperty(_delimiter);
		return defaultValue;
	}

	public boolean hasDelimiter() { 
		return node.hasProperty(_delimiter);
	}

	public STGroupModel removeDelimiter() { 
		node.removeProperty(_delimiter);
		return this;
	}  

	public static final String _icon = "icon";

	public STGroupModel setIcon(String value) { 
		if (value == null) {
			removeIcon(); 
		} else {
		 	node.setProperty(_icon, value);
		}
		return this;
	}

	public String getIcon() { 
		if (node.hasProperty(_icon)) return (String) node.getProperty(_icon);
		return null;
	}

	public String getIcon(String defaultValue) { 
		if (node.hasProperty(_icon)) return (String) node.getProperty(_icon);
		return defaultValue;
	}

	public boolean hasIcon() { 
		return node.hasProperty(_icon);
	}

	public STGroupModel removeIcon() { 
		node.removeProperty(_icon);
		return this;
	}  

	@Override
	public String toString() {
		final StringBuilder out = new StringBuilder();
		out.append("Node : ").append(node.getId()).append(" ");
		node.getLabels().forEach(label -> out.append(label.name()).append(" "));
		out.append("(");
		node.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(node.getProperty(s)));
		out.append(")");
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(relationship -> {
			out.append("\n\t -> ").append(relationship.getType()).append(" (");
			relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
			out.append(")");
		});
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> {
			out.append("\n\t <- ").append(relationship.getType()).append(" (");
			relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
			out.append(")");
		});
		return out.toString().trim();
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();	
	}


}  