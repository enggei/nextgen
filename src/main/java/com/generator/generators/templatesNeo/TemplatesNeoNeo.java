package com.generator.generators.templatesNeo;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.templatesNeo.TemplatesNeoNeo.TemplatesNeoLabels.*;

/**
 * Wraps Neo4j methods based on 'TemplatesNeo.stg' file <br/>
 * 
 * todo: refactor to static methods (no need for node-encapsulation, just let clients get the NeoNodes, but static treatment of each node as a specific type
 */
public final class TemplatesNeoNeo {

	private final GraphDatabaseService graph;

	public enum TemplatesNeoLabels implements Label {
		TemplatesNeo,   	
		TemplatesNeo_NeoGroupClassDeclaration,
		TemplatesNeo_bugfix2,
		TemplatesNeo_declaration,
		TemplatesNeo_defaultNodeTypes,
		TemplatesNeo_keyValueListInterfaceDecl,
		TemplatesNeo_keyValueListSetter,
		TemplatesNeo_keyValueRelationships,
		TemplatesNeo_keyValueVisitor,
		TemplatesNeo_listInterfaceDecl,
		TemplatesNeo_listSetter,
		TemplatesNeo_listVisitor,
		TemplatesNeo_newInstance,
		TemplatesNeo_stringInterfaceDecl,
		TemplatesNeo_stringSetter,
		TemplatesNeo_stringVisitor, 
		StringNode
	}

