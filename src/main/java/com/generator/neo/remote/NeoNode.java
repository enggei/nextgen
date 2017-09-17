package com.generator.neo.remote;

import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.generator.util.NeoUtil.TAG_UUID;
import static com.generator.neo.remote.NeoCache.removeCache;
import static com.generator.neo.remote.NeoCache.updateCache;
import static com.generator.neo.remote.NeoRelationship.fromDriverRelationship;


/**
 * Created by Ernst Sognnes on 11.07.17.
 */
public class NeoNode implements Node, NeoEntity {

   private final NeoDriver driver;
   private org.neo4j.driver.v1.types.Node driverNode;
   private final Collection<org.neo4j.driver.v1.types.Relationship> driverRelationships = new LinkedHashSet<>();

   private UUID uuid = new UUID(0l, 0l);

   private AtomicBoolean populated = new AtomicBoolean(false);

   // TODO: Perhaps we can implement a custom map and replace these two maps
   private final Map<RelationshipType, Map<UUID, Relationship>> degrees = new LinkedHashMap<>();
   private final Map<UUID, Relationship> relationships = new LinkedHashMap<>();

   // Every node gets a default label so we can combine it with the TAG_UUID property and create a global index for node UUIDs.
   static String TAG_NODE = "_node";

   NeoNode(@NotNull final NeoDriver driver, long id) {
      this(driver, driver.getSingleNodeWithRelationships(id));
   }

   public NeoNode(@NotNull final NeoDriver driver, @NotNull final UUID uuid) {
      this(driver, TAG_NODE, uuid);
   }

   public NeoNode(@NotNull final NeoDriver driver, @NotNull final Label label, @NotNull final UUID uuid) {
      this(driver, label.name(), uuid);
   }

   public NeoNode(@NotNull final NeoDriver driver, @NotNull final String label, @NotNull final UUID uuid) {
      this(driver, driver.getSingleNodeWithRelationships(label, uuid));
   }

   public NeoNode(@NotNull final NeoDriver driver, @NotNull NeoDriver.NodeWithRelationships nwr) {
      this(driver, nwr.node(), nwr.relationships());
   }

   private NeoNode(@NotNull final NeoDriver driver, @NotNull final org.neo4j.driver.v1.types.Node driverNode, final Collection<org.neo4j.driver.v1.types.Relationship> driverRelationships) {
      this.driver = driver;
      this.driverNode = driverNode;

      // Extract UUID
      this.uuid = uuidOf(driverNode);
      if (this.uuid == null)
         throw new IllegalArgumentException("Expected node property " + TAG_UUID + " does not exists!");

      if (driverRelationships == null) this.driverRelationships.addAll(driver.getRelationships(uuid));

      this.driverRelationships.forEach(this::addOrUpdateRelationship);

      updateCache(this);
   }

   protected void addOrUpdateRelationship(@NotNull final NeoRelationship relationship) {
      final RelationshipType type = relationship.getType();
      final UUID uuid = relationship.getUUID();

      if (!degrees.containsKey(type)) degrees.put(type, new LinkedHashMap<>());

      degrees.get(type).put(uuid, relationship);

      if (!relationships.containsKey(uuid)) relationships.put(uuid, relationship);
   }

   protected void addOrUpdateRelationship(@NotNull final org.neo4j.driver.v1.types.Relationship relationship) {
      final RelationshipType type = RelationshipType.withName(relationship.type());

      if (!degrees.containsKey(type)) degrees.put(type, new LinkedHashMap<>());

      final NeoRelationship r = new NeoRelationship(driver, relationship);
      final UUID uuid = r.getUUID();

      degrees.get(type).put(uuid, r);

      if (!relationships.containsKey(uuid)) relationships.put(uuid, r);
   }

   protected void removeRelationship(@NotNull final NeoRelationship relationship) {
      final RelationshipType type = relationship.getType();
      final UUID uuid = relationship.getUUID();

      if (degrees.containsKey(type) && degrees.get(type).containsKey(uuid)) {
         degrees.get(type).remove(uuid);
         if (degrees.get(type).isEmpty()) degrees.remove(type);
      }

      if (relationships.containsKey(uuid)) relationships.remove(uuid);
   }

   @Override
   public UUID getUUID() {
      return uuid;
   }

   private static void merge(NeoNode self, final Map<UUID, Relationship> other) {
      // Clear all that are not present in "other"
      self.relationships.forEach((uuid, r) -> {
         final NeoRelationship relationship = (NeoRelationship)r;
         final NeoNode otherNode = (NeoNode)relationship.getOtherNode(self);

         // Clear if not present in "other"
         if (!other.containsKey(uuid)) {

            otherNode.removeRelationship(relationship);
            self.removeRelationship(relationship);
         }
      });

      // Add or update remaining only present in "other"
      other.forEach((uuid, r) -> {
         final NeoRelationship relationship = (NeoRelationship)r;
         final NeoNode otherNode = (NeoNode)relationship.getOtherNode(self);

         otherNode.addOrUpdateRelationship(relationship);
         self.addOrUpdateRelationship(relationship);
      });
   }

