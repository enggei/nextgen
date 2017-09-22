package com.generator.neo.remote;

import org.jetbrains.annotations.NotNull;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.exceptions.ServiceUnavailableException;
import org.neo4j.driver.v1.summary.Notification;
import org.neo4j.driver.v1.summary.ResultSummary;
import org.neo4j.driver.v1.types.Entity;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.neo4j.graphdb.Direction;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static com.generator.neo.remote.NeoNode.*;
import static com.generator.util.NeoUtil.TAG_UUID;
import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by Ernst Sognnes on 08.07.17.
 */
public class NeoDriver implements AutoCloseable {

   public static final String CYPHER_DROP_ALL = "MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n, r";

   private static void ignoreUpdate(NeoTransactionContext context, StatementResult data) {
   }

   interface NodeWithRelationships {
      Node node();
      Collection<Relationship> relationships();
   }

   @FunctionalInterface
   interface ContextUpdater<Context, T> {
      void update(Context context, T data);
   }

   protected final URI uri;
   private final Driver driver;

   // TODO: Multiple session transactions
   private NeoTransaction transaction;	// Current transaction

   protected NeoTransactionEventHandler txEventHandler = new NeoTransactionEventHandler();

   public NeoDriver(URI uri, String username, String password) {
      this.uri = uri;
      this.driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
   }

   @Override
   public void close() {
      System.out.println("closing database connection " + uri);
      driver.close();
   }

   public void addIndex(final String label, final String property) {
      executeCypher("CREATE INDEX ON :" + label + "(" + property + ")");
   }

   public void dropIndex(final String label, final String property) {
      executeCypher("DROP INDEX ON :" + label + "(" + property + ")");
   }

   public void addConstraintUnique(final String label, final String property) {
      executeCypher("CREATE CONSTRAINT ON (n:" + label + ") ASSERT n." + property + " IS UNIQUE");
   }

   public void dropConstraintUnique(final String label, final String property) {
      executeCypher("DROP CONSTRAINT ON (n:" + label + ") ASSERT n." + property + " IS UNIQUE");
   }

   /// neo4j Enterprise Edition only
   public void addConstraintPropertyExists(final String label, final String property) {
      executeCypher("CREATE CONSTRAINT ON (n:" + label + ") ASSERT exists(n." + property + ")");
   }

   /// neo4j Enterprise Edition only
   public void dropConstraintPropertyExists(final String label, final String property) {
      executeCypher("DROP CONSTRAINT ON (n:" + label + ") ASSERT exists(n." + property + ")");
   }

   /// neo4j Enterprise Edition only
   public void addConstraintRelationshipPropertyExists(final String type, final String property) {
      executeCypher("CREATE CONSTRAINT ON ()-[r:" + type + "]-() ASSERT exists(r." + property + ")");
   }

   /// neo4j Enterprise Edition only
   public void dropConstraintRelationshipPropertyExists(final String type, final String property) {
      executeCypher("DROP CONSTRAINT ON ()-[r:" + type + "]-() ASSERT exists(r." + property + ")");
   }

   NeoTransaction beginTransaction() {
      if (inTransaction()) {
         System.out.println("beginTransaction: closing current open tx");
         transaction.close();   // Close if open
      }

      return getTransaction();	// New or continue
   }

   protected boolean inTransaction() {
      System.out.println("inTransaction: " + (transaction != null && transaction.isOpen() ? "YES" : "NO"));
      return transaction != null && transaction.isOpen();
   }

   protected void closeTransaction() {
      if (transaction == null) return;		// Nothing to end

      transaction.close();
   }

   private NeoTransaction getTransaction() {
      if (!inTransaction()) {
         transaction = new NeoTransaction(this, driver.session().beginTransaction());
         System.out.println("getTransaction: new tx");
         return transaction;
      }

      System.out.println("getTransaction: continue current tx");
      return transaction;	// Continue using open transaction
   }

   public StatementResult executeCypher(final String cypher) {
      return executeCypher(new Statement(cypher));
   }

   protected StatementResult executeCypher(final Statement statement) {
      return writeTransaction(tx -> {
         System.out.println("executeCypher: " + statement.toString());
         try ( Session session = driver.session() ) {
            return session.run(statement);
         }
         catch (ServiceUnavailableException e) {
            System.err.println(e.getMessage());
            throw e;
         }

      }, NeoDriver::ignoreUpdate);
   }

   public Node readSingleNode(final String cypher) {
      return readTransaction(tx -> readSingleNode(tx, new Statement(cypher)));
   }

   public Node readSingleNode(final Statement statement) {
      return readTransaction(tx -> readSingleNode(tx, statement));
   }

   static Node readSingleNode(Transaction tx, final Statement statement) {
      System.out.println("readSingleNode: " + statement.toString());
      StatementResult result = tx.run(statement);
//		System.out.println("readSingleNode summary: " + debugSummary(result.summary()));
      if (!result.hasNext()) return null;

      return result.single().get(0).asNode();
   }

   public NodeWithRelationships readSingleNodeWithRelationships(final String cypher) {
      return readTransaction(tx -> readSingleNodeWithRelationships(tx, new Statement(cypher)));
   }