   public TemplatesNeoNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isNeoGroupClassDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_NeoGroupClassDeclaration);
   }

   public static NeoGroupClassDeclarationNode newNeoGroupClassDeclaration(Node node) {
   	return new NeoGroupClassDeclarationNode(node);
   }

   public NeoGroupClassDeclarationNode newNeoGroupClassDeclaration() {
   	return new NeoGroupClassDeclarationNode(graph);
   }

   public ResourceIterator<NeoGroupClassDeclarationNode> findAllNeoGroupClassDeclaration() { 
   	return graph.findNodes(TemplatesNeo_NeoGroupClassDeclaration).map(TemplatesNeoNeo::newNeoGroupClassDeclaration);
   } 

   public static boolean isBugfix2(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_bugfix2);
   }

   public static bugfix2Node newBugfix2(Node node) {
   	return new bugfix2Node(node);
   }

   public bugfix2Node newBugfix2() {
   	return new bugfix2Node(graph);
   }

   public ResourceIterator<bugfix2Node> findAllBugfix2() { 
   	return graph.findNodes(TemplatesNeo_bugfix2).map(TemplatesNeoNeo::newBugfix2);
   } 

   public static boolean isDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_declaration);
   }

   public static declarationNode newDeclaration(Node node) {
   	return new declarationNode(node);
   }

   public declarationNode newDeclaration() {
   	return new declarationNode(graph);
   }

   public ResourceIterator<declarationNode> findAllDeclaration() { 
   	return graph.findNodes(TemplatesNeo_declaration).map(TemplatesNeoNeo::newDeclaration);
   } 

   public static boolean isDefaultNodeTypes(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_defaultNodeTypes);
   }

   public static defaultNodeTypesNode newDefaultNodeTypes(Node node) {
   	return new defaultNodeTypesNode(node);
   }

   public defaultNodeTypesNode newDefaultNodeTypes() {
   	return new defaultNodeTypesNode(graph);
   }

   public ResourceIterator<defaultNodeTypesNode> findAllDefaultNodeTypes() { 
   	return graph.findNodes(TemplatesNeo_defaultNodeTypes).map(TemplatesNeoNeo::newDefaultNodeTypes);
   } 

   public static boolean isKeyValueListInterfaceDecl(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_keyValueListInterfaceDecl);
   }

   public static keyValueListInterfaceDeclNode newKeyValueListInterfaceDecl(Node node) {
   	return new keyValueListInterfaceDeclNode(node);
   }

   public keyValueListInterfaceDeclNode newKeyValueListInterfaceDecl() {
   	return new keyValueListInterfaceDeclNode(graph);
   }

   public ResourceIterator<keyValueListInterfaceDeclNode> findAllKeyValueListInterfaceDecl() { 
   	return graph.findNodes(TemplatesNeo_keyValueListInterfaceDecl).map(TemplatesNeoNeo::newKeyValueListInterfaceDecl);
   } 

   public static boolean isKeyValueListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_keyValueListSetter);
   }

   public static keyValueListSetterNode newKeyValueListSetter(Node node) {
   	return new keyValueListSetterNode(node);
   }

   public keyValueListSetterNode newKeyValueListSetter() {
   	return new keyValueListSetterNode(graph);
   }

   public ResourceIterator<keyValueListSetterNode> findAllKeyValueListSetter() { 
   	return graph.findNodes(TemplatesNeo_keyValueListSetter).map(TemplatesNeoNeo::newKeyValueListSetter);
   } 

   public static boolean isKeyValueRelationships(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_keyValueRelationships);
   }

   public static keyValueRelationshipsNode newKeyValueRelationships(Node node) {
   	return new keyValueRelationshipsNode(node);
   }

   public keyValueRelationshipsNode newKeyValueRelationships() {
   	return new keyValueRelationshipsNode(graph);
   }

   public ResourceIterator<keyValueRelationshipsNode> findAllKeyValueRelationships() { 
   	return graph.findNodes(TemplatesNeo_keyValueRelationships).map(TemplatesNeoNeo::newKeyValueRelationships);
   } 

   public static boolean isKeyValueVisitor(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_keyValueVisitor);
   }

   public static keyValueVisitorNode newKeyValueVisitor(Node node) {
   	return new keyValueVisitorNode(node);
   }

   public keyValueVisitorNode newKeyValueVisitor() {
   	return new keyValueVisitorNode(graph);
   }

   public ResourceIterator<keyValueVisitorNode> findAllKeyValueVisitor() { 
   	return graph.findNodes(TemplatesNeo_keyValueVisitor).map(TemplatesNeoNeo::newKeyValueVisitor);
   } 

   public static boolean isListInterfaceDecl(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_listInterfaceDecl);
   }

   public static listInterfaceDeclNode newListInterfaceDecl(Node node) {
   	return new listInterfaceDeclNode(node);
   }

   public listInterfaceDeclNode newListInterfaceDecl() {
   	return new listInterfaceDeclNode(graph);
   }

   public ResourceIterator<listInterfaceDeclNode> findAllListInterfaceDecl() { 
   	return graph.findNodes(TemplatesNeo_listInterfaceDecl).map(TemplatesNeoNeo::newListInterfaceDecl);
   } 

   public static boolean isListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_listSetter);
   }

   public static listSetterNode newListSetter(Node node) {
   	return new listSetterNode(node);
   }

   public listSetterNode newListSetter() {
   	return new listSetterNode(graph);
   }

   public ResourceIterator<listSetterNode> findAllListSetter() { 
   	return graph.findNodes(TemplatesNeo_listSetter).map(TemplatesNeoNeo::newListSetter);
   } 

   public static boolean isListVisitor(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_listVisitor);
   }

   public static listVisitorNode newListVisitor(Node node) {
   	return new listVisitorNode(node);
   }

   public listVisitorNode newListVisitor() {
   	return new listVisitorNode(graph);
   }

   public ResourceIterator<listVisitorNode> findAllListVisitor() { 
   	return graph.findNodes(TemplatesNeo_listVisitor).map(TemplatesNeoNeo::newListVisitor);
   } 

   public static boolean isNewInstance(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_newInstance);
   }

   public static newInstanceNode newNewInstance(Node node) {
   	return new newInstanceNode(node);
   }

   public newInstanceNode newNewInstance() {
   	return new newInstanceNode(graph);
   }

   public ResourceIterator<newInstanceNode> findAllNewInstance() { 
   	return graph.findNodes(TemplatesNeo_newInstance).map(TemplatesNeoNeo::newNewInstance);
   } 

   public static boolean isStringInterfaceDecl(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_stringInterfaceDecl);
   }

   public static stringInterfaceDeclNode newStringInterfaceDecl(Node node) {
   	return new stringInterfaceDeclNode(node);
   }

   public stringInterfaceDeclNode newStringInterfaceDecl() {
   	return new stringInterfaceDeclNode(graph);
   }

   public ResourceIterator<stringInterfaceDeclNode> findAllStringInterfaceDecl() { 
   	return graph.findNodes(TemplatesNeo_stringInterfaceDecl).map(TemplatesNeoNeo::newStringInterfaceDecl);
   } 

   public static boolean isStringSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_stringSetter);
   }

   public static stringSetterNode newStringSetter(Node node) {
   	return new stringSetterNode(node);
   }

   public stringSetterNode newStringSetter() {
   	return new stringSetterNode(graph);
   }

   public ResourceIterator<stringSetterNode> findAllStringSetter() { 
   	return graph.findNodes(TemplatesNeo_stringSetter).map(TemplatesNeoNeo::newStringSetter);
   } 

   public static boolean isStringVisitor(Node node) {
   	return node != null && node.hasLabel(TemplatesNeo_stringVisitor);
   }

   public static stringVisitorNode newStringVisitor(Node node) {
   	return new stringVisitorNode(node);
   }

   public stringVisitorNode newStringVisitor() {
   	return new stringVisitorNode(graph);
   }

   public ResourceIterator<stringVisitorNode> findAllStringVisitor() { 
   	return graph.findNodes(TemplatesNeo_stringVisitor).map(TemplatesNeoNeo::newStringVisitor);
   } 

	public static final class NeoGroupClassDeclarationNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			comments_param, name_param, packageName_param, statements_param
		}

		private enum StatementsRelationships implements RelationshipType {
			declaration, name, newInstance
		} 

		private enum KeyValueLabels implements Label {
			Statements, 
		}

		private NeoGroupClassDeclarationNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_NeoGroupClassDeclaration);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private NeoGroupClassDeclarationNode(final Node node) {
			// assuming node has label TemplatesNeo_NeoGroupClassDeclaration
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			NeoGroupClassDeclarationNode that = (NeoGroupClassDeclarationNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // comments
	   public NeoGroupClassDeclarationNode addCommentsValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.comments_param)) return this;
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public void forEachComments(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.comments_param))
	   		consumer.accept(other(node, relationship));
	   }

	   public void forEachCommentsRelation(Consumer<Relationship> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.comments_param))
	   		consumer.accept(relationship);
	   } 

	   // name
	   public NeoGroupClassDeclarationNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // packageName
	   public NeoGroupClassDeclarationNode setPackageName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.packageName_param))
	   		singleOutgoing(node, Parameters.packageName_param).delete();
	   	node.createRelationshipTo(target, Parameters.packageName_param);
	      return this;
	   }

	   public Node getPackageName() {
	   	if (!hasOutgoing(node, Parameters.packageName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.packageName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getPackageNameRelation() {
	   	if (!hasOutgoing(node, Parameters.packageName_param)) return null;
	   	return singleOutgoing(node, Parameters.packageName_param);
	   }

	   public void removePackageName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.packageName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   public interface StatementsKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getNameValue();

	   	public Node getNewInstanceValue();

	   	public StatementsKeyValue setDeclarationValue(Node value);

	   	public StatementsKeyValue setNameValue(Node value);

	   	public StatementsKeyValue setNewInstanceValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public NeoGroupClassDeclarationNode addStatementsValue(StatementsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.statements_param);
	      return this;
	   }

	   public StatementsKeyValue newStatementsKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Statements);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newStatementsKeyValue(node);
	   }

	   public static StatementsKeyValue newStatementsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newStatementsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new StatementsKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, StatementsRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, StatementsRelationships.declaration));
	   		} 

	   		@Override
	   		public StatementsKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, StatementsRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, StatementsRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, StatementsRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, StatementsRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, StatementsRelationships.name));
	   		} 

	   		@Override
	   		public StatementsKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, StatementsRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, StatementsRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, StatementsRelationships.name);

	   			return this;
	   		} 

	   		@Override
	   		public Node getNewInstanceValue() {
	   			if (!hasOutgoing(node, StatementsRelationships.newInstance)) return null;
	   			return other(node, singleOutgoing(node, StatementsRelationships.newInstance));
	   		} 

	   		@Override
	   		public StatementsKeyValue setNewInstanceValue(Node value) {
	   			if (hasOutgoing(node, StatementsRelationships.newInstance)) {
	   				final Relationship outgoing = singleOutgoing(node, StatementsRelationships.newInstance);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, StatementsRelationships.newInstance);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachStatementsValue(Consumer<StatementsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.statements_param)) {
	   		consumer.accept(newStatementsKeyValue(other(node, relationship)));
	   	}
	   } 

		public interface NeoGroupClassDeclarationNodeVisitor<T> {

			T visit(NeoGroupClassDeclarationNode node);	

		}

		public <T> T visit(NeoGroupClassDeclarationNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class bugfix2Node {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		private bugfix2Node(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_bugfix2);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private bugfix2Node(final Node node) {
			// assuming node has label TemplatesNeo_bugfix2
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			bugfix2Node that = (bugfix2Node) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}


		public interface bugfix2NodeVisitor<T> {

			T visit(bugfix2Node node);	

		}

		public <T> T visit(bugfix2NodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class declarationNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param, properties_param
		}

		private enum PropertiesRelationships implements RelationshipType {
			name, relationships, setter
		} 

		private enum KeyValueLabels implements Label {
			Properties, 
		}

		private declarationNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_declaration);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private declarationNode(final Node node) {
			// assuming node has label TemplatesNeo_declaration
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			declarationNode that = (declarationNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // groupName
	   public declarationNode setGroupName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.groupName_param))
	   		singleOutgoing(node, Parameters.groupName_param).delete();
	   	node.createRelationshipTo(target, Parameters.groupName_param);
	      return this;
	   }

	   public Node getGroupName() {
	   	if (!hasOutgoing(node, Parameters.groupName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.groupName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getGroupNameRelation() {
	   	if (!hasOutgoing(node, Parameters.groupName_param)) return null;
	   	return singleOutgoing(node, Parameters.groupName_param);
	   }

	   public void removeGroupName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.groupName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public declarationNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   public interface PropertiesKeyValue {

	   	public Node getNameValue();

	   	public Node getRelationshipsValue();

	   	public Node getSetterValue();

	   	public PropertiesKeyValue setNameValue(Node value);

	   	public PropertiesKeyValue setRelationshipsValue(Node value);

	   	public PropertiesKeyValue setSetterValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public declarationNode addPropertiesValue(PropertiesKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.properties_param);
	      return this;
	   }

	   public PropertiesKeyValue newPropertiesKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Properties);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newPropertiesKeyValue(node);
	   }

	   public static PropertiesKeyValue newPropertiesKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newPropertiesKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new PropertiesKeyValue() {

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, PropertiesRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, PropertiesRelationships.name));
	   		} 

	   		@Override
	   		public PropertiesKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, PropertiesRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, PropertiesRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, PropertiesRelationships.name);

	   			return this;
	   		} 

	   		@Override
	   		public Node getRelationshipsValue() {
	   			if (!hasOutgoing(node, PropertiesRelationships.relationships)) return null;
	   			return other(node, singleOutgoing(node, PropertiesRelationships.relationships));
	   		} 

	   		@Override
	   		public PropertiesKeyValue setRelationshipsValue(Node value) {
	   			if (hasOutgoing(node, PropertiesRelationships.relationships)) {
	   				final Relationship outgoing = singleOutgoing(node, PropertiesRelationships.relationships);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, PropertiesRelationships.relationships);

	   			return this;
	   		} 

	   		@Override
	   		public Node getSetterValue() {
	   			if (!hasOutgoing(node, PropertiesRelationships.setter)) return null;
	   			return other(node, singleOutgoing(node, PropertiesRelationships.setter));
	   		} 

	   		@Override
	   		public PropertiesKeyValue setSetterValue(Node value) {
	   			if (hasOutgoing(node, PropertiesRelationships.setter)) {
	   				final Relationship outgoing = singleOutgoing(node, PropertiesRelationships.setter);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, PropertiesRelationships.setter);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachPropertiesValue(Consumer<PropertiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param)) {
	   		consumer.accept(newPropertiesKeyValue(other(node, relationship)));
	   	}
	   } 

		public interface declarationNodeVisitor<T> {

			T visit(declarationNode node);	

		}

		public <T> T visit(declarationNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class defaultNodeTypesNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		private defaultNodeTypesNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_defaultNodeTypes);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private defaultNodeTypesNode(final Node node) {
			// assuming node has label TemplatesNeo_defaultNodeTypes
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			defaultNodeTypesNode that = (defaultNodeTypesNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}


		public interface defaultNodeTypesNodeVisitor<T> {

			T visit(defaultNodeTypesNode node);	

		}

		public <T> T visit(defaultNodeTypesNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class keyValueListInterfaceDeclNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private keyValueListInterfaceDeclNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_keyValueListInterfaceDecl);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private keyValueListInterfaceDeclNode(final Node node) {
			// assuming node has label TemplatesNeo_keyValueListInterfaceDecl
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			keyValueListInterfaceDeclNode that = (keyValueListInterfaceDeclNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public keyValueListInterfaceDeclNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface keyValueListInterfaceDeclNodeVisitor<T> {

			T visit(keyValueListInterfaceDeclNode node);	

		}

		public <T> T visit(keyValueListInterfaceDeclNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class keyValueListSetterNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			kvNames_param, propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private keyValueListSetterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_keyValueListSetter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private keyValueListSetterNode(final Node node) {
			// assuming node has label TemplatesNeo_keyValueListSetter
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			keyValueListSetterNode that = (keyValueListSetterNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // kvNames
	   public keyValueListSetterNode addKvNamesValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.kvNames_param)) return this;
	   	node.createRelationshipTo(target, Parameters.kvNames_param);
	      return this;
	   }

	   public void forEachKvNames(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.kvNames_param))
	   		consumer.accept(other(node, relationship));
	   }

	   public void forEachKvNamesRelation(Consumer<Relationship> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.kvNames_param))
	   		consumer.accept(relationship);
	   } 

	   // propertyName
	   public keyValueListSetterNode setPropertyName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.propertyName_param))
	   		singleOutgoing(node, Parameters.propertyName_param).delete();
	   	node.createRelationshipTo(target, Parameters.propertyName_param);
	      return this;
	   }

	   public Node getPropertyName() {
	   	if (!hasOutgoing(node, Parameters.propertyName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.propertyName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getPropertyNameRelation() {
	   	if (!hasOutgoing(node, Parameters.propertyName_param)) return null;
	   	return singleOutgoing(node, Parameters.propertyName_param);
	   }

	   public void removePropertyName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.propertyName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // statementName
	   public keyValueListSetterNode setStatementName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.statementName_param))
	   		singleOutgoing(node, Parameters.statementName_param).delete();
	   	node.createRelationshipTo(target, Parameters.statementName_param);
	      return this;
	   }

	   public Node getStatementName() {
	   	if (!hasOutgoing(node, Parameters.statementName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.statementName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getStatementNameRelation() {
	   	if (!hasOutgoing(node, Parameters.statementName_param)) return null;
	   	return singleOutgoing(node, Parameters.statementName_param);
	   }

	   public void removeStatementName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statementName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface keyValueListSetterNodeVisitor<T> {

			T visit(keyValueListSetterNode node);	

		}

		public <T> T visit(keyValueListSetterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class keyValueRelationshipsNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param, types_param
		}


		private enum KeyValueLabels implements Label {
		}

		private keyValueRelationshipsNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_keyValueRelationships);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private keyValueRelationshipsNode(final Node node) {
			// assuming node has label TemplatesNeo_keyValueRelationships
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			keyValueRelationshipsNode that = (keyValueRelationshipsNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public keyValueRelationshipsNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // types
	   public keyValueRelationshipsNode addTypesValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.types_param)) return this;
	   	node.createRelationshipTo(target, Parameters.types_param);
	      return this;
	   }

	   public void forEachTypes(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.types_param))
	   		consumer.accept(other(node, relationship));
	   }

	   public void forEachTypesRelation(Consumer<Relationship> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.types_param))
	   		consumer.accept(relationship);
	   } 

		public interface keyValueRelationshipsNodeVisitor<T> {

			T visit(keyValueRelationshipsNode node);	

		}

		public <T> T visit(keyValueRelationshipsNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class keyValueVisitorNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private keyValueVisitorNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_keyValueVisitor);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private keyValueVisitorNode(final Node node) {
			// assuming node has label TemplatesNeo_keyValueVisitor
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			keyValueVisitorNode that = (keyValueVisitorNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public keyValueVisitorNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface keyValueVisitorNodeVisitor<T> {

			T visit(keyValueVisitorNode node);	

		}

		public <T> T visit(keyValueVisitorNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class listInterfaceDeclNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private listInterfaceDeclNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_listInterfaceDecl);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private listInterfaceDeclNode(final Node node) {
			// assuming node has label TemplatesNeo_listInterfaceDecl
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			listInterfaceDeclNode that = (listInterfaceDeclNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public listInterfaceDeclNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface listInterfaceDeclNodeVisitor<T> {

			T visit(listInterfaceDeclNode node);	

		}

		public <T> T visit(listInterfaceDeclNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class listSetterNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private listSetterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_listSetter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private listSetterNode(final Node node) {
			// assuming node has label TemplatesNeo_listSetter
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			listSetterNode that = (listSetterNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // propertyName
	   public listSetterNode setPropertyName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.propertyName_param))
	   		singleOutgoing(node, Parameters.propertyName_param).delete();
	   	node.createRelationshipTo(target, Parameters.propertyName_param);
	      return this;
	   }

	   public Node getPropertyName() {
	   	if (!hasOutgoing(node, Parameters.propertyName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.propertyName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getPropertyNameRelation() {
	   	if (!hasOutgoing(node, Parameters.propertyName_param)) return null;
	   	return singleOutgoing(node, Parameters.propertyName_param);
	   }

	   public void removePropertyName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.propertyName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // statementName
	   public listSetterNode setStatementName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.statementName_param))
	   		singleOutgoing(node, Parameters.statementName_param).delete();
	   	node.createRelationshipTo(target, Parameters.statementName_param);
	      return this;
	   }

	   public Node getStatementName() {
	   	if (!hasOutgoing(node, Parameters.statementName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.statementName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getStatementNameRelation() {
	   	if (!hasOutgoing(node, Parameters.statementName_param)) return null;
	   	return singleOutgoing(node, Parameters.statementName_param);
	   }

	   public void removeStatementName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statementName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface listSetterNodeVisitor<T> {

			T visit(listSetterNode node);	

		}

		public <T> T visit(listSetterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class listVisitorNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private listVisitorNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_listVisitor);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private listVisitorNode(final Node node) {
			// assuming node has label TemplatesNeo_listVisitor
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			listVisitorNode that = (listVisitorNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public listVisitorNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface listVisitorNodeVisitor<T> {

			T visit(listVisitorNode node);	

		}

		public <T> T visit(listVisitorNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class newInstanceNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private newInstanceNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_newInstance);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private newInstanceNode(final Node node) {
			// assuming node has label TemplatesNeo_newInstance
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			newInstanceNode that = (newInstanceNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // groupName
	   public newInstanceNode setGroupName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.groupName_param))
	   		singleOutgoing(node, Parameters.groupName_param).delete();
	   	node.createRelationshipTo(target, Parameters.groupName_param);
	      return this;
	   }

	   public Node getGroupName() {
	   	if (!hasOutgoing(node, Parameters.groupName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.groupName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getGroupNameRelation() {
	   	if (!hasOutgoing(node, Parameters.groupName_param)) return null;
	   	return singleOutgoing(node, Parameters.groupName_param);
	   }

	   public void removeGroupName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.groupName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public newInstanceNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface newInstanceNodeVisitor<T> {

			T visit(newInstanceNode node);	

		}

		public <T> T visit(newInstanceNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class stringInterfaceDeclNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private stringInterfaceDeclNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_stringInterfaceDecl);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private stringInterfaceDeclNode(final Node node) {
			// assuming node has label TemplatesNeo_stringInterfaceDecl
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			stringInterfaceDeclNode that = (stringInterfaceDeclNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public stringInterfaceDeclNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface stringInterfaceDeclNodeVisitor<T> {

			T visit(stringInterfaceDeclNode node);	

		}

		public <T> T visit(stringInterfaceDeclNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class stringSetterNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private stringSetterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_stringSetter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private stringSetterNode(final Node node) {
			// assuming node has label TemplatesNeo_stringSetter
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			stringSetterNode that = (stringSetterNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // propertyName
	   public stringSetterNode setPropertyName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.propertyName_param))
	   		singleOutgoing(node, Parameters.propertyName_param).delete();
	   	node.createRelationshipTo(target, Parameters.propertyName_param);
	      return this;
	   }

	   public Node getPropertyName() {
	   	if (!hasOutgoing(node, Parameters.propertyName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.propertyName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getPropertyNameRelation() {
	   	if (!hasOutgoing(node, Parameters.propertyName_param)) return null;
	   	return singleOutgoing(node, Parameters.propertyName_param);
	   }

	   public void removePropertyName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.propertyName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // statementName
	   public stringSetterNode setStatementName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.statementName_param))
	   		singleOutgoing(node, Parameters.statementName_param).delete();
	   	node.createRelationshipTo(target, Parameters.statementName_param);
	      return this;
	   }

	   public Node getStatementName() {
	   	if (!hasOutgoing(node, Parameters.statementName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.statementName_param);
	   	return other(node, relationship);
	   }

	   public Relationship getStatementNameRelation() {
	   	if (!hasOutgoing(node, Parameters.statementName_param)) return null;
	   	return singleOutgoing(node, Parameters.statementName_param);
	   }

	   public void removeStatementName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statementName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface stringSetterNodeVisitor<T> {

			T visit(stringSetterNode node);	

		}

		public <T> T visit(stringSetterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class stringVisitorNode {

		// TemplatesNeo
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private stringVisitorNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeo_stringVisitor);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private stringVisitorNode(final Node node) {
			// assuming node has label TemplatesNeo_stringVisitor
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			stringVisitorNode that = (stringVisitorNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public stringVisitorNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public Relationship getNameRelation() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	return singleOutgoing(node, Parameters.name_param);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface stringVisitorNodeVisitor<T> {

			T visit(stringVisitorNode node);	

		}

		public <T> T visit(stringVisitorNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public interface TemplatesNeoNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(TemplatesNeoNeoAction committer) {
		try (Transaction tx = graph.beginTx()) {
			try {
				committer.doAction(tx);
				tx.success();
			} catch (Throwable throwable) {
				committer.exception(throwable);
				tx.failure();
			}
		}
	}

	public static boolean isStringNode(Node node) {
		return node != null && node.hasLabel(StringNode);
	}

	// convenience-method for instantiating a new StringNode, and setting the value
	public Node newStringNode(String value) {
		if (value==null) throw new IllegalArgumentException("value for newStringNode cannot be null");

		final Node node = graph.createNode(StringNode);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		return newStringNode(node).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {

		//if (node==null) throw new IllegalArgumentException("node for newStringNode cannot be null");
		if (node==null) return null;

		final UUID uuid = UUID.fromString(getString(node, "_uuid"));

		return new StringNode() {
			@Override
			public StringNode setValue(String value) {
				node.setProperty("value", value);
				return this;
			}

			@Override
			public String getValue() {
				return getString(node, "value");
			}

			@Override
			public Node node() {
				return node;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				StringNode that = (StringNode) o;
				return uuid.equals(that.getUuid());
			}

			@Override
			public int hashCode() {
				return uuid.hashCode();
			}

			@Override
			public String toString() {
				return getValue();
			}	
		};
	}

	public interface StringNode {

		public StringNode setValue(String value);

		public String getValue();

		public Node node();

		public UUID getUuid();
	} 
} 