   @Override
   public void merge(NeoEntity neoEntity) {
      if (!(neoEntity instanceof NeoNode))
         throw new IllegalArgumentException("Entity is not a NeoNode");

      if (!uuid.equals(neoEntity.getUUID()))
         throw new IllegalArgumentException("Not allowed to to merge different nodes: " + uuid + " and " + neoEntity.getUUID());

      NeoNode other = (NeoNode)neoEntity;

      System.out.println("Merging " + this + " with " + other);

      this.driverNode = other.driverNode;
      this.driverRelationships.clear();
      this.driverRelationships.addAll(other.driverRelationships);

      merge(this, other.relationships);
   }

   public static NeoNode fromDriverNode(@NotNull NeoDriver driver, @NotNull org.neo4j.driver.v1.types.Node node) {
      return fromDriverNode(driver, node, null);
   }

   static NeoNode fromDriverNode(@NotNull NeoDriver driver, @NotNull org.neo4j.driver.v1.types.Node node, Collection<org.neo4j.driver.v1.types.Relationship> relationships) {
      return new NeoNode(driver, node, relationships);
   }

   // todo move static methods into BaseDomainVisitor, (which will be refactored to NeoUtil)
   public static UUID uuidOf(final org.neo4j.driver.v1.types.Node node) {
      return node == null ? null : hasUUID(node) ? UUID.fromString(node.get(TAG_UUID).asString()) : null;
   }

   public static UUID uuidOf(final org.neo4j.graphdb.Node node) {
      return node == null ? null : hasUUID(node) ? UUID.fromString(node.getProperty(TAG_UUID).toString()) : null;
   }

   public static boolean hasUUID(final org.neo4j.driver.v1.types.Node node) {
      return node.containsKey(TAG_UUID);
   }

   public static boolean hasUUID(final org.neo4j.graphdb.Node node) {
      return node.hasProperty(TAG_UUID);
   }

   @Override
   public void addLabel(Label label) {
      driverNode = driver.addLabel(uuid, label.name());
   }

   @Override
   public long getId() {
      return driverNode.id();
   }

   @Override
   public void delete() {
      if (driver.deleteNode(uuid) > 0) removeCache(this);
   }

   @Override
   public Iterable<Relationship> getRelationships() {
      return relationships.values();
   }

   @Override
   public boolean hasRelationship() {
      return relationships.size() > 0;
   }

   @Override
   public Iterable<Relationship> getRelationships(RelationshipType... types) {
      Set<Relationship> result = new LinkedHashSet<>();

      for (RelationshipType type : types) {
         if (!degrees.containsKey(type)) continue;
         result.addAll(degrees.get(type).values());
      }

      return result;
   }

   @Override
   public Iterable<Relationship> getRelationships(Direction direction, RelationshipType... types) {
      Set<Relationship> result = new LinkedHashSet<>();

      for (RelationshipType type : types) {
         if (!degrees.containsKey(type)) continue;
         result.addAll(degrees.get(type).values()
               .stream()
               .filter(relationship -> filterRelationship(direction, relationship, this))
               .collect(Collectors.toList()));
      }

      return result;
   }

   static boolean filterOutgoing(Relationship relationship, Node node) {
      return relationship.getStartNodeId() == node.getId();
   }

   static boolean filterIncoming(Relationship relationship, Node node) {
      return relationship.getEndNodeId() == node.getId();
   }

   static boolean filterRelationship(Direction direction, Relationship relationship, Node node) {
      switch (direction) {
         case OUTGOING:
            return relationship.getStartNodeId() == node.getId();
         case INCOMING:
            return relationship.getEndNodeId() == node.getId();
         default:
            return true;
      }
   }

   @Override
   public boolean hasRelationship(RelationshipType... types) {
      for (RelationshipType type : types)
         if (degrees.containsKey(type))
            return degrees.get(type).size() > 0;

      return false;
   }

   @Override
   public boolean hasRelationship(Direction direction, RelationshipType... types) {
      for (RelationshipType type : types) {
         if (!degrees.containsKey(type)) continue;
         switch (direction) {
            case OUTGOING:
               return degrees.get(type).values()
                     .stream()
                     .anyMatch(relationship -> filterOutgoing(relationship, this));
            case INCOMING:
               return degrees.get(type).values()
                     .stream()
                     .anyMatch(relationship -> filterIncoming(relationship, this));
            default:
               return degrees.get(type).size() > 0;
         }
      }

      return false;
   }

   @Override
   public Iterable<Relationship> getRelationships(Direction dir) {
      switch (dir) {
         case OUTGOING:
            return relationships.values()
                  .stream()
                  .filter(relationship -> filterOutgoing(relationship, this))
                  .collect(Collectors.toList());
         case INCOMING:
            return relationships.values()
                  .stream()
                  .filter(relationship -> filterIncoming(relationship, this))
                  .collect(Collectors.toList());
         default:
            return relationships.values();
      }
   }

   @Override
   public boolean hasRelationship(Direction dir) {
      return relationships.values()
            .stream()
            .anyMatch(relationship -> filterRelationship(dir, relationship, this));
   }