   public NodeWithRelationships readSingleNodeWithRelationships(final Statement statement) {
      return readTransaction(tx -> readSingleNodeWithRelationships(tx, statement));
   }

   static NodeWithRelationships readSingleNodeWithRelationships(Transaction tx, final Statement statement) {
      System.out.println("readSingleNodeWithRelationships: " + statement.toString());
      StatementResult result = tx.run(statement);
//		System.out.println("readSingleNodeWithRelationships summary: " + debugSummary(result.summary()));
      if (!result.hasNext()) return null;

      final Record first = result.next();

      final Node node = first.get(0).asNode();
      final Collection<Relationship> relationships = new LinkedHashSet<>();

      if (!first.get(1).isNull()) {
         relationships.add(first.get(1).asRelationship());

         result.forEachRemaining(record -> relationships.add(record.get(1).asRelationship()));
      }

      return new NodeWithRelationships() {
         @Override
         public Node node() {
            return node;
         }

         @Override
         public Collection<Relationship> relationships() {
            return relationships;
         }
      };
   }

   Collection<Node> readNodes(final String cypher) {
      return readTransaction(tx -> readNodes(tx, new Statement(cypher)));
   }

   Collection<Node> readNodes(final Statement statement) {
      return readTransaction(tx -> readNodes(tx, statement));
   }

   static Collection<Node> readNodes(Transaction tx, final Statement statement) {
      Collection<Node> nodes = new LinkedHashSet<>();

      System.out.println("readNodes: " + statement.toString());
      StatementResult result = tx.run(statement);
//		System.out.println("readNodes summary: " + debugSummary(result.summary()));

      nodes.addAll(result.list(record -> record.get(0).asNode()));

      return nodes;
   }

   Collection<NodeWithRelationships> readNodesWithRelationships(final String cypher) {
      return readTransaction(tx -> readNodesWithRelationships(tx, new Statement(cypher)));
   }

   public Collection<NodeWithRelationships> readNodesWithRelationships(final Statement statement) {
      return readTransaction(tx -> readNodesWithRelationships(tx, statement));
   }

   static Collection<NodeWithRelationships> readNodesWithRelationships(Transaction tx, final Statement statement) {
      Collection<NodeWithRelationships> nodesWithRelationships = new LinkedHashSet<>();

      System.out.println("readNodesWithRelationships: " + statement.toString());
      StatementResult result = tx.run(statement);
//		System.out.println("readNodesWithRelationships summary: " + debugSummary(result.summary()));

      if (!result.hasNext()) return nodesWithRelationships;

      final Map<Node, Collection<Relationship>> resultSet = new LinkedHashMap<>();

      result.forEachRemaining(record -> {
         Node node = record.get(0).asNode();
         if (!resultSet.containsKey(node)) resultSet.put(node, new LinkedHashSet<>());

         Collection<Relationship> relationships = resultSet.get(node);

         if (!record.get(1).isNull()) relationships.add(record.get(1).asRelationship());
      });

      resultSet.forEach((node, relationships) -> nodesWithRelationships.add(new NodeWithRelationships() {
         @Override
         public Node node() {
            return node;
         }

         @Override
         public Collection<Relationship> relationships() {
            return relationships;
         }
      }));

      return nodesWithRelationships;
   }

   Relationship readSingleRelationship(final String cypher) {
      return readTransaction(tx -> readSingleRelationship(tx, new Statement(cypher)));
   }

   Relationship readSingleRelationship(final Statement statement) {
      return readTransaction(tx -> readSingleRelationship(tx, statement));
   }

   static Relationship readSingleRelationship(Transaction tx, final Statement statement) {
      System.out.println("readSingleRelationship: " + statement.toString());
      StatementResult result = tx.run(statement);
//		System.out.println("readSingleRelationship summary: " + debugSummary(result.summary()));
      if (!result.hasNext()) return null;

      return result.single().get(0).asRelationship();
   }

   Collection<Relationship> readRelationships(final String cypher) {
      return readTransaction(tx -> readRelationships(tx, new Statement(cypher)));
   }

   Collection<Relationship> readRelationships(final Statement statement) {
      return readTransaction(tx -> readRelationships(tx, statement));
   }

   static Collection<Relationship> readRelationships(Transaction tx, final Statement statement) {
      Collection<Relationship> relationships = new LinkedHashSet<>();

      System.out.println("readRelationships: " + statement.toString());
      StatementResult result = tx.run(statement);
//		System.out.println("readRelationships summary: " + debugSummary(result.summary()));

      relationships.addAll(result.list(record -> record.get(0).asRelationship()));

      return relationships;
   }

   Collection<String> readSingleStringColumn(final String cypher) {
      return readTransaction(tx -> readSingleStringColumn(tx, new Statement(cypher)));
   }

   Collection<String> readSingleStringColumn(final Statement statement) {
      return readTransaction(tx -> readSingleStringColumn(tx, statement));
   }

   static Collection<String> readSingleStringColumn(Transaction tx, final Statement statement) {
      Collection<String> data = new LinkedHashSet<>();

      System.out.println("readSingleStringColumn: " + statement.toString());
      StatementResult result = tx.run(statement);
//		System.out.println("readSingleStringColumn summary: " + debugSummary(result.summary()));

      data.addAll(result.list(record -> record.get(0).asString()));

      return data;
   }

