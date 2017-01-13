package com.generator.generators.junit;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.junit.JunitNeo.JunitLabels.*;

/**
 * Wraps Neo4j methods based on 'Junit.stg' file <br/>
 * 
 * todo: refactor to static methods (no need for node-encapsulation, just let clients get the NeoNodes, but static treatment of each node as a specific type
 */
public final class JunitNeo {

	private final GraphDatabaseService graph;

	public enum JunitLabels implements Label {
		Junit,   	
		Junit_mvn,
		Junit_templateGroupTest,
		Junit_templateNeoTest,
		Junit_test,
		Junit_tests, 
		StringNode
	}

   public JunitNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isMvn(Node node) {
   	return node != null && node.hasLabel(Junit_mvn);
   }

   public static mvnNode newMvn(Node node) {
   	return new mvnNode(node);
   }

   public mvnNode newMvn() {
   	return new mvnNode(graph);
   }

   public ResourceIterator<mvnNode> findAllMvn() { 
   	return graph.findNodes(Junit_mvn).map(JunitNeo::newMvn);
   } 

   public static boolean isTemplateGroupTest(Node node) {
   	return node != null && node.hasLabel(Junit_templateGroupTest);
   }

   public static templateGroupTestNode newTemplateGroupTest(Node node) {
   	return new templateGroupTestNode(node);
   }

   public templateGroupTestNode newTemplateGroupTest() {
   	return new templateGroupTestNode(graph);
   }

   public ResourceIterator<templateGroupTestNode> findAllTemplateGroupTest() { 
   	return graph.findNodes(Junit_templateGroupTest).map(JunitNeo::newTemplateGroupTest);
   } 

   public static boolean isTemplateNeoTest(Node node) {
   	return node != null && node.hasLabel(Junit_templateNeoTest);
   }

   public static templateNeoTestNode newTemplateNeoTest(Node node) {
   	return new templateNeoTestNode(node);
   }

   public templateNeoTestNode newTemplateNeoTest() {
   	return new templateNeoTestNode(graph);
   }

   public ResourceIterator<templateNeoTestNode> findAllTemplateNeoTest() { 
   	return graph.findNodes(Junit_templateNeoTest).map(JunitNeo::newTemplateNeoTest);
   } 

   public static boolean isTest(Node node) {
   	return node != null && node.hasLabel(Junit_test);
   }

   public static testNode newTest(Node node) {
   	return new testNode(node);
   }

   public testNode newTest() {
   	return new testNode(graph);
   }

   public ResourceIterator<testNode> findAllTest() { 
   	return graph.findNodes(Junit_test).map(JunitNeo::newTest);
   } 

   public static boolean isTests(Node node) {
   	return node != null && node.hasLabel(Junit_tests);
   }

   public static testsNode newTests(Node node) {
   	return new testsNode(node);
   }

   public testsNode newTests() {
   	return new testsNode(graph);
   }

   public ResourceIterator<testsNode> findAllTests() { 
   	return graph.findNodes(Junit_tests).map(JunitNeo::newTests);
   } 

	public static final class mvnNode {

		// Junit
	   private final Node node;
		private final UUID uuid;

		private mvnNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Junit_mvn);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private mvnNode(final Node node) {
			// assuming node has label Junit_mvn
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
			mvnNode that = (mvnNode) o;
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


		public interface mvnNodeVisitor<T> {

			T visit(mvnNode node);	

		}

		public <T> T visit(mvnNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class templateGroupTestNode {

		// Junit
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			groupName_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private templateGroupTestNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Junit_templateGroupTest);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private templateGroupTestNode(final Node node) {
			// assuming node has label Junit_templateGroupTest
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
			templateGroupTestNode that = (templateGroupTestNode) o;
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
	   public templateGroupTestNode setGroupName(Node target) {
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
	   public templateGroupTestNode setName(Node target) {
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

		public interface templateGroupTestNodeVisitor<T> {

			T visit(templateGroupTestNode node);	

		}

		public <T> T visit(templateGroupTestNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class templateNeoTestNode {

		// Junit
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			dbPath_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private templateNeoTestNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Junit_templateNeoTest);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private templateNeoTestNode(final Node node) {
			// assuming node has label Junit_templateNeoTest
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
			templateNeoTestNode that = (templateNeoTestNode) o;
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

	   // dbPath
	   public templateNeoTestNode setDbPath(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.dbPath_param))
	   		singleOutgoing(node, Parameters.dbPath_param).delete();
	   	node.createRelationshipTo(target, Parameters.dbPath_param);
	      return this;
	   }

	   public Node getDbPath() {
	   	if (!hasOutgoing(node, Parameters.dbPath_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.dbPath_param);
	   	return other(node, relationship);
	   }

	   public void removeDbPath() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.dbPath_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public templateNeoTestNode setName(Node target) {
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

		public interface templateNeoTestNodeVisitor<T> {

			T visit(templateNeoTestNode node);	

		}

		public <T> T visit(templateNeoTestNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class testNode {

		// Junit
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, statements_param
		}


		private enum KeyValueLabels implements Label {
		}

		private testNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Junit_test);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private testNode(final Node node) {
			// assuming node has label Junit_test
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
			testNode that = (testNode) o;
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
	   public testNode setName(Node target) {
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

	   // statements
	   public testNode addStatementsValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.statements_param)) return this;
	   	node.createRelationshipTo(target, Parameters.statements_param);
	      return this;
	   }

	   public void forEachStatements(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.statements_param))
	   		consumer.accept(other(node, relationship));
	   } 

		public interface testNodeVisitor<T> {

			T visit(testNode node);	

		}

		public <T> T visit(testNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class testsNode {

		// Junit
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			imports_param, name_param, package_param, packageName_param, tests_param
		}


		private enum KeyValueLabels implements Label {
		}

		private testsNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Junit_tests);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private testsNode(final Node node) {
			// assuming node has label Junit_tests
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
			testsNode that = (testsNode) o;
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

	   // imports
	   public testsNode addImportsValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.imports_param)) return this;
	   	node.createRelationshipTo(target, Parameters.imports_param);
	      return this;
	   }

	   public void forEachImports(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.imports_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   // name
	   public testsNode setName(Node target) {
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

	   // package
	   public testsNode setPackage(Node target) {
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

	   // packageName
	   public testsNode setPackageName(Node target) {
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

	   // tests
	   public testsNode addTestsValue(Node target) {
	   	if (node == null) return this;
	   	if (isRelated(node, target, Parameters.tests_param)) return this;
	   	node.createRelationshipTo(target, Parameters.tests_param);
	      return this;
	   }

	   public void forEachTests(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.tests_param))
	   		consumer.accept(other(node, relationship));
	   } 

		public interface testsNodeVisitor<T> {

			T visit(testsNode node);	

		}

		public <T> T visit(testsNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public interface JunitNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(JunitNeoAction committer) {
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