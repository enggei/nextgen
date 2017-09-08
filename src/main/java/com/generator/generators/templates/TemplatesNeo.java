package com.generator.generators.templates;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.BaseDomainVisitor.*;
import static com.generator.generators.templates.TemplatesNeo.TemplatesLabels.*;

/**
 * Wraps Neo4j methods based on 'Templates.stg' file <br/>
 * 
 * todo: refactor to static methods (no need for node-encapsulation, just let clients get the NeoNodes, but static treatment of each node as a specific type
 */
public final class TemplatesNeo {

	private final GraphDatabaseService graph;

	public enum TemplatesLabels implements Label {
		Templates,   	
		Templates_BooleanTemplateParameter,
		Templates_KeyValueListTemplateParameter,
		Templates_ListTemplateParameter,
		Templates_Statement,
		Templates_StatementTemplateParameter,
		Templates_StringTemplateParameter,
		Templates_TemplateGroup,
		Templates_TemplateGroupVisitor,
		Templates_TemplateImport,
		Templates_TemplateStatement, 
		StringNode
	}

   public TemplatesNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isBooleanTemplateParameter(Node node) {
   	return node != null && node.hasLabel(Templates_BooleanTemplateParameter);
   }

   public static BooleanTemplateParameterNode newBooleanTemplateParameter(Node node) {
   	return new BooleanTemplateParameterNode(node);
   }

   public BooleanTemplateParameterNode newBooleanTemplateParameter() {
   	return new BooleanTemplateParameterNode(graph);
   }

   public ResourceIterator<BooleanTemplateParameterNode> findAllBooleanTemplateParameter() { 
   	return graph.findNodes(Templates_BooleanTemplateParameter).map(TemplatesNeo::newBooleanTemplateParameter);
   } 

   public static boolean isKeyValueListTemplateParameter(Node node) {
   	return node != null && node.hasLabel(Templates_KeyValueListTemplateParameter);
   }

   public static KeyValueListTemplateParameterNode newKeyValueListTemplateParameter(Node node) {
   	return new KeyValueListTemplateParameterNode(node);
   }

   public KeyValueListTemplateParameterNode newKeyValueListTemplateParameter() {
   	return new KeyValueListTemplateParameterNode(graph);
   }

   public ResourceIterator<KeyValueListTemplateParameterNode> findAllKeyValueListTemplateParameter() { 
   	return graph.findNodes(Templates_KeyValueListTemplateParameter).map(TemplatesNeo::newKeyValueListTemplateParameter);
   } 

   public static boolean isListTemplateParameter(Node node) {
   	return node != null && node.hasLabel(Templates_ListTemplateParameter);
   }

   public static ListTemplateParameterNode newListTemplateParameter(Node node) {
   	return new ListTemplateParameterNode(node);
   }

   public ListTemplateParameterNode newListTemplateParameter() {
   	return new ListTemplateParameterNode(graph);
   }

   public ResourceIterator<ListTemplateParameterNode> findAllListTemplateParameter() { 
   	return graph.findNodes(Templates_ListTemplateParameter).map(TemplatesNeo::newListTemplateParameter);
   } 

   public static boolean isStatement(Node node) {
   	return node != null && node.hasLabel(Templates_Statement);
   }

   public static StatementNode newStatement(Node node) {
   	return new StatementNode(node);
   }

   public StatementNode newStatement() {
   	return new StatementNode(graph);
   }

   public ResourceIterator<StatementNode> findAllStatement() { 
   	return graph.findNodes(Templates_Statement).map(TemplatesNeo::newStatement);
   } 

   public static boolean isStatementTemplateParameter(Node node) {
   	return node != null && node.hasLabel(Templates_StatementTemplateParameter);
   }

   public static StatementTemplateParameterNode newStatementTemplateParameter(Node node) {
   	return new StatementTemplateParameterNode(node);
   }

   public StatementTemplateParameterNode newStatementTemplateParameter() {
   	return new StatementTemplateParameterNode(graph);
   }

   public ResourceIterator<StatementTemplateParameterNode> findAllStatementTemplateParameter() { 
   	return graph.findNodes(Templates_StatementTemplateParameter).map(TemplatesNeo::newStatementTemplateParameter);
   } 

   public static boolean isStringTemplateParameter(Node node) {
   	return node != null && node.hasLabel(Templates_StringTemplateParameter);
   }

   public static StringTemplateParameterNode newStringTemplateParameter(Node node) {
   	return new StringTemplateParameterNode(node);
   }