   protected <T> T readTransaction(TransactionWork<T> transactionWork) {
      if (inTransaction())
         return transactionWork.execute(getTransaction().getTx());
      else
         try ( Session session = driver.session() ) {
            return readTransaction(session, transactionWork);
         }
         catch (ServiceUnavailableException e) {
            System.err.println(e.getMessage());
            throw e;
         }
   }

   static <T> T readTransaction(Session session, TransactionWork<T> transactionWork) {
      return session.readTransaction(transactionWork::execute);
   }

   private <T> T writeTransaction(TransactionWork<T> transactionWork, ContextUpdater<NeoTransactionContext, T> updater) {
      if (inTransaction()) {
         T t = transactionWork.execute(getTransaction().getTx());
         updater.update(getTransaction().getContext(), t);
         return t;
      }

      try ( Session session = driver.session() ) {
         return writeTransaction(session, transactionWork);
      }
      catch (ServiceUnavailableException e) {
         System.err.println(e.getMessage());
         throw e;
      }
   }

   static <T> T writeTransaction(Session session, TransactionWork<T> transactionWork) {
      return session.writeTransaction(transactionWork::execute);
   }

   @Deprecated
   public Node getSingleNode(long id) {
      return readSingleNode(new Statement("MATCH (n) WHERE ID(n) = $id RETURN n",
            parameters("id", id)));
   }

   public Node getSingleNode(@NotNull final String label, @NotNull UUID uuid) {
      return readSingleNode(new Statement("MATCH (n:" + label + " {" + TAG_UUID + ": $uuid}) RETURN n",
            parameters("uuid", uuid.toString())));
   }

   public Node getSingleNode(@NotNull UUID uuid) {
      return readSingleNode(new Statement("MATCH (n {" + TAG_UUID + ": $uuid}) RETURN n",
            parameters("uuid", uuid.toString())));
   }

   public Node getSingleNode(@NotNull final String label1, @NotNull final String label2, @NotNull final UUID uuid) {
      return getSingleNode(label1 + ":" + label2, uuid);
   }

   public Node getSingleNode(@NotNull final List<String> labels, @NotNull final UUID uuid) {
      return getSingleNode(labels.stream().collect(Collectors.joining(":")), uuid);
   }

   public Node getSingleNode(@NotNull final String[] labels, @NotNull final UUID uuid) {
      return getSingleNode(Arrays.stream(labels).collect(Collectors.joining(":")), uuid);
   }

   @Deprecated
   public NodeWithRelationships getSingleNodeWithRelationships(long id) {
      return readSingleNodeWithRelationships(new Statement("MATCH (n) WHERE ID(n) = $id OPTIONAL MATCH (n)-[rel]-(o) RETURN n, rel",
            parameters("id", id)));
   }

   public NodeWithRelationships getSingleNodeWithRelationships(@NotNull final String label, @NotNull UUID uuid) {
      return readSingleNodeWithRelationships(new Statement("MATCH (n:" + label + " {" + TAG_UUID + ": $uuid}) OPTIONAL MATCH (n)-[rel]-(o) RETURN n, rel",
            parameters("uuid", uuid.toString())));
   }

   public NodeWithRelationships getSingleNodeWithRelationships(@NotNull UUID uuid) {
      return readSingleNodeWithRelationships(new Statement("MATCH (n {" + TAG_UUID + ": $uuid}) OPTIONAL MATCH (n)-[rel]-(o) RETURN n, rel",
            parameters("uuid", uuid.toString())));
   }

   public NodeWithRelationships getSingleNodeWithRelationships(@NotNull final String label1, @NotNull final String label2, @NotNull final UUID uuid) {
      return getSingleNodeWithRelationships(label1 + ":" + label2, uuid);
   }

   public NodeWithRelationships getSingleNodeWithRelationships(@NotNull final List<String> labels, @NotNull final UUID uuid) {
      return getSingleNodeWithRelationships(labels.stream().collect(Collectors.joining(":")), uuid);
   }

   public NodeWithRelationships getSingleNodeWithRelationships(@NotNull final String[] labels, @NotNull final UUID uuid) {
      return getSingleNodeWithRelationships(Arrays.stream(labels).collect(Collectors.joining(":")), uuid);
   }

/*
	public Collection<Node> getNodes(@NotNull final String label) {
		return readNodes("MATCH (n:" + label + ") RETURN n");
	}

	public Collection<Node> getNodes(@NotNull final String label1, @NotNull final String label2) {
		return getNodes(label1 + ":" + label2);
	}

	public Collection<Node> getNodes(@NotNull final List<String> labels) {
		return getNodes(labels.stream().collect(Collectors.joining(":")));
	}

	public Collection<Node> getNodes(@NotNull final String[] labels) {
		return getNodes(Arrays.stream(labels).collect(Collectors.joining(":")));
	}
*/

	public Collection<Node> getNodes(@NotNull final String label, String property, Object value) {
      return readNodes(new Statement("MATCH (n:" + label + " {" + property + ": $value}) RETURN n",
            parameters("value", value)));
   }