   @Override
   public Iterable<Relationship> getRelationships(RelationshipType type, Direction dir) {
      Set<Relationship> result = new LinkedHashSet<>();

      if (!degrees.containsKey(type)) return result;

      result.addAll(
            degrees.get(type).values()
                  .stream()
                  .filter(relationship -> filterRelationship(dir, relationship, this))
                  .collect(Collectors.toList())
      );

      return result;
   }

   @Override
   public boolean hasRelationship(RelationshipType type, Direction dir) {
      return degrees.containsKey(type) && degrees.get(type).values()
            .stream()
            .anyMatch(relationship -> filterRelationship(dir, relationship, this));
   }

   @Override
   public Relationship getSingleRelationship(RelationshipType type, Direction dir) {
      if (!degrees.containsKey(type)) return null;

      final AtomicReference<Relationship> result = new AtomicReference<>();

      getRelationships(type, dir).iterator().forEachRemaining(relationship -> {
         if (!filterRelationship(dir, relationship, this)) return;

         if (result.get() != null)
            throw new RuntimeException("More than one " + dir.name() + " " + type.name() + " relationship exists");

         result.set(relationship);
      });

      return result.get();
   }

   @Override
   public Relationship createRelationshipTo(Node otherNode, RelationshipType type) {
      if (!(otherNode instanceof NeoNode)) throw new IllegalArgumentException("otherNode is not an instance of NeoNode");

      NeoNode other = (NeoNode)otherNode;
      final Relationship relationship = fromDriverRelationship(driver,
            driver.createOutgoingRelationship(this.getUUID(), other.getUUID(), type.name(), UUID.randomUUID()));

      this.addOrUpdateRelationship((NeoRelationship) relationship);
      other.addOrUpdateRelationship((NeoRelationship) relationship);

      return relationship;
   }

   @Override
   public Iterable<RelationshipType> getRelationshipTypes() {
      return degrees.keySet();
   }

   @Override
   public int getDegree() {
      return relationships.size();
   }

   @Override
   public int getDegree(RelationshipType type) {
      if (!degrees.containsKey(type)) return 0;
      return degrees.get(type).size();
   }

   @Override
   public int getDegree(Direction direction) {
      return (int)relationships.values()
            .stream()
            .filter(relationship -> filterRelationship(direction, relationship, this))
            .count();
   }

   @Override
   public int getDegree(RelationshipType type, Direction direction) {
      if (!degrees.containsKey(type)) return 0;

      return (int)degrees.get(type).values()
            .stream()
            .filter(relationship -> filterRelationship(direction, relationship, this))
            .count();
   }

   @Override
   public void removeLabel(Label label) {
      if (!driverNode.hasLabel(label.name())) return;

      driverNode = driver.removeLabel(this.getUUID(), label.name());
   }

   @Override
   public boolean hasLabel(Label label) {
      return driverNode.hasLabel(label.name());
   }

   @Override
   public Iterable<Label> getLabels() {
      Set<Label> labels = new LinkedHashSet<>();

      driverNode.labels().forEach(s -> labels.add(() -> s));

      return labels;
   }

   @Override
   public GraphDatabaseService getGraphDatabase() {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean hasProperty(String key) {
      return driverNode.containsKey(key);
   }

   @Override
   public Object getProperty(String key) {
      if (!driverNode.containsKey(key))
         throw new NotFoundException("Property " + key + " does not exist for node " + this.getUUID());

      return driverNode.get(key).asObject();
   }

   @Override
   public Object getProperty(String key, Object defaultValue) {
      if (!driverNode.containsKey(key)) return defaultValue;

      return driverNode.get(key).asObject();
   }

   @Override
   public void setProperty(String key, Object value) {
      driverNode = driver.setNodeProperties(this.getUUID(), key, value);
   }

   @Override
   public Object removeProperty(String key) {
      if (!driverNode.containsKey(key)) return null;

      Object old = driverNode.get(key).asObject();

      driverNode = driver.removeNodeProperties(this.getUUID(), key);

      return old;
   }

   @Override
   public Iterable<String> getPropertyKeys() {
      return driverNode.keys();
   }

   @Override
   public Map<String, Object> getProperties(String... keys) {
      Map<String, Object> properties = new LinkedHashMap<>();

      for (String key : keys) {
         if (!driverNode.containsKey(key)) continue;
         properties.put(key, driverNode.get(key).asObject());
      }

      return properties;
   }

   @Override
   public Map<String, Object> getAllProperties() {
      return driverNode.asMap();
   }

   static String toString(NeoNode neoNode) {
      UUID uuid = uuidOf(neoNode);
      StringBuilder properties = new StringBuilder();

      neoNode.driverNode.asMap().forEach((s, o) -> properties.append(s).append("=").append(o.toString()).append(" "));

      return neoNode.getId() + ": "
            + (uuid != null ? uuid.toString() : "NULL")
            + " (" + StreamSupport.stream(neoNode.driverNode.labels().spliterator(), false).collect(Collectors.joining(" ")) + ")"
            + " [" + properties.toString() + "]";
   }

   @Override
   public String toString() {
      return toString(this);
   }
}
