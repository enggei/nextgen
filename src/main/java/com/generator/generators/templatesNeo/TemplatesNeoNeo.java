package com.generator.generators.templatesNeo;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.generator.editors.domain.BaseDomainVisitor.*;

/**
 * Wraps Neo4j methods based on 'TemplatesNeo.stg' file <br/>
 * 
 */
public final class TemplatesNeoNeo {

	private final GraphDatabaseService graph;

	public enum TemplatesNeoLabels implements Label {
   	TemplatesNeo_NeoGroupClassDeclaration, TemplatesNeo_bugfix2, TemplatesNeo_declaration, TemplatesNeo_defaultNodeTypes, TemplatesNeo_keyValueListSetter, TemplatesNeo_listSetter, TemplatesNeo_newInstance, TemplatesNeo_stringSetter, TemplatesNeo, StringNode
	}

   public TemplatesNeoNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
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

   public static boolean isNeoGroupClassDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_NeoGroupClassDeclaration);
   }

   public NeoGroupClassDeclarationNode newNeoGroupClassDeclaration() {
   	return new NeoGroupClassDeclarationNode(graph);
   }

   public NeoGroupClassDeclarationNode newNeoGroupClassDeclaration(Node node) {
   	return new NeoGroupClassDeclarationNode(graph, node);
   }

   public void forEachNeoGroupClassDeclarationNodes(Consumer<NeoGroupClassDeclarationNode> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_NeoGroupClassDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NeoGroupClassDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitNeoGroupClassDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_NeoGroupClassDeclaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isBugfix2(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_bugfix2);
   }

   public bugfix2Node newBugfix2() {
   	return new bugfix2Node(graph);
   }

   public bugfix2Node newBugfix2(Node node) {
   	return new bugfix2Node(graph, node);
   }

   public void forEachBugfix2Nodes(Consumer<bugfix2Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_bugfix2).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfix2Node(graph, node));
   			}
   		});
   }

   public void visitBugfix2Nodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_bugfix2).
   		forEachRemaining(consumer);
   } 

   public static boolean isDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_declaration);
   }

   public declarationNode newDeclaration() {
   	return new declarationNode(graph);
   }

   public declarationNode newDeclaration(Node node) {
   	return new declarationNode(graph, node);
   }

   public void forEachDeclarationNodes(Consumer<declarationNode> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_declaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new declarationNode(graph, node));
   			}
   		});
   }

   public void visitDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_declaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isDefaultNodeTypes(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_defaultNodeTypes);
   }

   public defaultNodeTypesNode newDefaultNodeTypes() {
   	return new defaultNodeTypesNode(graph);
   }

   public defaultNodeTypesNode newDefaultNodeTypes(Node node) {
   	return new defaultNodeTypesNode(graph, node);
   }

   public void forEachDefaultNodeTypesNodes(Consumer<defaultNodeTypesNode> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_defaultNodeTypes).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new defaultNodeTypesNode(graph, node));
   			}
   		});
   }

   public void visitDefaultNodeTypesNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_defaultNodeTypes).
   		forEachRemaining(consumer);
   } 

   public static boolean isKeyValueListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_keyValueListSetter);
   }

   public keyValueListSetterNode newKeyValueListSetter() {
   	return new keyValueListSetterNode(graph);
   }

   public keyValueListSetterNode newKeyValueListSetter(Node node) {
   	return new keyValueListSetterNode(graph, node);
   }

   public void forEachKeyValueListSetterNodes(Consumer<keyValueListSetterNode> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_keyValueListSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new keyValueListSetterNode(graph, node));
   			}
   		});
   }

   public void visitKeyValueListSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_keyValueListSetter).
   		forEachRemaining(consumer);
   } 

   public static boolean isListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_listSetter);
   }

   public listSetterNode newListSetter() {
   	return new listSetterNode(graph);
   }

   public listSetterNode newListSetter(Node node) {
   	return new listSetterNode(graph, node);
   }

   public void forEachListSetterNodes(Consumer<listSetterNode> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_listSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new listSetterNode(graph, node));
   			}
   		});
   }

   public void visitListSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_listSetter).
   		forEachRemaining(consumer);
   } 

   public static boolean isNewInstance(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_newInstance);
   }

   public newInstanceNode newNewInstance() {
   	return new newInstanceNode(graph);
   }

   public newInstanceNode newNewInstance(Node node) {
   	return new newInstanceNode(graph, node);
   }

   public void forEachNewInstanceNodes(Consumer<newInstanceNode> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_newInstance).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new newInstanceNode(graph, node));
   			}
   		});
   }

   public void visitNewInstanceNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_newInstance).
   		forEachRemaining(consumer);
   } 

   public static boolean isStringSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesNeoLabels.TemplatesNeo_stringSetter);
   }

   public stringSetterNode newStringSetter() {
   	return new stringSetterNode(graph);
   }

   public stringSetterNode newStringSetter(Node node) {
   	return new stringSetterNode(graph, node);
   }

   public void forEachStringSetterNodes(Consumer<stringSetterNode> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_stringSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new stringSetterNode(graph, node));
   			}
   		});
   }

   public void visitStringSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesNeoLabels.TemplatesNeo_stringSetter).
   		forEachRemaining(consumer);
   } 

	public static final class NeoGroupClassDeclarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, name_param, packageName_param, statements_param
		}

		private NeoGroupClassDeclarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_NeoGroupClassDeclaration);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private NeoGroupClassDeclarationNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("NeoGroupClassDeclarationNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_NeoGroupClassDeclaration " + uuid;
		}

	   // comments
	   public NeoGroupClassDeclarationNode addCommentsValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public void forEachComments(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.comments_param))
	   		consumer.accept(other(node, relationship));
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

	   public void removePackageName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.packageName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // statements
	   public NeoGroupClassDeclarationNode addStatementsValue(Node declarationTarget, Node nameTarget, Node newInstanceTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (declarationTarget != null) 
	   		keyValueNode.createRelationshipTo(declarationTarget, RelationshipType.withName("declaration"));

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));

	   	if (newInstanceTarget != null) 
	   		keyValueNode.createRelationshipTo(newInstanceTarget, RelationshipType.withName("newInstance"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.statements_param);
	   	return this;
	   }

	   public NeoGroupClassDeclarationNode addStatementsValue(StatementsKeyValue keyValue) {
	      return addStatementsValue(keyValue.getDeclarationValue(), keyValue.getNameValue(), keyValue.getNewInstanceValue());
	   }

	   public interface StatementsKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getNameValue();

	   	public Node getNewInstanceValue();   
	   }

	   public void forEachStatementsValue(Consumer<StatementsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.statements_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new StatementsKeyValue() {

	   			@Override
	   			public Node getDeclarationValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("declaration"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("declaration")));
	   			 } 

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   			@Override
	   			public Node getNewInstanceValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("newInstance"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("newInstance")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "NeoGroupClassDeclaration_statements_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 
	} 

	public static final class bugfix2Node {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private bugfix2Node(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_bugfix2);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private bugfix2Node(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("bugfix2Node " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_bugfix2 " + uuid;
		}

	} 

	public static final class declarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, name_param, properties_param
		}

		private declarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_declaration);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private declarationNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("declarationNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_declaration " + uuid;
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

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // properties
	   public declarationNode addPropertiesValue(Node nameTarget, Node setterTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));

	   	if (setterTarget != null) 
	   		keyValueNode.createRelationshipTo(setterTarget, RelationshipType.withName("setter"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.properties_param);
	   	return this;
	   }

	   public declarationNode addPropertiesValue(PropertiesKeyValue keyValue) {
	      return addPropertiesValue(keyValue.getNameValue(), keyValue.getSetterValue());
	   }

	   public interface PropertiesKeyValue {

	   	public Node getNameValue();

	   	public Node getSetterValue();   
	   }

	   public void forEachPropertiesValue(Consumer<PropertiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new PropertiesKeyValue() {

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   			@Override
	   			public Node getSetterValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("setter"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("setter")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "declaration_properties_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 
	} 

	public static final class defaultNodeTypesNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param
		}

		private defaultNodeTypesNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_defaultNodeTypes);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private defaultNodeTypesNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("defaultNodeTypesNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_defaultNodeTypes " + uuid;
		}

	   // name
	   public defaultNodeTypesNode setName(Node target) {
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

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class keyValueListSetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			kvNames_param, propertyName_param, statementName_param
		}

		private keyValueListSetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_keyValueListSetter);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private keyValueListSetterNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("keyValueListSetterNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_keyValueListSetter " + uuid;
		}

	   // kvNames
	   public keyValueListSetterNode addKvNamesValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.kvNames_param);
	      return this;
	   }

	   public void forEachKvNames(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.kvNames_param))
	   		consumer.accept(other(node, relationship));
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

	   public void removeStatementName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statementName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class listSetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			propertyName_param, statementName_param
		}

		private listSetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_listSetter);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private listSetterNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("listSetterNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_listSetter " + uuid;
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

	   public void removeStatementName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statementName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class newInstanceNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, name_param
		}

		private newInstanceNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_newInstance);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private newInstanceNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("newInstanceNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_newInstance " + uuid;
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

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class stringSetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			propertyName_param, statementName_param
		}

		private stringSetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesNeoLabels.TemplatesNeo_stringSetter);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private stringSetterNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("stringSetterNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesNeo_stringSetter " + uuid;
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

	   public void removeStatementName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statementName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static boolean isStringNode(Node node) {
		return node != null && node.hasLabel(TemplatesNeoLabels.StringNode);
	}

	public Node newStringNode(String value) {
		if (value==null) throw new IllegalArgumentException("value for newStringNode cannot be null");
		return new StringNode(graph).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {
		if (node == null) return null;
		return new StringNode(node);
	}

	// todo turn this into an interface, like KeyValues ?
	public static final class StringNode {

		private final Node node;
		private final UUID uuid;

		public StringNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesNeoLabels.StringNode);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public StringNode(final Node node) {
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
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
			StringNode that = (StringNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getValue();
		}

		// propertyName
		public StringNode setValue(String value) {
			if (node == null) return this;
			node.setProperty("value", value);
			return this;
		}

		public String getValue() {
			return getString(node, "value");
		}
	} 
} 