package com.generator.neo;


import com.generator.neo.remote.NeoDriver;
import com.generator.neo.remote.RemoteNeoModel;
import com.generator.neo.remote.RemoteNode;
import com.generator.neo.remote.RemoteRelationship;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.event.LabelEntry;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;

import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.neo.remote.NeoCache.getCachedNode;
import static com.generator.neo.remote.NeoCache.getCachedRelationship;
import static com.generator.neo.remote.NeoDriver.CYPHER_DROP_ALL;
import static com.generator.neo.remote.RemoteNode.fromDriverNode;
import static com.generator.neo.remote.RemoteNode.uuidOf;
import static com.generator.util.NeoUtil.TAG_UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ernst Sognnes on 08.07.17.
 */
public class Tests {

	/*

	CALL db.constraints();
	CALL db.indexes();

	*/

   private static final String USERNAME = "neo4j";
   private static final String PASSWORD = "gu11/K0de";
   private static String NEO4J_URI;

   private static final UUID TEST_NODE_UUID[] = {
      UUID.fromString("5f955916-75cc-499c-93af-8dcab726f08b"),
      UUID.fromString("6fed3bba-b35f-48e7-9c61-2d4e5e36afd4"),
      UUID.fromString("1c62a80a-3f50-4b55-8267-0c2123e68589")
   };

   private static final UUID TEST_REL_UUID[] = {
      UUID.fromString("f58e1fde-d585-44ca-b907-5d0e4b875124"),
      UUID.fromString("b764ad71-e6b5-4f11-9b6f-bc9cf48acdeb")
   };

   @BeforeClass
   static public void setup() throws URISyntaxException {
      NEO4J_URI = "bolt://localhost:7687";
   }

   @Test
   public void basicFunctionality() {
      RemoteNeoModel remote = new RemoteNeoModel(NEO4J_URI, USERNAME, PASSWORD,
         model -> System.out.println("closed"));

      UUID uuid = TEST_NODE_UUID[0];

      remote.createNode(uuid,
         "test", "somevalue",
         "int", 128);

      Node node = remote.setNodeProperties(uuid,
         "bool", false,
         "timestamp", System.currentTimeMillis());

      assertTrue("The node does not contain \"test\" and \"int\" properties!", node.containsKey("test") && node.containsKey("int"));
      assertEquals("Nodes are not equal!", node, remote.getSingleNode(uuid));

      UUID uuid2 = TEST_NODE_UUID[1];

      Node node2 = remote.createNode(uuid2);

         Assert.assertNotEquals("Nodes are equal!", node, node2);

      node = remote.setProperties(node, "oneMore", "text");

      assertTrue("This is not the same node!", uuidOf(node).equals(uuid));

      node = remote.replaceNodeProperties(uuid,
         TAG_UUID, uuid.toString());

      assertTrue("More than UUID property remains!", node.size() == 1 && uuidOf(node).equals(uuid));

      remote.addLabel(uuid, "Something");

      UUID uuidLikes = TEST_REL_UUID[0];

      Relationship likes = remote.createOutgoingRelationship(node, node2, "LIKES", uuidLikes);

      remote.setRelationshipProperties("LIKES", uuidLikes,
         "tag", "hoorah!",
         "factor", 47.2f);

      UUID uuid4 = TEST_NODE_UUID[2];

      remote.createNode("D", uuid4);

      UUID uuidHates = TEST_REL_UUID[1];

      Relationship hates = remote.createIncomingRelationship(uuid2, uuid4, "HATES", uuidHates,
         "tool", "pitchfork");

      remote.setProperties(hates,
         "question", "no idea",
         "answer", 42);

      hates = remote.setRelationshipProperties("HATES", uuidHates,
         "oneMore", "yay");

      assertTrue("Wrong number of properties in relationship!", hates.size() == 5);

      for (UUID uuid1 : TEST_NODE_UUID) {
         remote.setNodeProperties(uuid1, "timestamp", System.currentTimeMillis());
      }

      for (UUID uuid1 : TEST_NODE_UUID) {
         assertTrue("Node " + uuid1 + " does not contain \"timestamp\" property!", remote.getNode(uuid1).hasProperty("timestamp"));
      }

      org.neo4j.graphdb.Node node4 = remote.findOrCreate(Label.label("Blah"), "nisse", "fant",
         "bool", true, "int", 256);

      assertTrue("node4 does not contain property \"int\"", node4.hasProperty("int"));

      System.out.println(node4);

      node4 = remote.findOrCreate(Label.label("Blah"), "nisse", "fant",
         "dings", "boms");

      assertTrue("node4 does not contain property \"dings\"", node4.hasProperty("dings"));

      System.out.println(node4);
   }