   public StringTemplateParameterNode newStringTemplateParameter() {
   	return new StringTemplateParameterNode(graph);
   }

   public ResourceIterator<StringTemplateParameterNode> findAllStringTemplateParameter() { 
   	return graph.findNodes(Templates_StringTemplateParameter).map(TemplatesNeo::newStringTemplateParameter);
   } 

   public static boolean isTemplateGroup(Node node) {
   	return node != null && node.hasLabel(Templates_TemplateGroup);
   }

   public static TemplateGroupNode newTemplateGroup(Node node) {
   	return new TemplateGroupNode(node);
   }

   public TemplateGroupNode newTemplateGroup() {
   	return new TemplateGroupNode(graph);
   }

   public ResourceIterator<TemplateGroupNode> findAllTemplateGroup() { 
   	return graph.findNodes(Templates_TemplateGroup).map(TemplatesNeo::newTemplateGroup);
   } 

   public static boolean isTemplateGroupVisitor(Node node) {
   	return node != null && node.hasLabel(Templates_TemplateGroupVisitor);
   }

   public static TemplateGroupVisitorNode newTemplateGroupVisitor(Node node) {
   	return new TemplateGroupVisitorNode(node);
   }

   public TemplateGroupVisitorNode newTemplateGroupVisitor() {
   	return new TemplateGroupVisitorNode(graph);
   }

   public ResourceIterator<TemplateGroupVisitorNode> findAllTemplateGroupVisitor() { 
   	return graph.findNodes(Templates_TemplateGroupVisitor).map(TemplatesNeo::newTemplateGroupVisitor);
   } 

   public static boolean isTemplateImport(Node node) {
   	return node != null && node.hasLabel(Templates_TemplateImport);
   }

   public static TemplateImportNode newTemplateImport(Node node) {
   	return new TemplateImportNode(node);
   }

   public TemplateImportNode newTemplateImport() {
   	return new TemplateImportNode(graph);
   }

   public ResourceIterator<TemplateImportNode> findAllTemplateImport() { 
   	return graph.findNodes(Templates_TemplateImport).map(TemplatesNeo::newTemplateImport);
   } 

   public static boolean isTemplateStatement(Node node) {
   	return node != null && node.hasLabel(Templates_TemplateStatement);
   }

   public static TemplateStatementNode newTemplateStatement(Node node) {
   	return new TemplateStatementNode(node);
   }

   public TemplateStatementNode newTemplateStatement() {
   	return new TemplateStatementNode(graph);
   }

   public ResourceIterator<TemplateStatementNode> findAllTemplateStatement() { 
   	return graph.findNodes(Templates_TemplateStatement).map(TemplatesNeo::newTemplateStatement);
   } 

