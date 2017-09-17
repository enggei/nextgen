package com.generator.neo.remote;


import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static com.generator.util.NeoUtil.TAG_UUID;
import static com.generator.neo.remote.NeoCache.removeCache;
import static com.generator.neo.remote.NeoCache.updateCache;


/**
 * Created by Ernst Sognnes on 11.07.17.
 */
public class NeoRelationship implements Relationship, NeoEntity {

   private final NeoDriver driver;
   private org.neo4j.driver.v1.types.Relationship driverRelationship;

   private UUID uuid = new UUID(0l, 0l);

   private final RelationshipType type;
   private final NeoNode[] nodes;

   NeoRelationship(@NotNull NeoDriver driver, @NotNull org.neo4j.driver.v1.types.Relationship driverRelationship) {
      this.driver = driver;
      this.driverRelationship = driverRelationship;

      // Extract UUID
      this.uuid = uuidOf(driverRelationship);
      if (this.uuid == null) throw new IllegalArgumentException("Expected node property " + TAG_UUID + " does not exists!");

      // Get type
      this.type = RelationshipType.withName(driverRelationship.type());

      // Start and end nodes
      this.nodes = new NeoNode[] { new NeoNode(driver, driverRelationship.startNodeId()), new NeoNode(driver, driverRelationship.endNodeId()) };

      updateCache(this);
   }

   static NeoRelationship fromDriverRelationship(@NotNull NeoDriver driver, @NotNull org.neo4j.driver.v1.types.Relationship relationship) {
      return new NeoRelationship(driver, relationship);
   }

   public static UUID uuidOf(final org.neo4j.driver.v1.types.Relationship relationship) {
      return relationship == null ? null : hasUUID(relationship) ? UUID.fromString(relationship.get(TAG_UUID).asString()) : null;
   }

   public static UUID uuidOf(final org.neo4j.graphdb.Relationship relationship) {
      return relationship == null ? null : hasUUID(relationship) ? UUID.fromString(relationship.getProperty(TAG_UUID).toString()) : null;
   }

   public static boolean hasUUID(final org.neo4j.driver.v1.types.Relationship relationship) {
      return relationship.containsKey(TAG_UUID);
   }

   public static boolean hasUUID(final org.neo4j.graphdb.Relationship relationship) {
      return relationship.hasProperty(TAG_UUID);
   }

   @Override
   public UUID getUUID() {
      return uuid;
   }

   @Override
   public void merge(NeoEntity neoEntity) {
      if (!(neoEntity instanceof NeoRelationship))
         throw new IllegalArgumentException("Entity is not a NeoRelationship");

      if (!uuid.equals(neoEntity.getUUID()))
         throw new IllegalArgumentException("Trying to merge " + uuid + " with different relationship " + neoEntity.getUUID());

      NeoRelationship other = (NeoRelationship)neoEntity;

      System.out.println("Merging " + this + " with " + other);

      // TODO: When / if cypher will accept changing the relationship type without removing it first
      if (!other.isType(type))
         throw new IllegalArgumentException("Trying to merge " + type.name() + " with different type " + other.type.name());

      this.driverRelationship = other.driverRelationship;

      for (NeoNode node : nodes) node.addOrUpdateRelationship(this);
   }

   @Override
   public void delete() {
      if (driver.deleteRelationship(this) > 0) {

         for (NeoNode node : nodes) {
            node.removeRelationship(this);
         }

         removeCache(this);
      }
   }

   @Override
   public long getId() {
      return driverRelationship.id();
   }

   @Override
   public Node getStartNode() {
      return nodes[0];
   }

   @Override
   public Node getEndNode() {
      return nodes[1];
   }

   @Override
   public Node getOtherNode(Node node) {
      final long id = node.getId();

      if (id == nodes[0].getId()) return nodes[1];
      if (id == nodes[1].getId()) return nodes[0];

      throw new RuntimeException("Input node is neither start nor end of this relationship");
   }

   @Override
   public Node[] getNodes() {
      return nodes;
   }

   @Override
   public RelationshipType getType() {
      return type;
   }

   @Override
   public boolean isType(RelationshipType type) {
      return this.type.equals(type);
   }

   @Override
   public GraphDatabaseService getGraphDatabase() {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean hasProperty(String key) {
      return driverRelationship.containsKey(key);
   }

   @Override
   public Object getProperty(String key) {
      return driverRelationship.get(key).asObject();
   }

   @Override
   public Object getProperty(String key, Object defaultValue) {
      return driverRelationship.containsKey(key) ? driverRelationship.get(key).asObject() : defaultValue;
   }

   @Override
   public void setProperty(String key, Object value) {
      driverRelationship = driver.setRelationshipProperties(type.name(), uuid, key, value);
   }

   @Override
   public Object removeProperty(String key) {
      if (!driverRelationship.containsKey(key)) return null;

      Object old = driverRelationship.get(key).asObject();

      driverRelationship = driver.removeRelationshipProperties(type.name(), uuid, key);

      return old;
   }

   @Override
   public Iterable<String> getPropertyKeys() {
      return driverRelationship.keys();
   }

   @Override
   public Map<String, Object> getProperties(String... keys) {
      Map<String, Object> properties = new LinkedHashMap<>();

      for (String key : keys) {
         if (!driverRelationship.containsKey(key)) continue;
         properties.put(key, driverRelationship.get(key).asObject());
      }

      return properties;
   }

   @Override
   public Map<String, Object> getAllProperties() {
      return driverRelationship.asMap();
   }

   static String toString(NeoRelationship neoRelationship) {
      UUID uuid = uuidOf(neoRelationship);
      StringBuilder properties = new StringBuilder();

      neoRelationship.driverRelationship.asMap().forEach((s, o) -> properties.append(s).append("=").append(o.toString()).append(" "));

      return neoRelationship.getId() + ": "
            + (uuid != null ? uuid.toString() : "NULL")
            + " (" + neoRelationship.getType().name() + ")"
            + " [" + properties.toString() + "]";
   }

   @Override
   public String toString() {
      return toString(this);
   }
}
