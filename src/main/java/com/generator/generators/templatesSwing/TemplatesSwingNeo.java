package com.generator.generators.templatesSwing;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.domain.BaseDomainVisitor.*;
import static com.generator.generators.templatesSwing.TemplatesSwingNeo.TemplatesSwingLabels.*;

/**
 * Wraps Neo4j methods based on 'TemplatesSwing.stg' file <br/>
 * 
 */
public final class TemplatesSwingNeo {

	private final GraphDatabaseService graph;

	public enum TemplatesSwingLabels implements Label {
		TemplatesSwing,   	
		TemplatesSwing_TemplatesSwing,
		TemplatesSwing_addVerticleAction,
		TemplatesSwing_bugfix,
		TemplatesSwing_newAction,
		TemplatesSwing_stringPropertyEditor, 
		StringNode
	}

   public TemplatesSwingNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

	public interface TemplatesSwingNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(TemplatesSwingNeoAction committer) {
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

   public static boolean isTemplatesSwing(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_TemplatesSwing);
   }

   public TemplatesSwingNode newTemplatesSwing() {
   	return new TemplatesSwingNode(graph);
   }

   public TemplatesSwingNode newTemplatesSwing(Node node) {
   	return new TemplatesSwingNode(graph, node);
   }

   public void forEachTemplatesSwingNodes(Consumer<TemplatesSwingNode> consumer) {
   	graph.findNodes(TemplatesSwing_TemplatesSwing).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new TemplatesSwingNode(graph, node));
   			}
   		});
   }

   public void visitTemplatesSwingNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_TemplatesSwing).
   		forEachRemaining(consumer);
   } 

   public static boolean isAddVerticleAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_addVerticleAction);
   }

   public addVerticleActionNode newAddVerticleAction() {
   	return new addVerticleActionNode(graph);
   }

   public addVerticleActionNode newAddVerticleAction(Node node) {
   	return new addVerticleActionNode(graph, node);
   }

   public void forEachAddVerticleActionNodes(Consumer<addVerticleActionNode> consumer) {
   	graph.findNodes(TemplatesSwing_addVerticleAction).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new addVerticleActionNode(graph, node));
   			}
   		});
   }

   public void visitAddVerticleActionNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_addVerticleAction).
   		forEachRemaining(consumer);
   } 

   public static boolean isBugfix(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_bugfix);
   }

   public bugfixNode newBugfix() {
   	return new bugfixNode(graph);
   }

   public bugfixNode newBugfix(Node node) {
   	return new bugfixNode(graph, node);
   }

   public void forEachBugfixNodes(Consumer<bugfixNode> consumer) {
   	graph.findNodes(TemplatesSwing_bugfix).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfixNode(graph, node));
   			}
   		});
   }

   public void visitBugfixNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_bugfix).
   		forEachRemaining(consumer);
   } 

   public static boolean isNewAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_newAction);
   }

   public newActionNode newNewAction() {
   	return new newActionNode(graph);
   }

   public newActionNode newNewAction(Node node) {
   	return new newActionNode(graph, node);
   }

   public void forEachNewActionNodes(Consumer<newActionNode> consumer) {
   	graph.findNodes(TemplatesSwing_newAction).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new newActionNode(graph, node));
   			}
   		});
   }

   public void visitNewActionNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_newAction).
   		forEachRemaining(consumer);
   } 

   public static boolean isStringPropertyEditor(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_stringPropertyEditor);
   }

   public stringPropertyEditorNode newStringPropertyEditor() {
   	return new stringPropertyEditorNode(graph);
   }

   public stringPropertyEditorNode newStringPropertyEditor(Node node) {
   	return new stringPropertyEditorNode(graph, node);
   }

   public void forEachStringPropertyEditorNodes(Consumer<stringPropertyEditorNode> consumer) {
   	graph.findNodes(TemplatesSwing_stringPropertyEditor).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new stringPropertyEditorNode(graph, node));
   			}
   		});
   }

   public void visitStringPropertyEditorNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwing_stringPropertyEditor).
   		forEachRemaining(consumer);
   } 

	public static final class TemplatesSwingNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, packageName_param, statements_param
		}

		private enum StatementsRelationships implements RelationshipType {
			name, newAction
		} 

		private enum KeyValueLabels implements Label {
			Statements, 
		}

		private TemplatesSwingNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwing_TemplatesSwing);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private TemplatesSwingNode(final GraphDatabaseService graph, final Node node) {
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
			TemplatesSwingNode that = (TemplatesSwingNode) o;
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
	   public TemplatesSwingNode setGroupName(Node target) {
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

	   // packageName
	   public TemplatesSwingNode setPackageName(Node target) {
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

	   	public Node getNameValue();

	   	public Node getNewActionValue();

	   	public StatementsKeyValue setNameValue(Node value);

	   	public StatementsKeyValue setNewActionValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplatesSwingNode addStatementsValue(StatementsKeyValue value) {
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
	   		public Node getNewActionValue() {
	   			if (!hasOutgoing(node, StatementsRelationships.newAction)) return null;
	   			return other(node, singleOutgoing(node, StatementsRelationships.newAction));
	   		} 

	   		@Override
	   		public StatementsKeyValue setNewActionValue(Node value) {
	   			if (hasOutgoing(node, StatementsRelationships.newAction)) {
	   				final Relationship outgoing = singleOutgoing(node, StatementsRelationships.newAction);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, StatementsRelationships.newAction);

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

	public static final class addVerticleActionNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, packageName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private addVerticleActionNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwing_addVerticleAction);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private addVerticleActionNode(final GraphDatabaseService graph, final Node node) {
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
			addVerticleActionNode that = (addVerticleActionNode) o;
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
	   public addVerticleActionNode setName(Node target) {
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
	   public addVerticleActionNode setPackageName(Node target) {
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
	} 

	public static final class bugfixNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private bugfixNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwing_bugfix);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private bugfixNode(final GraphDatabaseService graph, final Node node) {
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
			bugfixNode that = (bugfixNode) o;
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

	public static final class newActionNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private newActionNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwing_newAction);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private newActionNode(final GraphDatabaseService graph, final Node node) {
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
			newActionNode that = (newActionNode) o;
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
	   public newActionNode setGroupName(Node target) {
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
	   public newActionNode setName(Node target) {
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

	public static final class stringPropertyEditorNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private stringPropertyEditorNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwing_stringPropertyEditor);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private stringPropertyEditorNode(final GraphDatabaseService graph, final Node node) {
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
			stringPropertyEditorNode that = (stringPropertyEditorNode) o;
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
	   public stringPropertyEditorNode setGroupName(Node target) {
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
	   public stringPropertyEditorNode setName(Node target) {
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