   @Test
   public void iterators() {
      RemoteNeoModel remote = new RemoteNeoModel(NEO4J_URI, USERNAME, PASSWORD,
         model -> System.out.println("closed"));

      ResourceIterable<org.neo4j.graphdb.Relationship> allRelationships = remote.getAllRelationships();

      System.out.println("Iterator:");
      ResourceIterator<org.neo4j.graphdb.Relationship> iterator = allRelationships.iterator();
      while (iterator.hasNext()) {
         System.out.println(iterator.next());
      }

      System.out.println("Stream:");
      allRelationships.stream().forEach(System.out::println);
   }

   @Test
   public void modelInterface() {
      NeoModel neoModel = new RemoteNeoModel(NEO4J_URI, USERNAME, PASSWORD,
            model -> System.out.println("closed"));

      // todo perhaps use a cypher-query for this
//      neoModel.dropAll();

      UUID uuid1 = UUID.fromString("a1d484b2-7376-4fa9-b9f1-3e2afa3a5c48");

      final org.neo4j.graphdb.Node node1 = neoModel.newNode(uuid1, "key", "value", "number", 83);

      System.out.println(node1);

      Label kookoo = newLabel("Gjøkur");

      node1.addLabel(kookoo);

      assertTrue(node1.hasLabel(kookoo));

      System.out.println(node1);

      final org.neo4j.graphdb.Node node2 = neoModel.createNode(kookoo);

      assertTrue(node2.hasLabel(kookoo));

      System.out.println(node2);

      RelationshipType bird = newRelationshipType("Undulat");

      final org.neo4j.graphdb.Relationship relationship = node2.createRelationshipTo(node1, bird);

      assertTrue(relationship.isType(bird));

      assertEquals(node2.getId(), relationship.getStartNodeId());
      assertEquals(node1.getId(), relationship.getEndNodeId());

      assertTrue(node1.hasRelationship(bird));
      assertTrue(node2.hasRelationship(bird));

      System.out.println(relationship);


   }

   @Test
   public void cache() {
      NeoDriver neoDriver = new NeoDriver(NEO4J_URI, USERNAME, PASSWORD);

      neoDriver.executeCypher(CYPHER_DROP_ALL);

      UUID uuid1 = UUID.fromString("5f955916-75cc-499c-93af-8dcab726f08b");
      UUID uuid2 = UUID.fromString("6fed3bba-b35f-48e7-9c61-2d4e5e36afd4");
      UUID uuid3 = UUID.fromString("1c62a80a-3f50-4b55-8267-0c2123e68589");

      assertEquals(null, getCachedNode(uuid1));
      RemoteNode node1 = fromDriverNode(neoDriver, neoDriver.createNode(uuid1));

      assertEquals(null, getCachedNode(uuid2));
      RemoteNode node2 = fromDriverNode(neoDriver, neoDriver.createNode(uuid2));

      RemoteNode node1cached = getCachedNode(uuid1);
      RemoteNode node2cached = getCachedNode(uuid2);

      assertEquals(node1, node1cached);
      assertEquals(node2, node2cached);

      node1.setProperty("jalla", "kebab");

//		NeoNode updated1 = updateCache(fromDriverNode(neoDriver, neoDriver.setNodeProperties(uuid1, "jalla", "kebab")));

      assertTrue(node1cached.hasProperty("jalla"));
//		assertEquals(node1, updated1);

      System.out.println(node1);

      RemoteRelationship rel1 = (RemoteRelationship)node2.createRelationshipTo(node1cached, newRelationshipType("TJA"));
      RemoteRelationship rel1cached = getCachedRelationship(rel1.getUUID());

      assertEquals(rel1, rel1cached);

      rel1cached.setProperty("something", true);

      System.out.println(rel1);

      assertTrue(rel1.hasProperty("something"));
   }