	public static final class BooleanTemplateParameterNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private BooleanTemplateParameterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_BooleanTemplateParameter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private BooleanTemplateParameterNode(final Node node) {
			// assuming node has label Templates_BooleanTemplateParameter
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
			BooleanTemplateParameterNode that = (BooleanTemplateParameterNode) o;
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
	   public BooleanTemplateParameterNode setName(Node target) {
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

		public interface BooleanTemplateParameterNodeVisitor<T> {

			T visit(BooleanTemplateParameterNode node);	

		}

		public <T> T visit(BooleanTemplateParameterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class KeyValueListTemplateParameterNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			kvNames_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private KeyValueListTemplateParameterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_KeyValueListTemplateParameter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private KeyValueListTemplateParameterNode(final Node node) {
			// assuming node has label Templates_KeyValueListTemplateParameter
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
			KeyValueListTemplateParameterNode that = (KeyValueListTemplateParameterNode) o;
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
	   public KeyValueListTemplateParameterNode addKvNamesValue(Node target) {
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

	   // name
	   public KeyValueListTemplateParameterNode setName(Node target) {
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

		public interface KeyValueListTemplateParameterNodeVisitor<T> {

			T visit(KeyValueListTemplateParameterNode node);	

		}

		public <T> T visit(KeyValueListTemplateParameterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class ListTemplateParameterNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			elements_param, name_param
		}

		private enum ElementsRelationships implements RelationshipType {
			type
		} 

		private enum KeyValueLabels implements Label {
			Elements, 
		}

		private ListTemplateParameterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_ListTemplateParameter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private ListTemplateParameterNode(final Node node) {
			// assuming node has label Templates_ListTemplateParameter
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
			ListTemplateParameterNode that = (ListTemplateParameterNode) o;
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

	   public interface ElementsKeyValue {

	   	public Node getTypeValue();

	   	public ElementsKeyValue setTypeValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public ListTemplateParameterNode addElementsValue(ElementsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.elements_param);
	      return this;
	   }

	   public ElementsKeyValue newElementsKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Elements);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newElementsKeyValue(node);
	   }

	   public static ElementsKeyValue newElementsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newElementsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new ElementsKeyValue() {

	   		@Override
	   		public Node getTypeValue() {
	   			if (!hasOutgoing(node, ElementsRelationships.type)) return null;
	   			return other(node, singleOutgoing(node, ElementsRelationships.type));
	   		} 

	   		@Override
	   		public ElementsKeyValue setTypeValue(Node value) {
	   			if (hasOutgoing(node, ElementsRelationships.type)) {
	   				final Relationship outgoing = singleOutgoing(node, ElementsRelationships.type);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, ElementsRelationships.type);

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

	   public void forEachElementsValue(Consumer<ElementsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.elements_param)) {
	   		consumer.accept(newElementsKeyValue(other(node, relationship)));
	   	}
	   } 

	   // name
	   public ListTemplateParameterNode setName(Node target) {
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

		public interface ListTemplateParameterNodeVisitor<T> {

			T visit(ListTemplateParameterNode node);	

		}

		public <T> T visit(ListTemplateParameterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class StatementNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			parameters_param, templateStatement_param
		}

		private enum ParametersRelationships implements RelationshipType {
			templateParameter, value
		} 

		private enum KeyValueLabels implements Label {
			Parameters, 
		}

		private StatementNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_Statement);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private StatementNode(final Node node) {
			// assuming node has label Templates_Statement
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
			StatementNode that = (StatementNode) o;
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

	   public interface ParametersKeyValue {

	   	public Node getTemplateParameterValue();

	   	public Node getValueValue();

	   	public ParametersKeyValue setTemplateParameterValue(Node value);

	   	public ParametersKeyValue setValueValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public StatementNode addParametersValue(ParametersKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.parameters_param);
	      return this;
	   }

	   public ParametersKeyValue newParametersKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Parameters);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newParametersKeyValue(node);
	   }

	   public static ParametersKeyValue newParametersKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newParametersKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new ParametersKeyValue() {

	   		@Override
	   		public Node getTemplateParameterValue() {
	   			if (!hasOutgoing(node, ParametersRelationships.templateParameter)) return null;
	   			return other(node, singleOutgoing(node, ParametersRelationships.templateParameter));
	   		} 

	   		@Override
	   		public ParametersKeyValue setTemplateParameterValue(Node value) {
	   			if (hasOutgoing(node, ParametersRelationships.templateParameter)) {
	   				final Relationship outgoing = singleOutgoing(node, ParametersRelationships.templateParameter);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, ParametersRelationships.templateParameter);

	   			return this;
	   		} 

	   		@Override
	   		public Node getValueValue() {
	   			if (!hasOutgoing(node, ParametersRelationships.value)) return null;
	   			return other(node, singleOutgoing(node, ParametersRelationships.value));
	   		} 

	   		@Override
	   		public ParametersKeyValue setValueValue(Node value) {
	   			if (hasOutgoing(node, ParametersRelationships.value)) {
	   				final Relationship outgoing = singleOutgoing(node, ParametersRelationships.value);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, ParametersRelationships.value);

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

	   public void forEachParametersValue(Consumer<ParametersKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.parameters_param)) {
	   		consumer.accept(newParametersKeyValue(other(node, relationship)));
	   	}
	   } 

	   // templateStatement
	   public StatementNode setTemplateStatement(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.templateStatement_param))
	   		singleOutgoing(node, Parameters.templateStatement_param).delete();
	   	node.createRelationshipTo(target, Parameters.templateStatement_param);
	      return this;
	   }

	   public Node getTemplateStatement() {
	   	if (!hasOutgoing(node, Parameters.templateStatement_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.templateStatement_param);
	   	return other(node, relationship);
	   }

	   public Relationship getTemplateStatementRelation() {
	   	if (!hasOutgoing(node, Parameters.templateStatement_param)) return null;
	   	return singleOutgoing(node, Parameters.templateStatement_param);
	   }

	   public void removeTemplateStatement() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.templateStatement_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface StatementNodeVisitor<T> {

			T visit(StatementNode node);	

		}

		public <T> T visit(StatementNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class StatementTemplateParameterNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private StatementTemplateParameterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_StatementTemplateParameter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private StatementTemplateParameterNode(final Node node) {
			// assuming node has label Templates_StatementTemplateParameter
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
			StatementTemplateParameterNode that = (StatementTemplateParameterNode) o;
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
	   public StatementTemplateParameterNode setName(Node target) {
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

		public interface StatementTemplateParameterNodeVisitor<T> {

			T visit(StatementTemplateParameterNode node);	

		}

		public <T> T visit(StatementTemplateParameterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class StringTemplateParameterNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param, value_param
		}


		private enum KeyValueLabels implements Label {
		}

		private StringTemplateParameterNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_StringTemplateParameter);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private StringTemplateParameterNode(final Node node) {
			// assuming node has label Templates_StringTemplateParameter
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
			StringTemplateParameterNode that = (StringTemplateParameterNode) o;
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
	   public StringTemplateParameterNode setName(Node target) {
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

	   // value
	   public StringTemplateParameterNode setValue(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.value_param))
	   		singleOutgoing(node, Parameters.value_param).delete();
	   	node.createRelationshipTo(target, Parameters.value_param);
	      return this;
	   }

	   public Node getValue() {
	   	if (!hasOutgoing(node, Parameters.value_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.value_param);
	   	return other(node, relationship);
	   }

	   public Relationship getValueRelation() {
	   	if (!hasOutgoing(node, Parameters.value_param)) return null;
	   	return singleOutgoing(node, Parameters.value_param);
	   }

	   public void removeValue() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.value_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface StringTemplateParameterNodeVisitor<T> {

			T visit(StringTemplateParameterNode node);	

		}

		public <T> T visit(StringTemplateParameterNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class TemplateGroupNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			delimiter_param, imports_param, name_param, package_param, templateStatements_param
		}


		private enum KeyValueLabels implements Label {
		}

		private TemplateGroupNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_TemplateGroup);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private TemplateGroupNode(final Node node) {
			// assuming node has label Templates_TemplateGroup
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
			TemplateGroupNode that = (TemplateGroupNode) o;
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

	   // delimiter
	   public TemplateGroupNode setDelimiter(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.delimiter_param))
	   		singleOutgoing(node, Parameters.delimiter_param).delete();
	   	node.createRelationshipTo(target, Parameters.delimiter_param);
	      return this;
	   }

	   public Node getDelimiter() {
	   	if (!hasOutgoing(node, Parameters.delimiter_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.delimiter_param);
	   	return other(node, relationship);
	   }

	   public Relationship getDelimiterRelation() {
	   	if (!hasOutgoing(node, Parameters.delimiter_param)) return null;
	   	return singleOutgoing(node, Parameters.delimiter_param);
	   }

	   public void removeDelimiter() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.delimiter_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // imports
	   public TemplateGroupNode addImportsValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.imports_param)) return this;
	   	node.createRelationshipTo(target, Parameters.imports_param);
	      return this;
	   }

	   public void forEachImports(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.imports_param))
	   		consumer.accept(other(node, relationship));
	   }

