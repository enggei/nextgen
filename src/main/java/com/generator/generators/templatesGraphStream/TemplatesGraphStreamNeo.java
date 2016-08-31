package com.generator.generators.templatesGraphStream;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.domain.BaseDomainVisitor.*;
import static com.generator.generators.templatesGraphStream.TemplatesGraphStreamNeo.TemplatesGraphStreamLabels.*;

/**
 * Wraps Neo4j methods based on 'TemplatesGraphStream.stg' file <br/>
 * 
 */
public final class TemplatesGraphStreamNeo {

	private final GraphDatabaseService graph;

	public enum TemplatesGraphStreamLabels implements Label {
		TemplatesGraphStream,   	
		TemplatesGraphStream_GroupClassDeclaration,
		TemplatesGraphStream_bugfix2,
		TemplatesGraphStream_declaration,
		TemplatesGraphStream_defaultNodeTypes,
		TemplatesGraphStream_keyValueListSetter,
		TemplatesGraphStream_keyValueRelationships,
		TemplatesGraphStream_listSetter,
		TemplatesGraphStream_newInstance,
		TemplatesGraphStream_stringSetter, 
		StringNode
	}

   public TemplatesGraphStreamNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

	public interface TemplatesGraphStreamNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(TemplatesGraphStreamNeoAction committer) {
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

