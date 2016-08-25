package com.generator.generators.templatesSwing;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.generator.editors.domain.BaseDomainVisitor.*;

/**
 * Wraps Neo4j methods based on 'TemplatesSwing.stg' file <br/>
 * 
 */
public final class TemplatesSwingNeo {

	private final GraphDatabaseService graph;

	public enum TemplatesSwingLabels implements Label {
   	TemplatesSwing_GroupPanel, TemplatesSwing_TemplatePanel, TemplatesSwing_TemplatesSwing, TemplatesSwing_addVerticleAction, TemplatesSwing_bugfix, TemplatesSwing_newAction, TemplatesSwing_stringPropertyEditor, TemplatesSwing, StringNode
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

   public static boolean isGroupPanel(Node node) {
   	return node != null && node.hasLabel(TemplatesSwingLabels.TemplatesSwing_GroupPanel);
   }

   public GroupPanelNode newGroupPanel() {
   	return new GroupPanelNode(graph);
   }

   public GroupPanelNode newGroupPanel(Node node) {
   	return new GroupPanelNode(graph, node);
   }

   public void forEachGroupPanelNodes(Consumer<GroupPanelNode> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_GroupPanel).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new GroupPanelNode(graph, node));
   			}
   		});
   }

   public void visitGroupPanelNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_GroupPanel).
   		forEachRemaining(consumer);
   } 

   public static boolean isTemplatePanel(Node node) {
   	return node != null && node.hasLabel(TemplatesSwingLabels.TemplatesSwing_TemplatePanel);
   }

   public TemplatePanelNode newTemplatePanel() {
   	return new TemplatePanelNode(graph);
   }

   public TemplatePanelNode newTemplatePanel(Node node) {
   	return new TemplatePanelNode(graph, node);
   }

   public void forEachTemplatePanelNodes(Consumer<TemplatePanelNode> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_TemplatePanel).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new TemplatePanelNode(graph, node));
   			}
   		});
   }

   public void visitTemplatePanelNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_TemplatePanel).
   		forEachRemaining(consumer);
   } 

   public static boolean isTemplatesSwing(Node node) {
   	return node != null && node.hasLabel(TemplatesSwingLabels.TemplatesSwing_TemplatesSwing);
   }

   public TemplatesSwingNode newTemplatesSwing() {
   	return new TemplatesSwingNode(graph);
   }

   public TemplatesSwingNode newTemplatesSwing(Node node) {
   	return new TemplatesSwingNode(graph, node);
   }

   public void forEachTemplatesSwingNodes(Consumer<TemplatesSwingNode> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_TemplatesSwing).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new TemplatesSwingNode(graph, node));
   			}
   		});
   }

   public void visitTemplatesSwingNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_TemplatesSwing).
   		forEachRemaining(consumer);
   } 

   public static boolean isAddVerticleAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwingLabels.TemplatesSwing_addVerticleAction);
   }

   public addVerticleActionNode newAddVerticleAction() {
   	return new addVerticleActionNode(graph);
   }

   public addVerticleActionNode newAddVerticleAction(Node node) {
   	return new addVerticleActionNode(graph, node);
   }

   public void forEachAddVerticleActionNodes(Consumer<addVerticleActionNode> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_addVerticleAction).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new addVerticleActionNode(graph, node));
   			}
   		});
   }

   public void visitAddVerticleActionNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_addVerticleAction).
   		forEachRemaining(consumer);
   } 

   public static boolean isBugfix(Node node) {
   	return node != null && node.hasLabel(TemplatesSwingLabels.TemplatesSwing_bugfix);
   }

   public bugfixNode newBugfix() {
   	return new bugfixNode(graph);
   }

   public bugfixNode newBugfix(Node node) {
   	return new bugfixNode(graph, node);
   }

   public void forEachBugfixNodes(Consumer<bugfixNode> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_bugfix).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new bugfixNode(graph, node));
   			}
   		});
   }

   public void visitBugfixNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_bugfix).
   		forEachRemaining(consumer);
   } 

   public static boolean isNewAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwingLabels.TemplatesSwing_newAction);
   }

   public newActionNode newNewAction() {
   	return new newActionNode(graph);
   }

   public newActionNode newNewAction(Node node) {
   	return new newActionNode(graph, node);
   }

   public void forEachNewActionNodes(Consumer<newActionNode> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_newAction).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new newActionNode(graph, node));
   			}
   		});
   }

   public void visitNewActionNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_newAction).
   		forEachRemaining(consumer);
   } 

   public static boolean isStringPropertyEditor(Node node) {
   	return node != null && node.hasLabel(TemplatesSwingLabels.TemplatesSwing_stringPropertyEditor);
   }

   public stringPropertyEditorNode newStringPropertyEditor() {
   	return new stringPropertyEditorNode(graph);
   }

   public stringPropertyEditorNode newStringPropertyEditor(Node node) {
   	return new stringPropertyEditorNode(graph, node);
   }

   public void forEachStringPropertyEditorNodes(Consumer<stringPropertyEditorNode> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_stringPropertyEditor).
   		forEachRemaining(new Consumer<Node>() {
   			@Override
   			public void accept(Node node) {
   				consumer.accept(new stringPropertyEditorNode(graph, node));
   			}
   		});
   }

   public void visitStringPropertyEditorNodes(Consumer<Node> consumer) {
   	graph.findNodes(TemplatesSwingLabels.TemplatesSwing_stringPropertyEditor).
   		forEachRemaining(consumer);
   } 

	public static final class GroupPanelNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, packageName_param, verticles_param
		}

		private GroupPanelNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwingLabels.TemplatesSwing_GroupPanel);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private GroupPanelNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("GroupPanelNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			GroupPanelNode that = (GroupPanelNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "TemplatesSwing_GroupPanel " + uuid;
		}

	   // name
	   public GroupPanelNode setName(Node target) {
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
	   public GroupPanelNode setPackageName(Node target) {
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

	   // verticles
	   public GroupPanelNode addVerticlesValue(Node addGroupVerticleActionTarget, Node groupClassDeclarationPanelTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (addGroupVerticleActionTarget != null) 
	   		keyValueNode.createRelationshipTo(addGroupVerticleActionTarget, RelationshipType.withName("addGroupVerticleAction"));

	   	if (groupClassDeclarationPanelTarget != null) 
	   		keyValueNode.createRelationshipTo(groupClassDeclarationPanelTarget, RelationshipType.withName("groupClassDeclarationPanel"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.verticles_param);
	   	return this;
	   }

	   public GroupPanelNode addVerticlesValue(VerticlesKeyValue keyValue) {
	      return addVerticlesValue(keyValue.getAddGroupVerticleActionValue(), keyValue.getGroupClassDeclarationPanelValue());
	   }

	   public interface VerticlesKeyValue {

	   	public Node getAddGroupVerticleActionValue();

	   	public Node getGroupClassDeclarationPanelValue();   
	   }

	   public void forEachVerticlesValue(Consumer<VerticlesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.verticles_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new VerticlesKeyValue() {

	   			@Override
	   			public Node getAddGroupVerticleActionValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("addGroupVerticleAction"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("addGroupVerticleAction")));
	   			 } 

	   			@Override
	   			public Node getGroupClassDeclarationPanelValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("groupClassDeclarationPanel"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("groupClassDeclarationPanel")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "GroupPanel_verticles_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 
	} 

	public static final class TemplatePanelNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, properties_param
		}

		private TemplatePanelNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwingLabels.TemplatesSwing_TemplatePanel);
			this.node.setProperty("uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		private TemplatePanelNode(final GraphDatabaseService graph, final Node node) {
			this.graph = graph;
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException("TemplatePanelNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			TemplatePanelNode that = (TemplatePanelNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return "TemplatesSwing_TemplatePanel " + uuid;
		}

	   // name
	   public TemplatePanelNode setName(Node target) {
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
	   public TemplatePanelNode addPropertiesValue(Node stringPanelTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (stringPanelTarget != null) 
	   		keyValueNode.createRelationshipTo(stringPanelTarget, RelationshipType.withName("stringPanel"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.properties_param);
	   	return this;
	   }

	   public TemplatePanelNode addPropertiesValue(PropertiesKeyValue keyValue) {
	      return addPropertiesValue(keyValue.getStringPanelValue());
	   }

	   public interface PropertiesKeyValue {

	   	public Node getStringPanelValue();   
	   }

	   public void forEachPropertiesValue(Consumer<PropertiesKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.properties_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new PropertiesKeyValue() {

	   			@Override
	   			public Node getStringPanelValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("stringPanel"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("stringPanel")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "TemplatePanel_properties_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
	   	}
	   } 
	} 

	public static final class TemplatesSwingNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, packageName_param, statements_param
		}

		private TemplatesSwingNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwingLabels.TemplatesSwing_TemplatesSwing);
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
				throw new IllegalStateException("TemplatesSwingNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesSwing_TemplatesSwing " + uuid;
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

	   // statements
	   public TemplatesSwingNode addStatementsValue(Node nameTarget, Node newActionTarget) {

	   	final Node keyValueNode = graph.createNode(Label.label("KeyValue"));
	   	keyValueNode.setProperty("uuid", UUID.randomUUID().toString());

	   	if (nameTarget != null) 
	   		keyValueNode.createRelationshipTo(nameTarget, RelationshipType.withName("name"));

	   	if (newActionTarget != null) 
	   		keyValueNode.createRelationshipTo(newActionTarget, RelationshipType.withName("newAction"));
	      
	   	node.createRelationshipTo(keyValueNode, Parameters.statements_param);
	   	return this;
	   }

	   public TemplatesSwingNode addStatementsValue(StatementsKeyValue keyValue) {
	      return addStatementsValue(keyValue.getNameValue(), keyValue.getNewActionValue());
	   }

	   public interface StatementsKeyValue {

	   	public Node getNameValue();

	   	public Node getNewActionValue();   
	   }

	   public void forEachStatementsValue(Consumer<StatementsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.statements_param)) {
	   		final Node kvNode = other(node, relationship);
	   		consumer.accept(new StatementsKeyValue() {

	   			@Override
	   			public Node getNameValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("name"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("name")));
	   			 } 

	   			@Override
	   			public Node getNewActionValue() {
	   				if (!hasOutgoing(kvNode, RelationshipType.withName("newAction"))) return null;
	   				return other(kvNode, singleOutgoing(kvNode, RelationshipType.withName("newAction")));
	   			 } 

	   				@Override
	   				public String toString() {
	   					return "TemplatesSwing_statements_KeyValue " + get(kvNode, "uuid");
	   				}
	   		});
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

		private addVerticleActionNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwingLabels.TemplatesSwing_addVerticleAction);
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
				throw new IllegalStateException("addVerticleActionNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesSwing_addVerticleAction " + uuid;
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
			this.node = graph.createNode(TemplatesSwingLabels.TemplatesSwing_bugfix);
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
				throw new IllegalStateException("bugfixNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesSwing_bugfix " + uuid;
		}

	} 

	public static final class newActionNode {

		private final GraphDatabaseService graph;
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, name_param
		}

		private newActionNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwingLabels.TemplatesSwing_newAction);
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
				throw new IllegalStateException("newActionNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesSwing_newAction " + uuid;
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

		private stringPropertyEditorNode(final GraphDatabaseService graph) {
			this.graph = graph;
			this.node = graph.createNode(TemplatesSwingLabels.TemplatesSwing_stringPropertyEditor);
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
				throw new IllegalStateException("stringPropertyEditorNode " + uuid + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
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
			return "TemplatesSwing_stringPropertyEditor " + uuid;
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
		return node != null && node.hasLabel(TemplatesSwingLabels.StringNode);
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
			this.node = graph.createNode(TemplatesSwingLabels.StringNode);
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