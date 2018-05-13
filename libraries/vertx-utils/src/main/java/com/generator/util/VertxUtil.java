package com.generator.util;

import io.vertx.core.*;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.file.FileSystem;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetSocket;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameHelper;
import org.slf4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * goe on 1/14/16.
 */
public class VertxUtil {

   public static final String BODY = "body";
   public static final String RESULT = "result";
   public static final String SUCCESS = "success";
   public static final String FAIL = "fail";
   public static final String FAILURE_CODE = "failureCode";
   public static final String FAILURE_TYPE = "failureType";
   public static final String MESSAGE = "message";
   public static final String CONTENT = "content";
   public static final String CAUSE = "cause";
   public static final String UNKNOWN = "unknown";
   public static final String DEPLOYMENT_ID = "deploymentID";
   public static final String STATUS = "status";

   public static void putInLocalMap(Vertx vertx, Logger log, String mapName, String key, Object value) {
      final SharedData sharedData = vertx.sharedData();
      final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);
      log.info("putInLocalMap " + mapName + " " + key + " = " + value);
      localMap.put(key, value);
   }

   @SuppressWarnings("unchecked")
   public static <V> V removeFromLocalMap(Vertx vertx, Logger log, String mapName, String key) {
      final SharedData sharedData = vertx.sharedData();
      final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);
      log.info("removeFromLocalMap " + mapName + " " + key + " = " + localMap.get(key));
      return (V) localMap.remove(key);
   }

   @SuppressWarnings("unchecked")
   public static <V> V getFromLocalMap(Vertx vertx, Logger log, String mapName, String key) {
      final SharedData sharedData = vertx.sharedData();
      final LocalMap<Object, Object> localMap = sharedData.getLocalMap(mapName);
      log.info("getFromLocalMap " + mapName + " " + key + " = " + localMap.get(key));
      return (V) localMap.get(key);
   }

   public static <K, V> LocalMap<K, V> getLocalMap(Vertx vertx, Logger log, String mapName) {
      final SharedData sharedData = vertx.sharedData();
      log.info("getLocalMap " + mapName);
      return sharedData.getLocalMap(mapName);
   }

   public static void readDir(Vertx vertx, Logger log, File directory, SuccessHandler<List<File>> successHandler) {

      final FileSystem fileSystem = vertx.fileSystem();
      log.info("readDir " + directory.getAbsolutePath());

      fileSystem.readDir(directory.getAbsolutePath(), result -> {

         if (result.failed()) {
            log.error("readDir " + directory.getAbsolutePath() + " failed : " + result.cause().getMessage(), result.cause());
            successHandler.onFail(result.cause());
            return;
         }

         final List<File> list = new ArrayList<>(result.result().size());
         for (String s : result.result())
            list.add(new File(s));

         successHandler.onSuccess(list);
      });
   }

   public static void putInClusterMap(Vertx vertx, Logger log, String mapName, String key, Object value, SuccessHandler<Void> successHandler) {

      vertx.sharedData().getClusterWideMap(mapName, result -> {

         if (result.failed()) {
            log.error("putInClusterMap " + mapName + " failed : " + result.cause().getMessage(), result.cause());
            successHandler.onFail(result.cause());
            return;
         }

         result.result().put(key, value, resultPut -> {
            if (resultPut.failed()) {
               log.error("putInClusterMap " + mapName + " failed to put " + key + " = " + value + " : " + result.cause().getMessage(), result.cause());
               successHandler.onFail(resultPut.cause());
               return;
            }

            log.info("putInClusterMap " + mapName + " " + key + " = " + value + " success");
            successHandler.onSuccess(null);
         });
      });
   }

   @SuppressWarnings("unchecked")
   public static <V> void removeFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {

      vertx.sharedData().getClusterWideMap(mapName, result -> {

         if (result.failed()) {
            log.error("removeFromClusterMap " + mapName + " failed : " + result.cause().getMessage(), result.cause());
            successHandler.onFail(result.cause());
            return;
         }

         result.result().remove(key, resultGet -> {

            if (resultGet.failed()) {
               log.error("removeFromClusterMap " + mapName + " failed to remove key " + key + " : " + result.cause().getMessage(), result.cause());
               successHandler.onFail(resultGet.cause());
               return;
            }

            log.info("removeFromClusterMap " + mapName + "." + key + " removed " + resultGet.result());
            successHandler.onSuccess((V) resultGet);
         });
      });
   }

   @SuppressWarnings("unchecked")
   public static <V> void getFromClusterMap(Vertx vertx, Logger log, String mapName, String key, SuccessHandler<V> successHandler) {

      vertx.sharedData().getClusterWideMap(mapName, result -> {

         if (result.failed()) {
            log.error("getFromClusterMap " + mapName + " failed : " + result.cause().getMessage(), result.cause());
            successHandler.onFail(result.cause());
            return;
         }

         result.result().get(key, resultGet -> {

            if (resultGet.failed()) {
               log.error("getFromClusterMap " + mapName + "." + key + " failed : " + result.cause().getMessage(), result.cause());
               successHandler.onFail(resultGet.cause());
               return;
            }

            if (resultGet.result() == null) {
               log.error("getFromClusterMap " + mapName + "." + key + " is null", result.cause());
               successHandler.onFail(new Throwable(mapName + "." + key + " is null"));
               return;
            }

            log.info("getFromClusterMap " + mapName + "." + key + " = " + resultGet.result());
            successHandler.onSuccess((V) resultGet);
         });
      });
   }

   public static void sendFrame(org.slf4j.Logger log, String address, String replyAddress, JsonObject parameters, NetSocket socket) {
      log.info("sending frame " + address + " " + replyAddress + " " + parameters);
      FrameHelper.sendFrame("send", address, replyAddress, parameters, socket);
   }

   public static void reply(Logger log, String deploymentID, JsonObject result, Message<JsonObject> message) {
      log.info("reply " + deploymentID + " " + message.replyAddress() + " " + result);
      message.reply(result);
   }

   public interface SuccessHandler<T> {

      void onSuccess(T result);

      void onFail(Throwable t);

   }

   public interface Executor<R, T> extends SuccessHandler<T> {

      R execute() throws Throwable;
   }

   @SuppressWarnings("unchecked")
   public static <R> void executeBlocking(Vertx vertx, Logger log, Executor<R, R> executor) {

      vertx.executeBlocking(future -> {

         try {

            final R result = executor.execute();

            if (result == null) future.fail("no result");
            else future.complete(result);

         } catch (Throwable throwable) {
            log.error("executeBlocking exception : " + throwable.getMessage(), throwable);
            future.fail(throwable);
         }

      }, res -> {

         if (res.failed())
            executor.onFail(res.cause());
         else
            executor.onSuccess((R) res.result());
      });
   }

   public static <T> void consume(Vertx vertx, String consumer, String address, Logger log, Handler<Message<T>> messageHandler) {
      log.info(consumer + " consumes messages on address " + address);
      vertx.eventBus().consumer(address, messageHandler);
   }

   public static <T, R> void sendMessage(Vertx vertx, String address, T content, Logger log, SuccessHandler<Message<R>> handler) {
      sendMessage(vertx, address, content, null, log, handler);
   }

   public static <T, R> void sendJsonMessage(Vertx vertx, String address, JsonObject content, Logger log, SuccessHandler<Message<JsonObject>> handler) {
      sendMessage(vertx, address, content, null, log, handler);
   }

   public static <T, R> void sendMessage(Vertx vertx, String address, T content, Logger log) {
      sendMessage(vertx, address, content, null, log, new SuccessHandler<JsonObject>() {
         @Override
         public void onSuccess(JsonObject result) {
            log.info("sendMessage success " + address + " " + result);
         }

         @Override
         public void onFail(Throwable t) {
            log.info("sendMessage failed " + address + " " + t.getCause().getMessage(), t.getCause());
         }
      });
   }

   @SuppressWarnings("unchecked")
   public static <T, R> void sendMessage(Vertx vertx, String address, T content, DeliveryOptions options, Logger log, SuccessHandler<R> handler) {

      log.info("sendingMessage " + address + " " + content.toString());

      if (options == null) options = new DeliveryOptions();

      vertx.eventBus().send(address, content, options, result -> {

         if (result.failed()) {
            log.error("sendMessage failed " + address + " " + result.cause().getMessage());
            handler.onFail(result.cause());
            return;
         }
         log.info("sendMessage success " + address + " " + result.result().body());
         handler.onSuccess((R) result.result());
      });
   }

   public static void publish(Vertx vertx, String address, Object content, Logger log) {
      publish(vertx, address, content, null, log);
   }

   public static void publish(Vertx vertx, String address, Object content, DeliveryOptions options, Logger log) {
      if (options == null) options = new DeliveryOptions();
      log.info("publish to " + address + " : " + content);
      vertx.eventBus().publish(address, content, options);
   }

   public static void undeploy(Vertx vertx, Logger log, String deploymentId, SuccessHandler<Void> handler) {

      log.info("undeploy " + deploymentId);

      vertx.undeploy(deploymentId, result -> {

         if (result.failed()) {
            handler.onFail(result.cause());
            log.error("undeploy failed " + deploymentId + " " + result.cause().getMessage(), result.cause());
            return;
         }

         log.info("undeploy success " + deploymentId);
         handler.onSuccess(null);
      });
   }

   public static void deploy(ClusterManager clusterManager, Class[] verticleClass, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {
      VertxOptions options = new VertxOptions().setClusterManager(clusterManager);

      Vertx.clusteredVertx(options, result -> {
         if (result.failed()) {
            log.error("cluster join failed " + result.cause().getMessage(), result.cause());
            handler.onFail(result.cause());
            return;
         }

         log.info("cluster join success");
         Vertx vertx = result.result();

         deploy(vertx, verticleClass, deploymentOptions, log, handler);
      });
   }

   public static void deploy(ClusterManager clusterManager, Class verticleClass, Logger log, SuccessHandler<String> handler) {
      deploy(clusterManager, verticleClass, null, log, handler);
   }

   public static void deploy(ClusterManager clusterManager, Class verticleClass, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {
      VertxOptions options = new VertxOptions().setClusterManager(clusterManager);

      Vertx.clusteredVertx(options, result -> {
         if (result.failed()) {
            log.error("cluster join failed " + result.cause().getMessage(), result.cause());
            handler.onFail(result.cause());
            return;
         }

         log.info("cluster join success");
         Vertx vertx = result.result();

         deploy(vertx, verticleClass, deploymentOptions, log, handler);
      });
   }

   public static void deploy(Vertx vertx, Verticle verticle, Logger log, SuccessHandler<String> handler) {
      deploy(vertx, verticle, null, log, handler);
   }

   public static void deploy(Vertx vertx, Verticle verticle, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {

      if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();

      vertx.deployVerticle(verticle, deploymentOptions, result -> {

         if (result.failed()) {
            log.error("deploy failed " + verticle + " " + result.cause().getMessage(), result.cause());
            handler.onFail(result.cause());
            return;
         }

         log.info("deploy success " + verticle + " " + result.result());
         handler.onSuccess(result.result());
      });
   }

   public static void deploySilent(Vertx vertx, Class[] verticleClass, DeploymentOptions deploymentOptions, Logger log) {
      deploy(vertx, verticleClass, deploymentOptions, log, new SuccessHandler<String>() {
         @Override
         public void onSuccess(String result) {
            log.info("deploying " + verticleClass.length + " verticles " + result);
         }

         @Override
         public void onFail(Throwable t) {
            log.error("failed deploying " + verticleClass.length + " : " + t.getMessage(), t);
         }
      });
   }

   public static void deploy(Vertx vertx, Class[] verticleClass, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {

      VertxUtil.executeBlocking(vertx, log, new Executor<JsonObject, JsonObject>() {
         @Override
         public JsonObject execute() throws Throwable {

            for (Class verticleClass : verticleClass)
               VertxUtil.deploy(vertx, verticleClass, deploymentOptions, log, handler);

            return new JsonObject();
         }

         @Override
         public void onSuccess(JsonObject result) {
            log.info("deploying " + verticleClass.length + " verticles " + result.encode());
         }

         @Override
         public void onFail(Throwable t) {
            log.error("failed deploying " + verticleClass.length + " : " + t.getMessage(), t);

         }
      });
   }

   public static void deploy(Vertx vertx, Class verticleClass, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {
      deploy(vertx, verticleClass.getCanonicalName(), deploymentOptions, log, handler);
   }

   public static void deploy(Vertx vertx, String className, DeploymentOptions deploymentOptions, Logger log, SuccessHandler<String> handler) {

      if (deploymentOptions == null) deploymentOptions = new DeploymentOptions();

      vertx.deployVerticle(className, deploymentOptions, result -> {

         if (result.failed()) {
            log.error("deploy failed " + className + " " + result.cause().getMessage(), result.cause());
            handler.onFail(result.cause());
            return;
         }

         log.info("deploy success " + className + " " + result.result());
         handler.onSuccess(result.result());
      });
   }

   public static void deploy(Vertx vertx, String className, JsonObject config, Logger log, SuccessHandler<String> handler) {

      final DeploymentOptions deploymentOptions = new DeploymentOptions();
      if (config != null) deploymentOptions.setConfig(config);

      deploy(vertx, className, deploymentOptions, log, handler);
   }

   public static void deploy(Vertx vertx, String className, Logger log, SuccessHandler<String> handler) {
      deploy(vertx, className, new DeploymentOptions(), log, handler);
   }

   // ENVELOPE-MESSAGES

   public static JsonObject newStatus(String deploymentId, String status) {
      final JsonObject msg = new JsonObject();
      msg.put(DEPLOYMENT_ID, deploymentId);
      msg.put(STATUS, status);
      return msg;
   }

   public static JsonObject newSuccess(final Object content) {
      final JsonObject reply = new JsonObject();
      reply.put(RESULT, SUCCESS);
      reply.put(CONTENT, content);
      return reply;
   }

   public static JsonObject newFail(final Object cause) {
      final JsonObject reply = new JsonObject();
      reply.put(RESULT, FAIL);
      if (cause != null && ((cause instanceof Throwable) && ((Throwable) cause).getMessage() != null))
         reply.put(CAUSE, ((Throwable) cause).getMessage());
      return reply;
   }

   public static boolean isSuccess(Message<JsonObject> message) {
      return isSuccess(message.body());
   }

   public static boolean isFail(Message<JsonObject> message) {
      return isFail(message.body());
   }

   public static String getFailCause(Message<JsonObject> message) {
      return getFailCause(message.body());
   }

   public static boolean isSuccess(JsonObject jsonObject) {

      final JsonObject body = jsonObject.getJsonObject(BODY);
      if (body != null) {
         final String result = body.getString(RESULT);
         return result != null && SUCCESS.equals(result);
      }

      final String result = jsonObject.getString(RESULT);
      return result != null && SUCCESS.equals(result);
   }

   public static boolean isFail(JsonObject jsonObject) {

      final JsonObject body = jsonObject.getJsonObject(BODY);
      if (body != null) {
         final String result = body.getString(RESULT);
         return result != null && FAIL.equals(result);
      }

      final String result = jsonObject.getString(RESULT);
      if (result != null)
         return FAIL.equals(result);

      return jsonObject.getString(FAILURE_CODE) != null;
   }

   public static String getFailCause(JsonObject jsonObject) {

      final JsonObject body = jsonObject.getJsonObject(BODY);
      if (body != null)
         return body.getString(CAUSE);

      final String cause = jsonObject.getString(CAUSE);
      if (cause != null) return cause;

      final String failureCode = jsonObject.getString(FAILURE_CODE);
      if (failureCode != null)
         return failureCode + " : " + jsonObject.getString(FAILURE_TYPE) + " : " + jsonObject.getString(MESSAGE);

      return UNKNOWN + " : " + jsonObject;
   }
}