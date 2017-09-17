package com.generator.neo;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.index.IndexManager;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public interface NeoModel {

   ResourceIterable<Relationship> getAllRelationships();

   ResourceIterable<Label> getAllLabelsInUse();

   ResourceIterable<RelationshipType> getAllRelationshipTypesInUse();

   ResourceIterable<Label> getAllLabels();

   ResourceIterable<RelationshipType> getAllRelationshipTypes();

   ResourceIterable<String> getAllPropertyKeys();

   void registerTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler);

   void unregisterTransactionEventHandler(TransactionEventHandler<Object> transactionEventHandler);

   Node createNode(final Label label);

   Node newNode(Label label, Object... kv);

   Node newNode(String label, Object... kv);

   Node newNode(final UUID uuid, Object... kv);

   Node newNode(final String label, final UUID uuid, Object... kv);

   Node getNode(final UUID uuid);

   Set<Node> getAll(String label);

   Set<Node> getAll(String label, String property, Object value);

   Set<Node> getAll(String property, Object value);

   Result query(String query);

   Iterator<Node> findNodes(Label label);

   Iterator<Node> findNodes(Label label, String key, Object value);

   Iterable<Node> findNodesWithProperty(String property);

   Node findNode(Label label, String key, Object value);

   Node findOrCreate(Label label, String key, Object value, Object ... properties);

   IndexManager index();

   org.neo4j.graphdb.Transaction beginTx();

   void close();

   interface Committer {

      void doAction(org.neo4j.graphdb.Transaction tx) throws Throwable;

      void exception(Throwable throwable);
   }

   default void doInTransaction(Committer committer) {
      try (org.neo4j.graphdb.Transaction tx = beginTx()) {
         try {
            committer.doAction(tx);
            tx.success();
         } catch (Throwable throwable) {
            committer.exception(throwable);
            tx.failure();
         }
      }
   }
}