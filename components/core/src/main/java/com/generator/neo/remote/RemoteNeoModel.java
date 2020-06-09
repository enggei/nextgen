package com.generator.neo.remote;


import com.generator.neo.NeoModel;
import org.neo4j.driver.v1.Statement;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.helpers.collection.Iterators;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.generator.neo.remote.NeoCache.getCachedNode;
import static com.generator.neo.remote.NeoCache.isCachedNode;
import static com.generator.neo.remote.RemoteNode.*;
import static com.generator.neo.remote.RemoteRelationship.fromDriverRelationship;
import static com.generator.util.NeoUtil.TAG_UUID;
import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by Ernst Sognnes on 08.07.17.
 * todo cleanup methods, add Override etc, use only one TAG_UUID
 */
public class RemoteNeoModel extends NeoDriver implements NeoModel {

   public interface NeoModelListener {
      void closed(NeoModel model);
   }

   public RemoteNeoModel(String uri, String username, String password) {
      this(uri, username, password, null);
   }

   public RemoteNeoModel(String uri, String username, String password, NeoModelListener listener) {
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
   public ResourceIterable<Relationship> getAllRelationships() {

      final Iterable<Relationship> relationships = readRelationships(new Statement("MATCH ()-[r]-() RETURN r"))
         .stream()
         .map(relationship -> fromDriverRelationship(RemoteNeoModel.this, relationship))
         .collect(Collectors.toCollection(LinkedHashSet::new));

      return () -> Iterators.asResourceIterator(relationships.iterator());
   }

   @Override
   public Node findNode(Label label, String key, Object value) {
      final Iterator<Node> nodes = findNodes(label, key, value);
      return nodes.hasNext() ? nodes.next() : null;
   }

   @Override
   public Iterable<Node> findNodesWithProperty(String property) {

      final Iterable<Node> nodes = getNodesWithProperty(property)
         .stream()
         .map(node -> fromDriverNode(RemoteNeoModel.this, node))
         .collect(Collectors.toCollection(LinkedHashSet::new));

      return () -> Iterators.asResourceIterator(nodes.iterator());
   }

   @Override
   public ResourceIterable<Label> getAllLabelsInUse() {

      // NOTE: Returns all unique labels, not just all unique label combos
      final Iterable<Label> labels = readSingleStringColumn("MATCH (n) WITH DISTINCT LABELS(n) AS labels UNWIND labels as label RETURN DISTINCT label")
         .stream()
         .map(Label::label)
         .collect(Collectors.toCollection(LinkedHashSet::new));

      return () -> Iterators.asResourceIterator(labels.iterator());
   }

   @Override
   public ResourceIterable<RelationshipType> getAllRelationshipTypesInUse() {

      final Iterable<RelationshipType> relationshipTypes = readSingleStringColumn("MATCH ()-[r]-() WITH DISTINCT TYPE(r) AS type RETURN type")
         .stream()
         .map(RelationshipType::withName)
         .collect(Collectors.toCollection(LinkedHashSet::new));

      return () -> Iterators.asResourceIterator(relationshipTypes.iterator());
   }

   @Override
   public ResourceIterable<RelationshipType> getAllRelationshipTypes() {

      final Iterable<RelationshipType> relationshipTypes = readSingleStringColumn("CALL db.relationshipTypes()")
         .stream()
         .map(RelationshipType::withName)
         .collect(Collectors.toCollection(LinkedHashSet::new));

      return () -> Iterators.asResourceIterator(relationshipTypes.iterator());
   }

   @Override
   public ResourceIterable<String> getAllPropertyKeys() {
      final Iterable<String> properties = new LinkedHashSet<>(readSingleStringColumn("CALL db.propertyKeys()"));
      return () -> Iterators.asResourceIterator(properties.iterator());
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
         for (Label label : node.getLabels()) lbl.append(label.name()).append(" ");
         if (lbl.length() > 0) return lbl.toString().trim();

         // if no labels, show uuid:
         return hasUUID(node) ? uuidOf(node).toString() : "[" + node.getPropertyKeys() + "]";
      }
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
      return readNodes(new Statement("MATCH (n:" + label + " {" + property + ": $value}) RETURN n", parameters("value", value)))
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
   public Node findOrCreate(Label label, String key, Object value, Object... properties) {
      if (properties.length % 2 != 0)
         throw new IllegalArgumentException("Properties in findOrCreate must be key-value pairs");

      org.neo4j.driver.v1.types.Node node;

      Iterator<org.neo4j.driver.v1.types.Node> iterator = getNodes(label.name(), key, value).iterator();

      // TODO: Review this - ensuring UUID is generated for Node
      if (!iterator.hasNext())
         node = createNode(label.name(), UUID.randomUUID(), key, value);
      else
         node = iterator.next();

      node = setProperties(node, properties);

      return fromDriverNode(this, node);
   }

   @Override
   public Transaction beginTx() {
      return beginTransaction();
   }

   @Override
   public void registerTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler) {
      txEventHandler.registerTransactionEventHandler(transactionEventHandler);
   }

   @Override
   public void unregisterTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler) {
      txEventHandler.unregisterTransactionEventHandler(transactionEventHandler);
   }
}