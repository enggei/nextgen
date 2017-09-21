package com.generator.neo.embedded;

import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.helpers.collection.Iterators;
import org.stringtemplate.v4.ST;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.util.NeoUtil.TAG_UUID;


/**
 * Created 17.09.17.
 * todo cleanup methods, add Override etc
 */
public class EmbeddedNeoModel implements NeoModel {

   private final GraphDatabaseService graphDb;
   private final Index<Node> uuids;
   private final NeoModelListener listener;

   private final AtomicBoolean isShutdown = new AtomicBoolean(false);

   public interface NeoModelListener {

      void closed(EmbeddedNeoModel model);
   }

   public EmbeddedNeoModel(final GraphDatabaseService graphDb) {
      this(graphDb, null);
   }

   public EmbeddedNeoModel(final GraphDatabaseService graphDb, NeoModelListener listener) {

      this.graphDb = graphDb;


      try (Transaction tx = graphDb.beginTx()) {
         this.uuids = graphDb.index().forNodes(TAG_UUID);
         tx.success();
      }

      this.listener = listener;
      Runtime.getRuntime().addShutdownHook(new Thread(this::close));
   }

   @Override
   public ResourceIterable<Label> getAllLabelsInUse() {
      return graphDb.getAllLabelsInUse();
   }

   @Override
   public ResourceIterable<Relationship> getAllRelationships() {
      return graphDb.getAllRelationships();
   }

   @Override
   public ResourceIterable<RelationshipType> getAllRelationshipTypesInUse() {
      return graphDb.getAllRelationshipTypesInUse();
   }

   @Override
   public ResourceIterable<Label> getAllLabels() {
      return graphDb.getAllLabels();
   }

   @Override
   public ResourceIterable<RelationshipType> getAllRelationshipTypes() {
      return graphDb.getAllRelationshipTypes();
   }

   @Override
   public ResourceIterable<String> getAllPropertyKeys() {
      return graphDb.getAllPropertyKeys();
   }

   @Override
   public TransactionEventHandler<Object> registerTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler) {
      return graphDb.registerTransactionEventHandler(transactionEventHandler);
   }

   @Override
   public TransactionEventHandler<Object> unregisterTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler) {
      return graphDb.unregisterTransactionEventHandler(transactionEventHandler);
   }

   @Override
   public void close() {
      if (listener != null && !isShutdown.get()) listener.closed(EmbeddedNeoModel.this);
      graphDb.shutdown();
      isShutdown.set(true);
   }

   public Result query(String query) {
      //System.out.println(query);
      final Result result = graphDb.execute(query);
      //System.out.println("Query stats : \n" + result.getQueryStatistics().toString());
      return result;
   }

   public Transaction beginTx() {
      return graphDb.beginTx();
   }



   public Node createNode(Label label) {
      return newNode(label.name(), UUID.randomUUID());
   }

   public Node newNode(Label label, Object... kv) {
      return newNode(label.name(), UUID.randomUUID(), kv);
   }

   public Node newNode(String label, Object... kv) {
      return newNode(label, UUID.randomUUID(), kv);
   }

   public Node newNode(final UUID uuid, Object... kv) {
      return newNode(null, uuid, kv);
   }

   public Node mergeNode(final UUID uuid) {
      final IndexHits<Node> indexHits = uuids.get(TAG_UUID, uuid);
      return indexHits.size() == 0 ? newNode(uuid) : indexHits.getSingle();
   }

   public Node newNode(final String label, final UUID uuid, Object... kv) {

      Node node = getNode(uuid);
      if (node == null) {
         //System.out.println("newNode " + uuid + " (" + label + ")");
         node = label == null ? graphDb.createNode() : graphDb.createNode(() -> label);
         node.setProperty(TAG_UUID, uuid.toString());
         uuids.add(node, TAG_UUID, uuid.toString());
      }

      for (int i = 0; i < kv.length; i += 2)
         if (kv[i + 1] != null) {
            node.setProperty(kv[i].toString(), kv[i + 1]);
         }

      return node;
   }

   public Node getNode(final UUID uuid) {
      final IndexHits<Node> indexHits = uuids.get(TAG_UUID, uuid);
      if (indexHits.size() == 0) {
         final Iterator<Node> it = getAll(TAG_UUID, uuid.toString()).iterator();
         if (it.hasNext()) return it.next();
      }
      return indexHits.getSingle();
   }

   // NODES

   public Set<Node> getAll(String label) {
      final ST cypher = new ST("MATCH (entity~if(label)~:~label~~endif~) RETURN entity", '~', '~');
      if (label != null && label.length() != 0)
         cypher.add("label", label);

      final Result res = query(cypher.render());
      final Iterator<Node> n_column = res.columnAs("entity");
      final Set<Node> result = new LinkedHashSet<>();
      try {
         for (Node node : Iterators.asIterable(n_column))
            result.add(node);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
   }

   public Set<Node> getAll(String property, String value) {
      final ST cypher = new ST("MATCH (entity) WHERE entity.~property~ = \"~value~\" RETURN entity", '~', '~');
      cypher.add("property", property);
      cypher.add("value", value);
      final Result res = query(cypher.render());
      final Iterator<Node> n_column = res.columnAs("entity");
      final Set<Node> result = new LinkedHashSet<>();
      for (Node node : Iterators.asIterable(n_column))
         result.add(node);
      return result;
   }

   @Override
   public Set<Node> getAll(String label, String property, Object value) {
      return null;
   }

   @Override
   public Set<Node> getAll(String property, Object value) {
      return null;
   }

   @Override
   public Iterable<Node> findNodesWithProperty(String property) {
      final ST cypher = new ST("MATCH (entity) WHERE EXISTS(entity.~property~) RETURN entity", '~', '~');
      cypher.add("property", property);
      final Result res = query(cypher.render());
      final Iterator<Node> n_column = res.columnAs("entity");
      return Iterators.asIterable(n_column);
   }

   public ResourceIterator<Node> findNodes(Label label) {
      return graphDb.findNodes(label);
   }

   public ResourceIterator<Node> findNodes(Label label, String key, Object value) {
      return graphDb.findNodes(label, key, value);
   }

   @Override
   public Node findNode(Label label, String key, Object value) {
      final ResourceIterator<Node> iterator = graphDb.findNodes(label, key, value);
      return iterator.hasNext() ? iterator.next() : null;
   }

   public Node findOrCreate(Label label, String key, Object value, Object ... properties) {

      if (properties.length % 2 != 0)
         throw new IllegalArgumentException("Properties in findOrCreate must be key-value pairs");

      Node node = findNode(label, key, value);
      if (node == null)
         node = newNode(label, key, value.toString());

      for (int i = 0; i < properties.length; i += 2)
         node.setProperty(properties[i].toString(), properties[i + 1]);

      return node;
   }

   @Override
   public IndexManager index() {
      return graphDb.index();
   }
}