package com.generator.neo;


import com.generator.neo.remote.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.neo4j.graphdb.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.UUID;

import static com.generator.util.NeoUtil.TAG_UUID;
import static com.generator.neo.remote.NeoCache.getCachedNode;
import static com.generator.neo.remote.NeoCache.getCachedRelationship;
import static com.generator.neo.remote.NeoNode.fromDriverNode;
import static com.generator.neo.remote.NeoNode.uuidOf;
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
   private static URI NEO4J_URI;

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
      NEO4J_URI = new URI("bolt://localhost:7687");
   }

   @Test
   public void basicFunctionality() {
      RemoteNeoModel remote = new RemoteNeoModel(NEO4J_URI, USERNAME, PASSWORD,
         model -> System.out.println("closed"));

      remote.dropAll();

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
   public void transactions() {

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

      neoDriver.dropAll();

      UUID uuid1 = UUID.fromString("5f955916-75cc-499c-93af-8dcab726f08b");
      UUID uuid2 = UUID.fromString("6fed3bba-b35f-48e7-9c61-2d4e5e36afd4");
      UUID uuid3 = UUID.fromString("1c62a80a-3f50-4b55-8267-0c2123e68589");

      assertEquals(null, getCachedNode(uuid1));
      NeoNode node1 = fromDriverNode(neoDriver, neoDriver.createNode(uuid1));

      assertEquals(null, getCachedNode(uuid2));
      NeoNode node2 = fromDriverNode(neoDriver, neoDriver.createNode(uuid2));

      NeoNode node1cached = getCachedNode(uuid1);
      NeoNode node2cached = getCachedNode(uuid2);

      assertEquals(node1, node1cached);
      assertEquals(node2, node2cached);

      node1.setProperty("jalla", "kebab");

//		NeoNode updated1 = updateCache(fromDriverNode(neoDriver, neoDriver.setNodeProperties(uuid1, "jalla", "kebab")));

      assertTrue(node1cached.hasProperty("jalla"));
//		assertEquals(node1, updated1);

      System.out.println(node1);

      NeoRelationship rel1 = (NeoRelationship)node2.createRelationshipTo(node1cached, newRelationshipType("TJA"));
      NeoRelationship rel1cached = getCachedRelationship(rel1.getUUID());

      assertEquals(rel1, rel1cached);

      rel1cached.setProperty("something", true);

      System.out.println(rel1);

      assertTrue(rel1.hasProperty("something"));
   }

   @Test
   public void doInTransaction() {
      NeoModel neoModel = new RemoteNeoModel(NEO4J_URI, USERNAME, PASSWORD);

      // todo perhaps use a cypher-query for this
//      neoModel.dropAll();

      // Success
      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            final org.neo4j.graphdb.Node country = neoModel.createNode(newLabel("Country"));
            country.setProperty("name", "Kongo");

            final org.neo4j.graphdb.Node person = neoModel.createNode(newLabel("Person"));
            person.setProperty("name", "Bongo");

            person.createRelationshipTo(country, newRelationshipType("FROM"));
         }

         @Override
         public void exception(Throwable throwable) {
            System.err.println(throwable.getMessage());
         }
      });

      // Failure
      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            final org.neo4j.graphdb.Node country = neoModel.createNode(newLabel("Country"));
            country.setProperty("name", "USA");

            final org.neo4j.graphdb.Node person = neoModel.createNode(newLabel("Person"));
            person.setProperty("name", "Drumph");

            person.createRelationshipTo(country, newRelationshipType("FROM"));

            throw new Exception("TEST EXCEPTION DURING TRANSACTION");
         }

         @Override
         public void exception(Throwable throwable) {
            System.out.println(throwable.getMessage());
         }
      });
   }

   static Label newLabel(final String name) {
      return Label.label(name);
   }

   static RelationshipType newRelationshipType(final String name) {
      return RelationshipType.withName(name);
   }
}