	   public void forEachImportsRelation(Consumer<Relationship> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.imports_param))
	   		consumer.accept(relationship);
	   } 

	   // name
	   public TemplateGroupNode setName(Node target) {
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

	   // package
	   public TemplateGroupNode setPackage(Node target) {
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

	   public Relationship getPackageRelation() {
	   	if (!hasOutgoing(node, Parameters.package_param)) return null;
	   	return singleOutgoing(node, Parameters.package_param);
	   }

	   public void removePackage() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.package_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // templateStatements
	   public TemplateGroupNode addTemplateStatementsValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.templateStatements_param)) return this;
	   	node.createRelationshipTo(target, Parameters.templateStatements_param);
	      return this;
	   }

	   public void forEachTemplateStatements(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.templateStatements_param))
	   		consumer.accept(other(node, relationship));
	   }

	   public void forEachTemplateStatementsRelation(Consumer<Relationship> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.templateStatements_param))
	   		consumer.accept(relationship);
	   } 

		public interface TemplateGroupNodeVisitor<T> {

			T visit(TemplateGroupNode node);	

		}

		public <T> T visit(TemplateGroupNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class TemplateGroupVisitorNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param, onBooleanTemplateParameter_param, onKeyValueListTemplateParameter_param, onListTemplateParameter_param, onStatementTemplateParameter_param, onStringTemplateParameter_param, onTemplateGroup_param, onTemplateGroupEnd_param, onTemplateStatement_param, onTemplateStatementEnd_param, packageName_param, returnProperty_param, returnType_param
		}

		private enum OnBooleanTemplateParameterRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnKeyValueListTemplateParameterRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnListTemplateParameterRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnStatementTemplateParameterRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnStringTemplateParameterRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnTemplateGroupRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnTemplateGroupEndRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnTemplateStatementRelationships implements RelationshipType {
			declaration, statements
		} 
		private enum OnTemplateStatementEndRelationships implements RelationshipType {
			declaration, statements
		} 

		private enum KeyValueLabels implements Label {
			OnBooleanTemplateParameter, OnKeyValueListTemplateParameter, OnListTemplateParameter, OnStatementTemplateParameter, OnStringTemplateParameter, OnTemplateGroup, OnTemplateGroupEnd, OnTemplateStatement, OnTemplateStatementEnd, 
		}

		private TemplateGroupVisitorNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_TemplateGroupVisitor);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private TemplateGroupVisitorNode(final Node node) {
			// assuming node has label Templates_TemplateGroupVisitor
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
			TemplateGroupVisitorNode that = (TemplateGroupVisitorNode) o;
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
	   public TemplateGroupVisitorNode setName(Node target) {
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

	   public interface OnBooleanTemplateParameterKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnBooleanTemplateParameterKeyValue setDeclarationValue(Node value);

	   	public OnBooleanTemplateParameterKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnBooleanTemplateParameterValue(OnBooleanTemplateParameterKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onBooleanTemplateParameter_param);
	      return this;
	   }

	   public OnBooleanTemplateParameterKeyValue newOnBooleanTemplateParameterKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnBooleanTemplateParameter);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnBooleanTemplateParameterKeyValue(node);
	   }

	   public static OnBooleanTemplateParameterKeyValue newOnBooleanTemplateParameterKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnBooleanTemplateParameterKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnBooleanTemplateParameterKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnBooleanTemplateParameterRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnBooleanTemplateParameterRelationships.declaration));
	   		} 

	   		@Override
	   		public OnBooleanTemplateParameterKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnBooleanTemplateParameterRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnBooleanTemplateParameterRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnBooleanTemplateParameterRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnBooleanTemplateParameterRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnBooleanTemplateParameterRelationships.statements));
	   		} 

	   		@Override
	   		public OnBooleanTemplateParameterKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnBooleanTemplateParameterRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnBooleanTemplateParameterRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnBooleanTemplateParameterRelationships.statements);

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

	   public void forEachOnBooleanTemplateParameterValue(Consumer<OnBooleanTemplateParameterKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onBooleanTemplateParameter_param)) {
	   		consumer.accept(newOnBooleanTemplateParameterKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnKeyValueListTemplateParameterKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnKeyValueListTemplateParameterKeyValue setDeclarationValue(Node value);

	   	public OnKeyValueListTemplateParameterKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnKeyValueListTemplateParameterValue(OnKeyValueListTemplateParameterKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onKeyValueListTemplateParameter_param);
	      return this;
	   }

	   public OnKeyValueListTemplateParameterKeyValue newOnKeyValueListTemplateParameterKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnKeyValueListTemplateParameter);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnKeyValueListTemplateParameterKeyValue(node);
	   }

	   public static OnKeyValueListTemplateParameterKeyValue newOnKeyValueListTemplateParameterKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnKeyValueListTemplateParameterKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnKeyValueListTemplateParameterKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnKeyValueListTemplateParameterRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnKeyValueListTemplateParameterRelationships.declaration));
	   		} 

	   		@Override
	   		public OnKeyValueListTemplateParameterKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnKeyValueListTemplateParameterRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnKeyValueListTemplateParameterRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnKeyValueListTemplateParameterRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnKeyValueListTemplateParameterRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnKeyValueListTemplateParameterRelationships.statements));
	   		} 

	   		@Override
	   		public OnKeyValueListTemplateParameterKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnKeyValueListTemplateParameterRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnKeyValueListTemplateParameterRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnKeyValueListTemplateParameterRelationships.statements);

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

	   public void forEachOnKeyValueListTemplateParameterValue(Consumer<OnKeyValueListTemplateParameterKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onKeyValueListTemplateParameter_param)) {
	   		consumer.accept(newOnKeyValueListTemplateParameterKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnListTemplateParameterKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnListTemplateParameterKeyValue setDeclarationValue(Node value);

	   	public OnListTemplateParameterKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnListTemplateParameterValue(OnListTemplateParameterKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onListTemplateParameter_param);
	      return this;
	   }

	   public OnListTemplateParameterKeyValue newOnListTemplateParameterKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnListTemplateParameter);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnListTemplateParameterKeyValue(node);
	   }

	   public static OnListTemplateParameterKeyValue newOnListTemplateParameterKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnListTemplateParameterKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnListTemplateParameterKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnListTemplateParameterRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnListTemplateParameterRelationships.declaration));
	   		} 

	   		@Override
	   		public OnListTemplateParameterKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnListTemplateParameterRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnListTemplateParameterRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnListTemplateParameterRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnListTemplateParameterRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnListTemplateParameterRelationships.statements));
	   		} 

	   		@Override
	   		public OnListTemplateParameterKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnListTemplateParameterRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnListTemplateParameterRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnListTemplateParameterRelationships.statements);

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

	   public void forEachOnListTemplateParameterValue(Consumer<OnListTemplateParameterKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onListTemplateParameter_param)) {
	   		consumer.accept(newOnListTemplateParameterKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnStatementTemplateParameterKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnStatementTemplateParameterKeyValue setDeclarationValue(Node value);

	   	public OnStatementTemplateParameterKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnStatementTemplateParameterValue(OnStatementTemplateParameterKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onStatementTemplateParameter_param);
	      return this;
	   }

	   public OnStatementTemplateParameterKeyValue newOnStatementTemplateParameterKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnStatementTemplateParameter);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnStatementTemplateParameterKeyValue(node);
	   }

	   public static OnStatementTemplateParameterKeyValue newOnStatementTemplateParameterKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnStatementTemplateParameterKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnStatementTemplateParameterKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnStatementTemplateParameterRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnStatementTemplateParameterRelationships.declaration));
	   		} 

	   		@Override
	   		public OnStatementTemplateParameterKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnStatementTemplateParameterRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnStatementTemplateParameterRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnStatementTemplateParameterRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnStatementTemplateParameterRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnStatementTemplateParameterRelationships.statements));
	   		} 

	   		@Override
	   		public OnStatementTemplateParameterKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnStatementTemplateParameterRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnStatementTemplateParameterRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnStatementTemplateParameterRelationships.statements);

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

	   public void forEachOnStatementTemplateParameterValue(Consumer<OnStatementTemplateParameterKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onStatementTemplateParameter_param)) {
	   		consumer.accept(newOnStatementTemplateParameterKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnStringTemplateParameterKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnStringTemplateParameterKeyValue setDeclarationValue(Node value);

	   	public OnStringTemplateParameterKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnStringTemplateParameterValue(OnStringTemplateParameterKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onStringTemplateParameter_param);
	      return this;
	   }

	   public OnStringTemplateParameterKeyValue newOnStringTemplateParameterKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnStringTemplateParameter);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnStringTemplateParameterKeyValue(node);
	   }

	   public static OnStringTemplateParameterKeyValue newOnStringTemplateParameterKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnStringTemplateParameterKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnStringTemplateParameterKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnStringTemplateParameterRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnStringTemplateParameterRelationships.declaration));
	   		} 

	   		@Override
	   		public OnStringTemplateParameterKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnStringTemplateParameterRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnStringTemplateParameterRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnStringTemplateParameterRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnStringTemplateParameterRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnStringTemplateParameterRelationships.statements));
	   		} 

	   		@Override
	   		public OnStringTemplateParameterKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnStringTemplateParameterRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnStringTemplateParameterRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnStringTemplateParameterRelationships.statements);

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

	   public void forEachOnStringTemplateParameterValue(Consumer<OnStringTemplateParameterKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onStringTemplateParameter_param)) {
	   		consumer.accept(newOnStringTemplateParameterKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnTemplateGroupKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnTemplateGroupKeyValue setDeclarationValue(Node value);

	   	public OnTemplateGroupKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnTemplateGroupValue(OnTemplateGroupKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onTemplateGroup_param);
	      return this;
	   }

	   public OnTemplateGroupKeyValue newOnTemplateGroupKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnTemplateGroup);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnTemplateGroupKeyValue(node);
	   }

	   public static OnTemplateGroupKeyValue newOnTemplateGroupKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnTemplateGroupKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnTemplateGroupKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnTemplateGroupRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateGroupRelationships.declaration));
	   		} 

	   		@Override
	   		public OnTemplateGroupKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateGroupRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateGroupRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateGroupRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnTemplateGroupRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateGroupRelationships.statements));
	   		} 

	   		@Override
	   		public OnTemplateGroupKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateGroupRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateGroupRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateGroupRelationships.statements);

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

	   public void forEachOnTemplateGroupValue(Consumer<OnTemplateGroupKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onTemplateGroup_param)) {
	   		consumer.accept(newOnTemplateGroupKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnTemplateGroupEndKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnTemplateGroupEndKeyValue setDeclarationValue(Node value);

	   	public OnTemplateGroupEndKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnTemplateGroupEndValue(OnTemplateGroupEndKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onTemplateGroupEnd_param);
	      return this;
	   }

	   public OnTemplateGroupEndKeyValue newOnTemplateGroupEndKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnTemplateGroupEnd);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnTemplateGroupEndKeyValue(node);
	   }

	   public static OnTemplateGroupEndKeyValue newOnTemplateGroupEndKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnTemplateGroupEndKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnTemplateGroupEndKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnTemplateGroupEndRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateGroupEndRelationships.declaration));
	   		} 

	   		@Override
	   		public OnTemplateGroupEndKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateGroupEndRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateGroupEndRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateGroupEndRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnTemplateGroupEndRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateGroupEndRelationships.statements));
	   		} 

	   		@Override
	   		public OnTemplateGroupEndKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateGroupEndRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateGroupEndRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateGroupEndRelationships.statements);

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

	   public void forEachOnTemplateGroupEndValue(Consumer<OnTemplateGroupEndKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onTemplateGroupEnd_param)) {
	   		consumer.accept(newOnTemplateGroupEndKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnTemplateStatementKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnTemplateStatementKeyValue setDeclarationValue(Node value);

	   	public OnTemplateStatementKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnTemplateStatementValue(OnTemplateStatementKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onTemplateStatement_param);
	      return this;
	   }

	   public OnTemplateStatementKeyValue newOnTemplateStatementKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnTemplateStatement);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnTemplateStatementKeyValue(node);
	   }

	   public static OnTemplateStatementKeyValue newOnTemplateStatementKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnTemplateStatementKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnTemplateStatementKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnTemplateStatementRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateStatementRelationships.declaration));
	   		} 

	   		@Override
	   		public OnTemplateStatementKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateStatementRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateStatementRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateStatementRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnTemplateStatementRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateStatementRelationships.statements));
	   		} 

	   		@Override
	   		public OnTemplateStatementKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateStatementRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateStatementRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateStatementRelationships.statements);

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

	   public void forEachOnTemplateStatementValue(Consumer<OnTemplateStatementKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onTemplateStatement_param)) {
	   		consumer.accept(newOnTemplateStatementKeyValue(other(node, relationship)));
	   	}
	   } 

	   public interface OnTemplateStatementEndKeyValue {

	   	public Node getDeclarationValue();

	   	public Node getStatementsValue();

	   	public OnTemplateStatementEndKeyValue setDeclarationValue(Node value);

	   	public OnTemplateStatementEndKeyValue setStatementsValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public TemplateGroupVisitorNode addOnTemplateStatementEndValue(OnTemplateStatementEndKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.onTemplateStatementEnd_param);
	      return this;
	   }

	   public OnTemplateStatementEndKeyValue newOnTemplateStatementEndKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.OnTemplateStatementEnd);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newOnTemplateStatementEndKeyValue(node);
	   }

	   public static OnTemplateStatementEndKeyValue newOnTemplateStatementEndKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newOnTemplateStatementEndKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new OnTemplateStatementEndKeyValue() {

	   		@Override
	   		public Node getDeclarationValue() {
	   			if (!hasOutgoing(node, OnTemplateStatementEndRelationships.declaration)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateStatementEndRelationships.declaration));
	   		} 

	   		@Override
	   		public OnTemplateStatementEndKeyValue setDeclarationValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateStatementEndRelationships.declaration)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateStatementEndRelationships.declaration);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateStatementEndRelationships.declaration);

	   			return this;
	   		} 

	   		@Override
	   		public Node getStatementsValue() {
	   			if (!hasOutgoing(node, OnTemplateStatementEndRelationships.statements)) return null;
	   			return other(node, singleOutgoing(node, OnTemplateStatementEndRelationships.statements));
	   		} 

	   		@Override
	   		public OnTemplateStatementEndKeyValue setStatementsValue(Node value) {
	   			if (hasOutgoing(node, OnTemplateStatementEndRelationships.statements)) {
	   				final Relationship outgoing = singleOutgoing(node, OnTemplateStatementEndRelationships.statements);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, OnTemplateStatementEndRelationships.statements);

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

	   public void forEachOnTemplateStatementEndValue(Consumer<OnTemplateStatementEndKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.onTemplateStatementEnd_param)) {
	   		consumer.accept(newOnTemplateStatementEndKeyValue(other(node, relationship)));
	   	}
	   } 

	   // packageName
	   public TemplateGroupVisitorNode setPackageName(Node target) {
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

	   // returnProperty
	   public TemplateGroupVisitorNode setReturnProperty(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.returnProperty_param))
	   		singleOutgoing(node, Parameters.returnProperty_param).delete();
	   	node.createRelationshipTo(target, Parameters.returnProperty_param);
	      return this;
	   }

	   public Node getReturnProperty() {
	   	if (!hasOutgoing(node, Parameters.returnProperty_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.returnProperty_param);
	   	return other(node, relationship);
	   }

	   public Relationship getReturnPropertyRelation() {
	   	if (!hasOutgoing(node, Parameters.returnProperty_param)) return null;
	   	return singleOutgoing(node, Parameters.returnProperty_param);
	   }

	   public void removeReturnProperty() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.returnProperty_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // returnType
	   public TemplateGroupVisitorNode setReturnType(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.returnType_param))
	   		singleOutgoing(node, Parameters.returnType_param).delete();
	   	node.createRelationshipTo(target, Parameters.returnType_param);
	      return this;
	   }

	   public Node getReturnType() {
	   	if (!hasOutgoing(node, Parameters.returnType_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.returnType_param);
	   	return other(node, relationship);
	   }

	   public Relationship getReturnTypeRelation() {
	   	if (!hasOutgoing(node, Parameters.returnType_param)) return null;
	   	return singleOutgoing(node, Parameters.returnType_param);
	   }

	   public void removeReturnType() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.returnType_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface TemplateGroupVisitorNodeVisitor<T> {

			T visit(TemplateGroupVisitorNode node);	

		}

		public <T> T visit(TemplateGroupVisitorNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class TemplateImportNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private TemplateImportNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_TemplateImport);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private TemplateImportNode(final Node node) {
			// assuming node has label Templates_TemplateImport
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
			TemplateImportNode that = (TemplateImportNode) o;
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
	   public TemplateImportNode setName(Node target) {
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

		public interface TemplateImportNodeVisitor<T> {

			T visit(TemplateImportNode node);	

		}

		public <T> T visit(TemplateImportNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class TemplateStatementNode {

		// Templates
	   private final Node node;
		private final UUID uuid;

		public enum Parameters implements RelationshipType {
			name_param, templateParameters_param, text_param
		}


		private enum KeyValueLabels implements Label {
		}

		private TemplateStatementNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Templates_TemplateStatement);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private TemplateStatementNode(final Node node) {
			// assuming node has label Templates_TemplateStatement
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
			TemplateStatementNode that = (TemplateStatementNode) o;
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
	   public TemplateStatementNode setName(Node target) {
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

	   // templateParameters
	   public TemplateStatementNode addTemplateParametersValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.templateParameters_param)) return this;
	   	node.createRelationshipTo(target, Parameters.templateParameters_param);
	      return this;
	   }

	   public void forEachTemplateParameters(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.templateParameters_param))
	   		consumer.accept(other(node, relationship));
	   }

	   public void forEachTemplateParametersRelation(Consumer<Relationship> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.templateParameters_param))
	   		consumer.accept(relationship);
	   } 

	   // text
	   public TemplateStatementNode setText(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.text_param))
	   		singleOutgoing(node, Parameters.text_param).delete();
	   	node.createRelationshipTo(target, Parameters.text_param);
	      return this;
	   }

	   public Node getText() {
	   	if (!hasOutgoing(node, Parameters.text_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.text_param);
	   	return other(node, relationship);
	   }

	   public Relationship getTextRelation() {
	   	if (!hasOutgoing(node, Parameters.text_param)) return null;
	   	return singleOutgoing(node, Parameters.text_param);
	   }

	   public void removeText() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.text_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface TemplateStatementNodeVisitor<T> {

			T visit(TemplateStatementNode node);	

		}

		public <T> T visit(TemplateStatementNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public interface TemplatesNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(TemplatesNeoAction committer) {
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