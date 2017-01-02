package com.generator.generators.templatesSwing;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.templatesSwing.TemplatesSwingNeo.TemplatesSwingLabels.*;

/**
 * Wraps Neo4j methods based on 'TemplatesSwing.stg' file <br/>
 * 
 * todo: refactor to static methods (no need for node-encapsulation, just let clients get the NeoNodes, but static treatment of each node as a specific type
 */
public final class TemplatesSwingNeo {

	private final GraphDatabaseService graph;

	public enum TemplatesSwingLabels implements Label {
		TemplatesSwing,   	
		TemplatesSwing_CanvasActionStringProperty,
		TemplatesSwing_CanvasListener,
		TemplatesSwing_PNode,
		TemplatesSwing_TemplateCanvas,
		TemplatesSwing_TemplateGroupActions,
		TemplatesSwing_TemplatesSwing,
		TemplatesSwing_addListAction,
		TemplatesSwing_addVerticleAction,
		TemplatesSwing_bugfix,
		TemplatesSwing_genericFix,
		TemplatesSwing_newAction,
		TemplatesSwing_setStringAction,
		TemplatesSwing_statementActions,
		TemplatesSwing_stringPropertyEditor, 
		StringNode
	}

   public TemplatesSwingNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isCanvasActionStringProperty(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_CanvasActionStringProperty);
   }

   public static CanvasActionStringPropertyNode newCanvasActionStringProperty(Node node) {
   	return new CanvasActionStringPropertyNode(node);
   }

   public CanvasActionStringPropertyNode newCanvasActionStringProperty() {
   	return new CanvasActionStringPropertyNode(graph);
   }

   public ResourceIterator<CanvasActionStringPropertyNode> findAllCanvasActionStringProperty() { 
   	return graph.findNodes(TemplatesSwing_CanvasActionStringProperty).map(TemplatesSwingNeo::newCanvasActionStringProperty);
   } 

   public static boolean isCanvasListener(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_CanvasListener);
   }

   public static CanvasListenerNode newCanvasListener(Node node) {
   	return new CanvasListenerNode(node);
   }

   public CanvasListenerNode newCanvasListener() {
   	return new CanvasListenerNode(graph);
   }

   public ResourceIterator<CanvasListenerNode> findAllCanvasListener() { 
   	return graph.findNodes(TemplatesSwing_CanvasListener).map(TemplatesSwingNeo::newCanvasListener);
   } 

   public static boolean isPNode(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_PNode);
   }

   public static PNodeNode newPNode(Node node) {
   	return new PNodeNode(node);
   }

   public PNodeNode newPNode() {
   	return new PNodeNode(graph);
   }

   public ResourceIterator<PNodeNode> findAllPNode() { 
   	return graph.findNodes(TemplatesSwing_PNode).map(TemplatesSwingNeo::newPNode);
   } 

   public static boolean isTemplateCanvas(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_TemplateCanvas);
   }

   public static TemplateCanvasNode newTemplateCanvas(Node node) {
   	return new TemplateCanvasNode(node);
   }

   public TemplateCanvasNode newTemplateCanvas() {
   	return new TemplateCanvasNode(graph);
   }

   public ResourceIterator<TemplateCanvasNode> findAllTemplateCanvas() { 
   	return graph.findNodes(TemplatesSwing_TemplateCanvas).map(TemplatesSwingNeo::newTemplateCanvas);
   } 

   public static boolean isTemplateGroupActions(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_TemplateGroupActions);
   }

   public static TemplateGroupActionsNode newTemplateGroupActions(Node node) {
   	return new TemplateGroupActionsNode(node);
   }

   public TemplateGroupActionsNode newTemplateGroupActions() {
   	return new TemplateGroupActionsNode(graph);
   }

   public ResourceIterator<TemplateGroupActionsNode> findAllTemplateGroupActions() { 
   	return graph.findNodes(TemplatesSwing_TemplateGroupActions).map(TemplatesSwingNeo::newTemplateGroupActions);
   } 

   public static boolean isTemplatesSwing(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_TemplatesSwing);
   }

   public static TemplatesSwingNode newTemplatesSwing(Node node) {
   	return new TemplatesSwingNode(node);
   }

   public TemplatesSwingNode newTemplatesSwing() {
   	return new TemplatesSwingNode(graph);
   }

   public ResourceIterator<TemplatesSwingNode> findAllTemplatesSwing() { 
   	return graph.findNodes(TemplatesSwing_TemplatesSwing).map(TemplatesSwingNeo::newTemplatesSwing);
   } 

   public static boolean isAddListAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_addListAction);
   }

   public static addListActionNode newAddListAction(Node node) {
   	return new addListActionNode(node);
   }

   public addListActionNode newAddListAction() {
   	return new addListActionNode(graph);
   }

   public ResourceIterator<addListActionNode> findAllAddListAction() { 
   	return graph.findNodes(TemplatesSwing_addListAction).map(TemplatesSwingNeo::newAddListAction);
   } 

   public static boolean isAddVerticleAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_addVerticleAction);
   }

   public static addVerticleActionNode newAddVerticleAction(Node node) {
   	return new addVerticleActionNode(node);
   }

   public addVerticleActionNode newAddVerticleAction() {
   	return new addVerticleActionNode(graph);
   }

   public ResourceIterator<addVerticleActionNode> findAllAddVerticleAction() { 
   	return graph.findNodes(TemplatesSwing_addVerticleAction).map(TemplatesSwingNeo::newAddVerticleAction);
   } 

   public static boolean isBugfix(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_bugfix);
   }

   public static bugfixNode newBugfix(Node node) {
   	return new bugfixNode(node);
   }

   public bugfixNode newBugfix() {
   	return new bugfixNode(graph);
   }

   public ResourceIterator<bugfixNode> findAllBugfix() { 
   	return graph.findNodes(TemplatesSwing_bugfix).map(TemplatesSwingNeo::newBugfix);
   } 

   public static boolean isGenericFix(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_genericFix);
   }

   public static genericFixNode newGenericFix(Node node) {
   	return new genericFixNode(node);
   }

   public genericFixNode newGenericFix() {
   	return new genericFixNode(graph);
   }

   public ResourceIterator<genericFixNode> findAllGenericFix() { 
   	return graph.findNodes(TemplatesSwing_genericFix).map(TemplatesSwingNeo::newGenericFix);
   } 

   public static boolean isNewAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_newAction);
   }

   public static newActionNode newNewAction(Node node) {
   	return new newActionNode(node);
   }

   public newActionNode newNewAction() {
   	return new newActionNode(graph);
   }

   public ResourceIterator<newActionNode> findAllNewAction() { 
   	return graph.findNodes(TemplatesSwing_newAction).map(TemplatesSwingNeo::newNewAction);
   } 

   public static boolean isSetStringAction(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_setStringAction);
   }

   public static setStringActionNode newSetStringAction(Node node) {
   	return new setStringActionNode(node);
   }

   public setStringActionNode newSetStringAction() {
   	return new setStringActionNode(graph);
   }

   public ResourceIterator<setStringActionNode> findAllSetStringAction() { 
   	return graph.findNodes(TemplatesSwing_setStringAction).map(TemplatesSwingNeo::newSetStringAction);
   } 

   public static boolean isStatementActions(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_statementActions);
   }

   public static statementActionsNode newStatementActions(Node node) {
   	return new statementActionsNode(node);
   }

   public statementActionsNode newStatementActions() {
   	return new statementActionsNode(graph);
   }

   public ResourceIterator<statementActionsNode> findAllStatementActions() { 
   	return graph.findNodes(TemplatesSwing_statementActions).map(TemplatesSwingNeo::newStatementActions);
   } 

   public static boolean isStringPropertyEditor(Node node) {
   	return node != null && node.hasLabel(TemplatesSwing_stringPropertyEditor);
   }

   public static stringPropertyEditorNode newStringPropertyEditor(Node node) {
   	return new stringPropertyEditorNode(node);
   }

   public stringPropertyEditorNode newStringPropertyEditor() {
   	return new stringPropertyEditorNode(graph);
   }

   public ResourceIterator<stringPropertyEditorNode> findAllStringPropertyEditor() { 
   	return graph.findNodes(TemplatesSwing_stringPropertyEditor).map(TemplatesSwingNeo::newStringPropertyEditor);
   } 

	public static final class CanvasActionStringPropertyNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private CanvasActionStringPropertyNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_CanvasActionStringProperty);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private CanvasActionStringPropertyNode(final Node node) {
			// assuming node has label TemplatesSwing_CanvasActionStringProperty
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
			CanvasActionStringPropertyNode that = (CanvasActionStringPropertyNode) o;
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
	   public CanvasActionStringPropertyNode setGroupName(Node target) {
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
	   public CanvasActionStringPropertyNode setName(Node target) {
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

		public interface CanvasActionStringPropertyNodeVisitor<T> {

			T visit(CanvasActionStringPropertyNode node);	

		}

		public <T> T visit(CanvasActionStringPropertyNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class CanvasListenerNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, statements_param
		}

		private enum StatementsRelationships implements RelationshipType {
			canvasActions
		} 

		private enum KeyValueLabels implements Label {
			Statements, 
		}

		private CanvasListenerNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_CanvasListener);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private CanvasListenerNode(final Node node) {
			// assuming node has label TemplatesSwing_CanvasListener
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
			CanvasListenerNode that = (CanvasListenerNode) o;
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
	   public CanvasListenerNode setGroupName(Node target) {
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

	   public interface StatementsKeyValue {

	   	public Node getCanvasActionsValue();

	   	public StatementsKeyValue setCanvasActionsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public CanvasListenerNode addStatementsValue(StatementsKeyValue value) {
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
	   		public Node getCanvasActionsValue() {
	   			if (!hasOutgoing(node, StatementsRelationships.canvasActions)) return null;
	   			return other(node, singleOutgoing(node, StatementsRelationships.canvasActions));
	   		} 

	   		@Override
	   		public StatementsKeyValue setCanvasActionsValue(Node value) {
	   			if (hasOutgoing(node, StatementsRelationships.canvasActions)) {
	   				final Relationship outgoing = singleOutgoing(node, StatementsRelationships.canvasActions);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, StatementsRelationships.canvasActions);

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

		public interface CanvasListenerNodeVisitor<T> {

			T visit(CanvasListenerNode node);	

		}

		public <T> T visit(CanvasListenerNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class PNodeNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private PNodeNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_PNode);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private PNodeNode(final Node node) {
			// assuming node has label TemplatesSwing_PNode
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
			PNodeNode that = (PNodeNode) o;
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
	   public PNodeNode setName(Node target) {
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

		public interface PNodeNodeVisitor<T> {

			T visit(PNodeNode node);	

		}

		public <T> T visit(PNodeNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class TemplateCanvasNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param, packageName_param, statements_param
		}

		private enum StatementsRelationships implements RelationshipType {
			name
		} 

		private enum KeyValueLabels implements Label {
			Statements, 
		}

		private TemplateCanvasNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_TemplateCanvas);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private TemplateCanvasNode(final Node node) {
			// assuming node has label TemplatesSwing_TemplateCanvas
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
			TemplateCanvasNode that = (TemplateCanvasNode) o;
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
	   public TemplateCanvasNode setGroupName(Node target) {
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
	   public TemplateCanvasNode setName(Node target) {
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
	   public TemplateCanvasNode setPackageName(Node target) {
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

	   	public Node getNameValue();

	   	public StatementsKeyValue setNameValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateCanvasNode addStatementsValue(StatementsKeyValue value) {
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

		public interface TemplateCanvasNodeVisitor<T> {

			T visit(TemplateCanvasNode node);	

		}

		public <T> T visit(TemplateCanvasNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class TemplateGroupActionsNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param, packageName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private TemplateGroupActionsNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_TemplateGroupActions);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private TemplateGroupActionsNode(final Node node) {
			// assuming node has label TemplatesSwing_TemplateGroupActions
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
			TemplateGroupActionsNode that = (TemplateGroupActionsNode) o;
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
	   public TemplateGroupActionsNode setName(Node target) {
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
	   public TemplateGroupActionsNode setPackageName(Node target) {
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

		public interface TemplateGroupActionsNodeVisitor<T> {

			T visit(TemplateGroupActionsNode node);	

		}

		public <T> T visit(TemplateGroupActionsNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class TemplatesSwingNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			canvasListener_param, groupName_param, packageName_param, statements_param
		}

		private enum StatementsRelationships implements RelationshipType {
			name, newAction
		} 

		private enum KeyValueLabels implements Label {
			Statements, 
		}

		private TemplatesSwingNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_TemplatesSwing);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private TemplatesSwingNode(final Node node) {
			// assuming node has label TemplatesSwing_TemplatesSwing
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

	   // canvasListener
	   public TemplatesSwingNode setCanvasListener(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.canvasListener_param))
	   		singleOutgoing(node, Parameters.canvasListener_param).delete();
	   	node.createRelationshipTo(target, Parameters.canvasListener_param);
	      return this;
	   }

	   public Node getCanvasListener() {
	   	if (!hasOutgoing(node, Parameters.canvasListener_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.canvasListener_param);
	   	return other(node, relationship);
	   }

	   public Relationship getCanvasListenerRelation() {
	   	if (!hasOutgoing(node, Parameters.canvasListener_param)) return null;
	   	return singleOutgoing(node, Parameters.canvasListener_param);
	   }

	   public void removeCanvasListener() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.canvasListener_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
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

		public interface TemplatesSwingNodeVisitor<T> {

			T visit(TemplatesSwingNode node);	

		}

		public <T> T visit(TemplatesSwingNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class addListActionNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param, statement_param
		}


		private enum KeyValueLabels implements Label {
		}

		private addListActionNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_addListAction);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private addListActionNode(final Node node) {
			// assuming node has label TemplatesSwing_addListAction
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
			addListActionNode that = (addListActionNode) o;
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
	   public addListActionNode setGroupName(Node target) {
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
	   public addListActionNode setName(Node target) {
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

	   // statement
	   public addListActionNode setStatement(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.statement_param))
	   		singleOutgoing(node, Parameters.statement_param).delete();
	   	node.createRelationshipTo(target, Parameters.statement_param);
	      return this;
	   }

	   public Node getStatement() {
	   	if (!hasOutgoing(node, Parameters.statement_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.statement_param);
	   	return other(node, relationship);
	   }

	   public Relationship getStatementRelation() {
	   	if (!hasOutgoing(node, Parameters.statement_param)) return null;
	   	return singleOutgoing(node, Parameters.statement_param);
	   }

	   public void removeStatement() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statement_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface addListActionNodeVisitor<T> {

			T visit(addListActionNode node);	

		}

		public <T> T visit(addListActionNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class addVerticleActionNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param, packageName_param
		}


		private enum KeyValueLabels implements Label {
		}

		private addVerticleActionNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_addVerticleAction);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private addVerticleActionNode(final Node node) {
			// assuming node has label TemplatesSwing_addVerticleAction
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

		public interface addVerticleActionNodeVisitor<T> {

			T visit(addVerticleActionNode node);	

		}

		public <T> T visit(addVerticleActionNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class bugfixNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		private bugfixNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_bugfix);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private bugfixNode(final Node node) {
			// assuming node has label TemplatesSwing_bugfix
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


		public interface bugfixNodeVisitor<T> {

			T visit(bugfixNode node);	

		}

		public <T> T visit(bugfixNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class genericFixNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		private genericFixNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_genericFix);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private genericFixNode(final Node node) {
			// assuming node has label TemplatesSwing_genericFix
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
			genericFixNode that = (genericFixNode) o;
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


		public interface genericFixNodeVisitor<T> {

			T visit(genericFixNode node);	

		}

		public <T> T visit(genericFixNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class newActionNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private newActionNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_newAction);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private newActionNode(final Node node) {
			// assuming node has label TemplatesSwing_newAction
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

		public interface newActionNodeVisitor<T> {

			T visit(newActionNode node);	

		}

		public <T> T visit(newActionNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class setStringActionNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param, statement_param
		}


		private enum KeyValueLabels implements Label {
		}

		private setStringActionNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_setStringAction);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private setStringActionNode(final Node node) {
			// assuming node has label TemplatesSwing_setStringAction
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
			setStringActionNode that = (setStringActionNode) o;
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
	   public setStringActionNode setGroupName(Node target) {
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
	   public setStringActionNode setName(Node target) {
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

	   // statement
	   public setStringActionNode setStatement(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.statement_param))
	   		singleOutgoing(node, Parameters.statement_param).delete();
	   	node.createRelationshipTo(target, Parameters.statement_param);
	      return this;
	   }

	   public Node getStatement() {
	   	if (!hasOutgoing(node, Parameters.statement_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.statement_param);
	   	return other(node, relationship);
	   }

	   public Relationship getStatementRelation() {
	   	if (!hasOutgoing(node, Parameters.statement_param)) return null;
	   	return singleOutgoing(node, Parameters.statement_param);
	   }

	   public void removeStatement() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.statement_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface setStringActionNodeVisitor<T> {

			T visit(setStringActionNode node);	

		}

		public <T> T visit(setStringActionNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class statementActionsNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			actions_param, groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private statementActionsNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_statementActions);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private statementActionsNode(final Node node) {
			// assuming node has label TemplatesSwing_statementActions
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
			statementActionsNode that = (statementActionsNode) o;
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

	   // actions
	   public statementActionsNode addActionsValue(Node target) {
	   	if (node == null) return this;
	   	if (isAlreadyRelated(node, target, Parameters.actions_param)) return this;
	   	node.createRelationshipTo(target, Parameters.actions_param);
	      return this;
	   }

	   public void forEachActions(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.actions_param))
	   		consumer.accept(other(node, relationship));
	   }

	   public void forEachActionsRelation(Consumer<Relationship> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.actions_param))
	   		consumer.accept(relationship);
	   } 

	   // groupName
	   public statementActionsNode setGroupName(Node target) {
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
	   public statementActionsNode setName(Node target) {
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

		public interface statementActionsNodeVisitor<T> {

			T visit(statementActionsNode node);	

		}

		public <T> T visit(statementActionsNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class stringPropertyEditorNode {

		// TemplatesSwing
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private stringPropertyEditorNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(TemplatesSwing_stringPropertyEditor);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private stringPropertyEditorNode(final Node node) {
			// assuming node has label TemplatesSwing_stringPropertyEditor
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

		public interface stringPropertyEditorNodeVisitor<T> {

			T visit(stringPropertyEditorNode node);	

		}

		public <T> T visit(stringPropertyEditorNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
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