   public Collection<Node> getNodesWithProperty(@NotNull final String property) {
      return readNodes("MATCH (n) WHERE EXISTS (n." + property + ") RETURN n");
   }

   public Collection<NodeWithRelationships> getNodesWithRelationships(@NotNull final String label) {
      return readNodesWithRelationships("MATCH (n:" + label + ") OPTIONAL MATCH (n)-[rel]-(o) RETURN n, rel");
   }

   public Collection<NodeWithRelationships> getNodesWithRelationships(@NotNull final String label1, @NotNull final String label2) {
      return getNodesWithRelationships(label1 + ":" + label2);
   }

   public Collection<NodeWithRelationships> getNodesWithRelationships(@NotNull final List<String> labels) {
      return getNodesWithRelationships(labels.stream().collect(Collectors.joining(":")));
   }

   public Collection<NodeWithRelationships> getNodesWithRelationships(@NotNull final String[] labels) {
      return getNodesWithRelationships(Arrays.stream(labels).collect(Collectors.joining(":")));
   }

   public Collection<Relationship> getRelationships(@NotNull final Node node) {
      return getRelationships(node.id(), null, Direction.BOTH);
   }

   public Collection<Relationship> getRelationships(@NotNull final Node node, Direction direction) {
      return getRelationships(node.id(), null, direction);
   }

   @Deprecated
   public Collection<Relationship> getRelationships(final long id, final String type, Direction direction) {
      return readRelationships(new Statement("MATCH (n) WHERE ID(n) = $id MATCH (n)" + (direction == Direction.INCOMING ? "<" : "") + "-[rel" + (type != null ? ":" + type : "") + "]-" + (direction == Direction.OUTGOING ? ">" : "") + "(o) RETURN rel",
            parameters("id", id)));
   }

   public Collection<Relationship> getRelationships(@NotNull final UUID uuid) {
      return getRelationships(TAG_NODE, uuid);
   }

   public Collection<Relationship> getRelationships(@NotNull final String label, @NotNull UUID uuid) {
      return getRelationships(label, uuid, null, Direction.BOTH);
   }

   public Collection<Relationship> getRelationships(final String label, @NotNull UUID uuid, final String type, Direction direction) {
      return readRelationships(new Statement("MATCH (n" + (label != null ? ":" + label : "") + " {" + TAG_UUID + ": $uuid}) MATCH (n)" + (direction == Direction.INCOMING ? "<" : "") + "-[rel" + (type != null ? ":" + type : "") + "]-" + (direction == Direction.OUTGOING ? ">" : "") + "(o) RETURN rel",
            parameters("uuid", uuid.toString())));
   }

   public Node createNode(@NotNull final String label1, @NotNull final String label2, @NotNull final UUID uuid, Object... kv) {
      return createNode(label1 + ":" + label2, uuid, kv);
   }

   public Node createNode(@NotNull final List<String> labels, @NotNull final UUID uuid, Object... kv) {
      return createNode(labels.stream().collect(Collectors.joining(":")), uuid, kv);
   }

   public Node createNode(@NotNull final String[] labels, @NotNull final UUID uuid, Object... kv) {
      return createNode(Arrays.stream(labels).collect(Collectors.joining(":")), uuid, kv);
   }

   public Node createNode(@NotNull UUID uuid, Object... kv) {
      return createNode("", uuid, kv);
   }

   public Node createNode(@NotNull final String label, @NotNull final UUID uuid, Object... kv) {
      if (kv.length % 2 != 0)
         throw new IllegalArgumentException("Expecting key value PAIRS");

      return writeTransaction(tx -> {
         final Map<String, Object> props = propertyMap(kv);
         props.put(TAG_UUID, uuid.toString());

         Statement statement = new Statement("CREATE (n:" + TAG_NODE + (label.isEmpty() ? "" : ":" + label) + " $props) return n",
               parameters("props", props));

         System.out.println("createNode: " + statement.toString());
         final StatementResult result = tx.run(statement);
//			System.out.println("createNode summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) return null;

         return result.single().get(0).asNode();

      }, (context, node) -> context.txData().nodeCreated(fromDriverNode(NeoDriver.this, node)));
   }

   @Deprecated
   public Node deleteNode(final long id) {
      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH (n) WHERE ID(n) = $id DELETE n",
               parameters("id", id));

         System.out.println("deleteNode: " + statement.toString());
         final StatementResult result = tx.run(statement);
//			System.out.println("deleteNode summary: " + debugSummary(result.summary()));

         if (result.summary().counters().nodesDeleted() > 0)
            return NeoNode.deletedNode(id);

         return null;

      }, (context, node) -> context.txData().nodeDeleted(NeoNode.newInternalNeoNode(node)));
   }

   public Node deleteNode(@NotNull final UUID uuid) {
      return deleteNode(TAG_NODE, uuid);
   }

   public Node deleteNode(@NotNull final String label, @NotNull final UUID uuid) {
      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH (n:" + label + " {" + TAG_UUID + ": $uuid}) DELETE n RETURN ID(n)",
               parameters("uuid", uuid));

         System.out.println("deleteNode: " + statement.toString());
         final StatementResult result = tx.run(statement);