   @Test
   public void transactions() {
      NeoModel neoModel = new RemoteNeoModel(NEO4J_URI, USERNAME, PASSWORD);

      neoModel.registerTransactionEventHandler(new TransactionEventHandler<Object>() {

         private final Set<Long> deletedNodes = new LinkedHashSet<>();
         private final Set<Long> deletedRelations = new LinkedHashSet<>();
         private final Set<org.neo4j.graphdb.Node> addedNodes = new LinkedHashSet<>();
         private final Set<org.neo4j.graphdb.Relationship> addedRelations = new LinkedHashSet<>();
         private final Set<LabelEntry> assignedLabels = new LinkedHashSet<>();

         @Override
         public Object beforeCommit(TransactionData transactionData) throws Exception {
            System.out.println("before commit");
            transactionData.deletedNodes().forEach(node -> deletedNodes.add(node.getId()));
            transactionData.deletedRelationships().forEach(relationship -> deletedRelations.add(relationship.getId()));
            transactionData.createdNodes().forEach(addedNodes::add);
            transactionData.createdRelationships().forEach(addedRelations::add);
            transactionData.assignedLabels().forEach(assignedLabels::add);
            return null;
         }

         @Override
         public void afterCommit(TransactionData data, Object state) {
            System.out.println("after commit");
            if (!deletedNodes.isEmpty()) {
               System.out.println("deletedNodes: " + deletedNodes.size());
               deletedNodes.clear();
            }

            if (!deletedRelations.isEmpty()) {
               System.out.println("deletedRelations: " + deletedRelations.size());
               deletedRelations.clear();
            }

            if (!addedNodes.isEmpty()) {
               System.out.println("addedNodes: " + addedNodes.size());
               addedNodes.clear();
            }

            if (!addedRelations.isEmpty()) {
               System.out.println("addedRelations: " + addedRelations.size());
               addedRelations.clear();
            }

            if (!assignedLabels.isEmpty()) {
               System.out.println("assignedLabels: " + assignedLabels.size());
               assignedLabels.clear();
            }
         }

         @Override
         public void afterRollback(TransactionData data, Object state) {
            System.out.println("rollback");
         }
      });

      // Test custom state object
      neoModel.registerTransactionEventHandler(new TransactionEventHandler<Object>() {

         @Override
         public Object beforeCommit(TransactionData data) throws Exception {
            System.out.println("before commit");
            return "Supperådet";
         }

         @Override
         public void afterCommit(TransactionData data, Object state) {
            assertEquals("State object does not match!", "Supperådet", state);
            System.out.println("after commit: " + state);
         }

         @Override
         public void afterRollback(TransactionData data, Object state) {
            assertEquals("State object does not match!", "Supperådet", state);
            System.out.println("after rollback: " + state);
         }
      });

      // Success
      neoModel.doInTransaction(tx -> {
         final org.neo4j.graphdb.Node country = neoModel.createNode(newLabel("Country"));
         country.setProperty("name", "Kongo");

         final org.neo4j.graphdb.Node person = neoModel.createNode(newLabel("Person"));
         person.setProperty("name", "Bongo");

         person.createRelationshipTo(country, newRelationshipType("FROM"));

      }, throwable -> System.err.println(throwable.getMessage()));

      // Failure
      neoModel.doInTransaction(tx -> {

         final org.neo4j.graphdb.Node country = neoModel.createNode(newLabel("Country"));
         country.setProperty("name", "USA");

         final org.neo4j.graphdb.Node person = neoModel.createNode(newLabel("Person"));
         person.setProperty("name", "Drumph");

         person.createRelationshipTo(country, newRelationshipType("FROM"));

         throw new Exception("TEST EXCEPTION DURING TRANSACTION");

      }, throwable -> System.out.println(throwable.getMessage()));

      // Terminate
      neoModel.doInTransaction(tx -> {
         final org.neo4j.graphdb.Node country = neoModel.createNode(newLabel("Animal"));
         country.setProperty("name", "Pig");

         tx.terminate();

      }, throwable -> System.err.println(throwable.getMessage()));

      // Success
      neoModel.doInTransaction(tx -> {
         final org.neo4j.graphdb.Node country = neoModel.createNode(newLabel("Country"));
         country.setProperty("name", "North Korea");

         final org.neo4j.graphdb.Node person = neoModel.createNode(newLabel("Person"));
         person.setProperty("name", "Rocket Man");

         person.createRelationshipTo(country, newRelationshipType("FROM"));

      }, throwable -> System.err.println(throwable.getMessage()));
   }

   static Label newLabel(final String name) {
      return Label.label(name);
   }

   static RelationshipType newRelationshipType(final String name) {
      return RelationshipType.withName(name);
   }
}
