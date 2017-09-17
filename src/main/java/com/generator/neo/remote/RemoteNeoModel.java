package com.generator.neo.remote;


import com.generator.neo.NeoModel;
import org.neo4j.driver.v1.Statement;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.index.impl.lucene.legacy.EmptyIndexHits;

import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static com.generator.util.NeoUtil.TAG_UUID;
import static com.generator.neo.remote.NeoCache.getCachedNode;
import static com.generator.neo.remote.NeoCache.isCachedNode;
import static com.generator.neo.remote.NeoNode.*;
import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by Ernst Sognnes on 08.07.17.
 * todo cleanup methods, add Override etc, use only one TAG_UUID
 */
public class RemoteNeoModel extends NeoDriver implements NeoModel {

   public interface NeoModelListener {
      void closed(NeoModel model);
   }

   public RemoteNeoModel(URI uri, String username, String password) {
      this(uri, username, password, null);
   }

   public RemoteNeoModel(URI uri, String username, String password, NeoModelListener listener) {
      super(uri, username, password);

      addConstraintUnique(TAG_NODE, TAG_UUID);

      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
         try {
            close();
         } catch (Exception e) {
            e.printStackTrace();
         }
         if (listener != null) listener.closed(RemoteNeoModel.this);
      }));
   }

   @Override
   public void dropAll() {
      super.dropAll();
      NeoCache.clear();
   }

   @Override
   public ResourceIterable<Relationship> getAllRelationships() {
      // todo implement
      return new EmptyIndexHits<>();
   }

   @Override
   public Node findNode(Label label, String key, Object value) {
      final Iterator<Node> nodes = findNodes(label, key, value);
      return nodes.hasNext() ? nodes.next() : null;
   }

   @Override
   public IndexManager index() {
      System.out.println("index() needs to be solved");
      return null;
   }

   @Override
   public Iterable<Node> findNodesWithProperty(String property) {
      // todo implement
      return new EmptyIndexHits<>();
   }

   @Override
   public void registerTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler) {
      // todo implement
      System.out.println("ignoring registerTransactionEventHandler");
   }

   @Override
   public void unregisterTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler) {
      // todo implement
      System.out.println("ignoring unregisterTransactionEventHandler");
   }

   @Override
   public ResourceIterable<Label> getAllLabelsInUse() {

      // todo implement
      return new EmptyIndexHits<>();
   }

   @Override
   public ResourceIterable<RelationshipType> getAllRelationshipTypesInUse() {

      // todo implement
      return new EmptyIndexHits<>();
   }

   @Override
   public ResourceIterable<Label> getAllLabels() {

      // todo implement
      return new EmptyIndexHits<>();
   }

   @Override
   public ResourceIterable<RelationshipType> getAllRelationshipTypes() {

      // todo implement
      return new EmptyIndexHits<>();
   }

   @Override
   public ResourceIterable<String> getAllPropertyKeys() {
      // todo implement
      return new EmptyIndexHits<>();
   }

   @Override
   public Node createNode(final Label label) {
      return fromDriverNode(this, createNode(label.name(), UUID.randomUUID()));
   }

   @Override
   public Node newNode(Label label, Object... kv) {
      return newNode(label.name(), kv);
   }

   @Override
   public Node newNode(String label, Object... kv) {
      return fromDriverNode(this, createNode(label, UUID.randomUUID(), kv));
   }

   @Override
   public Node newNode(final UUID uuid, Object... kv) {
      return fromDriverNode(this, createNode(uuid, kv));
   }

   @Override
   public Node newNode(final String label, final UUID uuid, Object... kv) {
      return fromDriverNode(this, createNode(label, uuid, kv));
   }

   public static String getNameOrLabelFrom(Node node) {

      if (node == null) return "NULL";

      if (node.hasProperty("name")) {
         return node.getProperty("name").toString();

      } else {

         // if node has labels, show all
         final StringBuilder lbl = new StringBuilder();
         for (Label label : node.getLabels()) lbl.append(label).append(" ");
         if (lbl.length() > 0) return lbl.toString().trim();

         // if no labels, show uuid:
         return hasUUID(node) ? uuidOf(node).toString() : "[" + node.getPropertyKeys() + "]";
      }
   }

   // Use node.hasProperty(key, defaultValue) instead
   @Deprecated
   public static Object getProperty(String name, Node node, Object defaultValue) {
      return node.getProperty(name, defaultValue);
//		return node.hasProperty(name) ? node.getProperty(name) : defaultValue;
   }

   public static boolean hasOutgoing(Node node, RelationshipType relationship) {
      return node.hasRelationship(relationship, Direction.OUTGOING);
   }

   @Override
   public Node getNode(final UUID uuid) {
      if (isCachedNode(uuid)) return getCachedNode(uuid);

      NodeWithRelationships nwr = getSingleNodeWithRelationships(uuid);
      return fromDriverNode(this, nwr.node(), nwr.relationships());
   }

   public Set<Node> getAll() {
      return getAll(null);
   }

   @Override
   public Set<Node> getAll(String label) {
      return readNodes(
            new Statement("MATCH (n" + (label != null ? ":" + label : "") + ") RETURN n"))
            .stream()
            .map(node -> fromDriverNode(this, node))
            .collect(Collectors.toCollection(LinkedHashSet::new));
   }

   @Override
   public Set<Node> getAll(String label, String property, Object value) {
      return readNodes(new Statement("MATCH (n:" + label + " {" + property + ": $value} RETURN n", parameters("value", value)))
            .stream()
            .map(node -> fromDriverNode(this, node))
            .collect(Collectors.toCollection(LinkedHashSet::new));
   }

   @Override
   public Set<Node> getAll(String property, Object value) {
      return readNodes(new Statement("MATCH (n {" + property + ": $value} RETURN n", parameters("value", value)))
            .stream()
            .map(node -> fromDriverNode(this, node))
            .collect(Collectors.toCollection(LinkedHashSet::new));
   }

   @Override
   public Iterator<Node> findNodes(Label label) {
      return getAll(label.name()).iterator();
   }

   @Override
   public Iterator<Node> findNodes(Label label, String key, Object value) {
      return getAll(label.name(), key, value).iterator();
   }

   @Override
   public Result query(String query) {
      // todo implement
      return null;
   }

   @Override
   public Node findOrCreate(Label label, String key, Object value, Object... properties) {
      // todo implement
      return null;
   }

   @Override
   public Transaction beginTx() {
      return new Transaction() {

         //			private final org.neo4j.driver.v1.Session session = RemoteNeoModel.this.driver.session();
         private final org.neo4j.driver.v1.Transaction tx = RemoteNeoModel.this.beginTransaction();

         private AtomicBoolean terminateCalled = new AtomicBoolean(false);

         @Override
         public void terminate() {
            System.out.println("tx terminate");
            terminateCalled.set(true);
         }

         @Override
         public void failure() {
            System.out.println("tx failure");
            tx.failure();
         }

         @Override
         public void success() {
            System.out.println("tx success");
            if (!terminateCalled.get()) tx.success();
         }

         @Override
         public void close() {
            System.out.println("tx close");
            tx.close();
         }

         @Override
         public Lock acquireWriteLock(PropertyContainer entity) {
            throw new UnsupportedOperationException();
         }

         @Override
         public Lock acquireReadLock(PropertyContainer entity) {
            throw new UnsupportedOperationException();
         }
      };
   }
}