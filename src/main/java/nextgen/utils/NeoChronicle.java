package nextgen.utils;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class NeoChronicle implements TransactionEventHandler<UUID> {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NeoChronicle.class);

   private final GraphDatabaseService db;
   private final File transactionDir;
   private final Map<UUID, ChronicleTransaction> transactionMap = new LinkedHashMap<>();

   public NeoChronicle(String storeDir, GraphDatabaseService db) {
      this(new File(storeDir), db);
   }

   public NeoChronicle(File storeDir, GraphDatabaseService db) {
      this.db = db;
      this.db.registerTransactionEventHandler(this);
      this.transactionDir = FileUtil.tryToCreateDirIfNotExists(new File(storeDir, "chronicle"));
   }

   public Map<String, File> getTransactions() {

      final Map<String, File> map = new TreeMap<>();

      final File[] files = transactionDir.listFiles(file -> file.isFile() && file.getName().startsWith("tx_"));
      if (files == null || files.length == 0) return map;

      final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
      for (File file : files)
         map.put(simpleDateFormat.format(Long.parseLong(file.getName().substring(3))), file);

      return map;
   }

   public void rollback(List<File> files) {

      files.sort((f1, f2) -> f2.getName().compareToIgnoreCase(f1.getName()));

      doInTransaction(db, transaction -> {
         for (File file : files) {
            try {
               ChronicleTransaction.rollback(db, new JsonObject(Buffer.buffer(Files.readAllBytes(file.toPath()))));
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
         }
      });
   }

   public void rollback(File file) {
      rollback(Collections.singletonList(file));
   }

   public void rollbackLast() {
      final File[] files = transactionDir.listFiles(file -> file.isFile() && file.getName().startsWith("tx_"));
      if (files == null || files.length == 0) return;
      Arrays.sort(files, (f1, f2) -> f2.getName().compareToIgnoreCase(f1.getName()));
      rollback(files[0]);
   }

   @Override
   public UUID beforeCommit(TransactionData transactionData) {
      log.debug("before commit");
      final ChronicleTransaction transaction = new ChronicleTransaction(transactionData);
      transactionMap.put(transaction.uuid, transaction);
      return transaction.uuid;
   }

   @Override
   public void afterCommit(TransactionData transactionData, UUID uuid) {
      log.debug("after commit");
      transactionMap.remove(uuid).writeToFile(transactionDir);
   }

   @Override
   public void afterRollback(TransactionData transactionData, UUID uuid) {
      log.debug("after rollback");
      transactionMap.remove(uuid);
   }

   public static void doInTransaction(GraphDatabaseService db, java.util.function.Consumer<org.neo4j.graphdb.Transaction> action) {
      doInTransaction(db, action, java.lang.Throwable::printStackTrace);
   }

   public static void doInTransaction(GraphDatabaseService db, java.util.function.Consumer<org.neo4j.graphdb.Transaction> action, java.util.function.Consumer<java.lang.Throwable> onException) {
      try (org.neo4j.graphdb.Transaction tx = db.beginTx()) {
         action.accept(tx);
         tx.success();
      } catch (java.lang.Throwable t) {
         log.error("transaction error", t);
         onException.accept(t);
      }
   }

   private static final class ChronicleTransaction {

      private final UUID uuid = UUID.randomUUID();
      private final JsonObject data = new JsonObject();

      private static final String CREATED_NODES = "cn";
      private static final String CREATED_RELATIONS = "cr";
      private static final String ASSIGNED_LABELS = "al";
      private static final String ASSIGNED_NODE_PROPERTIES = "anp";
      private static final String ASSIGNED_RELATIONSHIP_PROPERTIES = "arp";
      private static final String DELETED_NODES = "dp";
      private static final String DELETED_RELATIONSHIPS = "dr";
      private static final String REMOVED_LABELS = "rl";
      private static final String REMOVED_NODE_PROPERTIES = "rnp";
      private static final String REMOVED_RELATIONSHIP_PROPERTIES = "rrp";

      public ChronicleTransaction(TransactionData transactionData) {

         // created
         final JsonArray createdNodes = addJsonArray(data, CREATED_NODES);
         transactionData.createdNodes().forEach(entry -> addJsonObject(createdNodes)
               .put("i", entry.getId()));

         final JsonArray createdRelations = addJsonArray(data, CREATED_RELATIONS);
         transactionData.createdRelationships().forEach(entry -> addJsonObject(createdRelations)
               .put("i", entry.getId())
               .put("t", entry.getType().name())
               .put("s", entry.getStartNodeId())
               .put("d", entry.getEndNodeId()));

         // assigned
         final JsonArray assignedLabels = addJsonArray(data, ASSIGNED_LABELS);
         transactionData.assignedLabels().forEach(entry -> addJsonObject(assignedLabels)
               .put("i", entry.node().getId())
               .put("l", entry.label().name()));

         final JsonArray assignedNodeProperties = addJsonArray(data, ASSIGNED_NODE_PROPERTIES);
         transactionData.assignedNodeProperties().forEach(entry -> addJsonObject(assignedNodeProperties)
               .put("i", entry.entity().getId())
               .put("k", entry.key())
               .put("v", entry.value()));

         final JsonArray assignedRelationshipProperties = addJsonArray(data, ASSIGNED_RELATIONSHIP_PROPERTIES);
         transactionData.assignedRelationshipProperties().forEach(entry -> addJsonObject(assignedRelationshipProperties)
               .put("i", entry.entity().getId())
               .put("k", entry.key())
               .put("v", entry.value()));

         // deleted
         final JsonArray deletedNodes = addJsonArray(data, DELETED_NODES);
         transactionData.deletedNodes().forEach(entry -> addJsonObject(deletedNodes)
               .put("i", entry.getId()));

         final JsonArray deletedRelationships = addJsonArray(data, DELETED_RELATIONSHIPS);
         transactionData.deletedRelationships().forEach(entry -> addJsonObject(deletedRelationships)
               .put("i", entry.getId())
               .put("t", entry.getType().name())
               .put("s", entry.getStartNodeId())
               .put("d", entry.getEndNodeId()));

         // removed
         final JsonArray removedLabels = addJsonArray(data, REMOVED_LABELS);
         transactionData.removedLabels().forEach(entry -> addJsonObject(removedLabels)
               .put("i", entry.node().getId())
               .put("l", entry.label().name()));

         final JsonArray removedNodeProperties = addJsonArray(data, REMOVED_NODE_PROPERTIES);
         transactionData.removedNodeProperties().forEach(entry -> addJsonObject(removedNodeProperties)
               .put("i", entry.entity().getId())
               .put("k", entry.key())
               .put("v", entry.previouslyCommitedValue()));

         final JsonArray removedRelationshipProperties = addJsonArray(data, REMOVED_RELATIONSHIP_PROPERTIES);
         transactionData.removedRelationshipProperties().forEach(entry -> addJsonObject(removedRelationshipProperties)
               .put("i", entry.entity().getId())
               .put("k", entry.key())
               .put("v", entry.previouslyCommitedValue()));
      }

      private JsonObject addJsonObject(JsonArray jsonArray) {
         final JsonObject element = new JsonObject();
         jsonArray.add(element);
         return element;
      }

      private JsonArray addJsonArray(JsonObject owner, String name) {
         if (owner.containsKey(name)) return owner.getJsonArray(name);
         owner.put(name, new JsonArray());
         return owner.getJsonArray(name);
      }

      public static void rollback(GraphDatabaseService db, JsonObject data) {

         final JsonArray createdNodes = getJsonArray(data, CREATED_NODES);
         final JsonArray createdRelations = getJsonArray(data, CREATED_RELATIONS);
         final JsonArray assignedLabels = getJsonArray(data, ASSIGNED_LABELS);
         final JsonArray removedLabels = getJsonArray(data, REMOVED_LABELS);
         final JsonArray assignedNodeProperties = getJsonArray(data, ASSIGNED_NODE_PROPERTIES);
         final JsonArray assignedRelationshipProperties = getJsonArray(data, ASSIGNED_RELATIONSHIP_PROPERTIES);
         final JsonArray deletedNodes = getJsonArray(data, DELETED_NODES);
         final JsonArray deletedRelationships = getJsonArray(data, DELETED_RELATIONSHIPS);
         final JsonArray removedNodeProperties = getJsonArray(data, REMOVED_NODE_PROPERTIES);
         final JsonArray removedRelationshipProperties = getJsonArray(data, REMOVED_RELATIONSHIP_PROPERTIES);

         doInTransaction(db, transaction -> {

            final Map<Long, Node> recoveredNodes = new LinkedHashMap<>();
            final Map<Long, Relationship> recoveredRelations = new LinkedHashMap<>();

            getJsonObjects(deletedNodes).forEach(jsonObject ->
                  recoveredNodes.put(jsonObject.getLong("i"), db.createNode()));

            getJsonObjects(deletedRelationships).forEach(jsonObject -> {
               final Node src = getNode(db, recoveredNodes, jsonObject.getLong("s"));
               final Node dst = getNode(db, recoveredNodes, jsonObject.getLong("d"));
               recoveredRelations.put(jsonObject.getLong("i"),
                     src.createRelationshipTo(dst, RelationshipType.withName(jsonObject.getString("t"))));
            });


            getJsonObjects(assignedLabels).forEach(jsonObject ->
                  getNode(db, recoveredNodes, jsonObject)
                        .removeLabel(Label.label(jsonObject.getString("l"))));

            getJsonObjects(assignedNodeProperties).forEach(jsonObject ->
                  getNode(db, recoveredNodes, jsonObject)
                        .removeProperty(jsonObject.getString("k")));

            getJsonObjects(assignedRelationshipProperties).forEach(jsonObject ->
                  getRelationship(db, recoveredRelations, jsonObject)
                        .removeProperty(jsonObject.getString("k")));

            getJsonObjects(createdRelations).forEach(jsonObject ->
                  getRelationship(db, recoveredRelations, jsonObject).delete());

            getJsonObjects(createdNodes).forEach(jsonObject ->
                  getNode(db, recoveredNodes, jsonObject).delete());


            getJsonObjects(removedLabels).forEach(jsonObject ->
                  getNode(db, recoveredNodes, jsonObject)
                        .addLabel(Label.label(jsonObject.getString("l"))));

            getJsonObjects(removedNodeProperties).forEach(jsonObject ->
                  getNode(db, recoveredNodes, jsonObject)
                        .setProperty(jsonObject.getString("k"), jsonObject.getValue("v")));

            getJsonObjects(removedRelationshipProperties).forEach(jsonObject ->
                  getRelationship(db, recoveredRelations, jsonObject)
                        .setProperty(jsonObject.getString("k"), jsonObject.getValue("v")));
         });
      }

      private static Relationship getRelationship(GraphDatabaseService db, Map<Long, Relationship> recoveredRelations, JsonObject jsonObject) {
         final Relationship relationship = recoveredRelations.get(jsonObject.getLong("i"));
         return relationship == null ? db.getRelationshipById(jsonObject.getLong("i")) : relationship;
      }

      private static Node getNode(GraphDatabaseService db, Map<Long, Node> recoveredNodes, JsonObject jsonObject) {
         return getNode(db, recoveredNodes, jsonObject.getLong("i"));
      }

      private static Node getNode(GraphDatabaseService db, Map<Long, Node> recoveredNodes, Long id) {
         final Node node = recoveredNodes.get(id);
         return node == null ? db.getNodeById(id) : node;
      }

      private static Stream<JsonObject> getJsonObjects(JsonArray jsonArray) {
         return jsonArray.stream().map(o -> (JsonObject) o);
      }

      private static JsonArray getJsonArray(JsonObject data, String name) {
         return data.getJsonArray(name, new JsonArray());
      }

      private void writeToFile(File transactionDir) {
         final File file = FileUtil.tryToCreateFileIfNotExists(new File(transactionDir, "tx_" + System.currentTimeMillis()));
         try {
            java.nio.file.Files.write(file.toPath(), data.toBuffer().getBytes());
         } catch (Throwable e) {
            log.error("unable to write chronicle tx " + file.getAbsolutePath() + " : " + e.getMessage(), e);
            log.error(data.encode());
         }
      }
   }
}