//			System.out.println("deleteNode summary: " + debugSummary(result.summary()));

         if (result.summary().counters().nodesDeleted() > 0)
            return NeoNode.deletedNode(result.single().get(0).asInt());

         return null;

      }, (context, node) -> context.txData().nodeDeleted(NeoNode.newInternalNeoNode(node)));
   }

   public Node addLabel(@NotNull final UUID uuid, @NotNull final String additional) {
      return addLabel(TAG_NODE, uuid, additional);
   }

   public Node addLabel(@NotNull final String label, @NotNull final UUID uuid, @NotNull final String additional) {
      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH (n:" + label + " {" + TAG_UUID + ": $uuid}) SET n:" + additional + " return n",
               parameters("uuid", uuid.toString()));

         System.out.println("addLabel: " + statement.toString());
         final StatementResult result = tx.run(statement);
//			System.out.println("addLabel summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) return null;

         return result.single().get(0).asNode();

      }, (context, node) -> context.txData().labelAssigned(additional, fromDriverNode(NeoDriver.this, node)));
   }

   public Node removeLabel(@NotNull final UUID uuid, @NotNull final String labelToRemove) {
      return removeLabel(TAG_NODE, uuid, labelToRemove);
   }

   public Node removeLabel(@NotNull final String label, @NotNull final UUID uuid, @NotNull final String labelToRemove) {
      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH (n:" + label + " {" + TAG_UUID + ": $uuid}) REMOVE n:" + labelToRemove + " return n",
               parameters("uuid", uuid.toString()));

         System.out.println("removeLabel: " + statement.toString());
         final StatementResult result = tx.run(statement);
