package com.generator.generators.templateGroup;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.domain.BaseDomainVisitor.*;
import static com.generator.generators.templateGroup.TemplateGroupNeo.TemplateGroupLabels.*;

/**
 * Wraps Neo4j methods based on 'TemplateGroup.stg' file <br/>
 * 
 */
public final class TemplateGroupNeo {

	private final GraphDatabaseService graph;

	public enum TemplateGroupLabels implements Label {
		TemplateGroup,   	
		TemplateGroup_AttributeRendererDeclaration,
		TemplateGroup_GroupClassDeclaration,
		TemplateGroup_NewGroupInstance,
		TemplateGroup_NewStatementDeclaration,
		TemplateGroup_NewStatementInstance,
		TemplateGroup_StatementKeyValueListPropertySetter,
		TemplateGroup_StatementListPropertySetter,
		TemplateGroup_StatementStringPropertySetter,
		TemplateGroup_bugfix, 
		StringNode
	}

   public TemplateGroupNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

	public interface TemplateGroupNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(TemplateGroupNeoAction committer) {
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

   public static boolean isAttributeRendererDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_AttributeRendererDeclaration);
   }

   public AttributeRendererDeclarationNode newAttributeRendererDeclaration() {
   	return new AttributeRendererDeclarationNode(graph);
   }

   public AttributeRendererDeclarationNode newAttributeRendererDeclaration(Node node) {
   	return new AttributeRendererDeclarationNode(graph, node);
   }

   public void forEachAttributeRendererDeclarationNodes(Consumer<AttributeRendererDeclarationNode> consumer) {
   	graph.findNodes(TemplateGroup_AttributeRendererDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new AttributeRendererDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitAttributeRendererDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_AttributeRendererDeclaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isGroupClassDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_GroupClassDeclaration);
   }

   public GroupClassDeclarationNode newGroupClassDeclaration() {
   	return new GroupClassDeclarationNode(graph);
   }

   public GroupClassDeclarationNode newGroupClassDeclaration(Node node) {
   	return new GroupClassDeclarationNode(graph, node);
   }

   public void forEachGroupClassDeclarationNodes(Consumer<GroupClassDeclarationNode> consumer) {
   	graph.findNodes(TemplateGroup_GroupClassDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new GroupClassDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitGroupClassDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_GroupClassDeclaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isNewGroupInstance(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_NewGroupInstance);
   }

   public NewGroupInstanceNode newNewGroupInstance() {
   	return new NewGroupInstanceNode(graph);
   }

   public NewGroupInstanceNode newNewGroupInstance(Node node) {
   	return new NewGroupInstanceNode(graph, node);
   }

   public void forEachNewGroupInstanceNodes(Consumer<NewGroupInstanceNode> consumer) {
   	graph.findNodes(TemplateGroup_NewGroupInstance).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NewGroupInstanceNode(graph, node));
   			}
   		});
   }

   public void visitNewGroupInstanceNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_NewGroupInstance).
   		forEachRemaining(consumer);
   } 

   public static boolean isNewStatementDeclaration(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_NewStatementDeclaration);
   }

   public NewStatementDeclarationNode newNewStatementDeclaration() {
   	return new NewStatementDeclarationNode(graph);
   }

   public NewStatementDeclarationNode newNewStatementDeclaration(Node node) {
   	return new NewStatementDeclarationNode(graph, node);
   }

   public void forEachNewStatementDeclarationNodes(Consumer<NewStatementDeclarationNode> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementDeclaration).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NewStatementDeclarationNode(graph, node));
   			}
   		});
   }

   public void visitNewStatementDeclarationNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementDeclaration).
   		forEachRemaining(consumer);
   } 

   public static boolean isNewStatementInstance(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_NewStatementInstance);
   }

   public NewStatementInstanceNode newNewStatementInstance() {
   	return new NewStatementInstanceNode(graph);
   }

   public NewStatementInstanceNode newNewStatementInstance(Node node) {
   	return new NewStatementInstanceNode(graph, node);
   }

   public void forEachNewStatementInstanceNodes(Consumer<NewStatementInstanceNode> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementInstance).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new NewStatementInstanceNode(graph, node));
   			}
   		});
   }

   public void visitNewStatementInstanceNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_NewStatementInstance).
   		forEachRemaining(consumer);
   } 

   public static boolean isStatementKeyValueListPropertySetter(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_StatementKeyValueListPropertySetter);
   }

   public StatementKeyValueListPropertySetterNode newStatementKeyValueListPropertySetter() {
   	return new StatementKeyValueListPropertySetterNode(graph);
   }

   public StatementKeyValueListPropertySetterNode newStatementKeyValueListPropertySetter(Node node) {
   	return new StatementKeyValueListPropertySetterNode(graph, node);
   }

   public void forEachStatementKeyValueListPropertySetterNodes(Consumer<StatementKeyValueListPropertySetterNode> consumer) {
   	graph.findNodes(TemplateGroup_StatementKeyValueListPropertySetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new StatementKeyValueListPropertySetterNode(graph, node));
   			}
   		});
   }

   public void visitStatementKeyValueListPropertySetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_StatementKeyValueListPropertySetter).
   		forEachRemaining(consumer);
   } 

   public static boolean isStatementListPropertySetter(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_StatementListPropertySetter);
   }

   public StatementListPropertySetterNode newStatementListPropertySetter() {
   	return new StatementListPropertySetterNode(graph);
   }

   public StatementListPropertySetterNode newStatementListPropertySetter(Node node) {
   	return new StatementListPropertySetterNode(graph, node);
   }

   public void forEachStatementListPropertySetterNodes(Consumer<StatementListPropertySetterNode> consumer) {
   	graph.findNodes(TemplateGroup_StatementListPropertySetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new StatementListPropertySetterNode(graph, node));
   			}
   		});
   }

   public void visitStatementListPropertySetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_StatementListPropertySetter).
   		forEachRemaining(consumer);
   } 

   public static boolean isStatementStringPropertySetter(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_StatementStringPropertySetter);
   }

   public StatementStringPropertySetterNode newStatementStringPropertySetter() {
   	return new StatementStringPropertySetterNode(graph);
   }

   public StatementStringPropertySetterNode newStatementStringPropertySetter(Node node) {
   	return new StatementStringPropertySetterNode(graph, node);
   }

   public void forEachStatementStringPropertySetterNodes(Consumer<StatementStringPropertySetterNode> consumer) {
   	graph.findNodes(TemplateGroup_StatementStringPropertySetter).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new StatementStringPropertySetterNode(graph, node));
   			}
   		});
   }

   public void visitStatementStringPropertySetterNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_StatementStringPropertySetter).
   		forEachRemaining(consumer);
   } 

   public static boolean isBugfix(Node node) {
   	return node != null && node.hasLabel(TemplateGroup_bugfix);
   }

   public bugfixNode newBugfix() {
   	return new bugfixNode(graph);
   }

   public bugfixNode newBugfix(Node node) {
   	return new bugfixNode(graph, node);
   }

   public void forEachBugfixNodes(Consumer<bugfixNode> consumer) {
   	graph.findNodes(TemplateGroup_bugfix).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfixNode(graph, node));
   			}
   		});
   }

   public void visitBugfixNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplateGroup_bugfix).
   		forEachRemaining(consumer);
   } 

	public static final class AttributeRendererDeclarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private AttributeRendererDeclarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_AttributeRendererDeclaration);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private AttributeRendererDeclarationNode(final GraphDatabaseService graph, final Node node) {
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
			AttributeRendererDeclarationNode that = (AttributeRendererDeclarationNode) o;
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

	public static final class GroupClassDeclarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			domain_param, name_param, packageName_param, statements_param
		}

		private enum StatementsRelationships implements RelationshipType {
			declaration, newInstance
		} 

		private enum KeyValueLabels implements Label {
			Statements, 
		}

		private GroupClassDeclarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_GroupClassDeclaration);
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

	   // domain
	   public GroupClassDeclarationNode setDomain(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.domain_param))
	   		singleOutgoing(node, Parameters.domain_param).delete();
	   	node.createRelationshipTo(target, Parameters.domain_param);
	      return this;
	   }

	   public Node getDomain() {
	   	if (!hasOutgoing(node, Parameters.domain_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.domain_param);
	   	return other(node, relationship);
	   }

	   public void removeDomain() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.domain_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
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

	   	public Node getNewInstanceValue();

	   	public StatementsKeyValue setDeclarationValue(Node value);

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

	public static final class NewGroupInstanceNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			filename_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private NewGroupInstanceNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_NewGroupInstance);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private NewGroupInstanceNode(final GraphDatabaseService graph, final Node node) {
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
			NewGroupInstanceNode that = (NewGroupInstanceNode) o;
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

	   // filename
	   public NewGroupInstanceNode setFilename(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.filename_param))
	   		singleOutgoing(node, Parameters.filename_param).delete();
	   	node.createRelationshipTo(target, Parameters.filename_param);
	      return this;
	   }

	   public Node getFilename() {
	   	if (!hasOutgoing(node, Parameters.filename_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.filename_param);
	   	return other(node, relationship);
	   }

	   public void removeFilename() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.filename_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public NewGroupInstanceNode setName(Node target) {
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

	public static final class NewStatementDeclarationNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, properties_param
		}

		private enum PropertiesRelationships implements RelationshipType {
			name, setter
		} 

		private enum KeyValueLabels implements Label {
			Properties, 
		}

		private NewStatementDeclarationNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_NewStatementDeclaration);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private NewStatementDeclarationNode(final GraphDatabaseService graph, final Node node) {
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
			NewStatementDeclarationNode that = (NewStatementDeclarationNode) o;
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
	   public NewStatementDeclarationNode setName(Node target) {
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

	   	public Node getSetterValue();

	   	public PropertiesKeyValue setNameValue(Node value);

	   	public PropertiesKeyValue setSetterValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public NewStatementDeclarationNode addPropertiesValue(PropertiesKeyValue value) {
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

	public static final class NewStatementInstanceNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private NewStatementInstanceNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_NewStatementInstance);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private NewStatementInstanceNode(final GraphDatabaseService graph, final Node node) {
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
			NewStatementInstanceNode that = (NewStatementInstanceNode) o;
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
	   public NewStatementInstanceNode setName(Node target) {
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

	public static final class StatementKeyValueListPropertySetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			kvNames_param, propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private StatementKeyValueListPropertySetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_StatementKeyValueListPropertySetter);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private StatementKeyValueListPropertySetterNode(final GraphDatabaseService graph, final Node node) {
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
			StatementKeyValueListPropertySetterNode that = (StatementKeyValueListPropertySetterNode) o;
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
	   public StatementKeyValueListPropertySetterNode addKvNamesValue(Node target) {
	   	if (node == null) return this;
	   	node.createRelationshipTo(target, Parameters.kvNames_param);
	      return this;
	   }

	   public void forEachKvNames(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.kvNames_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   // propertyName
	   public StatementKeyValueListPropertySetterNode setPropertyName(Node target) {
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
	   public StatementKeyValueListPropertySetterNode setStatementName(Node target) {
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

	public static final class StatementListPropertySetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private StatementListPropertySetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_StatementListPropertySetter);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private StatementListPropertySetterNode(final GraphDatabaseService graph, final Node node) {
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
			StatementListPropertySetterNode that = (StatementListPropertySetterNode) o;
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
	   public StatementListPropertySetterNode setPropertyName(Node target) {
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
	   public StatementListPropertySetterNode setStatementName(Node target) {
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

	public static final class StatementStringPropertySetterNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			propertyName_param, statementName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private StatementStringPropertySetterNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_StatementStringPropertySetter);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private StatementStringPropertySetterNode(final GraphDatabaseService graph, final Node node) {
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
			StatementStringPropertySetterNode that = (StatementStringPropertySetterNode) o;
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
	   public StatementStringPropertySetterNode setPropertyName(Node target) {
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
	   public StatementStringPropertySetterNode setStatementName(Node target) {
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

	public static final class bugfixNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private bugfixNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplateGroup_bugfix);
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