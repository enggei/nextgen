package com.generator.neo.vertx;


import com.generator.neo.embedded.EmbeddedNeoModel;
import com.generator.util.FormatUtil;
import com.generator.util.NeoUtil;
import com.generator.util.VertxUtil;
import io.vertx.core.Future;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.*;

import static com.generator.util.NeoUtil.*;


/**
 * goe on 2/9/16.
 */
public class NeoVerticle extends BaseNeoVerticle {

   private EmbeddedNeoModel model;

   // interface for custom-traversers
   public interface NeoVisitor {

      Object visit(EmbeddedNeoModel model, JsonObject parameters) throws Throwable;

   }

   @Override
   protected JsonObject onStart() throws Exception {

      final GraphDatabaseService db = new GraphDatabaseFactory().
            newEmbeddedDatabaseBuilder(new File(config().getString("neo.path"))).
            newGraphDatabase();

      this.model = new EmbeddedNeoModel(db, onClose -> publishToNeoInstance(VertxUtil.newStatus(deploymentID(), "closed")));

      return super.onStart();
   }

   @Override
   public void stop(Future<Void> stopFuture) throws Exception {
      final String deploymentID = deploymentID();
      log.info("Stopping NeoVerticle " + deploymentID);

      VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
         @Override
         public JsonObject execute() throws Throwable {
            model.close();
            return new JsonObject();
         }

         @Override
         public void onSuccess(JsonObject result) {
            log.info(deploymentID + " model closed");
         }

         @Override
         public void onFail(Throwable t) {
            log.info(deploymentID + " model failed to close");
         }
      });

      super.stop(stopFuture);
   }

   @Override
   protected void handleInstanceMessage(Message<JsonObject> message) {
      super.handleInstanceMessage(message);

      // todo add thread-pool and queue, and test performance
      // todo add metrics as supported through Vertx
      final long timestamp = System.currentTimeMillis();
      final String action = message.body().getString("action");

      VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
         @Override
         public JsonObject execute() throws Throwable {

            JsonObject result;

            try (org.neo4j.graphdb.Transaction tx = model.beginTx()) {
               try {

                  switch (action) {

                     case "createNode":

                        final Node newNode = model.createNode(Label.label(message.body().getString("label")));

                        for (Object tmp : message.body().getJsonArray("properties")) {
                           final JsonObject property = (JsonObject) tmp;
                           newNode.setProperty(property.getString("name"), property.getValue("value"));
                        }

                        result = VertxUtil.newSuccess(NeoUtil.uuidOf(newNode).toString());
                        break;

                     case "removeNode":

                        final Node nodeToDelete = model.getNode(UUID.fromString(message.body().getString("uuid")));

                        if (nodeToDelete == null)
                           throw new IllegalStateException(message.body().getString("uuid") + " not found");
                        else
                           result = deleteNode(nodeToDelete, message);
                        break;

                     case "updateNode":

                        final Node nodeToUpdate = model.getNode(UUID.fromString(message.body().getString("uuid")));
                        if (nodeToUpdate == null) {
                           throw new IllegalStateException(message.body().getString("uuid") + " not found");
                        } else {
                           for (Object tmp : message.body().getJsonArray("properties")) {
                              final JsonObject property = (JsonObject) tmp;
                              nodeToUpdate.setProperty(property.getString("name"), property.getValue("value"));
                           }
                           result = VertxUtil.newSuccess(message.body().getString("uuid"));
                        }

                        break;

                     case "inspectNode":

                        final Node nodeToInspect = model.getNode(UUID.fromString(message.body().getString("uuid")));
                        if (nodeToInspect == null) {
                           throw new IllegalStateException(message.body().getString("uuid") + " not found");
                        } else {

                           final JsonObject content = new JsonObject();

                           // get node-labels
                           final JsonArray labels = new JsonArray();
                           for (Label label : nodeToInspect.getLabels())
                              labels.add(label.name());
                           content.put("labels", labels);

                           // get node-properties
                           final JsonArray properties = new JsonArray();
                           for (String propertyKey : nodeToInspect.getPropertyKeys()) {
                              final JsonObject property = new JsonObject().
                                    put("name", propertyKey).
                                    put("value", nodeToInspect.getProperty(propertyKey));
                              properties.add(property);
                           }
                           content.put("properties", properties);

                           // get outgoing-relations, with other node-uuid
                           final JsonArray outgoing = new JsonArray();
                           outgoing(nodeToInspect).forEach(relationship -> {

                              final JsonObject relation = new JsonObject();
                              relation.put("other", uuidOf(other(nodeToInspect, relationship)).toString());
                              relation.put("relationshipType", relationship.getType().name());

                              final JsonArray relationProperties = new JsonArray();
                              for (String relationPropertyKey : relationship.getPropertyKeys()) {
                                 final JsonObject relationProperty = new JsonObject().
                                       put("name", relationPropertyKey).
                                       put("value", relationship.getProperty(relationPropertyKey));
                                 relationProperties.add(relationProperty);
                              }
                              relation.put("properties", relationProperties);
                              outgoing.add(relation);
                           });
                           content.put("outgoing", outgoing);

                           // get incoming-relations, with other node-uuid
                           final JsonArray incoming = new JsonArray();
                           incoming(nodeToInspect).forEach(relationship -> {

                              final JsonObject relation = new JsonObject();
                              relation.put("other", uuidOf(other(nodeToInspect, relationship)).toString());
                              relation.put("relationshipType", relationship.getType().name());

                              final JsonArray relationProperties = new JsonArray();
                              for (String relationPropertyKey : relationship.getPropertyKeys()) {
                                 final JsonObject relationProperty = new JsonObject().
                                       put("name", relationPropertyKey).
                                       put("value", relationship.getProperty(relationPropertyKey));
                                 relationProperties.add(relationProperty);
                              }
                              relation.put("properties", relationProperties);
                              incoming.add(relation);
                           });
                           content.put("incoming", incoming);

                           result = VertxUtil.newSuccess(content);
                        }

                        break;

                     case "relateNodes": {

                        final Node srcNode = model.getNode(UUID.fromString(message.body().getString("src")));
                        final Node dstNode = model.getNode(UUID.fromString(message.body().getString("dst")));
                        final RelationshipType relationshipType = RelationshipType.withName(message.body().getString("relationshipType"));

                        if (srcNode == null || dstNode == null)
                           throw new IllegalStateException((srcNode == null ? "src " + message.body().getString("src") + " NOT found " : "") + (dstNode == null ? "dst " + message.body().getString("dst") + " NOT found" : ""));

                        // if already related, merge properties:
                        for (Relationship relationship : NeoUtil.outgoing(srcNode, relationshipType))
                           if (dstNode.equals(other(srcNode, relationship))) {
                              final JsonArray properties = message.body().getJsonArray("properties");
                              if (properties != null) {
                                 for (Object tmp : properties) {
                                    final JsonObject property = (JsonObject) tmp;
                                    relationship.setProperty(property.getString("name"), property.getValue("value"));
                                 }
                              }
                              break;
                           }

                        final Relationship relationship = srcNode.createRelationshipTo(dstNode, relationshipType);
                        final JsonArray properties = message.body().getJsonArray("properties");
                        if (properties != null) {
                           for (Object tmp : properties) {
                              final JsonObject property = (JsonObject) tmp;
                              relationship.setProperty(property.getString("name"), property.getValue("value"));
                           }
                        }

                        result = VertxUtil.newSuccess(relationship.getId());
                        break;
                     }

                     case "unrelateNodes": {

                        final Node srcNode = model.getNode(UUID.fromString(message.body().getString("src")));
                        final Node dstNode = model.getNode(UUID.fromString(message.body().getString("dst")));
                        final RelationshipType relationshipType = RelationshipType.withName(message.body().getString("relationshipType"));

                        if (srcNode == null || dstNode == null)
                           throw new IllegalStateException((srcNode == null ? "src " + message.body().getString("src") + " NOT found" : "") + (dstNode == null ? " dst " + message.body().getString("dst") + " NOT found" : ""));

                        Relationship relationshipToDelete = null;
                        for (Relationship relationship : NeoUtil.outgoing(srcNode, relationshipType)) {
                           if (dstNode.equals(other(srcNode, relationship))) {
                              relationshipToDelete = relationship;
                              break;
                           }
                        }

                        if (relationshipToDelete == null) {
                           throw new IllegalStateException(message.body().getString("src") + " -> " + relationshipType + " -> " + message.body().getString("dst") + " does not exist");
                        } else {
                           final Long relationshipId = relationshipToDelete.getId();
                           relationshipToDelete.delete();
                           result = VertxUtil.newSuccess(relationshipId);
                        }
                        break;
                     }

                     case "listNodesByLabel":

                        final JsonArray nodes = new JsonArray();
                        model.findNodes(Label.label(message.body().getString("label"))).forEachRemaining(node -> {

                           final JsonObject nodeResult = new JsonObject().
                                 put("uuid", uuidOf(node).toString());

                           // select which node-properties to return, from parameters:
                           final JsonArray returnProperties = new JsonArray();
                           for (Object tmp : message.body().getJsonArray("properties")) {
                              String propertyName = (String) tmp;
                              if (node.hasProperty(propertyName))
                                 returnProperties.add(new JsonObject().put(propertyName, node.getProperty(propertyName)));
                           }
                           nodeResult.put("properties", returnProperties);

                           nodes.add(nodeResult);
                        });

                        result = VertxUtil.newSuccess(nodes);
                        break;

                     case "executeCypher":

                        final Map<String, Object> queryParams = new HashMap<>();
                        final JsonArray params = message.body().getJsonArray("params");
                        if (params != null) {
                           for (Object p : params) {
                              final JsonObject param = (JsonObject) p;
                              queryParams.put(param.getString("name"), param.getValue("value"));
                           }
                        }

                        final JsonArray queryResult = new JsonArray();
                        // ensure result is always closed after
                        try (Result query = model.query(message.body().getString("query"), queryParams)) {
                           while (query.hasNext()) {
                              Map<String, Object> row = query.next();
                              final JsonObject resultRow = new JsonObject();
                              for (Map.Entry<String, Object> column : row.entrySet())
                                 resultRow.put(column.getKey(), column.getValue());
                              queryResult.add(resultRow);
                           }
                        }
                        result = VertxUtil.newSuccess(queryResult);
                        break;

                     case "visitor":

                        final NeoVisitor visitor = (NeoVisitor) Class.forName(message.body().getString("className")).newInstance();
                        result = VertxUtil.newSuccess(visitor.visit(model, message.body().getJsonObject("params")));
                        break;

                     default:
                        log.warn("unhandled action " + action);
                        throw new IllegalArgumentException("unsupported action " + action);
                  }

                  tx.success();

                  return result;

               } catch (Throwable throwable) {
                  tx.failure();
                  throw throwable;
               }
            }
         }

         @Override
         public void onSuccess(JsonObject result) {
            log.info("neoTransaction " + action + " success " + FormatUtil.formatTime(System.currentTimeMillis() - timestamp));
            VertxUtil.reply(log, deploymentID(), result, message);
         }

         @Override
         public void onFail(Throwable throwable) {
            if (throwable instanceof IllegalStateException)
               log.info("neoTransaction " + action + " failed " + FormatUtil.formatTime(System.currentTimeMillis() - timestamp) + " : " + throwable.getMessage());
            else
               log.info("neoTransaction " + action + " failed : " + FormatUtil.formatTime(System.currentTimeMillis() - timestamp) + " : " + throwable.getMessage(), throwable);
            VertxUtil.reply(log, deploymentID(), VertxUtil.newFail(throwable), message);
         }
      });
   }

   private static JsonObject deleteNode(Node nodeToDelete, Message<JsonObject> message) {

      final Set<Relationship> incomingRelations = new LinkedHashSet<>();
      NeoUtil.incoming(nodeToDelete).forEach(incomingRelations::add);

      if (!incomingRelations.isEmpty()) {
         // node has dependent-relations, check if 'force' flag is true
         final Boolean force = message.body().getBoolean("force", false);

         if (!force) {
            final JsonObject cause = new JsonObject();

            final JsonArray dependentNodes = new JsonArray();
            for (Relationship incomingRelation : incomingRelations) {
               final Node dependentNode = other(nodeToDelete, incomingRelation);

               final JsonObject dependentNodeInfo = new JsonObject();
               dependentNodeInfo.put("uuid", uuidOf(dependentNode).toString());

               final JsonArray dependentNodeLabels = new JsonArray();
               for (Label label : dependentNode.getLabels())
                  dependentNodeLabels.add(label.name());
               dependentNodeInfo.put("labels", dependentNodeLabels);

               final JsonArray dependentNodeProperties = new JsonArray();
               for (String propertyKey : dependentNode.getPropertyKeys()) {
                  final JsonObject property = new JsonObject();
                  property.put("name", propertyKey);
                  property.put("value", dependentNode.getProperty(propertyKey));
                  dependentNodeProperties.add(property);
               }
               dependentNodeInfo.put("properties", dependentNodeProperties);

               dependentNodes.add(dependentNodeInfo);
            }
            cause.put("dependentNodes", dependentNodes);
            return VertxUtil.newFail(cause);

         } else {

            // force node-delete, remove incoming relations
            for (Relationship incomingRelation : incomingRelations)
               incomingRelation.delete();
         }
      }

      // get outgoing-relations
      final Set<Relationship> outgoingRelations = new LinkedHashSet<>();
      NeoUtil.outgoing(nodeToDelete).forEach(outgoingRelations::add);

      final JsonObject content = new JsonObject();
      if (!outgoingRelations.isEmpty()) {
         // node has outgoing-relations, check if 'cascade' flag is true

         final Boolean cascade = message.body().getBoolean("cascade", false);
         if (cascade) {

            final Set<Node> cascadeNodes = new LinkedHashSet<>();
            for (Relationship outgoingRelation : outgoingRelations) {
               cascadeNodes.add(other(nodeToDelete, outgoingRelation));
               outgoingRelation.delete();
            }

            final JsonArray cascadedNodes = new JsonArray();
            for (Node cascadeNode : cascadeNodes)
               cascadedNodes.add(deleteNode(cascadeNode, message));
            content.put("cascadedNodes", cascadedNodes);

         } else {
            // do not cascade, just delete outgoing-relations
            for (Relationship outgoingRelation : outgoingRelations)
               outgoingRelation.delete();
         }
      }

      final UUID uuid = uuidOf(nodeToDelete);
      nodeToDelete.delete();
      content.put("uuid", uuid.toString());
      return VertxUtil.newSuccess(content);
   }
}