//			System.out.println("removeLabel summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) return null;

         return result.single().get(0).asNode();

      }, (context, node) -> context.txData().labelRemoved(labelToRemove, fromDriverNode(NeoDriver.this, node)));
   }

   @Deprecated
   public Relationship getSingleRelationship(long id) {
      return readSingleRelationship(new Statement("MATCH ()-[rel]-() WHERE ID(rel) = $id RETURN rel",
            parameters("id", id)));
   }

   public Relationship getSingleRelationship(@NotNull final String type, @NotNull final UUID uuid) {
      return readSingleRelationship(new Statement("MATCH ()-[rel:" + type + " {" + TAG_UUID + ": $uuid}]-() RETURN rel",
            parameters("uuid", uuid.toString())));
   }

   public Relationship getSingleRelationship(@NotNull final UUID uuid) {
      return getSingleRelationship(TAG_UUID, uuid);
   }

   public static boolean hasProperty(@NotNull Entity entity, String... properties) {
      for (String property : properties) {
         if (!entity.containsKey(property)) return false;
      }

      return true;
   }

   public static boolean hasLabel(@NotNull Node node, String... labels) {
      for (String label : labels) {
         if (!node.hasLabel(label)) return false;
      }

      return true;
   }

   public static boolean isType(@NotNull Relationship relationship, @NotNull final String type) {
      return relationship.hasType(type);
   }

   public boolean hasRelationship(@NotNull Node node, @NotNull final String type) {
      return hasRelationship(null, uuidOf(node), type, Direction.BOTH);
   }

   public boolean hasRelationship(@NotNull Node node, @NotNull final String type, Direction direction) {
      return hasRelationship(null, uuidOf(node), type, direction);
   }

   public boolean hasRelationship(final String label, @NotNull final UUID uuid, @NotNull String type) {
      return hasRelationship(label, uuid, type, Direction.BOTH);
   }

   public boolean hasRelationship(final String label, @NotNull final UUID uuid, @NotNull String type, Direction direction) {
      return getRelationships(label, uuid, type, direction).size() > 0;
   }

   public Relationship createOutgoingRelationship(@NotNull final UUID lhs, @NotNull final UUID rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(lhs, rhs, type, Direction.OUTGOING, uuid, kv);
   }

   public Relationship createOutgoingRelationship(@NotNull final String label, @NotNull final UUID lhs, @NotNull final UUID rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(label, lhs, rhs, type, Direction.OUTGOING, uuid, kv);
   }

   public Relationship createOutgoingRelationship(@NotNull final String lhsLabel, @NotNull final UUID lhs, @NotNull final String rhsLabel, @NotNull final UUID rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(lhsLabel, lhs, rhsLabel, rhs, type, Direction.OUTGOING, uuid, kv);
   }

   public Relationship createIncomingRelationship(@NotNull final UUID lhs, @NotNull final UUID rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(lhs, rhs, type, Direction.INCOMING, uuid, kv);
   }

   public Relationship createIncomingRelationship(@NotNull final String label, @NotNull final UUID lhs, @NotNull final UUID rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(label, lhs, rhs, type, Direction.INCOMING, uuid, kv);
   }

   public Relationship createIncomingRelationship(@NotNull final String lhsLabel, @NotNull final UUID lhs, @NotNull final String rhsLabel, @NotNull final UUID rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(lhsLabel, lhs, rhsLabel, rhs, type, Direction.INCOMING, uuid, kv);
   }

   private Relationship createRelationship(@NotNull final UUID lhs, @NotNull final UUID rhs, @NotNull String type, Direction direction, @NotNull UUID uuid, Object... kv) {
      return createRelationship(TAG_NODE, lhs, TAG_NODE, rhs, type, direction, uuid, kv);
   }

   private Relationship createRelationship(@NotNull final String label, @NotNull final UUID lhs, @NotNull final UUID rhs, @NotNull String type, Direction direction, @NotNull UUID uuid, Object... kv) {
      return createRelationship(label, lhs, label, rhs, type, direction, uuid, kv);
   }

   private Relationship createRelationship(@NotNull final String lhsLabel, @NotNull final UUID uuidLhs, @NotNull final String rhsLabel, @NotNull final UUID uuidRhs, @NotNull String type, Direction direction, @NotNull UUID uuid, Object... kv) {
      if (kv.length % 2 != 0)
         throw new IllegalArgumentException("Expecting key value PAIRS");

      // One MUST indicate a direction when creating a relationship!
      // The following cypher fails: "CREATE (n:SomeLabel {tag: 'whatever'})-[rel:SomeType]-(o:SomeLabel {tag: 'whatever'})"
      if (direction == Direction.BOTH) throw new IllegalArgumentException("Only directed relationships are supported in CREATE");

      return writeTransaction(tx -> {
         final Map<String, Object> props = propertyMap(kv);
         props.put(TAG_UUID, uuid.toString());
         Statement statement = new Statement("MATCH (l:" + lhsLabel + " {" + TAG_UUID + ": $lhs}), (r:" + rhsLabel + " {" + TAG_UUID + ": $rhs}) "
               + "CREATE (l)" + (direction == Direction.INCOMING ? "<" : "") + "-[rel:" + type + "]-" + (direction == Direction.OUTGOING ? ">" : "") + "(r) "
               + "SET rel = $props "
               + "RETURN rel",
               parameters("lhs", uuidLhs.toString(), "rhs", uuidRhs.toString(), "props", props));

         System.out.println("createRelationship: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("createRelationship summary:" + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Relationship " + direction.name() + " " + type + " between nodes " + lhsLabel + ":" + uuidLhs + " and " + rhsLabel + ":" + uuidRhs + " was not created");
            return null;
         }

         return result.single().get(0).asRelationship();

      }, (context, rel) -> context.txData().relationshipCreated(NeoRelationship.fromDriverRelationship(NeoDriver.this, rel)));
   }

   public Relationship createOutgoingRelationship(@NotNull Node lhs, @NotNull Node rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(lhs, rhs, type, Direction.OUTGOING, uuid, kv);
   }

   public Relationship createIncomingRelationship(@NotNull Node lhs, @NotNull Node rhs, @NotNull String type, @NotNull UUID uuid, Object... kv) {
      return createRelationship(lhs, rhs, type, Direction.INCOMING, uuid, kv);
   }

   private Relationship createRelationship(@NotNull Node lhs, @NotNull Node rhs, @NotNull String type, Direction direction, @NotNull UUID uuid, Object... kv) {
      return createRelationship(lhs.id(), rhs.id(), type, direction, uuid, kv);
   }

   private Relationship createRelationship(long lhs, long rhs, @NotNull String type, Direction direction, @NotNull UUID uuid, Object... kv) {
      if (kv.length % 2 != 0)
         throw new IllegalArgumentException("Expecting key value PAIRS");

      // One MUST indicate a direction when creating a relationship!
      // The following cypher fails: "CREATE (n:SomeLabel {tag: 'whatever'})-[rel:SomeType]-(o:SomeLabel {tag: 'whatever'})"
      if (direction == Direction.BOTH) throw new IllegalArgumentException("Only directed relationships are supported in CREATE");

      return writeTransaction(tx -> {
         final Map<String, Object> props = propertyMap(kv);
         props.put(TAG_UUID, uuid.toString());
         Statement statement = new Statement("MATCH (l), (r) WHERE ID(l) = $lhs AND ID(r) = $rhs "
               + "CREATE (l)" + (direction == Direction.INCOMING ? "<" : "") + "-[rel:" + type + "]-" + (direction == Direction.OUTGOING ? ">" : "") + "(r) "
               + "SET rel = $props "
               + "RETURN rel",
               parameters("lhs", lhs, "rhs", rhs, "props", props));

         System.out.println("createRelationship: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("createRelationship summary:" + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Relationship " + direction.name() + " " + type + " between nodes with ID " + lhs + " and " + rhs + " was not created");
            return null;
         }

         return result.single().get(0).asRelationship();

      }, (context, rel) -> context.txData().relationshipCreated(NeoRelationship.fromDriverRelationship(NeoDriver.this, rel)));
   }

   @Deprecated
   public Relationship deleteRelationship(long id) {
      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH ()-[rel]-() WHERE ID(rel) = $id DELETE rel",
               parameters("id", id));

         System.out.println("deleteRelationship: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("createRelationship summary:" + debugSummary(result.summary()));
         if (result.summary().counters().relationshipsDeleted() > 0)
            return NeoRelationship.deletedRelationship(id, "");

         return null;

      }, (context, rel) -> context.txData().relationshipDeleted(NeoRelationship.newInternalRelationship(rel)));
   }

   public Relationship deleteRelationship(@NotNull final String type, @NotNull final UUID uuid) {
      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH ()-[rel:" + type + " {" + TAG_UUID + ": $uuid}]-() DELETE rel RETURN ID(rel)",
               parameters("uuid", uuid.toString()));

         System.out.println("deleteRelationship: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("deleteRelationship summary:" + debugSummary(result.summary()));
         if (result.summary().counters().relationshipsDeleted() > 0)
            return NeoRelationship.deletedRelationship(result.single().get(0).asLong(), type);

         return null;

      }, (context, rel) -> context.txData().relationshipDeleted(NeoRelationship.newInternalRelationship(rel)));
   }

   public Relationship deleteRelationship(@NotNull final NeoRelationship relationship) {
      return deleteRelationship(relationship.getType().name(), relationship.getUUID());
   }

   public Node setProperties(@NotNull Node node, Object... kv) {
      return setNodeProperties(node.id(), kv);
   }

   public Node replaceProperties(@NotNull Node node, Object... kv) {
      return setNodeProperties(node.id(), true, kv);
   }

   public Node setProperties(@NotNull Node node, @NotNull Boolean replace, Object... kv) {
      return setNodeProperties(node.id(), replace, kv);
   }

   @Deprecated
   public Node setNodeProperties(long id, Object... kv) {
      return setNodeProperties(id, false, kv);
   }

   @Deprecated
   public Node replaceNodeProperties(long id, Object... kv) {
      return setNodeProperties(id, true, kv);
   }

   @Deprecated
   public Node setNodeProperties(long id, @NotNull Boolean replace, Object... kv) {
      if (kv.length % 2 != 0)
         throw new IllegalArgumentException("Expecting key value PAIRS");

      if (kv.length == 0 && !replace) return getSingleNode(id);

      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH (n) WHERE ID(n) = $id SET n " + (replace ? "" : "+") + "= $props RETURN n",
            parameters("id", id, "props", propertyMap(kv)));

         System.out.println("setNodeProperties: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("setNodeProperties summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Node " + id + " does not exist");
            return null;
         }

         return result.single().get(0).asNode();

      }, (context, node) -> {
         // TODO: Update transaction data
      });
   }

   public Node setNodeProperties(@NotNull final UUID uuid, Object... kv) {
      return setNodeProperties(TAG_NODE, uuid, false, kv);
   }

   public Node setNodeProperties(@NotNull final String label, @NotNull final UUID uuid, Object... kv) {
      return setNodeProperties(label, uuid, false, kv);
   }

   public Node replaceNodeProperties(@NotNull final UUID uuid, Object... kv) {
      return setNodeProperties(TAG_NODE, uuid, true, kv);
   }

   public Node replaceNodeProperties(@NotNull final String label, @NotNull final UUID uuid, Object... kv) {
      return setNodeProperties(label, uuid, true, kv);
   }

   public Node setNodeProperties(@NotNull final String label, @NotNull final UUID uuid, @NotNull Boolean replace, Object... kv) {
      if (kv.length % 2 != 0)
         throw new IllegalArgumentException("Expecting key value PAIRS");

      if (kv.length == 0 && !replace) return getSingleNode(label, uuid);

      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH (n:" + label + " {" + TAG_UUID + ": $uuid}) SET n " + (replace ? "" : "+") + "= $props RETURN n",
            parameters("uuid", uuid.toString(), "props", propertyMap(kv)));

         System.out.println("setNodeProperties: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("setNodeProperties summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Node " + label + "{" + uuid + "} does not exist");
            return null;
         }

         return result.single().get(0).asNode();

      }, (context, node) -> {
         // TODO: Update transaction data
      });
   }

   public Node removeNodeProperties(@NotNull final UUID uuid, String... properties) {
      return removeNodeProperties(TAG_NODE, uuid, properties);
   }

   public Node removeNodeProperties(@NotNull final String label, @NotNull final UUID uuid, String... properties) {
      if (properties.length == 0) return getSingleNode(label, uuid);

      return writeTransaction(tx -> {
         StringBuilder sb = new StringBuilder("MATCH (n:" + label + " {" + TAG_UUID + ": $uuid}) REMOVE ");
         for (int i = 0; i < properties.length; ++i) {
            if (i > 0) sb.append(",");
            sb.append("n.").append(properties[i]);
         }
         sb.append("RETURN n");

         Statement statement = new Statement(sb.toString(),
               parameters("uuid", uuid.toString()));

         System.out.println("removeRelationshipProperties: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("removeRelationshipProperties summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Node " + label + "{" + uuid + "} does not exist");
            return null;
         }

         return result.single().get(0).asNode();

      }, (context, node) -> {
         // TODO: Update transaction data
      });
   }

   public Relationship setProperties(@NotNull Relationship relationship, Object... kv) {
      return setRelationshipProperties(relationship.id(), kv);
   }

   public Relationship replaceProperties(@NotNull Relationship relationship, Object... kv) {
      return setRelationshipProperties(relationship.id(), true, kv);
   }

   public Relationship setProperties(@NotNull Relationship relationship, @NotNull Boolean replace, Object... kv) {
      return setRelationshipProperties(relationship.id(), replace, kv);
   }

   @Deprecated
   public Relationship setRelationshipProperties(long id, Object... kv) {
      return setRelationshipProperties(id, false, kv);
   }

   @Deprecated
   public Relationship replaceRelationshipProperties(long id, Object... kv) {
      return setRelationshipProperties(id, true, kv);
   }

   @Deprecated
   public Relationship setRelationshipProperties(long id, @NotNull Boolean replace, Object... kv) {
      if (kv.length % 2 != 0)
         throw new IllegalArgumentException("Expecting key value PAIRS");

      if (kv.length == 0 && !replace) return getSingleRelationship(id);

      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH ()-[rel]->() WHERE ID(rel) = $id SET rel " + (replace ? "" : "+") + "= $props RETURN rel",
               parameters("id", id, "props", propertyMap(kv)));

         System.out.println("setRelationshipProperties: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("setRelationshipProperties summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Relationship " + id + " does not exist");
            return null;
         }

         return result.single().get(0).asRelationship();

      }, (context, rel) -> {
         // TODO: Update transaction data
      });
   }

   public Relationship setRelationshipProperties(@NotNull final String type, @NotNull final UUID uuid, Object... kv) {
      return setRelationshipProperties(type, uuid, false, kv);
   }

   public Relationship replaceRelationshipProperties(@NotNull final String type, @NotNull final UUID uuid, Object... kv) {
      return setRelationshipProperties(type, uuid, true, kv);
   }

   public Relationship setRelationshipProperties(@NotNull final String type, @NotNull final UUID uuid, @NotNull Boolean replace, Object... kv) {
      if (kv.length % 2 != 0)
         throw new IllegalArgumentException("Expecting key value PAIRS");

      if (kv.length == 0 && !replace) return getSingleRelationship(type, uuid);

      return writeTransaction(tx -> {
         Statement statement = new Statement("MATCH ()-[rel:" + type + " {" + TAG_UUID + ": $uuid}]->() SET rel " + (replace ? "" : "+") + "= $props RETURN rel",
               parameters("uuid", uuid.toString(), "props", propertyMap(kv)));

         System.out.println("setRelationshipProperties: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("setRelationshipProperties summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Relationship " + type + ":" + uuid + " does not exist");
            return null;
         }

         return result.single().get(0).asRelationship();

      }, (context, rel) -> {
         // TODO: Update transaction data
      });
   }

   public Relationship removeRelationshipProperties(@NotNull final String type, @NotNull final UUID uuid, String... properties) {
      if (properties.length == 0) return getSingleRelationship(type, uuid);

      return writeTransaction(tx -> {
         StringBuilder sb = new StringBuilder("MATCH ()-[rel:" + type + " {" + TAG_UUID + ": $uuid}]->() REMOVE ");
         for (int i = 0; i < properties.length; ++i) {
            if (i > 0) sb.append(",");
            sb.append("rel.").append(properties[i]);
         }
         sb.append("RETURN rel");

         Statement statement = new Statement(sb.toString(),
               parameters("uuid", uuid.toString()));

         System.out.println("removeRelationshipProperties: " + statement.toString());
         StatementResult result = tx.run(statement);
//			System.out.println("removeRelationshipProperties summary: " + debugSummary(result.summary()));

         if (!result.hasNext()) {
            System.out.println("Relationship " + type + ":" + uuid + " does not exist");
            return null;
         }

         return result.single().get(0).asRelationship();

      }, (context, rel) -> {
         // TODO: Update transaction data
      });
   }

   static Map<String, Object> propertyMap(final Object... kv) {
      final Map<String, Object> props = new LinkedHashMap<>();
      for (int i = 0; i < kv.length; i += 2) {
         if (kv[i + 1] != null && !kv[i + 1].equals("[]")) {
            props.put(kv[i].toString(), kv[i + 1]);
         }
      }
      return props;
   }

   public static String debugSummary(ResultSummary summary) {
      StringBuilder sb = new StringBuilder();

      sb.append("counters: [")
            .append("nodesCreated: ").append(summary.counters().nodesCreated())
            .append(", nodesDeleted: ").append(summary.counters().nodesDeleted())
            .append(", propertiesSet: ").append(summary.counters().propertiesSet())
            .append(", relationshipsCreated: ").append(summary.counters().relationshipsCreated())
            .append(", relationshipsDeleted: ").append(summary.counters().relationshipsDeleted())
            .append(", labelsAdded: ").append(summary.counters().labelsAdded())
            .append(", labelsRemoved: ").append(summary.counters().labelsRemoved())
            .append(", indexesAdded: ").append(summary.counters().indexesAdded())
            .append(", indexesRemoved: ").append(summary.counters().indexesRemoved())
            .append(", constraintsAdded: ").append(summary.counters().constraintsAdded())
            .append(", constraintsRemoved: ").append(summary.counters().constraintsRemoved())
            .append(", containsUpdates: ").append(summary.counters().containsUpdates())
            .append("]\n")
            .append("notifications: [");

      for (Notification notification : summary.notifications()) {
         sb.append("{").append(notification.title()).append(" | ")
               .append(notification.code()).append(" | ")
               .append(notification.description()).append(" | ").append(notification.severity())
               .append("}\n");
      }
      sb.append("]");

      return sb.toString();
   }

   NeoTransactionEventHandler txEventHandler() {
	   return txEventHandler;
   }

}
