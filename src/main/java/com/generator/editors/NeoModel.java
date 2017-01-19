package com.generator.editors;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.helpers.collection.Iterators;
import org.stringtemplate.v4.ST;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * User: goe
 * Date: 19.05.14
 */
public class NeoModel {

   private static final String TAG_UUID = "_uuid";
   public static final String TAG_LAYOUT = "_layout";

   private final GraphDatabaseService graphDb;
   private final Index<Node> uuids;

   public interface NeoModelListener {

      void closed(NeoModel model);
   }

   public NeoModel(final GraphDatabaseService graphDb) {
      this(graphDb, null);
   }

   public NeoModel(final GraphDatabaseService graphDb, NeoModelListener listener) {

      this.graphDb = graphDb;

      try (Transaction tx = graphDb.beginTx()) {
         this.uuids = graphDb.index().forNodes(TAG_UUID);
         tx.success();
      }

      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
         close();
         if (listener != null) listener.closed(NeoModel.this);
      }));
   }

   public GraphDatabaseService getGraphDb() {
      return graphDb;
   }

   public void close() {
      graphDb.shutdown();
   }

   public Result query(String query) {
      System.out.println(query);
      return graphDb.execute(query);
   }

   public Transaction beginTx() {
      return graphDb.beginTx();
   }

   public Node createNode(Label label) {
      return newNode(label.name(), UUID.randomUUID());
   }

   public Node newNode(Label label, String... kv) {
      return newNode(label.name(), UUID.randomUUID(), kv);
   }

   public Node newNode(String label, String... kv) {
      return newNode(label, UUID.randomUUID(), kv);
   }

   public Node newNode(final UUID uuid, String... kv) {
      return newNode(null, uuid, kv);
   }

   public Node newNode(final String label, final UUID uuid, String... kv) {

      Node node = getNode(uuid);
      if (node == null) {
         System.out.println("newNode " + uuid + " (" + label + ")");
         node = label == null ? graphDb.createNode() : graphDb.createNode(() -> label);
         node.setProperty(TAG_UUID, uuid.toString());
         uuids.add(node, TAG_UUID, uuid.toString());
      }

      for (int i = 0; i < kv.length; i += 2)
         if (kv[i + 1] != null && !kv[i + 1].equals("[]")) {
            node.setProperty(kv[i], kv[i + 1]);
         }

      return node;
   }

   public static UUID uuidOf(Node node) {
      return node == null ? null : hasUUID(node) ? UUID.fromString(node.getProperty(TAG_UUID).toString()) : null;
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

   public static Object getProperty(String name, Node node, Object defaultValue) {
      return node.hasProperty(name) ? node.getProperty(name) : defaultValue;
   }

   public static boolean hasOutgoing(Node node, RelationshipType relationship) {
      return node.getRelationships(Direction.OUTGOING, relationship).iterator().hasNext();
   }

   public Node getNode(final UUID uuid) {
      final IndexHits<Node> indexHits = uuids.get(TAG_UUID, uuid);
      return indexHits.size() == 0 ? null : indexHits.getSingle();
   }

   public Node mergeNode(final UUID uuid) {
      final IndexHits<Node> indexHits = uuids.get(TAG_UUID, uuid);
      return indexHits.size() == 0 ? newNode(uuid) : indexHits.getSingle();
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

   public Set<Node> getAll(String label, String property, String value) {
      final ST cypher = new ST("MATCH (entity:~label~) WHERE entity.~property~ = \"~value~\" RETURN entity", '~', '~');
      cypher.add("label", label);
      cypher.add("property", property);
      cypher.add("value", value);
      final Result res = query(cypher.render());
      final Iterator<Node> n_column = res.columnAs("entity");
      final Set<Node> result = new LinkedHashSet<>();
      for (Node node : Iterators.asIterable(n_column))
         result.add(node);
      return result;
   }

   public ResourceIterator<Node> findNodes(Label label) {
      return graphDb.findNodes(label);
   }

   public ResourceIterator<Node> findNodes(Label label, String key, Object value) {
      return graphDb.findNodes(label, key, value);
   }


   public interface Committer {

      void doAction(Transaction tx) throws Throwable;

      void exception(Throwable throwable);
   }

   public void doInTransaction(Committer committer) {
      try (Transaction tx = beginTx()) {
         try {
            committer.doAction(tx);
            tx.success();
         } catch (Throwable throwable) {
            committer.exception(throwable);
            tx.failure();
         }
      }
   }

   public static String debugNode(Node node) {
      return BaseDomainVisitor.uuidOf(node) + " (" + BaseDomainVisitor.labelsFor(node) + ") [" + BaseDomainVisitor.printPropertiesFor(node, " ") + "]";
   }

   private static boolean hasUUID(Node node) {
      return node.hasProperty(NeoModel.TAG_UUID);
   }

}