   public static boolean isGroupClassDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_GroupClassDeclaration);
   }

   public GroupClassDeclarationNode newGroupClassDeclaration() {
   	return new GroupClassDeclarationNode(graph);
   }

   public GroupClassDeclarationNode newGroupClassDeclaration(Node node) {
   	return new GroupClassDeclarationNode(graph, node);
   }

   public void forEachGroupClassDeclarationNodes(Consumer<GroupClassDeclarationNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_GroupClassDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new GroupClassDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitGroupClassDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_GroupClassDeclaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isBugfix2(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_bugfix2);
   }

   public bugfix2Node newBugfix2() {
   	return new bugfix2Node(graph);
   }

   public bugfix2Node newBugfix2(Node node) {
   	return new bugfix2Node(graph, node);
   }

   public void forEachBugfix2Nodes(Consumer<bugfix2Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_bugfix2).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfix2Node(graph, node));
   			}
   		});
   }

   public void visitBugfix2Nodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_bugfix2).
   		forEachRemaining(consumer);
   } 

   public static boolean isDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_declaration);
   }

   public declarationNode newDeclaration() {
   	return new declarationNode(graph);
   }

   public declarationNode newDeclaration(Node node) {
   	return new declarationNode(graph, node);
   }

   public void forEachDeclarationNodes(Consumer<declarationNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_declaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new declarationNode(graph, node));
   			}
   		});
   }

   public void visitDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_declaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isDefaultNodeTypes(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_defaultNodeTypes);
   }

   public defaultNodeTypesNode newDefaultNodeTypes() {
   	return new defaultNodeTypesNode(graph);
   }

   public defaultNodeTypesNode newDefaultNodeTypes(Node node) {
   	return new defaultNodeTypesNode(graph, node);
   }

   public void forEachDefaultNodeTypesNodes(Consumer<defaultNodeTypesNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_defaultNodeTypes).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new defaultNodeTypesNode(graph, node));
   			}
   		});
   }

   public void visitDefaultNodeTypesNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_defaultNodeTypes).
   		forEachRemaining(consumer);
   } 

   public static boolean isKeyValueListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_keyValueListSetter);
   }

   public keyValueListSetterNode newKeyValueListSetter() {
   	return new keyValueListSetterNode(graph);
   }

   public keyValueListSetterNode newKeyValueListSetter(Node node) {
   	return new keyValueListSetterNode(graph, node);
   }

   public void forEachKeyValueListSetterNodes(Consumer<keyValueListSetterNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_keyValueListSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new keyValueListSetterNode(graph, node));
   			}
   		});
   }

   public void visitKeyValueListSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_keyValueListSetter).
   		forEachRemaining(consumer);
   } 

   public static boolean isKeyValueRelationships(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_keyValueRelationships);
   }

   public keyValueRelationshipsNode newKeyValueRelationships() {
   	return new keyValueRelationshipsNode(graph);
   }

   public keyValueRelationshipsNode newKeyValueRelationships(Node node) {
   	return new keyValueRelationshipsNode(graph, node);
   }

   public void forEachKeyValueRelationshipsNodes(Consumer<keyValueRelationshipsNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_keyValueRelationships).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new keyValueRelationshipsNode(graph, node));
   			}
   		});
   }

   public void visitKeyValueRelationshipsNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_keyValueRelationships).
   		forEachRemaining(consumer);
   } 

   public static boolean isListSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_listSetter);
   }

   public listSetterNode newListSetter() {
   	return new listSetterNode(graph);
   }

   public listSetterNode newListSetter(Node node) {
   	return new listSetterNode(graph, node);
   }

   public void forEachListSetterNodes(Consumer<listSetterNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_listSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new listSetterNode(graph, node));
   			}
   		});
   }

   public void visitListSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_listSetter).
   		forEachRemaining(consumer);
   } 

   public static boolean isNewInstance(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_newInstance);
   }

   public newInstanceNode newNewInstance() {
   	return new newInstanceNode(graph);
   }

   public newInstanceNode newNewInstance(Node node) {
   	return new newInstanceNode(graph, node);
   }

   public void forEachNewInstanceNodes(Consumer<newInstanceNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_newInstance).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new newInstanceNode(graph, node));
   			}
   		});
   }

   public void visitNewInstanceNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_newInstance).
   		forEachRemaining(consumer);
   } 

   public static boolean isStringSetter(Node node) {
   	return node != null && node.hasLabel(TemplatesGraphStream_stringSetter);
   }

   public stringSetterNode newStringSetter() {
   	return new stringSetterNode(graph);
   }

   public stringSetterNode newStringSetter(Node node) {
   	return new stringSetterNode(graph, node);
   }

   public void forEachStringSetterNodes(Consumer<stringSetterNode> consumer) {
   	graph.findNodes(TemplatesGraphStream_stringSetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new stringSetterNode(graph, node));
   			}
   		});
   }

   public void visitStringSetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesGraphStream_stringSetter).
   		forEachRemaining(consumer);
   } 

	public static final class GroupClassDeclarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, name_param, packageName_param, statements_param
		}

		private enum StatementsRelationships implements RelationshipType {
			declaration, name, newInstance
		} 

		private enum KeyValueLabels implements Label {
			Statements, 
		}

		private GroupClassDeclarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_GroupClassDeclaration);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private GroupClassDeclarationNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
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
			GroupClassDeclarationNode that = (GroupClassDeclarationNode) o;
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
	   public GroupClassDeclarationNode addCommentsValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public void forEachComments(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.comments_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   // name
	   public GroupClassDeclarationNode setName(Node target) {
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
	   public GroupClassDeclarationNode setPackageName(Node target) {
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

	   public GroupClassDeclarationNode addStatementsValue(StatementsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.statements_param);
	      return this;
	   }

	   public StatementsKeyValue newStatementsKeyValue() {
	   	final Node node = graph.createNode(KeyValueLabels.Statements);
	   	node.setProperty("uuid", UUID.randomUUID().toString());
	   	return newStatementsKeyValue(node);
	   }

	   public static StatementsKeyValue newStatementsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newStatementsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "uuid"));

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
	} 

	public static final class bugfix2Node {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private bugfix2Node(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_bugfix2);
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

	} 

	public static final class declarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, name_param, properties_param
		}

		private enum PropertiesRelationships implements RelationshipType {
			name, relationships, setter
		} 

		private enum KeyValueLabels implements Label {
			Properties, 
		}

		private declarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_declaration);
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

	   public PropertiesKeyValue newPropertiesKeyValue() {
	   	final Node node = graph.createNode(KeyValueLabels.Properties);
	   	node.setProperty("uuid", UUID.randomUUID().toString());
	   	return newPropertiesKeyValue(node);
	   }

	   public static PropertiesKeyValue newPropertiesKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newPropertiesKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "uuid"));

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
	} 

	public static final class defaultNodeTypesNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private defaultNodeTypesNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_defaultNodeTypes);
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

	} 

	public static final class keyValueListSetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			kvNames_param, propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private keyValueListSetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_keyValueListSetter);
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

	public static final class keyValueRelationshipsNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, types_param
		}


		private enum KeyValueLabels implements Label {
		}

		private keyValueRelationshipsNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_keyValueRelationships);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private keyValueRelationshipsNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
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
	   	node.createRelationshipTo(target, Parameters.types_param);
	      return this;
	   }

	   public void forEachTypes(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.types_param))
	   		consumer.accept(other(node, relationship));
	   } 
	} 

	public static final class listSetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private listSetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_listSetter);
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


		private enum KeyValueLabels implements Label {
		}

		private newInstanceNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_newInstance);
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


		private enum KeyValueLabels implements Label {
		}

		private stringSetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesGraphStream_stringSetter);
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
		return node != null && node.hasLabel(StringNode);
	}

	// convenience-method for instantiating a new StringNode, and setting the value
	public Node newStringNode(String value) {
		if (value==null) throw new IllegalArgumentException("value for newStringNode cannot be null");

		final Node node = graph.createNode(StringNode);
		node.setProperty("uuid", UUID.randomUUID().toString());
		return newStringNode(node).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {
		if (node==null) throw new IllegalArgumentException("node for newStringNode cannot be null");

		final UUID uuid = UUID.fromString(getString(node, "uuid"));

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