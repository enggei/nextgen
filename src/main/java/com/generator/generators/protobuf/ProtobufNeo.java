package com.generator.generators.protobuf;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.domain.BaseDomainVisitor.*;
import static com.generator.generators.protobuf.ProtobufNeo.ProtobufLabels.*;

/**
 * Wraps Neo4j methods based on 'Protobuf.stg' file <br/>
 * 
 */
public final class ProtobufNeo {

	private final GraphDatabaseService graph;

	public enum ProtobufLabels implements Label {
		Protobuf,   	
		Protobuf_enum,
		Protobuf_extend,
		Protobuf_extensions,
		Protobuf_groupMessagesModel,
		Protobuf_message,
		Protobuf_messageField,
		Protobuf_protobufPackage, 
		StringNode
	}

   public ProtobufNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

	public interface ProtobufNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(ProtobufNeoAction committer) {
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

   public static boolean isEnum(Node node) {
   	return node != null && node.hasLabel(Protobuf_enum);
   }

   public enumNode newEnum() {
   	return new enumNode(graph);
   }

   public enumNode newEnum(Node node) {
   	return new enumNode(graph, node);
   }

   public void forEachEnumNodes(Consumer<enumNode> consumer) {
   	graph.findNodes(Protobuf_enum).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new enumNode(graph, node));
   			}
   		});
   }

   public void visitEnumNodes(Consumer<Node> consumer) {
   	graph.findNodes(Protobuf_enum).
   		forEachRemaining(consumer);
   } 

   public static boolean isExtend(Node node) {
   	return node != null && node.hasLabel(Protobuf_extend);
   }

   public extendNode newExtend() {
   	return new extendNode(graph);
   }

   public extendNode newExtend(Node node) {
   	return new extendNode(graph, node);
   }

   public void forEachExtendNodes(Consumer<extendNode> consumer) {
   	graph.findNodes(Protobuf_extend).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new extendNode(graph, node));
   			}
   		});
   }

   public void visitExtendNodes(Consumer<Node> consumer) {
   	graph.findNodes(Protobuf_extend).
   		forEachRemaining(consumer);
   } 

   public static boolean isExtensions(Node node) {
   	return node != null && node.hasLabel(Protobuf_extensions);
   }

   public extensionsNode newExtensions() {
   	return new extensionsNode(graph);
   }

   public extensionsNode newExtensions(Node node) {
   	return new extensionsNode(graph, node);
   }

   public void forEachExtensionsNodes(Consumer<extensionsNode> consumer) {
   	graph.findNodes(Protobuf_extensions).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new extensionsNode(graph, node));
   			}
   		});
   }

   public void visitExtensionsNodes(Consumer<Node> consumer) {
   	graph.findNodes(Protobuf_extensions).
   		forEachRemaining(consumer);
   } 

   public static boolean isGroupMessagesModel(Node node) {
   	return node != null && node.hasLabel(Protobuf_groupMessagesModel);
   }

   public groupMessagesModelNode newGroupMessagesModel() {
   	return new groupMessagesModelNode(graph);
   }

   public groupMessagesModelNode newGroupMessagesModel(Node node) {
   	return new groupMessagesModelNode(graph, node);
   }

   public void forEachGroupMessagesModelNodes(Consumer<groupMessagesModelNode> consumer) {
   	graph.findNodes(Protobuf_groupMessagesModel).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new groupMessagesModelNode(graph, node));
   			}
   		});
   }

   public void visitGroupMessagesModelNodes(Consumer<Node> consumer) {
   	graph.findNodes(Protobuf_groupMessagesModel).
   		forEachRemaining(consumer);
   } 

   public static boolean isMessage(Node node) {
   	return node != null && node.hasLabel(Protobuf_message);
   }

   public messageNode newMessage() {
   	return new messageNode(graph);
   }

   public messageNode newMessage(Node node) {
   	return new messageNode(graph, node);
   }

   public void forEachMessageNodes(Consumer<messageNode> consumer) {
   	graph.findNodes(Protobuf_message).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new messageNode(graph, node));
   			}
   		});
   }

   public void visitMessageNodes(Consumer<Node> consumer) {
   	graph.findNodes(Protobuf_message).
   		forEachRemaining(consumer);
   } 

   public static boolean isMessageField(Node node) {
   	return node != null && node.hasLabel(Protobuf_messageField);
   }

   public messageFieldNode newMessageField() {
   	return new messageFieldNode(graph);
   }

   public messageFieldNode newMessageField(Node node) {
   	return new messageFieldNode(graph, node);
   }

   public void forEachMessageFieldNodes(Consumer<messageFieldNode> consumer) {
   	graph.findNodes(Protobuf_messageField).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new messageFieldNode(graph, node));
   			}
   		});
   }

   public void visitMessageFieldNodes(Consumer<Node> consumer) {
   	graph.findNodes(Protobuf_messageField).
   		forEachRemaining(consumer);
   } 

   public static boolean isProtobufPackage(Node node) {
   	return node != null && node.hasLabel(Protobuf_protobufPackage);
   }

   public protobufPackageNode newProtobufPackage() {
   	return new protobufPackageNode(graph);
   }

   public protobufPackageNode newProtobufPackage(Node node) {
   	return new protobufPackageNode(graph, node);
   }

   public void forEachProtobufPackageNodes(Consumer<protobufPackageNode> consumer) {
   	graph.findNodes(Protobuf_protobufPackage).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new protobufPackageNode(graph, node));
   			}
   		});
   }

   public void visitProtobufPackageNodes(Consumer<Node> consumer) {
   	graph.findNodes(Protobuf_protobufPackage).
   		forEachRemaining(consumer);
   } 

	public static final class enumNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, name_param, properties_param
		}


		private enum KeyValueLabels implements Label {
		}

		private enumNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(Protobuf_enum);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private enumNode(final GraphDatabaseService graph, final Node node) {
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
			enumNode that = (enumNode) o;
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
	   public enumNode setComments(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comments_param))
	   		singleOutgoing(node, Parameters.comments_param).delete();
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public Node getComments() {
	   	if (!hasOutgoing(node, Parameters.comments_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comments_param);
	   	return other(node, relationship);
	   }

	   public void removeComments() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comments_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public enumNode setName(Node target) {
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
	   public enumNode addPropertiesValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.properties_param);
	      return this;
	   }

	   public void forEachProperties(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param))
	   		consumer.accept(other(node, relationship));
	   } 
	} 

	public static final class extendNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, name_param, properties_param
		}


		private enum KeyValueLabels implements Label {
		}

		private extendNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(Protobuf_extend);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private extendNode(final GraphDatabaseService graph, final Node node) {
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
			extendNode that = (extendNode) o;
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
	   public extendNode setComments(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comments_param))
	   		singleOutgoing(node, Parameters.comments_param).delete();
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public Node getComments() {
	   	if (!hasOutgoing(node, Parameters.comments_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comments_param);
	   	return other(node, relationship);
	   }

	   public void removeComments() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comments_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public extendNode setName(Node target) {
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
	   public extendNode addPropertiesValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.properties_param);
	      return this;
	   }

	   public void forEachProperties(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param))
	   		consumer.accept(other(node, relationship));
	   } 
	} 

	public static final class extensionsNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			max_param, min_param
		}


		private enum KeyValueLabels implements Label {
		}

		private extensionsNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(Protobuf_extensions);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private extensionsNode(final GraphDatabaseService graph, final Node node) {
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
			extensionsNode that = (extensionsNode) o;
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

	   // max
	   public extensionsNode setMax(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.max_param))
	   		singleOutgoing(node, Parameters.max_param).delete();
	   	node.createRelationshipTo(target, Parameters.max_param);
	      return this;
	   }

	   public Node getMax() {
	   	if (!hasOutgoing(node, Parameters.max_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.max_param);
	   	return other(node, relationship);
	   }

	   public void removeMax() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.max_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // min
	   public extensionsNode setMin(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.min_param))
	   		singleOutgoing(node, Parameters.min_param).delete();
	   	node.createRelationshipTo(target, Parameters.min_param);
	      return this;
	   }

	   public Node getMin() {
	   	if (!hasOutgoing(node, Parameters.min_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.min_param);
	   	return other(node, relationship);
	   }

	   public void removeMin() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.min_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class groupMessagesModelNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, messages_param, packageName_param
		}

		private enum MessagesRelationships implements RelationshipType {
			name
		} 

		private enum KeyValueLabels implements Label {
			Messages, 
		}

		private groupMessagesModelNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(Protobuf_groupMessagesModel);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private groupMessagesModelNode(final GraphDatabaseService graph, final Node node) {
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
			groupMessagesModelNode that = (groupMessagesModelNode) o;
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
	   public groupMessagesModelNode setGroupName(Node target) {
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

	   public interface MessagesKeyValue {

	   	public Node getNameValue();

	   	public MessagesKeyValue setNameValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public groupMessagesModelNode addMessagesValue(MessagesKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.messages_param);
	      return this;
	   }

	   public MessagesKeyValue newMessagesKeyValue() {
	   	final Node node = graph.createNode(KeyValueLabels.Messages);
	   	node.setProperty("uuid", UUID.randomUUID().toString());
	   	return newMessagesKeyValue(node);
	   }

	   public static MessagesKeyValue newMessagesKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newMessagesKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "uuid"));

	   	return new MessagesKeyValue() {

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, MessagesRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, MessagesRelationships.name));
	   		} 

	   		@Override
	   		public MessagesKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, MessagesRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, MessagesRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, MessagesRelationships.name);

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

	   public void forEachMessagesValue(Consumer<MessagesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.messages_param)) {
	   		consumer.accept(newMessagesKeyValue(other(node, relationship)));
	   	}
	   } 

	   // packageName
	   public groupMessagesModelNode setPackageName(Node target) {
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

	public static final class messageNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, name_param, properties_param
		}


		private enum KeyValueLabels implements Label {
		}

		private messageNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(Protobuf_message);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private messageNode(final GraphDatabaseService graph, final Node node) {
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
			messageNode that = (messageNode) o;
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
	   public messageNode setComments(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comments_param))
	   		singleOutgoing(node, Parameters.comments_param).delete();
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public Node getComments() {
	   	if (!hasOutgoing(node, Parameters.comments_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comments_param);
	   	return other(node, relationship);
	   }

	   public void removeComments() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comments_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public messageNode setName(Node target) {
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
	   public messageNode addPropertiesValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.properties_param);
	      return this;
	   }

	   public void forEachProperties(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param))
	   		consumer.accept(other(node, relationship));
	   } 
	} 

	public static final class messageFieldNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comments_param, defaultValue_param, fieldConstraint_param, name_param, ordinal_param, packedValue_param, type_param
		}


		private enum KeyValueLabels implements Label {
		}

		private messageFieldNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(Protobuf_messageField);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private messageFieldNode(final GraphDatabaseService graph, final Node node) {
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
			messageFieldNode that = (messageFieldNode) o;
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
	   public messageFieldNode setComments(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comments_param))
	   		singleOutgoing(node, Parameters.comments_param).delete();
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public Node getComments() {
	   	if (!hasOutgoing(node, Parameters.comments_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comments_param);
	   	return other(node, relationship);
	   }

	   public void removeComments() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comments_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // defaultValue
	   public messageFieldNode setDefaultValue(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.defaultValue_param))
	   		singleOutgoing(node, Parameters.defaultValue_param).delete();
	   	node.createRelationshipTo(target, Parameters.defaultValue_param);
	      return this;
	   }

	   public Node getDefaultValue() {
	   	if (!hasOutgoing(node, Parameters.defaultValue_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.defaultValue_param);
	   	return other(node, relationship);
	   }

	   public void removeDefaultValue() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.defaultValue_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // fieldConstraint
	   public messageFieldNode setFieldConstraint(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.fieldConstraint_param))
	   		singleOutgoing(node, Parameters.fieldConstraint_param).delete();
	   	node.createRelationshipTo(target, Parameters.fieldConstraint_param);
	      return this;
	   }

	   public Node getFieldConstraint() {
	   	if (!hasOutgoing(node, Parameters.fieldConstraint_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.fieldConstraint_param);
	   	return other(node, relationship);
	   }

	   public void removeFieldConstraint() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.fieldConstraint_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public messageFieldNode setName(Node target) {
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

	   // ordinal
	   public messageFieldNode setOrdinal(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.ordinal_param))
	   		singleOutgoing(node, Parameters.ordinal_param).delete();
	   	node.createRelationshipTo(target, Parameters.ordinal_param);
	      return this;
	   }

	   public Node getOrdinal() {
	   	if (!hasOutgoing(node, Parameters.ordinal_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.ordinal_param);
	   	return other(node, relationship);
	   }

	   public void removeOrdinal() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.ordinal_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // packedValue
	   public messageFieldNode setPackedValue(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.packedValue_param))
	   		singleOutgoing(node, Parameters.packedValue_param).delete();
	   	node.createRelationshipTo(target, Parameters.packedValue_param);
	      return this;
	   }

	   public Node getPackedValue() {
	   	if (!hasOutgoing(node, Parameters.packedValue_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.packedValue_param);
	   	return other(node, relationship);
	   }

	   public void removePackedValue() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.packedValue_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // type
	   public messageFieldNode setType(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.type_param))
	   		singleOutgoing(node, Parameters.type_param).delete();
	   	node.createRelationshipTo(target, Parameters.type_param);
	      return this;
	   }

	   public Node getType() {
	   	if (!hasOutgoing(node, Parameters.type_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.type_param);
	   	return other(node, relationship);
	   }

	   public void removeType() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.type_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 
	} 

	public static final class protobufPackageNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			deliverables_param, imports_param, options_param, package_param
		}

		private enum OptionsRelationships implements RelationshipType {
			name, value
		} 

		private enum KeyValueLabels implements Label {
			Options, 
		}

		private protobufPackageNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(Protobuf_protobufPackage);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private protobufPackageNode(final GraphDatabaseService graph, final Node node) {
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
			protobufPackageNode that = (protobufPackageNode) o;
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

	   // deliverables
	   public protobufPackageNode addDeliverablesValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.deliverables_param);
	      return this;
	   }

	   public void forEachDeliverables(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.deliverables_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   // imports
	   public protobufPackageNode addImportsValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.imports_param);
	      return this;
	   }

	   public void forEachImports(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.imports_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   public interface OptionsKeyValue {

	   	public Node getNameValue();

	   	public Node getValueValue();

	   	public OptionsKeyValue setNameValue(Node value);

	   	public OptionsKeyValue setValueValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public protobufPackageNode addOptionsValue(OptionsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.options_param);
	      return this;
	   }

	   public OptionsKeyValue newOptionsKeyValue() {
	   	final Node node = graph.createNode(KeyValueLabels.Options);
	   	node.setProperty("uuid", UUID.randomUUID().toString());
	   	return newOptionsKeyValue(node);
	   }

	   public static OptionsKeyValue newOptionsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOptionsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "uuid"));

	   	return new OptionsKeyValue() {

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, OptionsRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, OptionsRelationships.name));
	   		} 

	   		@Override
	   		public OptionsKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, OptionsRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, OptionsRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OptionsRelationships.name);

	   			return this;
	   		} 

	   		@Override
	   		public Node getValueValue() {
	   			if (!hasOutgoing(node, OptionsRelationships.value)) return null;
	   			return other(node, singleOutgoing(node, OptionsRelationships.value));
	   		} 

	   		@Override
	   		public OptionsKeyValue setValueValue(Node value) {
	   			if (hasOutgoing(node, OptionsRelationships.value)) {
	   				final Relationship outgoing = singleOutgoing(node, OptionsRelationships.value);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OptionsRelationships.value);

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

	   public void forEachOptionsValue(Consumer<OptionsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.options_param)) {
	   		consumer.accept(newOptionsKeyValue(other(node, relationship)));
	   	}
	   } 

	   // package
	   public protobufPackageNode setPackage(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.package_param))
	   		singleOutgoing(node, Parameters.package_param).delete();
	   	node.createRelationshipTo(target, Parameters.package_param);
	      return this;
	   }

	   public Node getPackage() {
	   	if (!hasOutgoing(node, Parameters.package_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.package_param);
	   	return other(node, relationship);
	   }

	   public void removePackage() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.package_param);
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